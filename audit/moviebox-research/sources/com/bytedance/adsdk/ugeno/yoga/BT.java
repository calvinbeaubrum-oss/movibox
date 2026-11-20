package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum BT {
    STATIC(0, "static"),
    RELATIVE(1, "relative"),
    ABSOLUTE(2, "absolute");

    private final String ExN;
    private final int We;

    BT(int i11, String str) {
        this.We = i11;
        this.ExN = str;
    }

    public static BT sc(int i11) {
        if (i11 == 0) {
            return STATIC;
        }
        if (i11 == 1) {
            return RELATIVE;
        }
        if (i11 == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }

    public static BT sc(String str) {
        str.hashCode();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int sc() {
        return this.We;
    }
}
