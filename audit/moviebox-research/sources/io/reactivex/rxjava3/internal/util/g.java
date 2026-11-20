package io.reactivex.rxjava3.internal.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g {
    public static int a(int i11) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i11 - 1));
    }
}
