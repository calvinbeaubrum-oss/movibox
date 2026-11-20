package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.s;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzelr {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcwk zzc;
    private final zzemh zzd;
    private final zzfnu zze;
    private final zzgfg zzf = zzgfg.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzels zzh;
    private zzfgy zzi;

    public zzelr(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcwk zzcwkVar, zzemh zzemhVar, zzfnu zzfnuVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcwkVar;
        this.zzd = zzemhVar;
        this.zze = zzfnuVar;
    }

    private final synchronized s zzd(zzfgm zzfgmVar) {
        Iterator it = zzfgmVar.zza.iterator();
        while (it.hasNext()) {
            zzein zzeinVarZza = this.zzc.zza(zzfgmVar.zzb, (String) it.next());
            if (zzeinVarZza != null && zzeinVarZza.zzb(this.zzi, zzfgmVar)) {
                return zzgen.zzo(zzeinVarZza.zza(this.zzi, zzfgmVar), zzfgmVar.zzS, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgen.zzg(new zzead(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(@Nullable zzfgm zzfgmVar) {
        if (zzfgmVar == null) {
            return;
        }
        s sVarZzd = zzd(zzfgmVar);
        this.zzd.zzf(this.zzi, zzfgmVar, sVarZzd, this.zze);
        zzgen.zzr(sVarZzd, new zzelq(this, zzfgmVar), this.zza);
    }

    public final synchronized s zzb(zzfgy zzfgyVar) {
        try {
            if (!this.zzg.getAndSet(true)) {
                if (zzfgyVar.zzb.zza.isEmpty()) {
                    this.zzf.zzd(new zzeml(3, zzemo.zzc(zzfgyVar)));
                } else {
                    this.zzi = zzfgyVar;
                    this.zzh = new zzels(zzfgyVar, this.zzd, this.zzf);
                    this.zzd.zzk(zzfgyVar.zzb.zza);
                    while (this.zzh.zze()) {
                        zze(this.zzh.zza());
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.zzf;
    }
}
