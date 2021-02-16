package com.hnatiuk.maxim.network

import com.hnatiuk.maxim.entities.ToDo
import retrofit2.http.GET
import retrofit2.http.Path

interface ToDoService {

    @GET("/todos/{id}")
    suspend fun getToDoById(@Path("id") id: Int) : ToDo
}