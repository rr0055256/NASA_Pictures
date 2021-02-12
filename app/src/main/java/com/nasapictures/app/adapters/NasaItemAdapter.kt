package com.nasapictures.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nasapictures.app.data.NasaItem
import com.nasapictures.app.databinding.ItemLayoutBinding

class NasaItemAdapter : ListAdapter<NasaItem,RecyclerView.ViewHolder>(NasaDiffCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NasaViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val nasaItem = getItem(position)
        (holder as NasaViewHolder).bind(nasaItem)
    }

    class NasaViewHolder(
        private val binding: ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.nasaItem?.let { nasaItem ->

                }
            }
        }

        fun bind(item: NasaItem) {
            binding.apply {
                nasaItem = item
                executePendingBindings()
            }
        }
    }
}



private class NasaDiffCallBack : DiffUtil.ItemCallback<NasaItem>(){
    override fun areItemsTheSame(oldItem: NasaItem, newItem: NasaItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NasaItem, newItem: NasaItem): Boolean {
        return oldItem == newItem
    }

}