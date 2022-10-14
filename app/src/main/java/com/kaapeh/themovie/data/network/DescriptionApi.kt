package com.kaapeh.themovie.data.network

import com.kaapeh.themovie.data.model.DescriptionMovies
import com.kaapeh.themovie.data.model.moviesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface DescriptionApi {
    @GET
    suspend fun getDescription(@Url url: String): Response<DescriptionMovies>
}