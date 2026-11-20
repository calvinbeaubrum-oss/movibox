package com.google.common.collect;

import com.google.common.base.Equivalence;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MapMaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f38474b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f38475c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MapMakerInternalMap.Strength f38476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MapMakerInternalMap.Strength f38477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Equivalence<Object> f38478f;

    /* JADX INFO: compiled from: source.java */
    public enum Dummy {
        VALUE
    }

    public MapMaker a(int i11) {
        int i12 = this.f38475c;
        com.google.common.base.m.x(i12 == -1, "concurrency level was already set to %s", i12);
        com.google.common.base.m.d(i11 > 0);
        this.f38475c = i11;
        return this;
    }

    public int b() {
        int i11 = this.f38475c;
        if (i11 == -1) {
            return 4;
        }
        return i11;
    }

    public int c() {
        int i11 = this.f38474b;
        if (i11 == -1) {
            return 16;
        }
        return i11;
    }

    public Equivalence<Object> d() {
        return (Equivalence) com.google.common.base.h.a(this.f38478f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.common.base.h.a(this.f38476d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.common.base.h.a(this.f38477e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i11) {
        int i12 = this.f38474b;
        com.google.common.base.m.x(i12 == -1, "initial capacity was already set to %s", i12);
        com.google.common.base.m.d(i11 >= 0);
        this.f38474b = i11;
        return this;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f38478f;
        com.google.common.base.m.z(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f38478f = (Equivalence) com.google.common.base.m.p(equivalence);
        this.f38473a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f38473a ? new ConcurrentHashMap(c(), 0.75f, b()) : MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f38476d;
        com.google.common.base.m.z(strength2 == null, "Key strength was already set to %s", strength2);
        this.f38476d = (MapMakerInternalMap.Strength) com.google.common.base.m.p(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f38473a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f38477e;
        com.google.common.base.m.z(strength2 == null, "Value strength was already set to %s", strength2);
        this.f38477e = (MapMakerInternalMap.Strength) com.google.common.base.m.p(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f38473a = true;
        }
        return this;
    }

    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        com.google.common.base.h.b bVarB = com.google.common.base.h.b(this);
        int i11 = this.f38474b;
        if (i11 != -1) {
            bVarB.b("initialCapacity", i11);
        }
        int i12 = this.f38475c;
        if (i12 != -1) {
            bVarB.b("concurrencyLevel", i12);
        }
        MapMakerInternalMap.Strength strength = this.f38476d;
        if (strength != null) {
            bVarB.d("keyStrength", com.google.common.base.a.e(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f38477e;
        if (strength2 != null) {
            bVarB.d("valueStrength", com.google.common.base.a.e(strength2.toString()));
        }
        if (this.f38478f != null) {
            bVarB.j("keyEquivalence");
        }
        return bVarB.toString();
    }
}
