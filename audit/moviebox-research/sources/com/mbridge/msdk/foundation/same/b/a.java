package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f44411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f44412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f44413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f44414d;

    private void a(a aVar) {
        if (this.f44411a == null) {
            this.f44411a = new ArrayList();
        }
        aVar.f44413c = this;
        this.f44411a.add(aVar);
    }

    public final List<a> a() {
        return this.f44411a;
    }

    public final void a(c cVar) {
        this.f44414d = cVar;
    }

    public final void a(c cVar, String str) {
        a aVar = new a();
        aVar.f44414d = cVar;
        aVar.f44412b = str;
        a(aVar);
    }

    public final void a(String str) {
        this.f44412b = str;
    }

    public final void a(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public final String b() {
        return this.f44412b;
    }

    public final a c() {
        return this.f44413c;
    }

    public final c d() {
        return this.f44414d;
    }
}
