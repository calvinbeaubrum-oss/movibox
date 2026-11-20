package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.widget.Toast;
import com.applovin.sdk.AppLovinMediationProvider;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.II;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.FI;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql extends BT {
    static final ArrayList<String> We = new ArrayList<>(Arrays.asList("ja", "en", "ko", "zh", "th", "vi", "id", "ru", "ar", "fr", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "it", "es", "hi", "pt", "zh-Hant", "ms", "pl", "tr"));
    private Set<String> ExN;
    public boolean zY;

    public Ql(BT.sc scVar) {
        super("tt_sdk_settings.prop", scVar);
        this.ExN = Collections.synchronizedSet(new HashSet());
    }

    public static Set<String> sc(Set<String> set) {
        try {
            if (set == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return new HashSet();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ExN
    public void sc(JSONObject jSONObject) {
        int iOptInt;
        ExN.sc scVarSc = sc();
        JSONObject jSONObjectExN = dE.ef().ExN();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("digest");
        this.zY = (jSONObjectOptJSONObject == null || jSONObjectExN == null || !jSONObjectOptJSONObject.toString().equals(jSONObjectExN.toString())) ? false : true;
        if (jSONObjectOptJSONObject != null) {
            scVarSc.sc("digest", jSONObjectOptJSONObject.toString());
        } else {
            scVarSc.sc("digest");
        }
        scVarSc.sc("data_time", jSONObject.optLong("data_time"));
        if (jSONObject.has("req_inter_min")) {
            long jOptLong = jSONObject.optLong("req_inter_min", 10L) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
            if (jOptLong < 0 || jOptLong > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                jOptLong = TTAdConstant.AD_MAX_EVENT_TIME;
            }
            scVarSc.sc("req_inter_min", jOptLong);
        }
        if (jSONObject.has("lp_new_style")) {
            scVarSc.sc("landingpage_new_style", jSONObject.optInt("lp_new_style", Api.BaseClientBuilder.API_PRIORITY_OTHER));
        }
        if (jSONObject.has("blank_detect_rate")) {
            int iOptInt2 = jSONObject.optInt("blank_detect_rate", 30);
            if (iOptInt2 < 0 || iOptInt2 > 100) {
                iOptInt2 = 30;
            }
            scVarSc.sc("blank_detect_rate", iOptInt2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (jSONObjectOptJSONObject2 != null) {
            if (jSONObjectOptJSONObject2.has("duration")) {
                scVarSc.sc("duration", jSONObjectOptJSONObject2.optLong("duration") * 1000);
            }
            if (jSONObjectOptJSONObject2.has(AppLovinMediationProvider.MAX)) {
                scVarSc.sc(AppLovinMediationProvider.MAX, jSONObjectOptJSONObject2.optInt(AppLovinMediationProvider.MAX));
            }
        }
        if (jSONObject.has("vbtt")) {
            scVarSc.sc("vbtt", jSONObject.optInt("vbtt", 5));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("abtest");
        if (jSONObjectOptJSONObject3 != null) {
            if (jSONObjectOptJSONObject3.has("version")) {
                scVarSc.sc("ab_test_version", jSONObjectOptJSONObject3.optString("version"));
            }
            if (jSONObjectOptJSONObject3.has("param")) {
                scVarSc.sc("ab_test_param", jSONObjectOptJSONObject3.optString("param"));
            }
        } else {
            dE.ef().qr();
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("log_rate_conf");
        if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("global_rate")) {
            scVarSc.sc("global_rate", (float) jSONObjectOptJSONObject4.optDouble("global_rate", 1.0d));
        }
        if (jSONObject.has("pyload_h5")) {
            scVarSc.sc("pyload_h5", jSONObject.optString("pyload_h5"));
        }
        if (jSONObject.has("pure_pyload_h5")) {
            scVarSc.sc("playableLoadH5Url", jSONObject.optString("pure_pyload_h5"));
        }
        if (jSONObject.has("ads_url")) {
            scVarSc.sc("ads_url", jSONObject.optString("ads_url"));
        }
        if (jSONObject.has("app_log_url")) {
            scVarSc.sc("app_log_url", jSONObject.optString("app_log_url"));
        }
        if (jSONObject.has("coppa")) {
            int iOptInt3 = jSONObject.optInt("coppa", -99);
            com.bytedance.sdk.openadsdk.core.Ol.pFF().We(iOptInt3);
            scVarSc.sc("coppa", iOptInt3);
        }
        if (jSONObject.has(CampaignEx.JSON_KEY_PRIVACY_URL)) {
            scVarSc.sc("policy_url", jSONObject.optString(CampaignEx.JSON_KEY_PRIVACY_URL));
        }
        if (jSONObject.has("consent_url")) {
            scVarSc.sc("consent_url", jSONObject.optString("consent_url"));
        }
        if (jSONObject.has("ivrv_downward")) {
            scVarSc.sc("ivrv_downward", jSONObject.optInt("ivrv_downward", 0));
        }
        if (jSONObject.has("dc")) {
            scVarSc.sc("dc", jSONObject.optString("dc"));
        }
        dE.ef().sc(jSONObject, scVarSc);
        dE.ef().pFF(jSONObject, scVarSc);
        if (jSONObject.has("if_both_open")) {
            scVarSc.sc("if_both_open", jSONObject.optInt("if_both_open", 0));
        }
        if (jSONObject.has("support_tnc")) {
            scVarSc.sc("support_tnc", jSONObject.optInt("support_tnc", 1));
        }
        if (jSONObject.has("insert_js_config")) {
            scVarSc.sc("insert_js_config", jSONObject.optString("insert_js_config", ""));
        }
        if (jSONObject.has("max_tpl_cnts")) {
            scVarSc.sc("max_tpl_cnts", jSONObject.optInt("max_tpl_cnts", 100));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject5 != null) {
            if (jSONObjectOptJSONObject5.has("force_language")) {
                String strOptString = jSONObjectOptJSONObject5.optString("force_language");
                if (!TextUtils.isEmpty(strOptString) && We.contains(strOptString)) {
                    scVarSc.sc("force_language", strOptString);
                }
            }
            if (jSONObjectOptJSONObject5.has("fetch_tpl_timeout_ctrl")) {
                scVarSc.sc("fetch_tpl_timeout_ctrl", jSONObjectOptJSONObject5.optInt("fetch_tpl_timeout_ctrl", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS));
            }
            if (jSONObjectOptJSONObject5.has("fetch_tpl_second")) {
                scVarSc.sc("fetch_tpl_second", jSONObjectOptJSONObject5.optInt("fetch_tpl_second", 0));
            }
            if (jSONObjectOptJSONObject5.has("support_gzip")) {
                scVarSc.sc("support_gzip", jSONObjectOptJSONObject5.optBoolean("support_gzip", false));
            }
            if (jSONObjectOptJSONObject5.has("aes_key")) {
                scVarSc.sc("aes_key", jSONObjectOptJSONObject5.optString("aes_key"));
            }
            if (jSONObjectOptJSONObject5.has("support_rtl")) {
                scVarSc.sc("support_rtl", jSONObjectOptJSONObject5.optBoolean("support_rtl", false));
            }
            if (jSONObjectOptJSONObject5.has("ad_revenue_enable")) {
                scVarSc.sc("ad_revenue_enable", jSONObjectOptJSONObject5.optBoolean("ad_revenue_enable", false));
            }
            if (jSONObjectOptJSONObject5.has("gecko_hosts")) {
                try {
                    this.ExN.clear();
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject5.optJSONArray("gecko_hosts");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                            this.ExN.add(jSONArrayOptJSONArray.getString(i11));
                        }
                    }
                    this.ExN = sc(this.ExN);
                    scVarSc.sc("gecko_hosts", jSONArrayOptJSONArray.toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF("GeckoLog: settings json error ".concat(String.valueOf(th2)));
                }
            }
        }
        if (jSONObject.has("read_video_from_cache")) {
            scVarSc.sc("read_video_from_cache", jSONObject.optInt("read_video_from_cache", 1));
        }
        zY.sc(jSONObject.optJSONArray("ad_slot_conf_list"));
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("privacy");
        if (jSONObjectOptJSONObject6 != null) {
            if (jSONObjectOptJSONObject6.has("ad_enable")) {
                scVarSc.sc("privacy_ad_enable", jSONObjectOptJSONObject6.optInt("ad_enable", Api.BaseClientBuilder.API_PRIORITY_OTHER));
            }
            if (jSONObjectOptJSONObject6.has("personalized_ad")) {
                scVarSc.sc("privacy_personalized_ad", jSONObjectOptJSONObject6.optInt("personalized_ad", Api.BaseClientBuilder.API_PRIORITY_OTHER));
            }
            if (jSONObjectOptJSONObject6.has("sladar_enable")) {
                scVarSc.sc("privacy_sladar_enable", jSONObjectOptJSONObject6.optInt("sladar_enable", Api.BaseClientBuilder.API_PRIORITY_OTHER));
            }
            if (jSONObjectOptJSONObject6.has("app_log_enable")) {
                scVarSc.sc("privacy_app_log_enable", jSONObjectOptJSONObject6.optInt("app_log_enable", Api.BaseClientBuilder.API_PRIORITY_OTHER));
            }
            if (jSONObjectOptJSONObject6.has("debug_unlock")) {
                scVarSc.sc("privacy_debug_unlock", jSONObjectOptJSONObject6.optInt("debug_unlock", Api.BaseClientBuilder.API_PRIORITY_OTHER));
            }
            if (jSONObjectOptJSONObject6.has("fields_allowed")) {
                String strOptString2 = jSONObjectOptJSONObject6.optString("fields_allowed", "");
                if (TextUtils.isEmpty(strOptString2)) {
                    scVarSc.sc("privacy_fields_allowed");
                } else {
                    scVarSc.sc("privacy_fields_allowed", strOptString2);
                }
            }
            if (jSONObjectOptJSONObject6.has("app_reg")) {
                int iOptInt4 = jSONObjectOptJSONObject6.optInt("app_reg", 1);
                if (iOptInt4 == 0 && II.sc().qr() == 1) {
                    Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.Ql.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(Xc.sc(), "Appid is not registered on pangle media platform", 1).show();
                        }
                    });
                }
                scVarSc.sc("privacy_app_reg", iOptInt4 != 0);
            }
        }
        if (jSONObject.has("video_cache_config")) {
            scVarSc.sc("video_cache_config", jSONObject.optString("video_cache_config"));
        }
        if (jSONObject.has("loaded_recall_time")) {
            int iOptInt5 = jSONObject.optInt("loaded_recall_time", 0);
            if (iOptInt5 != 0 && iOptInt5 != 1) {
                iOptInt5 = 0;
            }
            scVarSc.sc("loadedCallbackOpportunity", iOptInt5);
        }
        if (jSONObject.has("load_strategy")) {
            int iOptInt6 = jSONObject.optInt("load_strategy", 0);
            if (iOptInt6 != 0 && iOptInt6 != 1) {
                iOptInt6 = 0;
            }
            scVarSc.sc("load_callback_strategy", iOptInt6);
        }
        if (jSONObject.has("splash_video_load_strategy")) {
            int iOptInt7 = jSONObject.optInt("splash_video_load_strategy", 0);
            if (iOptInt7 < 0 || iOptInt7 > 3) {
                iOptInt7 = 0;
            }
            scVarSc.sc("splash_video_load_strategy", iOptInt7);
        }
        if (jSONObject.has("allow_blind_mode_request_ad")) {
            scVarSc.sc("allow_blind_mode_request_ad", jSONObject.optBoolean("allow_blind_mode_request_ad", false));
        }
        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("bus_con");
        if (jSONObjectOptJSONObject7 != null) {
            if (jSONObjectOptJSONObject7.has("bus_con_send_log_type")) {
                scVarSc.sc("bus_con_send_log_type", jSONObjectOptJSONObject7.optInt("bus_con_send_log_type", 1));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_sec_type")) {
                scVarSc.sc("bus_con_sec_type", jSONObjectOptJSONObject7.optInt("bus_con_sec_type", Api.BaseClientBuilder.API_PRIORITY_OTHER));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_dislike_report_raw")) {
                scVarSc.sc("bus_con_dislike_report_raw", jSONObjectOptJSONObject7.optBoolean("bus_con_dislike_report_raw", false));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_adshow_check_enable")) {
                scVarSc.sc("bus_con_adshow_check_enable", jSONObjectOptJSONObject7.optBoolean("bus_con_adshow_check_enable", true));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_tnc_interval")) {
                scVarSc.sc("bus_con_tnc_interval", jSONObjectOptJSONObject7.optLong("bus_con_tnc_interval", TTAdConstant.AD_MAX_EVENT_TIME));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_token_thread_count")) {
                scVarSc.sc("bus_con_token_thread_count", jSONObjectOptJSONObject7.optInt("bus_con_token_thread_count", 4));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_video_keep_screen_on")) {
                scVarSc.sc("bus_con_video_keep_screen_on", jSONObjectOptJSONObject7.optInt("bus_con_video_keep_screen_on", 1));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_auto_click_delay")) {
                scVarSc.sc("bus_con_auto_click_delay", jSONObjectOptJSONObject7.optInt("bus_con_auto_click_delay", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_express_host")) {
                scVarSc.sc("bus_con_express_host", jSONObjectOptJSONObject7.optString("bus_con_express_host", "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/"));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_rewardedfull_link")) {
                scVarSc.sc("bus_con_rewardedfull_link", jSONObjectOptJSONObject7.optInt("bus_con_rewardedfull_link", 0));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_check_clz")) {
                scVarSc.sc("bus_con_check_clz", jSONObjectOptJSONObject7.optString("bus_con_check_clz", ""));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_url_check")) {
                scVarSc.sc("bus_con_url_check", jSONObjectOptJSONObject7.optInt("bus_con_url_check", 1));
            }
            if (jSONObjectOptJSONObject7.has("bus_con_behavior_count")) {
                scVarSc.sc("bus_con_behavior_count", jSONObjectOptJSONObject7.optInt("bus_con_behavior_count", LogSeverity.NOTICE_VALUE));
            }
            String str = dE.f28498sc;
            if (jSONObjectOptJSONObject7.has(str)) {
                scVarSc.sc(str, jSONObjectOptJSONObject7.optBoolean(str, false));
            }
            String str2 = dE.pFF;
            if (jSONObjectOptJSONObject7.has(str2)) {
                scVarSc.sc(str2, jSONObjectOptJSONObject7.optInt(str2, 10000));
            }
            String str3 = dE.zY;
            if (jSONObjectOptJSONObject7.has(str3)) {
                scVarSc.sc(str3, (float) jSONObjectOptJSONObject7.optDouble(str3, 1.0d));
            }
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("perf_con");
                if (jSONObjectOptJSONObject8 != null) {
                    if (jSONObjectOptJSONObject8.has("perf_con_stats_rate")) {
                        String strOptString3 = jSONObjectOptJSONObject8.optString("perf_con_stats_rate");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            scVarSc.sc("perf_con_stats_rate", strOptString3);
                        }
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_applog_send")) {
                        String strOptString4 = jSONObjectOptJSONObject8.optString("perf_con_applog_send");
                        if (!TextUtils.isEmpty(strOptString4)) {
                            scVarSc.sc("perf_con_applog_send", strOptString4);
                        }
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_apm_native")) {
                        scVarSc.sc("perf_con_apm_native", jSONObjectOptJSONObject8.optInt("perf_con_apm_native"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_preload_cache")) {
                        scVarSc.sc("perf_con_webview_preload_cache", jSONObjectOptJSONObject8.optInt("perf_con_webview_preload_cache"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_preload_cache_v3")) {
                        scVarSc.sc("perf_con_webview_preload_cache_v3", jSONObjectOptJSONObject8.optInt("perf_con_webview_preload_cache_v3"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_cache_count")) {
                        scVarSc.sc("perf_con_webview_cache_count", jSONObjectOptJSONObject8.optInt("perf_con_webview_cache_count", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_webview_cache_count_v3")) {
                        scVarSc.sc("perf_con_webview_cache_count_v3", jSONObjectOptJSONObject8.optInt("perf_con_webview_cache_count_v3", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_thread_stack_size") && (iOptInt = jSONObjectOptJSONObject8.optInt("perf_con_thread_stack_size")) >= -524288 && iOptInt <= 0) {
                        scVarSc.sc("perf_con_thread_stack_size", iOptInt);
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_use_new_thread_pool")) {
                        scVarSc.sc("perf_con_use_new_thread_pool", jSONObjectOptJSONObject8.optInt("perf_con_use_new_thread_pool", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_thread_pool_config")) {
                        String strOptString5 = jSONObjectOptJSONObject8.optString("perf_con_thread_pool_config");
                        if (!TextUtils.isEmpty(strOptString5)) {
                            scVarSc.sc("perf_con_thread_pool_config", strOptString5);
                        }
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_is_new_net_thread")) {
                        scVarSc.sc("perf_con_is_new_net_thread", jSONObjectOptJSONObject8.optInt("perf_con_is_new_net_thread", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_use_prop")) {
                        FI.sc(jSONObjectOptJSONObject8.optInt("perf_con_use_prop", 1));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_adlog_expire_time")) {
                        scVarSc.sc("perf_con_adlog_expire_time", jSONObjectOptJSONObject8.optLong("perf_con_adlog_expire_time"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_adlog_turn_off_retry_ad")) {
                        scVarSc.sc("perf_con_adlog_turn_off_retry_ad", jSONObjectOptJSONObject8.optLong("perf_con_adlog_turn_off_retry_ad"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_adlog_turn_off_retry_stats")) {
                        scVarSc.sc("perf_con_adlog_turn_off_retry_stats", jSONObjectOptJSONObject8.optLong("perf_con_adlog_turn_off_retry_stats"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_applog_rate")) {
                        scVarSc.sc("perf_con_applog_rate", jSONObjectOptJSONObject8.optString("perf_con_applog_rate"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_track_url_strategy")) {
                        scVarSc.sc("perf_con_track_url_strategy", jSONObjectOptJSONObject8.optString("perf_con_track_url_strategy"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_drawable_code")) {
                        scVarSc.sc("perf_con_drawable_code", jSONObjectOptJSONObject8.optInt("perf_con_drawable_code", 0));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_close_button_delay_check_time")) {
                        scVarSc.sc("perf_con_close_button_delay_check_time", jSONObjectOptJSONObject8.optInt("perf_con_close_button_delay_check_time", -1));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_drop2rt_skip_label_list")) {
                        scVarSc.sc("perf_con_drop2rt_skip_label_list", jSONObjectOptJSONObject8.optString("perf_con_drop2rt_skip_label_list"));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_crypt_V4_get_ad")) {
                        scVarSc.sc("perf_con_crypt_V4_get_ad", jSONObjectOptJSONObject8.optBoolean("perf_con_crypt_V4_get_ad", false));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_crypt_V4_applog")) {
                        scVarSc.sc("perf_con_crypt_V4_applog", jSONObjectOptJSONObject8.optBoolean("perf_con_crypt_V4_applog", false));
                    }
                    if (jSONObjectOptJSONObject8.has("perf_con_crypt_V4")) {
                        scVarSc.sc("perf_con_crypt_V4", jSONObjectOptJSONObject8.optBoolean("perf_con_crypt_V4", false));
                    }
                }
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.Tf.sc("SettingsDefaultRepository", th3.getMessage());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("app_common_config", jSONObjectOptJSONObject5);
            jSONObject2.put("perf_con", jSONObject.optJSONObject("perf_con"));
            jSONObject2.put("bus_con", jSONObject.optJSONObject("bus_con"));
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("SettingsDefaultRepository", "coreSettingJson", e11.getMessage());
        }
        scVarSc.sc("core_settings", jSONObject2.toString());
        if (jSONObject.has("dual_event_url")) {
            scVarSc.sc("dual_event_url", jSONObject.optString("dual_event_url"));
        }
        scVarSc.sc();
        dE.ef().HJN();
        We();
    }
}
