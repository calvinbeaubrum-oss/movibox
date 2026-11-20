package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kr f17409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f17410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f17411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f17412f = false;

    public a0(JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.j jVar) {
        this.f17407a = JsonUtils.getString(jSONObject, "name", "");
        this.f17408b = JsonUtils.getString(jSONObject, "experiment", null);
        this.f17409c = a(jSONObject);
        this.f17410d = a("bidders", jSONObject, map, maxAdFormat, jVar);
        this.f17411e = a("waterfall", jSONObject, map, maxAdFormat, jVar);
    }

    private kr a(JSONObject jSONObject) {
        return new kr(JsonUtils.getJSONObject(jSONObject, "targeting"));
    }

    private List a(String str, JSONObject jSONObject, Map map, MaxAdFormat maxAdFormat, com.applovin.impl.sdk.j jVar) {
        ke keVar;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            if (jSONObject2 != null && (keVar = (ke) map.get(JsonUtils.getString(jSONObject2, "adapter_class", ""))) != null) {
                if (keVar.A()) {
                    this.f17412f = true;
                }
                arrayList.add(new ir(jSONObject2, maxAdFormat, keVar, jVar));
            }
        }
        return arrayList;
    }

    public List a() {
        return this.f17410d;
    }

    public String b() {
        return this.f17408b;
    }

    public String c() {
        return this.f17407a;
    }

    public kr d() {
        return this.f17409c;
    }

    public List e() {
        return this.f17411e;
    }

    public boolean f() {
        return this.f17412f;
    }
}
