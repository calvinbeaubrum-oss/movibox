package com.bytedance.sdk.component.qr.zY;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {
    private static final Object We = new Object();
    private int ExN;
    private We pFF = new We();

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26980sc;
    private boolean zY;

    public ExN(Context context, boolean z11, int i11) {
        this.f26980sc = context;
        this.zY = z11;
        this.ExN = i11;
    }

    private We pFF(JSONObject jSONObject) {
        try {
            We we2 = new We();
            if (jSONObject.has("local_enable")) {
                we2.f26986sc = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                we2.pFF = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        String string = jSONArray.getString(i11);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                we2.zY = map;
            } else {
                we2.zY = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                we2.We = map2;
            } else {
                we2.We = null;
            }
            we2.ExN = jSONObject.optInt("req_to_cnt", we2.ExN);
            we2.TRI = jSONObject.optInt("req_to_api_cnt", we2.TRI);
            we2.f26985qr = jSONObject.optInt("req_to_ip_cnt", we2.f26985qr);
            we2.Qj = jSONObject.optInt("req_err_cnt", we2.Qj);
            we2.Ol = jSONObject.optInt("req_err_api_cnt", we2.Ol);
            we2.WH = jSONObject.optInt("req_err_ip_cnt", we2.WH);
            we2.UFX = jSONObject.optInt("update_interval", we2.UFX);
            we2.Tf = jSONObject.optInt("update_random_range", we2.Tf);
            we2.Ql = jSONObject.optString("http_code_black", we2.Ql);
            return we2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void pFF() {
        try {
            String strSc = com.bytedance.sdk.component.qr.We.We.sc(this.f26980sc, 1, this.ExN);
            if (TextUtils.isEmpty(strSc)) {
                return;
            }
            We wePFF = pFF(new JSONObject(strSc));
            if (wePFF != null) {
                wePFF.toString();
            }
            if (wePFF != null) {
                this.pFF = wePFF;
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public void sc() {
        if (this.zY) {
            String string = this.f26980sc.getSharedPreferences(Qj.sc().sc(this.ExN).sc(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                We wePFF = pFF(new JSONObject(string));
                if (wePFF != null) {
                    this.pFF = wePFF;
                }
                if (wePFF == null) {
                    return;
                }
                wePFF.toString();
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:84:0x016e A[EXC_TOP_SPLITTER, FINALLY_INSNS, SYNTHETIC] */
    public void sc(JSONObject jSONObject) {
        Object obj;
        JSONObject jSONObject2;
        if (this.zY) {
            Qj.sc().sc(this.ExN).ExN();
            try {
                try {
                    boolean z11 = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
                    if (Qj.sc().sc(this.ExN).zY() && z11 && jSONArrayOptJSONArray != null) {
                        ArrayList<JSONObject> arrayList = new ArrayList();
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                            JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i11)).getJSONObject("param");
                            if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                                arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                            }
                        }
                        if (arrayList.isEmpty()) {
                            jSONObject2 = null;
                        } else {
                            jSONObject2 = new JSONObject();
                            for (JSONObject jSONObject4 : arrayList) {
                                Iterator<String> itKeys = jSONObject4.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    jSONObject2.put(next, jSONObject4.getString(next));
                                }
                            }
                        }
                    } else {
                        jSONObject2 = null;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
                    if (jSONObjectOptJSONObject != null || jSONObject2 != null) {
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                            jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                        } else if (jSONObject2 != null) {
                            jSONObjectOptJSONObject.put("host_replace_map", jSONObject2);
                        }
                    }
                    We wePFF = pFF(jSONObjectOptJSONObject);
                    if (wePFF != null) {
                        wePFF.toString();
                    }
                    if (wePFF == null) {
                        synchronized (We) {
                            this.f26980sc.getSharedPreferences(Qj.sc().sc(this.ExN).sc(), 0).edit().putString("tnc_config_str", "").apply();
                            com.bytedance.sdk.component.qr.We.We.sc(this.f26980sc, 1, "", this.ExN);
                        }
                        return;
                    } else {
                        this.pFF = wePFF;
                        String string = jSONObjectOptJSONObject.toString();
                        synchronized (We) {
                            this.f26980sc.getSharedPreferences(Qj.sc().sc(this.ExN).sc(), 0).edit().putString("tnc_config_str", string).apply();
                            com.bytedance.sdk.component.qr.We.We.sc(this.f26980sc, 1, string, this.ExN);
                        }
                        return;
                    }
                } catch (Throwable unused) {
                    this.pFF = new We();
                    synchronized (obj) {
                        return;
                    }
                }
            } finally {
                synchronized (We) {
                    this.f26980sc.getSharedPreferences(Qj.sc().sc(this.ExN).sc(), 0).edit().putString("tnc_config_str", "").apply();
                    com.bytedance.sdk.component.qr.We.We.sc(this.f26980sc, 1, "", this.ExN);
                }
            }
            synchronized (We) {
                this.f26980sc.getSharedPreferences(Qj.sc().sc(this.ExN).sc(), 0).edit().putString("tnc_config_str", "").apply();
                com.bytedance.sdk.component.qr.We.We.sc(this.f26980sc, 1, "", this.ExN);
            }
        }
    }

    public We zY() {
        return this.pFF;
    }
}
