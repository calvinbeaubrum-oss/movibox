package y2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final String f81097o8 = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, b.f81097o8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = b.f81097o8;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 != 1) {
                return super.onTransact(i11, parcel, parcel2, i12);
            }
            E(y2.a.AbstractBinderC0909a.e0(parcel.readStrongBinder()));
            return true;
        }
    }

    void E(y2.a aVar) throws RemoteException;
}
