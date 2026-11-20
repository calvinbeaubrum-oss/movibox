package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcla {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcla(int i11, int i12, int i13) {
        this.zzc = i11;
        this.zzb = i12;
        this.zza = i13;
    }

    public static zzcla zza() {
        return new zzcla(0, 0, 0);
    }

    public static zzcla zzb(int i11, int i12) {
        return new zzcla(1, i11, i12);
    }

    public static zzcla zzc(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        if (zzqVar.zzd) {
            return new zzcla(3, 0, 0);
        }
        if (zzqVar.zzi) {
            return new zzcla(2, 0, 0);
        }
        return zzqVar.zzh ? zza() : zzb(zzqVar.zzf, zzqVar.zzc);
    }

    public static zzcla zzd() {
        return new zzcla(5, 0, 0);
    }

    public static zzcla zze() {
        return new zzcla(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
