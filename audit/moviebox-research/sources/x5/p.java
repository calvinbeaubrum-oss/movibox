package x5;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f80120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f80121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f80122c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f80126g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f80128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r0 f80129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f80130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f80131l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f80133n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f80127h = new boolean[3];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f80123d = new u(7, 128);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f80124e = new u(8, 128);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f80125f = new u(6, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f80132m = C.TIME_UNSET;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final z3.c0 f80134o = new z3.c0();

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0 f80135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f80136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f80137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<a4.a.c> f80138d = new SparseArray<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray<a4.a.b> f80139e = new SparseArray<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a4.b f80140f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f80141g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f80142h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f80143i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f80144j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f80145k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f80146l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public a f80147m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public a f80148n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f80149o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f80150p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f80151q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f80152r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f80153s;

        /* JADX INFO: compiled from: source.java */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f80154a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f80155b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            public a4.a.c f80156c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f80157d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f80158e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f80159f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f80160g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f80161h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f80162i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f80163j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean f80164k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f80165l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f80166m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f80167n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public int f80168o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public int f80169p;

            public a() {
            }

            public void b() {
                this.f80155b = false;
                this.f80154a = false;
            }

            public final boolean c(a aVar) {
                int i11;
                int i12;
                int i13;
                boolean z11;
                if (!this.f80154a) {
                    return false;
                }
                if (!aVar.f80154a) {
                    return true;
                }
                a4.a.c cVar = (a4.a.c) z3.a.i(this.f80156c);
                a4.a.c cVar2 = (a4.a.c) z3.a.i(aVar.f80156c);
                return (this.f80159f == aVar.f80159f && this.f80160g == aVar.f80160g && this.f80161h == aVar.f80161h && (!this.f80162i || !aVar.f80162i || this.f80163j == aVar.f80163j) && (((i11 = this.f80157d) == (i12 = aVar.f80157d) || (i11 != 0 && i12 != 0)) && (((i13 = cVar.f402n) != 0 || cVar2.f402n != 0 || (this.f80166m == aVar.f80166m && this.f80167n == aVar.f80167n)) && ((i13 != 1 || cVar2.f402n != 1 || (this.f80168o == aVar.f80168o && this.f80169p == aVar.f80169p)) && (z11 = this.f80164k) == aVar.f80164k && (!z11 || this.f80165l == aVar.f80165l))))) ? false : true;
            }

            public boolean d() {
                int i11;
                return this.f80155b && ((i11 = this.f80158e) == 7 || i11 == 2);
            }

            public void e(a4.a.c cVar, int i11, int i12, int i13, int i14, boolean z11, boolean z12, boolean z13, boolean z14, int i15, int i16, int i17, int i18, int i19) {
                this.f80156c = cVar;
                this.f80157d = i11;
                this.f80158e = i12;
                this.f80159f = i13;
                this.f80160g = i14;
                this.f80161h = z11;
                this.f80162i = z12;
                this.f80163j = z13;
                this.f80164k = z14;
                this.f80165l = i15;
                this.f80166m = i16;
                this.f80167n = i17;
                this.f80168o = i18;
                this.f80169p = i19;
                this.f80154a = true;
                this.f80155b = true;
            }

            public void f(int i11) {
                this.f80158e = i11;
                this.f80155b = true;
            }
        }

        public b(r0 r0Var, boolean z11, boolean z12) {
            this.f80135a = r0Var;
            this.f80136b = z11;
            this.f80137c = z12;
            this.f80147m = new a();
            this.f80148n = new a();
            byte[] bArr = new byte[128];
            this.f80141g = bArr;
            this.f80140f = new a4.b(bArr, 0, 0);
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
            if (this.f80145k) {
                int i16 = i12 - i11;
                byte[] bArr2 = this.f80141g;
                int length = bArr2.length;
                int i17 = this.f80142h;
                if (length < i17 + i16) {
                    this.f80141g = Arrays.copyOf(bArr2, (i17 + i16) * 2);
                }
                System.arraycopy(bArr, i11, this.f80141g, this.f80142h, i16);
                int i18 = this.f80142h + i16;
                this.f80142h = i18;
                this.f80140f.i(this.f80141g, 0, i18);
                if (this.f80140f.b(8)) {
                    this.f80140f.k();
                    int iE2 = this.f80140f.e(2);
                    this.f80140f.l(5);
                    if (this.f80140f.c()) {
                        this.f80140f.h();
                        if (this.f80140f.c()) {
                            int iH2 = this.f80140f.h();
                            if (!this.f80137c) {
                                this.f80145k = false;
                                this.f80148n.f(iH2);
                                return;
                            }
                            if (this.f80140f.c()) {
                                int iH3 = this.f80140f.h();
                                if (this.f80139e.indexOfKey(iH3) < 0) {
                                    this.f80145k = false;
                                    return;
                                }
                                a4.a.b bVar = this.f80139e.get(iH3);
                                a4.a.c cVar = this.f80138d.get(bVar.f387b);
                                if (cVar.f399k) {
                                    if (!this.f80140f.b(2)) {
                                        return;
                                    } else {
                                        this.f80140f.l(2);
                                    }
                                }
                                if (this.f80140f.b(cVar.f401m)) {
                                    int iE3 = this.f80140f.e(cVar.f401m);
                                    if (!cVar.f400l) {
                                        if (this.f80140f.b(1)) {
                                            boolean zD2 = this.f80140f.d();
                                            if (!zD2) {
                                                z11 = zD2;
                                            } else {
                                                if (!this.f80140f.b(1)) {
                                                    return;
                                                }
                                                z11 = zD2;
                                                zD = this.f80140f.d();
                                                z12 = true;
                                            }
                                            if (this.f80143i == 5) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            if (z13) {
                                                iH = 0;
                                            } else if (!this.f80140f.c()) {
                                                return;
                                            } else {
                                                iH = this.f80140f.h();
                                            }
                                            i13 = cVar.f402n;
                                            if (i13 != 0) {
                                                if (this.f80140f.b(cVar.f403o)) {
                                                    iE = this.f80140f.e(cVar.f403o);
                                                    if (bVar.f388c || z11) {
                                                        i14 = iE;
                                                    } else {
                                                        if (!this.f80140f.c()) {
                                                            return;
                                                        }
                                                        iG = this.f80140f.g();
                                                        i14 = iE;
                                                    }
                                                    i15 = 0;
                                                    iG2 = 0;
                                                    this.f80148n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                                    this.f80145k = false;
                                                }
                                                return;
                                            }
                                            if (i13 == 1 || cVar.f404p) {
                                                i14 = 0;
                                            } else {
                                                if (!this.f80140f.c()) {
                                                    return;
                                                }
                                                int iG3 = this.f80140f.g();
                                                if (!bVar.f388c || z11) {
                                                    i15 = iG3;
                                                    i14 = 0;
                                                    iG = 0;
                                                    iG2 = 0;
                                                } else {
                                                    if (!this.f80140f.c()) {
                                                        return;
                                                    }
                                                    iG2 = this.f80140f.g();
                                                    i15 = iG3;
                                                    i14 = 0;
                                                    iG = 0;
                                                }
                                            }
                                            this.f80148n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                            this.f80145k = false;
                                            iG = 0;
                                            i15 = 0;
                                            iG2 = 0;
                                            this.f80148n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                            this.f80145k = false;
                                        }
                                        return;
                                    }
                                    z11 = false;
                                    z12 = false;
                                    zD = false;
                                    if (this.f80143i == 5) {
                                        z13 = true;
                                    } else {
                                        z13 = false;
                                    }
                                    if (z13) {
                                        iH = 0;
                                    } else if (!this.f80140f.c()) {
                                        return;
                                    } else {
                                        iH = this.f80140f.h();
                                    }
                                    i13 = cVar.f402n;
                                    if (i13 != 0) {
                                        if (i13 == 1) {
                                        }
                                        i14 = 0;
                                    } else {
                                        if (this.f80140f.b(cVar.f403o)) {
                                            return;
                                        }
                                        iE = this.f80140f.e(cVar.f403o);
                                        if (bVar.f388c) {
                                        }
                                        i14 = iE;
                                    }
                                    iG = 0;
                                    i15 = 0;
                                    iG2 = 0;
                                    this.f80148n.e(cVar, iE2, iH2, iE3, iH3, z11, z12, zD, z13, iH, i14, iG, i15, iG2);
                                    this.f80145k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean b(long j11, int i11, boolean z11) {
            boolean z12 = false;
            if (this.f80143i == 9 || (this.f80137c && this.f80148n.c(this.f80147m))) {
                if (z11 && this.f80149o) {
                    d(i11 + ((int) (j11 - this.f80144j)));
                }
                this.f80150p = this.f80144j;
                this.f80151q = this.f80146l;
                this.f80152r = false;
                this.f80149o = true;
            }
            boolean zD = this.f80136b ? this.f80148n.d() : this.f80153s;
            boolean z13 = this.f80152r;
            int i12 = this.f80143i;
            if (i12 == 5 || (zD && i12 == 1)) {
                z12 = true;
            }
            boolean z14 = z13 | z12;
            this.f80152r = z14;
            return z14;
        }

        public boolean c() {
            return this.f80137c;
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
            long j11 = this.f80151q;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z11 = this.f80152r;
            this.f80135a.f(j11, z11 ? 1 : 0, (int) (this.f80144j - this.f80150p), i11, null);
        }

        public void e(a4.a.b bVar) {
            this.f80139e.append(bVar.f386a, bVar);
        }

        public void f(a4.a.c cVar) {
            this.f80138d.append(cVar.f392d, cVar);
        }

        public void g() {
            this.f80145k = false;
            this.f80149o = false;
            this.f80148n.b();
        }

        public void h(long j11, int i11, long j12, boolean z11) {
            this.f80143i = i11;
            this.f80146l = j12;
            this.f80144j = j11;
            this.f80153s = z11;
            if (!this.f80136b || i11 != 1) {
                if (!this.f80137c) {
                    return;
                }
                if (i11 != 5 && i11 != 1 && i11 != 2) {
                    return;
                }
            }
            a aVar = this.f80147m;
            this.f80147m = this.f80148n;
            this.f80148n = aVar;
            aVar.b();
            this.f80142h = 0;
            this.f80145k = true;
        }
    }

    public p(d0 d0Var, boolean z11, boolean z12) {
        this.f80120a = d0Var;
        this.f80121b = z11;
        this.f80122c = z12;
    }

    private void a() {
        z3.a.i(this.f80129j);
        u0.i(this.f80130k);
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        a();
        int iF = c0Var.f();
        int iG = c0Var.g();
        byte[] bArrE = c0Var.e();
        this.f80126g += (long) c0Var.a();
        this.f80129j.c(c0Var, c0Var.a());
        while (true) {
            int iC = a4.a.c(bArrE, iF, iG, this.f80127h);
            if (iC == iG) {
                f(bArrE, iF, iG);
                return;
            }
            int iF2 = a4.a.f(bArrE, iC);
            int i11 = iC - iF;
            if (i11 > 0) {
                f(bArrE, iF, iC);
            }
            int i12 = iG - iC;
            long j11 = this.f80126g - ((long) i12);
            e(j11, i12, i11 < 0 ? -i11 : 0, this.f80132m);
            g(j11, iF2, this.f80132m);
            iF = iC + 3;
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80132m = j11;
        this.f80133n |= (i11 & 2) != 0;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80128i = dVar.b();
        r0 r0VarTrack = uVar.track(dVar.c(), 2);
        this.f80129j = r0VarTrack;
        this.f80130k = new b(r0VarTrack, this.f80121b, this.f80122c);
        this.f80120a.b(uVar, dVar);
    }

    public final void e(long j11, int i11, int i12, long j12) {
        if (!this.f80131l || this.f80130k.c()) {
            this.f80123d.b(i12);
            this.f80124e.b(i12);
            if (this.f80131l) {
                if (this.f80123d.c()) {
                    u uVar = this.f80123d;
                    this.f80130k.f(a4.a.l(uVar.f80241d, 3, uVar.f80242e));
                    this.f80123d.d();
                } else if (this.f80124e.c()) {
                    u uVar2 = this.f80124e;
                    this.f80130k.e(a4.a.j(uVar2.f80241d, 3, uVar2.f80242e));
                    this.f80124e.d();
                }
            } else if (this.f80123d.c() && this.f80124e.c()) {
                ArrayList arrayList = new ArrayList();
                u uVar3 = this.f80123d;
                arrayList.add(Arrays.copyOf(uVar3.f80241d, uVar3.f80242e));
                u uVar4 = this.f80124e;
                arrayList.add(Arrays.copyOf(uVar4.f80241d, uVar4.f80242e));
                u uVar5 = this.f80123d;
                a4.a.c cVarL = a4.a.l(uVar5.f80241d, 3, uVar5.f80242e);
                u uVar6 = this.f80124e;
                a4.a.b bVarJ = a4.a.j(uVar6.f80241d, 3, uVar6.f80242e);
                this.f80129j.b(new androidx.media3.common.y.b().X(this.f80128i).k0(MimeTypes.VIDEO_H264).M(z3.e.a(cVarL.f389a, cVarL.f390b, cVarL.f391c)).r0(cVarL.f394f).V(cVarL.f395g).N(new androidx.media3.common.k.b().d(cVarL.f405q).c(cVarL.f406r).e(cVarL.f407s).g(cVarL.f397i + 8).b(cVarL.f398j + 8).a()).g0(cVarL.f396h).Y(arrayList).I());
                this.f80131l = true;
                this.f80130k.f(cVarL);
                this.f80130k.e(bVarJ);
                this.f80123d.d();
                this.f80124e.d();
            }
        }
        if (this.f80125f.b(i12)) {
            u uVar7 = this.f80125f;
            this.f80134o.S(this.f80125f.f80241d, a4.a.q(uVar7.f80241d, uVar7.f80242e));
            this.f80134o.U(4);
            this.f80120a.a(j12, this.f80134o);
        }
        if (this.f80130k.b(j11, i11, this.f80131l)) {
            this.f80133n = false;
        }
    }

    public final void f(byte[] bArr, int i11, int i12) {
        if (!this.f80131l || this.f80130k.c()) {
            this.f80123d.a(bArr, i11, i12);
            this.f80124e.a(bArr, i11, i12);
        }
        this.f80125f.a(bArr, i11, i12);
        this.f80130k.a(bArr, i11, i12);
    }

    public final void g(long j11, int i11, long j12) {
        if (!this.f80131l || this.f80130k.c()) {
            this.f80123d.e(i11);
            this.f80124e.e(i11);
        }
        this.f80125f.e(i11);
        this.f80130k.h(j11, i11, j12, this.f80133n);
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        this.f80126g = 0L;
        this.f80133n = false;
        this.f80132m = C.TIME_UNSET;
        a4.a.a(this.f80127h);
        this.f80123d.d();
        this.f80124e.d();
        this.f80125f.d();
        b bVar = this.f80130k;
        if (bVar != null) {
            bVar.g();
        }
    }
}
