package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgbo extends zzgaa {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzgbo(Object[] objArr, int i11, int i12) {
        this.zza = objArr;
        this.zzb = i11;
        this.zzc = i12;
    }

    @Override // java.util.List
    public final Object get(int i11) {
        zzfxe.zza(i11, this.zzc, "index");
        Object obj = this.zza[i11 + i11 + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    public final boolean zzf() {
        return true;
    }
}
