package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class StandardTable<R, C, V> extends z<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;
    private transient Set<C> columnKeySet;
    private transient StandardTable<R, C, V>.f columnMap;
    final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends Map<C, V>> factory;
    private transient Map<R, Map<C, V>> rowMap;

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<p7.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f39576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map.Entry<R, Map<C, V>> f39577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f39578c;

        public b() {
            this.f39576a = StandardTable.this.backingMap.entrySet().iterator();
            this.f39578c = Iterators.j();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p7.a<R, C, V> next() {
            if (!this.f39578c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f39576a.next();
                this.f39577b = next;
                this.f39578c = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.f39578c.next();
            return Tables.b(this.f39577b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f39576a.hasNext() || this.f39578c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f39578c.remove();
            if (this.f39577b.getValue().isEmpty()) {
                this.f39576a.remove();
                this.f39577b = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Maps.m<R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C f39580d;

        /* JADX INFO: compiled from: source.java */
        public class a extends Sets.a<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.e(Predicates.a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.containsMapping(entry.getKey(), c.this.f39580d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !StandardTable.this.containsColumn(cVar.f39580d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.removeMapping(entry.getKey(), c.this.f39580d, entry.getValue());
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Predicates.f(Predicates.d(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.f39580d)) {
                        i11++;
                    }
                }
                return i11;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f39583c;

            /* JADX INFO: compiled from: source.java */
            public class a extends q<R, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f39585a;

                public a(Map.Entry entry) {
                    this.f39585a = entry;
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f39585a.getKey();
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f39585a.getValue()).get(c.this.f39580d);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
                public V setValue(V v11) {
                    return (V) ((Map) this.f39585a.getValue()).put(c.this.f39580d, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11));
                }
            }

            public b() {
                this.f39583c = StandardTable.this.backingMap.entrySet().iterator();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<R, V> a() {
                while (this.f39583c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f39583c.next();
                    if (next.getValue().containsKey(c.this.f39580d)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0414c extends Maps.i<R, V> {
            public C0414c() {
                super(c.this);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return StandardTable.this.contains(obj, cVar.f39580d);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return StandardTable.this.remove(obj, cVar.f39580d) != null;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Maps.l(Predicates.f(Predicates.d(collection))));
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class d extends Maps.l<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.e(Maps.A(Predicates.c(obj)));
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.e(Maps.A(Predicates.d(collection)));
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Maps.A(Predicates.f(Predicates.d(collection))));
            }
        }

        public c(C c11) {
            this.f39580d = (C) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        public Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        /* JADX INFO: renamed from: c */
        public Set<R> h() {
            return new C0414c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.f39580d);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        public Collection<V> d() {
            return new d();
        }

        public boolean e(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.n<? super Map.Entry<R, V>> nVar) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v11 = value.get(this.f39580d);
                if (v11 != null && nVar.apply(Maps.g(next.getKey(), v11))) {
                    value.remove(this.f39580d);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z11 = true;
                }
            }
            return z11;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) StandardTable.this.get(obj, this.f39580d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r11, V v11) {
            return (V) StandardTable.this.put(r11, this.f39580d, v11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.f39580d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AbstractIterator<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<C, V> f39589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Iterator<Map<C, V>> f39590d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f39591f;

        public d() {
            this.f39589c = StandardTable.this.factory.get();
            this.f39590d = StandardTable.this.backingMap.values().iterator();
            this.f39591f = Iterators.h();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
        public C a() {
            while (true) {
                if (this.f39591f.hasNext()) {
                    Map.Entry<C, V> next = this.f39591f.next();
                    if (!this.f39589c.containsKey(next.getKey())) {
                        this.f39589c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.f39590d.hasNext()) {
                        return b();
                    }
                    this.f39591f = this.f39590d.next().entrySet().iterator();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends StandardTable<R, C, V>.i<C> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z11 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z11 = true;
                }
            }
            return z11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.t(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z11 = true;
                }
            }
            return z11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z11 = true;
                }
            }
            return z11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.w(iterator());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends Maps.m<C, Map<R, V>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0415a implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<C, Map<R, V>> {
                public C0415a() {
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<R, V> apply(C c11) {
                    return StandardTable.this.column(c11);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.containsColumn(entry.getKey())) {
                    return false;
                }
                return f.this.get(entry.getKey()).equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.a(StandardTable.this.columnKeySet(), new C0415a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
                return Sets.i(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
                boolean z11 = false;
                for (Object obj : Lists.j(StandardTable.this.columnKeySet().iterator())) {
                    if (!collection.contains(Maps.g(obj, StandardTable.this.column(obj)))) {
                        StandardTable.this.removeColumn(obj);
                        z11 = true;
                    }
                }
                return z11;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends Maps.l<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
                boolean z11 = false;
                for (Object obj : Lists.j(StandardTable.this.columnKeySet().iterator())) {
                    if (collection.contains(StandardTable.this.column(obj))) {
                        StandardTable.this.removeColumn(obj);
                        z11 = true;
                    }
                }
                return z11;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
                boolean z11 = false;
                for (Object obj : Lists.j(StandardTable.this.columnKeySet().iterator())) {
                    if (!collection.contains(StandardTable.this.column(obj))) {
                        StandardTable.this.removeColumn(obj);
                        z11 = true;
                    }
                }
                return z11;
            }
        }

        public f() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        public Collection<Map<R, V>> d() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.column(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends Maps.h<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f39598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<C, V> f39599b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<Map.Entry<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f39601a;

            public a(Iterator it) {
                this.f39601a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> next() {
                return g.this.e((Map.Entry) this.f39601a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f39601a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f39601a.remove();
                g.this.d();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends r2<C, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map.Entry f39603a;

            public b(Map.Entry entry) {
                this.f39603a = entry;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r2, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
            /* JADX INFO: renamed from: f */
            public Map.Entry<C, V> delegate() {
                return this.f39603a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r2, java.util.Map.Entry
            public V setValue(V v11) {
                return (V) super.setValue(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11));
            }
        }

        public g(R r11) {
            this.f39598a = (R) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
        }

        public Map<C, V> a() {
            Map<C, V> map = this.f39599b;
            if (map != null && (!map.isEmpty() || !StandardTable.this.backingMap.containsKey(this.f39598a))) {
                return this.f39599b;
            }
            Map<C, V> mapC = c();
            this.f39599b = mapC;
            return mapC;
        }

        public Map<C, V> c() {
            return StandardTable.this.backingMap.get(this.f39598a);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> mapA = a();
            if (mapA != null) {
                mapA.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> mapA = a();
            return (obj == null || mapA == null || !Maps.r(mapA, obj)) ? false : true;
        }

        public void d() {
            if (a() == null || !this.f39599b.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.f39598a);
            this.f39599b = null;
        }

        public Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            return new b(entry);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Iterator<Map.Entry<C, V>> entryIterator() {
            Map<C, V> mapA = a();
            return mapA == null ? Iterators.j() : new a(mapA.entrySet().iterator());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Spliterator<Map.Entry<C, V>> entrySpliterator() {
            Map<C, V> mapA = a();
            return mapA == null ? Spliterators.emptySpliterator() : x1.e(mapA.entrySet().spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l7
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f39729a.e((Map.Entry) obj);
                }
            });
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> mapA = a();
            if (obj == null || mapA == null) {
                return null;
            }
            return (V) Maps.s(mapA, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c11, V v11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
            Map<C, V> map = this.f39599b;
            return (map == null || map.isEmpty()) ? (V) StandardTable.this.put(this.f39598a, c11, v11) : this.f39599b.put(c11, v11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> mapA = a();
            if (mapA == null) {
                return null;
            }
            V v11 = (V) Maps.t(mapA, obj);
            d();
            return v11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> mapA = a();
            if (mapA == null) {
                return 0;
            }
            return mapA.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends Maps.m<R, Map<C, V>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0416a implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<R, Map<C, V>> {
                public C0416a() {
                }

                @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<C, V> apply(R r11) {
                    return StandardTable.this.row(r11);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && j2.d(StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.a(StandardTable.this.backingMap.keySet(), new C0416a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.m
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get(Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                return StandardTable.this.row(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class i<T> extends Sets.a<T> {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<? extends Map<C, V>> qVar) {
        this.backingMap = map;
        this.factory = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r11) {
        Map<C, V> map = this.backingMap.get(r11);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r11, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator lambda$cellSpliterator$1(final Map.Entry entry) {
        return x1.e(((Map) entry.getValue()).entrySet().spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.i7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return StandardTable.lambda$null$0(entry, (Map.Entry) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p7.a lambda$null$0(Map.Entry entry, Map.Entry entry2) {
        return Tables.b(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V vRemove = next.getValue().remove(obj);
            if (vRemove != null) {
                linkedHashMap.put(next.getKey(), vRemove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Iterator<p7.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Set<p7.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Spliterator<p7.a<R, C, V>> cellSpliterator() {
        return x1.b(this.backingMap.entrySet().spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.j7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return StandardTable.lambda$cellSpliterator$1((Map.Entry) obj);
            }
        }, 65, size());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public void clear() {
        this.backingMap.clear();
    }

    public Map<R, V> column(C c11) {
        return new c(c11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        StandardTable<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (Maps.r(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean containsRow(Object obj) {
        return obj != null && Maps.r(this.backingMap, obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public V put(R r11, C c11, V v11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
        return getOrCreate(r11).put(c11, v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.s(this.backingMap, obj)) == null) {
            return null;
        }
        V v11 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v11;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Map<C, V> row(R r11) {
        return new g(r11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> mapCreateRowMap = createRowMap();
        this.rowMap = mapCreateRowMap;
        return mapCreateRowMap;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public int size() {
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Collection<V> values() {
        return super.values();
    }
}
