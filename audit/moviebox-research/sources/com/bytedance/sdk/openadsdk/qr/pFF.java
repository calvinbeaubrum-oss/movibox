package com.bytedance.sdk.openadsdk.qr;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.GeckoHubImp;
import com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.SR.zY;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.hisavana.common.tracking.TrackingKey;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final String[] f28662sc = {"gecko-pangle-sg.byteoversea.com"};

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final pFF f28664sc = new pFF();
    }

    private pFF() {
        try {
            GeckoHubImp.inst(Xc.sc());
        } catch (Throwable th2) {
            Tf.sc("GeckoHub", "GeckoHubImp init error", th2);
        }
    }

    private static String We() {
        String[] strArrZM = Xc.We().ZM();
        if (strArrZM == null) {
            strArrZM = f28662sc;
        }
        String str = strArrZM[new SecureRandom().nextInt(strArrZM.length)];
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        SecureRandom secureRandom = new SecureRandom();
        String[] strArr = f28662sc;
        return strArr[secureRandom.nextInt(strArr.length)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(Map<String, Sfl> map, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                jSONObject2.put("success", false);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject2.put(TrackingKey.CODE, 1);
                jSONObject = jSONObject2;
            }
            Iterator<Sfl> it = map.values().iterator();
            while (it.hasNext()) {
                zY.sc(it.next(), jSONObject);
            }
        } catch (Throwable th2) {
            Tf.sc("GeckoHub", "upLoadStateEvent error", th2);
        }
    }

    public static pFF sc() {
        return sc.f28664sc;
    }

    public static void zY() {
        try {
            GeckoHubImp.setThreadPoolExecutorCallback(new IThreadPoolCallback() { // from class: com.bytedance.sdk.openadsdk.qr.pFF.2
                @Override // com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback
                public ExecutorService getThreadPool() {
                    return Cb.We();
                }
            });
        } catch (Throwable th2) {
            Tf.sc("GeckoHub", "setThreadPoolExecutor error", th2);
        }
    }

    public ILoader pFF() {
        try {
            return GeckoHubImp.inst(Xc.sc()).getGeckoResLoader();
        } catch (Throwable th2) {
            Tf.sc("GeckoHub", "getGeckoResLoader error", th2);
            return null;
        }
    }

    public int sc(ILoader iLoader, String str) {
        try {
            return GeckoHubImp.inst(Xc.sc()).getResCount(iLoader, str);
        } catch (Throwable th2) {
            Tf.sc("GeckoHub", "getResCount error", th2);
            return 0;
        }
    }

    public WebResourceResponseModel sc(ILoader iLoader, String str, String str2) {
        if (iLoader == null) {
            return null;
        }
        try {
            return GeckoHubImp.inst(Xc.sc()).findResAndMsg(iLoader, str, str2);
        } catch (Throwable th2) {
            Tf.sc("GeckoHub", "findRes error", th2);
            return null;
        }
    }

    public void sc(ILoader iLoader) {
        if (iLoader != null) {
            try {
                GeckoHubImp.inst(Xc.sc()).releaseGeckoResLoader(iLoader);
            } catch (Throwable th2) {
                Tf.sc("GeckoHub", "releaseGeckoResLoader error", th2);
            }
        }
    }

    public void sc(final Map<String, Sfl> map) {
        try {
            String strSc = com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc());
            if (TextUtils.isEmpty(strSc)) {
                return;
            }
            Iterator<Sfl> it = map.values().iterator();
            while (it.hasNext()) {
                zY.pFF(it.next());
            }
            GeckoHubImp.setRandomHost(We());
            GeckoHubImp.inst(Xc.sc()).preload(strSc, new IStatisticMonitor() { // from class: com.bytedance.sdk.openadsdk.qr.pFF.1
                @Override // com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor
                public void upload(String str, JSONObject jSONObject) {
                    if (!"geckosdk_update_stats".equals(str)) {
                        if ("download_gecko_end".equals(str)) {
                            pFF.pFF(map, jSONObject, "");
                        }
                    } else {
                        Sfl sfl = (Sfl) map.get(jSONObject.optString("channel"));
                        if (sfl != null) {
                            com.bytedance.sdk.openadsdk.We.zY.sc.sc(str, jSONObject, sfl);
                        }
                    }
                }
            }, map.keySet(), new com.bytedance.sdk.openadsdk.qr.sc());
        } catch (Throwable th2) {
            pFF(map, null, th2.toString());
            Tf.sc("GeckoHub", "releaseGeckoResLoader error", th2);
        }
    }
}
