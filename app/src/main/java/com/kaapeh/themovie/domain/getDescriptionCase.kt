package com.kaapeh.themovie.domain

import com.kaapeh.themovie.data.DescriptionRepository
import com.kaapeh.themovie.data.MoviesRepository
import com.kaapeh.themovie.data.model.DescriptionMovies
import com.kaapeh.themovie.data.model.moviesModel

class getDescriptionCase {

    private val  repository = DescriptionRepository()
    suspend  operator  fun invoke (id :String) : DescriptionMovies?
    {
        return repository.getDescripcion(id)
    }
}