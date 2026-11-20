package com.google.android.play.core.appupdate.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class m extends h implements n {
    public m() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.appupdate.internal.h
    public final boolean e0(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 == 2) {
            Bundle bundle = (Bundle) i.a(parcel, Bundle.CREATOR);
            i.b(parcel);
            L(bundle);
            return true;
        }
        if (i11 != 3) {
            return false;
        }
        Bundle bundle2 = (Bundle) i.a(parcel, Bundle.CREATOR);
        i.b(parcel);
        zzb(bundle2);
        return true;
    }
}
