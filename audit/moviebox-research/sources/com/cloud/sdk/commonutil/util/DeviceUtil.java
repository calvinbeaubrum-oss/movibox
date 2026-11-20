package com.cloud.sdk.commonutil.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.transsion.sdk.oneid.OneID;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class DeviceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f30253a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f30254b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f30256d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f30255c = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f30257e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f30258f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f30259g = 0;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class a {

        /* JADX INFO: renamed from: com.cloud.sdk.commonutil.util.DeviceUtil$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0334a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f30260a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f30261b;

            public C0334a(String str, boolean z11) {
                this.f30260a = str;
                this.f30261b = z11;
            }

            public String a() {
                return this.f30260a;
            }

            public boolean b() {
                return this.f30261b;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class b implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f30262a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final LinkedBlockingQueue<IBinder> f30263b;

            public b() {
                this.f30262a = false;
                this.f30263b = new LinkedBlockingQueue<>(1);
            }

            public IBinder a() throws InterruptedException {
                if (this.f30262a) {
                    throw new IllegalStateException();
                }
                this.f30262a = true;
                return this.f30263b.take();
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    this.f30263b.put(iBinder);
                } catch (Exception e11) {
                    com.cloud.sdk.commonutil.util.c.Log().e(Log.getStackTraceString(e11));
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class c implements IInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f30264a;

            public c(IBinder iBinder) {
                this.f30264a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f30264a;
            }

            public boolean e0(boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.f30264a.transact(2, parcelObtain, parcelObtain2, 0);
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
                    this.f30264a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static C0334a a(Context context) throws Exception {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                try {
                    c cVar = new c(bVar.a());
                    C0334a c0334a = new C0334a(cVar.getId(), cVar.e0(true));
                    context.unbindService(bVar);
                    return c0334a;
                } catch (Exception e11) {
                    throw e11;
                }
            } catch (Throwable th2) {
                context.unbindService(bVar);
                throw th2;
            }
        }
    }

    public static boolean b(String str, AtomicInteger atomicInteger, int i11) {
        return TextUtils.isEmpty(str) && atomicInteger.getAndIncrement() < i11;
    }

    public static String c() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            sb2.append(strArr[i11]);
            if (i11 < strArr.length - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    public static String d() {
        try {
            if (!TextUtils.isEmpty(f30254b)) {
                return f30254b;
            }
            String simCountryIso = ((TelephonyManager) f.a().getSystemService("phone")).getSimCountryIso();
            if (TextUtils.isEmpty(simCountryIso)) {
                return "";
            }
            String upperCase = simCountryIso.toUpperCase();
            f30254b = upperCase;
            return upperCase;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        if (TextUtils.isEmpty(f30257e)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - f30259g < 10000) {
                return f30257e;
            }
            f30259g = jCurrentTimeMillis;
            f30257e = da.a.d().i("device_util_ga_id");
            if (Looper.myLooper() == Looper.getMainLooper()) {
                t.a().b(new Runnable() { // from class: com.cloud.sdk.commonutil.util.DeviceUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DeviceUtil.q();
                    }
                });
            } else {
                q();
            }
        }
        return f30257e;
    }

    public static int f() {
        if (f30258f == 0) {
            f30258f = da.a.d().f("is_limit_ad_tracking_enabled", 0);
        }
        return f30258f;
    }

    public static String g() {
        int cid;
        int lac;
        if (!b(f30253a, f30255c, 1)) {
            return f30253a;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f.a().getSystemService("phone");
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation == null) {
                return "";
            }
            if (telephonyManager.getPhoneType() == 2) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                cid = cdmaCellLocation.getBaseStationId();
                lac = cdmaCellLocation.getNetworkId();
            } else {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                cid = gsmCellLocation.getCid();
                lac = gsmCellLocation.getLac();
            }
            String str = cid + "|" + lac;
            f30253a = str;
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) f.a().getApplicationContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo.isConnected()) {
                f30256d = i();
            } else if (networkInfo2.isConnected()) {
                f30256d = o(((WifiManager) f.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
            }
        } catch (Exception e11) {
            c.Log().d("ssp", "获取本地ip地址失败 " + e11.getMessage());
        }
        return f30256d;
    }

    public static String i() {
        String hostAddress = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && p(inetAddressNextElement.getHostAddress())) {
                        hostAddress = inetAddressNextElement.getHostAddress();
                    }
                }
            }
        } catch (SocketException e11) {
            c.Log().d("ssp", "获取本地ip地址失败 " + e11.getMessage());
        }
        return hostAddress;
    }

    public static String j() {
        try {
            return OneID.e().a(2411);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int k() {
        return Build.VERSION.SDK_INT;
    }

    public static String l() {
        return Build.VERSION.RELEASE.replace(";", "");
    }

    public static long m() {
        try {
            ActivityManager activityManager = (ActivityManager) f.a().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        } catch (Exception e11) {
            c.Log().d("ssp", "获取本地运行内存失败 " + e11.getMessage());
            return 0L;
        }
    }

    public static String n() {
        return UUID.randomUUID().toString();
    }

    public static String o(int i11) {
        return (i11 & 255) + InstructionFileId.DOT + ((i11 >> 8) & 255) + InstructionFileId.DOT + ((i11 >> 16) & 255) + InstructionFileId.DOT + ((i11 >> 24) & 255);
    }

    public static boolean p(String str) {
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e11) {
            c.Log().d("ssp", "获取本地ip地址失败 " + e11.getMessage());
            return false;
        }
    }

    public static void q() {
        try {
            a.C0334a c0334aA = a.a(f.a());
            if (c0334aA == null || c0334aA.a().equals(f30257e)) {
                return;
            }
            f30257e = c0334aA.a();
            boolean zB = c0334aA.b();
            da.a.d().p("device_util_ga_id", f30257e);
            da.a.d().n("is_limit_ad_tracking_enabled", zB ? 1 : 2);
            c.Log().i("ssp", "gaid limit ：" + zB + " GAID is ：" + f30257e);
        } catch (Exception e11) {
            Log.e("DeviceUtil", Log.getStackTraceString(e11));
        }
    }
}
