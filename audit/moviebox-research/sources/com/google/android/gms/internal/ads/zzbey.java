package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbey extends zzgzu implements zzhbf {
    private static final zzbey zzb;
    private int zzd;
    private zzbep zze;
    private int zzf = 1000;
    private zzbew zzg;
    private zzben zzh;

    static {
        zzbey zzbeyVar = new zzbey();
        zzb = zzbeyVar;
        zzgzu.zzaU(zzbey.class, zzbeyVar);
    }

    private zzbey() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", zzbdc.zza, "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzbey();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbex(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
