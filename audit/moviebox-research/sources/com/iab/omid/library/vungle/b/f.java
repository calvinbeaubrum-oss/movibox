package com.iab.omid.library.vungle.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.vungle.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f implements rn.c, b.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static f f42439f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f42440a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rn.e f42441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rn.b f42442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public rn.d f42443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f42444e;

    public f(rn.e eVar, rn.b bVar) {
        this.f42441b = eVar;
        this.f42442c = bVar;
    }

    public static f a() {
        if (f42439f == null) {
            f42439f = new f(new rn.e(), new rn.b());
        }
        return f42439f;
    }

    @Override // rn.c
    public void a(float f11) {
        this.f42440a = f11;
        Iterator<sn.f> it = f().e().iterator();
        while (it.hasNext()) {
            it.next().k().b(f11);
        }
    }

    @Override // com.iab.omid.library.vungle.b.b.a
    public void a(boolean z11) {
        if (z11) {
            TreeWalker.p().c();
        } else {
            TreeWalker.p().k();
        }
    }

    public void b(Context context) {
        this.f42443d = this.f42441b.a(new Handler(), context, this.f42442c.a(), this);
    }

    public void c() {
        b.a().c(this);
        b.a().e();
        TreeWalker.p().c();
        this.f42443d.a();
    }

    public void d() {
        TreeWalker.p().h();
        b.a().f();
        this.f42443d.c();
    }

    public float e() {
        return this.f42440a;
    }

    public final a f() {
        if (this.f42444e == null) {
            this.f42444e = a.a();
        }
        return this.f42444e;
    }
}
