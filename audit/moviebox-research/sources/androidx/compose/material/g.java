package androidx.compose.material;

import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.material.ripple.c f3088b;

    public g(long j11, androidx.compose.material.ripple.c cVar) {
        this.f3087a = j11;
        this.f3088b = cVar;
    }

    public /* synthetic */ g(long j11, androidx.compose.material.ripple.c cVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? w1.f4564b.e() : j11, (i11 & 2) != 0 ? null : cVar, null);
    }

    public /* synthetic */ g(long j11, androidx.compose.material.ripple.c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, cVar);
    }

    public final long a() {
        return this.f3087a;
    }

    public final androidx.compose.material.ripple.c b() {
        return this.f3088b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return w1.m(this.f3087a, gVar.f3087a) && Intrinsics.b(this.f3088b, gVar.f3088b);
    }

    public int hashCode() {
        int iS = w1.s(this.f3087a) * 31;
        androidx.compose.material.ripple.c cVar = this.f3088b;
        return iS + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "RippleConfiguration(color=" + ((Object) w1.t(this.f3087a)) + ", rippleAlpha=" + this.f3088b + ')';
    }
}
