package kotlin.com.br.jeferson.breeds.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import kotlin.com.br.jeferson.breeds.model.Breed

@Database(entities = arrayOf(Breed::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
}