package com.google.android.exoplayer2;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f33708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f33709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f33710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j3 f33711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f33712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Object f33713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Looper f33714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f33715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f33716i = C.TIME_UNSET;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f33717j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f33718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f33719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f33720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f33721n;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b(r2 r2Var);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException;
    }

    public r2(a aVar, b bVar, j3 j3Var, int i11, com.google.android.exoplayer2.util.e eVar, Looper looper) {
        this.f33709b = aVar;
        this.f33708a = bVar;
        this.f33711d = j3Var;
        this.f33714g = looper;
        this.f33710c = eVar;
        this.f33715h = i11;
    }

    public synchronized boolean a(long j11) throws InterruptedException, TimeoutException {
        boolean z11;
        try {
            com.google.android.exoplayer2.util.a.g(this.f33718k);
            com.google.android.exoplayer2.util.a.g(this.f33714g.getThread() != Thread.currentThread());
            long jElapsedRealtime = this.f33710c.elapsedRealtime() + j11;
            while (true) {
                z11 = this.f33720m;
                if (z11 || j11 <= 0) {
                    break;
                }
                this.f33710c.a();
                wait(j11);
                j11 = jElapsedRealtime - this.f33710c.elapsedRealtime();
            }
            if (!z11) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f33719l;
    }

    public boolean b() {
        return this.f33717j;
    }

    public Looper c() {
        return this.f33714g;
    }

    public int d() {
        return this.f33715h;
    }

    @Nullable
    public Object e() {
        return this.f33713f;
    }

    public long f() {
        return this.f33716i;
    }

    public b g() {
        return this.f33708a;
    }

    public j3 h() {
        return this.f33711d;
    }

    public int i() {
        return this.f33712e;
    }

    public synchronized boolean j() {
        return this.f33721n;
    }

    public synchronized void k(boolean z11) {
        this.f33719l = z11 | this.f33719l;
        this.f33720m = true;
        notifyAll();
    }

    public r2 l() {
        com.google.android.exoplayer2.util.a.g(!this.f33718k);
        if (this.f33716i == C.TIME_UNSET) {
            com.google.android.exoplayer2.util.a.a(this.f33717j);
        }
        this.f33718k = true;
        this.f33709b.b(this);
        return this;
    }

    public r2 m(@Nullable Object obj) {
        com.google.android.exoplayer2.util.a.g(!this.f33718k);
        this.f33713f = obj;
        return this;
    }

    public r2 n(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f33718k);
        this.f33712e = i11;
        return this;
    }
}
