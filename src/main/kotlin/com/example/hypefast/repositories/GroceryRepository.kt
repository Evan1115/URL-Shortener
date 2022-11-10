package com.example.hypefast.repositories

import com.example.hypefast.model.URL
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GroceryRepository : MongoRepository<URL, String> {
}