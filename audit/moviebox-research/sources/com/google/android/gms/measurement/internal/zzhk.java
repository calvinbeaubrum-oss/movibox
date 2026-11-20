package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzpa;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhk implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zza;
    final /* synthetic */ zzhx zzb;

    public zzhk(zzhx zzhxVar, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzb = zzhxVar;
        this.zza = zzcfVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0089  */
    /* JADX WARN: Code duplicated, block: B:23:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Long lValueOf;
        zzkc zzkcVarZzu = this.zzb.zzt.zzu();
        zzpa.zzc();
        if (!zzkcVarZzu.zzt.zzf().zzs(null, zzdu.zzau)) {
            zzkcVarZzu.zzt.zzay().zzl().zza("getSessionId has been disabled.");
        } else {
            if (zzkcVarZzu.zzt.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                if (!zzkcVarZzu.zzt.zzm().zzk(zzkcVarZzu.zzt.zzav().currentTimeMillis()) && zzkcVarZzu.zzt.zzm().zzk.zza() != 0) {
                    lValueOf = Long.valueOf(zzkcVarZzu.zzt.zzm().zzk.zza());
                }
                if (lValueOf != null) {
                    this.zzb.zzt.zzv().zzU(this.zza, lValueOf.longValue());
                }
                try {
                    this.zza.zze(null);
                } catch (RemoteException e11) {
                    this.zzb.zzt.zzay().zzd().zzb("getSessionId failed with exception", e11);
                    return;
                }
            }
            zzkcVarZzu.zzt.zzay().zzl().zza("Analytics storage consent denied; will not get session id");
        }
        lValueOf = null;
        if (lValueOf != null) {
            this.zzb.zzt.zzv().zzU(this.zza, lValueOf.longValue());
        } else {
            this.zza.zze(null);
        }
    }
}
