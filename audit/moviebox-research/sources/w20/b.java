package w20;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f79203c = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f79204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Iterator f79205b;

    public b(Object obj, Iterator it) {
        if (obj == null) {
            throw new IllegalArgumentException("parent object is null");
        }
        if (it == null) {
            throw new IllegalArgumentException("cannot wrap null iterator");
        }
        this.f79204a = obj;
        if (it.hasNext()) {
            this.f79205b = it;
            a(this);
        }
    }

    public static synchronized void a(b bVar) {
        try {
            WeakHashMap weakHashMap = f79203c;
            Set hashSet = (Set) weakHashMap.get(bVar.f79204a);
            if (hashSet == null) {
                hashSet = new HashSet();
                weakHashMap.put(bVar.f79204a, hashSet);
            }
            hashSet.add(bVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void b(b bVar) {
        if (!((Set) f79203c.get(bVar.f79204a)).contains(bVar)) {
            throw new ConcurrentModificationException();
        }
    }

    public static synchronized void c(Object obj) {
        Set set = (Set) f79203c.get(obj);
        if (set != null) {
            set.clear();
        }
    }

    public static synchronized void d(b bVar) {
        Set set = (Set) f79203c.get(bVar.f79204a);
        if (set != null) {
            set.remove(bVar);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f79205b == null) {
            return false;
        }
        b(this);
        return this.f79205b.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        Iterator it = this.f79205b;
        if (it == null || !it.hasNext()) {
            throw new NoSuchElementException();
        }
        b(this);
        try {
            return this.f79205b.next();
        } finally {
            if (!this.f79205b.hasNext()) {
                this.f79205b = null;
                d(this);
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
