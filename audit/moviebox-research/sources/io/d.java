package io;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f67266a = true;

    public static int a(int i11) {
        if (f67266a || (i11 >= 0 && i11 < 32)) {
            return 1 << i11;
        }
        throw new AssertionError();
    }

    public static int b(int i11, int i12) {
        if (f67266a || (i11 <= i12 && i11 >= 0 && i12 < 32)) {
            return (0 - a(i11)) & ((-1) >>> (31 - i12));
        }
        throw new AssertionError();
    }

    public static int c(long j11) {
        if (j11 == 0 || j11 == 1) {
            return 1;
        }
        return ((j11 & (j11 - 1)) == 0 ? 0 : 1) + (63 - Long.numberOfLeadingZeros(j11));
    }
}
