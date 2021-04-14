package com.aeg7.gamelog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox

class GameDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)
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
        val newDate= DatePicker()
        newDate.show(supportFragmentManager,"datePicker")

    }

}