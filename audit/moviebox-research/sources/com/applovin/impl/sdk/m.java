package com.applovin.impl.sdk;

import com.applovin.impl.af;
import com.applovin.impl.sj;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a f22654j = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22655a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f22657c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f22660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f22661g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f22656b = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f22658d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f22659e = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f22662h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f22663i = new Object();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f22664a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22665b;

        public static /* synthetic */ int a(a aVar) {
            int i11 = aVar.f22665b;
            aVar.f22665b = i11 + 1;
            return i11;
        }

        public int a() {
            return this.f22665b;
        }

        public boolean a(Object obj) {
            return obj instanceof a;
        }

        public long b() {
            return this.f22664a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.a((Object) this) && b() == aVar.b() && a() == aVar.a();
        }

        public int hashCode() {
            long jB = b();
            return ((((int) (jB ^ (jB >>> 32))) + 59) * 59) + a();
        }

        public String toString() {
            return "FullScreenAdTracker.LostShowAttemptsData(lastAttemptedTimeMillis=" + b() + ", attemptCount=" + a() + ")";
        }
    }

    public m(j jVar) {
        this.f22655a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l11) {
        if (d() && System.currentTimeMillis() - this.f22660f >= l11.longValue()) {
            this.f22655a.J();
            if (n.a()) {
                this.f22655a.J().a("FullScreenAdTracker", "Resetting \"pending display\" state...");
            }
            this.f22659e.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l11, Object obj) {
        if (this.f22656b.get() && System.currentTimeMillis() - this.f22657c >= l11.longValue()) {
            this.f22655a.J();
            if (n.a()) {
                this.f22655a.J().a("FullScreenAdTracker", "Resetting \"display\" state...");
            }
            b(obj);
        }
    }

    public Object a() {
        return this.f22661g;
    }

    public void a(final Object obj) {
        if (!af.a(obj) && this.f22656b.compareAndSet(false, true)) {
            this.f22661g = obj;
            this.f22657c = System.currentTimeMillis();
            this.f22655a.J();
            if (n.a()) {
                this.f22655a.J().a("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.f22657c);
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final Long l11 = (Long) this.f22655a.a(sj.f22936d2);
            if (l11.longValue() >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.i1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f22560a.a(l11, obj);
                    }
                }, l11.longValue());
            }
        }
    }

    public void a(String str) {
        synchronized (this.f22663i) {
            this.f22662h.remove(str);
        }
    }

    public void a(boolean z11) {
        synchronized (this.f22658d) {
            try {
                this.f22659e.set(z11);
                if (z11) {
                    this.f22660f = System.currentTimeMillis();
                    this.f22655a.J();
                    if (n.a()) {
                        this.f22655a.J().a("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f22660f);
                    }
                    final Long l11 = (Long) this.f22655a.a(sj.f22928c2);
                    if (l11.longValue() >= 0) {
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.j1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f22623a.a(l11);
                            }
                        }, l11.longValue());
                    }
                } else {
                    this.f22660f = 0L;
                    this.f22655a.J();
                    if (n.a()) {
                        this.f22655a.J().a("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long b() {
        return this.f22657c;
    }

    public a b(String str) {
        a aVar;
        synchronized (this.f22663i) {
            aVar = (a) this.f22662h.get(str);
            if (aVar == null) {
                aVar = f22654j;
            }
        }
        return aVar;
    }

    public void b(Object obj) {
        if (!af.a(obj) && this.f22656b.compareAndSet(true, false)) {
            this.f22661g = null;
            this.f22655a.J();
            if (n.a()) {
                this.f22655a.J().a("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public void c(String str) {
        synchronized (this.f22663i) {
            try {
                a aVar = (a) this.f22662h.get(str);
                if (aVar == null) {
                    aVar = new a();
                    this.f22662h.put(str, aVar);
                }
                aVar.f22664a = System.currentTimeMillis();
                a.a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean c() {
        return this.f22656b.get();
    }

    public boolean d() {
        return this.f22659e.get();
    }
}
