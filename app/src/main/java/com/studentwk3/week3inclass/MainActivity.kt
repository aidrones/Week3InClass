package com.studentwk3.week3inclass

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtNum1 = findViewById<EditText>(R.id.txtNum1)
        var txtNum2 = findViewById<EditText>(R.id.txtNum2)
        val txtShow = findViewById<TextView>(R.id.txtShow)
        var btnSum = findViewById<Button>(R.id.btnSum)

        btnSum.setOnClickListener {
            var num1: Int = txtNum1.text.toString().toInt()
            var num2: Int = txtNum2.text.toString().toInt()
            val showcalc: Int = calculate(num1, num2)
            txtShow.text = "The sum is: ${showcalc}"

            //clear num1 & num2
            txtNum1.setText("")
            txtNum2.setText("")
            txtNum1.requestFocus()
            hideKeyboard()
        }
    }

    //Math
    fun calculate(a: Int, b: Int): Int {
        return a + b
    }

    //function to hide keyboard
    //import android.content.Context
    //import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            //ToDo: handle exception
        }

    }
}
