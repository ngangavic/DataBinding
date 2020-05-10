package com.example.databinding.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.R
import com.example.databinding.model.GroceryItem

class GroceryAdapter(val items: ArrayList<GroceryItem>, val context: Context,
                     val itemEditListener: (position: Int) -> Unit,
                     val itemDeleteListener: (position: Int) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.grocery_list_item, parent,
                false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        val description = item.amount.toString() + "x: " + item.itemName
        holder.textViewGroceryItem.text = description
        holder.textViewPrice.text = item.finalPrice.toString()
        holder.buttonEdit.setOnClickListener { itemEditListener(position) }
        holder.buttonDelete.setOnClickListener { itemDeleteListener(position) }
    }
}