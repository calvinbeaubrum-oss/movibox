package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f44415a;

    public b(String str) {
        a aVar = new a();
        aVar.a(str);
        aVar.a(c.AD_ROOT);
        List<a> listA = a();
        if (listA != null && listA.size() > 0) {
            aVar.a(listA);
        }
        this.f44415a = aVar;
    }

    public final a a(ArrayList<a> arrayList, c cVar, String str) {
        a aVar = new a();
        aVar.a(cVar);
        aVar.a(str);
        arrayList.add(aVar);
        return aVar;
    }

    public abstract List<a> a();

    public final a b() {
        return this.f44415a;
    }
}
