package com.example.hypefast.model

import java.time.LocalDateTime


data class URL(

    val link: String,
    val shortenURL : String,
    val createdAt: LocalDateTime,
    var redirectCount: Int
)

