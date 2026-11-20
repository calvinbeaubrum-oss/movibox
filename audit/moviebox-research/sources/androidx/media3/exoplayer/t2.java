package androidx.media3.exoplayer;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.d f11385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.common.m0 f11386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Object f11388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Looper f11389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11391i = C.TIME_UNSET;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11392j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11395m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11396n;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void c(t2 t2Var);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException;
    }

    public t2(a aVar, b bVar, androidx.media3.common.m0 m0Var, int i11, z3.d dVar, Looper looper) {
        this.f11384b = aVar;
        this.f11383a = bVar;
        this.f11386d = m0Var;
        this.f11389g = looper;
        this.f11385c = dVar;
        this.f11390h = i11;
    }

    public synchronized boolean a(long j11) throws InterruptedException, TimeoutException {
        boolean z11;
        try {
            z3.a.g(this.f11393k);
            z3.a.g(this.f11389g.getThread() != Thread.currentThread());
            long jElapsedRealtime = this.f11385c.elapsedRealtime() + j11;
            while (true) {
                z11 = this.f11395m;
                if (z11 || j11 <= 0) {
                    break;
                }
                this.f11385c.a();
                wait(j11);
                j11 = jElapsedRealtime - this.f11385c.elapsedRealtime();
            }
            if (!z11) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f11394l;
    }

    public boolean b() {
        return this.f11392j;
    }

    public Looper c() {
        return this.f11389g;
    }

    public int d() {
        return this.f11390h;
    }

    @Nullable
    public Object e() {
        return this.f11388f;
    }

    public long f() {
        return this.f11391i;
    }

    public b g() {
        return this.f11383a;
    }

    public androidx.media3.common.m0 h() {
        return this.f11386d;
    }

    public int i() {
        return this.f11387e;
    }

    public synchronized boolean j() {
        return this.f11396n;
    }

    public synchronized void k(boolean z11) {
        this.f11394l = z11 | this.f11394l;
        this.f11395m = true;
        notifyAll();
    }

    public t2 l() {
        z3.a.g(!this.f11393k);
        if (this.f11391i == C.TIME_UNSET) {
            z3.a.a(this.f11392j);
        }
        this.f11393k = true;
        this.f11384b.c(this);
        return this;
    }

    public t2 m(@Nullable Object obj) {
        z3.a.g(!this.f11393k);
        this.f11388f = obj;
        return this;
    }

    public t2 n(int i11) {
        z3.a.g(!this.f11393k);
        this.f11387e = i11;
        return this;
    }
}
