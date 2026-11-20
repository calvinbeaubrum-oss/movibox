package com.google.common.collect;

import com.google.common.primitives.Ints;
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
/* JADX INFO: loaded from: classes.dex */
public final class Iterators {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
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
            l.e(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class a<T> extends g1<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f38408a;

        public a(Iterator it) {
            this.f38408a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38408a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f38408a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class b<T> extends AbstractIterator<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f38409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.n f38410d;

        public b(Iterator it, com.google.common.base.n nVar) {
            this.f38409c = it;
            this.f38410d = nVar;
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
        @Override // com.google.common.collect.AbstractIterator
        public T a() {
            while (this.f38409c.hasNext()) {
                T t11 = (T) this.f38409c.next();
                if (this.f38410d.apply(t11)) {
                    return t11;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class c<F, T> extends d1<F, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.f f38411b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Iterator it, com.google.common.base.f fVar) {
            super(it);
            this.f38411b = fVar;
        }

        @Override // com.google.common.collect.d1
        public T a(F f11) {
            return (T) this.f38411b.apply(f11);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class d<T> extends g1<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f38412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f38413b;

        public d(Object obj) {
            this.f38413b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f38412a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f38412a) {
                throw new NoSuchElementException();
            }
            this.f38412a = true;
            return (T) this.f38413b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static final class e<T> extends com.google.common.collect.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h1<Object> f38414f = new e(new Object[0], 0, 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T[] f38415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f38416d;

        public e(T[] tArr, int i11, int i12, int i13) {
            super(i12, i13);
            this.f38415c = tArr;
            this.f38416d = i11;
        }

        @Override // com.google.common.collect.a
        public T a(int i11) {
            return this.f38415c[this.f38416d + i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class f<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<? extends T> f38417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<? extends T> f38418b = Iterators.i();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<? extends Iterator<? extends T>> f38419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Deque<Iterator<? extends Iterator<? extends T>>> f38420d;

        public f(Iterator<? extends Iterator<? extends T>> it) {
            this.f38419c = (Iterator) com.google.common.base.m.p(it);
        }

        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f38419c;
                if (it != null && it.hasNext()) {
                    return this.f38419c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f38420d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f38419c = this.f38420d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) com.google.common.base.m.p(this.f38418b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> itA = a();
                this.f38419c = itA;
                if (itA == null) {
                    return false;
                }
                Iterator<? extends T> next = itA.next();
                this.f38418b = next;
                if (next instanceof f) {
                    f fVar = (f) next;
                    this.f38418b = fVar.f38418b;
                    if (this.f38420d == null) {
                        this.f38420d = new ArrayDeque();
                    }
                    this.f38420d.addFirst(this.f38419c);
                    if (fVar.f38420d != null) {
                        while (!fVar.f38420d.isEmpty()) {
                            this.f38420d.addFirst(fVar.f38420d.removeLast());
                        }
                    }
                    this.f38419c = fVar.f38419c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it = this.f38418b;
            this.f38417a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.f38417a;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f38417a = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class g<T> extends g1<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<o0<T>> f38421a;

        public g(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.f38421a = new PriorityQueue(2, new Comparator() { // from class: com.google.common.collect.f0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Iterators.g.b(comparator, (o0) obj, (o0) obj2);
                }
            });
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f38421a.add(Iterators.t(it));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ int b(Comparator comparator, o0 o0Var, o0 o0Var2) {
            return comparator.compare(o0Var.peek(), o0Var2.peek());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f38421a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            o0<T> o0VarRemove = this.f38421a.remove();
            T next = o0VarRemove.next();
            if (o0VarRemove.hasNext()) {
                this.f38421a.add(o0VarRemove);
            }
            return next;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class h<E> implements o0<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends E> f38422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f38423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public E f38424c;

        public h(Iterator<? extends E> it) {
            this.f38422a = (Iterator) com.google.common.base.m.p(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38423b || this.f38422a.hasNext();
        }

        @Override // com.google.common.collect.o0, java.util.Iterator
        public E next() {
            if (!this.f38423b) {
                return this.f38422a.next();
            }
            E e11 = (E) k0.a(this.f38424c);
            this.f38423b = false;
            this.f38424c = null;
            return e11;
        }

        @Override // com.google.common.collect.o0
        public E peek() {
            if (!this.f38423b) {
                this.f38424c = this.f38422a.next();
                this.f38423b = true;
            }
            return (E) k0.a(this.f38424c);
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.w(!this.f38423b, "Can't remove after you've peeked at next");
            this.f38422a.remove();
        }
    }

    public static String A(Iterator<?> it) {
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

    public static <F, T> Iterator<T> B(Iterator<F> it, com.google.common.base.f<? super F, ? extends T> fVar) {
        com.google.common.base.m.p(fVar);
        return new c(it, fVar);
    }

    public static <T> g1<T> C(Iterator<? extends T> it) {
        com.google.common.base.m.p(it);
        return it instanceof g1 ? (g1) it : new a(it);
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.m.p(collection);
        com.google.common.base.m.p(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static int b(Iterator<?> it, int i11) {
        com.google.common.base.m.p(it);
        int i12 = 0;
        com.google.common.base.m.e(i11 >= 0, "numberToAdvance must be nonnegative");
        while (i12 < i11 && it.hasNext()) {
            it.next();
            i12++;
        }
        return i12;
    }

    public static <T> boolean c(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        return r(it, nVar) != -1;
    }

    public static <T> ListIterator<T> d(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static void e(Iterator<?> it) {
        com.google.common.base.m.p(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> f(Iterator<? extends Iterator<? extends T>> it) {
        return new f(it);
    }

    public static boolean g(Iterator<?> it, Object obj) {
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

    public static boolean h(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.j.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> g1<T> i() {
        return j();
    }

    public static <T> h1<T> j() {
        return (h1<T>) e.f38414f;
    }

    public static <T> Iterator<T> k() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> g1<T> l(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.p(it);
        com.google.common.base.m.p(nVar);
        return new b(it, nVar);
    }

    public static <T> T m(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.p(it);
        com.google.common.base.m.p(nVar);
        while (it.hasNext()) {
            T next = it.next();
            if (nVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public static <T> T n(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T o(Iterator<? extends T> it, T t11) {
        return it.hasNext() ? (T) n(it) : t11;
    }

    public static <T> T p(Iterator<? extends T> it, T t11) {
        return it.hasNext() ? it.next() : t11;
    }

    public static <T> T q(Iterator<T> it) {
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

    public static <T> int r(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.q(nVar, "predicate");
        int i11 = 0;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static <T> g1<T> s(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.common.base.m.q(iterable, "iterators");
        com.google.common.base.m.q(comparator, "comparator");
        return new g(iterable, comparator);
    }

    public static <T> o0<T> t(Iterator<? extends T> it) {
        return it instanceof h ? (h) it : new h(it);
    }

    public static <T> T u(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static boolean v(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.m.p(collection);
        boolean z11 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> boolean w(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.p(nVar);
        boolean z11 = false;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean x(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.m.p(collection);
        boolean z11 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> g1<T> y(T t11) {
        return new d(t11);
    }

    public static int z(Iterator<?> it) {
        long j11 = 0;
        while (it.hasNext()) {
            it.next();
            j11++;
        }
        return Ints.l(j11);
    }
}
