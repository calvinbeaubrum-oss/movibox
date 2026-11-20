package com.applovin.exoplayer2.common.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class d extends Optional {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f17242a;

    public d(Object obj) {
        this.f17242a = obj;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Set asSet() {
        return Collections.singleton(this.f17242a);
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f17242a.equals(((d) obj).f17242a);
        }
        return false;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object get() {
        return this.f17242a;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public int hashCode() {
        return this.f17242a.hashCode() + 1502476572;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Optional or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.f17242a;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object or(Object obj) {
        Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.f17242a;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object orNull() {
        return this.f17242a;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.f17242a + ")";
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Optional transform(Function function) {
        return new d(Preconditions.checkNotNull(function.apply(this.f17242a), "the Function passed to Optional.transform() must not return null."));
    }
}
