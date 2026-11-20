package kotlin.jvm.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Intrinsics {

    /* JADX INFO: compiled from: source.java */
    @SinceKotlin
    public static class Kotlin {
        private Kotlin() {
        }
    }

    private Intrinsics() {
    }

    @SinceKotlin
    public static boolean a(Float f11, float f12) {
        return f11 != null && f11.floatValue() == f12;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) n(new IllegalStateException(str + " must not be null")));
    }

    public static void d(Object obj) {
        if (obj == null) {
            q();
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) n(new NullPointerException(str + " must not be null")));
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            u(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            t(str);
        }
    }

    public static int i(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 == i12 ? 0 : 1;
    }

    public static int j(long j11, long j12) {
        if (j11 < j12) {
            return -1;
        }
        return j11 == j12 ? 0 : 1;
    }

    public static String k(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        int i11 = 0;
        while (!stackTrace[i11].getClassName().equals(name)) {
            i11++;
        }
        while (stackTrace[i11].getClassName().equals(name)) {
            i11++;
        }
        StackTraceElement stackTraceElement = stackTrace[i11];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + InstructionFileId.DOT + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void l() {
        v();
    }

    public static void m(int i11, String str) {
        v();
    }

    public static <T extends Throwable> T n(T t11) {
        return (T) o(t11, Intrinsics.class.getName());
    }

    public static <T extends Throwable> T o(T t11, String str) {
        StackTraceElement[] stackTrace = t11.getStackTrace();
        int length = stackTrace.length;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            if (str.equals(stackTrace[i12].getClassName())) {
                i11 = i12;
            }
        }
        t11.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i11 + 1, length));
        return t11;
    }

    public static String p(String str, Object obj) {
        return str + obj;
    }

    @SinceKotlin
    public static void q() {
        throw ((NullPointerException) n(new NullPointerException()));
    }

    @SinceKotlin
    public static void r(String str) {
        throw ((NullPointerException) n(new NullPointerException(str)));
    }

    public static void s() {
        throw ((KotlinNullPointerException) n(new KotlinNullPointerException()));
    }

    public static void t(String str) {
        throw ((IllegalArgumentException) n(new IllegalArgumentException(k(str))));
    }

    public static void u(String str) {
        throw ((NullPointerException) n(new NullPointerException(k(str))));
    }

    public static void v() {
        w("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void w(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void x(String str) {
        throw ((UninitializedPropertyAccessException) n(new UninitializedPropertyAccessException(str)));
    }

    public static void y(String str) {
        x("lateinit property " + str + " has not been initialized");
    }
}
