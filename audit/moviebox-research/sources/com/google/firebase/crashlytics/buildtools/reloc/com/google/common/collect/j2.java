package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j2 {
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder c(int i11) {
        n1.b(i11, "size");
        return new StringBuilder((int) Math.min(((long) i11) * 8, 1073741824L));
    }

    public static boolean d(Collection<?> collection, Object obj) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean e(Collection<?> collection, Object obj) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String f(Collection<?> collection) {
        StringBuilder sbC = c(collection.size());
        sbC.append('[');
        boolean z11 = true;
        for (Object obj : collection) {
            if (!z11) {
                sbC.append(", ");
            }
            if (obj == collection) {
                sbC.append("(this Collection)");
            } else {
                sbC.append(obj);
            }
            z11 = false;
        }
        sbC.append(']');
        return sbC.toString();
    }
}
