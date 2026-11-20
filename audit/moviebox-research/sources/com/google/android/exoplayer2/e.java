package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e implements w2, y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33187a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public z2 f33189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f33190d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public qg.u1 f33191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public nh.d0 f33193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public m1[] f33194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f33195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f33196k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f33198m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f33199n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f33188b = new n1();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f33197l = Long.MIN_VALUE;

    public e(int i11) {
        this.f33187a = i11;
    }

    @Override // com.google.android.exoplayer2.w2
    public /* synthetic */ void c(float f11, float f12) throws ExoPlaybackException {
        v2.a(this, f11, f12);
    }

    @Override // com.google.android.exoplayer2.w2
    public final long d() {
        return this.f33197l;
    }

    @Override // com.google.android.exoplayer2.w2
    public final void disable() {
        com.google.android.exoplayer2.util.a.g(this.f33192g == 1);
        this.f33188b.a();
        this.f33192g = 0;
        this.f33193h = null;
        this.f33194i = null;
        this.f33198m = false;
        p();
    }

    public final ExoPlaybackException e(Throwable th2, @Nullable m1 m1Var, int i11) {
        return i(th2, m1Var, false, i11);
    }

    @Override // com.google.android.exoplayer2.w2
    public final void f(m1[] m1VarArr, nh.d0 d0Var, long j11, long j12) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(!this.f33198m);
        this.f33193h = d0Var;
        if (this.f33197l == Long.MIN_VALUE) {
            this.f33197l = j11;
        }
        this.f33194i = m1VarArr;
        this.f33195j = j12;
        v(m1VarArr, j11, j12);
    }

    @Override // com.google.android.exoplayer2.w2
    public final void g(z2 z2Var, m1[] m1VarArr, nh.d0 d0Var, long j11, boolean z11, boolean z12, long j12, long j13) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(this.f33192g == 0);
        this.f33189c = z2Var;
        this.f33192g = 1;
        q(z11, z12);
        f(m1VarArr, d0Var, j12, j13);
        x(j11, z11);
    }

    @Override // com.google.android.exoplayer2.w2
    public final y2 getCapabilities() {
        return this;
    }

    @Override // com.google.android.exoplayer2.w2
    @Nullable
    public com.google.android.exoplayer2.util.u getMediaClock() {
        return null;
    }

    @Override // com.google.android.exoplayer2.w2
    public final int getState() {
        return this.f33192g;
    }

    @Override // com.google.android.exoplayer2.w2
    @Nullable
    public final nh.d0 getStream() {
        return this.f33193h;
    }

    @Override // com.google.android.exoplayer2.w2, com.google.android.exoplayer2.y2
    public final int getTrackType() {
        return this.f33187a;
    }

    @Override // com.google.android.exoplayer2.w2
    public final void h(int i11, qg.u1 u1Var) {
        this.f33190d = i11;
        this.f33191f = u1Var;
    }

    @Override // com.google.android.exoplayer2.r2.b
    public void handleMessage(int i11, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.w2
    public final boolean hasReadStreamToEnd() {
        return this.f33197l == Long.MIN_VALUE;
    }

    public final ExoPlaybackException i(Throwable th2, @Nullable m1 m1Var, boolean z11, int i11) {
        int i12;
        if (m1Var == null || this.f33199n) {
            i12 = 4;
        } else {
            this.f33199n = true;
            try {
                int iF = x2.f(a(m1Var));
                this.f33199n = false;
                i12 = iF;
            } catch (ExoPlaybackException unused) {
                this.f33199n = false;
                i12 = 4;
            } catch (Throwable th3) {
                this.f33199n = false;
                throw th3;
            }
        }
        return ExoPlaybackException.createForRenderer(th2, getName(), l(), m1Var, i12, z11, i11);
    }

    @Override // com.google.android.exoplayer2.w2
    public final boolean isCurrentStreamFinal() {
        return this.f33198m;
    }

    public final z2 j() {
        return (z2) com.google.android.exoplayer2.util.a.e(this.f33189c);
    }

    public final n1 k() {
        this.f33188b.a();
        return this.f33188b;
    }

    public final int l() {
        return this.f33190d;
    }

    public final qg.u1 m() {
        return (qg.u1) com.google.android.exoplayer2.util.a.e(this.f33191f);
    }

    @Override // com.google.android.exoplayer2.w2
    public final void maybeThrowStreamError() throws IOException {
        ((nh.d0) com.google.android.exoplayer2.util.a.e(this.f33193h)).maybeThrowError();
    }

    public final m1[] n() {
        return (m1[]) com.google.android.exoplayer2.util.a.e(this.f33194i);
    }

    public final boolean o() {
        return hasReadStreamToEnd() ? this.f33198m : ((nh.d0) com.google.android.exoplayer2.util.a.e(this.f33193h)).isReady();
    }

    public abstract void p();

    public void q(boolean z11, boolean z12) throws ExoPlaybackException {
    }

    public abstract void r(long j11, boolean z11) throws ExoPlaybackException;

    @Override // com.google.android.exoplayer2.w2
    public final void reset() {
        com.google.android.exoplayer2.util.a.g(this.f33192g == 0);
        this.f33188b.a();
        s();
    }

    @Override // com.google.android.exoplayer2.w2
    public final void resetPosition(long j11) throws ExoPlaybackException {
        x(j11, false);
    }

    public void s() {
    }

    @Override // com.google.android.exoplayer2.w2
    public final void setCurrentStreamFinal() {
        this.f33198m = true;
    }

    @Override // com.google.android.exoplayer2.w2
    public final void start() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(this.f33192g == 1);
        this.f33192g = 2;
        t();
    }

    @Override // com.google.android.exoplayer2.w2
    public final void stop() {
        com.google.android.exoplayer2.util.a.g(this.f33192g == 2);
        this.f33192g = 1;
        u();
    }

    @Override // com.google.android.exoplayer2.y2
    public int supportsMixedMimeTypeAdaptation() throws ExoPlaybackException {
        return 0;
    }

    public void t() throws ExoPlaybackException {
    }

    public void u() {
    }

    public abstract void v(m1[] m1VarArr, long j11, long j12) throws ExoPlaybackException;

    public final int w(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        int iB = ((nh.d0) com.google.android.exoplayer2.util.a.e(this.f33193h)).b(n1Var, decoderInputBuffer, i11);
        if (iB == -4) {
            if (decoderInputBuffer.i()) {
                this.f33197l = Long.MIN_VALUE;
                return this.f33198m ? -4 : -3;
            }
            long j11 = decoderInputBuffer.f33032f + this.f33195j;
            decoderInputBuffer.f33032f = j11;
            this.f33197l = Math.max(this.f33197l, j11);
        } else if (iB == -5) {
            m1 m1Var = (m1) com.google.android.exoplayer2.util.a.e(n1Var.f33603b);
            if (m1Var.f33449q != Long.MAX_VALUE) {
                n1Var.f33603b = m1Var.b().i0(m1Var.f33449q + this.f33195j).E();
            }
        }
        return iB;
    }

    public final void x(long j11, boolean z11) throws ExoPlaybackException {
        this.f33198m = false;
        this.f33196k = j11;
        this.f33197l = j11;
        r(j11, z11);
    }

    public int y(long j11) {
        return ((nh.d0) com.google.android.exoplayer2.util.a.e(this.f33193h)).skipData(j11 - this.f33195j);
    }
}
