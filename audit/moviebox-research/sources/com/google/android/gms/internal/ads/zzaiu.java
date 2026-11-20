package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaiu implements zzair {
    private final zzfp zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaiu(zzain zzainVar) {
        zzfp zzfpVar = zzainVar.zza;
        this.zza = zzfpVar;
        zzfpVar.zzK(12);
        this.zzc = zzfpVar.zzp() & 255;
        this.zzb = zzfpVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zza() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zzc() {
        int i11 = this.zzc;
        if (i11 == 8) {
            return this.zza.zzm();
        }
        if (i11 == 16) {
            return this.zza.zzq();
        }
        int i12 = this.zzd;
        this.zzd = i12 + 1;
        if (i12 % 2 != 0) {
            return this.zze & 15;
        }
        int iZzm = this.zza.zzm();
        this.zze = iZzm;
        return (iZzm & 240) >> 4;
    }
}
