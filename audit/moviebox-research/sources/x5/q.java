package x5;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f80170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f80171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r0 f80172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f80173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f80174e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f80181l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean[] f80175f = new boolean[3];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f80176g = new u(32, 128);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f80177h = new u(33, 128);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u f80178i = new u(34, 128);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f80179j = new u(39, 128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u f80180k = new u(40, 128);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f80182m = C.TIME_UNSET;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z3.c0 f80183n = new z3.c0();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0 f80184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f80185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f80186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f80187d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f80188e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f80189f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f80190g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f80191h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f80192i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f80193j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f80194k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f80195l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f80196m;

        public a(r0 r0Var) {
            this.f80184a = r0Var;
        }

        public static boolean b(int i11) {
            return (32 <= i11 && i11 <= 35) || i11 == 39;
        }

        public static boolean c(int i11) {
            return i11 < 32 || i11 == 40;
        }

        public void a(long j11, int i11, boolean z11) {
            if (this.f80193j && this.f80190g) {
                this.f80196m = this.f80186c;
                this.f80193j = false;
            } else if (this.f80191h || this.f80190g) {
                if (z11 && this.f80192i) {
                    d(i11 + ((int) (j11 - this.f80185b)));
                }
                this.f80194k = this.f80185b;
                this.f80195l = this.f80188e;
                this.f80196m = this.f80186c;
                this.f80192i = true;
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
            long j11 = this.f80195l;
            if (j11 == C.TIME_UNSET) {
                return;
            }
            boolean z11 = this.f80196m;
            this.f80184a.f(j11, z11 ? 1 : 0, (int) (this.f80185b - this.f80194k), i11, null);
        }

        public void e(byte[] bArr, int i11, int i12) {
            if (this.f80189f) {
                int i13 = this.f80187d;
                int i14 = (i11 + 2) - i13;
                if (i14 >= i12) {
                    this.f80187d = i13 + (i12 - i11);
                } else {
                    this.f80190g = (bArr[i14] & 128) != 0;
                    this.f80189f = false;
                }
            }
        }

        public void f() {
            this.f80189f = false;
            this.f80190g = false;
            this.f80191h = false;
            this.f80192i = false;
            this.f80193j = false;
        }

        public void g(long j11, int i11, int i12, long j12, boolean z11) {
            this.f80190g = false;
            this.f80191h = false;
            this.f80188e = j12;
            this.f80187d = 0;
            this.f80185b = j11;
            if (!c(i12)) {
                if (this.f80192i && !this.f80193j) {
                    if (z11) {
                        d(i11);
                    }
                    this.f80192i = false;
                }
                if (b(i12)) {
                    this.f80191h = !this.f80193j;
                    this.f80193j = true;
                }
            }
            boolean z12 = i12 >= 16 && i12 <= 21;
            this.f80186c = z12;
            this.f80189f = z12 || i12 <= 9;
        }
    }

    public q(d0 d0Var) {
        this.f80170a = d0Var;
    }

    private void a() {
        z3.a.i(this.f80172c);
        u0.i(this.f80173d);
    }

    private void e(long j11, int i11, int i12, long j12) {
        this.f80173d.a(j11, i11, this.f80174e);
        if (!this.f80174e) {
            this.f80176g.b(i12);
            this.f80177h.b(i12);
            this.f80178i.b(i12);
            if (this.f80176g.c() && this.f80177h.c() && this.f80178i.c()) {
                this.f80172c.b(g(this.f80171b, this.f80176g, this.f80177h, this.f80178i));
                this.f80174e = true;
            }
        }
        if (this.f80179j.b(i12)) {
            u uVar = this.f80179j;
            this.f80183n.S(this.f80179j.f80241d, a4.a.q(uVar.f80241d, uVar.f80242e));
            this.f80183n.V(5);
            this.f80170a.a(j12, this.f80183n);
        }
        if (this.f80180k.b(i12)) {
            u uVar2 = this.f80180k;
            this.f80183n.S(this.f80180k.f80241d, a4.a.q(uVar2.f80241d, uVar2.f80242e));
            this.f80183n.V(5);
            this.f80170a.a(j12, this.f80183n);
        }
    }

    private void f(byte[] bArr, int i11, int i12) {
        this.f80173d.e(bArr, i11, i12);
        if (!this.f80174e) {
            this.f80176g.a(bArr, i11, i12);
            this.f80177h.a(bArr, i11, i12);
            this.f80178i.a(bArr, i11, i12);
        }
        this.f80179j.a(bArr, i11, i12);
        this.f80180k.a(bArr, i11, i12);
    }

    public static androidx.media3.common.y g(@Nullable String str, u uVar, u uVar2, u uVar3) {
        int i11 = uVar.f80242e;
        byte[] bArr = new byte[uVar2.f80242e + i11 + uVar3.f80242e];
        System.arraycopy(uVar.f80241d, 0, bArr, 0, i11);
        System.arraycopy(uVar2.f80241d, 0, bArr, uVar.f80242e, uVar2.f80242e);
        System.arraycopy(uVar3.f80241d, 0, bArr, uVar.f80242e + uVar2.f80242e, uVar3.f80242e);
        a4.a.C0019a c0019aH = a4.a.h(uVar2.f80241d, 3, uVar2.f80242e);
        return new androidx.media3.common.y.b().X(str).k0(MimeTypes.VIDEO_H265).M(z3.e.c(c0019aH.f370a, c0019aH.f371b, c0019aH.f372c, c0019aH.f373d, c0019aH.f377h, c0019aH.f378i)).r0(c0019aH.f380k).V(c0019aH.f381l).N(new androidx.media3.common.k.b().d(c0019aH.f383n).c(c0019aH.f384o).e(c0019aH.f385p).g(c0019aH.f375f + 8).b(c0019aH.f376g + 8).a()).g0(c0019aH.f382m).Y(Collections.singletonList(bArr)).I();
    }

    @Override // x5.m
    public void b(z3.c0 c0Var) {
        a();
        while (c0Var.a() > 0) {
            int iF = c0Var.f();
            int iG = c0Var.g();
            byte[] bArrE = c0Var.e();
            this.f80181l += (long) c0Var.a();
            this.f80172c.c(c0Var, c0Var.a());
            while (iF < iG) {
                int iC = a4.a.c(bArrE, iF, iG, this.f80175f);
                if (iC == iG) {
                    f(bArrE, iF, iG);
                    return;
                }
                int iE = a4.a.e(bArrE, iC);
                int i11 = iC - iF;
                if (i11 > 0) {
                    f(bArrE, iF, iC);
                }
                int i12 = iG - iC;
                long j11 = this.f80181l - ((long) i12);
                e(j11, i12, i11 < 0 ? -i11 : 0, this.f80182m);
                h(j11, i12, iE, this.f80182m);
                iF = iC + 3;
            }
        }
    }

    @Override // x5.m
    public void c(long j11, int i11) {
        this.f80182m = j11;
    }

    @Override // x5.m
    public void d(u4.u uVar, i0.d dVar) {
        dVar.a();
        this.f80171b = dVar.b();
        r0 r0VarTrack = uVar.track(dVar.c(), 2);
        this.f80172c = r0VarTrack;
        this.f80173d = new a(r0VarTrack);
        this.f80170a.b(uVar, dVar);
    }

    public final void h(long j11, int i11, int i12, long j12) {
        this.f80173d.g(j11, i11, i12, j12, this.f80174e);
        if (!this.f80174e) {
            this.f80176g.e(i12);
            this.f80177h.e(i12);
            this.f80178i.e(i12);
        }
        this.f80179j.e(i12);
        this.f80180k.e(i12);
    }

    @Override // x5.m
    public void packetFinished() {
    }

    @Override // x5.m
    public void seek() {
        this.f80181l = 0L;
        this.f80182m = C.TIME_UNSET;
        a4.a.a(this.f80175f);
        this.f80176g.d();
        this.f80177h.d();
        this.f80178i.d();
        this.f80179j.d();
        this.f80180k.d();
        a aVar = this.f80173d;
        if (aVar != null) {
            aVar.f();
        }
    }
}
