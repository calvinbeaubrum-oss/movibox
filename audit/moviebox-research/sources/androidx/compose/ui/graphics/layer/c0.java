package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.p1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.graphics.y1;
import androidx.compose.ui.graphics.y4;
import androidx.compose.ui.unit.LayoutDirection;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
@Metadata
@SourceDebugExtension
public final class c0 implements GraphicsLayerImpl {
    public boolean A;
    public int B;
    public boolean C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1 f4217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z1.a f4218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RenderNode f4219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f4221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Matrix f4222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f4224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public x1 f4226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4227m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f4228n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f4229o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f4230p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f4231q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f4232r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4233s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f4234t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f4235u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f4236v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f4237w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f4238x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4239y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4240z;

    public c0(long j11, p1 p1Var, z1.a aVar) {
        this.f4216b = j11;
        this.f4217c = p1Var;
        this.f4218d = aVar;
        RenderNode renderNodeA = androidx.compose.foundation.i.a("graphicsLayer");
        this.f4219e = renderNodeA;
        this.f4220f = y1.m.f81091b.b();
        renderNodeA.setClipToBounds(false);
        b.a aVar2 = b.f4212a;
        N(renderNodeA, aVar2.a());
        this.f4224j = 1.0f;
        this.f4225k = e1.f4102a.B();
        this.f4227m = y1.g.f81070b.b();
        this.f4228n = 1.0f;
        this.f4229o = 1.0f;
        w1.a aVar3 = w1.f4564b;
        this.f4233s = aVar3.a();
        this.f4234t = aVar3.a();
        this.f4238x = 8.0f;
        this.B = aVar2.a();
        this.C = true;
    }

    public /* synthetic */ c0(long j11, p1 p1Var, z1.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, (i11 & 2) != 0 ? new p1() : p1Var, (i11 & 4) != 0 ? new z1.a() : aVar);
    }

    private final void M() {
        boolean z11 = false;
        boolean z12 = O() && !this.f4223i;
        if (O() && this.f4223i) {
            z11 = true;
        }
        if (z12 != this.f4240z) {
            this.f4240z = z12;
            this.f4219e.setClipToBounds(z12);
        }
        if (z11 != this.A) {
            this.A = z11;
            this.f4219e.setClipToOutline(z11);
        }
    }

    private final boolean P() {
        if (b.e(p(), b.f4212a.c()) || Q()) {
            return true;
        }
        n();
        return false;
    }

    private final void R() {
        if (P()) {
            N(this.f4219e, b.f4212a.c());
        } else {
            N(this.f4219e, p());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long A() {
        return this.f4233s;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float B() {
        return this.f4235u;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long C() {
        return this.f4234t;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix D() {
        Matrix matrix = this.f4222h;
        if (matrix == null) {
            matrix = new Matrix();
            this.f4222h = matrix;
        }
        this.f4219e.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float E() {
        return this.f4229o;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void F(boolean z11) {
        this.C = z11;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void G(Outline outline, long j11) {
        this.f4219e.setOutline(outline);
        this.f4223i = outline != null;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void H(q2.e eVar, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super z1.g, Unit> function1) {
        RecordingCanvas recordingCanvasBeginRecording = this.f4219e.beginRecording();
        try {
            p1 p1Var = this.f4217c;
            Canvas canvasV = p1Var.a().v();
            p1Var.a().w(recordingCanvasBeginRecording);
            androidx.compose.ui.graphics.g0 g0VarA = p1Var.a();
            z1.d dVarQ0 = this.f4218d.Q0();
            dVarQ0.b(eVar);
            dVarQ0.a(layoutDirection);
            dVarQ0.d(graphicsLayer);
            dVarQ0.f(this.f4220f);
            dVarQ0.h(g0VarA);
            function1.invoke(this.f4218d);
            p1Var.a().w(canvasV);
            this.f4219e.endRecording();
            F(false);
        } catch (Throwable th2) {
            this.f4219e.endRecording();
            throw th2;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void I(long j11) {
        this.f4227m = j11;
        if (y1.h.d(j11)) {
            this.f4219e.resetPivot();
        } else {
            this.f4219e.setPivotX(y1.g.m(j11));
            this.f4219e.setPivotY(y1.g.n(j11));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void J(int i11) {
        this.B = i11;
        R();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float K() {
        return this.f4232r;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void L(o1 o1Var) {
        androidx.compose.ui.graphics.h0.d(o1Var).drawRenderNode(this.f4219e);
    }

    public final void N(RenderNode renderNode, int i11) {
        b.a aVar = b.f4212a;
        if (b.e(i11, aVar.c())) {
            renderNode.setUseCompositingLayer(true, this.f4221g);
            renderNode.setHasOverlappingRendering(true);
        } else if (b.e(i11, aVar.b())) {
            renderNode.setUseCompositingLayer(false, this.f4221g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, this.f4221g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    public boolean O() {
        return this.f4239y;
    }

    public final boolean Q() {
        return (e1.E(m(), e1.f4102a.B()) && i() == null) ? false : true;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void a(float f11) {
        this.f4231q = f11;
        this.f4219e.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void b(float f11) {
        this.f4228n = f11;
        this.f4219e.setScaleX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void c(y4 y4Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            q0.f4303a.a(this.f4219e, y4Var);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void d(float f11) {
        this.f4238x = f11;
        this.f4219e.setCameraDistance(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void e(float f11) {
        this.f4235u = f11;
        this.f4219e.setRotationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void f(float f11) {
        this.f4236v = f11;
        this.f4219e.setRotationY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void g(float f11) {
        this.f4237w = f11;
        this.f4219e.setRotationZ(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.f4224j;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void h(float f11) {
        this.f4229o = f11;
        this.f4219e.setScaleY(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public x1 i() {
        return this.f4226l;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void j(float f11) {
        this.f4230p = f11;
        this.f4219e.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void k() {
        this.f4219e.discardDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean l() {
        return this.f4219e.hasDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int m() {
        return this.f4225k;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public y4 n() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float o() {
        return this.f4236v;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int p() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float q() {
        return this.f4237w;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void r(long j11) {
        this.f4233s = j11;
        this.f4219e.setAmbientShadowColor(y1.j(j11));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float s() {
        return this.f4238x;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f11) {
        this.f4224j = f11;
        this.f4219e.setAlpha(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void t(boolean z11) {
        this.f4239y = z11;
        M();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void u(long j11) {
        this.f4234t = j11;
        this.f4219e.setSpotShadowColor(y1.j(j11));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float v() {
        return this.f4228n;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void w(float f11) {
        this.f4232r = f11;
        this.f4219e.setElevation(f11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void x(int i11, int i12, long j11) {
        this.f4219e.setPosition(i11, i12, q2.t.g(j11) + i11, q2.t.f(j11) + i12);
        this.f4220f = q2.u.d(j11);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float y() {
        return this.f4231q;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float z() {
        return this.f4230p;
    }
}
