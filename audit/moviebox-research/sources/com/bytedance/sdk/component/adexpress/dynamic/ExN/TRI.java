package com.bytedance.sdk.component.adexpress.dynamic.ExN;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static HashMap<String, String> f26736qr;
    private zY ExN;
    private com.bytedance.sdk.component.adexpress.dynamic.We.We TRI;
    private sc We;
    private JSONObject pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private JSONObject f26737sc;
    private com.bytedance.sdk.component.adexpress.dynamic.We.zY zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        float pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        float f26738sc;
        boolean zY;

        public static sc sc(JSONObject jSONObject) {
            sc scVar = new sc();
            if (jSONObject != null) {
                scVar.f26738sc = (float) jSONObject.optDouble("width");
                scVar.pFF = (float) jSONObject.optDouble("height");
                scVar.zY = jSONObject.optBoolean("isLandscape");
            }
            return scVar;
        }
    }

    static {
        HashMap<String, String> map = new HashMap<>();
        f26736qr = map;
        map.put("subtitle", TrackingKey.DESCRIPTION);
        f26736qr.put("source", "source|app.app_name");
        f26736qr.put("screenshot", "dynamic_creative.screenshot");
    }

    public TRI(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.f26737sc = jSONObject;
        this.pFF = jSONObject2;
        this.zY = new com.bytedance.sdk.component.adexpress.dynamic.We.zY(jSONObject2);
        this.We = sc.sc(jSONObject3);
        this.TRI = com.bytedance.sdk.component.adexpress.dynamic.We.We.sc(jSONObject4);
    }

    private void pFF(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        com.bytedance.sdk.component.adexpress.dynamic.We.zY zYVar;
        Object objSc;
        Object objSc2;
        Object objSc3;
        Object objSc4;
        if (qj2 == null || (zYVar = this.zY) == null || (objSc = zYVar.sc("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objSc);
        if (TextUtils.isEmpty(strValueOf) || (objSc2 = this.zY.sc(CampaignEx.JSON_KEY_TITLE)) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objSc2);
        if (TextUtils.isEmpty(strValueOf2) || (objSc3 = this.zY.sc(TrackingKey.DESCRIPTION)) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objSc3);
        if (TextUtils.isEmpty(strValueOf3) || (objSc4 = this.zY.sc(RewardPlus.ICON)) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objSc4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objSc5 = this.zY.sc("app.app_name");
        Object objSc6 = this.zY.sc("source");
        if (objSc5 == null && objSc6 == null) {
            return;
        }
        if (objSc5 == null) {
            objSc5 = objSc6;
        }
        String strValueOf5 = String.valueOf(objSc5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        qj2.sc("imageUrl", strValueOf);
        qj2.sc(CampaignEx.JSON_KEY_TITLE, strValueOf2);
        qj2.sc(TrackingKey.DESCRIPTION, strValueOf3);
        qj2.sc(RewardPlus.ICON, strValueOf4);
        qj2.sc("app_name", strValueOf5);
        qj2.sc(true);
    }

    private String sc() {
        com.bytedance.sdk.component.adexpress.dynamic.We.zY zYVar = this.zY;
        return zYVar == null ? "" : String.valueOf(zYVar.sc("adx_name"));
    }

    private String sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.zY.pFF(str2)) {
                String strValueOf = String.valueOf(this.zY.sc(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private void sc(com.bytedance.sdk.component.adexpress.dynamic.We.ExN exN, int i11) {
        int iLastIndexOf;
        if (i11 == 5 || i11 == 15 || i11 == 50 || i11 == 154) {
            exN.sc("video");
            String strSc = Ol.sc("video");
            exN.ExN().YIK(strSc);
            String strSc2 = Ol.sc("video", "clickArea");
            if (!TextUtils.isEmpty(strSc2)) {
                exN.ExN().BT(strSc2);
                exN.qr().BT(strSc2);
            }
            exN.qr().YIK(strSc);
            exN.pFF(strSc);
            exN.ExN().EZl();
            return;
        }
        exN.sc("image");
        String strSc3 = Ol.sc("image");
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = exN.ExN();
        triExN.YIK(strSc3);
        exN.qr().YIK(strSc3);
        String strSc4 = Ol.sc("image", "clickArea");
        if (!TextUtils.isEmpty(strSc4)) {
            triExN.BT(strSc4);
            exN.qr().BT(strSc4);
        }
        JSONObject jSONObjectBZj = triExN.bZj();
        if (jSONObjectBZj != null) {
            triExN.JPJ(jSONObjectBZj.optString("imageLottieTosPath"));
            triExN.Tf(jSONObjectBZj.optBoolean("animationsLoop"));
            triExN.cvk(jSONObjectBZj.optInt("lottieAppNameMaxLength"));
            triExN.McK(jSONObjectBZj.optInt("lottieAdDescMaxLength"));
            triExN.II(jSONObjectBZj.optInt("lottieAdTitleMaxLength"));
        }
        exN.pFF(strSc3);
        if (strSc3 != null && (iLastIndexOf = strSc3.lastIndexOf(InstructionFileId.DOT)) > 0) {
            String strSubstring = strSc3.substring(0, iLastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", sc(strSubstring + ".width"));
                jSONObject.put("height", sc(strSubstring + ".height"));
            } catch (JSONException unused) {
            }
            exN.zY(jSONObject.toString());
        }
        triExN.lD();
    }

    private void sc(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        if (qj2 == null) {
            return;
        }
        int iPFF = com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() != null ? com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().BT() : com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc()));
        sc scVar = this.We;
        float fMin = scVar.zY ? scVar.f26738sc : Math.min(scVar.f26738sc, iPFF);
        if (this.We.pFF == 0.0f) {
            qj2.ExN(fMin);
            qj2.WH().ExN().WH("auto");
            qj2.TRI(0.0f);
        } else {
            qj2.ExN(fMin);
            int iPFF2 = com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc(), com.bytedance.sdk.component.adexpress.We.Qj.pFF(com.bytedance.sdk.component.adexpress.We.sc()));
            sc scVar2 = this.We;
            qj2.TRI(scVar2.zY ? scVar2.pFF : Math.min(scVar2.pFF, iPFF2));
            qj2.WH().ExN().WH("fixed");
        }
    }

    private void sc(com.bytedance.sdk.component.adexpress.dynamic.We.TRI tri) {
        if (tri == null) {
            return;
        }
        String strHJN = tri.HJN();
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            String strZY = com.bytedance.sdk.component.adexpress.We.Qj.zY(com.bytedance.sdk.component.adexpress.We.sc());
            if ("zh".equals(strZY)) {
                strZY = "cn";
            }
            if (!TextUtils.isEmpty(strZY) && tri.TRI() != null) {
                String strOptString = tri.TRI().optString(strZY);
                if (!TextUtils.isEmpty(strOptString)) {
                    strHJN = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strHJN)) {
            return;
        }
        int iIndexOf = strHJN.indexOf("{{");
        int iIndexOf2 = strHJN.indexOf("}}");
        if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf2 < iIndexOf) {
            tri.Tf(strHJN);
            return;
        }
        String strSc = sc(strHJN.substring(iIndexOf + 2, iIndexOf2));
        StringBuilder sb2 = new StringBuilder(strHJN.substring(0, iIndexOf));
        if (!TextUtils.isEmpty(strSc)) {
            sb2.append(strSc);
        }
        sb2.append(strHJN.substring(iIndexOf2 + 2));
        tri.Tf(sb2.toString());
    }

    public com.bytedance.sdk.component.adexpress.dynamic.We.Qj sc(double d11, int i11, double d12, String str, Ql ql2) {
        JSONObject jSONObject;
        this.zY.sc();
        try {
            jSONObject = new JSONObject(this.TRI.pFF);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qjSc = sc(We.sc(this.f26737sc, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.We.Qj) null);
        sc(qjSc);
        ExN exN = new ExN(d11, i11, d12, str, ql2);
        ExN.sc scVar = new ExN.sc();
        sc scVar2 = this.We;
        scVar.f26735sc = scVar2.f26738sc;
        scVar.pFF = scVar2.pFF;
        scVar.zY = 0.0f;
        exN.sc(scVar);
        exN.sc(qjSc, 0.0f, 0.0f);
        exN.sc();
        com.bytedance.sdk.component.adexpress.dynamic.We.pFF pff = exN.f26734sc;
        if (pff.We == 65536.0f) {
            return null;
        }
        return pff.TRI;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.We.Qj sc(JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        Ol.sc(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectSc = Ol.sc(strOptString, Ol.sc(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2 = new com.bytedance.sdk.component.adexpress.dynamic.We.Qj();
        if (TextUtils.isEmpty(strOptString2)) {
            qj2.pFF(String.valueOf(qj2.hashCode()));
        } else {
            qj2.pFF(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            pFF(qj2);
            qj2.zY((float) jSONObjectOptJSONObject.optDouble("x"));
            qj2.We((float) jSONObjectOptJSONObject.optDouble("y"));
            qj2.ExN((float) jSONObjectOptJSONObject.optDouble("width"));
            qj2.TRI((float) jSONObjectOptJSONObject.optDouble("height"));
            qj2.qr(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.We.ExN exN = new com.bytedance.sdk.component.adexpress.dynamic.We.ExN();
            exN.sc(strOptString);
            exN.pFF(jSONObjectOptJSONObject.optString("data"));
            exN.zY(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.We.TRI triSc = com.bytedance.sdk.component.adexpress.dynamic.We.TRI.sc(jSONObjectOptJSONObject);
            exN.sc(triSc);
            com.bytedance.sdk.component.adexpress.dynamic.We.TRI triSc2 = com.bytedance.sdk.component.adexpress.dynamic.We.TRI.sc(jSONObjectSc);
            if (triSc2 == null) {
                exN.pFF(triSc);
            } else {
                exN.pFF(triSc2);
            }
            sc(triSc);
            sc(triSc2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.pFF) != null) {
                sc(exN, jSONObject2.optInt("image_mode"));
            }
            String strPFF = exN.pFF();
            com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN = exN.ExN();
            if (f26736qr.containsKey(strPFF) && !triExN.ko()) {
                triExN.YIK(f26736qr.get(strPFF));
            }
            String strZY = triExN.ko() ? exN.zY() : sc(exN.zY());
            if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                if (TextUtils.equals(strPFF, "star") || TextUtils.equals(strPFF, "text_star")) {
                    strZY = sc("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(strPFF, "score-count") || TextUtils.equals(strPFF, "score-count-type-1") || TextUtils.equals(strPFF, "score-count-type-2")) {
                    strZY = sc("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(strPFF) && triSc.ag()) {
                    strZY = sc("image.0.url");
                }
            }
            if (TextUtils.isEmpty(sc()) || !(TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                exN.pFF(strZY);
            } else {
                exN.pFF(strZY + "adx:" + sc());
            }
            qj2.sc(exN);
        }
        return qj2;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.We.Qj sc(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.TRI != null) {
                zY zYVar = new zY();
                this.ExN = zYVar;
                JSONObject jSONObjectSc = zYVar.sc(this.TRI.f26766sc, iOptInt, jSONObject);
                if (jSONObjectSc != null) {
                    jSONObject = jSONObjectSc;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qjSc = sc(jSONObject);
        qjSc.sc(qj2);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            qjSc.sc((List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>) null);
            return qjSc;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i11);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                int iNP = TextUtils.equals(strOptString, "tag-group") ? qjSc.WH().ExN().NP() : jSONArrayOptJSONArray2.length();
                for (int i12 = 0; i12 < iNP; i12++) {
                    com.bytedance.sdk.component.adexpress.dynamic.We.Qj qjSc2 = sc(jSONArrayOptJSONArray2.optJSONObject(i12), qjSc);
                    if (com.bytedance.sdk.component.adexpress.We.pFF() && "skip-with-time".equals(qjSc.WH().pFF()) && !"transparent".equals(qjSc.JPJ()) && !TextUtils.isEmpty(qjSc.JPJ())) {
                        qjSc2.zY(qjSc.JPJ());
                    }
                    arrayList.add(qjSc2);
                    arrayList3.add(qjSc2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            qjSc.sc(arrayList);
        }
        if (arrayList2.size() > 0) {
            qjSc.pFF(arrayList2);
        }
        return qjSc;
    }
}
