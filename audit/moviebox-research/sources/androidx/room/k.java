package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface k extends IInterface {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements k {

        /* JADX INFO: renamed from: androidx.room.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0119a implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f12860a;

            public C0119a(IBinder iBinder) {
                this.f12860a = iBinder;
            }

            @Override // androidx.room.k
            public int H(j jVar, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeStrongInterface(jVar);
                    parcelObtain.writeString(str);
                    this.f12860a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f12860a;
            }

            @Override // androidx.room.k
            public void y(int i11, String[] strArr) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeStringArray(strArr);
                    this.f12860a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static k e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k)) ? new C0119a(iBinder) : (k) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            }
            if (i11 == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
            if (i11 == 1) {
                int iH = H(j.a.e0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(iH);
            } else if (i11 == 2) {
                c0(j.a.e0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
            } else {
                if (i11 != 3) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                y(parcel.readInt(), parcel.createStringArray());
            }
            return true;
        }
    }

    int H(j jVar, String str) throws RemoteException;

    void c0(j jVar, int i11) throws RemoteException;

    void y(int i11, String[] strArr) throws RemoteException;
}
