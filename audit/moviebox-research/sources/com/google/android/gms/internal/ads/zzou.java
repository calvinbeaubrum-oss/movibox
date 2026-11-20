package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzou {
    final /* synthetic */ zzov zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzur zze;
    private boolean zzf;
    private boolean zzg;

    public zzou(zzov zzovVar, String str, @Nullable int i11, zzur zzurVar) {
        this.zza = zzovVar;
        this.zzb = str;
        this.zzc = i11;
        this.zzd = zzurVar == null ? -1L : zzurVar.zzd;
        if (zzurVar == null || !zzurVar.zzb()) {
            return;
        }
        this.zze = zzurVar;
    }

    public final void zzg(int i11, @Nullable zzur zzurVar) {
        if (this.zzd == -1 && i11 == this.zzc && zzurVar != null) {
            zzov zzovVar = this.zza;
            long j11 = zzurVar.zzd;
            if (j11 >= zzovVar.zzl()) {
                this.zzd = j11;
            }
        }
    }

    public final boolean zzj(int i11, @Nullable zzur zzurVar) {
        if (zzurVar == null) {
            return i11 == this.zzc;
        }
        zzur zzurVar2 = this.zze;
        if (zzurVar2 == null) {
            return !zzurVar.zzb() && zzurVar.zzd == this.zzd;
        }
        return zzurVar.zzd == zzurVar2.zzd && zzurVar.zzb == zzurVar2.zzb && zzurVar.zzc == zzurVar2.zzc;
    }

    public final boolean zzk(zzmq zzmqVar) {
        zzur zzurVar = zzmqVar.zzd;
        if (zzurVar == null) {
            return this.zzc != zzmqVar.zzc;
        }
        long j11 = this.zzd;
        if (j11 == -1) {
            return false;
        }
        if (zzurVar.zzd > j11) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzcx zzcxVar = zzmqVar.zzb;
        int iZza = zzcxVar.zza(zzurVar.zza);
        int iZza2 = zzcxVar.zza(this.zze.zza);
        zzur zzurVar2 = zzmqVar.zzd;
        if (zzurVar2.zzd < this.zze.zzd || iZza < iZza2) {
            return false;
        }
        if (iZza > iZza2) {
            return true;
        }
        if (!zzurVar2.zzb()) {
            int i11 = zzmqVar.zzd.zze;
            return i11 == -1 || i11 > this.zze.zzb;
        }
        zzur zzurVar3 = zzmqVar.zzd;
        int i12 = zzurVar3.zzb;
        int i13 = zzurVar3.zzc;
        zzur zzurVar4 = this.zze;
        int i14 = zzurVar4.zzb;
        if (i12 <= i14) {
            return i12 == i14 && i13 > zzurVar4.zzc;
        }
        return true;
    }

    public final boolean zzl(zzcx zzcxVar, zzcx zzcxVar2) {
        int i11 = this.zzc;
        if (i11 < zzcxVar.zzc()) {
            zzcxVar.zze(i11, this.zza.zzc, 0L);
            int i12 = this.zza.zzc.zzp;
            while (true) {
                if (i12 > this.zza.zzc.zzq) {
                    i11 = -1;
                    break;
                }
                int iZza = zzcxVar2.zza(zzcxVar.zzf(i12));
                if (iZza != -1) {
                    i11 = zzcxVar2.zzd(iZza, this.zza.zzd, false).zzd;
                    break;
                }
                i12++;
            }
        } else if (i11 >= zzcxVar2.zzc()) {
            i11 = -1;
            break;
        }
        this.zzc = i11;
        if (i11 == -1) {
            return false;
        }
        zzur zzurVar = this.zze;
        return zzurVar == null || zzcxVar2.zza(zzurVar.zza) != -1;
    }
}
