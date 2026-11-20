package com.bytedance.sdk.openadsdk.YIK;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.uEA;
import com.bytedance.sdk.openadsdk.Dl.We;
import com.bytedance.sdk.openadsdk.Dl.zY;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.SR;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static volatile zY pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f27487sc = new ConcurrentHashMap<>();

    public static int ExN() {
        if (pFF()) {
            return sc("ad_load_and_render_opt", "webview_preload_cache", 0);
        }
        return 0;
    }

    public static int TRI() {
        if (pFF()) {
            return sc("ad_load_and_render_opt", "webview_preload_cache_v3", 0);
        }
        return 0;
    }

    public static boolean We() {
        return pFF() && sc("ad_load_and_render_opt", "sync_barrier_switch_opt", 0) == 1;
    }

    public static boolean pFF() {
        return sc("ad_load_and_render_opt", "enable", 0) == 1;
    }

    private static zY qr() {
        return sc(Xc.sc(), Ol.pFF().We());
    }

    public static int sc(String str, int i11) {
        zY zYVarQr = qr();
        return zYVarQr != null ? zYVarQr.sc(str, i11) : i11;
    }

    public static int sc(String str, String str2, int i11) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = f27487sc;
            Object obj = concurrentHashMap.get(str3);
            if (obj != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
            try {
                String strSc = qr().sc(str, "");
                if (TextUtils.isEmpty(strSc)) {
                    return i11;
                }
                int iOptInt = new JSONObject(strSc).optInt(str2, i11);
                concurrentHashMap.put(str3, Integer.valueOf(iOptInt));
                return iOptInt;
            } catch (Throwable th2) {
                Tf.sc("StrategyUtils", th2.getMessage());
            }
        }
        return i11;
    }

    public static zY sc(final Context context, final String str) {
        if (pFF == null) {
            synchronized (sc.class) {
                try {
                    if (pFF == null) {
                        try {
                            zY zYVar = new zY(new We() { // from class: com.bytedance.sdk.openadsdk.YIK.sc.1
                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public String ExN() {
                                    return cJ.We("/api/ad/union/sdk/strategies/adn");
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public JSONObject TRI() {
                                    try {
                                        JSONObject jSONObjectSc = SR.sc(uEA.sc(Xc.sc(), 0L));
                                        if (!jSONObjectSc.has("app_id")) {
                                            if (!TextUtils.isEmpty(str)) {
                                                jSONObjectSc.put("app_id", str);
                                            } else {
                                                if (TextUtils.isEmpty(Ol.pFF().We())) {
                                                    return null;
                                                }
                                                jSONObjectSc.put("app_id", Ol.pFF().We());
                                            }
                                        }
                                        return com.bytedance.sdk.component.utils.sc.sc(jSONObjectSc);
                                    } catch (Throwable th2) {
                                        Tf.sc("StrategyUtils", th2.getMessage());
                                        return null;
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public Handler We() {
                                    return com.bytedance.sdk.openadsdk.core.SR.pFF();
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public Context pFF() {
                                    Context context2 = context;
                                    return context2 != null ? context2 : Xc.sc();
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public Map<String, String> qr() {
                                    HashMap map = new HashMap();
                                    map.put("User-Agent", cJ.zY());
                                    return map;
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public ExecutorService sc() {
                                    return Cb.We();
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public JSONObject sc(JSONObject jSONObject) {
                                    int iOptInt = jSONObject.optInt("cypher", -1);
                                    if (iOptInt == -1 || iOptInt != 3) {
                                        return jSONObject;
                                    }
                                    String strZY = com.bytedance.sdk.component.utils.sc.zY(jSONObject.optString("message"));
                                    if (TextUtils.isEmpty(strZY)) {
                                        return jSONObject;
                                    }
                                    try {
                                        return new JSONObject(strZY);
                                    } catch (Throwable unused) {
                                        return jSONObject;
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.We
                                public String zY() {
                                    return "pag_adn_strategy_center";
                                }
                            });
                            pFF = zYVar;
                            zYVar.sc(new com.bytedance.sdk.openadsdk.Dl.sc() { // from class: com.bytedance.sdk.openadsdk.YIK.sc.2
                                @Override // com.bytedance.sdk.openadsdk.Dl.sc
                                public void pFF() {
                                    com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.YIK.sc.2.2
                                        @Override // com.bytedance.sdk.openadsdk.dE.We
                                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                            scVar.pFF("strategy_fetch");
                                            return scVar;
                                        }
                                    });
                                    com.bytedance.sdk.openadsdk.TRI.sc.sc().pFF();
                                    com.bytedance.sdk.openadsdk.Sfl.sc.zY.sc().pFF();
                                    com.bykv.vk.openvk.sc.sc.pFF.We.We.zY(!com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc());
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.sc
                                public void sc() {
                                    com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.YIK.sc.2.1
                                        @Override // com.bytedance.sdk.openadsdk.dE.We
                                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                            scVar.pFF("strategy_fetch");
                                            return scVar;
                                        }
                                    });
                                }

                                @Override // com.bytedance.sdk.openadsdk.Dl.sc
                                public void sc(int i11, String str2) {
                                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.YIK.sc.2.3
                                        @Override // com.bytedance.sdk.openadsdk.dE.We
                                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                            scVar.pFF("strategy_fetch");
                                            return scVar;
                                        }
                                    });
                                }
                            });
                        } catch (Throwable th2) {
                            th2.getMessage();
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return pFF;
    }

    public static String sc(String str, String str2) {
        zY zYVarQr = qr();
        return zYVarQr != null ? zYVarQr.sc(str, str2) : str2;
    }

    public static String sc(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str4 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = f27487sc;
            Object obj = concurrentHashMap.get(str4);
            if (obj != null && (obj instanceof String)) {
                return (String) obj;
            }
            try {
                String strSc = qr().sc(str, "");
                if (TextUtils.isEmpty(strSc)) {
                    return str3;
                }
                String strOptString = new JSONObject(strSc).optString(str2, str3);
                concurrentHashMap.put(str4, strOptString);
                return strOptString;
            } catch (Throwable th2) {
                Tf.sc("StrategyUtils", th2.getMessage());
            }
        }
        return str3;
    }

    public static void sc() {
        zY zYVarQr = qr();
        if (zYVarQr != null) {
            zYVarQr.sc();
        }
    }

    public static boolean sc(String str, boolean z11) {
        zY zYVarQr = qr();
        return zYVarQr != null ? zYVarQr.sc(str, z11) : z11;
    }

    public static boolean zY() {
        return pFF() && sc("ad_load_and_render_opt", "thread_switch_opt", 0) == 1;
    }
}
