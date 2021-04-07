package com.aeg7.gamelog

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aeg7.gamelog.Api.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(app: Application) :ViewModel() {
    private val _myGamesList = MutableLiveData<MutableList<Game>>()
    val myGamesList:LiveData<MutableList<Game>>
    get() = _myGamesList
    private val repository=MainRepository()
    init {
        viewModelScope.launch {
            _myGamesList.value=repository.importGames()
        }
    }
}