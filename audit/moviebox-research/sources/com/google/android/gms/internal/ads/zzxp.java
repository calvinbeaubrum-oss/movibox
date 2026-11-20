package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzxp implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxp(zzam zzamVar, int i11) {
        this.zza = 1 == (zzamVar.zze & 1);
        this.zzb = zzyg.zzo(i11, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxp zzxpVar) {
        return zzfzp.zzk().zze(this.zzb, zzxpVar.zzb).zze(this.zza, zzxpVar.zza).zza();
    }
}
