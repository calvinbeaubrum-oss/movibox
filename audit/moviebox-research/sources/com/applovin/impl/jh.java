package com.applovin.impl;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class jh extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final bh f19959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final bh f19960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final a f19961q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Inflater f19962r;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final bh f19963a = new bh();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f19964b = new int[256];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f19965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f19966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f19967e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f19968f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f19969g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f19970h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f19971i;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(bh bhVar, int i11) {
            int iZ;
            if (i11 < 4) {
                return;
            }
            bhVar.g(3);
            int i12 = i11 - 4;
            if ((bhVar.w() & 128) != 0) {
                if (i12 < 7 || (iZ = bhVar.z()) < 4) {
                    return;
                }
                this.f19970h = bhVar.C();
                this.f19971i = bhVar.C();
                this.f19963a.d(iZ - 4);
                i12 = i11 - 11;
            }
            int iD = this.f19963a.d();
            int iE = this.f19963a.e();
            if (iD >= iE || i12 <= 0) {
                return;
            }
            int iMin = Math.min(i12, iE - iD);
            bhVar.a(this.f19963a.c(), iD, iMin);
            this.f19963a.f(iD + iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(bh bhVar, int i11) {
            if (i11 < 19) {
                return;
            }
            this.f19966d = bhVar.C();
            this.f19967e = bhVar.C();
            bhVar.g(11);
            this.f19968f = bhVar.C();
            this.f19969g = bhVar.C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(bh bhVar, int i11) {
            if (i11 % 5 != 2) {
                return;
            }
            bhVar.g(2);
            Arrays.fill(this.f19964b, 0);
            int i12 = i11 / 5;
            for (int i13 = 0; i13 < i12; i13++) {
                int iW = bhVar.w();
                int iW2 = bhVar.w();
                int iW3 = bhVar.w();
                int iW4 = bhVar.w();
                double d11 = iW2;
                double d12 = iW3 - 128;
                double d13 = iW4 - 128;
                this.f19964b[iW] = (xp.a((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255) << 8) | (bhVar.w() << 24) | (xp.a((int) ((1.402d * d12) + d11), 0, 255) << 16) | xp.a((int) (d11 + (d13 * 1.772d)), 0, 255);
            }
            this.f19965c = true;
        }

        public b5 a() {
            int iW;
            if (this.f19966d == 0 || this.f19967e == 0 || this.f19970h == 0 || this.f19971i == 0 || this.f19963a.e() == 0 || this.f19963a.d() != this.f19963a.e() || !this.f19965c) {
                return null;
            }
            this.f19963a.f(0);
            int i11 = this.f19970h * this.f19971i;
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int iW2 = this.f19963a.w();
                if (iW2 != 0) {
                    iW = i12 + 1;
                    iArr[i12] = this.f19964b[iW2];
                } else {
                    int iW3 = this.f19963a.w();
                    if (iW3 != 0) {
                        iW = ((iW3 & 64) == 0 ? iW3 & 63 : ((iW3 & 63) << 8) | this.f19963a.w()) + i12;
                        Arrays.fill(iArr, i12, iW, (iW3 & 128) == 0 ? 0 : this.f19964b[this.f19963a.w()]);
                    }
                }
                i12 = iW;
            }
            return new b5.b().a(Bitmap.createBitmap(iArr, this.f19970h, this.f19971i, Bitmap.Config.ARGB_8888)).b(this.f19968f / this.f19966d).b(0).a(this.f19969g / this.f19967e, 0).a(0).d(this.f19970h / this.f19966d).a(this.f19971i / this.f19967e).a();
        }

        public void b() {
            this.f19966d = 0;
            this.f19967e = 0;
            this.f19968f = 0;
            this.f19969g = 0;
            this.f19970h = 0;
            this.f19971i = 0;
            this.f19963a.d(0);
            this.f19965c = false;
        }
    }

    public jh() {
        super("PgsDecoder");
        this.f19959o = new bh();
        this.f19960p = new bh();
        this.f19961q = new a();
    }

    private static b5 a(bh bhVar, a aVar) {
        int iE = bhVar.e();
        int iW = bhVar.w();
        int iC = bhVar.C();
        int iD = bhVar.d() + iC;
        b5 b5VarA = null;
        if (iD > iE) {
            bhVar.f(iE);
            return null;
        }
        if (iW != 128) {
            switch (iW) {
                case 20:
                    aVar.c(bhVar, iC);
                    break;
                case 21:
                    aVar.a(bhVar, iC);
                    break;
                case 22:
                    aVar.b(bhVar, iC);
                    break;
            }
        } else {
            b5VarA = aVar.a();
            aVar.b();
        }
        bhVar.f(iD);
        return b5VarA;
    }

    private void a(bh bhVar) {
        if (bhVar.a() <= 0 || bhVar.g() != 120) {
            return;
        }
        if (this.f19962r == null) {
            this.f19962r = new Inflater();
        }
        if (xp.a(bhVar, this.f19960p, this.f19962r)) {
            bhVar.a(this.f19960p.c(), this.f19960p.e());
        }
    }

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) {
        this.f19959o.a(bArr, i11);
        a(this.f19959o);
        this.f19961q.b();
        ArrayList arrayList = new ArrayList();
        while (this.f19959o.a() >= 3) {
            b5 b5VarA = a(this.f19959o, this.f19961q);
            if (b5VarA != null) {
                arrayList.add(b5VarA);
            }
        }
        return new kh(Collections.unmodifiableList(arrayList));
    }
}
