package com.kaapeh.themovie.data.model

import com.kaapeh.themovie.data.emptyData.EmptyMoviesModel

class provider {
    companion object {

        var emptyMoviesModel = EmptyMoviesModel()
        var movies : moviesModel = emptyMoviesModel.getEmptyMovies()


    }

}