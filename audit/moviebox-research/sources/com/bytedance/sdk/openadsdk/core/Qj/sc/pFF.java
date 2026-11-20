package com.bytedance.sdk.openadsdk.core.Qj.sc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Tf;
import com.bytedance.sdk.openadsdk.core.UFX.ExN.zY;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.YIK;
import com.bytedance.sdk.openadsdk.core.model.cvk;
import com.bytedance.sdk.openadsdk.core.model.dE;
import com.google.android.gms.common.internal.ImagesContract;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private static String pFF = "";

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static String f28096sc = "https://pag_open_icon_id/appicon.png";

    private static String pFF(Sfl.sc scVar) {
        com.bytedance.sdk.component.adexpress.sc.zY.pFF pffZY;
        if (scVar == null) {
            return "";
        }
        String strOl = scVar.Ol();
        return (!TextUtils.isEmpty(strOl) || (pffZY = com.bytedance.sdk.component.adexpress.sc.pFF.pFF.zY(scVar.TRI())) == null) ? strOl : pffZY.ExN();
    }

    private static JSONObject pFF(Sfl sfl) {
        JSONObject jSONObject = new JSONObject();
        try {
            HJN.sc(jSONObject, sfl);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static boolean pFF() {
        return true;
    }

    public static String sc() {
        return pFF;
    }

    private static String sc(Sfl.sc scVar) {
        return scVar != null ? scVar.WH() : "";
    }

    public static String sc(Sfl sfl, String str) {
        List<BT> listHt;
        if (sfl != null && (listHt = sfl.ht()) != null && listHt.size() > 0) {
            for (BT bt2 : listHt) {
                if (bt2 != null && TextUtils.equals(str, bt2.sc())) {
                    return bt2.qr();
                }
            }
        }
        return null;
    }

    public static Map<String, String> sc(Sfl sfl) {
        HashMap map = null;
        if (sfl == null) {
            return null;
        }
        List<BT> listHt = sfl.ht();
        if (listHt != null && listHt.size() > 0) {
            map = new HashMap();
            for (BT bt2 : listHt) {
                if (bt2 != null) {
                    map.put(bt2.sc(), bt2.qr());
                }
            }
            BT btQfG = sfl.qfG();
            if (btQfG != null) {
                map.put(btQfG.sc(), btQfG.qr());
            }
        }
        return map;
    }

    public static JSONObject sc(float f11, float f12, boolean z11, @NonNull Sfl sfl) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TrackingKey.PLATFORM, "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f11);
            jSONObject2.put("height", f12);
            if (z11) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            if (!(sfl instanceof YIK) || !((YIK) sfl).Kv()) {
                jSONObject.put("creative", sc(false, sfl));
                jSONObject.put("template_Plugin", pFF(sfl.JoC()));
                jSONObject.put("diff_template_Plugin", sc(sfl.JoC()));
                return jSONObject;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("choose_ui_data", jSONObject3);
            com.bytedance.sdk.openadsdk.core.model.sc.C0304sc c0304scKyy = ((YIK) sfl).Kyy();
            JSONObject jSONObjectPFF = c0304scKyy.pFF();
            if (TextUtils.isEmpty(c0304scKyy.Ol())) {
                jSONObjectPFF.put("data", pFF(c0304scKyy));
            }
            jSONObject3.put("tpl_info", jSONObjectPFF);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("creatives", jSONArray);
            for (Sfl sfl2 : ((YIK) sfl).oy()) {
                JSONObject jSONObjectSc = sc(false, sfl2);
                if (jSONObjectSc != null) {
                    jSONObjectSc.put("template_Plugin", pFF(sfl2.JoC()));
                    jSONObjectSc.put("diff_template_Plugin", sc(sfl2.JoC()));
                    jSONArray.put(jSONObjectSc);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject sc(float f11, float f12, boolean z11, @NonNull Sfl sfl, String str, zY zYVar) {
        pFF = "";
        JSONObject jSONObjectJP = null;
        if (sfl == null) {
            return null;
        }
        try {
            jSONObjectJP = sfl.JP();
            sc(jSONObjectJP, sfl, str);
            JSONObject jSONObjectPFF = HJN.pFF(sfl);
            jSONObjectPFF.put("language", Tf.pFF());
            jSONObjectJP.put("xSetting", jSONObjectPFF);
            jSONObjectJP.put("xAdInfo", sc(str, pFF(sfl), sfl));
            JSONObject jSONObject = new JSONObject();
            HJN.pFF(jSONObject);
            jSONObject.put(TrackingKey.PLATFORM, "android");
            jSONObjectJP.put("xAppInfo", jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f11);
            jSONObject2.put("height", f12);
            if (z11) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObjectJP.put("xSize", jSONObject2);
            zYVar.sc("adv3");
            cvk cvkVarQKn = sfl.qKn();
            if (cvkVarQKn != null) {
                String strWe = cvkVarQKn.We();
                if (TextUtils.isEmpty(strWe)) {
                    String strSc = com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc("adv3", cvkVarQKn.sc(), cvkVarQKn.pFF());
                    if (TextUtils.isEmpty(strSc)) {
                        String str2 = "local db data is null id is " + cvkVarQKn.sc() + " md5 is " + cvkVarQKn.pFF();
                        pFF = str2;
                        zYVar.sc(3, str2, "net");
                    } else {
                        jSONObjectJP.put("xTemplate", new JSONObject(strSc));
                        pFF = "getTemplate success by db data";
                        zYVar.pFF(ImagesContract.LOCAL);
                    }
                } else {
                    jSONObjectJP.put("xTemplate", new JSONObject(strWe));
                    pFF = "getTemplate success by local data";
                    zYVar.pFF(ImagesContract.LOCAL);
                }
            }
        } catch (Exception e11) {
            String str3 = "load template exception " + e11.getMessage();
            pFF = str3;
            zYVar.sc(3, str3, "net");
        }
        return jSONObjectJP;
    }

    private static JSONObject sc(String str, JSONObject jSONObject, Sfl sfl) {
        if (sfl == null) {
            return jSONObject;
        }
        try {
            if ("open_ad".equals(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_name", Ol.pFF().TRI());
                int iQr = Ol.pFF().qr();
                if (iQr != 0) {
                    int iCvk = sfl.cvk();
                    if (9 == iCvk) {
                        jSONObject2.put("app_icon", f28096sc);
                    } else if (10 == iCvk) {
                        jSONObject2.put("app_icon", "@".concat(String.valueOf(iQr)));
                    }
                }
                jSONObject.put("open_app_info", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject sc(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("keys");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i11);
                    if (jSONObject.has(strOptString)) {
                        jSONObject3.put(strOptString, jSONObject.opt(strOptString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject sc(boolean z11, @NonNull Sfl sfl) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", sfl.NQ());
            if (sfl.qfG() != null) {
                if (sfl.qfG() == null || TextUtils.isEmpty(sfl.qfG().sc())) {
                    jSONObject.put(RewardPlus.ICON, "");
                } else {
                    jSONObject.put(RewardPlus.ICON, sfl.qfG().sc());
                }
            }
            JSONArray jSONArray = new JSONArray();
            if (sfl.ht() != null) {
                for (int i11 = 0; i11 < sfl.ht().size(); i11++) {
                    BT bt2 = sfl.ht().get(i11);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", bt2.zY());
                    jSONObject2.put("width", bt2.pFF());
                    jSONObject2.put("url", bt2.sc());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", sfl.dix());
            jSONObject.put("interaction_type", sfl.QLv());
            jSONObject.put("interaction_method", sfl.wjp());
            jSONObject.put("is_compliance_template", pFF());
            jSONObject.put(CampaignEx.JSON_KEY_TITLE, sfl.YdT());
            jSONObject.put(TrackingKey.DESCRIPTION, sfl.bSP());
            jSONObject.put("source", sfl.MxZ());
            JSONObject jSONObject3 = new JSONObject();
            dE dEVarWH = sfl.WH();
            if (dEVarWH == null) {
                dEVarWH = new dE();
            }
            jSONObject3.put("ceiling_time", dEVarWH.sc());
            jSONObject3.put("ceiling_ratio", dEVarWH.pFF());
            jSONObject3.put("expand_ratio", dEVarWH.zY());
            jSONObject.put("interaction_params", jSONObject3);
            if (sfl.NP() != null) {
                jSONObject.put("comment_num", sfl.NP().ExN());
                jSONObject.put("score", sfl.NP().We());
                jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, sfl.NP().TRI());
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, sfl.NP().Qj());
            }
            a aVarGI = sfl.GI();
            if (aVarGI != null) {
                JSONObject jSONObjectK = aVarGI.K();
                jSONObjectK.put("video_duration", aVarGI.m() * ((double) aVarGI.J()));
                jSONObject.put("video", jSONObjectK);
            }
            if (sfl.JoC() != null) {
                jSONObject.put("dynamic_creative", sfl.JoC().UFX());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void sc(JSONObject jSONObject, Sfl sfl, String str) {
        a aVarGI;
        if (sfl == null || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("h265_video")) {
                jSONObject.remove("h265_video");
            }
            if (!jSONObject.has("video") || (aVarGI = sfl.GI()) == null) {
                return;
            }
            JSONObject jSONObjectK = aVarGI.K();
            if (jSONObjectK != null) {
                if ("open_ad".equals(str)) {
                    jSONObjectK.put("video_duration", Xc.We().JPJ(String.valueOf(sfl.QT())));
                } else {
                    jSONObjectK.put("video_duration", aVarGI.m() * ((double) aVarGI.J()));
                }
            }
            jSONObject.put("video", jSONObjectK);
        } catch (Exception e11) {
            e11.getMessage();
        }
    }
}
