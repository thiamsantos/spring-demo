package com.example.springdemo.greeting

import org.springframework.web.bind.annotation.*

@RequestMapping("/greetings")
@RestController
class GreetingController {
    private val service = GreetingService()

    @PostMapping
    fun create(@RequestBody greeting: Greeting): Greeting = service.create(greeting)

    @GetMapping("/{id}")
    fun find(@PathVariable("id") id: Long): Greeting = service.find(id)

    @GetMapping
    fun list(): List<Greeting> = service.list()

    @PutMapping("/{id}")
    fun update(
            @PathVariable("id") id: Long,
            @RequestBody updatedGreeting: Greeting
    ): Greeting = service.update(id, updatedGreeting)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = service.delete(id)
}
