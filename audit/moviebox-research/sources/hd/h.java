package hd;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface h extends IInterface {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "com.cloud.tmc.miniapp.IIpcMiniPSChannel");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniPSChannel");
                boolean zX = x(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zX ? 1 : 0);
                return true;
            }
            if (i11 == 2) {
                parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniPSChannel");
                boolean zQ = Q(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zQ ? 1 : 0);
                return true;
            }
            if (i11 == 3) {
                parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniPSChannel");
                boolean zV = v(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(zV ? 1 : 0);
                return true;
            }
            if (i11 != 4) {
                if (i11 != 1598968902) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                parcel2.writeString("com.cloud.tmc.miniapp.IIpcMiniPSChannel");
                return true;
            }
            parcel.enforceInterface("com.cloud.tmc.miniapp.IIpcMiniPSChannel");
            boolean zR = r(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(zR ? 1 : 0);
            return true;
        }
    }

    boolean Q(String str, String str2, Bundle bundle) throws RemoteException;

    boolean r(String str, String str2, Bundle bundle) throws RemoteException;

    boolean v(String str, String str2, Bundle bundle) throws RemoteException;

    boolean x(String str, String str2, Bundle bundle) throws RemoteException;
}
