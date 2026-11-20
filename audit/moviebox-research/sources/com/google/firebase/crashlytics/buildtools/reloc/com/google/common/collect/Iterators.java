package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Iterators {

    /* JADX INFO: compiled from: source.java */
    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class MergingIterator<T> extends t7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<q6<T>> f39401a;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.f39401a = new PriorityQueue(2, new Comparator<q6<T>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterators.MergingIterator.1
                @Override // java.util.Comparator
                public int compare(q6<T> q6Var, q6<T> q6Var2) {
                    return comparator.compare(q6Var.peek(), q6Var2.peek());
                }
            });
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f39401a.add(Iterators.r(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f39401a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            q6<T> q6VarRemove = this.f39401a.remove();
            T next = q6VarRemove.next();
            if (q6VarRemove.hasNext()) {
                this.f39401a.add(q6VarRemove);
            }
            return next;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class a<T> extends t7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f39402a;

        public a(Iterator it) {
            this.f39402a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39402a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f39402a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class b<T> extends AbstractIterator<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f39403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n f39404d;

        public b(Iterator it, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n nVar) {
            this.f39403c = it;
            this.f39404d = nVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
        public T a() {
            while (this.f39403c.hasNext()) {
                T t11 = (T) this.f39403c.next();
                if (this.f39404d.apply(t11)) {
                    return t11;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* JADX INFO: compiled from: source.java */
    public static class c<F, T> extends r7<F, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d f39405b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d dVar) {
            super(it);
            this.f39405b = dVar;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
        public T a(F f11) {
            return (T) this.f39405b.apply(f11);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public static class d<T> extends t7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f39406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f39407b;

        public d(Object obj) {
            this.f39407b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f39406a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f39406a) {
                throw new NoSuchElementException();
            }
            this.f39406a = true;
            return (T) this.f39407b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e<T> extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final u7<Object> f39408f = new e(new Object[0], 0, 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T[] f39409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f39410d;

        public e(T[] tArr, int i11, int i12, int i13) {
            super(i12, i13);
            this.f39409c = tArr;
            this.f39410d = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c
        public T a(int i11) {
            return this.f39409c[this.f39410d + i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<? extends T> f39411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<? extends T> f39412b = Iterators.h();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<? extends Iterator<? extends T>> f39413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Deque<Iterator<? extends Iterator<? extends T>>> f39414d;

        public f(Iterator<? extends Iterator<? extends T>> it) {
            this.f39413c = (Iterator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
        }

        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f39413c;
                if (it != null && it.hasNext()) {
                    return this.f39413c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f39414d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f39413c = this.f39414d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(this.f39412b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> itA = a();
                this.f39413c = itA;
                if (itA == null) {
                    return false;
                }
                Iterator<? extends T> next = itA.next();
                this.f39412b = next;
                if (next instanceof f) {
                    f fVar = (f) next;
                    this.f39412b = fVar.f39412b;
                    if (this.f39414d == null) {
                        this.f39414d = new ArrayDeque();
                    }
                    this.f39414d.addFirst(this.f39413c);
                    if (fVar.f39414d != null) {
                        while (!fVar.f39414d.isEmpty()) {
                            this.f39414d.addFirst(fVar.f39414d.removeLast());
                        }
                    }
                    this.f39413c = fVar.f39413c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it = this.f39412b;
            this.f39411a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            n1.e(this.f39411a != null);
            this.f39411a.remove();
            this.f39411a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g<E> implements q6<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends E> f39415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f39416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public E f39417c;

        public g(Iterator<? extends E> it) {
            this.f39415a = (Iterator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39416b || this.f39415a.hasNext();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q6, java.util.Iterator
        public E next() {
            if (!this.f39416b) {
                return this.f39415a.next();
            }
            E e11 = this.f39417c;
            this.f39416b = false;
            this.f39417c = null;
            return e11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q6
        public E peek() {
            if (!this.f39416b) {
                this.f39417c = this.f39415a.next();
                this.f39416b = true;
            }
            return this.f39417c;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.u(!this.f39416b, "Can't remove after you've peeked at next");
            this.f39415a.remove();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static int b(Iterator<?> it, int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
        int i12 = 0;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.e(i11 >= 0, "numberToAdvance must be nonnegative");
        while (i12 < i11 && it.hasNext()) {
            it.next();
            i12++;
        }
        return i12;
    }

    public static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static void d(Iterator<?> it) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new f(it);
    }

    public static boolean f(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> t7<T> h() {
        return i();
    }

    public static <T> u7<T> i() {
        return (u7<T>) e.f39408f;
    }

    public static <T> Iterator<T> j() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> t7<T> k(Iterator<T> it, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<? super T> nVar) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(nVar);
        return new b(it, nVar);
    }

    @SafeVarargs
    public static <T> t7<T> l(T... tArr) {
        return m(tArr, 0, tArr.length, 0);
    }

    public static <T> u7<T> m(T[] tArr, int i11, int i12, int i13) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(i12 >= 0);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i11 + i12, tArr.length);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i13, i12);
        return i12 == 0 ? i() : new e(tArr, i11, i12, i13);
    }

    public static <T> T n(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T o(Iterator<? extends T> it, T t11) {
        return it.hasNext() ? it.next() : t11;
    }

    public static <T> T p(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append(next);
        for (int i11 = 0; i11 < 4 && it.hasNext(); i11++) {
            sb2.append(", ");
            sb2.append(it.next());
        }
        if (it.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append('>');
        throw new IllegalArgumentException(sb2.toString());
    }

    public static <T> t7<T> q(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(iterable, "iterators");
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static <T> q6<T> r(Iterator<? extends T> it) {
        return it instanceof g ? (g) it : new g(it);
    }

    public static <T> T s(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static boolean t(Iterator<?> it, Collection<?> collection) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        boolean z11 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean u(Iterator<?> it, Collection<?> collection) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        boolean z11 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> t7<T> v(T t11) {
        return new d(t11);
    }

    public static int w(Iterator<?> it) {
        long j11 = 0;
        while (it.hasNext()) {
            it.next();
            j11++;
        }
        return Ints.i(j11);
    }

    public static String x(Iterator<?> it) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z11 = true;
        while (it.hasNext()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append(it.next());
            z11 = false;
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <F, T> Iterator<T> y(Iterator<F> it, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super F, ? extends T> dVar) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(dVar);
        return new c(it, dVar);
    }

    public static <T> t7<T> z(Iterator<? extends T> it) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(it);
        return it instanceof t7 ? (t7) it : new a(it);
    }
}
