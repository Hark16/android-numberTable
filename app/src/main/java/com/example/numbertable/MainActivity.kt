package com.example.numbertable


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val closeButton: Button = findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            finish() // Close the activity (and the app)
        }

        //val swipeRefreshLayout = findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val numberTableTextView = findViewById<TextView>(R.id.numberTableTextView)

        /*
        swipeRefreshLayout.setOnRefreshListener {

            editText.text.clear()
            numberTableTextView.text = ""
            swipeRefreshLayout.isRefreshing = false
            Toast.makeText(this, "App is refreshed", Toast.LENGTH_SHORT).show()

        }
*/

        button.setOnClickListener {
            val number = editText.text.toString().toIntOrNull()
            if (number != null) {
                val table = generateNumberTable(number)
                numberTableTextView.text = table

                // Example of displaying a Toast message when the activity is created
                val message = "Number table generated for number "+ number
                val duration = Toast.LENGTH_SHORT // or Toast.LENGTH_LONG for a longer duration
                val toast = Toast.makeText(this, message, duration)
                toast.show()
//                editText.text.clear()
                numberTableTextView.requestFocus()

            } else {
                editText.error = "Please enter a valid number"
            }
        }
    }

    private fun generateNumberTable(number: Int): String {
        val stringBuilder = StringBuilder()
        for (i in 1..10) {
            val result = number * i
            stringBuilder.append("$number x $i = $result\n")
        }
        return stringBuilder.toString()
    }


}
