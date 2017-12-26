package com.example.springdemo.greeting

import com.example.springdemo.commons.exception.NotFoundException
import java.util.concurrent.atomic.AtomicLong

class GreetingService {
    private val greetings = mutableListOf<Greeting>()
    private val counter = AtomicLong()

    fun create(greeting: Greeting): Greeting {
        greeting.id = counter.incrementAndGet()
        greetings.add(greeting)
        return greeting
    }

    fun find(id: Long): Greeting {
        return greetings.find { it.id == id } ?:
                throw NotFoundException("Greeting not found")
    }

    fun list(): List<Greeting> {
        return greetings
    }

    fun update(id: Long, updatedGreeting: Greeting): Greeting {
        val greeting = greetings.find { it.id == id } ?:
                throw NotFoundException("Greeting not found")
        val index = greetings.indexOf(greeting)
        updatedGreeting.id = greeting.id
        greetings[index] = updatedGreeting
        return updatedGreeting
    }

    fun delete(id: Long) {
        val greeting = greetings.find { it.id == id } ?:
                throw NotFoundException("Greeting not found")
        greetings.remove(greeting)
    }
}
