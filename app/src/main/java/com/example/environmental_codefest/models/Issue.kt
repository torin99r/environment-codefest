package com.example.environmental_codefest.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// todo maybe add icon as int which can ref the drawable
// add id for look up in db?
@Entity
data class Issue (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title: String = "Test Title",
    @ColumnInfo(name = "preview") val preview: String = "Test preview",
    @ColumnInfo(name = "message") val message: String = "Test Body",
    @ColumnInfo(name = "sources") val sources: String = "Test Sources"
)
