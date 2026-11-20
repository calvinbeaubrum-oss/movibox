package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.MonitorCrash;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.openadsdk.We.zY;
import com.bytedance.sdk.openadsdk.core.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.settings.TRI;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ApmHelper {
    private static pFF TRI = null;
    private static boolean We = false;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static sc f27050qr = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile boolean f27051sc = false;
    private static String zY;
    private static final AtomicBoolean pFF = new AtomicBoolean(false);
    private static boolean ExN = false;

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void sc(String str, String str2, Throwable th2);
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public final String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final String f27057sc;
        public final Throwable zY;

        public sc(String str, String str2, Throwable th2) {
            this.f27057sc = str;
            this.pFF = str2;
            this.zY = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> Ol() {
        HashMap map = new HashMap();
        Sfl sflSc = com.bytedance.sdk.openadsdk.utils.pFF.sc();
        if (sflSc != null) {
            map.put("adType", String.valueOf(sflSc.Zn()));
            map.put("aid", String.valueOf(sflSc.EOI()));
            map.put(BidResponsedEx.KEY_CID, sflSc.kDg());
            map.put("reqId", sflSc.ofL());
            map.put("rit", sflSc.WP("-1"));
            int iCvk = sflSc.cvk();
            if (sflSc.JPJ() != 2) {
                iCvk = -1;
            }
            map.put("render_type", String.valueOf(iCvk));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void We(final String str) {
        final Sfl sflSc = com.bytedance.sdk.openadsdk.utils.pFF.sc();
        if (sflSc != null) {
            String strSc = cJ.sc(sflSc);
            if (TextUtils.isEmpty(strSc)) {
                return;
            }
            zY.sc(System.currentTimeMillis(), sflSc, strSc, "sdk_crash_info", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.2
                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                public JSONObject sc() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("type", str);
                        jSONObject2.put("material", com.bytedance.sdk.component.utils.sc.sc(sflSc.JP()).toString());
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (JSONException unused) {
                    }
                    return jSONObject;
                }
            });
        }
    }

    public static void initApm(final Context context, final InitConfig initConfig) {
        if (pFF.compareAndSet(false, true) && !f27051sc) {
            Cb.sc(new Qj("init-apm") { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ApmHelper.f27051sc) {
                        TRI triWe = Xc.We();
                        boolean unused = ApmHelper.We = triWe.MxZ();
                        if (ApmHelper.We && !TextUtils.isEmpty(triWe.OXF())) {
                            String unused2 = ApmHelper.zY = initConfig.getAppId();
                            String[] strArr = {"com.bytedance.sdk.component", "com.bytedance.sdk.mediation", BuildConfig.LIBRARY_PACKAGE_NAME, "com.com.bytedance.overseas.sdk", "com.pgl.ssdk", "com.bykv.vk", "com.iab.omid.library.bytedance2", "com.bytedance.adsdk"};
                            String strSc = Tf.sc(context);
                            String strOXF = triWe.OXF();
                            try {
                                final MonitorCrash monitorCrashInitSDK = MonitorCrash.initSDK(context, "10000001", 6505L, BuildConfig.VERSION_NAME, strArr);
                                monitorCrashInitSDK.setCustomDataCallback(new AttachUserData() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.1
                                    @Override // com.apm.insight.AttachUserData
                                    @Nullable
                                    public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                                        Map<? extends String, ? extends String> mapOl = ApmHelper.Ol();
                                        if (mapOl.containsKey("render_type")) {
                                            monitorCrashInitSDK.addTags("render_type", mapOl.get("render_type"));
                                        } else {
                                            monitorCrashInitSDK.addTags("render_type", "-2");
                                        }
                                        return mapOl;
                                    }
                                });
                                if (triWe.NQ()) {
                                    monitorCrashInitSDK.config().setSoList(new String[]{"libnms.so", "libtobEmbedPagEncrypt.so", "tt_ugen_layout.so"});
                                }
                                monitorCrashInitSDK.config().setDeviceId(strSc);
                                monitorCrashInitSDK.setReportUrl(strOXF);
                                monitorCrashInitSDK.addTags("host_appid", ApmHelper.zY);
                                monitorCrashInitSDK.addTags("sdk_version", BuildConfig.VERSION_NAME);
                                pFF unused3 = ApmHelper.TRI = new pFF() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.2
                                    @Override // com.bytedance.sdk.openadsdk.ApmHelper.pFF
                                    public void sc(String str, String str2, Throwable th2) {
                                        monitorCrashInitSDK.reportCustomErr(str, str2, th2);
                                    }
                                };
                                boolean unused4 = ApmHelper.f27051sc = true;
                                ApmHelper.zY(strSc, strOXF);
                                monitorCrashInitSDK.registerCrashCallback(new ICrashCallback() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.3
                                    @Override // com.apm.insight.ICrashCallback
                                    public void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
                                        if (!ApmHelper.ExN) {
                                            ApmHelper.We(crashType.getName());
                                        }
                                        boolean unused5 = ApmHelper.ExN = true;
                                    }
                                }, CrashType.ALL);
                                sc scVar = ApmHelper.f27050qr;
                                sc unused5 = ApmHelper.f27050qr = null;
                                if (scVar != null) {
                                    ApmHelper.TRI.sc(scVar.f27057sc, scVar.pFF, scVar.zY);
                                }
                            } catch (Throwable unused6) {
                                boolean unused7 = ApmHelper.f27051sc = false;
                            }
                        }
                    }
                    ApmHelper.pFF.set(false);
                }
            });
        }
    }

    public static boolean isIsInit() {
        return f27051sc;
    }

    private static void pFF(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Xc.zY().sc(zY(str), AgentPageJsBridge.HTTPS + str2 + "/monitor/collect/c/session?version_code=6505&device_platform=android&aid=10000001");
    }

    public static void reportCustomError(String str, String str2, Throwable th2) {
        pFF pff = TRI;
        if (pff != null) {
            pff.sc(str, str2, th2);
        } else {
            f27050qr = new sc(str, str2, th2);
        }
    }

    public static void reportPvFromBackGround() {
        if (We) {
            pFF(Tf.sc(Xc.sc()), Xc.We().OXF());
        }
    }

    private static JSONObject zY(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", zY);
            jSONObject2.putOpt("custom", jSONObject3);
            jSONObject2.put("os", "Android");
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("device_model", Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put("aid", "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("ApmHelper", e11.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY(String str, String str2) {
        pFF(str, str2);
    }
}
