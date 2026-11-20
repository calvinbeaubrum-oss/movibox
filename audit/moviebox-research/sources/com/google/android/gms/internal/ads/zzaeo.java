package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaeo implements zzaej {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaeo(int i11, int i12, int i13, int i14) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
    }

    public static zzaeo zzb(zzfp zzfpVar) {
        int iZzi = zzfpVar.zzi();
        zzfpVar.zzL(8);
        int iZzi2 = zzfpVar.zzi();
        int iZzi3 = zzfpVar.zzi();
        zzfpVar.zzL(4);
        int iZzi4 = zzfpVar.zzi();
        zzfpVar.zzL(12);
        return new zzaeo(iZzi, iZzi2, iZzi3, iZzi4);
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return 1751742049;
    }
}
