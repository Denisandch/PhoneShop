package com.example.phoneshop.mainscreen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.domain.model.Phone
import com.example.phoneshop.R
import com.example.phoneshop.databinding.OnePhoneItemBinding

class PhoneListAdapter(
    private val listener: PhoneListListener
) : ListAdapter<Phone, PhoneListAdapter.PhoneListViewHolder>(DiffCallback) {

    inner class PhoneListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val oneItemHotSalesBinding = OnePhoneItemBinding.bind(view)

        fun init(phone: Phone) {

            oneItemHotSalesBinding.apply {
                onePhoneName.text = phone.name
                onePhonePrice.text = phone.price.toString()

                //onePhonePicture.load(phone.picture)
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


    override fun onBindViewHolder(holder: PhoneListViewHolder, position: Int) {
        holder.init(getItem(position))
    }

    object DiffCallback : DiffUtil.ItemCallback<Phone>() {

        override fun areItemsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem.name == newItem.name
        }

    }

}

interface PhoneListListener {
    fun phonePicked(phoneID: Int)
}
