package com.example.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DeletedMovieEntity(
    @PrimaryKey
    var id: Int = 0,
)
