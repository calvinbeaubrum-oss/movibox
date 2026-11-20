package org.apache.tools.ant.taskdefs;

import java.net.URL;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f72758a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ URL f72759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f72760c;

    public d(e eVar, URL url) {
        this.f72760c = eVar;
        this.f72759b = url;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f72758a;
    }

    @Override // java.util.Enumeration
    public Object nextElement() throws NoSuchElementException {
        if (!this.f72758a) {
            throw new NoSuchElementException();
        }
        this.f72758a = false;
        return this.f72759b;
    }
}
