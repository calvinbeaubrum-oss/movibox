package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;

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
public final class x<K, V> extends y<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f3713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f3714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x<K, V> f3715c;

        public a(x<K, V> xVar) {
            this.f3715c = xVar;
            Map.Entry<K, V> entryF = xVar.f();
            Intrinsics.d(entryF);
            this.f3713a = entryF.getKey();
            Map.Entry<K, V> entryF2 = xVar.f();
            Intrinsics.d(entryF2);
            this.f3714b = entryF2.getValue();
        }

        public void a(V v11) {
            this.f3714b = v11;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f3713a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3714b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            x<K, V> xVar = this.f3715c;
            if (xVar.g().d() != xVar.f3718c) {
                throw new ConcurrentModificationException();
            }
            V v12 = (V) getValue();
            xVar.g().put(getKey(), v11);
            a(v11);
            return v12;
        }
    }

    public x(t<K, V> tVar, Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        super(tVar, it);
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        d();
        if (f() != null) {
            return new a(this);
        }
        throw new IllegalStateException();
    }
}
