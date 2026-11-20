package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.exoplayer2.common.base.Supplier;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xf {

    /* JADX INFO: compiled from: source.java */
    public static class a extends e {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient Supplier f24316g;

        public a(Map map, Supplier supplier) {
            super(map);
            this.f24316g = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.applovin.impl.h
        public Map b() {
            return h();
        }

        @Override // com.applovin.impl.h
        public Set c() {
            return i();
        }

        @Override // com.applovin.impl.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public List g() {
            return (List) this.f24316g.get();
        }
    }

    public static fc a(Map map, Supplier supplier) {
        return new a(map, supplier);
    }

    public static boolean a(uf ufVar, Object obj) {
        if (obj == ufVar) {
            return true;
        }
        if (obj instanceof uf) {
            return ufVar.a().equals(((uf) obj).a());
        }
        return false;
    }
}
