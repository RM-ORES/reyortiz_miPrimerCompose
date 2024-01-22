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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
                CreateTextBox(label = "Nombre", content = "hola")
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    CreateButton(text = "Add", onClick = { /*TODO*/ })
                    CreateButton(text = "Delete", onClick = { /*TODO*/ })
                    CreateButton(text = "Update", onClick = { /*TODO*/ })
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTextBox(label: String, content: String) {
    Row(
        modifier = Modifier.padding(10.dp),
    ) {
        Text(text = label)
        TextField(value = content, onValueChange = {})
    }
}

@Composable
fun CreateButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(10.dp),
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