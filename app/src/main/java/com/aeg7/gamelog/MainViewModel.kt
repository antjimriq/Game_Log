package com.aeg7.gamelog

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aeg7.gamelog.Api.MainRepository
import com.aeg7.gamelog.Api.service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(app: Application) :ViewModel() {
    private var _myGamesList = MutableLiveData<MutableList<Game>>()
    val myGamesList:LiveData<MutableList<Game>>
    get() = _myGamesList
    private val repository=MainRepository()
    init {
        viewModelScope.launch {
            _myGamesList.value=repository.importGames()
        }
    }

}