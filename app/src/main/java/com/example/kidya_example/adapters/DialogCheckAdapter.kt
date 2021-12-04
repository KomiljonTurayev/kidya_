package com.example.kidya_example.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kidya_example.R
import com.example.kidya_example.network.dto.MockData
import kotlinx.android.synthetic.main.item_check_text.view.*

class DialogCheckAdapter : RecyclerView.Adapter<DialogCheckAdapter.ViewHolder>() {

    val list = MockData.getItemMaterialList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image = itemView.imageCheck

        //
        var i = 0

        init {
//            if (check) {

            itemView.setOnClickListener {
                Log.d("ttt", " itemView.setOnClickListener   ")

//                i = (i + 1) % 2
//                if (i == 1) {
//                    image.visibility = View.INVISIBLE
//                } else {
//                    image.visibility = View.VISIBLE
//                    i = 0
//
//                }


                when {
                    last != -1 -> {
                        image.visibility = View.INVISIBLE
                        Toast.makeText(itemView.context, "$adapterPosition", Toast.LENGTH_SHORT).show()
                        notifyDataSetChanged()
                    }
                    last == position -> {
                        image.visibility = View.INVISIBLE
                        last = -1
                        Toast.makeText(itemView.context, "$adapterPosition", Toast.LENGTH_SHORT).show()
                        notifyDataSetChanged()
                    }
                    else -> {
                        image.visibility = View.VISIBLE
                        last = position
                        Toast.makeText(itemView.context, "$adapterPosition", Toast.LENGTH_SHORT).show()
                        notifyDataSetChanged()
                    }
                }
            }
        }


        fun bind(item: MockData.ItemDialog) {
            itemView.apply {
                val d = item

//                shop.text = d.shopName

//                val d = item
                textCheck?.text = d.item2
//                image?.backgroundTintList = ColorStateList.valueOf(Color.parseColor(d.item2))
//                image2?.backgroundTintList = ColorStateList.valueOf(Color.parseColor(d.item2))
                Log.d("ttt", "${item}")

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_check_text, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    companion object {
        var last = -1
    }
}