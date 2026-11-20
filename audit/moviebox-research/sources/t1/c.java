package t1;

import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;

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
public final class c<K, V> extends b<K, V> implements KMutableMap.Entry {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i<K, V> f76669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V f76670d;

    public c(i<K, V> iVar, K k11, V v11) {
        super(k11, v11);
        this.f76669c = iVar;
        this.f76670d = v11;
    }

    public void a(V v11) {
        this.f76670d = v11;
    }

    @Override // t1.b, java.util.Map.Entry
    public V getValue() {
        return this.f76670d;
    }

    @Override // t1.b, java.util.Map.Entry
    public V setValue(V v11) {
        V value = getValue();
        a(v11);
        this.f76669c.c(getKey(), v11);
        return value;
    }
}
