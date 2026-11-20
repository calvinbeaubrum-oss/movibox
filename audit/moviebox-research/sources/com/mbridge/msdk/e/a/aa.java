package com.mbridge.msdk.e.a;

import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f43757a = "TrackManager_Volley";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f43758b = "com.mbridge.msdk.e.a.aa";

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<C0482a> f43759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f43760b;

        /* JADX INFO: renamed from: com.mbridge.msdk.e.a.aa$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0482a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f43761a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f43762b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f43763c;
        }

        public final void finalize() throws Throwable {
            long j11;
            if (this.f43760b) {
                return;
            }
            this.f43760b = true;
            if (this.f43759a.size() == 0) {
                j11 = 0;
            } else {
                long j12 = this.f43759a.get(0).f43763c;
                List<C0482a> list = this.f43759a;
                j11 = list.get(list.size() - 1).f43763c - j12;
            }
            if (j11 > 0) {
                long j13 = this.f43759a.get(0).f43763c;
                aa.b("(%-4d ms) %s", Long.valueOf(j11), "Request on the loose");
                for (C0482a c0482a : this.f43759a) {
                    long j14 = c0482a.f43763c;
                    aa.b("(+%-4d) [%2d] %s", Long.valueOf(j14 - j13), Long.valueOf(c0482a.f43762b), c0482a.f43761a);
                    j13 = j14;
                }
            }
            aa.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
    }

    public static void a(Throwable th2, String str, Object... objArr) {
        Log.e(f43757a, d(str, objArr), th2);
    }

    public static void b(String str, Object... objArr) {
        d(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        Log.e(f43757a, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i11 = 2; i11 < stackTrace.length; i11++) {
            if (!stackTrace[i11].getClassName().equals(f43758b)) {
                String className = stackTrace[i11].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + InstructionFileId.DOT + stackTrace[i11].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
