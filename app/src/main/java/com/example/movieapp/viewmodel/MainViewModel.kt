package com.example.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.model.Movie
import com.example.movieapp.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*
In the ViewModel setup,we need to create a class and extend the ViewModel.
The viewModel class has business logic and API call implementations.
In the ViewModel constructor, we need to pass the data repository to handle the data.
The ViewModel will handle the response.
* */

/*
We are using Live data to update the data to UI.
Since LiveData respects Android Lifecycle, this means
it will not invoke its observer callback unless activity
or fragment is received onStart()
but did not accept onStop() Adding to this,
LiveData will also automatically remove the observer
when its host receives onDestroy().
* */
class MainViewModel constructor(private val mainRepository: MainRepository):ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies(){
        val response = mainRepository.getAllMovies()
        response.enqueue(object : Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }
}