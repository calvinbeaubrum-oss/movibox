package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$layout;
import com.google.zxing.client.android.R$styleable;
import com.google.zxing.k;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.journeyapps.barcodescanner.camera.i;
import fm.f;
import fm.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xn.c;
import xn.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class DecoratedBarcodeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BarcodeView f42519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewfinderView f42520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f42521c;

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements xn.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public xn.a f42522a;

        public b(xn.a aVar) {
            this.f42522a = aVar;
        }

        @Override // xn.a
        public void a(List<k> list) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.this.f42520b.addPossibleResultPoint(it.next());
            }
            this.f42522a.a(list);
        }

        @Override // xn.a
        public void b(c cVar) {
            this.f42522a.b(cVar);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        b();
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(attributeSet);
    }

    public final void b() {
        c(null);
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_view);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.zxing_view_zxing_scanner_layout, R$layout.zxing_barcode_scanner);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R$id.zxing_barcode_surface);
        this.f42519a = barcodeView;
        if (barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        barcodeView.p(attributeSet);
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R$id.zxing_viewfinder_view);
        this.f42520b = viewfinderView;
        if (viewfinderView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        viewfinderView.setCameraPreview(this.f42519a);
        this.f42521c = (TextView) findViewById(R$id.zxing_status_view);
    }

    public void changeCameraParameters(i iVar) {
        this.f42519a.changeCameraParameters(iVar);
    }

    public void decodeContinuous(xn.a aVar) {
        this.f42519a.decodeContinuous(new b(aVar));
    }

    public void decodeSingle(xn.a aVar) {
        this.f42519a.decodeSingle(new b(aVar));
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R$id.zxing_barcode_surface);
    }

    public CameraSettings getCameraSettings() {
        return this.f42519a.getCameraSettings();
    }

    public xn.k getDecoderFactory() {
        return this.f42519a.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.f42521c;
    }

    public ViewfinderView getViewFinder() {
        return this.f42520b;
    }

    public void initializeFromIntent(Intent intent) {
        int intExtra;
        Set<BarcodeFormat> setA = f.a(intent);
        Map<DecodeHintType, ?> mapA = g.a(intent);
        CameraSettings cameraSettings = new CameraSettings();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            cameraSettings.i(intExtra);
        }
        if (intent.hasExtra("TORCH_ENABLED") && intent.getBooleanExtra("TORCH_ENABLED", false)) {
            setTorchOn();
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra("SCAN_TYPE", 0);
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new com.google.zxing.f().e(mapA);
        this.f42519a.setCameraSettings(cameraSettings);
        this.f42519a.setDecoderFactory(new n(setA, mapA, stringExtra2, intExtra2));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 == 24) {
            setTorchOn();
            return true;
        }
        if (i11 == 25) {
            setTorchOff();
            return true;
        }
        if (i11 == 27 || i11 == 80) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void pause() {
        this.f42519a.pause();
    }

    public void pauseAndWait() {
        this.f42519a.pauseAndWait();
    }

    public void resume() {
        this.f42519a.resume();
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f42519a.setCameraSettings(cameraSettings);
    }

    public void setDecoderFactory(xn.k kVar) {
        this.f42519a.setDecoderFactory(kVar);
    }

    public void setStatusText(String str) {
        TextView textView = this.f42521c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTorchListener(a aVar) {
    }

    public void setTorchOff() {
        this.f42519a.setTorch(false);
    }

    public void setTorchOn() {
        this.f42519a.setTorch(true);
    }
}
