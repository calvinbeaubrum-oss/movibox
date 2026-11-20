package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class rf implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f22101a;

    public rf(List list) {
        this.f22101a = Collections.unmodifiableList(list);
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return 1;
    }

    @Override // com.applovin.impl.nl
    public int a(long j11) {
        return j11 < 0 ? 0 : -1;
    }

    @Override // com.applovin.impl.nl
    public long a(int i11) {
        b1.a(i11 == 0);
        return 0L;
    }

    @Override // com.applovin.impl.nl
    public List b(long j11) {
        return j11 >= 0 ? this.f22101a : Collections.emptyList();
    }
}
