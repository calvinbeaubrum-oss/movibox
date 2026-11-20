package com.iab.omid.library.bytedance2.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f42243f = new a(new d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.iab.omid.library.bytedance2.utils.f f42244a = new com.iab.omid.library.bytedance2.utils.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Date f42245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f42246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f42247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f42248e;

    private a(d dVar) {
        this.f42247d = dVar;
    }

    public static a a() {
        return f42243f;
    }

    private void c() {
        if (!this.f42246c || this.f42245b == null) {
            return;
        }
        Iterator<com.iab.omid.library.bytedance2.adsession.a> it = c.c().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(b());
        }
    }

    public void a(@NonNull Context context) {
        if (this.f42246c) {
            return;
        }
        this.f42247d.a(context);
        this.f42247d.a(this);
        this.f42247d.e();
        this.f42248e = this.f42247d.c();
        this.f42246c = true;
    }

    @Override // com.iab.omid.library.bytedance2.internal.d.a
    public void a(boolean z11) {
        if (!this.f42248e && z11) {
            d();
        }
        this.f42248e = z11;
    }

    public Date b() {
        Date date = this.f42245b;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void d() {
        Date dateA = this.f42244a.a();
        Date date = this.f42245b;
        if (date == null || dateA.after(date)) {
            this.f42245b = dateA;
            c();
        }
    }
}
