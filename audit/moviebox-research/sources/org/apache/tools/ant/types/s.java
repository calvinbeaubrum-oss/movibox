package org.apache.tools.ant.types;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class s implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f72923a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f72924b;

    public s(t tVar) {
        this.f72924b = tVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f72923a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.f72923a) {
            throw new NoSuchElementException();
        }
        this.f72923a = true;
        return this.f72924b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
