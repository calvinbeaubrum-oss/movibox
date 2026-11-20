package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final d<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(d<F, ? extends T> dVar, Equivalence<T> equivalence) {
        this.function = (d) l.n(dVar);
        this.resultEquivalence = (Equivalence) l.n(equivalence);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence
    public boolean doEquivalent(F f11, F f12) {
        return this.resultEquivalence.equivalent(this.function.apply(f11), this.function.apply(f12));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence
    public int doHash(F f11) {
        return this.resultEquivalence.hash(this.function.apply(f11));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
    }

    public int hashCode() {
        return g.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
