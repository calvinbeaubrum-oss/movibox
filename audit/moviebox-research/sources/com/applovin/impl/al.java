package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class al implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f17733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f17734b;

    public al(List list, List list2) {
        this.f17733a = list;
        this.f17734b = list2;
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f17734b.size();
    }

    @Override // com.applovin.impl.nl
    public int a(long j11) {
        int iA = xp.a(this.f17734b, (Comparable) Long.valueOf(j11), false, false);
        if (iA < this.f17734b.size()) {
            return iA;
        }
        return -1;
    }

    @Override // com.applovin.impl.nl
    public long a(int i11) {
        b1.a(i11 >= 0);
        b1.a(i11 < this.f17734b.size());
        return ((Long) this.f17734b.get(i11)).longValue();
    }

    @Override // com.applovin.impl.nl
    public List b(long j11) {
        int iB = xp.b(this.f17734b, (Comparable) Long.valueOf(j11), true, false);
        return iB == -1 ? Collections.emptyList() : (List) this.f17733a.get(iB);
    }
}
