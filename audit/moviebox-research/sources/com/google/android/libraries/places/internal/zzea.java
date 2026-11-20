package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzea {
    static zzea zza;
    private final zzeb zzb;

    private zzea(zzeb zzebVar) {
        this.zzb = zzebVar;
    }

    public static zzea zza() {
        zzea zzeaVar = new zzea(new zzdz());
        zza = zzeaVar;
        return zzeaVar;
    }
}
