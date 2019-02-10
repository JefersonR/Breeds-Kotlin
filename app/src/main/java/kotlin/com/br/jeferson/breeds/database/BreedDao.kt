package kotlin.com.br.jeferson.breeds.database

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import kotlin.com.br.jeferson.breeds.model.Breed

interface BreedDao {
    @Query("SELECT * FROM breed")
    fun getAll(): List<Breed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg breeds: Breed)

    @Delete
    fun delete(breed: Breed)
}