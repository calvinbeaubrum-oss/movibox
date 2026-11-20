package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ag extends wg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ag f17656a = new ag();

    private ag() {
    }

    @Override // com.applovin.impl.wg, java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.applovin.impl.wg
    public wg c() {
        return xi.f24327a;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
