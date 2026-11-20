package kotlin.collections;

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
public final class IndexedValue<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f68765b;

    public IndexedValue(int i11, T t11) {
        this.f68764a = i11;
        this.f68765b = t11;
    }

    public final int a() {
        return this.f68764a;
    }

    public final T b() {
        return this.f68765b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f68764a == indexedValue.f68764a && Intrinsics.b(this.f68765b, indexedValue.f68765b);
    }

    public int hashCode() {
        int i11 = this.f68764a * 31;
        T t11 = this.f68765b;
        return i11 + (t11 == null ? 0 : t11.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f68764a + ", value=" + this.f68765b + ')';
    }
}
