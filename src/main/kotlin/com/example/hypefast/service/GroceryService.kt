package com.example.hypefast.service

import com.example.hypefast.repositories.GroceryRepository
import org.springframework.stereotype.Service

@Service
class GroceryService(
    private  val groceryRepository: GroceryRepository
) {
}