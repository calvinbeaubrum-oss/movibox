package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import com.google.android.gms.common.api.Api;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vc {

    /* JADX INFO: compiled from: source.java */
    public class a extends yo {
        public a(Iterator it) {
            super(it);
        }

        @Override // com.applovin.impl.yo
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: source.java */
    public static abstract class b implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f23820a = new a("KEY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f23821b = new C0203b("VALUE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f23822c = a();

        /* JADX INFO: compiled from: source.java */
        public final enum a extends b {
            public a(String str, int i11) {
                super(str, i11, null);
            }

            @Override // com.applovin.exoplayer2.common.base.Function
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.vc$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public final enum C0203b extends b {
            public C0203b(String str, int i11) {
                super(str, i11, null);
            }

            @Override // com.applovin.exoplayer2.common.base.Function
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        private b(String str, int i11) {
            super(str, i11);
        }

        public /* synthetic */ b(String str, int i11, uc ucVar) {
            this(str, i11);
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f23820a, f23821b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f23822c.clone();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c extends rj.b {
        public abstract Map a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // com.applovin.impl.rj.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return rj.a((Set) this, collection.iterator());
            }
        }

        @Override // com.applovin.impl.rj.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = rj.a(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        hashSetA.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends rj.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f23823a;

        public d(Map map) {
            this.f23823a = (Map) Preconditions.checkNotNull(map);
        }

        public Map a() {
            return this.f23823a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends AbstractCollection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f23824a;

        public e(Map map) {
            this.f23824a = (Map) Preconditions.checkNotNull(map);
        }

        public final Map a() {
            return this.f23824a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return vc.a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : a().entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = rj.a();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetA.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = rj.a();
                for (Map.Entry entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetA.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class f extends AbstractMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Set f23825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Collection f23826b;

        public abstract Set a();

        public Collection b() {
            return new e(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f23825a;
            if (set != null) {
                return set;
            }
            Set setA = a();
            this.f23825a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.f23826b;
            if (collection != null) {
                return collection;
            }
            Collection collectionB = b();
            this.f23826b = collectionB;
            return collectionB;
        }
    }

    public static int a(int i11) {
        if (i11 >= 3) {
            return i11 < 1073741824 ? (int) ((i11 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        p3.a(i11, "expectedSize");
        return i11 + 1;
    }

    public static Function a() {
        return b.f23820a;
    }

    public static String a(Map map) {
        StringBuilder sbA = q3.a(map.size());
        sbA.append('{');
        boolean z11 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z11) {
                sbA.append(", ");
            }
            sbA.append(entry.getKey());
            sbA.append('=');
            sbA.append(entry.getValue());
            z11 = false;
        }
        sbA.append('}');
        return sbA.toString();
    }

    public static Iterator a(Iterator it) {
        return new a(it);
    }

    public static Map.Entry a(Object obj, Object obj2) {
        return new db(obj, obj2);
    }

    public static boolean a(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static IdentityHashMap b() {
        return new IdentityHashMap();
    }

    public static boolean b(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static Function c() {
        return b.f23821b;
    }

    public static Object c(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static Object d(Map map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }
}
