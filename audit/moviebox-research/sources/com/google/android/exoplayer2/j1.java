package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j1 implements Handler.Callback, com.google.android.exoplayer2.source.h.a, fi.b0.a, g2.d, k.a, r2.a {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;

    @Nullable
    public h L;
    public long M;
    public int N;
    public boolean O;

    @Nullable
    public ExoPlaybackException P;
    public long Q;
    public long R = C.TIME_UNSET;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2[] f33305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<w2> f33306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y2[] f33307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fi.b0 f33308d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fi.c0 f33309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s1 f33310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.e f33311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.o f33312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HandlerThread f33313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Looper f33314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j3.d f33315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j3.b f33316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f33317n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f33318o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final k f33319p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<d> f33320q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f33321r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f33322s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d2 f33323t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g2 f33324u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r1 f33325v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f33326w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b3 f33327x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public k2 f33328y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e f33329z;

    /* JADX INFO: compiled from: source.java */
    public class a implements w2.a {
        public a() {
        }

        @Override // com.google.android.exoplayer2.w2.a
        public void a() {
            j1.this.I = true;
        }

        @Override // com.google.android.exoplayer2.w2.a
        public void b() {
            j1.this.f33312i.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<g2.c> f33331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final nh.e0 f33332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f33334d;

        public b(List<g2.c> list, nh.e0 e0Var, int i11, long j11) {
            this.f33331a = list;
            this.f33332b = e0Var;
            this.f33333c = i11;
            this.f33334d = j11;
        }

        public /* synthetic */ b(List list, nh.e0 e0Var, int i11, long j11, a aVar) {
            this(list, e0Var, i11, j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final nh.e0 f33338d;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r2 f33339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f33340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f33341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f33342d;

        public d(r2 r2Var) {
            this.f33339a = r2Var;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f33342d;
            if ((obj == null) != (dVar.f33342d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i11 = this.f33340b - dVar.f33340b;
            return i11 != 0 ? i11 : com.google.android.exoplayer2.util.o0.o(this.f33341c, dVar.f33341c);
        }

        public void b(int i11, long j11, Object obj) {
            this.f33340b = i11;
            this.f33341c = j11;
            this.f33342d = obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f33343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k2 f33344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f33348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f33349g;

        public e(k2 k2Var) {
            this.f33344b = k2Var;
        }

        public void b(int i11) {
            this.f33343a |= i11 > 0;
            this.f33345c += i11;
        }

        public void c(int i11) {
            this.f33343a = true;
            this.f33348f = true;
            this.f33349g = i11;
        }

        public void d(k2 k2Var) {
            this.f33343a |= this.f33344b != k2Var;
            this.f33344b = k2Var;
        }

        public void e(int i11) {
            if (this.f33346d && this.f33347e != 5) {
                com.google.android.exoplayer2.util.a.a(i11 == 5);
                return;
            }
            this.f33343a = true;
            this.f33346d = true;
            this.f33347e = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.i.b f33350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f33352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f33353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f33354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f33355f;

        public g(com.google.android.exoplayer2.source.i.b bVar, long j11, long j12, boolean z11, boolean z12, boolean z13) {
            this.f33350a = bVar;
            this.f33351b = j11;
            this.f33352c = j12;
            this.f33353d = z11;
            this.f33354e = z12;
            this.f33355f = z13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j3 f33356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f33357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f33358c;

        public h(j3 j3Var, int i11, long j11) {
            this.f33356a = j3Var;
            this.f33357b = i11;
            this.f33358c = j11;
        }
    }

    public j1(w2[] w2VarArr, fi.b0 b0Var, fi.c0 c0Var, s1 s1Var, com.google.android.exoplayer2.upstream.e eVar, int i11, boolean z11, qg.a aVar, b3 b3Var, r1 r1Var, long j11, boolean z12, Looper looper, com.google.android.exoplayer2.util.e eVar2, f fVar, qg.u1 u1Var) {
        this.f33322s = fVar;
        this.f33305a = w2VarArr;
        this.f33308d = b0Var;
        this.f33309f = c0Var;
        this.f33310g = s1Var;
        this.f33311h = eVar;
        this.F = i11;
        this.G = z11;
        this.f33327x = b3Var;
        this.f33325v = r1Var;
        this.f33326w = j11;
        this.Q = j11;
        this.B = z12;
        this.f33321r = eVar2;
        this.f33317n = s1Var.getBackBufferDurationUs();
        this.f33318o = s1Var.retainBackBufferFromKeyframe();
        k2 k2VarJ = k2.j(c0Var);
        this.f33328y = k2VarJ;
        this.f33329z = new e(k2VarJ);
        this.f33307c = new y2[w2VarArr.length];
        for (int i12 = 0; i12 < w2VarArr.length; i12++) {
            w2VarArr[i12].h(i12, u1Var);
            this.f33307c[i12] = w2VarArr[i12].getCapabilities();
        }
        this.f33319p = new k(this, eVar2);
        this.f33320q = new ArrayList<>();
        this.f33306b = Sets.h();
        this.f33315l = new j3.d();
        this.f33316m = new j3.b();
        b0Var.c(this, eVar);
        this.O = true;
        Handler handler = new Handler(looper);
        this.f33323t = new d2(aVar, handler);
        this.f33324u = new g2(this, aVar, handler, u1Var);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f33313j = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f33314k = looper2;
        this.f33312i = eVar2.createHandler(looper2, this);
    }

    public static boolean M(boolean z11, com.google.android.exoplayer2.source.i.b bVar, long j11, com.google.android.exoplayer2.source.i.b bVar2, j3.b bVar3, long j12) {
        if (z11 || j11 != j12 || !bVar.f71960a.equals(bVar2.f71960a)) {
            return false;
        }
        if (bVar.b() && bVar3.t(bVar.f71961b)) {
            return (bVar3.k(bVar.f71961b, bVar.f71962c) == 4 || bVar3.k(bVar.f71961b, bVar.f71962c) == 2) ? false : true;
        }
        return bVar2.b() && bVar3.t(bVar2.f71961b);
    }

    public static boolean O(w2 w2Var) {
        return w2Var.getState() != 0;
    }

    public static boolean Q(k2 k2Var, j3.b bVar) {
        com.google.android.exoplayer2.source.i.b bVar2 = k2Var.f33405b;
        j3 j3Var = k2Var.f33404a;
        return j3Var.u() || j3Var.l(bVar2.f71960a, bVar).f33367g;
    }

    public static void r0(j3 j3Var, d dVar, j3.d dVar2, j3.b bVar) {
        int i11 = j3Var.r(j3Var.l(dVar.f33342d, bVar).f33364c, dVar2).f33392q;
        Object obj = j3Var.k(i11, bVar, true).f33363b;
        long j11 = bVar.f33365d;
        dVar.b(i11, j11 != C.TIME_UNSET ? j11 - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean s0(d dVar, j3 j3Var, j3 j3Var2, int i11, boolean z11, j3.d dVar2, j3.b bVar) {
        Object obj = dVar.f33342d;
        if (obj == null) {
            Pair<Object, Long> pairV0 = v0(j3Var, new h(dVar.f33339a.h(), dVar.f33339a.d(), dVar.f33339a.f() == Long.MIN_VALUE ? C.TIME_UNSET : com.google.android.exoplayer2.util.o0.C0(dVar.f33339a.f())), false, i11, z11, dVar2, bVar);
            if (pairV0 == null) {
                return false;
            }
            dVar.b(j3Var.f(pairV0.first), ((Long) pairV0.second).longValue(), pairV0.first);
            if (dVar.f33339a.f() == Long.MIN_VALUE) {
                r0(j3Var, dVar, dVar2, bVar);
            }
            return true;
        }
        int iF = j3Var.f(obj);
        if (iF == -1) {
            return false;
        }
        if (dVar.f33339a.f() == Long.MIN_VALUE) {
            r0(j3Var, dVar, dVar2, bVar);
            return true;
        }
        dVar.f33340b = iF;
        j3Var2.l(dVar.f33342d, bVar);
        if (bVar.f33367g && j3Var2.r(bVar.f33364c, dVar2).f33391p == j3Var2.f(dVar.f33342d)) {
            Pair<Object, Long> pairN = j3Var.n(dVar2, bVar, j3Var.l(dVar.f33342d, bVar).f33364c, dVar.f33341c + bVar.q());
            dVar.b(j3Var.f(pairN.first), ((Long) pairN.second).longValue(), pairN.first);
        }
        return true;
    }

    public static g u0(j3 j3Var, k2 k2Var, @Nullable h hVar, d2 d2Var, int i11, boolean z11, j3.d dVar, j3.b bVar) {
        com.google.android.exoplayer2.source.i.b bVar2;
        int i12;
        int i13;
        boolean z12;
        boolean z13;
        boolean z14;
        int iE;
        int iE2;
        boolean z15;
        long j11;
        int i14;
        boolean z16;
        int iE3;
        boolean z17;
        boolean z18;
        if (j3Var.u()) {
            return new g(k2.k(), 0L, C.TIME_UNSET, false, true, false);
        }
        com.google.android.exoplayer2.source.i.b bVar3 = k2Var.f33405b;
        Object obj = bVar3.f71960a;
        boolean zQ = Q(k2Var, bVar);
        long jLongValue = (k2Var.f33405b.b() || zQ) ? k2Var.f33406c : k2Var.f33421r;
        if (hVar != null) {
            i12 = -1;
            Pair<Object, Long> pairV0 = v0(j3Var, hVar, true, i11, z11, dVar, bVar);
            if (pairV0 == null) {
                iE3 = j3Var.e(z11);
                jLongValue = jLongValue;
                z16 = false;
                z17 = false;
                z18 = true;
            } else {
                if (hVar.f33358c == C.TIME_UNSET) {
                    iE3 = j3Var.l(pairV0.first, bVar).f33364c;
                    jLongValue = jLongValue;
                    z16 = false;
                } else {
                    obj = pairV0.first;
                    jLongValue = ((Long) pairV0.second).longValue();
                    z16 = true;
                    iE3 = -1;
                }
                z17 = k2Var.f33408e == 4;
                z18 = false;
            }
            z14 = z16;
            z12 = z17;
            z13 = z18;
            i13 = iE3;
            bVar2 = bVar3;
        } else {
            bVar2 = bVar3;
            i12 = -1;
            if (k2Var.f33404a.u()) {
                iE = j3Var.e(z11);
            } else if (j3Var.f(obj) == -1) {
                Object objW0 = w0(dVar, bVar, i11, z11, obj, k2Var.f33404a, j3Var);
                if (objW0 == null) {
                    iE2 = j3Var.e(z11);
                    z15 = true;
                } else {
                    iE2 = j3Var.l(objW0, bVar).f33364c;
                    z15 = false;
                }
                i13 = iE2;
                z13 = z15;
                jLongValue = jLongValue;
                bVar2 = bVar2;
                z12 = false;
                z14 = false;
            } else if (jLongValue == C.TIME_UNSET) {
                iE = j3Var.l(obj, bVar).f33364c;
            } else if (zQ) {
                bVar2 = bVar2;
                k2Var.f33404a.l(bVar2.f71960a, bVar);
                if (k2Var.f33404a.r(bVar.f33364c, dVar).f33391p == k2Var.f33404a.f(bVar2.f71960a)) {
                    Pair<Object, Long> pairN = j3Var.n(dVar, bVar, j3Var.l(obj, bVar).f33364c, jLongValue + bVar.q());
                    obj = pairN.first;
                    jLongValue = ((Long) pairN.second).longValue();
                } else {
                    jLongValue = jLongValue;
                }
                i13 = -1;
                z12 = false;
                z13 = false;
                z14 = true;
            } else {
                i13 = -1;
                z12 = false;
                z13 = false;
                z14 = false;
            }
            i13 = iE;
            z12 = false;
            z13 = false;
            z14 = false;
        }
        if (i13 != i12) {
            Pair<Object, Long> pairN2 = j3Var.n(dVar, bVar, i13, C.TIME_UNSET);
            obj = pairN2.first;
            jLongValue = ((Long) pairN2.second).longValue();
            j11 = -9223372036854775807L;
        } else {
            j11 = jLongValue;
        }
        com.google.android.exoplayer2.source.i.b bVarB = d2Var.B(j3Var, obj, jLongValue);
        int i15 = bVarB.f71964e;
        boolean z19 = bVar2.f71960a.equals(obj) && !bVar2.b() && !bVarB.b() && (i15 == i12 || ((i14 = bVar2.f71964e) != i12 && i15 >= i14));
        com.google.android.exoplayer2.source.i.b bVar4 = bVar2;
        boolean zM = M(zQ, bVar2, jLongValue, bVarB, j3Var.l(obj, bVar), j11);
        if (z19 || zM) {
            bVarB = bVar4;
        }
        if (bVarB.b()) {
            if (bVarB.equals(bVar4)) {
                jLongValue = k2Var.f33421r;
            } else {
                j3Var.l(bVarB.f71960a, bVar);
                jLongValue = bVarB.f71962c == bVar.n(bVarB.f71961b) ? bVar.j() : 0L;
            }
        }
        return new g(bVarB, jLongValue, j11, z12, z13, z14);
    }

    public static m1[] v(fi.s sVar) {
        int length = sVar != null ? sVar.length() : 0;
        m1[] m1VarArr = new m1[length];
        for (int i11 = 0; i11 < length; i11++) {
            m1VarArr[i11] = sVar.getFormat(i11);
        }
        return m1VarArr;
    }

    @Nullable
    public static Pair<Object, Long> v0(j3 j3Var, h hVar, boolean z11, int i11, boolean z12, j3.d dVar, j3.b bVar) {
        Object objW0;
        j3 j3Var2 = hVar.f33356a;
        if (j3Var.u()) {
            return null;
        }
        j3 j3Var3 = j3Var2.u() ? j3Var : j3Var2;
        try {
            Pair<Object, Long> pairN = j3Var3.n(dVar, bVar, hVar.f33357b, hVar.f33358c);
            if (j3Var.equals(j3Var3)) {
                return pairN;
            }
            if (j3Var.f(pairN.first) != -1) {
                return (j3Var3.l(pairN.first, bVar).f33367g && j3Var3.r(bVar.f33364c, dVar).f33391p == j3Var3.f(pairN.first)) ? j3Var.n(dVar, bVar, j3Var.l(pairN.first, bVar).f33364c, hVar.f33358c) : pairN;
            }
            if (z11 && (objW0 = w0(dVar, bVar, i11, z12, pairN.first, j3Var3, j3Var)) != null) {
                return j3Var.n(dVar, bVar, j3Var.l(objW0, bVar).f33364c, C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    public static Object w0(j3.d dVar, j3.b bVar, int i11, boolean z11, Object obj, j3 j3Var, j3 j3Var2) {
        int iF = j3Var.f(obj);
        int iM = j3Var.m();
        int iH = iF;
        int iF2 = -1;
        for (int i12 = 0; i12 < iM && iF2 == -1; i12++) {
            iH = j3Var.h(iH, bVar, dVar, i11, z11);
            if (iH == -1) {
                break;
            }
            iF2 = j3Var2.f(j3Var.q(iH));
        }
        if (iF2 == -1) {
            return null;
        }
        return j3Var2.q(iF2);
    }

    public final long A() {
        return B(this.f33328y.f33419p);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ab A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:22:0x00a1, B:24:0x00ab, B:29:0x00b5, B:31:0x00bb, B:32:0x00be, B:34:0x00c4, B:36:0x00ce, B:38:0x00d6, B:42:0x00de, B:44:0x00e8, B:46:0x00f8, B:50:0x0102, B:54:0x0114, B:58:0x011d), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b5 A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:22:0x00a1, B:24:0x00ab, B:29:0x00b5, B:31:0x00bb, B:32:0x00be, B:34:0x00c4, B:36:0x00ce, B:38:0x00d6, B:42:0x00de, B:44:0x00e8, B:46:0x00f8, B:50:0x0102, B:54:0x0114, B:58:0x011d), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00bb A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:22:0x00a1, B:24:0x00ab, B:29:0x00b5, B:31:0x00bb, B:32:0x00be, B:34:0x00c4, B:36:0x00ce, B:38:0x00d6, B:42:0x00de, B:44:0x00e8, B:46:0x00f8, B:50:0x0102, B:54:0x0114, B:58:0x011d), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c4 A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:22:0x00a1, B:24:0x00ab, B:29:0x00b5, B:31:0x00bb, B:32:0x00be, B:34:0x00c4, B:36:0x00ce, B:38:0x00d6, B:42:0x00de, B:44:0x00e8, B:46:0x00f8, B:50:0x0102, B:54:0x0114, B:58:0x011d), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ce A[Catch: all -> 0x00ae, TryCatch #1 {all -> 0x00ae, blocks: (B:22:0x00a1, B:24:0x00ab, B:29:0x00b5, B:31:0x00bb, B:32:0x00be, B:34:0x00c4, B:36:0x00ce, B:38:0x00d6, B:42:0x00de, B:44:0x00e8, B:46:0x00f8, B:50:0x0102, B:54:0x0114, B:58:0x011d), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:53:0x0113  */
    /* JADX WARN: Code duplicated, block: B:56:0x011a  */
    /* JADX WARN: Code duplicated, block: B:57:0x011c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0126  */
    public final void A0(h hVar) throws Throwable {
        long jLongValue;
        long j11;
        boolean z11;
        com.google.android.exoplayer2.source.i.b bVar;
        long j12;
        long j13;
        long j14;
        long jA;
        boolean z12;
        long jB0;
        boolean z13;
        long j15;
        a2 a2VarP;
        k2 k2Var;
        int i11;
        this.f33329z.b(1);
        Pair<Object, Long> pairV0 = v0(this.f33328y.f33404a, hVar, true, this.F, this.G, this.f33315l, this.f33316m);
        try {
            if (pairV0 != null) {
                Object obj = pairV0.first;
                jLongValue = ((Long) pairV0.second).longValue();
                long j16 = hVar.f33358c == C.TIME_UNSET ? -9223372036854775807L : jLongValue;
                com.google.android.exoplayer2.source.i.b bVarB = this.f33323t.B(this.f33328y.f33404a, obj, jLongValue);
                if (bVarB.b()) {
                    this.f33328y.f33404a.l(bVarB.f71960a, this.f33316m);
                    j12 = this.f33316m.n(bVarB.f71961b) == bVarB.f71962c ? this.f33316m.j() : 0L;
                    j13 = j16;
                    z11 = true;
                    bVar = bVarB;
                } else {
                    j11 = j16;
                    z11 = hVar.f33358c == C.TIME_UNSET;
                    bVar = bVarB;
                }
                if (this.f33328y.f33404a.u()) {
                    if (pairV0 == null) {
                        if (this.f33328y.f33408e != 1) {
                            X0(4);
                        }
                        o0(false, true, false, true);
                    } else {
                        if (bVar.equals(this.f33328y.f33405b)) {
                            a2VarP = this.f33323t.p();
                            if (a2VarP == null && a2VarP.f32689d && j12 != 0) {
                                jA = a2VarP.f32686a.a(j12, this.f33327x);
                            } else {
                                jA = j12;
                            }
                            if (com.google.android.exoplayer2.util.o0.f1(jA) == com.google.android.exoplayer2.util.o0.f1(this.f33328y.f33421r) && ((i11 = (k2Var = this.f33328y).f33408e) == 2 || i11 == 3)) {
                                long j17 = k2Var.f33421r;
                                this.f33328y = J(bVar, j17, j13, j17, z11, 2);
                                return;
                            }
                        } else {
                            jA = j12;
                        }
                        if (this.f33328y.f33408e == 4) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        jB0 = B0(bVar, jA, z12);
                        z13 = (j12 != jB0) | z11;
                        try {
                            k2 k2Var2 = this.f33328y;
                            j3 j3Var = k2Var2.f33404a;
                            l1(j3Var, bVar, j3Var, k2Var2.f33405b, j13);
                            z11 = z13;
                            j15 = jB0;
                        } catch (Throwable th2) {
                            th = th2;
                            z11 = z13;
                            j14 = jB0;
                            this.f33328y = J(bVar, j14, j13, j14, z11, 2);
                            throw th;
                        }
                    }
                    this.f33328y = J(bVar, j15, j13, j15, z11, 2);
                    return;
                }
                this.L = hVar;
                j15 = j12;
                this.f33328y = J(bVar, j15, j13, j15, z11, 2);
                return;
            }
            Pair<com.google.android.exoplayer2.source.i.b, Long> pairY = y(this.f33328y.f33404a);
            bVar = (com.google.android.exoplayer2.source.i.b) pairY.first;
            jLongValue = ((Long) pairY.second).longValue();
            z11 = !this.f33328y.f33404a.u();
            j11 = -9223372036854775807L;
            if (this.f33328y.f33404a.u()) {
                if (pairV0 == null) {
                    if (this.f33328y.f33408e != 1) {
                        X0(4);
                    }
                    o0(false, true, false, true);
                } else {
                    if (bVar.equals(this.f33328y.f33405b)) {
                        a2VarP = this.f33323t.p();
                        if (a2VarP == null) {
                            jA = j12;
                        } else {
                            jA = j12;
                        }
                        if (com.google.android.exoplayer2.util.o0.f1(jA) == com.google.android.exoplayer2.util.o0.f1(this.f33328y.f33421r)) {
                            long j18 = k2Var.f33421r;
                            this.f33328y = J(bVar, j18, j13, j18, z11, 2);
                            return;
                        }
                    } else {
                        jA = j12;
                    }
                    if (this.f33328y.f33408e == 4) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    jB0 = B0(bVar, jA, z12);
                    z13 = (j12 != jB0) | z11;
                    k2 k2Var3 = this.f33328y;
                    j3 j3Var2 = k2Var3.f33404a;
                    l1(j3Var2, bVar, j3Var2, k2Var3.f33405b, j13);
                    z11 = z13;
                    j15 = jB0;
                }
                this.f33328y = J(bVar, j15, j13, j15, z11, 2);
                return;
            }
            this.L = hVar;
            j15 = j12;
            this.f33328y = J(bVar, j15, j13, j15, z11, 2);
            return;
        } catch (Throwable th3) {
            th = th3;
            j14 = j12;
        }
        j12 = jLongValue;
        j13 = j11;
    }

    public final long B(long j11) {
        a2 a2VarJ = this.f33323t.j();
        if (a2VarJ == null) {
            return 0L;
        }
        return Math.max(0L, j11 - a2VarJ.y(this.M));
    }

    public final long B0(com.google.android.exoplayer2.source.i.b bVar, long j11, boolean z11) throws ExoPlaybackException {
        return C0(bVar, j11, this.f33323t.p() != this.f33323t.q(), z11);
    }

    public final void C(com.google.android.exoplayer2.source.h hVar) {
        if (this.f33323t.v(hVar)) {
            this.f33323t.y(this.M);
            T();
        }
    }

    public final long C0(com.google.android.exoplayer2.source.i.b bVar, long j11, boolean z11, boolean z12) throws ExoPlaybackException {
        g1();
        this.D = false;
        if (z12 || this.f33328y.f33408e == 3) {
            X0(2);
        }
        a2 a2VarP = this.f33323t.p();
        a2 a2VarJ = a2VarP;
        while (a2VarJ != null && !bVar.equals(a2VarJ.f32691f.f32977a)) {
            a2VarJ = a2VarJ.j();
        }
        if (z11 || a2VarP != a2VarJ || (a2VarJ != null && a2VarJ.z(j11) < 0)) {
            for (w2 w2Var : this.f33305a) {
                m(w2Var);
            }
            if (a2VarJ != null) {
                while (this.f33323t.p() != a2VarJ) {
                    this.f33323t.b();
                }
                this.f33323t.z(a2VarJ);
                a2VarJ.x(1000000000000L);
                p();
            }
        }
        if (a2VarJ != null) {
            this.f33323t.z(a2VarJ);
            if (!a2VarJ.f32689d) {
                a2VarJ.f32691f = a2VarJ.f32691f.b(j11);
            } else if (a2VarJ.f32690e) {
                j11 = a2VarJ.f32686a.seekToUs(j11);
                a2VarJ.f32686a.discardBuffer(j11 - this.f33317n, this.f33318o);
            }
            q0(j11);
            T();
        } else {
            this.f33323t.f();
            q0(j11);
        }
        E(false);
        this.f33312i.sendEmptyMessage(2);
        return j11;
    }

    public final void D(IOException iOException, int i11) {
        ExoPlaybackException exoPlaybackExceptionCreateForSource = ExoPlaybackException.createForSource(iOException, i11);
        a2 a2VarP = this.f33323t.p();
        if (a2VarP != null) {
            exoPlaybackExceptionCreateForSource = exoPlaybackExceptionCreateForSource.copyWithMediaPeriodId(a2VarP.f32691f.f32977a);
        }
        com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForSource);
        f1(false, false);
        this.f33328y = this.f33328y.e(exoPlaybackExceptionCreateForSource);
    }

    public final void D0(r2 r2Var) throws ExoPlaybackException {
        if (r2Var.f() == C.TIME_UNSET) {
            E0(r2Var);
            return;
        }
        if (this.f33328y.f33404a.u()) {
            this.f33320q.add(new d(r2Var));
            return;
        }
        d dVar = new d(r2Var);
        j3 j3Var = this.f33328y.f33404a;
        if (!s0(dVar, j3Var, j3Var, this.F, this.G, this.f33315l, this.f33316m)) {
            r2Var.k(false);
        } else {
            this.f33320q.add(dVar);
            Collections.sort(this.f33320q);
        }
    }

    public final void E(boolean z11) {
        a2 a2VarJ = this.f33323t.j();
        com.google.android.exoplayer2.source.i.b bVar = a2VarJ == null ? this.f33328y.f33405b : a2VarJ.f32691f.f32977a;
        boolean z12 = !this.f33328y.f33414k.equals(bVar);
        if (z12) {
            this.f33328y = this.f33328y.b(bVar);
        }
        k2 k2Var = this.f33328y;
        k2Var.f33419p = a2VarJ == null ? k2Var.f33421r : a2VarJ.i();
        this.f33328y.f33420q = A();
        if ((z12 || z11) && a2VarJ != null && a2VarJ.f32689d) {
            i1(a2VarJ.n(), a2VarJ.o());
        }
    }

    public final void E0(r2 r2Var) throws ExoPlaybackException {
        if (r2Var.c() != this.f33314k) {
            this.f33312i.obtainMessage(15, r2Var).a();
            return;
        }
        l(r2Var);
        int i11 = this.f33328y.f33408e;
        if (i11 == 3 || i11 == 2) {
            this.f33312i.sendEmptyMessage(2);
        }
    }

    public final void F(j3 j3Var, boolean z11) throws Throwable {
        boolean z12;
        g gVarU0 = u0(j3Var, this.f33328y, this.L, this.f33323t, this.F, this.G, this.f33315l, this.f33316m);
        com.google.android.exoplayer2.source.i.b bVar = gVarU0.f33350a;
        long j11 = gVarU0.f33352c;
        boolean z13 = gVarU0.f33353d;
        long jB0 = gVarU0.f33351b;
        boolean z14 = (this.f33328y.f33405b.equals(bVar) && jB0 == this.f33328y.f33421r) ? false : true;
        h hVar = null;
        long j12 = C.TIME_UNSET;
        try {
            if (gVarU0.f33354e) {
                if (this.f33328y.f33408e != 1) {
                    X0(4);
                }
                o0(false, false, false, true);
            }
            try {
                if (z14) {
                    z12 = false;
                    if (!j3Var.u()) {
                        for (a2 a2VarP = this.f33323t.p(); a2VarP != null; a2VarP = a2VarP.j()) {
                            if (a2VarP.f32691f.f32977a.equals(bVar)) {
                                a2VarP.f32691f = this.f33323t.r(j3Var, a2VarP.f32691f);
                                a2VarP.A();
                            }
                        }
                        jB0 = B0(bVar, jB0, z13);
                    }
                } else {
                    try {
                        z12 = false;
                        if (!this.f33323t.F(j3Var, this.M, x())) {
                            z0(false);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        hVar = null;
                        k2 k2Var = this.f33328y;
                        j3 j3Var2 = k2Var.f33404a;
                        com.google.android.exoplayer2.source.i.b bVar2 = k2Var.f33405b;
                        if (gVarU0.f33355f) {
                            j12 = jB0;
                        }
                        h hVar2 = hVar;
                        l1(j3Var, bVar, j3Var2, bVar2, j12);
                        if (z14 || j11 != this.f33328y.f33406c) {
                            k2 k2Var2 = this.f33328y;
                            Object obj = k2Var2.f33405b.f71960a;
                            j3 j3Var3 = k2Var2.f33404a;
                            this.f33328y = J(bVar, jB0, j11, this.f33328y.f33407d, z14 && z11 && !j3Var3.u() && !j3Var3.l(obj, this.f33316m).f33367g, j3Var.f(obj) == -1 ? 4 : 3);
                        }
                        p0();
                        t0(j3Var, this.f33328y.f33404a);
                        this.f33328y = this.f33328y.i(j3Var);
                        if (!j3Var.u()) {
                            this.L = hVar2;
                        }
                        E(false);
                        throw th;
                    }
                }
                k2 k2Var3 = this.f33328y;
                l1(j3Var, bVar, k2Var3.f33404a, k2Var3.f33405b, gVarU0.f33355f ? jB0 : -9223372036854775807L);
                if (z14 || j11 != this.f33328y.f33406c) {
                    k2 k2Var4 = this.f33328y;
                    Object obj2 = k2Var4.f33405b.f71960a;
                    j3 j3Var4 = k2Var4.f33404a;
                    this.f33328y = J(bVar, jB0, j11, this.f33328y.f33407d, z14 && z11 && !j3Var4.u() && !j3Var4.l(obj2, this.f33316m).f33367g, j3Var.f(obj2) == -1 ? 4 : 3);
                }
                p0();
                t0(j3Var, this.f33328y.f33404a);
                this.f33328y = this.f33328y.i(j3Var);
                if (!j3Var.u()) {
                    this.L = null;
                }
                E(z12);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void F0(final r2 r2Var) {
        Looper looperC = r2Var.c();
        if (looperC.getThread().isAlive()) {
            this.f33321r.createHandler(looperC, null).post(new Runnable() { // from class: com.google.android.exoplayer2.i1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f33289a.S(r2Var);
                }
            });
        } else {
            com.google.android.exoplayer2.util.s.i("TAG", "Trying to send message on a dead thread.");
            r2Var.k(false);
        }
    }

    public final void G(com.google.android.exoplayer2.source.h hVar) throws ExoPlaybackException {
        if (this.f33323t.v(hVar)) {
            a2 a2VarJ = this.f33323t.j();
            a2VarJ.p(this.f33319p.getPlaybackParameters().f33487a, this.f33328y.f33404a);
            i1(a2VarJ.n(), a2VarJ.o());
            if (a2VarJ == this.f33323t.p()) {
                q0(a2VarJ.f32691f.f32978b);
                p();
                k2 k2Var = this.f33328y;
                com.google.android.exoplayer2.source.i.b bVar = k2Var.f33405b;
                long j11 = a2VarJ.f32691f.f32978b;
                this.f33328y = J(bVar, j11, k2Var.f33406c, j11, false, 5);
            }
            T();
        }
    }

    public final void G0(long j11) {
        for (w2 w2Var : this.f33305a) {
            if (w2Var.getStream() != null) {
                H0(w2Var, j11);
            }
        }
    }

    public final void H(m2 m2Var, float f11, boolean z11, boolean z12) throws ExoPlaybackException {
        if (z11) {
            if (z12) {
                this.f33329z.b(1);
            }
            this.f33328y = this.f33328y.f(m2Var);
        }
        m1(m2Var.f33487a);
        for (w2 w2Var : this.f33305a) {
            if (w2Var != null) {
                w2Var.c(f11, m2Var.f33487a);
            }
        }
    }

    public final void H0(w2 w2Var, long j11) {
        w2Var.setCurrentStreamFinal();
        if (w2Var instanceof vh.p) {
            ((vh.p) w2Var).H(j11);
        }
    }

    public final void I(m2 m2Var, boolean z11) throws ExoPlaybackException {
        H(m2Var, m2Var.f33487a, true, z11);
    }

    public final void I0(boolean z11, @Nullable AtomicBoolean atomicBoolean) {
        if (this.H != z11) {
            this.H = z11;
            if (!z11) {
                for (w2 w2Var : this.f33305a) {
                    if (!O(w2Var) && this.f33306b.remove(w2Var)) {
                        w2Var.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    @CheckResult
    public final k2 J(com.google.android.exoplayer2.source.i.b bVar, long j11, long j12, long j13, boolean z11, int i11) {
        List<Metadata> listOf;
        nh.k0 k0Var;
        fi.c0 c0Var;
        this.O = (!this.O && j11 == this.f33328y.f33421r && bVar.equals(this.f33328y.f33405b)) ? false : true;
        p0();
        k2 k2Var = this.f33328y;
        nh.k0 k0Var2 = k2Var.f33411h;
        fi.c0 c0Var2 = k2Var.f33412i;
        List<Metadata> list = k2Var.f33413j;
        if (this.f33324u.s()) {
            a2 a2VarP = this.f33323t.p();
            nh.k0 k0VarN = a2VarP == null ? nh.k0.f71939d : a2VarP.n();
            fi.c0 c0VarO = a2VarP == null ? this.f33309f : a2VarP.o();
            ImmutableList<Metadata> immutableListT = t(c0VarO.f64964c);
            if (a2VarP != null) {
                b2 b2Var = a2VarP.f32691f;
                if (b2Var.f32979c != j12) {
                    a2VarP.f32691f = b2Var.a(j12);
                }
            }
            k0Var = k0VarN;
            c0Var = c0VarO;
            listOf = immutableListT;
        } else if (bVar.equals(this.f33328y.f33405b)) {
            listOf = list;
            k0Var = k0Var2;
            c0Var = c0Var2;
        } else {
            k0Var = nh.k0.f71939d;
            c0Var = this.f33309f;
            listOf = ImmutableList.of();
        }
        if (z11) {
            this.f33329z.e(i11);
        }
        return this.f33328y.c(bVar, j11, j12, j13, A(), k0Var, c0Var, listOf);
    }

    public final void J0(b bVar) throws Throwable {
        this.f33329z.b(1);
        if (bVar.f33333c != -1) {
            this.L = new h(new s2(bVar.f33331a, bVar.f33332b), bVar.f33333c, bVar.f33334d);
        }
        F(this.f33324u.C(bVar.f33331a, bVar.f33332b), false);
    }

    public final boolean K(w2 w2Var, a2 a2Var) {
        a2 a2VarJ = a2Var.j();
        return a2Var.f32691f.f32982f && a2VarJ.f32689d && ((w2Var instanceof vh.p) || (w2Var instanceof com.google.android.exoplayer2.metadata.a) || w2Var.d() >= a2VarJ.m());
    }

    public void K0(List<g2.c> list, int i11, long j11, nh.e0 e0Var) {
        this.f33312i.obtainMessage(17, new b(list, e0Var, i11, j11, null)).a();
    }

    public final boolean L() {
        a2 a2VarQ = this.f33323t.q();
        if (!a2VarQ.f32689d) {
            return false;
        }
        int i11 = 0;
        while (true) {
            w2[] w2VarArr = this.f33305a;
            if (i11 >= w2VarArr.length) {
                return true;
            }
            w2 w2Var = w2VarArr[i11];
            nh.d0 d0Var = a2VarQ.f32688c[i11];
            if (w2Var.getStream() != d0Var || (d0Var != null && !w2Var.hasReadStreamToEnd() && !K(w2Var, a2VarQ))) {
                return false;
            }
            i11++;
        }
    }

    public final void L0(boolean z11) {
        if (z11 == this.J) {
            return;
        }
        this.J = z11;
        if (z11 || !this.f33328y.f33418o) {
            return;
        }
        this.f33312i.sendEmptyMessage(2);
    }

    public final void M0(boolean z11) throws ExoPlaybackException {
        this.B = z11;
        p0();
        if (!this.C || this.f33323t.q() == this.f33323t.p()) {
            return;
        }
        z0(true);
        E(false);
    }

    public final boolean N() {
        a2 a2VarJ = this.f33323t.j();
        return (a2VarJ == null || a2VarJ.k() == Long.MIN_VALUE) ? false : true;
    }

    public void N0(boolean z11, int i11) {
        this.f33312i.obtainMessage(1, z11 ? 1 : 0, i11).a();
    }

    public final void O0(boolean z11, int i11, boolean z12, int i12) throws ExoPlaybackException {
        this.f33329z.b(z12 ? 1 : 0);
        this.f33329z.c(i12);
        this.f33328y = this.f33328y.d(z11, i11);
        this.D = false;
        d0(z11);
        if (!a1()) {
            g1();
            k1();
            return;
        }
        int i13 = this.f33328y.f33408e;
        if (i13 == 3) {
            d1();
            this.f33312i.sendEmptyMessage(2);
        } else if (i13 == 2) {
            this.f33312i.sendEmptyMessage(2);
        }
    }

    public final boolean P() {
        a2 a2VarP = this.f33323t.p();
        long j11 = a2VarP.f32691f.f32981e;
        return a2VarP.f32689d && (j11 == C.TIME_UNSET || this.f33328y.f33421r < j11 || !a1());
    }

    public void P0(m2 m2Var) {
        this.f33312i.obtainMessage(4, m2Var).a();
    }

    public final void Q0(m2 m2Var) throws ExoPlaybackException {
        this.f33319p.b(m2Var);
        I(this.f33319p.getPlaybackParameters(), true);
    }

    public final /* synthetic */ Boolean R() {
        return Boolean.valueOf(this.A);
    }

    public void R0(int i11) {
        this.f33312i.obtainMessage(11, i11, 0).a();
    }

    public final /* synthetic */ void S(r2 r2Var) {
        try {
            l(r2Var);
        } catch (ExoPlaybackException e11) {
            com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e11);
            throw new RuntimeException(e11);
        }
    }

    public final void S0(int i11) throws ExoPlaybackException {
        this.F = i11;
        if (!this.f33323t.G(this.f33328y.f33404a, i11)) {
            z0(true);
        }
        E(false);
    }

    public final void T() {
        boolean zZ0 = Z0();
        this.E = zZ0;
        if (zZ0) {
            this.f33323t.j().d(this.M);
        }
        h1();
    }

    public final void T0(b3 b3Var) {
        this.f33327x = b3Var;
    }

    public final void U() {
        this.f33329z.d(this.f33328y);
        if (this.f33329z.f33343a) {
            this.f33322s.a(this.f33329z);
            this.f33329z = new e(this.f33328y);
        }
    }

    public void U0(boolean z11) {
        this.f33312i.obtainMessage(12, z11 ? 1 : 0, 0).a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(long j11, long j12) throws ExoPlaybackException {
        if (this.f33320q.isEmpty() || this.f33328y.f33405b.b()) {
            return;
        }
        if (this.O) {
            j11--;
            this.O = false;
        }
        k2 k2Var = this.f33328y;
        int iF = k2Var.f33404a.f(k2Var.f33405b.f71960a);
        int iMin = Math.min(this.N, this.f33320q.size());
        d dVar = iMin > 0 ? this.f33320q.get(iMin - 1) : null;
        while (dVar != null) {
            int i11 = dVar.f33340b;
            if (i11 <= iF && (i11 != iF || dVar.f33341c <= j11)) {
                break;
            }
            int i12 = iMin - 1;
            dVar = i12 > 0 ? this.f33320q.get(iMin - 2) : null;
            iMin = i12;
        }
        if (iMin < this.f33320q.size()) {
            d dVar2 = this.f33320q.get(iMin);
            while (dVar2 != null && dVar2.f33342d != null) {
                int i13 = dVar2.f33340b;
                if (i13 >= iF && (i13 != iF || dVar2.f33341c > j11)) {
                    break;
                }
                iMin++;
                dVar2 = iMin < this.f33320q.size() ? this.f33320q.get(iMin) : null;
            }
            while (dVar2 != null && dVar2.f33342d != null && dVar2.f33340b == iF) {
                long j13 = dVar2.f33341c;
                if (j13 <= j11 || j13 > j12) {
                    break;
                }
                try {
                    E0(dVar2.f33339a);
                    if (dVar2.f33339a.b() || dVar2.f33339a.j()) {
                        this.f33320q.remove(iMin);
                    } else {
                        iMin++;
                    }
                    dVar2 = iMin < this.f33320q.size() ? this.f33320q.get(iMin) : null;
                } catch (Throwable th2) {
                    if (dVar2.f33339a.b() || dVar2.f33339a.j()) {
                        this.f33320q.remove(iMin);
                    }
                    throw th2;
                }
            }
            this.N = iMin;
        }
    }

    public final void V0(boolean z11) throws ExoPlaybackException {
        this.G = z11;
        if (!this.f33323t.H(this.f33328y.f33404a, z11)) {
            z0(true);
        }
        E(false);
    }

    public final void W() throws ExoPlaybackException {
        b2 b2VarO;
        this.f33323t.y(this.M);
        if (this.f33323t.D() && (b2VarO = this.f33323t.o(this.M, this.f33328y)) != null) {
            a2 a2VarG = this.f33323t.g(this.f33307c, this.f33308d, this.f33310g.getAllocator(), this.f33324u, b2VarO, this.f33309f);
            a2VarG.f32686a.f(this, b2VarO.f32978b);
            if (this.f33323t.p() == a2VarG) {
                q0(b2VarO.f32978b);
            }
            E(false);
        }
        if (!this.E) {
            T();
        } else {
            this.E = N();
            h1();
        }
    }

    public final void W0(nh.e0 e0Var) throws Throwable {
        this.f33329z.b(1);
        F(this.f33324u.D(e0Var), false);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    public final void X() throws ExoPlaybackException {
        boolean z11;
        boolean z12 = false;
        while (Y0()) {
            if (z12) {
                U();
            }
            a2 a2Var = (a2) com.google.android.exoplayer2.util.a.e(this.f33323t.b());
            if (this.f33328y.f33405b.f71960a.equals(a2Var.f32691f.f32977a.f71960a)) {
                com.google.android.exoplayer2.source.i.b bVar = this.f33328y.f33405b;
                if (bVar.f71961b == -1) {
                    com.google.android.exoplayer2.source.i.b bVar2 = a2Var.f32691f.f32977a;
                    if (bVar2.f71961b != -1 || bVar.f71964e == bVar2.f71964e) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                } else {
                    z11 = false;
                }
            } else {
                z11 = false;
            }
            b2 b2Var = a2Var.f32691f;
            com.google.android.exoplayer2.source.i.b bVar3 = b2Var.f32977a;
            long j11 = b2Var.f32978b;
            this.f33328y = J(bVar3, j11, b2Var.f32979c, j11, !z11, 0);
            p0();
            k1();
            z12 = true;
        }
    }

    public final void X0(int i11) {
        k2 k2Var = this.f33328y;
        if (k2Var.f33408e != i11) {
            if (i11 != 2) {
                this.R = C.TIME_UNSET;
            }
            this.f33328y = k2Var.g(i11);
        }
    }

    public final void Y() {
        a2 a2VarQ = this.f33323t.q();
        if (a2VarQ == null) {
            return;
        }
        int i11 = 0;
        if (a2VarQ.j() != null && !this.C) {
            if (L()) {
                if (a2VarQ.j().f32689d || this.M >= a2VarQ.j().m()) {
                    fi.c0 c0VarO = a2VarQ.o();
                    a2 a2VarC = this.f33323t.c();
                    fi.c0 c0VarO2 = a2VarC.o();
                    j3 j3Var = this.f33328y.f33404a;
                    l1(j3Var, a2VarC.f32691f.f32977a, j3Var, a2VarQ.f32691f.f32977a, C.TIME_UNSET);
                    if (a2VarC.f32689d && a2VarC.f32686a.readDiscontinuity() != C.TIME_UNSET) {
                        G0(a2VarC.m());
                        return;
                    }
                    for (int i12 = 0; i12 < this.f33305a.length; i12++) {
                        boolean zC = c0VarO.c(i12);
                        boolean zC2 = c0VarO2.c(i12);
                        if (zC && !this.f33305a[i12].isCurrentStreamFinal()) {
                            boolean z11 = this.f33307c[i12].getTrackType() == -2;
                            z2 z2Var = c0VarO.f64963b[i12];
                            z2 z2Var2 = c0VarO2.f64963b[i12];
                            if (!zC2 || !z2Var2.equals(z2Var) || z11) {
                                H0(this.f33305a[i12], a2VarC.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!a2VarQ.f32691f.f32985i && !this.C) {
            return;
        }
        while (true) {
            w2[] w2VarArr = this.f33305a;
            if (i11 >= w2VarArr.length) {
                return;
            }
            w2 w2Var = w2VarArr[i11];
            nh.d0 d0Var = a2VarQ.f32688c[i11];
            if (d0Var != null && w2Var.getStream() == d0Var && w2Var.hasReadStreamToEnd()) {
                long j11 = a2VarQ.f32691f.f32981e;
                H0(w2Var, (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? -9223372036854775807L : a2VarQ.l() + a2VarQ.f32691f.f32981e);
            }
            i11++;
        }
    }

    public final boolean Y0() {
        a2 a2VarP;
        a2 a2VarJ;
        return a1() && !this.C && (a2VarP = this.f33323t.p()) != null && (a2VarJ = a2VarP.j()) != null && this.M >= a2VarJ.m() && a2VarJ.f32692g;
    }

    public final void Z() throws ExoPlaybackException {
        a2 a2VarQ = this.f33323t.q();
        if (a2VarQ == null || this.f33323t.p() == a2VarQ || a2VarQ.f32692g || !m0()) {
            return;
        }
        p();
    }

    public final boolean Z0() {
        if (!N()) {
            return false;
        }
        a2 a2VarJ = this.f33323t.j();
        return this.f33310g.a(a2VarJ == this.f33323t.p() ? a2VarJ.y(this.M) : a2VarJ.y(this.M) - a2VarJ.f32691f.f32978b, B(a2VarJ.k()), this.f33319p.getPlaybackParameters().f33487a);
    }

    @Override // com.google.android.exoplayer2.g2.d
    public void a() {
        this.f33312i.sendEmptyMessage(22);
    }

    public final void a0() throws Throwable {
        F(this.f33324u.i(), true);
    }

    public final boolean a1() {
        k2 k2Var = this.f33328y;
        return k2Var.f33415l && k2Var.f33416m == 0;
    }

    @Override // com.google.android.exoplayer2.r2.a
    public synchronized void b(r2 r2Var) {
        if (!this.A && this.f33313j.isAlive()) {
            this.f33312i.obtainMessage(14, r2Var).a();
            return;
        }
        com.google.android.exoplayer2.util.s.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        r2Var.k(false);
    }

    public final void b0(c cVar) throws Throwable {
        this.f33329z.b(1);
        F(this.f33324u.v(cVar.f33335a, cVar.f33336b, cVar.f33337c, cVar.f33338d), false);
    }

    public final boolean b1(boolean z11) {
        if (this.K == 0) {
            return P();
        }
        if (!z11) {
            return false;
        }
        k2 k2Var = this.f33328y;
        if (!k2Var.f33410g) {
            return true;
        }
        long jB = c1(k2Var.f33404a, this.f33323t.p().f32691f.f32977a) ? this.f33325v.b() : C.TIME_UNSET;
        a2 a2VarJ = this.f33323t.j();
        return (a2VarJ.q() && a2VarJ.f32691f.f32985i) || (a2VarJ.f32691f.f32977a.b() && !a2VarJ.f32689d) || this.f33310g.b(A(), this.f33319p.getPlaybackParameters().f33487a, this.D, jB);
    }

    public final void c0() {
        for (a2 a2VarP = this.f33323t.p(); a2VarP != null; a2VarP = a2VarP.j()) {
            for (fi.s sVar : a2VarP.o().f64964c) {
                if (sVar != null) {
                    sVar.a();
                }
            }
        }
    }

    public final boolean c1(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar) {
        if (bVar.b() || j3Var.u()) {
            return false;
        }
        j3Var.r(j3Var.l(bVar.f71960a, this.f33316m).f33364c, this.f33315l);
        if (!this.f33315l.i()) {
            return false;
        }
        j3.d dVar = this.f33315l;
        return dVar.f33385j && dVar.f33382g != C.TIME_UNSET;
    }

    public final void d0(boolean z11) {
        for (a2 a2VarP = this.f33323t.p(); a2VarP != null; a2VarP = a2VarP.j()) {
            for (fi.s sVar : a2VarP.o().f64964c) {
                if (sVar != null) {
                    sVar.b(z11);
                }
            }
        }
    }

    public final void d1() throws ExoPlaybackException {
        this.D = false;
        this.f33319p.f();
        for (w2 w2Var : this.f33305a) {
            if (O(w2Var)) {
                w2Var.start();
            }
        }
    }

    public final void e0() {
        for (a2 a2VarP = this.f33323t.p(); a2VarP != null; a2VarP = a2VarP.j()) {
            for (fi.s sVar : a2VarP.o().f64964c) {
                if (sVar != null) {
                    sVar.c();
                }
            }
        }
    }

    public void e1() {
        this.f33312i.obtainMessage(6).a();
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void g(com.google.android.exoplayer2.source.h hVar) {
        this.f33312i.obtainMessage(9, hVar).a();
    }

    public final void f1(boolean z11, boolean z12) {
        o0(z11 || !this.H, false, true, false);
        this.f33329z.b(z12 ? 1 : 0);
        this.f33310g.onStopped();
        X0(1);
    }

    public void g0() {
        this.f33312i.obtainMessage(0).a();
    }

    public final void g1() throws ExoPlaybackException {
        this.f33319p.g();
        for (w2 w2Var : this.f33305a) {
            if (O(w2Var)) {
                r(w2Var);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void h(com.google.android.exoplayer2.source.h hVar) {
        this.f33312i.obtainMessage(8, hVar).a();
    }

    public final void h0() {
        this.f33329z.b(1);
        o0(false, false, false, true);
        this.f33310g.onPrepared();
        X0(this.f33328y.f33404a.u() ? 4 : 2);
        this.f33324u.w(this.f33311h.b());
        this.f33312i.sendEmptyMessage(2);
    }

    public final void h1() {
        a2 a2VarJ = this.f33323t.j();
        boolean z11 = this.E || (a2VarJ != null && a2VarJ.f32686a.isLoading());
        k2 k2Var = this.f33328y;
        if (z11 != k2Var.f33410g) {
            this.f33328y = k2Var.a(z11);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        a2 a2VarQ;
        int i11 = 1000;
        try {
            switch (message.what) {
                case 0:
                    h0();
                    break;
                case 1:
                    O0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    n();
                    break;
                case 3:
                    A0((h) message.obj);
                    break;
                case 4:
                    Q0((m2) message.obj);
                    break;
                case 5:
                    T0((b3) message.obj);
                    break;
                case 6:
                    f1(false, true);
                    break;
                case 7:
                    j0();
                    return true;
                case 8:
                    G((com.google.android.exoplayer2.source.h) message.obj);
                    break;
                case 9:
                    C((com.google.android.exoplayer2.source.h) message.obj);
                    break;
                case 10:
                    n0();
                    break;
                case 11:
                    S0(message.arg1);
                    break;
                case 12:
                    V0(message.arg1 != 0);
                    break;
                case 13:
                    I0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    D0((r2) message.obj);
                    break;
                case 15:
                    F0((r2) message.obj);
                    break;
                case 16:
                    I((m2) message.obj, false);
                    break;
                case 17:
                    J0((b) message.obj);
                    break;
                case 18:
                    j((b) message.obj, message.arg1);
                    break;
                case 19:
                    b0((c) message.obj);
                    break;
                case 20:
                    k0(message.arg1, message.arg2, (nh.e0) message.obj);
                    break;
                case 21:
                    W0((nh.e0) message.obj);
                    break;
                case 22:
                    a0();
                    break;
                case 23:
                    M0(message.arg1 != 0);
                    break;
                case 24:
                    L0(message.arg1 == 1);
                    break;
                case 25:
                    k();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e11) {
            e = e11;
            if (e.type == 1 && (a2VarQ = this.f33323t.q()) != null) {
                e = e.copyWithMediaPeriodId(a2VarQ.f32691f.f32977a);
            }
            if (e.isRecoverable && this.P == null) {
                com.google.android.exoplayer2.util.s.j("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.P = e;
                com.google.android.exoplayer2.util.o oVar = this.f33312i;
                oVar.b(oVar.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.P;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.P;
                }
                com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Playback error", e);
                f1(true, false);
                this.f33328y = this.f33328y.e(e);
            }
        } catch (ParserException e12) {
            int i12 = e12.dataType;
            if (i12 == 1) {
                i11 = e12.contentIsMalformed ? 3001 : 3003;
            } else if (i12 == 4) {
                i11 = e12.contentIsMalformed ? 3002 : 3004;
            }
            D(e12, i11);
        } catch (DrmSession.DrmSessionException e13) {
            D(e13, e13.errorCode);
        } catch (BehindLiveWindowException e14) {
            D(e14, 1002);
        } catch (DataSourceException e15) {
            D(e15, e15.reason);
        } catch (IOException e16) {
            D(e16, 2000);
        } catch (RuntimeException e17) {
            ExoPlaybackException exoPlaybackExceptionCreateForUnexpected = ExoPlaybackException.createForUnexpected(e17, ((e17 instanceof IllegalStateException) || (e17 instanceof IllegalArgumentException)) ? 1004 : 1000);
            com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForUnexpected);
            f1(true, false);
            this.f33328y = this.f33328y.e(exoPlaybackExceptionCreateForUnexpected);
        }
        U();
        return true;
    }

    public synchronized boolean i0() {
        if (!this.A && this.f33313j.isAlive()) {
            this.f33312i.sendEmptyMessage(7);
            n1(new com.google.common.base.q() { // from class: com.google.android.exoplayer2.h1
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return this.f33259a.R();
                }
            }, this.f33326w);
            return this.A;
        }
        return true;
    }

    public final void i1(nh.k0 k0Var, fi.c0 c0Var) {
        this.f33310g.c(this.f33305a, k0Var, c0Var.f64964c);
    }

    public final void j(b bVar, int i11) throws Throwable {
        this.f33329z.b(1);
        g2 g2Var = this.f33324u;
        if (i11 == -1) {
            i11 = g2Var.q();
        }
        F(g2Var.f(i11, bVar.f33331a, bVar.f33332b), false);
    }

    public final void j0() {
        o0(true, false, true, false);
        this.f33310g.onReleased();
        X0(1);
        this.f33313j.quit();
        synchronized (this) {
            this.A = true;
            notifyAll();
        }
    }

    public final void j1() throws ExoPlaybackException, IOException {
        if (this.f33328y.f33404a.u() || !this.f33324u.s()) {
            return;
        }
        W();
        Y();
        Z();
        X();
    }

    public final void k() throws ExoPlaybackException {
        z0(true);
    }

    public final void k0(int i11, int i12, nh.e0 e0Var) throws Throwable {
        this.f33329z.b(1);
        F(this.f33324u.A(i11, i12, e0Var), false);
    }

    public final void k1() throws ExoPlaybackException {
        a2 a2VarP = this.f33323t.p();
        if (a2VarP == null) {
            return;
        }
        long discontinuity = a2VarP.f32689d ? a2VarP.f32686a.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != C.TIME_UNSET) {
            q0(discontinuity);
            if (discontinuity != this.f33328y.f33421r) {
                k2 k2Var = this.f33328y;
                this.f33328y = J(k2Var.f33405b, discontinuity, k2Var.f33406c, discontinuity, true, 5);
            }
        } else {
            long jH = this.f33319p.h(a2VarP != this.f33323t.q());
            this.M = jH;
            long jY = a2VarP.y(jH);
            V(this.f33328y.f33421r, jY);
            this.f33328y.f33421r = jY;
        }
        this.f33328y.f33419p = this.f33323t.j().i();
        this.f33328y.f33420q = A();
        k2 k2Var2 = this.f33328y;
        if (k2Var2.f33415l && k2Var2.f33408e == 3 && c1(k2Var2.f33404a, k2Var2.f33405b) && this.f33328y.f33417n.f33487a == 1.0f) {
            float fA = this.f33325v.a(u(), A());
            if (this.f33319p.getPlaybackParameters().f33487a != fA) {
                this.f33319p.b(this.f33328y.f33417n.e(fA));
                H(this.f33328y.f33417n, this.f33319p.getPlaybackParameters().f33487a, false, false);
            }
        }
    }

    public final void l(r2 r2Var) throws ExoPlaybackException {
        if (r2Var.j()) {
            return;
        }
        try {
            r2Var.g().handleMessage(r2Var.i(), r2Var.e());
        } finally {
            r2Var.k(true);
        }
    }

    public void l0(int i11, int i12, nh.e0 e0Var) {
        this.f33312i.obtainMessage(20, i11, i12, e0Var).a();
    }

    public final void l1(j3 j3Var, com.google.android.exoplayer2.source.i.b bVar, j3 j3Var2, com.google.android.exoplayer2.source.i.b bVar2, long j11) {
        if (!c1(j3Var, bVar)) {
            m2 m2Var = bVar.b() ? m2.f33485d : this.f33328y.f33417n;
            if (this.f33319p.getPlaybackParameters().equals(m2Var)) {
                return;
            }
            this.f33319p.b(m2Var);
            return;
        }
        j3Var.r(j3Var.l(bVar.f71960a, this.f33316m).f33364c, this.f33315l);
        this.f33325v.e((u1.g) com.google.android.exoplayer2.util.o0.j(this.f33315l.f33387l));
        if (j11 != C.TIME_UNSET) {
            this.f33325v.d(w(j3Var, bVar.f71960a, j11));
            return;
        }
        if (com.google.android.exoplayer2.util.o0.c(!j3Var2.u() ? j3Var2.r(j3Var2.l(bVar2.f71960a, this.f33316m).f33364c, this.f33315l).f33377a : null, this.f33315l.f33377a)) {
            return;
        }
        this.f33325v.d(C.TIME_UNSET);
    }

    public final void m(w2 w2Var) throws ExoPlaybackException {
        if (O(w2Var)) {
            this.f33319p.a(w2Var);
            r(w2Var);
            w2Var.disable();
            this.K--;
        }
    }

    public final boolean m0() throws ExoPlaybackException {
        a2 a2VarQ = this.f33323t.q();
        fi.c0 c0VarO = a2VarQ.o();
        int i11 = 0;
        boolean z11 = false;
        while (true) {
            w2[] w2VarArr = this.f33305a;
            if (i11 >= w2VarArr.length) {
                return !z11;
            }
            w2 w2Var = w2VarArr[i11];
            if (O(w2Var)) {
                boolean z12 = w2Var.getStream() != a2VarQ.f32688c[i11];
                if (!c0VarO.c(i11) || z12) {
                    if (!w2Var.isCurrentStreamFinal()) {
                        w2Var.f(v(c0VarO.f64964c[i11]), a2VarQ.f32688c[i11], a2VarQ.m(), a2VarQ.l());
                    } else if (w2Var.isEnded()) {
                        m(w2Var);
                    } else {
                        z11 = true;
                    }
                }
            }
            i11++;
        }
    }

    public final void m1(float f11) {
        for (a2 a2VarP = this.f33323t.p(); a2VarP != null; a2VarP = a2VarP.j()) {
            for (fi.s sVar : a2VarP.o().f64964c) {
                if (sVar != null) {
                    sVar.onPlaybackSpeed(f11);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01a3  */
    public final void n() throws ExoPlaybackException, IOException {
        boolean z11;
        boolean z12;
        int i11;
        long jUptimeMillis = this.f33321r.uptimeMillis();
        this.f33312i.removeMessages(2);
        j1();
        int i12 = this.f33328y.f33408e;
        if (i12 == 1 || i12 == 4) {
            return;
        }
        a2 a2VarP = this.f33323t.p();
        if (a2VarP == null) {
            x0(jUptimeMillis, 10L);
            return;
        }
        com.google.android.exoplayer2.util.l0.a("doSomeWork");
        k1();
        if (a2VarP.f32689d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            a2VarP.f32686a.discardBuffer(this.f33328y.f33421r - this.f33317n, this.f33318o);
            int i13 = 0;
            z11 = true;
            z12 = true;
            while (true) {
                w2[] w2VarArr = this.f33305a;
                if (i13 >= w2VarArr.length) {
                    break;
                }
                w2 w2Var = w2VarArr[i13];
                if (O(w2Var)) {
                    w2Var.render(this.M, jElapsedRealtime);
                    z11 = z11 && w2Var.isEnded();
                    boolean z13 = a2VarP.f32688c[i13] != w2Var.getStream();
                    boolean z14 = z13 || (!z13 && w2Var.hasReadStreamToEnd()) || w2Var.isReady() || w2Var.isEnded();
                    z12 = z12 && z14;
                    if (!z14) {
                        w2Var.maybeThrowStreamError();
                    }
                }
                i13++;
            }
        } else {
            a2VarP.f32686a.maybeThrowPrepareError();
            z11 = true;
            z12 = true;
        }
        long j11 = a2VarP.f32691f.f32981e;
        boolean z15 = z11 && a2VarP.f32689d && (j11 == C.TIME_UNSET || j11 <= this.f33328y.f33421r);
        if (z15 && this.C) {
            this.C = false;
            O0(false, this.f33328y.f33416m, false, 5);
        }
        if (z15 && a2VarP.f32691f.f32985i) {
            X0(4);
            g1();
        } else if (this.f33328y.f33408e == 2 && b1(z12)) {
            X0(3);
            this.P = null;
            if (a1()) {
                d1();
            }
        } else if (this.f33328y.f33408e == 3 && (this.K != 0 ? !z12 : !P())) {
            this.D = a1();
            X0(2);
            if (this.D) {
                e0();
                this.f33325v.c();
            }
            g1();
        }
        if (this.f33328y.f33408e == 2) {
            int i14 = 0;
            while (true) {
                w2[] w2VarArr2 = this.f33305a;
                if (i14 >= w2VarArr2.length) {
                    break;
                }
                if (O(w2VarArr2[i14]) && this.f33305a[i14].getStream() == a2VarP.f32688c[i14]) {
                    this.f33305a[i14].maybeThrowStreamError();
                }
                i14++;
            }
            k2 k2Var = this.f33328y;
            if (k2Var.f33410g || k2Var.f33420q >= 500000 || !N()) {
                this.R = C.TIME_UNSET;
            } else if (this.R == C.TIME_UNSET) {
                this.R = this.f33321r.elapsedRealtime();
            } else if (this.f33321r.elapsedRealtime() - this.R >= 4000) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        } else {
            this.R = C.TIME_UNSET;
        }
        boolean z16 = a1() && this.f33328y.f33408e == 3;
        boolean z17 = this.J && this.I && z16;
        k2 k2Var2 = this.f33328y;
        if (k2Var2.f33418o != z17) {
            this.f33328y = k2Var2.h(z17);
        }
        this.I = false;
        if (z17 || (i11 = this.f33328y.f33408e) == 4) {
            return;
        }
        if (z16 || i11 == 2) {
            x0(jUptimeMillis, 10L);
        } else if (i11 == 3 && this.K != 0) {
            x0(jUptimeMillis, 1000L);
        }
        com.google.android.exoplayer2.util.l0.c();
    }

    public final void n0() throws ExoPlaybackException {
        float f11 = this.f33319p.getPlaybackParameters().f33487a;
        a2 a2VarQ = this.f33323t.q();
        boolean z11 = true;
        for (a2 a2VarP = this.f33323t.p(); a2VarP != null && a2VarP.f32689d; a2VarP = a2VarP.j()) {
            fi.c0 c0VarV = a2VarP.v(f11, this.f33328y.f33404a);
            if (!c0VarV.a(a2VarP.o())) {
                if (z11) {
                    a2 a2VarP2 = this.f33323t.p();
                    boolean z12 = this.f33323t.z(a2VarP2);
                    boolean[] zArr = new boolean[this.f33305a.length];
                    long jB = a2VarP2.b(c0VarV, this.f33328y.f33421r, z12, zArr);
                    k2 k2Var = this.f33328y;
                    boolean z13 = (k2Var.f33408e == 4 || jB == k2Var.f33421r) ? false : true;
                    k2 k2Var2 = this.f33328y;
                    this.f33328y = J(k2Var2.f33405b, jB, k2Var2.f33406c, k2Var2.f33407d, z13, 5);
                    if (z13) {
                        q0(jB);
                    }
                    boolean[] zArr2 = new boolean[this.f33305a.length];
                    int i11 = 0;
                    while (true) {
                        w2[] w2VarArr = this.f33305a;
                        if (i11 >= w2VarArr.length) {
                            break;
                        }
                        w2 w2Var = w2VarArr[i11];
                        boolean zO = O(w2Var);
                        zArr2[i11] = zO;
                        nh.d0 d0Var = a2VarP2.f32688c[i11];
                        if (zO) {
                            if (d0Var != w2Var.getStream()) {
                                m(w2Var);
                            } else if (zArr[i11]) {
                                w2Var.resetPosition(this.M);
                            }
                        }
                        i11++;
                    }
                    q(zArr2);
                } else {
                    this.f33323t.z(a2VarP);
                    if (a2VarP.f32689d) {
                        a2VarP.a(c0VarV, Math.max(a2VarP.f32691f.f32978b, a2VarP.y(this.M)), false);
                    }
                }
                E(true);
                if (this.f33328y.f33408e != 4) {
                    T();
                    k1();
                    this.f33312i.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (a2VarP == a2VarQ) {
                z11 = false;
            }
        }
    }

    public final synchronized void n1(com.google.common.base.q<Boolean> qVar, long j11) {
        long jElapsedRealtime = this.f33321r.elapsedRealtime() + j11;
        boolean z11 = false;
        while (!qVar.get2().booleanValue() && j11 > 0) {
            try {
                this.f33321r.a();
                wait(j11);
            } catch (InterruptedException unused) {
                z11 = true;
            }
            j11 = jElapsedRealtime - this.f33321r.elapsedRealtime();
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    public final void o(int i11, boolean z11) throws ExoPlaybackException {
        w2 w2Var = this.f33305a[i11];
        if (O(w2Var)) {
            return;
        }
        a2 a2VarQ = this.f33323t.q();
        boolean z12 = a2VarQ == this.f33323t.p();
        fi.c0 c0VarO = a2VarQ.o();
        z2 z2Var = c0VarO.f64963b[i11];
        m1[] m1VarArrV = v(c0VarO.f64964c[i11]);
        boolean z13 = a1() && this.f33328y.f33408e == 3;
        boolean z14 = !z11 && z13;
        this.K++;
        this.f33306b.add(w2Var);
        w2Var.g(z2Var, m1VarArrV, a2VarQ.f32688c[i11], this.M, z14, z12, a2VarQ.m(), a2VarQ.l());
        w2Var.handleMessage(11, new a());
        this.f33319p.c(w2Var);
        if (z13) {
            w2Var.start();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a6 A[PHI: r4 r5 r7
  0x00a6: PHI (r4v3 com.google.android.exoplayer2.source.i$b) = (r4v2 com.google.android.exoplayer2.source.i$b), (r4v8 com.google.android.exoplayer2.source.i$b) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r5v2 long) = (r5v1 long), (r5v4 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    public final void o0(boolean z11, boolean z12, boolean z13, boolean z14) {
        com.google.android.exoplayer2.source.i.b bVar;
        long j11;
        boolean z15;
        this.f33312i.removeMessages(2);
        this.P = null;
        this.D = false;
        this.f33319p.g();
        this.M = 1000000000000L;
        for (w2 w2Var : this.f33305a) {
            try {
                m(w2Var);
            } catch (ExoPlaybackException | RuntimeException e11) {
                com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Disable failed.", e11);
            }
        }
        if (z11) {
            for (w2 w2Var2 : this.f33305a) {
                if (this.f33306b.remove(w2Var2)) {
                    try {
                        w2Var2.reset();
                    } catch (RuntimeException e12) {
                        com.google.android.exoplayer2.util.s.d("ExoPlayerImplInternal", "Reset failed.", e12);
                    }
                }
            }
        }
        this.K = 0;
        k2 k2Var = this.f33328y;
        com.google.android.exoplayer2.source.i.b bVar2 = k2Var.f33405b;
        long jLongValue = k2Var.f33421r;
        long j12 = (this.f33328y.f33405b.b() || Q(this.f33328y, this.f33316m)) ? this.f33328y.f33406c : this.f33328y.f33421r;
        if (z12) {
            this.L = null;
            Pair<com.google.android.exoplayer2.source.i.b, Long> pairY = y(this.f33328y.f33404a);
            bVar2 = (com.google.android.exoplayer2.source.i.b) pairY.first;
            jLongValue = ((Long) pairY.second).longValue();
            boolean zEquals = bVar2.equals(this.f33328y.f33405b);
            j12 = C.TIME_UNSET;
            if (zEquals) {
                bVar = bVar2;
                j11 = jLongValue;
                z15 = false;
            } else {
                z15 = true;
                bVar = bVar2;
                j11 = jLongValue;
            }
        } else {
            bVar = bVar2;
            j11 = jLongValue;
            z15 = false;
        }
        this.f33323t.f();
        this.E = false;
        k2 k2Var2 = this.f33328y;
        j3 j3Var = k2Var2.f33404a;
        int i11 = k2Var2.f33408e;
        ExoPlaybackException exoPlaybackException = z14 ? null : k2Var2.f33409f;
        nh.k0 k0Var = z15 ? nh.k0.f71939d : k2Var2.f33411h;
        fi.c0 c0Var = z15 ? this.f33309f : k2Var2.f33412i;
        List listOf = z15 ? ImmutableList.of() : k2Var2.f33413j;
        k2 k2Var3 = this.f33328y;
        this.f33328y = new k2(j3Var, bVar, j12, j11, i11, exoPlaybackException, false, k0Var, c0Var, listOf, bVar, k2Var3.f33415l, k2Var3.f33416m, k2Var3.f33417n, j11, 0L, j11, false);
        if (z13) {
            this.f33324u.y();
        }
    }

    @Override // com.google.android.exoplayer2.k.a
    public void onPlaybackParametersChanged(m2 m2Var) {
        this.f33312i.obtainMessage(16, m2Var).a();
    }

    @Override // fi.b0.a
    public void onTrackSelectionsInvalidated() {
        this.f33312i.sendEmptyMessage(10);
    }

    public final void p() throws ExoPlaybackException {
        q(new boolean[this.f33305a.length]);
    }

    public final void p0() {
        a2 a2VarP = this.f33323t.p();
        this.C = a2VarP != null && a2VarP.f32691f.f32984h && this.B;
    }

    public final void q(boolean[] zArr) throws ExoPlaybackException {
        a2 a2VarQ = this.f33323t.q();
        fi.c0 c0VarO = a2VarQ.o();
        for (int i11 = 0; i11 < this.f33305a.length; i11++) {
            if (!c0VarO.c(i11) && this.f33306b.remove(this.f33305a[i11])) {
                this.f33305a[i11].reset();
            }
        }
        for (int i12 = 0; i12 < this.f33305a.length; i12++) {
            if (c0VarO.c(i12)) {
                o(i12, zArr[i12]);
            }
        }
        a2VarQ.f32692g = true;
    }

    public final void q0(long j11) throws ExoPlaybackException {
        a2 a2VarP = this.f33323t.p();
        long jZ = a2VarP == null ? j11 + 1000000000000L : a2VarP.z(j11);
        this.M = jZ;
        this.f33319p.d(jZ);
        for (w2 w2Var : this.f33305a) {
            if (O(w2Var)) {
                w2Var.resetPosition(this.M);
            }
        }
        c0();
    }

    public final void r(w2 w2Var) throws ExoPlaybackException {
        if (w2Var.getState() == 2) {
            w2Var.stop();
        }
    }

    public void s(long j11) {
        this.Q = j11;
    }

    public final ImmutableList<Metadata> t(fi.s[] sVarArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z11 = false;
        for (fi.s sVar : sVarArr) {
            if (sVar != null) {
                Metadata metadata = sVar.getFormat(0).f33443k;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z11 = true;
                }
            }
        }
        return z11 ? aVar.m() : ImmutableList.of();
    }

    public final void t0(j3 j3Var, j3 j3Var2) {
        if (j3Var.u() && j3Var2.u()) {
            return;
        }
        for (int size = this.f33320q.size() - 1; size >= 0; size--) {
            if (!s0(this.f33320q.get(size), j3Var, j3Var2, this.F, this.G, this.f33315l, this.f33316m)) {
                this.f33320q.get(size).f33339a.k(false);
                this.f33320q.remove(size);
            }
        }
        Collections.sort(this.f33320q);
    }

    public final long u() {
        k2 k2Var = this.f33328y;
        return w(k2Var.f33404a, k2Var.f33405b.f71960a, k2Var.f33421r);
    }

    public final long w(j3 j3Var, Object obj, long j11) {
        j3Var.r(j3Var.l(obj, this.f33316m).f33364c, this.f33315l);
        j3.d dVar = this.f33315l;
        if (dVar.f33382g != C.TIME_UNSET && dVar.i()) {
            j3.d dVar2 = this.f33315l;
            if (dVar2.f33385j) {
                return com.google.android.exoplayer2.util.o0.C0(dVar2.d() - this.f33315l.f33382g) - (j11 + this.f33316m.q());
            }
        }
        return C.TIME_UNSET;
    }

    public final long x() {
        a2 a2VarQ = this.f33323t.q();
        if (a2VarQ == null) {
            return 0L;
        }
        long jL = a2VarQ.l();
        if (!a2VarQ.f32689d) {
            return jL;
        }
        int i11 = 0;
        while (true) {
            w2[] w2VarArr = this.f33305a;
            if (i11 >= w2VarArr.length) {
                return jL;
            }
            if (O(w2VarArr[i11]) && this.f33305a[i11].getStream() == a2VarQ.f32688c[i11]) {
                long jD = this.f33305a[i11].d();
                if (jD == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jL = Math.max(jD, jL);
            }
            i11++;
        }
    }

    public final void x0(long j11, long j12) {
        this.f33312i.sendEmptyMessageAtTime(2, j11 + j12);
    }

    public final Pair<com.google.android.exoplayer2.source.i.b, Long> y(j3 j3Var) {
        if (j3Var.u()) {
            return Pair.create(k2.k(), 0L);
        }
        Pair<Object, Long> pairN = j3Var.n(this.f33315l, this.f33316m, j3Var.e(this.G), C.TIME_UNSET);
        com.google.android.exoplayer2.source.i.b bVarB = this.f33323t.B(j3Var, pairN.first, 0L);
        long jLongValue = ((Long) pairN.second).longValue();
        if (bVarB.b()) {
            j3Var.l(bVarB.f71960a, this.f33316m);
            jLongValue = bVarB.f71962c == this.f33316m.n(bVarB.f71961b) ? this.f33316m.j() : 0L;
        }
        return Pair.create(bVarB, Long.valueOf(jLongValue));
    }

    public void y0(j3 j3Var, int i11, long j11) {
        this.f33312i.obtainMessage(3, new h(j3Var, i11, j11)).a();
    }

    public Looper z() {
        return this.f33314k;
    }

    public final void z0(boolean z11) throws ExoPlaybackException {
        com.google.android.exoplayer2.source.i.b bVar = this.f33323t.p().f32691f.f32977a;
        long jC0 = C0(bVar, this.f33328y.f33421r, true, false);
        if (jC0 != this.f33328y.f33421r) {
            k2 k2Var = this.f33328y;
            this.f33328y = J(bVar, jC0, k2Var.f33406c, k2Var.f33407d, z11, 5);
        }
    }
}
