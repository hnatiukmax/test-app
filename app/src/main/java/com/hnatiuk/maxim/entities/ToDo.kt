package com.hnatiuk.maxim.entities

import com.google.gson.annotations.SerializedName

data class ToDo(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("completed")
    val completed: Boolean
)