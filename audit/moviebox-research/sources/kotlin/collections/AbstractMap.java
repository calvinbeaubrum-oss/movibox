package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@SinceKotlin
@Metadata
@SourceDebugExtension
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f68721c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set<? extends K> f68722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Collection<? extends V> f68723b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return k(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (Intrinsics.b(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        Intrinsics.e(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V v11 = get(key);
        if (!Intrinsics.b(value, v11)) {
            return false;
        }
        if (v11 != null) {
            return true;
        }
        Intrinsics.e(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        return containsKey(key);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return f();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (!e((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Set f();

    public Set<K> g() {
        if (this.f68722a == null) {
            this.f68722a = new AbstractSet<K>(this) { // from class: kotlin.collections.AbstractMap$keys$1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ AbstractMap<K, V> f68724b;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f68724b = this;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
                public boolean contains(Object obj) {
                    return this.f68724b.containsKey(obj);
                }

                @Override // kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.f68724b.size();
                }

                @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
                public Iterator<K> iterator() {
                    return new AbstractMap$keys$1$iterator$1(this.f68724b.entrySet().iterator());
                }
            };
        }
        Set<? extends K> set = this.f68722a;
        Intrinsics.d(set);
        return set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        Map.Entry<K, V> entryK = k(obj);
        if (entryK != null) {
            return entryK.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    public int i() {
        return entrySet().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public Collection<V> j() {
        if (this.f68723b == null) {
            this.f68723b = new AbstractCollection<V>(this) { // from class: kotlin.collections.AbstractMap.values.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ AbstractMap<K, V> f68726a;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f68726a = this;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
                public boolean contains(Object obj) {
                    return this.f68726a.containsValue(obj);
                }

                @Override // kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.f68726a.size();
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
                public Iterator<V> iterator() {
                    return new AbstractMap$values$1$iterator$1(this.f68726a.entrySet().iterator());
                }
            };
        }
        Collection<? extends V> collection = this.f68723b;
        Intrinsics.d(collection);
        return collection;
    }

    public final Map.Entry<K, V> k(K k11) {
        Object next;
        Iterator<T> it = entrySet().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.b(((Map.Entry) next).getKey(), k11)) {
                return (Map.Entry) next;
            }
        }
        next = null;
        return (Map.Entry) next;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return g();
    }

    public final String l(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    public final String m(Map.Entry<? extends K, ? extends V> entry) {
        return l(entry.getKey()) + '=' + l(entry.getValue());
    }

    @Override // java.util.Map
    public V put(K k11, V v11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return i();
    }

    public String toString() {
        return CollectionsKt___CollectionsKt.o0(entrySet(), ", ", "{", "}", 0, null, new Function1<Map.Entry<? extends K, ? extends V>, CharSequence>(this) { // from class: kotlin.collections.AbstractMap.toString.1
            final /* synthetic */ AbstractMap<K, V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Map.Entry<? extends K, ? extends V> it) {
                Intrinsics.g(it, "it");
                return this.this$0.m(it);
            }
        }, 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return j();
    }
}
