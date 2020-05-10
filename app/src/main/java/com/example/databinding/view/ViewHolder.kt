package com.example.databinding.view

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.databinding.GroceryListItemBinding
import com.example.databinding.model.GroceryItem
import kotlinx.android.synthetic.main.grocery_list_item.view.*

class ViewHolder(val binding: GroceryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: GroceryItem) {
        binding.apply {
            itemName = "${item.amount}x: ${item.itemName}"
            price = item.price.toString()
        }
    }

}