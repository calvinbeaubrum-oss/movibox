package androidx.compose.foundation.layout;

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
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2521d;

    public r(int i11, int i12, int i13, int i14) {
        this.f2518a = i11;
        this.f2519b = i12;
        this.f2520c = i13;
        this.f2521d = i14;
    }

    public final int a() {
        return this.f2521d;
    }

    public final int b() {
        return this.f2518a;
    }

    public final int c() {
        return this.f2520c;
    }

    public final int d() {
        return this.f2519b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f2518a == rVar.f2518a && this.f2519b == rVar.f2519b && this.f2520c == rVar.f2520c && this.f2521d == rVar.f2521d;
    }

    public int hashCode() {
        return (((((this.f2518a * 31) + this.f2519b) * 31) + this.f2520c) * 31) + this.f2521d;
    }

    public String toString() {
        return "InsetsValues(left=" + this.f2518a + ", top=" + this.f2519b + ", right=" + this.f2520c + ", bottom=" + this.f2521d + ')';
    }
}
