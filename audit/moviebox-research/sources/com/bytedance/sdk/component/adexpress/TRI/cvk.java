package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cvk extends LinearLayout {
    private LinearLayout ExN;
    private com.bytedance.adsdk.pFF.TRI TRI;
    private sc We;
    private com.bytedance.sdk.component.utils.YIK pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.We.WH f26707qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private TextView f26708sc;
    private TextView zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
    }

    public cvk(@NonNull Context context, View view, com.bytedance.sdk.component.adexpress.dynamic.We.WH wh2) {
        super(context);
        this.f26707qr = wh2;
        sc(context, view);
    }

    private void sc(Context context, View view) {
        setClipChildren(false);
        addView(view);
        this.ExN = (LinearLayout) findViewById(2097610722);
        this.f26708sc = (TextView) findViewById(2097610719);
        this.zY = (TextView) findViewById(2097610718);
        com.bytedance.adsdk.pFF.TRI tri = (com.bytedance.adsdk.pFF.TRI) findViewById(2097610706);
        this.TRI = tri;
        tri.setAnimation("lottie_json/twist_multi_angle.json");
        this.TRI.setImageAssetsFolder("images/");
        this.TRI.sc(true);
    }

    public TextView getTopTextView() {
        return this.f26708sc;
    }

    public LinearLayout getWriggleLayout() {
        return this.ExN;
    }

    public View getWriggleProgressIv() {
        return this.TRI;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.pFF == null) {
                this.pFF = new com.bytedance.sdk.component.utils.YIK(getContext().getApplicationContext(), 2);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.TRI.cvk.2
            };
            com.bytedance.sdk.component.adexpress.dynamic.We.WH wh2 = this.f26707qr;
            if (wh2 != null) {
                wh2.zY();
                this.f26707qr.ExN();
                this.f26707qr.TRI();
                this.f26707qr.Qj();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.adsdk.pFF.TRI tri = this.TRI;
            if (tri != null) {
                tri.ExN();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
    }

    public void sc() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.cvk.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cvk.this.TRI.sc();
                } catch (Throwable unused) {
                }
            }
        }, 500L);
    }

    public void setOnShakeViewListener(sc scVar) {
        this.We = scVar;
    }

    public void setShakeText(String str) {
        this.zY.setText(str);
    }
}
