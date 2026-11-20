package com.google.android.gms.internal.ads;

import android.media.Spatializer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzxy implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzyg zza;

    public zzxy(zzxz zzxzVar, zzyg zzygVar) {
        this.zza = zzygVar;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z11) {
        this.zza.zzv();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z11) {
        this.zza.zzv();
    }
}
