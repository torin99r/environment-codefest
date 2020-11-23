package com.example.environmental_codefest.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.environmental_codefest.models.Issue
import com.example.environmental_codefest.repositories.IssuesRepository

class IssuesViewModel @ViewModelInject constructor(
    private val issuesRepository: IssuesRepository,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {
    val issues: LiveData<List<Issue>> = issuesRepository.getIssues()

    // maybe take out into a different viewmodel specifically for DetailFragment?
    // add a new model with more info of an issue like
    // IssueDetails with more info we pull down from api?
    // rep info if detailfragment is also where we send emails from
    fun getIssue(position: Int) = issuesRepository.getIssue(position)
    fun saveIssue(issue: Issue) {

    }

}
