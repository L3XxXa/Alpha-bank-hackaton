package ru.nsu.hackatonapp.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lru/nsu/hackatonapp/network/ApiService;", "", "addCard", "Lretrofit2/Response;", "Lru/nsu/hackatonapp/network/json/add_card/AddCardResponseJson;", "addCardRequestJson", "Lru/nsu/hackatonapp/network/json/add_card/AddCardRequestJson;", "(Lru/nsu/hackatonapp/network/json/add_card/AddCardRequestJson;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "Lru/nsu/hackatonapp/network/json/change_password/ChangePasswordResponseJson;", "changePasswordRequestJson", "Lru/nsu/hackatonapp/network/json/change_password/ChangePasswordRequestJson;", "(Lru/nsu/hackatonapp/network/json/change_password/ChangePasswordRequestJson;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCards", "", "Lru/nsu/hackatonapp/network/json/card/Card;", "loginId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "Lru/nsu/hackatonapp/network/json/login/LoginResponseJson;", "loginRequestJson", "Lru/nsu/hackatonapp/network/json/login/LoginRequestJson;", "(Lru/nsu/hackatonapp/network/json/login/LoginRequestJson;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "Lru/nsu/hackatonapp/network/json/register/RegisterResponseJson;", "registerRequestJson", "Lru/nsu/hackatonapp/network/json/register/RegisterRequestJson;", "(Lru/nsu/hackatonapp/network/json/register/RegisterRequestJson;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/user/login")
    public abstract java.lang.Object loginUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.nsu.hackatonapp.network.json.login.LoginRequestJson loginRequestJson, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.nsu.hackatonapp.network.json.login.LoginResponseJson>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/user/register")
    public abstract java.lang.Object registerUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.nsu.hackatonapp.network.json.register.RegisterRequestJson registerRequestJson, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.nsu.hackatonapp.network.json.register.RegisterResponseJson>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PUT(value = "/api/user")
    public abstract java.lang.Object changePassword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.nsu.hackatonapp.network.json.change_password.ChangePasswordRequestJson changePasswordRequestJson, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.nsu.hackatonapp.network.json.change_password.ChangePasswordResponseJson>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/api/card")
    public abstract java.lang.Object addCard(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    ru.nsu.hackatonapp.network.json.add_card.AddCardRequestJson addCardRequestJson, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<ru.nsu.hackatonapp.network.json.add_card.AddCardResponseJson>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/api/cards")
    public abstract java.lang.Object getCards(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "id")
    java.lang.String loginId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<ru.nsu.hackatonapp.network.json.card.Card>> continuation);
}