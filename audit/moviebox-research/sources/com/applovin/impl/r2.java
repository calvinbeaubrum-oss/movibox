package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class r2 extends wg implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Function f22026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final wg f22027b;

    public r2(Function function, wg wgVar) {
        this.f22026a = (Function) Preconditions.checkNotNull(function);
        this.f22027b = (wg) Preconditions.checkNotNull(wgVar);
    }

    @Override // com.applovin.impl.wg, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f22027b.compare(this.f22026a.apply(obj), this.f22026a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r2)) {
            return false;
        }
        r2 r2Var = (r2) obj;
        return this.f22026a.equals(r2Var.f22026a) && this.f22027b.equals(r2Var.f22027b);
    }

    public int hashCode() {
        return Objects.hashCode(this.f22026a, this.f22027b);
    }

    public String toString() {
        return this.f22027b + ".onResultOf(" + this.f22026a + ")";
    }
}
