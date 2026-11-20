package z3;

import android.os.Trace;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    public static void a(String str) {
        if (u0.f81838a >= 18) {
            b(str);
        }
    }

    @RequiresApi(18)
    public static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (u0.f81838a >= 18) {
            d();
        }
    }

    @RequiresApi(18)
    public static void d() {
        Trace.endSection();
    }
}
