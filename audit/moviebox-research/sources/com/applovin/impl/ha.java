package com.applovin.impl;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ha implements q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nj f19400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19402c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f19406g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f19408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private qo f19409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f19410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f19411l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f19413n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean[] f19407h = new boolean[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final yf f19403d = new yf(7, 128);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final yf f19404e = new yf(8, 128);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final yf f19405f = new yf(6, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f19412m = C.TIME_UNSET;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final bh f19414o = new bh();

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final qo f19415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f19416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f19417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SparseArray f19418d = new SparseArray();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final SparseArray f19419e = new SparseArray();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ch f19420f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f19421g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f19422h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f19423i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f19424j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f19425k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f19426l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private a f19427m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private a f19428n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f19429o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private long f19430p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f19431q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private boolean f19432r;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f19433a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f19434b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private zf.b f19435c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f19436d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f19437e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f19438f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f19439g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private boolean f19440h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private boolean f19441i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f19442j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private boolean f19443k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private int f19444l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private int f19445m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private int f19446n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private int f19447o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private int f19448p;

            private a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean a(a aVar) {
                int i11;
                int i12;
                int i13;
                boolean z11;
                if (!this.f19433a) {
                    return false;
                }
                if (!aVar.f19433a) {
                    return true;
                }
                zf.b bVar = (zf.b) b1.b(this.f19435c);
                zf.b bVar2 = (zf.b) b1.b(aVar.f19435c);
                return (this.f19438f == aVar.f19438f && this.f19439g == aVar.f19439g && this.f19440h == aVar.f19440h && (!this.f19441i || !aVar.f19441i || this.f19442j == aVar.f19442j) && (((i11 = this.f19436d) == (i12 = aVar.f19436d) || (i11 != 0 && i12 != 0)) && (((i13 = bVar.f24862k) != 0 || bVar2.f24862k != 0 || (this.f19445m == aVar.f19445m && this.f19446n == aVar.f19446n)) && ((i13 != 1 || bVar2.f24862k != 1 || (this.f19447o == aVar.f19447o && this.f19448p == aVar.f19448p)) && (z11 = this.f19443k) == aVar.f19443k && (!z11 || this.f19444l == aVar.f19444l))))) ? false : true;
            }

            public void a() {
                this.f19434b = false;
                this.f19433a = false;
            }

            public void a(int i11) {
                this.f19437e = i11;
                this.f19434b = true;
            }

            public void a(zf.b bVar, int i11, int i12, int i13, int i14, boolean z11, boolean z12, boolean z13, boolean z14, int i15, int i16, int i17, int i18, int i19) {
                this.f19435c = bVar;
                this.f19436d = i11;
                this.f19437e = i12;
                this.f19438f = i13;
                this.f19439g = i14;
                this.f19440h = z11;
                this.f19441i = z12;
                this.f19442j = z13;
                this.f19443k = z14;
                this.f19444l = i15;
                this.f19445m = i16;
                this.f19446n = i17;
                this.f19447o = i18;
                this.f19448p = i19;
                this.f19433a = true;
                this.f19434b = true;
            }

            public boolean b() {
                int i11;
                return this.f19434b && ((i11 = this.f19437e) == 7 || i11 == 2);
            }
        }

        public b(qo qoVar, boolean z11, boolean z12) {
            this.f19415a = qoVar;
            this.f19416b = z11;
            this.f19417c = z12;
            this.f19427m = new a();
            this.f19428n = new a();
            byte[] bArr = new byte[128];
            this.f19421g = bArr;
            this.f19420f = new ch(bArr, 0, 0);
            b();
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
        private void a(int i11) {
            long j11 = this.f19431q;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z11 = this.f19432r;
            this.f19415a.a(j11, z11 ? 1 : 0, (int) (this.f19424j - this.f19430p), i11, null);
        }

        public void a(long j11, int i11, long j12) {
            this.f19423i = i11;
            this.f19426l = j12;
            this.f19424j = j11;
            if (!this.f19416b || i11 != 1) {
                if (!this.f19417c) {
                    return;
                }
                if (i11 != 5 && i11 != 1 && i11 != 2) {
                    return;
                }
            }
            a aVar = this.f19427m;
            this.f19427m = this.f19428n;
            this.f19428n = aVar;
            aVar.a();
            this.f19422h = 0;
            this.f19425k = true;
        }

        public void a(zf.a aVar) {
            this.f19419e.append(aVar.f24849a, aVar);
        }

        public void a(zf.b bVar) {
            this.f19418d.append(bVar.f24855d, bVar);
        }

        /* JADX WARN: Code duplicated, block: B:53:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:54:0x00ff  */
        /* JADX WARN: Code duplicated, block: B:56:0x0103  */
        /* JADX WARN: Code duplicated, block: B:58:0x010b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x010c  */
        /* JADX WARN: Code duplicated, block: B:60:0x0115  */
        /* JADX WARN: Code duplicated, block: B:63:0x011b  */
        /* JADX WARN: Code duplicated, block: B:65:0x0125 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x0126  */
        /* JADX WARN: Code duplicated, block: B:77:0x0151  */
        public void a(byte[] bArr, int i11, int i12) {
            boolean z11;
            boolean z12;
            boolean zC;
            boolean z13;
            int iF;
            int i13;
            int i14;
            int i15;
            int iE;
            int iE2;
            int iB;
            if (this.f19425k) {
                int i16 = i12 - i11;
                byte[] bArr2 = this.f19421g;
                int length = bArr2.length;
                int i17 = this.f19422h + i16;
                if (length < i17) {
                    this.f19421g = Arrays.copyOf(bArr2, i17 * 2);
                }
                System.arraycopy(bArr, i11, this.f19421g, this.f19422h, i16);
                int i18 = this.f19422h + i16;
                this.f19422h = i18;
                this.f19420f.a(this.f19421g, 0, i18);
                if (this.f19420f.a(8)) {
                    this.f19420f.g();
                    int iB2 = this.f19420f.b(2);
                    this.f19420f.d(5);
                    if (this.f19420f.b()) {
                        this.f19420f.f();
                        if (this.f19420f.b()) {
                            int iF2 = this.f19420f.f();
                            if (!this.f19417c) {
                                this.f19425k = false;
                                this.f19428n.a(iF2);
                                return;
                            }
                            if (this.f19420f.b()) {
                                int iF3 = this.f19420f.f();
                                if (this.f19419e.indexOfKey(iF3) < 0) {
                                    this.f19425k = false;
                                    return;
                                }
                                zf.a aVar = (zf.a) this.f19419e.get(iF3);
                                zf.b bVar = (zf.b) this.f19418d.get(aVar.f24850b);
                                if (bVar.f24859h) {
                                    if (!this.f19420f.a(2)) {
                                        return;
                                    } else {
                                        this.f19420f.d(2);
                                    }
                                }
                                if (this.f19420f.a(bVar.f24861j)) {
                                    int iB3 = this.f19420f.b(bVar.f24861j);
                                    if (!bVar.f24860i) {
                                        if (this.f19420f.a(1)) {
                                            boolean zC2 = this.f19420f.c();
                                            if (!zC2) {
                                                z11 = zC2;
                                            } else {
                                                if (!this.f19420f.a(1)) {
                                                    return;
                                                }
                                                z11 = zC2;
                                                zC = this.f19420f.c();
                                                z12 = true;
                                            }
                                            if (this.f19423i == 5) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            if (z13) {
                                                iF = 0;
                                            } else if (!this.f19420f.b()) {
                                                return;
                                            } else {
                                                iF = this.f19420f.f();
                                            }
                                            i13 = bVar.f24862k;
                                            if (i13 != 0) {
                                                if (this.f19420f.a(bVar.f24863l)) {
                                                    iB = this.f19420f.b(bVar.f24863l);
                                                    if (aVar.f24851c || z11) {
                                                        i14 = iB;
                                                    } else {
                                                        if (!this.f19420f.b()) {
                                                            return;
                                                        }
                                                        iE = this.f19420f.e();
                                                        i14 = iB;
                                                    }
                                                    i15 = 0;
                                                    iE2 = 0;
                                                    this.f19428n.a(bVar, iB2, iF2, iB3, iF3, z11, z12, zC, z13, iF, i14, iE, i15, iE2);
                                                    this.f19425k = false;
                                                }
                                                return;
                                            }
                                            if (i13 == 1 || bVar.f24864m) {
                                                i14 = 0;
                                            } else {
                                                if (!this.f19420f.b()) {
                                                    return;
                                                }
                                                int iE3 = this.f19420f.e();
                                                if (!aVar.f24851c || z11) {
                                                    i15 = iE3;
                                                    i14 = 0;
                                                    iE = 0;
                                                    iE2 = 0;
                                                } else {
                                                    if (!this.f19420f.b()) {
                                                        return;
                                                    }
                                                    iE2 = this.f19420f.e();
                                                    i15 = iE3;
                                                    i14 = 0;
                                                    iE = 0;
                                                }
                                            }
                                            this.f19428n.a(bVar, iB2, iF2, iB3, iF3, z11, z12, zC, z13, iF, i14, iE, i15, iE2);
                                            this.f19425k = false;
                                            iE = 0;
                                            i15 = 0;
                                            iE2 = 0;
                                            this.f19428n.a(bVar, iB2, iF2, iB3, iF3, z11, z12, zC, z13, iF, i14, iE, i15, iE2);
                                            this.f19425k = false;
                                        }
                                        return;
                                    }
                                    z11 = false;
                                    z12 = false;
                                    zC = false;
                                    if (this.f19423i == 5) {
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                    if (z13) {
                                        iF = 0;
                                    } else if (!this.f19420f.b()) {
                                        return;
                                    } else {
                                        iF = this.f19420f.f();
                                    }
                                    i13 = bVar.f24862k;
                                    if (i13 != 0) {
                                        if (i13 == 1) {
                                        }
                                        i14 = 0;
                                    } else {
                                        if (this.f19420f.a(bVar.f24863l)) {
                                            return;
                                        }
                                        iB = this.f19420f.b(bVar.f24863l);
                                        if (aVar.f24851c) {
                                        }
                                        i14 = iB;
                                    }
                                    iE = 0;
                                    i15 = 0;
                                    iE2 = 0;
                                    this.f19428n.a(bVar, iB2, iF2, iB3, iF3, z11, z12, zC, z13, iF, i14, iE, i15, iE2);
                                    this.f19425k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean a() {
            return this.f19417c;
        }

        public boolean a(long j11, int i11, boolean z11, boolean z12) {
            boolean z13 = false;
            if (this.f19423i == 9 || (this.f19417c && this.f19428n.a(this.f19427m))) {
                if (z11 && this.f19429o) {
                    a(i11 + ((int) (j11 - this.f19424j)));
                }
                this.f19430p = this.f19424j;
                this.f19431q = this.f19426l;
                this.f19432r = false;
                this.f19429o = true;
            }
            if (this.f19416b) {
                z12 = this.f19428n.b();
            }
            boolean z14 = this.f19432r;
            int i12 = this.f19423i;
            if (i12 == 5 || (z12 && i12 == 1)) {
                z13 = true;
            }
            boolean z15 = z14 | z13;
            this.f19432r = z15;
            return z15;
        }

        public void b() {
            this.f19425k = false;
            this.f19429o = false;
            this.f19428n.a();
        }
    }

    public ha(nj njVar, boolean z11, boolean z12) {
        this.f19400a = njVar;
        this.f19401b = z11;
        this.f19402c = z12;
    }

    private void a(long j11, int i11, int i12, long j12) {
        if (!this.f19411l || this.f19410k.a()) {
            this.f19403d.a(i12);
            this.f19404e.a(i12);
            if (this.f19411l) {
                if (this.f19403d.a()) {
                    yf yfVar = this.f19403d;
                    this.f19410k.a(zf.c(yfVar.f24665d, 3, yfVar.f24666e));
                    this.f19403d.b();
                } else if (this.f19404e.a()) {
                    yf yfVar2 = this.f19404e;
                    this.f19410k.a(zf.b(yfVar2.f24665d, 3, yfVar2.f24666e));
                    this.f19404e.b();
                }
            } else if (this.f19403d.a() && this.f19404e.a()) {
                ArrayList arrayList = new ArrayList();
                yf yfVar3 = this.f19403d;
                arrayList.add(Arrays.copyOf(yfVar3.f24665d, yfVar3.f24666e));
                yf yfVar4 = this.f19404e;
                arrayList.add(Arrays.copyOf(yfVar4.f24665d, yfVar4.f24666e));
                yf yfVar5 = this.f19403d;
                zf.b bVarC = zf.c(yfVar5.f24665d, 3, yfVar5.f24666e);
                yf yfVar6 = this.f19404e;
                zf.a aVarB = zf.b(yfVar6.f24665d, 3, yfVar6.f24666e);
                this.f19409j.a(new f9.b().c(this.f19408i).f(MimeTypes.VIDEO_H264).a(o3.a(bVarC.f24852a, bVarC.f24853b, bVarC.f24854c)).q(bVarC.f24856e).g(bVarC.f24857f).b(bVarC.f24858g).a(arrayList).a());
                this.f19411l = true;
                this.f19410k.a(bVarC);
                this.f19410k.a(aVarB);
                this.f19403d.b();
                this.f19404e.b();
            }
        }
        if (this.f19405f.a(i12)) {
            yf yfVar7 = this.f19405f;
            this.f19414o.a(this.f19405f.f24665d, zf.c(yfVar7.f24665d, yfVar7.f24666e));
            this.f19414o.f(4);
            this.f19400a.a(j12, this.f19414o);
        }
        if (this.f19410k.a(j11, i11, this.f19411l, this.f19413n)) {
            this.f19413n = false;
        }
    }

    private void a(long j11, int i11, long j12) {
        if (!this.f19411l || this.f19410k.a()) {
            this.f19403d.b(i11);
            this.f19404e.b(i11);
        }
        this.f19405f.b(i11);
        this.f19410k.a(j11, i11, j12);
    }

    private void a(byte[] bArr, int i11, int i12) {
        if (!this.f19411l || this.f19410k.a()) {
            this.f19403d.a(bArr, i11, i12);
            this.f19404e.a(bArr, i11, i12);
        }
        this.f19405f.a(bArr, i11, i12);
        this.f19410k.a(bArr, i11, i12);
    }

    private void c() {
        b1.b(this.f19409j);
        xp.a(this.f19410k);
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f19406g = 0L;
        this.f19413n = false;
        this.f19412m = C.TIME_UNSET;
        zf.a(this.f19407h);
        this.f19403d.b();
        this.f19404e.b();
        this.f19405f.b();
        b bVar = this.f19410k;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f19412m = j11;
        }
        this.f19413n |= (i11 & 2) != 0;
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        c();
        int iD = bhVar.d();
        int iE = bhVar.e();
        byte[] bArrC = bhVar.c();
        this.f19406g += (long) bhVar.a();
        this.f19409j.a(bhVar, bhVar.a());
        while (true) {
            int iA = zf.a(bArrC, iD, iE, this.f19407h);
            if (iA == iE) {
                a(bArrC, iD, iE);
                return;
            }
            int iB = zf.b(bArrC, iA);
            int i11 = iA - iD;
            if (i11 > 0) {
                a(bArrC, iD, iA);
            }
            int i12 = iE - iA;
            long j11 = this.f19406g - ((long) i12);
            a(j11, i12, i11 < 0 ? -i11 : 0, this.f19412m);
            a(j11, iB, this.f19412m);
            iD = iA + 3;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f19408i = dVar.b();
        qo qoVarA = m8Var.a(dVar.c(), 2);
        this.f19409j = qoVarA;
        this.f19410k = new b(qoVarA, this.f19401b, this.f19402c);
        this.f19400a.a(m8Var, dVar);
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }
}
