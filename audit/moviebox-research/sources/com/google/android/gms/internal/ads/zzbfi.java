package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbfi extends zzgzu implements zzhbf {
    private static final zzbfi zzb;
    private int zzd;
    private int zze = 1000;
    private zzbew zzf;

    static {
        zzbfi zzbfiVar = new zzbfi();
        zzb = zzbfiVar;
        zzgzu.zzaU(zzbfi.class, zzbfiVar);
    }

    private zzbfi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", zzbdc.zza, "zzf"});
        }
        if (i12 == 3) {
            return new zzbfi();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbfh(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
