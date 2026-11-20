package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface zzbps extends IInterface {
    com.google.android.gms.ads.internal.client.zzdq zzb() throws RemoteException;

    zzbjj zzc() throws RemoteException;

    void zzd() throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbpv zzbpvVar) throws RemoteException;
}
