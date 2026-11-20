package gc;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b<E> implements Iterable<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Iterator f65474b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection<E> f65475a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Iterator {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("removing is unsupported");
        }
    }

    /* JADX INFO: renamed from: gc.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0687b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator f65476a;

        public C0687b(Iterator it) {
            this.f65476a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator it = this.f65476a;
            return it != null && it.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            Iterator it = this.f65476a;
            if (it != null) {
                return it.next();
            }
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("removing is unsupported");
        }
    }

    public b() {
    }

    public b(Collection<E> collection) {
        this.f65475a = collection;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Collection<E> collection = this.f65475a;
        return collection == null ? f65474b : new C0687b(collection.iterator());
    }

    public int size() {
        Collection<E> collection = this.f65475a;
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }
}
