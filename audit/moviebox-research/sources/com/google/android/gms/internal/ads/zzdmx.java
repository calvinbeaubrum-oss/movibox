package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdmx {

    @Nullable
    private zzbjj zza;

    public zzdmx(zzdmj zzdmjVar) {
        this.zza = zzdmjVar;
    }

    @Nullable
    public final synchronized zzbjj zza() {
        return this.zza;
    }

    public final synchronized void zzb(@Nullable zzbjj zzbjjVar) {
        this.zza = zzbjjVar;
    }
}
