package ru.nsu.hackatonapp.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0014J-\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lru/nsu/hackatonapp/activities/BarcodeScannerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "barcodeBoxView", "Lru/nsu/hackatonapp/domain/barcode_parcer/BarcodeBoxView;", "binding", "Lru/nsu/hackatonapp/databinding/ActivityBarcodeScannerBinding;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "checkCameraPermission", "", "checkIfCameraPermissionIsGranted", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "startCamera", "app_debug"})
public final class BarcodeScannerActivity extends androidx.appcompat.app.AppCompatActivity {
    private java.util.concurrent.ExecutorService cameraExecutor;
    private ru.nsu.hackatonapp.domain.barcode_parcer.BarcodeBoxView barcodeBoxView;
    private ru.nsu.hackatonapp.databinding.ActivityBarcodeScannerBinding binding;
    
    public BarcodeScannerActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    /**
     * This function is executed once the user has granted or denied the missing permission
     */
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    /**
     * This function is responsible to request the required CAMERA permission
     */
    private final void checkCameraPermission() {
    }
    
    /**
     * This function will check if the CAMERA permission has been granted.
     * If so, it will call the function responsible to initialize the camera preview.
     * Otherwise, it will raise an alert.
     */
    private final void checkIfCameraPermissionIsGranted() {
    }
    
    /**
     * This function is responsible for the setup of the camera preview and the image analyzer.
     */
    private final void startCamera() {
    }
}