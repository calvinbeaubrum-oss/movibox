package com.bytedance.sdk.openadsdk.core.UFX.pFF.sc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.adsdk.ugeno.Ol.pFF.sc {
    private final com.bytedance.adsdk.ugeno.Ol.pFF.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.adsdk.ugeno.Ol.pFF.sc f28289sc;

    public sc(Context context) {
        super(context);
        com.bytedance.adsdk.ugeno.Ol.pFF.sc scVar = new com.bytedance.adsdk.ugeno.Ol.pFF.sc(context);
        this.f28289sc = scVar;
        addView(scVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.adsdk.ugeno.Ol.pFF.sc scVar2 = new com.bytedance.adsdk.ugeno.Ol.pFF.sc(context);
        this.pFF = scVar2;
        scVar2.setBackgroundColor(0);
        addView(scVar2, new FrameLayout.LayoutParams(-1, -1));
    }

    public com.bytedance.adsdk.ugeno.Ol.pFF.sc getVideoView() {
        return this.f28289sc;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.pFF.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.pFF.setOnTouchListener(onTouchListener);
    }
}
