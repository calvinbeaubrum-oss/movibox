package com.applovin.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class i3 {
    private static String a(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static byte[] a(byte[] bArr) {
        return xp.f24372a >= 27 ? bArr : xp.c(a(xp.a(bArr)));
    }

    private static String b(String str) {
        return str.replace('-', '+').replace('_', '/');
    }

    public static byte[] b(byte[] bArr) {
        if (xp.f24372a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(xp.a(bArr));
            StringBuilder sb2 = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                if (i11 != 0) {
                    sb2.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                sb2.append("{\"k\":\"");
                sb2.append(b(jSONObject2.getString(CampaignEx.JSON_KEY_AD_K)));
                sb2.append("\",\"kid\":\"");
                sb2.append(b(jSONObject2.getString("kid")));
                sb2.append("\",\"kty\":\"");
                sb2.append(jSONObject2.getString("kty"));
                sb2.append("\"}");
            }
            sb2.append("]}");
            return xp.c(sb2.toString());
        } catch (JSONException e11) {
            pc.a("ClearKeyUtil", "Failed to adjust response data: " + xp.a(bArr), e11);
            return bArr;
        }
    }
}
