package com.iab.omid.library.mmadbridge.walking;

import java.util.HashSet;
import on.d;
import on.e;
import on.f;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements on.b.InterfaceC0782b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f42416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final on.c f42417b;

    public b(on.c cVar) {
        this.f42417b = cVar;
    }

    @Override // on.b.InterfaceC0782b
    public JSONObject a() {
        return this.f42416a;
    }

    @Override // on.b.InterfaceC0782b
    public void a(JSONObject jSONObject) {
        this.f42416a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42417b.c(new e(this, hashSet, jSONObject, j11));
    }

    public void c() {
        this.f42417b.c(new d(this));
    }

    public void d(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42417b.c(new f(this, hashSet, jSONObject, j11));
    }
}
