package com.example.a2022_mop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a2022_mop.databinding.RecyclerviewItemBinding

class ShopAdapter(private val dataSet: ArrayList<Item>): RecyclerView.Adapter<ShopAdapter.ViewHolder>() {
    override fun onCreateViewHolder (
        parent: ViewGroup,
        viewType: Int
    ) : ViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Item) {
            binding.itemName.text = data.name
            binding.itemDescription.text = data.description
            binding.itemImg.setImageResource(data.src)
        }
    }
}



