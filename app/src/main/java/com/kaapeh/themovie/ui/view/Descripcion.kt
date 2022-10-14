package com.kaapeh.themovie.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.kaapeh.themovie.R
import com.kaapeh.themovie.databinding.ActivityDescripcionBinding
import com.kaapeh.themovie.databinding.ActivityMainBinding
import com.kaapeh.themovie.ui.viewModel.moviesViewModel
import com.squareup.picasso.Picasso

class Descripcion : AppCompatActivity() {
    private lateinit var binding: ActivityDescripcionBinding
    private val movieViewModel: moviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle: Bundle? = intent.extras
        val id = bundle?.getString("id")

        if (id != null) {
            movieViewModel.Description(id)
        }
        movieViewModel.descripcion.observe(this, Observer{
            if (it != null) {
                val ruta = "https://image.tmdb.org/t/p/original${it.poster_path}"

                Log.e("TAG", "ruta    $", )
                Picasso.get().load(ruta).into(binding.ivDescripcion)
                binding.tvTitulo.text = it.original_title
                binding.tvRated.text = it.vote_average.toString()
                binding.tvfecha.text = " Fecha de estreno : ${it.release_date}"
                binding.tvDescripcion.text = it.overview
                Log.e("TAG", "descripcion ${it.original_title}"  )
            }
        })


        movieViewModel.pbDescripcion.observe(this, Observer{
            binding.pbDescripcion.isVisible = it
            Log.e("TAG", "onCreate: valor del pb $it"  )
        })

        movieViewModel.ly.observe(this , Observer{
            binding.clVista.isVisible = it
        })

    }
}