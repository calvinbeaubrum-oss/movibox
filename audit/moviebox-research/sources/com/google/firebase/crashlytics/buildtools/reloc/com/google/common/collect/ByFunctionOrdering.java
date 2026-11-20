package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<F, ? extends T> function;
    final Ordering<T> ordering;

    public ByFunctionOrdering(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<F, ? extends T> dVar, Ordering<T> ordering) {
        this.function = (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(dVar);
        this.ordering = (Ordering) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(ordering);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F f11, F f12) {
        return this.ordering.compare(this.function.apply(f11), this.function.apply(f12));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        return this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering);
    }

    public int hashCode() {
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.b(this.function, this.ordering);
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
