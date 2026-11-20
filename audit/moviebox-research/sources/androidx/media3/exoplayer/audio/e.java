package androidx.media3.exoplayer.audio;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.f0;
import androidx.media3.common.g0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.g;
import androidx.media3.decoder.i;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.m;
import androidx.media3.exoplayer.n;
import androidx.media3.exoplayer.source.l;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.x2;
import androidx.media3.exoplayer.y1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import f4.z;
import i4.j;
import org.mvel2.ast.ASTNode;
import z3.j0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T extends androidx.media3.decoder.g<DecoderInputBuffer, ? extends i, ? extends DecoderException>> extends m implements y1 {

    @Nullable
    public T A;

    @Nullable
    public DecoderInputBuffer B;

    @Nullable
    public i C;

    @Nullable
    public DrmSession D;

    @Nullable
    public DrmSession E;
    public int F;
    public boolean G;
    public boolean H;
    public long I;
    public boolean J;
    public boolean K;
    public boolean L;
    public long M;
    public final long[] N;
    public int O;
    public boolean P;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final androidx.media3.exoplayer.audio.c.a f9971s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AudioSink f9972t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DecoderInputBuffer f9973u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n f9974v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public y f9975w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9976x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9977y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f9978z;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class b {
        public static void a(AudioSink audioSink, @Nullable Object obj) {
            audioSink.i(f4.h.a(obj));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements AudioSink.b {
        public c() {
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void a(Exception exc) {
            o.d("DecoderAudioRenderer", "Audio sink error", exc);
            e.this.f9971s.n(exc);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void b(long j11) {
            e.this.f9971s.H(j11);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public /* synthetic */ void c() {
            z.c(this);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public /* synthetic */ void d() {
            z.b(this);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void e() {
            e.this.P = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public /* synthetic */ void f() {
            z.a(this);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void k(AudioSink.a aVar) {
            e.this.f9971s.o(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void l(AudioSink.a aVar) {
            e.this.f9971s.p(aVar);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onPositionDiscontinuity() {
            e.this.Z();
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onSkipSilenceEnabledChanged(boolean z11) {
            e.this.f9971s.I(z11);
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.b
        public void onUnderrun(int i11, long j11, long j12) {
            e.this.f9971s.J(i11, j11, j12);
        }
    }

    public e(@Nullable Handler handler, @Nullable androidx.media3.exoplayer.audio.c cVar, AudioSink audioSink) {
        super(1);
        this.f9971s = new androidx.media3.exoplayer.audio.c.a(handler, cVar);
        this.f9972t = audioSink;
        audioSink.j(new c());
        this.f9973u = DecoderInputBuffer.e();
        this.F = 0;
        this.H = true;
        e0(C.TIME_UNSET);
        this.N = new long[10];
    }

    private void T() throws ExoPlaybackException {
        if (this.F != 0) {
            c0();
            X();
            return;
        }
        this.B = null;
        i iVar = this.C;
        if (iVar != null) {
            iVar.release();
            this.C = null;
        }
        androidx.media3.decoder.g gVar = (androidx.media3.decoder.g) z3.a.e(this.A);
        gVar.flush();
        gVar.a(v());
        this.G = false;
    }

    private void Y(t1 t1Var) throws ExoPlaybackException {
        y yVar = (y) z3.a.e(t1Var.f11382b);
        f0(t1Var.f11381a);
        y yVar2 = this.f9975w;
        this.f9975w = yVar;
        this.f9976x = yVar.C;
        this.f9977y = yVar.D;
        T t11 = this.A;
        if (t11 == null) {
            X();
            this.f9971s.u(this.f9975w, null);
            return;
        }
        androidx.media3.exoplayer.o oVar = this.E != this.D ? new androidx.media3.exoplayer.o(t11.getName(), yVar2, yVar, 0, 128) : P(t11.getName(), yVar2, yVar);
        if (oVar.f10792d == 0) {
            if (this.G) {
                this.F = 1;
            } else {
                c0();
                X();
                this.H = true;
            }
        }
        this.f9971s.u(this.f9975w, oVar);
    }

    private void c0() {
        this.B = null;
        this.C = null;
        this.F = 0;
        this.G = false;
        T t11 = this.A;
        if (t11 != null) {
            this.f9974v.f10773b++;
            t11.release();
            this.f9971s.r(this.A.getName());
            this.A = null;
        }
        d0(null);
    }

    @Override // androidx.media3.exoplayer.m
    public void A(boolean z11, boolean z12) throws ExoPlaybackException {
        n nVar = new n();
        this.f9974v = nVar;
        this.f9971s.t(nVar);
        if (s().f11787b) {
            this.f9972t.e();
        } else {
            this.f9972t.disableTunneling();
        }
        this.f9972t.l(w());
        this.f9972t.d(r());
    }

    @Override // androidx.media3.exoplayer.m
    public void C(long j11, boolean z11) throws ExoPlaybackException {
        this.f9972t.flush();
        this.I = j11;
        this.P = false;
        this.J = true;
        this.K = false;
        this.L = false;
        if (this.A != null) {
            T();
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void G() {
        this.f9972t.play();
    }

    @Override // androidx.media3.exoplayer.m
    public void H() {
        i0();
        this.f9972t.pause();
    }

    @Override // androidx.media3.exoplayer.m
    public void I(y[] yVarArr, long j11, long j12, l.b bVar) throws ExoPlaybackException {
        super.I(yVarArr, j11, j12, bVar);
        this.f9978z = false;
        if (this.M == C.TIME_UNSET) {
            e0(j12);
            return;
        }
        int i11 = this.O;
        if (i11 == this.N.length) {
            o.h("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + this.N[this.O - 1]);
        } else {
            this.O = i11 + 1;
        }
        this.N[this.O - 1] = j12;
    }

    public androidx.media3.exoplayer.o P(String str, y yVar, y yVar2) {
        return new androidx.media3.exoplayer.o(str, yVar, yVar2, 0, 1);
    }

    public abstract T Q(y yVar, @Nullable androidx.media3.decoder.b bVar) throws DecoderException;

    public final boolean R() throws ExoPlaybackException, DecoderException, AudioSink.WriteException, AudioSink.InitializationException, AudioSink.ConfigurationException {
        if (this.C == null) {
            i iVar = (i) this.A.dequeueOutputBuffer();
            this.C = iVar;
            if (iVar == null) {
                return false;
            }
            int i11 = iVar.skippedOutputBufferCount;
            if (i11 > 0) {
                this.f9974v.f10777f += i11;
                this.f9972t.handleDiscontinuity();
            }
            if (this.C.isFirstSample()) {
                b0();
            }
        }
        if (this.C.isEndOfStream()) {
            if (this.F == 2) {
                c0();
                X();
                this.H = true;
            } else {
                this.C.release();
                this.C = null;
                try {
                    a0();
                } catch (AudioSink.WriteException e11) {
                    throw q(e11, e11.format, e11.isRecoverable, 5002);
                }
            }
            return false;
        }
        if (this.H) {
            this.f9972t.m(V(this.A).b().S(this.f9976x).T(this.f9977y).d0(this.f9975w.f9499k).X(this.f9975w.f9489a).Z(this.f9975w.f9490b).a0(this.f9975w.f9491c).b0(this.f9975w.f9492d).m0(this.f9975w.f9493e).i0(this.f9975w.f9494f).I(), 0, U(this.A));
            this.H = false;
        }
        AudioSink audioSink = this.f9972t;
        i iVar2 = this.C;
        if (!audioSink.c(iVar2.f9815b, iVar2.timeUs, 1)) {
            return false;
        }
        this.f9974v.f10776e++;
        this.C.release();
        this.C = null;
        return true;
    }

    public final boolean S() throws ExoPlaybackException, DecoderException {
        T t11 = this.A;
        if (t11 == null || this.F == 2 || this.K) {
            return false;
        }
        if (this.B == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t11.dequeueInputBuffer();
            this.B = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.F == 1) {
            this.B.setFlags(4);
            this.A.queueInputBuffer(this.B);
            this.B = null;
            this.F = 2;
            return false;
        }
        t1 t1VarT = t();
        int iK = K(t1VarT, this.B, 0);
        if (iK == -5) {
            Y(t1VarT);
            return true;
        }
        if (iK != -4) {
            if (iK == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (this.B.isEndOfStream()) {
            this.K = true;
            this.A.queueInputBuffer(this.B);
            this.B = null;
            return false;
        }
        if (!this.f9978z) {
            this.f9978z = true;
            this.B.addFlag(ASTNode.NOJIT);
        }
        if (this.B.f9782f < v()) {
            this.B.addFlag(Integer.MIN_VALUE);
        }
        this.B.c();
        DecoderInputBuffer decoderInputBuffer2 = this.B;
        decoderInputBuffer2.f9778a = this.f9975w;
        this.A.queueInputBuffer(decoderInputBuffer2);
        this.G = true;
        this.f9974v.f10774c++;
        this.B = null;
        return true;
    }

    @Nullable
    public int[] U(T t11) {
        return null;
    }

    public abstract y V(T t11);

    public final int W(y yVar) {
        return this.f9972t.p(yVar);
    }

    public final void X() throws ExoPlaybackException {
        androidx.media3.decoder.b bVarC;
        if (this.A != null) {
            return;
        }
        d0(this.E);
        DrmSession drmSession = this.D;
        if (drmSession != null) {
            bVarC = drmSession.c();
            if (bVarC == null && this.D.getError() == null) {
                return;
            }
        } else {
            bVarC = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            j0.a("createAudioDecoder");
            T t11 = (T) Q(this.f9975w, bVarC);
            this.A = t11;
            t11.a(v());
            j0.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f9971s.q(this.A.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.f9974v.f10772a++;
        } catch (DecoderException e11) {
            o.d("DecoderAudioRenderer", "Audio codec error", e11);
            this.f9971s.m(e11);
            throw p(e11, this.f9975w, 4001);
        } catch (OutOfMemoryError e12) {
            throw p(e12, this.f9975w, 4001);
        }
    }

    @CallSuper
    public void Z() {
        this.J = true;
    }

    @Override // androidx.media3.exoplayer.y2
    public final int a(y yVar) {
        if (!f0.o(yVar.f9501m)) {
            return x2.a(0);
        }
        int iH0 = h0(yVar);
        if (iH0 <= 2) {
            return x2.a(iH0);
        }
        return x2.b(iH0, 8, u0.f81838a >= 21 ? 32 : 0);
    }

    public final void a0() throws AudioSink.WriteException {
        this.L = true;
        this.f9972t.playToEndOfStream();
    }

    @Override // androidx.media3.exoplayer.y1
    public void b(g0 g0Var) {
        this.f9972t.b(g0Var);
    }

    public final void b0() {
        this.f9972t.handleDiscontinuity();
        if (this.O != 0) {
            e0(this.N[0]);
            int i11 = this.O - 1;
            this.O = i11;
            long[] jArr = this.N;
            System.arraycopy(jArr, 1, jArr, 0, i11);
        }
    }

    public final void d0(@Nullable DrmSession drmSession) {
        j.a(this.D, drmSession);
        this.D = drmSession;
    }

    public final void e0(long j11) {
        this.M = j11;
        if (j11 != C.TIME_UNSET) {
            this.f9972t.o(j11);
        }
    }

    public final void f0(@Nullable DrmSession drmSession) {
        j.a(this.E, drmSession);
        this.E = drmSession;
    }

    public final boolean g0(y yVar) {
        return this.f9972t.a(yVar);
    }

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.w2
    @Nullable
    public y1 getMediaClock() {
        return this;
    }

    @Override // androidx.media3.exoplayer.y1
    public g0 getPlaybackParameters() {
        return this.f9972t.getPlaybackParameters();
    }

    @Override // androidx.media3.exoplayer.y1
    public long getPositionUs() {
        if (getState() == 2) {
            i0();
        }
        return this.I;
    }

    @Override // androidx.media3.exoplayer.y1
    public boolean h() {
        boolean z11 = this.P;
        this.P = false;
        return z11;
    }

    public abstract int h0(y yVar);

    @Override // androidx.media3.exoplayer.m, androidx.media3.exoplayer.t2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
        if (i11 == 2) {
            this.f9972t.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i11 == 3) {
            this.f9972t.g((androidx.media3.common.d) obj);
            return;
        }
        if (i11 == 6) {
            this.f9972t.q((androidx.media3.common.g) obj);
            return;
        }
        if (i11 == 12) {
            if (u0.f81838a >= 23) {
                b.a(this.f9972t, obj);
            }
        } else if (i11 == 9) {
            this.f9972t.f(((Boolean) obj).booleanValue());
        } else if (i11 != 10) {
            super.handleMessage(i11, obj);
        } else {
            this.f9972t.setAudioSessionId(((Integer) obj).intValue());
        }
    }

    public final void i0() {
        long currentPositionUs = this.f9972t.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.J) {
                currentPositionUs = Math.max(this.I, currentPositionUs);
            }
            this.I = currentPositionUs;
            this.J = false;
        }
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isEnded() {
        return this.L && this.f9972t.isEnded();
    }

    @Override // androidx.media3.exoplayer.w2
    public boolean isReady() {
        return this.f9972t.hasPendingData() || (this.f9975w != null && (y() || this.C != null));
    }

    @Override // androidx.media3.exoplayer.w2
    public void render(long j11, long j12) throws ExoPlaybackException {
        if (this.L) {
            try {
                this.f9972t.playToEndOfStream();
                return;
            } catch (AudioSink.WriteException e11) {
                throw q(e11, e11.format, e11.isRecoverable, 5002);
            }
        }
        if (this.f9975w == null) {
            t1 t1VarT = t();
            this.f9973u.clear();
            int iK = K(t1VarT, this.f9973u, 2);
            if (iK != -5) {
                if (iK == -4) {
                    z3.a.g(this.f9973u.isEndOfStream());
                    this.K = true;
                    try {
                        a0();
                        return;
                    } catch (AudioSink.WriteException e12) {
                        throw p(e12, null, 5002);
                    }
                }
                return;
            }
            Y(t1VarT);
        }
        X();
        if (this.A != null) {
            try {
                j0.a("drainAndFeed");
                while (R()) {
                }
                while (S()) {
                }
                j0.c();
                this.f9974v.c();
            } catch (DecoderException e13) {
                o.d("DecoderAudioRenderer", "Audio codec error", e13);
                this.f9971s.m(e13);
                throw p(e13, this.f9975w, 4003);
            } catch (AudioSink.ConfigurationException e14) {
                throw p(e14, e14.format, 5001);
            } catch (AudioSink.InitializationException e15) {
                throw q(e15, e15.format, e15.isRecoverable, 5001);
            } catch (AudioSink.WriteException e16) {
                throw q(e16, e16.format, e16.isRecoverable, 5002);
            }
        }
    }

    @Override // androidx.media3.exoplayer.m
    public void z() {
        this.f9975w = null;
        this.H = true;
        e0(C.TIME_UNSET);
        this.P = false;
        try {
            f0(null);
            c0();
            this.f9972t.reset();
        } finally {
            this.f9971s.s(this.f9974v);
        }
    }
}
