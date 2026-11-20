package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
@Metadata
public final class MergingSequence<T1, T2, V> implements Sequence<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence<T1> f69032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Sequence<T2> f69033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<T1, T2, V> f69034c;

    /* JADX INFO: renamed from: kotlin.sequences.MergingSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<V>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T1> f69035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterator<T2> f69036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MergingSequence<T1, T2, V> f69037c;

        public AnonymousClass1(MergingSequence<T1, T2, V> mergingSequence) {
            this.f69037c = mergingSequence;
            this.f69035a = mergingSequence.f69032a.iterator();
            this.f69036b = mergingSequence.f69033b.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f69035a.hasNext() && this.f69036b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) this.f69037c.f69034c.invoke(this.f69035a.next(), this.f69036b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<V> iterator() {
        return new AnonymousClass1(this);
    }
}
