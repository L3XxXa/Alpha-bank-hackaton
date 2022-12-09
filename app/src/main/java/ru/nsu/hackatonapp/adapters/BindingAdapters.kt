package ru.nsu.hackatonapp.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.hackatonapp.network.json.card.Card

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Card>?){
    val adapter = recyclerView.adapter as CardsGridAdapter
    adapter.submitList(data)
}