package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcjp implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzcbs zza;
    final /* synthetic */ zzcjs zzb;

    public zzcjp(zzcjs zzcjsVar, zzcbs zzcbsVar) {
        this.zza = zzcbsVar;
        this.zzb = zzcjsVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzS(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
