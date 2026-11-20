package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarw extends zzgzu implements zzhbf {
    private static final zzarw zzb;
    private int zzd;
    private long zzf;
    private long zzj;
    private long zzk;
    private long zzm;
    private int zzq;
    private String zze = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzl = "";
    private String zzn = "";
    private String zzo = "";
    private zzhad zzp = zzgzu.zzaN();

    static {
        zzarw zzarwVar = new zzarw();
        zzb = zzarwVar;
        zzgzu.zzaU(zzarw.class, zzarwVar);
    }

    private zzarw() {
    }

    public static zzars zza() {
        return (zzars) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzarw zzarwVar, long j11) {
        zzarwVar.zzd |= 2;
        zzarwVar.zzf = j11;
    }

    public static /* synthetic */ void zze(zzarw zzarwVar, String str) {
        str.getClass();
        zzarwVar.zzd |= 4;
        zzarwVar.zzg = str;
    }

    public static /* synthetic */ void zzf(zzarw zzarwVar, String str) {
        str.getClass();
        zzarwVar.zzd |= 8;
        zzarwVar.zzh = str;
    }

    public static /* synthetic */ void zzg(zzarw zzarwVar, String str) {
        zzarwVar.zzd |= 16;
        zzarwVar.zzi = str;
    }

    public static /* synthetic */ void zzh(zzarw zzarwVar, String str) {
        zzarwVar.zzd |= 1024;
        zzarwVar.zzo = str;
    }

    public static /* synthetic */ void zzi(zzarw zzarwVar, String str) {
        str.getClass();
        zzarwVar.zzd |= 1;
        zzarwVar.zze = str;
    }

    public static /* synthetic */ void zzj(zzarw zzarwVar, int i11) {
        zzarwVar.zzq = i11 - 1;
        zzarwVar.zzd |= 2048;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", zzaru.class, "zzq", zzarv.zza});
        }
        if (i12 == 3) {
            return new zzarw();
        }
        zzarr zzarrVar = null;
        if (i12 == 4) {
            return new zzars(zzarrVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }
}
