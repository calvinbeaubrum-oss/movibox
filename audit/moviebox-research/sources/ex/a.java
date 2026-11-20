package ex;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64461b;

    public a(int i11, String strVal) {
        Intrinsics.g(strVal, "strVal");
        this.f64460a = i11;
        this.f64461b = strVal;
    }

    public final String a() {
        return this.f64461b;
    }

    public final int b() {
        return this.f64460a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f64460a == aVar.f64460a && Intrinsics.b(this.f64461b, aVar.f64461b);
    }

    public int hashCode() {
        return (this.f64460a * 31) + this.f64461b.hashCode();
    }

    public String toString() {
        return "HistoryVal(type=" + this.f64460a + ", strVal=" + this.f64461b + ")";
    }
}
