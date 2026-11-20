package com.vungle.warren;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import com.vungle.warren.utility.ActivityManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y00.h f62020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f62021b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f62022c = -2147483648L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f62023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f62024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f62025f;

    /* JADX INFO: compiled from: source.java */
    public class a extends ActivityManager.e {
        public a() {
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void c() {
            super.c();
            g.this.b();
        }

        @Override // com.vungle.warren.utility.ActivityManager.e
        public void d() {
            super.d();
            g.this.f();
        }
    }

    public g(@NonNull y00.h hVar) {
        this.f62020a = hVar;
        if (ActivityManager.p().s()) {
            c();
        } else {
            Log.e(g.class.getSimpleName(), "No lifecycle listener set");
            VungleLogger.c(g.class.getSimpleName() + "#deliverError", "No lifecycle listener set");
        }
        this.f62025f = 0;
    }

    public long a() {
        return SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f62025f != 0 || this.f62021b == 0) {
            return;
        }
        this.f62025f = 1;
        Bundle bundle = new Bundle();
        bundle.putLong("cache_bust_interval", this.f62021b);
        bundle.putLong("next_cache_bust", a() + this.f62021b);
        this.f62020a.a(y00.b.c().k(this.f62021b - this.f62024e).o(this.f62021b, 0).l(bundle));
        this.f62024e = 0L;
        this.f62023d = a();
    }

    public final void c() {
        ActivityManager.p().n(new a());
    }

    public void d(long j11) {
        long j12 = this.f62022c;
        if (j12 != -2147483648L) {
            this.f62021b = j12;
            return;
        }
        long jMax = j11 > 0 ? Math.max(j11, 900000L) : 0L;
        if (jMax != this.f62021b) {
            this.f62021b = jMax;
            if (this.f62025f == 1) {
                this.f62020a.b(y00.b.f81028d);
                this.f62025f = 0;
                e();
            }
        }
    }

    public synchronized void e() {
        try {
            if (this.f62025f == 1) {
                return;
            }
            this.f62025f = 1;
            if (this.f62021b == 0) {
                this.f62020a.a(y00.b.c());
            } else {
                Bundle bundle = new Bundle();
                bundle.putLong("cache_bust_interval", this.f62021b);
                bundle.putLong("next_cache_bust", a() + this.f62021b);
                this.f62020a.a(y00.b.c().o(this.f62021b, 0).l(bundle));
            }
            this.f62023d = a();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void f() {
        if (this.f62021b != 0) {
            this.f62024e = (a() - this.f62023d) % this.f62021b;
        }
        this.f62020a.b(y00.b.f81028d);
        this.f62025f = 0;
    }
}
