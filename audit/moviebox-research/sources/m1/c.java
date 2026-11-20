package m1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
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
public final class c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f70588a;

    public c(int i11, float f11) {
        this.f70588a = new LinkedHashMap<>(i11, f11, true);
    }

    public final V a(K key) {
        Intrinsics.g(key, "key");
        return this.f70588a.get(key);
    }

    public final Set<Map.Entry<K, V>> b() {
        Set<Map.Entry<K, V>> setEntrySet = this.f70588a.entrySet();
        Intrinsics.f(setEntrySet, "map.entries");
        return setEntrySet;
    }

    public final boolean c() {
        return this.f70588a.isEmpty();
    }

    public final V d(K key, V value) {
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
        return this.f70588a.put(key, value);
    }

    public final V e(K key) {
        Intrinsics.g(key, "key");
        return this.f70588a.remove(key);
    }
}
