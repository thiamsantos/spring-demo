package com.example.springdemo.greeting

import com.example.springdemo.commons.exception.NotFoundException
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RequestMapping("/greetings")
@RestController
class GreetingController {
    val greetings = mutableListOf<Greeting>()
    val counter = AtomicLong()

    @PostMapping
    fun create(@RequestBody greeting: Greeting): Greeting {
        greeting.id = counter.incrementAndGet()
        greetings.add(greeting)
        return greeting
    }

    @GetMapping("/{id}")
    fun find(@PathVariable("id") id: Long): Greeting {
        return greetings.find { it.id == id } ?:
                throw NotFoundException("Greeting not found")
    }

    @GetMapping
    fun list(): List<Greeting> {
        return greetings
    }

    @PutMapping("/{id}")
    fun update(
            @PathVariable("id") id: Long,
            @RequestBody updatedGreeting: Greeting
    ): Greeting {
        val greeting = greetings.find { it.id == id } ?:
                throw NotFoundException("Greeting not found")
        val index = greetings.indexOf(greeting)
        updatedGreeting.id = greeting.id
        greetings[index] = updatedGreeting
        return updatedGreeting
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        val greeting = greetings.find { it.id == id } ?:
                throw NotFoundException("Greeting not found")
        greetings.remove(greeting)
    }
}
