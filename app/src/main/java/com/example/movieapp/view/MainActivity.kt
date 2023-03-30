package com.example.movieapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.network.RetrofitService
import com.example.movieapp.repository.MainRepository
import com.example.movieapp.view.adapters.MainAdapter
import com.example.movieapp.viewmodel.MainViewModel
import com.example.movieapp.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel:MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerviewMovie.adapter = adapter
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG,"onCreate $it")
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()

    }
}