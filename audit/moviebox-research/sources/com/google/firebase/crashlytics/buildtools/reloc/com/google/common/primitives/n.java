package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n {
    public static byte a(long j11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.h((j11 >> 8) == 0, "out of range: %s", j11);
        return (byte) j11;
    }

    public static int b(byte b11, byte b12) {
        return c(b11) - c(b12);
    }

    public static int c(byte b11) {
        return b11 & 255;
    }
}
