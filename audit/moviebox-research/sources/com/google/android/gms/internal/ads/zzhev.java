package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhev extends zzgzu implements zzhbf {
    private static final zzhev zzb;
    private int zzd;
    private zzheu zze;
    private zzgyl zzg;
    private zzgyl zzh;
    private int zzi;
    private zzgyl zzj;
    private byte zzk = 2;
    private zzhad zzf = zzgzu.zzaN();

    static {
        zzhev zzhevVar = new zzhev();
        zzb = zzhevVar;
        zzgzu.zzaU(zzhev.class, zzhevVar);
    }

    private zzhev() {
        zzgyl zzgylVar = zzgyl.zzb;
        this.zzg = zzgylVar;
        this.zzh = zzgylVar;
        this.zzj = zzgylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzd", "zze", "zzf", zzhen.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i12 == 3) {
            return new zzhev();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhes(zzhdpVar);
        }
        if (i12 == 5) {
            return zzb;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
