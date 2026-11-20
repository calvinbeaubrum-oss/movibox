package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.os.Build;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.g5;
import androidx.compose.ui.graphics.k4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.o4;
import androidx.compose.ui.graphics.q4;
import androidx.compose.ui.graphics.y3;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class GraphicsLayerOwnerLayer implements androidx.compose.ui.node.w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GraphicsLayer f5336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4 f5337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AndroidComposeView f5338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> f5339d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f5340f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5342h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f5344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5345k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5349o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public m4 f5351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Path f5352r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public o4 f5353s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5354t;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5341g = q2.u.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f5343i = k4.c(null, 1, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q2.e f5346l = q2.g.b(1.0f, 0.0f, 2, null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LayoutDirection f5347m = LayoutDirection.Ltr;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z1.a f5348n = new z1.a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f5350p = g5.f4145a.a();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function1<z1.g, Unit> f5355u = new Function1<z1.g, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
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
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = this.this$0;
            androidx.compose.ui.graphics.o1 o1VarE = gVar.Q0().e();
            Function2 function2 = graphicsLayerOwnerLayer.f5339d;
            if (function2 != null) {
                function2.invoke(o1VarE, gVar.Q0().g());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, c4 c4Var, AndroidComposeView androidComposeView, Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.f5336a = graphicsLayer;
        this.f5337b = c4Var;
        this.f5338c = androidComposeView;
        this.f5339d = function2;
        this.f5340f = function0;
    }

    public final void b(androidx.compose.ui.graphics.o1 o1Var) {
        if (this.f5336a.k()) {
            m4 m4VarN = this.f5336a.n();
            if (m4VarN instanceof m4.b) {
                androidx.compose.ui.graphics.n1.e(o1Var, ((m4.b) m4VarN).b(), 0, 2, null);
                return;
            }
            if (!(m4VarN instanceof m4.c)) {
                if (m4VarN instanceof m4.a) {
                    androidx.compose.ui.graphics.n1.c(o1Var, ((m4.a) m4VarN).b(), 0, 2, null);
                    return;
                }
                return;
            }
            Path pathA = this.f5352r;
            if (pathA == null) {
                pathA = androidx.compose.ui.graphics.z0.a();
                this.f5352r = pathA;
            }
            pathA.reset();
            q4.b(pathA, ((m4.c) m4VarN).b(), null, 2, null);
            androidx.compose.ui.graphics.n1.c(o1Var, pathA, 0, 2, null);
        }
    }

    public final float[] c() {
        float[] fArrD = d();
        float[] fArrC = this.f5344j;
        if (fArrC == null) {
            fArrC = k4.c(null, 1, null);
            this.f5344j = fArrC;
        }
        if (g1.a(fArrD, fArrC)) {
            return fArrC;
        }
        return null;
    }

    public final float[] d() {
        g();
        return this.f5343i;
    }

    @Override // androidx.compose.ui.node.w0
    public void destroy() {
        this.f5339d = null;
        this.f5340f = null;
        this.f5342h = true;
        e(false);
        c4 c4Var = this.f5337b;
        if (c4Var != null) {
            c4Var.b(this.f5336a);
            this.f5338c.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void drawLayer(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer) {
        Canvas canvasD = androidx.compose.ui.graphics.h0.d(o1Var);
        if (canvasD.isHardwareAccelerated()) {
            updateDisplayList();
            this.f5354t = this.f5336a.u() > 0.0f;
            z1.d dVarQ0 = this.f5348n.Q0();
            dVarQ0.h(o1Var);
            dVarQ0.d(graphicsLayer);
            androidx.compose.ui.graphics.layer.d.a(this.f5348n, this.f5336a);
            return;
        }
        float fH = q2.p.h(this.f5336a.w());
        float fI = q2.p.i(this.f5336a.w());
        float fG = fH + q2.t.g(this.f5341g);
        float f11 = fI + q2.t.f(this.f5341g);
        if (this.f5336a.i() < 1.0f) {
            o4 o4VarA = this.f5353s;
            if (o4VarA == null) {
                o4VarA = androidx.compose.ui.graphics.t0.a();
                this.f5353s = o4VarA;
            }
            o4VarA.setAlpha(this.f5336a.i());
            canvasD.saveLayer(fH, fI, fG, f11, o4VarA.x());
        } else {
            o1Var.d();
        }
        o1Var.c(fH, fI);
        o1Var.o(d());
        if (this.f5336a.k()) {
            b(o1Var);
        }
        Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2 = this.f5339d;
        if (function2 != null) {
            function2.invoke(o1Var, null);
        }
        o1Var.k();
    }

    public final void e(boolean z11) {
        if (z11 != this.f5345k) {
            this.f5345k = z11;
            this.f5338c.notifyLayerIsDirty$ui_release(this, z11);
        }
    }

    public final void f() {
        if (Build.VERSION.SDK_INT >= 26) {
            d3.f5460a.a(this.f5338c);
        } else {
            this.f5338c.invalidate();
        }
    }

    public final void g() {
        GraphicsLayer graphicsLayer = this.f5336a;
        long jB = y1.h.d(graphicsLayer.o()) ? y1.n.b(q2.u.d(this.f5341g)) : graphicsLayer.o();
        k4.h(this.f5343i);
        float[] fArr = this.f5343i;
        float[] fArrC = k4.c(null, 1, null);
        k4.q(fArrC, -y1.g.m(jB), -y1.g.n(jB), 0.0f, 4, null);
        k4.n(fArr, fArrC);
        float[] fArr2 = this.f5343i;
        float[] fArrC2 = k4.c(null, 1, null);
        k4.q(fArrC2, graphicsLayer.x(), graphicsLayer.y(), 0.0f, 4, null);
        k4.i(fArrC2, graphicsLayer.p());
        k4.j(fArrC2, graphicsLayer.q());
        k4.k(fArrC2, graphicsLayer.r());
        k4.m(fArrC2, graphicsLayer.s(), graphicsLayer.t(), 0.0f, 4, null);
        k4.n(fArr2, fArrC2);
        float[] fArr3 = this.f5343i;
        float[] fArrC3 = k4.c(null, 1, null);
        k4.q(fArrC3, y1.g.m(jB), y1.g.n(jB), 0.0f, 4, null);
        k4.n(fArr3, fArrC3);
    }

    public final void h() {
        Function0<Unit> function0;
        m4 m4Var = this.f5351q;
        if (m4Var == null) {
            return;
        }
        androidx.compose.ui.graphics.layer.d.b(this.f5336a, m4Var);
        if (!(m4Var instanceof m4.a) || Build.VERSION.SDK_INT >= 33 || (function0 = this.f5340f) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.ui.node.w0
    public void invalidate() {
        if (this.f5345k || this.f5342h) {
            return;
        }
        this.f5338c.invalidate();
        e(true);
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo57isInLayerk4lQ0M(long j11) {
        float fM = y1.g.m(j11);
        float fN = y1.g.n(j11);
        if (this.f5336a.k()) {
            return j2.c(this.f5336a.n(), fM, fN, null, null, 24, null);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.w0
    public void mapBounds(y1.e eVar, boolean z11) {
        if (!z11) {
            k4.g(d(), eVar);
            return;
        }
        float[] fArrC = c();
        if (fArrC == null) {
            eVar.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            k4.g(fArrC, eVar);
        }
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo58mapOffset8S9VItk(long j11, boolean z11) {
        if (!z11) {
            return k4.f(d(), j11);
        }
        float[] fArrC = c();
        return fArrC != null ? k4.f(fArrC, j11) : y1.g.f81070b.a();
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo59movegyyYBs(long j11) {
        this.f5336a.c0(j11);
        f();
    }

    @Override // androidx.compose.ui.node.w0
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo60resizeozmzZPI(long j11) {
        if (q2.t.e(j11, this.f5341g)) {
            return;
        }
        this.f5341g = j11;
        invalidate();
    }

    @Override // androidx.compose.ui.node.w0
    public void reuseLayer(Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        c4 c4Var = this.f5337b;
        if (c4Var == null) {
            throw new IllegalArgumentException("currently reuse is only supported when we manage the layer lifecycle".toString());
        }
        if (!this.f5336a.z()) {
            throw new IllegalArgumentException("layer should have been released before reuse".toString());
        }
        this.f5336a = c4Var.a();
        this.f5342h = false;
        this.f5339d = function2;
        this.f5340f = function0;
        this.f5350p = g5.f4145a.a();
        this.f5354t = false;
        this.f5341g = q2.u.a(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f5351q = null;
        this.f5349o = 0;
    }

    @Override // androidx.compose.ui.node.w0
    public void updateDisplayList() {
        if (this.f5345k) {
            if (!g5.c(this.f5350p, g5.f4145a.a()) && !q2.t.e(this.f5336a.v(), this.f5341g)) {
                this.f5336a.P(y1.h.a(g5.d(this.f5350p) * q2.t.g(this.f5341g), g5.e(this.f5350p) * q2.t.f(this.f5341g)));
            }
            this.f5336a.E(this.f5346l, this.f5347m, this.f5341g, this.f5355u);
            e(false);
        }
    }

    @Override // androidx.compose.ui.node.w0
    public void updateLayerProperties(z4 z4Var) {
        boolean z11;
        int iB;
        Function0<Unit> function0;
        int iD = z4Var.D() | this.f5349o;
        this.f5347m = z4Var.C();
        this.f5346l = z4Var.A();
        int i11 = iD & 4096;
        if (i11 != 0) {
            this.f5350p = z4Var.i0();
        }
        if ((iD & 1) != 0) {
            this.f5336a.X(z4Var.v());
        }
        if ((iD & 2) != 0) {
            this.f5336a.Y(z4Var.E());
        }
        if ((iD & 4) != 0) {
            this.f5336a.J(z4Var.k());
        }
        if ((iD & 8) != 0) {
            this.f5336a.d0(z4Var.z());
        }
        if ((iD & 16) != 0) {
            this.f5336a.e0(z4Var.y());
        }
        if ((iD & 32) != 0) {
            this.f5336a.Z(z4Var.H());
            if (z4Var.H() > 0.0f && !this.f5354t && (function0 = this.f5340f) != null) {
                function0.invoke();
            }
        }
        if ((iD & 64) != 0) {
            this.f5336a.K(z4Var.l());
        }
        if ((iD & 128) != 0) {
            this.f5336a.b0(z4Var.K());
        }
        if ((iD & 1024) != 0) {
            this.f5336a.V(z4Var.q());
        }
        if ((iD & 256) != 0) {
            this.f5336a.T(z4Var.B());
        }
        if ((iD & 512) != 0) {
            this.f5336a.U(z4Var.o());
        }
        if ((iD & 2048) != 0) {
            this.f5336a.L(z4Var.s());
        }
        if (i11 != 0) {
            if (g5.c(this.f5350p, g5.f4145a.a())) {
                this.f5336a.P(y1.g.f81070b.b());
            } else {
                this.f5336a.P(y1.h.a(g5.d(this.f5350p) * q2.t.g(this.f5341g), g5.e(this.f5350p) * q2.t.f(this.f5341g)));
            }
        }
        if ((iD & 16384) != 0) {
            this.f5336a.M(z4Var.m());
        }
        if ((131072 & iD) != 0) {
            GraphicsLayer graphicsLayer = this.f5336a;
            z4Var.G();
            graphicsLayer.S(null);
        }
        if ((32768 & iD) != 0) {
            GraphicsLayer graphicsLayer2 = this.f5336a;
            int iX = z4Var.x();
            y3.a aVar = y3.f4585a;
            if (y3.e(iX, aVar.a())) {
                iB = androidx.compose.ui.graphics.layer.b.f4212a.a();
            } else if (y3.e(iX, aVar.c())) {
                iB = androidx.compose.ui.graphics.layer.b.f4212a.c();
            } else {
                if (!y3.e(iX, aVar.b())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                iB = androidx.compose.ui.graphics.layer.b.f4212a.b();
            }
            graphicsLayer2.N(iB);
        }
        if (Intrinsics.b(this.f5351q, z4Var.F())) {
            z11 = false;
        } else {
            this.f5351q = z4Var.F();
            h();
            z11 = true;
        }
        this.f5349o = z4Var.D();
        if (iD != 0 || z11) {
            f();
        }
    }
}
