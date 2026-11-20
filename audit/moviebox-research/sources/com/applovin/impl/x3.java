package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class x3 extends wg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparator f24215a;

    public x3(Comparator comparator) {
        this.f24215a = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.applovin.impl.wg, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f24215a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x3) {
            return this.f24215a.equals(((x3) obj).f24215a);
        }
        return false;
    }

    public int hashCode() {
        return this.f24215a.hashCode();
    }

    public String toString() {
        return this.f24215a.toString();
    }
}
