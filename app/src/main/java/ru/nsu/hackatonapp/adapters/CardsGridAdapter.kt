package ru.nsu.hackatonapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.hackatonapp.databinding.GridViewItemBinding
import ru.nsu.hackatonapp.network.json.card.Card
import ru.nsu.hackatonapp.utils.LogTags

class CardsGridAdapter : ListAdapter<Card, CardsGridAdapter.CardsGridViewHolder>(DiffCallback) {
    class CardsGridViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindingCard(card: Card){
            binding.cardName = card
            binding.executePendingBindings()
        }
        fun onClickListener(){
            binding.cardContainer.setOnClickListener {
                Log.d(LogTags.ACTIVITY_CARD, "CLICKED")
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsGridViewHolder {
        return CardsGridViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CardsGridViewHolder, position: Int) {
        val card = getItem(position)
        holder.bindingCard(card)
        holder.onClickListener()

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Card>(){
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.number == newItem.number
        }
    }
}