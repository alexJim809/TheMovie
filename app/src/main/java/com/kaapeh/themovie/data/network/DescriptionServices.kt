package com.kaapeh.themovie.data.network

import com.kaapeh.themovie.core.RetrofitDescription
import com.kaapeh.themovie.core.RetrofitHelper
import com.kaapeh.themovie.data.emptyData.EmptyMoviesModel
import com.kaapeh.themovie.data.model.DescriptionMovies
import com.kaapeh.themovie.data.model.moviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DescriptionServices {

    private val retrofit = RetrofitDescription.getRetrofit()
    private val descriptionMovies = DescriptionMovies("null", "null",0.0F,"null", "null")

    suspend fun getDescriptionMovies(id : String ): DescriptionMovies
    {
        return withContext(Dispatchers.IO){
            val response : Response<DescriptionMovies> = retrofit.create(DescriptionApi::class.java).getDescription("$id?api_key=886b4684bf2cbe6abb21f6e8078a48e3")

            response.body() ?: descriptionMovies
        }
    }
}