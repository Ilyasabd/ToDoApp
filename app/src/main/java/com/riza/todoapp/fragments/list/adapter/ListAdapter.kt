package com.riza.todoapp.fragments.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.riza.todoapp.data.models.ToDoData
import com.riza.todoapp.databinding.RowLayoutBinding

//Data Binding adalah sebuah library yang berguna untuk mengizinkan layout berkomunikasi
// secara langsung pada data model kita untuk menghilangkan boilerplate code pada program
// aplikasi kita didalam android.
class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(toDoData: ToDoData){
            binding.toDoData = toDoData
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(
                    binding
                )
            }
        }
    }
    // membuat suatu tampilan dan mengembalikannya
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(
            parent
        )
    }
    // mengembalikan jumlah total item dalam kumpulan data yang dipegang oleh adapter
    override fun getItemCount(): Int {
        return dataList.size
    }
    //menghubungkan data dengan view holder pada posisi yang ditentukan dalam RecyclerView.
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }

    fun setData(toDoData: List<ToDoData>){
        val toDoDiffUtil = ToDoDiffUtil(dataList, toDoData)
        val toDoDiffResult = DiffUtil.calculateDiff(toDoDiffUtil)
        this.dataList = toDoData
        toDoDiffResult.dispatchUpdatesTo(this)
    }

}