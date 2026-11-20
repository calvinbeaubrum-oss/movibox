package com.mbridge.msdk.foundation.tools;

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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: compiled from: source.java */
    public final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f45020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f45021c;

        public a(String str, boolean z11) {
            this.f45020b = str;
            this.f45021c = z11;
        }

        public final String a() {
            return this.f45020b;
        }

        public final boolean b() {
            return this.f45021c;
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.tools.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public final class ServiceConnectionC0494b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f45022a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f45024c;

        private ServiceConnectionC0494b() {
            this.f45024c = new LinkedBlockingQueue<>(1);
            this.f45022a = false;
        }

        public final IBinder a() throws InterruptedException {
            if (this.f45022a) {
                throw new IllegalStateException();
            }
            this.f45022a = true;
            return this.f45024c.take();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f45024c.put(iBinder);
            } catch (InterruptedException e11) {
                ad.b("AdvertisingIdClient", e11.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements IInterface {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IBinder f45026b;

        public c(IBinder iBinder) {
            this.f45026b = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f45026b.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            } catch (Throwable th2) {
                try {
                    ad.b("AdvertisingIdClient", th2.getMessage());
                    return null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public final boolean a(boolean z11) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            boolean z12 = false;
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z11 ? 1 : 0);
                this.f45026b.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                if (parcelObtain2.readInt() != 0) {
                    z12 = true;
                }
            } catch (Throwable th2) {
                try {
                    ad.b("AdvertisingIdClient", th2.getMessage());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
            return z12;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f45026b;
        }
    }

    public final a a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        ServiceConnectionC0494b serviceConnectionC0494b = new ServiceConnectionC0494b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, serviceConnectionC0494b, 1)) {
            throw new IOException("Google Play connection failed");
        }
        try {
            try {
                c cVar = new c(serviceConnectionC0494b.a());
                a aVar = new a(cVar.a(), cVar.a(true));
                context.unbindService(serviceConnectionC0494b);
                return aVar;
            } catch (Exception e11) {
                throw e11;
            }
        } catch (Throwable th2) {
            context.unbindService(serviceConnectionC0494b);
            throw th2;
        }
    }
}
