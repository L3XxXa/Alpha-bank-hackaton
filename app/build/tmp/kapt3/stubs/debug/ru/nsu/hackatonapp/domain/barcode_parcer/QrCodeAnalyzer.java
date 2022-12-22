package ru.nsu.hackatonapp.domain.barcode_parcer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lru/nsu/hackatonapp/domain/barcode_parcer/QrCodeAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "context", "Landroid/content/Context;", "barcodeBoxView", "Lru/nsu/hackatonapp/domain/barcode_parcer/BarcodeBoxView;", "previewViewWidth", "", "previewViewHeight", "(Landroid/content/Context;Lru/nsu/hackatonapp/domain/barcode_parcer/BarcodeBoxView;FF)V", "scaleX", "scaleY", "adjustBoundingRect", "Landroid/graphics/RectF;", "rect", "Landroid/graphics/Rect;", "analyze", "", "image", "Landroidx/camera/core/ImageProxy;", "translateX", "x", "translateY", "y", "app_debug"})
public final class QrCodeAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
    private final android.content.Context context = null;
    private final ru.nsu.hackatonapp.domain.barcode_parcer.BarcodeBoxView barcodeBoxView = null;
    private final float previewViewWidth = 0.0F;
    private final float previewViewHeight = 0.0F;
    
    /**
     * This parameters will handle preview box scaling
     */
    private float scaleX = 1.0F;
    private float scaleY = 1.0F;
    
    public QrCodeAnalyzer(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    ru.nsu.hackatonapp.domain.barcode_parcer.BarcodeBoxView barcodeBoxView, float previewViewWidth, float previewViewHeight) {
        super();
    }
    
    private final float translateX(float x) {
        return 0.0F;
    }
    
    private final float translateY(float y) {
        return 0.0F;
    }
    
    private final android.graphics.RectF adjustBoundingRect(android.graphics.Rect rect) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"UnsafeOptInUsageError"})
    @java.lang.Override()
    public void analyze(@org.jetbrains.annotations.NotNull()
    androidx.camera.core.ImageProxy image) {
    }
}