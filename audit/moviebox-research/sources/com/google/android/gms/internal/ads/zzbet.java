package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbet extends zzgzu implements zzhbf {
    private static final zzbet zzb;
    private int zzd;
    private int zze = 1000;
    private zzbew zzf;
    private zzben zzg;

    static {
        zzbet zzbetVar = new zzbet();
        zzb = zzbetVar;
        zzgzu.zzaU(zzbet.class, zzbetVar);
    }

    private zzbet() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzbdc.zza, "zzf", "zzg"});
        }
        if (i12 == 3) {
            return new zzbet();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbes(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
