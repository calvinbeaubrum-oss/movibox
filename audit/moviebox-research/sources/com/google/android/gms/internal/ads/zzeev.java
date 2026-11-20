package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeev implements zzgej {
    final /* synthetic */ zzbyx zza;

    public zzeev(zzeew zzeewVar, zzbyx zzbyxVar) {
        this.zza = zzbyxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        try {
            this.zza.zze(com.google.android.gms.ads.internal.util.zzbb.zzb(th2));
        } catch (RemoteException e11) {
            com.google.android.gms.ads.internal.util.zze.zzb("Ad service can't call client", e11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException e11) {
            com.google.android.gms.ads.internal.util.zze.zzb("Ad service can't call client", e11);
        }
    }
}
