package m2;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.Metadata;
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
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f70632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f70634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f70635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f70636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextDirectionHeuristic f70637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Layout.Alignment f70638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f70639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextUtils.TruncateAt f70640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f70641j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f70642k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f70643l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f70644m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f70645n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f70646o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f70647p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f70648q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f70649r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f70650s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f70651t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f70652u;

    public p1(CharSequence charSequence, int i11, int i12, TextPaint textPaint, int i13, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i14, TextUtils.TruncateAt truncateAt, int i15, float f11, float f12, int i16, boolean z11, boolean z12, int i17, int i18, int i19, int i21, int[] iArr, int[] iArr2) {
        this.f70632a = charSequence;
        this.f70633b = i11;
        this.f70634c = i12;
        this.f70635d = textPaint;
        this.f70636e = i13;
        this.f70637f = textDirectionHeuristic;
        this.f70638g = alignment;
        this.f70639h = i14;
        this.f70640i = truncateAt;
        this.f70641j = i15;
        this.f70642k = f11;
        this.f70643l = f12;
        this.f70644m = i16;
        this.f70645n = z11;
        this.f70646o = z12;
        this.f70647p = i17;
        this.f70648q = i18;
        this.f70649r = i19;
        this.f70650s = i21;
        this.f70651t = iArr;
        this.f70652u = iArr2;
        if (i11 < 0 || i11 > i12) {
            throw new IllegalArgumentException("invalid start value".toString());
        }
        int length = charSequence.length();
        if (i12 < 0 || i12 > length) {
            throw new IllegalArgumentException("invalid end value".toString());
        }
        if (i14 < 0) {
            throw new IllegalArgumentException("invalid maxLines value".toString());
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("invalid width value".toString());
        }
        if (i15 < 0) {
            throw new IllegalArgumentException("invalid ellipsizedWidth value".toString());
        }
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("invalid lineSpacingMultiplier value".toString());
        }
    }

    public final Layout.Alignment a() {
        return this.f70638g;
    }

    public final int b() {
        return this.f70647p;
    }

    public final TextUtils.TruncateAt c() {
        return this.f70640i;
    }

    public final int d() {
        return this.f70641j;
    }

    public final int e() {
        return this.f70634c;
    }

    public final int f() {
        return this.f70650s;
    }

    public final boolean g() {
        return this.f70645n;
    }

    public final int h() {
        return this.f70644m;
    }

    public final int[] i() {
        return this.f70651t;
    }

    public final int j() {
        return this.f70648q;
    }

    public final int k() {
        return this.f70649r;
    }

    public final float l() {
        return this.f70643l;
    }

    public final float m() {
        return this.f70642k;
    }

    public final int n() {
        return this.f70639h;
    }

    public final TextPaint o() {
        return this.f70635d;
    }

    public final int[] p() {
        return this.f70652u;
    }

    public final int q() {
        return this.f70633b;
    }

    public final CharSequence r() {
        return this.f70632a;
    }

    public final TextDirectionHeuristic s() {
        return this.f70637f;
    }

    public final boolean t() {
        return this.f70646o;
    }

    public final int u() {
        return this.f70636e;
    }
}
