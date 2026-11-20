package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbdt extends zzgzu implements zzhbf {
    private static final zzbdt zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzbdt zzbdtVar = new zzbdt();
        zzb = zzbdtVar;
        zzgzu.zzaU(zzbdt.class, zzbdtVar);
    }

    private zzbdt() {
    }

    public static zzbdm zza() {
        return (zzbdm) zzb.zzaA();
    }

    public static zzbdt zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzi(zzbdt zzbdtVar, int i11) {
        zzbdtVar.zze = i11 - 1;
        zzbdtVar.zzd |= 1;
    }

    public static /* synthetic */ void zzj(zzbdt zzbdtVar, int i11) {
        zzbdtVar.zzf = i11 - 1;
        zzbdtVar.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzbdr.zza, "zzf", zzbdo.zza});
        }
        if (i12 == 3) {
            return new zzbdt();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbdm(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zze() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzf() {
        return (this.zzd & 1) != 0;
    }

    public final int zzg() {
        int iZza = zzbdp.zza(this.zzf);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzh() {
        int iZza = zzbds.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }
}
