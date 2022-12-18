package ru.nsu.hackatonapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.adapters.CardViewBindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.hackatonapp.databinding.GridViewItemBinding
import ru.nsu.hackatonapp.network.json.card.Card
import ru.nsu.hackatonapp.utils.LogTags

class CardGridAdapter : ListAdapter<Card, CardGridAdapter.CardViewHolder>(DiffCallback) {
    class CardViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            binding.cardName = card
            binding.executePendingBindings()
            binding.cardContainer.setOnClickListener {
                Log.d(LogTags.ACTIVITY_CARD, card.name)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
            return oldItem.number == newItem.number
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = getItem(position)
        holder.bind(cardItem)
    }

}

