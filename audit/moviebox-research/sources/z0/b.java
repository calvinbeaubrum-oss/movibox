package z0;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final String f81694s8 = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: z0.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0922a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f81695a;

            public C0922a(IBinder iBinder) {
                this.f81695a = iBinder;
            }

            @Override // z0.b
            public boolean B(z0.a aVar, Uri uri) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    C0923b.f(parcelObtain, uri, 0);
                    this.f81695a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public boolean K(long j11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeLong(j11);
                    this.f81695a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public int P(z0.a aVar, String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    parcelObtain.writeString(str);
                    C0923b.f(parcelObtain, bundle, 0);
                    this.f81695a.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public boolean a(z0.a aVar, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    C0923b.f(parcelObtain, bundle, 0);
                    this.f81695a.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f81695a;
            }

            @Override // z0.b
            public boolean d(z0.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f81695a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public boolean d0(z0.a aVar, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    C0923b.f(parcelObtain, bundle, 0);
                    this.f81695a.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public boolean e(z0.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    C0923b.f(parcelObtain, uri, 0);
                    C0923b.f(parcelObtain, bundle, 0);
                    C0923b.e(parcelObtain, list, 0);
                    this.f81695a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public boolean q(z0.a aVar, Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    C0923b.f(parcelObtain, uri, 0);
                    C0923b.f(parcelObtain, bundle, 0);
                    this.f81695a.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public boolean w(z0.a aVar, int i11, Uri uri, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    parcelObtain.writeInt(i11);
                    C0923b.f(parcelObtain, uri, 0);
                    C0923b.f(parcelObtain, bundle, 0);
                    this.f81695a.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // z0.b
            public boolean z(z0.a aVar, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.f81694s8);
                    parcelObtain.writeStrongInterface(aVar);
                    parcelObtain.writeStrongBinder(iBinder);
                    C0923b.f(parcelObtain, bundle, 0);
                    this.f81695a.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, b.f81694s8);
        }

        public static b e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b.f81694s8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0922a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = b.f81694s8;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i11) {
                case 2:
                    boolean zK = K(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zK ? 1 : 0);
                    return true;
                case 3:
                    boolean zD = d(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zD ? 1 : 0);
                    return true;
                case 4:
                    z0.a aVarE0 = z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder());
                    Uri uri = (Uri) C0923b.d(parcel, Uri.CREATOR);
                    Parcelable.Creator creator = Bundle.CREATOR;
                    boolean zE = e(aVarE0, uri, (Bundle) C0923b.d(parcel, creator), parcel.createTypedArrayList(creator));
                    parcel2.writeNoException();
                    parcel2.writeInt(zE ? 1 : 0);
                    return true;
                case 5:
                    Bundle bundleI = i(parcel.readString(), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0923b.f(parcel2, bundleI, 1);
                    return true;
                case 6:
                    boolean zJ = j(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zJ ? 1 : 0);
                    return true;
                case 7:
                    boolean zB = B(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), (Uri) C0923b.d(parcel, Uri.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zB ? 1 : 0);
                    return true;
                case 8:
                    int iP = P(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), parcel.readString(), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(iP);
                    return true;
                case 9:
                    boolean zW = w(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), parcel.readInt(), (Uri) C0923b.d(parcel, Uri.CREATOR), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zW ? 1 : 0);
                    return true;
                case 10:
                    boolean zD0 = d0(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zD0 ? 1 : 0);
                    return true;
                case 11:
                    boolean zQ = q(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), (Uri) C0923b.d(parcel, Uri.CREATOR), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zQ ? 1 : 0);
                    return true;
                case 12:
                    boolean zC = C(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), (Uri) C0923b.d(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zC ? 1 : 0);
                    return true;
                case 13:
                    boolean zA = a(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(zA ? 1 : 0);
                    return true;
                case 14:
                    boolean z11 = z(z0.a.AbstractBinderC0920a.e0(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) C0923b.d(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(z11 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i11, parcel, parcel2, i12);
            }
        }
    }

    /* JADX INFO: renamed from: z0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0923b {
        public static <T> T d(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void e(Parcel parcel, List<T> list, int i11) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i12 = 0; i12 < size; i12++) {
                f(parcel, list.get(i12), i11);
            }
        }

        public static <T extends Parcelable> void f(Parcel parcel, T t11, int i11) {
            if (t11 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t11.writeToParcel(parcel, i11);
            }
        }
    }

    boolean B(z0.a aVar, Uri uri) throws RemoteException;

    boolean C(z0.a aVar, Uri uri, int i11, Bundle bundle) throws RemoteException;

    boolean K(long j11) throws RemoteException;

    int P(z0.a aVar, String str, Bundle bundle) throws RemoteException;

    boolean a(z0.a aVar, Bundle bundle) throws RemoteException;

    boolean d(z0.a aVar) throws RemoteException;

    boolean d0(z0.a aVar, Bundle bundle) throws RemoteException;

    boolean e(z0.a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    Bundle i(String str, Bundle bundle) throws RemoteException;

    boolean j(z0.a aVar, Bundle bundle) throws RemoteException;

    boolean q(z0.a aVar, Uri uri, Bundle bundle) throws RemoteException;

    boolean w(z0.a aVar, int i11, Uri uri, Bundle bundle) throws RemoteException;

    boolean z(z0.a aVar, IBinder iBinder, Bundle bundle) throws RemoteException;
}
