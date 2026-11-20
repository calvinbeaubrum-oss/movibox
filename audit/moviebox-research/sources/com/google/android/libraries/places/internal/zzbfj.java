package com.google.android.libraries.places.internal;

import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbfj implements Runnable, zzazg {
    final /* synthetic */ zzbfq zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private volatile ScheduledFuture zze;
    private volatile boolean zzf;

    public zzbfj(zzbfq zzbfqVar, zzazn zzaznVar, boolean z11) {
        long jZzb;
        this.zza = zzbfqVar;
        this.zzb = z11;
        if (zzaznVar == null) {
            this.zzc = false;
            jZzb = 0;
        } else {
            this.zzc = true;
            jZzb = zzaznVar.zzb(TimeUnit.NANOSECONDS);
        }
        this.zzd = jZzb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzm.zzh(zzb());
    }

    public final zzbdo zzb() {
        long jAbs = Math.abs(this.zzd);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit.toNanos(1L);
        long jAbs2 = Math.abs(this.zzd) % timeUnit.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(true != this.zzb ? "CallOptions" : "Context");
        sb2.append(" deadline exceeded after ");
        if (this.zzd < 0) {
            sb2.append('-');
        }
        sb2.append(nanos);
        Locale locale = Locale.US;
        sb2.append(String.format(locale, ".%09d", Long.valueOf(jAbs2)));
        sb2.append("s. ");
        Long l11 = (Long) this.zza.zzl.zzl(zzayx.zza);
        Object[] objArr = new Object[1];
        objArr[0] = Double.valueOf(l11 == null ? 0.0d : l11.longValue() / zzbfq.zzc);
        sb2.append(String.format(locale, "Name resolution delay %.9f seconds.", objArr));
        if (this.zza.zzm != null) {
            zzbjj zzbjjVar = new zzbjj();
            this.zza.zzm.zzg(zzbjjVar);
            sb2.append(" ");
            sb2.append(zzbjjVar);
        }
        return zzbdo.zze.zzg(sb2.toString());
    }

    public final void zzc() {
        if (this.zzf) {
            return;
        }
        if (this.zzc && !this.zzb) {
            zzbfq zzbfqVar = this.zza;
            if (zzbfqVar.zzq != null) {
                this.zze = zzbfqVar.zzq.schedule(new zzbki(this), this.zzd, TimeUnit.NANOSECONDS);
            }
        }
        this.zza.zzi.zzd(this, zzakb.zza());
        if (this.zzf) {
            zzd();
        }
    }

    public final void zzd() {
        this.zzf = true;
        ScheduledFuture scheduledFuture = this.zze;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }
}
