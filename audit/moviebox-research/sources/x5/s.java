package x5;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f80203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f80204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.c0 f80205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z3.b0 f80206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r0 f80207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f80208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.media3.common.y f80209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f80210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f80211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f80212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f80213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f80214l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f80215m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f80216n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f80217o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f80218p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f80219q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f80220r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f80221s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f80222t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f80223u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public String f80224v;

    public s(@Nullable String str, int i11) {
        this.f80203a = str;
        this.f80204b = i11;
        z3.c0 c0Var = new z3.c0(1024);
        this.f80205c = c0Var;
        this.f80206d = new z3.b0(c0Var.e());
        this.f80214l = C.TIME_UNSET;
    }

    public static long a(z3.b0 b0Var) {
        return b0Var.h((b0Var.h(2) + 1) * 8);
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) throws ParserException {
        z3.a.i(this.f80207e);
        while (c0Var.a() > 0) {
            int i11 = this.f80210h;
            if (i11 != 0) {
                if (i11 == 1) {
                    int iH = c0Var.H();
                    if ((iH & 224) == 224) {
                        this.f80213k = iH;
                        this.f80210h = 2;
                    } else if (iH != 86) {
                        this.f80210h = 0;
                    }
                } else if (i11 == 2) {
                    int iH2 = ((this.f80213k & (-225)) << 8) | c0Var.H();
                    this.f80212j = iH2;
                    if (iH2 > this.f80205c.e().length) {
                        k(this.f80212j);
                    }
                    this.f80211i = 0;
                    this.f80210h = 3;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c0Var.a(), this.f80212j - this.f80211i);
                    c0Var.l(this.f80206d.f81757a, this.f80211i, iMin);
                    int i12 = this.f80211i + iMin;
                    this.f80211i = i12;
                    if (i12 == this.f80212j) {
                        this.f80206d.p(0);
                        e(this.f80206d);
                        this.f80210h = 0;
                    }
                }
            } else if (c0Var.H() == 86) {
                this.f80210h = 1;
            }
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80214l = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80207e = uVar.track(dVar.c(), 1);
        this.f80208f = dVar.b();
    }

    public final void e(z3.b0 b0Var) throws ParserException {
        if (!b0Var.g()) {
            this.f80215m = true;
            j(b0Var);
        } else if (!this.f80215m) {
            return;
        }
        if (this.f80216n != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (this.f80217o != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        i(b0Var, h(b0Var));
        if (this.f80219q) {
            b0Var.r((int) this.f80220r);
        }
    }

    public final int f(z3.b0 b0Var) throws ParserException {
        int iB = b0Var.b();
        u4.a.b bVarD = u4.a.d(b0Var, true);
        this.f80224v = bVarD.f78196c;
        this.f80221s = bVarD.f78194a;
        this.f80223u = bVarD.f78195b;
        return iB - b0Var.b();
    }

    public final void g(z3.b0 b0Var) {
        int iH = b0Var.h(3);
        this.f80218p = iH;
        if (iH == 0) {
            b0Var.r(8);
            return;
        }
        if (iH == 1) {
            b0Var.r(9);
            return;
        }
        if (iH == 3 || iH == 4 || iH == 5) {
            b0Var.r(6);
        } else {
            if (iH != 6 && iH != 7) {
                throw new IllegalStateException();
            }
            b0Var.r(1);
        }
    }

    public final int h(z3.b0 b0Var) throws ParserException {
        int iH;
        if (this.f80218p != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        int i11 = 0;
        do {
            iH = b0Var.h(8);
            i11 += iH;
        } while (iH == 255);
        return i11;
    }

    public final void i(z3.b0 b0Var, int i11) {
        int iE = b0Var.e();
        if ((iE & 7) == 0) {
            this.f80205c.U(iE >> 3);
        } else {
            b0Var.i(this.f80205c.e(), 0, i11 * 8);
            this.f80205c.U(0);
        }
        this.f80207e.c(this.f80205c, i11);
        z3.a.g(this.f80214l != C.TIME_UNSET);
        this.f80207e.f(this.f80214l, 1, i11, 0, null);
        this.f80214l += this.f80222t;
    }

    public final void j(z3.b0 b0Var) throws ParserException {
        boolean zG;
        int iH = b0Var.h(1);
        int iH2 = iH == 1 ? b0Var.h(1) : 0;
        this.f80216n = iH2;
        if (iH2 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (iH == 1) {
            a(b0Var);
        }
        if (!b0Var.g()) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        this.f80217o = b0Var.h(6);
        int iH3 = b0Var.h(4);
        int iH4 = b0Var.h(3);
        if (iH3 != 0 || iH4 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (iH == 0) {
            int iE = b0Var.e();
            int iF = f(b0Var);
            b0Var.p(iE);
            byte[] bArr = new byte[(iF + 7) / 8];
            b0Var.i(bArr, 0, iF);
            androidx.media3.common.y yVarI = new androidx.media3.common.y.b().X(this.f80208f).k0(MimeTypes.AUDIO_AAC).M(this.f80224v).L(this.f80223u).l0(this.f80221s).Y(Collections.singletonList(bArr)).b0(this.f80203a).i0(this.f80204b).I();
            if (!yVarI.equals(this.f80209g)) {
                this.f80209g = yVarI;
                this.f80222t = 1024000000 / ((long) yVarI.A);
                this.f80207e.b(yVarI);
            }
        } else {
            b0Var.r(((int) a(b0Var)) - f(b0Var));
        }
        g(b0Var);
        boolean zG2 = b0Var.g();
        this.f80219q = zG2;
        this.f80220r = 0L;
        if (zG2) {
            if (iH == 1) {
                this.f80220r = a(b0Var);
            } else {
                do {
                    zG = b0Var.g();
                    this.f80220r = (this.f80220r << 8) + ((long) b0Var.h(8));
                } while (zG);
            }
        }
        if (b0Var.g()) {
            b0Var.r(8);
        }
    }

    public final void k(int i11) {
        this.f80205c.Q(i11);
        this.f80206d.n(this.f80205c.e());
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        this.f80210h = 0;
        this.f80214l = C.TIME_UNSET;
        this.f80215m = false;
    }
}
