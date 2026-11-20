package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f1 extends d1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f18837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f18838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f18839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f18840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final u2 f18841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a f18843l;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Uri uri);
    }

    public f1(String str, com.applovin.impl.sdk.ad.b bVar, u2 u2Var, com.applovin.impl.sdk.j jVar, a aVar) {
        this(str, bVar, bVar.X(), true, u2Var, jVar, aVar);
    }

    public f1(String str, com.applovin.impl.sdk.ad.b bVar, List list, boolean z11, u2 u2Var, com.applovin.impl.sdk.j jVar, a aVar) {
        super("AsyncTaskCacheResource", jVar);
        this.f18837f = str;
        this.f18838g = bVar;
        this.f18839h = list;
        this.f18840i = z11;
        this.f18841j = u2Var;
        this.f18842k = jVar;
        this.f18843l = aVar;
    }

    private void a(Uri uri) {
        a aVar;
        if (this.f18339e.get() || (aVar = this.f18843l) == null) {
            return;
        }
        aVar.a(uri);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean call() {
        if (this.f18339e.get()) {
            return Boolean.FALSE;
        }
        String strA = this.f18842k.B().a(a(), this.f18837f, this.f18838g.getCachePrefix(), this.f18839h, this.f18840i, this.f18841j);
        if (TextUtils.isEmpty(strA)) {
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.f18339e.get()) {
            return Boolean.FALSE;
        }
        File fileA = this.f18842k.B().a(strA, a());
        if (fileA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f18337c.b(this.f18336b, "Unable to retrieve File for cached filename = " + strA);
            }
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.f18339e.get()) {
            return Boolean.FALSE;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f18337c.b(this.f18336b, "Unable to extract Uri from file");
            }
            a((Uri) null);
            return Boolean.FALSE;
        }
        if (this.f18339e.get()) {
            return Boolean.FALSE;
        }
        a(uriFromFile);
        return Boolean.TRUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f18837f.equals(((f1) obj).f18837f);
    }

    public int hashCode() {
        String str = this.f18837f;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
