package ru.nsu.hackatonapp.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lru/nsu/hackatonapp/adapters/CardGridAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/nsu/hackatonapp/network/json/card/Card;", "Lru/nsu/hackatonapp/adapters/CardGridAdapter$CardViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CardViewHolder", "DiffCallback", "app_debug"})
public final class CardGridAdapter extends androidx.recyclerview.widget.ListAdapter<ru.nsu.hackatonapp.network.json.card.Card, ru.nsu.hackatonapp.adapters.CardGridAdapter.CardViewHolder> {
    @org.jetbrains.annotations.NotNull()
    public static final ru.nsu.hackatonapp.adapters.CardGridAdapter.DiffCallback DiffCallback = null;
    
    public CardGridAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ru.nsu.hackatonapp.adapters.CardGridAdapter.CardViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ru.nsu.hackatonapp.adapters.CardGridAdapter.CardViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lru/nsu/hackatonapp/adapters/CardGridAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/nsu/hackatonapp/databinding/GridViewItemBinding;", "(Lru/nsu/hackatonapp/databinding/GridViewItemBinding;)V", "bind", "", "card", "Lru/nsu/hackatonapp/network/json/card/Card;", "app_debug"})
    public static final class CardViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private ru.nsu.hackatonapp.databinding.GridViewItemBinding binding;
        
        public CardViewHolder(@org.jetbrains.annotations.NotNull()
        ru.nsu.hackatonapp.databinding.GridViewItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        ru.nsu.hackatonapp.network.json.card.Card card) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lru/nsu/hackatonapp/adapters/CardGridAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/nsu/hackatonapp/network/json/card/Card;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<ru.nsu.hackatonapp.network.json.card.Card> {
        
        private DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        ru.nsu.hackatonapp.network.json.card.Card oldItem, @org.jetbrains.annotations.NotNull()
        ru.nsu.hackatonapp.network.json.card.Card newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        ru.nsu.hackatonapp.network.json.card.Card oldItem, @org.jetbrains.annotations.NotNull()
        ru.nsu.hackatonapp.network.json.card.Card newItem) {
            return false;
        }
    }
}