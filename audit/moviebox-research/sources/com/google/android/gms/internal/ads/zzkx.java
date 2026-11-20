package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkx {
    public zzly zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    private boolean zzg;

    public zzkx(zzly zzlyVar) {
        this.zza = zzlyVar;
    }

    public final void zza(int i11) {
        this.zzg = 1 == ((this.zzg ? 1 : 0) | i11);
        this.zzb += i11;
    }

    public final void zzb(int i11) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i11;
    }

    public final void zzc(zzly zzlyVar) {
        this.zzg |= this.zza != zzlyVar;
        this.zza = zzlyVar;
    }

    public final void zzd(int i11) {
        if (this.zzc && this.zzd != 5) {
            zzek.zzd(i11 == 5);
            return;
        }
        this.zzg = true;
        this.zzc = true;
        this.zzd = i11;
    }
}
