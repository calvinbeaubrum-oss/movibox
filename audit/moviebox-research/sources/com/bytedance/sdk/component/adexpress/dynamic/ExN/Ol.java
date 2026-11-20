package com.bytedance.sdk.component.adexpress.dynamic.ExN;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol {
    public static String pFF(String str, String str2) {
        if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
            return sc.sc(str);
        }
        if (str.indexOf(46) < 0) {
            str = str + ".png";
        }
        return str2 + "static/images/" + str;
    }

    public static String sc(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectMD = com.bytedance.sdk.component.adexpress.pFF.mD(str);
        if (jSONObjectMD == null || (jSONObjectOptJSONObject = jSONObjectMD.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String sc(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectMD = com.bytedance.sdk.component.adexpress.pFF.mD(str);
        if (jSONObjectMD == null || (jSONObjectOptJSONObject = jSONObjectMD.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject sc(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectMD = com.bytedance.sdk.component.adexpress.pFF.mD(str);
        if (jSONObjectMD == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return sc(jSONObject2, jSONObjectMD.optJSONObject("themeValues"), jSONObject);
    }

    public static JSONObject sc(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }

    public static JSONObject sc(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void sc(String str, JSONObject jSONObject) {
        JSONObject jSONObjectMD = com.bytedance.sdk.component.adexpress.pFF.mD(str);
        if (jSONObjectMD == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectMD.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        sc(jSONObjectOptJSONObject, jSONObject);
    }

    private static void sc(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
    }
}
