package com.riza.todoapp.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//*Entitas merupakan data class dengan anotasi @Entity yang bertujuan
// untuk menyimpan data dan merepresentasikan tabel dalam database.

//menambahkan @parcelize dan parcelable Hal ini dilakukan supaya kita bisa mengirimkan
// data berupa objek ke activity lain yang dikirimkan bersama intent.

@Entity(tableName = "todo_table")
@Parcelize
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Priority,
    var description: String
): Parcelable