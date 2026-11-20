package com.bytedance.sdk.openadsdk.We.sc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.II;
import com.bytedance.sdk.openadsdk.utils.WP;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.bytedance.sdk.openadsdk.utils.uEA;
import com.cloud.config.utils.CommonUtils;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private final String ExN;
    private final boolean We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f27412sc;
    private final Context zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final zY f27413sc = new zY();
    }

    private zY() {
        this.We = zY();
        this.zY = Xc.sc().getApplicationContext();
        this.ExN = ExN();
    }

    private String ExN() {
        if (DeviceUtils.zY(this.zY)) {
            return "tv";
        }
        return DeviceUtils.pFF(this.zY) ? "android_pad" : "android";
    }

    @JProtect
    private String TRI() {
        StringBuilder sb2 = new StringBuilder();
        try {
            if (WP.ExN()) {
                sb2.append("MIUI-");
            } else if (WP.pFF()) {
                sb2.append("FLYME-");
            } else {
                String strSR = WP.SR();
                if (WP.sc(strSR)) {
                    sb2.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strSR)) {
                    sb2.append(strSR);
                    sb2.append("-");
                }
            }
            sb2.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb2.toString();
    }

    private int We() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static zY sc() {
        return sc.f27413sc;
    }

    private String sc(int i11) {
        if (i11 == 120) {
            return "ldpi";
        }
        if (i11 == 160) {
            return "mdpi";
        }
        if (i11 == 240) {
            return "hdpi";
        }
        if (i11 == 320) {
            return "xhdpi";
        }
        if (i11 != 480) {
            return i11 != 640 ? "mdpi" : "xxxhdpi";
        }
        return "xxhdpi";
    }

    private String sc(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private void sc(com.bytedance.sdk.openadsdk.We.sc scVar, boolean z11) {
        if (scVar == null) {
            return;
        }
        try {
            String strOptString = z11 ? scVar.zY().optJSONObject("params").optString("log_extra", "") : scVar.zY().optString("log_extra", "");
            long jSc = Sfl.sc(strOptString);
            int iWe = Sfl.We(strOptString);
            if (jSc == 0) {
                jSc = this.f27412sc;
            }
            this.f27412sc = jSc;
            if (iWe == 0) {
                iWe = this.pFF;
            }
            this.pFF = iWe;
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("AdLogParamsGenerate", "getInfoFromLogExtra exception", e11.getMessage());
        }
    }

    private boolean zY() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public List<com.bytedance.sdk.openadsdk.We.sc> pFF(List<com.bytedance.sdk.openadsdk.We.sc> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.We.sc scVar : list) {
            try {
                JSONObject jSONObjectZY = scVar.zY();
                jSONObjectZY.putOpt("_ad_staging_flag", 1);
                arrayList.add(new com.bytedance.sdk.openadsdk.We.sc(scVar.f27378sc, jSONObjectZY));
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("AdLogParamsGenerate", e11.getMessage());
            }
        }
        return arrayList;
    }

    @SuppressLint({"HardwareIds"})
    @JProtect
    public JSONObject pFF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ua", cJ.zY());
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("app_version", cJ.qr());
            jSONObject.put("sim_op", sc(this.zY));
            jSONObject.put("root", this.We ? 1 : 0);
            jSONObject.put("timezone", We());
            jSONObject.put("access", uEA.sc(this.zY));
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.ExN);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", kX.We(this.zY) + "x" + kX.zY(this.zY));
            jSONObject.put("display_density", sc(kX.qr(this.zY)));
            jSONObject.put("density_dpi", kX.qr(this.zY));
            jSONObject.put("aid", "1371");
            jSONObject.put("device_id", com.bytedance.sdk.openadsdk.core.Tf.sc(this.zY));
            jSONObject.put("rom", TRI());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.pFF);
            jSONObject.put(CommonUtils.PARAM_UID, this.f27412sc);
            jSONObject.put("google_aid", com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF());
            jSONObject.put("locale_language", DeviceUtils.We());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.ExN() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.pFF() ? 1 : 0);
            com.bytedance.sdk.openadsdk.core.settings.TRI triWe = Xc.We();
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.Sfl.sc(this.zY, "tt_choose_language"));
            if (triWe.McK("mnc")) {
                jSONObject.put("mnc", II.zY());
            }
            if (triWe.McK("mcc")) {
                jSONObject.put("mcc", II.pFF());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String sc(List<com.bytedance.sdk.openadsdk.We.sc> list) {
        return cJ.ExN((list.size() <= 0 || list.get(0) == null || list.get(0).zY() == null) ? "" : list.get(0).zY().optString("app_log_url"));
    }

    public List<com.bytedance.sdk.openadsdk.We.sc> sc(List<com.bytedance.sdk.openadsdk.We.sc> list, boolean z11) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.We.sc scVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectZY = scVar.zY();
                jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, jSONObjectZY.optString("label"));
                long jOptLong = jSONObjectZY.optLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", com.bytedance.sdk.openadsdk.We.TRI.zY.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> itKeys = jSONObjectZY.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.equals(next, "label")) {
                        jSONObject2.putOpt(next, jSONObjectZY.opt(next));
                    }
                }
                if (z11) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt("params", jSONObject2);
                arrayList.add(new com.bytedance.sdk.openadsdk.We.TRI(scVar.f27378sc, jSONObject));
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("AdLogParamsGenerate", e11.getMessage());
            }
        }
        return arrayList;
    }

    public JSONObject sc(List<com.bytedance.sdk.openadsdk.We.sc> list, long j11, JSONObject jSONObject, boolean z11) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            sc(list.get(0), z11);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.We.sc> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().sc(z11));
            }
            if (z11) {
                jSONObject2.put("event_v3", jSONArray);
                jSONObject2.put("magic_tag", "ss_app_log");
            } else {
                jSONObject2.put(NotificationCompat.CATEGORY_EVENT, jSONArray);
            }
            jSONObject2.put("_gen_time", j11);
            jSONObject2.put("local_time", j11 / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }
}
