package com.example.reyortiz_primercompose.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reyortiz_primercompose.ui.theme.Reyortiz_primerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Reyortiz_primerComposeTheme {
                // A surface container using the 'background' color from the theme
                Pantalla()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla(
    //viewModel: MainViewModel = hiltViewModel(),
) {
    Reyortiz_primerComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextField(value = "-", onValueChange = {}, label = { Text(text = "Nombre")})
                val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
                DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))
                val (checkedState, onStateChange) = remember { mutableStateOf(true) }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null
                    )
                    Text(
                        text = "Es legal",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                RangeSlider(value = 0f..10f,
                    modifier = Modifier.padding(horizontal = 20.dp),
                    onValueChange = {})

                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    CreateButton(text = "Add", onClick = { /*TODO*/ })
                    CreateButton(text = "Delete", onClick = { /*TODO*/ })
                    CreateButton(text = "Update", onClick = { /*TODO*/ })
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.Bottom,
                ){
                    CreateButton(text = "<", onClick = { /*TODO*/ })
                    CreateButton(text = ">", onClick = { /*TODO*/ })
                }

            }
        }
    }
}

@Composable
fun CreateButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(5.dp),
    ) {
        Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi there $name!",
        modifier = modifier
    )
}


@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun GreetingPreview() {
    Reyortiz_primerComposeTheme {
        Pantalla()
    }
}