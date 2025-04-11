package com.example.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.database.model.DeletedMovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDeletedMovie(movie: DeletedMovieEntity)

    @Query("SELECT * FROM deletedmovieentity")
    suspend fun getAllDeletedMovies(): List<DeletedMovieEntity>
}
