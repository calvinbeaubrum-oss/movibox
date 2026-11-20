package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class CaptureActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f42517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DecoratedBarcodeView f42518b;

    public DecoratedBarcodeView a() {
        setContentView(R$layout.zxing_capture);
        return (DecoratedBarcodeView) findViewById(R$id.zxing_barcode_scanner);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f42518b = a();
        a aVar = new a(this, this.f42518b);
        this.f42517a = aVar;
        aVar.p(getIntent(), bundle);
        this.f42517a.l();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f42517a.u();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        return this.f42518b.onKeyDown(i11, keyEvent) || super.onKeyDown(i11, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f42517a.v();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.f42517a.w(i11, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f42517a.x();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f42517a.y(bundle);
    }
}
