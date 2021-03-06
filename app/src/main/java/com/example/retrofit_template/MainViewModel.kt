package com.example.retrofit_template

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_template.model.Post
import com.example.retrofit_template.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushPost(post: Post){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int, auth: String){
        viewModelScope.launch {
            val response = repository.getPosts2(number, auth)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId: Int, sort: String, order: String){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myCustomPosts.value = response

        }
    }

    fun getCustomPosts2(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, options)
            myCustomPosts2.value = response
        }
    }
}