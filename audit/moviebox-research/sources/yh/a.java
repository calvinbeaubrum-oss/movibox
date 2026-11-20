package yh;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import vh.h;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f81349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c0 f81350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final C0916a f81351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public Inflater f81352r;

    /* JADX INFO: renamed from: yh.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0916a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f81353a = new c0();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f81354b = new int[256];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f81355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f81356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f81357e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f81358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f81359g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f81360h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f81361i;

        @Nullable
        public vh.b d() {
            int iD;
            if (this.f81356d == 0 || this.f81357e == 0 || this.f81360h == 0 || this.f81361i == 0 || this.f81353a.f() == 0 || this.f81353a.e() != this.f81353a.f() || !this.f81355c) {
                return null;
            }
            this.f81353a.P(0);
            int i11 = this.f81360h * this.f81361i;
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int iD2 = this.f81353a.D();
                if (iD2 != 0) {
                    iD = i12 + 1;
                    iArr[i12] = this.f81354b[iD2];
                } else {
                    int iD3 = this.f81353a.D();
                    if (iD3 != 0) {
                        iD = ((iD3 & 64) == 0 ? iD3 & 63 : ((iD3 & 63) << 8) | this.f81353a.D()) + i12;
                        Arrays.fill(iArr, i12, iD, (iD3 & 128) == 0 ? 0 : this.f81354b[this.f81353a.D()]);
                    }
                }
                i12 = iD;
            }
            return new vh.b.C0875b().f(Bitmap.createBitmap(iArr, this.f81360h, this.f81361i, Bitmap.Config.ARGB_8888)).k(this.f81358f / this.f81356d).l(0).h(this.f81359g / this.f81357e, 0).i(0).n(this.f81360h / this.f81356d).g(this.f81361i / this.f81357e).a();
        }

        public final void e(c0 c0Var, int i11) {
            int iG;
            if (i11 < 4) {
                return;
            }
            c0Var.Q(3);
            int i12 = i11 - 4;
            if ((c0Var.D() & 128) != 0) {
                if (i12 < 7 || (iG = c0Var.G()) < 4) {
                    return;
                }
                this.f81360h = c0Var.J();
                this.f81361i = c0Var.J();
                this.f81353a.L(iG - 4);
                i12 = i11 - 11;
            }
            int iE = this.f81353a.e();
            int iF = this.f81353a.f();
            if (iE >= iF || i12 <= 0) {
                return;
            }
            int iMin = Math.min(i12, iF - iE);
            c0Var.j(this.f81353a.d(), iE, iMin);
            this.f81353a.P(iE + iMin);
        }

        public final void f(c0 c0Var, int i11) {
            if (i11 < 19) {
                return;
            }
            this.f81356d = c0Var.J();
            this.f81357e = c0Var.J();
            c0Var.Q(11);
            this.f81358f = c0Var.J();
            this.f81359g = c0Var.J();
        }

        public final void g(c0 c0Var, int i11) {
            if (i11 % 5 != 2) {
                return;
            }
            c0Var.Q(2);
            Arrays.fill(this.f81354b, 0);
            int i12 = i11 / 5;
            for (int i13 = 0; i13 < i12; i13++) {
                int iD = c0Var.D();
                int iD2 = c0Var.D();
                int iD3 = c0Var.D();
                int iD4 = c0Var.D();
                double d11 = iD2;
                double d12 = iD3 - 128;
                double d13 = iD4 - 128;
                this.f81354b[iD] = (o0.q((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255) << 8) | (c0Var.D() << 24) | (o0.q((int) ((1.402d * d12) + d11), 0, 255) << 16) | o0.q((int) (d11 + (d13 * 1.772d)), 0, 255);
            }
            this.f81355c = true;
        }

        public void h() {
            this.f81356d = 0;
            this.f81357e = 0;
            this.f81358f = 0;
            this.f81359g = 0;
            this.f81360h = 0;
            this.f81361i = 0;
            this.f81353a.L(0);
            this.f81355c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f81349o = new c0();
        this.f81350p = new c0();
        this.f81351q = new C0916a();
    }

    @Nullable
    public static vh.b y(c0 c0Var, C0916a c0916a) {
        int iF = c0Var.f();
        int iD = c0Var.D();
        int iJ = c0Var.J();
        int iE = c0Var.e() + iJ;
        vh.b bVarD = null;
        if (iE > iF) {
            c0Var.P(iF);
            return null;
        }
        if (iD != 128) {
            switch (iD) {
                case 20:
                    c0916a.g(c0Var, iJ);
                    break;
                case 21:
                    c0916a.e(c0Var, iJ);
                    break;
                case 22:
                    c0916a.f(c0Var, iJ);
                    break;
            }
        } else {
            bVarD = c0916a.d();
            c0916a.h();
        }
        c0Var.P(iE);
        return bVarD;
    }

    @Override // vh.h
    public i w(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        this.f81349o.N(bArr, i11);
        x(this.f81349o);
        this.f81351q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f81349o.a() >= 3) {
            vh.b bVarY = y(this.f81349o, this.f81351q);
            if (bVarY != null) {
                arrayList.add(bVarY);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }

    public final void x(c0 c0Var) {
        if (c0Var.a() <= 0 || c0Var.h() != 120) {
            return;
        }
        if (this.f81352r == null) {
            this.f81352r = new Inflater();
        }
        if (o0.r0(c0Var, this.f81350p, this.f81352r)) {
            c0Var.N(this.f81350p.d(), this.f81350p.f());
        }
    }
}
