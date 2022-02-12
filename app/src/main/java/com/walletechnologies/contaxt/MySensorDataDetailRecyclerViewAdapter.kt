package com.walletechnologies.contaxt

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.walletechnologies.contaxt.placeholder.PlaceholderContent.PlaceholderItem
import com.walletechnologies.contaxt.databinding.SensorDetailItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MySensorDataDetailRecyclerViewAdapter(
    private val values: Array<Pair<String, String>>
) : RecyclerView.Adapter<MySensorDataDetailRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            SensorDetailItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.first
        holder.contentView.text = item.second
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: SensorDetailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}