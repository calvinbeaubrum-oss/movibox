package com.bytedance.adsdk.pFF.TRI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private static float pFF(float f11) {
        return f11 <= 0.04045f ? f11 / 12.92f : (float) Math.pow((f11 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float sc(float f11) {
        return f11 <= 0.0031308f ? f11 * 12.92f : (float) ((Math.pow(f11, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int sc(float f11, int i11, int i12) {
        if (i11 == i12) {
            return i11;
        }
        float f12 = ((i11 >> 24) & 255) / 255.0f;
        float fPFF = pFF(((i11 >> 16) & 255) / 255.0f);
        float fPFF2 = pFF(((i11 >> 8) & 255) / 255.0f);
        float fPFF3 = pFF((i11 & 255) / 255.0f);
        float fPFF4 = pFF(((i12 >> 16) & 255) / 255.0f);
        float f13 = f12 + (((((i12 >> 24) & 255) / 255.0f) - f12) * f11);
        float fPFF5 = fPFF2 + ((pFF(((i12 >> 8) & 255) / 255.0f) - fPFF2) * f11);
        float fPFF6 = fPFF3 + (f11 * (pFF((i12 & 255) / 255.0f) - fPFF3));
        return (Math.round(sc(fPFF + ((fPFF4 - fPFF) * f11)) * 255.0f) << 16) | (Math.round(f13 * 255.0f) << 24) | (Math.round(sc(fPFF5) * 255.0f) << 8) | Math.round(sc(fPFF6) * 255.0f);
    }
}
