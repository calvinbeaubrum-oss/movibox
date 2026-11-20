package z3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f81788a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<E, Integer> f81789b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<E> f81790c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<E> f81791d = Collections.emptyList();

    public void a(E e11) {
        synchronized (this.f81788a) {
            try {
                ArrayList arrayList = new ArrayList(this.f81791d);
                arrayList.add(e11);
                this.f81791d = Collections.unmodifiableList(arrayList);
                Integer num = this.f81789b.get(e11);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f81790c);
                    hashSet.add(e11);
                    this.f81790c = Collections.unmodifiableSet(hashSet);
                }
                this.f81789b.put(e11, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(E e11) {
        synchronized (this.f81788a) {
            try {
                Integer num = this.f81789b.get(e11);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f81791d);
                arrayList.remove(e11);
                this.f81791d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f81789b.remove(e11);
                    HashSet hashSet = new HashSet(this.f81790c);
                    hashSet.remove(e11);
                    this.f81790c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f81789b.put(e11, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int count(E e11) {
        int iIntValue;
        synchronized (this.f81788a) {
            try {
                iIntValue = this.f81789b.containsKey(e11) ? this.f81789b.get(e11).intValue() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iIntValue;
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f81788a) {
            set = this.f81790c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f81788a) {
            it = this.f81791d.iterator();
        }
        return it;
    }
}
