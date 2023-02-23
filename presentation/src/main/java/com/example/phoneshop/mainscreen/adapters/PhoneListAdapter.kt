package com.example.phoneshop.mainscreen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.Phone
import com.example.phoneshop.R
import com.example.phoneshop.databinding.OnePhoneItemBinding

class PhoneListAdapter(
    private val listener: PhoneListListener
) : RecyclerView.Adapter<PhoneListAdapter.PhoneListViewHolder>() {

    private lateinit var phoneList: List<Phone>

    inner class PhoneListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val oneItemHotSalesBinding = OnePhoneItemBinding.bind(view)

        fun init(phone: Phone) {

            oneItemHotSalesBinding.apply {
                onePhoneName.text = phone.name
                onePhonePrice.text = phone.price.toString()
                Glide.with(itemView.context)
                    .load(phone.picture)
                    .into(onePhonePicture)
            }

            itemView.setOnClickListener {
                listener.phonePicked(phoneID = phone.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneListViewHolder {
        return PhoneListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.one_phone_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    override fun onBindViewHolder(holder: PhoneListViewHolder, position: Int) {
        holder.init(phoneList[position])
    }

    fun setList(list: List<Phone>) {
        phoneList = list
        notifyDataSetChanged()
    }
}

interface PhoneListListener {
    fun phonePicked(phoneID: Int)
}
