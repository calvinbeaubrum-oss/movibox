package com.google.android.play.core.appupdate.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends a implements l {
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.core.appupdate.internal.l
    public final void T(String str, Bundle bundle, n nVar) throws RemoteException {
        Parcel parcelE0 = e0();
        parcelE0.writeString(str);
        i.c(parcelE0, bundle);
        parcelE0.writeStrongBinder(nVar);
        f0(3, parcelE0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.play.core.appupdate.internal.l
    public final void Z(String str, Bundle bundle, n nVar) throws RemoteException {
        Parcel parcelE0 = e0();
        parcelE0.writeString(str);
        i.c(parcelE0, bundle);
        parcelE0.writeStrongBinder(nVar);
        f0(2, parcelE0);
    }
}
