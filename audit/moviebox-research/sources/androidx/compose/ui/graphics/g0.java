package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
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
@PublishedApi
@SourceDebugExtension
public final class g0 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Canvas f4140a = h0.f4147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f4141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f4142c;

    @Override // androidx.compose.ui.graphics.o1
    public void a(float f11, float f12, float f13, float f14, int i11) {
        this.f4140a.clipRect(f11, f12, f13, f14, x(i11));
    }

    @Override // androidx.compose.ui.graphics.o1
    public void b(Path path, int i11) {
        Canvas canvas = this.f4140a;
        if (!(path instanceof u0)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((u0) path).o(), x(i11));
    }

    @Override // androidx.compose.ui.graphics.o1
    public void c(float f11, float f12) {
        this.f4140a.translate(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void d() {
        this.f4140a.save();
    }

    @Override // androidx.compose.ui.graphics.o1
    public void e(float f11, float f12) {
        this.f4140a.scale(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void f(float f11, float f12, float f13, float f14, o4 o4Var) {
        this.f4140a.drawRect(f11, f12, f13, f14, o4Var.x());
    }

    @Override // androidx.compose.ui.graphics.o1
    public void g(int i11, List<y1.g> list, o4 o4Var) {
        v4.a aVar = v4.f4365a;
        if (v4.e(i11, aVar.a())) {
            t(list, o4Var, 2);
        } else if (v4.e(i11, aVar.c())) {
            t(list, o4Var, 1);
        } else if (v4.e(i11, aVar.b())) {
            u(list, o4Var);
        }
    }

    @Override // androidx.compose.ui.graphics.o1
    public void h(g4 g4Var, long j11, long j12, long j13, long j14, o4 o4Var) {
        if (this.f4141b == null) {
            this.f4141b = new Rect();
            this.f4142c = new Rect();
        }
        Canvas canvas = this.f4140a;
        Bitmap bitmapB = q0.b(g4Var);
        Rect rect = this.f4141b;
        Intrinsics.d(rect);
        rect.left = q2.p.h(j11);
        rect.top = q2.p.i(j11);
        rect.right = q2.p.h(j11) + q2.t.g(j12);
        rect.bottom = q2.p.i(j11) + q2.t.f(j12);
        Unit unit = Unit.f68710a;
        Rect rect2 = this.f4142c;
        Intrinsics.d(rect2);
        rect2.left = q2.p.h(j13);
        rect2.top = q2.p.i(j13);
        rect2.right = q2.p.h(j13) + q2.t.g(j14);
        rect2.bottom = q2.p.i(j13) + q2.t.f(j14);
        canvas.drawBitmap(bitmapB, rect, rect2, o4Var.x());
    }

    @Override // androidx.compose.ui.graphics.o1
    public /* synthetic */ void i(y1.i iVar, int i11) {
        n1.a(this, iVar, i11);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void j(y1.i iVar, o4 o4Var) {
        this.f4140a.saveLayer(iVar.f(), iVar.i(), iVar.g(), iVar.c(), o4Var.x(), 31);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void k() {
        this.f4140a.restore();
    }

    @Override // androidx.compose.ui.graphics.o1
    public void l() {
        r1.f4333a.a(this.f4140a, true);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void m(long j11, long j12, o4 o4Var) {
        this.f4140a.drawLine(y1.g.m(j11), y1.g.n(j11), y1.g.m(j12), y1.g.n(j12), o4Var.x());
    }

    @Override // androidx.compose.ui.graphics.o1
    public void n() {
        r1.f4333a.a(this.f4140a, false);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void o(float[] fArr) {
        if (l4.c(fArr)) {
            return;
        }
        Matrix matrix = new Matrix();
        r0.a(matrix, fArr);
        this.f4140a.concat(matrix);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void p(Path path, o4 o4Var) {
        Canvas canvas = this.f4140a;
        if (!(path instanceof u0)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((u0) path).o(), o4Var.x());
    }

    @Override // androidx.compose.ui.graphics.o1
    public void q(long j11, float f11, o4 o4Var) {
        this.f4140a.drawCircle(y1.g.m(j11), y1.g.n(j11), f11, o4Var.x());
    }

    @Override // androidx.compose.ui.graphics.o1
    public /* synthetic */ void r(y1.i iVar, o4 o4Var) {
        n1.b(this, iVar, o4Var);
    }

    @Override // androidx.compose.ui.graphics.o1
    public void s(float f11, float f12, float f13, float f14, float f15, float f16, o4 o4Var) {
        this.f4140a.drawRoundRect(f11, f12, f13, f14, f15, f16, o4Var.x());
    }

    public final void t(List<y1.g> list, o4 o4Var, int i11) {
        if (list.size() >= 2) {
            Paint paintX = o4Var.x();
            int i12 = 0;
            while (i12 < list.size() - 1) {
                long jV = list.get(i12).v();
                long jV2 = list.get(i12 + 1).v();
                this.f4140a.drawLine(y1.g.m(jV), y1.g.n(jV), y1.g.m(jV2), y1.g.n(jV2), paintX);
                i12 += i11;
            }
        }
    }

    public final void u(List<y1.g> list, o4 o4Var) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            long jV = list.get(i11).v();
            this.f4140a.drawPoint(y1.g.m(jV), y1.g.n(jV), o4Var.x());
        }
    }

    public final Canvas v() {
        return this.f4140a;
    }

    public final void w(Canvas canvas) {
        this.f4140a = canvas;
    }

    public final Region.Op x(int i11) {
        return v1.d(i11, v1.f4361a.a()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }
}
