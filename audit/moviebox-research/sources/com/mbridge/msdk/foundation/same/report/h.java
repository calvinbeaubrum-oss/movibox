package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import android.util.Log;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements com.mbridge.msdk.e.d {
    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        int i11 = 0;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            i11++;
            if (i11 <= jSONObject.length() - 1) {
                sb2.append(next);
                sb2.append("=");
                sb2.append(a(String.valueOf(jSONObject.opt(next))));
                sb2.append("&");
            } else {
                sb2.append(next);
                sb2.append("=");
                sb2.append(a(String.valueOf(jSONObject.opt(next))));
            }
        }
        return sb2.toString();
    }

    private static StringBuilder a(List<com.mbridge.msdk.e.i> list) {
        com.mbridge.msdk.e.e eVarC;
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            com.mbridge.msdk.e.i iVar = list.get(i11);
            if (iVar != null && (eVarC = iVar.c()) != null) {
                JSONObject jSONObjectD = eVarC.d();
                g.a(jSONObjectD);
                if (jSONObjectD == null) {
                    jSONObjectD = new JSONObject();
                }
                try {
                    try {
                        jSONObjectD.put("ts", eVarC.f());
                        int iD = iVar.d() - 1;
                        if (iD >= 1) {
                            jSONObjectD.put("retryed", iD);
                        }
                        long jG = eVarC.g();
                        if (jG > 0) {
                            jSONObjectD.put("duration", jG);
                        }
                    } catch (Exception e11) {
                        if (com.mbridge.msdk.e.a.f43738a) {
                            Log.e("TrackManager", "decorateRequestParams: ", e11);
                        }
                    }
                    sb2.append(a(jSONObjectD));
                    if (i11 < list.size() - 1) {
                        sb2.append("\n");
                    }
                } catch (Throwable th2) {
                    sb2.append(a(jSONObjectD));
                    throw th2;
                }
            }
        }
        return sb2;
    }

    @Override // com.mbridge.msdk.e.d
    public final Map<String, String> a(com.mbridge.msdk.e.m mVar, List<com.mbridge.msdk.e.i> list, JSONObject jSONObject) {
        HashMap map;
        if (list != null && list.size() != 0) {
            g.a(jSONObject);
            if (jSONObject == null) {
                map = null;
            } else {
                map = new HashMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, String.valueOf(jSONObject.opt(next)));
                }
            }
            if (map == null) {
                map = new HashMap();
            }
            try {
                map.put("data", a(list).toString());
                return map;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
