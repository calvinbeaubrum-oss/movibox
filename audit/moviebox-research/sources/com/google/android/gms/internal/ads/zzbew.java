package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbew extends zzgzu implements zzhbf {
    private static final zzbew zzb;
    private int zzd;
    private int zze;

    static {
        zzbew zzbewVar = new zzbew();
        zzb = zzbewVar;
        zzgzu.zzaU(zzbew.class, zzbewVar);
    }

    private zzbew() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzbev.zza});
        }
        if (i12 == 3) {
            return new zzbew();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbeu(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
