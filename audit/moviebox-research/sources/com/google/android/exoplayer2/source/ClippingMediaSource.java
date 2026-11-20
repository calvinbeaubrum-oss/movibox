package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ClippingMediaSource extends c<Void> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f33732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f33733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f33734n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f33735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f33736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f33737q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<b> f33738r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j3.d f33739s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public a f33740t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public IllegalClippingException f33741u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f33742v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f33743w;

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
    public static final class a extends nh.m {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f33744d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f33745f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f33746g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f33747h;

        public a(j3 j3Var, long j11, long j12) throws IllegalClippingException {
            super(j3Var);
            boolean z11 = false;
            if (j3Var.m() != 1) {
                throw new IllegalClippingException(0);
            }
            j3.d dVarR = j3Var.r(0, new j3.d());
            long jMax = Math.max(0L, j11);
            if (!dVarR.f33388m && jMax != 0 && !dVarR.f33384i) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j12 == Long.MIN_VALUE ? dVarR.f33390o : Math.max(0L, j12);
            long j13 = dVarR.f33390o;
            if (j13 != C.TIME_UNSET) {
                jMax2 = jMax2 > j13 ? j13 : jMax2;
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.f33744d = jMax;
            this.f33745f = jMax2;
            this.f33746g = jMax2 == C.TIME_UNSET ? -9223372036854775807L : jMax2 - jMax;
            if (dVarR.f33385j && (jMax2 == C.TIME_UNSET || (j13 != C.TIME_UNSET && jMax2 == j13))) {
                z11 = true;
            }
            this.f33747h = z11;
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.b k(int i11, j3.b bVar, boolean z11) {
            this.f71944c.k(0, bVar, z11);
            long jQ = bVar.q() - this.f33744d;
            long j11 = this.f33746g;
            return bVar.v(bVar.f33362a, bVar.f33363b, 0, j11 == C.TIME_UNSET ? -9223372036854775807L : j11 - jQ, jQ);
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.d s(int i11, j3.d dVar, long j11) {
            this.f71944c.s(0, dVar, 0L);
            long j12 = dVar.f33393r;
            long j13 = this.f33744d;
            dVar.f33393r = j12 + j13;
            dVar.f33390o = this.f33746g;
            dVar.f33385j = this.f33747h;
            long j14 = dVar.f33389n;
            if (j14 != C.TIME_UNSET) {
                long jMax = Math.max(j14, j13);
                dVar.f33389n = jMax;
                long j15 = this.f33745f;
                if (j15 != C.TIME_UNSET) {
                    jMax = Math.min(jMax, j15);
                }
                dVar.f33389n = jMax - this.f33744d;
            }
            long jF1 = o0.f1(this.f33744d);
            long j16 = dVar.f33381f;
            if (j16 != C.TIME_UNSET) {
                dVar.f33381f = j16 + jF1;
            }
            long j17 = dVar.f33382g;
            if (j17 != C.TIME_UNSET) {
                dVar.f33382g = j17 + jF1;
            }
            return dVar;
        }
    }

    public ClippingMediaSource(i iVar, long j11, long j12, boolean z11, boolean z12, boolean z13) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0);
        this.f33732l = (i) com.google.android.exoplayer2.util.a.e(iVar);
        this.f33733m = j11;
        this.f33734n = j12;
        this.f33735o = z11;
        this.f33736p = z12;
        this.f33737q = z13;
        this.f33738r = new ArrayList<>();
        this.f33739s = new j3.d();
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        super.B(k0Var);
        K(null, this.f33732l);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void D() {
        super.D();
        this.f33741u = null;
        this.f33740t = null;
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void I(Void r11, i iVar, j3 j3Var) {
        if (this.f33741u != null) {
            return;
        }
        M(j3Var);
    }

    public final void M(j3 j3Var) {
        long j11;
        long j12;
        j3Var.r(0, this.f33739s);
        long jH = this.f33739s.h();
        if (this.f33740t == null || this.f33738r.isEmpty() || this.f33736p) {
            long j13 = this.f33733m;
            long j14 = this.f33734n;
            if (this.f33737q) {
                long jF = this.f33739s.f();
                j13 += jF;
                j14 += jF;
            }
            this.f33742v = jH + j13;
            this.f33743w = this.f33734n != Long.MIN_VALUE ? jH + j14 : Long.MIN_VALUE;
            int size = this.f33738r.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f33738r.get(i11).l(this.f33742v, this.f33743w);
            }
            j11 = j13;
            j12 = j14;
        } else {
            long j15 = this.f33742v - jH;
            j12 = this.f33734n != Long.MIN_VALUE ? this.f33743w - jH : Long.MIN_VALUE;
            j11 = j15;
        }
        try {
            a aVar = new a(j3Var, j11, j12);
            this.f33740t = aVar;
            C(aVar);
        } catch (IllegalClippingException e11) {
            this.f33741u = e11;
            for (int i12 = 0; i12 < this.f33738r.size(); i12++) {
                this.f33738r.get(i12).j(this.f33741u);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        return this.f33732l.a();
    }

    @Override // com.google.android.exoplayer2.source.i
    public h e(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        b bVar3 = new b(this.f33732l.e(bVar, bVar2, j11), this.f33735o, this.f33742v, this.f33743w);
        this.f33738r.add(bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(h hVar) {
        com.google.android.exoplayer2.util.a.g(this.f33738r.remove(hVar));
        this.f33732l.k(((b) hVar).f33769a);
        if (!this.f33738r.isEmpty() || this.f33736p) {
            return;
        }
        M(((a) com.google.android.exoplayer2.util.a.e(this.f33740t)).f71944c);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.f33741u;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }
}
