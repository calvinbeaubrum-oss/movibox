package com.google.api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public enum JwtLocation$InCase {
    HEADER(1),
    QUERY(2),
    IN_NOT_SET(0);

    private final int value;

    JwtLocation$InCase(int i11) {
        this.value = i11;
    }

    public static JwtLocation$InCase forNumber(int i11) {
        if (i11 == 0) {
            return IN_NOT_SET;
        }
        if (i11 == 1) {
            return HEADER;
        }
        if (i11 != 2) {
            return null;
        }
        return QUERY;
    }

    @Deprecated
    public static JwtLocation$InCase valueOf(int i11) {
        return forNumber(i11);
    }

    public int getNumber() {
        return this.value;
    }
}
