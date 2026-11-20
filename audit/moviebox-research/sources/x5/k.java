package x5;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.concurrent.atomic.AtomicInteger;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z3.c0 f80048a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f80050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f80051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f80052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r0 f80053f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f80055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f80056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f80057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.media3.common.y f80058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f80059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f80060m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f80054g = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f80063p = C.TIME_UNSET;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f80049b = new AtomicInteger();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f80061n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f80062o = -1;

    public k(@Nullable String str, int i11, int i12) {
        this.f80048a = new z3.c0(new byte[i12]);
        this.f80050c = str;
        this.f80051d = i11;
    }

    private boolean a(z3.c0 c0Var, byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f80055h);
        c0Var.l(bArr, this.f80055h, iMin);
        int i12 = this.f80055h + iMin;
        this.f80055h = i12;
        return i12 == i11;
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) throws ParserException {
        z3.a.i(this.f80053f);
        while (c0Var.a() > 0) {
            switch (this.f80054g) {
                case 0:
                    if (h(c0Var)) {
                        int i11 = this.f80060m;
                        if (i11 == 3 || i11 == 4) {
                            this.f80054g = 4;
                        } else if (i11 != 1) {
                            this.f80054g = 2;
                        } else {
                            this.f80054g = 1;
                        }
                    }
                    break;
                case 1:
                    if (a(c0Var, this.f80048a.e(), 18)) {
                        e();
                        this.f80048a.U(0);
                        this.f80053f.c(this.f80048a, 18);
                        this.f80054g = 6;
                    }
                    break;
                case 2:
                    if (a(c0Var, this.f80048a.e(), 7)) {
                        this.f80061n = u4.o.j(this.f80048a.e());
                        this.f80054g = 3;
                    }
                    break;
                case 3:
                    if (a(c0Var, this.f80048a.e(), this.f80061n)) {
                        f();
                        this.f80048a.U(0);
                        this.f80053f.c(this.f80048a, this.f80061n);
                        this.f80054g = 6;
                    }
                    break;
                case 4:
                    if (a(c0Var, this.f80048a.e(), 6)) {
                        int iL = u4.o.l(this.f80048a.e());
                        this.f80062o = iL;
                        int i12 = this.f80055h;
                        if (i12 > iL) {
                            int i13 = i12 - iL;
                            this.f80055h = i12 - i13;
                            c0Var.U(c0Var.f() - i13);
                        }
                        this.f80054g = 5;
                    }
                    break;
                case 5:
                    if (a(c0Var, this.f80048a.e(), this.f80062o)) {
                        g();
                        this.f80048a.U(0);
                        this.f80053f.c(this.f80048a, this.f80062o);
                        this.f80054g = 6;
                    }
                    break;
                case 6:
                    int iMin = Math.min(c0Var.a(), this.f80059l - this.f80055h);
                    this.f80053f.c(c0Var, iMin);
                    int i14 = this.f80055h + iMin;
                    this.f80055h = i14;
                    if (i14 == this.f80059l) {
                        z3.a.g(this.f80063p != C.TIME_UNSET);
                        this.f80053f.f(this.f80063p, this.f80060m == 4 ? 0 : 1, this.f80059l, 0, null);
                        this.f80063p += this.f80057j;
                        this.f80054g = 0;
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80063p = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80052e = dVar.b();
        this.f80053f = uVar.track(dVar.c(), 1);
    }

    public final void e() {
        byte[] bArrE = this.f80048a.e();
        if (this.f80058k == null) {
            androidx.media3.common.y yVarH = u4.o.h(bArrE, this.f80052e, this.f80050c, this.f80051d, null);
            this.f80058k = yVarH;
            this.f80053f.b(yVarH);
        }
        this.f80059l = u4.o.b(bArrE);
        this.f80057j = Ints.d(u0.e1(u4.o.g(bArrE), this.f80058k.A));
    }

    public final void f() throws ParserException {
        u4.o.b bVarI = u4.o.i(this.f80048a.e());
        i(bVarI);
        this.f80059l = bVarI.f78367d;
        long j11 = bVarI.f78368e;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        this.f80057j = j11;
    }

    public final void g() throws ParserException {
        u4.o.b bVarK = u4.o.k(this.f80048a.e(), this.f80049b);
        if (this.f80060m == 3) {
            i(bVarK);
        }
        this.f80059l = bVarK.f78367d;
        long j11 = bVarK.f78368e;
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        this.f80057j = j11;
    }

    public final boolean h(z3.c0 c0Var) {
        while (c0Var.a() > 0) {
            int i11 = this.f80056i << 8;
            this.f80056i = i11;
            int iH = i11 | c0Var.H();
            this.f80056i = iH;
            int iC = u4.o.c(iH);
            this.f80060m = iC;
            if (iC != 0) {
                byte[] bArrE = this.f80048a.e();
                int i12 = this.f80056i;
                bArrE[0] = (byte) ((i12 >> 24) & 255);
                bArrE[1] = (byte) ((i12 >> 16) & 255);
                bArrE[2] = (byte) ((i12 >> 8) & 255);
                bArrE[3] = (byte) (i12 & 255);
                this.f80055h = 4;
                this.f80056i = 0;
                return true;
            }
        }
        return false;
    }

    public final void i(u4.o.b bVar) {
        int i11;
        int i12 = bVar.f78365b;
        if (i12 == -2147483647 || (i11 = bVar.f78366c) == -1) {
            return;
        }
        androidx.media3.common.y yVar = this.f80058k;
        if (yVar != null && i11 == yVar.f9514z && i12 == yVar.A && u0.c(bVar.f78364a, yVar.f9501m)) {
            return;
        }
        androidx.media3.common.y yVar2 = this.f80058k;
        androidx.media3.common.y yVarI = (yVar2 == null ? new androidx.media3.common.y.b() : yVar2.b()).X(this.f80052e).k0(bVar.f78364a).L(bVar.f78366c).l0(bVar.f78365b).b0(this.f80050c).i0(this.f80051d).I();
        this.f80058k = yVarI;
        this.f80053f.b(yVarI);
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        this.f80054g = 0;
        this.f80055h = 0;
        this.f80056i = 0;
        this.f80063p = C.TIME_UNSET;
        this.f80049b.set(0);
    }
}
