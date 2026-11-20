package dh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f63316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f63317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public tg.e0 f63318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f63319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f63320e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f63327l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f63321f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f63322g = new u(32, 128);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f63323h = new u(33, 128);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u f63324i = new u(34, 128);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f63325j = new u(39, 128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f63326k = new u(40, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f63328m = C.TIME_UNSET;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63329n = new com.google.android.exoplayer2.util.c0();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tg.e0 f63330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f63331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f63332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f63333d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f63334e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f63335f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f63336g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f63337h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f63338i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f63339j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f63340k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f63341l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f63342m;

        public a(tg.e0 e0Var) {
            this.f63330a = e0Var;
        }

        public static boolean b(int i11) {
            return (32 <= i11 && i11 <= 35) || i11 == 39;
        }

        public static boolean c(int i11) {
            return i11 < 32 || i11 == 40;
        }

        public void a(long j11, int i11, boolean z11) {
            if (this.f63339j && this.f63336g) {
                this.f63342m = this.f63332c;
                this.f63339j = false;
            } else if (this.f63337h || this.f63336g) {
                if (z11 && this.f63338i) {
                    d(i11 + ((int) (j11 - this.f63331b)));
                }
                this.f63340k = this.f63331b;
                this.f63341l = this.f63334e;
                this.f63342m = this.f63332c;
                this.f63338i = true;
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void d(int i11) {
            long j11 = this.f63341l;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z11 = this.f63342m;
            this.f63330a.d(j11, z11 ? 1 : 0, (int) (this.f63331b - this.f63340k), i11, null);
        }

        public void e(byte[] bArr, int i11, int i12) {
            if (this.f63335f) {
                int i13 = this.f63333d;
                int i14 = (i11 + 2) - i13;
                if (i14 >= i12) {
                    this.f63333d = i13 + (i12 - i11);
                } else {
                    this.f63336g = (bArr[i14] & 128) != 0;
                    this.f63335f = false;
                }
            }
        }

        public void f() {
            this.f63335f = false;
            this.f63336g = false;
            this.f63337h = false;
            this.f63338i = false;
            this.f63339j = false;
        }

        public void g(long j11, int i11, int i12, long j12, boolean z11) {
            this.f63336g = false;
            this.f63337h = false;
            this.f63334e = j12;
            this.f63333d = 0;
            this.f63331b = j11;
            if (!c(i12)) {
                if (this.f63338i && !this.f63339j) {
                    if (z11) {
                        d(i11);
                    }
                    this.f63338i = false;
                }
                if (b(i12)) {
                    this.f63337h = !this.f63339j;
                    this.f63339j = true;
                }
            }
            boolean z12 = i12 >= 16 && i12 <= 21;
            this.f63332c = z12;
            this.f63335f = z12 || i12 <= 9;
        }
    }

    public q(d0 d0Var) {
        this.f63316a = d0Var;
    }

    private void a() {
        com.google.android.exoplayer2.util.a.i(this.f63318c);
        o0.j(this.f63319d);
    }

    private void e(long j11, int i11, int i12, long j12) {
        this.f63319d.a(j11, i11, this.f63320e);
        if (!this.f63320e) {
            this.f63322g.b(i12);
            this.f63323h.b(i12);
            this.f63324i.b(i12);
            if (this.f63322g.c() && this.f63323h.c() && this.f63324i.c()) {
                this.f63318c.e(g(this.f63317b, this.f63322g, this.f63323h, this.f63324i));
                this.f63320e = true;
            }
        }
        if (this.f63325j.b(i12)) {
            u uVar = this.f63325j;
            this.f63329n.N(this.f63325j.f63385d, com.google.android.exoplayer2.util.x.q(uVar.f63385d, uVar.f63386e));
            this.f63329n.Q(5);
            this.f63316a.a(j12, this.f63329n);
        }
        if (this.f63326k.b(i12)) {
            u uVar2 = this.f63326k;
            this.f63329n.N(this.f63326k.f63385d, com.google.android.exoplayer2.util.x.q(uVar2.f63385d, uVar2.f63386e));
            this.f63329n.Q(5);
            this.f63316a.a(j12, this.f63329n);
        }
    }

    private void f(byte[] bArr, int i11, int i12) {
        this.f63319d.e(bArr, i11, i12);
        if (!this.f63320e) {
            this.f63322g.a(bArr, i11, i12);
            this.f63323h.a(bArr, i11, i12);
            this.f63324i.a(bArr, i11, i12);
        }
        this.f63325j.a(bArr, i11, i12);
        this.f63326k.a(bArr, i11, i12);
    }

    public static m1 g(@Nullable String str, u uVar, u uVar2, u uVar3) {
        int i11 = uVar.f63386e;
        byte[] bArr = new byte[uVar2.f63386e + i11 + uVar3.f63386e];
        int i12 = 0;
        System.arraycopy(uVar.f63385d, 0, bArr, 0, i11);
        System.arraycopy(uVar2.f63385d, 0, bArr, uVar.f63386e, uVar2.f63386e);
        System.arraycopy(uVar3.f63385d, 0, bArr, uVar.f63386e + uVar2.f63386e, uVar3.f63386e);
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(uVar2.f63385d, 0, uVar2.f63386e);
        d0Var.l(44);
        int iE = d0Var.e(3);
        d0Var.k();
        int iE2 = d0Var.e(2);
        boolean zD = d0Var.d();
        int iE3 = d0Var.e(5);
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i14 >= 32) {
                break;
            }
            if (d0Var.d()) {
                i13 |= 1 << i14;
            }
            i14++;
        }
        int[] iArr = new int[6];
        for (int i15 = 0; i15 < 6; i15++) {
            iArr[i15] = d0Var.e(8);
        }
        int iE4 = d0Var.e(8);
        for (int i16 = 0; i16 < iE; i16++) {
            if (d0Var.d()) {
                i12 += 89;
            }
            if (d0Var.d()) {
                i12 += 8;
            }
        }
        d0Var.l(i12);
        if (iE > 0) {
            d0Var.l((8 - iE) * 2);
        }
        d0Var.h();
        int iH = d0Var.h();
        if (iH == 3) {
            d0Var.k();
        }
        int iH2 = d0Var.h();
        int iH3 = d0Var.h();
        if (d0Var.d()) {
            int iH4 = d0Var.h();
            int iH5 = d0Var.h();
            int iH6 = d0Var.h();
            int iH7 = d0Var.h();
            iH2 -= ((iH == 1 || iH == 2) ? 2 : 1) * (iH4 + iH5);
            iH3 -= (iH == 1 ? 2 : 1) * (iH6 + iH7);
        }
        d0Var.h();
        d0Var.h();
        int iH8 = d0Var.h();
        for (int i17 = d0Var.d() ? 0 : iE; i17 <= iE; i17++) {
            d0Var.h();
            d0Var.h();
            d0Var.h();
        }
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        if (d0Var.d() && d0Var.d()) {
            h(d0Var);
        }
        d0Var.l(2);
        if (d0Var.d()) {
            d0Var.l(8);
            d0Var.h();
            d0Var.h();
            d0Var.k();
        }
        i(d0Var);
        if (d0Var.d()) {
            for (int i18 = 0; i18 < d0Var.h(); i18++) {
                d0Var.l(iH8 + 5);
            }
        }
        d0Var.l(2);
        float f11 = 1.0f;
        if (d0Var.d()) {
            if (d0Var.d()) {
                int iE5 = d0Var.e(8);
                if (iE5 == 255) {
                    int iE6 = d0Var.e(16);
                    int iE7 = d0Var.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f11 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = com.google.android.exoplayer2.util.x.f35653b;
                    if (iE5 < fArr.length) {
                        f11 = fArr[iE5];
                    } else {
                        com.google.android.exoplayer2.util.s.i("H265Reader", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (d0Var.d()) {
                d0Var.k();
            }
            if (d0Var.d()) {
                d0Var.l(4);
                if (d0Var.d()) {
                    d0Var.l(24);
                }
            }
            if (d0Var.d()) {
                d0Var.h();
                d0Var.h();
            }
            d0Var.k();
            if (d0Var.d()) {
                iH3 *= 2;
            }
        }
        return new m1.b().S(str).e0(MimeTypes.VIDEO_H265).I(com.google.android.exoplayer2.util.f.c(iE2, zD, iE3, i13, iArr, iE4)).j0(iH2).Q(iH3).a0(f11).T(Collections.singletonList(bArr)).E();
    }

    public static void h(com.google.android.exoplayer2.util.d0 d0Var) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (d0Var.d()) {
                    int iMin = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        d0Var.g();
                    }
                    for (int i14 = 0; i14 < iMin; i14++) {
                        d0Var.g();
                    }
                } else {
                    d0Var.h();
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    public static void i(com.google.android.exoplayer2.util.d0 d0Var) {
        int iH = d0Var.h();
        boolean zD = false;
        int i11 = 0;
        for (int i12 = 0; i12 < iH; i12++) {
            if (i12 != 0) {
                zD = d0Var.d();
            }
            if (zD) {
                d0Var.k();
                d0Var.h();
                for (int i13 = 0; i13 <= i11; i13++) {
                    if (d0Var.d()) {
                        d0Var.k();
                    }
                }
            } else {
                int iH2 = d0Var.h();
                int iH3 = d0Var.h();
                int i14 = iH2 + iH3;
                for (int i15 = 0; i15 < iH2; i15++) {
                    d0Var.h();
                    d0Var.k();
                }
                for (int i16 = 0; i16 < iH3; i16++) {
                    d0Var.h();
                    d0Var.k();
                }
                i11 = i14;
            }
        }
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        a();
        while (c0Var.a() > 0) {
            int iE = c0Var.e();
            int iF = c0Var.f();
            byte[] bArrD = c0Var.d();
            this.f63327l += (long) c0Var.a();
            this.f63318c.c(c0Var, c0Var.a());
            while (iE < iF) {
                int iC = com.google.android.exoplayer2.util.x.c(bArrD, iE, iF, this.f63321f);
                if (iC == iF) {
                    f(bArrD, iE, iF);
                    return;
                }
                int iE2 = com.google.android.exoplayer2.util.x.e(bArrD, iC);
                int i11 = iC - iE;
                if (i11 > 0) {
                    f(bArrD, iE, iC);
                }
                int i12 = iF - iC;
                long j11 = this.f63327l - ((long) i12);
                e(j11, i12, i11 < 0 ? -i11 : 0, this.f63328m);
                j(j11, i12, iE2, this.f63328m);
                iE = iC + 3;
            }
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63328m = j11;
        }
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63317b = dVar.b();
        tg.e0 e0VarTrack = nVar.track(dVar.c(), 2);
        this.f63318c = e0VarTrack;
        this.f63319d = new a(e0VarTrack);
        this.f63316a.b(nVar, dVar);
    }

    public final void j(long j11, int i11, int i12, long j12) {
        this.f63319d.g(j11, i11, i12, j12, this.f63320e);
        if (!this.f63320e) {
            this.f63322g.e(i12);
            this.f63323h.e(i12);
            this.f63324i.e(i12);
        }
        this.f63325j.e(i12);
        this.f63326k.e(i12);
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        this.f63327l = 0L;
        this.f63328m = C.TIME_UNSET;
        com.google.android.exoplayer2.util.x.a(this.f63321f);
        this.f63322g.d();
        this.f63323h.d();
        this.f63324i.d();
        this.f63325j.d();
        this.f63326k.d();
        a aVar = this.f63319d;
        if (aVar != null) {
            aVar.f();
        }
    }
}
