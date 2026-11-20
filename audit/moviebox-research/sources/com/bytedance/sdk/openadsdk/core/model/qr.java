package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    private List<String> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f28446sc;

    public qr(String str) {
        this.f28446sc = "";
        this.pFF = new ArrayList();
        HashMap<String, Object> map = TextUtils.isEmpty(str) ? new HashMap<>() : sc(str);
        try {
            this.f28446sc = (String) map.get("auto_test_param");
            JSONArray jSONArray = new JSONArray((String) map.get("auto_test_hosts"));
            this.pFF = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                this.pFF.add(jSONArray.optString(i11));
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("AutoTestModel", e11.getMessage());
        }
    }

    private static final HashMap<String, Object> sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                map.put(jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.VALUE));
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    public List<String> pFF() {
        return this.pFF;
    }

    public String sc() {
        return this.f28446sc;
    }
}
