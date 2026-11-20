package androidx.compose.ui.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import m2.s1;

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
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AndroidParagraphIntrinsics f5747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s1 f5751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f5752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<y1.i> f5753g;

    /* JADX INFO: renamed from: androidx.compose.ui.text.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class C0061a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5754a;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5754a = iArr;
        }
    }

    public a(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i11, boolean z11, long j11) {
        List<y1.i> listL;
        y1.i iVar;
        float fW;
        float fJ;
        int iB;
        float fV;
        float fB;
        float fJ2;
        this.f5747a = androidParagraphIntrinsics;
        this.f5748b = i11;
        this.f5749c = z11;
        this.f5750d = j11;
        if (q2.b.m(j11) != 0 || q2.b.n(j11) != 0) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        }
        if (i11 < 1) {
            throw new IllegalArgumentException("maxLines should be greater than 0".toString());
        }
        e0 e0VarI = androidParagraphIntrinsics.i();
        this.f5752f = b.k(e0VarI, z11) ? b.i(androidParagraphIntrinsics.f()) : androidParagraphIntrinsics.f();
        int iL = b.l(e0VarI.z());
        boolean zK = androidx.compose.ui.text.style.h.k(e0VarI.z(), androidx.compose.ui.text.style.h.f6101b.c());
        int iN = b.n(e0VarI.v().c());
        int iM = b.m(androidx.compose.ui.text.style.e.g(e0VarI.r()));
        int iO = b.o(androidx.compose.ui.text.style.e.h(e0VarI.r()));
        int iP = b.p(androidx.compose.ui.text.style.e.i(e0VarI.r()));
        TextUtils.TruncateAt truncateAt = z11 ? TextUtils.TruncateAt.END : null;
        s1 s1VarV = v(iL, zK ? 1 : 0, truncateAt, i11, iN, iM, iO, iP);
        if (!z11 || s1VarV.e() <= q2.b.k(j11) || i11 <= 1) {
            this.f5751e = s1VarV;
        } else {
            int iJ = b.j(s1VarV, q2.b.k(j11));
            if (iJ >= 0 && iJ != i11) {
                s1VarV = v(iL, zK ? 1 : 0, truncateAt, kotlin.ranges.a.d(iJ, 1), iN, iM, iO, iP);
            }
            this.f5751e = s1VarV;
        }
        z().e(e0VarI.g(), y1.n.a(getWidth(), getHeight()), e0VarI.d());
        ShaderBrushSpan[] shaderBrushSpanArrY = y(this.f5751e);
        if (shaderBrushSpanArrY != null) {
            Iterator itA = ArrayIteratorKt.a(shaderBrushSpanArrY);
            while (itA.hasNext()) {
                ((ShaderBrushSpan) itA.next()).c(y1.n.a(getWidth(), getHeight()));
            }
        }
        CharSequence charSequence = this.f5752f;
        if (charSequence instanceof Spanned) {
            Object[] spans = ((Spanned) charSequence).getSpans(0, charSequence.length(), n2.j.class);
            ArrayList arrayList = new ArrayList(spans.length);
            for (Object obj : spans) {
                n2.j jVar = (n2.j) obj;
                Spanned spanned = (Spanned) charSequence;
                int spanStart = spanned.getSpanStart(jVar);
                int spanEnd = spanned.getSpanEnd(jVar);
                int iP2 = this.f5751e.p(spanStart);
                boolean z12 = iP2 >= this.f5748b;
                boolean z13 = this.f5751e.m(iP2) > 0 && spanEnd > this.f5751e.n(iP2);
                boolean z14 = spanEnd > this.f5751e.o(iP2);
                if (z13 || z14 || z12) {
                    iVar = null;
                } else {
                    int i12 = C0061a.f5754a[q(spanStart).ordinal()];
                    if (i12 == 1) {
                        fW = w(spanStart, true);
                    } else {
                        if (i12 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        fW = w(spanStart, true) - jVar.d();
                    }
                    float fD = jVar.d() + fW;
                    s1 s1Var = this.f5751e;
                    switch (jVar.c()) {
                        case 0:
                            fJ = s1Var.j(iP2);
                            iB = jVar.b();
                            fV = fJ - iB;
                            iVar = new y1.i(fW, fV, fD, jVar.b() + fV);
                            break;
                        case 1:
                            fV = s1Var.v(iP2);
                            iVar = new y1.i(fW, fV, fD, jVar.b() + fV);
                            break;
                        case 2:
                            fJ = s1Var.k(iP2);
                            iB = jVar.b();
                            fV = fJ - iB;
                            iVar = new y1.i(fW, fV, fD, jVar.b() + fV);
                            break;
                        case 3:
                            fV = ((s1Var.v(iP2) + s1Var.k(iP2)) - jVar.b()) / 2;
                            iVar = new y1.i(fW, fV, fD, jVar.b() + fV);
                            break;
                        case 4:
                            fB = jVar.a().ascent;
                            fJ2 = s1Var.j(iP2);
                            fV = fB + fJ2;
                            iVar = new y1.i(fW, fV, fD, jVar.b() + fV);
                            break;
                        case 5:
                            fV = (jVar.a().descent + s1Var.j(iP2)) - jVar.b();
                            iVar = new y1.i(fW, fV, fD, jVar.b() + fV);
                            break;
                        case 6:
                            Paint.FontMetricsInt fontMetricsIntA = jVar.a();
                            fB = ((fontMetricsIntA.ascent + fontMetricsIntA.descent) - jVar.b()) / 2;
                            fJ2 = s1Var.j(iP2);
                            fV = fB + fJ2;
                            iVar = new y1.i(fW, fV, fD, jVar.b() + fV);
                            break;
                        default:
                            throw new IllegalStateException("unexpected verticalAlignment");
                    }
                }
                arrayList.add(iVar);
            }
            listL = arrayList;
        } else {
            listL = kotlin.collections.g.l();
        }
        this.f5753g = listL;
    }

    public /* synthetic */ a(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i11, boolean z11, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i11, z11, j11);
    }

    public final boolean A(Spanned spanned, Class<?> cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    public final void B(o1 o1Var) {
        Canvas canvasD = androidx.compose.ui.graphics.h0.d(o1Var);
        if (k()) {
            canvasD.save();
            canvasD.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.f5751e.F(canvasD);
        if (k()) {
            canvasD.restore();
        }
    }

    @Override // androidx.compose.ui.text.l
    public float a() {
        return this.f5747a.a();
    }

    @Override // androidx.compose.ui.text.l
    public void b(o1 o1Var, long j11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11) {
        int iB = z().b();
        AndroidTextPaint androidTextPaintZ = z();
        androidTextPaintZ.f(j11);
        androidTextPaintZ.h(b5Var);
        androidTextPaintZ.i(iVar);
        androidTextPaintZ.g(hVar);
        androidTextPaintZ.d(i11);
        B(o1Var);
        z().d(iB);
    }

    @Override // androidx.compose.ui.text.l
    public ResolvedTextDirection c(int i11) {
        return this.f5751e.x(this.f5751e.p(i11)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    @Override // androidx.compose.ui.text.l
    public float d(int i11) {
        return this.f5751e.v(i11);
    }

    @Override // androidx.compose.ui.text.l
    public y1.i e(int i11) {
        if (i11 >= 0 && i11 <= this.f5752f.length()) {
            float fZ = s1.z(this.f5751e, i11, false, 2, null);
            int iP = this.f5751e.p(i11);
            return new y1.i(fZ, this.f5751e.v(iP), fZ, this.f5751e.k(iP));
        }
        throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0," + this.f5752f.length() + ']').toString());
    }

    @Override // androidx.compose.ui.text.l
    public float f() {
        return x(0);
    }

    @Override // androidx.compose.ui.text.l
    public int g(int i11) {
        return this.f5751e.u(i11);
    }

    @Override // androidx.compose.ui.text.l
    public float getHeight() {
        return this.f5751e.e();
    }

    @Override // androidx.compose.ui.text.l
    public float getWidth() {
        return q2.b.l(this.f5750d);
    }

    @Override // androidx.compose.ui.text.l
    public int h(int i11, boolean z11) {
        return z11 ? this.f5751e.w(i11) : this.f5751e.o(i11);
    }

    @Override // androidx.compose.ui.text.l
    public int i() {
        return this.f5751e.l();
    }

    @Override // androidx.compose.ui.text.l
    public float j(int i11) {
        return this.f5751e.t(i11);
    }

    @Override // androidx.compose.ui.text.l
    public boolean k() {
        return this.f5751e.c();
    }

    @Override // androidx.compose.ui.text.l
    public int l(float f11) {
        return this.f5751e.q((int) f11);
    }

    @Override // androidx.compose.ui.text.l
    public float m(int i11) {
        return this.f5751e.s(i11);
    }

    @Override // androidx.compose.ui.text.l
    public void n(long j11, float[] fArr, int i11) {
        this.f5751e.a(c0.j(j11), c0.i(j11), fArr, i11);
    }

    @Override // androidx.compose.ui.text.l
    public float o() {
        return x(i() - 1);
    }

    @Override // androidx.compose.ui.text.l
    public int p(int i11) {
        return this.f5751e.p(i11);
    }

    @Override // androidx.compose.ui.text.l
    public ResolvedTextDirection q(int i11) {
        return this.f5751e.E(i11) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
    }

    @Override // androidx.compose.ui.text.l
    public float r(int i11) {
        return this.f5751e.k(i11);
    }

    @Override // androidx.compose.ui.text.l
    public y1.i s(int i11) {
        if (i11 >= 0 && i11 < this.f5752f.length()) {
            RectF rectFB = this.f5751e.b(i11);
            return new y1.i(rectFB.left, rectFB.top, rectFB.right, rectFB.bottom);
        }
        throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0," + this.f5752f.length() + ')').toString());
    }

    @Override // androidx.compose.ui.text.l
    public List<y1.i> t() {
        return this.f5753g;
    }

    @Override // androidx.compose.ui.text.l
    public void u(o1 o1Var, l1 l1Var, float f11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11) {
        int iB = z().b();
        AndroidTextPaint androidTextPaintZ = z();
        androidTextPaintZ.e(l1Var, y1.n.a(getWidth(), getHeight()), f11);
        androidTextPaintZ.h(b5Var);
        androidTextPaintZ.i(iVar);
        androidTextPaintZ.g(hVar);
        androidTextPaintZ.d(i11);
        B(o1Var);
        z().d(iB);
    }

    public final s1 v(int i11, int i12, TextUtils.TruncateAt truncateAt, int i13, int i14, int i15, int i16, int i17) {
        return new s1(this.f5752f, getWidth(), z(), i11, truncateAt, this.f5747a.j(), 1.0f, 0.0f, androidx.compose.ui.text.platform.c.b(this.f5747a.i()), true, i13, i15, i16, i17, i14, i12, null, null, this.f5747a.h(), 196736, null);
    }

    public float w(int i11, boolean z11) {
        return z11 ? s1.z(this.f5751e, i11, false, 2, null) : s1.B(this.f5751e, i11, false, 2, null);
    }

    public float x(int i11) {
        return this.f5751e.j(i11);
    }

    public final ShaderBrushSpan[] y(s1 s1Var) {
        if (!(s1Var.C() instanceof Spanned)) {
            return null;
        }
        CharSequence charSequenceC = s1Var.C();
        Intrinsics.e(charSequenceC, "null cannot be cast to non-null type android.text.Spanned");
        if (!A((Spanned) charSequenceC, ShaderBrushSpan.class)) {
            return null;
        }
        CharSequence charSequenceC2 = s1Var.C();
        Intrinsics.e(charSequenceC2, "null cannot be cast to non-null type android.text.Spanned");
        return (ShaderBrushSpan[]) ((Spanned) charSequenceC2).getSpans(0, s1Var.C().length(), ShaderBrushSpan.class);
    }

    public final AndroidTextPaint z() {
        return this.f5747a.k();
    }
}
