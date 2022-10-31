package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Numbers

        bu0.setOnClickListener { appendVal("0", false) }
        bu1.setOnClickListener { appendVal("1", false) }
        bu3.setOnClickListener { appendVal("3", false) }
        bu4.setOnClickListener { appendVal("4", false) }
        bu5.setOnClickListener { appendVal("5", false) }
        bu6.setOnClickListener { appendVal("6", false) }
        bu7.setOnClickListener { appendVal("7", false) }
        bu8.setOnClickListener { appendVal("8", false) }
        bu9.setOnClickListener { appendVal("9", false) }
        bu2.setOnClickListener { appendVal("2", false) }
        buDot.setOnClickListener { appendVal(".", false) }
        //Operators
        buAC.setOnClickListener { appendVal("", true) }
        buDivide.setOnClickListener { appendVal(" / ", false) }
        buMultiply.setOnClickListener { appendVal(" * ", false) }
        buMinus.setOnClickListener { appendVal(" - ", false) }
        buPlus.setOnClickListener { appendVal(" + ", false) }


        buEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(editText.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    Toast.makeText(this, "Double", Toast.LENGTH_SHORT).show()
                    editText.text = longResult.toString()
                } else
                    editText.text = result.toString()

            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show();

                Log.d("EXCEPTION", "Message: ${e.message}")
            }

        }


    }

    fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            editText.text = ""
//            placeholder.append(string)
        } else {
            editText.append(string)
        }
    }

}
