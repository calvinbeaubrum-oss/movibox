package com.iab.omid.library.vungle.walking;

import java.util.HashSet;
import org.json.JSONObject;
import wn.d;
import wn.e;
import wn.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements wn.b.InterfaceC0893b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f42480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wn.c f42481b;

    public b(wn.c cVar) {
        this.f42481b = cVar;
    }

    public void a() {
        this.f42481b.c(new d(this));
    }

    @Override // wn.b.InterfaceC0893b
    public void a(JSONObject jSONObject) {
        this.f42480a = jSONObject;
    }

    @Override // wn.b.InterfaceC0893b
    public JSONObject b() {
        return this.f42480a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42481b.c(new f(this, hashSet, jSONObject, j11));
    }

    public void c(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42481b.c(new e(this, hashSet, jSONObject, j11));
    }
}
