package com.apm.insight.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.nativecrash.NativeImpl;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f17090a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f17091b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f17092c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f17093d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f17094e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static c f17095f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f17096g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f17097h = false;

    public static c a() {
        return f17095f;
    }

    public static void a(long j11) {
        NativeImpl.a(j11);
    }

    public static synchronized void a(@NonNull Application application, @NonNull Context context) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (f17090a) {
                return;
            }
            f17090a = true;
            if (context == null || application == null) {
                throw new IllegalArgumentException("context or Application must be not null.");
            }
            com.apm.insight.e.a(application, context);
            if (!com.apm.insight.e.u() || (!b(application) && !c(application))) {
                com.apm.insight.g.a aVarA = com.apm.insight.g.a.a();
                aVarA.a(new com.apm.insight.i.b(context));
                aVarA.b(new com.apm.insight.g.d(context));
                f17091b = true;
                NativeImpl.a();
                boolean zA = NativeImpl.a(context);
                f17093d = zA;
                if (!zA) {
                    f17094e = true;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    f17096g = true;
                    NativeImpl.i();
                }
                n.a().a(new Runnable() { // from class: com.apm.insight.runtime.m.2

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    private /* synthetic */ boolean f17100a = true;

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!m.f17096g) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.apm.insight.runtime.m.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    m.r();
                                    NativeImpl.i();
                                }
                            });
                        }
                        m.e(this.f17100a);
                    }
                }, 0L);
                com.apm.insight.a.a((Object) ("Npth.init takes " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms."));
                return;
            }
            Log.e("apminsight", "Inner npth checked.");
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void a(@NonNull Context context) {
        Application applicationH;
        try {
            if (com.apm.insight.e.h() != null) {
                applicationH = com.apm.insight.e.h();
            } else if (context instanceof Application) {
                applicationH = (Application) context;
                if (applicationH.getBaseContext() == null) {
                    throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                }
            } else {
                try {
                    applicationH = (Application) context.getApplicationContext();
                    if (applicationH == null) {
                        throw new IllegalArgumentException("Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.");
                    }
                    if (applicationH.getBaseContext() != null) {
                        context = applicationH.getBaseContext();
                    }
                } catch (Throwable unused) {
                    throw new IllegalArgumentException("Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.");
                }
            }
            a(applicationH, context);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void a(ICrashCallback iCrashCallback, CrashType crashType) {
        f17095f.a(iCrashCallback, crashType);
    }

    public static void a(IOOMCallback iOOMCallback) {
        f17095f.a(iOOMCallback);
    }

    public static void a(com.apm.insight.b.h.a aVar) {
        i.a(aVar);
    }

    public static void a(@NonNull com.apm.insight.b.i.a aVar) {
        com.apm.insight.e.i().setEncryptImpl$22f2d42e(aVar);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str);
    }

    public static void a(final String str, final com.apm.insight.b.h.a aVar) {
        n.a().a(new Runnable() { // from class: com.apm.insight.runtime.m.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.apm.insight.l.a.c(com.apm.insight.e.g())) {
                    com.apm.insight.b.d.a(str, aVar);
                }
            }
        });
    }

    public static void a(String str, com.apm.insight.b.i.a aVar, com.apm.insight.b.i.a aVar2) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        com.apm.insight.a.a.a().a(str, aVar, aVar2);
    }

    public static void a(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable com.apm.insight.b.h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, aVar);
    }

    public static void a(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @Nullable com.apm.insight.b.h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, map3, aVar);
    }

    @Deprecated
    public static void a(@NonNull Throwable th2) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.a(th2);
        }
    }

    public static void a(boolean z11) {
        com.apm.insight.e.a(z11);
    }

    public static void b(long j11) {
        NativeImpl.b(j11);
    }

    public static void b(ICrashCallback iCrashCallback, CrashType crashType) {
        f17095f.b(iCrashCallback, crashType);
    }

    public static void b(IOOMCallback iOOMCallback) {
        f17095f.b(iOOMCallback);
    }

    public static void b(com.apm.insight.b.h.a aVar) {
        com.apm.insight.k.e.a(aVar);
    }

    @Deprecated
    public static void b(String str) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.c(str);
        }
    }

    public static void b(boolean z11) {
        com.apm.insight.e.b(z11);
    }

    public static boolean b() {
        return f17091b;
    }

    private static boolean b(Context context) {
        try {
            return new File(com.apm.insight.l.j.j(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(String str) {
        NativeImpl.b(str);
    }

    public static void c(boolean z11) {
        com.apm.insight.e.c(z11);
    }

    public static boolean c() {
        return f17092c;
    }

    private static boolean c(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libnpth.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void d(boolean z11) {
        com.apm.insight.e.d(z11);
    }

    public static boolean d() {
        return f17093d;
    }

    public static /* synthetic */ void e(boolean z11) {
        Context contextG = com.apm.insight.e.g();
        com.apm.insight.runtime.a.f.a();
        k.a();
        int iB = NativeImpl.b();
        NativeImpl.d();
        if (f17094e) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("NativeLibraryLoad faild");
        } else if (iB < 0) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("createCallbackThread faild");
        }
        com.apm.insight.e.a.a().a(contextG);
        com.apm.insight.c.a();
        com.apm.insight.k.h.a(contextG);
        if (z11) {
            com.apm.insight.b.f.a(contextG).c();
            f17092c = z11;
        }
        com.apm.insight.k.g.a().b();
        NativeImpl.g();
        com.apm.insight.k.j.d();
        NativeImpl.k();
        p.a("afterNpthInitAsync", "noValue");
    }

    public static boolean e() {
        return f17090a;
    }

    public static void f() {
        if (!f17090a || f17091b) {
            return;
        }
        Context contextG = com.apm.insight.e.g();
        com.apm.insight.g.a aVarA = com.apm.insight.g.a.a();
        aVarA.a(new com.apm.insight.i.b(contextG));
        aVarA.b(new com.apm.insight.g.d(contextG));
    }

    public static void g() {
        if (f17090a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).c();
            f17092c = true;
        }
    }

    public static boolean h() {
        if (f17090a && !f17093d) {
            boolean zA = NativeImpl.a(com.apm.insight.e.g());
            f17093d = zA;
            if (!zA) {
                f17094e = true;
            }
        }
        return f17093d;
    }

    public static boolean i() {
        return com.apm.insight.b.c.c();
    }

    public static void j() {
        if (f17090a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).d();
            f17092c = false;
        }
    }

    public static void k() {
        NativeImpl.c();
    }

    public static boolean l() {
        return com.apm.insight.g.a.b() || NativeImpl.e();
    }

    public static boolean m() {
        return com.apm.insight.g.a.c() || NativeImpl.e();
    }

    public static boolean n() {
        return com.apm.insight.g.a.b();
    }

    public static boolean o() {
        return f17097h;
    }

    public static void p() {
        f17097h = true;
    }

    public static /* synthetic */ boolean r() {
        f17096g = true;
        return true;
    }
}
