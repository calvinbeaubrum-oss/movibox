package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeot implements com.google.android.gms.ads.internal.zzf {
    final /* synthetic */ zzdjo zza;

    public zzeot(zzeou zzeouVar, zzdjo zzdjoVar) {
        this.zza = zzdjoVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
        this.zza.zzb().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
        this.zza.zzc().zza();
        this.zza.zzf().zza();
    }
}
