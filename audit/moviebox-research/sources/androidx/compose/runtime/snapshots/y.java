package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
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
public abstract class y<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t<K, V> f3716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator<Map.Entry<K, V>> f3717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map.Entry<? extends K, ? extends V> f3719d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map.Entry<? extends K, ? extends V> f3720f;

    /* JADX WARN: Multi-variable type inference failed */
    public y(t<K, V> tVar, Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        this.f3716a = tVar;
        this.f3717b = it;
        this.f3718c = tVar.d();
        d();
    }

    public final void d() {
        this.f3719d = this.f3720f;
        this.f3720f = this.f3717b.hasNext() ? this.f3717b.next() : null;
    }

    public final Map.Entry<K, V> f() {
        return this.f3719d;
    }

    public final t<K, V> g() {
        return this.f3716a;
    }

    public final boolean hasNext() {
        return this.f3720f != null;
    }

    public final Map.Entry<K, V> i() {
        return this.f3720f;
    }

    public final void remove() {
        if (g().d() != this.f3718c) {
            throw new ConcurrentModificationException();
        }
        Map.Entry<? extends K, ? extends V> entry = this.f3719d;
        if (entry == null) {
            throw new IllegalStateException();
        }
        this.f3716a.remove(entry.getKey());
        this.f3719d = null;
        Unit unit = Unit.f68710a;
        this.f3718c = g().d();
    }
}
