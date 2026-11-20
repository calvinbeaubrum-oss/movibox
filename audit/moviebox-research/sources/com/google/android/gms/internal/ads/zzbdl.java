package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbdl extends zzgzu implements zzhbf {
    private static final zzbdl zzb;
    private int zzd;
    private zzbdh zze;
    private zzhad zzf = zzgzu.zzaN();
    private int zzg;
    private zzben zzh;

    static {
        zzbdl zzbdlVar = new zzbdl();
        zzb = zzbdlVar;
        zzgzu.zzaU(zzbdl.class, zzbdlVar);
    }

    private zzbdl() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003᠌\u0001\u0004ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzbel.class, "zzg", zzbdc.zza, "zzh"});
        }
        if (i12 == 3) {
            return new zzbdl();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbdk(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
