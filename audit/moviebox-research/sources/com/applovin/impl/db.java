package com.applovin.impl;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class db extends g implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f18401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f18402b;

    public db(Object obj, Object obj2) {
        this.f18401a = obj;
        this.f18402b = obj2;
    }

    @Override // com.applovin.impl.g, java.util.Map.Entry
    public final Object getKey() {
        return this.f18401a;
    }

    @Override // com.applovin.impl.g, java.util.Map.Entry
    public final Object getValue() {
        return this.f18402b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
