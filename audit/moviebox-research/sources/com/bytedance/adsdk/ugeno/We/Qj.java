package com.bytedance.adsdk.ugeno.We;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    public static pFF.sc sc(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        pFF.sc scVar = new pFF.sc();
        Uri uri = Uri.parse(com.bytedance.adsdk.ugeno.zY.pFF.sc(str, jSONObject));
        if (uri == null) {
            return null;
        }
        if (!TextUtils.isEmpty(uri.getScheme())) {
            scVar.sc(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        scVar.pFF(authority);
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.bytedance.adsdk.ugeno.zY.pFF.sc(uri.getQueryParameter(str2), jSONObject));
            }
        }
        scVar.sc(map);
        return scVar;
    }
}
