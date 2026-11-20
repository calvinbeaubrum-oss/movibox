package eq;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: eq.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0664a extends Binder implements a {

        /* JADX INFO: renamed from: eq.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0665a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static a f64341b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f64342a;

            public C0665a(IBinder iBinder) {
                this.f64342a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f64342a;
            }

            @Override // eq.a
            public String getId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.f64342a.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0664a.f0() != null) {
                        return AbstractBinderC0664a.f0().getId();
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
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0665a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static a f0() {
            return C0665a.f64341b;
        }
    }

    String getId() throws RemoteException;
}
