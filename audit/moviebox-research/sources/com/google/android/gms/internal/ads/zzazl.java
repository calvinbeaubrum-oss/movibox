package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzazl implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzazp zzb;

    public zzazl(zzazp zzazpVar, View view) {
        this.zza = view;
        this.zzb = zzazpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
