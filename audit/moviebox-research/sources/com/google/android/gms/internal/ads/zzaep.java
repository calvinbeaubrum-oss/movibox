package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaep implements zzaej {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzaep(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.zza = i11;
        this.zzb = i13;
        this.zzc = i14;
        this.zzd = i15;
        this.zze = i16;
    }

    public static zzaep zzb(zzfp zzfpVar) {
        int iZzi = zzfpVar.zzi();
        zzfpVar.zzL(12);
        int iZzi2 = zzfpVar.zzi();
        int iZzi3 = zzfpVar.zzi();
        int iZzi4 = zzfpVar.zzi();
        zzfpVar.zzL(4);
        int iZzi5 = zzfpVar.zzi();
        int iZzi6 = zzfpVar.zzi();
        zzfpVar.zzL(8);
        return new zzaep(iZzi, iZzi2, iZzi3, iZzi4, iZzi5, iZzi6);
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return 1752331379;
    }
}
