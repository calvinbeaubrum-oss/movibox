package com.iab.omid.library.applovin.walking;

import com.iab.omid.library.applovin.walking.async.d;
import com.iab.omid.library.applovin.walking.async.e;
import com.iab.omid.library.applovin.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements com.iab.omid.library.applovin.walking.async.b.InterfaceC0466b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f42208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.applovin.walking.async.c f42209b;

    public b(com.iab.omid.library.applovin.walking.async.c cVar) {
        this.f42209b = cVar;
    }

    @Override // com.iab.omid.library.applovin.walking.async.b.InterfaceC0466b
    public JSONObject a() {
        return this.f42208a;
    }

    @Override // com.iab.omid.library.applovin.walking.async.b.InterfaceC0466b
    public void a(JSONObject jSONObject) {
        this.f42208a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42209b.b(new e(this, hashSet, jSONObject, j11));
    }

    public void b() {
        this.f42209b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42209b.b(new f(this, hashSet, jSONObject, j11));
    }
}
