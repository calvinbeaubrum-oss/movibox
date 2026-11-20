package ql;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f74802a;

    public static synchronized c c() {
        try {
            if (f74802a == null) {
                f74802a = new c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f74802a;
    }

    public void a(String str) {
    }

    public void b(String str) {
        Log.e("FirebasePerformance", str);
    }

    public void d(String str) {
    }

    public void e(String str) {
        Log.w("FirebasePerformance", str);
    }
}
