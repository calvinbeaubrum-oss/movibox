package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f35580a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<E, Integer> f35581b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<E> f35582c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<E> f35583d = Collections.emptyList();

    public void a(E e11) {
        synchronized (this.f35580a) {
            try {
                ArrayList arrayList = new ArrayList(this.f35583d);
                arrayList.add(e11);
                this.f35583d = Collections.unmodifiableList(arrayList);
                Integer num = this.f35581b.get(e11);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f35582c);
                    hashSet.add(e11);
                    this.f35582c = Collections.unmodifiableSet(hashSet);
                }
                this.f35581b.put(e11, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(E e11) {
        synchronized (this.f35580a) {
            try {
                Integer num = this.f35581b.get(e11);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f35583d);
                arrayList.remove(e11);
                this.f35583d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f35581b.remove(e11);
                    HashSet hashSet = new HashSet(this.f35582c);
                    hashSet.remove(e11);
                    this.f35582c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f35581b.put(e11, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int count(E e11) {
        int iIntValue;
        synchronized (this.f35580a) {
            try {
                iIntValue = this.f35581b.containsKey(e11) ? this.f35581b.get(e11).intValue() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iIntValue;
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f35580a) {
            set = this.f35582c;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f35580a) {
            it = this.f35583d.iterator();
        }
        return it;
    }
}
