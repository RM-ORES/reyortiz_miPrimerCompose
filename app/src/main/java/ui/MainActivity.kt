package com.example.reyortiz_primercompose.ui

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExposureNeg1
import androidx.compose.material.icons.filled.ExposurePlus1
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.StarRate
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.domain.modelo.Sustancia
import com.example.reyortiz_miprimercompose.R
import com.example.reyortiz_primercompose.ui.theme.Reyortiz_primerComposeTheme
import kotlinx.coroutines.launch
import utils.Constantes
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Reyortiz_primerComposeTheme {
                Pantalla()
            }
        }
    }
}


@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla(
    viewModel: MainViewModel = hiltViewModel(),
) {
    Reyortiz_primerComposeTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            color = MaterialTheme.colorScheme.background
        ) {
            var currentVMIndex = viewModel.state.collectAsState()
            var currentIndex by remember { mutableStateOf(0) }
            var newSustancia by remember { mutableStateOf(Sustancia()) }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = dimensionResource(R.dimen.twenty),
                        vertical = dimensionResource(R.dimen.six)
                    ),
                //horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.fourteen)))
                //val snackScope = rememberCoroutineScope()
                //TEXTFIELDS
                val susDesc = remember { mutableStateOf("Description") }
                Text("Detalles de la sustancia")
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = dimensionResource(R.dimen.twenty),
                            vertical = dimensionResource(R.dimen.six)
                        ),
                    value = susDesc.value,
                    onValueChange = { viewModel.handleEvent(MainEvent.ChangeDescription(it)) },
                    label = { Text(text = "Descripción") })
                //LEGAL CHECK
                var checkedState = remember { mutableStateOf(true) }
                Row(
                    Modifier
                        .padding(
                            horizontal = dimensionResource(R.dimen.twenty),
                            vertical = dimensionResource(R.dimen.six)
                        )
                        .fillMaxWidth()
                        .height(dimensionResource(R.dimen.forty)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        //modifier = Modifier.padding(8.dp),
                        checked = checkedState.value,
                        onCheckedChange = { viewModel.handleEvent(MainEvent.ChangeLegal(it)) }
                    )
                    Text(
                        text = "Es legal",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.ten))
                    )
                }
                //FECHA
                val openDialog = remember { mutableStateOf(false) }
                val myDate = remember { mutableStateOf(Date()) }
                val dateFormat = SimpleDateFormat("yyyy-MM-dd")
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.six)))
                Text(text = "Fecha del registro:")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.twenty)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        textAlign = TextAlign.Left,
                        modifier = Modifier.width(dimensionResource(R.dimen.hundredfiftyfive)),
                        text = dateFormat.format(myDate.value),//selectedDate.toString(),
                    )
                    Button(
                        modifier = Modifier.width(dimensionResource(R.dimen.hundredfortyfive)),
                        onClick = { openDialog.value = true }
                    ) {
                        Text(text = "Resetear Fecha")
                    }
                }
                //MyDatePick( openDialog )
                val snackState = remember { SnackbarHostState() }
                val snackScope = rememberCoroutineScope()
                SnackbarHost(hostState = snackState, Modifier)
                //val openDialog = remember { mutableStateOf(true) }
                if (openDialog.value) {
                    val datePickerState = rememberDatePickerState()
                    val confirmEnabled = remember {
                        derivedStateOf { datePickerState.selectedDateMillis != null }
                    }
                    DatePickerDialog(
                        onDismissRequest = {
                            // Dismiss the dialog when the user clicks outside the dialog or on the back
                            // button. If you want to disable that functionality, simply use an empty
                            // onDismissRequest.
                            openDialog.value = false
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    myDate.value = Date(datePickerState.selectedDateMillis!!)
                                    openDialog.value = false
                                    //COMENTADO PARA EVITAR QUE PETE EL PREVIEW
                                    //snackScope.launch {
                                    //  snackState.showSnackbar(
                                    //      "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                                    //  )
                                    //}
                                },
                                enabled = confirmEnabled.value
                            ) {
                                Text("OK")
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = {
                                    openDialog.value = false
                                }
                            ) {
                                Text("Cancel")
                            }
                        }
                    ) {
                        DatePicker(state = datePickerState)
                    }
                }
                /*Column()
                {
                    val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
                    DatePicker(state = state, modifier = Modifier.padding(8.dp))

                    Text(
                        "Entered date timestamp: ${state.selectedDateMillis ?: "no input"}",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(4.dp)
                    )
                }*/

                //SLIDER
                var susPower by remember { mutableStateOf(0f) }
                //Nota: El susPower está cargado en grados, acordarse de pasar a entero cuando se guarde en el objeto
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.six)))
                Row(
                    Modifier
                        .fillMaxWidth()
                    //.padding(horizontal = 20.dp, vertical = 6.dp)
                ) {
                    Column {
                        Text(
                            modifier = Modifier.height(dimensionResource(R.dimen.twentyfour)),
                            text = "Potencia de la sustancia: ${susPower.roundToInt()}"
                        )
                        Row(
                            Modifier.padding(
                                horizontal = dimensionResource(R.dimen.twenty),
                                vertical = dimensionResource(R.dimen.zero)
                            )
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(0.5f),
                                textAlign = TextAlign.Left,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Italic,
                                text = " 0"
                            )
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Right,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Light,
                                fontStyle = FontStyle.Italic,
                                text = "10"
                            )
                        }
                        Slider(
                            value = susPower,
                            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.twenty)),
                            valueRange = 0f..10f,
                            steps = 10,
                            onValueChange = { viewModel.handleEvent(MainEvent.ChangePotencia(it.toInt())) },
                        )
                    }
                }
                //EFECTOS
                val radioOptions = listOf(Constantes.PSICODELICO, Constantes.ESTIMULANTE, Constantes.DISOCIATIVO)
                val (selectedOption, onOptionSelected) = remember { mutableStateOf("") }
                var susEffect by remember { mutableStateOf("") }
                // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.six)))
                Column(Modifier.selectableGroup()) {
                    Text(
                        //modifier = Modifier.height(30.dp),
                        text = "Efectos de la sustancia: $susEffect"
                    )
                    radioOptions.forEach { text ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(R.dimen.fortytwo))
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = {
                                        onOptionSelected(text)
                                        susEffect = text
                                        viewModel.handleEvent(MainEvent.ChangeEfecto(text))},
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = dimensionResource(R.dimen.sixteen)),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = null // null recommended for accessibility with screenreaders
                            )
                            Text(
                                text = text,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.padding(start = dimensionResource(R.dimen.sixteen))
                            )
                        }
                    }
                }
                //PRECIO
                var susPrice by remember { mutableStateOf(0) }
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.six)))
                Text(
                    text = "Precio de la sustancia:",
                    //modifier = Modifier.height(30.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.twenty)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        textAlign = TextAlign.Left,
                        modifier = Modifier.width(dimensionResource(R.dimen.hundredfiftyfive)),
                        text = stringResource(R.string.eur_per_ud, susPrice)
                    )
                    if (susPrice == 0) {
                        IconButton(onClick = { }, enabled = false) {
                            Icon(Icons.Filled.ExposureNeg1, contentDescription = "Decrease Value")
                        }
                    } else {
                        IconButton(onClick = {
                            susPrice -= 1
                            viewModel.handleEvent(MainEvent.ChangePrecio(susPrice))
                        }) {
                            Icon(Icons.Filled.ExposureNeg1, contentDescription = "Decrease Value")
                        }
                    }
                    IconButton(onClick = {
                        susPrice = (susPrice + 1)
                        viewModel.handleEvent(MainEvent.ChangePrecio(susPrice))
                    }) {
                        Icon(Icons.Filled.ExposurePlus1, contentDescription = "Increase Value")
                    }
                }
                //VALORACION
                var susMark by remember { mutableStateOf(0) }
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.six)))
                Text(
                    text = "Valoración de la calidad: $susMark estrellas",
                    //modifier = Modifier.height(30.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.twenty)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (susMark > 0) {
                        for (i in 0..(susMark - 1)) {
                            IconButton(onClick = {
                                susMark = (i + 1)
                                viewModel.handleEvent(MainEvent.ChangeValoracion(susMark))
                            }) {
                                Icon(Icons.Filled.StarRate, contentDescription = "$(i) Star")
                            }
                        }
                    }
                    for (i in (susMark)..4) {
                        IconButton(onClick = {
                            susMark = (i + 1)
                            viewModel.handleEvent(MainEvent.ChangeValoracion(susMark))
                        }) {
                            Icon(Icons.Outlined.StarRate, contentDescription = "$(i) Star")
                        }
                    }

                }
                // PARTE DE ABAJO: NAVEGACION
                // BottomBarV1()
                // AHORA ESTO SE HACE CON EL SCALFOLDING
            }
        }
    }
}

