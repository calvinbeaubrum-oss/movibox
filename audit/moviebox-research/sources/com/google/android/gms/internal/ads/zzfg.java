package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfg {
    private int zza;
    private long[] zzb;

    public zzfg() {
        this(32);
    }

    public zzfg(int i11) {
        this.zzb = new long[32];
    }

    public final int zza() {
        return this.zza;
    }

    public final long zzb(int i11) {
        if (i11 >= 0 && i11 < this.zza) {
            return this.zzb[i11];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i11 + ", size is " + this.zza);
    }

    public final void zzc(long j11) {
        int i11 = this.zza;
        long[] jArr = this.zzb;
        if (i11 == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i11 + i11);
        }
        long[] jArr2 = this.zzb;
        int i12 = this.zza;
        this.zza = i12 + 1;
        jArr2[i12] = j11;
    }
}
