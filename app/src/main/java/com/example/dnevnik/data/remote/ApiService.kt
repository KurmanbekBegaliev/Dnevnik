package com.example.ejournal.data.remote

import com.example.dnevnik.data.models.News
import com.example.dnevnik.data.models.Pupils
import com.example.ejournal.data.models.Teachers
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("add/okuuchu/")
    suspend fun getTeachers(): Response<Pupils>

    @GET("add/news/")
    suspend fun  getNews(): Response<News>
}