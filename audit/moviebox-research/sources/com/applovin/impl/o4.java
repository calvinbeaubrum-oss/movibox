package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o4 {
    private static List a(int i11, com.applovin.impl.sdk.j jVar) {
        String strA = yp.a(i11, com.applovin.impl.sdk.j.l(), jVar);
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalStateException("Unable to retrieve consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(strA, null);
        if (jSONObjectJsonObjectFromJsonString == null) {
            throw new IllegalStateException("Unable to parse consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectJsonObjectFromJsonString, "states", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            arrayList.add(j4.a(JsonUtils.getJSONObject(jSONArray, i12, new JSONObject()), jVar));
        }
        return arrayList;
    }

    public static List a(com.applovin.impl.sdk.j jVar) {
        return a(R.raw.applovin_consent_flow_privacy_policy, jVar);
    }

    public static List b(com.applovin.impl.sdk.j jVar) {
        return a(R.raw.applovin_consent_flow_terms_of_service_and_privacy_policy, jVar);
    }

    public static List c(com.applovin.impl.sdk.j jVar) {
        return a(R.raw.applovin_consent_flow_unified_cmp, jVar);
    }
}
