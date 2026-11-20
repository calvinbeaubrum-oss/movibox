package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s1 implements Handler.Callback, androidx.media3.exoplayer.source.k.a, s4.e0.a, r2.d, r.a, t2.a {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;

    @Nullable
    public h M;
    public long N;
    public int O;
    public boolean P;

    @Nullable
    public ExoPlaybackException Q;
    public long R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2[] f11010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<w2> f11011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y2[] f11012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s4.e0 f11013d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s4.f0 f11014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v1 f11015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.e f11016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z3.j f11017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final HandlerThread f11018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Looper f11019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.media3.common.m0.c f11020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final androidx.media3.common.m0.b f11021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f11022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f11023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final r f11024p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<d> f11025q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final z3.d f11026r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f11027s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c2 f11028t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final r2 f11029u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u1 f11030v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11031w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b3 f11032x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public s2 f11033y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e f11034z;
    public long S = C.TIME_UNSET;
    public long E = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public class a implements w2.a {
        public a() {
        }

        @Override // androidx.media3.exoplayer.w2.a
        public void a() {
            s1.this.J = true;
        }

        @Override // androidx.media3.exoplayer.w2.a
        public void b() {
            s1.this.f11017i.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<r2.c> f11036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p4.f0 f11037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f11039d;

        public b(List<r2.c> list, p4.f0 f0Var, int i11, long j11) {
            this.f11036a = list;
            this.f11037b = f0Var;
            this.f11038c = i11;
            this.f11039d = j11;
        }

        public /* synthetic */ b(List list, p4.f0 f0Var, int i11, long j11, a aVar) {
            this(list, f0Var, i11, j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final p4.f0 f11043d;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t2 f11044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Object f11047d;

        public d(t2 t2Var) {
            this.f11044a = t2Var;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f11047d;
            if ((obj == null) != (dVar.f11047d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i11 = this.f11045b - dVar.f11045b;
            return i11 != 0 ? i11 : z3.u0.n(this.f11046c, dVar.f11046c);
        }

        public void b(int i11, long j11, Object obj) {
            this.f11045b = i11;
            this.f11046c = j11;
            this.f11047d = obj;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s2 f11049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11051d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11052e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11053f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11054g;

        public e(s2 s2Var) {
            this.f11049b = s2Var;
        }

        public void b(int i11) {
            this.f11048a |= i11 > 0;
            this.f11050c += i11;
        }

        public void c(int i11) {
            this.f11048a = true;
            this.f11053f = true;
            this.f11054g = i11;
        }

        public void d(s2 s2Var) {
            this.f11048a |= this.f11049b != s2Var;
            this.f11049b = s2Var;
        }

        public void e(int i11) {
            if (this.f11051d && this.f11052e != 5) {
                z3.a.a(i11 == 5);
                return;
            }
            this.f11048a = true;
            this.f11051d = true;
            this.f11052e = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.exoplayer.source.l.b f11055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f11057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f11058d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f11059e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f11060f;

        public g(androidx.media3.exoplayer.source.l.b bVar, long j11, long j12, boolean z11, boolean z12, boolean z13) {
            this.f11055a = bVar;
            this.f11056b = j11;
            this.f11057c = j12;
            this.f11058d = z11;
            this.f11059e = z12;
            this.f11060f = z13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.m0 f11061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f11063c;

        public h(androidx.media3.common.m0 m0Var, int i11, long j11) {
            this.f11061a = m0Var;
            this.f11062b = i11;
            this.f11063c = j11;
        }
    }

    public s1(w2[] w2VarArr, s4.e0 e0Var, s4.f0 f0Var, v1 v1Var, androidx.media3.exoplayer.upstream.e eVar, int i11, boolean z11, e4.a aVar, b3 b3Var, u1 u1Var, long j11, boolean z12, Looper looper, z3.d dVar, f fVar, x3 x3Var, Looper looper2) {
        this.f11027s = fVar;
        this.f11010a = w2VarArr;
        this.f11013d = e0Var;
        this.f11014f = f0Var;
        this.f11015g = v1Var;
        this.f11016h = eVar;
        this.G = i11;
        this.H = z11;
        this.f11032x = b3Var;
        this.f11030v = u1Var;
        this.f11031w = j11;
        this.R = j11;
        this.B = z12;
        this.f11026r = dVar;
        this.f11022n = v1Var.getBackBufferDurationUs();
        this.f11023o = v1Var.retainBackBufferFromKeyframe();
        s2 s2VarK = s2.k(f0Var);
        this.f11033y = s2VarK;
        this.f11034z = new e(s2VarK);
        this.f11012c = new y2[w2VarArr.length];
        y2.a aVarD = e0Var.d();
        for (int i12 = 0; i12 < w2VarArr.length; i12++) {
            w2VarArr[i12].i(i12, x3Var, dVar);
            this.f11012c[i12] = w2VarArr[i12].getCapabilities();
            if (aVarD != null) {
                this.f11012c[i12].n(aVarD);
            }
        }
        this.f11024p = new r(this, dVar);
        this.f11025q = new ArrayList<>();
        this.f11011b = Sets.h();
        this.f11020l = new androidx.media3.common.m0.c();
        this.f11021m = new androidx.media3.common.m0.b();
        e0Var.e(this, eVar);
        this.P = true;
        z3.j jVarCreateHandler = dVar.createHandler(looper, null);
        this.f11028t = new c2(aVar, jVarCreateHandler, new z1.a() { // from class: androidx.media3.exoplayer.p1
            @Override // androidx.media3.exoplayer.z1.a
            public final z1 a(a2 a2Var, long j12) {
                return this.f10947a.p(a2Var, j12);
            }
        });
        this.f11029u = new r2(this, aVar, jVarCreateHandler, x3Var);
        if (looper2 != null) {
            this.f11018j = null;
            this.f11019k = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.f11018j = handlerThread;
            handlerThread.start();
            this.f11019k = handlerThread.getLooper();
        }
        this.f11017i = dVar.createHandler(this.f11019k, this);
    }

    public static androidx.media3.common.y[] A(s4.z zVar) {
        int length = zVar != null ? zVar.length() : 0;
        androidx.media3.common.y[] yVarArr = new androidx.media3.common.y[length];
        for (int i11 = 0; i11 < length; i11++) {
            yVarArr[i11] = zVar.getFormat(i11);
        }
        return yVarArr;
    }

    public static boolean A0(d dVar, androidx.media3.common.m0 m0Var, androidx.media3.common.m0 m0Var2, int i11, boolean z11, androidx.media3.common.m0.c cVar, androidx.media3.common.m0.b bVar) {
        Object obj = dVar.f11047d;
        if (obj == null) {
            Pair<Object, Long> pairD0 = D0(m0Var, new h(dVar.f11044a.h(), dVar.f11044a.d(), dVar.f11044a.f() == Long.MIN_VALUE ? C.TIME_UNSET : z3.u0.S0(dVar.f11044a.f())), false, i11, z11, cVar, bVar);
            if (pairD0 == null) {
                return false;
            }
            dVar.b(m0Var.b(pairD0.first), ((Long) pairD0.second).longValue(), pairD0.first);
            if (dVar.f11044a.f() == Long.MIN_VALUE) {
                z0(m0Var, dVar, cVar, bVar);
            }
            return true;
        }
        int iB = m0Var.b(obj);
        if (iB == -1) {
            return false;
        }
        if (dVar.f11044a.f() == Long.MIN_VALUE) {
            z0(m0Var, dVar, cVar, bVar);
            return true;
        }
        dVar.f11045b = iB;
        m0Var2.h(dVar.f11047d, bVar);
        if (bVar.f9298f && m0Var2.n(bVar.f9295c, cVar).f9323o == m0Var2.b(dVar.f11047d)) {
            Pair<Object, Long> pairJ = m0Var.j(cVar, bVar, m0Var.h(dVar.f11047d, bVar).f9295c, dVar.f11046c + bVar.o());
            dVar.b(m0Var.b(pairJ.first), ((Long) pairJ.second).longValue(), pairJ.first);
        }
        return true;
    }

    public static g C0(androidx.media3.common.m0 m0Var, s2 s2Var, @Nullable h hVar, c2 c2Var, int i11, boolean z11, androidx.media3.common.m0.c cVar, androidx.media3.common.m0.b bVar) {
        androidx.media3.exoplayer.source.l.b bVar2;
        int i12;
        int i13;
        boolean z12;
        boolean z13;
        boolean z14;
        int iA;
        int iA2;
        boolean z15;
        long j11;
        int i14;
        boolean z16;
        int iA3;
        boolean z17;
        boolean z18;
        if (m0Var.q()) {
            return new g(s2.l(), 0L, C.TIME_UNSET, false, true, false);
        }
        androidx.media3.exoplayer.source.l.b bVar3 = s2Var.f11066b;
        Object obj = bVar3.f11209a;
        boolean zV = V(s2Var, bVar);
        long jLongValue = (s2Var.f11066b.b() || zV) ? s2Var.f11067c : s2Var.f11082r;
        if (hVar != null) {
            i12 = -1;
            Pair<Object, Long> pairD0 = D0(m0Var, hVar, true, i11, z11, cVar, bVar);
            if (pairD0 == null) {
                iA3 = m0Var.a(z11);
                jLongValue = jLongValue;
                z16 = false;
                z17 = false;
                z18 = true;
            } else {
                if (hVar.f11063c == C.TIME_UNSET) {
                    iA3 = m0Var.h(pairD0.first, bVar).f9295c;
                    jLongValue = jLongValue;
                    z16 = false;
                } else {
                    obj = pairD0.first;
                    jLongValue = ((Long) pairD0.second).longValue();
                    z16 = true;
                    iA3 = -1;
                }
                z17 = s2Var.f11069e == 4;
                z18 = false;
            }
            z14 = z16;
            z12 = z17;
            z13 = z18;
            i13 = iA3;
            bVar2 = bVar3;
        } else {
            bVar2 = bVar3;
            i12 = -1;
            if (s2Var.f11065a.q()) {
                iA = m0Var.a(z11);
            } else if (m0Var.b(obj) == -1) {
                Object objE0 = E0(cVar, bVar, i11, z11, obj, s2Var.f11065a, m0Var);
                if (objE0 == null) {
                    iA2 = m0Var.a(z11);
                    z15 = true;
                } else {
                    iA2 = m0Var.h(objE0, bVar).f9295c;
                    z15 = false;
                }
                i13 = iA2;
                z13 = z15;
                jLongValue = jLongValue;
                bVar2 = bVar2;
                z12 = false;
                z14 = false;
            } else if (jLongValue == C.TIME_UNSET) {
                iA = m0Var.h(obj, bVar).f9295c;
            } else if (zV) {
                bVar2 = bVar2;
                s2Var.f11065a.h(bVar2.f11209a, bVar);
                if (s2Var.f11065a.n(bVar.f9295c, cVar).f9323o == s2Var.f11065a.b(bVar2.f11209a)) {
                    Pair<Object, Long> pairJ = m0Var.j(cVar, bVar, m0Var.h(obj, bVar).f9295c, jLongValue + bVar.o());
                    obj = pairJ.first;
                    jLongValue = ((Long) pairJ.second).longValue();
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
            i13 = iA;
            z12 = false;
            z13 = false;
            z14 = false;
        }
        if (i13 != i12) {
            Pair<Object, Long> pairJ2 = m0Var.j(cVar, bVar, i13, C.TIME_UNSET);
            obj = pairJ2.first;
            jLongValue = ((Long) pairJ2.second).longValue();
            j11 = -9223372036854775807L;
        } else {
            j11 = jLongValue;
        }
        androidx.media3.exoplayer.source.l.b bVarF = c2Var.F(m0Var, obj, jLongValue);
        int i15 = bVarF.f11213e;
        boolean z19 = bVar2.f11209a.equals(obj) && !bVar2.b() && !bVarF.b() && (i15 == i12 || ((i14 = bVar2.f11213e) != i12 && i15 >= i14));
        androidx.media3.exoplayer.source.l.b bVar4 = bVar2;
        boolean zR = R(zV, bVar2, jLongValue, bVarF, m0Var.h(obj, bVar), j11);
        if (z19 || zR) {
            bVarF = bVar4;
        }
        if (bVarF.b()) {
            if (bVarF.equals(bVar4)) {
                jLongValue = s2Var.f11082r;
            } else {
                m0Var.h(bVarF.f11209a, bVar);
                jLongValue = bVarF.f11211c == bVar.l(bVarF.f11210b) ? bVar.g() : 0L;
            }
        }
        return new g(bVarF, jLongValue, j11, z12, z13, z14);
    }

    @Nullable
    public static Pair<Object, Long> D0(androidx.media3.common.m0 m0Var, h hVar, boolean z11, int i11, boolean z12, androidx.media3.common.m0.c cVar, androidx.media3.common.m0.b bVar) {
        Object objE0;
        androidx.media3.common.m0 m0Var2 = hVar.f11061a;
        if (m0Var.q()) {
            return null;
        }
        androidx.media3.common.m0 m0Var3 = m0Var2.q() ? m0Var : m0Var2;
        try {
            Pair<Object, Long> pairJ = m0Var3.j(cVar, bVar, hVar.f11062b, hVar.f11063c);
            if (m0Var.equals(m0Var3)) {
                return pairJ;
            }
            if (m0Var.b(pairJ.first) != -1) {
                return (m0Var3.h(pairJ.first, bVar).f9298f && m0Var3.n(bVar.f9295c, cVar).f9323o == m0Var3.b(pairJ.first)) ? m0Var.j(cVar, bVar, m0Var.h(pairJ.first, bVar).f9295c, hVar.f11063c) : pairJ;
            }
            if (z11 && (objE0 = E0(cVar, bVar, i11, z12, pairJ.first, m0Var3, m0Var)) != null) {
                return m0Var.j(cVar, bVar, m0Var.h(objE0, bVar).f9295c, C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    public static Object E0(androidx.media3.common.m0.c cVar, androidx.media3.common.m0.b bVar, int i11, boolean z11, Object obj, androidx.media3.common.m0 m0Var, androidx.media3.common.m0 m0Var2) {
        int iB = m0Var.b(obj);
        int i12 = m0Var.i();
        int iD = iB;
        int iB2 = -1;
        for (int i13 = 0; i13 < i12 && iB2 == -1; i13++) {
            iD = m0Var.d(iD, bVar, cVar, i11, z11);
            if (iD == -1) {
                break;
            }
            iB2 = m0Var2.b(m0Var.m(iD));
        }
        if (iB2 == -1) {
            return null;
        }
        return m0Var2.m(iB2);
    }

    public static boolean R(boolean z11, androidx.media3.exoplayer.source.l.b bVar, long j11, androidx.media3.exoplayer.source.l.b bVar2, androidx.media3.common.m0.b bVar3, long j12) {
        if (z11 || j11 != j12 || !bVar.f11209a.equals(bVar2.f11209a)) {
            return false;
        }
        if (bVar.b() && bVar3.s(bVar.f11210b)) {
            return (bVar3.h(bVar.f11210b, bVar.f11211c) == 4 || bVar3.h(bVar.f11210b, bVar.f11211c) == 2) ? false : true;
        }
        return bVar2.b() && bVar3.s(bVar2.f11210b);
    }

    public static boolean T(w2 w2Var) {
        return w2Var.getState() != 0;
    }

    public static boolean V(s2 s2Var, androidx.media3.common.m0.b bVar) {
        androidx.media3.exoplayer.source.l.b bVar2 = s2Var.f11066b;
        androidx.media3.common.m0 m0Var = s2Var.f11065a;
        return m0Var.q() || m0Var.h(bVar2.f11209a, bVar).f9298f;
    }

    public static void z0(androidx.media3.common.m0 m0Var, d dVar, androidx.media3.common.m0.c cVar, androidx.media3.common.m0.b bVar) {
        int i11 = m0Var.n(m0Var.h(dVar.f11047d, bVar).f9295c, cVar).f9324p;
        Object obj = m0Var.g(i11, bVar, true).f9294b;
        long j11 = bVar.f9296d;
        dVar.b(i11, j11 != C.TIME_UNSET ? j11 - 1 : Long.MAX_VALUE, obj);
    }

    public final long B(androidx.media3.common.m0 m0Var, Object obj, long j11) {
        m0Var.n(m0Var.h(obj, this.f11021m).f9295c, this.f11020l);
        androidx.media3.common.m0.c cVar = this.f11020l;
        if (cVar.f9314f != C.TIME_UNSET && cVar.f()) {
            androidx.media3.common.m0.c cVar2 = this.f11020l;
            if (cVar2.f9317i) {
                return z3.u0.S0(cVar2.a() - this.f11020l.f9314f) - (j11 + this.f11021m.o());
            }
        }
        return C.TIME_UNSET;
    }

    public final void B0(androidx.media3.common.m0 m0Var, androidx.media3.common.m0 m0Var2) {
        if (m0Var.q() && m0Var2.q()) {
            return;
        }
        for (int size = this.f11025q.size() - 1; size >= 0; size--) {
            if (!A0(this.f11025q.get(size), m0Var, m0Var2, this.G, this.H, this.f11020l, this.f11021m)) {
                this.f11025q.get(size).f11044a.k(false);
                this.f11025q.remove(size);
            }
        }
        Collections.sort(this.f11025q);
    }

    public final long C() {
        z1 z1VarS = this.f11028t.s();
        if (z1VarS == null) {
            return 0L;
        }
        long jL = z1VarS.l();
        if (!z1VarS.f11773d) {
            return jL;
        }
        int i11 = 0;
        while (true) {
            w2[] w2VarArr = this.f11010a;
            if (i11 >= w2VarArr.length) {
                return jL;
            }
            if (T(w2VarArr[i11]) && this.f11010a[i11].getStream() == z1VarS.f11772c[i11]) {
                long jD = this.f11010a[i11].d();
                if (jD == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jL = Math.max(jD, jL);
            }
            i11++;
        }
    }

    public final Pair<androidx.media3.exoplayer.source.l.b, Long> D(androidx.media3.common.m0 m0Var) {
        if (m0Var.q()) {
            return Pair.create(s2.l(), 0L);
        }
        Pair<Object, Long> pairJ = m0Var.j(this.f11020l, this.f11021m, m0Var.a(this.H), C.TIME_UNSET);
        androidx.media3.exoplayer.source.l.b bVarF = this.f11028t.F(m0Var, pairJ.first, 0L);
        long jLongValue = ((Long) pairJ.second).longValue();
        if (bVarF.b()) {
            m0Var.h(bVarF.f11209a, this.f11021m);
            jLongValue = bVarF.f11211c == this.f11021m.l(bVarF.f11210b) ? this.f11021m.g() : 0L;
        }
        return Pair.create(bVarF, Long.valueOf(jLongValue));
    }

    public Looper E() {
        return this.f11019k;
    }

    public final long F() {
        return G(this.f11033y.f11080p);
    }

    public final void F0(long j11, long j12) {
        this.f11017i.sendEmptyMessageAtTime(2, j11 + j12);
    }

    public final long G(long j11) {
        z1 z1VarL = this.f11028t.l();
        if (z1VarL == null) {
            return 0L;
        }
        return Math.max(0L, j11 - z1VarL.y(this.N));
    }

    public void G0(androidx.media3.common.m0 m0Var, int i11, long j11) {
        this.f11017i.obtainMessage(3, new h(m0Var, i11, j11)).a();
    }

    public final void H(androidx.media3.exoplayer.source.k kVar) {
        if (this.f11028t.y(kVar)) {
            this.f11028t.C(this.N);
            Y();
        }
    }

    public final void H0(boolean z11) throws ExoPlaybackException {
        androidx.media3.exoplayer.source.l.b bVar = this.f11028t.r().f11775f.f9824a;
        long jK0 = K0(bVar, this.f11033y.f11082r, true, false);
        if (jK0 != this.f11033y.f11082r) {
            s2 s2Var = this.f11033y;
            this.f11033y = O(bVar, jK0, s2Var.f11067c, s2Var.f11068d, z11, 5);
        }
    }

    public final void I(IOException iOException, int i11) {
        ExoPlaybackException exoPlaybackExceptionCreateForSource = ExoPlaybackException.createForSource(iOException, i11);
        z1 z1VarR = this.f11028t.r();
        if (z1VarR != null) {
            exoPlaybackExceptionCreateForSource = exoPlaybackExceptionCreateForSource.copyWithMediaPeriodId(z1VarR.f11775f.f9824a);
        }
        z3.o.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForSource);
        o1(false, false);
        this.f11033y = this.f11033y.f(exoPlaybackExceptionCreateForSource);
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
    public final void I0(h hVar) throws Throwable {
        long jLongValue;
        long j11;
        boolean z11;
        androidx.media3.exoplayer.source.l.b bVar;
        long jG;
        long j12;
        long j13;
        long jB;
        boolean z12;
        long jJ0;
        long j14;
        z1 z1VarR;
        s2 s2Var;
        int i11;
        this.f11034z.b(1);
        Pair<Object, Long> pairD0 = D0(this.f11033y.f11065a, hVar, true, this.G, this.H, this.f11020l, this.f11021m);
        try {
            if (pairD0 != null) {
                Object obj = pairD0.first;
                jLongValue = ((Long) pairD0.second).longValue();
                long j15 = hVar.f11063c == C.TIME_UNSET ? -9223372036854775807L : jLongValue;
                androidx.media3.exoplayer.source.l.b bVarF = this.f11028t.F(this.f11033y.f11065a, obj, jLongValue);
                if (bVarF.b()) {
                    this.f11033y.f11065a.h(bVarF.f11209a, this.f11021m);
                    jG = this.f11021m.l(bVarF.f11210b) == bVarF.f11211c ? this.f11021m.g() : 0L;
                    j12 = j15;
                    z11 = true;
                    bVar = bVarF;
                } else {
                    j11 = j15;
                    z11 = hVar.f11063c == C.TIME_UNSET;
                    bVar = bVarF;
                }
                if (this.f11033y.f11065a.q()) {
                    if (pairD0 == null) {
                        if (this.f11033y.f11069e != 1) {
                            g1(4);
                        }
                        w0(false, true, false, true);
                    } else {
                        if (bVar.equals(this.f11033y.f11066b)) {
                            z1VarR = this.f11028t.r();
                            if (z1VarR == null && z1VarR.f11773d && jG != 0) {
                                jB = z1VarR.f11770a.b(jG, this.f11032x);
                            } else {
                                jB = jG;
                            }
                            if (z3.u0.B1(jB) == z3.u0.B1(this.f11033y.f11082r) && ((i11 = (s2Var = this.f11033y).f11069e) == 2 || i11 == 3)) {
                                long j16 = s2Var.f11082r;
                                this.f11033y = O(bVar, j16, j12, j16, z11, 2);
                                return;
                            }
                        } else {
                            jB = jG;
                        }
                        if (this.f11033y.f11069e == 4) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        jJ0 = J0(bVar, jB, z12);
                        z11 |= jG != jJ0;
                        try {
                            s2 s2Var2 = this.f11033y;
                            androidx.media3.common.m0 m0Var = s2Var2.f11065a;
                            w1(m0Var, bVar, m0Var, s2Var2.f11066b, j12, true);
                            j14 = jJ0;
                        } catch (Throwable th2) {
                            th = th2;
                            j13 = jJ0;
                            this.f11033y = O(bVar, j13, j12, j13, z11, 2);
                            throw th;
                        }
                    }
                    this.f11033y = O(bVar, j14, j12, j14, z11, 2);
                    return;
                }
                this.M = hVar;
                j14 = jG;
                this.f11033y = O(bVar, j14, j12, j14, z11, 2);
                return;
            }
            Pair<androidx.media3.exoplayer.source.l.b, Long> pairD = D(this.f11033y.f11065a);
            bVar = (androidx.media3.exoplayer.source.l.b) pairD.first;
            jLongValue = ((Long) pairD.second).longValue();
            z11 = !this.f11033y.f11065a.q();
            j11 = -9223372036854775807L;
            if (this.f11033y.f11065a.q()) {
                if (pairD0 == null) {
                    if (this.f11033y.f11069e != 1) {
                        g1(4);
                    }
                    w0(false, true, false, true);
                } else {
                    if (bVar.equals(this.f11033y.f11066b)) {
                        z1VarR = this.f11028t.r();
                        if (z1VarR == null) {
                            jB = jG;
                        } else {
                            jB = jG;
                        }
                        if (z3.u0.B1(jB) == z3.u0.B1(this.f11033y.f11082r)) {
                            long j17 = s2Var.f11082r;
                            this.f11033y = O(bVar, j17, j12, j17, z11, 2);
                            return;
                        }
                    } else {
                        jB = jG;
                    }
                    if (this.f11033y.f11069e == 4) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    jJ0 = J0(bVar, jB, z12);
                    z11 |= jG != jJ0;
                    s2 s2Var3 = this.f11033y;
                    androidx.media3.common.m0 m0Var2 = s2Var3.f11065a;
                    w1(m0Var2, bVar, m0Var2, s2Var3.f11066b, j12, true);
                    j14 = jJ0;
                }
                this.f11033y = O(bVar, j14, j12, j14, z11, 2);
                return;
            }
            this.M = hVar;
            j14 = jG;
            this.f11033y = O(bVar, j14, j12, j14, z11, 2);
            return;
        } catch (Throwable th3) {
            th = th3;
            j13 = jG;
        }
        jG = jLongValue;
        j12 = j11;
    }

    public final void J(boolean z11) {
        z1 z1VarL = this.f11028t.l();
        androidx.media3.exoplayer.source.l.b bVar = z1VarL == null ? this.f11033y.f11066b : z1VarL.f11775f.f9824a;
        boolean z12 = !this.f11033y.f11075k.equals(bVar);
        if (z12) {
            this.f11033y = this.f11033y.c(bVar);
        }
        s2 s2Var = this.f11033y;
        s2Var.f11080p = z1VarL == null ? s2Var.f11082r : z1VarL.i();
        this.f11033y.f11081q = F();
        if ((z12 || z11) && z1VarL != null && z1VarL.f11773d) {
            r1(z1VarL.f11775f.f9824a, z1VarL.n(), z1VarL.o());
        }
    }

    public final long J0(androidx.media3.exoplayer.source.l.b bVar, long j11, boolean z11) throws ExoPlaybackException {
        return K0(bVar, j11, this.f11028t.r() != this.f11028t.s(), z11);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:80:0x0161  */
    /* JADX WARN: Code duplicated, block: B:85:0x017e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0188 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:93:0x019d  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ab  */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x008b: MOVE (r5 I:??[long, double]) = (r25 I:??[long, double]), block:B:30:0x008a */
    public final void K(androidx.media3.common.m0 m0Var, boolean z11) throws Throwable {
        long j11;
        Object obj;
        boolean z12;
        int i11;
        long j12;
        long j13;
        long jJ0;
        g gVarC0 = C0(m0Var, this.f11033y, this.M, this.f11028t, this.G, this.H, this.f11020l, this.f11021m);
        androidx.media3.exoplayer.source.l.b bVar = gVarC0.f11055a;
        long j14 = gVarC0.f11057c;
        boolean z13 = gVarC0.f11058d;
        long j15 = gVarC0.f11056b;
        int i12 = 1;
        boolean z14 = (this.f11033y.f11066b.equals(bVar) && j15 == this.f11033y.f11082r) ? false : true;
        long j16 = C.TIME_UNSET;
        try {
            if (gVarC0.f11059e) {
                if (this.f11033y.f11069e != 1) {
                    g1(4);
                }
                w0(false, false, false, true);
            }
            for (w2 w2Var : this.f11010a) {
                w2Var.l(m0Var);
            }
            try {
                if (z14) {
                    j13 = j15;
                    i12 = -1;
                    if (m0Var.q()) {
                        jJ0 = j13;
                    } else {
                        try {
                            for (z1 z1VarR = this.f11028t.r(); z1VarR != null; z1VarR = z1VarR.j()) {
                                if (z1VarR.f11775f.f9824a.equals(bVar)) {
                                    z1VarR.f11775f = this.f11028t.t(m0Var, z1VarR.f11775f);
                                    z1VarR.A();
                                }
                            }
                            j15 = j13;
                            try {
                                jJ0 = J0(bVar, j15, z13);
                            } catch (Throwable th2) {
                                th = th2;
                                s2 s2Var = this.f11033y;
                                androidx.media3.common.m0 m0Var2 = s2Var.f11065a;
                                androidx.media3.exoplayer.source.l.b bVar2 = s2Var.f11066b;
                                if (gVarC0.f11060f) {
                                    j16 = j15;
                                }
                                j11 = j15;
                                w1(m0Var, bVar, m0Var2, bVar2, j16, false);
                                if (z14 || j14 != this.f11033y.f11067c) {
                                    s2 s2Var2 = this.f11033y;
                                    obj = s2Var2.f11066b.f11209a;
                                    androidx.media3.common.m0 m0Var3 = s2Var2.f11065a;
                                    if (z14 || !z11 || m0Var3.q() || m0Var3.h(obj, this.f11021m).f9298f) {
                                        z12 = false;
                                    } else {
                                        z12 = true;
                                    }
                                    long j17 = this.f11033y.f11068d;
                                    if (m0Var.b(obj) == i12) {
                                        i11 = 4;
                                    } else {
                                        i11 = 3;
                                    }
                                    this.f11033y = O(bVar, j11, j14, j17, z12, i11);
                                }
                                x0();
                                B0(m0Var, this.f11033y.f11065a);
                                this.f11033y = this.f11033y.j(m0Var);
                                if (!m0Var.q()) {
                                    this.M = 0;
                                }
                                J(false);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            j15 = j13;
                        }
                    }
                } else {
                    try {
                        i12 = -1;
                        j13 = j15;
                        if (!this.f11028t.J(m0Var, this.N, C())) {
                            H0(false);
                        }
                        jJ0 = j13;
                    } catch (Throwable th4) {
                        th = th4;
                        i12 = -1;
                        s2 s2Var3 = this.f11033y;
                        androidx.media3.common.m0 m0Var4 = s2Var3.f11065a;
                        androidx.media3.exoplayer.source.l.b bVar3 = s2Var3.f11066b;
                        if (gVarC0.f11060f) {
                            j16 = j15;
                        }
                        j11 = j15;
                        w1(m0Var, bVar, m0Var4, bVar3, j16, false);
                        if (z14) {
                            s2 s2Var4 = this.f11033y;
                            obj = s2Var4.f11066b.f11209a;
                            androidx.media3.common.m0 m0Var5 = s2Var4.f11065a;
                            if (z14) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            long j18 = this.f11033y.f11068d;
                            if (m0Var.b(obj) == i12) {
                                i11 = 4;
                            } else {
                                i11 = 3;
                            }
                            this.f11033y = O(bVar, j11, j14, j18, z12, i11);
                        } else {
                            s2 s2Var5 = this.f11033y;
                            obj = s2Var5.f11066b.f11209a;
                            androidx.media3.common.m0 m0Var6 = s2Var5.f11065a;
                            if (z14) {
                                z12 = false;
                            } else {
                                z12 = false;
                            }
                            long j19 = this.f11033y.f11068d;
                            if (m0Var.b(obj) == i12) {
                                i11 = 4;
                            } else {
                                i11 = 3;
                            }
                            this.f11033y = O(bVar, j11, j14, j19, z12, i11);
                        }
                        x0();
                        B0(m0Var, this.f11033y.f11065a);
                        this.f11033y = this.f11033y.j(m0Var);
                        if (!m0Var.q()) {
                            this.M = 0;
                        }
                        J(false);
                        throw th;
                    }
                }
                s2 s2Var6 = this.f11033y;
                w1(m0Var, bVar, s2Var6.f11065a, s2Var6.f11066b, gVarC0.f11060f ? jJ0 : -9223372036854775807L, false);
                if (z14 || j14 != this.f11033y.f11067c) {
                    s2 s2Var7 = this.f11033y;
                    Object obj2 = s2Var7.f11066b.f11209a;
                    androidx.media3.common.m0 m0Var7 = s2Var7.f11065a;
                    this.f11033y = O(bVar, jJ0, j14, this.f11033y.f11068d, z14 && z11 && !m0Var7.q() && !m0Var7.h(obj2, this.f11021m).f9298f, m0Var.b(obj2) == i12 ? 4 : 3);
                }
                x0();
                B0(m0Var, this.f11033y.f11065a);
                this.f11033y = this.f11033y.j(m0Var);
                if (!m0Var.q()) {
                    this.M = null;
                }
                J(false);
            } catch (Throwable th5) {
                th = th5;
                j15 = j12;
            }
        } catch (Throwable th6) {
            th = th6;
            i12 = -1;
        }
    }

    public final long K0(androidx.media3.exoplayer.source.l.b bVar, long j11, boolean z11, boolean z12) throws ExoPlaybackException {
        p1();
        x1(false, true);
        if (z12 || this.f11033y.f11069e == 3) {
            g1(2);
        }
        z1 z1VarR = this.f11028t.r();
        z1 z1VarJ = z1VarR;
        while (z1VarJ != null && !bVar.equals(z1VarJ.f11775f.f9824a)) {
            z1VarJ = z1VarJ.j();
        }
        if (z11 || z1VarR != z1VarJ || (z1VarJ != null && z1VarJ.z(j11) < 0)) {
            for (w2 w2Var : this.f11010a) {
                r(w2Var);
            }
            if (z1VarJ != null) {
                while (this.f11028t.r() != z1VarJ) {
                    this.f11028t.b();
                }
                this.f11028t.D(z1VarJ);
                z1VarJ.x(1000000000000L);
                u();
            }
        }
        if (z1VarJ != null) {
            this.f11028t.D(z1VarJ);
            if (!z1VarJ.f11773d) {
                z1VarJ.f11775f = z1VarJ.f11775f.b(j11);
            } else if (z1VarJ.f11774e) {
                j11 = z1VarJ.f11770a.seekToUs(j11);
                z1VarJ.f11770a.discardBuffer(j11 - this.f11022n, this.f11023o);
            }
            y0(j11);
            Y();
        } else {
            this.f11028t.f();
            y0(j11);
        }
        J(false);
        this.f11017i.sendEmptyMessage(2);
        return j11;
    }

    public final void L(androidx.media3.exoplayer.source.k kVar) throws ExoPlaybackException {
        if (this.f11028t.y(kVar)) {
            z1 z1VarL = this.f11028t.l();
            z1VarL.p(this.f11024p.getPlaybackParameters().f9222a, this.f11033y.f11065a);
            r1(z1VarL.f11775f.f9824a, z1VarL.n(), z1VarL.o());
            if (z1VarL == this.f11028t.r()) {
                y0(z1VarL.f11775f.f9825b);
                u();
                s2 s2Var = this.f11033y;
                androidx.media3.exoplayer.source.l.b bVar = s2Var.f11066b;
                long j11 = z1VarL.f11775f.f9825b;
                this.f11033y = O(bVar, j11, s2Var.f11067c, j11, false, 5);
            }
            Y();
        }
    }

    public final void L0(t2 t2Var) throws ExoPlaybackException {
        if (t2Var.f() == C.TIME_UNSET) {
            M0(t2Var);
            return;
        }
        if (this.f11033y.f11065a.q()) {
            this.f11025q.add(new d(t2Var));
            return;
        }
        d dVar = new d(t2Var);
        androidx.media3.common.m0 m0Var = this.f11033y.f11065a;
        if (!A0(dVar, m0Var, m0Var, this.G, this.H, this.f11020l, this.f11021m)) {
            t2Var.k(false);
        } else {
            this.f11025q.add(dVar);
            Collections.sort(this.f11025q);
        }
    }

    public final void M(androidx.media3.common.g0 g0Var, float f11, boolean z11, boolean z12) throws ExoPlaybackException {
        if (z11) {
            if (z12) {
                this.f11034z.b(1);
            }
            this.f11033y = this.f11033y.g(g0Var);
        }
        y1(g0Var.f9222a);
        for (w2 w2Var : this.f11010a) {
            if (w2Var != null) {
                w2Var.c(f11, g0Var.f9222a);
            }
        }
    }

    public final void M0(t2 t2Var) throws ExoPlaybackException {
        if (t2Var.c() != this.f11019k) {
            this.f11017i.obtainMessage(15, t2Var).a();
            return;
        }
        q(t2Var);
        int i11 = this.f11033y.f11069e;
        if (i11 == 3 || i11 == 2) {
            this.f11017i.sendEmptyMessage(2);
        }
    }

    public final void N(androidx.media3.common.g0 g0Var, boolean z11) throws ExoPlaybackException {
        M(g0Var, g0Var.f9222a, true, z11);
    }

    public final void N0(final t2 t2Var) {
        Looper looperC = t2Var.c();
        if (looperC.getThread().isAlive()) {
            this.f11026r.createHandler(looperC, null).post(new Runnable() { // from class: androidx.media3.exoplayer.r1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10977a.X(t2Var);
                }
            });
        } else {
            z3.o.h("TAG", "Trying to send message on a dead thread.");
            t2Var.k(false);
        }
    }

    @CheckResult
    public final s2 O(androidx.media3.exoplayer.source.l.b bVar, long j11, long j12, long j13, boolean z11, int i11) {
        List<Metadata> listOf;
        p4.k0 k0Var;
        s4.f0 f0Var;
        this.P = (!this.P && j11 == this.f11033y.f11082r && bVar.equals(this.f11033y.f11066b)) ? false : true;
        x0();
        s2 s2Var = this.f11033y;
        p4.k0 k0Var2 = s2Var.f11072h;
        s4.f0 f0Var2 = s2Var.f11073i;
        List<Metadata> list = s2Var.f11074j;
        if (this.f11029u.t()) {
            z1 z1VarR = this.f11028t.r();
            p4.k0 k0VarN = z1VarR == null ? p4.k0.f73571d : z1VarR.n();
            s4.f0 f0VarO = z1VarR == null ? this.f11014f : z1VarR.o();
            ImmutableList<Metadata> immutableListY = y(f0VarO.f76010c);
            if (z1VarR != null) {
                a2 a2Var = z1VarR.f11775f;
                if (a2Var.f9826c != j12) {
                    z1VarR.f11775f = a2Var.a(j12);
                }
            }
            c0();
            k0Var = k0VarN;
            f0Var = f0VarO;
            listOf = immutableListY;
        } else if (bVar.equals(this.f11033y.f11066b)) {
            listOf = list;
            k0Var = k0Var2;
            f0Var = f0Var2;
        } else {
            k0Var = p4.k0.f73571d;
            f0Var = this.f11014f;
            listOf = ImmutableList.of();
        }
        if (z11) {
            this.f11034z.e(i11);
        }
        return this.f11033y.d(bVar, j11, j12, j13, F(), k0Var, f0Var, listOf);
    }

    public final void O0(long j11) {
        for (w2 w2Var : this.f11010a) {
            if (w2Var.getStream() != null) {
                P0(w2Var, j11);
            }
        }
    }

    public final boolean P(w2 w2Var, z1 z1Var) {
        z1 z1VarJ = z1Var.j();
        return z1Var.f11775f.f9829f && z1VarJ.f11773d && ((w2Var instanceof r4.i) || (w2Var instanceof n4.c) || w2Var.d() >= z1VarJ.m());
    }

    public final void P0(w2 w2Var, long j11) {
        w2Var.setCurrentStreamFinal();
        if (w2Var instanceof r4.i) {
            ((r4.i) w2Var).c0(j11);
        }
    }

    public final boolean Q() {
        z1 z1VarS = this.f11028t.s();
        if (!z1VarS.f11773d) {
            return false;
        }
        int i11 = 0;
        while (true) {
            w2[] w2VarArr = this.f11010a;
            if (i11 >= w2VarArr.length) {
                return true;
            }
            w2 w2Var = w2VarArr[i11];
            p4.e0 e0Var = z1VarS.f11772c[i11];
            if (w2Var.getStream() != e0Var || (e0Var != null && !w2Var.hasReadStreamToEnd() && !P(w2Var, z1VarS))) {
                return false;
            }
            i11++;
        }
    }

    public final void Q0(boolean z11, @Nullable AtomicBoolean atomicBoolean) {
        if (this.I != z11) {
            this.I = z11;
            if (!z11) {
                for (w2 w2Var : this.f11010a) {
                    if (!T(w2Var) && this.f11011b.remove(w2Var)) {
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

    public final void R0(androidx.media3.common.g0 g0Var) {
        this.f11017i.removeMessages(16);
        this.f11024p.b(g0Var);
    }

    public final boolean S() {
        z1 z1VarL = this.f11028t.l();
        return (z1VarL == null || z1VarL.k() == Long.MIN_VALUE) ? false : true;
    }

    public final void S0(b bVar) throws Throwable {
        this.f11034z.b(1);
        if (bVar.f11038c != -1) {
            this.M = new h(new u2(bVar.f11036a, bVar.f11037b), bVar.f11038c, bVar.f11039d);
        }
        K(this.f11029u.D(bVar.f11036a, bVar.f11037b), false);
    }

    public void T0(List<r2.c> list, int i11, long j11, p4.f0 f0Var) {
        this.f11017i.obtainMessage(17, new b(list, f0Var, i11, j11, null)).a();
    }

    public final boolean U() {
        z1 z1VarR = this.f11028t.r();
        long j11 = z1VarR.f11775f.f9828e;
        return z1VarR.f11773d && (j11 == C.TIME_UNSET || this.f11033y.f11082r < j11 || !j1());
    }

    public final void U0(boolean z11) {
        if (z11 == this.K) {
            return;
        }
        this.K = z11;
        if (z11 || !this.f11033y.f11079o) {
            return;
        }
        this.f11017i.sendEmptyMessage(2);
    }

    public final void V0(boolean z11) throws ExoPlaybackException {
        this.B = z11;
        x0();
        if (!this.C || this.f11028t.s() == this.f11028t.r()) {
            return;
        }
        H0(true);
        J(false);
    }

    public final /* synthetic */ Boolean W() {
        return Boolean.valueOf(this.A);
    }

    public void W0(boolean z11, int i11) {
        this.f11017i.obtainMessage(1, z11 ? 1 : 0, i11).a();
    }

    public final /* synthetic */ void X(t2 t2Var) {
        try {
            q(t2Var);
        } catch (ExoPlaybackException e11) {
            z3.o.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e11);
            throw new RuntimeException(e11);
        }
    }

    public final void X0(boolean z11, int i11, boolean z12, int i12) throws ExoPlaybackException {
        this.f11034z.b(z12 ? 1 : 0);
        this.f11034z.c(i12);
        this.f11033y = this.f11033y.e(z11, i11);
        x1(false, false);
        j0(z11);
        if (!j1()) {
            p1();
            v1();
            return;
        }
        int i13 = this.f11033y.f11069e;
        if (i13 != 3) {
            if (i13 == 2) {
                this.f11017i.sendEmptyMessage(2);
            }
        } else {
            x1(false, false);
            this.f11024p.f();
            m1();
            this.f11017i.sendEmptyMessage(2);
        }
    }

    public final void Y() {
        boolean zI1 = i1();
        this.F = zI1;
        if (zI1) {
            this.f11028t.l().d(this.N, this.f11024p.getPlaybackParameters().f9222a, this.E);
        }
        q1();
    }

    public void Y0(androidx.media3.common.g0 g0Var) {
        this.f11017i.obtainMessage(4, g0Var).a();
    }

    public final void Z() {
        this.f11034z.d(this.f11033y);
        if (this.f11034z.f11048a) {
            this.f11027s.a(this.f11034z);
            this.f11034z = new e(this.f11033y);
        }
    }

    public final void Z0(androidx.media3.common.g0 g0Var) throws ExoPlaybackException {
        R0(g0Var);
        N(this.f11024p.getPlaybackParameters(), true);
    }

    @Override // androidx.media3.exoplayer.r2.d
    public void a() {
        this.f11017i.sendEmptyMessage(22);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0(long j11, long j12) throws ExoPlaybackException {
        if (this.f11025q.isEmpty() || this.f11033y.f11066b.b()) {
            return;
        }
        if (this.P) {
            j11--;
            this.P = false;
        }
        s2 s2Var = this.f11033y;
        int iB = s2Var.f11065a.b(s2Var.f11066b.f11209a);
        int iMin = Math.min(this.O, this.f11025q.size());
        d dVar = iMin > 0 ? this.f11025q.get(iMin - 1) : null;
        while (dVar != null) {
            int i11 = dVar.f11045b;
            if (i11 <= iB && (i11 != iB || dVar.f11046c <= j11)) {
                break;
            }
            int i12 = iMin - 1;
            dVar = i12 > 0 ? this.f11025q.get(iMin - 2) : null;
            iMin = i12;
        }
        if (iMin < this.f11025q.size()) {
            d dVar2 = this.f11025q.get(iMin);
            while (dVar2 != null && dVar2.f11047d != null) {
                int i13 = dVar2.f11045b;
                if (i13 >= iB && (i13 != iB || dVar2.f11046c > j11)) {
                    break;
                }
                iMin++;
                dVar2 = iMin < this.f11025q.size() ? this.f11025q.get(iMin) : null;
            }
            while (dVar2 != null && dVar2.f11047d != null && dVar2.f11045b == iB) {
                long j13 = dVar2.f11046c;
                if (j13 <= j11 || j13 > j12) {
                    break;
                }
                try {
                    M0(dVar2.f11044a);
                    if (dVar2.f11044a.b() || dVar2.f11044a.j()) {
                        this.f11025q.remove(iMin);
                    } else {
                        iMin++;
                    }
                    dVar2 = iMin < this.f11025q.size() ? this.f11025q.get(iMin) : null;
                } catch (Throwable th2) {
                    if (dVar2.f11044a.b() || dVar2.f11044a.j()) {
                        this.f11025q.remove(iMin);
                    }
                    throw th2;
                }
            }
            this.O = iMin;
        }
    }

    public void a1(int i11) {
        this.f11017i.obtainMessage(11, i11, 0).a();
    }

    @Override // s4.e0.a
    public void b(w2 w2Var) {
        this.f11017i.sendEmptyMessage(26);
    }

    public final void b0() throws ExoPlaybackException {
        a2 a2VarQ;
        this.f11028t.C(this.N);
        if (this.f11028t.H() && (a2VarQ = this.f11028t.q(this.N, this.f11033y)) != null) {
            z1 z1VarG = this.f11028t.g(a2VarQ);
            z1VarG.f11770a.g(this, a2VarQ.f9825b);
            if (this.f11028t.r() == z1VarG) {
                y0(a2VarQ.f9825b);
            }
            J(false);
        }
        if (!this.F) {
            Y();
        } else {
            this.F = S();
            q1();
        }
    }

    public final void b1(int i11) throws ExoPlaybackException {
        this.G = i11;
        if (!this.f11028t.K(this.f11033y.f11065a, i11)) {
            H0(true);
        }
        J(false);
    }

    @Override // androidx.media3.exoplayer.t2.a
    public synchronized void c(t2 t2Var) {
        if (!this.A && this.f11019k.getThread().isAlive()) {
            this.f11017i.obtainMessage(14, t2Var).a();
            return;
        }
        z3.o.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        t2Var.k(false);
    }

    public final void c0() {
        boolean z11;
        z1 z1VarR = this.f11028t.r();
        if (z1VarR != null) {
            s4.f0 f0VarO = z1VarR.o();
            boolean z12 = false;
            int i11 = 0;
            boolean z13 = false;
            while (true) {
                if (i11 >= this.f11010a.length) {
                    z11 = true;
                    break;
                }
                if (f0VarO.c(i11)) {
                    if (this.f11010a[i11].getTrackType() != 1) {
                        z11 = false;
                        break;
                    } else if (f0VarO.f76009b[i11].f11786a != 0) {
                        z13 = true;
                    }
                }
                i11++;
            }
            if (z13 && z11) {
                z12 = true;
            }
            U0(z12);
        }
    }

    public final void c1(b3 b3Var) {
        this.f11032x = b3Var;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    public final void d0() throws ExoPlaybackException {
        boolean z11;
        boolean z12 = false;
        while (h1()) {
            if (z12) {
                Z();
            }
            z1 z1Var = (z1) z3.a.e(this.f11028t.b());
            if (this.f11033y.f11066b.f11209a.equals(z1Var.f11775f.f9824a.f11209a)) {
                androidx.media3.exoplayer.source.l.b bVar = this.f11033y.f11066b;
                if (bVar.f11210b == -1) {
                    androidx.media3.exoplayer.source.l.b bVar2 = z1Var.f11775f.f9824a;
                    if (bVar2.f11210b != -1 || bVar.f11213e == bVar2.f11213e) {
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
            a2 a2Var = z1Var.f11775f;
            androidx.media3.exoplayer.source.l.b bVar3 = a2Var.f9824a;
            long j11 = a2Var.f9825b;
            this.f11033y = O(bVar3, j11, a2Var.f9826c, j11, !z11, 0);
            x0();
            v1();
            if (this.f11033y.f11069e == 3) {
                m1();
            }
            n();
            z12 = true;
        }
    }

    public void d1(boolean z11) {
        this.f11017i.obtainMessage(12, z11 ? 1 : 0, 0).a();
    }

    public final void e0() throws ExoPlaybackException {
        z1 z1VarS = this.f11028t.s();
        if (z1VarS == null) {
            return;
        }
        int i11 = 0;
        if (z1VarS.j() != null && !this.C) {
            if (Q()) {
                if (z1VarS.j().f11773d || this.N >= z1VarS.j().m()) {
                    s4.f0 f0VarO = z1VarS.o();
                    z1 z1VarC = this.f11028t.c();
                    s4.f0 f0VarO2 = z1VarC.o();
                    androidx.media3.common.m0 m0Var = this.f11033y.f11065a;
                    w1(m0Var, z1VarC.f11775f.f9824a, m0Var, z1VarS.f11775f.f9824a, C.TIME_UNSET, false);
                    if (z1VarC.f11773d && z1VarC.f11770a.readDiscontinuity() != C.TIME_UNSET) {
                        O0(z1VarC.m());
                        if (z1VarC.q()) {
                            return;
                        }
                        this.f11028t.D(z1VarC);
                        J(false);
                        Y();
                        return;
                    }
                    for (int i12 = 0; i12 < this.f11010a.length; i12++) {
                        boolean zC = f0VarO.c(i12);
                        boolean zC2 = f0VarO2.c(i12);
                        if (zC && !this.f11010a[i12].isCurrentStreamFinal()) {
                            boolean z11 = this.f11012c[i12].getTrackType() == -2;
                            z2 z2Var = f0VarO.f76009b[i12];
                            z2 z2Var2 = f0VarO2.f76009b[i12];
                            if (!zC2 || !z2Var2.equals(z2Var) || z11) {
                                P0(this.f11010a[i12], z1VarC.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!z1VarS.f11775f.f9832i && !this.C) {
            return;
        }
        while (true) {
            w2[] w2VarArr = this.f11010a;
            if (i11 >= w2VarArr.length) {
                return;
            }
            w2 w2Var = w2VarArr[i11];
            p4.e0 e0Var = z1VarS.f11772c[i11];
            if (e0Var != null && w2Var.getStream() == e0Var && w2Var.hasReadStreamToEnd()) {
                long j11 = z1VarS.f11775f.f9828e;
                P0(w2Var, (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? -9223372036854775807L : z1VarS.l() + z1VarS.f11775f.f9828e);
            }
            i11++;
        }
    }

    public final void e1(boolean z11) throws ExoPlaybackException {
        this.H = z11;
        if (!this.f11028t.L(this.f11033y.f11065a, z11)) {
            H0(true);
        }
        J(false);
    }

    @Override // androidx.media3.exoplayer.source.k.a
    public void f(androidx.media3.exoplayer.source.k kVar) {
        this.f11017i.obtainMessage(8, kVar).a();
    }

    public final void f0() throws ExoPlaybackException {
        z1 z1VarS = this.f11028t.s();
        if (z1VarS == null || this.f11028t.r() == z1VarS || z1VarS.f11776g || !t0()) {
            return;
        }
        u();
    }

    public final void f1(p4.f0 f0Var) throws Throwable {
        this.f11034z.b(1);
        K(this.f11029u.E(f0Var), false);
    }

    public final void g0() throws Throwable {
        K(this.f11029u.i(), true);
    }

    public final void g1(int i11) {
        s2 s2Var = this.f11033y;
        if (s2Var.f11069e != i11) {
            if (i11 != 2) {
                this.S = C.TIME_UNSET;
            }
            this.f11033y = s2Var.h(i11);
        }
    }

    public final void h0(c cVar) throws Throwable {
        this.f11034z.b(1);
        K(this.f11029u.w(cVar.f11040a, cVar.f11041b, cVar.f11042c, cVar.f11043d), false);
    }

    public final boolean h1() {
        z1 z1VarR;
        z1 z1VarJ;
        return j1() && !this.C && (z1VarR = this.f11028t.r()) != null && (z1VarJ = z1VarR.j()) != null && this.N >= z1VarJ.m() && z1VarJ.f11776g;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        int i11;
        z1 z1VarS;
        int i12 = 1000;
        try {
            switch (message.what) {
                case 0:
                    n0();
                    break;
                case 1:
                    X0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    s();
                    break;
                case 3:
                    I0((h) message.obj);
                    break;
                case 4:
                    Z0((androidx.media3.common.g0) message.obj);
                    break;
                case 5:
                    c1((b3) message.obj);
                    break;
                case 6:
                    o1(false, true);
                    break;
                case 7:
                    p0();
                    return true;
                case 8:
                    L((androidx.media3.exoplayer.source.k) message.obj);
                    break;
                case 9:
                    H((androidx.media3.exoplayer.source.k) message.obj);
                    break;
                case 10:
                    u0();
                    break;
                case 11:
                    b1(message.arg1);
                    break;
                case 12:
                    e1(message.arg1 != 0);
                    break;
                case 13:
                    Q0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    L0((t2) message.obj);
                    break;
                case 15:
                    N0((t2) message.obj);
                    break;
                case 16:
                    N((androidx.media3.common.g0) message.obj, false);
                    break;
                case 17:
                    S0((b) message.obj);
                    break;
                case 18:
                    l((b) message.obj, message.arg1);
                    break;
                case 19:
                    h0((c) message.obj);
                    break;
                case 20:
                    r0(message.arg1, message.arg2, (p4.f0) message.obj);
                    break;
                case 21:
                    f1((p4.f0) message.obj);
                    break;
                case 22:
                    g0();
                    break;
                case 23:
                    V0(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    o();
                    break;
                case 26:
                    v0();
                    break;
                case 27:
                    t1(message.arg1, message.arg2, (List) message.obj);
                    break;
            }
        } catch (ParserException e11) {
            int i13 = e11.dataType;
            if (i13 == 1) {
                i12 = e11.contentIsMalformed ? 3001 : 3003;
            } else if (i13 == 4) {
                i12 = e11.contentIsMalformed ? 3002 : 3004;
            }
            I(e11, i12);
        } catch (DataSourceException e12) {
            I(e12, e12.reason);
        } catch (ExoPlaybackException e13) {
            e = e13;
            if (e.type == 1 && (z1VarS = this.f11028t.s()) != null) {
                e = e.copyWithMediaPeriodId(z1VarS.f11775f.f9824a);
            }
            if (e.isRecoverable && (this.Q == null || (i11 = e.errorCode) == 5004 || i11 == 5003)) {
                z3.o.i("ExoPlayerImplInternal", "Recoverable renderer error", e);
                ExoPlaybackException exoPlaybackException = this.Q;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.Q;
                } else {
                    this.Q = e;
                }
                z3.j jVar = this.f11017i;
                jVar.b(jVar.obtainMessage(25, e));
            } else {
                ExoPlaybackException exoPlaybackException2 = this.Q;
                if (exoPlaybackException2 != null) {
                    exoPlaybackException2.addSuppressed(e);
                    e = this.Q;
                }
                z3.o.d("ExoPlayerImplInternal", "Playback error", e);
                if (e.type == 1 && this.f11028t.r() != this.f11028t.s()) {
                    while (this.f11028t.r() != this.f11028t.s()) {
                        this.f11028t.b();
                    }
                    a2 a2Var = ((z1) z3.a.e(this.f11028t.r())).f11775f;
                    androidx.media3.exoplayer.source.l.b bVar = a2Var.f9824a;
                    long j11 = a2Var.f9825b;
                    this.f11033y = O(bVar, j11, a2Var.f9826c, j11, true, 0);
                }
                o1(true, false);
                this.f11033y = this.f11033y.f(e);
            }
        } catch (DrmSession.DrmSessionException e14) {
            I(e14, e14.errorCode);
        } catch (BehindLiveWindowException e15) {
            I(e15, 1002);
        } catch (IOException e16) {
            I(e16, 2000);
        } catch (RuntimeException e17) {
            ExoPlaybackException exoPlaybackExceptionCreateForUnexpected = ExoPlaybackException.createForUnexpected(e17, ((e17 instanceof IllegalStateException) || (e17 instanceof IllegalArgumentException)) ? 1004 : 1000);
            z3.o.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionCreateForUnexpected);
            o1(true, false);
            this.f11033y = this.f11033y.f(exoPlaybackExceptionCreateForUnexpected);
        }
        Z();
        return true;
    }

    public final void i0() {
        for (z1 z1VarR = this.f11028t.r(); z1VarR != null; z1VarR = z1VarR.j()) {
            for (s4.z zVar : z1VarR.o().f76010c) {
                if (zVar != null) {
                    zVar.a();
                }
            }
        }
    }

    public final boolean i1() {
        if (!S()) {
            return false;
        }
        z1 z1VarL = this.f11028t.l();
        long jG = G(z1VarL.k());
        long jY = z1VarL == this.f11028t.r() ? z1VarL.y(this.N) : z1VarL.y(this.N) - z1VarL.f11775f.f9825b;
        boolean zA = this.f11015g.a(jY, jG, this.f11024p.getPlaybackParameters().f9222a);
        if (zA || jG >= 500000) {
            return zA;
        }
        if (this.f11022n <= 0 && !this.f11023o) {
            return zA;
        }
        this.f11028t.r().f11770a.discardBuffer(this.f11033y.f11082r, false);
        return this.f11015g.a(jY, jG, this.f11024p.getPlaybackParameters().f9222a);
    }

    public final void j0(boolean z11) {
        for (z1 z1VarR = this.f11028t.r(); z1VarR != null; z1VarR = z1VarR.j()) {
            for (s4.z zVar : z1VarR.o().f76010c) {
                if (zVar != null) {
                    zVar.b(z11);
                }
            }
        }
    }

    public final boolean j1() {
        s2 s2Var = this.f11033y;
        return s2Var.f11076l && s2Var.f11077m == 0;
    }

    public final void k0() {
        for (z1 z1VarR = this.f11028t.r(); z1VarR != null; z1VarR = z1VarR.j()) {
            for (s4.z zVar : z1VarR.o().f76010c) {
                if (zVar != null) {
                    zVar.c();
                }
            }
        }
    }

    public final boolean k1(boolean z11) {
        if (this.L == 0) {
            return U();
        }
        if (!z11) {
            return false;
        }
        if (!this.f11033y.f11071g) {
            return true;
        }
        z1 z1VarR = this.f11028t.r();
        long jB = l1(this.f11033y.f11065a, z1VarR.f11775f.f9824a) ? this.f11030v.b() : C.TIME_UNSET;
        z1 z1VarL = this.f11028t.l();
        return (z1VarL.q() && z1VarL.f11775f.f9832i) || (z1VarL.f11775f.f9824a.b() && !z1VarL.f11773d) || this.f11015g.c(this.f11033y.f11065a, z1VarR.f11775f.f9824a, F(), this.f11024p.getPlaybackParameters().f9222a, this.D, jB);
    }

    public final void l(b bVar, int i11) throws Throwable {
        this.f11034z.b(1);
        r2 r2Var = this.f11029u;
        if (i11 == -1) {
            i11 = r2Var.r();
        }
        K(r2Var.f(i11, bVar.f11036a, bVar.f11037b), false);
    }

    @Override // androidx.media3.exoplayer.source.t.a
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void h(androidx.media3.exoplayer.source.k kVar) {
        this.f11017i.obtainMessage(9, kVar).a();
    }

    public final boolean l1(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar) {
        if (bVar.b() || m0Var.q()) {
            return false;
        }
        m0Var.n(m0Var.h(bVar.f11209a, this.f11021m).f9295c, this.f11020l);
        if (!this.f11020l.f()) {
            return false;
        }
        androidx.media3.common.m0.c cVar = this.f11020l;
        return cVar.f9317i && cVar.f9314f != C.TIME_UNSET;
    }

    public void m(int i11, List<r2.c> list, p4.f0 f0Var) {
        this.f11017i.obtainMessage(18, i11, 0, new b(list, f0Var, -1, C.TIME_UNSET, null)).a();
    }

    public void m0() {
        this.f11017i.obtainMessage(0).a();
    }

    public final void m1() throws ExoPlaybackException {
        z1 z1VarR = this.f11028t.r();
        if (z1VarR == null) {
            return;
        }
        s4.f0 f0VarO = z1VarR.o();
        for (int i11 = 0; i11 < this.f11010a.length; i11++) {
            if (f0VarO.c(i11) && this.f11010a[i11].getState() == 1) {
                this.f11010a[i11].start();
            }
        }
    }

    public final void n() {
        s4.f0 f0VarO = this.f11028t.r().o();
        for (int i11 = 0; i11 < this.f11010a.length; i11++) {
            if (f0VarO.c(i11)) {
                this.f11010a[i11].f();
            }
        }
    }

    public final void n0() {
        this.f11034z.b(1);
        w0(false, false, false, true);
        this.f11015g.onPrepared();
        g1(this.f11033y.f11065a.q() ? 4 : 2);
        this.f11029u.x(this.f11016h.b());
        this.f11017i.sendEmptyMessage(2);
    }

    public void n1() {
        this.f11017i.obtainMessage(6).a();
    }

    public final void o() throws ExoPlaybackException {
        v0();
    }

    public synchronized boolean o0() {
        if (!this.A && this.f11019k.getThread().isAlive()) {
            this.f11017i.sendEmptyMessage(7);
            z1(new com.google.common.base.q() { // from class: androidx.media3.exoplayer.q1
                @Override // com.google.common.base.q
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return this.f10967a.W();
                }
            }, this.f11031w);
            return this.A;
        }
        return true;
    }

    public final void o1(boolean z11, boolean z12) {
        w0(z11 || !this.I, false, true, false);
        this.f11034z.b(z12 ? 1 : 0);
        this.f11015g.onStopped();
        g1(1);
    }

    @Override // androidx.media3.exoplayer.r.a
    public void onPlaybackParametersChanged(androidx.media3.common.g0 g0Var) {
        this.f11017i.obtainMessage(16, g0Var).a();
    }

    @Override // s4.e0.a
    public void onTrackSelectionsInvalidated() {
        this.f11017i.sendEmptyMessage(10);
    }

    public final z1 p(a2 a2Var, long j11) {
        return new z1(this.f11012c, j11, this.f11013d, this.f11015g.getAllocator(), this.f11029u, a2Var, this.f11014f);
    }

    public final void p0() {
        try {
            w0(true, false, true, false);
            q0();
            this.f11015g.onReleased();
            g1(1);
            HandlerThread handlerThread = this.f11018j;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            synchronized (this) {
                this.A = true;
                notifyAll();
            }
        } catch (Throwable th2) {
            HandlerThread handlerThread2 = this.f11018j;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            synchronized (this) {
                this.A = true;
                notifyAll();
                throw th2;
            }
        }
    }

    public final void p1() throws ExoPlaybackException {
        this.f11024p.g();
        for (w2 w2Var : this.f11010a) {
            if (T(w2Var)) {
                w(w2Var);
            }
        }
    }

    public final void q(t2 t2Var) throws ExoPlaybackException {
        if (t2Var.j()) {
            return;
        }
        try {
            t2Var.g().handleMessage(t2Var.i(), t2Var.e());
        } finally {
            t2Var.k(true);
        }
    }

    public final void q0() {
        for (int i11 = 0; i11 < this.f11010a.length; i11++) {
            this.f11012c[i11].e();
            this.f11010a[i11].release();
        }
    }

    public final void q1() {
        z1 z1VarL = this.f11028t.l();
        boolean z11 = this.F || (z1VarL != null && z1VarL.f11770a.isLoading());
        s2 s2Var = this.f11033y;
        if (z11 != s2Var.f11071g) {
            this.f11033y = s2Var.b(z11);
        }
    }

    public final void r(w2 w2Var) throws ExoPlaybackException {
        if (T(w2Var)) {
            this.f11024p.a(w2Var);
            w(w2Var);
            w2Var.disable();
            this.L--;
        }
    }

    public final void r0(int i11, int i12, p4.f0 f0Var) throws Throwable {
        this.f11034z.b(1);
        K(this.f11029u.B(i11, i12, f0Var), false);
    }

    public final void r1(androidx.media3.exoplayer.source.l.b bVar, p4.k0 k0Var, s4.f0 f0Var) {
        this.f11015g.b(this.f11033y.f11065a, bVar, this.f11010a, k0Var, f0Var.f76010c);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01ad  */
    public final void s() throws ExoPlaybackException, IOException {
        boolean z11;
        boolean z12;
        int i11;
        long jUptimeMillis = this.f11026r.uptimeMillis();
        this.f11017i.removeMessages(2);
        u1();
        int i12 = this.f11033y.f11069e;
        if (i12 == 1 || i12 == 4) {
            return;
        }
        z1 z1VarR = this.f11028t.r();
        if (z1VarR == null) {
            F0(jUptimeMillis, 10L);
            return;
        }
        z3.j0.a("doSomeWork");
        v1();
        if (z1VarR.f11773d) {
            long jS0 = z3.u0.S0(this.f11026r.elapsedRealtime());
            z1VarR.f11770a.discardBuffer(this.f11033y.f11082r - this.f11022n, this.f11023o);
            int i13 = 0;
            z11 = true;
            z12 = true;
            while (true) {
                w2[] w2VarArr = this.f11010a;
                if (i13 >= w2VarArr.length) {
                    break;
                }
                w2 w2Var = w2VarArr[i13];
                if (T(w2Var)) {
                    w2Var.render(this.N, jS0);
                    z11 = z11 && w2Var.isEnded();
                    boolean z13 = z1VarR.f11772c[i13] != w2Var.getStream();
                    boolean z14 = z13 || (!z13 && w2Var.hasReadStreamToEnd()) || w2Var.isReady() || w2Var.isEnded();
                    z12 = z12 && z14;
                    if (!z14) {
                        w2Var.maybeThrowStreamError();
                    }
                }
                i13++;
            }
        } else {
            z1VarR.f11770a.maybeThrowPrepareError();
            z11 = true;
            z12 = true;
        }
        long j11 = z1VarR.f11775f.f9828e;
        boolean z15 = z11 && z1VarR.f11773d && (j11 == C.TIME_UNSET || j11 <= this.f11033y.f11082r);
        if (z15 && this.C) {
            this.C = false;
            X0(false, this.f11033y.f11077m, false, 5);
        }
        if (z15 && z1VarR.f11775f.f9832i) {
            g1(4);
            p1();
        } else if (this.f11033y.f11069e == 2 && k1(z12)) {
            g1(3);
            this.Q = null;
            if (j1()) {
                x1(false, false);
                this.f11024p.f();
                m1();
            }
        } else if (this.f11033y.f11069e == 3 && (this.L != 0 ? !z12 : !U())) {
            x1(j1(), false);
            g1(2);
            if (this.D) {
                k0();
                this.f11030v.c();
            }
            p1();
        }
        if (this.f11033y.f11069e == 2) {
            int i14 = 0;
            while (true) {
                w2[] w2VarArr2 = this.f11010a;
                if (i14 >= w2VarArr2.length) {
                    break;
                }
                if (T(w2VarArr2[i14]) && this.f11010a[i14].getStream() == z1VarR.f11772c[i14]) {
                    this.f11010a[i14].maybeThrowStreamError();
                }
                i14++;
            }
            s2 s2Var = this.f11033y;
            if (s2Var.f11071g || s2Var.f11081q >= 500000 || !S()) {
                this.S = C.TIME_UNSET;
            } else if (this.S == C.TIME_UNSET) {
                this.S = this.f11026r.elapsedRealtime();
            } else if (this.f11026r.elapsedRealtime() - this.S >= 4000) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        } else {
            this.S = C.TIME_UNSET;
        }
        boolean z16 = j1() && this.f11033y.f11069e == 3;
        boolean z17 = this.K && this.J && z16;
        s2 s2Var2 = this.f11033y;
        if (s2Var2.f11079o != z17) {
            this.f11033y = s2Var2.i(z17);
        }
        this.J = false;
        if (!z17 && (i11 = this.f11033y.f11069e) != 4) {
            if (z16 || i11 == 2) {
                F0(jUptimeMillis, 10L);
            } else if (i11 == 3 && this.L != 0) {
                F0(jUptimeMillis, 1000L);
            }
        }
        z3.j0.c();
    }

    public void s0(int i11, int i12, p4.f0 f0Var) {
        this.f11017i.obtainMessage(20, i11, i12, f0Var).a();
    }

    public void s1(int i11, int i12, List<androidx.media3.common.b0> list) {
        this.f11017i.obtainMessage(27, i11, i12, list).a();
    }

    public final void t(int i11, boolean z11, long j11) throws ExoPlaybackException {
        w2 w2Var = this.f11010a[i11];
        if (T(w2Var)) {
            return;
        }
        z1 z1VarS = this.f11028t.s();
        boolean z12 = z1VarS == this.f11028t.r();
        s4.f0 f0VarO = z1VarS.o();
        z2 z2Var = f0VarO.f76009b[i11];
        androidx.media3.common.y[] yVarArrA = A(f0VarO.f76010c[i11]);
        boolean z13 = j1() && this.f11033y.f11069e == 3;
        boolean z14 = !z11 && z13;
        this.L++;
        this.f11011b.add(w2Var);
        w2Var.g(z2Var, yVarArrA, z1VarS.f11772c[i11], this.N, z14, z12, j11, z1VarS.l(), z1VarS.f11775f.f9824a);
        w2Var.handleMessage(11, new a());
        this.f11024p.c(w2Var);
        if (z13 && z12) {
            w2Var.start();
        }
    }

    public final boolean t0() throws ExoPlaybackException {
        z1 z1VarS = this.f11028t.s();
        s4.f0 f0VarO = z1VarS.o();
        int i11 = 0;
        boolean z11 = false;
        while (true) {
            w2[] w2VarArr = this.f11010a;
            if (i11 >= w2VarArr.length) {
                return !z11;
            }
            w2 w2Var = w2VarArr[i11];
            if (T(w2Var)) {
                boolean z12 = w2Var.getStream() != z1VarS.f11772c[i11];
                if (!f0VarO.c(i11) || z12) {
                    if (!w2Var.isCurrentStreamFinal()) {
                        w2Var.m(A(f0VarO.f76010c[i11]), z1VarS.f11772c[i11], z1VarS.m(), z1VarS.l(), z1VarS.f11775f.f9824a);
                        if (this.K) {
                            U0(false);
                        }
                    } else if (w2Var.isEnded()) {
                        r(w2Var);
                    } else {
                        z11 = true;
                    }
                }
            }
            i11++;
        }
    }

    public final void t1(int i11, int i12, List<androidx.media3.common.b0> list) throws Throwable {
        this.f11034z.b(1);
        K(this.f11029u.F(i11, i12, list), false);
    }

    public final void u() throws ExoPlaybackException {
        v(new boolean[this.f11010a.length], this.f11028t.s().m());
    }

    public final void u0() throws ExoPlaybackException {
        float f11 = this.f11024p.getPlaybackParameters().f9222a;
        z1 z1VarS = this.f11028t.s();
        s4.f0 f0Var = null;
        boolean z11 = true;
        for (z1 z1VarR = this.f11028t.r(); z1VarR != null && z1VarR.f11773d; z1VarR = z1VarR.j()) {
            s4.f0 f0VarV = z1VarR.v(f11, this.f11033y.f11065a);
            if (z1VarR == this.f11028t.r()) {
                f0Var = f0VarV;
            }
            if (!f0VarV.a(z1VarR.o())) {
                if (z11) {
                    z1 z1VarR2 = this.f11028t.r();
                    boolean zD = this.f11028t.D(z1VarR2);
                    boolean[] zArr = new boolean[this.f11010a.length];
                    long jB = z1VarR2.b((s4.f0) z3.a.e(f0Var), this.f11033y.f11082r, zD, zArr);
                    s2 s2Var = this.f11033y;
                    boolean z12 = (s2Var.f11069e == 4 || jB == s2Var.f11082r) ? false : true;
                    s2 s2Var2 = this.f11033y;
                    this.f11033y = O(s2Var2.f11066b, jB, s2Var2.f11067c, s2Var2.f11068d, z12, 5);
                    if (z12) {
                        y0(jB);
                    }
                    boolean[] zArr2 = new boolean[this.f11010a.length];
                    int i11 = 0;
                    while (true) {
                        w2[] w2VarArr = this.f11010a;
                        if (i11 >= w2VarArr.length) {
                            break;
                        }
                        w2 w2Var = w2VarArr[i11];
                        boolean zT = T(w2Var);
                        zArr2[i11] = zT;
                        p4.e0 e0Var = z1VarR2.f11772c[i11];
                        if (zT) {
                            if (e0Var != w2Var.getStream()) {
                                r(w2Var);
                            } else if (zArr[i11]) {
                                w2Var.resetPosition(this.N);
                            }
                        }
                        i11++;
                    }
                    v(zArr2, this.N);
                } else {
                    this.f11028t.D(z1VarR);
                    if (z1VarR.f11773d) {
                        z1VarR.a(f0VarV, Math.max(z1VarR.f11775f.f9825b, z1VarR.y(this.N)), false);
                    }
                }
                J(true);
                if (this.f11033y.f11069e != 4) {
                    Y();
                    v1();
                    this.f11017i.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (z1VarR == z1VarS) {
                z11 = false;
            }
        }
    }

    public final void u1() throws ExoPlaybackException {
        if (this.f11033y.f11065a.q() || !this.f11029u.t()) {
            return;
        }
        b0();
        e0();
        f0();
        d0();
    }

    public final void v(boolean[] zArr, long j11) throws ExoPlaybackException {
        z1 z1VarS = this.f11028t.s();
        s4.f0 f0VarO = z1VarS.o();
        for (int i11 = 0; i11 < this.f11010a.length; i11++) {
            if (!f0VarO.c(i11) && this.f11011b.remove(this.f11010a[i11])) {
                this.f11010a[i11].reset();
            }
        }
        for (int i12 = 0; i12 < this.f11010a.length; i12++) {
            if (f0VarO.c(i12)) {
                t(i12, zArr[i12], j11);
            }
        }
        z1VarS.f11776g = true;
    }

    public final void v0() throws ExoPlaybackException {
        u0();
        H0(true);
    }

    public final void v1() throws ExoPlaybackException {
        z1 z1VarR = this.f11028t.r();
        if (z1VarR == null) {
            return;
        }
        long discontinuity = z1VarR.f11773d ? z1VarR.f11770a.readDiscontinuity() : -9223372036854775807L;
        if (discontinuity != C.TIME_UNSET) {
            if (!z1VarR.q()) {
                this.f11028t.D(z1VarR);
                J(false);
                Y();
            }
            y0(discontinuity);
            if (discontinuity != this.f11033y.f11082r) {
                s2 s2Var = this.f11033y;
                this.f11033y = O(s2Var.f11066b, discontinuity, s2Var.f11067c, discontinuity, true, 5);
            }
        } else {
            long jI = this.f11024p.i(z1VarR != this.f11028t.s());
            this.N = jI;
            long jY = z1VarR.y(jI);
            a0(this.f11033y.f11082r, jY);
            if (this.f11024p.h()) {
                s2 s2Var2 = this.f11033y;
                this.f11033y = O(s2Var2.f11066b, jY, s2Var2.f11067c, jY, true, 6);
            } else {
                this.f11033y.o(jY);
            }
        }
        this.f11033y.f11080p = this.f11028t.l().i();
        this.f11033y.f11081q = F();
        s2 s2Var3 = this.f11033y;
        if (s2Var3.f11076l && s2Var3.f11069e == 3 && l1(s2Var3.f11065a, s2Var3.f11066b) && this.f11033y.f11078n.f9222a == 1.0f) {
            float fA = this.f11030v.a(z(), F());
            if (this.f11024p.getPlaybackParameters().f9222a != fA) {
                R0(this.f11033y.f11078n.b(fA));
                M(this.f11033y.f11078n, this.f11024p.getPlaybackParameters().f9222a, false, false);
            }
        }
    }

    public final void w(w2 w2Var) {
        if (w2Var.getState() == 2) {
            w2Var.stop();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a6 A[PHI: r5 r6 r8
  0x00a6: PHI (r5v3 androidx.media3.exoplayer.source.l$b) = (r5v2 androidx.media3.exoplayer.source.l$b), (r5v6 androidx.media3.exoplayer.source.l$b) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r6v2 long) = (r6v1 long), (r6v8 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r8v3 long) = (r8v2 long), (r8v5 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f0 A[PHI: r0
  0x00f0: PHI (r0v10 androidx.media3.common.m0) = 
  (r0v9 androidx.media3.common.m0)
  (r0v9 androidx.media3.common.m0)
  (r0v14 androidx.media3.common.m0)
  (r0v14 androidx.media3.common.m0)
 binds: [B:36:0x00b5, B:38:0x00b9, B:40:0x00ca, B:42:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    public final void w0(boolean z11, boolean z12, boolean z13, boolean z14) {
        long j11;
        long j12;
        androidx.media3.common.m0 m0Var;
        androidx.media3.exoplayer.source.l.b bVar;
        this.f11017i.removeMessages(2);
        this.Q = null;
        boolean z15 = true;
        x1(false, true);
        this.f11024p.g();
        this.N = 1000000000000L;
        for (w2 w2Var : this.f11010a) {
            try {
                r(w2Var);
            } catch (ExoPlaybackException | RuntimeException e11) {
                z3.o.d("ExoPlayerImplInternal", "Disable failed.", e11);
            }
        }
        if (z11) {
            for (w2 w2Var2 : this.f11010a) {
                if (this.f11011b.remove(w2Var2)) {
                    try {
                        w2Var2.reset();
                    } catch (RuntimeException e12) {
                        z3.o.d("ExoPlayerImplInternal", "Reset failed.", e12);
                    }
                }
            }
        }
        this.L = 0;
        s2 s2Var = this.f11033y;
        androidx.media3.exoplayer.source.l.b bVar2 = s2Var.f11066b;
        long jLongValue = s2Var.f11082r;
        long j13 = (this.f11033y.f11066b.b() || V(this.f11033y, this.f11021m)) ? this.f11033y.f11067c : this.f11033y.f11082r;
        if (z12) {
            this.M = null;
            Pair<androidx.media3.exoplayer.source.l.b, Long> pairD = D(this.f11033y.f11065a);
            bVar2 = (androidx.media3.exoplayer.source.l.b) pairD.first;
            jLongValue = ((Long) pairD.second).longValue();
            boolean zEquals = bVar2.equals(this.f11033y.f11066b);
            j13 = C.TIME_UNSET;
            if (zEquals) {
                j11 = jLongValue;
                j12 = j13;
                z15 = false;
            } else {
                j11 = jLongValue;
                j12 = -9223372036854775807L;
            }
        } else {
            j11 = jLongValue;
            j12 = j13;
            z15 = false;
        }
        this.f11028t.f();
        this.F = false;
        androidx.media3.common.m0 m0VarE = this.f11033y.f11065a;
        if (z13 && (m0VarE instanceof u2)) {
            m0VarE = ((u2) m0VarE).E(this.f11029u.q());
            if (bVar2.f11210b != -1) {
                m0VarE.h(bVar2.f11209a, this.f11021m);
                if (m0VarE.n(this.f11021m.f9295c, this.f11020l).f()) {
                    m0Var = m0VarE;
                    bVar = new androidx.media3.exoplayer.source.l.b(bVar2.f11209a, bVar2.f11212d);
                } else {
                    m0Var = m0VarE;
                    bVar = bVar2;
                }
            } else {
                m0Var = m0VarE;
                bVar = bVar2;
            }
        } else {
            m0Var = m0VarE;
            bVar = bVar2;
        }
        s2 s2Var2 = this.f11033y;
        int i11 = s2Var2.f11069e;
        ExoPlaybackException exoPlaybackException = z14 ? null : s2Var2.f11070f;
        p4.k0 k0Var = z15 ? p4.k0.f73571d : s2Var2.f11072h;
        s4.f0 f0Var = z15 ? this.f11014f : s2Var2.f11073i;
        List listOf = z15 ? ImmutableList.of() : s2Var2.f11074j;
        s2 s2Var3 = this.f11033y;
        this.f11033y = new s2(m0Var, bVar, j12, j11, i11, exoPlaybackException, false, k0Var, f0Var, listOf, bVar, s2Var3.f11076l, s2Var3.f11077m, s2Var3.f11078n, j11, 0L, j11, 0L, false);
        if (z13) {
            this.f11029u.z();
        }
    }

    public final void w1(androidx.media3.common.m0 m0Var, androidx.media3.exoplayer.source.l.b bVar, androidx.media3.common.m0 m0Var2, androidx.media3.exoplayer.source.l.b bVar2, long j11, boolean z11) throws ExoPlaybackException {
        if (!l1(m0Var, bVar)) {
            androidx.media3.common.g0 g0Var = bVar.b() ? androidx.media3.common.g0.f9218d : this.f11033y.f11078n;
            if (this.f11024p.getPlaybackParameters().equals(g0Var)) {
                return;
            }
            R0(g0Var);
            M(this.f11033y.f11078n, g0Var.f9222a, false, false);
            return;
        }
        m0Var.n(m0Var.h(bVar.f11209a, this.f11021m).f9295c, this.f11020l);
        this.f11030v.e((androidx.media3.common.b0.g) z3.u0.i(this.f11020l.f9319k));
        if (j11 != C.TIME_UNSET) {
            this.f11030v.d(B(m0Var, bVar.f11209a, j11));
            return;
        }
        if (!z3.u0.c(!m0Var2.q() ? m0Var2.n(m0Var2.h(bVar2.f11209a, this.f11021m).f9295c, this.f11020l).f9309a : null, this.f11020l.f9309a) || z11) {
            this.f11030v.d(C.TIME_UNSET);
        }
    }

    public void x(long j11) {
        this.R = j11;
    }

    public final void x0() {
        z1 z1VarR = this.f11028t.r();
        this.C = z1VarR != null && z1VarR.f11775f.f9831h && this.B;
    }

    public final void x1(boolean z11, boolean z12) {
        this.D = z11;
        this.E = z12 ? C.TIME_UNSET : this.f11026r.elapsedRealtime();
    }

    public final ImmutableList<Metadata> y(s4.z[] zVarArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z11 = false;
        for (s4.z zVar : zVarArr) {
            if (zVar != null) {
                Metadata metadata = zVar.getFormat(0).f9499k;
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

    public final void y0(long j11) throws ExoPlaybackException {
        z1 z1VarR = this.f11028t.r();
        long jZ = z1VarR == null ? j11 + 1000000000000L : z1VarR.z(j11);
        this.N = jZ;
        this.f11024p.d(jZ);
        for (w2 w2Var : this.f11010a) {
            if (T(w2Var)) {
                w2Var.resetPosition(this.N);
            }
        }
        i0();
    }

    public final void y1(float f11) {
        for (z1 z1VarR = this.f11028t.r(); z1VarR != null; z1VarR = z1VarR.j()) {
            for (s4.z zVar : z1VarR.o().f76010c) {
                if (zVar != null) {
                    zVar.onPlaybackSpeed(f11);
                }
            }
        }
    }

    public final long z() {
        s2 s2Var = this.f11033y;
        return B(s2Var.f11065a, s2Var.f11066b.f11209a, s2Var.f11082r);
    }

    public final synchronized void z1(com.google.common.base.q<Boolean> qVar, long j11) {
        long jElapsedRealtime = this.f11026r.elapsedRealtime() + j11;
        boolean z11 = false;
        while (!qVar.get2().booleanValue() && j11 > 0) {
            try {
                this.f11026r.a();
                wait(j11);
            } catch (InterruptedException unused) {
                z11 = true;
            }
            j11 = jElapsedRealtime - this.f11026r.elapsedRealtime();
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }
}
