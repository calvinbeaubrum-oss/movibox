package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzhfa extends zzgzu implements zzhbf {
    private static final zzhfa zzb;
    private int zzd;
    private int zze;
    private zzhez zzf;
    private zzhez zzg;

    static {
        zzhfa zzhfaVar = new zzhfa();
        zzb = zzhfaVar;
        zzgzu.zzaU(zzhfa.class, zzhfaVar);
    }

    private zzhfa() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzhex.zza, "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzhfa();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhew(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
