package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class vg implements Set, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f23904a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet f23905b = new HashSet();

    public Comparable a() {
        return (Comparable) this.f23904a.get(size() - 1);
    }

    public Comparable a(int i11) {
        return (Comparable) this.f23904a.get(i11);
    }

    public void a(int i11, Comparable comparable) {
        this.f23905b.remove((Comparable) this.f23904a.get(i11));
        this.f23904a.set(i11, comparable);
        this.f23905b.add(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(Comparable comparable) {
        if (contains(comparable)) {
            return false;
        }
        if (isEmpty() || comparable.compareTo(a()) > 0) {
            this.f23904a.add(comparable);
        } else {
            this.f23904a.add(b(comparable), comparable);
        }
        return this.f23905b.add(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z11 = false;
            while (it.hasNext()) {
                if (add((Comparable) it.next()) || z11) {
                    z11 = true;
                }
            }
            return z11;
        }
    }

    public int b(Comparable comparable) {
        int iBinarySearch = Collections.binarySearch(this.f23904a, comparable);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableA = a(iBinarySearch);
        while (iBinarySearch >= 0 && comparableA == a(iBinarySearch)) {
            iBinarySearch--;
        }
        return iBinarySearch + 1;
    }

    public Comparable b(int i11) {
        Comparable comparable = (Comparable) this.f23904a.remove(i11);
        this.f23905b.remove(comparable);
        return comparable;
    }

    public int c(Comparable comparable) {
        int iBinarySearch = Collections.binarySearch(this.f23904a, comparable);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableA = a(iBinarySearch);
        while (iBinarySearch < size() && comparableA == a(iBinarySearch)) {
            iBinarySearch++;
        }
        return iBinarySearch;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f23904a.clear();
        this.f23905b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f23905b.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f23905b.containsAll(collection);
    }

    public int d(Comparable comparable) {
        if (comparable == null || !contains(comparable)) {
            return -1;
        }
        return b(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f23904a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f23904a.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int iD = d((Comparable) obj);
        if (iD == -1) {
            return false;
        }
        this.f23904a.remove(iD);
        return this.f23905b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        while (true) {
            boolean z11 = false;
            for (Object obj : collection) {
                if (z11 || remove(obj)) {
                    z11 = true;
                }
            }
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean z11 = false;
        for (int size = size() - 1; size >= 0; size--) {
            Comparable comparable = (Comparable) this.f23904a.get(size);
            if (!collection.contains(comparable)) {
                this.f23904a.remove(size);
                this.f23905b.remove(comparable);
                z11 = true;
            }
        }
        return z11;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.f23904a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.f23904a.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f23904a.toArray(objArr);
    }
}
