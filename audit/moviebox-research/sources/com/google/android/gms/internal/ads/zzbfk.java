package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbfk extends zzgzu implements zzhbf {
    private static final zzbfk zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzbfk zzbfkVar = new zzbfk();
        zzb = zzbfkVar;
        zzgzu.zzaU(zzbfk.class, zzbfkVar);
    }

    private zzbfk() {
    }

    public static zzbfj zza() {
        return (zzbfj) zzb.zzaA();
    }

    public static /* synthetic */ void zzd(zzbfk zzbfkVar, boolean z11) {
        zzbfkVar.zzd |= 1;
        zzbfkVar.zze = z11;
    }

    public static /* synthetic */ void zze(zzbfk zzbfkVar, int i11) {
        zzbfkVar.zzd |= 2;
        zzbfkVar.zzf = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzgzu
    public final Object zzb(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzgzu.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i12 == 3) {
            return new zzbfk();
        }
        zzbbw zzbbwVar = null;
        if (i12 == 4) {
            return new zzbfj(zzbbwVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
