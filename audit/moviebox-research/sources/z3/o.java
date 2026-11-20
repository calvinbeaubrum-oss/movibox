package z3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f81817b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f81818c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f81816a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f81819d = a.f81820a;

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f81820a = new C0928a();

        /* JADX INFO: renamed from: z3.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0928a implements a {
            @Override // z3.o.a
            public void a(String str, String str2, @Nullable Throwable th2) {
                o.a(str2, th2);
            }

            @Override // z3.o.a
            public void b(String str, String str2, @Nullable Throwable th2) {
                o.a(str2, th2);
            }

            @Override // z3.o.a
            public void e(String str, String str2, @Nullable Throwable th2) {
                Log.e(str, o.a(str2, th2));
            }

            @Override // z3.o.a
            public void w(String str, String str2, @Nullable Throwable th2) {
                Log.w(str, o.a(str2, th2));
            }
        }

        void a(String str, String str2, @Nullable Throwable th2);

        void b(String str, String str2, @Nullable Throwable th2);

        void e(String str, String str2, @Nullable Throwable th2);

        void w(String str, String str2, @Nullable Throwable th2);
    }

    public static String a(String str, @Nullable Throwable th2) {
        String strE = e(th2);
        if (TextUtils.isEmpty(strE)) {
            return str;
        }
        return str + "\n  " + strE.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2) {
        synchronized (f81816a) {
            try {
                if (f81817b == 0) {
                    f81819d.a(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void c(String str, String str2) {
        synchronized (f81816a) {
            try {
                if (f81817b <= 3) {
                    f81819d.e(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void d(String str, String str2, @Nullable Throwable th2) {
        synchronized (f81816a) {
            try {
                if (f81817b <= 3) {
                    f81819d.e(str, str2, th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Nullable
    public static String e(@Nullable Throwable th2) {
        if (th2 == null) {
            return null;
        }
        synchronized (f81816a) {
            try {
                if (g(th2)) {
                    return "UnknownHostException (no network)";
                }
                if (f81818c) {
                    return Log.getStackTraceString(th2).trim().replace("\t", "    ");
                }
                return th2.getMessage();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static void f(String str, String str2) {
        synchronized (f81816a) {
            try {
                if (f81817b <= 1) {
                    f81819d.b(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean g(@Nullable Throwable th2) {
        while (th2 != null) {
            if (th2 instanceof UnknownHostException) {
                return true;
            }
            th2 = th2.getCause();
        }
        return false;
    }

    public static void h(String str, String str2) {
        synchronized (f81816a) {
            try {
                if (f81817b <= 2) {
                    f81819d.w(str, str2, null);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void i(String str, String str2, @Nullable Throwable th2) {
        synchronized (f81816a) {
            try {
                if (f81817b <= 2) {
                    f81819d.w(str, str2, th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
