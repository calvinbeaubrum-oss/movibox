package com.bytedance.adsdk.ugeno.core;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {
    private String ExN;
    private JSONObject TRI;
    private JSONObject We;
    private JSONObject pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f26385qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private JSONObject f26386sc;
    private String zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private List<sc> ExN;
        private String Qj;
        private sc TRI;
        private JSONObject We;
        private String pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private String f26387qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f26388sc;
        private JSONObject zY;

        public List<sc> ExN() {
            return this.ExN;
        }

        public JSONObject TRI() {
            return this.We;
        }

        public JSONObject We() {
            return this.zY;
        }

        public String pFF() {
            return this.f26387qr;
        }

        public String sc() {
            return this.f26388sc;
        }

        public void sc(sc scVar) {
            if (this.ExN == null) {
                this.ExN = new ArrayList();
            }
            this.ExN.add(scVar);
        }

        public void sc(String str) {
            this.pFF = str;
        }

        public String toString() {
            return "UGNode{id='" + this.f26388sc + "', name='" + this.pFF + "'}";
        }

        public String zY() {
            return this.pFF;
        }
    }

    public ExN(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public ExN(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.f26386sc = jSONObject.optJSONObject(TtmlNode.TAG_BODY);
            } else {
                this.f26386sc = jSONObject.optJSONObject("main_template");
            }
            this.pFF = jSONObject.optJSONObject("sub_templates");
            JSONObject jSONObjectOptJSONObject = jSONObject.has("meta") ? jSONObject.optJSONObject("meta") : jSONObject.optJSONObject("template_info");
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has(TtmlNode.TAG_BODY)) {
                    this.f26385qr = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.zY = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.zY = "3.0";
                    }
                } else {
                    this.zY = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.ExN = jSONObjectOptJSONObject.optString("adType");
                }
            } else if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.zY = "3.0";
                this.f26385qr = true;
            }
            this.We = jSONObject2;
            this.TRI = jSONObject3;
        }
    }

    private sc sc(JSONObject jSONObject, sc scVar) {
        sc scVarSc;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.has("type") ? jSONObject.optString("type") : jSONObject.optString("name");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        sc scVar2 = new sc();
        scVar2.f26388sc = strOptString2;
        if (this.f26385qr && TextUtils.equals("Video", strOptString)) {
            scVar2.pFF = strOptString + "V3";
        } else {
            scVar2.pFF = strOptString;
        }
        scVar2.zY = jSONObject2;
        scVar2.TRI = scVar;
        scVar2.f26387qr = this.zY;
        scVar2.Qj = this.ExN;
        if (jSONObject2.has("i18n")) {
            scVar2.We = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            sc(jSONObject, scVar2.zY);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                String strOptString3 = jSONObject.has("type") ? jSONObject.optString("type") : jSONObject.optString("name");
                String strSc = com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObjectOptJSONObject.optString("id"), this.We);
                if (TextUtils.equals(strOptString3, "Template")) {
                    JSONObject jSONObject3 = this.pFF;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strSc);
                        scVarSc = sc(jSONObjectOptJSONObject, scVar2);
                    } else {
                        scVarSc = null;
                    }
                } else {
                    scVarSc = sc(jSONObjectOptJSONObject, scVar2);
                }
                if (scVarSc != null) {
                    scVar2.sc(scVarSc);
                }
            }
        }
        return scVar2;
    }

    private void sc(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.TRI == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.TRI.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (!TextUtils.equals(next, "events") || !jSONObject3.has("events")) {
                        jSONObject3.put(next, objOpt);
                    } else if (objOpt instanceof JSONArray) {
                        com.bytedance.adsdk.ugeno.qr.pFF.sc(jSONObject3.optJSONArray("events"), (JSONArray) objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean sc(sc scVar) {
        return (scVar == null || scVar.zY == null) ? false : true;
    }

    public boolean We() {
        return this.f26385qr;
    }

    public String pFF() {
        return this.zY;
    }

    public sc sc() {
        return sc(this.f26386sc, (sc) null);
    }

    public List<sc> zY() {
        if (this.pFF == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.pFF.keys();
        while (itKeys.hasNext()) {
            sc scVarSc = sc(this.pFF.optJSONObject(itKeys.next()), (sc) null);
            if (scVarSc != null) {
                arrayList.add(scVarSc);
            }
        }
        return arrayList;
    }
}
