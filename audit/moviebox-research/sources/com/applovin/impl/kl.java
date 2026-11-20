package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class kl implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b5[] f20260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f20261b;

    public kl(b5[] b5VarArr, long[] jArr) {
        this.f20260a = b5VarArr;
        this.f20261b = jArr;
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f20261b.length;
    }

    @Override // com.applovin.impl.nl
    public int a(long j11) {
        int iA = xp.a(this.f20261b, j11, false, false);
        if (iA < this.f20261b.length) {
            return iA;
        }
        return -1;
    }

    @Override // com.applovin.impl.nl
    public long a(int i11) {
        b1.a(i11 >= 0);
        b1.a(i11 < this.f20261b.length);
        return this.f20261b[i11];
    }

    @Override // com.applovin.impl.nl
    public List b(long j11) {
        b5 b5Var;
        int iB = xp.b(this.f20261b, j11, true, false);
        return (iB == -1 || (b5Var = this.f20260a[iB]) == b5.f17830s) ? Collections.emptyList() : Collections.singletonList(b5Var);
    }
}
