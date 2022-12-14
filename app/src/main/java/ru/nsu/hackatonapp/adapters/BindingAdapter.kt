package ru.nsu.hackatonapp.adapters

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.hackatonapp.network.json.card.Card
import ru.nsu.hackatonapp.utils.LogTags

@BindingAdapter("listData")
fun bindRecycleView(recyclerView: RecyclerView, data: List<Card>?) {
    val adapter = recyclerView.adapter as CardGridAdapter
    Log.d(LogTags.ACTIVITY_CARD, " data is $data")
    adapter.submitList(data)
}