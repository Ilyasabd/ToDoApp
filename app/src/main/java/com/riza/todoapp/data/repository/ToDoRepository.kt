package com.riza.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.riza.todoapp.data.ToDoDao
import com.riza.todoapp.data.models.ToDoData

//Repository bertanggung jawab untuk semua data yang akan digunakan di aplikasi.
// Mau itu menyimpan data, melakukan update data, menghapus data atau mencari data
// serahkan semuanya kepada Repository
class ToDoRepository(private val toDoDao: ToDoDao) {
//Livedata sebuah class yang juga Lifecycle Aware yang artinya object ini memiliki response
// terhadap lifecycle dari Activity, Fragment atau yang lainya.
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()
    val sortByHighPriority: LiveData<List<ToDoData>> = toDoDao.sortByHighPriority()
    val sortByLowPriority: LiveData<List<ToDoData>> = toDoDao.sortByLowPriority()

//suspend ini adalah cara kotlin menerapkan fungsi yang akan dipanggil dari dalam coroutine
    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }

    suspend fun updateData(toDoData: ToDoData){
        toDoDao.updateData(toDoData)
    }

    suspend fun deleteItem(toDoData: ToDoData){
        toDoDao.deleteItem(toDoData)
    }

    suspend fun deleteAll(){
        toDoDao.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>> {
        return toDoDao.searchDatabase(searchQuery)
    }

}