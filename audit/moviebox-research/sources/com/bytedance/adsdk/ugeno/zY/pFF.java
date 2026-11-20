package com.bytedance.adsdk.ugeno.zY;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.We;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    public static String sc(String str, JSONObject jSONObject) {
        sc scVarZY;
        sc.InterfaceC0239sc interfaceC0239scSc;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (scVarZY = We.sc().zY()) == null || (interfaceC0239scSc = scVarZY.sc(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0239scSc.sc(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return str;
    }
}
