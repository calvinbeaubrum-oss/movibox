package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.decoder.DecoderInputBuffer;
import e4.x3;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements w2, y2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10672b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public z2 f10674d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public x3 f10676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z3.d f10677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public p4.e0 f10679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.y[] f10680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f10681l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10682m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10684o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f10685p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public y2.a f10687r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10671a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t1 f10673c = new t1();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f10683n = Long.MIN_VALUE;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.media3.common.m0 f10686q = androidx.media3.common.m0.f9282a;

    public m(int i11) {
        this.f10672b = i11;
    }

    public void A(boolean z11, boolean z12) throws ExoPlaybackException {
    }

    public void B() {
    }

    public abstract void C(long j11, boolean z11) throws ExoPlaybackException;

    public void D() {
    }

    public final void E() {
        y2.a aVar;
        synchronized (this.f10671a) {
            aVar = this.f10687r;
        }
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void F() {
    }

    public void G() throws ExoPlaybackException {
    }

    public void H() {
    }

    public void I(androidx.media3.common.y[] yVarArr, long j11, long j12, androidx.media3.exoplayer.source.l.b bVar) throws ExoPlaybackException {
    }

    public void J(androidx.media3.common.m0 m0Var) {
    }

    public final int K(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int iC = ((p4.e0) z3.a.e(this.f10679j)).c(t1Var, decoderInputBuffer, i11);
        if (iC == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.f10683n = Long.MIN_VALUE;
                return this.f10684o ? -4 : -3;
            }
            long j11 = decoderInputBuffer.f9782f + this.f10681l;
            decoderInputBuffer.f9782f = j11;
            this.f10683n = Math.max(this.f10683n, j11);
        } else if (iC == -5) {
            androidx.media3.common.y yVar = (androidx.media3.common.y) z3.a.e(t1Var.f11382b);
            if (yVar.f9505q != Long.MAX_VALUE) {
                t1Var.f11382b = yVar.b().o0(yVar.f9505q + this.f10681l).I();
            }
        }
        return iC;
    }

    public final void L(long j11, boolean z11) throws ExoPlaybackException {
        this.f10684o = false;
        this.f10682m = j11;
        this.f10683n = j11;
        C(j11, z11);
    }

    public int M(long j11) {
        return ((p4.e0) z3.a.e(this.f10679j)).skipData(j11 - this.f10681l);
    }

    @Override // androidx.media3.exoplayer.w2
    public /* synthetic */ void c(float f11, float f12) throws ExoPlaybackException {
        v2.b(this, f11, f12);
    }

    @Override // androidx.media3.exoplayer.w2
    public final long d() {
        return this.f10683n;
    }

    @Override // androidx.media3.exoplayer.w2
    public final void disable() {
        z3.a.g(this.f10678i == 1);
        this.f10673c.a();
        this.f10678i = 0;
        this.f10679j = null;
        this.f10680k = null;
        this.f10684o = false;
        z();
    }

    @Override // androidx.media3.exoplayer.y2
    public final void e() {
        synchronized (this.f10671a) {
            this.f10687r = null;
        }
    }

    @Override // androidx.media3.exoplayer.w2
    public /* synthetic */ void f() {
        v2.a(this);
    }

    @Override // androidx.media3.exoplayer.w2
    public final void g(z2 z2Var, androidx.media3.common.y[] yVarArr, p4.e0 e0Var, long j11, boolean z11, boolean z12, long j12, long j13, androidx.media3.exoplayer.source.l.b bVar) throws ExoPlaybackException {
        z3.a.g(this.f10678i == 0);
        this.f10674d = z2Var;
        this.f10678i = 1;
        A(z11, z12);
        m(yVarArr, e0Var, j12, j13, bVar);
        L(j12, z11);
    }

    @Override // androidx.media3.exoplayer.w2
    public final y2 getCapabilities() {
        return this;
    }

    @Override // androidx.media3.exoplayer.w2
    @Nullable
    public y1 getMediaClock() {
        return null;
    }

    @Override // androidx.media3.exoplayer.w2
    public final int getState() {
        return this.f10678i;
    }

    @Override // androidx.media3.exoplayer.w2
    @Nullable
    public final p4.e0 getStream() {
        return this.f10679j;
    }

    @Override // androidx.media3.exoplayer.w2, androidx.media3.exoplayer.y2
    public final int getTrackType() {
        return this.f10672b;
    }

    @Override // androidx.media3.exoplayer.t2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // androidx.media3.exoplayer.w2
    public final boolean hasReadStreamToEnd() {
        return this.f10683n == Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.w2
    public final void i(int i11, x3 x3Var, z3.d dVar) {
        this.f10675f = i11;
        this.f10676g = x3Var;
        this.f10677h = dVar;
        B();
    }

    @Override // androidx.media3.exoplayer.w2
    public final boolean isCurrentStreamFinal() {
        return this.f10684o;
    }

    @Override // androidx.media3.exoplayer.w2
    public final void l(androidx.media3.common.m0 m0Var) {
        if (z3.u0.c(this.f10686q, m0Var)) {
            return;
        }
        this.f10686q = m0Var;
        J(m0Var);
    }

    @Override // androidx.media3.exoplayer.w2
    public final void m(androidx.media3.common.y[] yVarArr, p4.e0 e0Var, long j11, long j12, androidx.media3.exoplayer.source.l.b bVar) throws ExoPlaybackException {
        z3.a.g(!this.f10684o);
        this.f10679j = e0Var;
        if (this.f10683n == Long.MIN_VALUE) {
            this.f10683n = j11;
        }
        this.f10680k = yVarArr;
        this.f10681l = j12;
        I(yVarArr, j11, j12, bVar);
    }

    @Override // androidx.media3.exoplayer.w2
    public final void maybeThrowStreamError() throws IOException {
        ((p4.e0) z3.a.e(this.f10679j)).maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.y2
    public final void n(y2.a aVar) {
        synchronized (this.f10671a) {
            this.f10687r = aVar;
        }
    }

    public final ExoPlaybackException p(Throwable th2, @Nullable androidx.media3.common.y yVar, int i11) {
        return q(th2, yVar, false, i11);
    }

    public final ExoPlaybackException q(Throwable th2, @Nullable androidx.media3.common.y yVar, boolean z11, int i11) {
        int i12;
        if (yVar == null || this.f10685p) {
            i12 = 4;
        } else {
            this.f10685p = true;
            try {
                int i13 = x2.i(a(yVar));
                this.f10685p = false;
                i12 = i13;
            } catch (ExoPlaybackException unused) {
                this.f10685p = false;
                i12 = 4;
            } catch (Throwable th3) {
                this.f10685p = false;
                throw th3;
            }
        }
        return ExoPlaybackException.createForRenderer(th2, getName(), u(), yVar, i12, z11, i11);
    }

    public final z3.d r() {
        return (z3.d) z3.a.e(this.f10677h);
    }

    @Override // androidx.media3.exoplayer.w2
    public final void release() {
        z3.a.g(this.f10678i == 0);
        D();
    }

    @Override // androidx.media3.exoplayer.w2
    public final void reset() {
        z3.a.g(this.f10678i == 0);
        this.f10673c.a();
        F();
    }

    @Override // androidx.media3.exoplayer.w2
    public final void resetPosition(long j11) throws ExoPlaybackException {
        L(j11, false);
    }

    public final z2 s() {
        return (z2) z3.a.e(this.f10674d);
    }

    @Override // androidx.media3.exoplayer.w2
    public final void setCurrentStreamFinal() {
        this.f10684o = true;
    }

    @Override // androidx.media3.exoplayer.w2
    public final void start() throws ExoPlaybackException {
        z3.a.g(this.f10678i == 1);
        this.f10678i = 2;
        G();
    }

    @Override // androidx.media3.exoplayer.w2
    public final void stop() {
        z3.a.g(this.f10678i == 2);
        this.f10678i = 1;
        H();
    }

    @Override // androidx.media3.exoplayer.y2
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public final t1 t() {
        this.f10673c.a();
        return this.f10673c;
    }

    public final int u() {
        return this.f10675f;
    }

    public final long v() {
        return this.f10682m;
    }

    public final x3 w() {
        return (x3) z3.a.e(this.f10676g);
    }

    public final androidx.media3.common.y[] x() {
        return (androidx.media3.common.y[]) z3.a.e(this.f10680k);
    }

    public final boolean y() {
        return hasReadStreamToEnd() ? this.f10684o : ((p4.e0) z3.a.e(this.f10679j)).isReady();
    }

    public abstract void z();
}
