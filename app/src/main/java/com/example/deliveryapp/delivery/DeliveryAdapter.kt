package com.example.deliveryapp.delivery

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.ItemDeliveryBinding

class DeliveryAdapter(
    private var list: ArrayList<Delivery>,
    private var context: Context
) :
    Adapter<DeliveryAdapter.DeliveryViewHolder>() {

    private val click = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
        return DeliveryViewHolder(
            ItemDeliveryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DeliveryViewHolder(private val binding: ItemDeliveryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(delivery: Delivery) {
            binding.TextViewDelivery.text = delivery.Categories

            itemView.setOnClickListener {
//               binding.cardView.setBackgroundColor(Color.YELLOW)
                val color = ContextCompat.getColor(context, R.color.group)
                binding.cardView.setCardBackgroundColor(color)
            }
        }
    }
}






