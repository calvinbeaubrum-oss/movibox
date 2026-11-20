package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbel extends zzgzu implements zzhbf {
    private static final zzbel zzb;
    private int zzd;
    private String zze = "";
    private int zzf;
    private zzben zzg;

    static {
        zzbel zzbelVar = new zzbel();
        zzb = zzbelVar;
        zzgzu.zzaU(zzbel.class, zzbelVar);
    }

    private zzbel() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzbdc.zza, "zzg"});
        }
        if (i12 == 3) {
            return new zzbel();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbek(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
