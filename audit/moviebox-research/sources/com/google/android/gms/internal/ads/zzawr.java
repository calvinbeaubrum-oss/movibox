package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzawr implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzaws zza;

    public zzawr(zzaws zzawsVar) {
        this.zza = zzawsVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i11, String str2, boolean z11) {
        if (z11) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzaws zzawsVar = this.zza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zzawsVar.zzc > 0) {
            zzaws zzawsVar2 = this.zza;
            if (jCurrentTimeMillis >= zzawsVar2.zzc) {
                zzawsVar2.zzd = jCurrentTimeMillis - zzawsVar2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
