package com.bytedance.sdk.openadsdk.SR.sc;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.api.gateway.utils.SafeStringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We<T extends We> implements zY {
    private String Ol;
    private String Tf;
    private String UFX;
    private String WH;
    private String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f27117qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27118sc;
    private String zY;
    private final String We = BuildConfig.VERSION_NAME;
    private long ExN = System.currentTimeMillis() / 1000;
    private int TRI = 0;
    private int Qj = 0;

    @JProtect
    private JSONObject BT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("package_name", cJ.ExN());
            jSONObject.put("ua", cJ.zY());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private T dE() {
        return this;
    }

    public static We<We> pFF() {
        return new We<>();
    }

    public T ExN(String str) {
        this.f27117qr = str;
        return (T) dE();
    }

    public String ExN() {
        return this.pFF;
    }

    public int Ol() {
        return this.TRI;
    }

    public long Qj() {
        return this.ExN;
    }

    public T Qj(String str) {
        this.Tf = str;
        return (T) dE();
    }

    public String Ql() {
        return this.WH;
    }

    public String SR() {
        return this.Tf;
    }

    public T TRI(String str) {
        this.Ol = str;
        return (T) dE();
    }

    public String TRI() {
        return this.zY;
    }

    public String Tf() {
        return this.Ol;
    }

    public int UFX() {
        return this.Qj;
    }

    public String WH() {
        return this.f27117qr;
    }

    public T We(String str) {
        this.zY = str;
        return (T) dE();
    }

    public String We() {
        return this.UFX;
    }

    public T pFF(int i11) {
        this.Qj = i11;
        return (T) dE();
    }

    public T pFF(String str) {
        this.UFX = str;
        return (T) dE();
    }

    public T qr(String str) {
        this.WH = str;
        return (T) dE();
    }

    public String qr() {
        return TextUtils.isEmpty(BuildConfig.VERSION_NAME) ? "" : BuildConfig.VERSION_NAME;
    }

    public T sc(int i11) {
        this.TRI = i11;
        return (T) dE();
    }

    public T sc(String str) {
        this.f27118sc = str;
        return (T) dE();
    }

    @Override // com.bytedance.sdk.openadsdk.SR.sc.zY
    @JProtect
    public JSONObject sc() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ad_sdk_version", qr());
            jSONObject2.put("app_version", cJ.qr());
            jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, Qj());
            jSONObject2.put("conn_type", BT.pFF(Xc.sc()));
            jSONObject2.put(SafeStringUtils.SP_APPID, TextUtils.isEmpty(Ol.pFF().We()) ? "" : Ol.pFF().We());
            jSONObject2.put("device_info", BT());
            if (!TextUtils.isEmpty(zY())) {
                jSONObject2.put("type", zY());
            }
            jSONObject2.put(TrackingKey.ERROR_CODE, UFX());
            if (!TextUtils.isEmpty(Tf())) {
                jSONObject2.put("error_msg", Tf());
            }
            if (!TextUtils.isEmpty(ExN())) {
                jSONObject2.put("rit", ExN());
            }
            if (!TextUtils.isEmpty(TRI())) {
                jSONObject2.put(CampaignEx.JSON_KEY_CREATIVE_ID, TRI());
            }
            if (Ol() > 0) {
                jSONObject2.put("adtype", Ol());
            }
            if (!TextUtils.isEmpty(WH())) {
                jSONObject2.put("req_id", WH());
            }
            if (!TextUtils.isEmpty(Ql())) {
                jSONObject2.put("extra", Ql());
            }
            String strWe = We();
            if (TextUtils.isEmpty(strWe)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(strWe);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            }
            if (jSONObject != null) {
                jSONObject.put("os_version_int", Build.VERSION.SDK_INT);
                jSONObject2.put("event_extra", jSONObject.toString());
            } else if (!TextUtils.isEmpty(strWe)) {
                jSONObject2.put("event_extra", strWe);
            }
            if (!TextUtils.isEmpty(SR())) {
                jSONObject2.put("duration", SR());
            }
        } catch (Throwable th2) {
            Tf.sc("LogStatsBase", th2.getMessage());
        }
        return jSONObject2;
    }

    public T zY(String str) {
        this.pFF = str;
        return (T) dE();
    }

    public String zY() {
        return this.f27118sc;
    }
}
