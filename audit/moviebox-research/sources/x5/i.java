package x5;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements m {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f80010w = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f80011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.b0 f80012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z3.c0 f80013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f80014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f80015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f80016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r0 f80017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r0 f80018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f80019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f80020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f80021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f80022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f80023m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f80024n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f80025o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f80026p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f80027q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f80028r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f80029s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f80030t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public r0 f80031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f80032v;

    public i(boolean z11) {
        this(z11, null, 0);
    }

    public i(boolean z11, @Nullable String str, int i11) {
        this.f80012b = new z3.b0(new byte[7]);
        this.f80013c = new z3.c0(Arrays.copyOf(f80010w, 10));
        q();
        this.f80024n = -1;
        this.f80025o = -1;
        this.f80028r = C.TIME_UNSET;
        this.f80030t = C.TIME_UNSET;
        this.f80011a = z11;
        this.f80014d = str;
        this.f80015e = i11;
    }

    private boolean g(z3.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f80020j);
        c0Var.l(bArr, this.f80020j, iMin);
        int i12 = this.f80020j + iMin;
        this.f80020j = i12;
        return i12 == i11;
    }

    public static boolean k(int i11) {
        return (i11 & 65526) == 65520;
    }

    public final void a() {
        z3.a.e(this.f80017g);
        u0.i(this.f80031u);
        u0.i(this.f80018h);
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) throws ParserException {
        a();
        while (c0Var.a() > 0) {
            int i11 = this.f80019i;
            if (i11 == 0) {
                h(c0Var);
            } else if (i11 == 1) {
                e(c0Var);
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (g(c0Var, this.f80012b.f81757a, this.f80022l ? 7 : 5)) {
                        l();
                    }
                } else {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    n(c0Var);
                }
            } else if (g(c0Var, this.f80013c.e(), 10)) {
                m();
            }
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80030t = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80016f = dVar.b();
        r0 r0VarTrack = uVar.track(dVar.c(), 1);
        this.f80017g = r0VarTrack;
        this.f80031u = r0VarTrack;
        if (!this.f80011a) {
            this.f80018h = new u4.q();
            return;
        }
        dVar.a();
        r0 r0VarTrack2 = uVar.track(dVar.c(), 5);
        this.f80018h = r0VarTrack2;
        r0VarTrack2.b(new androidx.media3.common.y.b().X(dVar.b()).k0(MimeTypes.APPLICATION_ID3).I());
    }

    public final void e(z3.c0 c0Var) {
        if (c0Var.a() == 0) {
            return;
        }
        this.f80012b.f81757a[0] = c0Var.e()[c0Var.f()];
        this.f80012b.p(2);
        int iH = this.f80012b.h(4);
        int i11 = this.f80025o;
        if (i11 != -1 && iH != i11) {
            o();
            return;
        }
        if (!this.f80023m) {
            this.f80023m = true;
            this.f80024n = this.f80026p;
            this.f80025o = iH;
        }
        r();
    }

    public final boolean f(z3.c0 c0Var, int i11) {
        c0Var.U(i11 + 1);
        if (!u(c0Var, this.f80012b.f81757a, 1)) {
            return false;
        }
        this.f80012b.p(4);
        int iH = this.f80012b.h(1);
        int i12 = this.f80024n;
        if (i12 != -1 && iH != i12) {
            return false;
        }
        if (this.f80025o != -1) {
            if (!u(c0Var, this.f80012b.f81757a, 1)) {
                return true;
            }
            this.f80012b.p(2);
            if (this.f80012b.h(4) != this.f80025o) {
                return false;
            }
            c0Var.U(i11 + 2);
        }
        if (!u(c0Var, this.f80012b.f81757a, 4)) {
            return true;
        }
        this.f80012b.p(14);
        int iH2 = this.f80012b.h(13);
        if (iH2 < 7) {
            return false;
        }
        byte[] bArrE = c0Var.e();
        int iG = c0Var.g();
        int i13 = i11 + iH2;
        if (i13 >= iG) {
            return true;
        }
        byte b11 = bArrE[i13];
        if (b11 == -1) {
            int i14 = i13 + 1;
            if (i14 == iG) {
                return true;
            }
            return j((byte) -1, bArrE[i14]) && ((bArrE[i14] & 8) >> 3) == iH;
        }
        if (b11 != 73) {
            return false;
        }
        int i15 = i13 + 1;
        if (i15 == iG) {
            return true;
        }
        if (bArrE[i15] != 68) {
            return false;
        }
        int i16 = i13 + 2;
        return i16 == iG || bArrE[i16] == 51;
    }

    public final void h(z3.c0 c0Var) {
        byte[] bArrE = c0Var.e();
        int iF = c0Var.f();
        int iG = c0Var.g();
        while (iF < iG) {
            int i11 = iF + 1;
            byte b11 = bArrE[iF];
            int i12 = b11 & 255;
            if (this.f80021k == 512 && j((byte) -1, (byte) i12) && (this.f80023m || f(c0Var, iF - 1))) {
                this.f80026p = (b11 & 8) >> 3;
                this.f80022l = (b11 & 1) == 0;
                if (this.f80023m) {
                    r();
                } else {
                    p();
                }
                c0Var.U(i11);
                return;
            }
            int i13 = this.f80021k;
            int i14 = i12 | i13;
            if (i14 == 329) {
                this.f80021k = 768;
            } else if (i14 == 511) {
                this.f80021k = 512;
            } else if (i14 == 836) {
                this.f80021k = 1024;
            } else if (i14 == 1075) {
                s();
                c0Var.U(i11);
                return;
            } else if (i13 != 256) {
                this.f80021k = 256;
            }
            iF = i11;
        }
        c0Var.U(iF);
    }

    public long i() {
        return this.f80028r;
    }

    public final boolean j(byte b11, byte b12) {
        return k(((b11 & 255) << 8) | (b12 & 255));
    }

    public final void l() throws ParserException {
        this.f80012b.p(0);
        if (this.f80027q) {
            this.f80012b.r(10);
        } else {
            int i11 = 2;
            int iH = this.f80012b.h(2) + 1;
            if (iH != 2) {
                z3.o.h("AdtsReader", "Detected audio object type: " + iH + ", but assuming AAC LC.");
            } else {
                i11 = iH;
            }
            this.f80012b.r(5);
            byte[] bArrA = u4.a.a(i11, this.f80025o, this.f80012b.h(3));
            u4.a.b bVarE = u4.a.e(bArrA);
            androidx.media3.common.y yVarI = new androidx.media3.common.y.b().X(this.f80016f).k0(MimeTypes.AUDIO_AAC).M(bVarE.f78196c).L(bVarE.f78195b).l0(bVarE.f78194a).Y(Collections.singletonList(bArrA)).b0(this.f80014d).i0(this.f80015e).I();
            this.f80028r = 1024000000 / ((long) yVarI.A);
            this.f80017g.b(yVarI);
            this.f80027q = true;
        }
        this.f80012b.r(4);
        int iH2 = this.f80012b.h(13);
        int i12 = iH2 - 7;
        if (this.f80022l) {
            i12 = iH2 - 9;
        }
        t(this.f80017g, this.f80028r, 0, i12);
    }

    public final void m() {
        this.f80018h.c(this.f80013c, 10);
        this.f80013c.U(6);
        t(this.f80018h, 0L, 10, this.f80013c.G() + 10);
    }

    public final void n(z3.c0 c0Var) {
        int iMin = Math.min(c0Var.a(), this.f80029s - this.f80020j);
        this.f80031u.c(c0Var, iMin);
        int i11 = this.f80020j + iMin;
        this.f80020j = i11;
        if (i11 == this.f80029s) {
            z3.a.g(this.f80030t != C.TIME_UNSET);
            this.f80031u.f(this.f80030t, 1, this.f80029s, 0, null);
            this.f80030t += this.f80032v;
            q();
        }
    }

    public final void o() {
        this.f80023m = false;
        q();
    }

    public final void p() {
        this.f80019i = 1;
        this.f80020j = 0;
    }

    @Override // x5.m
    public void packetFinished() {
    }

    public final void q() {
        this.f80019i = 0;
        this.f80020j = 0;
        this.f80021k = 256;
    }

    public final void r() {
        this.f80019i = 3;
        this.f80020j = 0;
    }

    public final void s() {
        this.f80019i = 2;
        this.f80020j = f80010w.length;
        this.f80029s = 0;
        this.f80013c.U(0);
    }

    @Override // x5.m
    public void seek() {
        this.f80030t = C.TIME_UNSET;
        o();
    }

    public final void t(r0 r0Var, long j11, int i11, int i12) {
        this.f80019i = 4;
        this.f80020j = i11;
        this.f80031u = r0Var;
        this.f80032v = j11;
        this.f80029s = i12;
    }

    public final boolean u(z3.c0 c0Var, byte[] bArr, int i11) {
        if (c0Var.a() < i11) {
            return false;
        }
        c0Var.l(bArr, 0, i11);
        return true;
    }
}
