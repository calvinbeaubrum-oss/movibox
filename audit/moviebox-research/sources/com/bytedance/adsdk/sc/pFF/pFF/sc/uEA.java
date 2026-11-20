package com.bytedance.adsdk.sc.pFF.pFF.sc;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class uEA implements com.bytedance.adsdk.sc.pFF.pFF.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26307sc;

    public uEA(String str) {
        this.f26307sc = str;
    }

    private Object sc(String[] strArr, int i11, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i11 < strArr.length && jSONObject != null) {
            String str = strArr[i11];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
                objOpt = jSONObject.opt(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i12 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i12) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            if (i11 == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return sc(strArr, i11 + 1, new JSONObject((String) objOpt));
                } catch (JSONException unused2) {
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return sc(strArr, i11 + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        return this.f26307sc;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return com.bytedance.adsdk.sc.pFF.We.TRI.VARIABLE;
    }

    public Object sc(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sc(str.split("\\."), 0, jSONObject);
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public Object sc(Map<String, JSONObject> map) {
        Object objSc;
        if (map == null || map.size() <= 0 || (objSc = sc(this.f26307sc, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objSc;
    }

    public String toString() {
        return "VariableNode [literals=" + this.f26307sc + "]";
    }
}
