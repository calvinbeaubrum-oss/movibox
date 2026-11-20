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
public class z implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaxAdFormat f24732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a0 f24733d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f24734f;

    public z(JSONObject jSONObject, Map map, com.applovin.impl.sdk.j jVar) {
        this.f24730a = JsonUtils.getString(jSONObject, "name", "");
        this.f24731b = JsonUtils.getString(jSONObject, "display_name", "");
        this.f24732c = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "format", null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.f24734f = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            if (jSONObject2 != null) {
                this.f24734f.add(new a0(jSONObject2, map, this.f24732c, jVar));
            }
        }
        this.f24733d = this.f24734f.isEmpty() ? null : (a0) this.f24734f.get(0);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(z zVar) {
        return this.f24731b.compareToIgnoreCase(zVar.f24731b);
    }

    public MaxAdFormat a() {
        return this.f24732c;
    }

    public String b() {
        MaxAdFormat maxAdFormat = this.f24732c;
        return maxAdFormat != null ? maxAdFormat.getLabel() : "Unknown";
    }

    public String c() {
        return this.f24730a;
    }

    public String d() {
        return this.f24731b;
    }

    public String e() {
        return "\n---------- " + this.f24731b + " ----------\nIdentifier - " + this.f24730a + "\nFormat     - " + b();
    }

    public a0 f() {
        return this.f24733d;
    }

    public List g() {
        return this.f24734f;
    }
}
