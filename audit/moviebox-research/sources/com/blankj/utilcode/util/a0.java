package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f25299a = {"huawei"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f25300b = {"vivo"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f25301c = {"xiaomi"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f25302d = {"oppo"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f25303e = {"leeco", "letv"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f25304f = {"360", "qiku"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f25305g = {"zte"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f25306h = {"oneplus"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f25307i = {"nubia"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f25308j = {"coolpad", "yulong"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f25309k = {"lg", "lge"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f25310l = {"google"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f25311m = {"samsung"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f25312n = {"meizu"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f25313o = {"lenovo"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f25314p = {"smartisan", "deltainno"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f25315q = {"htc"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f25316r = {"sony"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f25317s = {"gionee", "amigo"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f25318t = {"motorola"};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static a f25319u = null;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f25321b;

        public String toString() {
            return "RomInfo{name=" + this.f25320a + ", version=" + this.f25321b + "}";
        }
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : AppLovinMediationProvider.UNKNOWN;
        } catch (Throwable unused) {
            return AppLovinMediationProvider.UNKNOWN;
        }
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : AppLovinMediationProvider.UNKNOWN;
        } catch (Throwable unused) {
            return AppLovinMediationProvider.UNKNOWN;
        }
    }

    public static a c() {
        a aVar = f25319u;
        if (aVar != null) {
            return aVar;
        }
        f25319u = new a();
        String strA = a();
        String strB = b();
        String[] strArr = f25299a;
        if (i(strA, strB, strArr)) {
            f25319u.f25320a = strArr[0];
            String strD = d("ro.build.version.emui");
            String[] strArrSplit = strD.split("_");
            if (strArrSplit.length > 1) {
                f25319u.f25321b = strArrSplit[1];
            } else {
                f25319u.f25321b = strD;
            }
            return f25319u;
        }
        String[] strArr2 = f25300b;
        if (i(strA, strB, strArr2)) {
            f25319u.f25320a = strArr2[0];
            f25319u.f25321b = d("ro.vivo.os.build.display.id");
            return f25319u;
        }
        String[] strArr3 = f25301c;
        if (i(strA, strB, strArr3)) {
            f25319u.f25320a = strArr3[0];
            f25319u.f25321b = d("ro.build.version.incremental");
            return f25319u;
        }
        String[] strArr4 = f25302d;
        if (i(strA, strB, strArr4)) {
            f25319u.f25320a = strArr4[0];
            f25319u.f25321b = d("ro.build.version.opporom");
            return f25319u;
        }
        String[] strArr5 = f25303e;
        if (i(strA, strB, strArr5)) {
            f25319u.f25320a = strArr5[0];
            f25319u.f25321b = d("ro.letv.release.version");
            return f25319u;
        }
        String[] strArr6 = f25304f;
        if (i(strA, strB, strArr6)) {
            f25319u.f25320a = strArr6[0];
            f25319u.f25321b = d("ro.build.uiversion");
            return f25319u;
        }
        String[] strArr7 = f25305g;
        if (i(strA, strB, strArr7)) {
            f25319u.f25320a = strArr7[0];
            f25319u.f25321b = d("ro.build.MiFavor_version");
            return f25319u;
        }
        String[] strArr8 = f25306h;
        if (i(strA, strB, strArr8)) {
            f25319u.f25320a = strArr8[0];
            f25319u.f25321b = d("ro.rom.version");
            return f25319u;
        }
        String[] strArr9 = f25307i;
        if (i(strA, strB, strArr9)) {
            f25319u.f25320a = strArr9[0];
            f25319u.f25321b = d("ro.build.rom.id");
            return f25319u;
        }
        String[] strArr10 = f25308j;
        if (i(strA, strB, strArr10)) {
            f25319u.f25320a = strArr10[0];
        } else {
            String[] strArr11 = f25309k;
            if (i(strA, strB, strArr11)) {
                f25319u.f25320a = strArr11[0];
            } else {
                String[] strArr12 = f25310l;
                if (i(strA, strB, strArr12)) {
                    f25319u.f25320a = strArr12[0];
                } else {
                    String[] strArr13 = f25311m;
                    if (i(strA, strB, strArr13)) {
                        f25319u.f25320a = strArr13[0];
                    } else {
                        String[] strArr14 = f25312n;
                        if (i(strA, strB, strArr14)) {
                            f25319u.f25320a = strArr14[0];
                        } else {
                            String[] strArr15 = f25313o;
                            if (i(strA, strB, strArr15)) {
                                f25319u.f25320a = strArr15[0];
                            } else {
                                String[] strArr16 = f25314p;
                                if (i(strA, strB, strArr16)) {
                                    f25319u.f25320a = strArr16[0];
                                } else {
                                    String[] strArr17 = f25315q;
                                    if (i(strA, strB, strArr17)) {
                                        f25319u.f25320a = strArr17[0];
                                    } else {
                                        String[] strArr18 = f25316r;
                                        if (i(strA, strB, strArr18)) {
                                            f25319u.f25320a = strArr18[0];
                                        } else {
                                            String[] strArr19 = f25317s;
                                            if (i(strA, strB, strArr19)) {
                                                f25319u.f25320a = strArr19[0];
                                            } else {
                                                String[] strArr20 = f25318t;
                                                if (i(strA, strB, strArr20)) {
                                                    f25319u.f25320a = strArr20[0];
                                                } else {
                                                    f25319u.f25320a = strB;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        f25319u.f25321b = d("");
        return f25319u;
    }

    public static String d(String str) {
        String strE = !TextUtils.isEmpty(str) ? e(str) : "";
        if (TextUtils.isEmpty(strE) || strE.equals(AppLovinMediationProvider.UNKNOWN)) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    strE = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strE) ? AppLovinMediationProvider.UNKNOWN : strE;
    }

    public static String e(String str) throws Throwable {
        String strG = g(str);
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        String strH = h(str);
        return (TextUtils.isEmpty(strH) && Build.VERSION.SDK_INT < 28) ? f(str) : strH;
    }

    public static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused) {
                        }
                        return line;
                    }
                    bufferedReader2.close();
                    return "";
                } catch (IOException unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                return "";
            }
        } catch (IOException unused5) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean i(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j() {
        return f25311m[0].equals(c().f25320a);
    }
}
