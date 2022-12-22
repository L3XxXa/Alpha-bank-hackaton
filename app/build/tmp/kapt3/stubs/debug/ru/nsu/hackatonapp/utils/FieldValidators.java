package ru.nsu.hackatonapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lru/nsu/hackatonapp/utils/FieldValidators;", "", "()V", "Companion", "app_debug"})
public final class FieldValidators {
    @org.jetbrains.annotations.NotNull()
    public static final ru.nsu.hackatonapp.utils.FieldValidators.Companion Companion = null;
    
    public FieldValidators() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lru/nsu/hackatonapp/utils/FieldValidators$Companion;", "", "()V", "checkEmail", "", "email", "", "checkFieldNotEmpty", "field", "checkLengthPassword", "password", "confirmPassword", "password1", "password2", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean checkFieldNotEmpty(@org.jetbrains.annotations.NotNull()
        java.lang.String field) {
            return false;
        }
        
        public final boolean checkLengthPassword(@org.jetbrains.annotations.NotNull()
        java.lang.String password) {
            return false;
        }
        
        public final boolean confirmPassword(@org.jetbrains.annotations.NotNull()
        java.lang.String password1, @org.jetbrains.annotations.NotNull()
        java.lang.String password2) {
            return false;
        }
        
        public final boolean checkEmail(@org.jetbrains.annotations.NotNull()
        java.lang.String email) {
            return false;
        }
    }
}