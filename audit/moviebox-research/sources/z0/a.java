package z0;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final String f81692r8 = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* JADX INFO: renamed from: z0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static abstract class AbstractBinderC0920a extends Binder implements a {

        /* JADX INFO: renamed from: z0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0921a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f81693a;

            public C0921a(IBinder iBinder) {
                this.f81693a = iBinder;
            }

            @Override // z0.a
            public void M(int i11, int i12, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f81692r8);
                    parcelObtain.writeInt(i11);
                    parcelObtain.writeInt(i12);
                    b.d(parcelObtain, bundle, 0);
                    this.f81693a.transact(8, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // z0.a
            public void S(int i11, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f81692r8);
                    parcelObtain.writeInt(i11);
                    b.d(parcelObtain, bundle, 0);
                    this.f81693a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // z0.a
            public void X(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f81692r8);
                    parcelObtain.writeString(str);
                    b.d(parcelObtain, bundle, 0);
                    this.f81693a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.a
            public void Y(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f81692r8);
                    b.d(parcelObtain, bundle, 0);
                    this.f81693a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.a
            public void a0(int i11, Uri uri, boolean z11, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f81692r8);
                    parcelObtain.writeInt(i11);
                    b.d(parcelObtain, uri, 0);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    b.d(parcelObtain, bundle, 0);
                    this.f81693a.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f81693a;
            }

            @Override // z0.a
            public Bundle h(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f81692r8);
                    parcelObtain.writeString(str);
                    b.d(parcelObtain, bundle, 0);
                    this.f81693a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) b.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.a
            public void s(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.f81692r8);
                    parcelObtain.writeString(str);
                    b.d(parcelObtain, bundle, 0);
                    this.f81693a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0920a() {
            attachInterface(this, a.f81692r8);
        }

        public static a e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.f81692r8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0921a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = a.f81692r8;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i11) {
                case 2:
                    S(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 3:
                    s(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 4:
                    Y((Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    X(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    a0(parcel.readInt(), (Uri) b.c(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 7:
                    Bundle bundleH = h(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.d(parcel2, bundleH, 1);
                    return true;
                case 8:
                    M(parcel.readInt(), parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
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

    void M(int i11, int i12, Bundle bundle) throws RemoteException;

    void S(int i11, Bundle bundle) throws RemoteException;

    void X(String str, Bundle bundle) throws RemoteException;

    void Y(Bundle bundle) throws RemoteException;

    void a0(int i11, Uri uri, boolean z11, Bundle bundle) throws RemoteException;

    Bundle h(String str, Bundle bundle) throws RemoteException;

    void s(String str, Bundle bundle) throws RemoteException;
}
