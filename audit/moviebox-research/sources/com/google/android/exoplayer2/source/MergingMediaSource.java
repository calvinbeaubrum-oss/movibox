package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.k0;
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
/* JADX INFO: loaded from: classes4.dex */
public final class MergingMediaSource extends c<Integer> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final u1 f33748w = new u1.c().d("MergingMediaSource").a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f33749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f33750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i[] f33751n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j3[] f33752o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<i> f33753p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final nh.d f33754q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<Object, Long> f33755r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h0<Object, b> f33756s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f33757t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long[][] f33758u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public IllegalMergeException f33759v;

    /* JADX INFO: compiled from: source.java */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public IllegalMergeException(int i11) {
            this.reason = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a extends nh.m {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f33760d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long[] f33761f;

        public a(j3 j3Var, Map<Object, Long> map) {
            super(j3Var);
            int iT = j3Var.t();
            this.f33761f = new long[j3Var.t()];
            j3.d dVar = new j3.d();
            for (int i11 = 0; i11 < iT; i11++) {
                this.f33761f[i11] = j3Var.r(i11, dVar).f33390o;
            }
            int iM = j3Var.m();
            this.f33760d = new long[iM];
            j3.b bVar = new j3.b();
            for (int i12 = 0; i12 < iM; i12++) {
                j3Var.k(i12, bVar, true);
                long jLongValue = ((Long) com.google.android.exoplayer2.util.a.e(map.get(bVar.f33363b))).longValue();
                long[] jArr = this.f33760d;
                jLongValue = jLongValue == Long.MIN_VALUE ? bVar.f33365d : jLongValue;
                jArr[i12] = jLongValue;
                long j11 = bVar.f33365d;
                if (j11 != C.TIME_UNSET) {
                    long[] jArr2 = this.f33761f;
                    int i13 = bVar.f33364c;
                    jArr2[i13] = jArr2[i13] - (j11 - jLongValue);
                }
            }
        }

        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.b k(int i11, j3.b bVar, boolean z11) {
            super.k(i11, bVar, z11);
            bVar.f33365d = this.f33760d[i11];
            return bVar;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x001e  */
        @Override // nh.m, com.google.android.exoplayer2.j3
        public j3.d s(int i11, j3.d dVar, long j11) {
            long jMin;
            super.s(i11, dVar, j11);
            long j12 = this.f33761f[i11];
            dVar.f33390o = j12;
            if (j12 != C.TIME_UNSET) {
                long j13 = dVar.f33389n;
                if (j13 == C.TIME_UNSET) {
                    jMin = dVar.f33389n;
                } else {
                    jMin = Math.min(j13, j12);
                }
            } else {
                jMin = dVar.f33389n;
            }
            dVar.f33389n = jMin;
            return dVar;
        }
    }

    public MergingMediaSource(boolean z11, boolean z12, nh.d dVar, i... iVarArr) {
        this.f33749l = z11;
        this.f33750m = z12;
        this.f33751n = iVarArr;
        this.f33754q = dVar;
        this.f33753p = new ArrayList<>(Arrays.asList(iVarArr));
        this.f33757t = -1;
        this.f33752o = new j3[iVarArr.length];
        this.f33758u = new long[0][];
        this.f33755r = new HashMap();
        this.f33756s = MultimapBuilder.a().a().e();
    }

    public MergingMediaSource(boolean z11, boolean z12, i... iVarArr) {
        this(z11, z12, new nh.e(), iVarArr);
    }

    public MergingMediaSource(boolean z11, i... iVarArr) {
        this(z11, false, iVarArr);
    }

    public MergingMediaSource(i... iVarArr) {
        this(false, iVarArr);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void B(@Nullable k0 k0Var) {
        super.B(k0Var);
        for (int i11 = 0; i11 < this.f33751n.length; i11++) {
            K(Integer.valueOf(i11), this.f33751n[i11]);
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void D() {
        super.D();
        Arrays.fill(this.f33752o, (Object) null);
        this.f33757t = -1;
        this.f33759v = null;
        this.f33753p.clear();
        Collections.addAll(this.f33753p, this.f33751n);
    }

    public final void L() {
        j3.b bVar = new j3.b();
        for (int i11 = 0; i11 < this.f33757t; i11++) {
            long j11 = -this.f33752o[0].j(i11, bVar).q();
            int i12 = 1;
            while (true) {
                j3[] j3VarArr = this.f33752o;
                if (i12 < j3VarArr.length) {
                    this.f33758u[i11][i12] = j11 - (-j3VarArr[i12].j(i11, bVar).q());
                    i12++;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.c
    @Nullable
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public i.b F(Integer num, i.b bVar) {
        if (num.intValue() == 0) {
            return bVar;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void I(Integer num, i iVar, j3 j3Var) {
        if (this.f33759v != null) {
            return;
        }
        if (this.f33757t == -1) {
            this.f33757t = j3Var.m();
        } else if (j3Var.m() != this.f33757t) {
            this.f33759v = new IllegalMergeException(0);
            return;
        }
        if (this.f33758u.length == 0) {
            this.f33758u = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f33757t, this.f33752o.length);
        }
        this.f33753p.remove(iVar);
        this.f33752o[num.intValue()] = j3Var;
        if (this.f33753p.isEmpty()) {
            if (this.f33749l) {
                L();
            }
            j3 aVar = this.f33752o[0];
            if (this.f33750m) {
                O();
                aVar = new a(aVar, this.f33755r);
            }
            C(aVar);
        }
    }

    public final void O() {
        j3[] j3VarArr;
        j3.b bVar = new j3.b();
        for (int i11 = 0; i11 < this.f33757t; i11++) {
            long j11 = Long.MIN_VALUE;
            int i12 = 0;
            while (true) {
                j3VarArr = this.f33752o;
                if (i12 >= j3VarArr.length) {
                    break;
                }
                long jM = j3VarArr[i12].j(i11, bVar).m();
                if (jM != C.TIME_UNSET) {
                    long j12 = jM + this.f33758u[i11][i12];
                    if (j11 == Long.MIN_VALUE || j12 < j11) {
                        j11 = j12;
                    }
                }
                i12++;
            }
            Object objQ = j3VarArr[0].q(i11);
            this.f33755r.put(objQ, Long.valueOf(j11));
            Iterator<b> it = this.f33756s.get(objQ).iterator();
            while (it.hasNext()) {
                it.next().l(0L, j11);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public u1 a() {
        i[] iVarArr = this.f33751n;
        return iVarArr.length > 0 ? iVarArr[0].a() : f33748w;
    }

    @Override // com.google.android.exoplayer2.source.i
    public h e(i.b bVar, com.google.android.exoplayer2.upstream.b bVar2, long j11) {
        int length = this.f33751n.length;
        h[] hVarArr = new h[length];
        int iF = this.f33752o[0].f(bVar.f71960a);
        for (int i11 = 0; i11 < length; i11++) {
            hVarArr[i11] = this.f33751n[i11].e(bVar.c(this.f33752o[i11].q(iF)), bVar2, j11 - this.f33758u[iF][i11]);
        }
        k kVar = new k(this.f33754q, this.f33758u[iF], hVarArr);
        if (!this.f33750m) {
            return kVar;
        }
        b bVar3 = new b(kVar, true, 0L, ((Long) com.google.android.exoplayer2.util.a.e(this.f33755r.get(bVar.f71960a))).longValue());
        this.f33756s.put(bVar.f71960a, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void k(h hVar) {
        if (this.f33750m) {
            b bVar = (b) hVar;
            for (Map.Entry<Object, b> entry : this.f33756s.entries()) {
                if (entry.getValue().equals(bVar)) {
                    this.f33756s.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            hVar = bVar.f33769a;
        }
        k kVar = (k) hVar;
        int i11 = 0;
        while (true) {
            i[] iVarArr = this.f33751n;
            if (i11 >= iVarArr.length) {
                return;
            }
            iVarArr[i11].k(kVar.b(i11));
            i11++;
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.f33759v;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }
}
