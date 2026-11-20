package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbpw extends zzayg implements zzbpy {
    public zzbpw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbpy
    public final void zze(int i11) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i11);
        zzbm(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpy
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpy
    public final void zzg(zzbps zzbpsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzbpsVar);
        zzbm(1, parcelZza);
    }
}
