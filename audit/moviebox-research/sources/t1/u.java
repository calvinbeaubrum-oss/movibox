package t1;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public abstract class u<K, V, T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f76705a = t.f76696e.a().p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f76707c;

    public final K a() {
        v1.a.a(g());
        return (K) this.f76705a[this.f76707c];
    }

    public final t<? extends K, ? extends V> c() {
        v1.a.a(i());
        Object obj = this.f76705a[this.f76707c];
        Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (t) obj;
    }

    public final Object[] d() {
        return this.f76705a;
    }

    public final int f() {
        return this.f76707c;
    }

    public final boolean g() {
        return this.f76707c < this.f76706b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return g();
    }

    public final boolean i() {
        v1.a.a(this.f76707c >= this.f76706b);
        return this.f76707c < this.f76705a.length;
    }

    public final void j() {
        v1.a.a(g());
        this.f76707c += 2;
    }

    public final void k() {
        v1.a.a(i());
        this.f76707c++;
    }

    public final void l(Object[] objArr, int i11) {
        m(objArr, i11, 0);
    }

    public final void m(Object[] objArr, int i11, int i12) {
        this.f76705a = objArr;
        this.f76706b = i11;
        this.f76707c = i12;
    }

    public final void n(int i11) {
        this.f76707c = i11;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
