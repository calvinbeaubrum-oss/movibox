package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class kh implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f20253a;

    public kh(List list) {
        this.f20253a = list;
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return 1;
    }

    @Override // com.applovin.impl.nl
    public int a(long j11) {
        return -1;
    }

    @Override // com.applovin.impl.nl
    public long a(int i11) {
        return 0L;
    }

    @Override // com.applovin.impl.nl
    public List b(long j11) {
        return this.f20253a;
    }
}
