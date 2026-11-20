package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzayv {
    private zzayj zza = zzayj.zza;
    private int zzb;
    private boolean zzc;

    public final zzayv zza(zzayj zzayjVar) {
        zzmt.zzc(zzayjVar, "callOptions cannot be null");
        this.zza = zzayjVar;
        return this;
    }

    public final zzayv zzb(boolean z11) {
        this.zzc = z11;
        return this;
    }

    public final zzayv zzc(int i11) {
        this.zzb = i11;
        return this;
    }

    public final zzayw zzd() {
        return new zzayw(this.zza, this.zzb, this.zzc);
    }
}
