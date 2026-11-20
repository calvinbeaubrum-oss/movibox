package com.applovin.impl;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f19837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final JSONObject f19838b;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        NONE,
        IS_AL_GDPR
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        ALERT,
        EVENT,
        HAS_USER_CONSENT,
        REINIT,
        CMP_LOAD,
        CMP_SHOW,
        DECISION,
        TERMS_FLOW
    }

    public j4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        this.f19837a = jVar;
        this.f19838b = jSONObject;
    }

    private static a a(String str) {
        return "is_al_gdpr".equalsIgnoreCase(str) ? a.IS_AL_GDPR : a.NONE;
    }

    public static j4 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        b bVarC = c(JsonUtils.getString(jSONObject, "type", null));
        if (bVarC == b.ALERT) {
            return new k4(jSONObject, jVar);
        }
        return bVarC == b.EVENT ? new m4(jSONObject, jVar) : new j4(jSONObject, jVar);
    }

    private static b c(String str) {
        if ("alert".equalsIgnoreCase(str)) {
            return b.ALERT;
        }
        if (NotificationCompat.CATEGORY_EVENT.equalsIgnoreCase(str)) {
            return b.EVENT;
        }
        if ("cmp_load".equalsIgnoreCase(str)) {
            return b.CMP_LOAD;
        }
        if ("cmp_show".equalsIgnoreCase(str)) {
            return b.CMP_SHOW;
        }
        if ("decision".equalsIgnoreCase(str)) {
            return b.DECISION;
        }
        if ("terms_flow".equalsIgnoreCase(str)) {
            return b.TERMS_FLOW;
        }
        if ("huc".equalsIgnoreCase(str)) {
            return b.HAS_USER_CONSENT;
        }
        if ("reinit".equalsIgnoreCase(str)) {
            return b.REINIT;
        }
        throw new IllegalArgumentException("Invalid type provided: " + str);
    }

    public a a() {
        return a(JsonUtils.getString(this.f19838b, "decision_type", null));
    }

    public String a(Boolean bool) {
        String string = JsonUtils.getString(this.f19838b, "destination_state_id", null);
        if (StringUtils.isValidString(string)) {
            return string;
        }
        if (bool != null) {
            return bool.booleanValue() ? JsonUtils.getString(this.f19838b, "destination_state_id_true", null) : JsonUtils.getString(this.f19838b, "destination_state_id_false", null);
        }
        throw new IllegalStateException("Decision needed for state: " + string);
    }

    public String b() {
        return JsonUtils.getString(this.f19838b, "id", null);
    }

    public String b(String str) {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f19838b, str, (JSONObject) null);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "replacements", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            String string = JsonUtils.getObjectAtIndex(jSONArray, i11, "").toString();
            if ("<APP_NAME>".equalsIgnoreCase(string)) {
                String str2 = (String) this.f19837a.y().F().get("app_name");
                if (StringUtils.isValidString(str2)) {
                    arrayList.add(str2);
                } else {
                    arrayList.add(com.applovin.impl.sdk.j.a("THIS_APP"));
                }
            } else {
                arrayList.add(string);
            }
        }
        return com.applovin.impl.sdk.j.a(JsonUtils.getString(jSONObject, "key", null), arrayList);
    }

    public b c() {
        return c(JsonUtils.getString(this.f19838b, "type", null));
    }

    public boolean d() {
        return JsonUtils.getBoolean(this.f19838b, "is_initial_state", Boolean.FALSE).booleanValue();
    }

    public String toString() {
        return "ConsentFlowState{id=" + b() + "type=" + c() + "isInitialState=" + d() + "}";
    }
}
