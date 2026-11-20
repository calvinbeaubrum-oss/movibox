package com.applovin.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class e extends f implements fc {
    public e(Map map) {
        super(map);
    }

    @Override // com.applovin.impl.f
    public Collection a(Object obj, Collection collection) {
        return a(obj, (List) collection, null);
    }

    @Override // com.applovin.impl.h, com.applovin.impl.uf
    public Map a() {
        return super.a();
    }

    @Override // com.applovin.impl.f
    public Collection c(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.applovin.impl.h
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.applovin.impl.f, com.applovin.impl.uf
    public boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }
}
