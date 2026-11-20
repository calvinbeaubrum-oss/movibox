package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class rj {

    /* JADX INFO: compiled from: source.java */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f22117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f22118b;

        /* JADX INFO: renamed from: com.applovin.impl.rj$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0198a extends d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator f22119c;

            public C0198a() {
                this.f22119c = a.this.f22117a.iterator();
            }

            @Override // com.applovin.impl.d
            public Object a() {
                while (this.f22119c.hasNext()) {
                    Object next = this.f22119c.next();
                    if (a.this.f22118b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f22117a = set;
            this.f22118b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f22117a.contains(obj) && this.f22118b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return this.f22117a.containsAll(collection) && this.f22118b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f22118b, this.f22117a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public pp iterator() {
            return new C0198a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator it = this.f22117a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (this.f22118b.contains(it.next())) {
                    i11++;
                }
            }
            return i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b extends AbstractSet {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return rj.a((Set) this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c extends AbstractSet {
        private c() {
        }

        public /* synthetic */ c(qj qjVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }
    }

    public static int a(Set set) {
        Iterator it = set.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i11 = ~(~(i11 + (next != null ? next.hashCode() : 0)));
        }
        return i11;
    }

    public static c a(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new a(set, set2);
    }

    public static HashSet a() {
        return new HashSet();
    }

    public static HashSet a(int i11) {
        return new HashSet(vc.a(i11));
    }

    public static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean a(Set set, Collection collection) {
        Preconditions.checkNotNull(collection);
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? a(set, collection.iterator()) : xb.a(set.iterator(), collection);
    }

    public static boolean a(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    public static Set b() {
        return Collections.newSetFromMap(vc.b());
    }
}
