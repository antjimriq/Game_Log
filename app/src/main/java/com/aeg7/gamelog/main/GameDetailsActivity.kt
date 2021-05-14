package com.aeg7.gamelog.main

import android.content.Intent
<<<<<<< HEAD
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
=======
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.aeg7.gamelog.DatePicker
>>>>>>> origin/master
import com.aeg7.gamelog.Game
import com.aeg7.gamelog.R
import com.aeg7.gamelog.api.MainRepository
import com.aeg7.gamelog.database.getDatabase
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

<<<<<<< HEAD

=======
>>>>>>> origin/master
class GameDetailsActivity : AppCompatActivity() {
    companion object{
        const val KEY = "7e8c32c7ac3140cd94a143252b925b94"
        const val GAME_KEY = "game"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)

        //Recibimos el intent que se envia desde GameListMainActivity con la función openGameListDetailActivity
<<<<<<< HEAD
        val game = intent.extras?.getParcelable<Game>(GAME_KEY)
=======
        val game = intent?.extras?.getParcelable<Game>(GAME_KEY)
>>>>>>> origin/master

        if(game?.logo?.isNotEmpty() == true){
            Glide.with(this).load(game?.logo).into(findViewById(R.id.logoDetails))
        }else{
<<<<<<< HEAD
            Glide.with(this).load("https://www.ferexpo.cl/images/contenido-no-disponible.jpg").into(
                findViewById(
                    R.id.logoDetails
                )
            )
=======
            Glide.with(this).load("https://www.ferexpo.cl/images/contenido-no-disponible.jpg").into(findViewById(R.id.logoDetails))
>>>>>>> origin/master
        }


        val status = resources.getStringArray(R.array.Status)
        val spinnerStatus:Spinner = findViewById(R.id.game_status)
        if (spinnerStatus != null){
<<<<<<< HEAD
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, status)
=======
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,status)
>>>>>>> origin/master
            spinnerStatus.adapter=adapter
        }
        val mark= resources.getStringArray(R.array.Mark)
        val spinnerMark:Spinner= findViewById(R.id.mark)
        if (spinnerMark !=null){
<<<<<<< HEAD
            val adapter= ArrayAdapter(this, android.R.layout.simple_spinner_item, mark)
=======
            val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,mark)
>>>>>>> origin/master
            spinnerMark.adapter=adapter
        }
        val platforms= game?.platform
        val spinnerPlatform:Spinner=findViewById(R.id.platform)
        if (spinnerPlatform != null){
            val adapter= platforms?.let {
<<<<<<< HEAD
                ArrayAdapter(this, android.R.layout.simple_spinner_item, it)
=======
                ArrayAdapter(this,android.R.layout.simple_spinner_item, it)
>>>>>>> origin/master
            }
            spinnerPlatform.adapter=adapter
        }

<<<<<<< HEAD
        val datapicker=findViewById<EditText>(R.id.edit_date)

        datapicker.setOnClickListener {
            showDatePickerDialog()
        }


        //Aquí pasaremos los valores del juego seleccionado para que se muestre cada dato en su correpondiente campo
        var index_plat=platforms?.indexOf(game?.preferences?.console.toString())

        if (index_plat != null) {
            findViewById<Spinner>(R.id.platform).setSelection(index_plat)
        }


        var index_mark= mark.indexOf(game?.preferences?.mark)
        if (index_mark != null) {
            findViewById<Spinner>(R.id.mark).setSelection(index_mark)
        }


        var index_status= status.indexOf(game?.preferences?.status)
        if (index_status != null) {
            findViewById<Spinner>(R.id.game_status).setSelection(index_status)
        }

        //Mostrarmos el comentario
        findViewById<EditText>(R.id.comments).setText(game?.preferences?.comments)

        //Si ownership es true el CheckBox aparecerá marcado
        findViewById<CheckBox>(R.id.ownership).isChecked = game?.preferences?.ownership == "true"
        //Repetimos lo mismo para el resto de checkbox
        findViewById<CheckBox>(R.id.physical_copy).isChecked = game?.preferences?.physicalCopy == "true"
        findViewById<CheckBox>(R.id.digital_copy).isChecked = game?.preferences?.digitalCopy == "true"
        findViewById<CheckBox>(R.id.collectors_edition).isChecked = game?.preferences?.collectors == "true"
        findViewById<CheckBox>(R.id.dlc).isChecked = game?.preferences?.extra == "true"

        //Y por ultimo mostramos la fecha en el campo date
        if(game?.preferences?.date != ""){
            findViewById<EditText>(R.id.edit_date).setText(game?.preferences?.date)
        }


