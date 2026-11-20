package com.mbridge.msdk.foundation.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class z extends j {
    private static String A = "";
    private static Object B = null;
    private static int C = 0;
    private static int D = 0;
    private static String E = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f45097e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f45098f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f45099g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f45100h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f45101i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f45102j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f45103k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f45104l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f45105m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f45106n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile int f45107o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f45108p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f45109q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f45110r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f45111s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static int f45112t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f45113u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static String f45114v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f45115w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static String f45116x = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static int f45117y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static int f45118z;

    private static void A() {
        String str = Build.VERSION.RELEASE;
        String strH = h();
        String str2 = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strH)) {
            f45116x = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Mozilla/5.0 (Linux; Android ");
        sb2.append(str);
        sb2.append("; ");
        sb2.append(strH);
        sb2.append(" Build/");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append(") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
        f45116x = sb2.toString();
    }

    private static long B() {
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC == null) {
            return 0L;
        }
        ActivityManager activityManager = (ActivityManager) contextC.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static String C() {
        String str;
        if (!TextUtils.isEmpty(f45100h)) {
            return f45100h;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th2) {
            ad.b("SameDiTool", th2.getMessage());
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str) || !str.equals("harmony")) {
                f45100h = "android";
            } else {
                jSONObject.put("osType", str);
                try {
                    Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
                    jSONObject.put("version", (String) cls2.getMethod("getVersion", new Class[0]).invoke(cls2, new Object[0]));
                } catch (Throwable th3) {
                    ad.b("SameDiTool", th3.getMessage());
                }
                try {
                    jSONObject.put("pure_state", Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.c.m().c().getContentResolver(), "pure_mode_state", -1));
                } catch (Throwable th4) {
                    ad.b("SameDiTool", th4.getMessage());
                }
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    string = x.b(string);
                }
                f45100h = string;
            }
        } catch (Throwable th5) {
            ad.b("SameDiTool", th5.getMessage());
        }
        return f45100h;
    }

    public static String a(Context context, int i11) {
        TelephonyManager telephonyManager;
        if (i11 == 0 || i11 == 9) {
            return "";
        }
        try {
            return (!com.mbridge.msdk.foundation.same.a.f44390z || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th2) {
            ad.a("SameDiTool", th2.getMessage(), th2);
            return "";
        }
    }

    public static String a(String str, Context context) {
        try {
            if (!TextUtils.isEmpty(f45097e)) {
                return f45097e;
            }
            if (!TextUtils.isEmpty(str) && context != null) {
                f45097e = context.getPackageManager().getInstallerPackageName(str);
                ad.a("SameDiTool", "PKGSource:" + f45097e);
            }
            return f45097e;
        } catch (Exception e11) {
            ad.a("SameDiTool", e11.getMessage(), e11);
        }
    }

    public static int b(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
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
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static Object b(String str) {
        if (B == null) {
            B = ai.g(str);
        }
        return B;
    }

    public static int c(String str) {
        if (D == 0) {
            D = ai.f(str);
        }
        return D;
    }

    public static void c(int i11) {
        f45104l = i11;
    }

    public static void d(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                e.b(context);
            } else {
                new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.z.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b(context);
                    }
                });
            }
        } catch (Exception e11) {
            ad.a("SameDiTool", "", e11);
        }
    }

    public static String e(Context context) {
        if (context == null) {
            return f45109q;
        }
        try {
            if (!TextUtils.isEmpty(f45109q)) {
                return f45109q;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            f45109q = str;
            return str;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static int f() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return 0;
            }
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            long j11 = 0;
            long jLongValue = ((Long) al.a(contextC, "FreeRamSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 1800000 || f45110r == -1) {
                Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                if (contextC2 != null) {
                    ActivityManager activityManager = (ActivityManager) contextC2.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j11 = memoryInfo.availMem;
                }
                f45110r = Long.valueOf((j11 / 1000) / 1000).intValue();
                al.b(contextC, "FreeRamSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th2) {
            ad.a("SameDiTool", th2.getMessage(), th2);
        }
        return f45110r;
    }

    public static String f(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return null;
        }
        if (TextUtils.isEmpty(f45116x)) {
            try {
                f45116x = al.a(context, "mbridge_ua", "").toString();
            } catch (Throwable th2) {
                ad.a("SameDiTool", th2.getMessage(), th2);
            }
        }
        try {
            if (Looper.myLooper() != Looper.getMainLooper() || MBridgeConstans.DNT_GUA_ON_UI) {
                if (TextUtils.isEmpty(f45116x)) {
                    A();
                }
                x(context);
            } else if (TextUtils.isEmpty(f45116x)) {
                try {
                    f45116x = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(f45116x)) {
                    try {
                        Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                        declaredConstructor.setAccessible(true);
                        f45116x = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                        declaredConstructor.setAccessible(false);
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    if (TextUtils.isEmpty(f45116x)) {
                        try {
                            f45116x = new WebView(context).getSettings().getUserAgentString();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(f45116x)) {
                        A();
                    }
                }
            } else {
                x(context);
            }
        } catch (Throwable th5) {
            ad.a("SameDiTool", th5.getMessage(), th5);
        }
        y(context);
        return f45116x;
    }

    public static int g(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapH = h(context);
            return mapH.get("height") == null ? displayMetrics.heightPixels : ((Integer) mapH.get("height")).intValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(f45116x)) {
            f(com.mbridge.msdk.foundation.controller.c.m().c());
        }
        return f45116x;
    }

    public static String h() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MODEL;
    }

    public static HashMap h(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            map.put("height", Integer.valueOf(displayMetrics.heightPixels));
            map.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e11) {
            ad.a("SameDiTool", e11.getMessage(), e11);
        }
        return map;
    }

    public static int i(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapH = h(context);
            return mapH.get("width") == null ? displayMetrics.widthPixels : ((Integer) mapH.get("width")).intValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static String i() {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA);
        return "";
    }

    public static String j(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f45105m = "";
            } else if (TextUtils.isEmpty(f45105m)) {
                if (context == null) {
                    f45105m = "";
                    return "";
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (ai.j(simOperator)) {
                    f45105m = simOperator.substring(0, Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            f45105m = "";
        }
        return f45105m;
    }

    public static void j() {
        try {
            Object objA = al.a(com.mbridge.msdk.foundation.controller.c.m().c(), MBridgeConstans.SP_GA_ID, "");
            Object objA2 = al.a(com.mbridge.msdk.foundation.controller.c.m().c(), MBridgeConstans.SP_GA_ID_LIMIT, 0);
            if (objA instanceof String) {
                String str = (String) objA;
                if (!TextUtils.isEmpty(str)) {
                    e.a(str);
                }
                if (objA2 instanceof Integer) {
                    e.f45052d = ((Integer) objA2).intValue();
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("SameDiTool", e11.getMessage());
            }
        }
    }

    public static int k() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.VERSION.SDK_INT;
        }
        return -1;
    }

    public static String k(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f45106n = "";
            } else if (TextUtils.isEmpty(f45106n)) {
                if (context == null) {
                    f45106n = "";
                    return f45105m;
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (ai.j(simOperator)) {
                    f45106n = simOperator.substring(Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            f45106n = "";
        }
        return f45106n;
    }

    public static int l(Context context) {
        try {
            final Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) && contextC != null) {
                if (f45107o == -1) {
                    f45107o = 0;
                    return f45107o;
                }
                try {
                    Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.z.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                ConnectivityManager connectivityManager = (ConnectivityManager) contextC.getSystemService("connectivity");
                                if (connectivityManager != null && com.mbridge.msdk.foundation.same.a.f44390z) {
                                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                    if (activeNetworkInfo == null) {
                                        int unused = z.f45107o = 0;
                                        return;
                                    }
                                    if (activeNetworkInfo.getType() == 1) {
                                        int unused2 = z.f45107o = 9;
                                        return;
                                    }
                                    TelephonyManager telephonyManager = (TelephonyManager) contextC.getSystemService("phone");
                                    if (telephonyManager == null) {
                                        int unused3 = z.f45107o = 0;
                                    } else {
                                        int unused4 = z.f45107o = z.b(telephonyManager.getNetworkType());
                                    }
                                }
                            } catch (Exception e11) {
                                ad.a("SameDiTool", e11.getMessage(), e11);
                                int unused5 = z.f45107o = 0;
                            }
                        }
                    };
                    if (com.mbridge.msdk.foundation.same.f.b.f().getActiveCount() < 1) {
                        com.mbridge.msdk.foundation.same.f.b.f().execute(runnable);
                    }
                } catch (Throwable th2) {
                    ad.b("SameDiTool", th2.getMessage());
                }
                return f45107o;
            }
            return f45107o;
        } catch (Exception e11) {
            ad.a("SameDiTool", e11.getMessage(), e11);
            f45107o = 0;
            return f45107o;
        }
    }

    public static String l() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MANUFACTURER;
    }

    public static String m() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String m(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e11) {
            ad.a("SameDiTool", e11.getMessage(), e11);
            return "";
        } catch (Throwable th2) {
            ad.a("SameDiTool", th2.getMessage(), th2);
            return "";
        }
    }

    public static String n() {
        String strA = "";
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            long jA = y.a();
            long jB = B();
            String strZ = z(contextC);
            String str = "app_tki_" + jA + "_" + jB + "_" + strZ;
            String str2 = (String) al.a(contextC, str, "");
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", strZ);
                    jSONObject.put("2", String.valueOf(jB));
                    jSONObject.put("3", String.valueOf(jA));
                    jSONObject.put("4", "");
                    jSONObject.put("5", "");
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                strA = a.a(jSONObject.toString());
                al.b(contextC, str, strA);
            } catch (Exception e12) {
                e = e12;
                strA = str2;
                e.printStackTrace();
            }
        } catch (Exception e13) {
            e = e13;
        }
        return strA;
    }

    public static String n(Context context) {
        FileReader fileReader;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(f45114v)) {
            return f45114v;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                        try {
                            String fileSize = Formatter.formatFileSize(context, Long.valueOf(bufferedReader2.readLine().split("\\s+")[1]).longValue() * 1024);
                            f45114v = fileSize;
                            try {
                                bufferedReader2.close();
                            } catch (IOException e11) {
                                ad.a("SameDiTool", e11.getMessage(), e11);
                            }
                            try {
                                fileReader.close();
                            } catch (IOException e12) {
                                ad.a("SameDiTool", e12.getMessage(), e12);
                            }
                            return fileSize;
                        } catch (IOException e13) {
                            e = e13;
                            bufferedReader = bufferedReader2;
                            ad.a("SameDiTool", e.getMessage(), e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e14) {
                                    ad.a("SameDiTool", e14.getMessage(), e14);
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return "";
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            ad.a("SameDiTool", th.getMessage(), th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e15) {
                                    ad.a("SameDiTool", e15.getMessage(), e15);
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return "";
                        }
                    } catch (IOException e16) {
                        e = e16;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e17) {
                    ad.a("SameDiTool", e17.getMessage(), e17);
                    return "";
                }
            } catch (IOException e18) {
                e = e18;
                fileReader = null;
            } catch (Throwable th4) {
                th = th4;
                fileReader = null;
            }
        } catch (Throwable th5) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e19) {
                    ad.a("SameDiTool", e19.getMessage(), e19);
                }
            }
            if (fileReader == null) {
                throw th5;
            }
            try {
                fileReader.close();
                throw th5;
            } catch (IOException e21) {
                ad.a("SameDiTool", e21.getMessage(), e21);
                throw th5;
            }
        }
    }

    public static int o() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        if (f45111s < 1) {
            try {
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                long jLongValue = ((Long) al.a(contextC, "TotalRamSize", 0L)).longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jLongValue > 1800000 || f45111s == -1) {
                    f45111s = Long.valueOf((B() / 1000) / 1000).intValue();
                    al.b(contextC, "TotalRamSize", Long.valueOf(jCurrentTimeMillis));
                }
            } catch (Throwable th2) {
                ad.a("SameDiTool", th2.getMessage(), th2);
            }
        }
        return f45111s;
    }

    public static void o(Context context) {
        try {
            e.a(context);
            v();
            e(context);
            p(context);
            q(context);
            r(context);
            h();
            w();
            s(context);
            x();
            com.mbridge.msdk.foundation.same.a.B = false;
            com.mbridge.msdk.foundation.same.a.f44390z = ai.a("android.permission.ACCESS_NETWORK_STATE", context);
            t(context);
            C();
            e.e();
            try {
                com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.z.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.mbridge.msdk.f.c.a();
                        } catch (Exception e11) {
                            ad.b("SameDiTool", e11.getMessage());
                        }
                    }
                });
            } catch (Throwable th2) {
                ad.b("SameDiTool", th2.getMessage());
            }
        } catch (Throwable th3) {
            ad.b("SameDiTool", th3.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedReader] */
    public static String p() {
        FileReader fileReader;
        Throwable th2;
        Exception e11;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (f45115w > 0) {
            return f45115w + "GB";
        }
        ?? bufferedReader = "/proc/meminfo";
        f45115w = 0;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader, 8192);
                        try {
                            String str = bufferedReader.readLine().split("\\s+")[1];
                            bufferedReader.close();
                            if (str != null) {
                                f45115w = (int) Math.ceil(new Float(Float.valueOf(str).floatValue() / 1048576.0f).doubleValue());
                            }
                            try {
                                fileReader.close();
                            } catch (IOException unused) {
                            }
                            bufferedReader.close();
                        } catch (Exception e12) {
                            e11 = e12;
                            ad.a("SameDiTool", e11.getMessage(), e11);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (bufferedReader != 0) {
                                bufferedReader.close();
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            ad.a("SameDiTool", th2.getMessage(), th2);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (bufferedReader != 0) {
                                bufferedReader.close();
                            }
                        }
                    } catch (Exception e13) {
                        e11 = e13;
                        bufferedReader = 0;
                    } catch (Throwable th4) {
                        th2 = th4;
                        bufferedReader = 0;
                    }
                } catch (Throwable th5) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (bufferedReader == 0) {
                        throw th5;
                    }
                    try {
                        bufferedReader.close();
                        throw th5;
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        throw th5;
                    }
                }
            } catch (Exception e15) {
                fileReader = null;
                e11 = e15;
                bufferedReader = 0;
            } catch (Throwable th6) {
                fileReader = null;
                th2 = th6;
                bufferedReader = 0;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return f45115w + "GB";
    }

    public static String p(Context context) {
        if (context == null) {
            return A;
        }
        try {
            if (!TextUtils.isEmpty(A)) {
                return A;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            A = str;
            return str;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static int q() {
        try {
            if (!af.a.f44979a.a("v_a_d_p", false)) {
                return 0;
            }
            if (ai.h()) {
                f45102j = 1;
            } else if (ai.i()) {
                f45102j = 2;
            } else {
                f45102j = 0;
            }
        } catch (Exception e11) {
            f45102j = 0;
            ad.b("SameDiTool", e11.getMessage());
        }
        return f45102j;
    }

    public static int q(Context context) {
        if (context == null) {
            return f45118z;
        }
        int i11 = f45118z;
        if (i11 != 0) {
            return i11;
        }
        try {
            int i12 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            f45118z = i12;
            return i12;
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static int r(Context context) {
        Configuration configuration;
        return (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) ? 1 : 2;
    }

    public static int s() {
        return f45117y;
    }

    public static String s(Context context) {
        Locale locale;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f45103k)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale) == null) {
                    return "en-US";
                }
                String languageTag = locale.toLanguageTag();
                f45103k = languageTag;
                return languageTag;
            } catch (Throwable th2) {
                ad.a("SameDiTool", th2.getMessage());
                f45103k = "en-US";
            }
        }
        return f45103k;
    }

    public static int t() {
        if (C == 0) {
            C = ai.e();
        }
        return C;
    }

    public static int t(Context context) {
        if (context == null) {
            return f45112t;
        }
        if (f45112t == 0) {
            try {
                f45112t = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e11) {
                ad.b("SameDiTool", e11.getMessage());
            }
        }
        return f45112t;
    }

    public static int u() {
        return f45104l;
    }

    public static int u(Context context) {
        if (f45099g == -1) {
            f45099g = ai.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return f45099g;
    }

    public static String v() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(f45108p)) {
            f45108p = r() + "";
        }
        return f45108p;
    }

    public static boolean v(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String w() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BRAND;
    }

    public static String x() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                return "";
            }
            if (TextUtils.isEmpty(f45113u)) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.z.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            String unused = z.f45113u = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }).start();
                return f45113u;
            }
        } catch (Throwable th2) {
            ad.a("SameDiTool", th2.getMessage(), th2);
        }
        return f45113u;
    }

    private static void x(final Context context) {
        try {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.z.2
                @Override // java.lang.Runnable
                public final void run() {
                    String defaultUserAgent;
                    try {
                        defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    } catch (Throwable unused) {
                        defaultUserAgent = null;
                    }
                    try {
                        if (TextUtils.isEmpty(defaultUserAgent) || defaultUserAgent.equals(z.f45116x)) {
                            return;
                        }
                        String unused2 = z.f45116x = defaultUserAgent;
                        z.y(context);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static int y() {
        if (f45101i == -1) {
            f45101i = ai.f() ? 1 : 0;
        }
        return f45101i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Context context) {
        try {
            al.b(context, "mbridge_ua", f45116x);
        } catch (Throwable th2) {
            ad.a("SameDiTool", th2.getMessage(), th2);
        }
    }

    private static String z(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                f45098f = "";
            } else if (TextUtils.isEmpty(f45098f)) {
                f45098f = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            f45098f = "";
        }
        return f45098f;
    }
}
