package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.o1;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class f0<T> implements List<T>, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SnapshotStateList<T> f3661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3664d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f3665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0<T> f3666b;

        public a(Ref.IntRef intRef, f0<T> f0Var) {
            this.f3665a = intRef;
            this.f3666b = f0Var;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void add(T t11) {
            s.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            s.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void set(T t11) {
            s.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f3665a.element < this.f3666b.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f3665a.element >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            int i11 = this.f3665a.element + 1;
            s.g(i11, this.f3666b.size());
            this.f3665a.element = i11;
            return this.f3666b.get(i11);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f3665a.element + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i11 = this.f3665a.element;
            s.g(i11, this.f3666b.size());
            this.f3665a.element = i11 - 1;
            return this.f3666b.get(i11);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f3665a.element;
        }
    }

    public f0(SnapshotStateList<T> snapshotStateList, int i11, int i12) {
        this.f3661a = snapshotStateList;
        this.f3662b = i11;
        this.f3663c = snapshotStateList.f();
        this.f3664d = i12 - i11;
    }

    public int a() {
        return this.f3664d;
    }

    @Override // java.util.List
    public void add(int i11, T t11) {
        f();
        this.f3661a.add(this.f3662b + i11, t11);
        this.f3664d = size() + 1;
        this.f3663c = this.f3661a.f();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t11) {
        f();
        this.f3661a.add(this.f3662b + size(), t11);
        this.f3664d = size() + 1;
        this.f3663c = this.f3661a.f();
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i11, Collection<? extends T> collection) {
        f();
        boolean zAddAll = this.f3661a.addAll(i11 + this.f3662b, collection);
        if (zAddAll) {
            this.f3664d = size() + collection.size();
            this.f3663c = this.f3661a.f();
        }
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            f();
            SnapshotStateList<T> snapshotStateList = this.f3661a;
            int i11 = this.f3662b;
            snapshotStateList.j(i11, size() + i11);
            this.f3664d = 0;
            this.f3663c = this.f3661a.f();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public T e(int i11) {
        f();
        T tRemove = this.f3661a.remove(this.f3662b + i11);
        this.f3664d = size() - 1;
        this.f3663c = this.f3661a.f();
        return tRemove;
    }

    public final void f() {
        if (this.f3661a.f() != this.f3663c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List
    public T get(int i11) {
        f();
        s.g(i11, size());
        return this.f3661a.get(this.f3662b + i11);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        f();
        int i11 = this.f3662b;
        Iterator<Integer> it = kotlin.ranges.a.r(i11, size() + i11).iterator();
        while (it.hasNext()) {
            int iA = ((IntIterator) it).a();
            if (Intrinsics.b(obj, this.f3661a.get(iA))) {
                return iA - this.f3662b;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        f();
        int size = this.f3662b + size();
        do {
            size--;
            if (size < this.f3662b) {
                return -1;
            }
        } while (!Intrinsics.b(obj, this.f3661a.get(size)));
        return size - this.f3662b;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i11) {
        f();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i11 - 1;
        return new a(intRef, this);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i11) {
        return e(i11);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        Iterator<? extends Object> it = collection.iterator();
        while (true) {
            boolean z11 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z11) {
                    z11 = true;
                }
            }
            return z11;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        f();
        SnapshotStateList<T> snapshotStateList = this.f3661a;
        int i11 = this.f3662b;
        int iR = snapshotStateList.r(collection, i11, size() + i11);
        if (iR > 0) {
            this.f3663c = this.f3661a.f();
            this.f3664d = size() - iR;
        }
        return iR > 0;
    }

    @Override // java.util.List
    public T set(int i11, T t11) {
        s.g(i11, size());
        f();
        T t12 = this.f3661a.set(i11 + this.f3662b, t11);
        this.f3663c = this.f3661a.f();
        return t12;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.List
    public List<T> subList(int i11, int i12) {
        if (!(i11 >= 0 && i11 <= i12 && i12 <= size())) {
            o1.a("fromIndex or toIndex are out of bounds");
        }
        f();
        SnapshotStateList<T> snapshotStateList = this.f3661a;
        int i13 = this.f3662b;
        return new f0(snapshotStateList, i11 + i13, i12 + i13);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.b(this, tArr);
    }
}
