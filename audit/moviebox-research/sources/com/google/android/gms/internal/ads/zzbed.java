package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbed extends zzgzu implements zzhbf {
    private static final zzbed zzb;
    private int zzd;
    private int zzf;
    private int zzg;
    private long zzh;
    private long zzk;
    private int zzl;
    private zzhad zze = zzgzu.zzaN();
    private String zzi = "";
    private String zzj = "";

    static {
        zzbed zzbedVar = new zzbed();
        zzb = zzbedVar;
        zzgzu.zzaU(zzbed.class, zzbedVar);
    }

    private zzbed() {
    }

    public static zzbdz zza() {
        return (zzbdz) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzbed zzbedVar, Iterable iterable) {
        zzhad zzhadVar = zzbedVar.zze;
        if (!zzhadVar.zzc()) {
            zzbedVar.zze = zzgzu.zzaO(zzhadVar);
        }
        zzgxt.zzav(iterable, zzbedVar.zze);
    }

    public static /* synthetic */ void zze(zzbed zzbedVar, int i11) {
        zzbedVar.zzd |= 1;
        zzbedVar.zzf = i11;
    }

    public static /* synthetic */ void zzf(zzbed zzbedVar, int i11) {
        zzbedVar.zzd |= 2;
        zzbedVar.zzg = i11;
    }

    public static /* synthetic */ void zzg(zzbed zzbedVar, long j11) {
        zzbedVar.zzd |= 4;
        zzbedVar.zzh = j11;
    }

    public static /* synthetic */ void zzh(zzbed zzbedVar, String str) {
        str.getClass();
        zzbedVar.zzd |= 8;
        zzbedVar.zzi = str;
    }

    public static /* synthetic */ void zzi(zzbed zzbedVar, String str) {
        str.getClass();
        zzbedVar.zzd |= 16;
        zzbedVar.zzj = str;
    }

    public static /* synthetic */ void zzj(zzbed zzbedVar, long j11) {
        zzbedVar.zzd |= 32;
        zzbedVar.zzk = j11;
    }

    public static /* synthetic */ void zzk(zzbed zzbedVar, int i11) {
        zzbedVar.zzd |= 64;
        zzbedVar.zzl = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005\bင\u0006", new Object[]{"zzd", "zze", zzbdy.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i12 == 3) {
            return new zzbed();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbdz(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
