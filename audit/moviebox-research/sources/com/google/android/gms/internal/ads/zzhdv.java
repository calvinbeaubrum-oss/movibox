package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdv extends zzgzu implements zzhbf {
    private static final zzhdv zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private zzgyl zzg = zzgyl.zzb;

    static {
        zzhdv zzhdvVar = new zzhdv();
        zzb = zzhdvVar;
        zzgzu.zzaU(zzhdv.class, zzhdvVar);
    }

    private zzhdv() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzd", "zze", zzhdu.zza, "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzhdv();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhdt(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
