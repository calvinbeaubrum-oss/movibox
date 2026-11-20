package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k1 extends AbstractList<String> implements d0, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f41348a;

    /* JADX INFO: compiled from: source.java */
    public class a implements ListIterator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ListIterator<String> f41349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f41350b;

        public a(int i11) {
            this.f41350b = i11;
            this.f41349a = k1.this.f41348a.listIterator(i11);
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f41349a.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f41349a.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f41349a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f41349a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f41349a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f41349a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<String> f41352a;

        public b() {
            this.f41352a = k1.this.f41348a.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f41352a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41352a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public k1(d0 d0Var) {
        this.f41348a = d0Var;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get(int i11) {
        return (String) this.f41348a.get(i11);
    }

    @Override // com.google.protobuf.d0
    public void d(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // com.google.protobuf.d0
    public List<?> l() {
        return this.f41348a.l();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i11) {
        return new a(i11);
    }

    @Override // com.google.protobuf.d0
    public d0 q() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41348a.size();
    }

    @Override // com.google.protobuf.d0
    public Object t(int i11) {
        return this.f41348a.t(i11);
    }
}
