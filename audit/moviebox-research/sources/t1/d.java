package t1;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public class d<K, V> extends AbstractMap<K, V> implements s1.g<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f76671g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f76672h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f76673i = new d(t.f76696e.a(), 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t<K, V> f76674d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f76675f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <K, V> d<K, V> a() {
            d<K, V> dVar = d.f76673i;
            Intrinsics.e(dVar, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return dVar;
        }
    }

    public d(t<K, V> tVar, int i11) {
        this.f76674d = tVar;
        this.f76675f = i11;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean containsKey(K k11) {
        return this.f76674d.k(k11 != null ? k11.hashCode() : 0, k11, 0);
    }

    @Override // kotlin.collections.AbstractMap
    @PublishedApi
    public final Set<Map.Entry<K, V>> f() {
        return r();
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public V get(K k11) {
        return this.f76674d.o(k11 != null ? k11.hashCode() : 0, k11, 0);
    }

    @Override // kotlin.collections.AbstractMap
    public int i() {
        return this.f76675f;
    }

    @Override // s1.g, androidx.compose.runtime.n1
    public f<K, V> q() {
        return new f<>(this);
    }

    public final s1.e<Map.Entry<K, V>> r() {
        return new n(this);
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public s1.e<K> g() {
        return new p(this);
    }

    public final t<K, V> t() {
        return this.f76674d;
    }

    @Override // kotlin.collections.AbstractMap
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public s1.b<V> j() {
        return new r(this);
    }

    public d<K, V> v(K k11, V v11) {
        t.b<K, V> bVarP = this.f76674d.P(k11 != null ? k11.hashCode() : 0, k11, v11, 0);
        return bVarP == null ? this : new d<>(bVarP.a(), size() + bVarP.b());
    }

    public d<K, V> w(K k11) {
        t<K, V> tVarQ = this.f76674d.Q(k11 != null ? k11.hashCode() : 0, k11, 0);
        if (this.f76674d == tVarQ) {
            return this;
        }
        return tVarQ == null ? f76671g.a() : new d<>(tVarQ, size() - 1);
    }
}
