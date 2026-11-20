package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasy extends zzgzu implements zzhbf {
    private static final zzasy zzb;
    private int zzd;
    private long zze = -1;
    private int zzf = 1000;

    static {
        zzasy zzasyVar = new zzasy();
        zzb = zzasyVar;
        zzgzu.zzaU(zzasy.class, zzasyVar);
    }

    private zzasy() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzatj.zza});
        }
        if (i12 == 3) {
            return new zzasy();
        }
        zzasf zzasfVar = null;
        if (i12 == 4) {
            return new zzasx(zzasfVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
