package com.example.springdemo.commons.exception

class NotFoundException(override val message: String) : RuntimeException(message)

class UnauthorizedException(override val message: String) : RuntimeException(message)

class ForbiddenException(override val message: String) : RuntimeException(message)

class ConflictException(override val message: String) : RuntimeException(message)

class UnprocessableException(override val message: String) : RuntimeException(message)
