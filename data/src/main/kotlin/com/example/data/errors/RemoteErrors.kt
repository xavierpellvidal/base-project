package com.example.data.errors

sealed class RemoteErrors : Throwable() {
    data object NetworkException : RemoteErrors()
}
