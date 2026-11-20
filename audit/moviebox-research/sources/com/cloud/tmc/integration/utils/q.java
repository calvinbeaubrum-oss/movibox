package com.cloud.tmc.integration.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.transsion.core.log.LogUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f31092b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f31094d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f31098h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f31091a = new q();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f31093c = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f31095e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f31096f = "device_util_ga_id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f31097g = System.currentTimeMillis();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicInteger f31099i = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f31100j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f31101k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f31102l = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f31103a = new a();

        /* JADX INFO: renamed from: com.cloud.tmc.integration.utils.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0340a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f31104a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f31105b;

            public C0340a(String str, boolean z11) {
                this.f31104a = str;
                this.f31105b = z11;
            }

            public final String a() {
                return this.f31104a;
            }

            public final boolean b() {
                return this.f31105b;
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class b implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f31106a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final LinkedBlockingQueue<IBinder> f31107b = new LinkedBlockingQueue<>(1);

            public final IBinder a() throws InterruptedException {
                if (this.f31106a) {
                    throw new IllegalStateException();
                }
                this.f31106a = true;
                return this.f31107b.take();
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.g(name, "name");
                Intrinsics.g(service, "service");
                try {
                    this.f31107b.put(service);
                } catch (InterruptedException e11) {
                    Log.e("DeviceUtil", "getLocalIpAddress: ", e11);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Intrinsics.g(name, "name");
            }
        }

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class c implements IInterface {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f31108a;

            public c(IBinder binder) {
                Intrinsics.g(binder, "binder");
                this.f31108a = binder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f31108a;
            }

            public final boolean e0(boolean z11) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.f(parcelObtain, "obtain()");
                Parcel parcelObtain2 = Parcel.obtain();
                Intrinsics.f(parcelObtain2, "obtain()");
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcelObtain.writeInt(z11 ? 1 : 0);
                    this.f31108a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            public final String getId() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.f(parcelObtain, "obtain()");
                Parcel parcelObtain2 = Parcel.obtain();
                Intrinsics.f(parcelObtain2, "obtain()");
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.f31108a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0059 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final C0340a a(Context context) throws Exception {
            Intrinsics.g(context, "context");
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (!context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            C0340a c0340a = new C0340a("", false);
            IBinder iBinderA = bVar.a();
            if (iBinderA == null) {
                return c0340a;
            }
            try {
                c cVar = new c(iBinderA);
                C0340a c0340a2 = new C0340a(cVar.getId(), cVar.e0(true));
                context.unbindService(bVar);
                return c0340a2;
            } catch (Exception e11) {
                throw e11;
            }
        }
    }

    @JvmStatic
    public static final boolean b(String str, AtomicInteger increment, int i11) {
        Intrinsics.g(increment, "increment");
        return TextUtils.isEmpty(str) && increment.getAndIncrement() < i11;
    }

    @JvmStatic
    public static final String d() {
        try {
            if (TextUtils.isEmpty(f31095e) || (Intrinsics.b(f31095e, "00000000-0000-0000-0000-000000000000") && System.currentTimeMillis() - f31097g > TTAdConstant.AD_MAX_EVENT_TIME)) {
                f31097g = System.currentTimeMillis();
                String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(com.cloud.tmc.miniutils.util.e0.a(), "minisdk_storage", f31096f);
                if (string == null) {
                    string = "";
                }
                f31095e = string;
                if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                    com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.utils.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            q.e();
                        }
                    });
                } else {
                    f31091a.q();
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("DeviceUtil", "getGAId", th2);
        }
        return f31095e;
    }

    public static final void e() {
        f31091a.q();
    }

    @JvmStatic
    public static final String m() {
        return Build.VERSION.RELEASE;
    }

    @JvmStatic
    public static final String n() {
        return UUID.randomUUID().toString();
    }

    public final void c(Bundle bundle) {
        Intrinsics.g(bundle, "bundle");
        try {
            if (f31101k == -1) {
                f31101k = Runtime.getRuntime().availableProcessors();
            }
            if (TextUtils.isEmpty(f31102l)) {
                String HARDWARE = Build.HARDWARE;
                Intrinsics.f(HARDWARE, "HARDWARE");
                f31102l = HARDWARE;
            }
            bundle.putInt("cpucores", f31101k);
            bundle.putString("cpuhardware", f31102l);
        } catch (Throwable th2) {
            Log.e("DeviceUtil", "getCupInfo: ", th2);
        }
    }

    public final int f() {
        if (f31094d == 0) {
            f31094d = g.f31057a.a().f("is_limit_ad_tracking_enabled", 0);
        }
        return f31094d;
    }

    public final String g() {
        int cid;
        int lac;
        if (!b(f31093c, f31099i, 1)) {
            return f31093c;
        }
        try {
            Object systemService = ws.a.a().getSystemService("phone");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
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
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cid);
            sb2.append('|');
            sb2.append(lac);
            String string = sb2.toString();
            f31093c = string;
            return string;
        } catch (Exception e11) {
            Log.e("DeviceUtil", "getGsmCellLocation: ", e11);
            return "";
        }
    }

    public final String h() {
        try {
            Object systemService = ws.a.a().getApplicationContext().getSystemService("connectivity");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                f31092b = k();
            } else if (networkInfo2 != null && networkInfo2.isConnected()) {
                Object systemService2 = ws.a.a().getApplicationContext().getSystemService("wifi");
                Intrinsics.e(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                f31092b = o(Integer.valueOf(((WifiManager) systemService2).getConnectionInfo().getIpAddress()));
            }
        } catch (Exception e11) {
            Log.e("DeviceUtil", "getIp: ", e11);
        }
        String str = f31092b;
        return str == null ? "" : str;
    }

    public final String i(Context context) {
        Context applicationContext;
        Context applicationContext2;
        Intrinsics.g(context, "context");
        WeakReference weakReference = new WeakReference(context);
        try {
            Context context2 = (Context) weakReference.get();
            Object systemService = (context2 == null || (applicationContext2 = context2.getApplicationContext()) == null) ? null : applicationContext2.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(0) : null;
            NetworkInfo networkInfo2 = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
            if (networkInfo != null && networkInfo.isConnected()) {
                f31092b = k();
            } else if (networkInfo2 != null && networkInfo2.isConnected()) {
                Context context3 = (Context) weakReference.get();
                Object systemService2 = (context3 == null || (applicationContext = context3.getApplicationContext()) == null) ? null : applicationContext.getSystemService("wifi");
                WifiManager wifiManager = systemService2 instanceof WifiManager ? (WifiManager) systemService2 : null;
                WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
                f31092b = o(connectionInfo != null ? Integer.valueOf(connectionInfo.getIpAddress()) : null);
            }
        } catch (Exception e11) {
            Log.e("DeviceUtil", "getIp: ", e11);
        }
        return f31092b;
    }

    public final boolean j() {
        return f31098h;
    }

    public final String k() {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        String hostAddress = inetAddressNextElement.getHostAddress();
                        Intrinsics.f(hostAddress, "ip.hostAddress");
                        if (p(hostAddress)) {
                            String hostAddress2 = inetAddressNextElement.getHostAddress();
                            Intrinsics.f(hostAddress2, "ip.hostAddress");
                            str = hostAddress2;
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (SocketException e11) {
            Log.e("DeviceUtil", "getLocalIpAddress: ", e11);
        }
        return str;
    }

    public final void l(Context context, Bundle bundle) {
        Intrinsics.g(bundle, "bundle");
        if (context != null) {
            try {
                Object systemService = context.getSystemService("activity");
                Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
                if (f31100j == -1) {
                    f31100j = memoryInfo.totalMem / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                }
                bundle.putLong("totalMem", f31100j);
            } catch (Throwable th2) {
                Log.e("DeviceUtil", "getMemoryInfo: ", th2);
            }
        }
    }

    public final String o(Integer num) {
        StringBuilder sb2 = new StringBuilder();
        if (num != null) {
            int iIntValue = num.intValue();
            sb2.append(iIntValue & 255);
            sb2.append(InstructionFileId.DOT);
            sb2.append((iIntValue >> 8) & 255);
            sb2.append(InstructionFileId.DOT);
            sb2.append((iIntValue >> 16) & 255);
            sb2.append(InstructionFileId.DOT);
            sb2.append((iIntValue >> 24) & 255);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }

    public final boolean p(String str) {
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    public final void q() {
        try {
            a aVar = a.f31103a;
            Context contextA = ws.a.a();
            Intrinsics.f(contextA, "getContext()");
            a.C0340a c0340aA = aVar.a(contextA);
            if (c0340aA != null) {
                if (!Intrinsics.b(c0340aA.a(), f31095e)) {
                    String strA = c0340aA.a();
                    if (strA == null) {
                        strA = "";
                    }
                    f31095e = strA;
                    boolean zB = c0340aA.b();
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(com.cloud.tmc.miniutils.util.e0.a(), "minisdk_storage", f31096f, f31095e);
                    g.f31057a.a().n("is_limit_ad_tracking_enabled", zB ? 1 : 2);
                }
                LogUtils.h("gaid is " + f31095e, new Object[0]);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void r(String str) {
        if (f31098h || (str != null && str.length() > 0)) {
            f31098h = false;
            try {
                ((LauncherReportProxy) tc.a.a(LauncherReportProxy.class)).reportCacheData(str);
            } catch (Throwable unused) {
            }
        }
    }
}
