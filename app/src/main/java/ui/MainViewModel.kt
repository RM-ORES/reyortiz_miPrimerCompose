package com.example.reyortiz_primercompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.modelo.Sustancia
import com.example.myapplication.domain.usecases.AddSustanciaUsecase
import com.example.myapplication.domain.usecases.DeleteSustanciaUsecase
import com.example.myapplication.domain.usecases.GetAllSustanciasUsecase
import com.example.myapplication.domain.usecases.GetSustanciaUsecase
import com.example.myapplication.domain.usecases.UpdateSustanciaUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import utils.Constantes
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addSustanciaUsecase: AddSustanciaUsecase,
    private val deleteSustanciaUsecase: DeleteSustanciaUsecase,
    private val updateSustanciaUsecase: UpdateSustanciaUsecase,
    private val getSustanciaUsecase: GetSustanciaUsecase,
    private val getAllSustanciasUsecase: GetAllSustanciasUsecase,
) : ViewModel() {
    private val _state: MutableStateFlow<MainState> by lazy {
        MutableStateFlow(MainState())
    }
    val state: StateFlow<MainState> = _state
    private var index = 0
    private var sustancias = emptyList<Sustancia>()

    init {
        getSustancias()
        sustancias[index].let {
            _state.value = MainState(
                sustancia = it,

                )
        }
    }

    fun handleEvent(event: MainEvent) {
        when (event) {
            MainEvent.ErrorVisto -> _state.value = _state.value.copy(error = null)
            MainEvent.Next -> next()
            MainEvent.Previous -> previous()
            MainEvent.GetSustancias -> getSustancias()
            is MainEvent.AddSustancia -> addSustancia(event.sustancia)
            is MainEvent.DeleteSustancia -> deleteSustancia(event.sustancia)
            is MainEvent.GetSustancia -> getSustancia(event.id)
            is MainEvent.UpdateSustancia -> updateSustancia(event.sustancia)
        }
    }

    private fun getSustancias() {
        viewModelScope.launch {
            getAllSustanciasUsecase.invoke()
                .catch(action = { cause ->
                    _state.update {
                        it.copy(
                            error = cause.message,
                        )
                    }
                }
                ).collect { result ->
                    sustancias = result
                }
        }
    }

    private fun getSustancia(id: Int) {
        viewModelScope.launch {
            getSustanciaUsecase.invoke(id)
                .collect {
                    _state.update {
                        it.copy(

                        )
                    }
                }
        }
    }

    private fun addSustancia(sustancia: Sustancia) {
        viewModelScope.launch {
            addSustanciaUsecase.invoke(sustancia)
                .collect { result ->
                    _state.update {
                        it.copy(
                            sustancia = sustancia,
                            error = Constantes.ANADIDO
                        )
                    }
                }
        }
    }

    private fun deleteSustancia(sustancia: Sustancia) {
        viewModelScope.launch {
            deleteSustanciaUsecase.invoke(sustancia)
                .collect { result ->
                    _state.update {
                        it.copy(
                            sustancia = sustancia,
                            error = Constantes.BORRADO
                        )
                    }
                }
        }
    }

    private fun updateSustancia(sustancia: Sustancia) {
        viewModelScope.launch {
            updateSustanciaUsecase.invoke(sustancia)
                .collect { result ->
                    _state.update {
                        it.copy(
                            sustancia = sustancia,
                            error = Constantes.MODIFICADO
                        )
                    }
                }
        }
    }

    private fun next() {
    }

    private fun previous() {

    }
}
