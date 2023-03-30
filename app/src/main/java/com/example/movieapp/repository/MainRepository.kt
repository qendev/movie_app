package com.example.movieapp.repository

import com.example.movieapp.network.RetrofitService


/*
I am using a repository pattern to handle the data from API.
In the repository class, we need to pass the retrofit service
instance to perform the network call.
There is no need to handle the response here in the repository
that will be part of the ViewModel.
* */
class MainRepository(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}