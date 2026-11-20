package com.iab.omid.library.vungle.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f42422c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<sn.f> f42423a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<sn.f> f42424b = new ArrayList<>();

    public static a a() {
        return f42422c;
    }

    public void b(sn.f fVar) {
        this.f42423a.add(fVar);
    }

    public Collection<sn.f> c() {
        return Collections.unmodifiableCollection(this.f42423a);
    }

    public void d(sn.f fVar) {
        boolean zG = g();
        this.f42424b.add(fVar);
        if (zG) {
            return;
        }
        f.a().c();
    }

    public Collection<sn.f> e() {
        return Collections.unmodifiableCollection(this.f42424b);
    }

    public void f(sn.f fVar) {
        boolean zG = g();
        this.f42423a.remove(fVar);
        this.f42424b.remove(fVar);
        if (!zG || g()) {
            return;
        }
        f.a().d();
    }

    public boolean g() {
        return this.f42424b.size() > 0;
    }
}
