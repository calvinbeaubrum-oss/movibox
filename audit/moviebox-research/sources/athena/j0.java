package athena;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.sdk.oneid.OneID;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f13693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f13694b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f13695c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f13696d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f13697e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile String f13698f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile String f13699g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f13700h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f13701i;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13702a = new a("NETWORK_UNKNOWN", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f13703b = new a("NETWORK_WIFI", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f13704c = new a("NETWORK_2G", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f13705d = new a("NETWORK_3G", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f13706e = new a("NETWORK_4G", 4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f13707f = new a("NETWORK_5G", 5);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f13708g = new a("NETWORK_ETHERNET", 6);

        private a(String str, int i11) {
            super(str, i11);
        }
    }

    public static int a(long j11) {
        if (j11 > 999) {
            return Integer.parseInt(String.valueOf(j11).substring(0, 4));
        }
        return 0;
    }

    public static a b(Context context) {
        NetworkInfo.State state;
        NetworkInfo.State state2;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return a.f13702a;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || ((state2 = networkInfo.getState()) != NetworkInfo.State.CONNECTED && state2 != NetworkInfo.State.CONNECTING)) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(9);
                if (networkInfo2 != null && ((state = networkInfo2.getState()) == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                    return a.f13708g;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.getType() != 0) {
                        return a.f13702a;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return a.f13704c;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return a.f13705d;
                        case 13:
                        case 18:
                            return a.f13706e;
                        case 19:
                        default:
                            String subtypeName = activeNetworkInfo.getSubtypeName();
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return a.f13702a;
                            }
                            return a.f13705d;
                        case 20:
                            return a.f13707f;
                    }
                }
                return a.f13702a;
            }
            return a.f13703b;
        } catch (Exception e11) {
            a0.c(e11.getMessage());
        }
    }

    @NonNull
    public static String c() {
        return f13693a == null ? "" : f13693a;
    }

    public static String d(int i11) {
        StringBuilder sb2;
        String str;
        if (i11 > 10) {
            sb2 = new StringBuilder();
            str = "";
        } else {
            sb2 = new StringBuilder();
            str = "0";
        }
        sb2.append(str);
        sb2.append(i11);
        return sb2.toString();
    }

    public static void e(String str) {
        Log.e("Athena", "------------------------------------------------------------");
        Log.e("Athena", "");
        Log.e("Athena", str);
        Log.e("Athena", "");
        Log.e("Athena", "------------------------------------------------------------");
    }

    public static void f(StringBuilder sb2, int i11, int i12) {
        String string = Integer.toString(i12);
        for (int i13 = 0; i13 < i11 - string.length(); i13++) {
            sb2.append('0');
        }
        sb2.append(string);
    }

    public static boolean g(Context context, String str) {
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                String[] strArr = packageInfo.requestedPermissions;
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo != null && applicationInfo.uid == 1000 && strArr != null) {
                    for (String str2 : strArr) {
                        if (TextUtils.equals(str2, str)) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (Exception e11) {
                a0.c(e11.getMessage());
            }
        }
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e12) {
            a0.c(e12.getMessage());
            return false;
        }
    }

    public static String h() {
        if (TextUtils.isEmpty(f13693a)) {
            Context contextA = ws.a.a();
            try {
                f13693a = w.b(contextA).a();
            } catch (Exception e11) {
                a0.c(e11.getMessage());
            }
            if (TextUtils.isEmpty(f13693a)) {
                f13693a = m0.a(contextA).i("athena_id");
            }
        }
        return f13693a;
    }

    public static String i(Context context, String str) {
        Map<String, String> map = f13694b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        try {
            if (!OneID.f()) {
                return "";
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = f13697e;
            if (j11 != 0 && jElapsedRealtime - j11 < TTAdConstant.AD_MAX_EVENT_TIME) {
                return "";
            }
            String strB = k0.a(context).b(str);
            if (TextUtils.isEmpty(strB)) {
                f13697e = jElapsedRealtime;
                return "";
            }
            map.put(str, strB);
            f13697e = 0L;
            return strB;
        } catch (Exception e11) {
            a0.c(e11.getMessage());
            return "";
        }
    }

    public static void j(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        if (sensorManager == null || Build.VERSION.SDK_INT < 30) {
            f13700h = false;
        } else {
            Sensor defaultSensor = sensorManager.getDefaultSensor(36);
            if (defaultSensor == null) {
                List<Sensor> sensorList = sensorManager.getSensorList(-1);
                for (int i11 = 0; i11 < sensorList.size(); i11++) {
                    Sensor sensor = sensorList.get(i11);
                    if (sensor.getStringType().equals("android.sensor.hinge") || sensor.getStringType().equals("android.sensor.hinge_angle")) {
                        defaultSensor = sensor;
                        break;
                    }
                }
            }
            f13700h = defaultSensor != null;
        }
        m0 m0VarA = m0.a(context);
        if (m0VarA != null) {
            f13698f = m0VarA.i("_scr_type");
        }
        if (f13700h) {
            return;
        }
        f13699g = "0";
        f13698f = "0";
    }

    public static void k(String str) {
        f13698f = str;
        Context contextA = ws.a.a();
        if (contextA != null) {
            m0.a(contextA).g("_scr_type", str);
        }
    }

    public static boolean l(long j11) {
        return j11 > 999 && j11 <= 9999;
    }

    public static String m() {
        char c11;
        try {
            int rawOffset = TimeZone.getDefault().getRawOffset() / 60000;
            if (rawOffset < 0) {
                rawOffset = -rawOffset;
                c11 = '-';
            } else {
                c11 = '+';
            }
            StringBuilder sb2 = new StringBuilder(9);
            sb2.append("GMT");
            sb2.append(c11);
            f(sb2, 2, rawOffset / 60);
            sb2.append(':');
            f(sb2, 2, rawOffset % 60);
            return sb2.toString();
        } catch (Throwable th2) {
            a0.c(Log.getStackTraceString(th2));
            return "";
        }
    }

    public static void n(String str) {
        f13693a = str;
    }

    public static boolean o(Context context) {
        try {
            if (f13696d) {
                if (TextUtils.isEmpty(m0.a(context).i("first_launch"))) {
                    if (new File(context.getFilesDir() + File.separator + br.g.f14357j, "global.cfg").exists()) {
                        f13696d = false;
                    }
                } else {
                    f13696d = false;
                }
            }
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
        return f13696d;
    }

    public static String p() {
        return f13699g;
    }

    public static void q(String str) {
        f13699g = str;
    }

    public static boolean r(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(4) || networkCapabilities.hasTransport(3);
            }
            return false;
        } catch (Exception e11) {
            a0.c(e11.getMessage());
        }
    }

    public static String s() {
        if (TextUtils.isEmpty(f13701i)) {
            try {
                f13701i = Settings.Global.getString(ws.a.a().getApplicationContext().getContentResolver(), "os_small_version");
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        String str = f13701i;
        return str == null ? "" : str;
    }

    public static boolean t(Context context) {
        try {
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo("com.hoffnung", 8).providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if ("com.transsion.dataservice.provider".equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
        return false;
    }

    public static String u() {
        return f13698f;
    }

    public static String v() {
        if ("FOLD".equals(f13698f)) {
            return "1";
        }
        if ("HINGE".equals(f13698f)) {
            return "2";
        }
        return f13700h ? "" : "0";
    }

    public static boolean w() {
        return br.g.D() || br.g.H();
    }

    public static boolean x() {
        return f13700h;
    }
}
