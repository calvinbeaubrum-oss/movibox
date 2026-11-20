package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class yo implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator f24700a;

    public yo(Iterator it) {
        this.f24700a = (Iterator) Preconditions.checkNotNull(it);
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f24700a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f24700a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f24700a.remove();
    }
}
