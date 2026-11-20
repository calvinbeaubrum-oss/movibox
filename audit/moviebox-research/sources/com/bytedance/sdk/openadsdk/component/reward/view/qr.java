package com.bytedance.sdk.openadsdk.component.reward.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends com.bytedance.sdk.openadsdk.core.ExN.zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc f27967sc;

    public qr(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar.f27911pc);
        this.f27967sc = scVar;
        if (scVar.dix != null || Build.VERSION.SDK_INT < 35) {
            return;
        }
        setFitsSystemWindows(true);
    }

    private void sc(View view, ViewGroup viewGroup) {
        if (view != null) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        RFEndCardBackUpLayout rFEndCardBackUpLayoutQj;
        pff.sc(this);
        if (this.f27967sc.f27913sc != 1 && (rFEndCardBackUpLayoutQj = pff.Qj()) != null) {
            addView(rFEndCardBackUpLayoutQj, new FrameLayout.LayoutParams(-1, -1));
        }
        sc(pff.Ol(), this);
        sc(pff.WH(), this);
    }
}
