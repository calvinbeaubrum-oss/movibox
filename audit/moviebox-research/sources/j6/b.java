package j6;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f67936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f67937b;

    public static void a(@NonNull String str) {
        c.a(str);
    }

    public static void b() {
        c.b();
    }

    public static void c(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean d() {
        try {
            if (f67937b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    public static boolean e() {
        try {
            if (f67937b == null) {
                f67936a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f67937b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f67937b.invoke(null, Long.valueOf(f67936a))).booleanValue();
        } catch (Exception e11) {
            c("isTagEnabled", e11);
            return false;
        }
    }
}
