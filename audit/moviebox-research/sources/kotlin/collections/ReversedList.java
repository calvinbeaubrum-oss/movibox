package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

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
public final class ReversedList<T> extends AbstractMutableList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f68772a;

    /* JADX INFO: renamed from: kotlin.collections.ReversedList$listIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListIterator<T> f68773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReversedList<T> f68774b;

        public AnonymousClass1(ReversedList<T> reversedList, int i11) {
            this.f68774b = reversedList;
            this.f68773a = reversedList.f68772a.listIterator(l.T(reversedList, i11));
        }

        @Override // java.util.ListIterator
        public void add(T t11) {
            this.f68773a.add(t11);
            this.f68773a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f68773a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f68773a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f68773a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return l.S(this.f68774b, this.f68773a.previousIndex());
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f68773a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return l.S(this.f68774b, this.f68773a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f68773a.remove();
        }

        @Override // java.util.ListIterator
        public void set(T t11) {
            this.f68773a.set(t11);
        }
    }

    public ReversedList(List<T> delegate) {
        Intrinsics.g(delegate, "delegate");
        this.f68772a = delegate;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i11, T t11) {
        this.f68772a.add(l.T(this, i11), t11);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f68772a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i11) {
        return this.f68772a.get(l.R(this, i11));
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f68772a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<T> listIterator(int i11) {
        return new AnonymousClass1(this, i11);
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int i11) {
        return this.f68772a.remove(l.R(this, i11));
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int i11, T t11) {
        return this.f68772a.set(l.R(this, i11), t11);
    }
}
