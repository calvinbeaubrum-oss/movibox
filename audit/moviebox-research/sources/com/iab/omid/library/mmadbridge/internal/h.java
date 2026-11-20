package com.iab.omid.library.mmadbridge.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.mmadbridge.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h implements d.a, ln.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static h f42370f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f42371a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ln.e f42372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ln.b f42373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ln.d f42374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f42375e;

    public h(ln.e eVar, ln.b bVar) {
        this.f42372b = eVar;
        this.f42373c = bVar;
    }

    public static h d() {
        if (f42370f == null) {
            f42370f = new h(new ln.e(), new ln.b());
        }
        return f42370f;
    }

    public final c a() {
        if (this.f42375e == null) {
            this.f42375e = c.e();
        }
        return this.f42375e;
    }

    @Override // ln.c
    public void a(float f11) {
        this.f42371a = f11;
        Iterator<kn.g> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().w().b(f11);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d.a
    public void a(boolean z11) {
        if (z11) {
            TreeWalker.p().q();
        } else {
            TreeWalker.p().o();
        }
    }

    public void b(Context context) {
        this.f42374d = this.f42372b.a(new Handler(), context, this.f42373c.a(), this);
    }

    public float c() {
        return this.f42371a;
    }

    public void e() {
        b.k().b(this);
        b.k().i();
        TreeWalker.p().q();
        this.f42374d.d();
    }

    public void f() {
        TreeWalker.p().s();
        b.k().j();
        this.f42374d.e();
    }
}
