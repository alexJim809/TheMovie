package com.kaapeh.themovie.data.network

import android.util.Log
import com.kaapeh.themovie.core.RetrofitHelper
import com.kaapeh.themovie.data.emptyData.EmptyMoviesModel
import com.kaapeh.themovie.data.model.moviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MoviesServices {
    private val retrofit = RetrofitHelper.getRetrofit()
    private val emptyMoviesModel = EmptyMoviesModel()
    suspend fun getMovies(): moviesModel
    {
        return withContext(Dispatchers.IO){
        val response : Response <moviesModel> = retrofit.create(MoviesApiClient::class.java).getAllMovies()

        if (response.isSuccessful)
        {
            response.body() ?: emptyMoviesModel.getEmptyMovies()
        }else
        {
            emptyMoviesModel.getEmptyMovies()
        }

            }
    }
}