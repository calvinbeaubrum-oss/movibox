package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfh {
    private long[] zza;

    public zzfh() {
        this(16);
    }

    public zzfh(int i11) {
        int i12 = 16;
        if (Integer.bitCount(16) != 1) {
            int iHighestOneBit = Integer.highestOneBit(15);
            i12 = iHighestOneBit + iHighestOneBit;
        }
        this.zza = new long[i12];
    }
}
