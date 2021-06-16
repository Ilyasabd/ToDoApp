package com.riza.todoapp.fragments.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.riza.todoapp.data.models.ToDoData

class ToDoDiffUtil(
    private val oldList: List<ToDoData>,
    private val newList: List<ToDoData>
): DiffUtil.Callback() {
    //DiffUtil mempunyai Callback yang didalam nya terdapat beberapa fungsi yang mengembalikan boolean

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    // pada fungsi ini kita perlu menentukan apa yang menjadi indikator pembeda
    //antara item satu dengan yang lainya,disini saya menggunakan field repoName sebagai indikator
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    //di method ini kita menentukan indikator yang akan digunakan
    //untuk menentukan apakah item kita berubah atau tidak
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].description == newList[newItemPosition].description
                && oldList[oldItemPosition].priority == newList[newItemPosition].priority
    }
}