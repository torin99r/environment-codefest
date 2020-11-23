package com.example.environmental_codefest.service

import com.example.environmental_codefest.models.Issue
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

// put this in to set up the service
// basically copied it from somewhere trying to get this to work
// calls like WebServiceObject.issueData.getIssues()
object WebServiceObject {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://earthspeaks.pythonanywhere.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val issueData: WebService = retrofit.create(WebService::class.java)
}
