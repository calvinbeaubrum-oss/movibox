package com.iab.omid.library.bytedance2.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.bytedance2.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i implements com.iab.omid.library.bytedance2.devicevolume.c, d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f42268f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f42269a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.devicevolume.e f42270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.devicevolume.b f42271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.bytedance2.devicevolume.d f42272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f42273e;

    public i(com.iab.omid.library.bytedance2.devicevolume.e eVar, com.iab.omid.library.bytedance2.devicevolume.b bVar) {
        this.f42270b = eVar;
        this.f42271c = bVar;
    }

    private c a() {
        if (this.f42273e == null) {
            this.f42273e = c.c();
        }
        return this.f42273e;
    }

    public static i c() {
        if (f42268f == null) {
            f42268f = new i(new com.iab.omid.library.bytedance2.devicevolume.e(), new com.iab.omid.library.bytedance2.devicevolume.b());
        }
        return f42268f;
    }

    @Override // com.iab.omid.library.bytedance2.devicevolume.c
    public void a(float f11) {
        this.f42269a = f11;
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f11);
        }
    }

    public void a(Context context) {
        this.f42272d = this.f42270b.a(new Handler(), context, this.f42271c.a(), this);
    }

    @Override // com.iab.omid.library.bytedance2.internal.d.a
    public void a(boolean z11) {
        if (z11) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }

    public float b() {
        return this.f42269a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f42272d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f42272d.d();
    }
}
