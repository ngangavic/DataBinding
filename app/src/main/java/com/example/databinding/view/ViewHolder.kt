package com.example.databinding.view

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grocery_list_item.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textViewGroceryItem: TextView = view.tv_grocery_item_name
    val textViewPrice: TextView = view.tv_grocery_item_price
    val buttonEdit: ImageButton = view.button_edit
    val buttonDelete: ImageButton = view.button_delete

}