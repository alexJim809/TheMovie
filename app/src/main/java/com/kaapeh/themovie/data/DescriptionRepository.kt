package com.kaapeh.themovie.data

import com.kaapeh.themovie.data.model.DescriptionMovies
import com.kaapeh.themovie.data.model.moviesModel
import com.kaapeh.themovie.data.network.DescriptionServices
import com.kaapeh.themovie.data.network.MoviesServices

class DescriptionRepository {

    private val api = DescriptionServices()

    suspend fun  getDescripcion(id : String ) : DescriptionMovies
    {


        var respose : DescriptionMovies = api.getDescriptionMovies(id)
        return respose

    }
}