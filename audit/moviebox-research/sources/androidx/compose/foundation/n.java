package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.platform.e1;
import androidx.compose.ui.platform.f1;
import androidx.compose.ui.unit.LayoutDirection;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
@RequiresApi(VungleException.WEB_CRASH)
@Metadata
@SourceDebugExtension
public final class n extends f1 implements androidx.compose.ui.draw.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AndroidEdgeEffectOverscrollEffect f2812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f2813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RenderNode f2814e;

    public n(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, p pVar, Function1<? super e1, Unit> function1) {
        super(function1);
        this.f2812c = androidEdgeEffectOverscrollEffect;
        this.f2813d = pVar;
    }

    @Override // androidx.compose.ui.draw.g
    public void A(z1.c cVar) {
        boolean zO;
        this.f2812c.r(cVar.i());
        if (y1.m.k(cVar.i())) {
            cVar.a1();
            return;
        }
        this.f2812c.j().getValue();
        float fN0 = cVar.N0(g.b());
        Canvas canvasD = androidx.compose.ui.graphics.h0.d(cVar.Q0().e());
        p pVar = this.f2813d;
        boolean zU = u();
        boolean zT = t();
        if (zU && zT) {
            s().setPosition(0, 0, canvasD.getWidth(), canvasD.getHeight());
        } else if (zU) {
            s().setPosition(0, 0, canvasD.getWidth() + (a20.b.d(fN0) * 2), canvasD.getHeight());
        } else {
            if (!zT) {
                cVar.a1();
                return;
            }
            s().setPosition(0, 0, canvasD.getWidth(), canvasD.getHeight() + (a20.b.d(fN0) * 2));
        }
        RecordingCanvas recordingCanvasBeginRecording = s().beginRecording();
        if (pVar.s()) {
            EdgeEffect edgeEffectI = pVar.i();
            p(edgeEffectI, recordingCanvasBeginRecording);
            edgeEffectI.finish();
        }
        if (pVar.r()) {
            EdgeEffect edgeEffectH = pVar.h();
            zO = o(edgeEffectH, recordingCanvasBeginRecording);
            if (pVar.t()) {
                float fN = y1.g.n(this.f2812c.i());
                o oVar = o.f2815a;
                oVar.d(pVar.i(), oVar.b(edgeEffectH), 1 - fN);
            }
        } else {
            zO = false;
        }
        if (pVar.z()) {
            EdgeEffect edgeEffectM = pVar.m();
            a(edgeEffectM, recordingCanvasBeginRecording);
            edgeEffectM.finish();
        }
        if (pVar.y()) {
            EdgeEffect edgeEffectL = pVar.l();
            zO = q(edgeEffectL, recordingCanvasBeginRecording) || zO;
            if (pVar.A()) {
                float fM = y1.g.m(this.f2812c.i());
                o oVar2 = o.f2815a;
                oVar2.d(pVar.m(), oVar2.b(edgeEffectL), fM);
            }
        }
        if (pVar.v()) {
            EdgeEffect edgeEffectK = pVar.k();
            o(edgeEffectK, recordingCanvasBeginRecording);
            edgeEffectK.finish();
        }
        if (pVar.u()) {
            EdgeEffect edgeEffectJ = pVar.j();
            zO = p(edgeEffectJ, recordingCanvasBeginRecording) || zO;
            if (pVar.w()) {
                float fN2 = y1.g.n(this.f2812c.i());
                o oVar3 = o.f2815a;
                oVar3.d(pVar.k(), oVar3.b(edgeEffectJ), fN2);
            }
        }
        if (pVar.p()) {
            EdgeEffect edgeEffectG = pVar.g();
            q(edgeEffectG, recordingCanvasBeginRecording);
            edgeEffectG.finish();
        }
        if (pVar.o()) {
            EdgeEffect edgeEffectF = pVar.f();
            boolean z11 = a(edgeEffectF, recordingCanvasBeginRecording) || zO;
            if (pVar.q()) {
                float fM2 = y1.g.m(this.f2812c.i());
                o oVar4 = o.f2815a;
                oVar4.d(pVar.g(), oVar4.b(edgeEffectF), 1 - fM2);
            }
            zO = z11;
        }
        if (zO) {
            this.f2812c.k();
        }
        float f11 = zT ? 0.0f : fN0;
        if (zU) {
            fN0 = 0.0f;
        }
        LayoutDirection layoutDirection = cVar.getLayoutDirection();
        o1 o1VarB = androidx.compose.ui.graphics.h0.b(recordingCanvasBeginRecording);
        long jI = cVar.i();
        q2.e density = cVar.Q0().getDensity();
        LayoutDirection layoutDirection2 = cVar.Q0().getLayoutDirection();
        o1 o1VarE = cVar.Q0().e();
        long jI2 = cVar.Q0().i();
        GraphicsLayer graphicsLayerG = cVar.Q0().g();
        z1.d dVarQ0 = cVar.Q0();
        dVarQ0.b(cVar);
        dVarQ0.a(layoutDirection);
        dVarQ0.h(o1VarB);
        dVarQ0.f(jI);
        dVarQ0.d(null);
        o1VarB.d();
        try {
            cVar.Q0().c().c(f11, fN0);
            try {
                cVar.a1();
                float f12 = -f11;
                float f13 = -fN0;
                cVar.Q0().c().c(f12, f13);
                o1VarB.k();
                z1.d dVarQ1 = cVar.Q0();
                dVarQ1.b(density);
                dVarQ1.a(layoutDirection2);
                dVarQ1.h(o1VarE);
                dVarQ1.f(jI2);
                dVarQ1.d(graphicsLayerG);
                s().endRecording();
                int iSave = canvasD.save();
                canvasD.translate(f12, f13);
                canvasD.drawRenderNode(s());
                canvasD.restoreToCount(iSave);
            } catch (Throwable th2) {
                cVar.Q0().c().c(-f11, -fN0);
                throw th2;
            }
        } catch (Throwable th3) {
            o1VarB.k();
            z1.d dVarQ2 = cVar.Q0();
            dVarQ2.b(density);
            dVarQ2.a(layoutDirection2);
            dVarQ2.h(o1VarE);
            dVarQ2.f(jI2);
            dVarQ2.d(graphicsLayerG);
            throw th3;
        }
    }

    public final boolean a(EdgeEffect edgeEffect, Canvas canvas) {
        return r(180.0f, edgeEffect, canvas);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object c(Object obj, Function2 function2) {
        return androidx.compose.ui.g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean d(Function1 function1) {
        return androidx.compose.ui.g.a(this, function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ androidx.compose.ui.f f(androidx.compose.ui.f fVar) {
        return androidx.compose.ui.e.a(this, fVar);
    }

    public final boolean o(EdgeEffect edgeEffect, Canvas canvas) {
        return r(270.0f, edgeEffect, canvas);
    }

    public final boolean p(EdgeEffect edgeEffect, Canvas canvas) {
        return r(90.0f, edgeEffect, canvas);
    }

    public final boolean q(EdgeEffect edgeEffect, Canvas canvas) {
        return r(0.0f, edgeEffect, canvas);
    }

    public final boolean r(float f11, EdgeEffect edgeEffect, Canvas canvas) {
        if (f11 == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f11);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    public final RenderNode s() {
        RenderNode renderNode = this.f2814e;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNodeA = i.a("AndroidEdgeEffectOverscrollEffect");
        this.f2814e = renderNodeA;
        return renderNodeA;
    }

    public final boolean t() {
        p pVar = this.f2813d;
        return pVar.r() || pVar.s() || pVar.u() || pVar.v();
    }

    public final boolean u() {
        p pVar = this.f2813d;
        return pVar.y() || pVar.z() || pVar.o() || pVar.p();
    }
}
