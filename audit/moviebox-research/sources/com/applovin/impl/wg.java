package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Function;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wg implements Comparator {
    public static wg a() {
        return ag.f17656a;
    }

    public static wg a(Comparator comparator) {
        return comparator instanceof wg ? (wg) comparator : new x3(comparator);
    }

    public eb a(Iterable iterable) {
        return eb.a((Comparator) this, iterable);
    }

    public wg a(Function function) {
        return new r2(function, this);
    }

    public wg b() {
        return a(vc.a());
    }

    public wg c() {
        return new yi(this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);
}
