package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final Ol f28485sc = new Ol("");
    private final HashMap<String, sc> pFF = new HashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public String ExN;
        public int We;
        public String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final String f28486sc;
        public int zY;

        public sc(JSONObject jSONObject) {
            this.f28486sc = jSONObject.optString("name");
            this.pFF = jSONObject.optString("app_id");
            this.zY = jSONObject.optInt("init_thread", 2);
            this.We = jSONObject.optInt("request_after_init", 2);
            this.ExN = jSONObject.optString("class_name");
        }
    }

    public Ol(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                if (jSONObjectOptJSONObject != null) {
                    sc scVar = new sc(jSONObjectOptJSONObject);
                    this.pFF.put(scVar.f28486sc, scVar);
                }
            }
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("MediationInitConfigs", e11.getMessage());
        }
    }
}
