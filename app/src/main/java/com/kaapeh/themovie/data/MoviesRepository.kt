package com.kaapeh.themovie.data

import android.util.Log
import com.kaapeh.themovie.data.emptyData.EmptyMoviesModel
import com.kaapeh.themovie.data.model.DescriptionMovies
import com.kaapeh.themovie.data.model.moviesModel
import com.kaapeh.themovie.data.model.provider
import com.kaapeh.themovie.data.network.MoviesServices

class MoviesRepository {
    private val api = MoviesServices()

    suspend fun getAllMovies():moviesModel
    {

        val emptyMoviesModel = EmptyMoviesModel()
        Log.e("TAG", "getAllMovies: ${api.getMovies().results[0].title}" )
        var respose : moviesModel = api.getMovies()

       // respose += moviesModel("uamgen","titulo","calificacio")
       // respose.addAll(listOf<moviesModel>(moviesModel("imagen", "titulo" , "calificacion")))


        provider.movies = respose
        return respose
    }



}