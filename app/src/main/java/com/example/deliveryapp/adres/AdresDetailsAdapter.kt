package com.example.deliveryapp.adres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.deliveryapp.databinding.ItemMenuBinding

class AdresDetailsAdapter(
    private var list: ArrayList<AdresDetails>,
    private var onClick: (adresDetailes: AdresDetails) -> Unit
) :
    Adapter<AdresDetailsAdapter.AdresViewHilder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdresViewHilder {
        return AdresViewHilder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdresViewHilder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class AdresViewHilder(private val binding: ItemMenuBinding) : ViewHolder(binding.root) {

        fun onBind(adresDetails: AdresDetails) {
            adresDetails.image?.let { binding.ImageViewBurger.setImageResource(it) }
            binding.TextViewBurgerCraze.text = adresDetails.header
            binding.TextViewAdresKm.text = adresDetails.timer

            itemView.setOnClickListener {
                onClick(adresDetails)
            }
        }

    }

}