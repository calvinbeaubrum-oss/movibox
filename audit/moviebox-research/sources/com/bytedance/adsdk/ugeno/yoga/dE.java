package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum dE {
    NO_WRAP(0, "nowrap"),
    WRAP(1, "wrap"),
    WRAP_REVERSE(2, "wrap_reverse");

    private final String ExN;
    private final int We;

    dE(int i11, String str) {
        this.We = i11;
        this.ExN = str;
    }

    public static dE sc(int i11) {
        if (i11 == 0) {
            return NO_WRAP;
        }
        if (i11 == 1) {
            return WRAP;
        }
        if (i11 == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i11)));
    }

    public static dE sc(String str) {
        str.hashCode();
        switch (str) {
            case "nowrap":
                return NO_WRAP;
            case "wrap":
                return WRAP;
            case "wrap_reverse":
                return WRAP_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(str));
        }
    }

    public int sc() {
        return this.We;
    }
}
