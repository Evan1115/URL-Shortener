package com.example.hypefast.controller


import com.example.hypefast.model.URL
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/url")
interface GroceryApi {
    //Get
    @GetMapping("/redirect/{url}")
    fun urlRedirection(
        @PathVariable("url")
        url : String
    ) : ResponseEntity<Void>

    @GetMapping("/{url}")
    fun findByShortenURL(
        @PathVariable("url")
        url : String
    ) : ResponseEntity<URL>

    //post
    @PostMapping
     fun generateShortenURL(
        @RequestBody
        link: CreateURLResource
     ) : ResponseEntity<URL>


}