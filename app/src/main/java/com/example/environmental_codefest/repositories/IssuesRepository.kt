package com.example.environmental_codefest.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.environmental_codefest.models.Issue
import javax.inject.Inject

class IssuesRepository @Inject constructor() {
    private lateinit var issues: List<Issue>

    //TODO inject webservice, use webservice to get issues, cache/preserve data
    fun getIssues(): LiveData<List<Issue>> {
        val list = mutableListOf<Issue>()
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
        issues = list
        val data = MutableLiveData<List<Issue>>()
        data.value = list
        Log.d(this.toString(), "Issues Size: ${list.size}")
        return data
    }

    fun getIssue(position: Int): Issue{
        return issues[position]
    }
}
