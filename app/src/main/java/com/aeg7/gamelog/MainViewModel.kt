package com.aeg7.gamelog

import android.app.Application
import androidx.lifecycle.*
import com.aeg7.gamelog.api.MainRepository
import com.aeg7.gamelog.database.getDatabase
import kotlinx.coroutines.launch

class MainViewModel(app: Application) :AndroidViewModel(app) {
    private val database= getDatabase(app)
    private val repository= MainRepository(database)
    private var _myGamesList = MutableLiveData<MutableList<Game>>()
    val myGamesList:LiveData<MutableList<Game>>
    get() = _myGamesList
    init {
        viewModelScope.launch {
            _myGamesList.value=repository.importGames()
        }
    }
}