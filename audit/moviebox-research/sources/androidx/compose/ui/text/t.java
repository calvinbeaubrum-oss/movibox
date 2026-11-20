package androidx.compose.ui.text;

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
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6149c;

    public final long a() {
        return this.f6148b;
    }

    public final int b() {
        return this.f6149c;
    }

    public final long c() {
        return this.f6147a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return q2.w.e(this.f6147a, tVar.f6147a) && q2.w.e(this.f6148b, tVar.f6148b) && u.i(this.f6149c, tVar.f6149c);
    }

    public int hashCode() {
        return (((q2.w.i(this.f6147a) * 31) + q2.w.i(this.f6148b)) * 31) + u.j(this.f6149c);
    }

    public String toString() {
        return "Placeholder(width=" + ((Object) q2.w.j(this.f6147a)) + ", height=" + ((Object) q2.w.j(this.f6148b)) + ", placeholderVerticalAlign=" + ((Object) u.k(this.f6149c)) + ')';
    }
}
