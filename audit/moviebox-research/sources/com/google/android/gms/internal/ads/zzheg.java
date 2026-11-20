package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzheg extends zzgzu implements zzhbf {
    private static final zzheg zzb;
    private int zzd;
    private zzgyl zze = zzgyl.zzb;

    static {
        zzheg zzhegVar = new zzheg();
        zzb = zzhegVar;
        zzgzu.zzaU(zzheg.class, zzhegVar);
    }

    private zzheg() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ည\u0000", new Object[]{"zzd", "zze"});
        }
        if (i12 == 3) {
            return new zzheg();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhef(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
