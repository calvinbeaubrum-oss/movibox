package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzboh;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzcct;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface zzce extends IInterface {
    zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzbu zze(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, int i11) throws RemoteException;

    zzco zzg(IObjectWrapper iObjectWrapper, int i11) throws RemoteException;

    zzdj zzh(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzbjq zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    zzbjw zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzboh zzk(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i11, zzboe zzboeVar) throws RemoteException;

    zzbwm zzl(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzbwt zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzbzx zzn(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzcan zzo(IObjectWrapper iObjectWrapper, String str, zzbsv zzbsvVar, int i11) throws RemoteException;

    zzcct zzp(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i11) throws RemoteException;
}
