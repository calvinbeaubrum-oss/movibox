package ca;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static String f14709a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static String f14711b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static volatile Boolean f14713c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static volatile String f14715d0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f14708a = Log.isLoggable("anti_fraud_log", 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Intent f14710b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static BroadcastReceiver f14712c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f14714d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f14716e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f14717f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f14718g = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f14719h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f14720i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f14721j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f14722k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f14723l = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic", "com.dual.dualgenius", "com.jiubang.commerce.gomultiple"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f14724m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f14725n = {"/dev/socket/qemud", "/dev/qemu_pipe"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f14726o = {"goldfish"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f14727p = {"/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f14728q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f14729r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f14730s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f14731t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f14732u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f14733v = "bluetooth_name";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f14734w = "base_band_version";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f14735x = "boot_time";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f14736y = "phone_name";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f14737z = "ssid";
    public static boolean A = false;
    public static String[] B = new String[0];
    public static String C = "screen_brightness";
    public static String D = "battery_percent";
    public static String E = "charge_type";
    public static String F = "rom_name";
    public static String G = "rom_build_time";
    public static String H = "os_api";
    public static String I = "build_id";
    public static String J = "cpu_cores";
    public static String K = "cpu_cores_cnt";
    public static String L = "cpu_abi";
    public static String M = "cpu_kernel";
    public static String N = "board";
    public static String O = "hard_ware";
    public static String P = "finger_print";
    public static int Q = 0;
    public static boolean R = false;
    public static String S = "phone_height";
    public static int T = 0;
    public static boolean U = false;
    public static int V = 0;
    public static int W = 0;
    public static boolean X = false;
    public static final AtomicBoolean Y = new AtomicBoolean(true);
    public static final Bundle Z = new Bundle();

    /* JADX INFO: compiled from: source.java */
    public class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    public static String A() {
        if (!"cpu_abi".equals(L)) {
            return L;
        }
        try {
            L = w0(Build.CPU_ABI);
        } catch (Exception e11) {
            L = "";
            r0(Log.getStackTraceString(e11));
        }
        return L;
    }

    public static String B() {
        if (!"cpu_cores".equals(J)) {
            return J;
        }
        try {
            J = w0(Build.CPU_ABI);
        } catch (Exception e11) {
            J = "";
            r0(Log.getStackTraceString(e11));
        }
        return J;
    }

    public static String C() {
        try {
            if (!g0(22)) {
                return "cpu_cores_cnt";
            }
            if (!"cpu_cores_cnt".equals(K)) {
                return K;
            }
            K = Integer.toHexString(g(Runtime.getRuntime().availableProcessors(), E() / 1000));
            return K;
        } catch (Exception e11) {
            K = "";
            r0(Log.getStackTraceString(e11));
        }
    }

    public static String D() {
        if (!"cpu_kernel".equals(M)) {
            return M;
        }
        try {
            M = w0(Build.CPU_ABI2);
        } catch (Exception e11) {
            M = "";
            r0(Log.getStackTraceString(e11));
        }
        return M;
    }

    public static int E() {
        int i11 = 0;
        try {
            FileReader fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                try {
                    i11 = Integer.parseInt(bufferedReader.readLine().trim());
                    bufferedReader.close();
                    fileReader.close();
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    fileReader.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
                throw th4;
            }
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return i11;
    }

    @SuppressLint({"MissingPermission"})
    public static String F() {
        try {
            if (!g0(18)) {
                return "bluetooth_name";
            }
            if (!"bluetooth_name".equals(f14733v)) {
                return f14733v;
            }
            if (Build.VERSION.SDK_INT > 30 && z2.a.checkSelfPermission(com.cloud.sdk.commonutil.util.f.a().getApplicationContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                return f14733v;
            }
            BluetoothAdapter adapter = ((BluetoothManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("bluetooth")).getAdapter();
            f14733v = adapter != null ? w0(adapter.getName()) : "";
            return f14733v;
        } catch (Exception e11) {
            f14733v = "";
            r0(Log.getStackTraceString(e11));
        }
    }

    public static void G() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSizeLong = statFs.getBlockSizeLong();
            if (blockSizeLong == 0) {
                return;
            }
            long blockCountLong = statFs.getBlockCountLong();
            long availableBlocksLong = statFs.getAvailableBlocksLong();
            V = (int) ((blockCountLong * blockSizeLong) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            W = (int) ((availableBlocksLong * blockSizeLong) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        }
    }

    public static String H() {
        if (!"finger_print".equals(P)) {
            return P;
        }
        try {
            P = w0(Build.FINGERPRINT);
        } catch (Exception e11) {
            P = "";
            r0(Log.getStackTraceString(e11));
        }
        return P;
    }

    public static String I() {
        if (!"hard_ware".equals(O)) {
            return O;
        }
        try {
            O = w0(Build.HARDWARE);
        } catch (Exception e11) {
            O = "";
            r0(Log.getStackTraceString(e11));
        }
        return O;
    }

    public static String J() {
        try {
            if (!g0(23)) {
                return Integer.toHexString(0);
            }
            if (R) {
                return Integer.toHexString(Q);
            }
            R = true;
            String[] cameraIdList = ((CameraManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("camera")).getCameraIdList();
            if (cameraIdList.length > 0) {
                Q = cameraIdList.length;
            }
            return Integer.toHexString(Q);
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
    }

    public static String K() {
        if (!"os_api".equals(H)) {
            return H;
        }
        try {
            H = Integer.toHexString(Build.VERSION.SDK_INT);
        } catch (Exception e11) {
            H = "";
            r0(Log.getStackTraceString(e11));
        }
        return H;
    }

    public static String L() {
        if (!"phone_height".equals(S)) {
            return S;
        }
        try {
            S = Integer.toHexString(g(d.k(), d.j()));
        } catch (Exception e11) {
            S = "";
            r0(Log.getStackTraceString(e11));
        }
        return S;
    }

    public static String M() {
        if (!"phone_name".equals(f14736y)) {
            return f14736y;
        }
        try {
            f14736y = w0(Build.DEVICE);
        } catch (Exception e11) {
            f14736y = "";
            r0(Log.getStackTraceString(e11));
        }
        return f14736y;
    }

    public static String N() {
        if (!"rom_build_time".equals(G)) {
            return G;
        }
        try {
            return Long.toHexString(Build.TIME);
        } catch (Exception e11) {
            G = "";
            r0(Log.getStackTraceString(e11));
            return G;
        }
    }

    public static String O() {
        if (!"rom_name".equals(F)) {
            return F;
        }
        try {
            F = w0(Build.MANUFACTURER);
        } catch (Exception e11) {
            F = "";
            r0(Log.getStackTraceString(e11));
        }
        return F;
    }

    public static String P() {
        return "";
    }

    public static String Q() {
        try {
            if (!g0(20)) {
                return "screen_brightness";
            }
            if (!"screen_brightness".equals(C)) {
                return C;
            }
            C = Integer.toHexString(g(Settings.System.getInt(com.cloud.sdk.commonutil.util.f.a().getContentResolver(), "screen_brightness"), 255));
            return C;
        } catch (Exception e11) {
            C = "";
            r0(Log.getStackTraceString(e11));
        }
    }

    public static String R() {
        if (!"ssid".equals(f14737z)) {
            return f14737z;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) com.cloud.sdk.commonutil.util.f.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            f14737z = connectionInfo != null ? w0(connectionInfo.getSSID()) : "";
        } catch (Exception e11) {
            f14737z = "";
            r0(Log.getStackTraceString(e11));
        }
        return f14737z;
    }

    public static String S() {
        try {
            if (!g0(25)) {
                return Integer.toHexString(0);
            }
            if (X) {
                return Integer.toHexString(V);
            }
            X = true;
            G();
            return Integer.toHexString(V);
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
            return "";
        }
    }

    public static String T() {
        if (!g0(24)) {
            return Integer.toHexString(0);
        }
        if (U) {
            return Integer.toHexString(T);
        }
        U = true;
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    T = Integer.parseInt(bufferedReader.readLine().split("\\s+")[1]) / 1024;
                    bufferedReader.close();
                    fileReader.close();
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    fileReader.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
                throw th4;
            }
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return Integer.toHexString(T);
    }

    public static String[] U() {
        try {
            if (!g0(19)) {
                return new String[0];
            }
            if (A) {
                return B;
            }
            A = true;
            if (z2.a.checkSelfPermission(com.cloud.sdk.commonutil.util.f.a().getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && z2.a.checkSelfPermission(com.cloud.sdk.commonutil.util.f.a().getApplicationContext(), "android.permission.ACCESS_WIFI_STATE") == 0) {
                List<ScanResult> scanResults = ((WifiManager) com.cloud.sdk.commonutil.util.f.a().getApplicationContext().getSystemService("wifi")).getScanResults();
                ArrayList arrayList = new ArrayList();
                if (scanResults != null && !scanResults.isEmpty()) {
                    for (int i11 = 0; i11 < scanResults.size(); i11++) {
                        ScanResult scanResult = scanResults.get(i11);
                        if (arrayList.size() > 4) {
                            break;
                        }
                        if (!scanResult.SSID.isEmpty()) {
                            arrayList.add(w0(scanResult.SSID));
                        }
                    }
                }
                B = (String[]) arrayList.toArray(new String[0]);
                return B;
            }
            return B;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
    }

    public static void V() {
        if (f14710b == null) {
            f14712c = new a();
            if (Build.VERSION.SDK_INT >= 33) {
                f14710b = com.cloud.sdk.commonutil.util.f.a().registerReceiver(f14712c, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2);
            } else {
                f14710b = com.cloud.sdk.commonutil.util.f.a().registerReceiver(f14712c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            }
        }
    }

    public static int W() {
        try {
            int i11 = 0;
            if (!g0(9)) {
                return 0;
            }
            int i12 = f14720i;
            if (i12 != -1) {
                return i12;
            }
            f14720i = 0;
            boolean zIsEnabled = ((AccessibilityManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("accessibility")).isEnabled();
            boolean zL0 = l0();
            if (zIsEnabled && zL0) {
                i11 = 512;
            }
            f14720i = i11;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14720i;
    }

    public static boolean X(Context context, String str) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static int Y() {
        try {
            if (!g0(8)) {
                return 0;
            }
            int i11 = f14719h;
            if (i11 != -1) {
                return i11;
            }
            f14719h = 0;
            boolean z11 = true;
            boolean z12 = Settings.Secure.getInt(com.cloud.sdk.commonutil.util.f.a().getContentResolver(), "development_settings_enabled", 0) != 0;
            if (Settings.Secure.getInt(com.cloud.sdk.commonutil.util.f.a().getContentResolver(), "adb_enabled", 0) == 0) {
                z11 = false;
            }
            f14719h = (z12 || z11) ? 256 : 0;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14719h;
    }

    public static int Z() {
        try {
            if (!o0(4)) {
                return 32;
            }
            int i11 = f14716e;
            if (i11 != -1) {
                return i11;
            }
            f14716e = 32;
            PackageManager packageManager = com.cloud.sdk.commonutil.util.f.a().getPackageManager();
            f14716e = (packageManager == null || !packageManager.hasSystemFeature("android.hardware.camera.any")) ? 0 : 16;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14716e;
    }

    public static int a(int i11, int i12) {
        return i11 | i12;
    }

    public static int a0() {
        g0(7);
        return 0;
    }

    public static boolean b() {
        return "android".equalsIgnoreCase(Build.BRAND) || Build.MODEL.toLowerCase().contains("sdk");
    }

    public static int b0() {
        try {
            if (!o0(0)) {
                return 2;
            }
            V();
            Intent intent = f14710b;
            if (intent != null) {
                int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                f();
                if (intExtra == 2) {
                    return 1;
                }
                return intExtra == 1 ? 2 : 0;
            }
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        f();
        return 2;
    }

    public static boolean c() {
        for (String str : f14727p) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public static int c0() {
        try {
            if (!g0(13)) {
                return 0;
            }
            int i11 = f14724m;
            if (i11 != -1) {
                return i11;
            }
            f14724m = 0;
            f14724m = (b() || c() || e() || d()) ? 8192 : 0;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14724m;
    }

    public static boolean d() {
        for (String str : f14725n) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public static int d0() {
        try {
            if (!g0(10)) {
                return 0;
            }
            int i11 = f14721j;
            if (i11 != -1) {
                return i11;
            }
            f14721j = 0;
            f14721j = (j() || i() || k()) ? 1024 : 0;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14721j;
    }

    public static boolean e() {
        File file = new File("/proc/tty/drivers");
        if (file.exists() && file.canRead()) {
            byte[] bArr = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.read(bArr) > 0) {
                        String str = new String(bArr);
                        for (String str2 : f14726o) {
                            if (str.contains(str2)) {
                                fileInputStream.close();
                                return true;
                            }
                        }
                    }
                    fileInputStream.close();
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Exception e11) {
                r0(Log.getStackTraceString(e11));
            }
        }
        return false;
    }

    public static int e0() {
        try {
            int i11 = 0;
            if (!g0(16)) {
                return 0;
            }
            int i12 = f14730s;
            if (i12 != -1) {
                return i12;
            }
            f14730s = 0;
            if (Build.VERSION.SDK_INT >= 23) {
                if (z2.a.checkSelfPermission(com.cloud.sdk.commonutil.util.f.a(), "android.permission.ACCESS_FINE_LOCATION") == 0 || z2.a.checkSelfPermission(com.cloud.sdk.commonutil.util.f.a(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    ((LocationManager) com.cloud.sdk.commonutil.util.f.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION)).setTestProviderEnabled("gps", true);
                    i11 = 65536;
                } else {
                    r0("No location permission is currently available");
                }
            } else if (Settings.Secure.getInt(com.cloud.sdk.commonutil.util.f.a().getContentResolver(), "mock_location", 0) != 0) {
                i11 = 65536;
            }
            f14730s = i11;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14730s;
    }

    public static void f() {
        f14710b = null;
        if (f14712c != null) {
            com.cloud.sdk.commonutil.util.f.a().unregisterReceiver(f14712c);
            f14712c = null;
        }
    }

    public static int f0() {
        return (g0(17) && f14731t) ? 131072 : 0;
    }

    public static int g(int i11, int i12) {
        if (i11 > 65535 || i12 > 65535) {
            return -1;
        }
        return (i11 << 16) ^ i12;
    }

    public static boolean g0(int i11) {
        try {
            String strO = o();
            if (strO.length() < i11 + 1) {
                return true;
            }
            return !(new StringBuilder(strO).reverse().toString().charAt(i11) + "").equals("1");
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean h(Exception exc) {
        int i11 = 0;
        for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
            if ("com.android.internal.os.ZygoteInit".equals(stackTraceElement.getClassName())) {
                i11++;
                if (i11 == 2) {
                    return true;
                }
            } else {
                if ("com.saurik.substrate.MS$2".equals(stackTraceElement.getClassName()) && "invoked".equals(stackTraceElement.getMethodName())) {
                    return true;
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "main".equals(stackTraceElement.getMethodName())) {
                    return true;
                }
                if ("de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName()) && "handleHookedMethod".equals(stackTraceElement.getMethodName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean h0() {
        if (f14713c0 == null) {
            f14713c0 = Boolean.valueOf(da.a.d().c("is_open_anti_fraud_sp_key", false));
        }
        return f14713c0.booleanValue();
    }

    public static boolean i() {
        HashSet<String> hashSet = new HashSet();
        try {
            FileReader fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.endsWith(".so") || line.endsWith(".jar")) {
                            hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                        }
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                    throw th;
                }
                for (String str : hashSet) {
                    if (str.contains("com.saurik.substrate")) {
                        bufferedReader.close();
                        fileReader.close();
                        return true;
                    }
                    if (str.contains("XposedBridge.jar")) {
                        bufferedReader.close();
                        fileReader.close();
                        return true;
                    }
                }
                bufferedReader.close();
                fileReader.close();
                return false;
            } catch (Throwable th5) {
                fileReader.close();
                throw th5;
            }
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
            return false;
        }
    }

    public static int i0() {
        try {
            int i11 = 0;
            if (!g0(12)) {
                return 0;
            }
            int i12 = f14722k;
            if (i12 != -1) {
                return i12;
            }
            f14722k = 0;
            String path = com.cloud.sdk.commonutil.util.f.a().getFilesDir().getPath();
            for (String str : f14723l) {
                if (path.contains(str)) {
                    i11 = 4096;
                    break;
                }
            }
            f14722k = i11;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14722k;
    }

    public static boolean j() {
        return false;
    }

    public static int j0() {
        g0(11);
        return 0;
    }

    public static boolean k() {
        try {
            throw new AndroidRuntimeException("findhook");
        } catch (Exception e11) {
            return h(e11);
        }
    }

    public static int k0() {
        boolean z11;
        try {
            if (!g0(6)) {
                return 0;
            }
            int i11 = f14717f;
            if (i11 != -1) {
                return i11;
            }
            f14717f = 0;
            String[] strArr = f14718g;
            int length = strArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    z11 = false;
                    break;
                }
                if (new File(strArr[i12]).exists()) {
                    z11 = true;
                    break;
                }
                i12++;
            }
            String str = Build.TAGS;
            f14717f = ((str != null && str.contains("test-keys")) || z11) ? 64 : 0;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14717f;
    }

    public static void l() {
        Bundle bundle = Z;
        bundle.putString("bbv", r());
        bundle.putString("bt", w());
        bundle.putString("phn", M());
        bundle.putString("si", R());
        bundle.putStringArray("bl", U());
        bundle.putString("sb", Q());
        bundle.putString("bpc", t());
        bundle.putString("ct", y());
        bundle.putString("rn", O());
        bundle.putString(CampaignEx.JSON_KEY_REWARD_TEMPLATE, P());
        bundle.putString("rb", N());
        bundle.putString("oa", K());
        bundle.putString("bi", x());
        bundle.putString("cc", B());
        bundle.putString("ccf", C());
        bundle.putString(DownloadCommon.DOWNLOAD_REPORT_CANCEL, A());
        bundle.putString("ck", D());
        bundle.putString("bd", v());
        bundle.putString("hw", I());
        bundle.putString("fp", H());
        bundle.putString("noc", J());
        bundle.putString("ps", L());
        bundle.putString("tm", T());
        bundle.putString("td", S());
        bundle.putString("am", q());
        bundle.putString("ad", p());
        bundle.putString("cp", Integer.toHexString(z()));
    }

    public static boolean l0() {
        Intent intent = new Intent("android.accessibilityservice.AccessibilityService");
        intent.addCategory("android.accessibilityservice.category.FEEDBACK_SPOKEN");
        boolean zX = false;
        List<ResolveInfo> listQueryIntentServices = com.cloud.sdk.commonutil.util.f.a().getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices.isEmpty()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            ArrayList arrayList = new ArrayList();
            Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("activity")).getRunningServices(Api.BaseClientBuilder.API_PRIORITY_OTHER).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().service.getPackageName());
            }
            Iterator<ResolveInfo> it2 = listQueryIntentServices.iterator();
            while (it2.hasNext()) {
                if (arrayList.contains(it2.next().serviceInfo.packageName)) {
                    return true;
                }
            }
            return false;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            zX |= X(com.cloud.sdk.commonutil.util.f.a(), resolveInfo.serviceInfo.packageName + "/" + resolveInfo.serviceInfo.name);
        }
        return zX;
    }

    public static String m() {
        if (!TextUtils.isEmpty(f14711b0)) {
            return f14711b0;
        }
        if (!h0()) {
            r0("=========== getAntiFraudLiteString server close ===========");
            return "";
        }
        if (Y.get()) {
            return "";
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("phn", M());
            bundle.putString("bt", w());
            bundle.putString("si", R());
            bundle.putStringArray("bl", U());
            bundle.putString("sb", Q());
            bundle.putString("bpc", t());
            bundle.putString("rn", O());
            bundle.putString(CampaignEx.JSON_KEY_REWARD_TEMPLATE, P());
            bundle.putString("rb", N());
            bundle.putString("oa", K());
            bundle.putString("cp", Integer.toHexString(z()));
            f14711b0 = n(bundle);
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        if (TextUtils.isEmpty(f14711b0)) {
            f14711b0 = "";
        }
        return f14711b0;
    }

    @SuppressLint({"MissingPermission"})
    public static int m0() {
        try {
            if (!o0(2)) {
                return 8;
            }
            int i11 = f14714d;
            if (i11 != -1) {
                return i11;
            }
            if (z2.a.checkSelfPermission(com.cloud.sdk.commonutil.util.f.a(), "android.permission.READ_PHONE_STATE") != 0) {
                return 8;
            }
            f14714d = 8;
            TelephonyManager telephonyManager = (TelephonyManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("phone");
            String subscriberId = telephonyManager != null ? telephonyManager.getSubscriberId() : "";
            if (subscriberId == null || subscriberId.length() <= 0) {
                f14714d = 0;
            } else {
                f14714d = 4;
            }
            return f14714d;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
    }

    public static String n(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            Set<String> setKeySet = bundle.keySet();
            sb2.append("bn");
            sb2.append("\u0002");
            sb2.append(F());
            for (String str : setKeySet) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        obj = "\"\"";
                    }
                    sb2.append("\u0001");
                    sb2.append(str);
                    sb2.append("\u0002");
                    sb2.append(obj);
                } else if (obj instanceof Float) {
                    sb2.append("\u0001");
                    sb2.append(str);
                    sb2.append("\u0002");
                    sb2.append(obj);
                } else if (obj instanceof float[]) {
                    sb2.append("\u0001");
                    sb2.append(str);
                    sb2.append("\u0002");
                    sb2.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof String[]) {
                    sb2.append("\u0001");
                    sb2.append(str);
                    sb2.append("\u0002");
                    sb2.append(Arrays.toString((String[]) obj));
                }
            }
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
            sb2.append("");
        }
        return com.cloud.sdk.commonutil.util.a.a(sb2.toString());
    }

    public static boolean n0() {
        int i11 = f14732u;
        if (i11 >= 0) {
            return i11 == 1;
        }
        if (TextUtils.equals(o(), "0")) {
            f14732u = 1;
        } else {
            f14732u = g0(27) ? 1 : 0;
        }
        return f14732u == 1;
    }

    public static String o() {
        if (TextUtils.isEmpty(f14715d0)) {
            f14715d0 = da.a.d().j("anti_fraud_sub_function_sp_key", "");
            if (f14715d0.isEmpty()) {
                f14715d0 = "0";
            }
        }
        return f14715d0;
    }

    public static boolean o0(int i11) {
        try {
            String strO = o();
            if (strO.equals("1")) {
                strO = "01";
            }
            return !new StringBuilder(strO).reverse().toString().substring(i11, i11 + 2).equals(PrepareException.ERROR_MINI_APPID);
        } catch (Exception unused) {
            return true;
        }
    }

    public static String p() {
        if (X) {
            return Integer.toHexString(W);
        }
        try {
            return Integer.toHexString(W);
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
            return "";
        }
    }

    public static int p0() {
        try {
            int i11 = 0;
            if (!g0(15)) {
                return 0;
            }
            int i12 = f14729r;
            if (i12 != -1) {
                return i12;
            }
            f14729r = 0;
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int i13 = Integer.parseInt(property2);
            if (!TextUtils.isEmpty(property) && i13 != -1) {
                i11 = 32768;
            }
            f14729r = i11;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14729r;
    }

    public static String q() {
        try {
            ActivityManager activityManager = (ActivityManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return Integer.toHexString((int) (memoryInfo.availMem / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
            return "";
        }
    }

    public static int q0() {
        try {
            int i11 = 0;
            if (!g0(14)) {
                return 0;
            }
            int i12 = f14728q;
            if (i12 != -1) {
                return i12;
            }
            f14728q = 0;
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                    if (networkInterface.isUp() && !networkInterface.getInterfaceAddresses().isEmpty()) {
                        if (!"tun0".equals(networkInterface.getName()) && !"ppp0".equals(networkInterface.getName())) {
                        }
                        i11 = 16384;
                        break;
                    }
                    r0("The network is disconnected.");
                }
            }
            f14728q = i11;
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
        return f14728q;
    }

    public static String r() {
        if (!"base_band_version".equals(f14734w)) {
            return f14734w;
        }
        try {
            f14734w = w0(Build.VERSION.INCREMENTAL);
        } catch (Exception e11) {
            f14734w = "";
            r0(Log.getStackTraceString(e11));
        }
        return f14734w;
    }

    public static void r0(String str) {
        if (f14708a) {
            Log.w("anti_fraud_log", str);
        }
    }

    public static int s() {
        try {
            return ((BatteryManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
            return 0;
        }
    }

    public static void s0() {
        if (!h0()) {
            r0("preloadAntiFraud --> cloud close");
            return;
        }
        try {
            if (!g0(26)) {
                f.q();
            }
            l();
            Y.set(false);
            r0("preloadAntiFraud --> Initialize set tag IS_PRELOAD_LOADING = false");
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
        }
    }

    public static String t() {
        if (!"battery_percent".equals(D)) {
            return D;
        }
        try {
            D = Integer.toHexString(g(s(), u()));
        } catch (Exception e11) {
            D = "";
            r0(Log.getStackTraceString(e11));
        }
        return D;
    }

    public static void t0(String str) {
        r0("cloud antiFraudSubfunctionControl = " + str);
        if (TextUtils.isEmpty(f14715d0) || !f14715d0.equals(str)) {
            f14715d0 = str;
            da.a.d().p("anti_fraud_sub_function_sp_key", f14715d0);
        }
    }

    public static int u() {
        return 0;
    }

    public static void u0(boolean z11) {
        r0("cloud isOpenAntiFraud = " + z11);
        if (f14713c0 == null || f14713c0.booleanValue() != z11) {
            f14713c0 = Boolean.valueOf(z11);
            if (z11 && Y.get()) {
                r0("saveAntiFraudSwitch --> non preload");
                s0();
            }
            da.a.d().m("is_open_anti_fraud_sp_key", z11);
        }
    }

    public static String v() {
        if (!"board".equals(N)) {
            return N;
        }
        try {
            N = w0(Build.BOARD);
        } catch (Exception e11) {
            N = "";
            r0(Log.getStackTraceString(e11));
        }
        return N;
    }

    public static void v0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!TextUtils.isEmpty(f14709a0)) {
            bundle.putString("fraud_data_set", f14709a0);
            return;
        }
        if (!h0()) {
            r0("======= setAntiFraudFullString serve close =========");
            return;
        }
        try {
            if (Y.get()) {
                bundle.putString("fraud_data_set", "");
            } else {
                boolean zM = f.e().m();
                Bundle bundle2 = Z;
                bundle2.putAll(f.k());
                String strN = n(bundle2);
                bundle.putString("fraud_data_set", strN);
                if (zM) {
                    bundle2.clear();
                    f14709a0 = strN;
                }
            }
        } catch (Exception e11) {
            r0(Log.getStackTraceString(e11));
            bundle.putString("fraud_data_set", "");
        }
    }

    public static String w() {
        if (!"boot_time".equals(f14735x)) {
            return f14735x;
        }
        try {
            f14735x = Integer.toHexString((int) ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000));
        } catch (Exception e11) {
            f14735x = "";
            r0(Log.getStackTraceString(e11));
        }
        return f14735x;
    }

    public static String w0(String str) {
        return (str == null || str.length() <= 100) ? str : str.substring(0, 100);
    }

    public static String x() {
        if (!"build_id".equals(I)) {
            return I;
        }
        try {
            I = w0(Build.ID);
        } catch (Exception e11) {
            I = "";
            r0(Log.getStackTraceString(e11));
        }
        return I;
    }

    public static String y() {
        try {
            if (!g0(21)) {
                return "charge_type";
            }
            if (!"charge_type".equals(E)) {
                return E;
            }
            V();
            Intent intent = f14710b;
            if (intent != null) {
                int intExtra = intent.getIntExtra("plugged", -1);
                if (intExtra == 1) {
                    E = "1";
                } else if (intExtra == 2) {
                    E = "2";
                } else if (intExtra == 4) {
                    E = "3";
                } else {
                    E = "0";
                }
            }
            return E;
        } catch (Exception e11) {
            E = "0";
            r0(Log.getStackTraceString(e11));
        }
    }

    public static int z() {
        return a(a(a(a(a(a(a(a(a(a(a(a(a(a(a(0, b0()), m0()), Z()), k0()), a0()), Y()), W()), d0()), j0()), i0()), c0()), q0()), p0()), e0()), f0());
    }
}
