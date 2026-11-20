package e00;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: e00.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0654a extends Binder implements a {
        public AbstractBinderC0654a() {
            attachInterface(this, "com.transsnet.dispenselib.IDispenseCommonCallBack");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface("com.transsnet.dispenselib.IDispenseCommonCallBack");
            }
            if (i11 == 1598968902) {
                parcel2.writeString("com.transsnet.dispenselib.IDispenseCommonCallBack");
                return true;
            }
            if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            }
            W(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void W(String str, String str2) throws RemoteException;
}
