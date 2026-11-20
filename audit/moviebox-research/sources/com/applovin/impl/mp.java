package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class mp implements nl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final mp f21189b = new mp();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f21190a;

    private mp() {
        this.f21190a = Collections.emptyList();
    }

    public mp(b5 b5Var) {
        this.f21190a = Collections.singletonList(b5Var);
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
        return j11 >= 0 ? this.f21190a : Collections.emptyList();
    }
}
