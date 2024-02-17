package com.example.a3numerostarea2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a3numerostarea2.ui.theme._3NumerosTarea2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _3NumerosTarea2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThreeNumbers()
                }
            }
        }
    }
}

fun getMax(numberOne: Int, numberTwo: Int, numberThree: Int): String {
    val numbers = listOf(numberOne, numberTwo, numberThree)
    return numbers.max().toString()
}

fun getMin(numberOne: Int, numberTwo: Int, numberThree: Int): String {
    val numbers = listOf(numberOne, numberTwo, numberThree)
    return numbers.min().toString()
}

@Composable
fun ThreeNumbers() {
    var numberOne: Int by remember { mutableStateOf(0) }
    var numberTwo: Int by remember { mutableStateOf(0) }
    var numberThree: Int by remember { mutableStateOf(0) }

    var max: String by remember { mutableStateOf("0") }
    var min: String by remember { mutableStateOf("0") }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "3 números",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = numberOne.toString(),
            onValueChange = {numberOne = it.toInt()},
            label = {
                Text(text = "Número 1")
            },
            placeholder = {
                Text(text = "Escribe el primer número")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        OutlinedTextField(
            value = numberTwo.toString(),
            onValueChange = {numberTwo = it.toInt()},
            label = {
                Text(text = "Número 2")
            },
            placeholder = {
                Text(text = "Escribe el segundo número")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        OutlinedTextField(
            value = numberThree.toString(),
            onValueChange = {numberThree = it.toInt()},
            label = {
                Text(text = "Número 3")
            },
            placeholder = {
                Text(text = "Escribe el tercer número")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Star, contentDescription = "Icon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                max = getMax(numberOne, numberTwo, numberThree)
                min = getMin(numberOne, numberTwo, numberThree)
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFFE5900)),
            modifier = Modifier.padding(horizontal = 30.dp).fillMaxWidth()
        ) {
            Text(
                text = "Obtener números",
                color = Color(0xFFFFFFFF),
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "El mayor es: ${max}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "El menor es: ${min}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _3NumerosTarea2Theme {
        ThreeNumbers()
    }
}