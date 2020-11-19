package com.example.environmental_codefest.service

import com.example.environmental_codefest.models.Issue
import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/issues/")
    fun getIssues(): Call<List<Issue>>
}