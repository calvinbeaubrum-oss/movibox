package op;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: op.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0783a extends Binder implements a {

        /* JADX INFO: renamed from: op.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0784a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static a f72505b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f72506a;

            public C0784a(IBinder iBinder) {
                this.f72506a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f72506a;
            }

            @Override // op.a
            public String getId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.f72506a.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0783a.f0() != null) {
                        return AbstractBinderC0783a.f0().getId();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0784a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a f0() {
            return C0784a.f72505b;
        }
    }

    String getId() throws RemoteException;
}
