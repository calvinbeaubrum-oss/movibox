package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX {
    public static long sc(float f11, float f12) {
        return ((long) Float.floatToRawIntBits(f12)) | (((long) Float.floatToRawIntBits(f11)) << 32);
    }

    public static long sc(int i11, int i12) {
        return sc(i11, i12);
    }
}
