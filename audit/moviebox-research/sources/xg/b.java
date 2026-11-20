package xg;

import android.net.Uri;
import com.google.android.exoplayer2.util.c0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;
import tg.a0;
import tg.b0;
import tg.l;
import tg.m;
import tg.n;
import tg.q;
import tg.r;
import tg.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements l {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final r f80486q = new r() { // from class: xg.a
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return b.g();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f80492f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f80494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f80495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f80496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f80497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f80498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f80499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f80500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.a f80501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.flv.b f80502p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f80487a = new c0(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f80488b = new c0(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f80489c = new c0(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f80490d = new c0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f80491e = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f80493g = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] g() {
        return new l[]{new b()};
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        mVar.peekFully(this.f80487a.d(), 0, 3);
        this.f80487a.P(0);
        if (this.f80487a.G() != 4607062) {
            return false;
        }
        mVar.peekFully(this.f80487a.d(), 0, 2);
        this.f80487a.P(0);
        if ((this.f80487a.J() & 250) != 0) {
            return false;
        }
        mVar.peekFully(this.f80487a.d(), 0, 4);
        this.f80487a.P(0);
        int iN = this.f80487a.n();
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(iN);
        mVar.peekFully(this.f80487a.d(), 0, 4);
        this.f80487a.P(0);
        return this.f80487a.n() == 0;
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f80492f);
        while (true) {
            int i11 = this.f80493g;
            if (i11 != 1) {
                if (i11 == 2) {
                    l(mVar);
                } else if (i11 != 3) {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    if (j(mVar)) {
                        return 0;
                    }
                } else if (!k(mVar)) {
                    return -1;
                }
            } else if (!i(mVar)) {
                return -1;
            }
        }
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f80492f = nVar;
    }

    public final void e() {
        if (this.f80500n) {
            return;
        }
        this.f80492f.g(new b0.b(C.TIME_UNSET));
        this.f80500n = true;
    }

    public final long f() {
        if (this.f80494h) {
            return this.f80495i + this.f80499m;
        }
        if (this.f80491e.d() == C.TIME_UNSET) {
            return 0L;
        }
        return this.f80499m;
    }

    public final c0 h(m mVar) throws IOException {
        if (this.f80498l > this.f80490d.b()) {
            c0 c0Var = this.f80490d;
            c0Var.N(new byte[Math.max(c0Var.b() * 2, this.f80498l)], 0);
        } else {
            this.f80490d.P(0);
        }
        this.f80490d.O(this.f80498l);
        mVar.readFully(this.f80490d.d(), 0, this.f80498l);
        return this.f80490d;
    }

    public final boolean i(m mVar) throws IOException {
        if (!mVar.readFully(this.f80488b.d(), 0, 9, true)) {
            return false;
        }
        this.f80488b.P(0);
        this.f80488b.Q(4);
        int iD = this.f80488b.D();
        boolean z11 = (iD & 4) != 0;
        boolean z12 = (iD & 1) != 0;
        if (z11 && this.f80501o == null) {
            this.f80501o = new com.google.android.exoplayer2.extractor.flv.a(this.f80492f.track(8, 1));
        }
        if (z12 && this.f80502p == null) {
            this.f80502p = new com.google.android.exoplayer2.extractor.flv.b(this.f80492f.track(9, 2));
        }
        this.f80492f.endTracks();
        this.f80496j = this.f80488b.n() - 5;
        this.f80493g = 2;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x008b  */
    public final boolean j(m mVar) throws IOException {
        boolean zA;
        boolean z11;
        long j11;
        long jF = f();
        int i11 = this.f80497k;
        if (i11 == 8 && this.f80501o != null) {
            e();
            zA = this.f80501o.a(h(mVar), jF);
        } else {
            if (i11 != 9 || this.f80502p == null) {
                if (i11 != 18 || this.f80500n) {
                    mVar.skipFully(this.f80498l);
                    zA = false;
                    z11 = false;
                } else {
                    zA = this.f80491e.a(h(mVar), jF);
                    long jD = this.f80491e.d();
                    if (jD != C.TIME_UNSET) {
                        this.f80492f.g(new z(this.f80491e.e(), this.f80491e.f(), jD));
                        this.f80500n = true;
                    }
                }
                if (!this.f80494h && zA) {
                    this.f80494h = true;
                    if (this.f80491e.d() == C.TIME_UNSET) {
                        j11 = -this.f80499m;
                    } else {
                        j11 = 0;
                    }
                    this.f80495i = j11;
                }
                this.f80496j = 4;
                this.f80493g = 2;
                return z11;
            }
            e();
            zA = this.f80502p.a(h(mVar), jF);
        }
        z11 = true;
        if (!this.f80494h) {
            this.f80494h = true;
            if (this.f80491e.d() == C.TIME_UNSET) {
                j11 = -this.f80499m;
            } else {
                j11 = 0;
            }
            this.f80495i = j11;
        }
        this.f80496j = 4;
        this.f80493g = 2;
        return z11;
    }

    public final boolean k(m mVar) throws IOException {
        if (!mVar.readFully(this.f80489c.d(), 0, 11, true)) {
            return false;
        }
        this.f80489c.P(0);
        this.f80497k = this.f80489c.D();
        this.f80498l = this.f80489c.G();
        this.f80499m = this.f80489c.G();
        this.f80499m = (((long) (this.f80489c.D() << 24)) | this.f80499m) * 1000;
        this.f80489c.Q(3);
        this.f80493g = 4;
        return true;
    }

    public final void l(m mVar) throws IOException {
        mVar.skipFully(this.f80496j);
        this.f80496j = 0;
        this.f80493g = 3;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f80493g = 1;
            this.f80494h = false;
        } else {
            this.f80493g = 3;
        }
        this.f80496j = 0;
    }
}
