package com.example.environmental_codefest.models

// todo maybe add icon as int which can ref the drawable
// add id for look up in db?
data class Issue (
    val id: Int = 0,
    val title: String = "Test Title",
    val preview: String = "Test preview",
    val message: String = "Test Body",
    val sources: String = "Test Sources"
)
