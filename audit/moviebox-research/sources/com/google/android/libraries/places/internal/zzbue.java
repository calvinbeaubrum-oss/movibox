package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbue {
    private int zza;
    private final int[] zzb = new int[10];

    public final int zza(int i11) {
        return this.zzb[i11];
    }

    public final int zzb() {
        if ((this.zza & 2) != 0) {
            return this.zzb[1];
        }
        return -1;
    }

    public final int zzc(int i11) {
        return (this.zza & 32) != 0 ? this.zzb[5] : i11;
    }

    public final int zzd() {
        return Integer.bitCount(this.zza);
    }

    public final zzbue zze(int i11, int i12, int i13) {
        if (i11 >= 10) {
            return this;
        }
        this.zza = (1 << i11) | this.zza;
        this.zzb[i11] = i13;
        return this;
    }

    public final boolean zzf(int i11) {
        return ((1 << i11) & this.zza) != 0;
    }
}
