package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
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
@Metadata
@SourceDebugExtension
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence<T> f69053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f69055c;

    /* JADX INFO: renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f69056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SubSequence<T> f69058c;

        public AnonymousClass1(SubSequence<T> subSequence) {
            this.f69058c = subSequence;
            this.f69056a = subSequence.f69053a.iterator();
        }

        private final void a() {
            while (this.f69057b < this.f69058c.f69054b && this.f69056a.hasNext()) {
                this.f69056a.next();
                this.f69057b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f69057b < this.f69058c.f69055c && this.f69056a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f69057b >= this.f69058c.f69055c) {
                throw new NoSuchElementException();
            }
            this.f69057b++;
            return this.f69056a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubSequence(Sequence<? extends T> sequence, int i11, int i12) {
        Intrinsics.g(sequence, "sequence");
        this.f69053a = sequence;
        this.f69054b = i11;
        this.f69055c = i12;
        if (i11 < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i11).toString());
        }
        if (i12 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i12).toString());
        }
        if (i12 >= i11) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i12 + " < " + i11).toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> a(int i11) {
        return i11 >= e() ? SequencesKt__SequencesKt.e() : new SubSequence(this.f69053a, this.f69054b + i11, this.f69055c);
    }

    public final int e() {
        return this.f69055c - this.f69054b;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
