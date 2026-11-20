package com.bytedance.sdk.openadsdk.We.sc;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static AtomicInteger f27389sc = new AtomicInteger(0);
    public static AtomicInteger pFF = new AtomicInteger(0);
    public static AtomicInteger zY = new AtomicInteger(0);
    public static AtomicInteger We = new AtomicInteger(0);
    public static AtomicInteger ExN = new AtomicInteger(0);
    public static AtomicInteger TRI = new AtomicInteger(0);

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public static AtomicInteger f27388qr = new AtomicInteger(0);
    public static AtomicInteger Qj = new AtomicInteger(0);
    public static AtomicInteger Ol = new AtomicInteger(0);

    public static void ExN() {
        try {
            if (DeviceUtils.pFF()) {
                return;
            }
            Ol.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static JSONObject We() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("load_times", f27389sc.get());
            jSONObject.put("load_success", pFF.get());
            jSONObject.put("load_fail", zY.get());
            jSONObject.put("load_fail_in_background", Ol.get());
            jSONObject.put("load_success_and_parse_success", We.get());
            jSONObject.put("load_success_and_parse_fail", ExN.get());
            jSONObject.put("load_success_and_no_ad", TRI.get());
            jSONObject.put("load_fail_by_no_net", f27388qr.get());
            jSONObject.put("load_fail_by_io", Qj.get());
            jSONObject.put("load_get_ad_version", BuildConfig.VERSION_CODE);
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void pFF() {
        try {
            com.bytedance.sdk.openadsdk.SR.zY.sc().sc("pangle_sdk_get_ad_track", com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void sc() {
        try {
            long jSc = com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_get_ad", "get_ad_event_time_key", 0L);
            if (jSc > 0 && System.currentTimeMillis() - jSc >= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                pFF();
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if (jSc <= 0 || jSc > System.currentTimeMillis()) {
                com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
            }
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.multipro.We.sc.pFF("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            int iOptInt = jSONObject.optInt("load_get_ad_version", 0);
            if (iOptInt >= 5702 && (iOptInt < 5800 || iOptInt >= 5802)) {
                f27389sc.addAndGet(jSONObject.optInt("load_times"));
                pFF.addAndGet(jSONObject.optInt("load_success"));
                zY.addAndGet(jSONObject.optInt("load_fail"));
                We.addAndGet(jSONObject.optInt("load_success_and_parse_success"));
                ExN.addAndGet(jSONObject.optInt("load_success_and_parse_fail"));
                TRI.addAndGet(jSONObject.optInt("load_success_and_no_ad"));
                f27388qr.addAndGet(jSONObject.optInt("load_fail_by_no_net"));
                Qj.addAndGet(jSONObject.optInt("load_fail_by_io"));
                Ol.addAndGet(jSONObject.optInt("load_fail_in_background"));
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void sc(int i11, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, i11);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            com.bytedance.sdk.openadsdk.SR.zY.sc().sc("pangle_sdk_client_load_error", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void zY() {
        try {
            com.bytedance.sdk.openadsdk.multipro.We.sc.sc("tt_sdk_event_get_ad", "get_ad_event_key", We().toString());
        } catch (Throwable unused) {
        }
    }
}
