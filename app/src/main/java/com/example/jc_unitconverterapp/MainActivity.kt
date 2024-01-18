package com.example.jc_unitconverterapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jc_unitconverterapp.ui.theme.JC_unitConverterAppTheme
import java.time.format.TextStyle
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_unitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    unitConverter()
                }
            }
        }
    }
}

@Composable
fun unitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var iUnit by remember { mutableStateOf("meter") }
    var oUnit by remember { mutableStateOf("meter") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    val customTextStyle = androidx.compose.ui.text.TextStyle (
        fontFamily = FontFamily.Monospace, fontSize = 32.sp, color = Color.Red
    )

    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100 / oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "UNIT CONVERTER", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange ={ inputValue = it; convertUnits() }, label = { Text(
            text = "Enter value")} )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
    // intput box
            Box {
                Button(onClick = { iExpanded = true }) {
                    Text(text = iUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "centimeter") }, onClick = { iExpanded = false; iUnit = "centimeter"; conversionFactor.value = 0.01; convertUnits() })
                    DropdownMenuItem(text = { Text(text = "meter") }, onClick = { iExpanded = false; iUnit = "meter"; conversionFactor.value = 1.0; convertUnits() })
                    DropdownMenuItem(text = { Text(text = "feet") }, onClick = { iExpanded = false; iUnit = "feet"; conversionFactor.value = 0.3048; convertUnits() })
                    DropdownMenuItem(text = { Text(text = "millimeter") }, onClick = {  iExpanded = false; iUnit = "millimeter"; conversionFactor.value = 0.001; convertUnits() })}
            }



            Spacer(modifier = Modifier.width(4.dp))
    // output box
           Box {
               Button(onClick = { oExpanded= true }) {
                   Text(text = oUnit)
                   Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow down")
               }
               DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                   DropdownMenuItem(text = { Text(text = "centimeter") }, onClick = { oExpanded = false; oUnit = "centimeter"; oConversionFactor.value = 0.01; convertUnits() })
                   DropdownMenuItem(text = { Text(text = "meter") }, onClick = { oExpanded = false; oUnit = "meter"; oConversionFactor.value = 1.00; convertUnits() })
                   DropdownMenuItem(text = { Text(text = "feet") }, onClick = { oExpanded = false; oUnit = "feet"; oConversionFactor.value = 0.3048; convertUnits() })
                   DropdownMenuItem(text = { Text(text = "millimeter") }, onClick = { oExpanded = false; oUnit = "millimeter"; oConversionFactor.value = 0.001; convertUnits() })}
           }
           }

        Text(text = "Result: $outputValue $oUnit", style = MaterialTheme.typography.headlineMedium)
    }

}


@Preview (showBackground = true)
@Composable

fun unitConverterPreview(){
    unitConverter()
}
