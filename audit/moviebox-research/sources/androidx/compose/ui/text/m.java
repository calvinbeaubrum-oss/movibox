package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f5989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f5994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f5995g;

    public m(l lVar, int i11, int i12, int i13, int i14, float f11, float f12) {
        this.f5989a = lVar;
        this.f5990b = i11;
        this.f5991c = i12;
        this.f5992d = i13;
        this.f5993e = i14;
        this.f5994f = f11;
        this.f5995g = f12;
    }

    public final float a() {
        return this.f5995g;
    }

    public final int b() {
        return this.f5991c;
    }

    public final int c() {
        return this.f5993e;
    }

    public final int d() {
        return this.f5991c - this.f5990b;
    }

    public final l e() {
        return this.f5989a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Intrinsics.b(this.f5989a, mVar.f5989a) && this.f5990b == mVar.f5990b && this.f5991c == mVar.f5991c && this.f5992d == mVar.f5992d && this.f5993e == mVar.f5993e && Float.compare(this.f5994f, mVar.f5994f) == 0 && Float.compare(this.f5995g, mVar.f5995g) == 0;
    }

    public final int f() {
        return this.f5990b;
    }

    public final int g() {
        return this.f5992d;
    }

    public final float h() {
        return this.f5994f;
    }

    public int hashCode() {
        return (((((((((((this.f5989a.hashCode() * 31) + this.f5990b) * 31) + this.f5991c) * 31) + this.f5992d) * 31) + this.f5993e) * 31) + Float.floatToIntBits(this.f5994f)) * 31) + Float.floatToIntBits(this.f5995g);
    }

    public final y1.i i(y1.i iVar) {
        return iVar.q(y1.h.a(0.0f, this.f5994f));
    }

    public final int j(int i11) {
        return i11 + this.f5990b;
    }

    public final int k(int i11) {
        return i11 + this.f5992d;
    }

    public final float l(float f11) {
        return f11 + this.f5994f;
    }

    public final int m(int i11) {
        return kotlin.ranges.a.k(i11, this.f5990b, this.f5991c) - this.f5990b;
    }

    public final int n(int i11) {
        return i11 - this.f5992d;
    }

    public final float o(float f11) {
        return f11 - this.f5994f;
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.f5989a + ", startIndex=" + this.f5990b + ", endIndex=" + this.f5991c + ", startLineIndex=" + this.f5992d + ", endLineIndex=" + this.f5993e + ", top=" + this.f5994f + ", bottom=" + this.f5995g + ')';
    }
}
