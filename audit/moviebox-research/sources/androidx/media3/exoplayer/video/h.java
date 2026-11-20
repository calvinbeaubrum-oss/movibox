package androidx.media3.exoplayer.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.t0;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.t1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import z3.h0;
import z3.j0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends androidx.media3.exoplayer.m {

    @Nullable
    public DecoderInputBuffer A;

    @Nullable
    public VideoDecoderOutputBuffer B;
    public int C;

    @Nullable
    public Object D;

    @Nullable
    public Surface E;

    @Nullable
    public n F;

    @Nullable
    public o G;

    @Nullable
    public DrmSession H;

    @Nullable
    public DrmSession I;
    public int J;
    public boolean K;
    public int L;
    public long M;
    public long N;
    public boolean O;
    public boolean P;
    public boolean Q;

    @Nullable
    public t0 R;
    public long S;
    public int T;
    public int U;
    public int V;
    public long W;
    public long X;
    public androidx.media3.exoplayer.n Y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f11612s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f11613t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f0.a f11614u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h0<androidx.media3.common.y> f11615v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DecoderInputBuffer f11616w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.y f11617x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.y f11618y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public androidx.media3.decoder.g<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> f11619z;

    public h(long j11, @Nullable Handler handler, @Nullable f0 f0Var, int i11) {
        super(2);
        this.f11612s = j11;
        this.f11613t = i11;
        this.N = C.TIME_UNSET;
        this.f11615v = new h0<>();
        this.f11616w = DecoderInputBuffer.e();
        this.f11614u = new f0.a(handler, f0Var);
        this.J = 0;
        this.C = -1;
        this.L = 0;
        this.Y = new androidx.media3.exoplayer.n();
    }

    private boolean P(long j11, long j12) throws ExoPlaybackException, DecoderException {
        if (this.B == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) ((androidx.media3.decoder.g) z3.a.e(this.f11619z)).dequeueOutputBuffer();
            this.B = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            androidx.media3.exoplayer.n nVar = this.Y;
            int i11 = nVar.f10777f;
            int i12 = videoDecoderOutputBuffer.skippedOutputBufferCount;
            nVar.f10777f = i11 + i12;
            this.V -= i12;
        }
        if (!this.B.isEndOfStream()) {
            boolean zK0 = k0(j11, j12);
            if (zK0) {
                i0(((VideoDecoderOutputBuffer) z3.a.e(this.B)).timeUs);
                this.B = null;
            }
            return zK0;
        }
        if (this.J == 2) {
            l0();
            Y();
        } else {
            this.B.release();
            this.B = null;
            this.Q = true;
        }
        return false;
    }

    private boolean R() throws ExoPlaybackException, DecoderException {
        androidx.media3.decoder.g<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> gVar = this.f11619z;
        if (gVar == null || this.J == 2 || this.P) {
            return false;
        }
        if (this.A == null) {
            DecoderInputBuffer decoderInputBufferDequeueInputBuffer = gVar.dequeueInputBuffer();
            this.A = decoderInputBufferDequeueInputBuffer;
            if (decoderInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) z3.a.e(this.A);
        if (this.J == 1) {
            decoderInputBuffer.setFlags(4);
            ((androidx.media3.decoder.g) z3.a.e(this.f11619z)).queueInputBuffer(decoderInputBuffer);
            this.A = null;
            this.J = 2;
            return false;
        }
        t1 t1VarT = t();
        int iK = K(t1VarT, decoderInputBuffer, 0);
        if (iK == -5) {
            e0(t1VarT);
            return true;
        }
        if (iK != -4) {
            if (iK == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (decoderInputBuffer.isEndOfStream()) {
            this.P = true;
            ((androidx.media3.decoder.g) z3.a.e(this.f11619z)).queueInputBuffer(decoderInputBuffer);
            this.A = null;
            return false;
        }
        if (this.O) {
            this.f11615v.a(decoderInputBuffer.f9782f, (androidx.media3.common.y) z3.a.e(this.f11617x));
            this.O = false;
        }
        if (decoderInputBuffer.f9782f < v()) {
            decoderInputBuffer.addFlag(Integer.MIN_VALUE);
        }
        decoderInputBuffer.c();
        decoderInputBuffer.f9778a = this.f11617x;
        j0(decoderInputBuffer);
        ((androidx.media3.decoder.g) z3.a.e(this.f11619z)).queueInputBuffer(decoderInputBuffer);
        this.V++;
        this.K = true;
        this.Y.f10774c++;
        this.A = null;
        return true;
    }

    public static boolean U(long j11) {
        return j11 < -30000;
    }

    public static boolean V(long j11) {
        return j11 < -500000;
    }

    private void W(int i11) {
        this.L = Math.min(this.L, i11);
    }

    private void Y() throws ExoPlaybackException {
        androidx.media3.decoder.b bVarC;
        if (this.f11619z != null) {
            return;
        }
        o0(this.I);
        DrmSession drmSession = this.H;
        if (drmSession != null) {
            bVarC = drmSession.c();
            if (bVarC == null && this.H.getError() == null) {
                return;
            }
        } else {
            bVarC = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            androidx.media3.decoder.g<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> gVarO = O((androidx.media3.common.y) z3.a.e(this.f11617x), bVarC);
            this.f11619z = gVarO;
            gVarO.a(v());
            p0(this.C);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f11614u.k(((androidx.media3.decoder.g) z3.a.e(this.f11619z)).getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.Y.f10772a++;
        } catch (DecoderException e11) {
            z3.o.d("DecoderVideoRenderer", "Video codec error", e11);
            this.f11614u.C(e11);
            throw p(e11, this.f11617x, 4001);
        } catch (OutOfMemoryError e12) {
            throw p(e12, this.f11617x, 4001);
        }
    }

    private void Z() {
        if (this.T > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f11614u.n(this.T, jElapsedRealtime - this.S);
            this.T = 0;
            this.S = jElapsedRealtime;
        }
    }

    private void a0() {
        if (this.L != 3) {
            this.L = 3;
            Object obj = this.D;
            if (obj != null) {
                this.f11614u.A(obj);
            }
        }
    }

    private void c0() {
        Object obj;
        if (this.L != 3 || (obj = this.D) == null) {
            return;
        }
        this.f11614u.A(obj);
    }

    private void d0() {
        t0 t0Var = this.R;
        if (t0Var != null) {
            this.f11614u.D(t0Var);
        }
    }

    private void o0(@Nullable DrmSession drmSession) {
        i4.j.a(this.H, drmSession);
        this.H = drmSession;
    }

    private void s0(@Nullable DrmSession drmSession) {
        i4.j.a(this.I, drmSession);
        this.I = drmSession;
    }

    @Override // androidx.media3.exoplayer.m
    public void A(boolean z11, boolean z12) throws ExoPlaybackException {
        androidx.media3.exoplayer.n nVar = new androidx.media3.exoplayer.n();
        this.Y = nVar;
        this.f11614u.o(nVar);
        this.L = z12 ? 1 : 0;
    }

    @Override // androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) throws ExoPlaybackException {
        this.P = false;
        this.Q = false;
        W(1);
        this.M = C.TIME_UNSET;
        this.U = 0;
        if (this.f11619z != null) {
            S();
        }
        if (z11) {
            q0();
        } else {
            this.N = C.TIME_UNSET;
        }
        this.f11615v.c();
    }

    @Override // androidx.media3.exoplayer.m
    public void G() {
        this.T = 0;
        this.S = SystemClock.elapsedRealtime();
        this.W = u0.S0(SystemClock.elapsedRealtime());
    }

    @Override // androidx.media3.exoplayer.m
    public void H() {
        this.N = C.TIME_UNSET;
        Z();
    }

    @Override // androidx.media3.exoplayer.m
    public void I(androidx.media3.common.y[] yVarArr, long j11, long j12, androidx.media3.exoplayer.source.l.b bVar) throws ExoPlaybackException {
        this.X = j12;
        super.I(yVarArr, j11, j12, bVar);
    }

    public androidx.media3.exoplayer.o N(String str, androidx.media3.common.y yVar, androidx.media3.common.y yVar2) {
        return new androidx.media3.exoplayer.o(str, yVar, yVar2, 0, 1);
    }

    public abstract androidx.media3.decoder.g<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> O(androidx.media3.common.y yVar, @Nullable androidx.media3.decoder.b bVar) throws DecoderException;

    public void Q(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        y0(0, 1);
        videoDecoderOutputBuffer.release();
    }

    @CallSuper
    public void S() throws ExoPlaybackException {
        this.V = 0;
        if (this.J != 0) {
            l0();
            Y();
            return;
        }
        this.A = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.B;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.B = null;
        }
        androidx.media3.decoder.g gVar = (androidx.media3.decoder.g) z3.a.e(this.f11619z);
        gVar.flush();
        gVar.a(v());
        this.K = false;
    }

    public final boolean T() {
        return this.C != -1;
    }

    public boolean X(long j11) throws ExoPlaybackException {
        int iM = M(j11);
        if (iM == 0) {
            return false;
        }
        this.Y.f10781j++;
        y0(iM, this.V);
        S();
        return true;
    }

    public final void b0(int i11, int i12) {
        t0 t0Var = this.R;
        if (t0Var != null && t0Var.f9449a == i11 && t0Var.f9450b == i12) {
            return;
        }
        t0 t0Var2 = new t0(i11, i12);
        this.R = t0Var2;
        this.f11614u.D(t0Var2);
    }

    @CallSuper
    public void e0(t1 t1Var) throws ExoPlaybackException {
        this.O = true;
        androidx.media3.common.y yVar = (androidx.media3.common.y) z3.a.e(t1Var.f11382b);
        s0(t1Var.f11381a);
        androidx.media3.common.y yVar2 = this.f11617x;
        this.f11617x = yVar;
        androidx.media3.decoder.g<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> gVar = this.f11619z;
        if (gVar == null) {
            Y();
            this.f11614u.p((androidx.media3.common.y) z3.a.e(this.f11617x), null);
            return;
        }
        androidx.media3.exoplayer.o oVar = this.I != this.H ? new androidx.media3.exoplayer.o(gVar.getName(), (androidx.media3.common.y) z3.a.e(yVar2), yVar, 0, 128) : N(gVar.getName(), (androidx.media3.common.y) z3.a.e(yVar2), yVar);
        if (oVar.f10792d == 0) {
            if (this.K) {
                this.J = 1;
            } else {
                l0();
                Y();
            }
        }
        this.f11614u.p((androidx.media3.common.y) z3.a.e(this.f11617x), oVar);
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.w2
    public void f() {
        if (this.L == 0) {
            this.L = 1;
        }
    }

    public final void f0() {
        d0();
        W(1);
        if (getState() == 2) {
            q0();
        }
    }

    public final void g0() {
        this.R = null;
        W(1);
    }

    public final void h0() {
        d0();
        c0();
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.t2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 1) {
            r0(obj);
        } else if (i11 == 7) {
            this.G = (o) obj;
        } else {
            super.handleMessage(i11, obj);
        }
    }

    @CallSuper
    public void i0(long j11) {
        this.V--;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return this.Q;
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isReady() {
        if (this.f11617x != null && ((y() || this.B != null) && (this.L == 3 || !T()))) {
            this.N = C.TIME_UNSET;
            return true;
        }
        if (this.N == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.N) {
            return true;
        }
        this.N = C.TIME_UNSET;
        return false;
    }

    public void j0(DecoderInputBuffer decoderInputBuffer) {
    }

    public final boolean k0(long j11, long j12) throws ExoPlaybackException, DecoderException {
        if (this.M == C.TIME_UNSET) {
            this.M = j11;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) z3.a.e(this.B);
        long j13 = videoDecoderOutputBuffer.timeUs;
        long j14 = j13 - j11;
        if (!T()) {
            if (!U(j14)) {
                return false;
            }
            x0(videoDecoderOutputBuffer);
            return true;
        }
        androidx.media3.common.y yVarJ = this.f11615v.j(j13);
        if (yVarJ != null) {
            this.f11618y = yVarJ;
        } else if (this.f11618y == null) {
            this.f11618y = this.f11615v.i();
        }
        long j15 = j13 - this.X;
        if (v0(j14)) {
            m0(videoDecoderOutputBuffer, j15, (androidx.media3.common.y) z3.a.e(this.f11618y));
            return true;
        }
        if (getState() != 2 || j11 == this.M || (t0(j14, j12) && X(j11))) {
            return false;
        }
        if (u0(j14, j12)) {
            Q(videoDecoderOutputBuffer);
            return true;
        }
        if (j14 < 30000) {
            m0(videoDecoderOutputBuffer, j15, (androidx.media3.common.y) z3.a.e(this.f11618y));
            return true;
        }
        return false;
    }

    @CallSuper
    public void l0() {
        this.A = null;
        this.B = null;
        this.J = 0;
        this.K = false;
        this.V = 0;
        androidx.media3.decoder.g<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> gVar = this.f11619z;
        if (gVar != null) {
            this.Y.f10773b++;
            gVar.release();
            this.f11614u.l(this.f11619z.getName());
            this.f11619z = null;
        }
        o0(null);
    }

    public void m0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j11, androidx.media3.common.y yVar) throws DecoderException {
        o oVar = this.G;
        if (oVar != null) {
            oVar.e(j11, r().nanoTime(), yVar, null);
        }
        this.W = u0.S0(SystemClock.elapsedRealtime());
        int i11 = videoDecoderOutputBuffer.mode;
        boolean z11 = i11 == 1 && this.E != null;
        boolean z12 = i11 == 0 && this.F != null;
        if (!z12 && !z11) {
            Q(videoDecoderOutputBuffer);
            return;
        }
        b0(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
        if (z12) {
            ((n) z3.a.e(this.F)).setOutputBuffer(videoDecoderOutputBuffer);
        } else {
            n0(videoDecoderOutputBuffer, (Surface) z3.a.e(this.E));
        }
        this.U = 0;
        this.Y.f10776e++;
        a0();
    }

    public abstract void n0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws DecoderException;

    public abstract void p0(int i11);

    public final void q0() {
        this.N = this.f11612s > 0 ? SystemClock.elapsedRealtime() + this.f11612s : C.TIME_UNSET;
    }

    public final void r0(@Nullable Object obj) {
        if (obj instanceof Surface) {
            this.E = (Surface) obj;
            this.F = null;
            this.C = 1;
        } else if (obj instanceof n) {
            this.E = null;
            this.F = (n) obj;
            this.C = 0;
        } else {
            this.E = null;
            this.F = null;
            this.C = -1;
            obj = null;
        }
        if (this.D == obj) {
            if (obj != null) {
                h0();
                return;
            }
            return;
        }
        this.D = obj;
        if (obj == null) {
            g0();
            return;
        }
        if (this.f11619z != null) {
            p0(this.C);
        }
        f0();
    }

    @Override // androidx.media3.exoplayer.w2
    public void render(long j11, long j12) throws ExoPlaybackException {
        if (this.Q) {
            return;
        }
        if (this.f11617x == null) {
            t1 t1VarT = t();
            this.f11616w.clear();
            int iK = K(t1VarT, this.f11616w, 2);
            if (iK != -5) {
                if (iK == -4) {
                    z3.a.g(this.f11616w.isEndOfStream());
                    this.P = true;
                    this.Q = true;
                    return;
                }
                return;
            }
            e0(t1VarT);
        }
        Y();
        if (this.f11619z != null) {
            try {
                j0.a("drainAndFeed");
                while (P(j11, j12)) {
                }
                while (R()) {
                }
                j0.c();
                this.Y.c();
            } catch (DecoderException e11) {
                z3.o.d("DecoderVideoRenderer", "Video codec error", e11);
                this.f11614u.C(e11);
                throw p(e11, this.f11617x, 4003);
            }
        }
    }

    public boolean t0(long j11, long j12) {
        return V(j11);
    }

    public boolean u0(long j11, long j12) {
        return U(j11);
    }

    public final boolean v0(long j11) {
        boolean z11 = getState() == 2;
        int i11 = this.L;
        if (i11 == 0) {
            return z11;
        }
        if (i11 == 1) {
            return true;
        }
        if (i11 == 3) {
            return z11 && w0(j11, u0.S0(SystemClock.elapsedRealtime()) - this.W);
        }
        throw new IllegalStateException();
    }

    public boolean w0(long j11, long j12) {
        return U(j11) && j12 > 100000;
    }

    public void x0(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.Y.f10777f++;
        videoDecoderOutputBuffer.release();
    }

    public void y0(int i11, int i12) {
        androidx.media3.exoplayer.n nVar = this.Y;
        nVar.f10779h += i11;
        int i13 = i11 + i12;
        nVar.f10778g += i13;
        this.T += i13;
        int i14 = this.U + i13;
        this.U = i14;
        nVar.f10780i = Math.max(i14, nVar.f10780i);
        int i15 = this.f11613t;
        if (i15 <= 0 || this.T < i15) {
            return;
        }
        Z();
    }

    @Override // androidx.media3.exoplayer.m
    public void z() {
        this.f11617x = null;
        this.R = null;
        W(0);
        try {
            s0(null);
            l0();
        } finally {
            this.f11614u.m(this.Y);
        }
    }
}
