package com.iab.omid.library.mmadbridge.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f42355c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<kn.g> f42356a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<kn.g> f42357b = new ArrayList<>();

    public static c e() {
        return f42355c;
    }

    public Collection<kn.g> a() {
        return Collections.unmodifiableCollection(this.f42357b);
    }

    public void b(kn.g gVar) {
        this.f42356a.add(gVar);
    }

    public Collection<kn.g> c() {
        return Collections.unmodifiableCollection(this.f42356a);
    }

    public void d(kn.g gVar) {
        boolean zG = g();
        this.f42356a.remove(gVar);
        this.f42357b.remove(gVar);
        if (!zG || g()) {
            return;
        }
        h.d().f();
    }

    public void f(kn.g gVar) {
        boolean zG = g();
        this.f42357b.add(gVar);
        if (zG) {
            return;
        }
        h.d().e();
    }

    public boolean g() {
        return this.f42357b.size() > 0;
    }
}
