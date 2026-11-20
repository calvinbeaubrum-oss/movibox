package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum WH {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    private final int We;

    WH(int i11) {
        this.We = i11;
    }

    public static WH sc(int i11) {
        if (i11 == 0) {
            return UNDEFINED;
        }
        if (i11 == 1) {
            return EXACTLY;
        }
        if (i11 == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }
}
