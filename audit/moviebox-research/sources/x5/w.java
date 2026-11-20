package x5;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f80246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.b0 f80247b = new z3.b0(new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f80248c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f80249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z3.i0 f80250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f80251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f80252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f80253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f80254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f80255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f80256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f80257l;

    public w(m mVar) {
        this.f80246a = mVar;
    }

    @Override // x5.i0
    public void a(z3.i0 i0Var, u4.u uVar, i0.d dVar) {
        this.f80250e = i0Var;
        this.f80246a.d(uVar, dVar);
    }

    @Override // x5.i0
    public final void b(z3.c0 c0Var, int i11) throws ParserException {
        z3.a.i(this.f80250e);
        if ((i11 & 1) != 0) {
            int i12 = this.f80248c;
            if (i12 != 0 && i12 != 1) {
                if (i12 == 2) {
                    z3.o.h("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i12 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f80255j != -1) {
                        z3.o.h("PesReader", "Unexpected start indicator: expected " + this.f80255j + " more bytes");
                    }
                    this.f80246a.packetFinished();
                }
            }
            f(1);
        }
        while (c0Var.a() > 0) {
            int i13 = this.f80248c;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 == 2) {
                        if (c(c0Var, this.f80247b.f81757a, Math.min(10, this.f80254i)) && c(c0Var, null, this.f80254i)) {
                            e();
                            i11 |= this.f80256k ? 4 : 0;
                            this.f80246a.c(this.f80257l, i11);
                            f(3);
                        }
                    } else {
                        if (i13 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = c0Var.a();
                        int i14 = this.f80255j;
                        int i15 = i14 != -1 ? iA - i14 : 0;
                        if (i15 > 0) {
                            iA -= i15;
                            c0Var.T(c0Var.f() + iA);
                        }
                        this.f80246a.b(c0Var);
                        int i16 = this.f80255j;
                        if (i16 != -1) {
                            int i17 = i16 - iA;
                            this.f80255j = i17;
                            if (i17 == 0) {
                                this.f80246a.packetFinished();
                                f(1);
                            }
                        }
                    }
                } else if (c(c0Var, this.f80247b.f81757a, 9)) {
                    f(d() ? 2 : 0);
                }
            } else {
                c0Var.V(c0Var.a());
            }
        }
    }

    public final boolean c(z3.c0 c0Var, @Nullable byte[] bArr, int i11) {
        int iMin = Math.min(c0Var.a(), i11 - this.f80249d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            c0Var.V(iMin);
        } else {
            c0Var.l(bArr, this.f80249d, iMin);
        }
        int i12 = this.f80249d + iMin;
        this.f80249d = i12;
        return i12 == i11;
    }

    public final boolean d() {
        this.f80247b.p(0);
        int iH = this.f80247b.h(24);
        if (iH != 1) {
            z3.o.h("PesReader", "Unexpected start code prefix: " + iH);
            this.f80255j = -1;
            return false;
        }
        this.f80247b.r(8);
        int iH2 = this.f80247b.h(16);
        this.f80247b.r(5);
        this.f80256k = this.f80247b.g();
        this.f80247b.r(2);
        this.f80251f = this.f80247b.g();
        this.f80252g = this.f80247b.g();
        this.f80247b.r(6);
        int iH3 = this.f80247b.h(8);
        this.f80254i = iH3;
        if (iH2 == 0) {
            this.f80255j = -1;
        } else {
            int i11 = (iH2 - 3) - iH3;
            this.f80255j = i11;
            if (i11 < 0) {
                z3.o.h("PesReader", "Found negative packet payload size: " + this.f80255j);
                this.f80255j = -1;
            }
        }
        return true;
    }

    public final void e() {
        this.f80247b.p(0);
        this.f80257l = C.TIME_UNSET;
        if (this.f80251f) {
            this.f80247b.r(4);
            long jH = ((long) this.f80247b.h(3)) << 30;
            this.f80247b.r(1);
            long jH2 = jH | ((long) (this.f80247b.h(15) << 15));
            this.f80247b.r(1);
            long jH3 = jH2 | ((long) this.f80247b.h(15));
            this.f80247b.r(1);
            if (!this.f80253h && this.f80252g) {
                this.f80247b.r(4);
                long jH4 = ((long) this.f80247b.h(3)) << 30;
                this.f80247b.r(1);
                long jH5 = jH4 | ((long) (this.f80247b.h(15) << 15));
                this.f80247b.r(1);
                long jH6 = jH5 | ((long) this.f80247b.h(15));
                this.f80247b.r(1);
                this.f80250e.b(jH6);
                this.f80253h = true;
            }
            this.f80257l = this.f80250e.b(jH3);
        }
    }

    public final void f(int i11) {
        this.f80248c = i11;
        this.f80249d = 0;
    }

    @Override // x5.i0
    public final void seek() {
        this.f80248c = 0;
        this.f80249d = 0;
        this.f80253h = false;
        this.f80246a.seek();
    }
}
