package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaru extends zzgzu implements zzhbf {
    private static final zzaru zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzaru zzaruVar = new zzaru();
        zzb = zzaruVar;
        zzgzu.zzaU(zzaru.class, zzaruVar);
    }

    private zzaru() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzaru();
        }
        zzarr zzarrVar = null;
        if (i12 == 4) {
            return new zzart(zzarrVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
