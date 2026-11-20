package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class yi extends wg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final wg f24675a;

    public yi(wg wgVar) {
        this.f24675a = (wg) Preconditions.checkNotNull(wgVar);
    }

    @Override // com.applovin.impl.wg
    public wg c() {
        return this.f24675a;
    }

    @Override // com.applovin.impl.wg, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f24675a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof yi) {
            return this.f24675a.equals(((yi) obj).f24675a);
        }
        return false;
    }

    public int hashCode() {
        return -this.f24675a.hashCode();
    }

    public String toString() {
        return this.f24675a + ".reverse()";
    }
}
