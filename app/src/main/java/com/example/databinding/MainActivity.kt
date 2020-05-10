package com.example.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databinding.databinding.ActivityMainBinding
import com.example.databinding.model.GroceryItem
import com.example.databinding.view.GroceryAdapter
import com.example.databinding.view.NewItemDialogFragment
import com.example.databinding.viewmodel.GroceryListViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), NewItemDialogFragment.NewItemDialogListener {

    lateinit var viewModel: GroceryListViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(GroceryListViewModel::class.java)

        // TODO: associate the layout manager, adapter and button listener with the binding object

        binding.rvGroceryList.layoutManager = LinearLayoutManager(this)

        binding.rvGroceryList.adapter = GroceryAdapter(viewModel.groceryListItems, this,
                ::editGroceryItem, ::deleteGroceryItem)

        binding.addItemButton.setOnClickListener {
            addGroceryItem()
        }

    }

    override fun onDialogPositiveClick(dialog: DialogFragment, item: GroceryItem, isEdit: Boolean, position: Int?) {
        if (!isEdit) {
            viewModel.groceryListItems.add(item)
        } else {
            viewModel.updateItem(position!!, item)
            binding.rvGroceryList.adapter?.notifyDataSetChanged()
        }

        binding.totalAmount = viewModel.getTotal().toString()

        Snackbar.make(binding.addItemButton, "Item Added Successfully", Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Snackbar.make(binding.addItemButton, "Nothing Added", Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }

    private fun addGroceryItem() {
        val newFragment = NewItemDialogFragment.newInstance(R.string.add_new_item_dialog_title, null)
        newFragment.show(supportFragmentManager, "newItem")
    }

    private fun editGroceryItem(position: Int) {
        Log.d("GoBuy", "edit")
        val newFragment = NewItemDialogFragment.newInstance(R.string.edit_item_dialog_title,
                position)
        newFragment.show(supportFragmentManager, "newItem")
    }

    private fun deleteGroceryItem(position: Int) {
        Log.d("GoBuy", "delete")
        viewModel.removeItem(position)
        binding.totalAmount = viewModel.getTotal().toString()
        binding.rvGroceryList.adapter?.notifyDataSetChanged()
    }

}