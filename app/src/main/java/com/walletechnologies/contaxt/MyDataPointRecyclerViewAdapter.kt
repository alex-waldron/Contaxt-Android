package com.walletechnologies.contaxt

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.walletechnologies.contaxt.data.model.SensorData

import com.walletechnologies.contaxt.placeholder.PlaceholderContent.PlaceholderItem
import com.walletechnologies.contaxt.databinding.FragmentItemBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyDataPointRecyclerViewAdapter(
    private val values: List<SensorData>
) : RecyclerView.Adapter<MyDataPointRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.timestamp.toString()
        holder.idView.setOnClickListener {
            val action = DataPointFragmentDirections.actionDataPointFragmentToSensorDataDetailFragment(item)
            it.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemDate
        override fun toString(): String {
            return super.toString()
        }
    }

}