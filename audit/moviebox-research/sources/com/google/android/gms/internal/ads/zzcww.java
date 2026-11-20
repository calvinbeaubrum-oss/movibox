package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcww {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final s zzc;
    private volatile boolean zzd = true;

    public zzcww(Executor executor, ScheduledExecutorService scheduledExecutorService, s sVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = sVar;
    }

    public static /* bridge */ /* synthetic */ void zzb(final zzcww zzcwwVar, List list, final zzgej zzgejVar) {
        if (list == null || list.isEmpty()) {
            zzcwwVar.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcwr
                @Override // java.lang.Runnable
                public final void run() {
                    zzgejVar.zza(new zzead(3));
                }
            });
            return;
        }
        s sVarZzh = zzgen.zzh(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final s sVar = (s) it.next();
            sVarZzh = zzgen.zzn(zzgen.zzf(sVarZzh, Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcws
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    zzgejVar.zza((Throwable) obj);
                    return zzgen.zzh(null);
                }
            }, zzcwwVar.zza), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcwt
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    return this.zza.zza(zzgejVar, sVar, (zzcwh) obj);
                }
            }, zzcwwVar.zza);
        }
        zzgen.zzr(sVarZzh, new zzcwv(zzcwwVar, zzgejVar), zzcwwVar.zza);
    }

    public final /* synthetic */ s zza(zzgej zzgejVar, s sVar, zzcwh zzcwhVar) throws Exception {
        if (zzcwhVar != null) {
            zzgejVar.zzb(zzcwhVar);
        }
        return zzgen.zzo(sVar, ((Long) zzbin.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzgej zzgejVar) {
        zzgen.zzr(this.zzc, new zzcwu(this, zzgejVar), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
