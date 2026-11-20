package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;

/* JADX INFO: Add missing generic type declarations: [E] */
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
public final class MutableScatterSet$MutableSetWrapper$iterator$1<E> implements Iterator<E>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1892a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator<E> f1893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MutableScatterSet<E> f1894c;

    public MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet<E> mutableScatterSet) {
        this.f1894c = mutableScatterSet;
        this.f1893b = SequencesKt__SequenceBuilderKt.a(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(mutableScatterSet, this, null));
    }

    public final void a(int i11) {
        this.f1892a = i11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1893b.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.f1893b.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i11 = this.f1892a;
        if (i11 != -1) {
            this.f1894c.y(i11);
            this.f1892a = -1;
        }
    }
}
