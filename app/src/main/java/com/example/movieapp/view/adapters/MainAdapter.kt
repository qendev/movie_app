package com.example.movieapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.databinding.AdapterMovieBinding
import com.example.movieapp.model.Movie


/*
create an adapter for the recyclerview to set
all the items into the recyclerview.
* */
class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    var movies = mutableListOf<Movie>()
    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)


    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.name

        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {return movies.size
    }


    class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}