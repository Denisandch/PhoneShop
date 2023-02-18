package com.example.domain.model

data class PhoneDescription(
    val id: Int,
    val name: String,
    val price: Int,
    val description: String,
    val pictures: List<String>
)
