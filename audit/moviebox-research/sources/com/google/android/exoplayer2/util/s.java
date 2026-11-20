package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f35639b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f35640c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f35638a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f35641d = a.f35642a;

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35642a = new C0375a();

        /* JADX INFO: renamed from: com.google.android.exoplayer2.util.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0375a implements a {
            @Override // com.google.android.exoplayer2.util.s.a
            public void d(String str, String str2) {
            }

            @Override // com.google.android.exoplayer2.util.s.a
            public void e(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // com.google.android.exoplayer2.util.s.a
            public void i(String str, String str2) {
            }

            @Override // com.google.android.exoplayer2.util.s.a
            public void w(String str, String str2) {
                Log.w(str, str2);
            }
        }

        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void w(String str, String str2);
    }

    public static String a(String str, @Nullable Throwable th2) {
        String strE = e(th2);
        if (TextUtils.isEmpty(strE)) {
            return str;
        }
        return str + "\n  " + strE.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (f35638a) {
            try {
                if (f35639b == 0) {
                    f35641d.d(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void c(String str, String str2) {
        synchronized (f35638a) {
            try {
                if (f35639b <= 3) {
                    f35641d.e(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void d(String str, String str2, @Nullable Throwable th2) {
        c(str, a(str2, th2));
    }

    @Nullable
    public static String e(@Nullable Throwable th2) {
        synchronized (f35638a) {
            try {
                if (th2 == null) {
                    return null;
                }
                if (h(th2)) {
                    return "UnknownHostException (no network)";
                }
                if (f35640c) {
                    return Log.getStackTraceString(th2).trim().replace("\t", "    ");
                }
                return th2.getMessage();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static void f(String str, String str2) {
        synchronized (f35638a) {
            try {
                if (f35639b <= 1) {
                    f35641d.i(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void g(String str, String str2, @Nullable Throwable th2) {
        f(str, a(str2, th2));
    }

    public static boolean h(@Nullable Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void i(String str, String str2) {
        synchronized (f35638a) {
            try {
                if (f35639b <= 2) {
                    f35641d.w(str, str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void j(String str, String str2, @Nullable Throwable th2) {
        i(str, a(str2, th2));
    }
}
