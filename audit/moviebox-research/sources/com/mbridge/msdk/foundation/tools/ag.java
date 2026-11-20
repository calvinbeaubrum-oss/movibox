package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static char[] f44980a = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f44981b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f44982c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f44983d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f44984e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f44985f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f44986g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f44987h = -1;

    public static int a() {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            long jLongValue = ((Long) al.a(contextC, "freeExternalSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 1800000 || f44984e == -1) {
                f44984e = Long.valueOf((c() / 1000) / 1000).intValue();
                al.b(contextC, "freeExternalSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th2) {
            ad.a("SameSDCardTool", th2.getMessage(), th2);
        }
        return f44984e;
    }

    private static File a(File file) {
        File file2 = new File(file, UUID.randomUUID() + "");
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    public static void a(Context context) {
        if (context == null || f44985f) {
            return;
        }
        try {
            try {
                f44981b = context.getFilesDir().getAbsolutePath() + File.separator;
                f44982c = false;
                b(context);
            } catch (Exception unused) {
                f44981b = context.getFilesDir().getAbsolutePath() + File.separator;
                b(context);
            }
        } catch (Exception unused2) {
        }
        f44985f = true;
    }

    public static int b() {
        if (f44987h == -1) {
            try {
                f44987h = new Long((e() / 1000) / 1000).intValue();
            } catch (Throwable th2) {
                ad.a("SameSDCardTool", th2.getMessage(), th2);
            }
        }
        return f44987h;
    }

    private static void b(Context context) {
        com.mbridge.msdk.foundation.same.b.e.a(new com.mbridge.msdk.foundation.same.b.d(c(context)));
        com.mbridge.msdk.foundation.same.b.e.a().b();
    }

    private static long c() {
        if (d()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005f A[PHI: r1
  0x005f: PHI (r1v3 java.io.File) = (r1v2 java.io.File), (r1v5 java.io.File) binds: [B:11:0x0017, B:15:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    private static String c(Context context) {
        File fileA;
        File absoluteFile;
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            fileA = externalFilesDir != null ? a(externalFilesDir) : null;
        } catch (Throwable th2) {
            ad.a("common-exception", "hasSDCard is failed", th2);
        }
        if (f44982c) {
            if (fileA == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Environment.getExternalStorageDirectory().getPath());
                String str = File.separator;
                sb2.append(str);
                sb2.append("Android");
                sb2.append(str);
                sb2.append("data");
                sb2.append(str);
                sb2.append(context.getPackageName());
                fileA = a(new File(sb2.toString()));
            }
            absoluteFile = c() > 31457280 ? fileA : null;
        }
        if (absoluteFile == null || !absoluteFile.exists()) {
            absoluteFile = context.getFilesDir().getAbsoluteFile();
        }
        return absoluteFile.getAbsolutePath();
    }

    private static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            ad.b("", "hasSDCard is failed");
            return false;
        }
    }

    private static long e() {
        if (d()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return 0L;
    }
}
