package ph;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nh.d0;
import ph.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i<T extends j> implements d0, q, Loader.b<f>, Loader.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f73818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1[] f73819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean[] f73820d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final T f73821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q.a<i<T>> f73822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.j.a f73823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z f73824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Loader f73825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f73826k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<ph.a> f73827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<ph.a> f73828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.p f73829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.p[] f73830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f73831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public f f73832q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public m1 f73833r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public b<T> f73834s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f73835t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f73836u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f73837v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public ph.a f73838w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f73839x;

    /* JADX INFO: compiled from: source.java */
    public final class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i<T> f73840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.p f73841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f73842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f73843d;

        public a(i<T> iVar, com.google.android.exoplayer2.source.p pVar, int i11) {
            this.f73840a = iVar;
            this.f73841b = pVar;
            this.f73842c = i11;
        }

        private void a() {
            if (this.f73843d) {
                return;
            }
            i.this.f73823h.i(i.this.f73818b[this.f73842c], i.this.f73819c[this.f73842c], 0, null, i.this.f73836u);
            this.f73843d = true;
        }

        @Override // nh.d0
        public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (i.this.u()) {
                return -3;
            }
            if (i.this.f73838w != null && i.this.f73838w.g(this.f73842c + 1) <= this.f73841b.C()) {
                return -3;
            }
            a();
            return this.f73841b.S(n1Var, decoderInputBuffer, i11, i.this.f73839x);
        }

        public void c() {
            com.google.android.exoplayer2.util.a.g(i.this.f73820d[this.f73842c]);
            i.this.f73820d[this.f73842c] = false;
        }

        @Override // nh.d0
        public boolean isReady() {
            return !i.this.u() && this.f73841b.K(i.this.f73839x);
        }

        @Override // nh.d0
        public void maybeThrowError() {
        }

        @Override // nh.d0
        public int skipData(long j11) {
            if (i.this.u()) {
                return 0;
            }
            int iE = this.f73841b.E(j11, i.this.f73839x);
            if (i.this.f73838w != null) {
                iE = Math.min(iE, i.this.f73838w.g(this.f73842c + 1) - this.f73841b.C());
            }
            this.f73841b.e0(iE);
            if (iE > 0) {
                a();
            }
            return iE;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T extends j> {
        void b(i<T> iVar);
    }

    public i(int i11, @Nullable int[] iArr, @Nullable m1[] m1VarArr, T t11, q.a<i<T>> aVar, com.google.android.exoplayer2.upstream.b bVar, long j11, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.drm.b.a aVar2, z zVar, com.google.android.exoplayer2.source.j.a aVar3) {
        this.f73817a = i11;
        int i12 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f73818b = iArr;
        this.f73819c = m1VarArr == null ? new m1[0] : m1VarArr;
        this.f73821f = t11;
        this.f73822g = aVar;
        this.f73823h = aVar3;
        this.f73824i = zVar;
        this.f73825j = new Loader("ChunkSampleStream");
        this.f73826k = new h();
        ArrayList<ph.a> arrayList = new ArrayList<>();
        this.f73827l = arrayList;
        this.f73828m = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f73830o = new com.google.android.exoplayer2.source.p[length];
        this.f73820d = new boolean[length];
        int i13 = length + 1;
        int[] iArr2 = new int[i13];
        com.google.android.exoplayer2.source.p[] pVarArr = new com.google.android.exoplayer2.source.p[i13];
        com.google.android.exoplayer2.source.p pVarK = com.google.android.exoplayer2.source.p.k(bVar, cVar, aVar2);
        this.f73829n = pVarK;
        iArr2[0] = i11;
        pVarArr[0] = pVarK;
        while (i12 < length) {
            com.google.android.exoplayer2.source.p pVarL = com.google.android.exoplayer2.source.p.l(bVar);
            this.f73830o[i12] = pVarL;
            int i14 = i12 + 1;
            pVarArr[i14] = pVarL;
            iArr2[i14] = this.f73818b[i12];
            i12 = i14;
        }
        this.f73831p = new c(iArr2, pVarArr);
        this.f73835t = j11;
        this.f73836u = j11;
    }

    public final int A(int i11, int i12) {
        do {
            i12++;
            if (i12 >= this.f73827l.size()) {
                return this.f73827l.size() - 1;
            }
        } while (this.f73827l.get(i12).g(0) <= i11);
        return i12 - 1;
    }

    public void B() {
        C(null);
    }

    public void C(@Nullable b<T> bVar) {
        this.f73834s = bVar;
        this.f73829n.R();
        for (com.google.android.exoplayer2.source.p pVar : this.f73830o) {
            pVar.R();
        }
        this.f73825j.l(this);
    }

    public final void D() {
        this.f73829n.V();
        for (com.google.android.exoplayer2.source.p pVar : this.f73830o) {
            pVar.V();
        }
    }

    public void E(long j11) {
        ph.a aVar;
        boolean Z;
        this.f73836u = j11;
        if (u()) {
            this.f73835t = j11;
            return;
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 < this.f73827l.size()) {
                aVar = this.f73827l.get(i12);
                long j12 = aVar.f73812g;
                if (j12 == j11 && aVar.f73779k == C.TIME_UNSET) {
                    break;
                } else if (j12 <= j11) {
                    i12++;
                }
            }
            aVar = null;
            break;
        }
        if (aVar != null) {
            Z = this.f73829n.Y(aVar.g(0));
        } else {
            Z = this.f73829n.Z(j11, j11 < getNextLoadPositionUs());
        }
        if (Z) {
            this.f73837v = A(this.f73829n.C(), 0);
            com.google.android.exoplayer2.source.p[] pVarArr = this.f73830o;
            int length = pVarArr.length;
            while (i11 < length) {
                pVarArr[i11].Z(j11, true);
                i11++;
            }
            return;
        }
        this.f73835t = j11;
        this.f73839x = false;
        this.f73827l.clear();
        this.f73837v = 0;
        if (!this.f73825j.i()) {
            this.f73825j.f();
            D();
            return;
        }
        this.f73829n.r();
        com.google.android.exoplayer2.source.p[] pVarArr2 = this.f73830o;
        int length2 = pVarArr2.length;
        while (i11 < length2) {
            pVarArr2[i11].r();
            i11++;
        }
        this.f73825j.e();
    }

    public i<T>.a F(long j11, int i11) {
        for (int i12 = 0; i12 < this.f73830o.length; i12++) {
            if (this.f73818b[i12] == i11) {
                com.google.android.exoplayer2.util.a.g(!this.f73820d[i12]);
                this.f73820d[i12] = true;
                this.f73830o[i12].Z(j11, true);
                return new a(this, this.f73830o[i12], i12);
            }
        }
        throw new IllegalStateException();
    }

    public long a(long j11, b3 b3Var) {
        return this.f73821f.a(j11, b3Var);
    }

    @Override // nh.d0
    public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (u()) {
            return -3;
        }
        ph.a aVar = this.f73838w;
        if (aVar != null && aVar.g(0) <= this.f73829n.C()) {
            return -3;
        }
        v();
        return this.f73829n.S(n1Var, decoderInputBuffer, i11, this.f73839x);
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        List<ph.a> listEmptyList;
        long j12;
        if (this.f73839x || this.f73825j.i() || this.f73825j.h()) {
            return false;
        }
        boolean zU = u();
        if (zU) {
            listEmptyList = Collections.emptyList();
            j12 = this.f73835t;
        } else {
            listEmptyList = this.f73828m;
            j12 = r().f73813h;
        }
        this.f73821f.g(j11, j12, listEmptyList, this.f73826k);
        h hVar = this.f73826k;
        boolean z11 = hVar.f73816b;
        f fVar = hVar.f73815a;
        hVar.a();
        if (z11) {
            this.f73835t = C.TIME_UNSET;
            this.f73839x = true;
            return true;
        }
        if (fVar == null) {
            return false;
        }
        this.f73832q = fVar;
        if (t(fVar)) {
            ph.a aVar = (ph.a) fVar;
            if (zU) {
                long j13 = aVar.f73812g;
                long j14 = this.f73835t;
                if (j13 != j14) {
                    this.f73829n.b0(j14);
                    for (com.google.android.exoplayer2.source.p pVar : this.f73830o) {
                        pVar.b0(this.f73835t);
                    }
                }
                this.f73835t = C.TIME_UNSET;
            }
            aVar.i(this.f73831p);
            this.f73827l.add(aVar);
        } else if (fVar instanceof m) {
            ((m) fVar).e(this.f73831p);
        }
        this.f73823h.A(new nh.n(fVar.f73806a, fVar.f73807b, this.f73825j.m(fVar, this, this.f73824i.a(fVar.f73808c))), fVar.f73808c, this.f73817a, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h);
        return true;
    }

    public void discardBuffer(long j11, boolean z11) {
        if (u()) {
            return;
        }
        int iX = this.f73829n.x();
        this.f73829n.q(j11, z11, true);
        int iX2 = this.f73829n.x();
        if (iX2 > iX) {
            long jY = this.f73829n.y();
            int i11 = 0;
            while (true) {
                com.google.android.exoplayer2.source.p[] pVarArr = this.f73830o;
                if (i11 >= pVarArr.length) {
                    break;
                }
                pVarArr[i11].q(jY, z11, this.f73820d[i11]);
                i11++;
            }
        }
        m(iX2);
    }

    @Override // com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        if (this.f73839x) {
            return Long.MIN_VALUE;
        }
        if (u()) {
            return this.f73835t;
        }
        long jMax = this.f73836u;
        ph.a aVarR = r();
        if (!aVarR.f()) {
            if (this.f73827l.size() > 1) {
                ArrayList<ph.a> arrayList = this.f73827l;
                aVarR = arrayList.get(arrayList.size() - 2);
            } else {
                aVarR = null;
            }
        }
        if (aVarR != null) {
            jMax = Math.max(jMax, aVarR.f73813h);
        }
        return Math.max(jMax, this.f73829n.z());
    }

    @Override // com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        if (u()) {
            return this.f73835t;
        }
        if (this.f73839x) {
            return Long.MIN_VALUE;
        }
        return r().f73813h;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f73825j.i();
    }

    @Override // nh.d0
    public boolean isReady() {
        return !u() && this.f73829n.K(this.f73839x);
    }

    public final void m(int i11) {
        int iMin = Math.min(A(i11, 0), this.f73837v);
        if (iMin > 0) {
            o0.N0(this.f73827l, 0, iMin);
            this.f73837v -= iMin;
        }
    }

    @Override // nh.d0
    public void maybeThrowError() throws IOException {
        this.f73825j.maybeThrowError();
        this.f73829n.N();
        if (this.f73825j.i()) {
            return;
        }
        this.f73821f.maybeThrowError();
    }

    public final void o(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f73825j.i());
        int size = this.f73827l.size();
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (!s(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j11 = r().f73813h;
        ph.a aVarP = p(i11);
        if (this.f73827l.isEmpty()) {
            this.f73835t = this.f73836u;
        }
        this.f73839x = false;
        this.f73823h.D(this.f73817a, aVarP.f73812g, j11);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void onLoaderReleased() {
        this.f73829n.T();
        for (com.google.android.exoplayer2.source.p pVar : this.f73830o) {
            pVar.T();
        }
        this.f73821f.release();
        b<T> bVar = this.f73834s;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    public final ph.a p(int i11) {
        ph.a aVar = this.f73827l.get(i11);
        ArrayList<ph.a> arrayList = this.f73827l;
        o0.N0(arrayList, i11, arrayList.size());
        this.f73837v = Math.max(this.f73837v, this.f73827l.size());
        int i12 = 0;
        this.f73829n.u(aVar.g(0));
        while (true) {
            com.google.android.exoplayer2.source.p[] pVarArr = this.f73830o;
            if (i12 >= pVarArr.length) {
                return aVar;
            }
            com.google.android.exoplayer2.source.p pVar = pVarArr[i12];
            i12++;
            pVar.u(aVar.g(i12));
        }
    }

    public T q() {
        return this.f73821f;
    }

    public final ph.a r() {
        ArrayList<ph.a> arrayList = this.f73827l;
        return arrayList.get(arrayList.size() - 1);
    }

    @Override // com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
        if (this.f73825j.h() || u()) {
            return;
        }
        if (!this.f73825j.i()) {
            int preferredQueueSize = this.f73821f.getPreferredQueueSize(j11, this.f73828m);
            if (preferredQueueSize < this.f73827l.size()) {
                o(preferredQueueSize);
                return;
            }
            return;
        }
        f fVar = (f) com.google.android.exoplayer2.util.a.e(this.f73832q);
        if (!(t(fVar) && s(this.f73827l.size() - 1)) && this.f73821f.h(j11, fVar, this.f73828m)) {
            this.f73825j.e();
            if (t(fVar)) {
                this.f73838w = (ph.a) fVar;
            }
        }
    }

    public final boolean s(int i11) {
        int iC;
        ph.a aVar = this.f73827l.get(i11);
        if (this.f73829n.C() > aVar.g(0)) {
            return true;
        }
        int i12 = 0;
        do {
            com.google.android.exoplayer2.source.p[] pVarArr = this.f73830o;
            if (i12 >= pVarArr.length) {
                return false;
            }
            iC = pVarArr[i12].C();
            i12++;
        } while (iC <= aVar.g(i12));
        return true;
    }

    @Override // nh.d0
    public int skipData(long j11) {
        if (u()) {
            return 0;
        }
        int iE = this.f73829n.E(j11, this.f73839x);
        ph.a aVar = this.f73838w;
        if (aVar != null) {
            iE = Math.min(iE, aVar.g(0) - this.f73829n.C());
        }
        this.f73829n.e0(iE);
        v();
        return iE;
    }

    public final boolean t(f fVar) {
        return fVar instanceof ph.a;
    }

    public boolean u() {
        return this.f73835t != C.TIME_UNSET;
    }

    public final void v() {
        int iA = A(this.f73829n.C(), this.f73837v - 1);
        while (true) {
            int i11 = this.f73837v;
            if (i11 > iA) {
                return;
            }
            this.f73837v = i11 + 1;
            w(i11);
        }
    }

    public final void w(int i11) {
        ph.a aVar = this.f73827l.get(i11);
        m1 m1Var = aVar.f73809d;
        if (!m1Var.equals(this.f73833r)) {
            this.f73823h.i(this.f73817a, m1Var, aVar.f73810e, aVar.f73811f, aVar.f73812g);
        }
        this.f73833r = m1Var;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void j(f fVar, long j11, long j12, boolean z11) {
        this.f73832q = null;
        this.f73838w = null;
        nh.n nVar = new nh.n(fVar.f73806a, fVar.f73807b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f73824i.b(fVar.f73806a);
        this.f73823h.r(nVar, fVar.f73808c, this.f73817a, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h);
        if (z11) {
            return;
        }
        if (u()) {
            D();
        } else if (t(fVar)) {
            p(this.f73827l.size() - 1);
            if (this.f73827l.isEmpty()) {
                this.f73835t = this.f73836u;
            }
        }
        this.f73822g.g(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void l(f fVar, long j11, long j12) {
        this.f73832q = null;
        this.f73821f.d(fVar);
        nh.n nVar = new nh.n(fVar.f73806a, fVar.f73807b, fVar.d(), fVar.c(), j11, j12, fVar.a());
        this.f73824i.b(fVar.f73806a);
        this.f73823h.u(nVar, fVar.f73808c, this.f73817a, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h);
        this.f73822g.g(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Loader.c n(f fVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        long jA = fVar.a();
        boolean zT = t(fVar);
        int size = this.f73827l.size() - 1;
        boolean z11 = (jA != 0 && zT && s(size)) ? false : true;
        nh.n nVar = new nh.n(fVar.f73806a, fVar.f73807b, fVar.d(), fVar.c(), j11, j12, jA);
        z.c cVar = new z.c(nVar, new nh.o(fVar.f73808c, this.f73817a, fVar.f73809d, fVar.f73810e, fVar.f73811f, o0.f1(fVar.f73812g), o0.f1(fVar.f73813h)), iOException, i11);
        if (!this.f73821f.e(fVar, z11, cVar, this.f73824i)) {
            cVarG = null;
        } else if (z11) {
            cVarG = Loader.f35231f;
            if (zT) {
                com.google.android.exoplayer2.util.a.g(p(size) == fVar);
                if (this.f73827l.isEmpty()) {
                    this.f73835t = this.f73836u;
                }
            }
        } else {
            s.i("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            cVarG = null;
        }
        if (cVarG == null) {
            long jC = this.f73824i.c(cVar);
            cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f35232g;
        }
        boolean z12 = !cVarG.c();
        this.f73823h.w(nVar, fVar.f73808c, this.f73817a, fVar.f73809d, fVar.f73810e, fVar.f73811f, fVar.f73812g, fVar.f73813h, iOException, z12);
        if (z12) {
            this.f73832q = null;
            this.f73824i.b(fVar.f73806a);
            this.f73822g.g(this);
        }
        return cVarG;
    }
}
