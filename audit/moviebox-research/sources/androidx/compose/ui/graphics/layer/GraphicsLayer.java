package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.n1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.q4;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.graphics.z0;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class GraphicsLayer {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f4168x = new a(null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final f0 f4169y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GraphicsLayerImpl f4170a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Outline f4175f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m4 f4180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Path f4181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Path f4182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o4 f4184o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f4185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.compose.ui.graphics.layer.a f4186q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4187r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4188s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f4189t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f4190u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4191v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RectF f4192w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q2.e f4171b = z1.e.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutDirection f4172c = LayoutDirection.Ltr;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super z1.g, Unit> f4173d = new Function1<z1.g, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$drawBlock$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(z1.g gVar) {
            invoke2(gVar);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(z1.g gVar) {
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<z1.g, Unit> f4174e = new Function1<z1.g, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayer$clipDrawBlock$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(z1.g gVar) {
            invoke2(gVar);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(z1.g gVar) {
            Path path = this.this$0.f4181l;
            if (!this.this$0.f4183n || !this.this$0.k() || path == null) {
                this.this$0.f4173d.invoke(gVar);
                return;
            }
            Function1 function1 = this.this$0.f4173d;
            int iB = v1.f4361a.b();
            z1.d dVarQ0 = gVar.Q0();
            long jI = dVarQ0.i();
            dVarQ0.e().d();
            try {
                dVarQ0.c().b(path, iB);
                function1.invoke(gVar);
            } finally {
                dVarQ0.e().k();
                dVarQ0.f(jI);
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4176g = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        f0 f0Var;
        if (e0.f4291a.a()) {
            f0Var = g0.f4293a;
        } else {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                f0Var = i0.f4295a;
            } else {
                f0Var = (i11 < 22 || !r0.f4304a.a()) ? g0.f4293a : h0.f4294a;
            }
        }
        f4169y = f0Var;
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl, e0 e0Var) {
        this.f4170a = graphicsLayerImpl;
        y1.g.a aVar = y1.g.f81070b;
        this.f4177h = aVar.c();
        this.f4178i = y1.m.f81091b.a();
        this.f4186q = new androidx.compose.ui.graphics.layer.a();
        graphicsLayerImpl.t(false);
        this.f4188s = q2.p.f74244b.a();
        this.f4189t = q2.t.f74253b.a();
        this.f4190u = aVar.b();
    }

    public final Outline A() {
        Outline outline = this.f4175f;
        if (outline != null) {
            return outline;
        }
        Outline outline2 = new Outline();
        this.f4175f = outline2;
        return outline2;
    }

    public final RectF B() {
        RectF rectF = this.f4192w;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF();
        this.f4192w = rectF2;
        return rectF2;
    }

    public final void C() {
        this.f4185p++;
    }

    public final void D() {
        this.f4185p--;
        f();
    }

    public final void E(q2.e eVar, LayoutDirection layoutDirection, long j11, Function1<? super z1.g, Unit> function1) {
        a0(j11);
        this.f4171b = eVar;
        this.f4172c = layoutDirection;
        this.f4173d = function1;
        this.f4170a.F(true);
        F();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0093 A[LOOP:0: B:20:0x005c->B:30:0x0093, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0096 A[EDGE_INSN: B:34:0x0096->B:31:0x0096 BREAK  A[LOOP:0: B:20:0x005c->B:30:0x0093], SYNTHETIC] */
    public final void F() {
        androidx.compose.ui.graphics.layer.a aVar = this.f4186q;
        aVar.f4208b = aVar.f4207a;
        MutableScatterSet mutableScatterSet = aVar.f4209c;
        if (mutableScatterSet != null && mutableScatterSet.e()) {
            MutableScatterSet mutableScatterSetA = aVar.f4210d;
            if (mutableScatterSetA == null) {
                mutableScatterSetA = androidx.collection.u0.a();
                aVar.f4210d = mutableScatterSetA;
            }
            mutableScatterSetA.i(mutableScatterSet);
            mutableScatterSet.m();
        }
        aVar.f4211e = true;
        this.f4170a.H(this.f4171b, this.f4172c, this, this.f4174e);
        aVar.f4211e = false;
        GraphicsLayer graphicsLayer = aVar.f4208b;
        if (graphicsLayer != null) {
            graphicsLayer.D();
        }
        MutableScatterSet mutableScatterSet2 = aVar.f4210d;
        if (mutableScatterSet2 == null || !mutableScatterSet2.e()) {
            return;
        }
        Object[] objArr = mutableScatterSet2.f1898b;
        long[] jArr = mutableScatterSet2.f1897a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i11 != length) {
                        break;
                        break;
                    }
                    i11++;
                } else {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            ((GraphicsLayer) objArr[(i11 << 3) + i13]).D();
                        }
                        j11 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    } else if (i11 != length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        mutableScatterSet2.m();
    }

    public final void G() {
        if (this.f4170a.l()) {
            return;
        }
        try {
            F();
        } catch (Throwable unused) {
        }
    }

    public final void H() {
        if (this.f4187r) {
            return;
        }
        this.f4187r = true;
        f();
    }

    public final void I() {
        this.f4180k = null;
        this.f4181l = null;
        this.f4178i = y1.m.f81091b.a();
        this.f4177h = y1.g.f81070b.c();
        this.f4179j = 0.0f;
        this.f4176g = true;
        this.f4183n = false;
    }

    public final void J(float f11) {
        if (this.f4170a.getAlpha() == f11) {
            return;
        }
        this.f4170a.setAlpha(f11);
    }

    public final void K(long j11) {
        if (w1.m(j11, this.f4170a.A())) {
            return;
        }
        this.f4170a.r(j11);
    }

    public final void L(float f11) {
        if (this.f4170a.s() == f11) {
            return;
        }
        this.f4170a.d(f11);
    }

    public final void M(boolean z11) {
        if (this.f4191v != z11) {
            this.f4191v = z11;
            this.f4176g = true;
            e();
        }
    }

    public final void N(int i11) {
        if (b.e(this.f4170a.p(), i11)) {
            return;
        }
        this.f4170a.J(i11);
    }

    public final void O(Path path) {
        I();
        this.f4181l = path;
        e();
    }

    public final void P(long j11) {
        if (y1.g.j(this.f4190u, j11)) {
            return;
        }
        this.f4190u = j11;
        this.f4170a.I(j11);
    }

    public final void Q(long j11, long j12) {
        this.f4170a.x(q2.p.h(j11), q2.p.i(j11), j12);
    }

    public final void R(long j11, long j12) {
        W(j11, j12, 0.0f);
    }

    public final void S(y4 y4Var) {
        this.f4170a.n();
        if (Intrinsics.b(null, y4Var)) {
            return;
        }
        this.f4170a.c(y4Var);
    }

    public final void T(float f11) {
        if (this.f4170a.B() == f11) {
            return;
        }
        this.f4170a.e(f11);
    }

    public final void U(float f11) {
        if (this.f4170a.o() == f11) {
            return;
        }
        this.f4170a.f(f11);
    }

    public final void V(float f11) {
        if (this.f4170a.q() == f11) {
            return;
        }
        this.f4170a.g(f11);
    }

    public final void W(long j11, long j12, float f11) {
        if (y1.g.j(this.f4177h, j11) && y1.m.f(this.f4178i, j12) && this.f4179j == f11 && this.f4181l == null) {
            return;
        }
        I();
        this.f4177h = j11;
        this.f4178i = j12;
        this.f4179j = f11;
        e();
    }

    public final void X(float f11) {
        if (this.f4170a.v() == f11) {
            return;
        }
        this.f4170a.b(f11);
    }

    public final void Y(float f11) {
        if (this.f4170a.E() == f11) {
            return;
        }
        this.f4170a.h(f11);
    }

    public final void Z(float f11) {
        if (this.f4170a.K() == f11) {
            return;
        }
        this.f4170a.w(f11);
        this.f4176g = true;
        e();
    }

    public final void a0(long j11) {
        if (q2.t.e(this.f4189t, j11)) {
            return;
        }
        this.f4189t = j11;
        Q(this.f4188s, j11);
        if (this.f4178i == 9205357640488583168L) {
            this.f4176g = true;
            e();
        }
    }

    public final void b0(long j11) {
        if (w1.m(j11, this.f4170a.C())) {
            return;
        }
        this.f4170a.u(j11);
    }

    public final void c0(long j11) {
        if (q2.p.g(this.f4188s, j11)) {
            return;
        }
        this.f4188s = j11;
        Q(j11, this.f4189t);
    }

    public final void d(GraphicsLayer graphicsLayer) {
        if (this.f4186q.i(graphicsLayer)) {
            graphicsLayer.C();
        }
    }

    public final void d0(float f11) {
        if (this.f4170a.z() == f11) {
            return;
        }
        this.f4170a.j(f11);
    }

    public final void e() {
        if (this.f4176g) {
            Outline outline = null;
            if (this.f4191v || u() > 0.0f) {
                Path path = this.f4181l;
                if (path != null) {
                    RectF rectFB = B();
                    if (!(path instanceof androidx.compose.ui.graphics.u0)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((androidx.compose.ui.graphics.u0) path).o().computeBounds(rectFB, false);
                    Outline outlineG0 = g0(path);
                    if (outlineG0 != null) {
                        outlineG0.setAlpha(i());
                        outline = outlineG0;
                    }
                    this.f4170a.G(outline, q2.u.a(Math.round(rectFB.width()), Math.round(rectFB.height())));
                    if (this.f4183n && this.f4191v) {
                        this.f4170a.t(false);
                        this.f4170a.k();
                    } else {
                        this.f4170a.t(this.f4191v);
                    }
                } else {
                    this.f4170a.t(this.f4191v);
                    y1.m.f81091b.b();
                    Outline outlineA = A();
                    long jD = q2.u.d(this.f4189t);
                    long j11 = this.f4177h;
                    long j12 = this.f4178i;
                    long j13 = j12 == 9205357640488583168L ? jD : j12;
                    outlineA.setRoundRect(Math.round(y1.g.m(j11)), Math.round(y1.g.n(j11)), Math.round(y1.g.m(j11) + y1.m.i(j13)), Math.round(y1.g.n(j11) + y1.m.g(j13)), this.f4179j);
                    outlineA.setAlpha(i());
                    this.f4170a.G(outlineA, q2.u.c(j13));
                }
            } else {
                this.f4170a.t(false);
                this.f4170a.G(null, q2.t.f74253b.a());
            }
        }
        this.f4176g = false;
    }

    public final void e0(float f11) {
        if (this.f4170a.y() == f11) {
            return;
        }
        this.f4170a.a(f11);
    }

    public final void f() {
        if (this.f4187r && this.f4185p == 0) {
            g();
        }
    }

    public final void f0(Canvas canvas) {
        float fH = q2.p.h(this.f4188s);
        float fI = q2.p.i(this.f4188s);
        float fH2 = q2.p.h(this.f4188s) + q2.t.g(this.f4189t);
        float fI2 = q2.p.i(this.f4188s) + q2.t.f(this.f4189t);
        float fI3 = i();
        x1 x1VarL = l();
        int iJ = j();
        if (fI3 < 1.0f || !e1.E(iJ, e1.f4102a.B()) || x1VarL != null || b.e(m(), b.f4212a.c())) {
            o4 o4VarA = this.f4184o;
            if (o4VarA == null) {
                o4VarA = androidx.compose.ui.graphics.t0.a();
                this.f4184o = o4VarA;
            }
            o4VarA.setAlpha(fI3);
            o4VarA.o(iJ);
            o4VarA.A(x1VarL);
            canvas.saveLayer(fH, fI, fH2, fI2, o4VarA.x());
        } else {
            canvas.save();
        }
        canvas.translate(fH, fI);
        canvas.concat(this.f4170a.D());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0059 A[LOOP:0: B:10:0x0022->B:20:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x005c A[EDGE_INSN: B:25:0x005c->B:21:0x005c BREAK  A[LOOP:0: B:10:0x0022->B:20:0x0059], SYNTHETIC] */
    public final void g() {
        androidx.compose.ui.graphics.layer.a aVar = this.f4186q;
        GraphicsLayer graphicsLayer = aVar.f4207a;
        if (graphicsLayer != null) {
            graphicsLayer.D();
            aVar.f4207a = null;
        }
        MutableScatterSet mutableScatterSet = aVar.f4209c;
        if (mutableScatterSet != null) {
            Object[] objArr = mutableScatterSet.f1898b;
            long[] jArr = mutableScatterSet.f1897a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i11 != length) {
                            break;
                            break;
                        }
                        i11++;
                    } else {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                ((GraphicsLayer) objArr[(i11 << 3) + i13]).D();
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        } else if (i11 != length) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
            }
            mutableScatterSet.m();
        }
        this.f4170a.k();
    }

    public final Outline g0(Path path) {
        Outline outline;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 28 || path.a()) {
            Outline outlineA = A();
            if (i11 >= 30) {
                l0.f4299a.a(outlineA, path);
            } else {
                if (!(path instanceof androidx.compose.ui.graphics.u0)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                outlineA.setConvexPath(((androidx.compose.ui.graphics.u0) path).o());
            }
            this.f4183n = !outlineA.canClip();
            outline = outlineA;
        } else {
            Outline outline2 = this.f4175f;
            if (outline2 != null) {
                outline2.setEmpty();
            }
            this.f4183n = true;
            this.f4170a.F(true);
            outline = null;
        }
        this.f4181l = path;
        return outline;
    }

    public final void h(o1 o1Var, GraphicsLayer graphicsLayer) {
        if (this.f4187r) {
            return;
        }
        e();
        G();
        boolean z11 = u() > 0.0f;
        if (z11) {
            o1Var.l();
        }
        Canvas canvasD = androidx.compose.ui.graphics.h0.d(o1Var);
        boolean z12 = !canvasD.isHardwareAccelerated();
        if (z12) {
            canvasD.save();
            f0(canvasD);
        }
        boolean z13 = z12 && this.f4191v;
        if (z13) {
            o1Var.d();
            m4 m4VarN = n();
            if (m4VarN instanceof m4.b) {
                n1.e(o1Var, m4VarN.a(), 0, 2, null);
            } else if (m4VarN instanceof m4.c) {
                Path pathA = this.f4182m;
                if (pathA != null) {
                    pathA.rewind();
                } else {
                    pathA = z0.a();
                    this.f4182m = pathA;
                }
                q4.b(pathA, ((m4.c) m4VarN).b(), null, 2, null);
                n1.c(o1Var, pathA, 0, 2, null);
            } else if (m4VarN instanceof m4.a) {
                n1.c(o1Var, ((m4.a) m4VarN).b(), 0, 2, null);
            }
        }
        if (graphicsLayer != null) {
            graphicsLayer.d(this);
        }
        this.f4170a.L(o1Var);
        if (z13) {
            o1Var.k();
        }
        if (z11) {
            o1Var.n();
        }
        if (z12) {
            canvasD.restore();
        }
    }

    public final float i() {
        return this.f4170a.getAlpha();
    }

    public final int j() {
        return this.f4170a.m();
    }

    public final boolean k() {
        return this.f4191v;
    }

    public final x1 l() {
        return this.f4170a.i();
    }

    public final int m() {
        return this.f4170a.p();
    }

    public final m4 n() {
        m4 m4Var = this.f4180k;
        Path path = this.f4181l;
        if (m4Var != null) {
            return m4Var;
        }
        if (path != null) {
            m4.a aVar = new m4.a(path);
            this.f4180k = aVar;
            return aVar;
        }
        long jD = q2.u.d(this.f4189t);
        long j11 = this.f4177h;
        long j12 = this.f4178i;
        if (j12 != 9205357640488583168L) {
            jD = j12;
        }
        float fM = y1.g.m(j11);
        float fN = y1.g.n(j11);
        float fI = fM + y1.m.i(jD);
        float fG = fN + y1.m.g(jD);
        float f11 = this.f4179j;
        m4 cVar = f11 > 0.0f ? new m4.c(y1.l.c(fM, fN, fI, fG, y1.b.b(f11, 0.0f, 2, null))) : new m4.b(new y1.i(fM, fN, fI, fG));
        this.f4180k = cVar;
        return cVar;
    }

    public final long o() {
        return this.f4190u;
    }

    public final float p() {
        return this.f4170a.B();
    }

    public final float q() {
        return this.f4170a.o();
    }

    public final float r() {
        return this.f4170a.q();
    }

    public final float s() {
        return this.f4170a.v();
    }

    public final float t() {
        return this.f4170a.E();
    }

    public final float u() {
        return this.f4170a.K();
    }

    public final long v() {
        return this.f4189t;
    }

    public final long w() {
        return this.f4188s;
    }

    public final float x() {
        return this.f4170a.z();
    }

    public final float y() {
        return this.f4170a.y();
    }

    public final boolean z() {
        return this.f4187r;
    }
}
