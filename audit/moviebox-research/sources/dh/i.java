package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final byte[] f63164v = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f63165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.b0 f63166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f63168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f63169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public tg.e0 f63170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public tg.e0 f63171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f63172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f63173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f63174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f63175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f63176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f63177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f63178n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f63179o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f63180p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f63181q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f63182r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f63183s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public tg.e0 f63184t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f63185u;

    public i(boolean z11) {
        this(z11, null);
    }

    public i(boolean z11, @Nullable String str) {
        this.f63166b = new com.google.android.exoplayer2.util.b0(new byte[7]);
        this.f63167c = new com.google.android.exoplayer2.util.c0(Arrays.copyOf(f63164v, 10));
        q();
        this.f63177m = -1;
        this.f63178n = -1;
        this.f63181q = C.TIME_UNSET;
        this.f63183s = C.TIME_UNSET;
        this.f63165a = z11;
        this.f63168d = str;
    }

    private boolean g(com.google.android.exoplayer2.util.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f63173i);
        c0Var.j(bArr, this.f63173i, iMin);
        int i12 = this.f63173i + iMin;
        this.f63173i = i12;
        return i12 == i11;
    }

    public static boolean k(int i11) {
        return (i11 & 65526) == 65520;
    }

    public final void a() {
        com.google.android.exoplayer2.util.a.e(this.f63170f);
        o0.j(this.f63184t);
        o0.j(this.f63171g);
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) throws ParserException {
        a();
        while (c0Var.a() > 0) {
            int i11 = this.f63172h;
            if (i11 == 0) {
                h(c0Var);
            } else if (i11 == 1) {
                e(c0Var);
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (g(c0Var, this.f63166b.f35543a, this.f63175k ? 7 : 5)) {
                        l();
                    }
                } else {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    n(c0Var);
                }
            } else if (g(c0Var, this.f63167c.d(), 10)) {
                m();
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63183s = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63169e = dVar.b();
        tg.e0 e0VarTrack = nVar.track(dVar.c(), 1);
        this.f63170f = e0VarTrack;
        this.f63184t = e0VarTrack;
        if (!this.f63165a) {
            this.f63171g = new tg.k();
            return;
        }
        dVar.a();
        tg.e0 e0VarTrack2 = nVar.track(dVar.c(), 5);
        this.f63171g = e0VarTrack2;
        e0VarTrack2.e(new m1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_ID3).E());
    }

    public final void e(com.google.android.exoplayer2.util.c0 c0Var) {
        if (c0Var.a() == 0) {
            return;
        }
        this.f63166b.f35543a[0] = c0Var.d()[c0Var.e()];
        this.f63166b.p(2);
        int iH = this.f63166b.h(4);
        int i11 = this.f63178n;
        if (i11 != -1 && iH != i11) {
            o();
            return;
        }
        if (!this.f63176l) {
            this.f63176l = true;
            this.f63177m = this.f63179o;
            this.f63178n = iH;
        }
        r();
    }

    public final boolean f(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        c0Var.P(i11 + 1);
        if (!u(c0Var, this.f63166b.f35543a, 1)) {
            return false;
        }
        this.f63166b.p(4);
        int iH = this.f63166b.h(1);
        int i12 = this.f63177m;
        if (i12 != -1 && iH != i12) {
            return false;
        }
        if (this.f63178n != -1) {
            if (!u(c0Var, this.f63166b.f35543a, 1)) {
                return true;
            }
            this.f63166b.p(2);
            if (this.f63166b.h(4) != this.f63178n) {
                return false;
            }
            c0Var.P(i11 + 2);
        }
        if (!u(c0Var, this.f63166b.f35543a, 4)) {
            return true;
        }
        this.f63166b.p(14);
        int iH2 = this.f63166b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrD = c0Var.d();
        int iF = c0Var.f();
        int i13 = i11 + iH2;
        if (i13 >= iF) {
            return true;
        }
        byte b11 = bArrD[i13];
        if (b11 == -1) {
            int i14 = i13 + 1;
            if (i14 == iF) {
                return true;
            }
            return j((byte) -1, bArrD[i14]) && ((bArrD[i14] & 8) >> 3) == iH;
        }
        if (b11 != 73) {
            return false;
        }
        int i15 = i13 + 1;
        if (i15 == iF) {
            return true;
        }
        if (bArrD[i15] != 68) {
            return false;
        }
        int i16 = i13 + 2;
        return i16 == iF || bArrD[i16] == 51;
    }

    public final void h(com.google.android.exoplayer2.util.c0 c0Var) {
        byte[] bArrD = c0Var.d();
        int iE = c0Var.e();
        int iF = c0Var.f();
        while (iE < iF) {
            int i11 = iE + 1;
            byte b11 = bArrD[iE];
            int i12 = b11 & 255;
            if (this.f63174j == 512 && j((byte) -1, (byte) i12) && (this.f63176l || f(c0Var, iE - 1))) {
                this.f63179o = (b11 & 8) >> 3;
                this.f63175k = (b11 & 1) == 0;
                if (this.f63176l) {
                    r();
                } else {
                    p();
                }
                c0Var.P(i11);
                return;
            }
            int i13 = this.f63174j;
            int i14 = i12 | i13;
            if (i14 == 329) {
                this.f63174j = 768;
            } else if (i14 == 511) {
                this.f63174j = 512;
            } else if (i14 == 836) {
                this.f63174j = 1024;
            } else if (i14 == 1075) {
                s();
                c0Var.P(i11);
                return;
            } else if (i13 != 256) {
                this.f63174j = 256;
            }
            iE = i11;
        }
        c0Var.P(iE);
    }

    public long i() {
        return this.f63181q;
    }

    public final boolean j(byte b11, byte b12) {
        return k(((b11 & 255) << 8) | (b12 & 255));
    }

    public final void l() throws ParserException {
        this.f63166b.p(0);
        if (this.f63180p) {
            this.f63166b.r(10);
        } else {
            int i11 = 2;
            int iH = this.f63166b.h(2) + 1;
            if (iH != 2) {
                com.google.android.exoplayer2.util.s.i("AdtsReader", "Detected audio object type: " + iH + ", but assuming AAC LC.");
            } else {
                i11 = iH;
            }
            this.f63166b.r(5);
            byte[] bArrB = com.google.android.exoplayer2.audio.a.b(i11, this.f63178n, this.f63166b.h(3));
            com.google.android.exoplayer2.audio.a.b bVarF = com.google.android.exoplayer2.audio.a.f(bArrB);
            m1 m1VarE = new m1.b().S(this.f63169e).e0(MimeTypes.AUDIO_AAC).I(bVarF.f32772c).H(bVarF.f32771b).f0(bVarF.f32770a).T(Collections.singletonList(bArrB)).V(this.f63168d).E();
            this.f63181q = 1024000000 / ((long) m1VarE.A);
            this.f63170f.e(m1VarE);
            this.f63180p = true;
        }
        this.f63166b.r(4);
        int iH2 = this.f63166b.h(13);
        int i12 = iH2 - 7;
        if (this.f63175k) {
            i12 = iH2 - 9;
        }
        t(this.f63170f, this.f63181q, 0, i12);
    }

    public final void m() {
        this.f63171g.c(this.f63167c, 10);
        this.f63167c.P(6);
        t(this.f63171g, 0L, 10, this.f63167c.C() + 10);
    }

    public final void n(com.google.android.exoplayer2.util.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f63182r - this.f63173i);
        this.f63184t.c(c0Var, iMin);
        int i11 = this.f63173i + iMin;
        this.f63173i = i11;
        int i12 = this.f63182r;
        if (i11 == i12) {
            long j11 = this.f63183s;
            if (j11 != C.TIME_UNSET) {
                this.f63184t.d(j11, 1, i12, 0, null);
                this.f63183s += this.f63185u;
            }
            q();
        }
    }

    public final void o() {
        this.f63176l = false;
        q();
    }

    public final void p() {
        this.f63172h = 1;
        this.f63173i = 0;
    }

    @Override // dh.m
    public void packetFinished() {
    }

    public final void q() {
        this.f63172h = 0;
        this.f63173i = 0;
        this.f63174j = 256;
    }

    public final void r() {
        this.f63172h = 3;
        this.f63173i = 0;
    }

    public final void s() {
        this.f63172h = 2;
        this.f63173i = f63164v.length;
        this.f63182r = 0;
        this.f63167c.P(0);
    }

    @Override // dh.m
    public void seek() {
        this.f63183s = C.TIME_UNSET;
        o();
    }

    public final void t(tg.e0 e0Var, long j11, int i11, int i12) {
        this.f63172h = 4;
        this.f63173i = i11;
        this.f63184t = e0Var;
        this.f63185u = j11;
        this.f63182r = i12;
    }

    public final boolean u(com.google.android.exoplayer2.util.c0 c0Var, byte[] bArr, int i11) {
        if (c0Var.a() < i11) {
            return false;
        }
        c0Var.j(bArr, 0, i11);
        return true;
    }
}
