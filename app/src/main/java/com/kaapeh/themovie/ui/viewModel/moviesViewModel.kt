package com.kaapeh.themovie.ui.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaapeh.themovie.data.model.DescriptionMovies
import com.kaapeh.themovie.data.model.moviesModel
import com.kaapeh.themovie.data.model.provider
import com.kaapeh.themovie.domain.getDescriptionCase
import com.kaapeh.themovie.domain.getMoviesUseCase
import kotlinx.coroutines.launch

class moviesViewModel : ViewModel() {
    val moviesM = MutableLiveData <moviesModel?>()
    val descripcion = MutableLiveData <DescriptionMovies?>()
    val ly = MutableLiveData <Boolean> ()
    val pbMovies = MutableLiveData <Boolean>()
    val pbDescripcion = MutableLiveData <Boolean> ()

    var getMoviesUseCase = getMoviesUseCase()
    var getDescriptionUseCase = getDescriptionCase()

    @SuppressLint("SuspiciousIndentation")
    fun onCreate() {

    viewModelScope.launch {
        val result: moviesModel? = getMoviesUseCase()



            pbMovies.postValue(true)
            moviesM.postValue(result)
            pbMovies.postValue(false)

    }
    }

    @SuppressLint("SuspiciousIndentation")
    fun Description( id : String) {


        viewModelScope.launch {
            val result: DescriptionMovies? = getDescriptionUseCase.invoke(id)
            pbDescripcion.postValue(true)
            ly.postValue(false)
            descripcion.postValue(result)
            pbDescripcion.postValue(false)
            ly.postValue(true)


        }
    }




    fun ramdomMovies()
    {
      /*  val moviesAl : moviesModel = provider.random()
        moviesM.postValue(moviesAl)*/
    }


}