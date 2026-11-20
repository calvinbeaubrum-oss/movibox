package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmm implements zzlh {
    private final zzel zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzcg zze = zzcg.zza;

    public zzmm(zzel zzelVar) {
        this.zza = zzelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final long zza() {
        long j11 = this.zzc;
        if (!this.zzb) {
            return j11;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzcg zzcgVar = this.zze;
        return j11 + (zzcgVar.zzc == 1.0f ? zzfy.zzq(jElapsedRealtime) : zzcgVar.zza(jElapsedRealtime));
    }

    public final void zzb(long j11) {
        this.zzc = j11;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final zzcg zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (this.zzb) {
            return;
        }
        this.zzd = SystemClock.elapsedRealtime();
        this.zzb = true;
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzg(zzcg zzcgVar) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final /* synthetic */ boolean zzj() {
        throw null;
    }
}
