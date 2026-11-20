package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaou {
    public final int zza;
    public final long zzb;

    private zzaou(int i11, long j11) {
        this.zza = i11;
        this.zzb = j11;
    }

    public static zzaou zza(zzacv zzacvVar, zzfp zzfpVar) throws IOException {
        ((zzack) zzacvVar).zzm(zzfpVar.zzM(), 0, 8, false);
        zzfpVar.zzK(0);
        return new zzaou(zzfpVar.zzg(), zzfpVar.zzs());
    }
}
