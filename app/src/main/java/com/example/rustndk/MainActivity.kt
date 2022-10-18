package com.example.rustndk

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.System.loadLibrary

class MainActivity : AppCompatActivity() {

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            loadLibrary("rust_lib")
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.textView).text = stringFromJNI()
    }

    external fun stringFromJNI():String
}