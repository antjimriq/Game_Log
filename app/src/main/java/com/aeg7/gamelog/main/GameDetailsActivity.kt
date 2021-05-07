package com.aeg7.gamelog.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.aeg7.gamelog.DatePicker
import com.aeg7.gamelog.Game
import com.aeg7.gamelog.R
import com.aeg7.gamelog.api.MainRepository
import com.aeg7.gamelog.database.getDatabase
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class GameDetailsActivity : AppCompatActivity() {
    companion object{
        const val KEY = "7e8c32c7ac3140cd94a143252b925b94"
        const val GAME_KEY = "game"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)

        //Recibimos el intent que se envia desde GameListMainActivity con la función openGameListDetailActivity
        val game = intent?.extras?.getParcelable<Game>(GAME_KEY)
        println("aquiiiiii------------------------------------"+game?.logo)

        if(game?.logo?.isNotEmpty() == true){
            Glide.with(this).load(game?.logo).into(findViewById(R.id.logoDetails))
        }else{
            Glide.with(this).load("https://www.ferexpo.cl/images/contenido-no-disponible.jpg").into(findViewById(R.id.logoDetails))
        }


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
        val platforms= game?.platform
        val spinnerPlatform:Spinner=findViewById(R.id.platform)
        if (spinnerPlatform != null){
            val adapter= platforms?.let {
                ArrayAdapter(this,android.R.layout.simple_spinner_item, it)
            }
            spinnerPlatform.adapter=adapter
        }

        findViewById<Button>(R.id.save_button).setOnClickListener{
            saveData(game)
        }
    }

    private fun saveData(game: Game?) {
        game?.preferences?.console = findViewById<Spinner>(R.id.platform).toString()

        game?.preferences?.mark = findViewById<Spinner>(R.id.mark).toString()

        game?.preferences?.status = findViewById<Spinner>(R.id.game_status).toString()
        game?.preferences?.comments = findViewById<EditText>(R.id.comments).toString()
        game?.preferences?.ownership = findViewById<CheckBox>(R.id.ownership).toString()
        game?.preferences?.physicalCopy = findViewById<CheckBox>(R.id.physical_copy).toString()
        game?.preferences?.digitalCopy = findViewById<CheckBox>(R.id.digital_copy).toString()
        game?.preferences?.collectors = findViewById<CheckBox>(R.id.collectors_edition).toString()
        game?.preferences?.extra = findViewById<CheckBox>(R.id.dlc).toString()
        game?.preferences?.date = findViewById<Button>(R.id.starting_date).toString()

        //El juego iría a mi lista
        game?.myGame=true

        val database= getDatabase(application)
        val repository= MainRepository(database, application)

        runBlocking {
            launch(Dispatchers.IO){
                if (game != null) {
                    repository.updateOneGame(game)
                }
            }
        }

        val intent= Intent(this, MyGamesListActivity::class.java)
        intent.putExtra(MyGamesListActivity.MYGAMES_KEY,game)
        startActivity(intent)



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