package com.example.qr

import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.qr.ui.theme.QRTheme
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

class MainActivity : ComponentActivity() {
    private val scanln =  registerForActivityResult(ScanContract()){
        result->
            if(result.contents == null){
                Toast.makeText(this , "cancel Scan data ${result.contents}" , Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this , "accept  scan data${result.contents}" , Toast.LENGTH_LONG).show()
            }


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QRTheme {
                Button(onClick = {
                    scanln.launch(ScanOptions())
                } , modifier = Modifier.fillMaxSize()  , ){
                    Text(text= "Click me if you wanna scan")
                }
            }
        }
    }
}



