package androidx.compose.runtime;

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
public final class c3<T> implements g3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f3354a;

    public c3(T t11) {
        this.f3354a = t11;
    }

    @Override // androidx.compose.runtime.g3
    public T a(n1 n1Var) {
        return this.f3354a;
    }

    public final T b() {
        return this.f3354a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c3) && Intrinsics.b(this.f3354a, ((c3) obj).f3354a);
    }

    public int hashCode() {
        T t11 = this.f3354a;
        if (t11 == null) {
            return 0;
        }
        return t11.hashCode();
    }

    public String toString() {
        return "StaticValueHolder(value=" + this.f3354a + ')';
    }
}
