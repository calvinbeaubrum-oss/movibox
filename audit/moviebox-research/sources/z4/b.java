package z4;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;
import u4.i0;
import u4.l0;
import u4.m0;
import u4.r;
import u4.s;
import u4.t;
import u4.u;
import u4.x;
import u4.y;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements s {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final y f81855q = new y() { // from class: z4.a
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return b.h();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f81861f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f81863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f81864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f81865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f81866k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f81867l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f81868m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f81869n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.media3.extractor.flv.a f81870o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.media3.extractor.flv.b f81871p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f81856a = new c0(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f81857b = new c0(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f81858c = new c0(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f81859d = new c0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f81860e = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f81862g = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s[] h() {
        return new s[]{new b()};
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        tVar.peekFully(this.f81856a.e(), 0, 3);
        this.f81856a.U(0);
        if (this.f81856a.K() != 4607062) {
            return false;
        }
        tVar.peekFully(this.f81856a.e(), 0, 2);
        this.f81856a.U(0);
        if ((this.f81856a.N() & 250) != 0) {
            return false;
        }
        tVar.peekFully(this.f81856a.e(), 0, 4);
        this.f81856a.U(0);
        int iQ = this.f81856a.q();
        tVar.resetPeekPosition();
        tVar.advancePeekPosition(iQ);
        tVar.peekFully(this.f81856a.e(), 0, 4);
        this.f81856a.U(0);
        return this.f81856a.q() == 0;
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        z3.a.i(this.f81861f);
        while (true) {
            int i11 = this.f81862g;
            if (i11 != 1) {
                if (i11 == 2) {
                    m(tVar);
                } else if (i11 != 3) {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    if (k(tVar)) {
                        return 0;
                    }
                } else if (!l(tVar)) {
                    return -1;
                }
            } else if (!j(tVar)) {
                return -1;
            }
        }
    }

    public final void e() {
        if (this.f81869n) {
            return;
        }
        this.f81861f.f(new m0.b(C.TIME_UNSET));
        this.f81869n = true;
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f81861f = uVar;
    }

    public final long g() {
        if (this.f81863h) {
            return this.f81864i + this.f81868m;
        }
        if (this.f81860e.d() == C.TIME_UNSET) {
            return 0L;
        }
        return this.f81868m;
    }

    public final c0 i(t tVar) throws IOException {
        if (this.f81867l > this.f81859d.b()) {
            c0 c0Var = this.f81859d;
            c0Var.S(new byte[Math.max(c0Var.b() * 2, this.f81867l)], 0);
        } else {
            this.f81859d.U(0);
        }
        this.f81859d.T(this.f81867l);
        tVar.readFully(this.f81859d.e(), 0, this.f81867l);
        return this.f81859d;
    }

    public final boolean j(t tVar) throws IOException {
        if (!tVar.readFully(this.f81857b.e(), 0, 9, true)) {
            return false;
        }
        this.f81857b.U(0);
        this.f81857b.V(4);
        int iH = this.f81857b.H();
        boolean z11 = (iH & 4) != 0;
        boolean z12 = (iH & 1) != 0;
        if (z11 && this.f81870o == null) {
            this.f81870o = new androidx.media3.extractor.flv.a(this.f81861f.track(8, 1));
        }
        if (z12 && this.f81871p == null) {
            this.f81871p = new androidx.media3.extractor.flv.b(this.f81861f.track(9, 2));
        }
        this.f81861f.endTracks();
        this.f81865j = this.f81857b.q() - 5;
        this.f81862g = 2;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x008b  */
    public final boolean k(t tVar) throws IOException {
        boolean zA;
        boolean z11;
        long j11;
        long jG = g();
        int i11 = this.f81866k;
        if (i11 == 8 && this.f81870o != null) {
            e();
            zA = this.f81870o.a(i(tVar), jG);
        } else {
            if (i11 != 9 || this.f81871p == null) {
                if (i11 != 18 || this.f81869n) {
                    tVar.skipFully(this.f81867l);
                    zA = false;
                    z11 = false;
                } else {
                    zA = this.f81860e.a(i(tVar), jG);
                    long jD = this.f81860e.d();
                    if (jD != C.TIME_UNSET) {
                        this.f81861f.f(new i0(this.f81860e.e(), this.f81860e.f(), jD));
                        this.f81869n = true;
                    }
                }
                if (!this.f81863h && zA) {
                    this.f81863h = true;
                    if (this.f81860e.d() == C.TIME_UNSET) {
                        j11 = -this.f81868m;
                    } else {
                        j11 = 0;
                    }
                    this.f81864i = j11;
                }
                this.f81865j = 4;
                this.f81862g = 2;
                return z11;
            }
            e();
            zA = this.f81871p.a(i(tVar), jG);
        }
        z11 = true;
        if (!this.f81863h) {
            this.f81863h = true;
            if (this.f81860e.d() == C.TIME_UNSET) {
                j11 = -this.f81868m;
            } else {
                j11 = 0;
            }
            this.f81864i = j11;
        }
        this.f81865j = 4;
        this.f81862g = 2;
        return z11;
    }

    public final boolean l(t tVar) throws IOException {
        if (!tVar.readFully(this.f81858c.e(), 0, 11, true)) {
            return false;
        }
        this.f81858c.U(0);
        this.f81866k = this.f81858c.H();
        this.f81867l = this.f81858c.K();
        this.f81868m = this.f81858c.K();
        this.f81868m = (((long) (this.f81858c.H() << 24)) | this.f81868m) * 1000;
        this.f81858c.V(3);
        this.f81862g = 4;
        return true;
    }

    public final void m(t tVar) throws IOException {
        tVar.skipFully(this.f81865j);
        this.f81865j = 0;
        this.f81862g = 3;
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f81862g = 1;
            this.f81863h = false;
        } else {
            this.f81862g = 3;
        }
        this.f81865j = 0;
    }
}
