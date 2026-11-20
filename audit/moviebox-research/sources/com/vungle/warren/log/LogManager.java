package com.vungle.warren.log;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.vungle.warren.Vungle;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.persistence.FilePreferences;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class LogManager {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f62057o = "com.vungle";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f62058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f62059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f62060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FilePreferences f62061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.vungle.warren.log.a f62062e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f62063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f62064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f62065h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtomicInteger f62066i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f62067j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f62068k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f62069l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Gson f62070m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f62071n;

    /* JADX INFO: compiled from: source.java */
    public class a implements b {
        public a() {
        }

        @Override // com.vungle.warren.log.LogManager.b
        public void a() {
            LogManager.this.k();
        }

        @Override // com.vungle.warren.log.LogManager.b
        public boolean b() {
            return LogManager.this.g();
        }

        @Override // com.vungle.warren.log.LogManager.b
        public void c(@NonNull VungleLogger.LoggerLevel loggerLevel, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
            LogManager.this.i(loggerLevel, str, str2, str3, str4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a();

        boolean b();

        void c(@NonNull VungleLogger.LoggerLevel loggerLevel, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4);
    }

    public LogManager(@NonNull Context context, @NonNull c cVar, @NonNull d dVar, @NonNull Executor executor, @NonNull FilePreferences filePreferences) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f62063f = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        this.f62064g = atomicBoolean2;
        this.f62065h = f62057o;
        this.f62066i = new AtomicInteger(5);
        this.f62067j = false;
        this.f62069l = new ConcurrentHashMap();
        this.f62070m = new Gson();
        this.f62071n = new a();
        this.f62068k = context.getPackageName();
        this.f62059b = dVar;
        this.f62058a = cVar;
        this.f62060c = executor;
        this.f62061d = filePreferences;
        cVar.w(this.f62071n);
        Package r11 = Vungle.class.getPackage();
        if (r11 != null) {
            f62057o = r11.getName();
        }
        atomicBoolean.set(filePreferences.d("logging_enabled", false));
        atomicBoolean2.set(filePreferences.d("crash_report_enabled", false));
        this.f62065h = filePreferences.f("crash_collect_filter", f62057o);
        this.f62066i.set(filePreferences.e("crash_batch_max", 5));
        f();
    }

    public LogManager(@NonNull Context context, @NonNull com.vungle.warren.persistence.a aVar, @NonNull VungleApiClient vungleApiClient, @NonNull Executor executor, @NonNull FilePreferences filePreferences) {
        this(context, new c(aVar.g()), new d(vungleApiClient, filePreferences), executor, filePreferences);
    }

    public final String e() {
        if (this.f62069l.isEmpty()) {
            return null;
        }
        return this.f62070m.toJson(this.f62069l);
    }

    public synchronized void f() {
        try {
            if (!this.f62067j) {
                if (!g()) {
                    return;
                }
                if (this.f62062e == null) {
                    this.f62062e = new com.vungle.warren.log.a(this.f62071n);
                }
                this.f62062e.a(this.f62065h);
                this.f62067j = true;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean g() {
        return this.f62064g.get();
    }

    public boolean h() {
        return this.f62063f.get();
    }

    public void i(@NonNull final VungleLogger.LoggerLevel loggerLevel, @NonNull final String str, @NonNull final String str2, @Nullable final String str3, @Nullable final String str4) {
        final String strL = VungleApiClient.l();
        if (loggerLevel != VungleLogger.LoggerLevel.CRASH || !g()) {
            this.f62060c.execute(new Runnable() { // from class: com.vungle.warren.log.LogManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LogManager.this.h()) {
                        LogManager.this.f62058a.u(str2, loggerLevel.toString(), str, "", strL, LogManager.this.f62068k, LogManager.this.e(), str3, str4);
                    }
                }
            });
        } else {
            synchronized (this) {
                this.f62058a.s(str2, loggerLevel.toString(), str, "", strL, this.f62068k, e(), str3, str4);
            }
        }
    }

    public final void j() {
        File[] fileArrP;
        if (!g() || (fileArrP = this.f62058a.p(this.f62066i.get())) == null || fileArrP.length == 0) {
            return;
        }
        this.f62059b.e(fileArrP);
    }

    public final void k() {
        File[] fileArrR;
        if (!h() || (fileArrR = this.f62058a.r()) == null || fileArrR.length == 0) {
            return;
        }
        this.f62059b.e(fileArrR);
    }

    public void l() {
        j();
        k();
    }

    public void m(boolean z11) {
        if (this.f62063f.compareAndSet(!z11, z11)) {
            this.f62061d.l("logging_enabled", z11);
            this.f62061d.c();
        }
    }

    public void n(int i11) {
        c cVar = this.f62058a;
        if (i11 <= 0) {
            i11 = 100;
        }
        cVar.v(i11);
    }

    public synchronized void o(boolean z11, @Nullable String str, int i11) {
        try {
            boolean z12 = true;
            boolean z13 = this.f62064g.get() != z11;
            boolean z14 = (TextUtils.isEmpty(str) || str.equals(this.f62065h)) ? false : true;
            int iMax = Math.max(i11, 0);
            if (this.f62066i.get() == iMax) {
                z12 = false;
            }
            if (z13 || z14 || z12) {
                if (z13) {
                    this.f62064g.set(z11);
                    this.f62061d.l("crash_report_enabled", z11);
                }
                if (z14) {
                    if ("*".equals(str)) {
                        this.f62065h = "";
                    } else {
                        this.f62065h = str;
                    }
                    this.f62061d.j("crash_collect_filter", this.f62065h);
                }
                if (z12) {
                    this.f62066i.set(iMax);
                    this.f62061d.i("crash_batch_max", iMax);
                }
                this.f62061d.c();
                com.vungle.warren.log.a aVar = this.f62062e;
                if (aVar != null) {
                    aVar.a(this.f62065h);
                }
                if (z11) {
                    f();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
