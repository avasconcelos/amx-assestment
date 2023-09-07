package com.amx.assestment.handler

import com.amx.assestment.dto.ErrorDto
import com.amx.assestment.exceptions.UserNoContentException
import com.amx.assestment.exceptions.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun handleUserNotFoundException(ex: UserNotFoundException): ResponseEntity<ErrorDto> {
        val error = ErrorDto(
            HttpStatus.NOT_FOUND.value(),
            ex.message!!
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleUserNoContentException(ex: UserNoContentException): ResponseEntity<ErrorDto> {
        val error = ErrorDto(
            HttpStatus.NO_CONTENT.value(),
            ex.message!!
        )

        return ResponseEntity(error, HttpStatus.NO_CONTENT)
    }
}