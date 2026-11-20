package com.iab.omid.library.applovin.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f42114f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.applovin.utils.f f42115a = new com.iab.omid.library.applovin.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f42116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f42117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f42118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f42119e;

    private a(d dVar) {
        this.f42118d = dVar;
    }

    public static a a() {
        return f42114f;
    }

    private void c() {
        if (!this.f42117c || this.f42116b == null) {
            return;
        }
        Iterator<com.iab.omid.library.applovin.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public void a(@NonNull Context context) {
        if (this.f42117c) {
            return;
        }
        this.f42118d.a(context);
        this.f42118d.a(this);
        this.f42118d.e();
        this.f42119e = this.f42118d.c();
        this.f42117c = true;
    }

    @Override // com.iab.omid.library.applovin.internal.d.a
    public void a(boolean z11) {
        if (!this.f42119e && z11) {
            d();
        }
        this.f42119e = z11;
    }

    public Date b() {
        Date date = this.f42116b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f42115a.a();
        Date date = this.f42116b;
        if (date == null || dateA.after(date)) {
            this.f42116b = dateA;
            c();
        }
    }
}
