package com.kaapeh.themovie.domain

import com.kaapeh.themovie.data.MoviesRepository
import com.kaapeh.themovie.data.model.moviesModel

class getMoviesUseCase {
    private val  repository = MoviesRepository()
    suspend  operator  fun invoke () : moviesModel ?
    {
        return repository.getAllMovies()
    }
}