package x5;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;
import u4.l0;
import u4.m0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements u4.s {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u4.y f79892l = new u4.y() { // from class: x5.z
        @Override // u4.y
        public /* synthetic */ u4.y a(o5.s.a aVar) {
            return u4.x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ u4.s[] b(Uri uri, Map map) {
            return u4.x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ u4.y c(boolean z11) {
            return u4.x.b(this, z11);
        }

        @Override // u4.y
        public final u4.s[] createExtractors() {
            return a0.e();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.i0 f79893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f79894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.c0 f79895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f79896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f79897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f79898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f79899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f79900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public x f79901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public u4.u f79902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f79903k;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f79904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final z3.i0 f79905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z3.b0 f79906c = new z3.b0(new byte[64]);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f79907d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f79908e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f79909f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f79910g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f79911h;

        public a(m mVar, z3.i0 i0Var) {
            this.f79904a = mVar;
            this.f79905b = i0Var;
        }

        public void a(z3.c0 c0Var) throws ParserException {
            c0Var.l(this.f79906c.f81757a, 0, 3);
            this.f79906c.p(0);
            b();
            c0Var.l(this.f79906c.f81757a, 0, this.f79910g);
            this.f79906c.p(0);
            c();
            this.f79904a.c(this.f79911h, 4);
            this.f79904a.b(c0Var);
            this.f79904a.packetFinished();
        }

        public final void b() {
            this.f79906c.r(8);
            this.f79907d = this.f79906c.g();
            this.f79908e = this.f79906c.g();
            this.f79906c.r(6);
            this.f79910g = this.f79906c.h(8);
        }

        public final void c() {
            this.f79911h = 0L;
            if (this.f79907d) {
                this.f79906c.r(4);
                long jH = ((long) this.f79906c.h(3)) << 30;
                this.f79906c.r(1);
                long jH2 = jH | ((long) (this.f79906c.h(15) << 15));
                this.f79906c.r(1);
                long jH3 = jH2 | ((long) this.f79906c.h(15));
                this.f79906c.r(1);
                if (!this.f79909f && this.f79908e) {
                    this.f79906c.r(4);
                    long jH4 = ((long) this.f79906c.h(3)) << 30;
                    this.f79906c.r(1);
                    long jH5 = jH4 | ((long) (this.f79906c.h(15) << 15));
                    this.f79906c.r(1);
                    long jH6 = jH5 | ((long) this.f79906c.h(15));
                    this.f79906c.r(1);
                    this.f79905b.b(jH6);
                    this.f79909f = true;
                }
                this.f79911h = this.f79905b.b(jH3);
            }
        }

        public void d() {
            this.f79909f = false;
            this.f79904a.seek();
        }
    }

    public a0() {
        this(new z3.i0(0L));
    }

    public a0(z3.i0 i0Var) {
        this.f79893a = i0Var;
        this.f79895c = new z3.c0(4096);
        this.f79894b = new SparseArray<>();
        this.f79896d = new y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ u4.s[] e() {
        return new u4.s[]{new a0()};
    }

    @Override // u4.s
    public boolean b(u4.t tVar) throws IOException {
        byte[] bArr = new byte[14];
        tVar.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        tVar.advancePeekPosition(bArr[13] & 7);
        tVar.peekFully(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(u4.t tVar, l0 l0Var) throws IOException {
        m nVar;
        z3.a.i(this.f79902j);
        long length = tVar.getLength();
        if (length != -1 && !this.f79896d.e()) {
            return this.f79896d.g(tVar, l0Var);
        }
        g(length);
        x xVar = this.f79901i;
        if (xVar != null && xVar.d()) {
            return this.f79901i.c(tVar, l0Var);
        }
        tVar.resetPeekPosition();
        long peekPosition = length != -1 ? length - tVar.getPeekPosition() : -1L;
        if ((peekPosition != -1 && peekPosition < 4) || !tVar.peekFully(this.f79895c.e(), 0, 4, true)) {
            return -1;
        }
        this.f79895c.U(0);
        int iQ = this.f79895c.q();
        if (iQ == 441) {
            return -1;
        }
        if (iQ == 442) {
            tVar.peekFully(this.f79895c.e(), 0, 10);
            this.f79895c.U(9);
            tVar.skipFully((this.f79895c.H() & 7) + 14);
            return 0;
        }
        if (iQ == 443) {
            tVar.peekFully(this.f79895c.e(), 0, 2);
            this.f79895c.U(0);
            tVar.skipFully(this.f79895c.N() + 6);
            return 0;
        }
        if (((iQ & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            tVar.skipFully(1);
            return 0;
        }
        int i11 = iQ & 255;
        a aVar = this.f79894b.get(i11);
        if (!this.f79897e) {
            if (aVar == null) {
                if (i11 == 189) {
                    nVar = new c();
                    this.f79898f = true;
                    this.f79900h = tVar.getPosition();
                } else if ((iQ & 224) == 192) {
                    nVar = new t();
                    this.f79898f = true;
                    this.f79900h = tVar.getPosition();
                } else if ((iQ & 240) == 224) {
                    nVar = new n();
                    this.f79899g = true;
                    this.f79900h = tVar.getPosition();
                } else {
                    nVar = null;
                }
                if (nVar != null) {
                    nVar.d(this.f79902j, new i0.d(i11, 256));
                    aVar = new a(nVar, this.f79893a);
                    this.f79894b.put(i11, aVar);
                }
            }
            if (tVar.getPosition() > ((this.f79898f && this.f79899g) ? this.f79900h + PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                this.f79897e = true;
                this.f79902j.endTracks();
            }
        }
        tVar.peekFully(this.f79895c.e(), 0, 2);
        this.f79895c.U(0);
        int iN = this.f79895c.N() + 6;
        if (aVar == null) {
            tVar.skipFully(iN);
        } else {
            this.f79895c.Q(iN);
            tVar.readFully(this.f79895c.e(), 0, iN);
            this.f79895c.U(6);
            aVar.a(this.f79895c);
            z3.c0 c0Var = this.f79895c;
            c0Var.T(c0Var.b());
        }
        return 0;
    }

    @Override // u4.s
    public void f(u4.u uVar) {
        this.f79902j = uVar;
    }

    public final void g(long j11) {
        if (this.f79903k) {
            return;
        }
        this.f79903k = true;
        if (this.f79896d.c() == C.TIME_UNSET) {
            this.f79902j.f(new m0.b(this.f79896d.c()));
            return;
        }
        x xVar = new x(this.f79896d.d(), this.f79896d.c(), j11);
        this.f79901i = xVar;
        this.f79902j.f(xVar.b());
    }

    @Override // u4.s
    public void release() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    @Override // u4.s
    public void seek(long j11, long j12) {
        boolean z11 = this.f79893a.f() == C.TIME_UNSET;
        if (!z11) {
            long jD = this.f79893a.d();
            if (jD != C.TIME_UNSET && jD != 0 && jD != j12) {
                this.f79893a.i(j12);
            }
        } else if (z11) {
            this.f79893a.i(j12);
        }
        x xVar = this.f79901i;
        if (xVar != null) {
            xVar.h(j12);
        }
        for (int i11 = 0; i11 < this.f79894b.size(); i11++) {
            this.f79894b.valueAt(i11).d();
        }
    }
}
