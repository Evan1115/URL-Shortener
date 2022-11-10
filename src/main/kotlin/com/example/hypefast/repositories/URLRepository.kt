package com.example.hypefast.repositories

import com.example.hypefast.model.URL
import org.springframework.stereotype.Repository

@Repository
class URLRepository {
    var URLs: MutableList<URL> = mutableListOf()

    fun save(url: URL): URL {
        URLs.add(url)
        return url
    }

    fun findByShortenURL(url: String): URL? {

        return URLs.find { it.shortenURL == url }
    }


    fun updateURL(url: URL): URL {
        val foundURL = URLs.filter { it.shortenURL == url.shortenURL }.first()
        foundURL.redirectCount++
        URLs.add(foundURL)
        URLs.remove(url)
        return foundURL
    }

}