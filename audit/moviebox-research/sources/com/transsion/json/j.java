package com.transsion.json;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class, p> f52964a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<r, p> f52965b = new HashMap();

    public final o a() {
        o oVar = new o();
        for (Class cls : this.f52964a.keySet()) {
            oVar.b(cls, this.f52964a.get(cls));
        }
        for (r rVar : this.f52965b.keySet()) {
            oVar.a(rVar, this.f52965b.get(rVar));
        }
        return oVar;
    }

    public T b(String str, Class cls) {
        return (T) a().j(new m(str).j(), cls);
    }
}
