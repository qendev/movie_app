package com.example.movieapp.network

import com.example.movieapp.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//create the interface for the API call definition.
interface RetrofitService {
    @GET("movielist.json")
    fun getAllMovies(): Call<List<Movie>>

    //Create the Retrofit service instance using the retrofit.

    companion object{
        var retrofitService:RetrofitService? = null

        fun getInstance():RetrofitService{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService =retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }


}