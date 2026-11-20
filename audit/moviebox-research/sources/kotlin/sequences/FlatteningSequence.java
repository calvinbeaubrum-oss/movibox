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
public final class FlatteningSequence<T, R, E> implements Sequence<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence<T> f69018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, R> f69019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<R, Iterator<E>> f69020c;

    /* JADX INFO: renamed from: kotlin.sequences.FlatteningSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<E>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f69021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<? extends E> f69022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FlatteningSequence<T, R, E> f69023c;

        public AnonymousClass1(FlatteningSequence<T, R, E> flatteningSequence) {
            this.f69023c = flatteningSequence;
            this.f69021a = flatteningSequence.f69018a.iterator();
        }

        public final boolean a() {
            Iterator<? extends E> it = this.f69022b;
            if (it != null && !it.hasNext()) {
                this.f69022b = null;
            }
            while (this.f69022b == null) {
                if (!this.f69021a.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) this.f69023c.f69020c.invoke(this.f69023c.f69019b.invoke(this.f69021a.next()));
                if (it2.hasNext()) {
                    this.f69022b = it2;
                    break;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f69022b;
            Intrinsics.d(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new AnonymousClass1(this);
    }
}
