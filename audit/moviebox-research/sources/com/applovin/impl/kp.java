package com.applovin.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class kp implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gp f20266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f20267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f20268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f20269d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f20270f;

    public kp(gp gpVar, Map map, Map map2, Map map3) {
        this.f20266a = gpVar;
        this.f20269d = map2;
        this.f20270f = map3;
        this.f20268c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.f20267b = gpVar.b();
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f20267b.length;
    }

    @Override // com.applovin.impl.nl
    public int a(long j11) {
        int iA = xp.a(this.f20267b, j11, false, false);
        if (iA < this.f20267b.length) {
            return iA;
        }
        return -1;
    }

    @Override // com.applovin.impl.nl
    public long a(int i11) {
        return this.f20267b[i11];
    }

    @Override // com.applovin.impl.nl
    public List b(long j11) {
        return this.f20266a.a(j11, this.f20268c, this.f20269d, this.f20270f);
    }
}
