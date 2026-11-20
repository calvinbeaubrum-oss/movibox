package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbsq {
    final /* synthetic */ zzbsu zza;
    private final int zzc;
    private int zzd;
    private int zze;
    private final zzbsp zzf;
    private final zzbwb zzb = new zzbwb();
    private boolean zzg = false;

    public zzbsq(zzbsu zzbsuVar, int i11, int i12, zzbsp zzbspVar) {
        this.zza = zzbsuVar;
        this.zzc = i11;
        this.zzd = i12;
        this.zzf = zzbspVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb(int i11) {
        if (i11 <= 0 || Api.BaseClientBuilder.API_PRIORITY_OTHER - i11 >= this.zzd) {
            int i12 = this.zzd + i11;
            this.zzd = i12;
            return i12;
        }
        throw new IllegalArgumentException("Window size overflow for stream: " + this.zzc);
    }

    public final int zzc() {
        return Math.max(0, Math.min(this.zzd, (int) this.zzb.zzg())) - this.zze;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final int zze() {
        return Math.min(this.zzd, this.zza.zzd.zzd);
    }

    public final int zzf(int i11, zzbst zzbstVar) {
        int iMin = Math.min(i11, zze());
        int iZzg = 0;
        while (zzk() && iMin > 0) {
            zzbwb zzbwbVar = this.zzb;
            if (iMin >= zzbwbVar.zzg()) {
                iZzg += (int) zzbwbVar.zzg();
                zzj(zzbwbVar, (int) zzbwbVar.zzg(), this.zzg);
            } else {
                iZzg += iMin;
                zzj(zzbwbVar, iMin, false);
            }
            zzbstVar.zza++;
            iMin = Math.min(i11 - iZzg, zze());
        }
        return iZzg;
    }

    public final void zzg(int i11) {
        this.zze += i11;
    }

    public final void zzh() {
        this.zze = 0;
    }

    public final void zzi(zzbwb zzbwbVar, int i11, boolean z11) {
        this.zzb.zzn(zzbwbVar, i11);
        this.zzg |= z11;
    }

    public final void zzj(zzbwb zzbwbVar, int i11, boolean z11) {
        do {
            int iMin = Math.min(i11, this.zza.zzb.zzd());
            int i12 = -iMin;
            this.zza.zzd.zzb(i12);
            zzb(i12);
            try {
                boolean z12 = false;
                if (zzbwbVar.zzg() == iMin && z11) {
                    z12 = true;
                }
                this.zza.zzb.zzf(z12, this.zzc, zzbwbVar, iMin);
                this.zzf.zzs(iMin);
                i11 -= iMin;
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
        } while (i11 > 0);
    }

    public final boolean zzk() {
        return this.zzb.zzg() > 0;
    }
}
