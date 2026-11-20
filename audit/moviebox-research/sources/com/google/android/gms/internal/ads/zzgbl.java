package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgbl extends zzgaa {
    final /* synthetic */ zzgbm zza;

    public zzgbl(zzgbm zzgbmVar) {
        this.zza = zzgbmVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i11) {
        zzfxe.zza(i11, this.zza.zzc, "index");
        int i12 = i11 + i11;
        Object obj = this.zza.zzb[i12];
        Objects.requireNonNull(obj);
        Object obj2 = this.zza.zzb[i12 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    public final boolean zzf() {
        return true;
    }
}
