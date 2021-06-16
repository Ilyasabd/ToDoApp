package com.riza.todoapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.riza.todoapp.data.models.ToDoData

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object {
        @Volatile
//volatile merupakan salah satu jenis keyword yang terdapat di bahasa pemrograman java ,
//yang dimana fungsinya untuk mencegah thread , menyembunyikan (caching) nilai pada variable.
// Keyword ini digunakan untuk menandai suatu variable ,yang disimpan di memori utama.
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ToDoDatabase::class.java, "todo_database"
            )
                .build()
    }

}