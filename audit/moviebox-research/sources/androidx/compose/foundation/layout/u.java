package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class u implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f2527d;

    public u(float f11, float f12, float f13, float f14) {
        this.f2524a = f11;
        this.f2525b = f12;
        this.f2526c = f13;
        this.f2527d = f14;
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Start padding must be non-negative".toString());
        }
        if (f12 < 0.0f) {
            throw new IllegalArgumentException("Top padding must be non-negative".toString());
        }
        if (f13 < 0.0f) {
            throw new IllegalArgumentException("End padding must be non-negative".toString());
        }
        if (f14 < 0.0f) {
            throw new IllegalArgumentException("Bottom padding must be non-negative".toString());
        }
    }

    public /* synthetic */ u(float f11, float f12, float f13, float f14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14);
    }

    @Override // androidx.compose.foundation.layout.t
    public float a() {
        return this.f2527d;
    }

    @Override // androidx.compose.foundation.layout.t
    public float b(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.f2524a : this.f2526c;
    }

    @Override // androidx.compose.foundation.layout.t
    public float c(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.f2526c : this.f2524a;
    }

    @Override // androidx.compose.foundation.layout.t
    public float d() {
        return this.f2525b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return q2.i.j(this.f2524a, uVar.f2524a) && q2.i.j(this.f2525b, uVar.f2525b) && q2.i.j(this.f2526c, uVar.f2526c) && q2.i.j(this.f2527d, uVar.f2527d);
    }

    public int hashCode() {
        return (((((q2.i.k(this.f2524a) * 31) + q2.i.k(this.f2525b)) * 31) + q2.i.k(this.f2526c)) * 31) + q2.i.k(this.f2527d);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) q2.i.l(this.f2524a)) + ", top=" + ((Object) q2.i.l(this.f2525b)) + ", end=" + ((Object) q2.i.l(this.f2526c)) + ", bottom=" + ((Object) q2.i.l(this.f2527d)) + ')';
    }
}
