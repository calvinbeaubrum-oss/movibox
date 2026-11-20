package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Equivalence;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class MapMaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f39472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39473b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39474c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MapMakerInternalMap.Strength f39475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MapMakerInternalMap.Strength f39476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Equivalence<Object> f39477f;

    /* JADX INFO: compiled from: source.java */
    public enum Dummy {
        VALUE
    }

    public MapMaker a(int i11) {
        int i12 = this.f39474c;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.v(i12 == -1, "concurrency level was already set to %s", i12);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(i11 > 0);
        this.f39474c = i11;
        return this;
    }

    public int b() {
        int i11 = this.f39474c;
        if (i11 == -1) {
            return 4;
        }
        return i11;
    }

    public int c() {
        int i11 = this.f39473b;
        if (i11 == -1) {
            return 16;
        }
        return i11;
    }

    public Equivalence<Object> d() {
        return (Equivalence) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a(this.f39477f, e().defaultEquivalence());
    }

    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a(this.f39475d, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMakerInternalMap.Strength f() {
        return (MapMakerInternalMap.Strength) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.a(this.f39476e, MapMakerInternalMap.Strength.STRONG);
    }

    public MapMaker g(int i11) {
        int i12 = this.f39473b;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.v(i12 == -1, "initial capacity was already set to %s", i12);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(i11 >= 0);
        this.f39473b = i11;
        return this;
    }

    public MapMaker h(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f39477f;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.w(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f39477f = (Equivalence) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(equivalence);
        this.f39472a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f39472a ? new ConcurrentHashMap(c(), 0.75f, b()) : MapMakerInternalMap.create(this);
    }

    public MapMaker j(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f39475d;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.w(strength2 == null, "Key strength was already set to %s", strength2);
        this.f39475d = (MapMakerInternalMap.Strength) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f39472a = true;
        }
        return this;
    }

    public MapMaker k(MapMakerInternalMap.Strength strength) {
        MapMakerInternalMap.Strength strength2 = this.f39476e;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.w(strength2 == null, "Value strength was already set to %s", strength2);
        this.f39476e = (MapMakerInternalMap.Strength) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(strength);
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f39472a = true;
        }
        return this;
    }

    public MapMaker l() {
        return j(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.b bVarB = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.b(this);
        int i11 = this.f39473b;
        if (i11 != -1) {
            bVarB.b("initialCapacity", i11);
        }
        int i12 = this.f39474c;
        if (i12 != -1) {
            bVarB.b("concurrencyLevel", i12);
        }
        MapMakerInternalMap.Strength strength = this.f39475d;
        if (strength != null) {
            bVarB.d("keyStrength", com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.a.c(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f39476e;
        if (strength2 != null) {
            bVarB.d("valueStrength", com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.a.c(strength2.toString()));
        }
        if (this.f39477f != null) {
            bVarB.h("keyEquivalence");
        }
        return bVarB.toString();
    }
}
