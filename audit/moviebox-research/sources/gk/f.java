package gk;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f65568c = new f("FirebaseCrashlytics");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f65570b = 4;

    public f(String str) {
        this.f65569a = str;
    }

    public static f f() {
        return f65568c;
    }

    public final boolean a(int i11) {
        return this.f65570b <= i11 || Log.isLoggable(this.f65569a, i11);
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th2) {
        a(3);
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th2) {
        if (a(6)) {
            Log.e(this.f65569a, str, th2);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th2) {
        a(4);
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th2) {
        if (a(2)) {
            Log.v(this.f65569a, str, th2);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th2) {
        if (a(5)) {
            Log.w(this.f65569a, str, th2);
        }
    }
}
