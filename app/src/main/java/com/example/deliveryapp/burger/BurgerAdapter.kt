package com.example.deliveryapp.burger

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.deliveryapp.databinding.ItemBurgerBinding

class BurgerAdapter(private var list: ArrayList<Burger>) :
    Adapter<BurgerAdapter.BurgerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BurgerViewHolder {
        return BurgerViewHolder(
            ItemBurgerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BurgerViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class BurgerViewHolder(private val binding: ItemBurgerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(burger: Burger) {
            burger.image?.let { img ->
                binding.imgBurger.setImageResource(img)
            }
            binding.tvBurger.text = burger.name
        }

    }
}