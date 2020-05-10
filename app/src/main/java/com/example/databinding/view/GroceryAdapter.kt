package com.example.databinding.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.R
import com.example.databinding.model.GroceryItem
import kotlinx.android.synthetic.main.grocery_list_item.view.*

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

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textViewGroceryItem: TextView = view.tv_grocery_item_name
    val textViewPrice: TextView = view.tv_grocery_item_price
    val buttonEdit: ImageButton = view.button_edit
    val buttonDelete: ImageButton = view.button_delete

}