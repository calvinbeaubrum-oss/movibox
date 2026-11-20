package io;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class j {
    static {
        int i11 = k.f67301a;
    }

    public static int a(long j11) {
        int i11 = (int) (j11 & 4294967295L);
        return (i11 >>> 1) ^ (-(i11 & 1));
    }

    public static int b(long j11) {
        return i.a(((Long.numberOfLeadingZeros(j11 | 1) ^ 63) * 9) + 73, 64);
    }

    public static long c(int i11) {
        return fo.c.a((i11 >> 31) ^ (i11 << 1));
    }

    public static long d(long j11) {
        return (j11 >> 63) ^ (j11 << 1);
    }
}
