package com.bytedance.sdk.openadsdk.core.Qj.sc;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public static float pFF(Context context) {
        return kX.We(context, kX.WH(context));
    }

    public static float sc(Context context) {
        return kX.We(context, kX.Ol(context));
    }

    @NonNull
    public static Pair<Float, Float> sc(Window window, int i11) {
        View decorView = window.getDecorView();
        float[] fArrSc = {decorView.getWidth() - (decorView.getPaddingLeft() * 2), decorView.getHeight() - (decorView.getPaddingTop() * 2)};
        fArrSc[0] = kX.We(window.getContext(), fArrSc[0]);
        float fWe = kX.We(window.getContext(), fArrSc[1]);
        fArrSc[1] = fWe;
        if (fArrSc[0] < 10.0f || fWe < 10.0f) {
            fArrSc = sc(window.getContext(), kX.We(window.getContext(), kX.sc()), i11);
        }
        float fMax = Math.max(fArrSc[0], fArrSc[1]);
        float fMin = Math.min(fArrSc[0], fArrSc[1]);
        if (i11 == 1) {
            fArrSc[0] = fMin;
            fArrSc[1] = fMax;
        } else {
            fArrSc[0] = fMax;
            fArrSc[1] = fMin;
        }
        return new Pair<>(Float.valueOf(fArrSc[0]), Float.valueOf(fArrSc[1]));
    }

    private static float[] sc(Context context, int i11, int i12) {
        float fSc = sc(context);
        float fPFF = pFF(context);
        if ((i12 == 1) != (fSc > fPFF)) {
            float f11 = fSc + fPFF;
            fPFF = f11 - fPFF;
            fSc = f11 - fPFF;
        }
        if (i12 == 1) {
            fSc -= i11;
        } else {
            fPFF -= i11;
        }
        return new float[]{fPFF, fSc};
    }
}
