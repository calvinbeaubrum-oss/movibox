package com.bytedance.sdk.openadsdk.zY;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends LinearLayout {
    private Qj pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final FilterWord f28823sc;
    private final WH zY;

    public qr(Context context, FilterWord filterWord, WH wh2) {
        super(context);
        setOrientation(1);
        this.f28823sc = filterWord;
        this.zY = wh2;
        sc();
    }

    private void pFF() {
        this.pFF = new Qj(getContext(), this.zY);
        new LinearLayout.LayoutParams(-1, -2);
        this.pFF.sc(this.f28823sc.getOptions());
        addView(this.pFF);
    }

    private void sc() {
        zY();
        pFF();
    }

    private void zY() {
        String name = this.f28823sc.getName();
        com.bytedance.sdk.openadsdk.core.ExN.Qj qj2 = new com.bytedance.sdk.openadsdk.core.ExN.Qj(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = kX.zY(getContext(), 12.0f);
        layoutParams.gravity = 17;
        qj2.setGravity(17);
        qj2.setText(name);
        qj2.setTextColor(Color.argb(85, 22, 24, 35));
        qj2.setTextSize(this.zY.Ol() ? 14 : 10);
        addView(qj2, layoutParams);
    }
}
