package com.applovin.impl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m2 extends Binder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f20569a;

    static {
        f20569a = xp.f24372a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public static eb a(IBinder iBinder) {
        int i11;
        eb.a aVarF = eb.f();
        int i12 = 1;
        int i13 = 0;
        while (i12 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i13);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i11 = parcelObtain2.readInt();
                        if (i11 == 1) {
                            aVarF.b((Bundle) b1.a(parcelObtain2.readBundle()));
                            i13++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i12 = i11;
                } catch (RemoteException e11) {
                    throw new RuntimeException(e11);
                }
            } catch (Throwable th2) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th2;
            }
        }
        return aVarF.a();
    }
}
