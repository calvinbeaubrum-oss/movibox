package m2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
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
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f70657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f70658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f70659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0 f70660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f70661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Layout f70662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f70663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f70664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f70665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f70666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f70667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f70668l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint.FontMetricsInt f70669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f70670n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final n2.h[] f70671o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f70672p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h0 f70673q;

    public s1(CharSequence charSequence, float f11, TextPaint textPaint, int i11, TextUtils.TruncateAt truncateAt, int i12, float f12, float f13, boolean z11, boolean z12, int i13, int i14, int i15, int i16, int i17, int i18, int[] iArr, int[] iArr2, i0 i0Var) {
        TextDirectionHeuristic textDirectionHeuristic;
        Layout layoutA;
        this.f70657a = textPaint;
        this.f70658b = z11;
        this.f70659c = z12;
        this.f70660d = i0Var;
        this.f70672p = new Rect();
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristicK = t1.k(i12);
        Layout.Alignment alignmentA = q1.f70653a.a(i11);
        boolean z13 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, n2.a.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics metricsA = i0Var.a();
            double d11 = f11;
            int iCeil = (int) Math.ceil(d11);
            if (metricsA == null || i0Var.b() > f11 || z13) {
                this.f70668l = false;
                textDirectionHeuristic = textDirectionHeuristicK;
                layoutA = m1.f70625a.a(charSequence, textPaint, iCeil, 0, charSequence.length(), textDirectionHeuristicK, alignmentA, i13, truncateAt, (int) Math.ceil(d11), f12, f13, i18, z11, z12, i14, i15, i16, i17, iArr, iArr2);
            } else {
                this.f70668l = true;
                layoutA = e.f70596a.a(charSequence, textPaint, iCeil, metricsA, alignmentA, z11, z12, truncateAt, iCeil);
                textDirectionHeuristic = textDirectionHeuristicK;
            }
            this.f70662f = layoutA;
            Trace.endSection();
            int iMin = Math.min(layoutA.getLineCount(), i13);
            this.f70663g = iMin;
            int i19 = iMin - 1;
            this.f70661e = iMin >= i13 && (layoutA.getEllipsisCount(i19) > 0 || layoutA.getLineEnd(i19) != charSequence.length());
            long jL = t1.l(this);
            n2.h[] hVarArrJ = t1.j(this);
            this.f70671o = hVarArrJ;
            long jI = hVarArrJ != null ? t1.i(hVarArrJ) : t1.f70675b;
            this.f70664h = Math.max(u1.c(jL), u1.c(jI));
            this.f70665i = Math.max(u1.b(jL), u1.b(jI));
            Paint.FontMetricsInt fontMetricsIntH = t1.h(this, textPaint, textDirectionHeuristic, hVarArrJ);
            this.f70670n = fontMetricsIntH != null ? fontMetricsIntH.bottom - ((int) r(i19)) : 0;
            this.f70669m = fontMetricsIntH;
            this.f70666j = n2.d.b(layoutA, i19, null, 2, null);
            this.f70667k = n2.d.d(layoutA, i19, null, 2, null);
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ s1(CharSequence charSequence, float f11, TextPaint textPaint, int i11, TextUtils.TruncateAt truncateAt, int i12, float f12, float f13, boolean z11, boolean z12, int i13, int i14, int i15, int i16, int i17, int i18, int[] iArr, int[] iArr2, i0 i0Var, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        int i21 = (i19 & 8) != 0 ? 0 : i11;
        TextUtils.TruncateAt truncateAt2 = (i19 & 16) != 0 ? null : truncateAt;
        int i22 = (i19 & 32) != 0 ? 2 : i12;
        this(charSequence, f11, textPaint, i21, truncateAt2, i22, (i19 & 64) != 0 ? 1.0f : f12, (i19 & 128) != 0 ? 0.0f : f13, (i19 & 256) != 0 ? false : z11, (i19 & 512) != 0 ? true : z12, (i19 & 1024) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i13, (i19 & 2048) != 0 ? 0 : i14, (i19 & 4096) != 0 ? 0 : i15, (i19 & 8192) != 0 ? 0 : i16, (i19 & 16384) != 0 ? 0 : i17, (32768 & i19) != 0 ? 0 : i18, (65536 & i19) != 0 ? null : iArr, (131072 & i19) != 0 ? null : iArr2, (i19 & 262144) != 0 ? new i0(charSequence, textPaint, i22) : i0Var);
    }

    public static /* synthetic */ float B(s1 s1Var, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return s1Var.A(i11, z11);
    }

    public static /* synthetic */ float z(s1 s1Var, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return s1Var.y(i11, z11);
    }

    public final float A(int i11, boolean z11) {
        return i().c(i11, false, z11) + f(p(i11));
    }

    public final CharSequence C() {
        return this.f70662f.getText();
    }

    public final boolean D() {
        if (this.f70668l) {
            e eVar = e.f70596a;
            Layout layout = this.f70662f;
            Intrinsics.e(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            return eVar.b((BoringLayout) layout);
        }
        m1 m1Var = m1.f70625a;
        Layout layout2 = this.f70662f;
        Intrinsics.e(layout2, "null cannot be cast to non-null type android.text.StaticLayout");
        return m1Var.c((StaticLayout) layout2, this.f70659c);
    }

    public final boolean E(int i11) {
        return this.f70662f.isRtlCharAt(i11);
    }

    public final void F(Canvas canvas) {
        if (canvas.getClipBounds(this.f70672p)) {
            int i11 = this.f70664h;
            if (i11 != 0) {
                canvas.translate(0.0f, i11);
            }
            r1 r1Var = t1.f70674a;
            r1Var.a(canvas);
            this.f70662f.draw(r1Var);
            int i12 = this.f70664h;
            if (i12 != 0) {
                canvas.translate(0.0f, (-1) * i12);
            }
        }
    }

    public final void a(int i11, int i12, float[] fArr, int i13) {
        float fD;
        float fE;
        int length = C().length();
        if (i11 < 0) {
            throw new IllegalArgumentException("startOffset must be > 0".toString());
        }
        if (i11 >= length) {
            throw new IllegalArgumentException("startOffset must be less than text length".toString());
        }
        if (i12 <= i11) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset".toString());
        }
        if (i12 > length) {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length".toString());
        }
        if (fArr.length - i13 < (i12 - i11) * 4) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4".toString());
        }
        int iP = p(i11);
        int iP2 = p(i12 - 1);
        e0 e0Var = new e0(this);
        if (iP > iP2) {
            return;
        }
        while (true) {
            int iU = u(iP);
            int iO = o(iP);
            int iMin = Math.min(i12, iO);
            float fV = v(iP);
            float fK = k(iP);
            boolean z11 = x(iP) == 1;
            boolean z12 = !z11;
            for (int iMax = Math.max(i11, iU); iMax < iMin; iMax++) {
                boolean zE = E(iMax);
                if (z11 && !zE) {
                    fD = e0Var.b(iMax);
                    fE = e0Var.c(iMax + 1);
                } else if (z11 && zE) {
                    fE = e0Var.d(iMax);
                    fD = e0Var.e(iMax + 1);
                } else if (z12 && zE) {
                    fE = e0Var.b(iMax);
                    fD = e0Var.c(iMax + 1);
                } else {
                    fD = e0Var.d(iMax);
                    fE = e0Var.e(iMax + 1);
                }
                fArr[i13] = fD;
                fArr[i13 + 1] = fV;
                fArr[i13 + 2] = fE;
                fArr[i13 + 3] = fK;
                i13 += 4;
            }
            if (iP == iP2) {
                return;
            } else {
                iP++;
            }
        }
    }

    public final RectF b(int i11) {
        float fA;
        float fA2;
        float fY;
        float fY2;
        int iP = p(i11);
        float fV = v(iP);
        float fK = k(iP);
        boolean z11 = x(iP) == 1;
        boolean zIsRtlCharAt = this.f70662f.isRtlCharAt(i11);
        if (!z11 || zIsRtlCharAt) {
            if (z11 && zIsRtlCharAt) {
                fY = A(i11, false);
                fY2 = A(i11 + 1, true);
            } else if (zIsRtlCharAt) {
                fY = y(i11, false);
                fY2 = y(i11 + 1, true);
            } else {
                fA = A(i11, false);
                fA2 = A(i11 + 1, true);
            }
            float f11 = fY;
            fA = fY2;
            fA2 = f11;
        } else {
            fA = y(i11, false);
            fA2 = y(i11 + 1, true);
        }
        return new RectF(fA, fV, fA2, fK);
    }

    public final boolean c() {
        return this.f70661e;
    }

    public final boolean d() {
        return this.f70659c;
    }

    public final int e() {
        return (this.f70661e ? this.f70662f.getLineBottom(this.f70663g - 1) : this.f70662f.getHeight()) + this.f70664h + this.f70665i + this.f70670n;
    }

    public final float f(int i11) {
        if (i11 == this.f70663g - 1) {
            return this.f70666j + this.f70667k;
        }
        return 0.0f;
    }

    public final boolean g() {
        return this.f70658b;
    }

    public final Layout h() {
        return this.f70662f;
    }

    public final h0 i() {
        h0 h0Var = this.f70673q;
        if (h0Var != null) {
            Intrinsics.d(h0Var);
            return h0Var;
        }
        h0 h0Var2 = new h0(this.f70662f);
        this.f70673q = h0Var2;
        return h0Var2;
    }

    public final float j(int i11) {
        return this.f70664h + ((i11 != this.f70663g + (-1) || this.f70669m == null) ? this.f70662f.getLineBaseline(i11) : v(i11) - this.f70669m.ascent);
    }

    public final float k(int i11) {
        if (i11 != this.f70663g - 1 || this.f70669m == null) {
            return this.f70664h + this.f70662f.getLineBottom(i11) + (i11 == this.f70663g + (-1) ? this.f70665i : 0);
        }
        return this.f70662f.getLineBottom(i11 - 1) + this.f70669m.bottom;
    }

    public final int l() {
        return this.f70663g;
    }

    public final int m(int i11) {
        return this.f70662f.getEllipsisCount(i11);
    }

    public final int n(int i11) {
        return this.f70662f.getEllipsisStart(i11);
    }

    public final int o(int i11) {
        return this.f70662f.getEllipsisStart(i11) == 0 ? this.f70662f.getLineEnd(i11) : this.f70662f.getText().length();
    }

    public final int p(int i11) {
        return this.f70662f.getLineForOffset(i11);
    }

    public final int q(int i11) {
        return this.f70662f.getLineForVertical(i11 - this.f70664h);
    }

    public final float r(int i11) {
        return k(i11) - v(i11);
    }

    public final float s(int i11) {
        return this.f70662f.getLineLeft(i11) + (i11 == this.f70663g + (-1) ? this.f70666j : 0.0f);
    }

    public final float t(int i11) {
        return this.f70662f.getLineRight(i11) + (i11 == this.f70663g + (-1) ? this.f70667k : 0.0f);
    }

    public final int u(int i11) {
        return this.f70662f.getLineStart(i11);
    }

    public final float v(int i11) {
        return this.f70662f.getLineTop(i11) + (i11 == 0 ? 0 : this.f70664h);
    }

    public final int w(int i11) {
        if (this.f70662f.getEllipsisStart(i11) == 0) {
            return i().d(i11);
        }
        return this.f70662f.getEllipsisStart(i11) + this.f70662f.getLineStart(i11);
    }

    public final int x(int i11) {
        return this.f70662f.getParagraphDirection(i11);
    }

    public final float y(int i11, boolean z11) {
        return i().c(i11, true, z11) + f(p(i11));
    }
}
