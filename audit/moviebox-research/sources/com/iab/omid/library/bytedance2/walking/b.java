package com.iab.omid.library.bytedance2.walking;

import com.iab.omid.library.bytedance2.walking.async.d;
import com.iab.omid.library.bytedance2.walking.async.e;
import com.iab.omid.library.bytedance2.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0470b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f42337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.walking.async.c f42338b;

    public b(com.iab.omid.library.bytedance2.walking.async.c cVar) {
        this.f42338b = cVar;
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0470b
    public JSONObject a() {
        return this.f42337a;
    }

    @Override // com.iab.omid.library.bytedance2.walking.async.b.InterfaceC0470b
    public void a(JSONObject jSONObject) {
        this.f42337a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42338b.b(new e(this, hashSet, jSONObject, j11));
    }

    public void b() {
        this.f42338b.b(new d(this));
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.f42338b.b(new f(this, hashSet, jSONObject, j11));
    }
}