=======
        if (game?.preferences?.ownership == "true"){
            findViewById<CheckBox>(R.id.ownership).isChecked=true
        }else{
            findViewById<CheckBox>(R.id.ownership).isChecked=false
        }

        findViewById<EditText>(R.id.comments).text=game?.preferences?.comments.toString()
>>>>>>> origin/master


        findViewById<Button>(R.id.save_button).setOnClickListener{
            saveData(game)
        }
    }
<<<<<<< HEAD
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.gamedetails_menu, menu)
        return true
    }
    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        val datapicker=findViewById<EditText>(R.id.edit_date)
        //En Android se empiezan a contar los meses desde cero, por ello sumamos uno para que coincida con nuestro calendario
        datapicker.setText("$day/${month+1}/$year")
    }

    private fun saveData(game: Game?) {
        //Es importante seleccionar el elemento del spinner con selectItem y convertirlo a String
        //Lo mismo con los CheckBox, hay que coger si han sido marcados con isChecked y convertirlo a String
        game?.preferences?.console = findViewById<Spinner>(R.id.platform).selectedItem.toString()
        game?.preferences?.mark = findViewById<Spinner>(R.id.mark).selectedItem.toString()
        game?.preferences?.status = findViewById<Spinner>(R.id.game_status).selectedItem.toString()
        game?.preferences?.comments = findViewById<EditText>(R.id.comments).text.toString()
        game?.preferences?.ownership = findViewById<CheckBox>(R.id.ownership).isChecked.toString()
        game?.preferences?.physicalCopy = findViewById<CheckBox>(R.id.physical_copy).isChecked.toString()
        game?.preferences?.digitalCopy = findViewById<CheckBox>(R.id.digital_copy).isChecked.toString()
        game?.preferences?.collectors = findViewById<CheckBox>(R.id.collectors_edition).isChecked.toString()
        game?.preferences?.extra = findViewById<CheckBox>(R.id.dlc).isChecked.toString()
        game?.preferences?.date = findViewById<EditText>(R.id.edit_date).text.toString()

        //Como se esta editando el juego, ponemos myGame a true
        if (game?.myGame == false){
            game?.myGame=true
        }


        val db = getDatabase(application)
        val repository= MainRepository(db, application)

=======

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

        println("aquii el juego------------------------------------- $game")

        val database= getDatabase(application)
        val repository= MainRepository(database, application)
        var listamisjuegos= mutableListOf<Game>()
>>>>>>> origin/master

        runBlocking {
            launch(Dispatchers.IO){
                if (game != null) {
                    repository.updateOneGame(game)
<<<<<<< HEAD
=======
                    listamisjuegos=repository.selectMyGames()
>>>>>>> origin/master
                }
            }
        }

<<<<<<< HEAD

        val intent= Intent(this, MyGamesListActivity::class.java)
        startActivity(intent)


    }

    fun CheckBoxClicked(view: View){
        if (view is CheckBox){
            val checked: Boolean = view.isChecked
            when (view.id){
                R.id.ownership -> {
                    if (checked) {
                        //TODO
                    } else {
                        //TODO
                    }
                }
                R.id.physical_copy -> {
                    if (checked) {
                        //TODO
                    } else {
                        //TODO
                    }
                }
                R.id.digital_copy -> {
                    if (checked) {
                        //TODO
                    } else {
                        //TODO
                    }
                }
                R.id.collectors_edition -> {
                    if (checked) {
                        //TODO
                    } else {
                        //TODO
                    }
                }
                R.id.dlc -> {
                    if (checked) {
                        //TODO
                    } else {
=======
        println("aquii el listamisjuegos------------------------------------- $listamisjuegos")

        val intent= Intent(this, MyGamesListActivity::class.java)
        //intent.putExtra(MyGamesListActivity.MYGAMES_KEY,game)
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
>>>>>>> origin/master
                        //TODO
                    }
                }
            }
        }
    }
<<<<<<< HEAD
=======
    fun showDatePicked(view: View){
        DatePicker().show(supportFragmentManager,"datePicker")
    }
>>>>>>> origin/master

}