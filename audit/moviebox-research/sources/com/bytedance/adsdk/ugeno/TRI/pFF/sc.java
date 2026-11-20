package com.bytedance.adsdk.ugeno.TRI.pFF;

import android.view.View;
import com.bytedance.adsdk.ugeno.Qj.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements zY.ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final float f26361sc = 0.8f;
    final float pFF = 0.5f;

    @Override // com.bytedance.adsdk.ugeno.Qj.zY.ExN
    public void sc(View view, float f11) {
        float f12 = ((f11 < 0.0f ? 0.19999999f : -0.19999999f) * f11) + 1.0f;
        float f13 = (f11 * (f11 < 0.0f ? 0.5f : -0.5f)) + 1.0f;
        if (f11 < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f12);
        view.setScaleY(f12);
        view.setAlpha(Math.abs(f13));
    }
}
