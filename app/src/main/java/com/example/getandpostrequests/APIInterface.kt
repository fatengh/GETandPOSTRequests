package com.example.getandpostrequests

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
    @GET("/custom-people/")
    fun getName():Call<Data>
    @POST("/custom-people/")
    fun addName(@Body obUser:DataItem):Call<DataItem>
}

