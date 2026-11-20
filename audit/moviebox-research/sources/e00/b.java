package e00;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: e00.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0655a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f63621a;

            public C0655a(IBinder iBinder) {
                this.f63621a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f63621a;
            }

            @Override // e00.b
            public void g(e00.a aVar, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.transsnet.dispenselib.IDispenseCommonService");
                    parcelObtain.writeStrongInterface(aVar);
                    parcelObtain.writeString(str);
                    this.f63621a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static b e0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.transsnet.dispenselib.IDispenseCommonService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0655a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }

    void g(e00.a aVar, String str) throws RemoteException;
}
