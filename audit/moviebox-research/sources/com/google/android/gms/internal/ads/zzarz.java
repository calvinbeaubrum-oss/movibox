package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarz extends zzgzu implements zzhbf {
    private static final zzarz zzb;
    private int zzd;
    private zzasb zze;
    private zzase zzf;

    static {
        zzarz zzarzVar = new zzarz();
        zzb = zzarzVar;
        zzgzu.zzaU(zzarz.class, zzarzVar);
    }

    private zzarz() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzarz();
        }
        zzarx zzarxVar = null;
        if (i12 == 4) {
            return new zzary(zzarxVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
