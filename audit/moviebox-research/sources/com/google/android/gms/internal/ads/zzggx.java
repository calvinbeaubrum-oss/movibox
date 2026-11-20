package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzggx {
    private final ConcurrentMap zza;
    private final List zzb;
    private final zzggt zzc;
    private final Class zzd;
    private final zzgrw zze;

    public /* synthetic */ zzggx(ConcurrentMap concurrentMap, List list, zzggt zzggtVar, zzgrw zzgrwVar, Class cls, zzggw zzggwVar) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzggtVar;
        this.zzd = cls;
        this.zze = zzgrwVar;
    }

    public final zzggt zza() {
        return this.zzc;
    }

    public final zzgrw zzb() {
        return this.zze;
    }

    public final Class zzc() {
        return this.zzd;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze(byte[] bArr) {
        List list = (List) this.zza.get(new zzggv(bArr, null));
        return list != null ? list : Collections.emptyList();
    }

    public final boolean zzf() {
        return !this.zze.zza().isEmpty();
    }
}
