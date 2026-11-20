package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.impl;

import java.util.Enumeration;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Enumeration f40089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeakHashtable f40090b;

    public b(WeakHashtable weakHashtable, Enumeration enumeration) {
        this.f40090b = weakHashtable;
        this.f40089a = enumeration;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f40089a.hasMoreElements();
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        return ((WeakHashtable.b) this.f40089a.nextElement()).b();
    }
}
