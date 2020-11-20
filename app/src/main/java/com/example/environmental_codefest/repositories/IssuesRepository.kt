package com.example.environmental_codefest.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.environmental_codefest.models.Issue
import com.example.environmental_codefest.service.WebServiceObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class IssuesRepository @Inject constructor() {
    private var data = MutableLiveData<List<Issue>>()

    //TODO inject webservice, use webservice to get issues, cache/preserve data
    fun getIssues(): LiveData<List<Issue>> {
        // this is for testing ui without a connection
       /* val list = mutableListOf<Issue>()
        for (x in 0 until 20) {
            if (x.rem(2) == 0) {
                list.add(
                    Issue(
                        title = "This Is a Longer Title for testing purposes",
                        preview = "This is a really long long long long long long long long long long long long long long long long long long issue preview for testing purposes. It has to be long just for testing"
                    )
                )
            } else {
                list.add(Issue())
            }
        }
        issues = list */

        WebServiceObject.issueData.getIssues().enqueue(object : Callback<List<Issue>> {
            override fun onResponse(call: Call<List<Issue>>, response: Response<List<Issue>>) {
                data.value = response.body()
                Log.d(this.toString(), "Response Received")
            }

            override fun onFailure(call: Call<List<Issue>>, t: Throwable) {
                Log.d(this.toString(), "Error Message: ${t.message}")
                Log.d(this.toString(), "Call Executed: ${call.isExecuted}")
                Log.d(this.toString(), "Error Cause: ${t.cause}")
            }
        })

        Log.d(this.toString(), "Issues Size: ${data.value?.size}")
        return data
    }

    fun getIssue(position: Int): Issue {
        // this isn't right btw need to fix this somehow but leaving it for now cuz i don't feel
        // like working anymore tonight
        return data.value!![position]
    }
}
