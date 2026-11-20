package com.google.android.exoplayer2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends Binder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33221b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<Bundle> f33222a;

    static {
        f33221b = com.google.android.exoplayer2.util.o0.f35608a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public f(List<Bundle> list) {
        this.f33222a = ImmutableList.copyOf((Collection) list);
    }

    public static ImmutableList<Bundle> a(IBinder iBinder) {
        int i11;
        ImmutableList.a aVarBuilder = ImmutableList.builder();
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
                            aVarBuilder.a((Bundle) com.google.android.exoplayer2.util.a.e(parcelObtain2.readBundle()));
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
        return aVarBuilder.m();
    }

    @Override // android.os.Binder
    public boolean onTransact(int i11, Parcel parcel, @Nullable Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return super.onTransact(i11, parcel, parcel2, i12);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.f33222a.size();
        int i13 = parcel.readInt();
        while (i13 < size && parcel2.dataSize() < f33221b) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.f33222a.get(i13));
            i13++;
        }
        parcel2.writeInt(i13 < size ? 2 : 0);
        return true;
    }
}
