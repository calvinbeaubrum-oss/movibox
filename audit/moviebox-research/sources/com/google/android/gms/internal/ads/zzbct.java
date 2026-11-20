package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbct extends zzgzu implements zzhbf {
    private static final zzbct zzb;
    private int zzd;
    private String zze = "";
    private zzhad zzf = zzgzu.zzaN();
    private int zzg = 1000;
    private int zzh = 1000;
    private int zzi = 1000;

    static {
        zzbct zzbctVar = new zzbct();
        zzb = zzbctVar;
        zzgzu.zzaU(zzbct.class, zzbctVar);
    }

    private zzbct() {
    }

    public static zzbct zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbct zzbctVar, String str) {
        str.getClass();
        zzbctVar.zzd |= 1;
        zzbctVar.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgzy zzgzyVar = zzbdc.zza;
            return zzgzu.zzaR(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzd", "zze", "zzf", zzbcp.class, "zzg", zzgzyVar, "zzh", zzgzyVar, "zzi", zzgzyVar});
        }
        if (i12 == 3) {
            return new zzbct();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbcs(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
