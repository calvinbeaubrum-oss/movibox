package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhel extends zzgzu implements zzhbf {
    private static final zzhel zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private long zzh;

    static {
        zzhel zzhelVar = new zzhel();
        zzb = zzhelVar;
        zzgzu.zzaU(zzhel.class, zzhelVar);
    }

    private zzhel() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", zzhek.zza, "zzf", zzhei.zza, "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzhel();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhej(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
