package ru.nsu.hackatonapp.domain.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lru/nsu/hackatonapp/domain/viewmodels/AddCardViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "addCardRepository", "Lru/nsu/hackatonapp/repository/AddCardRepository;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lru/nsu/hackatonapp/network/BaseResponse;", "Lru/nsu/hackatonapp/network/json/add_card/AddCardResponseJson;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "addCard", "", "userId", "", "name", "number", "priority", "app_debug"})
public final class AddCardViewModel extends androidx.lifecycle.ViewModel {
    private final ru.nsu.hackatonapp.repository.AddCardRepository addCardRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<ru.nsu.hackatonapp.network.BaseResponse<ru.nsu.hackatonapp.network.json.add_card.AddCardResponseJson>> result = null;
    
    public AddCardViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<ru.nsu.hackatonapp.network.BaseResponse<ru.nsu.hackatonapp.network.json.add_card.AddCardResponseJson>> getResult() {
        return null;
    }
    
    public final void addCard(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String priority) {
    }
}