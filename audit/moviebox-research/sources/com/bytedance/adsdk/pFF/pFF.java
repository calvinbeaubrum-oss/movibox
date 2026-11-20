package com.bytedance.adsdk.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    static final int[] f26169sc = new int[0];
    static final long[] pFF = new long[0];
    static final Object[] zY = new Object[0];

    public static int sc(int[] iArr, int i11, int i12) {
        int i13 = i11 - 1;
        int i14 = 0;
        while (i14 <= i13) {
            int i15 = (i14 + i13) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i12) {
                i14 = i15 + 1;
            } else {
                if (i16 <= i12) {
                    return i15;
                }
                i13 = i15 - 1;
            }
        }
        return ~i14;
    }
}
