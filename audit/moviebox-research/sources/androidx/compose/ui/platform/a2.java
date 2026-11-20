package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.y3;
import androidx.compose.ui.graphics.y4;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class a2 implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidComposeView f5424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RenderNode f5425b = androidx.compose.foundation.i.a("Compose");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5426c = y3.f4585a.a();

    public a2(AndroidComposeView androidComposeView) {
        this.f5424a = androidComposeView;
    }

    @Override // androidx.compose.ui.platform.y0
    public void A(float f11) {
        this.f5425b.setPivotX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void B(float f11) {
        this.f5425b.setPivotY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void C(Outline outline) {
        this.f5425b.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.y0
    public void D(int i11) {
        this.f5425b.setAmbientShadowColor(i11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void E(boolean z11) {
        this.f5425b.setClipToOutline(z11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void F(androidx.compose.ui.graphics.p1 p1Var, Path path, Function1<? super androidx.compose.ui.graphics.o1, Unit> function1) {
        RecordingCanvas recordingCanvasBeginRecording = this.f5425b.beginRecording();
        Canvas canvasV = p1Var.a().v();
        p1Var.a().w(recordingCanvasBeginRecording);
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
        this.f5425b.endRecording();
    }

    @Override // androidx.compose.ui.platform.y0
    public void G(int i11) {
        this.f5425b.setSpotShadowColor(i11);
    }

    @Override // androidx.compose.ui.platform.y0
    public float H() {
        return this.f5425b.getElevation();
    }

    @Override // androidx.compose.ui.platform.y0
    public void a(float f11) {
        this.f5425b.setTranslationY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void b(float f11) {
        this.f5425b.setScaleX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void c(y4 y4Var) {
        if (Build.VERSION.SDK_INT >= 31) {
            b2.f5436a.a(this.f5425b, y4Var);
        }
    }

    @Override // androidx.compose.ui.platform.y0
    public void d(float f11) {
        this.f5425b.setCameraDistance(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void e(float f11) {
        this.f5425b.setRotationX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void f(float f11) {
        this.f5425b.setRotationY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void g(float f11) {
        this.f5425b.setRotationZ(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public float getAlpha() {
        return this.f5425b.getAlpha();
    }

    @Override // androidx.compose.ui.platform.y0
    public int getHeight() {
        return this.f5425b.getHeight();
    }

    @Override // androidx.compose.ui.platform.y0
    public int getWidth() {
        return this.f5425b.getWidth();
    }

    @Override // androidx.compose.ui.platform.y0
    public void h(float f11) {
        this.f5425b.setScaleY(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public int i() {
        return this.f5425b.getLeft();
    }

    @Override // androidx.compose.ui.platform.y0
    public void j(float f11) {
        this.f5425b.setTranslationX(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void k() {
        this.f5425b.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean l() {
        return this.f5425b.hasDisplayList();
    }

    @Override // androidx.compose.ui.platform.y0
    public int m() {
        return this.f5425b.getRight();
    }

    @Override // androidx.compose.ui.platform.y0
    public void n(int i11) {
        RenderNode renderNode = this.f5425b;
        y3.a aVar = y3.f4585a;
        if (y3.e(i11, aVar.c())) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
        } else if (y3.e(i11, aVar.b())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
        this.f5426c = i11;
    }

    @Override // androidx.compose.ui.platform.y0
    public void o(Canvas canvas) {
        canvas.drawRenderNode(this.f5425b);
    }

    @Override // androidx.compose.ui.platform.y0
    public void p(boolean z11) {
        this.f5425b.setClipToBounds(z11);
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean q(int i11, int i12, int i13, int i14) {
        return this.f5425b.setPosition(i11, i12, i13, i14);
    }

    @Override // androidx.compose.ui.platform.y0
    public void r(float f11) {
        this.f5425b.setElevation(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void s(int i11) {
        this.f5425b.offsetTopAndBottom(i11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void setAlpha(float f11) {
        this.f5425b.setAlpha(f11);
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean t() {
        return this.f5425b.getClipToBounds();
    }

    @Override // androidx.compose.ui.platform.y0
    public int u() {
        return this.f5425b.getTop();
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean v() {
        return this.f5425b.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.y0
    public boolean w(boolean z11) {
        return this.f5425b.setHasOverlappingRendering(z11);
    }

    @Override // androidx.compose.ui.platform.y0
    public void x(Matrix matrix) {
        this.f5425b.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.y0
    public void y(int i11) {
        this.f5425b.offsetLeftAndRight(i11);
    }

    @Override // androidx.compose.ui.platform.y0
    public int z() {
        return this.f5425b.getBottom();
    }
}
