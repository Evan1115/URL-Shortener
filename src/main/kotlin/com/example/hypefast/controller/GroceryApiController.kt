package com.example.hypefast.controller

import com.example.hypefast.model.URL
import com.example.hypefast.repositories.GroceryRepository
import com.example.hypefast.repositories.URLRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.time.LocalDateTime
import kotlin.random.Random

@RestController
class GroceryApiController(
    private val URLRepository : URLRepository,
    private val groceryRepository: GroceryRepository
) : GroceryApi {
    override fun urlRedirection(url: String): ResponseEntity<Void> {
        val url = URLRepository.findByShortenURL(url) ?: return ResponseEntity.notFound().build()

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.link)).build();
    }
    override fun findByShortenURL(url: String): ResponseEntity<URL> {
        val url = URLRepository.findByShortenURL(url) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(url)
    }
    override fun generateShortenURL(resource: CreateURLResource): ResponseEntity<URL> {
        val length = 6
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val shortenURL = (1..length)
            .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
            .joinToString("")

        val newURL = URLRepository.save( URL(resource.link, shortenURL, LocalDateTime.now(), 0))
        return ResponseEntity.ok(newURL)
    }
}