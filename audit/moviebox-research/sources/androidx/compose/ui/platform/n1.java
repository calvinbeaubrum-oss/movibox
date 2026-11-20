package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.y3;
import androidx.compose.ui.graphics.y4;
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
public final class n1 implements y0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f5522k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidComposeView f5524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RenderNode f5525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f5520i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5521j = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f5523l = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public n1(AndroidComposeView androidComposeView) {
        this.f5524a = androidComposeView;
        RenderNode renderNodeCreate = RenderNode.create("Compose", androidComposeView);
        this.f5525b = renderNodeCreate;
        this.f5526c = y3.f4585a.a();
        if (f5523l) {
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
            N(renderNodeCreate);
            I();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
            f5523l = false;
        }
        if (f5522k) {
            throw new NoClassDefFoundError();
        }
    }

    @Override // androidx.compose.ui.platform.y0
    public void A(float f11) {
        this.f5525b.setPivotX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void B(float f11) {
        this.f5525b.setPivotY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void C(Outline outline) {
        this.f5525b.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.y0
    public void D(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            e2.f5466a.c(this.f5525b, i11);
        }
    }

    @Override // androidx.compose.ui.platform.y0
    public void E(boolean z11) {
        this.f5525b.setClipToOutline(z11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void F(androidx.compose.ui.graphics.p1 p1Var, Path path, Function1<? super androidx.compose.ui.graphics.o1, Unit> function1) {
        DisplayListCanvas displayListCanvasStart = this.f5525b.start(getWidth(), getHeight());
        Canvas canvasV = p1Var.a().v();
        p1Var.a().w((Canvas) displayListCanvasStart);
        androidx.compose.ui.graphics.g0 g0VarA = p1Var.a();
        if (path != null) {
            g0VarA.d();
            androidx.compose.ui.graphics.n1.c(g0VarA, path, 0, 2, null);
        }
        function1.invoke(g0VarA);
        if (path != null) {
            g0VarA.k();
        }
        p1Var.a().w(canvasV);
        this.f5525b.end(displayListCanvasStart);
    }

    @Override // androidx.compose.ui.platform.y0
    public void G(int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            e2.f5466a.d(this.f5525b, i11);
        }
    }

    @Override // androidx.compose.ui.platform.y0
    public float H() {
        return this.f5525b.getElevation();
    }

    public final void I() {
        if (Build.VERSION.SDK_INT >= 24) {
            d2.f5459a.a(this.f5525b);
        } else {
            c2.f5448a.a(this.f5525b);
        }
    }

    public void J(int i11) {
        this.f5530g = i11;
    }

    public void K(int i11) {
        this.f5527d = i11;
    }

    public void L(int i11) {
        this.f5529f = i11;
    }

    public void M(int i11) {
        this.f5528e = i11;
    }

    public final void N(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            e2 e2Var = e2.f5466a;
            e2Var.c(renderNode, e2Var.a(renderNode));
            e2Var.d(renderNode, e2Var.b(renderNode));
        }
    }

    @Override // androidx.compose.ui.platform.y0
    public void a(float f11) {
        this.f5525b.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void b(float f11) {
        this.f5525b.setScaleX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void c(y4 y4Var) {
    }

    @Override // androidx.compose.ui.platform.y0
    public void d(float f11) {
        this.f5525b.setCameraDistance(-f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void e(float f11) {
        this.f5525b.setRotationX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void f(float f11) {
        this.f5525b.setRotationY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void g(float f11) {
        this.f5525b.setRotation(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public float getAlpha() {
        return this.f5525b.getAlpha();
    }

    @Override // androidx.compose.ui.platform.y0
    public int getHeight() {
        return z() - u();
    }

    @Override // androidx.compose.ui.platform.y0
    public int getWidth() {
        return m() - i();
    }

    @Override // androidx.compose.ui.platform.y0
    public void h(float f11) {
        this.f5525b.setScaleY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public int i() {
        return this.f5527d;
    }

    @Override // androidx.compose.ui.platform.y0
    public void j(float f11) {
        this.f5525b.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void k() {
        I();
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean l() {
        return this.f5525b.isValid();
    }

    @Override // androidx.compose.ui.platform.y0
    public int m() {
        return this.f5529f;
    }

    @Override // androidx.compose.ui.platform.y0
    public void n(int i11) {
        y3.a aVar = y3.f4585a;
        if (y3.e(i11, aVar.c())) {
            this.f5525b.setLayerType(2);
            this.f5525b.setHasOverlappingRendering(true);
        } else if (y3.e(i11, aVar.b())) {
            this.f5525b.setLayerType(0);
            this.f5525b.setHasOverlappingRendering(false);
        } else {
            this.f5525b.setLayerType(0);
            this.f5525b.setHasOverlappingRendering(true);
        }
        this.f5526c = i11;
    }

    @Override // androidx.compose.ui.platform.y0
    public void o(Canvas canvas) {
        Intrinsics.e(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.f5525b);
    }

    @Override // androidx.compose.ui.platform.y0
    public void p(boolean z11) {
        this.f5531h = z11;
        this.f5525b.setClipToBounds(z11);
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean q(int i11, int i12, int i13, int i14) {
        K(i11);
        M(i12);
        L(i13);
        J(i14);
        return this.f5525b.setLeftTopRightBottom(i11, i12, i13, i14);
    }

    @Override // androidx.compose.ui.platform.y0
    public void r(float f11) {
        this.f5525b.setElevation(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void s(int i11) {
        M(u() + i11);
        J(z() + i11);
        this.f5525b.offsetTopAndBottom(i11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void setAlpha(float f11) {
        this.f5525b.setAlpha(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean t() {
        return this.f5531h;
    }

    @Override // androidx.compose.ui.platform.y0
    public int u() {
        return this.f5528e;
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean v() {
        return this.f5525b.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean w(boolean z11) {
        return this.f5525b.setHasOverlappingRendering(z11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void x(Matrix matrix) {
        this.f5525b.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.y0
    public void y(int i11) {
        K(i() + i11);
        L(m() + i11);
        this.f5525b.offsetLeftAndRight(i11);
    }

    @Override // androidx.compose.ui.platform.y0
    public int z() {
        return this.f5530g;
    }
}
