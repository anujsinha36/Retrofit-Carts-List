package com.example.retrofitpractise.data

data class Cart(
    val id: Int,
    val products: List<Product>,
    val userId: Int,
    val totalProducts: Int,
    val totalQuantity: Int,
    val total: Double,
    val discountedTotal: Double
)