package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final f<? super F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(f<? super F, ? extends T> fVar, Equivalence<T> equivalence) {
        this.function = (f) m.p(fVar);
        this.resultEquivalence = (Equivalence) m.p(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F f11, F f12) {
        return this.resultEquivalence.equivalent(this.function.apply(f11), this.function.apply(f12));
    }

    @Override // com.google.common.base.Equivalence
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
        return j.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
