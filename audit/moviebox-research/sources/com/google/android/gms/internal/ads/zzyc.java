package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzyc {
    public final int zza;
    public final zzcz zzb;
    public final int zzc;
    public final zzam zzd;

    public zzyc(int i11, zzcz zzczVar, int i12) {
        this.zza = i11;
        this.zzb = zzczVar;
        this.zzc = i12;
        this.zzd = zzczVar.zzb(i12);
    }

    public abstract int zzb();

    public abstract boolean zzc(zzyc zzycVar);
}
