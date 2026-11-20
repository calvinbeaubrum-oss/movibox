package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TransformingSequence<T, R> implements Sequence<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence<T> f69074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f69075b;

    /* JADX INFO: renamed from: kotlin.sequences.TransformingSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<R>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f69076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TransformingSequence<T, R> f69077b;

        public AnonymousClass1(TransformingSequence<T, R> transformingSequence) {
            this.f69077b = transformingSequence;
            this.f69076a = transformingSequence.f69074a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f69076a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f69077b.f69075b.invoke(this.f69076a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformingSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer) {
        Intrinsics.g(sequence, "sequence");
        Intrinsics.g(transformer, "transformer");
        this.f69074a = sequence;
        this.f69075b = transformer;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new AnonymousClass1(this);
    }
}
