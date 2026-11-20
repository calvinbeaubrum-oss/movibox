package org.apache.tools.ant.types;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class p implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Enumeration f72908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f72909b;

    public p(q qVar, Enumeration enumeration) {
        this.f72909b = qVar;
        this.f72908a = enumeration;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f72908a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public Object next() {
        return new w20.f(this.f72909b.getProject(), (String) this.f72908a.nextElement());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
