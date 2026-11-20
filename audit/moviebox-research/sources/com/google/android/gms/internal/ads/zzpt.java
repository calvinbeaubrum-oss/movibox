package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpt {

    @Nullable
    private final Handler zza;

    @Nullable
    private final zzpu zzb;

    public zzpt(@Nullable Handler handler, @Nullable zzpu zzpuVar) {
        this.zza = zzpuVar == null ? null : handler;
        this.zzb = zzpuVar;
    }

    public final void zza(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpn
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(exc);
                }
            });
        }
    }

    public final void zzb(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpo
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(exc);
                }
            });
        }
    }

    public final void zzc(final zzpv zzpvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzpvVar);
                }
            });
        }
    }

    public final void zzd(final zzpv zzpvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpm
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(zzpvVar);
                }
            });
        }
    }

    public final void zze(final String str, final long j11, final long j12) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(str, j11, j12);
                }
            });
        }
    }

    public final void zzf(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzps
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(str);
                }
            });
        }
    }

    public final void zzg(final zzir zzirVar) {
        zzirVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpi
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzirVar);
                }
            });
        }
    }

    public final void zzh(final zzir zzirVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzph
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzq(zzirVar);
                }
            });
        }
    }

    public final void zzi(final zzam zzamVar, @Nullable final zzis zzisVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpp
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzr(zzamVar, zzisVar);
                }
            });
        }
    }

    public final /* synthetic */ void zzj(Exception exc) {
        int i11 = zzfy.zza;
        this.zzb.zza(exc);
    }

    public final /* synthetic */ void zzk(Exception exc) {
        int i11 = zzfy.zza;
        this.zzb.zzh(exc);
    }

    public final /* synthetic */ void zzl(zzpv zzpvVar) {
        int i11 = zzfy.zza;
        this.zzb.zzi(zzpvVar);
    }

    public final /* synthetic */ void zzm(zzpv zzpvVar) {
        int i11 = zzfy.zza;
        this.zzb.zzj(zzpvVar);
    }

    public final /* synthetic */ void zzn(String str, long j11, long j12) {
        int i11 = zzfy.zza;
        this.zzb.zzb(str, j11, j12);
    }

    public final /* synthetic */ void zzo(String str) {
        int i11 = zzfy.zza;
        this.zzb.zzc(str);
    }

    public final /* synthetic */ void zzp(zzir zzirVar) {
        zzirVar.zza();
        int i11 = zzfy.zza;
        this.zzb.zzd(zzirVar);
    }

    public final /* synthetic */ void zzq(zzir zzirVar) {
        int i11 = zzfy.zza;
        this.zzb.zze(zzirVar);
    }

    public final /* synthetic */ void zzr(zzam zzamVar, zzis zzisVar) {
        int i11 = zzfy.zza;
        this.zzb.zzf(zzamVar, zzisVar);
    }

    public final /* synthetic */ void zzs(long j11) {
        int i11 = zzfy.zza;
        this.zzb.zzg(j11);
    }

    public final /* synthetic */ void zzt(boolean z11) {
        int i11 = zzfy.zza;
        this.zzb.zzn(z11);
    }

    public final /* synthetic */ void zzu(int i11, long j11, long j12) {
        int i12 = zzfy.zza;
        this.zzb.zzk(i11, j11, j12);
    }

    public final void zzv(final long j11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpj
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzs(j11);
                }
            });
        }
    }

    public final void zzw(final boolean z11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzt(z11);
                }
            });
        }
    }

    public final void zzx(final int i11, final long j11, final long j12) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzu(i11, j11, j12);
                }
            });
        }
    }
}
