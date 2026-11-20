package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
public final class FilteringSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence<T> f69011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f69012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<T, Boolean> f69013c;

    /* JADX INFO: renamed from: kotlin.sequences.FilteringSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f69014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69015b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f69016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FilteringSequence<T> f69017d;

        public AnonymousClass1(FilteringSequence<T> filteringSequence) {
            this.f69017d = filteringSequence;
            this.f69014a = filteringSequence.f69011a.iterator();
        }

        public final void a() {
            while (this.f69014a.hasNext()) {
                T next = this.f69014a.next();
                if (((Boolean) this.f69017d.f69013c.invoke(next)).booleanValue() == this.f69017d.f69012b) {
                    this.f69016c = next;
                    this.f69015b = 1;
                    return;
                }
            }
            this.f69015b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f69015b == -1) {
                a();
            }
            return this.f69015b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f69015b == -1) {
                a();
            }
            if (this.f69015b == 0) {
                throw new NoSuchElementException();
            }
            T t11 = this.f69016c;
            this.f69016c = null;
            this.f69015b = -1;
            return t11;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilteringSequence(Sequence<? extends T> sequence, boolean z11, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(sequence, "sequence");
        Intrinsics.g(predicate, "predicate");
        this.f69011a = sequence;
        this.f69012b = z11;
        this.f69013c = predicate;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
