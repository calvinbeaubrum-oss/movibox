package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbbd extends zzayg {
    public zzbbd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbbb zzbbbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbbbVar);
        Parcel parcelZzbl = zzbl(3, parcelZza);
        long j11 = parcelZzbl.readLong();
        parcelZzbl.recycle();
        return j11;
    }

    public final zzbay zzf(zzbbb zzbbbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbbbVar);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        zzbay zzbayVar = (zzbay) zzayi.zza(parcelZzbl, zzbay.CREATOR);
        parcelZzbl.recycle();
        return zzbayVar;
    }

    public final zzbay zzg(zzbbb zzbbbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbbbVar);
        Parcel parcelZzbl = zzbl(2, parcelZza);
        zzbay zzbayVar = (zzbay) zzayi.zza(parcelZzbl, zzbay.CREATOR);
        parcelZzbl.recycle();
        return zzbayVar;
    }
}
