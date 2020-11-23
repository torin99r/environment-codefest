package com.example.environmental_codefest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.environmental_codefest.models.Issue

@Dao
interface IssueDao{
    @Insert(onConflict = REPLACE)
    fun save(issue: Issue)

    @Query("SELECT * FROM issue")
    fun getAll(): List<Issue>

    @Query("SELECT * FROM issue WHERE id = :issueId")
    fun getIssue(issueId: Int)
}