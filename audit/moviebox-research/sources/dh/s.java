package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f63349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.b0 f63351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public tg.e0 f63352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f63353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m1 f63354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f63355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f63356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f63357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f63358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f63359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f63360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f63361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f63362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f63363o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f63364p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f63365q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f63366r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f63367s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f63368t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public String f63369u;

    public s(@Nullable String str) {
        this.f63349a = str;
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(1024);
        this.f63350b = c0Var;
        this.f63351c = new com.google.android.exoplayer2.util.b0(c0Var.d());
        this.f63359k = C.TIME_UNSET;
    }

    public static long a(com.google.android.exoplayer2.util.b0 b0Var) {
        return b0Var.h((b0Var.h(2) + 1) * 8);
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) throws ParserException {
        com.google.android.exoplayer2.util.a.i(this.f63352d);
        while (c0Var.a() > 0) {
            int i11 = this.f63355g;
            if (i11 != 0) {
                if (i11 == 1) {
                    int iD = c0Var.D();
                    if ((iD & 224) == 224) {
                        this.f63358j = iD;
                        this.f63355g = 2;
                    } else if (iD != 86) {
                        this.f63355g = 0;
                    }
                } else if (i11 == 2) {
                    int iD2 = ((this.f63358j & (-225)) << 8) | c0Var.D();
                    this.f63357i = iD2;
                    if (iD2 > this.f63350b.d().length) {
                        k(this.f63357i);
                    }
                    this.f63356h = 0;
                    this.f63355g = 3;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(c0Var.a(), this.f63357i - this.f63356h);
                    c0Var.j(this.f63351c.f35543a, this.f63356h, iMin);
                    int i12 = this.f63356h + iMin;
                    this.f63356h = i12;
                    if (i12 == this.f63357i) {
                        this.f63351c.p(0);
                        e(this.f63351c);
                        this.f63355g = 0;
                    }
                }
            } else if (c0Var.D() == 86) {
                this.f63355g = 1;
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63359k = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63352d = nVar.track(dVar.c(), 1);
        this.f63353e = dVar.b();
    }

    public final void e(com.google.android.exoplayer2.util.b0 b0Var) throws ParserException {
        if (!b0Var.g()) {
            this.f63360l = true;
            j(b0Var);
        } else if (!this.f63360l) {
            return;
        }
        if (this.f63361m != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (this.f63362n != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        i(b0Var, h(b0Var));
        if (this.f63364p) {
            b0Var.r((int) this.f63365q);
        }
    }

    public final int f(com.google.android.exoplayer2.util.b0 b0Var) throws ParserException {
        int iB = b0Var.b();
        com.google.android.exoplayer2.audio.a.b bVarE = com.google.android.exoplayer2.audio.a.e(b0Var, true);
        this.f63369u = bVarE.f32772c;
        this.f63366r = bVarE.f32770a;
        this.f63368t = bVarE.f32771b;
        return iB - b0Var.b();
    }

    public final void g(com.google.android.exoplayer2.util.b0 b0Var) {
        int iH = b0Var.h(3);
        this.f63363o = iH;
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

    public final int h(com.google.android.exoplayer2.util.b0 b0Var) throws ParserException {
        int iH;
        if (this.f63363o != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        int i11 = 0;
        do {
            iH = b0Var.h(8);
            i11 += iH;
        } while (iH == 255);
        return i11;
    }

    public final void i(com.google.android.exoplayer2.util.b0 b0Var, int i11) {
        int iE = b0Var.e();
        if ((iE & 7) == 0) {
            this.f63350b.P(iE >> 3);
        } else {
            b0Var.i(this.f63350b.d(), 0, i11 * 8);
            this.f63350b.P(0);
        }
        this.f63352d.c(this.f63350b, i11);
        long j11 = this.f63359k;
        if (j11 != C.TIME_UNSET) {
            this.f63352d.d(j11, 1, i11, 0, null);
            this.f63359k += this.f63367s;
        }
    }

    public final void j(com.google.android.exoplayer2.util.b0 b0Var) throws ParserException {
        boolean zG;
        int iH = b0Var.h(1);
        int iH2 = iH == 1 ? b0Var.h(1) : 0;
        this.f63361m = iH2;
        if (iH2 != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        if (iH == 1) {
            a(b0Var);
        }
        if (!b0Var.g()) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        this.f63362n = b0Var.h(6);
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
            m1 m1VarE = new m1.b().S(this.f63353e).e0(MimeTypes.AUDIO_AAC).I(this.f63369u).H(this.f63368t).f0(this.f63366r).T(Collections.singletonList(bArr)).V(this.f63349a).E();
            if (!m1VarE.equals(this.f63354f)) {
                this.f63354f = m1VarE;
                this.f63367s = 1024000000 / ((long) m1VarE.A);
                this.f63352d.e(m1VarE);
            }
        } else {
            b0Var.r(((int) a(b0Var)) - f(b0Var));
        }
        g(b0Var);
        boolean zG2 = b0Var.g();
        this.f63364p = zG2;
        this.f63365q = 0L;
        if (zG2) {
            if (iH == 1) {
                this.f63365q = a(b0Var);
            } else {
                do {
                    zG = b0Var.g();
                    this.f63365q = (this.f63365q << 8) + ((long) b0Var.h(8));
                } while (zG);
            }
        }
        if (b0Var.g()) {
            b0Var.r(8);
        }
    }

    public final void k(int i11) {
        this.f63350b.L(i11);
        this.f63351c.n(this.f63350b.d());
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        this.f63355g = 0;
        this.f63359k = C.TIME_UNSET;
        this.f63360l = false;
    }
}
