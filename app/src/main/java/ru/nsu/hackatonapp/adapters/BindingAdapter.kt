package ru.nsu.hackatonapp.adapters

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.hackatonapp.network.json.card.Card
import ru.nsu.hackatonapp.utils.LogTags

@BindingAdapter("listData")
fun bindRecycleView(recyclerView: RecyclerView, data: List<Card>?) {
    val list = ArrayList<Card>()
    list.add(Card("123", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))
    list.add(Card("228", "123", "123", "123", "123"))

    val adapter = recyclerView.adapter as CardGridAdapter
    adapter.submitList(list)
}