@Composable
fun BottomBarV1() {
    //PARTE DE ABAJO: NAVEGACION
    Column(
        modifier = Modifier.padding(dimensionResource(R.dimen.five)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        //CRUD BUTTONS
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.five)),
            verticalAlignment = Alignment.Bottom,
        ) {
            CreateButton(text = "Add", onClick = { /*TODO*/ })
            CreateButton(text = "Delete", onClick = { /*TODO*/ })
            CreateButton(text = "Update", onClick = { /*TODO*/ })
        }
        //NEXT PREV BUTTONS
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.five)),
            verticalAlignment = Alignment.Bottom,
        ) {
            CreateButton(text = "<", onClick = { /*TODO*/ })
            CreateButton(text = ">", onClick = { /*TODO*/ })
        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePick(openDialog: MutableState<Boolean>) {
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()
    SnackbarHost(hostState = snackState, Modifier)
    //val openDialog = remember { mutableStateOf(true) }
// TODO demo how to read the selected date from the state.
    if (openDialog.value) {
        val datePickerState = rememberDatePickerState()
        val confirmEnabled = remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }
        DatePickerDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        snackScope.launch {
                            snackState.showSnackbar(
                                "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                            )
                        }
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

@Composable
fun FullPantalla(
    viewModel: MainViewModel? = null,
) {
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    //NEXT
                    IconButton(onClick = {
                        viewModel?.handleEvent(MainEvent.Previous)
                    }) {
                        Icon(Icons.Filled.ChevronLeft, contentDescription = Constantes.LOC_DESCRIPTION)
                    }
                    //MODIFY
                    IconButton(onClick = {
                        viewModel?.state?.value?.let {
                            val mod = it.sustancia
                            if (mod != null) {
                                mod.descripcion = it.descripcion
                                mod.fecha = it.fecha
                                mod.precio =it.precio
                                mod.legal = it.legal
                                mod.efecto = it.efecto
                                mod.potencia = it.potencia
                                mod.valoracion = it.valoracion
                                viewModel.handleEvent(MainEvent.UpdateSustancia(mod))
                            } else{
                                Toast.makeText(context, Constantes.ERROR, Toast.LENGTH_LONG).show()
                            }
                        }?: Toast.makeText(context, Constantes.ERROR, Toast.LENGTH_LONG).show()
                    }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = Constantes.LOC_DESCRIPTION,
                        )
                    }
                    //DELETE
                    IconButton(onClick = {
                        viewModel?.state?.value?.sustancia?.let{
                            viewModel.handleEvent(MainEvent.DeleteSustancia(it))
                        } ?: Toast.makeText(context, Constantes.ERROR, Toast.LENGTH_LONG).show()
                    }) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = Constantes.LOC_DESCRIPTION,
                        )
                    }
                    //NEXT
                    IconButton(onClick = {
                        viewModel?.handleEvent(MainEvent.Next)
                    }) {
                        Icon(
                            Icons.Filled.ChevronRight,
                            contentDescription = Constantes.LOC_DESCRIPTION,
                        )
                    }
                },
                //ADD
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            viewModel?.state?.value?.let {
                                val new = Sustancia(
                                    0,
                                    it.descripcion,
                                    it.fecha,
                                    it.precio,
                                    it.legal,
                                    it.efecto,
                                    it.potencia,
                                    it.valoracion
                                )
                                viewModel.handleEvent(MainEvent.AddSustancia(new))
                            } ?: Toast.makeText(context, Constantes.ERROR, Toast.LENGTH_LONG).show()
                        },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, Constantes.LOC_DESCRIPTION)
                    }
                }
            )
        },
        content = { innerPadding ->
            if (viewModel != null) {
                Pantalla(viewModel)
            }
        }
    )
}


@Composable
fun CreateButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(dimensionResource(R.dimen.five)),
    ) {
        Text(text = text)
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun Preview() {
    Reyortiz_primerComposeTheme {
        FullPantalla()
    }
}