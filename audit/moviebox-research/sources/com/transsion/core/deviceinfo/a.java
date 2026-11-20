package com.transsion.core.deviceinfo;

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
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f51782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f51783b;

        public b(String str, boolean z11) {
            this.f51782a = str;
            this.f51783b = z11;
        }

        public String a() {
            return this.f51782a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f51784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f51785b;

        public c() {
            this.f51784a = false;
            this.f51785b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f51784a) {
                throw new IllegalStateException();
            }
            this.f51784a = true;
            return this.f51785b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                if (this.f51785b.size() == 0) {
                    this.f51785b.put(iBinder);
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                this.f51785b.clear();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IBinder f51786a;

        public d(IBinder iBinder) {
            this.f51786a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f51786a;
        }

        public boolean e0(boolean z11) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z11 ? 1 : 0);
                this.f51786a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public String getId() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f51786a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
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
        if (!context.bindService(intent, cVar, 1)) {
            throw new IOException("Google Play connection failed");
        }
        try {
            try {
                d dVar = new d(cVar.a());
                b bVar = new b(dVar.getId(), dVar.e0(true));
                context.unbindService(cVar);
                return bVar;
            } catch (Exception e11) {
                throw e11;
            }
        } catch (Throwable th2) {
            context.unbindService(cVar);
            throw th2;
        }
    }
}
