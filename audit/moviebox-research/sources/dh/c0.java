package dh;

import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f63086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63087b = new com.google.android.exoplayer2.util.c0(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f63088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f63089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f63090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f63091f;

    public c0(b0 b0Var) {
        this.f63086a = b0Var;
    }

    @Override // dh.i0
    public void a(com.google.android.exoplayer2.util.k0 k0Var, tg.n nVar, i0.d dVar) {
        this.f63086a.a(k0Var, nVar, dVar);
        this.f63091f = true;
    }

    @Override // dh.i0
    public void b(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        int iE;
        boolean z11 = (i11 & 1) != 0;
        if (z11) {
            iE = c0Var.e() + c0Var.D();
        } else {
            iE = -1;
        }
        if (this.f63091f) {
            if (!z11) {
                return;
            }
            this.f63091f = false;
            c0Var.P(iE);
            this.f63089d = 0;
        }
        while (c0Var.a() > 0) {
            int i12 = this.f63089d;
            if (i12 < 3) {
                if (i12 == 0) {
                    int iD = c0Var.D();
                    c0Var.P(c0Var.e() - 1);
                    if (iD == 255) {
                        this.f63091f = true;
                        return;
                    }
                }
                int iMin = Math.min(c0Var.a(), 3 - this.f63089d);
                c0Var.j(this.f63087b.d(), this.f63089d, iMin);
                int i13 = this.f63089d + iMin;
                this.f63089d = i13;
                if (i13 == 3) {
                    this.f63087b.P(0);
                    this.f63087b.O(3);
                    this.f63087b.Q(1);
                    int iD2 = this.f63087b.D();
                    int iD3 = this.f63087b.D();
                    this.f63090e = (iD2 & 128) != 0;
                    this.f63088c = (((iD2 & 15) << 8) | iD3) + 3;
                    int iB = this.f63087b.b();
                    int i14 = this.f63088c;
                    if (iB < i14) {
                        this.f63087b.c(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i14, this.f63087b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(c0Var.a(), this.f63088c - this.f63089d);
                c0Var.j(this.f63087b.d(), this.f63089d, iMin2);
                int i15 = this.f63089d + iMin2;
                this.f63089d = i15;
                int i16 = this.f63088c;
                if (i15 != i16) {
                    continue;
                } else {
                    if (!this.f63090e) {
                        this.f63087b.O(i16);
                    } else {
                        if (o0.t(this.f63087b.d(), 0, this.f63088c, -1) != 0) {
                            this.f63091f = true;
                            return;
                        }
                        this.f63087b.O(this.f63088c - 4);
                    }
                    this.f63087b.P(0);
                    this.f63086a.b(this.f63087b);
                    this.f63089d = 0;
                }
            }
        }
    }

    @Override // dh.i0
    public void seek() {
        this.f63091f = true;
    }
}
