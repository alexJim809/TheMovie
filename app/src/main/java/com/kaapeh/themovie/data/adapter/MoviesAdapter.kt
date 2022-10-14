package com.kaapeh.themovie.data.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaapeh.themovie.R
import com.kaapeh.themovie.data.holders.MoviesViewHolder
import com.kaapeh.themovie.data.model.Results

class MoviesAdapter (val images :List <Results> ) : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        Log.e("TAG", "onBindViewHolder: ${images.size}" )
        val item : String = images[position].poster_path
        val rated : String = "${images[position].vote_average}"
        val id : String= "${images[position].id}"
        holder.bind(item,rated,id)
    }

    override fun getItemCount(): Int {
        Log.e("TAG", "getItemCount:  ${images.size}" )
        return images.size
    }
}