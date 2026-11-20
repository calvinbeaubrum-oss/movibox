package z0;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d extends IInterface {

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final String f81698u8 = "android$support$customtabs$IPostMessageService".replace('$', '.');

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, d.f81698u8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = d.f81698u8;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 == 2) {
                b(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), (Bundle) b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            } else {
                if (i11 != 3) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                f(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), parcel.readString(), (Bundle) b.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void b(z0.a aVar, Bundle bundle) throws RemoteException;

    void f(z0.a aVar, String str, Bundle bundle) throws RemoteException;
}
