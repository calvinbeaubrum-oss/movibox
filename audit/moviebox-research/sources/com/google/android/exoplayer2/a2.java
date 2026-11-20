package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.h f32686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f32687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nh.d0[] f32688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f32689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b2 f32691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f32692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f32693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y2[] f32694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final fi.b0 f32695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g2 f32696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public a2 f32697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public nh.k0 f32698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public fi.c0 f32699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f32700o;

    public a2(y2[] y2VarArr, long j11, fi.b0 b0Var, com.google.android.exoplayer2.upstream.b bVar, g2 g2Var, b2 b2Var, fi.c0 c0Var) {
        this.f32694i = y2VarArr;
        this.f32700o = j11;
        this.f32695j = b0Var;
        this.f32696k = g2Var;
        com.google.android.exoplayer2.source.i.b bVar2 = b2Var.f32977a;
        this.f32687b = bVar2.f71960a;
        this.f32691f = b2Var;
        this.f32698m = nh.k0.f71939d;
        this.f32699n = c0Var;
        this.f32688c = new nh.d0[y2VarArr.length];
        this.f32693h = new boolean[y2VarArr.length];
        this.f32686a = e(bVar2, g2Var, bVar, b2Var.f32978b, b2Var.f32980d);
    }

    public static com.google.android.exoplayer2.source.h e(com.google.android.exoplayer2.source.i.b bVar, g2 g2Var, com.google.android.exoplayer2.upstream.b bVar2, long j11, long j12) {
        com.google.android.exoplayer2.source.h hVarH = g2Var.h(bVar, bVar2, j11);
        return j12 != C.TIME_UNSET ? new com.google.android.exoplayer2.source.b(hVarH, true, 0L, j12) : hVarH;
    }

    public static void u(g2 g2Var, com.google.android.exoplayer2.source.h hVar) {
        try {
            if (hVar instanceof com.google.android.exoplayer2.source.b) {
                g2Var.z(((com.google.android.exoplayer2.source.b) hVar).f33769a);
            } else {
                g2Var.z(hVar);
            }
        } catch (RuntimeException e11) {
            com.google.android.exoplayer2.util.s.d("MediaPeriodHolder", "Period release failed.", e11);
        }
    }

    public void A() {
        com.google.android.exoplayer2.source.h hVar = this.f32686a;
        if (hVar instanceof com.google.android.exoplayer2.source.b) {
            long j11 = this.f32691f.f32980d;
            if (j11 == C.TIME_UNSET) {
                j11 = Long.MIN_VALUE;
            }
            ((com.google.android.exoplayer2.source.b) hVar).l(0L, j11);
        }
    }

    public long a(fi.c0 c0Var, long j11, boolean z11) {
        return b(c0Var, j11, z11, new boolean[this.f32694i.length]);
    }

    public long b(fi.c0 c0Var, long j11, boolean z11, boolean[] zArr) {
        int i11 = 0;
        while (true) {
            boolean z12 = true;
            if (i11 >= c0Var.f64962a) {
                break;
            }
            boolean[] zArr2 = this.f32693h;
            if (z11 || !c0Var.b(this.f32699n, i11)) {
                z12 = false;
            }
            zArr2[i11] = z12;
            i11++;
        }
        g(this.f32688c);
        f();
        this.f32699n = c0Var;
        h();
        long jE = this.f32686a.e(c0Var.f64964c, this.f32693h, this.f32688c, zArr, j11);
        c(this.f32688c);
        this.f32690e = false;
        int i12 = 0;
        while (true) {
            nh.d0[] d0VarArr = this.f32688c;
            if (i12 >= d0VarArr.length) {
                return jE;
            }
            if (d0VarArr[i12] != null) {
                com.google.android.exoplayer2.util.a.g(c0Var.c(i12));
                if (this.f32694i[i12].getTrackType() != -2) {
                    this.f32690e = true;
                }
            } else {
                com.google.android.exoplayer2.util.a.g(c0Var.f64964c[i12] == null);
            }
            i12++;
        }
    }

    public final void c(nh.d0[] d0VarArr) {
        int i11 = 0;
        while (true) {
            y2[] y2VarArr = this.f32694i;
            if (i11 >= y2VarArr.length) {
                return;
            }
            if (y2VarArr[i11].getTrackType() == -2 && this.f32699n.c(i11)) {
                d0VarArr[i11] = new nh.l();
            }
            i11++;
        }
    }

    public void d(long j11) {
        com.google.android.exoplayer2.util.a.g(r());
        this.f32686a.continueLoading(y(j11));
    }

    public final void f() {
        if (!r()) {
            return;
        }
        int i11 = 0;
        while (true) {
            fi.c0 c0Var = this.f32699n;
            if (i11 >= c0Var.f64962a) {
                return;
            }
            boolean zC = c0Var.c(i11);
            fi.s sVar = this.f32699n.f64964c[i11];
            if (zC && sVar != null) {
                sVar.disable();
            }
            i11++;
        }
    }

    public final void g(nh.d0[] d0VarArr) {
        int i11 = 0;
        while (true) {
            y2[] y2VarArr = this.f32694i;
            if (i11 >= y2VarArr.length) {
                return;
            }
            if (y2VarArr[i11].getTrackType() == -2) {
                d0VarArr[i11] = null;
            }
            i11++;
        }
    }

    public final void h() {
        if (!r()) {
            return;
        }
        int i11 = 0;
        while (true) {
            fi.c0 c0Var = this.f32699n;
            if (i11 >= c0Var.f64962a) {
                return;
            }
            boolean zC = c0Var.c(i11);
            fi.s sVar = this.f32699n.f64964c[i11];
            if (zC && sVar != null) {
                sVar.enable();
            }
            i11++;
        }
    }

    public long i() {
        if (!this.f32689d) {
            return this.f32691f.f32978b;
        }
        long bufferedPositionUs = this.f32690e ? this.f32686a.getBufferedPositionUs() : Long.MIN_VALUE;
        return bufferedPositionUs == Long.MIN_VALUE ? this.f32691f.f32981e : bufferedPositionUs;
    }

    @Nullable
    public a2 j() {
        return this.f32697l;
    }

    public long k() {
        if (this.f32689d) {
            return this.f32686a.getNextLoadPositionUs();
        }
        return 0L;
    }

    public long l() {
        return this.f32700o;
    }

    public long m() {
        return this.f32691f.f32978b + this.f32700o;
    }

    public nh.k0 n() {
        return this.f32698m;
    }

    public fi.c0 o() {
        return this.f32699n;
    }

    public void p(float f11, j3 j3Var) throws ExoPlaybackException {
        this.f32689d = true;
        this.f32698m = this.f32686a.getTrackGroups();
        fi.c0 c0VarV = v(f11, j3Var);
        b2 b2Var = this.f32691f;
        long jMax = b2Var.f32978b;
        long j11 = b2Var.f32981e;
        if (j11 != C.TIME_UNSET && jMax >= j11) {
            jMax = Math.max(0L, j11 - 1);
        }
        long jA = a(c0VarV, jMax, false);
        long j12 = this.f32700o;
        b2 b2Var2 = this.f32691f;
        this.f32700o = j12 + (b2Var2.f32978b - jA);
        this.f32691f = b2Var2.b(jA);
    }

    public boolean q() {
        return this.f32689d && (!this.f32690e || this.f32686a.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public final boolean r() {
        return this.f32697l == null;
    }

    public void s(long j11) {
        com.google.android.exoplayer2.util.a.g(r());
        if (this.f32689d) {
            this.f32686a.reevaluateBuffer(y(j11));
        }
    }

    public void t() {
        f();
        u(this.f32696k, this.f32686a);
    }

    public fi.c0 v(float f11, j3 j3Var) throws ExoPlaybackException {
        fi.c0 c0VarH = this.f32695j.h(this.f32694i, n(), this.f32691f.f32977a, j3Var);
        for (fi.s sVar : c0VarH.f64964c) {
            if (sVar != null) {
                sVar.onPlaybackSpeed(f11);
            }
        }
        return c0VarH;
    }

    public void w(@Nullable a2 a2Var) {
        if (a2Var == this.f32697l) {
            return;
        }
        f();
        this.f32697l = a2Var;
        h();
    }

    public void x(long j11) {
        this.f32700o = j11;
    }

    public long y(long j11) {
        return j11 - l();
    }

    public long z(long j11) {
        return j11 + l();
    }
}
