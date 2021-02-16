package com.hnatiuk.maxim.repositories

import com.hnatiuk.maxim.network.RestClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object TodoRepository {

    val toDoService = RestClient.toDoService

    suspend fun getTodoById(id: Int) = withContext(Dispatchers.IO) {
        toDoService.getToDoById(id)
    }
}