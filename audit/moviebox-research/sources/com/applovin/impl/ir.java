package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ir {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jc f19769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final dg f19770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f19771c;

    public ir(JSONObject jSONObject, MaxAdFormat maxAdFormat, ke keVar, com.applovin.impl.sdk.j jVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.f19770b = new dg(jSONObject2, jVar);
        } else {
            this.f19770b = null;
        }
        this.f19769a = new jc(JsonUtils.getString(jSONObject, "name", ""), JsonUtils.getString(jSONObject, "display_name", ""), jSONObject2 != null, keVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "placements", new JSONArray());
        this.f19771c = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            if (jSONObject3 != null) {
                this.f19771c.add(new dg(jSONObject3, jVar));
            }
        }
    }

    public dg a() {
        return this.f19770b;
    }

    public jc b() {
        return this.f19769a;
    }

    public List c() {
        return this.f19771c;
    }

    public boolean d() {
        return this.f19770b != null;
    }
}
