package q4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.source.t;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.w1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p4.e0;
import q4.i;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h<T extends i> implements e0, t, Loader.b<e>, Loader.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f74333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f74334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y[] f74335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean[] f74336d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final T f74337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t.a<h<T>> f74338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.media3.exoplayer.source.m.a f74339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f74340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Loader f74341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f74342k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<q4.a> f74343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<q4.a> f74344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s f74345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final s[] f74346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f74347p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public e f74348q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public y f74349r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public b<T> f74350s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f74351t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f74352u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f74353v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public q4.a f74354w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f74355x;

    /* JADX INFO: compiled from: source.java */
    public final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h<T> f74356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s f74357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f74358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f74359d;

        public a(h<T> hVar, s sVar, int i11) {
            this.f74356a = hVar;
            this.f74357b = sVar;
            this.f74358c = i11;
        }

        private void a() {
            if (this.f74359d) {
                return;
            }
            h.this.f74339h.h(h.this.f74334b[this.f74358c], h.this.f74335c[this.f74358c], 0, null, h.this.f74352u);
            this.f74359d = true;
        }

        public void b() {
            z3.a.g(h.this.f74336d[this.f74358c]);
            h.this.f74336d[this.f74358c] = false;
        }

        @Override // p4.e0
        public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (h.this.v()) {
                return -3;
            }
            if (h.this.f74354w != null && h.this.f74354w.g(this.f74358c + 1) <= this.f74357b.D()) {
                return -3;
            }
            a();
            return this.f74357b.T(t1Var, decoderInputBuffer, i11, h.this.f74355x);
        }

        @Override // p4.e0
        public boolean isReady() {
            return !h.this.v() && this.f74357b.L(h.this.f74355x);
        }

        @Override // p4.e0
        public void maybeThrowError() {
        }

        @Override // p4.e0
        public int skipData(long j11) {
            if (h.this.v()) {
                return 0;
            }
            int iF = this.f74357b.F(j11, h.this.f74355x);
            if (h.this.f74354w != null) {
                iF = Math.min(iF, h.this.f74354w.g(this.f74358c + 1) - this.f74357b.D());
            }
            this.f74357b.f0(iF);
            if (iF > 0) {
                a();
            }
            return iF;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T extends i> {
        void c(h<T> hVar);
    }

    public h(int i11, @Nullable int[] iArr, @Nullable y[] yVarArr, T t11, t.a<h<T>> aVar, androidx.media3.exoplayer.upstream.b bVar, long j11, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.drm.b.a aVar2, androidx.media3.exoplayer.upstream.m mVar, androidx.media3.exoplayer.source.m.a aVar3) {
        this.f74333a = i11;
        int i12 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f74334b = iArr;
        this.f74335c = yVarArr == null ? new y[0] : yVarArr;
        this.f74337f = t11;
        this.f74338g = aVar;
        this.f74339h = aVar3;
        this.f74340i = mVar;
        this.f74341j = new Loader("ChunkSampleStream");
        this.f74342k = new g();
        ArrayList<q4.a> arrayList = new ArrayList<>();
        this.f74343l = arrayList;
        this.f74344m = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.f74346o = new s[length];
        this.f74336d = new boolean[length];
        int i13 = length + 1;
        int[] iArr2 = new int[i13];
        s[] sVarArr = new s[i13];
        s sVarK = s.k(bVar, cVar, aVar2);
        this.f74345n = sVarK;
        iArr2[0] = i11;
        sVarArr[0] = sVarK;
        while (i12 < length) {
            s sVarL = s.l(bVar);
            this.f74346o[i12] = sVarL;
            int i14 = i12 + 1;
            sVarArr[i14] = sVarL;
            iArr2[i14] = this.f74334b[i12];
            i12 = i14;
        }
        this.f74347p = new c(iArr2, sVarArr);
        this.f74351t = j11;
        this.f74352u = j11;
    }

    private void D() {
        this.f74345n.W();
        for (s sVar : this.f74346o) {
            sVar.W();
        }
    }

    private void p(int i11) {
        z3.a.g(!this.f74341j.i());
        int size = this.f74343l.size();
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (!t(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return;
        }
        long j11 = s().f74329h;
        q4.a aVarQ = q(i11);
        if (this.f74343l.isEmpty()) {
            this.f74351t = this.f74352u;
        }
        this.f74355x = false;
        this.f74339h.C(this.f74333a, aVarQ.f74328g, j11);
    }

    private boolean u(e eVar) {
        return eVar instanceof q4.a;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public Loader.c k(e eVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        long jA = eVar.a();
        boolean zU = u(eVar);
        int size = this.f74343l.size() - 1;
        boolean z11 = (jA != 0 && zU && t(size)) ? false : true;
        p4.n nVar = new p4.n(eVar.f74322a, eVar.f74323b, eVar.d(), eVar.c(), j11, j12, jA);
        androidx.media3.exoplayer.upstream.m.c cVar = new androidx.media3.exoplayer.upstream.m.c(nVar, new p4.o(eVar.f74324c, this.f74333a, eVar.f74325d, eVar.f74326e, eVar.f74327f, u0.B1(eVar.f74328g), u0.B1(eVar.f74329h)), iOException, i11);
        if (!this.f74337f.c(eVar, z11, cVar, this.f74340i)) {
            cVarG = null;
        } else if (z11) {
            cVarG = Loader.f11436f;
            if (zU) {
                z3.a.g(q(size) == eVar);
                if (this.f74343l.isEmpty()) {
                    this.f74351t = this.f74352u;
                }
            }
        } else {
            z3.o.h("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            cVarG = null;
        }
        if (cVarG == null) {
            long jC = this.f74340i.c(cVar);
            cVarG = jC != C.TIME_UNSET ? Loader.g(false, jC) : Loader.f11437g;
        }
        boolean z12 = !cVarG.c();
        this.f74339h.v(nVar, eVar.f74324c, this.f74333a, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h, iOException, z12);
        if (z12) {
            this.f74348q = null;
            this.f74340i.b(eVar.f74322a);
            this.f74338g.h(this);
        }
        return cVarG;
    }

    public final int B(int i11, int i12) {
        do {
            i12++;
            if (i12 >= this.f74343l.size()) {
                return this.f74343l.size() - 1;
            }
        } while (this.f74343l.get(i12).g(0) <= i11);
        return i12 - 1;
    }

    public void C(@Nullable b<T> bVar) {
        this.f74350s = bVar;
        this.f74345n.S();
        for (s sVar : this.f74346o) {
            sVar.S();
        }
        this.f74341j.l(this);
    }

    public void E(long j11) {
        q4.a aVar;
        boolean zA0;
        this.f74352u = j11;
        if (v()) {
            this.f74351t = j11;
            return;
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 < this.f74343l.size()) {
                aVar = this.f74343l.get(i12);
                long j12 = aVar.f74328g;
                if (j12 == j11 && aVar.f74293k == C.TIME_UNSET) {
                    break;
                } else if (j12 <= j11) {
                    i12++;
                }
            }
            aVar = null;
            break;
        }
        if (aVar != null) {
            zA0 = this.f74345n.Z(aVar.g(0));
        } else {
            zA0 = this.f74345n.a0(j11, j11 < getNextLoadPositionUs());
        }
        if (zA0) {
            this.f74353v = B(this.f74345n.D(), 0);
            s[] sVarArr = this.f74346o;
            int length = sVarArr.length;
            while (i11 < length) {
                sVarArr[i11].a0(j11, true);
                i11++;
            }
            return;
        }
        this.f74351t = j11;
        this.f74355x = false;
        this.f74343l.clear();
        this.f74353v = 0;
        if (!this.f74341j.i()) {
            this.f74341j.f();
            D();
            return;
        }
        this.f74345n.r();
        s[] sVarArr2 = this.f74346o;
        int length2 = sVarArr2.length;
        while (i11 < length2) {
            sVarArr2[i11].r();
            i11++;
        }
        this.f74341j.e();
    }

    public h<T>.a F(long j11, int i11) {
        for (int i12 = 0; i12 < this.f74346o.length; i12++) {
            if (this.f74334b[i12] == i11) {
                z3.a.g(!this.f74336d[i12]);
                this.f74336d[i12] = true;
                this.f74346o[i12].a0(j11, true);
                return new a(this, this.f74346o[i12], i12);
            }
        }
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        List<q4.a> listEmptyList;
        long j11;
        if (this.f74355x || this.f74341j.i() || this.f74341j.h()) {
            return false;
        }
        boolean zV = v();
        if (zV) {
            listEmptyList = Collections.emptyList();
            j11 = this.f74351t;
        } else {
            listEmptyList = this.f74344m;
            j11 = s().f74329h;
        }
        this.f74337f.e(w1Var, j11, listEmptyList, this.f74342k);
        g gVar = this.f74342k;
        boolean z11 = gVar.f74332b;
        e eVar = gVar.f74331a;
        gVar.a();
        if (z11) {
            this.f74351t = C.TIME_UNSET;
            this.f74355x = true;
            return true;
        }
        if (eVar == null) {
            return false;
        }
        this.f74348q = eVar;
        if (u(eVar)) {
            q4.a aVar = (q4.a) eVar;
            if (zV) {
                long j12 = aVar.f74328g;
                long j13 = this.f74351t;
                if (j12 != j13) {
                    this.f74345n.c0(j13);
                    for (s sVar : this.f74346o) {
                        sVar.c0(this.f74351t);
                    }
                }
                this.f74351t = C.TIME_UNSET;
            }
            aVar.i(this.f74347p);
            this.f74343l.add(aVar);
        } else if (eVar instanceof l) {
            ((l) eVar).e(this.f74347p);
        }
        this.f74339h.z(new p4.n(eVar.f74322a, eVar.f74323b, this.f74341j.m(eVar, this, this.f74340i.a(eVar.f74324c))), eVar.f74324c, this.f74333a, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h);
        return true;
    }

    public long b(long j11, b3 b3Var) {
        return this.f74337f.b(j11, b3Var);
    }

    @Override // p4.e0
    public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (v()) {
            return -3;
        }
        q4.a aVar = this.f74354w;
        if (aVar != null && aVar.g(0) <= this.f74345n.D()) {
            return -3;
        }
        w();
        return this.f74345n.T(t1Var, decoderInputBuffer, i11, this.f74355x);
    }

    public void discardBuffer(long j11, boolean z11) {
        if (v()) {
            return;
        }
        int iY = this.f74345n.y();
        this.f74345n.q(j11, z11, true);
        int iY2 = this.f74345n.y();
        if (iY2 > iY) {
            long jZ = this.f74345n.z();
            int i11 = 0;
            while (true) {
                s[] sVarArr = this.f74346o;
                if (i11 >= sVarArr.length) {
                    break;
                }
                sVarArr[i11].q(jZ, z11, this.f74336d[i11]);
                i11++;
            }
        }
        m(iY2);
    }

    @Override // androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        if (this.f74355x) {
            return Long.MIN_VALUE;
        }
        if (v()) {
            return this.f74351t;
        }
        long jMax = this.f74352u;
        q4.a aVarS = s();
        if (!aVarS.f()) {
            if (this.f74343l.size() > 1) {
                ArrayList<q4.a> arrayList = this.f74343l;
                aVarS = arrayList.get(arrayList.size() - 2);
            } else {
                aVarS = null;
            }
        }
        if (aVarS != null) {
            jMax = Math.max(jMax, aVarS.f74329h);
        }
        return Math.max(jMax, this.f74345n.A());
    }

    @Override // androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        if (v()) {
            return this.f74351t;
        }
        if (this.f74355x) {
            return Long.MIN_VALUE;
        }
        return s().f74329h;
    }

    @Override // androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f74341j.i();
    }

    @Override // p4.e0
    public boolean isReady() {
        return !v() && this.f74345n.L(this.f74355x);
    }

    public final void m(int i11) {
        int iMin = Math.min(B(i11, 0), this.f74353v);
        if (iMin > 0) {
            u0.d1(this.f74343l, 0, iMin);
            this.f74353v -= iMin;
        }
    }

    @Override // p4.e0
    public void maybeThrowError() throws IOException {
        this.f74341j.maybeThrowError();
        this.f74345n.O();
        if (this.f74341j.i()) {
            return;
        }
        this.f74337f.maybeThrowError();
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.e
    public void onLoaderReleased() {
        this.f74345n.U();
        for (s sVar : this.f74346o) {
            sVar.U();
        }
        this.f74337f.release();
        b<T> bVar = this.f74350s;
        if (bVar != null) {
            bVar.c(this);
        }
    }

    public final q4.a q(int i11) {
        q4.a aVar = this.f74343l.get(i11);
        ArrayList<q4.a> arrayList = this.f74343l;
        u0.d1(arrayList, i11, arrayList.size());
        this.f74353v = Math.max(this.f74353v, this.f74343l.size());
        int i12 = 0;
        this.f74345n.u(aVar.g(0));
        while (true) {
            s[] sVarArr = this.f74346o;
            if (i12 >= sVarArr.length) {
                return aVar;
            }
            s sVar = sVarArr[i12];
            i12++;
            sVar.u(aVar.g(i12));
        }
    }

    public T r() {
        return this.f74337f;
    }

    @Override // androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
        if (this.f74341j.h() || v()) {
            return;
        }
        if (!this.f74341j.i()) {
            int preferredQueueSize = this.f74337f.getPreferredQueueSize(j11, this.f74344m);
            if (preferredQueueSize < this.f74343l.size()) {
                p(preferredQueueSize);
                return;
            }
            return;
        }
        e eVar = (e) z3.a.e(this.f74348q);
        if (!(u(eVar) && t(this.f74343l.size() - 1)) && this.f74337f.d(j11, eVar, this.f74344m)) {
            this.f74341j.e();
            if (u(eVar)) {
                this.f74354w = (q4.a) eVar;
            }
        }
    }

    public final q4.a s() {
        ArrayList<q4.a> arrayList = this.f74343l;
        return arrayList.get(arrayList.size() - 1);
    }

    @Override // p4.e0
    public int skipData(long j11) {
        if (v()) {
            return 0;
        }
        int iF = this.f74345n.F(j11, this.f74355x);
        q4.a aVar = this.f74354w;
        if (aVar != null) {
            iF = Math.min(iF, aVar.g(0) - this.f74345n.D());
        }
        this.f74345n.f0(iF);
        w();
        return iF;
    }

    public final boolean t(int i11) {
        int iD;
        q4.a aVar = this.f74343l.get(i11);
        if (this.f74345n.D() > aVar.g(0)) {
            return true;
        }
        int i12 = 0;
        do {
            s[] sVarArr = this.f74346o;
            if (i12 >= sVarArr.length) {
                return false;
            }
            iD = sVarArr[i12].D();
            i12++;
        } while (iD <= aVar.g(i12));
        return true;
    }

    public boolean v() {
        return this.f74351t != C.TIME_UNSET;
    }

    public final void w() {
        int iB = B(this.f74345n.D(), this.f74353v - 1);
        while (true) {
            int i11 = this.f74353v;
            if (i11 > iB) {
                return;
            }
            this.f74353v = i11 + 1;
            x(i11);
        }
    }

    public final void x(int i11) {
        q4.a aVar = this.f74343l.get(i11);
        y yVar = aVar.f74325d;
        if (!yVar.equals(this.f74349r)) {
            this.f74339h.h(this.f74333a, yVar, aVar.f74326e, aVar.f74327f, aVar.f74328g);
        }
        this.f74349r = yVar;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void o(e eVar, long j11, long j12, boolean z11) {
        this.f74348q = null;
        this.f74354w = null;
        p4.n nVar = new p4.n(eVar.f74322a, eVar.f74323b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f74340i.b(eVar.f74322a);
        this.f74339h.q(nVar, eVar.f74324c, this.f74333a, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h);
        if (z11) {
            return;
        }
        if (v()) {
            D();
        } else if (u(eVar)) {
            q(this.f74343l.size() - 1);
            if (this.f74343l.isEmpty()) {
                this.f74351t = this.f74352u;
            }
        }
        this.f74338g.h(this);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void n(e eVar, long j11, long j12) {
        this.f74348q = null;
        this.f74337f.f(eVar);
        p4.n nVar = new p4.n(eVar.f74322a, eVar.f74323b, eVar.d(), eVar.c(), j11, j12, eVar.a());
        this.f74340i.b(eVar.f74322a);
        this.f74339h.t(nVar, eVar.f74324c, this.f74333a, eVar.f74325d, eVar.f74326e, eVar.f74327f, eVar.f74328g, eVar.f74329h);
        this.f74338g.h(this);
    }
}
