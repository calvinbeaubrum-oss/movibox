package pd;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: pd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0801a extends Binder implements a {

        /* JADX INFO: renamed from: pd.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0802a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static a f73736b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f73737a;

            public C0802a(IBinder iBinder) {
                this.f73737a = iBinder;
            }

            @Override // pd.a
            public boolean G(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f73737a.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0801a.f0() != null) {
                        return AbstractBinderC0801a.f0().G(str, str2, bundle);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // pd.a
            public boolean J(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.f73737a.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0801a.f0() != null) {
                        return AbstractBinderC0801a.f0().J(str, str2, bundle);
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
                return this.f73737a;
            }
        }

        public AbstractBinderC0801a() {
            attachInterface(this, "com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
        }

        public static a e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0802a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a f0() {
            return C0802a.f73736b;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                parcel.enforceInterface("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
                boolean zU = u(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zU ? 1 : 0);
                return true;
            }
            if (i11 == 2) {
                parcel.enforceInterface("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
                boolean zG = G(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zG ? 1 : 0);
                return true;
            }
            if (i11 == 3) {
                parcel.enforceInterface("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
                boolean zJ = J(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zJ ? 1 : 0);
                return true;
            }
            if (i11 != 4) {
                if (i11 != 1598968902) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                parcel2.writeString("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
                return true;
            }
            parcel.enforceInterface("com.cloud.tmc.miniapp.protocol.IIpcMiniProtocolMainChannel");
            boolean zM = m(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(zM ? 1 : 0);
            return true;
        }
    }

    boolean G(String str, String str2, Bundle bundle) throws RemoteException;

    boolean J(String str, String str2, Bundle bundle) throws RemoteException;

    boolean m(String str, String str2, Bundle bundle) throws RemoteException;

    boolean u(String str, String str2, Bundle bundle) throws RemoteException;
}
