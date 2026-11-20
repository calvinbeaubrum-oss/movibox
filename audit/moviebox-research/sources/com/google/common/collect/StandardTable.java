package com.google.common.collect;

import com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class StandardTable<R, C, V> extends com.google.common.collect.i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;
    private transient Set<C> columnKeySet;
    private transient StandardTable<R, C, V>.f columnMap;
    final com.google.common.base.q<? extends Map<C, V>> factory;
    private transient Map<R, Map<C, V>> rowMap;

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<b1.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f38587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map.Entry<R, Map<C, V>> f38588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f38589c;

        public b() {
            this.f38587a = StandardTable.this.backingMap.entrySet().iterator();
            this.f38589c = Iterators.k();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b1.a<R, C, V> next() {
            if (!this.f38589c.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f38587a.next();
                this.f38588b = next;
                this.f38589c = next.getValue().entrySet().iterator();
            }
            Objects.requireNonNull(this.f38588b);
            Map.Entry<C, V> next2 = this.f38589c.next();
            return Tables.b(this.f38588b.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38587a.hasNext() || this.f38589c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f38589c.remove();
            Map.Entry<R, Map<C, V>> entry = this.f38588b;
            Objects.requireNonNull(entry);
            if (entry.getValue().isEmpty()) {
                this.f38587a.remove();
                this.f38588b = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends Maps.q<R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C f38591d;

        /* JADX INFO: compiled from: source.java */
        public class a extends Sets.d<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.e(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.containsMapping(entry.getKey(), c.this.f38591d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !StandardTable.this.containsColumn(cVar.f38591d);
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
                return StandardTable.this.removeMapping(entry.getKey(), c.this.f38591d, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Predicates.i(Predicates.g(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.f38591d)) {
                        i11++;
                    }
                }
                return i11;
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends AbstractIterator<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f38594c;

            /* JADX INFO: compiled from: source.java */
            public class a extends com.google.common.collect.b<R, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f38596a;

                public a(Map.Entry entry) {
                    this.f38596a = entry;
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f38596a.getKey();
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f38596a.getValue()).get(c.this.f38591d);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V setValue(V v11) {
                    return (V) k0.a(((Map) this.f38596a.getValue()).put(c.this.f38591d, com.google.common.base.m.p(v11)));
                }
            }

            public b() {
                this.f38594c = StandardTable.this.backingMap.entrySet().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<R, V> a() {
                while (this.f38594c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f38594c.next();
                    if (next.getValue().containsKey(c.this.f38591d)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.StandardTable$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0396c extends Maps.l<R, V> {
            public C0396c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return StandardTable.this.contains(obj, cVar.f38591d);
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return StandardTable.this.remove(obj, cVar.f38591d) != null;
            }

            @Override // com.google.common.collect.Sets.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Maps.n(Predicates.i(Predicates.g(collection))));
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class d extends Maps.p<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.e(Maps.F(Predicates.f(obj)));
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.e(Maps.F(Predicates.g(collection)));
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.e(Maps.F(Predicates.i(Predicates.g(collection))));
            }
        }

        public c(C c11) {
            this.f38591d = (C) com.google.common.base.m.p(c11);
        }

        @Override // com.google.common.collect.Maps.q
        public Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.q
        /* JADX INFO: renamed from: c */
        public Set<R> h() {
            return new C0396c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.f38591d);
        }

        @Override // com.google.common.collect.Maps.q
        public Collection<V> d() {
            return new d();
        }

        public boolean e(com.google.common.base.n<? super Map.Entry<R, V>> nVar) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v11 = value.get(this.f38591d);
                if (v11 != null && nVar.apply(Maps.i(next.getKey(), v11))) {
                    value.remove(this.f38591d);
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
            return (V) StandardTable.this.get(obj, this.f38591d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r11, V v11) {
            return (V) StandardTable.this.put(r11, this.f38591d, v11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.f38591d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AbstractIterator<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<C, V> f38600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Iterator<Map<C, V>> f38601d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f38602f;

        public d() {
            this.f38600c = StandardTable.this.factory.get2();
            this.f38601d = StandardTable.this.backingMap.values().iterator();
            this.f38602f = Iterators.i();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            while (true) {
                if (this.f38602f.hasNext()) {
                    Map.Entry<C, V> next = this.f38602f.next();
                    if (!this.f38600c.containsKey(next.getKey())) {
                        this.f38600c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else {
                    if (!this.f38601d.hasNext()) {
                        return b();
                    }
                    this.f38602f = this.f38601d.next().entrySet().iterator();
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

        @Override // com.google.common.collect.Sets.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            com.google.common.base.m.p(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.v(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z11 = true;
                }
            }
            return z11;
        }

        @Override // com.google.common.collect.Sets.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.m.p(collection);
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
            return Iterators.z(iterator());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends Maps.q<C, Map<R, V>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.StandardTable$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0397a implements com.google.common.base.f<C, Map<R, V>> {
                public C0397a() {
                }

                @Override // com.google.common.base.f
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
                Map<R, V> map = f.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.c(StandardTable.this.columnKeySet(), new C0397a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.m.p(collection);
                return Sets.j(this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.m.p(collection);
                boolean z11 = false;
                for (Object obj : Lists.k(StandardTable.this.columnKeySet().iterator())) {
                    if (!collection.contains(Maps.i(obj, StandardTable.this.column(obj)))) {
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
        public class b extends Maps.p<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
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
            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.m.p(collection);
                boolean z11 = false;
                for (Object obj : Lists.k(StandardTable.this.columnKeySet().iterator())) {
                    if (collection.contains(StandardTable.this.column(obj))) {
                        StandardTable.this.removeColumn(obj);
                        z11 = true;
                    }
                }
                return z11;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.p, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.m.p(collection);
                boolean z11 = false;
                for (Object obj : Lists.k(StandardTable.this.columnKeySet().iterator())) {
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

        @Override // com.google.common.collect.Maps.q
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.Maps.q
        public Collection<Map<R, V>> d() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(Object obj) {
            if (!StandardTable.this.containsColumn(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.column(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.q, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends Maps.k<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f38609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<C, V> f38610b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Iterator<Map.Entry<C, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f38612a;

            public a(Iterator it) {
                this.f38612a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> next() {
                return g.this.f((Map.Entry) this.f38612a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f38612a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f38612a.remove();
                g.this.d();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends v<C, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map.Entry f38614a;

            public b(g gVar, Map.Entry entry) {
                this.f38614a = entry;
            }

            @Override // com.google.common.collect.v, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.v, java.util.Map.Entry
            public V setValue(V v11) {
                return (V) super.setValue(com.google.common.base.m.p(v11));
            }

            @Override // com.google.common.collect.x
            public Map.Entry<C, V> u() {
                return this.f38614a;
            }
        }

        public g(R r11) {
            this.f38609a = (R) com.google.common.base.m.p(r11);
        }

        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<C, V>> a() {
            e();
            Map<C, V> map = this.f38610b;
            return map == null ? Iterators.k() : new a(map.entrySet().iterator());
        }

        public Map<C, V> c() {
            return StandardTable.this.backingMap.get(this.f38609a);
        }

        @Override // com.google.common.collect.Maps.k, java.util.AbstractMap, java.util.Map
        public void clear() {
            e();
            Map<C, V> map = this.f38610b;
            if (map != null) {
                map.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> map;
            e();
            return (obj == null || (map = this.f38610b) == null || !Maps.u(map, obj)) ? false : true;
        }

        public void d() {
            e();
            Map<C, V> map = this.f38610b;
            if (map == null || !map.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.f38609a);
            this.f38610b = null;
        }

        public final void e() {
            Map<C, V> map = this.f38610b;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.f38609a))) {
                this.f38610b = c();
            }
        }

        public Map.Entry<C, V> f(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> map;
            e();
            if (obj == null || (map = this.f38610b) == null) {
                return null;
            }
            return (V) Maps.v(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c11, V v11) {
            com.google.common.base.m.p(c11);
            com.google.common.base.m.p(v11);
            Map<C, V> map = this.f38610b;
            return (map == null || map.isEmpty()) ? (V) StandardTable.this.put(this.f38609a, c11, v11) : this.f38610b.put(c11, v11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            e();
            Map<C, V> map = this.f38610b;
            if (map == null) {
                return null;
            }
            V v11 = (V) Maps.w(map, obj);
            d();
            return v11;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            e();
            Map<C, V> map = this.f38610b;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends Maps.q<R, Map<C, V>> {

        /* JADX INFO: compiled from: source.java */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: com.google.common.collect.StandardTable$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class C0398a implements com.google.common.base.f<R, Map<C, V>> {
                public C0398a() {
                }

                @Override // com.google.common.base.f
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
                return entry.getKey() != null && (entry.getValue() instanceof Map) && m.c(StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.c(StandardTable.this.backingMap.keySet(), new C0398a());
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

        @Override // com.google.common.collect.Maps.q
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
            if (!StandardTable.this.containsRow(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.row(obj);
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
    public abstract class i<T> extends Sets.d<T> {
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

    public StandardTable(Map<R, Map<C, V>> map, com.google.common.base.q<? extends Map<C, V>> qVar) {
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
        Map<C, V> map2 = this.factory.get2();
        this.backingMap.put(r11, map2);
        return map2;
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

    @Override // com.google.common.collect.i
    public Iterator<b1.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public Set<b1.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i
    public void clear() {
        this.backingMap.clear();
    }

    public Map<R, V> column(C c11) {
        return new c(c11);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.b1
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        StandardTable<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.i
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.i
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (Maps.u(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.i
    public boolean containsRow(Object obj) {
        return obj != null && Maps.u(this.backingMap, obj);
    }

    @Override // com.google.common.collect.i
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.common.collect.i
    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.i
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.i
    public V put(R r11, C c11, V v11) {
        com.google.common.base.m.p(r11);
        com.google.common.base.m.p(c11);
        com.google.common.base.m.p(v11);
        return getOrCreate(r11).put(c11, v11);
    }

    @Override // com.google.common.collect.i
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.v(this.backingMap, obj)) == null) {
            return null;
        }
        V v11 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v11;
    }

    @Override // com.google.common.collect.b1
    public Map<C, V> row(R r11) {
        return new g(r11);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.b1
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> mapCreateRowMap = createRowMap();
        this.rowMap = mapCreateRowMap;
        return mapCreateRowMap;
    }

    @Override // com.google.common.collect.b1
    public int size() {
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // com.google.common.collect.i
    public Collection<V> values() {
        return super.values();
    }
}
