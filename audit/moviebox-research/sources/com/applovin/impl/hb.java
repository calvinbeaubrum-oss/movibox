package com.applovin.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class hb extends b2 implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient gb f19451d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient int f19452f;

    /* JADX INFO: compiled from: source.java */
    public class a extends pp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Iterator f19453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Iterator f19454b = xb.a();

        public a() {
            this.f19453a = hb.this.f19451d.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19454b.hasNext() || this.f19453a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f19454b.hasNext()) {
                this.f19454b = ((cb) this.f19453a.next()).iterator();
            }
            return this.f19454b.next();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map f19456a = mh.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator f19457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Comparator f19458c;

        public b a(Object obj, Iterable iterable) {
            if (obj == null) {
                throw new NullPointerException("null key in entry: null=" + wb.d(iterable));
            }
            Collection collection = (Collection) this.f19456a.get(obj);
            if (collection != null) {
                for (Object obj2 : iterable) {
                    p3.a(obj, obj2);
                    collection.add(obj2);
                }
                return this;
            }
            Iterator it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            Collection collectionB = b();
            while (it.hasNext()) {
                Object next = it.next();
                p3.a(obj, next);
                collectionB.add(next);
            }
            this.f19456a.put(obj, collectionB);
            return this;
        }

        public b a(Object obj, Object... objArr) {
            return a(obj, Arrays.asList(objArr));
        }

        public hb a() {
            Collection collectionEntrySet = this.f19456a.entrySet();
            Comparator comparator = this.f19457b;
            if (comparator != null) {
                collectionEntrySet = wg.a(comparator).b().a(collectionEntrySet);
            }
            return fb.a(collectionEntrySet, this.f19458c);
        }

        public Collection b() {
            return new ArrayList();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends cb {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final transient hb f19459b;

        public c(hb hbVar) {
            this.f19459b = hbVar;
        }

        @Override // com.applovin.impl.cb
        public int a(Object[] objArr, int i11) {
            pp it = this.f19459b.f19451d.values().iterator();
            while (it.hasNext()) {
                i11 = ((cb) it.next()).a(objArr, i11);
            }
            return i11;
        }

        @Override // com.applovin.impl.cb, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f19459b.a(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public pp iterator() {
            return this.f19459b.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f19459b.size();
        }
    }

    public hb(gb gbVar, int i11) {
        this.f19451d = gbVar;
        this.f19452f = i11;
    }

    @Override // com.applovin.impl.h
    public boolean a(Object obj) {
        return obj != null && super.a(obj);
    }

    @Override // com.applovin.impl.h
    public Map b() {
        throw new AssertionError("should never be called");
    }

    @Override // com.applovin.impl.h
    public Set c() {
        throw new AssertionError("unreachable");
    }

    @Override // com.applovin.impl.uf
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.h
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.applovin.impl.h, com.applovin.impl.uf
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public gb a() {
        return this.f19451d;
    }

    @Override // com.applovin.impl.h
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public cb d() {
        return new c(this);
    }

    @Override // com.applovin.impl.h
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.applovin.impl.h
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public pp f() {
        return new a();
    }

    @Override // com.applovin.impl.h, com.applovin.impl.uf
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public cb values() {
        return (cb) super.values();
    }

    @Override // com.applovin.impl.uf
    public boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.uf
    public int size() {
        return this.f19452f;
    }

    @Override // com.applovin.impl.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
