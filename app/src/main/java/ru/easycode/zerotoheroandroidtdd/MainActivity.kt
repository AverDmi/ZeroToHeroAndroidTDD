package ru.easycode.zerotoheroandroidtdd

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.titleTextView)
        button = findViewById<Button>(R.id.hideButton)

        button.setOnClickListener {
            textView.isVisible = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.run {
            putBoolean("KEY", textView.isVisible)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.isVisible = savedInstanceState.getBoolean("KEY")
    }
}