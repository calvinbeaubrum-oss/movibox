package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbuc {
    private final zzbuc[] zza;
    private final int zzb;
    private final int zzc;

    public zzbuc() {
        this.zza = new zzbuc[256];
        this.zzb = 0;
        this.zzc = 0;
    }

    public zzbuc(int i11, int i12) {
        this.zza = null;
        this.zzb = i11;
        int i13 = i12 & 7;
        this.zzc = i13 == 0 ? 8 : i13;
    }
}
