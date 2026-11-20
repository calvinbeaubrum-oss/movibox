package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhez extends zzgzu implements zzhbf {
    private static final zzhez zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;

    static {
        zzhez zzhezVar = new zzhez();
        zzb = zzhezVar;
        zzgzu.zzaU(zzhez.class, zzhezVar);
    }

    private zzhez() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgzy zzgzyVar = zzhex.zza;
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzgzyVar, "zzf", "zzg", zzgzyVar});
        }
        if (i12 == 3) {
            return new zzhez();
        }
        zzhdp zzhdpVar = null;
        if (i12 == 4) {
            return new zzhey(zzhdpVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
