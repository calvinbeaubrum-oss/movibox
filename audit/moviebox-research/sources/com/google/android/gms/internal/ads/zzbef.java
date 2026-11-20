package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbef extends zzgzu implements zzhbf {
    private static final zzbef zzb;
    private int zzd;
    private int zze = 1000;
    private int zzf = 1000;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzbeh zzo;

    static {
        zzbef zzbefVar = new zzbef();
        zzb = zzbefVar;
        zzgzu.zzaU(zzbef.class, zzbefVar);
    }

    private zzbef() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            zzgzy zzgzyVar = zzbdc.zza;
            return zzgzu.zzaR(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zzd", "zze", zzgzyVar, "zzf", zzgzyVar, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i12 == 3) {
            return new zzbef();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbee(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
