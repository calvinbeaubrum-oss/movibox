package com.bytedance.sdk.openadsdk.core;

import com.applovin.sdk.AppLovinErrorCodes;
import com.hisavana.common.bean.TAdErrorCode;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {
    public static String sc(int i11) {
        try {
            if (i11 == -16) {
                return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_ad_able_false_msg");
            }
            if (i11 == -15) {
                return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_lack_android_manifest_configuration");
            }
            if (i11 == 117) {
                return "dynamic1 render time_out";
            }
            if (i11 == 118) {
                return "dynamic1 render error";
            }
            if (i11 == 127) {
                return "dynamic2 render time_out";
            }
            if (i11 == 128) {
                return "dynamic2 render error";
            }
            if (i11 == 137) {
                return "ugen render time_out";
            }
            if (i11 == 138) {
                return "ugen render error";
            }
            if (i11 == 201) {
                return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_load_creative_icon_response_error");
            }
            if (i11 == 202) {
                return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_load_creative_icon_error");
            }
            if (i11 == 10002) {
                return "load time out";
            }
            if (i11 == 10003) {
                return "resource error";
            }
            switch (i11) {
                case -100:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_init_setting_config_not_complete");
                case 113:
                    return "dynamic1 parse error";
                case 123:
                    return "dynamic2 parse error";
                case 133:
                    return "ugen parse error";
                case TAdErrorCode.CODE_FILL_FAILED_WITH_NO_AD /* 20001 */:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_no_ad");
                case 40000:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_content_type");
                case TAdErrorCode.CODE_TRIGGER_SHOW_ONLINE_NO_AD /* 40001 */:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_request_pb_error");
                case TAdErrorCode.CODE_TRIGGER_SHOW_OFFLINE_NO_AD /* 40002 */:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_app_empty");
                case 40003:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_wap_empty");
                case 40004:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_adslot_empty");
                case 40005:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_adslot_size_empty");
                case 40006:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_adslot_id_error");
                case 40007:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_code_adcount_error");
                case 40008:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_image_size");
                case 40009:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_media_id");
                case 40010:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_media_type");
                case 40011:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_ad_type");
                case 40012:
                case 40017:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_access_method_pass");
                case 40013:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_splash_ad_type");
                case 40014:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_redirect");
                case 40015:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_request_invalid");
                case 40016:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_slot_id_app_id_differ");
                case 40018:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_package_name");
                case 40019:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_adtype_differ");
                case 40020:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_new_register_limit");
                case 40021:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_apk_sign_check_error");
                case 40022:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_origin_ad_error");
                case 40023:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_union_os_error");
                case 40024:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_union_sdk_too_old");
                case 40026:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_device_ip");
                case 40028:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_update_version");
                case 40034:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_bidding_type");
                case 40042:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_interstitial_version");
                case 40052:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_empty_content");
                case 40060:
                    return "Appid is not registered on pangle media platform";
                case TAdErrorCode.CODE_SHOW_EXCEPTION /* 50001 */:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_sys_error");
                case TAdErrorCode.CODE_SHOW_VULGAR /* 60007 */:
                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_verify_reward");
                default:
                    switch (i11) {
                        case -12:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_splash_not_have_cache_error");
                        case -11:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_splash_cache_expired_error");
                        case -10:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_splash_cache_parse_error");
                        case -9:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_request_body_error");
                        case AppLovinErrorCodes.INVALID_AD_TOKEN /* -8 */:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_frequent_call_erroe");
                        case AppLovinErrorCodes.INVALID_ZONE /* -7 */:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_splash_ad_load_image_error");
                        case AppLovinErrorCodes.UNABLE_TO_RENDER_AD /* -6 */:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_insert_ad_load_image_error");
                        case C.RESULT_FORMAT_READ /* -5 */:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_banner_ad_load_image_error");
                        case C.RESULT_BUFFER_READ /* -4 */:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_ad_data_error");
                        case C.RESULT_NOTHING_READ /* -3 */:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_no_ad_parse");
                        case -2:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_net_error");
                        case -1:
                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_parse_fail");
                        default:
                            switch (i11) {
                                case 101:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_render_render_parse_error");
                                case 102:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_render_main_template_invalid");
                                case Worker.WHAT_SYNC_DATA /* 103 */:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_render_diff_template_invalid");
                                case 104:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_render_fail_meta_invalid");
                                case 105:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_render_fail_template_parse_error");
                                case 106:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_render_fail_unknown");
                                case 107:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_render_fail_timeout");
                                case 108:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_reder_ad_load_timeout");
                                case 109:
                                    return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_template_load_fail");
                                default:
                                    switch (i11) {
                                        case TAdErrorCode.CODE_INVALID_APP_ID /* 60001 */:
                                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_ror_code_show_event_error");
                                        case TAdErrorCode.CODE_CURRENT_OBJECT_IS_DESTROYED /* 60002 */:
                                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_code_click_event_error");
                                        default:
                                            return com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_error_unknow");
                                    }
                            }
                    }
            }
        } catch (Throwable unused) {
            return "";
        }
    }
}
