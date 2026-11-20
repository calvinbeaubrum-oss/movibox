package com.cloud.tmc.kernel.extension;

import com.google.gson.JsonObject;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements bc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f31193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mc.a f31194b;

    public b(mc.a aVar, boolean z11) {
        this.f31193a = z11;
        this.f31194b = aVar;
    }

    @Override // bc.a
    public void a(JsonObject jsonObject) {
        if (this.f31193a) {
            this.f31194b.k(jsonObject);
        } else {
            this.f31194b.i(jsonObject);
        }
    }

    @Override // bc.a
    public void b() {
        e(new JsonObject());
    }

    @Override // bc.a
    public String c() {
        return this.f31194b.e();
    }

    @Override // bc.a
    public void close() {
        h(new JsonObject());
    }

    @Override // bc.a
    public void d(JsonObject jsonObject) {
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        jsonObject.addProperty("success", "true");
        a(jsonObject);
    }

    @Override // bc.a
    public void e(JsonObject jsonObject) {
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        jsonObject.addProperty("success", "false");
        a(jsonObject);
    }

    @Override // bc.a
    public void f() {
        j(new HashMap<>());
    }

    @Override // bc.a
    public void g() {
        d(new JsonObject());
    }

    public void h(JsonObject jsonObject) {
        if (this.f31193a) {
            this.f31194b.j(jsonObject);
        }
    }

    public void i(bc.b bVar) {
        if (bVar == null) {
            bVar = bc.b.f14083b;
        }
        if (bVar instanceof bc.b.C0142b) {
            bc.b.C0142b c0142b = (bc.b.C0142b) bVar;
            this.f31194b.l(c0142b.b(), c0142b.c());
            return;
        }
        JsonObject jsonObjectA = bVar.a();
        if (this.f31193a) {
            this.f31194b.k(jsonObjectA);
        } else {
            this.f31194b.i(jsonObjectA);
        }
    }

    public void j(HashMap<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("success", "false");
        k(map);
    }

    public void k(HashMap<String, Object> map) {
        if (this.f31193a) {
            this.f31194b.h(map);
        } else {
            this.f31194b.g(map);
        }
    }
}
