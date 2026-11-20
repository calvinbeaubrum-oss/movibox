package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bytedance.sdk.component.utils.uEA;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.II;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SR extends com.bytedance.sdk.component.Qj.Qj {
    private final Ql pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f28490sc;
    private final Set<ExN> zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(boolean z11);
    }

    public SR(sc scVar, Ql ql2, ExN... exNArr) {
        super("SetF");
        HashSet hashSet = new HashSet();
        this.zY = hashSet;
        this.f28490sc = scVar;
        this.pFF = ql2;
        hashSet.addAll(Arrays.asList(exNArr));
    }

    private JSONObject pFF(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.sc.sc(jSONObject);
    }

    public static JSONObject sc(int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            TRI triWe = Xc.We();
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("device_city", cJ.BT());
            if (triWe.McK("gaid")) {
                jSONObject.put("gaid", com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF());
            }
            jSONObject.put("gdpr", com.bytedance.sdk.openadsdk.core.Ol.pFF().Ol());
            jSONObject.put("coppa", com.bytedance.sdk.openadsdk.core.Ol.pFF().Qj());
            jSONObject.put("ccpa", com.bytedance.sdk.openadsdk.core.Ol.pFF().YIK());
            if (triWe.McK("mcc")) {
                jSONObject.put("mcc", II.pFF());
            }
            Context contextSc = Xc.sc();
            jSONObject.put("conn_type", cJ.qr(i11));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("aos_api_level", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.Tf.pFF());
            jSONObject.put("time_zone", cJ.wjp());
            jSONObject.put("package_name", cJ.ExN());
            jSONObject.put(RequestParameters.POSITION, cJ.sc() ? 1 : 2);
            jSONObject.put("app_version", cJ.qr());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.Tf.zY(contextSc));
            String strWe = com.bytedance.sdk.openadsdk.core.Ol.pFF().We();
            if (strWe != null) {
                jSONObject.put("app_id", strWe);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ExN.sc(strWe != null ? strWe.concat(String.valueOf(jCurrentTimeMillis)).concat(BuildConfig.VERSION_NAME) : ""));
            jSONObject.put("tcstring", dE.zY(contextSc));
            jSONObject.put("tcf_gdpr", dE.pFF(contextSc));
            jSONObject.put("lmt", DeviceUtils.zY());
            jSONObject.put("locale_language", DeviceUtils.We());
            jSONObject.put("channel", "main");
            JSONObject jSONObjectExN = triWe.ExN();
            if (jSONObjectExN != null) {
                jSONObject.put("digest", jSONObjectExN);
            }
            jSONObject.put("data_time", triWe.TRI());
            jSONObject.put("app_set_id_scope", We.pFF());
            jSONObject.put("app_set_id", We.zY());
            jSONObject.put("installed_source", We.We());
            if (triWe.McK("gaid")) {
                jSONObject.put("did", com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc()));
            }
            String strExN = com.bytedance.sdk.openadsdk.core.Ol.pFF().ExN();
            if (!TextUtils.isEmpty(strExN)) {
                jSONObject.put("mediation", strExN);
            }
            jSONObject.put("device", DeviceUtils.sc(contextSc, true));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str, Map<String, String> map) {
        int i11 = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap map2 = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        map2.put(key.toLowerCase(Locale.US), entry.getValue());
                    }
                }
                int i12 = Integer.parseInt((String) map2.get("active-control"));
                long j11 = Long.parseLong((String) map2.get("ts"));
                String str2 = (String) map2.get("pst");
                String strA = v8.a.a(str + i12 + j11);
                if (strA != null && strA.equalsIgnoreCase(str2)) {
                    i11 = i12;
                }
            }
        } catch (Throwable unused) {
        }
        Tf.sc(i11);
    }

    public static boolean sc() {
        return BinderPoolService.f28619sc;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iSc = uEA.sc(Xc.sc(), 0L);
        if (iSc == 0) {
            this.f28490sc.sc(false);
            return;
        }
        final com.bytedance.sdk.openadsdk.SR.sc.ExN exN = new com.bytedance.sdk.openadsdk.SR.sc.ExN(1);
        JSONObject jSONObjectSc = sc(iSc);
        com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
        try {
            String strSc = com.bytedance.sdk.openadsdk.Qj.We.sc(wePFF, cJ.We("/api/ad/union/sdk/settings/"));
            wePFF.pFF(strSc);
            wePFF.pFF("User-Agent", cJ.zY());
            exN.sc(strSc);
        } catch (Exception unused) {
        }
        String string = pFF(jSONObjectSc).toString();
        if (Xc.We().yL() && com.bytedance.sdk.openadsdk.core.II.sc().qr() == 1) {
            cJ.sc("Pangle_Debug_Mode", string, Xc.sc());
        }
        wePFF.sc(string, Xc.We().Xc());
        exN.sc(wePFF.We()).sc();
        wePFF.sc(6);
        wePFF.sc("setting");
        com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.settings.SR.1
            @Override // com.bytedance.sdk.openadsdk.dE.We
            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                scVar.pFF("settings_fetch");
                return scVar;
            }
        });
        wePFF.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.settings.SR.2
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                JSONObject jSONObject;
                int iOptInt;
                int iSc2 = pff.sc();
                String strWe = pff.We();
                if (Xc.We().yL() && com.bytedance.sdk.openadsdk.core.II.sc().qr() == 1) {
                    cJ.sc("Pangle_Debug_Mode", strWe, Xc.sc());
                }
                if (!pff.TRI() || TextUtils.isEmpty(strWe)) {
                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.settings.SR.2.2
                        @Override // com.bytedance.sdk.openadsdk.dE.We
                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            scVar.pFF("settings_fetch");
                            return scVar;
                        }
                    });
                } else {
                    exN.zY(strWe).sc(iSc2).sc(true);
                    String strZY = null;
                    try {
                        jSONObject = new JSONObject(strWe);
                    } catch (JSONException unused2) {
                        jSONObject = null;
                    }
                    if (jSONObject != null && (iOptInt = jSONObject.optInt("cypher", -1)) != -1) {
                        if (iOptInt == 3) {
                            strZY = com.bytedance.sdk.component.utils.sc.zY(jSONObject.optString("message"));
                            if (!TextUtils.isEmpty(strZY)) {
                                try {
                                    jSONObject = new JSONObject(strZY);
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                        try {
                            SR.this.sc(strZY, pff.zY());
                        } catch (Throwable unused4) {
                        }
                        try {
                            SR.this.sc(jSONObject);
                            Xc.We().sc(System.currentTimeMillis());
                            com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.settings.SR.2.1
                                @Override // com.bytedance.sdk.openadsdk.dE.We
                                public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                    com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                    scVar.pFF("settings_fetch");
                                    return scVar;
                                }
                            });
                        } catch (Throwable unused5) {
                        }
                        SR.this.f28490sc.sc(true);
                        com.bytedance.sdk.openadsdk.core.WH.sc.sc();
                        return;
                    }
                }
                exN.zY(strWe).sc(iSc2).We(pff.pFF()).sc(pff.TRI());
                SR.this.f28490sc.sc(false);
            }

            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                exN.We(iOException != null ? iOException.getMessage() : null).sc(false);
                SR.this.f28490sc.sc(false);
                com.bytedance.sdk.openadsdk.core.WH.sc.sc();
                com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.settings.SR.2.3
                    @Override // com.bytedance.sdk.openadsdk.dE.We
                    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                        com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                        scVar.pFF("settings_fetch");
                        return scVar;
                    }
                });
            }
        });
        DeviceUtils.UFX();
    }

    public boolean sc(@NonNull JSONObject jSONObject) {
        this.pFF.sc(jSONObject);
        for (ExN exN : this.zY) {
            if (exN != null) {
                exN.sc(jSONObject);
            }
        }
        return this.pFF.zY;
    }
}
