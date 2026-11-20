package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
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
public class s extends r {
    public static <K, V> Map<K, V> h() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        Intrinsics.e(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    @SinceKotlin
    public static <K, V> V i(Map<K, ? extends V> map, K k11) {
        Intrinsics.g(map, "<this>");
        return (V) q.a(map, k11);
    }

    public static <K, V> HashMap<K, V> j(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.g(pairs, "pairs");
        HashMap<K, V> map = new HashMap<>(r.e(pairs.length));
        q(map, pairs);
        return map;
    }

    public static <K, V> Map<K, V> k(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.g(pairs, "pairs");
        return pairs.length > 0 ? u(pairs, new LinkedHashMap(r.e(pairs.length))) : h();
    }

    public static <K, V> Map<K, V> l(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.g(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(r.e(pairs.length));
        q(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> m(Map<K, ? extends V> map) {
        Intrinsics.g(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : r.g(map);
        }
        return h();
    }

    public static <K, V> Map<K, V> n(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        Intrinsics.g(map, "<this>");
        Intrinsics.g(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static <K, V> Map<K, V> o(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.g(map, "<this>");
        Intrinsics.g(pair, "pair");
        if (map.isEmpty()) {
            return r.f(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    public static final <K, V> void p(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.g(map, "<this>");
        Intrinsics.g(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void q(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.g(map, "<this>");
        Intrinsics.g(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static <K, V> Map<K, V> r(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m(s(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return s(iterable, new LinkedHashMap(r.e(collection.size())));
        }
        return r.f(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M s(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M destination) {
        Intrinsics.g(iterable, "<this>");
        Intrinsics.g(destination, "destination");
        p(destination, iterable);
        return destination;
    }

    @SinceKotlin
    public static <K, V> Map<K, V> t(Map<? extends K, ? extends V> map) {
        Intrinsics.g(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? v(map) : r.g(map);
        }
        return h();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M u(Pair<? extends K, ? extends V>[] pairArr, M destination) {
        Intrinsics.g(pairArr, "<this>");
        Intrinsics.g(destination, "destination");
        q(destination, pairArr);
        return destination;
    }

    @SinceKotlin
    public static <K, V> Map<K, V> v(Map<? extends K, ? extends V> map) {
        Intrinsics.g(map, "<this>");
        return new LinkedHashMap(map);
    }
}
