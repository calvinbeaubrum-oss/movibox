package com.transsion.json;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class f implements Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f52946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f52947b = new HashSet();

    public f(Set set) {
        this.f52946a = set;
    }

    public Set a() {
        return this.f52946a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.f52947b.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f52947b.addAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f52947b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f52947b.contains(obj) || this.f52946a.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f52947b.containsAll(collection) || this.f52946a.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f52947b.isEmpty() && this.f52946a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new e(this.f52947b, this.f52946a);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.f52947b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f52947b.removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f52947b.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.f52947b.size() + this.f52946a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        Object[] array = this.f52947b.toArray();
        Object[] array2 = this.f52946a.toArray();
        Object[] objArr = new Object[array.length + array2.length];
        System.arraycopy(array, 0, objArr, 0, array.length);
        System.arraycopy(array2, 0, objArr, array.length, array2.length);
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        throw new IllegalStateException("Not implemeneted");
    }
}
