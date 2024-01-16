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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jc_unitconverterapp.ui.theme.JC_unitConverterAppTheme

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
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "UNIT CONVERTER")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange ={} )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
    // output box
            Box {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow down")
                }
                DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "centimeter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "meter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "millimeter") }, onClick = { /*TODO*/ })}
            }



            Spacer(modifier = Modifier.width(4.dp))
    // input box
           Box {
               Button(onClick = { /*TODO*/ }) {
                   Text(text = "select")
                   Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow down")
               }
               DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
                   DropdownMenuItem(text = { Text(text = "centimeter") }, onClick = { /*TODO*/ })
                   DropdownMenuItem(text = { Text(text = "meter") }, onClick = { /*TODO*/ })
                   DropdownMenuItem(text = { Text(text = "feet") }, onClick = { /*TODO*/ })
                   DropdownMenuItem(text = { Text(text = "millimeter") }, onClick = { /*TODO*/ })}
           }
           }

        Text(text = "Result")
    }

}


@Preview (showBackground = true)
@Composable

fun unitConverterPreview(){
    unitConverter()
}
