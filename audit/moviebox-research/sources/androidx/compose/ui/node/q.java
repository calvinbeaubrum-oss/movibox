package androidx.compose.ui.node;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class q implements List<androidx.compose.ui.f.c>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5115d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f5112a = new Object[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f5113b = new long[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5114c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5116f = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a implements ListIterator<androidx.compose.ui.f.c>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5119c;

        public a(int i11, int i12, int i13) {
            this.f5117a = i11;
            this.f5118b = i12;
            this.f5119c = i13;
        }

        public /* synthetic */ a(q qVar, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
            this((i14 & 1) != 0 ? 0 : i11, (i14 & 2) != 0 ? 0 : i12, (i14 & 4) != 0 ? qVar.size() : i13);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public androidx.compose.ui.f.c next() {
            Object[] objArr = q.this.f5112a;
            int i11 = this.f5117a;
            this.f5117a = i11 + 1;
            Object obj = objArr[i11];
            Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (androidx.compose.ui.f.c) obj;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(androidx.compose.ui.f.c cVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public androidx.compose.ui.f.c previous() {
            Object[] objArr = q.this.f5112a;
            int i11 = this.f5117a - 1;
            this.f5117a = i11;
            Object obj = objArr[i11];
            Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (androidx.compose.ui.f.c) obj;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f5117a < this.f5119c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f5117a > this.f5118b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f5117a - this.f5118b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.f5117a - this.f5118b) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(androidx.compose.ui.f.c cVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class b implements List<androidx.compose.ui.f.c>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5122b;

        public b(int i11, int i12) {
            this.f5121a = i11;
            this.f5122b = i12;
        }

        public boolean a(androidx.compose.ui.f.c cVar) {
            return indexOf(cVar) != -1;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i11, androidx.compose.ui.f.c cVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i11, Collection<? extends androidx.compose.ui.f.c> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends androidx.compose.ui.f.c> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof androidx.compose.ui.f.c) {
                return a((androidx.compose.ui.f.c) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains((androidx.compose.ui.f.c) it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.compose.ui.f.c get(int i11) {
            Object obj = q.this.f5112a[i11 + this.f5121a];
            Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (androidx.compose.ui.f.c) obj;
        }

        public int f() {
            return this.f5122b - this.f5121a;
        }

        public int g(androidx.compose.ui.f.c cVar) {
            int i11 = this.f5121a;
            int i12 = this.f5122b;
            if (i11 > i12) {
                return -1;
            }
            while (!Intrinsics.b(q.this.f5112a[i11], cVar)) {
                if (i11 == i12) {
                    return -1;
                }
                i11++;
            }
            return i11 - this.f5121a;
        }

        public int i(androidx.compose.ui.f.c cVar) {
            int i11 = this.f5122b;
            int i12 = this.f5121a;
            if (i12 > i11) {
                return -1;
            }
            while (!Intrinsics.b(q.this.f5112a[i11], cVar)) {
                if (i11 == i12) {
                    return -1;
                }
                i11--;
            }
            return i11 - this.f5121a;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof androidx.compose.ui.f.c) {
                return g((androidx.compose.ui.f.c) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<androidx.compose.ui.f.c> iterator() {
            q qVar = q.this;
            int i11 = this.f5121a;
            return qVar.new a(i11, i11, this.f5122b);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof androidx.compose.ui.f.c) {
                return i((androidx.compose.ui.f.c) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator<androidx.compose.ui.f.c> listIterator() {
            q qVar = q.this;
            int i11 = this.f5121a;
            return qVar.new a(i11, i11, this.f5122b);
        }

        @Override // java.util.List
        public ListIterator<androidx.compose.ui.f.c> listIterator(int i11) {
            q qVar = q.this;
            int i12 = this.f5121a;
            return qVar.new a(i11 + i12, i12, this.f5122b);
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ androidx.compose.ui.f.c remove(int i11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<androidx.compose.ui.f.c> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ androidx.compose.ui.f.c set(int i11, androidx.compose.ui.f.c cVar) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return f();
        }

        @Override // java.util.List
        public void sort(Comparator<? super androidx.compose.ui.f.c> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List<androidx.compose.ui.f.c> subList(int i11, int i12) {
            q qVar = q.this;
            int i13 = this.f5121a;
            return qVar.new b(i11 + i13, i13 + i12);
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

    public final boolean A(float f11, boolean z11) {
        if (this.f5114c == kotlin.collections.g.n(this)) {
            return true;
        }
        return l.a(r(), r.a(f11, z11)) > 0;
    }

    public int B(androidx.compose.ui.f.c cVar) {
        for (int iN = kotlin.collections.g.n(this); -1 < iN; iN--) {
            if (Intrinsics.b(this.f5112a[iN], cVar)) {
                return iN;
            }
        }
        return -1;
    }

    public final void C() {
        int i11 = this.f5114c + 1;
        int iN = kotlin.collections.g.n(this);
        if (i11 <= iN) {
            while (true) {
                this.f5112a[i11] = null;
                if (i11 == iN) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.f5115d = this.f5114c + 1;
    }

    public final void D(androidx.compose.ui.f.c cVar, float f11, boolean z11, Function0<Unit> function0) {
        if (this.f5114c == kotlin.collections.g.n(this)) {
            y(cVar, f11, z11, function0);
            if (this.f5114c + 1 == kotlin.collections.g.n(this)) {
                C();
                return;
            }
            return;
        }
        long jR = r();
        int i11 = this.f5114c;
        this.f5114c = kotlin.collections.g.n(this);
        y(cVar, f11, z11, function0);
        if (this.f5114c + 1 < kotlin.collections.g.n(this) && l.a(jR, r()) > 0) {
            int i12 = this.f5114c + 1;
            int i13 = i11 + 1;
            Object[] objArr = this.f5112a;
            ArraysKt___ArraysJvmKt.l(objArr, objArr, i13, i12, size());
            long[] jArr = this.f5113b;
            ArraysKt___ArraysJvmKt.k(jArr, jArr, i13, i12, size());
            this.f5114c = ((size() + i11) - this.f5114c) - 1;
        }
        C();
        this.f5114c = i11;
    }

    public final void a() {
        this.f5114c = size() - 1;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i11, androidx.compose.ui.f.c cVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i11, Collection<? extends androidx.compose.ui.f.c> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends androidx.compose.ui.f.c> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f5114c = -1;
        C();
        this.f5116f = true;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof androidx.compose.ui.f.c) {
            return i((androidx.compose.ui.f.c) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((androidx.compose.ui.f.c) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean i(androidx.compose.ui.f.c cVar) {
        return indexOf(cVar) != -1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof androidx.compose.ui.f.c) {
            return z((androidx.compose.ui.f.c) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<androidx.compose.ui.f.c> iterator() {
        return new a(this, 0, 0, 0, 7, null);
    }

    public final void j() {
        int i11 = this.f5114c;
        Object[] objArr = this.f5112a;
        if (i11 >= objArr.length) {
            int length = objArr.length + 16;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, length);
            Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f5112a = objArrCopyOf;
            long[] jArrCopyOf = Arrays.copyOf(this.f5113b, length);
            Intrinsics.f(jArrCopyOf, "copyOf(this, newSize)");
            this.f5113b = jArrCopyOf;
        }
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof androidx.compose.ui.f.c) {
            return B((androidx.compose.ui.f.c) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<androidx.compose.ui.f.c> listIterator() {
        return new a(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public ListIterator<androidx.compose.ui.f.c> listIterator(int i11) {
        return new a(this, i11, 0, 0, 6, null);
    }

    public final long r() {
        long jA = r.a(Float.POSITIVE_INFINITY, false);
        int i11 = this.f5114c + 1;
        int iN = kotlin.collections.g.n(this);
        if (i11 <= iN) {
            while (true) {
                long jB = l.b(this.f5113b[i11]);
                if (l.a(jB, jA) < 0) {
                    jA = jB;
                }
                if (l.c(jA) < 0.0f && l.d(jA)) {
                    return jA;
                }
                if (i11 != iN) {
                    i11++;
                }
            }
        }
        return jA;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ androidx.compose.ui.f.c remove(int i11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<androidx.compose.ui.f.c> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public androidx.compose.ui.f.c get(int i11) {
        Object obj = this.f5112a[i11];
        Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (androidx.compose.ui.f.c) obj;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ androidx.compose.ui.f.c set(int i11, androidx.compose.ui.f.c cVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return v();
    }

    @Override // java.util.List
    public void sort(Comparator<? super androidx.compose.ui.f.c> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<androidx.compose.ui.f.c> subList(int i11, int i12) {
        return new b(i11, i12);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.b(this, tArr);
    }

    public final boolean u() {
        return this.f5116f;
    }

    public int v() {
        return this.f5115d;
    }

    public final boolean w() {
        long jR = r();
        return l.c(jR) < 0.0f && l.d(jR);
    }

    public final void x(androidx.compose.ui.f.c cVar, boolean z11, Function0<Unit> function0) {
        y(cVar, -1.0f, z11, function0);
        NodeCoordinator nodeCoordinatorG1 = cVar.g1();
        if (nodeCoordinatorG1 == null || nodeCoordinatorG1.F2()) {
            return;
        }
        this.f5116f = false;
    }

    public final void y(androidx.compose.ui.f.c cVar, float f11, boolean z11, Function0<Unit> function0) {
        int i11 = this.f5114c;
        this.f5114c = i11 + 1;
        j();
        Object[] objArr = this.f5112a;
        int i12 = this.f5114c;
        objArr[i12] = cVar;
        this.f5113b[i12] = r.a(f11, z11);
        C();
        function0.invoke();
        this.f5114c = i11;
    }

    public int z(androidx.compose.ui.f.c cVar) {
        int iN = kotlin.collections.g.n(this);
        if (iN < 0) {
            return -1;
        }
        int i11 = 0;
        while (!Intrinsics.b(this.f5112a[i11], cVar)) {
            if (i11 == iN) {
                return -1;
            }
            i11++;
        }
        return i11;
    }
}
