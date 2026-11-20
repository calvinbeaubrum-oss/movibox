package com.bytedance.sdk.openadsdk.component.We;

import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.SR.pFF;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.We.zY;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.WP;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.transsion.push.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public static void pFF(Sfl sfl) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", Sfl.ExN(sfl) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException e11) {
            Tf.sc("TTAppOpenAdReport", "reportCacheLoss json error", e11);
        }
        zY.We(sfl, "cache_loss", jSONObject);
    }

    public static void pFF(Sfl sfl, long j11, boolean z11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("size", sfl.GI().c());
            jSONObject.put("video_duration", sfl.GI().m());
            jSONObject.put("order", z11 ? 1 : 2);
        } catch (JSONException unused) {
        }
        zY.sc(sfl, "download_video_duration", j11, jSONObject);
    }

    public static void sc(final int i11, final int i12) {
        com.bytedance.sdk.openadsdk.SR.zY.sc("openad_load_ad_timeout", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.component.We.sc.1
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeout_type", i11);
                jSONObject.put("user_timeout_time", i12);
                return We.pFF().sc("openad_load_ad_timeout").pFF(jSONObject.toString());
            }
        });
    }

    public static void sc(Sfl sfl) {
        zY.We(sfl, "cache_expire", (JSONObject) null);
    }

    public static void sc(Sfl sfl, int i11, int i12, float f11) {
        JSONObject jSONObject = new JSONObject();
        try {
            sc(jSONObject, sfl);
            jSONObject.put("openad_creative_type", Sfl.ExN(sfl) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("skip_time", i11);
            jSONObject.put("skip_show_time", i12);
            jSONObject.put("total_time", f11);
        } catch (JSONException e11) {
            Tf.sc("TTAppOpenAdReport", "reportSkip json error", e11);
        }
        zY.sc(sfl, "skip", i11, jSONObject);
    }

    public static void sc(Sfl sfl, int i11, WP wp2) {
        JSONObject jSONObject = new JSONObject();
        long jTRI = 0;
        try {
            jSONObject.put("openad_creative_type", Sfl.ExN(sfl) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("open_ad_cache_type", i11);
            if (wp2 != null) {
                wp2.pFF(OXF.pFF());
                sc(jSONObject, sfl);
                jSONObject.put("client_start_time", wp2.pFF());
                jSONObject.put("sever_time", wp2.We());
                jSONObject.put("network_time", wp2.zY());
                jSONObject.put("client_end_time", wp2.ExN());
                jSONObject.put("download_resource_duration", wp2.qr());
                jSONObject.put("resource_source", wp2.Qj());
                jSONObject.put("is_bidding", wp2.f28414sc ? 1 : 0);
                if (wp2.f28414sc) {
                    jSONObject.put("load_wait_time", wp2.pFF);
                }
                jTRI = wp2.TRI();
            }
        } catch (JSONException e11) {
            Tf.sc("TTAppOpenAdReport", "reportLoadNetDuration json error", e11);
        }
        zY.sc(sfl, "load_net_duration", jTRI, jSONObject);
    }

    public static void sc(Sfl sfl, long j11) {
        JSONObject jSONObject = new JSONObject();
        try {
            sc(jSONObject, sfl);
            jSONObject.put("openad_creative_type", Sfl.ExN(sfl) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException unused) {
            Tf.sc("TTAppOpenAdReport", "reportLoadCacheDuration json error");
        }
        zY.sc(sfl, "load_cache_duration", j11, jSONObject);
    }

    public static void sc(Sfl sfl, long j11, float f11, boolean z11) {
        JSONObject jSONObject = new JSONObject();
        try {
            sc(jSONObject, sfl);
            jSONObject.put("openad_creative_type", Sfl.ExN(sfl) ? "video_normal_ad" : "image_normal_ad");
            if (z11) {
                double d11 = f11;
                jSONObject.put("video_duration", d11);
                jSONObject.put("video_percent", (int) (((j11 * 1.0d) / 10.0d) / d11));
            } else {
                jSONObject.put("image_duration", f11);
            }
        } catch (JSONException e11) {
            Tf.sc("TTAppOpenAdReport", "reportDestroy json error", e11);
        }
        zY.We(sfl, PushConstants.PROVIDER_FIELD_DESTROY, jSONObject);
    }

    public static void sc(Sfl sfl, long j11, boolean z11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("order", z11 ? 1 : 2);
        } catch (JSONException unused) {
        }
        zY.sc(sfl, "download_image_duration", j11, jSONObject);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000e  */
    private static void sc(JSONObject jSONObject, Sfl sfl) {
        int i11;
        if (sfl != null) {
            try {
                if (sfl.LVf()) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
            } catch (JSONException e11) {
                Tf.sc("TTAppOpenAdReport", e11.getMessage());
                return;
            }
        } else {
            i11 = 0;
        }
        jSONObject.put("is_icon_only", i11);
    }
}
