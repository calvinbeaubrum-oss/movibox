package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.ui.platform.e1;
import androidx.compose.ui.platform.f1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class h extends f1 implements androidx.compose.ui.draw.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AndroidEdgeEffectOverscrollEffect f2373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f2374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e0 f2375e;

    public h(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, p pVar, e0 e0Var, Function1<? super e1, Unit> function1) {
        super(function1);
        this.f2373c = androidEdgeEffectOverscrollEffect;
        this.f2374d = pVar;
        this.f2375e = e0Var;
    }

    @Override // androidx.compose.ui.draw.g
    public void A(z1.c cVar) {
        this.f2373c.r(cVar.i());
        if (y1.m.k(cVar.i())) {
            cVar.a1();
            return;
        }
        cVar.a1();
        this.f2373c.j().getValue();
        Canvas canvasD = androidx.compose.ui.graphics.h0.d(cVar.Q0().e());
        p pVar = this.f2374d;
        boolean zO = pVar.r() ? o(cVar, pVar.h(), canvasD) : false;
        if (pVar.y()) {
            zO = q(cVar, pVar.l(), canvasD) || zO;
        }
        if (pVar.u()) {
            zO = p(cVar, pVar.j(), canvasD) || zO;
        }
        if (pVar.o()) {
            if (!a(cVar, pVar.f(), canvasD) && !zO) {
                return;
            }
        } else if (!zO) {
            return;
        }
        this.f2373c.k();
    }

    public final boolean a(z1.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return r(180.0f, y1.h.a(-y1.m.i(gVar.i()), (-y1.m.g(gVar.i())) + gVar.N0(this.f2375e.a().a())), edgeEffect, canvas);
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

    public final boolean o(z1.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return r(270.0f, y1.h.a(-y1.m.g(gVar.i()), gVar.N0(this.f2375e.a().b(gVar.getLayoutDirection()))), edgeEffect, canvas);
    }

    public final boolean p(z1.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return r(90.0f, y1.h.a(0.0f, (-a20.b.d(y1.m.i(gVar.i()))) + gVar.N0(this.f2375e.a().c(gVar.getLayoutDirection()))), edgeEffect, canvas);
    }

    public final boolean q(z1.g gVar, EdgeEffect edgeEffect, Canvas canvas) {
        return r(0.0f, y1.h.a(0.0f, gVar.N0(this.f2375e.a().d())), edgeEffect, canvas);
    }

    public final boolean r(float f11, long j11, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f11);
        canvas.translate(y1.g.m(j11), y1.g.n(j11));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }
}
