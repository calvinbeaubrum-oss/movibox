package com.applovin.impl;

import android.os.Looper;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f22103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f22104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l3 f22105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final fo f22106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f22108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Looper f22109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f22110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f22111i = C.TIME_UNSET;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22112j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f22113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f22114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f22115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f22116n;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(rh rhVar);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11, Object obj);
    }

    public rh(a aVar, b bVar, fo foVar, int i11, l3 l3Var, Looper looper) {
        this.f22104b = aVar;
        this.f22103a = bVar;
        this.f22106d = foVar;
        this.f22109g = looper;
        this.f22105c = l3Var;
        this.f22110h = i11;
    }

    public rh a(int i11) {
        b1.b(!this.f22113k);
        this.f22107e = i11;
        return this;
    }

    public rh a(Object obj) {
        b1.b(!this.f22113k);
        this.f22108f = obj;
        return this;
    }

    public synchronized void a(boolean z11) {
        this.f22114l = z11 | this.f22114l;
        this.f22115m = true;
        notifyAll();
    }

    public boolean a() {
        return this.f22112j;
    }

    public synchronized boolean a(long j11) {
        boolean z11;
        try {
            b1.b(this.f22113k);
            b1.b(this.f22109g.getThread() != Thread.currentThread());
            long jC = this.f22105c.c() + j11;
            while (true) {
                z11 = this.f22115m;
                if (z11 || j11 <= 0) {
                    break;
                }
                this.f22105c.b();
                wait(j11);
                j11 = jC - this.f22105c.c();
            }
            if (!z11) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f22114l;
    }

    public Looper b() {
        return this.f22109g;
    }

    public Object c() {
        return this.f22108f;
    }

    public long d() {
        return this.f22111i;
    }

    public b e() {
        return this.f22103a;
    }

    public fo f() {
        return this.f22106d;
    }

    public int g() {
        return this.f22107e;
    }

    public int h() {
        return this.f22110h;
    }

    public synchronized boolean i() {
        return this.f22116n;
    }

    public rh j() {
        b1.b(!this.f22113k);
        if (this.f22111i == C.TIME_UNSET) {
            b1.a(this.f22112j);
        }
        this.f22113k = true;
        this.f22104b.a(this);
        return this;
    }
}
