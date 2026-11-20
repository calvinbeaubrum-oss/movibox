package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcx extends zzgzu implements zzhbf {
    private static final zzbcx zzb;
    private int zzd;
    private zzben zzf;
    private int zzg;
    private zzbep zzh;
    private int zzi;
    private String zze = "";
    private int zzj = 1000;
    private int zzk = 1000;
    private int zzl = 1000;

    static {
        zzbcx zzbcxVar = new zzbcx();
        zzb = zzbcxVar;
        zzgzu.zzaU(zzbcx.class, zzbcxVar);
    }

    private zzbcx() {
    }

    public static zzbcx zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbcx zzbcxVar, String str) {
        zzbcxVar.zzd |= 1;
        zzbcxVar.zze = str;
    }

    public static /* synthetic */ void zze(zzbcx zzbcxVar, zzbep zzbepVar) {
        zzbepVar.getClass();
        zzbcxVar.zzh = zzbepVar;
        zzbcxVar.zzd |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgzy zzgzyVar = zzbdc.zza;
            return zzgzu.zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzgzyVar, "zzk", zzgzyVar, "zzl", zzgzyVar});
        }
        if (i12 == 3) {
            return new zzbcx();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbcw(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
