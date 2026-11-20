package ph;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.w;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.List;
import qg.u1;
import tg.a0;
import tg.b0;
import tg.d0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements tg.n, g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final g.a f73788k = new g.a() { // from class: ph.d
        @Override // ph.g.a
        public final g a(int i11, m1 m1Var, boolean z11, List list, e0 e0Var, u1 u1Var) {
            return e.f(i11, m1Var, z11, list, e0Var, u1Var);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a0 f73789l = new a0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tg.l f73790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f73791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m1 f73792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<a> f73793d = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f73794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public g.b f73795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f73796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b0 f73797i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m1[] f73798j;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f73799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f73800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final m1 f73801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final tg.k f73802d = new tg.k();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public m1 f73803e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e0 f73804f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f73805g;

        public a(int i11, int i12, @Nullable m1 m1Var) {
            this.f73799a = i11;
            this.f73800b = i12;
            this.f73801c = m1Var;
        }

        @Override // tg.e0
        public int a(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11, int i12) throws IOException {
            return ((e0) o0.j(this.f73804f)).b(gVar, i11, z11);
        }

        @Override // tg.e0
        public /* synthetic */ int b(com.google.android.exoplayer2.upstream.g gVar, int i11, boolean z11) {
            return d0.a(this, gVar, i11, z11);
        }

        @Override // tg.e0
        public /* synthetic */ void c(c0 c0Var, int i11) {
            d0.b(this, c0Var, i11);
        }

        @Override // tg.e0
        public void d(long j11, int i11, int i12, int i13, @Nullable e0.a aVar) {
            long j12 = this.f73805g;
            if (j12 != C.TIME_UNSET && j11 >= j12) {
                this.f73804f = this.f73802d;
            }
            ((e0) o0.j(this.f73804f)).d(j11, i11, i12, i13, aVar);
        }

        @Override // tg.e0
        public void e(m1 m1Var) {
            m1 m1Var2 = this.f73801c;
            if (m1Var2 != null) {
                m1Var = m1Var.j(m1Var2);
            }
            this.f73803e = m1Var;
            ((e0) o0.j(this.f73804f)).e(this.f73803e);
        }

        @Override // tg.e0
        public void f(c0 c0Var, int i11, int i12) {
            ((e0) o0.j(this.f73804f)).c(c0Var, i11);
        }

        public void g(@Nullable g.b bVar, long j11) {
            if (bVar == null) {
                this.f73804f = this.f73802d;
                return;
            }
            this.f73805g = j11;
            e0 e0VarTrack = bVar.track(this.f73799a, this.f73800b);
            this.f73804f = e0VarTrack;
            m1 m1Var = this.f73803e;
            if (m1Var != null) {
                e0VarTrack.e(m1Var);
            }
        }
    }

    public e(tg.l lVar, int i11, m1 m1Var) {
        this.f73790a = lVar;
        this.f73791b = i11;
        this.f73792c = m1Var;
    }

    public static /* synthetic */ g f(int i11, m1 m1Var, boolean z11, List list, e0 e0Var, u1 u1Var) {
        tg.l gVar;
        String str = m1Var.f33444l;
        if (w.r(str)) {
            return null;
        }
        if (w.q(str)) {
            gVar = new zg.e(1);
        } else {
            gVar = new bh.g(z11 ? 4 : 0, null, null, list, e0Var);
        }
        return new e(gVar, i11, m1Var);
    }

    @Override // ph.g
    public boolean a(tg.m mVar) throws IOException {
        int iC = this.f73790a.c(mVar, f73789l);
        com.google.android.exoplayer2.util.a.g(iC != 1);
        return iC == 0;
    }

    @Override // ph.g
    @Nullable
    public tg.d b() {
        b0 b0Var = this.f73797i;
        if (b0Var instanceof tg.d) {
            return (tg.d) b0Var;
        }
        return null;
    }

    @Override // ph.g
    @Nullable
    public m1[] c() {
        return this.f73798j;
    }

    @Override // ph.g
    public void d(@Nullable g.b bVar, long j11, long j12) {
        this.f73795g = bVar;
        this.f73796h = j12;
        if (!this.f73794f) {
            this.f73790a.d(this);
            if (j11 != C.TIME_UNSET) {
                this.f73790a.seek(0L, j11);
            }
            this.f73794f = true;
            return;
        }
        tg.l lVar = this.f73790a;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        lVar.seek(0L, j11);
        for (int i11 = 0; i11 < this.f73793d.size(); i11++) {
            this.f73793d.valueAt(i11).g(bVar, j12);
        }
    }

    @Override // tg.n
    public void endTracks() {
        m1[] m1VarArr = new m1[this.f73793d.size()];
        for (int i11 = 0; i11 < this.f73793d.size(); i11++) {
            m1VarArr[i11] = (m1) com.google.android.exoplayer2.util.a.i(this.f73793d.valueAt(i11).f73803e);
        }
        this.f73798j = m1VarArr;
    }

    @Override // tg.n
    public void g(b0 b0Var) {
        this.f73797i = b0Var;
    }

    @Override // ph.g
    public void release() {
        this.f73790a.release();
    }

    @Override // tg.n
    public e0 track(int i11, int i12) {
        a aVar = this.f73793d.get(i11);
        if (aVar == null) {
            com.google.android.exoplayer2.util.a.g(this.f73798j == null);
            aVar = new a(i11, i12, i12 == this.f73791b ? this.f73792c : null);
            aVar.g(this.f73795g, this.f73796h);
            this.f73793d.put(i11, aVar);
        }
        return aVar;
    }
}
