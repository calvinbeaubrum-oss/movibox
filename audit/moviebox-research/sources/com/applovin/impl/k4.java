package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k4 extends j4 {
    public k4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jVar);
    }

    public List e() {
        l4 l4VarA;
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f19838b, "transitions", null);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i11, (JSONObject) null);
            if (jSONObject != null && (l4VarA = l4.a(jSONObject, this.f19837a)) != null) {
                arrayList.add(l4VarA);
            }
        }
        return arrayList;
    }

    public String f() {
        return b("message");
    }

    public String g() {
        return b(CampaignEx.JSON_KEY_TITLE);
    }

    @Override // com.applovin.impl.j4
    public String toString() {
        return "ConsentFlowState{id=" + b() + "type=" + c() + "isInitialState=" + d() + "title=" + g() + "message=" + f() + "actions=" + e() + "}";
    }
}
