package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.p1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.y1;
import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.atomic.AtomicBoolean;
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
@RequiresApi(23)
@Metadata
@SourceDebugExtension
public final class e implements GraphicsLayerImpl {
    public static boolean G;
    public float A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1 f4267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z1.a f4268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RenderNode f4269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f4271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Matrix f4272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public x1 f4277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f4280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f4281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f4282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f4283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f4284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f4285u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f4286v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f4287w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f4288x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f4289y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f4290z;
    public static final a F = new a(null);
    public static final AtomicBoolean H = new AtomicBoolean(true);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(View view, long j11, p1 p1Var, z1.a aVar) {
        this.f4266b = j11;
        this.f4267c = p1Var;
        this.f4268d = aVar;
        RenderNode renderNodeCreate = RenderNode.create("Compose", view);
        this.f4269e = renderNodeCreate;
        q2.t.a aVar2 = q2.t.f74253b;
        this.f4270f = aVar2.a();
        this.f4274j = aVar2.a();
        if (H.getAndSet(false)) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            S(renderNodeCreate);
            O();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
        }
        if (G) {
            throw new NoClassDefFoundError();
        }
        renderNodeCreate.setClipToBounds(false);
        b.a aVar3 = b.f4212a;
        N(aVar3.a());
        this.f4275k = aVar3.a();
        this.f4276l = e1.f4102a.B();
        this.f4278n = 1.0f;
        this.f4280p = y1.g.f81070b.b();
        this.f4281q = 1.0f;
        this.f4282r = 1.0f;
        w1.a aVar4 = w1.f4564b;
        this.f4286v = aVar4.a();
        this.f4287w = aVar4.a();
        this.A = 8.0f;
        this.E = true;
    }

    public /* synthetic */ e(View view, long j11, p1 p1Var, z1.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, j11, (i11 & 4) != 0 ? new p1() : p1Var, (i11 & 8) != 0 ? new z1.a() : aVar);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long A() {
        return this.f4286v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float B() {
        return this.f4288x;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long C() {
        return this.f4287w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix D() {
        Matrix matrix = this.f4272h;
        if (matrix == null) {
            matrix = new Matrix();
            this.f4272h = matrix;
        }
        this.f4269e.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float E() {
        return this.f4282r;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z11) {
        this.E = z11;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j11) {
        this.f4274j = j11;
        this.f4269e.setOutline(outline);
        this.f4273i = outline != null;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(q2.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super z1.g, Unit> function1) {
        Canvas canvasStart = this.f4269e.start(Math.max(q2.t.g(this.f4270f), q2.t.g(this.f4274j)), Math.max(q2.t.f(this.f4270f), q2.t.f(this.f4274j)));
        try {
            p1 p1Var = this.f4267c;
            Canvas canvasV = p1Var.a().v();
            p1Var.a().w(canvasStart);
            androidx.compose.ui.graphics.g0 g0VarA = p1Var.a();
            z1.a aVar = this.f4268d;
            long jD = q2.u.d(this.f4270f);
            q2.e density = aVar.Q0().getDensity();
            LayoutDirection layoutDirection2 = aVar.Q0().getLayoutDirection();
            o1 o1VarE = aVar.Q0().e();
            long jI = aVar.Q0().i();
            GraphicsLayer graphicsLayerG = aVar.Q0().g();
            z1.d dVarQ0 = aVar.Q0();
            dVarQ0.b(eVar);
            dVarQ0.a(layoutDirection);
            dVarQ0.h(g0VarA);
            dVarQ0.f(jD);
            dVarQ0.d(graphicsLayer);
            g0VarA.d();
            try {
                function1.invoke(aVar);
                g0VarA.k();
                z1.d dVarQ1 = aVar.Q0();
                dVarQ1.b(density);
                dVarQ1.a(layoutDirection2);
                dVarQ1.h(o1VarE);
                dVarQ1.f(jI);
                dVarQ1.d(graphicsLayerG);
                p1Var.a().w(canvasV);
                this.f4269e.end(canvasStart);
                F(false);
            } catch (Throwable th2) {
                g0VarA.k();
                z1.d dVarQ2 = aVar.Q0();
                dVarQ2.b(density);
                dVarQ2.a(layoutDirection2);
                dVarQ2.h(o1VarE);
                dVarQ2.f(jI);
                dVarQ2.d(graphicsLayerG);
                throw th2;
            }
        } catch (Throwable th3) {
            this.f4269e.end(canvasStart);
            throw th3;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(long j11) {
        this.f4280p = j11;
        if (y1.h.d(j11)) {
            this.f4279o = true;
            this.f4269e.setPivotX(q2.t.g(this.f4270f) / 2.0f);
            this.f4269e.setPivotY(q2.t.f(this.f4270f) / 2.0f);
        } else {
            this.f4279o = false;
            this.f4269e.setPivotX(y1.g.m(j11));
            this.f4269e.setPivotY(y1.g.n(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void J(int i11) {
        this.f4275k = i11;
        R();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.f4285u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void L(o1 o1Var) {
        DisplayListCanvas displayListCanvasD = androidx.compose.ui.graphics.h0.d(o1Var);
        Intrinsics.e(displayListCanvasD, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        displayListCanvasD.drawRenderNode(this.f4269e);
    }

    public final void M() {
        boolean z11 = false;
        boolean z12 = P() && !this.f4273i;
        if (P() && this.f4273i) {
            z11 = true;
        }
        if (z12 != this.C) {
            this.C = z12;
            this.f4269e.setClipToBounds(z12);
        }
        if (z11 != this.D) {
            this.D = z11;
            this.f4269e.setClipToOutline(z11);
        }
    }

    public final void N(int i11) {
        RenderNode renderNode = this.f4269e;
        b.a aVar = b.f4212a;
        if (b.e(i11, aVar.c())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.f4271g);
            renderNode.setHasOverlappingRendering(true);
        } else if (b.e(i11, aVar.b())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f4271g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.f4271g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    public final void O() {
        if (Build.VERSION.SDK_INT >= 24) {
            o0.f4301a.a(this.f4269e);
        } else {
            n0.f4300a.a(this.f4269e);
        }
    }

    public boolean P() {
        return this.B;
    }

    public final boolean Q() {
        return (!b.e(p(), b.f4212a.c()) && e1.E(m(), e1.f4102a.B()) && i() == null) ? false : true;
    }

    public final void R() {
        if (Q()) {
            N(b.f4212a.c());
        } else {
            N(p());
        }
    }

    public final void S(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            p0 p0Var = p0.f4302a;
            p0Var.c(renderNode, p0Var.a(renderNode));
            p0Var.d(renderNode, p0Var.b(renderNode));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void a(float f11) {
        this.f4284t = f11;
        this.f4269e.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void b(float f11) {
        this.f4281q = f11;
        this.f4269e.setScaleX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(y4 y4Var) {
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f11) {
        this.A = f11;
        this.f4269e.setCameraDistance(-f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f11) {
        this.f4288x = f11;
        this.f4269e.setRotationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(float f11) {
        this.f4289y = f11;
        this.f4269e.setRotationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f11) {
        this.f4290z = f11;
        this.f4269e.setRotation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.f4278n;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f11) {
        this.f4282r = f11;
        this.f4269e.setScaleY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public x1 i() {
        return this.f4277m;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f11) {
        this.f4283s = f11;
        this.f4269e.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k() {
        O();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean l() {
        return this.f4269e.isValid();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int m() {
        return this.f4276l;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public y4 n() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float o() {
        return this.f4289y;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int p() {
        return this.f4275k;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float q() {
        return this.f4290z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void r(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4286v = j11;
            p0.f4302a.c(this.f4269e, y1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float s() {
        return this.A;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f11) {
        this.f4278n = f11;
        this.f4269e.setAlpha(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void t(boolean z11) {
        this.B = z11;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void u(long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4287w = j11;
            p0.f4302a.d(this.f4269e, y1.j(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float v() {
        return this.f4281q;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void w(float f11) {
        this.f4285u = f11;
        this.f4269e.setElevation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void x(int i11, int i12, long j11) {
        this.f4269e.setLeftTopRightBottom(i11, i12, q2.t.g(j11) + i11, q2.t.f(j11) + i12);
        if (q2.t.e(this.f4270f, j11)) {
            return;
        }
        if (this.f4279o) {
            this.f4269e.setPivotX(q2.t.g(j11) / 2.0f);
            this.f4269e.setPivotY(q2.t.f(j11) / 2.0f);
        }
        this.f4270f = j11;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float y() {
        return this.f4284t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float z() {
        return this.f4283s;
    }
}
