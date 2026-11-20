package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f7800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f7801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f7802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f7803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f7804e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f7800a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f7801b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f7802c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f7803d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f7804e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
