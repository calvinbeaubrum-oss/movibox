package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcyk implements com.google.android.gms.ads.internal.client.zza {
    private final zzcyo zza;
    private final zzfhh zzb;

    public zzcyk(zzcyo zzcyoVar, zzfhh zzfhhVar) {
        this.zza = zzcyoVar;
        this.zzb = zzfhhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
