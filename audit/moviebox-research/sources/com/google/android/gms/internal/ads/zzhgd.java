package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhgd extends zzgzu implements zzhbf {
    private static final zzhgd zzb;
    private int zzd;
    private int zze;
    private int zzh;
    private String zzf = "";
    private zzgzz zzg = zzgzu.zzaJ();
    private zzhad zzi = zzgzu.zzaN();
    private zzgyl zzj = zzgyl.zzb;

    static {
        zzhgd zzhgdVar = new zzhgd();
        zzb = zzhgdVar;
        zzgzu.zzaU(zzhgd.class, zzhgdVar);
    }

    private zzhgd() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzhgb.class, "zzj"});
        }
        if (i12 == 3) {
            return new zzhgd();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhgc(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
