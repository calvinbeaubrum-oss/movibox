package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcd extends zzgzu implements zzhbf {
    private static final zzbcd zzb;
    private int zzd;
    private int zze;
    private zzbch zzf;
    private zzbcj zzg;

    static {
        zzbcd zzbcdVar = new zzbcd();
        zzb = zzbcdVar;
        zzgzu.zzaU(zzbcd.class, zzbcdVar);
    }

    private zzbcd() {
    }

    public static zzbcc zza() {
        return (zzbcc) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzbcd zzbcdVar, zzbch zzbchVar) {
        zzbchVar.getClass();
        zzbcdVar.zzf = zzbchVar;
        zzbcdVar.zzd |= 2;
    }

    public static /* synthetic */ void zze(zzbcd zzbcdVar, zzbcj zzbcjVar) {
        zzbcjVar.getClass();
        zzbcdVar.zzg = zzbcjVar;
        zzbcdVar.zzd |= 4;
    }

    public static /* synthetic */ void zzf(zzbcd zzbcdVar, int i11) {
        zzbcdVar.zze = 1;
        zzbcdVar.zzd = 1 | zzbcdVar.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzbcf.zza, "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzbcd();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbcc(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
