package com.bytedance.sdk.openadsdk.We;

import android.app.Application;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.cvk;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Dl;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public static void sc(final int i11, final int i12, final int i13, final int i14, final Sfl sfl, String str, final int i15) {
            if (str == null || TextUtils.isEmpty(sfl.PPh())) {
                return;
            }
            zY.sc(System.currentTimeMillis(), sfl, str, "landing_page_resource_detail", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.sc.4
                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                public JSONObject sc() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("next_url", sfl.ko());
                        jSONObject2.put("channel_name", sfl.PPh());
                        jSONObject2.put("preload_status", i11 <= 0 ? 0 : 2);
                        jSONObject2.put("first_page", i15);
                        jSONObject2.put("preload_h5_type", sfl.Ay());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("channel_response", i11);
                        jSONObject3.put("failResourceCount", i12);
                        jSONObject3.put("successCount", i13);
                        jSONObject3.put("failCount", i14);
                        jSONObject2.put("resource_info", jSONObject3);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        }

        public static void sc(final int i11, final int i12, Sfl sfl) {
            String strSc = cJ.sc(sfl);
            if (strSc == null) {
                return;
            }
            zY.sc(System.currentTimeMillis(), sfl, strSc + "_landingpage", "local_res_hit_rate", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.sc.2
                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                public JSONObject sc() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("all_times", i12);
                        jSONObject2.put("hit_times", i11);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        }

        public static void sc(final long j11, final Sfl sfl, String str, final ILoader iLoader, final String str2) {
            if (str == null) {
                return;
            }
            zY.sc(System.currentTimeMillis(), sfl, str, "landingpage_init", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.sc.3
                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                public JSONObject sc() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int iSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(iLoader, str2);
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        int i11 = 0;
                        jSONObject3.put(Sfl.zY, sfl.yL() ? 1 : 0);
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                        jSONObject2.put("url", sfl.ko());
                        jSONObject2.put("channel_name", sfl.PPh());
                        if (!TextUtils.isEmpty(sfl.PPh()) && iSc > 0) {
                            i11 = 1;
                        }
                        jSONObject2.put("interceptor_status", i11);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("resource_count", iSc);
                        jSONObject2.put("resource_info", jSONObject4);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("duration", j11);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        }

        public static void sc(String str, final JSONObject jSONObject, Sfl sfl) {
            String strSc = cJ.sc(sfl);
            if (strSc == null) {
                return;
            }
            zY.sc(System.currentTimeMillis(), sfl, strSc + "_landingpage", str, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.sc.1
                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                public JSONObject sc() {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    public static void ExN(Sfl sfl, final com.bytedance.sdk.openadsdk.SR.sc.sc scVar, final String str) {
        sc(System.currentTimeMillis(), sfl, str, "web_behavior_click", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.31
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", scVar.zY());
                    jSONObject2.put("current_url_index", scVar.We());
                    jSONObject2.put("arbi_start_x", scVar.ExN());
                    jSONObject2.put("arbi_start_y", scVar.TRI());
                    jSONObject2.put("click_duration", scVar.qr());
                    jSONObject2.put("is_trigger_jump", scVar.Qj());
                    jSONObject2.put("click_type", String.valueOf(scVar.Sfl()));
                    if (scVar.sc() != -1) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("hit_type", scVar.sc());
                        jSONObject3.put("hit_extra", scVar.pFF());
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th2) {
                    Dl.pFF("TTAD.AdEvent", "onWebBehaviorClick", th2.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void ExN(Sfl sfl, String str, JSONObject jSONObject) {
        We(sfl, "activity_recreate", str, jSONObject);
    }

    public static void We(Sfl sfl, final com.bytedance.sdk.openadsdk.SR.sc.sc scVar, final String str) {
        sc(System.currentTimeMillis(), sfl, str, "web_behavior_scroll", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.30
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", scVar.zY());
                    jSONObject2.put("current_url_index", scVar.We());
                    jSONObject2.put("trigger_scroll_x", scVar.Ol());
                    jSONObject2.put("trigger_scroll_y", scVar.WH());
                    jSONObject2.put("arbi_offset_y", scVar.UFX());
                    jSONObject2.put("scroll_type", scVar.Tf());
                    jSONObject2.put("scroll_duration", scVar.Ql());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th2) {
                    Dl.pFF("TTAD.AdEvent", "onWebBehaviorScroll", th2.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void We(final Sfl sfl, final String str, final int i11) {
        sc(System.currentTimeMillis(), sfl, str, "material_status", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.13
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(TrackingKey.TRIGGER_TYPE, i11);
                    jSONObject3.put("image_mode", sfl.dix());
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject.toString();
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    @DungeonFlag
    private static void We(final Sfl sfl, final String str, final String str2, final JSONObject jSONObject) {
        if (sfl == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (sfl.io() && PushConstants.PUSH_SERVICE_TYPE_SHOW.equals(str)) {
            return;
        }
        if (PushConstants.PUSH_SERVICE_TYPE_SHOW.equals(str)) {
            sfl.Qj(true);
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        sc(new com.bytedance.sdk.component.Qj.Qj("onShow") { // from class: com.bytedance.sdk.openadsdk.We.zY.49
            @Override // java.lang.Runnable
            public void run() {
                final String strSc;
                if (com.bytedance.sdk.openadsdk.core.Xc.We().DNB()) {
                    strSc = com.bytedance.sdk.openadsdk.core.Ol.sc.sc.sc((Application) com.bytedance.sdk.openadsdk.core.Xc.sc()).sc(str2, DeviceUtils.sc(), sfl.QT());
                } else {
                    strSc = DevicePublicKeyStringDef.NONE;
                }
                zY.sc(jCurrentTimeMillis, sfl, str2, str, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.49.1
                    @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                    public JSONObject sc() {
                        Object obj;
                        try {
                            JPJ.pFF(sfl);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                AnonymousClass49 anonymousClass49 = AnonymousClass49.this;
                                JSONObject jSONObject3 = jSONObject;
                                if (jSONObject3 != null) {
                                    jSONObject3.put("interaction_method", sfl.wjp());
                                    AnonymousClass49 anonymousClass410 = AnonymousClass49.this;
                                    jSONObject.put("real_interaction_method", sfl.Xc());
                                    jSONObject.put("video_skip_result", com.bytedance.sdk.openadsdk.core.Xc.We().Ql(String.valueOf(sfl.QT())));
                                    jSONObject.put("au_show", strSc);
                                    AnonymousClass49 anonymousClass411 = AnonymousClass49.this;
                                    com.bytedance.sdk.openadsdk.Sfl.sc.sc.sc(sfl, jSONObject);
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                } else {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("interaction_method", sfl.wjp());
                                    jSONObject4.put("real_interaction_method", sfl.Xc());
                                    jSONObject4.put("video_skip_result", com.bytedance.sdk.openadsdk.core.Xc.We().Ql(String.valueOf(sfl.QT())));
                                    jSONObject4.put("au_show", strSc);
                                    com.bytedance.sdk.openadsdk.Sfl.sc.sc.sc(sfl, jSONObject4);
                                    jSONObject2.put("ad_extra_data", jSONObject4.toString());
                                }
                                jSONObject2.putOpt("log_extra", sfl.mD());
                                float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - sfl.zGQ()).floatValue();
                                if (fFloatValue <= 0.0f) {
                                    fFloatValue = 0.0f;
                                }
                                jSONObject2.putOpt(TrackingKey.SHOW_TIME, Float.valueOf(fFloatValue));
                                jSONObject2.putOpt("ua_policy", Integer.valueOf(sfl.BR()));
                                String strMcK = sfl.McK();
                                if (!TextUtils.isEmpty(strMcK) && !TextUtils.isEmpty(strMcK)) {
                                    try {
                                        jSONObject2.put("ttdsp_price", Math.round(Float.parseFloat(strMcK) * 100000.0f));
                                    } catch (Throwable th2) {
                                        jSONObject2.put("ttdsp_price", 0);
                                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", th2.getMessage());
                                    }
                                }
                                if (sfl.eoh() == null) {
                                    return jSONObject2;
                                }
                                try {
                                    Object obj2 = sfl.eoh().get(TTAdConstant.SDK_BIDDING_TYPE);
                                    if (obj2 == null || Integer.parseInt(obj2.toString()) != 2 || (obj = sfl.eoh().get(BidResponsed.KEY_PRICE)) == null) {
                                        return jSONObject2;
                                    }
                                    jSONObject2.put("ttdsp_price", Math.round(Double.parseDouble(obj.toString()) * 100000.0d));
                                    return jSONObject2;
                                } catch (Throwable th3) {
                                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", "client bidding price error: ", th3);
                                    return jSONObject2;
                                }
                            } catch (Exception unused) {
                                return jSONObject2;
                            }
                        } catch (Exception unused2) {
                            return null;
                        }
                    }
                });
                if (PushConstants.PUSH_SERVICE_TYPE_SHOW.equals(str)) {
                    if (!sfl.ag()) {
                        if (sfl.ixT()) {
                            com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(sfl.idT(), new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF("show_urls", sfl));
                        } else {
                            zY.sc(sfl);
                        }
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        int iOptInt = jSONObject2.optInt("dynamic_show_type");
                        if (sfl.yQN() == 1 && (iOptInt == 7 || iOptInt == 10)) {
                            com.bytedance.sdk.component.utils.qr.sc().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.zY.49.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("auto_click", true);
                                        AnonymousClass49 anonymousClass49 = AnonymousClass49.this;
                                        zY.pFF(sfl, str2, "click", jSONObject3);
                                    } catch (Exception unused) {
                                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", "ugen click exception");
                                    }
                                }
                            }, com.bytedance.sdk.openadsdk.core.settings.dE.ef().Mrq());
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.Ol.zY.sc(sfl, strSc);
                }
            }
        });
    }

    public static void We(Sfl sfl, String str, JSONObject jSONObject) {
        if (sfl == null) {
            return;
        }
        sc(sfl, str, -1L, jSONObject);
    }

    public static void pFF(final long j11, final Sfl sfl, String str, final String str2) {
        sc(System.currentTimeMillis(), sfl, str, "endcard_feeling_duraion", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.25
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("duration", j11);
                    if (Sfl.zY(sfl)) {
                        if (sfl.Cwg() != null) {
                            jSONObject2.putOpt("url", sfl.Cwg().zY());
                            jSONObject2.putOpt("id", sfl.Cwg().sc());
                            jSONObject2.putOpt("md5", sfl.Cwg().pFF());
                        }
                        jSONObject2.putOpt("from", str2);
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.put("url", sfl.GI().p());
                        jSONObject2.put("style_id", sfl.Qy());
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void pFF(Sfl sfl, final com.bytedance.sdk.openadsdk.SR.sc.sc scVar, final String str) {
        sc(System.currentTimeMillis(), sfl, str, "web_behavior_load", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.28
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", scVar.zY());
                    jSONObject2.put("current_url_index", scVar.We());
                    jSONObject2.put("arbi_load_duration", scVar.wjp());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th2) {
                    Dl.pFF("TTAD.AdEvent", "onWebBehaviorLoad", th2.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void pFF(final Sfl sfl, String str) {
        sc(System.currentTimeMillis(), sfl, str, "picture_click", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.14
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("ad_slot_type", sfl.Cb().getNativeAdType());
                    jSONObject.put("interaction_method", sfl.wjp());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void pFF(Sfl sfl, String str, final int i11) {
        sc(System.currentTimeMillis(), sfl, str, "check_meta", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.7
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(TrackingKey.ERROR_CODE, i11);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.dE.ef().ds());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void pFF(Sfl sfl, String str, int i11, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i11);
        } catch (JSONException unused) {
        }
        pFF(sfl, str, "download_app_ad_track", jSONObject);
    }

    public static void pFF(Sfl sfl, String str, final long j11) {
        if (sfl != null && j11 > 0 && j11 < 200000) {
            sc(System.currentTimeMillis(), sfl, str, "video_click_duration", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.3
                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                public JSONObject sc() {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put("video_click_duration_time", j11);
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    public static void pFF(Sfl sfl, String str, String str2, final JSONObject jSONObject) {
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.19
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pFF(Sfl sfl, String str, String str2, final JSONObject jSONObject, final long j11) {
        if (sfl == null || jSONObject == null) {
            return;
        }
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.36
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j11);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pFF(Sfl sfl, final String str, final JSONObject jSONObject) {
        sc(System.currentTimeMillis(), sfl, str, pFF.ExN, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.38
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                String str2 = pFF.f27372sc;
                return jSONObject2;
            }
        });
    }

    public static void sc() {
        try {
            Class.forName(zY.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void sc(final long j11, final Sfl sfl, String str) {
        if (sfl == null || !Sfl.zY(sfl) || sfl.Cwg() == null) {
            return;
        }
        sc(System.currentTimeMillis(), sfl, str, "endcard_close", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.32
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", sfl.Cwg().zY());
                    jSONObject2.putOpt("id", sfl.Cwg().sc());
                    jSONObject2.putOpt("md5", sfl.Cwg().pFF());
                    if (sfl.GI() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(sfl.GI().t()));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j11);
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
                }
                return jSONObject;
            }
        });
    }

    @DungeonFlag
    public static void sc(long j11, Sfl sfl, String str, String str2) {
        sc(j11, sfl, str, str2, (com.bytedance.sdk.openadsdk.SR.zY.sc) null);
    }

    @DungeonFlag
    public static void sc(final long j11, final Sfl sfl, final String str, final String str2, final com.bytedance.sdk.openadsdk.SR.zY.sc scVar) {
        if (sfl == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || sc(sfl.hbB(), str2)) {
            return;
        }
        sc(new com.bytedance.sdk.component.Qj.Qj(str2) { // from class: com.bytedance.sdk.openadsdk.We.zY.23
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                try {
                    com.bytedance.sdk.openadsdk.SR.zY.sc scVar2 = scVar;
                    if (scVar2 != null) {
                        jSONObject = scVar2.sc();
                        if (jSONObject == null) {
                            try {
                                jSONObject = new JSONObject();
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.putOpt("log_extra", sfl.mD());
                    jSONObject.putOpt("ua_policy", Integer.valueOf(sfl.BR()));
                } catch (Exception unused2) {
                    jSONObject = null;
                }
                new com.bytedance.sdk.openadsdk.We.sc.C0273sc(j11, sfl).pFF(str).zY(str2).ExN(sfl.kDg()).Qj(sfl.Kh()).sc(sfl.DNB()).sc(jSONObject).qr(sfl.ofL()).sc((com.bytedance.sdk.openadsdk.We.pFF.sc) null);
            }
        });
    }

    public static void sc(long j11, Sfl sfl, String str, String str2, final JSONObject jSONObject, qr qrVar, com.bytedance.sdk.openadsdk.We.pFF.sc scVar) {
        sc(j11, sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.48
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                return jSONObject;
            }
        });
    }

    public static void sc(final com.bytedance.sdk.component.Qj.Qj qj2) {
        if (qj2 == null) {
            return;
        }
        if (Cb.ExN()) {
            com.bytedance.sdk.component.utils.qr.sc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.zY.42
                @Override // java.lang.Runnable
                public void run() {
                    Cb.pFF(qj2, 10);
                }
            });
        } else if (Cb.TRI()) {
            qj2.run();
        } else {
            Cb.pFF(qj2, 10);
        }
    }

    public static void sc(final com.bytedance.sdk.openadsdk.SR.sc.pFF pff) {
        if (pff == null || pff.pFF() == null) {
            return;
        }
        final Sfl sflPFF = pff.pFF();
        final int iQLv = sflPFF.QLv();
        if (iQLv == 2 || iQLv == 8 || (cJ.We(sflPFF) && pFF.sc.We.equals(pff.sc()))) {
            sc(System.currentTimeMillis(), sflPFF, pff.zY(), "open_browser", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.43
                @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                public JSONObject sc() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int iWe = pff.We();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("count", cJ.SR(com.bytedance.sdk.openadsdk.core.Xc.sc()));
                        jSONObject2.put("interceptor", iWe);
                        jSONObject2.put("success", pff.ExN());
                        jSONObject2.put("link", pff.sc());
                        jSONObject2.put("interaction_type", iQLv);
                        jSONObject2.put("real_interaction_type", pff.qr());
                        if (pff.We() == 9) {
                            jSONObject2.put("is_act_signals_api_available", pff.Qj());
                            jSONObject2.put("is_act_signals_callback", pff.Ol());
                        }
                        if (!TextUtils.isEmpty(pff.TRI())) {
                            jSONObject2.put("exception_msg", pff.TRI());
                        }
                        if (iWe == 2 || iWe == 5) {
                            jSONObject2.put("meta", sflPFF.JP().toString());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    } catch (Exception e11) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", e11.getMessage());
                    }
                    return jSONObject;
                }
            });
        }
    }

    public static void sc(Sfl sfl) {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.Tf.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()))) {
            return;
        }
        com.bytedance.sdk.openadsdk.We.sc.We.sc(com.bytedance.sdk.openadsdk.JPJ.sc.sc(sfl.idT(), true), 1, sfl.kDg());
    }

    public static void sc(Sfl sfl, final com.bytedance.sdk.openadsdk.SR.sc.sc scVar, final String str) {
        sc(System.currentTimeMillis(), sfl, str, "web_behavior_keyword", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.27
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", scVar.zY());
                    jSONObject2.put("keyword", scVar.Xc());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th2) {
                    Dl.pFF("TTAD.AdEvent", "onWebBehaviorKeyword", th2.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void sc(final Sfl sfl, String str) {
        sc(System.currentTimeMillis(), sfl, str, "endcard_load_start", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.12
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (Sfl.zY(sfl)) {
                        if (sfl.Cwg() != null) {
                            jSONObject2.putOpt("url", sfl.Cwg().zY());
                            jSONObject2.putOpt("id", sfl.Cwg().sc());
                            jSONObject2.putOpt("md5", sfl.Cwg().pFF());
                        }
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", sfl.GI().p());
                        jSONObject2.putOpt("style_id", sfl.Qy());
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void sc(Sfl sfl, String str, final int i11) {
        sc(System.currentTimeMillis(), sfl, str, "open_url_h5", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.1
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("preload_status", Integer.valueOf(i11));
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sc(Sfl sfl, String str, final int i11, final long j11) {
        sc(System.currentTimeMillis(), sfl, str, "video_choose", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.17
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("video_choose", i11);
                    jSONObject2.put("video_choose_duration", j11);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject;
            }
        });
    }

    public static void sc(Sfl sfl, final String str, final int i11, final String str2, final float f11) {
        sc(System.currentTimeMillis(), sfl, str, pFF.pFF, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.10
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("index", i11);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("arbi_load_duration", f11);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(Sfl sfl, final String str, final int i11, final String str2, final int i12) {
        sc(System.currentTimeMillis(), sfl, str, pFF.f27372sc, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.9
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("index", i11);
                    jSONObject.put("arbi_current_url", str2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("new_index", i12);
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(Sfl sfl, final String str, final int i11, final String str2, final long j11, final boolean z11, final int i12, final long j12) {
        sc(System.currentTimeMillis(), sfl, str, pFF.We, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.4
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("invisible_scene", i11);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("loading_visible_time", j11);
                    jSONObject.put("arbi_trigger_start", z11);
                    jSONObject.put("arbi_convert_count", i12);
                    jSONObject.put("loading_start_timestamp", j12);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(Sfl sfl, final String str, final int i11, final String str2, final String str3, final int i12) {
        sc(System.currentTimeMillis(), sfl, str, pFF.zY, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.11
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("index", i11);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, str3);
                    jSONObject.put("url_flag", i12);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(Sfl sfl, String str, int i11, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i11);
        } catch (JSONException unused) {
        }
        pFF(sfl, str, "open_ad_land_page_links", jSONObject);
    }

    public static void sc(final Sfl sfl, String str, final long j11) {
        sc(System.currentTimeMillis(), sfl, str, "endcard_load_finish", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.22
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (Sfl.zY(sfl)) {
                        if (sfl.Cwg() != null) {
                            jSONObject2.putOpt("url", sfl.Cwg().zY());
                            jSONObject2.putOpt("id", sfl.Cwg().sc());
                            jSONObject2.putOpt("md5", sfl.Cwg().pFF());
                        }
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", sfl.GI().p());
                        jSONObject2.putOpt("style_id", sfl.Qy());
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j11);
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void sc(final Sfl sfl, String str, final long j11, final int i11, final int i12) {
        sc(System.currentTimeMillis(), sfl, str, "load", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.44
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("interaction_method", Integer.valueOf(sfl.wjp()));
                    jSONObject2.put("first_page", i12);
                    jSONObject2.put("preload_h5_type", sfl.Ay());
                    int i13 = i11;
                    if (i13 >= 0) {
                        jSONObject2.putOpt("preload_status", Integer.valueOf(i13));
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", Math.min(j11, TTAdConstant.AD_MAX_EVENT_TIME));
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sc(final Sfl sfl, String str, final long j11, final int i11, final String str2, final String str3) {
        sc(System.currentTimeMillis(), sfl, str, "endcard_load_fail", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.33
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (Sfl.zY(sfl)) {
                        if (sfl.Cwg() != null) {
                            jSONObject2.putOpt("url", sfl.Cwg().zY());
                            jSONObject2.putOpt("id", sfl.Cwg().sc());
                            jSONObject2.putOpt("md5", sfl.Cwg().pFF());
                        }
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", sfl.GI().p());
                        jSONObject2.putOpt("style_id", sfl.Qy());
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject2.putOpt("error_url", str3);
                        }
                        if (sfl.GI() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject2.put(TrackingKey.ERROR_CODE, i11);
                    jSONObject2.put("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j11);
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void sc(Sfl sfl, String str, final long j11, final JSONObject jSONObject) {
        sc(System.currentTimeMillis(), sfl, "open_ad", str, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.41
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    long j12 = j11;
                    if (j12 != -1) {
                        jSONObject2.put("duration", j12);
                    }
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    } else {
                        jSONObject2.put("ad_extra_data", new JSONObject().toString());
                    }
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", e11.getMessage());
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(Sfl sfl, String str, final long j11, final boolean z11) {
        sc(System.currentTimeMillis(), sfl, str, "lp_loading", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.5
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("if_lp_loading_success", z11 ? 1 : 2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j11);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(final Sfl sfl, final String str, final OXF oxf) {
        if (sfl == null) {
            return;
        }
        final long jWe = oxf.We();
        sc(System.currentTimeMillis(), sfl, str, "stay_duration", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.2
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("click_stay_time", jWe);
                    jSONObject.put(TrackingKey.CLICK_TIME, oxf.f28736sc);
                    if (str.equals("open_ad")) {
                        jSONObject.put("is_icon_only", sfl.LVf() ? 1 : 0);
                    }
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(Sfl sfl, String str, final String str2) {
        sc(System.currentTimeMillis(), sfl, str, "show_error", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.34
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sc(Sfl sfl, String str, final String str2, final long j11, final int i11, JSONObject jSONObject, final qr qrVar) {
        final JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.18
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                qr qrVar2;
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("duration", j11);
                    jSONObject3.put("percent", i11);
                    if (("feed_break".equals(str2) || "feed_over".equals(str2)) && (qrVar2 = qrVar) != null) {
                        qrVar2.sc(jSONObject2);
                    }
                    jSONObject3.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject3;
            }
        });
    }

    public static void sc(Sfl sfl, String str, String str2, final long j11, final JSONObject jSONObject) {
        if (sfl == null || jSONObject == null) {
            return;
        }
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.35
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("duration", j11);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", e11.getMessage());
                }
                return jSONObject2;
            }
        });
    }

    public static void sc(Sfl sfl, String str, final String str2, final com.bytedance.sdk.openadsdk.SR.zY.sc scVar) {
        sc(System.currentTimeMillis(), sfl, str, "playable_track", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.24
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    com.bytedance.sdk.openadsdk.SR.zY.sc scVar2 = scVar;
                    if (scVar2 == null || (jSONObject = scVar2.sc()) == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("is_new_playable", 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("pag_json_data", jSONObject.toString());
                    jSONObject3.put("playable_event", str2);
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    @DungeonFlag
    public static void sc(final Sfl sfl, final String str, final String str2, final String str3, final long j11, final long j12, final JSONObject jSONObject, final boolean z11) {
        if (sfl == null || sc(sfl.hbB(), str3)) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        sc(new com.bytedance.sdk.component.Qj.Qj("sendJsAdEvent") { // from class: com.bytedance.sdk.openadsdk.We.zY.40
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArrayOptJSONArray;
                String strDNB = sfl.DNB();
                if (jSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        String strOptString = jSONObject.optString("ad_extra_data");
                        if (!TextUtils.isEmpty(strOptString)) {
                            jSONObject2 = new JSONObject(strOptString);
                        }
                        if (!"click".equals(str3)) {
                            jSONObject2.put("device", DeviceUtils.ExN(com.bytedance.sdk.openadsdk.core.Xc.sc()).toString());
                        }
                        if ("click".equals(str3)) {
                            if (z11) {
                                jSONObject2.put("click_scence", 1);
                            } else if (com.bytedance.sdk.openadsdk.core.model.JPJ.pFF(sfl)) {
                                jSONObject2.put("click_scence", 3);
                            }
                        }
                        if (sfl.nW()) {
                            try {
                                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("pag_json_data");
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                jSONObjectOptJSONObject.put("is_new_playable", 1);
                                if (sfl.nj()) {
                                    jSONObjectOptJSONObject.put("is_pre_render", 1);
                                }
                                jSONObject2.put("pag_json_data", jSONObjectOptJSONObject.toString());
                            } catch (Throwable unused) {
                            }
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("tag", str2);
                        int iOptInt = jSONObject2.optInt("agg_request_type", -1);
                        if (z11 && iOptInt == 2) {
                            strDNB = jSONObject2.optString("app_log_url");
                        }
                        int i11 = 0;
                        if ("click".equals(str3)) {
                            JPJ.zY(sfl);
                            float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - Sfl.pFF(jSONObject.optString("log_extra"))).floatValue();
                            JSONObject jSONObject3 = jSONObject;
                            if (fFloatValue <= 0.0f) {
                                fFloatValue = 0.0f;
                            }
                            jSONObject3.putOpt(TrackingKey.SHOW_TIME, Float.valueOf(fFloatValue));
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.Tf.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()))) {
                                if (z11 && iOptInt == 2) {
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("click_tracking_url");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        ArrayList arrayList = new ArrayList();
                                        while (i11 < jSONArrayOptJSONArray2.length()) {
                                            arrayList.add(jSONArrayOptJSONArray2.optString(i11));
                                            i11++;
                                        }
                                        com.bytedance.sdk.openadsdk.We.sc.We.sc(com.bytedance.sdk.openadsdk.JPJ.sc.sc(arrayList, true), 2, String.valueOf(j11));
                                    }
                                } else {
                                    Sfl sfl2 = sfl;
                                    if (sfl2 != null) {
                                        com.bytedance.sdk.openadsdk.We.sc.We.sc(com.bytedance.sdk.openadsdk.JPJ.sc.sc(sfl2.fT(), true), 2, sfl.kDg());
                                    }
                                }
                            }
                        } else if (PushConstants.PUSH_SERVICE_TYPE_SHOW.equals(str3) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.Tf.sc(com.bytedance.sdk.openadsdk.core.Xc.sc())) && z11 && iOptInt == 2 && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("show_tracking_url")) != null) {
                            ArrayList arrayList2 = new ArrayList();
                            while (i11 < jSONArrayOptJSONArray.length()) {
                                arrayList2.add(jSONArrayOptJSONArray.optString(i11));
                                i11++;
                            }
                            com.bytedance.sdk.openadsdk.We.sc.We.sc(com.bytedance.sdk.openadsdk.JPJ.sc.sc(arrayList2, true), 1, String.valueOf(j11));
                        }
                    } catch (Exception unused2) {
                    }
                }
                new com.bytedance.sdk.openadsdk.We.sc.C0273sc(jCurrentTimeMillis, sfl).We(str).pFF(str2).zY(str3).ExN(String.valueOf(j11)).TRI(String.valueOf(j12)).sc(strDNB).sc(jSONObject).Qj(sfl.Kh()).qr(sfl.ofL()).sc((com.bytedance.sdk.openadsdk.We.pFF.sc) null);
            }
        });
    }

    public static void sc(final Sfl sfl, String str, String str2, final Map<String, Object> map) {
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.21
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        Object obj = map.get("duration");
                        if (obj instanceof Long) {
                            jSONObject.put("duration", obj);
                        }
                    }
                    jSONObject2.put("dp_creative_type", sfl.Vb());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sc(Sfl sfl, String str, String str2, final JSONObject jSONObject) {
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.16
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                if (jSONObject == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    if (jSONObject.has("duration")) {
                        jSONObject2.put("duration", jSONObject.get("duration"));
                    }
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", e11.getMessage());
                }
                return jSONObject2;
            }
        });
        if ("click".equals(str2)) {
            JPJ.zY(sfl);
        }
    }

    public static void sc(Sfl sfl, String str, String str2, final JSONObject jSONObject, final long j11) {
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.20
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                    jSONObject2.put("duration", j11);
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    @DungeonFlag
    public static void sc(Sfl sfl, String str, JSONObject jSONObject) {
        We(sfl, PushConstants.PUSH_SERVICE_TYPE_SHOW, str, jSONObject);
    }

    public static void sc(Sfl sfl, String str, final boolean z11, final boolean z12, final boolean z13, final boolean z14, final int i11, final Map<String, Object> map) {
        sc(System.currentTimeMillis(), sfl, str, "start_show_plb", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.45
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("isSkip", z11);
                    jSONObject2.put("force", z12);
                    jSONObject2.put("isFromLandingPage", z13);
                    jSONObject2.put("finishing", z14);
                    jSONObject2.put("from", i11);
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sc(final Sfl sfl, final boolean z11, String str, final String str2, final long j11, final String str3, final String str4, final int i11, final String str5) {
        sc(System.currentTimeMillis(), sfl, str, "load_ugen_template", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.46
            /* JADX WARN: Code duplicated, block: B:21:0x0046  */
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                byte b11;
                cvk cvkVarQKn;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String str6 = str4;
                    int iHashCode = str6.hashCode();
                    if (iHashCode != -1606803861) {
                        if (iHashCode != 3107) {
                            if (iHashCode == 2989536 && str6.equals("adv3")) {
                                b11 = 2;
                            } else {
                                b11 = -1;
                            }
                        } else if (str6.equals("ad")) {
                            b11 = 1;
                        } else {
                            b11 = -1;
                        }
                    } else if (str6.equals(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD)) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                    if (b11 != 0) {
                        if (b11 == 1) {
                            Sfl.sc scVarJoC = sfl.JoC();
                            if (scVarJoC != null) {
                                jSONObject2.putOpt("url", scVarJoC.BT());
                                jSONObject2.putOpt("id", scVarJoC.TRI());
                                jSONObject2.putOpt("md5", scVarJoC.dE());
                            }
                        } else if (b11 == 2 && (cvkVarQKn = sfl.qKn()) != null) {
                            jSONObject2.putOpt("url", cvkVarQKn.zY());
                            jSONObject2.putOpt("id", cvkVarQKn.sc());
                            jSONObject2.putOpt("md5", cvkVarQKn.pFF());
                        }
                    } else if (z11) {
                        com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVarNT = sfl.NT();
                        if (scVarNT != null) {
                            jSONObject2.putOpt("url", scVarNT.zY());
                            jSONObject2.putOpt("id", scVarNT.sc());
                            jSONObject2.putOpt("md5", scVarNT.pFF());
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVarCwg = sfl.Cwg();
                        if (scVarCwg != null) {
                            jSONObject2.putOpt("url", scVarCwg.zY());
                            jSONObject2.putOpt("id", scVarCwg.sc());
                            jSONObject2.putOpt("md5", scVarCwg.pFF());
                        }
                    }
                    jSONObject2.put("ugen_status", str2);
                    jSONObject2.put("from", str3);
                    jSONObject2.put("ugen_scene", str4);
                    if ("fail".equals(str2)) {
                        jSONObject2.put(TrackingKey.ERROR_CODE, i11);
                        jSONObject2.put("error_msg", str5);
                    }
                    jSONObject.put("duration", j11);
                } catch (Throwable th2) {
                    try {
                        jSONObject2.put(TrackingKey.ERROR_CODE, 133);
                        jSONObject2.put("error_msg", "send template error " + th2.getMessage());
                    } catch (Throwable unused) {
                    }
                }
                try {
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused2) {
                }
                return jSONObject;
            }
        });
    }

    public static void sc(String str, long j11) {
        com.bytedance.sdk.openadsdk.core.qr.zY.sc(str, j11);
    }

    @DungeonFlag
    public static void sc(final String str, final Sfl sfl, final com.bytedance.sdk.openadsdk.core.model.WH wh2, final String str2, final boolean z11, final Map<String, Object> map, final int i11) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        sc(new com.bytedance.sdk.component.Qj.Qj("onClick") { // from class: com.bytedance.sdk.openadsdk.We.zY.15
            @Override // java.lang.Runnable
            public void run() {
                Sfl sfl2 = sfl;
                if (sfl2 == null) {
                    return;
                }
                zY.sc(jCurrentTimeMillis, sfl2, str2, str, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.15.1
                    @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                    public JSONObject sc() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            com.bytedance.sdk.openadsdk.core.model.WH wh3 = wh2;
                            if (wh3 != null) {
                                JSONObject jSONObjectSc = wh3.sc();
                                jSONObjectSc.put("is_valid", z11);
                                int i12 = i11;
                                if (i12 > 0 && i12 <= 2) {
                                    jSONObjectSc.put("user_behavior_type", i12);
                                }
                                Map map2 = map;
                                if (map2 != null) {
                                    if (map2.containsKey("duration")) {
                                        jSONObject.put("duration", map.get("duration"));
                                    }
                                    for (Map.Entry entry : map.entrySet()) {
                                        if (!"duration".equals(entry.getKey())) {
                                            jSONObjectSc.put((String) entry.getKey(), entry.getValue());
                                        }
                                    }
                                }
                                jSONObjectSc.put("interaction_method", sfl.wjp());
                                if (str2.equals("open_ad")) {
                                    jSONObjectSc.put("is_icon_only", sfl.LVf() ? 1 : 0);
                                }
                                jSONObject.put("ad_extra_data", jSONObjectSc.toString());
                            }
                            jSONObject.putOpt("log_extra", sfl.mD());
                            float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - sfl.zGQ()).floatValue();
                            if (fFloatValue <= 0.0f) {
                                fFloatValue = 0.0f;
                            }
                            jSONObject.putOpt(TrackingKey.SHOW_TIME, Float.valueOf(fFloatValue));
                            jSONObject.putOpt("ua_policy", Integer.valueOf(sfl.BR()));
                        } catch (Exception unused) {
                        }
                        return jSONObject;
                    }
                });
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.Tf.sc(com.bytedance.sdk.openadsdk.core.Xc.sc())) && "click".equals(str)) {
                    com.bytedance.sdk.openadsdk.We.sc.We.sc(com.bytedance.sdk.openadsdk.JPJ.sc.sc(sfl.fT(), true), 2, sfl.kDg());
                }
                if ("click".equals(str)) {
                    JPJ.zY(sfl);
                }
            }
        });
    }

    @DungeonFlag
    public static void sc(final String str, final Sfl sfl, final String str2, final qr qrVar) {
        if (sfl == null || qrVar == null || !qrVar.sc()) {
            return;
        }
        sc(System.currentTimeMillis(), sfl, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.50
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", str);
                    qr qrVar2 = qrVar;
                    if (qrVar2 != null && qrVar2.pFF() != null) {
                        JSONObject jSONObjectPFF = qrVar.pFF();
                        if (str2.equals("open_ad")) {
                            jSONObjectPFF.put("is_icon_only", sfl.LVf() ? 1 : 0);
                        }
                        jSONObject.put("ad_extra_data", jSONObjectPFF.toString());
                    }
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sc(String str, Sfl sfl, String str2, final Map<String, Object> map) {
        sc(System.currentTimeMillis(), sfl, str2, str, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.47
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (map != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry entry : map.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    private static boolean sc(int i11, String str) {
        int iHJN;
        try {
            Set<String> setGOt = com.bytedance.sdk.openadsdk.core.settings.dE.ef().GOt();
            if ((i11 == 1 && setGOt != null && setGOt.contains(str)) || (iHJN = com.bytedance.sdk.openadsdk.core.settings.dE.ef().HJN(str)) == 0) {
                return true;
            }
            return iHJN != 100 && ((int) ((Math.random() * 100.0d) + 1.0d)) > iHJN;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", th2.getMessage());
            return false;
        }
    }

    public static void zY(Sfl sfl, final com.bytedance.sdk.openadsdk.SR.sc.sc scVar, final String str) {
        sc(System.currentTimeMillis(), sfl, str, "web_behavior_stay", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.29
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", scVar.zY());
                    jSONObject2.put("current_url_index", scVar.We());
                    jSONObject2.put("arbi_stay_duration", scVar.SR());
                    jSONObject2.put("browsing_percentage", scVar.BT());
                    jSONObject2.put("out_focus_scene", scVar.dE());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th2) {
                    Dl.pFF("TTAD.AdEvent", "onWebBehaviorStay", th2.getMessage());
                }
                return jSONObject;
            }
        });
    }

    public static void zY(final Sfl sfl, String str) {
        if (sfl == null || !Sfl.zY(sfl) || sfl.Cwg() == null) {
            return;
        }
        sc(System.currentTimeMillis(), sfl, str, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.26
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", sfl.Cwg().zY());
                    jSONObject2.putOpt("id", sfl.Cwg().sc());
                    jSONObject2.putOpt("md5", sfl.Cwg().pFF());
                    if (sfl.GI() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(sfl.GI().t()));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void zY(Sfl sfl, String str, final int i11) {
        sc(System.currentTimeMillis(), sfl, str, "check_meta_more", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.8
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(TrackingKey.ERROR_CODE, i11);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.dE.ef().ds());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.toString());
                }
                return jSONObject2;
            }
        });
    }

    public static void zY(Sfl sfl, String str, final long j11) {
        sc(System.currentTimeMillis(), sfl, str, "load_feeling_duration", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.6
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", j11);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdEvent", th2.getMessage());
                }
                jSONObject.toString();
                return jSONObject;
            }
        });
    }

    public static void zY(Sfl sfl, final String str, final String str2, final JSONObject jSONObject) {
        if (sfl == null || jSONObject == null) {
            return;
        }
        sc(System.currentTimeMillis(), sfl, str, str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.37
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void zY(Sfl sfl, final String str, final JSONObject jSONObject) {
        sc(System.currentTimeMillis(), sfl, str, pFF.TRI, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.zY.39
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                String str2 = pFF.f27372sc;
                return jSONObject2;
            }
        });
    }
}
