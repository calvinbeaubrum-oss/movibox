package hi;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import bg.b;
import bg.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: hi.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0696a extends b implements a {

        /* JADX INFO: renamed from: hi.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0697a extends bg.a implements a {
            public C0697a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // hi.a
            public final Bundle k(Bundle bundle) throws RemoteException {
                Parcel parcelE0 = e0();
                c.b(parcelE0, bundle);
                Parcel parcelF0 = f0(parcelE0);
                Bundle bundle2 = (Bundle) c.a(parcelF0, Bundle.CREATOR);
                parcelF0.recycle();
                return bundle2;
            }
        }

        public static a e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new C0697a(iBinder);
        }
    }

    Bundle k(Bundle bundle) throws RemoteException;
}
