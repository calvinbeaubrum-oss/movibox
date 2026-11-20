package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbpk;
import com.google.android.gms.internal.ads.zzbsv;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface zzco extends IInterface {
    float zze() throws RemoteException;

    String zzf() throws RemoteException;

    List zzg() throws RemoteException;

    void zzh(@Nullable String str) throws RemoteException;

    void zzi() throws RemoteException;

    void zzj(boolean z11) throws RemoteException;

    void zzk() throws RemoteException;

    void zzl(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzm(zzda zzdaVar) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzo(zzbsv zzbsvVar) throws RemoteException;

    void zzp(boolean z11) throws RemoteException;

    void zzq(float f11) throws RemoteException;

    void zzr(String str) throws RemoteException;

    void zzs(zzbpk zzbpkVar) throws RemoteException;

    void zzt(String str) throws RemoteException;

    void zzu(zzff zzffVar) throws RemoteException;

    boolean zzv() throws RemoteException;
}
