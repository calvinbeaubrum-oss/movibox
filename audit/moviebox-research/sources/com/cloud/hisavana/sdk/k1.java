package com.cloud.hisavana.sdk;

import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class k1<K, V> extends m1<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public n1<K, V> f29845i;

    /* JADX INFO: compiled from: source.java */
    public class a extends n1<K, V> {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.n1
        public int a(Object obj) {
            return k1.this.c(obj);
        }

        @Override // com.cloud.hisavana.sdk.n1
        public Object b(int i11, int i12) {
            return k1.this.f29861b[(i11 << 1) + i12];
        }

        @Override // com.cloud.hisavana.sdk.n1
        public V c(int i11, V v11) {
            return k1.this.f(i11, v11);
        }

        @Override // com.cloud.hisavana.sdk.n1
        public void d() {
            k1.this.clear();
        }

        @Override // com.cloud.hisavana.sdk.n1
        public void e(int i11) {
            k1.this.l(i11);
        }

        @Override // com.cloud.hisavana.sdk.n1
        public void f(K k11, V v11) {
            k1.this.put(k11, v11);
        }

        @Override // com.cloud.hisavana.sdk.n1
        public int j(Object obj) {
            return k1.this.i(obj);
        }

        @Override // com.cloud.hisavana.sdk.n1
        public Map<K, V> k() {
            return k1.this;
        }

        @Override // com.cloud.hisavana.sdk.n1
        public int n() {
            return k1.this.f29862c;
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return n().p();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return n().q();
    }

    public final n1<K, V> n() {
        if (this.f29845i == null) {
            this.f29845i = new a();
        }
        return this.f29845i;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        j(this.f29862c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return n().r();
    }
}
