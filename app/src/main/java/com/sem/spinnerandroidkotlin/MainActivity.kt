package com.sem.spinnerandroidkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.sem.spinnerandroidkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private var option : Spinner? = null
    private var result : TextView? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val array = arrayOf("Option 1", "Option 2", "Option 3")

        option = findViewById<Spinner>(R.id.spinner)
        result = findViewById<TextView>(R.id.textView)
      //  option?.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array)

                ArrayAdapter.createFromResource(
                    this,
            R.array.currency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
                    option?.adapter = adapter
        }

        option?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
              //  result?.text = array.get(p2)

                when(p2) {
                    0 -> result?.text = array.get(0)
                    1 -> result?.text = array.get(1)
                    2 -> result?.text = array.get(2)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
               // result?.text = array.get(0)
            }

        }
    }
}