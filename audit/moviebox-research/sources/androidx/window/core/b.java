package androidx.window.core;

import android.graphics.Rect;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13136d;

    public b(int i11, int i12, int i13, int i14) {
        this.f13133a = i11;
        this.f13134b = i12;
        this.f13135c = i13;
        this.f13136d = i14;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        Intrinsics.g(rect, "rect");
    }

    public final int a() {
        return this.f13136d - this.f13134b;
    }

    public final int b() {
        return this.f13133a;
    }

    public final int c() {
        return this.f13134b;
    }

    public final int d() {
        return this.f13135c - this.f13133a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(b.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
        }
        b bVar = (b) obj;
        return this.f13133a == bVar.f13133a && this.f13134b == bVar.f13134b && this.f13135c == bVar.f13135c && this.f13136d == bVar.f13136d;
    }

    public final Rect f() {
        return new Rect(this.f13133a, this.f13134b, this.f13135c, this.f13136d);
    }

    public int hashCode() {
        return (((((this.f13133a * 31) + this.f13134b) * 31) + this.f13135c) * 31) + this.f13136d;
    }

    public String toString() {
        return ((Object) b.class.getSimpleName()) + " { [" + this.f13133a + ',' + this.f13134b + ',' + this.f13135c + ',' + this.f13136d + "] }";
    }
}
