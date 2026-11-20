package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbfa extends zzgzu implements zzhbf {
    private static final zzbfa zzb;
    private int zzd;
    private int zze = 1000;
    private zzbew zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzbfa zzbfaVar = new zzbfa();
        zzb = zzbfaVar;
        zzgzu.zzaU(zzbfa.class, zzbfaVar);
    }

    private zzbfa() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzbdc.zza, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i12 == 3) {
            return new zzbfa();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbez(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
