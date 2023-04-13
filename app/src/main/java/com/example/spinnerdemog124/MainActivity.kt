package com.example.spinnerdemog124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinnerSelection: Spinner = findViewById(R.id.spinnerCourseSelection)
        spinnerSelection.onItemSelectedListener = this
        ArrayAdapter.createFromResource(this,
        R.array.course_selection,
        android.R.layout.simple_spinner_item).also{
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSelection.adapter = adapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos:Int, id:Long){
        val selectionTv: TextView = findViewById(R.id.selectedCourseTextView)
        selectionTv.text = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>){
        val selectionTv: TextView = findViewById(R.id.selectedCourseTextView)
        selectionTv.text = "You have not make a course selection"
    }
}