package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbep extends zzgzu implements zzhbf {
    private static final zzbep zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbep zzbepVar = new zzbep();
        zzb = zzbepVar;
        zzgzu.zzaU(zzbep.class, zzbepVar);
    }

    private zzbep() {
    }

    public static zzbeo zza() {
        return (zzbeo) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzbep zzbepVar, int i11) {
        zzbepVar.zzd |= 1;
        zzbepVar.zze = i11;
    }

    public static /* synthetic */ void zze(zzbep zzbepVar, int i11) {
        zzbepVar.zzd |= 2;
        zzbepVar.zzf = i11;
    }

    public static /* synthetic */ void zzf(zzbep zzbepVar, int i11) {
        zzbepVar.zzd |= 4;
        zzbepVar.zzg = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzbep();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbeo(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
