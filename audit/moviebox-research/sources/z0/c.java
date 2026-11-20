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
public interface c extends IInterface {

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final String f81696t8 = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements c {

        /* JADX INFO: renamed from: z0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0924a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f81697a;

            public C0924a(IBinder iBinder) {
                this.f81697a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f81697a;
            }

            @Override // z0.c
            public void onGreatestScrollPercentageIncreased(int i11, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f81696t8);
                    parcelObtain.writeInt(i11);
                    b.d(parcelObtain, bundle, 0);
                    this.f81697a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // z0.c
            public void onSessionEnded(boolean z11, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f81696t8);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    b.d(parcelObtain, bundle, 0);
                    this.f81697a.transact(4, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // z0.c
            public void onVerticalScrollEvent(boolean z11, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(c.f81696t8);
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    b.d(parcelObtain, bundle, 0);
                    this.f81697a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, c.f81696t8);
        }

        public static c e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c.f81696t8);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0924a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            String str = c.f81696t8;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i11 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i11 == 2) {
                onVerticalScrollEvent(parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
            } else if (i11 == 3) {
                onGreatestScrollPercentageIncreased(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
            } else {
                if (i11 != 4) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                onSessionEnded(parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
            }
            return true;
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

    void onGreatestScrollPercentageIncreased(int i11, Bundle bundle) throws RemoteException;

    void onSessionEnded(boolean z11, Bundle bundle) throws RemoteException;

    void onVerticalScrollEvent(boolean z11, Bundle bundle) throws RemoteException;
}
