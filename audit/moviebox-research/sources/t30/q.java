package t30;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class q<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, q<K, V>.a<K, V>> f76845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<q<K, V>.a<K, V>> f76846b;

    /* JADX INFO: compiled from: source.java */
    public class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f76847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public K f76848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public V f76849c;

        public a(int i11, K k11, V v11) {
            this.f76847a = i11;
            this.f76848b = k11;
            this.f76849c = v11;
        }

        public int a() {
            return this.f76847a;
        }

        public K b() {
            return this.f76848b;
        }

        public V c() {
            return this.f76849c;
        }

        public void d(V v11) {
            this.f76849c = v11;
        }
    }

    public q() {
        this.f76845a = new HashMap();
        this.f76846b = new ArrayList<>();
    }

    public q(q<K, V> qVar, boolean z11) {
        this.f76846b = new ArrayList<>(qVar.f76846b.size());
        this.f76845a = new HashMap();
        int i11 = 0;
        if (z11) {
            for (q<K, V>.a<K, V> aVar : qVar.f76846b) {
                q<K, V>.a<K, V> aVar2 = new a<>(i11, aVar.b(), null);
                this.f76846b.add(aVar2);
                this.f76845a.put(aVar.b(), aVar2);
                i11++;
            }
            return;
        }
        for (q<K, V>.a<K, V> aVar3 : qVar.f76846b) {
            q<K, V>.a<K, V> aVar4 = new a<>(i11, aVar3.b(), aVar3.c());
            this.f76846b.add(aVar4);
            this.f76845a.put(aVar3.b(), aVar4);
            i11++;
        }
    }

    public V a(int i11) {
        return this.f76846b.get(i11).c();
    }

    public int c(K k11) {
        return this.f76845a.get(k11).a();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("cannot clear map");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f76845a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f76845a.containsValue(obj);
    }

    public void d(int i11, V v11) {
        this.f76846b.get(i11).d(v11);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return this.f76845a.get(obj).c();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f76845a.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.f76845a.keySet();
    }

    @Override // java.util.Map
    public V put(K k11, V v11) {
        q<K, V>.a<K, V> aVar = this.f76845a.get(k11);
        if (aVar == null) {
            throw new RuntimeException("cannot add a new entry.  you must allocate a new key with addKey() first.");
        }
        this.f76846b.add(aVar);
        return this.f76845a.put(k11, aVar).c();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("cannot remove keys");
    }

    @Override // java.util.Map
    public int size() {
        return this.f76845a.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }
}
