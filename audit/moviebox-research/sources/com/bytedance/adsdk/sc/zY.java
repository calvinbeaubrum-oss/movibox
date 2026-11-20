package com.bytedance.adsdk.sc;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements ExN {
    @Override // com.bytedance.adsdk.sc.ExN
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public String sc(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length != 3) {
            return null;
        }
        String strValueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strValueOf);
            String strValueOf2 = String.valueOf(objArr[1]);
            if (TextUtils.isEmpty(strValueOf2)) {
                return null;
            }
            return jSONObject2.optString(strValueOf2, String.valueOf(objArr[2]));
        } catch (JSONException unused) {
            return null;
        }
    }
}
