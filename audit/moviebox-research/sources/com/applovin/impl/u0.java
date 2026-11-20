package com.applovin.impl;

import android.os.Handler;
import android.os.HandlerThread;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class u0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final u0 f23456l = new u0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f23458b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f23460d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.applovin.impl.sdk.j f23463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Thread f23464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f23465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f23466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f23467k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f23457a = new AtomicLong(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HandlerThread f23459c = new HandlerThread("AppLovinSdk:anr_detector");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f23461e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f23462f = new AtomicBoolean();

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (u0.this.f23461e.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - u0.this.f23457a.get();
            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > u0.this.f23465i) {
                u0.this.a();
                if (u0.this.f23464h == null || u0.this.f23464h.getStackTrace().length <= 0) {
                    str = "None";
                } else {
                    StackTraceElement stackTraceElement = u0.this.f23464h.getStackTrace()[0];
                    str = stackTraceElement.getClassName() + InstructionFileId.DOT + stackTraceElement.getMethodName();
                }
                long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - com.applovin.impl.sdk.j.k());
                HashMap map = new HashMap(3);
                map.put("top_main_method", str);
                map.put("source", u0.this.f23463g.t0() ? "non_first_session" : "first_session");
                map.put("details", "seconds_since_app_launch=" + seconds);
                u0.this.f23463g.E().a(la.C, (Map) map);
            }
            u0.this.f23460d.postDelayed(this, u0.this.f23467k);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u0.this.f23461e.get()) {
                return;
            }
            u0.this.f23457a.set(System.currentTimeMillis());
            u0.this.f23458b.postDelayed(this, u0.this.f23466j);
        }
    }

    private u0() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f23465i = timeUnit.toMillis(4L);
        this.f23466j = timeUnit.toMillis(3L);
        this.f23467k = timeUnit.toMillis(3L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f23462f.get()) {
            this.f23461e.set(true);
        }
    }

    private void a(com.applovin.impl.sdk.j jVar) {
        if (this.f23462f.compareAndSet(false, true)) {
            this.f23463g = jVar;
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20622a.b();
                }
            });
            this.f23465i = ((Long) jVar.a(sj.S5)).longValue();
            this.f23466j = ((Long) jVar.a(sj.T5)).longValue();
            this.f23467k = ((Long) jVar.a(sj.U5)).longValue();
            this.f23458b = new Handler(com.applovin.impl.sdk.j.l().getMainLooper());
            this.f23459c.start();
            this.f23458b.post(new c());
            Handler handler = new Handler(this.f23459c.getLooper());
            this.f23460d = handler;
            handler.postDelayed(new b(), this.f23467k / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f23464h = Thread.currentThread();
    }

    public static void b(com.applovin.impl.sdk.j jVar) {
        if (jVar != null) {
            if (!((Boolean) jVar.a(sj.R5)).booleanValue() || yp.c(jVar)) {
                f23456l.a();
            } else {
                f23456l.a(jVar);
            }
        }
    }
}
