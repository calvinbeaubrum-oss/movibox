package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.b0;
import androidx.media3.common.m0;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.h0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class MergingMediaSource extends c<Integer> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b0 f11103v = new b0.c().d("MergingMediaSource").a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11104k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f11105l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l[] f11106m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m0[] f11107n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<l> f11108o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final p4.d f11109p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<Object, Long> f11110q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h0<Object, b> f11111r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11112s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long[][] f11113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public IllegalMergeException f11114u;

    /* JADX INFO: compiled from: source.java */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public IllegalMergeException(int i11) {
            this.reason = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a extends p4.m {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long[] f11115g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long[] f11116h;

        public a(m0 m0Var, Map<Object, Long> map) {
            super(m0Var);
            int iP = m0Var.p();
            this.f11116h = new long[m0Var.p()];
            m0.c cVar = new m0.c();
            for (int i11 = 0; i11 < iP; i11++) {
                this.f11116h[i11] = m0Var.n(i11, cVar).f9322n;
            }
            int i12 = m0Var.i();
            this.f11115g = new long[i12];
            m0.b bVar = new m0.b();
            for (int i13 = 0; i13 < i12; i13++) {
                m0Var.g(i13, bVar, true);
                long jLongValue = ((Long) z3.a.e(map.get(bVar.f9294b))).longValue();
                long[] jArr = this.f11115g;
                jLongValue = jLongValue == Long.MIN_VALUE ? bVar.f9296d : jLongValue;
                jArr[i13] = jLongValue;
                long j11 = bVar.f9296d;
                if (j11 != C.TIME_UNSET) {
                    long[] jArr2 = this.f11116h;
                    int i14 = bVar.f9295c;
                    jArr2[i14] = jArr2[i14] - (j11 - jLongValue);
                }
            }
        }

        @Override // p4.m, androidx.media3.common.m0
        public m0.b g(int i11, m0.b bVar, boolean z11) {
            super.g(i11, bVar, z11);
            bVar.f9296d = this.f11115g[i11];
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        @Override // p4.m, androidx.media3.common.m0
        public m0.c o(int i11, m0.c cVar, long j11) {
            long jMin;
            super.o(i11, cVar, j11);
            long j12 = this.f11116h[i11];
            cVar.f9322n = j12;
            if (j12 != C.TIME_UNSET) {
                long j13 = cVar.f9321m;
                if (j13 == C.TIME_UNSET) {
                    jMin = cVar.f9321m;
                } else {
                    jMin = Math.min(j13, j12);
                }
            } else {
                jMin = cVar.f9321m;
            }
            cVar.f9321m = jMin;
            return cVar;
        }
    }

    public MergingMediaSource(boolean z11, boolean z12, p4.d dVar, l... lVarArr) {
        this.f11104k = z11;
        this.f11105l = z12;
        this.f11106m = lVarArr;
        this.f11109p = dVar;
        this.f11108o = new ArrayList<>(Arrays.asList(lVarArr));
        this.f11112s = -1;
        this.f11107n = new m0[lVarArr.length];
        this.f11113t = new long[0][];
        this.f11110q = new HashMap();
        this.f11111r = MultimapBuilder.a().a().e();
    }

    public MergingMediaSource(boolean z11, boolean z12, l... lVarArr) {
        this(z11, z12, new p4.e(), lVarArr);
    }

    public MergingMediaSource(boolean z11, l... lVarArr) {
        this(z11, false, lVarArr);
    }

    public MergingMediaSource(l... lVarArr) {
        this(false, lVarArr);
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void B() {
        super.B();
        Arrays.fill(this.f11107n, (Object) null);
        this.f11112s = -1;
        this.f11114u = null;
        this.f11108o.clear();
        Collections.addAll(this.f11108o, this.f11106m);
    }

    public final void J() {
        m0.b bVar = new m0.b();
        for (int i11 = 0; i11 < this.f11112s; i11++) {
            long j11 = -this.f11107n[0].f(i11, bVar).o();
            int i12 = 1;
            while (true) {
                m0[] m0VarArr = this.f11107n;
                if (i12 < m0VarArr.length) {
                    this.f11113t[i11][i12] = j11 - (-m0VarArr[i12].f(i11, bVar).o());
                    i12++;
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.c
    @Nullable
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public l.b D(Integer num, l.b bVar) {
        if (num.intValue() == 0) {
            return bVar;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.source.c
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void G(Integer num, l lVar, m0 m0Var) {
        if (this.f11114u != null) {
            return;
        }
        if (this.f11112s == -1) {
            this.f11112s = m0Var.i();
        } else if (m0Var.i() != this.f11112s) {
            this.f11114u = new IllegalMergeException(0);
            return;
        }
        if (this.f11113t.length == 0) {
            this.f11113t = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f11112s, this.f11107n.length);
        }
        this.f11108o.remove(lVar);
        this.f11107n[num.intValue()] = m0Var;
        if (this.f11108o.isEmpty()) {
            if (this.f11104k) {
                J();
            }
            m0 aVar = this.f11107n[0];
            if (this.f11105l) {
                M();
                aVar = new a(aVar, this.f11110q);
            }
            A(aVar);
        }
    }

    public final void M() {
        m0[] m0VarArr;
        m0.b bVar = new m0.b();
        for (int i11 = 0; i11 < this.f11112s; i11++) {
            long j11 = Long.MIN_VALUE;
            int i12 = 0;
            while (true) {
                m0VarArr = this.f11107n;
                if (i12 >= m0VarArr.length) {
                    break;
                }
                long jK = m0VarArr[i12].f(i11, bVar).k();
                if (jK != C.TIME_UNSET) {
                    long j12 = jK + this.f11113t[i11][i12];
                    if (j11 == Long.MIN_VALUE || j12 < j11) {
                        j11 = j12;
                    }
                }
                i12++;
            }
            Object objM = m0VarArr[0].m(i11);
            this.f11110q.put(objM, Long.valueOf(j11));
            Iterator<b> it = this.f11111r.get(objM).iterator();
            while (it.hasNext()) {
                it.next().m(0L, j11);
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.l
    public b0 a() {
        l[] lVarArr = this.f11106m;
        return lVarArr.length > 0 ? lVarArr[0].a() : f11103v;
    }

    @Override // androidx.media3.exoplayer.source.l
    public k h(l.b bVar, androidx.media3.exoplayer.upstream.b bVar2, long j11) {
        int length = this.f11106m.length;
        k[] kVarArr = new k[length];
        int iB = this.f11107n[0].b(bVar.f11209a);
        for (int i11 = 0; i11 < length; i11++) {
            kVarArr[i11] = this.f11106m[i11].h(bVar.a(this.f11107n[i11].m(iB)), bVar2, j11 - this.f11113t[iB][i11]);
        }
        n nVar = new n(this.f11109p, this.f11113t[iB], kVarArr);
        if (!this.f11105l) {
            return nVar;
        }
        b bVar3 = new b(nVar, true, 0L, ((Long) z3.a.e(this.f11110q.get(bVar.f11209a))).longValue());
        this.f11111r.put(bVar.f11209a, bVar3);
        return bVar3;
    }

    @Override // androidx.media3.exoplayer.source.l
    public void l(k kVar) {
        if (this.f11105l) {
            b bVar = (b) kVar;
            for (Map.Entry<Object, b> entry : this.f11111r.entries()) {
                if (entry.getValue().equals(bVar)) {
                    this.f11111r.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            kVar = bVar.f11124a;
        }
        n nVar = (n) kVar;
        int i11 = 0;
        while (true) {
            l[] lVarArr = this.f11106m;
            if (i11 >= lVarArr.length) {
                return;
            }
            lVarArr[i11].l(nVar.i(i11));
            i11++;
        }
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.l
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.f11114u;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public void n(b0 b0Var) {
        this.f11106m[0].n(b0Var);
    }

    @Override // androidx.media3.exoplayer.source.a, androidx.media3.exoplayer.source.l
    public boolean q(b0 b0Var) {
        l[] lVarArr = this.f11106m;
        return lVarArr.length > 0 && lVarArr[0].q(b0Var);
    }

    @Override // androidx.media3.exoplayer.source.c, androidx.media3.exoplayer.source.a
    public void z(@Nullable c4.o oVar) {
        super.z(oVar);
        for (int i11 = 0; i11 < this.f11106m.length; i11++) {
            I(Integer.valueOf(i11), this.f11106m[i11]);
        }
    }
}
