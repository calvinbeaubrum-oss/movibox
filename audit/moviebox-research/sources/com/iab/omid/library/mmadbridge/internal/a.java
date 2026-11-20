package com.iab.omid.library.mmadbridge.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f42348f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn.f f42349a = new nn.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Date f42350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f42352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42353e;

    public a(d dVar) {
        this.f42352d = dVar;
    }

    public static a a() {
        return f42348f;
    }

    @Override // com.iab.omid.library.mmadbridge.internal.d.a
    public void a(boolean z11) {
        if (!this.f42353e && z11) {
            e();
        }
        this.f42353e = z11;
    }

    public void b(@NonNull Context context) {
        if (this.f42351c) {
            return;
        }
        this.f42352d.a(context);
        this.f42352d.b(this);
        this.f42352d.i();
        this.f42353e = this.f42352d.g();
        this.f42351c = true;
    }

    public Date c() {
        Date date = this.f42350b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public final void d() {
        if (!this.f42351c || this.f42350b == null) {
            return;
        }
        Iterator<kn.g> it = c.e().a().iterator();
        while (it.hasNext()) {
            it.next().w().h(c());
        }
    }

    public void e() {
        Date dateA = this.f42349a.a();
        Date date = this.f42350b;
        if (date == null || dateA.after(date)) {
            this.f42350b = dateA;
            d();
        }
    }
}
