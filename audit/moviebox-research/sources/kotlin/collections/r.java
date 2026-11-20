package kotlin.collections;

import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class r extends q {
    @SinceKotlin
    @PublishedApi
    public static <K, V> Map<K, V> b(Map<K, V> builder) {
        Intrinsics.g(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    @SinceKotlin
    @PublishedApi
    public static <K, V> Map<K, V> c() {
        return new MapBuilder();
    }

    @SinceKotlin
    @PublishedApi
    public static <K, V> Map<K, V> d(int i11) {
        return new MapBuilder(i11);
    }

    @PublishedApi
    public static int e(int i11) {
        if (i11 < 0) {
            return i11;
        }
        if (i11 < 3) {
            return i11 + 1;
        }
        return i11 < 1073741824 ? (int) ((i11 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static <K, V> Map<K, V> f(Pair<? extends K, ? extends V> pair) {
        Intrinsics.g(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.f(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> g(Map<? extends K, ? extends V> map) {
        Intrinsics.g(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.f(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
