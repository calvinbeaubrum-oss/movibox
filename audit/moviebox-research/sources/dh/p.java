package dh;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f63267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f63268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f63269c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f63273g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f63275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public tg.e0 f63276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f63277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f63278l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f63280n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f63274h = new boolean[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f63270d = new u(7, 128);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f63271e = new u(8, 128);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f63272f = new u(6, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f63279m = C.TIME_UNSET;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63281o = new com.google.android.exoplayer2.util.c0();

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final tg.e0 f63282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f63283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f63284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<com.google.android.exoplayer2.util.x.c> f63285d = new SparseArray<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray<com.google.android.exoplayer2.util.x.b> f63286e = new SparseArray<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.d0 f63287f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f63288g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f63289h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f63290i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f63291j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f63292k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f63293l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public a f63294m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public a f63295n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f63296o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f63297p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f63298q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f63299r;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f63300a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f63301b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public com.google.android.exoplayer2.util.x.c f63302c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f63303d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f63304e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f63305f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f63306g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f63307h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f63308i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f63309j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean f63310k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f63311l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f63312m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f63313n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public int f63314o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public int f63315p;

            public a() {
            }

            public void b() {
                this.f63301b = false;
                this.f63300a = false;
            }

            public final boolean c(a aVar) {
                int i11;
                int i12;
                int i13;
                boolean z11;
                if (!this.f63300a) {
                    return false;
                }
                if (!aVar.f63300a) {
                    return true;
                }
                com.google.android.exoplayer2.util.x.c cVar = (com.google.android.exoplayer2.util.x.c) com.google.android.exoplayer2.util.a.i(this.f63302c);
                com.google.android.exoplayer2.util.x.c cVar2 = (com.google.android.exoplayer2.util.x.c) com.google.android.exoplayer2.util.a.i(aVar.f63302c);
                return (this.f63305f == aVar.f63305f && this.f63306g == aVar.f63306g && this.f63307h == aVar.f63307h && (!this.f63308i || !aVar.f63308i || this.f63309j == aVar.f63309j) && (((i11 = this.f63303d) == (i12 = aVar.f63303d) || (i11 != 0 && i12 != 0)) && (((i13 = cVar.f35680l) != 0 || cVar2.f35680l != 0 || (this.f63312m == aVar.f63312m && this.f63313n == aVar.f63313n)) && ((i13 != 1 || cVar2.f35680l != 1 || (this.f63314o == aVar.f63314o && this.f63315p == aVar.f63315p)) && (z11 = this.f63310k) == aVar.f63310k && (!z11 || this.f63311l == aVar.f63311l))))) ? false : true;
            }

            public boolean d() {
                int i11;
                return this.f63301b && ((i11 = this.f63304e) == 7 || i11 == 2);
            }

            public void e(com.google.android.exoplayer2.util.x.c cVar, int i11, int i12, int i13, int i14, boolean z11, boolean z12, boolean z13, boolean z14, int i15, int i16, int i17, int i18, int i19) {
                this.f63302c = cVar;
                this.f63303d = i11;
                this.f63304e = i12;
                this.f63305f = i13;
                this.f63306g = i14;
                this.f63307h = z11;
                this.f63308i = z12;
                this.f63309j = z13;
                this.f63310k = z14;
                this.f63311l = i15;
                this.f63312m = i16;
                this.f63313n = i17;
                this.f63314o = i18;
                this.f63315p = i19;
                this.f63300a = true;
                this.f63301b = true;
            }

            public void f(int i11) {
                this.f63304e = i11;
                this.f63301b = true;
            }
        }

        public b(tg.e0 e0Var, boolean z11, boolean z12) {
            this.f63282a = e0Var;
            this.f63283b = z11;
            this.f63284c = z12;
            this.f63294m = new a();
            this.f63295n = new a();
            byte[] bArr = new byte[128];
            this.f63288g = bArr;
            this.f63287f = new com.google.android.exoplayer2.util.d0(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Code duplicated, block: B:53:0x0100  */
        /* JADX WARN: Code duplicated, block: B:54:0x0103  */
        /* JADX WARN: Code duplicated, block: B:56:0x0107  */
        /* JADX WARN: Code duplicated, block: B:58:0x010f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x0110  */
        /* JADX WARN: Code duplicated, block: B:60:0x0119  */
        /* JADX WARN: Code duplicated, block: B:63:0x011f  */
        /* JADX WARN: Code duplicated, block: B:65:0x0129 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x012a  */
        /* JADX WARN: Code duplicated, block: B:77:0x0155  */
        public void a(byte[] bArr, int i11, int i12) {
            boolean z11;
            boolean z12;
            boolean zD;
            boolean z13;
            int iH;
            int i13;
            int i14;
            int i15;
            int iG;
            int iG2;
            int iE;
            if (this.f63292k) {
                int i16 = i12 - i11;
                byte[] bArr2 = this.f63288g;
                int length = bArr2.length;
                int i17 = this.f63289h;
                if (length < i17 + i16) {
                    this.f63288g = Arrays.copyOf(bArr2, (i17 + i16) * 2);
                }
                System.arraycopy(bArr, i11, this.f63288g, this.f63289h, i16);
                int i18 = this.f63289h + i16;
                this.f63289h = i18;
                this.f63287f.i(this.f63288g, 0, i18);
                if (this.f63287f.b(8)) {
                    this.f63287f.k();
                    int iE2 = this.f63287f.e(2);
                    this.f63287f.l(5);
                    if (this.f63287f.c()) {
                        this.f63287f.h();
                        if (this.f63287f.c()) {
                            int iH2 = this.f63287f.h();
                            if (!this.f63284c) {
                                this.f63292k = false;
                                this.f63295n.f(iH2);
                                return;
                            }
                            if (this.f63287f.c()) {
                                int iH3 = this.f63287f.h();
                                if (this.f63286e.indexOfKey(iH3) < 0) {
                                    this.f63292k = false;
                                    return;
                                }
                                com.google.android.exoplayer2.util.x.b bVar = this.f63286e.get(iH3);
                                com.google.android.exoplayer2.util.x.c cVar = this.f63285d.get(bVar.f35667b);
                                if (cVar.f35677i) {
                                    if (!this.f63287f.b(2)) {
                                        return;
                                    } else {
                                        this.f63287f.l(2);
                                    }
                                }
                                if (this.f63287f.b(cVar.f35679k)) {
                                    int iE3 = this.f63287f.e(cVar.f35679k);
                                    if (!cVar.f35678j) {
                                        if (this.f63287f.b(1)) {
                                            boolean zD2 = this.f63287f.d();
                                            if (!zD2) {
                                                z11 = zD2;
                                            } else {
                                                if (!this.f63287f.b(1)) {
                                                    return;
                                                }
                                                z11 = zD2;
                                                zD = this.f63287f.d();
                                                z12 = true;
                                            }
                                            if (this.f63290i == 5) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            if (z13) {
                                                iH = 0;
                                            } else if (!this.f63287f.c()) {
                                                return;
                                            } else {
                                                iH = this.f63287f.h();
                                            }
                                            i13 = cVar.f35680l;
                                            if (i13 != 0) {
                                                if (this.f63287f.b(cVar.f35681m)) {
                                                    iE = this.f63287f.e(cVar.f35681m);
                                                    if (bVar.f35668c || z11) {
                                                        i14 = iE;
                                                    } else {
                                                        if (!this.f63287f.c()) {
                                                            return;
                                                        }
                                                        iG = this.f63287f.g();
                                                        i14 = iE;
                                                    }
                                                    i15 = 0;
                                                    iG2 = 0;
                                                    this.f63295n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                                    this.f63292k = false;
                                                }
                                                return;
                                            }
                                            if (i13 == 1 || cVar.f35682n) {
                                                i14 = 0;
                                            } else {
                                                if (!this.f63287f.c()) {
                                                    return;
                                                }
                                                int iG3 = this.f63287f.g();
                                                if (!bVar.f35668c || z11) {
                                                    i15 = iG3;
                                                    i14 = 0;
                                                    iG = 0;
                                                    iG2 = 0;
                                                } else {
                                                    if (!this.f63287f.c()) {
                                                        return;
                                                    }
                                                    iG2 = this.f63287f.g();
                                                    i15 = iG3;
                                                    i14 = 0;
                                                    iG = 0;
                                                }
                                            }
                                            this.f63295n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                            this.f63292k = false;
                                            iG = 0;
                                            i15 = 0;
                                            iG2 = 0;
                                            this.f63295n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                            this.f63292k = false;
                                        }
                                        return;
                                    }
                                    z11 = false;
                                    z12 = false;
                                    zD = false;
                                    if (this.f63290i == 5) {
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                    if (z13) {
                                        iH = 0;
                                    } else if (!this.f63287f.c()) {
                                        return;
                                    } else {
                                        iH = this.f63287f.h();
                                    }
                                    i13 = cVar.f35680l;
                                    if (i13 != 0) {
                                        if (i13 == 1) {
                                        }
                                        i14 = 0;
                                    } else {
                                        if (this.f63287f.b(cVar.f35681m)) {
                                            return;
                                        }
                                        iE = this.f63287f.e(cVar.f35681m);
                                        if (bVar.f35668c) {
                                        }
                                        i14 = iE;
                                    }
                                    iG = 0;
                                    i15 = 0;
                                    iG2 = 0;
                                    this.f63295n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                    this.f63292k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean b(long j11, int i11, boolean z11, boolean z12) {
            boolean z13 = false;
            if (this.f63290i == 9 || (this.f63284c && this.f63295n.c(this.f63294m))) {
                if (z11 && this.f63296o) {
                    d(i11 + ((int) (j11 - this.f63291j)));
                }
                this.f63297p = this.f63291j;
                this.f63298q = this.f63293l;
                this.f63299r = false;
                this.f63296o = true;
            }
            if (this.f63283b) {
                z12 = this.f63295n.d();
            }
            boolean z14 = this.f63299r;
            int i12 = this.f63290i;
            if (i12 == 5 || (z12 && i12 == 1)) {
                z13 = true;
            }
            boolean z15 = z14 | z13;
            this.f63299r = z15;
            return z15;
        }

        public boolean c() {
            return this.f63284c;
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
            long j11 = this.f63298q;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z11 = this.f63299r;
            this.f63282a.d(j11, z11 ? 1 : 0, (int) (this.f63291j - this.f63297p), i11, null);
        }

        public void e(com.google.android.exoplayer2.util.x.b bVar) {
            this.f63286e.append(bVar.f35666a, bVar);
        }

        public void f(com.google.android.exoplayer2.util.x.c cVar) {
            this.f63285d.append(cVar.f35672d, cVar);
        }

        public void g() {
            this.f63292k = false;
            this.f63296o = false;
            this.f63295n.b();
        }

        public void h(long j11, int i11, long j12) {
            this.f63290i = i11;
            this.f63293l = j12;
            this.f63291j = j11;
            if (!this.f63283b || i11 != 1) {
                if (!this.f63284c) {
                    return;
                }
                if (i11 != 5 && i11 != 1 && i11 != 2) {
                    return;
                }
            }
            a aVar = this.f63294m;
            this.f63294m = this.f63295n;
            this.f63295n = aVar;
            aVar.b();
            this.f63289h = 0;
            this.f63292k = true;
        }
    }

    public p(d0 d0Var, boolean z11, boolean z12) {
        this.f63267a = d0Var;
        this.f63268b = z11;
        this.f63269c = z12;
    }

    private void a() {
        com.google.android.exoplayer2.util.a.i(this.f63276j);
        o0.j(this.f63277k);
    }

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        a();
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        this.f63273g += (long) c0Var.a();
        this.f63276j.c(c0Var, c0Var.a());
        while (true) {
            int iC = com.google.android.exoplayer2.util.x.c(bArrD, iE, iF, this.f63274h);
            if (iC == iF) {
                f(bArrD, iE, iF);
                return;
            }
            int iF2 = com.google.android.exoplayer2.util.x.f(bArrD, iC);
            int i11 = iC - iE;
            if (i11 > 0) {
                f(bArrD, iE, iC);
            }
            int i12 = iF - iC;
            long j11 = this.f63273g - ((long) i12);
            e(j11, i12, i11 < 0 ? -i11 : 0, this.f63279m);
            g(j11, iF2, this.f63279m);
            iE = iC + 3;
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f63279m = j11;
        }
        this.f63280n |= (i11 & 2) != 0;
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        this.f63275i = dVar.b();
        tg.e0 e0VarTrack = nVar.track(dVar.c(), 2);
        this.f63276j = e0VarTrack;
        this.f63277k = new b(e0VarTrack, this.f63268b, this.f63269c);
        this.f63267a.b(nVar, dVar);
    }

    public final void e(long j11, int i11, int i12, long j12) {
        if (!this.f63278l || this.f63277k.c()) {
            this.f63270d.b(i12);
            this.f63271e.b(i12);
            if (this.f63278l) {
                if (this.f63270d.c()) {
                    u uVar = this.f63270d;
                    this.f63277k.f(com.google.android.exoplayer2.util.x.l(uVar.f63385d, 3, uVar.f63386e));
                    this.f63270d.d();
                } else if (this.f63271e.c()) {
                    u uVar2 = this.f63271e;
                    this.f63277k.e(com.google.android.exoplayer2.util.x.j(uVar2.f63385d, 3, uVar2.f63386e));
                    this.f63271e.d();
                }
            } else if (this.f63270d.c() && this.f63271e.c()) {
                ArrayList arrayList = new ArrayList();
                u uVar3 = this.f63270d;
                arrayList.add(Arrays.copyOf(uVar3.f63385d, uVar3.f63386e));
                u uVar4 = this.f63271e;
                arrayList.add(Arrays.copyOf(uVar4.f63385d, uVar4.f63386e));
                u uVar5 = this.f63270d;
                com.google.android.exoplayer2.util.x.c cVarL = com.google.android.exoplayer2.util.x.l(uVar5.f63385d, 3, uVar5.f63386e);
                u uVar6 = this.f63271e;
                com.google.android.exoplayer2.util.x.b bVarJ = com.google.android.exoplayer2.util.x.j(uVar6.f63385d, 3, uVar6.f63386e);
                this.f63276j.e(new m1.b().S(this.f63275i).e0(MimeTypes.VIDEO_H264).I(com.google.android.exoplayer2.util.f.a(cVarL.f35669a, cVarL.f35670b, cVarL.f35671c)).j0(cVarL.f35674f).Q(cVarL.f35675g).a0(cVarL.f35676h).T(arrayList).E());
                this.f63278l = true;
                this.f63277k.f(cVarL);
                this.f63277k.e(bVarJ);
                this.f63270d.d();
                this.f63271e.d();
            }
        }
        if (this.f63272f.b(i12)) {
            u uVar7 = this.f63272f;
            this.f63281o.N(this.f63272f.f63385d, com.google.android.exoplayer2.util.x.q(uVar7.f63385d, uVar7.f63386e));
            this.f63281o.P(4);
            this.f63267a.a(j12, this.f63281o);
        }
        if (this.f63277k.b(j11, i11, this.f63278l, this.f63280n)) {
            this.f63280n = false;
        }
    }

    public final void f(byte[] bArr, int i11, int i12) {
        if (!this.f63278l || this.f63277k.c()) {
            this.f63270d.a(bArr, i11, i12);
            this.f63271e.a(bArr, i11, i12);
        }
        this.f63272f.a(bArr, i11, i12);
        this.f63277k.a(bArr, i11, i12);
    }

    public final void g(long j11, int i11, long j12) {
        if (!this.f63278l || this.f63277k.c()) {
            this.f63270d.e(i11);
            this.f63271e.e(i11);
        }
        this.f63272f.e(i11);
        this.f63277k.h(j11, i11, j12);
    }

    @Override // dh.m
    public void packetFinished() {
    }

    @Override // dh.m
    public void seek() {
        this.f63273g = 0L;
        this.f63280n = false;
        this.f63279m = C.TIME_UNSET;
        com.google.android.exoplayer2.util.x.a(this.f63274h);
        this.f63270d.d();
        this.f63271e.d();
        this.f63272f.d();
        b bVar = this.f63277k;
        if (bVar != null) {
            bVar.g();
        }
    }
}
