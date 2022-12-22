package ru.nsu.hackatonapp.domain.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0015H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lru/nsu/hackatonapp/domain/viewmodels/CardsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_cards", "Landroidx/lifecycle/MutableLiveData;", "", "Lru/nsu/hackatonapp/network/json/card/Card;", "_status", "Lru/nsu/hackatonapp/domain/viewmodels/Status;", "cards", "Landroidx/lifecycle/LiveData;", "getCards", "()Landroidx/lifecycle/LiveData;", "debugCards", "Ljava/util/ArrayList;", "getDebugCards", "()Ljava/util/ArrayList;", "setDebugCards", "(Ljava/util/ArrayList;)V", "status", "getStatus", "", "app_debug"})
public final class CardsViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<ru.nsu.hackatonapp.domain.viewmodels.Status> _status = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<ru.nsu.hackatonapp.domain.viewmodels.Status> status = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<ru.nsu.hackatonapp.network.json.card.Card>> _cards = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<ru.nsu.hackatonapp.network.json.card.Card>> cards = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<ru.nsu.hackatonapp.network.json.card.Card> debugCards;
    
    public CardsViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<ru.nsu.hackatonapp.domain.viewmodels.Status> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<ru.nsu.hackatonapp.network.json.card.Card>> getCards() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<ru.nsu.hackatonapp.network.json.card.Card> getDebugCards() {
        return null;
    }
    
    public final void setDebugCards(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<ru.nsu.hackatonapp.network.json.card.Card> p0) {
    }
    
    private final void getCards() {
    }
}