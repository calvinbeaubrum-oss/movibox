package i1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<K, V> f66866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c<K, V> f66867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f66868c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f66869d = 0;

    /* JADX INFO: compiled from: source.java */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // i1.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f66873d;
        }

        @Override // i1.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f66872c;
        }
    }

    /* JADX INFO: renamed from: i1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0704b<K, V> extends e<K, V> {
        public C0704b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // i1.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f66872c;
        }

        @Override // i1.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f66873d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final K f66870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final V f66871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c<K, V> f66872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c<K, V> f66873d;

        public c(@NonNull K k11, @NonNull V v11) {
            this.f66870a = k11;
            this.f66871b = v11;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f66870a.equals(cVar.f66870a) && this.f66871b.equals(cVar.f66871b);
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.f66870a;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.f66871b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f66870a.hashCode() ^ this.f66871b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v11) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f66870a + "=" + this.f66871b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f66874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f66875b = true;

        public d() {
        }

        @Override // i1.b.f
        public void a(@NonNull c<K, V> cVar) {
            c<K, V> cVar2 = this.f66874a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f66873d;
                this.f66874a = cVar3;
                this.f66875b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f66875b) {
                this.f66875b = false;
                this.f66874a = b.this.f66866a;
            } else {
                c<K, V> cVar = this.f66874a;
                this.f66874a = cVar != null ? cVar.f66872c : null;
            }
            return this.f66874a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f66875b) {
                return b.this.f66866a != null;
            }
            c<K, V> cVar = this.f66874a;
            return (cVar == null || cVar.f66872c == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<K, V> f66877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<K, V> f66878b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f66877a = cVar2;
            this.f66878b = cVar;
        }

        @Override // i1.b.f
        public void a(@NonNull c<K, V> cVar) {
            if (this.f66877a == cVar && cVar == this.f66878b) {
                this.f66878b = null;
                this.f66877a = null;
            }
            c<K, V> cVar2 = this.f66877a;
            if (cVar2 == cVar) {
                this.f66877a = b(cVar2);
            }
            if (this.f66878b == cVar) {
                this.f66878b = f();
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f66878b;
            this.f66878b = f();
            return cVar;
        }

        public final c<K, V> f() {
            c<K, V> cVar = this.f66878b;
            c<K, V> cVar2 = this.f66877a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f66878b != null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class f<K, V> {
        public abstract void a(@NonNull c<K, V> cVar);
    }

    @Nullable
    public Map.Entry<K, V> a() {
        return this.f66866a;
    }

    @Nullable
    public c<K, V> b(K k11) {
        c<K, V> cVar = this.f66866a;
        while (cVar != null && !cVar.f66870a.equals(k11)) {
            cVar = cVar.f66872c;
        }
        return cVar;
    }

    @NonNull
    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0704b c0704b = new C0704b(this.f66867b, this.f66866a);
        this.f66868c.put(c0704b, Boolean.FALSE);
        return c0704b;
    }

    @NonNull
    public b<K, V>.d e() {
        b<K, V>.d dVar = new d();
        this.f66868c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Nullable
    public Map.Entry<K, V> f() {
        return this.f66867b;
    }

    public c<K, V> g(@NonNull K k11, @NonNull V v11) {
        c<K, V> cVar = new c<>(k11, v11);
        this.f66869d++;
        c<K, V> cVar2 = this.f66867b;
        if (cVar2 == null) {
            this.f66866a = cVar;
            this.f66867b = cVar;
            return cVar;
        }
        cVar2.f66872c = cVar;
        cVar.f66873d = cVar2;
        this.f66867b = cVar;
        return cVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    public V i(@NonNull K k11, @NonNull V v11) {
        c<K, V> cVarB = b(k11);
        if (cVarB != null) {
            return cVarB.f66871b;
        }
        g(k11, v11);
        return null;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f66866a, this.f66867b);
        this.f66868c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V j(@NonNull K k11) {
        c<K, V> cVarB = b(k11);
        if (cVarB == null) {
            return null;
        }
        this.f66869d--;
        if (!this.f66868c.isEmpty()) {
            Iterator<f<K, V>> it = this.f66868c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarB);
            }
        }
        c<K, V> cVar = cVarB.f66873d;
        if (cVar != null) {
            cVar.f66872c = cVarB.f66872c;
        } else {
            this.f66866a = cVarB.f66872c;
        }
        c<K, V> cVar2 = cVarB.f66872c;
        if (cVar2 != null) {
            cVar2.f66873d = cVar;
        } else {
            this.f66867b = cVar;
        }
        cVarB.f66872c = null;
        cVarB.f66873d = null;
        return cVarB.f66871b;
    }

    public int size() {
        return this.f66869d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
