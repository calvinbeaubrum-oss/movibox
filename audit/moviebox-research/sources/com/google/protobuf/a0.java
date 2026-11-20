package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a0 extends b0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n0 f41206f;

    /* JADX INFO: compiled from: source.java */
    public static class b<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map.Entry<K, a0> f41207a;

        public b(Map.Entry<K, a0> entry) {
            this.f41207a = entry;
        }

        public a0 a() {
            return this.f41207a.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f41207a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            a0 value = this.f41207a.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof n0) {
                return this.f41207a.getValue().d((n0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f41208a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f41208a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f41208a.next();
            return next.getValue() instanceof a0 ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41208a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f41208a.remove();
        }
    }

    @Override // com.google.protobuf.b0
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public n0 f() {
        return c(this.f41206f);
    }

    @Override // com.google.protobuf.b0
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
