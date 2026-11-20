package t1;

import java.util.Map;
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
public final class y<K, V> extends u<K, V, Map.Entry<K, V>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i<K, V> f76708d;

    public y(i<K, V> iVar) {
        this.f76708d = iVar;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        v1.a.a(g());
        n(f() + 2);
        return new c(this.f76708d, d()[f() - 2], d()[f() - 1]);
    }
}
