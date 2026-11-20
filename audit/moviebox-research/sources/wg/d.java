package wg;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.Map;
import tg.a0;
import tg.b0;
import tg.e0;
import tg.l;
import tg.m;
import tg.n;
import tg.q;
import tg.r;
import tg.s;
import tg.t;
import tg.u;
import tg.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements l {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final r f79419o = new r() { // from class: wg.c
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return d.i();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f79420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f79421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f79422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s.a f79423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f79424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e0 f79425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f79426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Metadata f79427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public v f79428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f79429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f79430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f79431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f79432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f79433n;

    public d() {
        this(0);
    }

    public d(int i11) {
        this.f79420a = new byte[42];
        this.f79421b = new c0(new byte[32768], 0);
        this.f79422c = (i11 & 1) != 0;
        this.f79423d = new s.a();
        this.f79426g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] i() {
        return new l[]{new d()};
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        t.c(mVar, false);
        return t.a(mVar);
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        int i11 = this.f79426g;
        if (i11 == 0) {
            l(mVar);
            return 0;
        }
        if (i11 == 1) {
            h(mVar);
            return 0;
        }
        if (i11 == 2) {
            n(mVar);
            return 0;
        }
        if (i11 == 3) {
            m(mVar);
            return 0;
        }
        if (i11 == 4) {
            f(mVar);
            return 0;
        }
        if (i11 == 5) {
            return k(mVar, a0Var);
        }
        throw new IllegalStateException();
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f79424e = nVar;
        this.f79425f = nVar.track(0, 1);
        nVar.endTracks();
    }

    public final long e(c0 c0Var, boolean z11) {
        boolean zD;
        com.google.android.exoplayer2.util.a.e(this.f79428i);
        int iE = c0Var.e();
        while (iE <= c0Var.f() - 16) {
            c0Var.P(iE);
            if (s.d(c0Var, this.f79428i, this.f79430k, this.f79423d)) {
                c0Var.P(iE);
                return this.f79423d.f77076a;
            }
            iE++;
        }
        if (!z11) {
            c0Var.P(iE);
            return -1L;
        }
        while (iE <= c0Var.f() - this.f79429j) {
            c0Var.P(iE);
            try {
                zD = s.d(c0Var, this.f79428i, this.f79430k, this.f79423d);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (c0Var.e() <= c0Var.f() && zD) {
                c0Var.P(iE);
                return this.f79423d.f77076a;
            }
            iE++;
        }
        c0Var.P(c0Var.f());
        return -1L;
    }

    public final void f(m mVar) throws IOException {
        this.f79430k = t.b(mVar);
        ((n) o0.j(this.f79424e)).g(g(mVar.getPosition(), mVar.getLength()));
        this.f79426g = 5;
    }

    public final b0 g(long j11, long j12) {
        com.google.android.exoplayer2.util.a.e(this.f79428i);
        v vVar = this.f79428i;
        if (vVar.f77090k != null) {
            return new u(vVar, j11);
        }
        if (j12 == -1 || vVar.f77089j <= 0) {
            return new b0.b(vVar.f());
        }
        b bVar = new b(vVar, this.f79430k, j11, j12);
        this.f79431l = bVar;
        return bVar.b();
    }

    public final void h(m mVar) throws IOException {
        byte[] bArr = this.f79420a;
        mVar.peekFully(bArr, 0, bArr.length);
        mVar.resetPeekPosition();
        this.f79426g = 2;
    }

    public final void j() {
        ((e0) o0.j(this.f79425f)).d((this.f79433n * 1000000) / ((long) ((v) o0.j(this.f79428i)).f77084e), 1, this.f79432m, 0, null);
    }

    public final int k(m mVar, a0 a0Var) throws IOException {
        boolean z11;
        com.google.android.exoplayer2.util.a.e(this.f79425f);
        com.google.android.exoplayer2.util.a.e(this.f79428i);
        b bVar = this.f79431l;
        if (bVar != null && bVar.d()) {
            return this.f79431l.c(mVar, a0Var);
        }
        if (this.f79433n == -1) {
            this.f79433n = s.i(mVar, this.f79428i);
            return 0;
        }
        int iF = this.f79421b.f();
        if (iF < 32768) {
            int i11 = mVar.read(this.f79421b.d(), iF, 32768 - iF);
            z11 = i11 == -1;
            if (!z11) {
                this.f79421b.O(iF + i11);
            } else if (this.f79421b.a() == 0) {
                j();
                return -1;
            }
        } else {
            z11 = false;
        }
        int iE = this.f79421b.e();
        int i12 = this.f79432m;
        int i13 = this.f79429j;
        if (i12 < i13) {
            c0 c0Var = this.f79421b;
            c0Var.Q(Math.min(i13 - i12, c0Var.a()));
        }
        long jE = e(this.f79421b, z11);
        int iE2 = this.f79421b.e() - iE;
        this.f79421b.P(iE);
        this.f79425f.c(this.f79421b, iE2);
        this.f79432m += iE2;
        if (jE != -1) {
            j();
            this.f79432m = 0;
            this.f79433n = jE;
        }
        if (this.f79421b.a() < 16) {
            int iA = this.f79421b.a();
            System.arraycopy(this.f79421b.d(), this.f79421b.e(), this.f79421b.d(), 0, iA);
            this.f79421b.P(0);
            this.f79421b.O(iA);
        }
        return 0;
    }

    public final void l(m mVar) throws IOException {
        this.f79427h = t.d(mVar, !this.f79422c);
        this.f79426g = 1;
    }

    public final void m(m mVar) throws IOException {
        t.a aVar = new t.a(this.f79428i);
        boolean zE = false;
        while (!zE) {
            zE = t.e(mVar, aVar);
            this.f79428i = (v) o0.j(aVar.f77077a);
        }
        com.google.android.exoplayer2.util.a.e(this.f79428i);
        this.f79429j = Math.max(this.f79428i.f77082c, 6);
        ((e0) o0.j(this.f79425f)).e(this.f79428i.g(this.f79420a, this.f79427h));
        this.f79426g = 4;
    }

    public final void n(m mVar) throws IOException {
        t.i(mVar);
        this.f79426g = 3;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f79426g = 0;
        } else {
            b bVar = this.f79431l;
            if (bVar != null) {
                bVar.h(j12);
            }
        }
        this.f79433n = j12 != 0 ? -1L : 0L;
        this.f79432m = 0;
        this.f79421b.L(0);
    }
}
