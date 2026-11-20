package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;
import com.applovin.sdk.AppLovinMediationProvider;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ClippingMediaSource extends x {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f11088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f11089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f11090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f11091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f11092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<b> f11093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final m0.c f11094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public a f11095t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public IllegalClippingException f11096u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f11097v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f11098w;

    /* JADX INFO: compiled from: source.java */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        public IllegalClippingException(int i11) {
            super("Illegal clipping: " + getReasonDescription(i11));
            this.reason = i11;
        }

        private static String getReasonDescription(int i11) {
            if (i11 == 0) {
                return "invalid period count";
            }
            if (i11 != 1) {
                return i11 != 2 ? AppLovinMediationProvider.UNKNOWN : "start exceeds end";
            }
            return "not seekable to start";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a extends p4.m {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f11099g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f11100h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f11101i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f11102j;

        public a(m0 m0Var, long j11, long j12) throws IllegalClippingException {
            super(m0Var);
            boolean z11 = false;
            if (m0Var.i() != 1) {
                throw new IllegalClippingException(0);
            }
            m0.c cVarN = m0Var.n(0, new m0.c());
            long jMax = Math.max(0L, j11);
            if (!cVarN.f9320l && jMax != 0 && !cVarN.f9316h) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j12 == Long.MIN_VALUE ? cVarN.f9322n : Math.max(0L, j12);
            long j13 = cVarN.f9322n;
            if (j13 != C.TIME_UNSET) {
                jMax2 = jMax2 > j13 ? j13 : jMax2;
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.f11099g = jMax;
            this.f11100h = jMax2;
            this.f11101i = jMax2 == C.TIME_UNSET ? -9223372036854775807L : jMax2 - jMax;
            if (cVarN.f9317i && (jMax2 == C.TIME_UNSET || (j13 != C.TIME_UNSET && jMax2 == j13))) {
                z11 = true;
            }
            this.f11102j = z11;
        }

        @Override // p4.m, androidx.media3.common.m0
        public m0.b g(int i11, m0.b bVar, boolean z11) {
            this.f73577f.g(0, bVar, z11);
            long jO = bVar.o() - this.f11099g;
            long j11 = this.f11101i;
            return bVar.t(bVar.f9293a, bVar.f9294b, 0, j11 == C.TIME_UNSET ? -9223372036854775807L : j11 - jO, jO);
        }

        @Override // p4.m, androidx.media3.common.m0
        public m0.c o(int i11, m0.c cVar, long j11) {
            this.f73577f.o(0, cVar, 0L);
            long j12 = cVar.f9325q;
            long j13 = this.f11099g;
            cVar.f9325q = j12 + j13;
            cVar.f9322n = this.f11101i;
            cVar.f9317i = this.f11102j;
            long j14 = cVar.f9321m;
            if (j14 != C.TIME_UNSET) {
                long jMax = Math.max(j14, j13);
                cVar.f9321m = jMax;
                long j15 = this.f11100h;
                if (j15 != C.TIME_UNSET) {
                    jMax = Math.min(jMax, j15);
                }
                cVar.f9321m = jMax - this.f11099g;
            }
            long jB1 = u0.B1(this.f11099g);
            long j16 = cVar.f9313e;
            if (j16 != C.TIME_UNSET) {
                cVar.f9313e = j16 + jB1;
            }
            long j17 = cVar.f9314f;
            if (j17 != C.TIME_UNSET) {
                cVar.f9314f = j17 + jB1;
            }
            return cVar;
        }
    }

    public ClippingMediaSource(l lVar, long j11, long j12, boolean z11, boolean z12, boolean z13) {
        super((l) z3.a.e(lVar));
        z3.a.a(j11 >= 0);
        this.f11088m = j11;
        this.f11089n = j12;
        this.f11090o = z11;
        this.f11091p = z12;
        this.f11092q = z13;
        this.f11093r = new ArrayList<>();
        this.f11094s = new m0.c();
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void B() {
        super.B();
        this.f11096u = null;
        this.f11095t = null;
    }

    @Override // androidx.media3.exoplayer.source.x
    public void P(m0 m0Var) {
        if (this.f11096u != null) {
            return;
        }
        T(m0Var);
    }

    public final void T(m0 m0Var) {
        long j11;
        long j12;
        m0Var.n(0, this.f11094s);
        long jE = this.f11094s.e();
        if (this.f11095t == null || this.f11093r.isEmpty() || this.f11091p) {
            long j13 = this.f11088m;
            long j14 = this.f11089n;
            if (this.f11092q) {
                long jC = this.f11094s.c();
                j13 += jC;
                j14 += jC;
            }
            this.f11097v = jE + j13;
            this.f11098w = this.f11089n != Long.MIN_VALUE ? jE + j14 : Long.MIN_VALUE;
            int size = this.f11093r.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f11093r.get(i11).m(this.f11097v, this.f11098w);
            }
            j11 = j13;
            j12 = j14;
        } else {
            long j15 = this.f11097v - jE;
            j12 = this.f11089n != Long.MIN_VALUE ? this.f11098w - jE : Long.MIN_VALUE;
            j11 = j15;
        }
        try {
            a aVar = new a(m0Var, j11, j12);
            this.f11095t = aVar;
            A(aVar);
        } catch (IllegalClippingException e11) {
            this.f11096u = e11;
            for (int i12 = 0; i12 < this.f11093r.size(); i12++) {
                this.f11093r.get(i12).k(this.f11096u);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.l
    public k h(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        b bVar3 = new b(this.f11378k.h(bVar, bVar2, j11), this.f11090o, this.f11097v, this.f11098w);
        this.f11093r.add(bVar3);
        return bVar3;
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(k kVar) {
        z3.a.g(this.f11093r.remove(kVar));
        this.f11378k.l(((b) kVar).f11124a);
        if (!this.f11093r.isEmpty() || this.f11091p) {
            return;
        }
        T(((a) z3.a.e(this.f11095t)).f73577f);
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.f11096u;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean q(b0 b0Var) {
        return a().f8955f.equals(b0Var.f8955f) && this.f11378k.q(b0Var);
    }
}
