package com.iab.omid.library.applovin.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.applovin.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i implements d.a, com.iab.omid.library.applovin.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f42139f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f42140a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.applovin.devicevolume.e f42141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.applovin.devicevolume.b f42142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.applovin.devicevolume.d f42143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f42144e;

    public i(com.iab.omid.library.applovin.devicevolume.e eVar, com.iab.omid.library.applovin.devicevolume.b bVar) {
        this.f42141b = eVar;
        this.f42142c = bVar;
    }

    private c a() {
        if (this.f42144e == null) {
            this.f42144e = c.c();
        }
        return this.f42144e;
    }

    public static i c() {
        if (f42139f == null) {
            f42139f = new i(new com.iab.omid.library.applovin.devicevolume.e(), new com.iab.omid.library.applovin.devicevolume.b());
        }
        return f42139f;
    }

    @Override // com.iab.omid.library.applovin.devicevolume.c
    public void a(float f11) {
        this.f42140a = f11;
        Iterator<com.iab.omid.library.applovin.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f11);
        }
    }

    public void a(Context context) {
        this.f42143d = this.f42141b.a(new Handler(), context, this.f42142c.a(), this);
    }

    @Override // com.iab.omid.library.applovin.internal.d.a
    public void a(boolean z11) {
        if (z11) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }

    public float b() {
        return this.f42140a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f42143d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f42143d.d();
    }
}
