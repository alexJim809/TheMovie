package com.kaapeh.themovie.data.model

import com.google.gson.annotations.SerializedName

data class moviesModel (val page : Int , val results: List<Results>, val total_pages : Int, val total_results : Int)