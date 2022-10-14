package com.kaapeh.themovie.data.holders

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

import com.kaapeh.themovie.databinding.ItemMovieBinding
import com.kaapeh.themovie.ui.view.Descripcion
import com.squareup.picasso.Picasso

class MoviesViewHolder (view : View): RecyclerView.ViewHolder (view)  {


    private  val binding  = ItemMovieBinding.bind(view)

    fun bind (image : String ,rated : String , id : String)
    {
        val ruta = "https://image.tmdb.org/t/p/original$image"
        Picasso.get().load(ruta).into(binding.ivPoster)
        binding.tvRated.text = rated
        Log.e("TAG", "Click bind: $id" )
        binding.ivPoster.setOnClickListener{
           val intent = Intent(it.context, Descripcion::class.java)
            intent.putExtra("id",id)
            it.context.startActivity(intent)


        }
        Log.e("TAG", "bind: $ruta"  )

    }
}