package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzet extends zzkf implements zzln {
    private static final zzet zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzem zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzet zzetVar = new zzet();
        zza = zzetVar;
        zzkf.zzbL(zzet.class, zzetVar);
    }

    private zzet() {
    }

    public static zzes zzc() {
        return (zzes) zza.zzbx();
    }

    public static /* synthetic */ void zzf(zzet zzetVar, String str) {
        zzetVar.zzd |= 2;
        zzetVar.zzf = str;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzem zzb() {
        zzem zzemVar = this.zzg;
        return zzemVar == null ? zzem.zzb() : zzemVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzk() {
        return (this.zzd & 32) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i12 == 3) {
            return new zzet();
        }
        zzeg zzegVar = null;
        if (i12 == 4) {
            return new zzes(zzegVar);
        }
        if (i12 != 5) {
            return null;
        }
        return zza;
    }
}
