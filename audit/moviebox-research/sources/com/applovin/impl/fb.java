package com.applovin.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class fb extends hb implements fc {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends hb.b {
        @Override // com.applovin.impl.hb.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Object obj, Iterable iterable) {
            super.a(obj, iterable);
            return this;
        }

        public a b(Object obj, Object... objArr) {
            super.a(obj, objArr);
            return this;
        }

        public fb c() {
            return (fb) super.a();
        }
    }

    public fb(gb gbVar, int i11) {
        super(gbVar, i11);
    }

    public static fb a(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return l();
        }
        gb.a aVar = new gb.a(collection.size());
        Iterator it = collection.iterator();
        int size = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            eb ebVarA = comparator == null ? eb.a(collection2) : eb.a(comparator, (Iterable) collection2);
            if (!ebVarA.isEmpty()) {
                aVar.a(key, ebVarA);
                size += ebVarA.size();
            }
        }
        return new fb(aVar.a(), size);
    }

    public static a k() {
        return new a();
    }

    public static fb l() {
        return r7.f22055g;
    }

    public eb b(Object obj) {
        eb ebVar = (eb) this.f19451d.get(obj);
        return ebVar == null ? eb.h() : ebVar;
    }
}
