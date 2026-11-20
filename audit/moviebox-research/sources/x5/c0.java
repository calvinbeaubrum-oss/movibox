package x5;

import androidx.core.view.InputDeviceCompat;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f79929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z3.c0 f79930b = new z3.c0(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f79931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f79932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f79933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f79934f;

    public c0(b0 b0Var) {
        this.f79929a = b0Var;
    }

    @Override // x5.i0
    public void a(z3.i0 i0Var, u4.u uVar, i0.d dVar) {
        this.f79929a.a(i0Var, uVar, dVar);
        this.f79934f = true;
    }

    @Override // x5.i0
    public void b(z3.c0 c0Var, int i11) {
        int iF;
        boolean z11 = (i11 & 1) != 0;
        if (z11) {
            iF = c0Var.f() + c0Var.H();
        } else {
            iF = -1;
        }
        if (this.f79934f) {
            if (!z11) {
                return;
            }
            this.f79934f = false;
            c0Var.U(iF);
            this.f79932d = 0;
        }
        while (c0Var.a() > 0) {
            int i12 = this.f79932d;
            if (i12 < 3) {
                if (i12 == 0) {
                    int iH = c0Var.H();
                    c0Var.U(c0Var.f() - 1);
                    if (iH == 255) {
                        this.f79934f = true;
                        return;
                    }
                }
                int iMin = Math.min(c0Var.a(), 3 - this.f79932d);
                c0Var.l(this.f79930b.e(), this.f79932d, iMin);
                int i13 = this.f79932d + iMin;
                this.f79932d = i13;
                if (i13 == 3) {
                    this.f79930b.U(0);
                    this.f79930b.T(3);
                    this.f79930b.V(1);
                    int iH2 = this.f79930b.H();
                    int iH3 = this.f79930b.H();
                    this.f79933e = (iH2 & 128) != 0;
                    this.f79931c = (((iH2 & 15) << 8) | iH3) + 3;
                    int iB = this.f79930b.b();
                    int i14 = this.f79931c;
                    if (iB < i14) {
                        this.f79930b.c(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i14, this.f79930b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(c0Var.a(), this.f79931c - this.f79932d);
                c0Var.l(this.f79930b.e(), this.f79932d, iMin2);
                int i15 = this.f79932d + iMin2;
                this.f79932d = i15;
                int i16 = this.f79931c;
                if (i15 != i16) {
                    continue;
                } else {
                    if (!this.f79933e) {
                        this.f79930b.T(i16);
                    } else {
                        if (u0.x(this.f79930b.e(), 0, this.f79931c, -1) != 0) {
                            this.f79934f = true;
                            return;
                        }
                        this.f79930b.T(this.f79931c - 4);
                    }
                    this.f79930b.U(0);
                    this.f79929a.b(this.f79930b);
                    this.f79932d = 0;
                }
            }
        }
    }

    @Override // x5.i0
    public void seek() {
        this.f79934f = true;
    }
}
