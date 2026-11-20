package com.applovin.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class y0 implements km.b, im.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f24441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f24442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w0 f24443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f24444d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(w0 w0Var, String str);

        void a(b bVar, String str);
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        APP_DETAILS_NOT_FOUND,
        INVALID_DEVELOPER_URI,
        APPADSTXT_NOT_FOUND,
        MISSING_APPLOVIN_ENTRIES,
        MISSING_NON_APPLOVIN_ENTRIES
    }

    public y0(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f24441a = jVar;
        this.f24442b = aVar;
    }

    public void a() {
        w0 w0Var = this.f24443c;
        if (w0Var != null) {
            this.f24442b.a(w0Var, this.f24444d);
        } else {
            this.f24441a.j0().a(new km(this.f24441a, this));
        }
    }

    @Override // com.applovin.impl.km.b
    public void a(b bVar) {
        this.f24442b.a(bVar, (String) null);
    }

    @Override // com.applovin.impl.im.b
    public void a(b bVar, String str) {
        this.f24442b.a(bVar, str);
    }

    @Override // com.applovin.impl.km.b
    public void a(String str) {
        this.f24441a.j0().a(new im(this.f24441a, str, this));
    }

    @Override // com.applovin.impl.im.b
    public void a(String str, String str2) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split("\n");
        int length = strArrSplit.length;
        int i11 = 1;
        int i12 = 0;
        while (i12 < length) {
            int i13 = i11 + 1;
            x0 x0Var = new x0(strArrSplit[i12], i11);
            if (x0Var.h()) {
                String strB = x0Var.b();
                List arrayList2 = map.containsKey(strB) ? (List) map.get(strB) : new ArrayList();
                if (arrayList2 != null) {
                    arrayList2.add(x0Var);
                    map.put(strB, arrayList2);
                }
            } else {
                arrayList.add(x0Var);
            }
            i12++;
            i11 = i13;
        }
        this.f24443c = new w0(map, arrayList);
        this.f24444d = str2;
        this.f24441a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24441a.J().a("AppAdsTxtService", "app-ads.txt fetched: " + this.f24443c);
        }
        this.f24442b.a(this.f24443c, str2);
    }
}
