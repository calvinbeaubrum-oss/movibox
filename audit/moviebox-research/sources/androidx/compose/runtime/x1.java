package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3747a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3748b = new Object();

    public static final <K, V> boolean a(Map<K, List<V>> map, K k11, V v11) {
        List<V> arrayList = map.get(k11);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(k11, arrayList);
        }
        return arrayList.add(v11);
    }

    public static final <K, V> V b(Map<K, List<V>> map, K k11) {
        List<V> list = map.get(k11);
        if (list == null) {
            return null;
        }
        V v11 = (V) kotlin.collections.k.H(list);
        if (!list.isEmpty()) {
            return v11;
        }
        map.remove(k11);
        return v11;
    }
}
