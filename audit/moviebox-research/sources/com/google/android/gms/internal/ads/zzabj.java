package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabj {

    @Nullable
    private final Handler zza;

    @Nullable
    private final zzabk zzb;

    public zzabj(@Nullable Handler handler, @Nullable zzabk zzabkVar) {
        this.zza = zzabkVar == null ? null : handler;
        this.zzb = zzabkVar;
    }

    public final void zza(final String str, final long j11, final long j12) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaaz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg(str, j11, j12);
                }
            });
        }
    }

    public final void zzb(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabi
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh(str);
                }
            });
        }
    }

    public final void zzc(final zzir zzirVar) {
        zzirVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(zzirVar);
                }
            });
        }
    }

    public final void zzd(final int i11, final long j11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(i11, j11);
                }
            });
        }
    }

    public final void zze(final zzir zzirVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabf
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(zzirVar);
                }
            });
        }
    }

    public final void zzf(final zzam zzamVar, @Nullable final zzis zzisVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzamVar, zzisVar);
                }
            });
        }
    }

    public final /* synthetic */ void zzg(String str, long j11, long j12) {
        int i11 = zzfy.zza;
        this.zzb.zzp(str, j11, j12);
    }

    public final /* synthetic */ void zzh(String str) {
        int i11 = zzfy.zza;
        this.zzb.zzq(str);
    }

    public final /* synthetic */ void zzi(zzir zzirVar) {
        zzirVar.zza();
        int i11 = zzfy.zza;
        this.zzb.zzr(zzirVar);
    }

    public final /* synthetic */ void zzj(int i11, long j11) {
        int i12 = zzfy.zza;
        this.zzb.zzl(i11, j11);
    }

    public final /* synthetic */ void zzk(zzir zzirVar) {
        int i11 = zzfy.zza;
        this.zzb.zzs(zzirVar);
    }

    public final /* synthetic */ void zzl(zzam zzamVar, zzis zzisVar) {
        int i11 = zzfy.zza;
        this.zzb.zzu(zzamVar, zzisVar);
    }

    public final /* synthetic */ void zzm(Object obj, long j11) {
        int i11 = zzfy.zza;
        this.zzb.zzm(obj, j11);
    }

    public final /* synthetic */ void zzn(long j11, int i11) {
        int i12 = zzfy.zza;
        this.zzb.zzt(j11, i11);
    }

    public final /* synthetic */ void zzo(Exception exc) {
        int i11 = zzfy.zza;
        this.zzb.zzo(exc);
    }

    public final /* synthetic */ void zzp(zzdp zzdpVar) {
        int i11 = zzfy.zza;
        this.zzb.zzv(zzdpVar);
    }

    public final void zzq(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j11, final int i11) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabd
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(j11, i11);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabe
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(exc);
                }
            });
        }
    }

    public final void zzt(final zzdp zzdpVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaba
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzdpVar);
                }
            });
        }
    }
}
