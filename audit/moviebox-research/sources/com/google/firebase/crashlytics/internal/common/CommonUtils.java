package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class CommonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f40099a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f40100b = -1;

    /* JADX INFO: compiled from: source.java */
    public enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;

        private static final Map<String, Architecture> matcher;

        static {
            Architecture architecture = X86_32;
            Architecture architecture2 = ARMV6;
            Architecture architecture3 = ARMV7;
            Architecture architecture4 = ARM64;
            HashMap map = new HashMap(4);
            matcher = map;
            map.put("armeabi-v7a", architecture3);
            map.put("armeabi", architecture2);
            map.put("arm64-v8a", architecture4);
            map.put("x86", architecture);
        }

        public static Architecture getValue() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                gk.f.f().i("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = matcher.get(str.toLowerCase(Locale.US));
            return architecture == null ? UNKNOWN : architecture;
        }
    }

    public static boolean A(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static String B(String str) {
        return t(str, EncoderUtil.ALGORITHM_SHA_1);
    }

    public static String C(InputStream inputStream) {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    @SuppressLint({"MissingPermission"})
    public static boolean c(Context context) {
        if (!d(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean d(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void e(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                gk.f.f().e(str, e11);
            }
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static long g(String str, String str2, int i11) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i11);
    }

    public static String h(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
        }
        String string = sb2.toString();
        if (string.length() > 0) {
            return B(string);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static String i(File file, String str) throws Throwable {
        ?? Exists = file.exists();
        String str2 = null;
        str2 = null;
        str2 = null;
        ?? r11 = 0;
        try {
            if (Exists != 0) {
                try {
                    Exists = new BufferedReader(new FileReader(file), 1024);
                    while (true) {
                        try {
                            String line = Exists.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] strArrSplit = Pattern.compile("\\s*:\\s*").split(line, 2);
                            if (strArrSplit.length > 1 && strArrSplit[0].equals(str)) {
                                str2 = strArrSplit[1];
                                break;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            gk.f.f().e("Error parsing " + file, e);
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    Exists = 0;
                } catch (Throwable th2) {
                    th = th2;
                    e(r11, "Failed to close system file reader.");
                    throw th;
                }
                e(Exists, "Failed to close system file reader.");
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            r11 = Exists;
        }
    }

    public static ActivityManager.RunningAppProcessInfo j(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static boolean k(Context context, String str, boolean z11) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int iQ = q(context, str, "bool");
            if (iQ > 0) {
                return resources.getBoolean(iQ);
            }
            int iQ2 = q(context, str, "string");
            if (iQ2 > 0) {
                return Boolean.parseBoolean(context.getString(iQ2));
            }
        }
        return z11;
    }

    public static int l() {
        return Architecture.getValue().ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int m() {
        boolean zY = y();
        ?? r11 = zY;
        if (z()) {
            r11 = (zY ? 1 : 0) | 2;
        }
        return x() ? r11 | 4 : r11;
    }

    public static String n(Context context) {
        int iQ = q(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (iQ == 0) {
            iQ = q(context, "com.crashlytics.android.build_id", "string");
        }
        if (iQ != 0) {
            return context.getResources().getString(iQ);
        }
        return null;
    }

    public static boolean o(Context context) {
        return (y() || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    public static String p(Context context) {
        int i11 = context.getApplicationContext().getApplicationInfo().icon;
        if (i11 <= 0) {
            return context.getPackageName();
        }
        try {
            String resourcePackageName = context.getResources().getResourcePackageName(i11);
            return "android".equals(resourcePackageName) ? context.getPackageName() : resourcePackageName;
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static int q(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, p(context));
    }

    public static SharedPreferences r(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static synchronized long s() {
        try {
            if (f40100b == -1) {
                String strI = i(new File("/proc/meminfo"), "MemTotal");
                long jG = 0;
                if (!TextUtils.isEmpty(strI)) {
                    String upperCase = strI.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            jG = g(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            jG = g(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            jG = g(upperCase, "GB", 1073741824);
                        } else {
                            gk.f.f().k("Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e11) {
                        gk.f.f().e("Unexpected meminfo format while computing RAM: " + upperCase, e11);
                    }
                }
                f40100b = jG;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f40100b;
    }

    public static String t(String str, String str2) {
        return u(str.getBytes(), str2);
    }

    public static String u(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return v(messageDigest.digest());
        } catch (NoSuchAlgorithmException e11) {
            gk.f.f().e("Could not create hashing algorithm: " + str + ", returning empty string.", e11);
            return "";
        }
    }

    public static String v(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            int i12 = i11 * 2;
            char[] cArr2 = f40099a;
            cArr[i12] = cArr2[(b11 & 255) >>> 4];
            cArr[i12 + 1] = cArr2[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static boolean w(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean x() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static boolean y() {
        if (!Build.PRODUCT.contains("sdk")) {
            String str = Build.HARDWARE;
            if (!str.contains("goldfish") && !str.contains("ranchu")) {
                return false;
            }
        }
        return true;
    }

    public static boolean z() {
        boolean zY = y();
        String str = Build.TAGS;
        if ((zY || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !zY && new File("/system/xbin/su").exists();
        }
        return true;
    }
}
