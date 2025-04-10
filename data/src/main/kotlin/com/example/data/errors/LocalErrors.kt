package com.example.data.errors

sealed class LocalErrors : Throwable() {
    data object DatabaseException : LocalErrors()
}
