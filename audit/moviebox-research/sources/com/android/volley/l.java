package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f16525a = "Volley";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f16526b = Log.isLoggable("Volley", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16527c = l.class.getName();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final boolean f16528c = l.f16526b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C0162a> f16529a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f16530b = false;

        /* JADX INFO: renamed from: com.android.volley.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0162a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f16531a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f16532b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f16533c;

            public C0162a(String str, long j11, long j12) {
                this.f16531a = str;
                this.f16532b = j11;
                this.f16533c = j12;
            }
        }

        public synchronized void a(String str, long j11) {
            if (this.f16530b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f16529a.add(new C0162a(str, j11, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.f16530b = true;
            long jC = c();
            if (jC <= 0) {
                return;
            }
            long j11 = this.f16529a.get(0).f16533c;
            l.b("(%-4d ms) %s", Long.valueOf(jC), str);
            for (C0162a c0162a : this.f16529a) {
                long j12 = c0162a.f16533c;
                l.b("(+%-4d) [%2d] %s", Long.valueOf(j12 - j11), Long.valueOf(c0162a.f16532b), c0162a.f16531a);
                j11 = j12;
            }
        }

        public final long c() {
            if (this.f16529a.size() == 0) {
                return 0L;
            }
            long j11 = this.f16529a.get(0).f16533c;
            List<C0162a> list = this.f16529a;
            return list.get(list.size() - 1).f16533c - j11;
        }

        public void finalize() throws Throwable {
            if (this.f16530b) {
                return;
            }
            b("Request on the loose");
            l.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i11 = 2; i11 < stackTrace.length; i11++) {
            if (!stackTrace[i11].getClassName().equals(f16527c)) {
                String className = stackTrace[i11].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + InstructionFileId.DOT + stackTrace[i11].getMethodName();
                return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
            }
        }
        str2 = "<unknown>";
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        Log.e(f16525a, a(str, objArr));
    }

    public static void d(Throwable th2, String str, Object... objArr) {
        Log.e(f16525a, a(str, objArr), th2);
    }

    public static void e(String str, Object... objArr) {
        if (f16526b) {
            Log.v(f16525a, a(str, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        Log.wtf(f16525a, a(str, objArr));
    }
}
