package androidx.compose.ui.graphics;

import android.graphics.RectF;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class u0 implements Path {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final android.graphics.Path f4349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f4350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f4351d;

    /* JADX WARN: Multi-variable type inference failed */
    public u0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public u0(android.graphics.Path path) {
        this.f4349b = path;
    }

    public /* synthetic */ u0(android.graphics.Path path, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new android.graphics.Path() : path);
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean a() {
        return this.f4349b.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void b(float f11, float f12) {
        this.f4349b.rMoveTo(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void c(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f4349b.rCubicTo(f11, f12, f13, f14, f15, f16);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.f4349b.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void d(int i11) {
        this.f4349b.setFillType(s4.d(i11, s4.f4342a.a()) ? android.graphics.Path.FillType.EVEN_ODD : android.graphics.Path.FillType.WINDING);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void e(float f11, float f12, float f13, float f14) {
        this.f4349b.quadTo(f11, f12, f13, f14);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void f(float f11, float f12, float f13, float f14) {
        this.f4349b.rQuadTo(f11, f12, f13, f14);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void g(y1.k kVar, Path.Direction direction) {
        if (this.f4350c == null) {
            this.f4350c = new RectF();
        }
        RectF rectF = this.f4350c;
        Intrinsics.d(rectF);
        rectF.set(kVar.e(), kVar.g(), kVar.f(), kVar.a());
        if (this.f4351d == null) {
            this.f4351d = new float[8];
        }
        float[] fArr = this.f4351d;
        Intrinsics.d(fArr);
        fArr[0] = y1.a.d(kVar.h());
        fArr[1] = y1.a.e(kVar.h());
        fArr[2] = y1.a.d(kVar.i());
        fArr[3] = y1.a.e(kVar.i());
        fArr[4] = y1.a.d(kVar.c());
        fArr[5] = y1.a.e(kVar.c());
        fArr[6] = y1.a.d(kVar.b());
        fArr[7] = y1.a.e(kVar.b());
        android.graphics.Path path = this.f4349b;
        RectF rectF2 = this.f4350c;
        Intrinsics.d(rectF2);
        float[] fArr2 = this.f4351d;
        Intrinsics.d(fArr2);
        path.addRoundRect(rectF2, fArr2, z0.d(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public y1.i getBounds() {
        if (this.f4350c == null) {
            this.f4350c = new RectF();
        }
        RectF rectF = this.f4350c;
        Intrinsics.d(rectF);
        this.f4349b.computeBounds(rectF, true);
        return new y1.i(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void h(y1.i iVar, Path.Direction direction) {
        p(iVar);
        if (this.f4350c == null) {
            this.f4350c = new RectF();
        }
        RectF rectF = this.f4350c;
        Intrinsics.d(rectF);
        rectF.set(iVar.f(), iVar.i(), iVar.g(), iVar.c());
        android.graphics.Path path = this.f4349b;
        RectF rectF2 = this.f4350c;
        Intrinsics.d(rectF2);
        path.addRect(rectF2, z0.d(direction));
    }

    @Override // androidx.compose.ui.graphics.Path
    public int i() {
        return this.f4349b.getFillType() == android.graphics.Path.FillType.EVEN_ODD ? s4.f4342a.a() : s4.f4342a.b();
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.f4349b.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void j(float f11, float f12) {
        this.f4349b.moveTo(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void k(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f4349b.cubicTo(f11, f12, f13, f14, f15, f16);
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean l(Path path, Path path2, int i11) {
        android.graphics.Path.Op op2;
        u4.a aVar = u4.f4354a;
        if (u4.f(i11, aVar.a())) {
            op2 = android.graphics.Path.Op.DIFFERENCE;
        } else if (u4.f(i11, aVar.b())) {
            op2 = android.graphics.Path.Op.INTERSECT;
        } else if (u4.f(i11, aVar.c())) {
            op2 = android.graphics.Path.Op.REVERSE_DIFFERENCE;
        } else {
            op2 = u4.f(i11, aVar.d()) ? android.graphics.Path.Op.UNION : android.graphics.Path.Op.XOR;
        }
        android.graphics.Path path3 = this.f4349b;
        if (!(path instanceof u0)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path pathO = ((u0) path).o();
        if (path2 instanceof u0) {
            return path3.op(pathO, ((u0) path2).o(), op2);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void m(float f11, float f12) {
        this.f4349b.rLineTo(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void n(float f11, float f12) {
        this.f4349b.lineTo(f11, f12);
    }

    public final android.graphics.Path o() {
        return this.f4349b;
    }

    public final void p(y1.i iVar) {
        if (Float.isNaN(iVar.f()) || Float.isNaN(iVar.i()) || Float.isNaN(iVar.g()) || Float.isNaN(iVar.c())) {
            z0.c("Invalid rectangle, make sure no value is NaN");
        }
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.f4349b.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void rewind() {
        this.f4349b.rewind();
    }
}
