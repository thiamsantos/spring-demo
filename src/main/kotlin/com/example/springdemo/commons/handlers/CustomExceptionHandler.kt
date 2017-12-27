package com.example.springdemo.commons.handlers

import com.example.springdemo.commons.exception.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    fun notFound(exception: NotFoundException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse(exception.message), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(UnauthorizedException::class)
    fun unauthorized(exception: UnauthorizedException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse(exception.message), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(ForbiddenException::class)
    fun forbidden(exception: ForbiddenException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse(exception.message), HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(ConflictException::class)
    fun conflict(exception: ConflictException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse(exception.message), HttpStatus.CONFLICT)
    }

    @ExceptionHandler(UnprocessableException::class)
    fun unprocessable(exception: UnprocessableException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse(exception.message), HttpStatus.UNPROCESSABLE_ENTITY)
    }
}
