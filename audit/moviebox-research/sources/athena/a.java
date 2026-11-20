package athena;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.transsion.athena.data.TrackData;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: athena.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static abstract class AbstractBinderC0131a extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f13596a = 0;

        /* JADX INFO: renamed from: athena.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0132a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f13597a;

            public C0132a(IBinder iBinder) {
                this.f13597a = iBinder;
            }

            @Override // athena.a
            public void V(String str, TrackData trackData, long j11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.transsion.athena.IAthenaTrackInterface");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(1);
                    trackData.writeToParcel(parcelObtain, 0);
                    parcelObtain.writeLong(j11);
                    if (!this.f13597a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i11 = AbstractBinderC0131a.f13596a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f13597a;
            }
        }

        public AbstractBinderC0131a() {
            attachInterface(this, "com.transsion.athena.IAthenaTrackInterface");
        }

        public static a e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.transsion.athena.IAthenaTrackInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0132a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1) {
                if (i11 != 1598968902) {
                    return super.onTransact(i11, parcel, parcel2, i12);
                }
                parcel2.writeString("com.transsion.athena.IAthenaTrackInterface");
                return true;
            }
            parcel.enforceInterface("com.transsion.athena.IAthenaTrackInterface");
            V(parcel.readString(), parcel.readInt() != 0 ? TrackData.CREATOR.createFromParcel(parcel) : null, parcel.readLong());
            parcel2.writeNoException();
            return true;
        }
    }

    void V(String str, TrackData trackData, long j11) throws RemoteException;
}
