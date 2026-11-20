package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzof;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzka {

    @VisibleForTesting
    protected long zza;

    @VisibleForTesting
    protected long zzb;
    final /* synthetic */ zzkc zzc;
    private final zzap zzd;

    public zzka(zzkc zzkcVar) {
        this.zzc = zzkcVar;
        this.zzd = new zzjz(this, zzkcVar.zzt);
        long jElapsedRealtime = zzkcVar.zzt.zzav().elapsedRealtime();
        this.zza = jElapsedRealtime;
        this.zzb = jElapsedRealtime;
    }

    public final void zza() {
        this.zzd.zzb();
        this.zza = 0L;
        this.zzb = 0L;
    }

    public final void zzb(long j11) {
        this.zzd.zzb();
    }

    public final void zzc(long j11) {
        this.zzc.zzg();
        this.zzd.zzb();
        this.zza = j11;
        this.zzb = j11;
    }

    public final boolean zzd(boolean z11, boolean z12, long j11) {
        this.zzc.zzg();
        this.zzc.zza();
        zzof.zzc();
        if (!this.zzc.zzt.zzf().zzs(null, zzdu.zzad) || this.zzc.zzt.zzJ()) {
            this.zzc.zzt.zzm().zzj.zzb(this.zzc.zzt.zzav().currentTimeMillis());
        }
        long j12 = j11 - this.zza;
        if (!z11 && j12 < 1000) {
            this.zzc.zzt.zzay().zzj().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j12));
            return false;
        }
        if (!z12) {
            j12 = j11 - this.zzb;
            this.zzb = j11;
        }
        this.zzc.zzt.zzay().zzj().zzb("Recording user engagement, ms", Long.valueOf(j12));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j12);
        zzlb.zzK(this.zzc.zzt.zzs().zzj(!this.zzc.zzt.zzf().zzu()), bundle, true);
        if (!z12) {
            this.zzc.zzt.zzq().zzG("auto", "_e", bundle);
        }
        this.zza = j11;
        this.zzd.zzb();
        this.zzd.zzd(3600000L);
        return true;
    }
}
