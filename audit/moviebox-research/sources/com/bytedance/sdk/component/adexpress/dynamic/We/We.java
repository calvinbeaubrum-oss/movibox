package com.bytedance.sdk.component.adexpress.dynamic.We;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    public String We;
    public String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public List<sc> f26766sc;
    public String zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public JSONObject pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public int f26767sc;
    }

    public static We sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        We we2 = new We();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null) {
                    sc scVar = new sc();
                    scVar.f26767sc = jSONObjectOptJSONObject.optInt("id");
                    scVar.pFF = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(scVar);
                }
            }
        } catch (JSONException unused) {
        }
        we2.f26766sc = arrayList;
        we2.pFF = jSONObject.optString("diff_data");
        we2.zY = jSONObject.optString("style_diff");
        we2.We = jSONObject.optString("tag_diff");
        return we2;
    }
}
