package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IBinderPool extends IInterface {

    /* JADX INFO: compiled from: source.java */
    public static class Default implements IBinderPool {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i11) throws RemoteException {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class Stub extends Binder implements IBinderPool {

        /* JADX INFO: compiled from: source.java */
        public static class sc implements IBinderPool {

            /* JADX INFO: renamed from: sc, reason: collision with root package name */
            public static IBinderPool f27082sc;
            private IBinder pFF;

            public sc(IBinder iBinder) {
                this.pFF = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.pFF;
            }

            @Override // com.bytedance.sdk.openadsdk.IBinderPool
            public IBinder queryBinder(int i11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IBinderPool");
                    parcelObtain.writeInt(i11);
                    if (!this.pFF.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryBinder(i11);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readStrongBinder();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IBinderPool");
        }

        public static IBinderPool asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IBinderPool");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IBinderPool)) ? new sc(iBinder) : (IBinderPool) iInterfaceQueryLocalInterface;
        }

        public static IBinderPool getDefaultImpl() {
            return sc.f27082sc;
        }

        public static boolean setDefaultImpl(IBinderPool iBinderPool) {
            if (sc.f27082sc != null || iBinderPool == null) {
                return false;
            }
            sc.f27082sc = iBinderPool;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1) {
                if (i11 != 1598968902) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.IBinderPool");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IBinderPool");
            IBinder iBinderQueryBinder = queryBinder(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(iBinderQueryBinder);
            return true;
        }
    }

    IBinder queryBinder(int i11) throws RemoteException;
}
