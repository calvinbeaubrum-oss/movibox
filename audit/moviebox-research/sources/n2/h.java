package n2;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;

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
public final class h implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f71460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f71462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f71463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f71464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f71465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f71466g = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f71467h = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f71468i = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f71469j = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f71470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f71471l;

    public h(float f11, int i11, int i12, boolean z11, boolean z12, float f12) {
        this.f71460a = f11;
        this.f71461b = i11;
        this.f71462c = i12;
        this.f71463d = z11;
        this.f71464e = z12;
        this.f71465f = f12;
        if ((0.0f > f12 || f12 > 1.0f) && f12 != -1.0f) {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }
    }

    public final void a(Paint.FontMetricsInt fontMetricsInt) {
        int iA = i.a(fontMetricsInt);
        int iCeil = (int) Math.ceil(this.f71460a);
        int i11 = iCeil - iA;
        float fAbs = this.f71465f;
        if (fAbs == -1.0f) {
            fAbs = Math.abs(fontMetricsInt.ascent) / i.a(fontMetricsInt);
        }
        int iCeil2 = (int) (i11 <= 0 ? Math.ceil(i11 * fAbs) : Math.ceil(i11 * (1.0f - fAbs)));
        int i12 = fontMetricsInt.descent;
        int i13 = iCeil2 + i12;
        this.f71468i = i13;
        int i14 = i13 - iCeil;
        this.f71467h = i14;
        if (this.f71463d) {
            i14 = fontMetricsInt.ascent;
        }
        this.f71466g = i14;
        if (this.f71464e) {
            i13 = i12;
        }
        this.f71469j = i13;
        this.f71470k = fontMetricsInt.ascent - i14;
        this.f71471l = i13 - i12;
    }

    public final h b(int i11, int i12, boolean z11) {
        return new h(this.f71460a, i11, i12, z11, this.f71464e, this.f71465f);
    }

    public final int c() {
        return this.f71470k;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i11, int i12, int i13, int i14, Paint.FontMetricsInt fontMetricsInt) {
        if (i.a(fontMetricsInt) <= 0) {
            return;
        }
        boolean z11 = i11 == this.f71461b;
        boolean z12 = i12 == this.f71462c;
        if (z11 && z12 && this.f71463d && this.f71464e) {
            return;
        }
        if (this.f71466g == Integer.MIN_VALUE) {
            a(fontMetricsInt);
        }
        fontMetricsInt.ascent = z11 ? this.f71466g : this.f71467h;
        fontMetricsInt.descent = z12 ? this.f71469j : this.f71468i;
    }

    public final int d() {
        return this.f71471l;
    }

    public final boolean e() {
        return this.f71464e;
    }
}
