package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f38045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38046b = "com.google.android.play.core.appupdate.protocol.IAppUpdateService";

    public a(IBinder iBinder, String str) {
        this.f38045a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f38045a;
    }

    public final Parcel e0() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f38046b);
        return parcelObtain;
    }

    public final void f0(int i11, Parcel parcel) throws RemoteException {
        try {
            this.f38045a.transact(i11, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
