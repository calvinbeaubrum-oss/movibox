package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcdb implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzceu zzb;

    public zzcdb(zzcdc zzcdcVar, Context context, zzceu zzceuVar) {
        this.zza = context;
        this.zzb = zzceuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e11) {
            this.zzb.zzd(e11);
            zzcec.zzh("Exception while getting advertising Id info", e11);
        }
    }
}
