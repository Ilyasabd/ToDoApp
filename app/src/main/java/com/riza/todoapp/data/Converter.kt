package com.riza.todoapp.data

import androidx.room.TypeConverter
import com.riza.todoapp.data.models.Priority

class Converter {
    //Typeconverter ,yang memungkinkan anda untuk mempertahankan tipe costum tertentu kedalam data base
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }

}