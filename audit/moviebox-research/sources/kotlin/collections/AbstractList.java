package kotlin.collections;

import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@SinceKotlin
@Metadata
@SourceDebugExtension
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    public static final Companion Companion = new Companion(null);
    private static final int maxArraySize = 2147483639;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i11, int i12, int i13) {
            if (i11 < 0 || i12 > i13) {
                throw new IndexOutOfBoundsException("startIndex: " + i11 + ", endIndex: " + i12 + ", size: " + i13);
            }
            if (i11 <= i12) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i11 + " > endIndex: " + i12);
        }

        public final void b(int i11, int i12) {
            if (i11 < 0 || i11 >= i12) {
                throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
            }
        }

        public final void c(int i11, int i12) {
            if (i11 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
            }
        }

        public final void d(int i11, int i12, int i13) {
            if (i11 < 0 || i12 > i13) {
                throw new IndexOutOfBoundsException("fromIndex: " + i11 + ", toIndex: " + i12 + ", size: " + i13);
            }
            if (i11 <= i12) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i11 + " > toIndex: " + i12);
        }

        public final int e(int i11, int i12) {
            int i13 = i11 + (i11 >> 1);
            if (i13 - i12 < 0) {
                i13 = i12;
            }
            if (i13 - AbstractList.maxArraySize > 0) {
                return i12 > AbstractList.maxArraySize ? Api.BaseClientBuilder.API_PRIORITY_OTHER : AbstractList.maxArraySize;
            }
            return i13;
        }

        public final boolean f(Collection<?> c11, Collection<?> other) {
            Intrinsics.g(c11, "c");
            Intrinsics.g(other, "other");
            if (c11.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c11.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection<?> c11) {
            Intrinsics.g(c11, "c");
            Iterator<?> it = c11.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public class a implements Iterator<E>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f68715a;

        public a() {
        }

        public final int a() {
            return this.f68715a;
        }

        public final void c(int i11) {
            this.f68715a = i11;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f68715a < AbstractList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractList<E> abstractList = AbstractList.this;
            int i11 = this.f68715a;
            this.f68715a = i11 + 1;
            return abstractList.get(i11);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public class b extends AbstractList<E>.a implements ListIterator<E> {
        public b(int i11) {
            super();
            AbstractList.Companion.c(i11, AbstractList.this.size());
            c(i11);
        }

        @Override // java.util.ListIterator
        public void add(E e11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractList<E> abstractList = AbstractList.this;
            c(a() - 1);
            return abstractList.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c<E> extends AbstractList<E> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractList<E> f68718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f68719b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f68720c;

        /* JADX WARN: Multi-variable type inference failed */
        public c(AbstractList<? extends E> list, int i11, int i12) {
            Intrinsics.g(list, "list");
            this.f68718a = list;
            this.f68719b = i11;
            AbstractList.Companion.d(i11, i12, list.size());
            this.f68720c = i12 - i11;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int i11) {
            AbstractList.Companion.b(i11, this.f68720c);
            return this.f68718a.get(this.f68719b + i11);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f68720c;
        }
    }

    @Override // java.util.List
    public void add(int i11, E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i11);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.g(this);
    }

    public int indexOf(E e11) {
        Iterator<E> it = iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (Intrinsics.b(it.next(), e11)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a();
    }

    public int lastIndexOf(E e11) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.b(listIterator.previous(), e11)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return new b(0);
    }

    public ListIterator<E> listIterator(int i11) {
        return new b(i11);
    }

    @Override // java.util.List
    public E remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public E set(int i11, E e11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<E> subList(int i11, int i12) {
        return new c(this, i11, i12);
    }
}
