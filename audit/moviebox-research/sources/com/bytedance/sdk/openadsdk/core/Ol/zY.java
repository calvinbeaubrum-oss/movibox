package com.bytedance.sdk.openadsdk.core.Ol;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.ExN;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.hisavana.common.tracking.TrackingKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f28042sc = false;

    public static int ExN() {
        if (Xc.We().QLv()) {
            return pFF.pFF().qr();
        }
        return 6;
    }

    public static String TRI() {
        if (Xc.We().QLv()) {
            return pFF.pFF().We();
        }
        return null;
    }

    public static long We() {
        if (Xc.We().QLv()) {
            return pFF.pFF().TRI();
        }
        return 0L;
    }

    public static void pFF() {
        if (Xc.We().QLv()) {
            pFF.pFF().sc();
        }
    }

    public static void pFF(String str) {
        if (TextUtils.isEmpty(str) || !Xc.We().QLv()) {
            return;
        }
        pFF.pFF().pFF(str);
    }

    public static Map<String, String> sc(String str, String str2) {
        if (Xc.We().QLv()) {
            return pFF.pFF().sc(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return new HashMap();
    }

    public static void sc() {
        if (!f28042sc && Xc.We().QLv()) {
            pFF.pFF();
            f28042sc = pFF.pFF().zY();
        }
    }

    public static void sc(MotionEvent motionEvent) {
        if (Xc.We().QLv()) {
            pFF.pFF().sc(motionEvent);
        }
    }

    public static void sc(Sfl sfl, String str) {
        long jOptLong;
        long jOptLong2;
        long jOptLong3;
        Object obj;
        if (Xc.We().QLv()) {
            HashMap map = new HashMap();
            map.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            map.put("au_show", str);
            if (sfl != null) {
                String strOfL = sfl.ofL();
                String strOptString = "-1";
                if (TextUtils.isEmpty(strOfL)) {
                    map.put(TrackingKey.REQUEST_ID, "-1");
                } else {
                    map.put(TrackingKey.REQUEST_ID, strOfL);
                }
                try {
                    long j11 = -1;
                    if (sfl.jxU() != null) {
                        jOptLong = sfl.jxU().optLong("ad_id", -1L);
                        jOptLong2 = sfl.jxU().optLong("rit", -1L);
                        jOptLong3 = sfl.jxU().optLong("ad_slot_type", -1L);
                        strOptString = sfl.jxU().optString("ad_type", "-1");
                    } else {
                        jOptLong = -1;
                        jOptLong2 = -1;
                        jOptLong3 = -1;
                    }
                    map.put("ad_id", Long.valueOf(jOptLong));
                    map.put("rit", Long.valueOf(jOptLong2));
                    map.put("ad_slot_type", Long.valueOf(jOptLong3));
                    map.put("ad_type", strOptString);
                    Map<String, Object> mapEoh = sfl.eoh();
                    if (mapEoh != null && (obj = mapEoh.get(TTAdConstant.SDK_BIDDING_TYPE)) != null) {
                        j11 = Long.parseLong(obj.toString());
                    }
                    map.put(TTAdConstant.SDK_BIDDING_TYPE, Long.valueOf(j11));
                    pFF.pFF().sc("AdShow", map);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void sc(String str) {
        if (TextUtils.isEmpty(str) && Xc.We().QLv()) {
            pFF.pFF().sc(str);
        }
    }

    public static void sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (!Xc.We().QLv()) {
                jSONObject.put("pglx", PrepareException.ERROR_NO_URL);
                return;
            }
            sc();
            if (ExN() != 0) {
                jSONObject.put("pglx", String.valueOf(ExN()));
                return;
            }
            jSONObject.put("sec_did", pFF.pFF().We());
            String strSc = ExN.sc(jSONObject.toString());
            Map<String, String> mapSc = pFF.pFF().sc("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", strSc != null ? strSc.getBytes() : new byte[0]);
            if (mapSc == null || mapSc.size() <= 0) {
                jSONObject.put("pglx", PrepareException.ERROR_MANIFEST_INFO);
            } else {
                for (String str : mapSc.keySet()) {
                    jSONObject.put(str, mapSc.get(str));
                }
                jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                jSONObject.put("pangle_m", strSc);
            }
            jSONObject.put("ec", pFF.pFF().TRI());
        } catch (Throwable th2) {
            Tf.sc("SecSdkHelperUtil", th2.getMessage());
            try {
                jSONObject.put("pglx", "7");
            } catch (JSONException unused) {
            }
        }
    }

    public static String zY() {
        return Xc.We().QLv() ? pFF.pFF().ExN() : "";
    }
}
