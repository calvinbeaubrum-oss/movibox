package com.cloud.hisavana.sdk.common.tranmeasure;

import android.os.Handler;
import android.os.Looper;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends Monitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Handler f29462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f29463b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f29464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f.b f29465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f29466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f29467f;

    /* JADX INFO: compiled from: source.java */
    public class a implements f.b {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.f.b
        public void a(boolean z11) {
            if (z11) {
                b.this.a();
            } else {
                b.this.c();
            }
        }
    }

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.tranmeasure.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class RunnableC0325b implements Runnable {
        public RunnableC0325b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f29463b) {
                e.c().i();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.f29463b || b.this.f29462a == null) {
                return;
            }
            b.this.f29462a.post(b.this.f29466e);
            b.this.f29462a.postDelayed(b.this.f29467f, 200L);
        }
    }

    public b() {
        a aVar = new a();
        this.f29465d = aVar;
        this.f29466e = new RunnableC0325b();
        this.f29467f = new c();
        f fVar = new f();
        this.f29464c = fVar;
        fVar.c(aVar);
    }

    public final void a() {
        if (Looper.myLooper() == null) {
            return;
        }
        this.f29463b = true;
        if (this.f29462a == null) {
            this.f29462a = new Handler(Looper.myLooper());
        }
        this.f29462a.post(this.f29466e);
        this.f29462a.postDelayed(this.f29467f, 200L);
    }

    public final void c() {
        this.f29463b = false;
        if (this.f29462a != null) {
            this.f29462a.removeCallbacks(this.f29467f);
            this.f29462a = null;
        }
    }

    @Override // com.cloud.hisavana.sdk.common.tranmeasure.Monitor
    public void end() {
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "stop monitor");
        this.f29463b = false;
        this.f29464c.b();
        c();
    }

    @Override // com.cloud.hisavana.sdk.common.tranmeasure.Monitor
    public void start() {
        if (this.f29463b && this.f29462a != null && this.f29462a.hasMessages(0)) {
            z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "monitor is running");
            return;
        }
        z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "start monitor");
        a();
        this.f29464c.c(this.f29465d);
        this.f29464c.h();
    }
}
