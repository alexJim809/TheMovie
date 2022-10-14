package com.kaapeh.themovie.data.network

import com.kaapeh.themovie.data.model.moviesModel
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApiClient {

    @GET("top_rated?api_key=886b4684bf2cbe6abb21f6e8078a48e3")
    suspend fun getAllMovies():Response <moviesModel>
}