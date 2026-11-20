package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbdh extends zzgzu implements zzhbf {
    private static final zzbdh zzb;
    private int zzd;
    private int zzf;
    private zzben zzh;
    private String zze = "";
    private zzgzz zzg = zzgzu.zzaJ();

    static {
        zzbdh zzbdhVar = new zzbdh();
        zzb = zzbdhVar;
        zzgzu.zzaU(zzbdh.class, zzbdhVar);
    }

    private zzbdh() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzbdc.zza, "zzg", "zzh"});
        }
        if (i12 == 3) {
            return new zzbdh();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbdg(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
