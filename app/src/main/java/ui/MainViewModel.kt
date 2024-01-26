package com.example.reyortiz_primercompose.ui

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.usecases.AddSustanciaUsecase
import com.example.myapplication.domain.usecases.DeleteSustanciaUsecase
import com.example.myapplication.domain.usecases.GetSustanciaUsecase
import com.example.myapplication.domain.usecases.UpdateSustanciaUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addSustanciaUsecase: AddSustanciaUsecase,
    private val deleteSustanciaUsecase: DeleteSustanciaUsecase,
    private val updateSustanciaUsecase: UpdateSustanciaUsecase,
    private val getSustanciaUsecase: GetSustanciaUsecase,
): ViewModel(){
    private val _state: MutableStateFlow<MainState> by lazy {
        MutableStateFlow(MainState())
    }
    val state : StateFlow<MainState> = _state





}