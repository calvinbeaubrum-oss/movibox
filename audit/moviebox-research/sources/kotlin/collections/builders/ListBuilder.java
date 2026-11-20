package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class ListBuilder<E> extends AbstractMutableList<E> implements RandomAccess, Serializable {
    private static final a Companion = new a(null);
    private static final ListBuilder Empty;
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b<E> implements ListIterator<E>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListBuilder<E> f68790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f68792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f68793d;

        public b(ListBuilder<E> list, int i11) {
            Intrinsics.g(list, "list");
            this.f68790a = list;
            this.f68791b = i11;
            this.f68792c = -1;
            this.f68793d = ((AbstractList) list).modCount;
        }

        private final void a() {
            if (((AbstractList) this.f68790a).modCount != this.f68793d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E e11) {
            a();
            ListBuilder<E> listBuilder = this.f68790a;
            int i11 = this.f68791b;
            this.f68791b = i11 + 1;
            listBuilder.add(i11, e11);
            this.f68792c = -1;
            this.f68793d = ((AbstractList) this.f68790a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f68791b < ((ListBuilder) this.f68790a).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f68791b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            a();
            if (this.f68791b >= ((ListBuilder) this.f68790a).length) {
                throw new NoSuchElementException();
            }
            int i11 = this.f68791b;
            this.f68791b = i11 + 1;
            this.f68792c = i11;
            return (E) ((ListBuilder) this.f68790a).array[((ListBuilder) this.f68790a).offset + this.f68792c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f68791b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            a();
            int i11 = this.f68791b;
            if (i11 <= 0) {
                throw new NoSuchElementException();
            }
            int i12 = i11 - 1;
            this.f68791b = i12;
            this.f68792c = i12;
            return (E) ((ListBuilder) this.f68790a).array[((ListBuilder) this.f68790a).offset + this.f68792c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f68791b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i11 = this.f68792c;
            if (i11 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f68790a.remove(i11);
            this.f68791b = this.f68792c;
            this.f68792c = -1;
            this.f68793d = ((AbstractList) this.f68790a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(E e11) {
            a();
            int i11 = this.f68792c;
            if (i11 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f68790a.set(i11, e11);
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i11) {
        this(ListBuilderKt.d(i11), 0, 0, false, null, null);
    }

    private ListBuilder(E[] eArr, int i11, int i12, boolean z11, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i11;
        this.length = i12;
        this.isReadOnly = z11;
        this.backing = listBuilder;
        this.root = listBuilder2;
        if (listBuilder != null) {
            ((AbstractList) this).modCount = ((AbstractList) listBuilder).modCount;
        }
    }

    private final void addAllInternal(int i11, Collection<? extends E> collection, int i12) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i11, collection, i12);
            this.array = this.backing.array;
            this.length += i12;
        } else {
            insertAtInternal(i11, i12);
            Iterator<? extends E> it = collection.iterator();
            for (int i13 = 0; i13 < i12; i13++) {
                this.array[i11 + i13] = it.next();
            }
        }
    }

    private final void addAtInternal(int i11, E e11) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder == null) {
            insertAtInternal(i11, 1);
            this.array[i11] = e11;
        } else {
            listBuilder.addAtInternal(i11, e11);
            this.array = this.backing.array;
            this.length++;
        }
    }

    private final void checkForComodification() {
        ListBuilder<E> listBuilder = this.root;
        if (listBuilder != null && ((AbstractList) listBuilder).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        return ListBuilderKt.h(this.array, this.offset, this.length, list);
    }

    private final void ensureCapacityInternal(int i11) {
        if (i11 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.array;
        if (i11 > eArr.length) {
            this.array = (E[]) ListBuilderKt.e(this.array, kotlin.collections.AbstractList.Companion.e(eArr.length, i11));
        }
    }

    private final void ensureExtraCapacity(int i11) {
        ensureCapacityInternal(this.length + i11);
    }

    private final void insertAtInternal(int i11, int i12) {
        ensureExtraCapacity(i12);
        E[] eArr = this.array;
        ArraysKt___ArraysJvmKt.l(eArr, eArr, i11 + i12, i11, this.offset + this.length);
        this.length += i12;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final E removeAtInternal(int i11) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            E eRemoveAtInternal = listBuilder.removeAtInternal(i11);
            this.length--;
            return eRemoveAtInternal;
        }
        E[] eArr = this.array;
        E e11 = eArr[i11];
        ArraysKt___ArraysJvmKt.l(eArr, eArr, i11, i11 + 1, this.offset + this.length);
        ListBuilderKt.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e11;
    }

    private final void removeRangeInternal(int i11, int i12) {
        if (i12 > 0) {
            registerModification();
        }
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i11, i12);
        } else {
            E[] eArr = this.array;
            ArraysKt___ArraysJvmKt.l(eArr, eArr, i11, i11 + i12, this.length);
            E[] eArr2 = this.array;
            int i13 = this.length;
            ListBuilderKt.g(eArr2, i13 - i12, i13);
        }
        this.length -= i12;
    }

    private final int retainOrRemoveAllInternal(int i11, int i12, Collection<? extends E> collection, boolean z11) {
        int iRetainOrRemoveAllInternal;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            iRetainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i11, i12, collection, z11);
        } else {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i12) {
                int i15 = i11 + i13;
                if (collection.contains(this.array[i15]) == z11) {
                    E[] eArr = this.array;
                    i13++;
                    eArr[i14 + i11] = eArr[i15];
                    i14++;
                } else {
                    i13++;
                }
            }
            int i16 = i12 - i14;
            E[] eArr2 = this.array;
            ArraysKt___ArraysJvmKt.l(eArr2, eArr2, i11 + i14, i12 + i11, this.length);
            E[] eArr3 = this.array;
            int i17 = this.length;
            ListBuilderKt.g(eArr3, i17 - i16, i17);
            iRetainOrRemoveAllInternal = i16;
        }
        if (iRetainOrRemoveAllInternal > 0) {
            registerModification();
        }
        this.length -= iRetainOrRemoveAllInternal;
        return iRetainOrRemoveAllInternal;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i11, E e11) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.c(i11, this.length);
        addAtInternal(this.offset + i11, e11);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e11) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, e11);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i11, Collection<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.c(i11, this.length);
        int size = elements.size();
        addAllInternal(this.offset + i11, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        checkIsMutable();
        checkForComodification();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    public final List<E> build() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        checkIsMutable();
        this.isReadOnly = true;
        return this.length > 0 ? this : Empty;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        checkForComodification();
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i11) {
        checkForComodification();
        kotlin.collections.AbstractList.Companion.b(i11, this.length);
        return this.array[this.offset + i11];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        checkForComodification();
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        checkForComodification();
        return ListBuilderKt.i(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        checkForComodification();
        for (int i11 = 0; i11 < this.length; i11++) {
            if (Intrinsics.b(this.array[this.offset + i11], obj)) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkForComodification();
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        checkForComodification();
        for (int i11 = this.length - 1; i11 >= 0; i11--) {
            if (Intrinsics.b(this.array[this.offset + i11], obj)) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i11) {
        checkForComodification();
        kotlin.collections.AbstractList.Companion.c(i11, this.length);
        return new b(this, i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        checkForComodification();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        checkIsMutable();
        checkForComodification();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int i11) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.b(i11, this.length);
        return removeAtInternal(this.offset + i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        checkIsMutable();
        checkForComodification();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i11, E e11) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.Companion.b(i11, this.length);
        E[] eArr = this.array;
        int i12 = this.offset;
        E e12 = eArr[i12 + i11];
        eArr[i12 + i11] = e11;
        return e12;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int i11, int i12) {
        kotlin.collections.AbstractList.Companion.d(i11, i12, this.length);
        E[] eArr = this.array;
        int i13 = this.offset + i11;
        int i14 = i12 - i11;
        boolean z11 = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i13, i14, z11, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        checkForComodification();
        E[] eArr = this.array;
        int i11 = this.offset;
        return ArraysKt___ArraysJvmKt.r(eArr, i11, this.length + i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] destination) {
        Intrinsics.g(destination, "destination");
        checkForComodification();
        int length = destination.length;
        int i11 = this.length;
        if (length >= i11) {
            E[] eArr = this.array;
            int i12 = this.offset;
            ArraysKt___ArraysJvmKt.l(eArr, destination, 0, i12, i11 + i12);
            return (T[]) f.g(this.length, destination);
        }
        E[] eArr2 = this.array;
        int i13 = this.offset;
        T[] tArr = (T[]) Arrays.copyOfRange(eArr2, i13, i11 + i13, destination.getClass());
        Intrinsics.f(tArr, "copyOfRange(...)");
        return tArr;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        checkForComodification();
        return ListBuilderKt.j(this.array, this.offset, this.length, this);
    }
}
