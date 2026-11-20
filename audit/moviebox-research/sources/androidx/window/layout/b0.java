package androidx.window.layout;

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
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.window.core.b f13183a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(Rect bounds) {
        this(new androidx.window.core.b(bounds));
        Intrinsics.g(bounds, "bounds");
    }

    public b0(androidx.window.core.b _bounds) {
        Intrinsics.g(_bounds, "_bounds");
        this.f13183a = _bounds;
    }

    public final Rect a() {
        return this.f13183a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.b(b0.class, obj.getClass())) {
            return false;
        }
        return Intrinsics.b(this.f13183a, ((b0) obj).f13183a);
    }

    public int hashCode() {
        return this.f13183a.hashCode();
    }

    public String toString() {
        return "WindowMetrics { bounds: " + a() + " }";
    }
}
