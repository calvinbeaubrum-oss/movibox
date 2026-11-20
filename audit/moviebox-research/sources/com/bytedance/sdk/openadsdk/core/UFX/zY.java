package com.bytedance.sdk.openadsdk.core.UFX;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Tf;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.google.android.gms.common.internal.ImagesContract;
import com.hisavana.common.tracking.TrackingKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f28309sc = "";

    public static boolean pFF(Sfl sfl) {
        return sfl != null && sfl.cvk() == 10;
    }

    public static String sc() {
        return f28309sc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public static JSONObject sc(Sfl sfl, com.bytedance.sdk.openadsdk.core.UFX.ExN.zY zYVar) {
        zYVar.sc("ad");
        String strXc = "";
        f28309sc = "";
        ?? r11 = 0;
        try {
            Sfl.sc scVarJoC = sfl.JoC();
            if (scVarJoC != null) {
                strXc = scVarJoC.Xc();
                if (TextUtils.isEmpty(strXc) && !TextUtils.isEmpty(scVarJoC.dE()) && !TextUtils.isEmpty(scVarJoC.TRI())) {
                    strXc = com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc("ad", scVarJoC.TRI(), scVarJoC.dE());
                }
            }
            try {
                if (TextUtils.isEmpty(strXc)) {
                    String str = "local data is null id is " + scVarJoC.TRI() + " md5 is " + scVarJoC.dE();
                    f28309sc = str;
                    zYVar.sc(3, str, "net");
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(strXc);
                    try {
                        f28309sc = "getTemplate success";
                        zYVar.pFF(ImagesContract.LOCAL);
                        return jSONObject;
                    } catch (JSONException unused) {
                        String strConcat = "parse json exception data is ".concat(String.valueOf(strXc));
                        f28309sc = strConcat;
                        zYVar.sc(2, strConcat, ImagesContract.LOCAL);
                        return null;
                    }
                } catch (JSONException unused2) {
                }
            } catch (Throwable th2) {
                r11 = scVarJoC;
                th = th2;
                String str2 = "get template error " + th.getMessage();
                f28309sc = str2;
                zYVar.sc(2, str2, ImagesContract.LOCAL);
                return r11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static JSONObject sc(Sfl sfl, String str) {
        JSONObject jSONObjectJP = sfl.JP();
        try {
            jSONObjectJP.put("show_dislike", sfl.vYl());
            jSONObjectJP.put("language", Tf.pFF());
            if ("open_ad".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                String strTRI = Ol.pFF().TRI();
                int iQr = Ol.pFF().qr();
                jSONObject.put("app_name", strTRI);
                jSONObject.put("app_icon_id", "@".concat(String.valueOf(iQr)));
                jSONObjectJP.put("open_app_info", jSONObject);
            }
            jSONObjectJP.put("os", "Android");
            JSONArray jSONArrayZY = zY(sfl);
            if (jSONArrayZY != null) {
                jSONObjectJP.put("dpa_data", jSONArrayZY);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("UgenUtils", "parseUGenDataInfo exception", th2.getMessage());
        }
        return jSONObjectJP;
    }

    public static boolean sc(int i11) {
        return i11 == 10 || i11 == 9;
    }

    public static boolean sc(Sfl sfl) {
        return sfl != null && sfl.cvk() == 7;
    }

    private static JSONArray zY(Sfl sfl) {
        try {
            Sfl.sc scVarJoC = sfl.JoC();
            if (scVarJoC == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(scVarJoC.UFX());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("original_price", Double.valueOf(jSONObject.optDouble("original_price", 0.0d)));
            jSONObject2.putOpt("price_unit", jSONObject.optString("price_unit"));
            jSONObject2.putOpt("discount", Double.valueOf(jSONObject.optDouble("discount", 0.0d)));
            jSONObject2.putOpt("product_name", jSONObject.optString("dpa_product_name"));
            jSONObject2.putOpt(TrackingKey.DESCRIPTION, jSONObject.optString("dpa_description"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dpa_images");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                jSONObject2.putOpt("image", jSONArrayOptJSONArray.get(0));
            }
            jSONObject2.putOpt("brand_name", jSONObject.optString("dpa_brand_name"));
            jSONObject2.putOpt("sale_price_i18n", Integer.valueOf(jSONObject.optInt("sale_price_i18n")));
            jSONObject2.putOpt("real_price", Double.valueOf(jSONObject.optDouble("real_price", 0.0d)));
            jSONObject2.put("button_text", sfl.NQ());
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("dpa_related_products");
            if (jSONArrayOptJSONArray2 != null) {
                jSONArray.put(jSONObject2);
                for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                    try {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i11);
                        jSONObject3.put("button_text", sfl.NQ());
                        jSONArray.put(jSONObject3);
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
