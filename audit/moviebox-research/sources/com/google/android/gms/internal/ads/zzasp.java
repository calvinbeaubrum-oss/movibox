package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasp extends zzgzu implements zzhbf {
    private static final zzasp zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;
    private int zzg = 1000;

    static {
        zzasp zzaspVar = new zzasp();
        zzb = zzaspVar;
        zzgzu.zzaU(zzasp.class, zzaspVar);
    }

    private zzasp() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgzy zzgzyVar = zzatj.zza;
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", zzgzyVar, "zzg", zzgzyVar});
        }
        if (i12 == 3) {
            return new zzasp();
        }
        zzasf zzasfVar = null;
        if (i12 == 4) {
            return new zzaso(zzasfVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
