package gc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c<E> extends b<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<E> f65477c;

    public c(E e11) {
        ArrayList arrayList = new ArrayList();
        this.f65477c = arrayList;
        arrayList.add(e11);
        this.f65475a = this.f65477c;
    }

    public c(List<E> list) {
        super(list);
        this.f65477c = list;
    }

    public List<E> a() {
        return new ArrayList(this.f65477c);
    }

    public E get(int i11) {
        List<E> list = this.f65477c;
        if (list != null) {
            return list.get(i11);
        }
        return null;
    }

    @Override // gc.b, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // gc.b
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public String toString() {
        return this.f65477c.toString();
    }
}
