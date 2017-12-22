package com.example.springdemo.greeting

import com.fasterxml.jackson.annotation.JsonProperty

data class Greeting(
        @JsonProperty("id") var id: Long = 0,
        @JsonProperty("content") val content: String)
