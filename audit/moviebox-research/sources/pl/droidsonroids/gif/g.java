package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f73931a;

    public static Context a() {
        if (f73931a == null) {
            try {
                f73931a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e11) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e11);
            }
        }
        return f73931a;
    }

    public static void b() {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            pl.droidsonroids.relinker.b.a(a(), "pl_droidsonroids_gif");
        }
    }
}
