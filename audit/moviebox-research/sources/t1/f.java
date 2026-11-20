package t1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
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
public class f<K, V> extends AbstractMutableMap<K, V> implements s1.g.a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d<K, V> f76679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v1.e f76680b = new v1.e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t<K, V> f76681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V f76682d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f76683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f76684g;

    public f(d<K, V> dVar) {
        this.f76679a = dVar;
        this.f76681c = this.f76679a.t();
        this.f76684g = this.f76679a.size();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> a() {
        return new h(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> c() {
        return new j(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        t<K, V> tVarA = t.f76696e.a();
        Intrinsics.e(tVarA, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f76681c = tVarA;
        n(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(K k11) {
        return this.f76681c.k(k11 != null ? k11.hashCode() : 0, k11, 0);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int d() {
        return this.f76684g;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection<V> e() {
        return new l(this);
    }

    @Override // s1.g.a, androidx.compose.runtime.n1.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d<K, V> build() {
        d<K, V> dVar;
        if (this.f76681c == this.f76679a.t()) {
            dVar = this.f76679a;
        } else {
            this.f76680b = new v1.e();
            dVar = new d<>(this.f76681c, size());
        }
        this.f76679a = dVar;
        return dVar;
    }

    public final int g() {
        return this.f76683f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(K k11) {
        return this.f76681c.o(k11 != null ? k11.hashCode() : 0, k11, 0);
    }

    public final t<K, V> i() {
        return this.f76681c;
    }

    public final v1.e j() {
        return this.f76680b;
    }

    public final void k(int i11) {
        this.f76683f = i11;
    }

    public final void l(V v11) {
        this.f76682d = v11;
    }

    public final void m(v1.e eVar) {
        this.f76680b = eVar;
    }

    public void n(int i11) {
        this.f76684g = i11;
        this.f76683f++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        this.f76682d = null;
        this.f76681c = this.f76681c.D(k11 != null ? k11.hashCode() : 0, k11, v11, 0, this);
        return this.f76682d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        d<K, V> dVarBuild = map instanceof d ? (d) map : null;
        if (dVarBuild == null) {
            f fVar = map instanceof f ? (f) map : null;
            dVarBuild = fVar != null ? fVar.build() : null;
        }
        if (dVarBuild == null) {
            super.putAll(map);
            return;
        }
        v1.b bVar = new v1.b(0, 1, null);
        int size = size();
        t<K, V> tVar = this.f76681c;
        t<K, V> tVarT = dVarBuild.t();
        Intrinsics.e(tVarT, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.f76681c = tVar.E(tVarT, 0, bVar, this);
        int size2 = (dVarBuild.size() + size) - bVar.a();
        if (size != size2) {
            n(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(K k11) {
        this.f76682d = null;
        t tVarG = this.f76681c.G(k11 != null ? k11.hashCode() : 0, k11, 0, this);
        if (tVarG == null) {
            tVarG = t.f76696e.a();
            Intrinsics.e(tVarG, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.f76681c = tVarG;
        return this.f76682d;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        t tVarH = this.f76681c.H(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (tVarH == null) {
            tVarH = t.f76696e.a();
            Intrinsics.e(tVarH, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.f76681c = tVarH;
        return size != size();
    }
}
