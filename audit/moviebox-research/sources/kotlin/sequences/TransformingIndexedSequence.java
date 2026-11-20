package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.g;
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
public final class TransformingIndexedSequence<T, R> implements Sequence<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence<T> f69069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, T, R> f69070b;

    /* JADX INFO: renamed from: kotlin.sequences.TransformingIndexedSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<R>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f69071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TransformingIndexedSequence<T, R> f69073c;

        public AnonymousClass1(TransformingIndexedSequence<T, R> transformingIndexedSequence) {
            this.f69073c = transformingIndexedSequence;
            this.f69071a = transformingIndexedSequence.f69069a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f69071a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            Function2 function2 = this.f69073c.f69070b;
            int i11 = this.f69072b;
            this.f69072b = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            return (R) function2.invoke(Integer.valueOf(i11), this.f69071a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new AnonymousClass1(this);
    }
}
