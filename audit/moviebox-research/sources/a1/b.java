package a1;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {
    public static final String V7 = "android$support$customtabs$trusted$ITrustedWebActivityService".replace('$', '.');

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, b.V7);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = b.V7;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i11) {
                case 2:
                    Bundle bundleT = t((Bundle) C0017b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0017b.d(parcel2, bundleT, 1);
                    return true;
                case 3:
                    R((Bundle) C0017b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    int iN = N();
                    parcel2.writeNoException();
                    parcel2.writeInt(iN);
                    return true;
                case 5:
                    Bundle bundleD = D();
                    parcel2.writeNoException();
                    C0017b.d(parcel2, bundleD, 1);
                    return true;
                case 6:
                    Bundle bundleO = O((Bundle) C0017b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0017b.d(parcel2, bundleO, 1);
                    return true;
                case 7:
                    Bundle bundleO2 = o();
                    parcel2.writeNoException();
                    C0017b.d(parcel2, bundleO2, 1);
                    return true;
                case 8:
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
                case 9:
                    Bundle bundleL = l(parcel.readString(), (Bundle) C0017b.c(parcel, Bundle.CREATOR), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    C0017b.d(parcel2, bundleL, 1);
                    return true;
            }
        }
    }

    /* JADX INFO: renamed from: a1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0017b {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t11, int i11) {
            if (t11 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t11.writeToParcel(parcel, i11);
            }
        }
    }

    Bundle D() throws RemoteException;

    int N() throws RemoteException;

    Bundle O(Bundle bundle) throws RemoteException;

    void R(Bundle bundle) throws RemoteException;

    Bundle l(String str, Bundle bundle, IBinder iBinder) throws RemoteException;

    Bundle o() throws RemoteException;

    Bundle t(Bundle bundle) throws RemoteException;
}
