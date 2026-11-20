package hd;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface g extends IInterface {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: hd.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0694a implements g {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static g f66427b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f66428a;

            public C0694a(IBinder iBinder) {
                this.f66428a = iBinder;
            }

            @Override // hd.g
            public boolean A(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f66428a.transact(1, parcelObtain, parcelObtain2, 0) && a.f0() != null) {
                        return a.f0().A(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // hd.g
            public boolean F(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f66428a.transact(7, parcelObtain, parcelObtain2, 0) && a.f0() != null) {
                        return a.f0().F(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // hd.g
            public boolean I(String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (!this.f66428a.transact(4, parcelObtain, parcelObtain2, 0) && a.f0() != null) {
                        return a.f0().I(str, str2);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // hd.g
            public boolean U() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    if (!this.f66428a.transact(6, parcelObtain, parcelObtain2, 0) && a.f0() != null) {
                        return a.f0().U();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f66428a;
            }

            @Override // hd.g
            public boolean b0(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f66428a.transact(3, parcelObtain, parcelObtain2, 0) && a.f0() != null) {
                        return a.f0().b0(str, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // hd.g
            public boolean n(int i11, int i12) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    if (!this.f66428a.transact(5, parcelObtain, parcelObtain2, 0) && a.f0() != null) {
                        return a.f0().n(i11, i12);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // hd.g
            public boolean p(boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    if (!this.f66428a.transact(2, parcelObtain, parcelObtain2, 0) && a.f0() != null) {
                        return a.f0().p(z11);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
        }

        public static g e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof g)) ? new C0694a(iBinder) : (g) iInterfaceQueryLocalInterface;
        }

        public static g f0() {
            return C0694a.f66427b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1598968902) {
                parcel2.writeString("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                return true;
            }
            switch (i11) {
                case 1:
                    parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    boolean zA = A(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    boolean zP = p(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(zP ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    boolean zB0 = b0(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zB0 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    boolean zI = I(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zI ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    boolean zN = n(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zN ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    boolean zU = U();
                    parcel2.writeNoException();
                    parcel2.writeInt(zU ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniLauncherChannel");
                    boolean zF = F(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zF ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
            }
        }
    }

    boolean A(String str, Bundle bundle) throws RemoteException;

    boolean F(String str, Bundle bundle) throws RemoteException;

    boolean I(String str, String str2) throws RemoteException;

    boolean U() throws RemoteException;

    boolean b0(String str, Bundle bundle) throws RemoteException;

    boolean n(int i11, int i12) throws RemoteException;

    boolean p(boolean z11) throws RemoteException;
}
