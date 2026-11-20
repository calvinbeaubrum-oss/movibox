package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;
import v8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class McK implements cvk {
    private static final Map<Integer, String> ExN = new HashMap<Integer, String>(12) { // from class: com.bytedance.sdk.openadsdk.core.McK.1
        {
            put(1, "abtest");
            put(2, "user_data");
            put(3, "gaid");
            put(4, "apk-sign");
            put(5, "app_set_id_scope");
            put(6, "app_set_id");
            put(7, "installed_source");
            put(8, "app_running_time");
            put(9, "vendor");
            put(10, "model");
            put(11, "user_agent_device");
            put(12, "user_agent_webview");
            put(13, "sys_compiling_time");
            put(14, "sec_did");
            put(15, "url");
            put(16, "X-Argus");
            put(17, "X-Ladon");
            put(18, "X-Khronos");
            put(19, "X-Gorgon");
            put(20, "pangle_m");
            put(21, "screen_height");
            put(22, "screen_width");
            put(23, "rom_version");
            put(24, "carrier_name");
            put(25, "os_version");
            put(26, "conn_type");
            put(27, "boot");
            put(28, "feature_data");
            put(29, "t_ver");
            put(30, CampaignEx.JSON_KEY_AAB);
            put(31, "w_ver");
            put(32, "is_fold");
            put(33, "abi");
        }
    };

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    boolean f28026sc = false;
    boolean pFF = false;
    String zY = "com.union_test.internationad";
    String We = "8025677";
    private int TRI = 0;

    private JSONObject sc(JSONObject jSONObject, boolean z11) {
        JSONObject jSONObjectSc;
        if (z11) {
            jSONObjectSc = PangleEncryptManager.encryptType4(jSONObject, new Dl(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN));
            uEA.sc(jSONObjectSc);
        } else {
            jSONObjectSc = com.bytedance.sdk.component.utils.sc.sc(jSONObject);
        }
        return jSONObjectSc != null ? jSONObjectSc : new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    /* JADX INFO: renamed from: ExN, reason: merged with bridge method [inline-methods] */
    public McK pFF(String str) {
        Ol.pFF().zY(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public cvk ExN(int i11) {
        this.TRI = i11;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public String ExN() {
        return zY((String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public int TRI() {
        return Ol.pFF().YIK();
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public cvk TRI(int i11) {
        Ol.pFF().sc(i11);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    /* JADX INFO: renamed from: We, reason: merged with bridge method [inline-methods] */
    public McK sc(String str) {
        Ol.pFF().sc(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public cvk We(int i11) {
        Ol.pFF().TRI(i11);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public String We() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public int pFF() {
        return Ol.pFF().Qj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public cvk pFF(int i11) {
        Ol.pFF().pFF(i11);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public int qr() {
        return this.TRI;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public cvk sc() {
        com.bytedance.sdk.component.utils.Tf.sc("PangleSDK-6505");
        c.d("PangleSDK-6505");
        com.bytedance.sdk.component.utils.Tf.pFF();
        com.bytedance.sdk.component.qr.sc.sc();
        c.b();
        com.bytedance.sdk.openadsdk.utils.Dl.sc();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public cvk sc(int i11) {
        Ol.pFF().ExN(i11);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public boolean sc(String str, int i11, String str2, String str3, String str4) {
        if (!this.zY.equals(Xc.sc().getPackageName()) || !this.We.equals(Ol.pFF().We()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method methodSc = com.bytedance.sdk.component.utils.JPJ.sc("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (methodSc != null) {
                methodSc.invoke(null, str, Integer.valueOf(i11), str2, str3, str4);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public int zY() {
        return Ol.pFF().Ol();
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public cvk zY(int i11) {
        Ol.pFF().zY(i11);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.cvk
    public String zY(String str) {
        int size;
        cJ.WH("getBiddingToken");
        com.bytedance.sdk.openadsdk.core.Ol.zY.sc();
        try {
            JSONObject jSONObject = new JSONObject();
            boolean z11 = false;
            jSONObject.put("is_init", SR.ExN() ? 1 : 0);
            String strWH = Xc.We().WH();
            String strYIK = Xc.We().YIK();
            if (strWH != null && strYIK != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("version", strWH);
                jSONObject2.put("param", strYIK);
                jSONObject.put("abtest", jSONObject2);
            }
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("package_name", cJ.ExN());
            jSONObject.put("user_data", YIK.sc(TextUtils.isEmpty(str) ? null : new AdSlot.Builder().setCodeId(str).build()));
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            if (jSONObject.toString().getBytes().length <= 2680) {
                com.bytedance.sdk.openadsdk.core.settings.TRI triWe = Xc.We();
                if (triWe.McK("gaid")) {
                    jSONObject.put("gaid", com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF());
                }
                jSONObject.put("app_reg", triWe.Pu() ? 1 : 0);
                Context contextSc = Xc.sc();
                jSONObject.put("apk-sign", com.bytedance.sdk.openadsdk.common.pFF.qr());
                jSONObject.put("app_set_id_scope", com.bytedance.sdk.openadsdk.core.settings.We.pFF());
                jSONObject.put("app_set_id", com.bytedance.sdk.openadsdk.core.settings.We.zY());
                jSONObject.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.We.We());
                jSONObject.put("app_running_time", (System.currentTimeMillis() - SR.sc()) / 1000);
                jSONObject.put("rewardedfull_link", com.bytedance.sdk.openadsdk.core.settings.dE.ef().hE() ? 1 : 0);
                jSONObject.put("js_render_ver", com.bytedance.sdk.openadsdk.core.Qj.Tf.pFF());
                jSONObject.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.Qj.Tf.zY());
                jSONObject.put("vendor", Build.MANUFACTURER);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("user_agent_device", cJ.pFF());
                jSONObject.put("user_agent_webview", cJ.zY());
                jSONObject.put("sys_compiling_time", Tf.pFF(contextSc));
                jSONObject.put("screen_height", kX.We(contextSc));
                jSONObject.put("screen_width", kX.zY(contextSc));
                jSONObject.put("rom_version", com.bytedance.sdk.openadsdk.utils.WP.sc());
                jSONObject.put("carrier_name", com.bytedance.sdk.openadsdk.utils.II.sc());
                jSONObject.put("os_version", Build.VERSION.RELEASE);
                jSONObject.put("conn_type", cJ.Tf(contextSc));
                if (triWe.McK("boot")) {
                    jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                }
                cJ.sc(jSONObject);
                com.bytedance.sdk.openadsdk.core.Ol.zY.sc(jSONObject);
                com.bytedance.sdk.openadsdk.utils.TRI.sc(jSONObject, contextSc);
                size = ExN.size();
            } else {
                size = 2;
            }
            while (size > 0 && jSONObject.toString().getBytes().length > 2680) {
                jSONObject.remove(ExN.get(Integer.valueOf(size)));
                size--;
            }
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc(jSONObject);
            if (com.bytedance.sdk.openadsdk.core.settings.dE.ag() && com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN)) {
                z11 = true;
            }
            JSONObject jSONObjectSc = sc(jSONObject, z11);
            while (size > 0 && jSONObjectSc.toString().getBytes().length > 4096) {
                jSONObject.remove(ExN.get(Integer.valueOf(size)));
                jSONObjectSc = sc(jSONObject, z11);
                size--;
            }
            if (com.bytedance.sdk.component.utils.Tf.We()) {
                Objects.toString(jSONObjectSc);
                int length = jSONObjectSc.toString().getBytes().length;
            }
            Objects.toString(jSONObjectSc);
            return jSONObjectSc.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
