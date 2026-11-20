package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u4 implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f23514a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f23515b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f23516c = Collections.emptySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f23517d = Collections.emptyList();

    public Set a() {
        Set set;
        synchronized (this.f23514a) {
            set = this.f23516c;
        }
        return set;
    }

    public void a(Object obj) {
        synchronized (this.f23514a) {
            try {
                ArrayList arrayList = new ArrayList(this.f23517d);
                arrayList.add(obj);
                this.f23517d = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.f23515b.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f23516c);
                    hashSet.add(obj);
                    this.f23516c = Collections.unmodifiableSet(hashSet);
                }
                this.f23515b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int b(Object obj) {
        int iIntValue;
        synchronized (this.f23514a) {
            try {
                iIntValue = this.f23515b.containsKey(obj) ? ((Integer) this.f23515b.get(obj)).intValue() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iIntValue;
    }

    public void c(Object obj) {
        synchronized (this.f23514a) {
            try {
                Integer num = (Integer) this.f23515b.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f23517d);
                arrayList.remove(obj);
                this.f23517d = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f23515b.remove(obj);
                    HashSet hashSet = new HashSet(this.f23516c);
                    hashSet.remove(obj);
                    this.f23516c = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f23515b.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Iterator it;
        synchronized (this.f23514a) {
            it = this.f23517d.iterator();
        }
        return it;
    }
}
