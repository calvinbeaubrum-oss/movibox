package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcr extends zzgzu implements zzhbf {
    private static final zzbcr zzb;
    private int zzd;
    private String zze = "";
    private zzhad zzf = zzgzu.zzaN();
    private int zzg;

    static {
        zzbcr zzbcrVar = new zzbcr();
        zzb = zzbcrVar;
        zzgzu.zzaU(zzbcr.class, zzbcrVar);
    }

    private zzbcr() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzbcp.class, "zzg", zzbdc.zza});
        }
        if (i12 == 3) {
            return new zzbcr();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbcq(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
