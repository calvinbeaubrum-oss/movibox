package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c0 extends c<String> implements d0, RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f41216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f41217d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f41218b;

    static {
        c0 c0Var = new c0();
        f41216c = c0Var;
        c0Var.k();
        f41217d = c0Var;
    }

    public c0() {
        this(10);
    }

    public c0(int i11) {
        this((ArrayList<Object>) new ArrayList(i11));
    }

    public c0(ArrayList<Object> arrayList) {
        this.f41218b = arrayList;
    }

    public static String e(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof ByteString ? ((ByteString) obj).toStringUtf8() : y.j((byte[]) obj);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    public boolean addAll(int i11, Collection<? extends String> collection) {
        a();
        if (collection instanceof d0) {
            collection = ((d0) collection).l();
        }
        boolean zAddAll = this.f41218b.addAll(i11, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i11, String str) {
        a();
        this.f41218b.add(i11, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f41218b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.d0
    public void d(ByteString byteString) {
        a();
        this.f41218b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i11) {
        Object obj = this.f41218b.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f41218b.set(i11, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String strJ = y.j(bArr);
        if (y.g(bArr)) {
            this.f41218b.set(i11, strJ);
        }
        return strJ;
    }

    @Override // com.google.protobuf.y.j
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public c0 c2(int i11) {
        if (i11 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i11);
        arrayList.addAll(this.f41218b);
        return new c0((ArrayList<Object>) arrayList);
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public String remove(int i11) {
        a();
        Object objRemove = this.f41218b.remove(i11);
        ((AbstractList) this).modCount++;
        return e(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public String set(int i11, String str) {
        a();
        return e(this.f41218b.set(i11, str));
    }

    @Override // com.google.protobuf.d0
    public List<?> l() {
        return Collections.unmodifiableList(this.f41218b);
    }

    @Override // com.google.protobuf.c, com.google.protobuf.y.j
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // com.google.protobuf.d0
    public d0 q() {
        return m() ? new k1(this) : this;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41218b.size();
    }

    @Override // com.google.protobuf.d0
    public Object t(int i11) {
        return this.f41218b.get(i11);
    }
}
