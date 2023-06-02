package com.example.deliveryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryapp.adres.AdresDetails
import com.example.deliveryapp.adres.AdresDetailsAdapter
import com.example.deliveryapp.burger.Burger
import com.example.deliveryapp.burger.BurgerAdapter
import com.example.deliveryapp.databinding.ActivityMainBinding

import com.example.deliveryapp.delivery.Delivery
import com.example.deliveryapp.delivery.DeliveryAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<Burger>()
    private var listDelivery = arrayListOf<Delivery>()
    private var listBurgerCraze = arrayListOf<AdresDetails>()
    private lateinit var adapter: AdresDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        loadData()
        LayoutManagerBurger()
        productCategories()
        LayoutManagerDelivery()
        BurgerCraze()
    }

    private fun BurgerCraze() {
        listBurgerCraze.add(AdresDetails(R.drawable.img_2, "Burger Craze", "15-20"))
        listBurgerCraze.add(AdresDetails(R.drawable.vegetarian_pizza, "Vegetarian Pizza", "10-15"))
        listBurgerCraze.add(AdresDetails(R.drawable.img_2, "Burger Craze", "15-20"))
        val adapter = AdresDetailsAdapter(listBurgerCraze, this::onClick)
        binding.rvMenu.adapter = adapter
    }

    private fun onClick(adresDetails: AdresDetails) {
        val intent = Intent(this,DetailsActivity::class.java)
        intent.putExtra("Craze",adresDetails.header)
        intent.putExtra("timer",adresDetails.timer)
        intent.putExtra("image",adresDetails.image)
        startActivity(intent)
    }

    private fun loadData() {
        list.add(Burger("Takeaways", R.drawable.burger))
        list.add(Burger("Grocery", R.drawable.grocery))
        list.add(Burger("Convenience", R.drawable.convenience))
        list.add(Burger("Pharmacy", R.drawable.pharmacy))
    }

//    private fun SetTextColor() {
//        class ButtonAdapter (
//            private val context: Context,
//            private val buttonList: ArrayList<Button>,
//            var onClick: (Button) -> Unit) : RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>(){
//
//            private var selectedPosition = RecyclerView.NO_POSITION
//
//            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
//                return ButtonViewHolder(ItemButtonBinding.inflate(
//                    LayoutInflater.from(parent.context), parent, false))
//            }
//
//            override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
//                holder.onBind(buttonList[position])
//
//                if (position == selectedPosition) {
//                    val selectedColor = ContextCompat.getColor(context, R.color.yellow)
//
//                    holder.binding.textForButton.apply {
//                        setBackgroundColor(selectedColor)
//                        setTextColor(ContextCompat.getColor(context, R.color.white_100))
//                    }
//                    holder.itemView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.yellow)
//
//
//                } else {
//                    val defaultColor = ContextCompat.getColor(context, R.color.white_100)
//                    holder.binding.textForButton.apply {
//                        setBackgroundColor(defaultColor)
//                        setTextColor(ContextCompat.getColor(context, R.color.green))
//                    }
//                    holder.itemView.backgroundTintList = ContextCompat.getColorStateList(context, R.color.white_100)
//                }
//
//                holder.itemView.setOnClickListener {
//                    onClick(buttonList[position])
//
//                    val previousSelectedPosition = selectedPosition
//                    selectedPosition = holder.adapterPosition
//
//                    if (previousSelectedPosition != RecyclerView.NO_POSITION) {
//                        notifyItemChanged(previousSelectedPosition)
//                    }
//
//                    notifyItemChanged(selectedPosition)
//
//                }
//
//            }
//
//            override fun getItemCount(): Int {
//                return buttonList.size
//            }
//
//            inner class ButtonViewHolder(val binding: ItemButtonBinding)
//                : RecyclerView.ViewHolder(binding.root) {
//
//                fun onBind(button: Button) {
//                    binding.textForButton.setText(button.text)
//                    binding.iconDelivery.isVisible= button.hasIcon
//                }
//            }
//        }
//    }

    private fun LayoutManagerDelivery() {
        val adapter = DeliveryAdapter(listDelivery, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.RecycleDelivery.layoutManager = layoutManager
        binding.RecycleDelivery.adapter = adapter
    }

    private fun LayoutManagerBurger() {
        val adapter = BurgerAdapter(list)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvBurger.layoutManager = layoutManager
        binding.rvBurger.adapter = adapter
    }

    private fun productCategories() {
        listDelivery.add(Delivery("Delivery", R.drawable.group))
        listDelivery.add(Delivery("Pichup"))
        listDelivery.add(Delivery("Catering"))
        listDelivery.add(Delivery("Curbside"))
    }


}




