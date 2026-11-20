package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzheu extends zzgzu implements zzhbf {
    private static final zzheu zzb;
    private int zzd;
    private int zze;
    private zzgyl zzf;
    private zzgyl zzg;

    static {
        zzheu zzheuVar = new zzheu();
        zzb = zzheuVar;
        zzgzu.zzaU(zzheu.class, zzheuVar);
    }

    private zzheu() {
        zzgyl zzgylVar = zzgyl.zzb;
        this.zzf = zzgylVar;
        this.zzg = zzgylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzheu();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhet(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
