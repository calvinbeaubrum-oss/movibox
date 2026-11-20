package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzjh implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjl zzb;

    public zzjh(zzjl zzjlVar, ComponentName componentName) {
        this.zzb = zzjlVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm.zzo(this.zzb.zza, this.zza);
    }
}
