package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    public boolean ExN;
    public boolean TRI;
    public boolean We;
    public String zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final qr f28520sc = new qr(null);
    public static String pFF = "";

    public qr(String str) {
        this.zY = "https://sf19-static.i18n-pglstatp.com/obj/ad-pattern-sg/3p_monitor.9db44671.js";
        this.We = true;
        this.ExN = true;
        this.TRI = true;
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("performance_js");
            String strOptString = jSONObjectOptJSONObject.optString("url", "https://sf19-static.i18n-pglstatp.com/obj/ad-pattern-sg/3p_monitor.9db44671.js");
            if (!TextUtils.isEmpty(strOptString)) {
                this.zY = strOptString;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("execute_time");
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i11));
            }
            this.We = arrayList.contains("load_finish");
            this.TRI = arrayList.contains("load_fail");
            this.ExN = arrayList.contains("load");
        } catch (Exception unused) {
        }
    }
}
