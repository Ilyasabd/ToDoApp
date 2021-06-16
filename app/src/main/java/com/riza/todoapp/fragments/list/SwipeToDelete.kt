package com.riza.todoapp.fragments.list

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
//ItemTouchHelper.SimpleCallback menyediakan metode callback tertentu seperti onMove(),
// onChildDraw(), onSwiped() saat baris digesek. Menampilkan tampilan latar belakang,
// menghapus item dari adaptor dapat dilakukan menggunakan metode callback ini.
abstract class SwipeToDelete: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }
}