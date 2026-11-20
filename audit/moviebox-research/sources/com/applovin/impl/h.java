package com.applovin.impl;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class h implements uf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Set f19307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Collection f19308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Map f19309c;

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractCollection {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.a(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return h.this.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return h.this.size();
        }
    }

    @Override // com.applovin.impl.uf
    public Map a() {
        Map map = this.f19309c;
        if (map != null) {
            return map;
        }
        Map mapB = b();
        this.f19309c = mapB;
        return mapB;
    }

    public boolean a(Object obj) {
        Iterator it = a().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map b();

    public abstract Set c();

    public abstract Collection d();

    public Set e() {
        Set set = this.f19307a;
        if (set != null) {
            return set;
        }
        Set setC = c();
        this.f19307a = setC;
        return setC;
    }

    public boolean equals(Object obj) {
        return xf.a(this, obj);
    }

    public abstract Iterator f();

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }

    @Override // com.applovin.impl.uf
    public Collection values() {
        Collection collection = this.f19308b;
        if (collection != null) {
            return collection;
        }
        Collection collectionD = d();
        this.f19308b = collectionD;
        return collectionD;
    }
}
