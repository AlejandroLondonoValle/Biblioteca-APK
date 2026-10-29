package com.sena.biblioteca_sena.navegation

import kotlinx.serialization.Serializable

@Serializable
data object Home {
}

@Serializable
data object BookList

@Serializable
data class BookDetail(
    val bookTitle: String
)

@Serializable
data class ReservationConfirmation(
    val bookTitle: String
)


