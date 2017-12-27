package com.example.springdemo.commons.handlers

import com.example.springdemo.commons.exception.ExceptionResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ErrorAttributes
import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class GenericExceptionHandler: ErrorController {
    @Autowired
    private val errorAttributes: ErrorAttributes? = null

    override fun getErrorPath(): String {
        return "/error"
    }

    @RequestMapping("/error")
    fun error(request: HttpServletRequest, response: HttpServletResponse): ExceptionResponse {
        val requestAttributes = ServletRequestAttributes(request)
        val a : Map<String, Any> = errorAttributes!!.getErrorAttributes(requestAttributes, false)

        return ExceptionResponse(a["message"].toString())
    }
}
