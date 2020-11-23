package com.example.environmental_codefest

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.environmental_codefest.models.Issue

@Database(entities = arrayOf(Issue::class), version = 1)
abstract class IssueDatabase : RoomDatabase() {
    abstract fun issueDao(): IssueDao
}
