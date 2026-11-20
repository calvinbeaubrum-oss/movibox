package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhhq {
    private final List zza;
    private final List zzb;

    public /* synthetic */ zzhhq(int i11, int i12, zzhhp zzhhpVar) {
        this.zza = zzhha.zzc(i11);
        this.zzb = zzhha.zzc(i12);
    }

    public final zzhhq zza(zzhhm zzhhmVar) {
        this.zzb.add(zzhhmVar);
        return this;
    }

    public final zzhhq zzb(zzhhm zzhhmVar) {
        this.zza.add(zzhhmVar);
        return this;
    }

    public final zzhhr zzc() {
        return new zzhhr(this.zza, this.zzb, null);
    }
}
