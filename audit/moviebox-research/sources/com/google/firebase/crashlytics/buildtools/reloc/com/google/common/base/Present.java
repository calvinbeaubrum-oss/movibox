package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public Present(T t11) {
        this.reference = t11;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        l.n(optional);
        return this;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public T or(q<? extends T> qVar) {
        l.n(qVar);
        return this.reference;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public T or(T t11) {
        l.o(t11, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional
    public <V> Optional<V> transform(d<? super T, V> dVar) {
        return new Present(l.o(dVar.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
    }
}
