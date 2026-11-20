package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class u6 {
    public static void a(v6 v6Var, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            v6Var.add((Range) it.next());
        }
    }

    public static boolean b(v6 v6Var, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!v6Var.encloses((Range) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static void c(v6 v6Var, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            v6Var.remove((Range) it.next());
        }
    }
}
