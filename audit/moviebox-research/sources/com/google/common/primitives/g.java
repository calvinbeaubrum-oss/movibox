package com.google.common.primitives;

import com.google.common.base.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static byte a(long j11) {
        m.i((j11 >> 8) == 0, "out of range: %s", j11);
        return (byte) j11;
    }

    public static int b(byte b11, byte b12) {
        return c(b11) - c(b12);
    }

    public static int c(byte b11) {
        return b11 & 255;
    }
}
