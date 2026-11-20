package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbak extends zzayg implements zzbam {
    public zzbak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void zzb(int i11) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i11);
        zzbm(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final void zzd(zzbaj zzbajVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzbajVar);
        zzbm(1, parcelZza);
    }
}
