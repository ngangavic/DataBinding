package com.example.databinding.view

import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.databinding.GroceryListItemBinding
import com.example.databinding.model.GroceryItem

class ViewHolder(val binding: GroceryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: GroceryItem) {
        binding.apply {
            itemName = "${item.amount}x: ${item.itemName}"
            price = item.price.toString()
        }
    }

}