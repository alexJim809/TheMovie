package com.kaapeh.themovie.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kaapeh.themovie.data.adapter.MoviesAdapter
import com.kaapeh.themovie.databinding.ActivityMainBinding
import com.kaapeh.themovie.ui.viewModel.moviesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MoviesAdapter



    private val movieViewModel: moviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciarRv()
        movieViewModel.onCreate()
        movieViewModel.Description("238")

        movieViewModel.moviesM.observe(this, Observer {
            if (it != null) {
                if (it.page == 0)
                {
                    binding.btnRetry.isVisible = true
                    binding.ivNoSignal.isVisible = true
                }
                else {


                    adapter = MoviesAdapter(it.results)
                    binding.rvMovies.adapter = adapter
                    Log.e("TAG", "onCreate: ${it.results}")
                    adapter.notifyDataSetChanged()

                }

            }
        })


        movieViewModel.descripcion.observe(this, Observer{
            if (it != null) {
                Log.e("TAG", "descripcion ${it.original_title}"  )
            }
        })


        movieViewModel.pbMovies.observe(this, Observer{
            binding.pbMovies.isVisible = it
            Log.e("TAG", "onCreate: valor del pb $it"  )
        })

        binding.btnRetry.setOnClickListener{
            movieViewModel.onCreate()
            binding.btnRetry.isVisible = false
            binding.ivNoSignal.isVisible = false

        }

     /*   binding.viewContainer.setOnClickListener {
            movieViewModel.ramdomMovies()
        }*/
    }

    private fun iniciarRv() {
        adapter = MoviesAdapter(mutableListOf())
        binding.rvMovies.layoutManager = GridLayoutManager(this,2)
       // binding.rvMovies.setHasFixedSize(false)
    }
}