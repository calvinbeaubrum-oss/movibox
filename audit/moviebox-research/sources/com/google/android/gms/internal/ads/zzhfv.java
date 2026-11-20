package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfv extends zzgzu implements zzhbf {
    private static final zzhfv zzb;
    private int zzd;
    private String zze = "";
    private zzgyl zzf = zzgyl.zzb;

    static {
        zzhfv zzhfvVar = new zzhfv();
        zzb = zzhfvVar;
        zzgzu.zzaU(zzhfv.class, zzhfvVar);
    }

    private zzhfv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzhfv();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhfu(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
