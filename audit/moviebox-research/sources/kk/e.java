package kk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<E> f68633a;

    public e(List<E> list) {
        this.f68633a = Collections.unmodifiableList(list);
    }

    @NonNull
    public static <E> e<E> a(@NonNull List<E> list) {
        return new e<>(list);
    }

    @NonNull
    public static <E> e<E> b(E... eArr) {
        return new e<>(Arrays.asList(eArr));
    }

    @Override // java.util.List
    public void add(int i11, @NonNull E e11) {
        this.f68633a.add(i11, e11);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(@NonNull E e11) {
        return this.f68633a.add(e11);
    }

    @Override // java.util.List
    public boolean addAll(int i11, @NonNull Collection<? extends E> collection) {
        return this.f68633a.addAll(i11, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        return this.f68633a.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f68633a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.f68633a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f68633a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        return this.f68633a.equals(obj);
    }

    @Override // java.util.List
    @NonNull
    public E get(int i11) {
        return this.f68633a.get(i11);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f68633a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.f68633a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f68633a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.f68633a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.f68633a.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        return this.f68633a.listIterator();
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i11) {
        return this.f68633a.listIterator(i11);
    }

    @Override // java.util.List
    public E remove(int i11) {
        return this.f68633a.remove(i11);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.f68633a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f68633a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f68633a.retainAll(collection);
    }

    @Override // java.util.List
    @NonNull
    public E set(int i11, @NonNull E e11) {
        return this.f68633a.set(i11, e11);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f68633a.size();
    }

    @Override // java.util.List
    @NonNull
    public List<E> subList(int i11, int i12) {
        return this.f68633a.subList(i11, i12);
    }

    @Override // java.util.List, java.util.Collection
    @Nullable
    public Object[] toArray() {
        return this.f68633a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(@Nullable T[] tArr) {
        return (T[]) this.f68633a.toArray(tArr);
    }
}
