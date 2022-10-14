package com.kaapeh.themovie.data.emptyData

import com.kaapeh.themovie.data.model.Results
import com.kaapeh.themovie.data.model.moviesModel

class EmptyMoviesModel {

    fun getEmptyMovies ():moviesModel
    {
        var list = listOf<Int>(0,0)
        val result = Results(false,"null",list,0,"null","null","null",0.0F,"null","null","null",false,0.0F,0)
        var lisResult : List <Results> = listOf(result)

        return moviesModel(0,lisResult,0,0)
    }



}