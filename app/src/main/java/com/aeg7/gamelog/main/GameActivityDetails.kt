package com.aeg7.gamelog.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import com.aeg7.gamelog.DatePicker
import com.aeg7.gamelog.R

class GameActivityDetails : AppCompatActivity() {
    companion object{
        const val KEY = "7e8c32c7ac3140cd94a143252b925b94"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)
        val status = resources.getStringArray(R.array.Status)
        val spinnerStatus:Spinner = findViewById(R.id.game_status)
        if (spinnerStatus != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,status)
            spinnerStatus.adapter=adapter
        }
        val mark= resources.getStringArray(R.array.Mark)
        val spinnerMark:Spinner= findViewById(R.id.mark)
        if (spinnerMark !=null){
            val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,mark)
            spinnerMark.adapter=adapter
        }
        val platform=resources.getStringArray(R.array.Platform)
        val spinnerPlatform:Spinner=findViewById(R.id.platform)
        if (spinnerPlatform != null){
            val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,platform)
            spinnerPlatform.adapter=adapter
        }
    }
    fun CheckBoxClicked (view:View){
        if (view is CheckBox){
            val checked: Boolean = view.isChecked
            when (view.id){
                R.id.ownership ->{
                    if (checked){
                        //TODO
                        }
                    else{
                        //TODO
                    }
                }
                R.id.physical_copy ->{
                    if (checked){
                        //TODO
                    }
                    else{
                        //TODO
                    }
                }
                R.id.digital_copy ->{
                    if (checked){
                        //TODO
                    }
                    else{
                        //TODO
                    }
                }
                R.id.collectors_edition ->{
                    if (checked){
                        //TODO
                    }
                    else{
                        //TODO
                    }
                }
                R.id.dlc ->{
                    if (checked){
                        //TODO
                    }
                    else{
                        //TODO
                    }
                }
            }
        }
    }
    fun showDatePicked(view: View){
        DatePicker().show(supportFragmentManager,"datePicker")
    }


}