package androidx.compose.runtime.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.g;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
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
public final class b<T> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3357d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f3358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<T> f3359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3360c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<T> implements List<T>, KMutableList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<T> f3361a;

        public a(b<T> bVar) {
            this.f3361a = bVar;
        }

        public int a() {
            return this.f3361a.r();
        }

        @Override // java.util.List
        public void add(int i11, T t11) {
            this.f3361a.a(i11, t11);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t11) {
            return this.f3361a.b(t11);
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection<? extends T> collection) {
            return this.f3361a.e(i11, collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            return this.f3361a.g(collection);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.f3361a.i();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.f3361a.j(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            return this.f3361a.l(collection);
        }

        public T e(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3361a.z(i11);
        }

        @Override // java.util.List
        public T get(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3361a.q()[i11];
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.f3361a.s(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f3361a.t();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.f3361a.w(obj);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i11) {
            return new c(this, i11);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i11) {
            return e(i11);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.f3361a.x(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            return this.f3361a.y(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            return this.f3361a.B(collection);
        }

        @Override // java.util.List
        public T set(int i11, T t11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3361a.C(i11, t11);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List<T> subList(int i11, int i12) {
            androidx.compose.runtime.collection.c.d(this, i11, i12);
            return new C0048b(this, i11, i12);
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

    /* JADX INFO: renamed from: androidx.compose.runtime.collection.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class C0048b<T> implements List<T>, KMutableList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f3362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3364c;

        public C0048b(List<T> list, int i11, int i12) {
            this.f3362a = list;
            this.f3363b = i11;
            this.f3364c = i12;
        }

        public int a() {
            return this.f3364c - this.f3363b;
        }

        @Override // java.util.List
        public void add(int i11, T t11) {
            this.f3362a.add(i11 + this.f3363b, t11);
            this.f3364c++;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t11) {
            List<T> list = this.f3362a;
            int i11 = this.f3364c;
            this.f3364c = i11 + 1;
            list.add(i11, t11);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection<? extends T> collection) {
            this.f3362a.addAll(i11 + this.f3363b, collection);
            this.f3364c += collection.size();
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            this.f3362a.addAll(this.f3364c, collection);
            this.f3364c += collection.size();
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i11 = this.f3364c - 1;
            int i12 = this.f3363b;
            if (i12 <= i11) {
                while (true) {
                    this.f3362a.remove(i11);
                    if (i11 == i12) {
                        break;
                    } else {
                        i11--;
                    }
                }
            }
            this.f3364c = this.f3363b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i11 = this.f3364c;
            for (int i12 = this.f3363b; i12 < i11; i12++) {
                if (Intrinsics.b(this.f3362a.get(i12), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public T e(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            T tRemove = this.f3362a.remove(i11 + this.f3363b);
            this.f3364c--;
            return tRemove;
        }

        @Override // java.util.List
        public T get(int i11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3362a.get(i11 + this.f3363b);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i11 = this.f3364c;
            for (int i12 = this.f3363b; i12 < i11; i12++) {
                if (Intrinsics.b(this.f3362a.get(i12), obj)) {
                    return i12 - this.f3363b;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f3364c == this.f3363b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i11 = this.f3364c - 1;
            int i12 = this.f3363b;
            if (i12 > i11) {
                return -1;
            }
            while (!Intrinsics.b(this.f3362a.get(i11), obj)) {
                if (i11 == i12) {
                    return -1;
                }
                i11--;
            }
            return i11 - this.f3363b;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new c(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i11) {
            return new c(this, i11);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i11) {
            return e(i11);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i11 = this.f3364c;
            for (int i12 = this.f3363b; i12 < i11; i12++) {
                if (Intrinsics.b(this.f3362a.get(i12), obj)) {
                    this.f3362a.remove(i12);
                    this.f3364c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            int i11 = this.f3364c;
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i11 != this.f3364c;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            int i11 = this.f3364c;
            int i12 = i11 - 1;
            int i13 = this.f3363b;
            if (i13 <= i12) {
                while (true) {
                    if (!collection.contains(this.f3362a.get(i12))) {
                        this.f3362a.remove(i12);
                        this.f3364c--;
                    }
                    if (i12 == i13) {
                        break;
                    }
                    i12--;
                }
            }
            return i11 != this.f3364c;
        }

        @Override // java.util.List
        public T set(int i11, T t11) {
            androidx.compose.runtime.collection.c.c(this, i11);
            return this.f3362a.set(i11 + this.f3363b, t11);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List<T> subList(int i11, int i12) {
            androidx.compose.runtime.collection.c.d(this, i11, i12);
            return new C0048b(this, i11, i12);
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c<T> implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f3365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3366b;

        public c(List<T> list, int i11) {
            this.f3365a = list;
            this.f3366b = i11;
        }

        @Override // java.util.ListIterator
        public void add(T t11) {
            this.f3365a.add(this.f3366b, t11);
            this.f3366b++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f3366b < this.f3365a.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f3366b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.f3365a;
            int i11 = this.f3366b;
            this.f3366b = i11 + 1;
            return list.get(i11);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f3366b;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i11 = this.f3366b - 1;
            this.f3366b = i11;
            return this.f3365a.get(i11);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f3366b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i11 = this.f3366b - 1;
            this.f3366b = i11;
            this.f3365a.remove(i11);
        }

        @Override // java.util.ListIterator
        public void set(T t11) {
            this.f3365a.set(this.f3366b, t11);
        }
    }

    @PublishedApi
    public b(T[] tArr, int i11) {
        this.f3358a = tArr;
        this.f3360c = i11;
    }

    public final void A(int i11, int i12) {
        if (i12 > i11) {
            int i13 = this.f3360c;
            if (i12 < i13) {
                T[] tArr = this.f3358a;
                ArraysKt___ArraysJvmKt.l(tArr, tArr, i11, i12, i13);
            }
            int i14 = this.f3360c - (i12 - i11);
            int iR = r() - 1;
            if (i14 <= iR) {
                int i15 = i14;
                while (true) {
                    this.f3358a[i15] = null;
                    if (i15 == iR) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            this.f3360c = i14;
        }
    }

    public final boolean B(Collection<? extends T> collection) {
        int i11 = this.f3360c;
        for (int iR = r() - 1; -1 < iR; iR--) {
            if (!collection.contains(q()[iR])) {
                z(iR);
            }
        }
        return i11 != this.f3360c;
    }

    public final T C(int i11, T t11) {
        T[] tArr = this.f3358a;
        T t12 = tArr[i11];
        tArr[i11] = t11;
        return t12;
    }

    @PublishedApi
    public final void D(int i11) {
        this.f3360c = i11;
    }

    public final void E(Comparator<T> comparator) {
        ArraysKt___ArraysJvmKt.D(this.f3358a, comparator, 0, this.f3360c);
    }

    public final void a(int i11, T t11) {
        o(this.f3360c + 1);
        T[] tArr = this.f3358a;
        int i12 = this.f3360c;
        if (i11 != i12) {
            ArraysKt___ArraysJvmKt.l(tArr, tArr, i11 + 1, i11, i12);
        }
        tArr[i11] = t11;
        this.f3360c++;
    }

    public final boolean b(T t11) {
        o(this.f3360c + 1);
        T[] tArr = this.f3358a;
        int i11 = this.f3360c;
        tArr[i11] = t11;
        this.f3360c = i11 + 1;
        return true;
    }

    public final boolean d(int i11, b<T> bVar) {
        if (bVar.t()) {
            return false;
        }
        o(this.f3360c + bVar.f3360c);
        T[] tArr = this.f3358a;
        int i12 = this.f3360c;
        if (i11 != i12) {
            ArraysKt___ArraysJvmKt.l(tArr, tArr, bVar.f3360c + i11, i11, i12);
        }
        ArraysKt___ArraysJvmKt.l(bVar.f3358a, tArr, i11, 0, bVar.f3360c);
        this.f3360c += bVar.f3360c;
        return true;
    }

    public final boolean e(int i11, Collection<? extends T> collection) {
        int i12 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        o(this.f3360c + collection.size());
        T[] tArr = this.f3358a;
        if (i11 != this.f3360c) {
            ArraysKt___ArraysJvmKt.l(tArr, tArr, collection.size() + i11, i11, this.f3360c);
        }
        for (T t11 : collection) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            tArr[i12 + i11] = t11;
            i12 = i13;
        }
        this.f3360c += collection.size();
        return true;
    }

    public final boolean f(int i11, List<? extends T> list) {
        if (list.isEmpty()) {
            return false;
        }
        o(this.f3360c + list.size());
        T[] tArr = this.f3358a;
        if (i11 != this.f3360c) {
            ArraysKt___ArraysJvmKt.l(tArr, tArr, list.size() + i11, i11, this.f3360c);
        }
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            tArr[i11 + i12] = list.get(i12);
        }
        this.f3360c += list.size();
        return true;
    }

    public final boolean g(Collection<? extends T> collection) {
        return e(this.f3360c, collection);
    }

    public final List<T> h() {
        List<T> list = this.f3359b;
        if (list != null) {
            return list;
        }
        a aVar = new a(this);
        this.f3359b = aVar;
        return aVar;
    }

    public final void i() {
        T[] tArr = this.f3358a;
        int iR = r();
        while (true) {
            iR--;
            if (-1 >= iR) {
                this.f3360c = 0;
                return;
            }
            tArr[iR] = null;
        }
    }

    public final boolean j(T t11) {
        int iR = r() - 1;
        if (iR >= 0) {
            for (int i11 = 0; !Intrinsics.b(q()[i11], t11); i11++) {
                if (i11 != iR) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean l(Collection<? extends T> collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!j(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void o(int i11) {
        T[] tArr = this.f3358a;
        if (tArr.length < i11) {
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, Math.max(i11, tArr.length * 2));
            Intrinsics.f(tArr2, "copyOf(this, newSize)");
            this.f3358a = tArr2;
        }
    }

    public final T p() {
        if (t()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return q()[0];
    }

    public final T[] q() {
        return this.f3358a;
    }

    public final int r() {
        return this.f3360c;
    }

    public final int s(T t11) {
        int i11 = this.f3360c;
        if (i11 <= 0) {
            return -1;
        }
        T[] tArr = this.f3358a;
        int i12 = 0;
        while (!Intrinsics.b(t11, tArr[i12])) {
            i12++;
            if (i12 >= i11) {
                return -1;
            }
        }
        return i12;
    }

    public final boolean t() {
        return this.f3360c == 0;
    }

    public final boolean u() {
        return this.f3360c != 0;
    }

    public final T v() {
        if (t()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return q()[r() - 1];
    }

    public final int w(T t11) {
        int i11 = this.f3360c;
        if (i11 <= 0) {
            return -1;
        }
        int i12 = i11 - 1;
        T[] tArr = this.f3358a;
        while (!Intrinsics.b(t11, tArr[i12])) {
            i12--;
            if (i12 < 0) {
                return -1;
            }
        }
        return i12;
    }

    public final boolean x(T t11) {
        int iS = s(t11);
        if (iS < 0) {
            return false;
        }
        z(iS);
        return true;
    }

    public final boolean y(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int i11 = this.f3360c;
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            x(it.next());
        }
        return i11 != this.f3360c;
    }

    public final T z(int i11) {
        T[] tArr = this.f3358a;
        T t11 = tArr[i11];
        if (i11 != r() - 1) {
            ArraysKt___ArraysJvmKt.l(tArr, tArr, i11, i11 + 1, this.f3360c);
        }
        int i12 = this.f3360c - 1;
        this.f3360c = i12;
        tArr[i12] = null;
        return t11;
    }
}
