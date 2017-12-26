package com.example.springdemo.commons.exception

class NotFoundException(override val message: String) : RuntimeException(message)
