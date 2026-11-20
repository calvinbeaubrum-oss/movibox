package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcj extends zzgzu implements zzhbf {
    private static final zzbcj zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzbcj zzbcjVar = new zzbcj();
        zzb = zzbcjVar;
        zzgzu.zzaU(zzbcj.class, zzbcjVar);
    }

    private zzbcj() {
    }

    public static zzbci zza() {
        return (zzbci) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzbcj zzbcjVar, boolean z11) {
        zzbcjVar.zzd |= 1;
        zzbcjVar.zze = z11;
    }

    public static /* synthetic */ void zze(zzbcj zzbcjVar, boolean z11) {
        zzbcjVar.zzd |= 2;
        zzbcjVar.zzf = z11;
    }

    public static /* synthetic */ void zzf(zzbcj zzbcjVar, int i11) {
        zzbcjVar.zzd |= 4;
        zzbcjVar.zzg = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzbcj();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbci(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
