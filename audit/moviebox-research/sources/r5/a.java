package r5;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;
import o5.e;
import o5.k;
import o5.r;
import o5.s;
import z3.c0;
import z3.h;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f75130a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f75131b = new c0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0825a f75132c = new C0825a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Inflater f75133d;

    /* JADX INFO: renamed from: r5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0825a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f75134a = new c0();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f75135b = new int[256];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f75136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f75137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f75138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f75139f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f75140g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f75141h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f75142i;

        @Nullable
        public y3.a d() {
            int iH;
            if (this.f75137d == 0 || this.f75138e == 0 || this.f75141h == 0 || this.f75142i == 0 || this.f75134a.g() == 0 || this.f75134a.f() != this.f75134a.g() || !this.f75136c) {
                return null;
            }
            this.f75134a.U(0);
            int i11 = this.f75141h * this.f75142i;
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int iH2 = this.f75134a.H();
                if (iH2 != 0) {
                    iH = i12 + 1;
                    iArr[i12] = this.f75135b[iH2];
                } else {
                    int iH3 = this.f75134a.H();
                    if (iH3 != 0) {
                        iH = ((iH3 & 64) == 0 ? iH3 & 63 : ((iH3 & 63) << 8) | this.f75134a.H()) + i12;
                        Arrays.fill(iArr, i12, iH, (iH3 & 128) == 0 ? 0 : this.f75135b[this.f75134a.H()]);
                    }
                }
                i12 = iH;
            }
            return new y3.a.b().f(Bitmap.createBitmap(iArr, this.f75141h, this.f75142i, Bitmap.Config.ARGB_8888)).k(this.f75139f / this.f75137d).l(0).h(this.f75140g / this.f75138e, 0).i(0).n(this.f75141h / this.f75137d).g(this.f75142i / this.f75138e).a();
        }

        public final void e(c0 c0Var, int i11) {
            int iK;
            if (i11 < 4) {
                return;
            }
            c0Var.V(3);
            int i12 = i11 - 4;
            if ((c0Var.H() & 128) != 0) {
                if (i12 < 7 || (iK = c0Var.K()) < 4) {
                    return;
                }
                this.f75141h = c0Var.N();
                this.f75142i = c0Var.N();
                this.f75134a.Q(iK - 4);
                i12 = i11 - 11;
            }
            int iF = this.f75134a.f();
            int iG = this.f75134a.g();
            if (iF >= iG || i12 <= 0) {
                return;
            }
            int iMin = Math.min(i12, iG - iF);
            c0Var.l(this.f75134a.e(), iF, iMin);
            this.f75134a.U(iF + iMin);
        }

        public final void f(c0 c0Var, int i11) {
            if (i11 < 19) {
                return;
            }
            this.f75137d = c0Var.N();
            this.f75138e = c0Var.N();
            c0Var.V(11);
            this.f75139f = c0Var.N();
            this.f75140g = c0Var.N();
        }

        public final void g(c0 c0Var, int i11) {
            if (i11 % 5 != 2) {
                return;
            }
            c0Var.V(2);
            Arrays.fill(this.f75135b, 0);
            int i12 = i11 / 5;
            for (int i13 = 0; i13 < i12; i13++) {
                int iH = c0Var.H();
                int iH2 = c0Var.H();
                int iH3 = c0Var.H();
                int iH4 = c0Var.H();
                double d11 = iH2;
                double d12 = iH3 - 128;
                double d13 = iH4 - 128;
                this.f75135b[iH] = (u0.p((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255) << 8) | (c0Var.H() << 24) | (u0.p((int) ((1.402d * d12) + d11), 0, 255) << 16) | u0.p((int) (d11 + (d13 * 1.772d)), 0, 255);
            }
            this.f75136c = true;
        }

        public void h() {
            this.f75137d = 0;
            this.f75138e = 0;
            this.f75139f = 0;
            this.f75140g = 0;
            this.f75141h = 0;
            this.f75142i = 0;
            this.f75134a.Q(0);
            this.f75136c = false;
        }
    }

    @Nullable
    public static y3.a f(c0 c0Var, C0825a c0825a) {
        int iG = c0Var.g();
        int iH = c0Var.H();
        int iN = c0Var.N();
        int iF = c0Var.f() + iN;
        y3.a aVarD = null;
        if (iF > iG) {
            c0Var.U(iG);
            return null;
        }
        if (iH != 128) {
            switch (iH) {
                case 20:
                    c0825a.g(c0Var, iN);
                    break;
                case 21:
                    c0825a.e(c0Var, iN);
                    break;
                case 22:
                    c0825a.f(c0Var, iN);
                    break;
            }
        } else {
            aVarD = c0825a.d();
            c0825a.h();
        }
        c0Var.U(iF);
        return aVarD;
    }

    @Override // o5.s
    public /* synthetic */ void a(byte[] bArr, s.b bVar, h hVar) {
        r.a(this, bArr, bVar, hVar);
    }

    @Override // o5.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.b(this, bArr, i11, i12);
    }

    @Override // o5.s
    public void c(byte[] bArr, int i11, int i12, s.b bVar, h<e> hVar) {
        this.f75130a.S(bArr, i12 + i11);
        this.f75130a.U(i11);
        e(this.f75130a);
        this.f75132c.h();
        ArrayList arrayList = new ArrayList();
        while (this.f75130a.a() >= 3) {
            y3.a aVarF = f(this.f75130a, this.f75132c);
            if (aVarF != null) {
                arrayList.add(aVarF);
            }
        }
        hVar.accept(new e(arrayList, C.TIME_UNSET, C.TIME_UNSET));
    }

    @Override // o5.s
    public int d() {
        return 2;
    }

    public final void e(c0 c0Var) {
        if (c0Var.a() <= 0 || c0Var.j() != 120) {
            return;
        }
        if (this.f75133d == null) {
            this.f75133d = new Inflater();
        }
        if (u0.D0(c0Var, this.f75131b, this.f75133d)) {
            c0Var.S(this.f75131b.e(), this.f75131b.g());
        }
    }

    @Override // o5.s
    public /* synthetic */ void reset() {
        r.c(this);
    }
}
