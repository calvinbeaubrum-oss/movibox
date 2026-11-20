package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zbs extends com.google.android.gms.internal.p001authapi.zba {
    public zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zbc(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p001authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p001authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(Worker.WHAT_SYNC_DATA, parcelZba);
    }

    public final void zbd(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p001authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p001authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(102, parcelZba);
    }

    public final void zbe(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel parcelZba = zba();
        com.google.android.gms.internal.p001authapi.zbc.zbd(parcelZba, zbrVar);
        com.google.android.gms.internal.p001authapi.zbc.zbc(parcelZba, googleSignInOptions);
        zbb(101, parcelZba);
    }
}
