package k20;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f68215a;

        public b(String str, boolean z11) {
            this.f68215a = str;
        }

        public String a() {
            return this.f68215a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f68216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f68217b;

        public c() {
            this.f68216a = false;
            this.f68217b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f68216a) {
                throw new IllegalStateException();
            }
            this.f68216a = true;
            return this.f68217b.poll(10L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f68217b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IBinder f68218a;

        public d(IBinder iBinder) {
            this.f68218a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f68218a;
        }

        public String e0() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f68218a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public boolean f0(boolean z11) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z11 ? 1 : 0);
                this.f68218a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public static b a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, cVar, 1)) {
            try {
                try {
                    IBinder iBinderA = cVar.a();
                    if (iBinderA != null) {
                        d dVar = new d(iBinderA);
                        b bVar = new b(dVar.e0(), dVar.f0(true));
                        context.unbindService(cVar);
                        return bVar;
                    }
                    context.unbindService(cVar);
                } catch (Exception e11) {
                    throw e11;
                }
            } catch (Throwable th2) {
                context.unbindService(cVar);
                throw th2;
            }
            context.unbindService(cVar);
            throw th2;
        }
        throw new IOException("Google Play connection failed");
    }
}
