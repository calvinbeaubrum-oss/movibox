package com.cloud.hisavana.sdk.common.athena;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.hisavana.net.NetGroup;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.hisavana.sdk.common.bean.ProgressData;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.request.FormBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.ext.attr.AttrData;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.sdk.commonutil.util.j;
import com.cloud.sdk.commonutil.util.r;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.web.api.WebConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import w9.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AthenaTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f29385a = false;

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.athena.AthenaTracker$14, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ String val$gplink;
        final /* synthetic */ AdsDTO val$info;

        public AnonymousClass14(AdsDTO adsDTO, String str) {
            this.val$info = adsDTO;
            this.val$gplink = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.X(this.val$info, this.val$gplink);
        }
    }

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.athena.AthenaTracker$19, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ AdsDTO val$adsDTO;

        public AnonymousClass19(AdsDTO adsDTO) {
            this.val$adsDTO = adsDTO;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.z(this.val$adsDTO);
        }
    }

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.athena.AthenaTracker$6, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String val$requestId;

        public AnonymousClass6(String str) {
            this.val$requestId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.E(this.val$requestId);
        }
    }

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.athena.AthenaTracker$7, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ int val$errorCode;
        final /* synthetic */ String val$requestId;

        public AnonymousClass7(String str, int i11) {
            this.val$requestId = str;
            this.val$errorCode = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.F(this.val$requestId, this.val$errorCode);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public enum ClickJumpType {
        PS_FULL_SCREEN(0),
        PS_HALF_SCREEN(1),
        GP(3),
        PULL_LIVE(4),
        OTHER(5);

        private final int rawValue;

        ClickJumpType(int i11) {
            this.rawValue = i11;
        }

        public int rawValue() {
            return this.rawValue;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class a {
        public static void A(List<AdsDTO> list, String str, String str2, long j11) {
            AdxImpBean impBeanRequest;
            Bundle bundleM = AthenaTracker.m(null);
            AdsDTO adsDTO = list.get(0);
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null || (impBeanRequest = adsDTO.getImpBeanRequest()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (AdsDTO adsDTO2 : list) {
                if (adsDTO2 != null) {
                    arrayList.add(adsDTO2.getAdCreativeId());
                }
            }
            bundleM.putString(TrackingKey.TRIGGER_ID, str);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, str2);
            bundleM.putString(TrackingKey.AD_CREATE_IDS, TextUtils.join(",", arrayList));
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putString("expired_date", adsDTO.getExpiredDate());
            bundleM.putLong("time_consuming", j11);
            bundleM.putString(TrackingKey.ECPM, String.valueOf(adsDTO.getFirstPrice()));
            bundleM.putString("campaignname", adsDTO.getCampaignname());
            bundleM.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
            bundleM.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
            bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, impBeanRequest.mTriggerNetState);
            new dr.a("ssp_filling_result_default", 8765).c(bundleM, null).b();
        }

        public static void B(String str) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, str);
            bundleM.putString("app_id", AdManager.f29117b);
            new dr.a("ssp_ad_request_default", 8765).c(bundleM, null).b();
        }

        public static void C(String str, int i11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, str);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(i11));
            new dr.a("ssp_ad_return_default", 8765).c(bundleM, null).b();
        }

        public static void D(AdsDTO adsDTO) {
            if (adsDTO == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest() != null ? adsDTO.getImpBeanRequest() : null;
            if (impBeanRequest == null) {
                return;
            }
            bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putLong("show_report_time_type", adsDTO.getShowReportTimeType().intValue());
            bundleM.putString("expired_date", adsDTO.getExpiredDate());
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putString(TrackingKey.ECPM, String.valueOf(adsDTO.getFirstPrice()));
            bundleM.putString("campaignname", adsDTO.getCampaignname());
            bundleM.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
            bundleM.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
            bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, impBeanRequest.mTriggerNetState);
            bundleM.putString("tracking_secret_key", adsDTO.getShowTrackingSecretKey());
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt("is_inapp_ad", 1);
            bundleM.putString("material_style", h(adsDTO));
            bundleM.putInt("close_delay_time", adsDTO.getCloseDelayTime());
            new dr.a("ssp_show_inapp", 2411).c(bundleM, null).b();
        }

        public static void E(String str) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, str);
            bundleM.putString("app_id", AdManager.f29117b);
            new dr.a("ssp_ad_request_zip", 8765).c(bundleM, null).b();
        }

        public static void F(String str, int i11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, str);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putInt(TrackingKey.ERROR_CODE, i11);
            bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(i11));
            new dr.a("ssp_ad_return_zip", 8765).c(bundleM, null).b();
        }

        public static void G(AdsDTO adsDTO, FormBean formBean) {
            if (adsDTO == null || formBean == null) {
                return;
            }
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest() != null ? adsDTO.getImpBeanRequest() : null;
            if (impBeanRequest == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, 1);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString("form_info", GsonUtil.d(formBean));
            bundleM.putInt("material_type", adsDTO.getMaterialType().intValue());
            new dr.a("form_infor_set", 8765).c(bundleM, null).b();
        }

        public static void H(AdsDTO adsDTO, String str, String str2) {
            AdxImpBean impBeanRequest;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Bundle bundleM = AthenaTracker.m(null);
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        Object obj = jSONObject.get(next);
                        if (obj != null) {
                            z.a().d("ssp", obj.toString());
                            String simpleName = obj.getClass().getSimpleName();
                            if (simpleName.equals("Integer")) {
                                bundleM.putInt(next, ((Integer) jSONObject.get(next)).intValue());
                            } else if (simpleName.equals("Double")) {
                                bundleM.putDouble(next, ((Double) jSONObject.get(next)).doubleValue());
                            } else if (simpleName.equals("Long")) {
                                bundleM.putLong(next, ((Long) jSONObject.get(next)).longValue());
                            } else if (simpleName.equals("String")) {
                                bundleM.putString(next, (String) jSONObject.get(next));
                            } else if (simpleName.equals("Boolean")) {
                                bundleM.putBoolean(next, ((Boolean) jSONObject.get(next)).booleanValue());
                            } else {
                                z.a().d("ssp", "type not supported");
                            }
                        }
                    }
                }
                if (adsDTO != null) {
                    bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
                    bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
                    bundleM.putString("plan_id", adsDTO.getPlanId());
                    bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
                    bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                    bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
                    impBeanRequest = adsDTO.getImpBeanRequest();
                } else {
                    impBeanRequest = null;
                }
                if (impBeanRequest != null) {
                    bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
                    bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
                }
                bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                new dr.a(str, 8765).c(bundleM, null).b();
            } catch (JSONException e11) {
                z.a().e(Log.getStackTraceString(e11));
            }
        }

        public static void I(AttrData attrData) {
            if (attrData == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putLong(TrackingKey.EVENT_TS, attrData.getEventTs());
            bundleM.putInt(TrackingKey.ERROR_CODE, attrData.getErrorCode());
            bundleM.putInt("ct", attrData.getCount());
            bundleM.putInt("fail_c", attrData.getFailCount());
            bundleM.putString("error_list", attrData.getErrorList());
            bundleM.putString("link_id", attrData.getLinkId());
            bundleM.putString(TrackingKey.AD_CREATE_IDS, attrData.getCreatives());
            new dr.a("imp_sync", 8765).c(bundleM, null).b();
        }

        public static void J() {
            new dr.a("sdk_initalize", 8765).c(AthenaTracker.m(null), null).b();
        }

        public static void K(AdsDTO adsDTO, int i11) {
            if (adsDTO == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putString(TrackingKey.REQUEST_ID, adsDTO.getRid());
            bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putInt("process", i11);
            new dr.a("show_process", 8765).c(bundleM, null).b();
        }

        public static void L(boolean z11, int i11, String str, String str2, int i12, int i13, String str3, String str4, Map<String, Object> map, int i14) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putInt("offline_ad_enable", z11 ? 1 : 0);
            bundleM.putInt("ad_type", i11);
            bundleM.putString(TrackingKey.TRIGGER_ID, str);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, str2);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt(TrackingKey.AD_COUNT, i12);
            bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, i13);
            bundleM.putInt(TrackingKey.IS_RETREATAD, 0);
            bundleM.putString(TrackingKey.GAME_NAME, str3);
            bundleM.putString(TrackingKey.GAME_SCENE, str4);
            bundleM.putString("ext_info", map == null ? null : GsonUtil.d(map));
            bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(i14));
            if (NetGroup.c() && NetGroup.d() > 0) {
                bundleM.putInt("net_bucket_id", NetGroup.d());
            }
            AthenaTracker.k(bundleM);
            new dr.a("media_call_request", 8765).c(bundleM, null).b();
        }

        public static void M(AdsDTO adsDTO, int i11) {
            Bundle bundleI = i(adsDTO);
            if (bundleI != null) {
                bundleI.putInt("pop_status", i11);
                bundleI.putInt("is_skip", i11 == 4 ? 1 : 0);
                new dr.a("miniapp_add_homescreen_guide", 8765).c(bundleI, null).b();
            }
        }

        public static void N(AdsDTO adsDTO, int i11) {
            Bundle bundleI = i(adsDTO);
            if (bundleI != null) {
                bundleI.putInt("os_pop_status", i11);
                new dr.a("miniapp_sys_add_homescreen", 8765).c(bundleI, null).b();
            }
        }

        public static void O(AdsDTO adsDTO) {
            Bundle bundleM = AthenaTracker.m(null);
            AdxImpBean impBeanRequest = (adsDTO == null || adsDTO.getImpBeanRequest() == null) ? null : adsDTO.getImpBeanRequest();
            if (impBeanRequest != null) {
                bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
                bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
                bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
                bundleM.putInt("offline_ad_enable", impBeanRequest.offlineAdEnable ? 1 : 0);
                bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, impBeanRequest.mTriggerNetState);
            }
            ca.b.v0(bundleM);
            PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
            int i11 = 1;
            bundleM.putInt("is_install_ps", packageInfoC == null ? 0 : 1);
            bundleM.putString("ps_version", packageInfoC == null ? "" : String.valueOf(packageInfoC.versionCode));
            if (adsDTO == null) {
                bundleM.putInt("is_ps_type", 0);
            } else {
                bundleM.putInt("is_ps_type", x.a(adsDTO) ? 1 : 0);
                bundleM.putString("click_link", adsDTO.getClick_link());
                bundleM.putString("ps_packagename", adsDTO.getPsPackageName());
                bundleM.putInt("is_jump_to_halfscreen", adsDTO.isJumpToHalfscreen() ? 1 : 0);
                bundleM.putInt("is_halfscreen_ad", adsDTO.getPslinkInfoStatus() ? 1 : 0);
                bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
                bundleM.putString("app_id", AdManager.f29117b);
                bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                bundleM.putString("tracking_secret_key", adsDTO.getShowTrackingSecretKey());
                bundleM.putInt(TrackingKey.SLOT_HEIGHT, adsDTO.getViewHeight());
                bundleM.putInt(TrackingKey.SLOT_WIDTH, adsDTO.getViewWidth());
                bundleM.putInt("material_type", adsDTO.isInteractiveAd() ? 4 : adsDTO.getMaterialType().intValue());
                if (!AdManager.i() && !adsDTO.getTestResponse().booleanValue()) {
                    i11 = 0;
                }
                bundleM.putInt("is_test_request", i11);
                bundleM.putString("half_screen_type", adsDTO.getHalfScreenType());
                bundleM.putInt("track_type", adsDTO.getTrackType().intValue());
                bundleM.putInt("show_times", adsDTO.getShowTime().intValue());
                bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
                bundleM.putInt(TrackingKey.PLATFORM, adsDTO.getDspType().intValue());
                bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
                bundleM.putString("material_style", h(adsDTO));
                bundleM.putInt("close_delay_time", adsDTO.getCloseDelayTime());
            }
            AthenaTracker.l(adsDTO, bundleM);
            AthenaTracker.k(bundleM);
            new dr.a("ssp_new_click", 8765).c(bundleM, null).b();
        }

        public static void P(String str, int i11, int i12) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, str);
            bundleM.putInt(TrackingKey.REQUEST_TYPE, i11);
            bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(i12));
            new dr.a("offline_result", 8765).c(bundleM, null).b();
        }

        public static void Q(AdsDTO adsDTO) {
            AdxImpBean impBeanRequest;
            if (adsDTO == null || (impBeanRequest = adsDTO.getImpBeanRequest()) == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt(TrackingKey.PLATFORM, adsDTO.getDspType().intValue());
            bundleM.putInt("ad_type", adsDTO.getAdType());
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putString("gaid", DeviceUtil.e());
            bundleM.putLong("show_duration", adsDTO.getTriggerShowSpend());
            bundleM.putString("sspsdk_version", ca.d.l());
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putInt("track_type", adsDTO.getTrackType().intValue());
            bundleM.putInt("video_reward_time", adsDTO.getRewardDuration().intValue());
            VastData videoInfo = adsDTO.getVideoInfo();
            if (videoInfo != null && videoInfo.getDuration() != null) {
                bundleM.putInt("video_duration", videoInfo.getDuration().intValue());
            }
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putInt("is_inapp_ad", adsDTO.getSource() == 4 ? 1 : 0);
            new dr.a("ssp_ad_reward", 8765).c(bundleM, null).b();
        }

        public static void R(AdsDTO adsDTO) {
            if (adsDTO == null) {
                return;
            }
            z.a().d("ssp", "currentThread().getId()" + Thread.currentThread().getId());
            Bundle bundle = new Bundle();
            bundle.putDouble(BidResponsed.KEY_PRICE, adsDTO.getFirstPrice().doubleValue());
            bundle.putString("new_price", adsDTO.getNewPrice());
            bundle.putInt("popularize_app_install_status", adsDTO.getInstallApk());
            bundle.putLong("show_duration", adsDTO.getActualShowTime().longValue());
            bundle.putString("show_area", adsDTO.getShowArea());
            bundle.putLong("show_report_time_type", adsDTO.getShowReportTimeType().intValue());
            bundle.putInt("is_adm_ad", TextUtils.isEmpty(adsDTO.getAdm()) ? 1 : 2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(adsDTO.getAdCreativeId());
            bundle.putString(TrackingKey.AD_CREATE_IDS, TextUtils.join(",", arrayList));
            if (adsDTO.isOfflineAd()) {
                bundle.putLong("ad_expire_time", adsDTO.getOfflineAdExpireTime().longValue());
            }
            bundle.putInt("show_times", adsDTO.getShowNum().intValue());
            bundle.putInt("source", adsDTO.getSource());
            bundle.putInt("material_type", adsDTO.isInteractiveAd() ? 4 : 2);
            if (adsDTO.getImpBeanRequest() != null) {
                bundle.putString(TrackingKey.TRIGGER_ID, adsDTO.getImpBeanRequest().triggerId);
            }
            bundle.putInt("image_width", adsDTO.getAdImageWidth().intValue());
            bundle.putInt("image_height", adsDTO.getAdImageHeight().intValue());
            bundle.putString("package_name", adsDTO.getPackageName());
            bundle.putString(CampaignEx.JSON_KEY_CLICK_URL, adsDTO.getClickUrl());
            bundle.putInt(TrackingKey.IS_DEFAULT_AD, 0);
            bundle.putInt("is_default_ad_first_show", 0);
            PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
            bundle.putInt("is_install_ps", packageInfoC == null ? 0 : 1);
            bundle.putString("ps_version", packageInfoC == null ? "" : String.valueOf(packageInfoC.versionCode));
            bundle.putInt("is_ps_type", x.a(adsDTO) ? 1 : 0);
            bundle.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundle.putInt("is_halfscreen_ad", adsDTO.getPslinkInfoStatus() ? 1 : 0);
            bundle.putInt("material_type", adsDTO.getMaterialType().intValue());
            bundle.putInt(TrackingKey.SLOT_HEIGHT, adsDTO.getViewHeight());
            bundle.putInt(TrackingKey.SLOT_WIDTH, adsDTO.getViewWidth());
            ca.b.v0(bundle);
            bundle.putString("half_screen_type", adsDTO.getHalfScreenType());
            bundle.putInt("track_type", adsDTO.getTrackType().intValue());
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
            if (impBeanRequest != null) {
                bundle.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
                bundle.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
                bundle.putString("ext_info", impBeanRequest.getExtInfoJson());
                bundle.putInt("offline_ad_enable", impBeanRequest.offlineAdEnable ? 1 : 0);
            }
            if (NetGroup.c() && NetGroup.d() > 0) {
                bundle.putInt("net_bucket_id", NetGroup.d());
            }
            AthenaTracker.k(bundle);
            AthenaTracker.l(adsDTO, bundle);
            bundle.putString("material_style", h(adsDTO));
            bundle.putInt("close_delay_time", adsDTO.getCloseDelayTime());
            new dr.a("ad_ssp_show", 2411).c(g(adsDTO, bundle), null).b();
        }

        public static void S(AdsDTO adsDTO, String str, int i11) {
            if (adsDTO == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("error_url", str);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString(TrackingKey.REQUEST_ID, adsDTO.getRid());
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt(TrackingKey.ERROR_CODE, i11);
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            new dr.a("show_adm_error", 8765).c(bundleM, null).b();
        }

        public static void T(String str, int i11, int i12, long j11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("download_url", str);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt("download_way", i11);
            bundleM.putInt("m_status", i12);
            bundleM.putLong("file_size", j11);
            new dr.a("material_slice_download", 8765).c(bundleM, null).b();
        }

        public static void U(AdsDTO adsDTO, int i11) {
            AdxImpBean impBeanRequest;
            if (adsDTO == null || (impBeanRequest = adsDTO.getImpBeanRequest()) == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putInt("expired_count", i11);
            new dr.a("material_expire", 8765).c(bundleM, null).b();
        }

        public static void V(AdsDTO adsDTO, Integer num) {
            if (adsDTO == null) {
                return;
            }
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest() != null ? adsDTO.getImpBeanRequest() : null;
            if (impBeanRequest == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt(TrackingKey.REQUEST_TYPE, impBeanRequest.requestType);
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putInt("cache_time", adsDTO.getCacheTime().intValue());
            bundleM.putString("id", adsDTO.getId().toString());
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putLong("show_times", adsDTO.getShowNum().intValue());
            bundleM.putLong("show_duration", adsDTO.getActualShowTime().longValue());
            bundleM.putString("show_area", adsDTO.getShowArea());
            bundleM.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
            bundleM.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
            bundleM.putString("ext_info", impBeanRequest.getExtInfoJson());
            bundleM.putInt(TrackingKey.SLOT_HEIGHT, adsDTO.getViewHeight());
            bundleM.putInt(TrackingKey.SLOT_WIDTH, adsDTO.getViewWidth());
            bundleM.putInt("material_type", adsDTO.getMaterialType().intValue());
            if (num != null) {
                bundleM.putInt("close_type", num.intValue());
            }
            bundleM.putInt("close_delay_time", adsDTO.getCloseDelayTime());
            new dr.a("ad_ssp_close_ad", 8765).c(bundleM, null).b();
        }

        public static void W(AdxImpBean adxImpBean) {
            if (adxImpBean == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putInt(TrackingKey.REQUEST_TYPE, adxImpBean.requestType);
            bundleM.putLong(TrackingKey.REQUEST_TS, adxImpBean.getRequestTs().longValue());
            bundleM.putString(TrackingKey.REQUEST_ID, adxImpBean.requestId);
            bundleM.putLong(TrackingKey.EVENT_TS, adxImpBean.getRequestTs().longValue());
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adxImpBean.offlineAd ? 1 : 0);
            bundleM.putInt("ad_type", adxImpBean.adt);
            bundleM.putString(TrackingKey.TRIGGER_ID, adxImpBean.triggerId);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adxImpBean.pmid);
            bundleM.putInt(TrackingKey.AD_COUNT, adxImpBean.mAdCount);
            bundleM.putInt(TrackingKey.IS_RETREATAD, 0);
            bundleM.putInt(TrackingKey.REQUEST_NUM, adxImpBean.mAdCount);
            bundleM.putString(TrackingKey.GAME_NAME, adxImpBean.gameName);
            bundleM.putString(TrackingKey.GAME_SCENE, adxImpBean.gameScene);
            bundleM.putString("ext_info", adxImpBean.getExtInfoJson());
            bundleM.putString(TrackingKey.CLD_CONFIGURE_ID, da.a.d().i("hisavanaCurrentCloudControlVersion"));
            ca.b.v0(bundleM);
            PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
            bundleM.putInt("is_install_ps", packageInfoC == null ? 0 : 1);
            String str = "";
            if (packageInfoC != null) {
                str = packageInfoC.versionCode + "";
            }
            bundleM.putString("ps_version", str);
            bundleM.putInt("offline_ad_enable", adxImpBean.offlineAdEnable ? 1 : 0);
            ConfigCodeSeatDTO configCodeSeatDTOG = com.cloud.hisavana.sdk.x.h().g(adxImpBean.pmid);
            bundleM.putInt("cache_offline_ad_count", configCodeSeatDTOG != null ? configCodeSeatDTOG.getLocalOfflineAdCacheCount() : 0);
            if (NetGroup.c() && NetGroup.d() > 0) {
                bundleM.putInt("net_bucket_id", NetGroup.d());
            }
            AthenaTracker.k(bundleM);
            new dr.a("ad_ssp_request", 8765).c(bundleM, null).b();
        }

        public static void X(AdsDTO adsDTO, String str) {
            Bundle bundleM = AthenaTracker.m(null);
            AdxImpBean impBeanRequest = (adsDTO == null || adsDTO.getImpBeanRequest() == null) ? null : adsDTO.getImpBeanRequest();
            if (impBeanRequest == null) {
                return;
            }
            bundleM.putString("gplink", str);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            adsDTO.setRequestPsTs(System.currentTimeMillis());
            bundleM.putLong(TrackingKey.REQUEST_TS, adsDTO.getRequestPsTs());
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
            bundleM.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
            bundleM.putString("ext_info", impBeanRequest.getExtInfoJson());
            new dr.a("ad_ssp_request_ps_material", 8765).c(bundleM, null).b();
        }

        public static void Y(List<AdsDTO> list, TaErrorCode taErrorCode, AdxImpBean adxImpBean, int i11) {
            AdsDTO adsDTO;
            Bundle bundleM = AthenaTracker.m(null);
            if (list == null || list.size() <= 0) {
                adsDTO = null;
            } else {
                adsDTO = list.get(0);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (AdsDTO adsDTO2 : list) {
                    if (adsDTO2 != null) {
                        arrayList.add(adsDTO2.getAdCreativeId());
                        arrayList2.add(Integer.valueOf(adsDTO2.getPslinkInfoStatus() ? 1 : 0));
                    }
                }
                bundleM.putString(TrackingKey.AD_CREATE_IDS, TextUtils.join(",", arrayList));
                bundleM.putString("is_halfscreen_ads", TextUtils.join(",", arrayList2));
                bundleM.putInt(TrackingKey.AD_COUNT, list.size());
            }
            if (adsDTO != null && adsDTO.getImpBeanRequest() != null && adxImpBean == null) {
                adxImpBean = adsDTO.getImpBeanRequest();
            }
            if (adxImpBean != null) {
                bundleM.putInt(TrackingKey.REQUEST_TYPE, adxImpBean.requestType);
                bundleM.putLong(TrackingKey.REQUEST_TS, adxImpBean.getRequestTs().longValue());
                bundleM.putString(TrackingKey.REQUEST_ID, adxImpBean.requestId);
                bundleM.putString(TrackingKey.TRIGGER_ID, adxImpBean.triggerId);
                bundleM.putInt("ad_type", adxImpBean.adt);
                bundleM.putString(TrackingKey.CODE_SEAT_ID, adxImpBean.pmid);
                if (adxImpBean.getRequestTs().longValue() != 0) {
                    bundleM.putInt(TrackingKey.RETURN_TIME, (int) (System.currentTimeMillis() - adxImpBean.getRequestTs().longValue()));
                }
                bundleM.putInt(TrackingKey.IS_TIMEOUT, adxImpBean.isTimeOut);
                bundleM.putInt(TrackingKey.REQUEST_NUM, adxImpBean.mAdCount);
                bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adxImpBean.offlineAd ? 1 : 0);
                bundleM.putLong(TrackingKey.EVENT_TS, adxImpBean.getRequestTs().longValue());
                bundleM.putString(TrackingKey.GAME_NAME, adxImpBean.gameName);
                bundleM.putString(TrackingKey.GAME_SCENE, adxImpBean.gameScene);
                bundleM.putString("ext_info", adxImpBean.getExtInfoJson());
                bundleM.putInt("offline_ad_enable", adxImpBean.offlineAdEnable ? 1 : 0);
                ConfigCodeSeatDTO configCodeSeatDTOG = com.cloud.hisavana.sdk.x.h().g(adxImpBean.pmid);
                bundleM.putInt("cache_offline_ad_count", configCodeSeatDTOG == null ? 0 : configCodeSeatDTOG.getLocalOfflineAdCacheCount());
            }
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putLong(TrackingKey.RETURN_TS, System.currentTimeMillis());
            if (taErrorCode != null) {
                bundleM.putString(TrackingKey.ERROR_CODE, taErrorCode.getErrorCode() + "");
                bundleM.putString(TrackingKey.ERROR_MESSAGE, taErrorCode.getErrorMessage());
            }
            if (adsDTO != null) {
                bundleM.putDouble(TrackingKey.BIDDING_PRICE, adsDTO.getFirstPrice().doubleValue());
                bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
                bundleM.putString("plan_id", adsDTO.getPlanId());
                bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
                bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                bundleM.putInt("is_adm_ad", TextUtils.isEmpty(adsDTO.getAdm()) ? 1 : 2);
                bundleM.putString("pslink", adsDTO.getPsLink());
                bundleM.putInt("material_type", adsDTO.isInteractiveAd() ? 4 : adsDTO.getMaterialType().intValue());
                bundleM.putInt("is_test_request", (AdManager.i() || adsDTO.getTestResponse().booleanValue()) ? 1 : 0);
                bundleM.putString("half_screen_type", adsDTO.getHalfScreenType());
                bundleM.putInt("track_type", adsDTO.getTrackType().intValue());
                bundleM.putString("material_style", adsDTO.getMaterialStyle());
            }
            bundleM.putInt("return_offline_ad_count", i11);
            if (NetGroup.c() && NetGroup.d() > 0) {
                bundleM.putInt("net_bucket_id", NetGroup.d());
            }
            ca.b.v0(bundleM);
            AthenaTracker.l(adsDTO, bundleM);
            AthenaTracker.k(bundleM);
            new dr.a("ad_ssp_return", 8765).c(bundleM, null).b();
        }

        public static void Z(AdsDTO adsDTO, DiskTrackingBean diskTrackingBean, String str, int i11, String str2, Throwable th2) {
            if (adsDTO == null && diskTrackingBean == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            if (adsDTO != null) {
                AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
                if (impBeanRequest != null) {
                    bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
                    bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
                    bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
                }
                bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
                bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
                bundleM.putString("package_name", TextUtils.isEmpty(adsDTO.getPackageName()) ? adsDTO.getPsPackageName() : adsDTO.getPackageName());
                bundleM.putInt("retry_status", 0);
                bundleM.putInt("retry_num", 0);
            } else {
                bundleM.putString(TrackingKey.TRIGGER_ID, diskTrackingBean.getTriggerId());
                bundleM.putString(TrackingKey.REQUEST_ID, diskTrackingBean.getRequestId());
                bundleM.putString(TrackingKey.CODE_SEAT_ID, diskTrackingBean.getCodeSeatId());
                bundleM.putString("ad_creative_id", diskTrackingBean.getAdCreativeId());
                bundleM.putString(TrackingKey.SHOW_ID, diskTrackingBean.getShowId());
                bundleM.putString("advertiser_id", diskTrackingBean.getAdvertiserId());
                bundleM.putString("package_name", diskTrackingBean.getPackageName());
                bundleM.putInt("retry_status", 1);
                bundleM.putInt("retry_num", diskTrackingBean.getRetryTimes().intValue() + 1);
            }
            bundleM.putInt(TrackingKey.ERROR_CODE, i11);
            if (i11 >= 300) {
                bundleM.putString("exception_name", th2 == null ? "" : th2.getClass().getName());
                if (str2 != null) {
                    bundleM.putString("response_info", str2.length() > 200 ? str2.substring(0, 200) : str2);
                }
                bundleM.putString("track_url", str);
            }
            new dr.a("adx_track_result", 8765).c(bundleM, null).b();
        }

        public static /* synthetic */ void a(AdsDTO adsDTO, DiskTrackingBean diskTrackingBean, String str, int i11, String str2, Throwable th2) {
            Z(adsDTO, diskTrackingBean, str, i11, str2, th2);
        }

        public static void a0(String str, int i11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, str);
            bundleM.putInt(TrackingKey.REQUEST_TYPE, i11);
            new dr.a("offline_start_judge", 8765).c(bundleM, null).b();
        }

        public static /* synthetic */ void b(AdsDTO adsDTO, int i11, int i12) {
            p(adsDTO, i11, i12);
        }

        public static void b0(AdsDTO adsDTO, TaErrorCode taErrorCode, int i11, String str) {
            AdxImpBean impBeanRequest;
            int width;
            int height;
            if (adsDTO == null || (impBeanRequest = adsDTO.getImpBeanRequest()) == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString("vast_version", str);
            bundleM.putInt("vast_status", i11);
            if (taErrorCode != null) {
                bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(taErrorCode.getErrorCode()));
                bundleM.putString(TrackingKey.ERROR_CODE, taErrorCode.getErrorMessage());
            }
            bundleM.putInt("cache_time", adsDTO.getCacheTime().intValue());
            bundleM.putString("id", String.valueOf(adsDTO.getId()));
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            VastData videoInfo = adsDTO.getVideoInfo();
            bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
            if (videoInfo != null) {
                VastMedia mainAd = videoInfo.getMainAd();
                if (mainAd != null) {
                    width = mainAd.getWidth();
                    height = mainAd.getHeight();
                } else {
                    width = 0;
                    height = 0;
                }
                bundleM.putInt("image_width", width);
                bundleM.putInt("image_height", height);
            }
            new dr.a("ad_ssp_vast_analyze", 8765).c(bundleM, null).b();
        }

        public static /* synthetic */ void c(AdsDTO adsDTO) {
            Q(adsDTO);
        }

        public static void c0(AdsDTO adsDTO, TaErrorCode taErrorCode) {
            AdxImpBean impBeanRequest;
            int width;
            int height;
            if (adsDTO == null || (impBeanRequest = adsDTO.getImpBeanRequest()) == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt(TrackingKey.REQUEST_TYPE, impBeanRequest.requestType);
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt("source", adsDTO.getSource());
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(taErrorCode.getErrorCode()));
            bundleM.putString(TrackingKey.ERROR_MESSAGE, taErrorCode.getErrorMessage());
            bundleM.putInt("cache_time", adsDTO.getCacheTime().intValue());
            bundleM.putString("id", String.valueOf(adsDTO.getId()));
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            VastData videoInfo = adsDTO.getVideoInfo();
            if (videoInfo != null) {
                VastMedia mainAd = videoInfo.getMainAd();
                if (mainAd != null) {
                    width = mainAd.getWidth();
                    height = mainAd.getHeight();
                } else {
                    width = 0;
                    height = 0;
                }
                bundleM.putInt("image_width", width);
                bundleM.putInt("image_height", height);
            }
            bundleM.putInt("actual_show_rate", adsDTO.getActualShowRate().intValue());
            bundleM.putLong(TrackingKey.SHOW_TS, System.currentTimeMillis());
            bundleM.putInt("is_effective_show", adsDTO.getIsEffectiveShow().intValue());
            bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
            bundleM.putLong("show_duration", adsDTO.getActualShowTime().longValue());
            bundleM.putString("show_area", adsDTO.getShowArea());
            bundleM.putInt("show_times", adsDTO.getShowNum().intValue());
            new dr.a("ad_ssp_video_abnormal", 8765).c(bundleM, null).b();
        }

        public static /* synthetic */ void d(int i11, Integer num, Integer num2, AdsDTO adsDTO) {
            n(i11, num, num2, adsDTO);
        }

        public static void d0(AdsDTO adsDTO, ProgressData progressData) {
            AdxImpBean impBeanRequest;
            int width;
            int height;
            if (adsDTO == null || progressData == null || (impBeanRequest = adsDTO.getImpBeanRequest()) == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt(TrackingKey.REQUEST_TYPE, impBeanRequest.requestType);
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt("source", adsDTO.getSource());
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            Integer videoPlayTimeType = progressData.getVideoPlayTimeType();
            bundleM.putInt("video_play_time_type", videoPlayTimeType == null ? -1 : videoPlayTimeType.intValue());
            Integer progress = progressData.getProgress();
            bundleM.putInt("video_progress", progress == null ? -1 : progress.intValue());
            Integer duration = progressData.getDuration();
            bundleM.putInt("video_duration", duration != null ? duration.intValue() : -1);
            bundleM.putInt("cache_time", adsDTO.getCacheTime().intValue());
            bundleM.putString("id", String.valueOf(adsDTO.getId()));
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            VastData videoInfo = adsDTO.getVideoInfo();
            if (videoInfo != null) {
                VastMedia mainAd = videoInfo.getMainAd();
                if (mainAd != null) {
                    width = mainAd.getWidth();
                    height = mainAd.getHeight();
                } else {
                    width = 0;
                    height = 0;
                }
                bundleM.putInt("image_width", width);
                bundleM.putInt("image_height", height);
            }
            bundleM.putInt("actual_show_rate", adsDTO.getActualShowRate().intValue());
            bundleM.putLong(TrackingKey.SHOW_TS, System.currentTimeMillis());
            bundleM.putInt("is_effective_show", adsDTO.getIsEffectiveShow().intValue());
            bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
            bundleM.putLong("show_duration", adsDTO.getActualShowTime().longValue());
            bundleM.putString("show_area", adsDTO.getShowArea());
            bundleM.putLong("ad_expire_time", adsDTO.getOfflineAdExpireTime().longValue());
            bundleM.putInt("show_times", adsDTO.getShowNum().intValue());
            new dr.a("ad_ssp_video_progress", 8765).c(g(adsDTO, bundleM), null).b();
        }

        public static /* synthetic */ void e(AttrData attrData) {
            v(attrData);
        }

        public static void e0(String str, String str2, String str3, int i11, String str4, String str5, int i12, long j11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("webId", str);
            bundleM.putString("url", str2);
            bundleM.putString("targetUrl", str3);
            if (i11 >= 0) {
                bundleM.putInt("redirectType", i11);
            }
            bundleM.putString(NotificationCompat.CATEGORY_STATUS, str4);
            bundleM.putString("errorType", str5);
            bundleM.putInt("errorCode", i12);
            if (j11 >= 0) {
                bundleM.putLong("waitTime", j11);
            }
            new dr.a("webLoadResult", 1814).c(bundleM, null).b();
        }

        public static /* synthetic */ void f(AttrData attrData) {
            I(attrData);
        }

        public static void f0(String str, String str2, String str3, int i11, int i12, long j11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("webId", str);
            bundleM.putString("url", str2);
            bundleM.putString("targetUrl", str3);
            if (i12 >= 0) {
                bundleM.putInt("redirectType", i12);
            }
            bundleM.putInt(NotificationCompat.CATEGORY_PROGRESS, i11);
            bundleM.putLong("spendTime", j11);
            new dr.a("webLoadTime", 1814).c(bundleM, null).b();
        }

        public static Bundle g(AdsDTO adsDTO, Bundle bundle) {
            Bundle bundleM = AthenaTracker.m(bundle);
            if (adsDTO == null) {
                return bundleM;
            }
            bundleM.putString(TrackingKey.REQUEST_ID, adsDTO.getRid());
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putInt("cache_time", adsDTO.getCacheTime().intValue());
            bundleM.putInt("id", adsDTO.getId().intValue());
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString("tracking_secret_key", adsDTO.getShowTrackingSecretKey());
            bundleM.putLong("login_time", System.currentTimeMillis());
            bundleM.putInt("actual_show_rate", adsDTO.getActualShowRate().intValue());
            bundleM.putLong(TrackingKey.SHOW_TS, System.currentTimeMillis());
            bundleM.putInt("is_effective_show", adsDTO.getIsEffectiveShow().intValue());
            bundleM.putString("app_id", AdManager.f29117b);
            if (adsDTO.getStoreDeeplink() != null && adsDTO.getStoreDeeplink().size() > 0) {
                bundleM.putString("click_urls", adsDTO.getStoreDeeplink().toString());
            }
            bundleM.putInt("is_test_request", (AdManager.i() || adsDTO.getTestResponse().booleanValue()) ? 1 : 0);
            if (adsDTO.getAbTest() != null) {
                bundleM.putString("abTest", GsonUtil.d(adsDTO.getAbTest()));
            }
            bundleM.putString("extInfo", adsDTO.getExtInfo());
            if (adsDTO.getImpBeanRequest() != null) {
                bundleM.putInt(TrackingKey.REQUEST_TYPE, adsDTO.getImpBeanRequest().requestType);
                bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, adsDTO.getImpBeanRequest().mTriggerNetState);
            }
            bundleM.putLong(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1L : 0L);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            return bundleM;
        }

        public static void g0(String str, String str2, String str3, String str4) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("webId", str);
            bundleM.putString("url", str2);
            bundleM.putString("targetUrl", str3);
            bundleM.putString("pageStatus", str4);
            new dr.a("webPageState", 1814).c(bundleM, null).b();
        }

        public static String h(AdsDTO adsDTO) {
            StringBuilder sb2;
            String str;
            if (adsDTO == null) {
                return "";
            }
            String materialStyle = adsDTO.getMaterialStyle();
            if (TextUtils.isEmpty(materialStyle)) {
                return "";
            }
            int bannerStyle = adsDTO.getBannerStyle();
            if (bannerStyle == 0) {
                sb2 = new StringBuilder();
                sb2.append(materialStyle);
                str = "-0";
            } else if (bannerStyle == 1) {
                sb2 = new StringBuilder();
                sb2.append(materialStyle);
                str = "-1";
            } else {
                if (bannerStyle != 2) {
                    return materialStyle;
                }
                sb2 = new StringBuilder();
                sb2.append(materialStyle);
                str = "-2";
            }
            sb2.append(str);
            return sb2.toString();
        }

        public static void h0(AdsDTO adsDTO) {
            if (adsDTO == null) {
                return;
            }
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest() != null ? adsDTO.getImpBeanRequest() : null;
            if (impBeanRequest == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt(TrackingKey.REQUEST_TYPE, impBeanRequest.requestType);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putString("web_url", adsDTO.getClickUrl());
            bundleM.putInt("material_type", adsDTO.getMaterialType().intValue());
            if (adsDTO.getClickUrlTs() != 0) {
                bundleM.putInt("web_duration", (int) (System.currentTimeMillis() - adsDTO.getClickUrlTs()));
            }
            new dr.a("ad_web_callback", 8765).c(bundleM, null).b();
        }

        public static Bundle i(AdsDTO adsDTO) {
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return null;
            }
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString("deep_link_url", adsDTO.getDeepLinkUrl());
            bundleM.putString("plan_id", adsDTO.getPlanId());
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putString("sspsdk_version", ca.d.l());
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
            return bundleM;
        }

        public static void j(AdsDTO adsDTO, long j11) {
            if (adsDTO == null || !adsDTO.isOfflineAd()) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
            if (impBeanRequest != null) {
                bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
                bundleM.putInt(TrackingKey.REQUEST_TYPE, impBeanRequest.requestType);
                bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            }
            bundleM.putString("web_url", adsDTO.getOfflineH5Url());
            bundleM.putLong("web_duration", j11);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putInt("material_type", adsDTO.getMaterialType().intValue());
            new dr.a("ad_web_complete", 8765).c(bundleM, null).b();
        }

        public static void k(List<AdsDTO> list, String str, int i11, String str2, int i12, long j11, String str3, boolean z11, String str4, int i13) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.TRIGGER_ID, str);
            bundleM.putInt(TrackingKey.AD_COUNT, list == null ? 0 : list.size());
            bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(i12));
            bundleM.putLong("time_consuming", j11);
            bundleM.putInt("offline_ad_enable", z11 ? 1 : 0);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, str3);
            bundleM.putInt("cache_offline_ad_count", i13);
            if (list == null || list.isEmpty()) {
                bundleM.putString("default_ad_status", str4);
                bundleM.putInt("filling_result", 2);
                bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, i11);
                bundleM.putString("offline_ad_status", str2);
                if (AdManager.h()) {
                    r.b("fill_fail，ad_trigger_status，" + i11, 3);
                }
            } else {
                AdsDTO adsDTO = list.get(0);
                AdxImpBean impBeanRequest = (adsDTO == null || adsDTO.getImpBeanRequest() == null) ? null : adsDTO.getImpBeanRequest();
                if (impBeanRequest == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (AdsDTO adsDTO2 : list) {
                    if (adsDTO2 != null) {
                        arrayList2.add(adsDTO2.getAdCreativeId());
                        arrayList.add(Integer.valueOf(adsDTO2.getSource()));
                        arrayList3.add(Integer.valueOf(adsDTO2.getPslinkInfoStatus() ? 1 : 0));
                    }
                }
                bundleM.putString(TrackingKey.AD_CREATE_IDS, TextUtils.join(",", arrayList2));
                bundleM.putString(TrackingKey.FILLING_SOURCE, TextUtils.join(",", arrayList));
                bundleM.putInt("filling_result", 1);
                bundleM.putInt("source", adsDTO.getSource());
                bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, i11);
                bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
                bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
                bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
                bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
                bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
                bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                bundleM.putString("plan_id", adsDTO.getPlanId());
                bundleM.putString("ad_group_id", adsDTO.getAdGroupId());
                bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                bundleM.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
                bundleM.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
                bundleM.putString("ext_info", impBeanRequest.getExtInfoJson());
                bundleM.putInt("material_type", adsDTO.isInteractiveAd() ? 4 : adsDTO.getMaterialType().intValue());
                bundleM.putInt("is_test_request", (AdManager.i() || adsDTO.getTestResponse().booleanValue()) ? 1 : 0);
                bundleM.putString("is_halfscreen_ads", TextUtils.join(",", arrayList3));
                bundleM.putString("half_screen_type", adsDTO.getHalfScreenType());
                bundleM.putInt("track_type", adsDTO.getTrackType().intValue());
                AthenaTracker.l(adsDTO, bundleM);
            }
            if (NetGroup.c() && NetGroup.d() > 0) {
                bundleM.putInt("net_bucket_id", NetGroup.d());
            }
            AthenaTracker.k(bundleM);
            new dr.a("ad_filling_result", 8765).c(bundleM, null).b();
        }

        public static void l(String str, String str2, String str3, List<String> list, List<Integer> list2, boolean z11, int i11) {
            if (list == null || list2 == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, str3);
            bundleM.putString(TrackingKey.REQUEST_ID, str);
            bundleM.putString(TrackingKey.TRIGGER_ID, str2);
            bundleM.putString(TrackingKey.AD_CREATE_IDS, TextUtils.join(",", list));
            bundleM.putString("filter_reason", TextUtils.join(",", list2));
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, z11 ? 1 : 0);
            bundleM.putInt("source", i11);
            new dr.a("ad_filter", 8765).c(bundleM, null).b();
        }

        public static void m(AdsDTO adsDTO, String str) {
            Bundle bundleM = AthenaTracker.m(null);
            if (adsDTO != null) {
                bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
                bundleM.putString("app_id", AdManager.f29117b);
                bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
                bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                bundleM.putString("event_id", str);
                AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
                if (impBeanRequest != null) {
                    bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
                    bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
                }
            }
            if (bundleM != null) {
                new dr.a("interaction_event", 8765).c(bundleM, null).b();
            }
        }

        public static void n(int i11, Integer num, Integer num2, AdsDTO adsDTO) {
            String str;
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return;
            }
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
            if (num != null) {
                bundleM.putInt(TrackingKey.PLATFORM, num.intValue());
            }
            if (num2 != null) {
                bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(num2));
            }
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            if (i11 == 0) {
                str = "ssp_container_open";
            } else if (i11 != 1) {
                str = i11 != 2 ? null : "ssp_container_click";
            } else {
                str = "ssp_container_show";
            }
            if (str != null) {
                new dr.a(str, 8765).c(bundleM, null).b();
            }
        }

        public static void o(AdsDTO adsDTO) {
            Bundle bundleM = AthenaTracker.m(null);
            if (adsDTO != null) {
                bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
                bundleM.putString("app_id", AdManager.f29117b);
                bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
                bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
                if (impBeanRequest != null) {
                    bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
                    bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
                    bundleM.putInt("offline_ad_enable", impBeanRequest.offlineAdEnable ? 1 : 0);
                }
                bundleM.putInt("is_halfscreen_ad", adsDTO.getPslinkInfoStatus() ? 1 : 0);
            }
            AthenaTracker.l(adsDTO, bundleM);
            if (bundleM != null) {
                AthenaTracker.k(bundleM);
                new dr.a("ssp_trigger_show", 8765).c(bundleM, null).b();
            }
        }

        public static void p(AdsDTO adsDTO, int i11, int i12) {
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
            bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putInt("adm_render_status", i11);
            bundleM.putInt(TrackingKey.ERROR_CODE, i12);
            new dr.a("adm_render_process", 8765).c(bundleM, null).b();
        }

        public static void q(String str, String str2, int i11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, str);
            bundleM.putString(TrackingKey.REQUEST_ID, str2);
            bundleM.putString(TrackingKey.ERROR_CODE, String.valueOf(i11));
            new dr.a("agent_page_js_warning", 8765).c(bundleM, null).b();
        }

        public static void r(AdsDTO adsDTO, boolean z11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putInt("is_ps_reporting", z11 ? 1 : 0);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString(TrackingKey.TRIGGER_ID, adsDTO.getJsTriggerId());
            bundleM.putString(TrackingKey.REQUEST_ID, adsDTO.getJsRequestId());
            bundleM.putString(TrackingKey.CLD_APP_ID, adsDTO.getJsMediaId());
            bundleM.putString(TrackingKey.CLD_CODE_SEAT_ID, adsDTO.getJsCodeSeatId());
            bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getJsCodeSeatId());
            bundleM.putString("gaid", DeviceUtil.e());
            bundleM.putInt("track_type", adsDTO.getTrackType().intValue());
            PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
            bundleM.putString("ps_version", packageInfoC == null ? null : packageInfoC.versionName);
            new dr.a("h5_ad_click_ps_reporting", 8765).c(bundleM, null).b();
        }

        public static void s(AdsDTO adsDTO, String str, String str2, boolean z11) {
            Bundle bundleM = AthenaTracker.m(null);
            if (adsDTO != null) {
                bundleM.putString("js_trigger_id", adsDTO.getJsTriggerId());
                bundleM.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
                bundleM.putInt("pslink_type", adsDTO.getPslinkInfoStatus() ? 2 : 1);
                bundleM.putInt("track_type", adsDTO.getTrackType().intValue());
                bundleM.putString(TrackingKey.REQUEST_ID, adsDTO.getJsRequestId());
                bundleM.putString("advertiser_id", adsDTO.getAdvertiserId());
                bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
                bundleM.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getJsCodeSeatId());
                bundleM.putInt("is_jump_to_halfscreen", adsDTO.isJumpToHalfscreen() ? 1 : 0);
                bundleM.putInt(TrackingKey.PLATFORM, adsDTO.getDspType().intValue());
            }
            bundleM.putString(TrackingKey.SHOW_ID, str);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putString("sspsdk_version", ca.d.l());
            PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
            bundleM.putInt("is_install_ps", packageInfoC == null ? 0 : 1);
            bundleM.putString("ps_version", packageInfoC == null ? null : packageInfoC.versionName);
            bundleM.putString("pslink", str2);
            try {
                bundleM.putString("halfscren_type", Uri.parse(str2).getQueryParameter("HalfScreenType"));
            } catch (Throwable th2) {
                z.a().d("ssp", Log.getStackTraceString(th2));
            }
            bundleM.putInt("pslink_result", z11 ? 1 : 0);
            new dr.a("js_bridge_result", 8765).c(bundleM, null).b();
        }

        public static void t(String str, String str2, boolean z11) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("js_trigger_id", str);
            bundleM.putString(TrackingKey.SHOW_ID, str2);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putString("sspsdk_version", ca.d.l());
            PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
            bundleM.putInt("is_install_ps", packageInfoC == null ? 0 : 1);
            bundleM.putString("ps_version", packageInfoC == null ? null : packageInfoC.versionName);
            bundleM.putInt(TrackingKey.IS_OFFLINE_AD, z11 ? 1 : 0);
            new dr.a("js_bridge_trigger", 8765).c(bundleM, null).b();
        }

        public static void u(String str, AdsDTO adsDTO, Boolean bool) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("event_data_set", str);
            bundleM.putInt("turn_off_per_ads", DeviceUtil.f());
            AdxImpBean impBeanRequest = (adsDTO == null || adsDTO.getImpBeanRequest() == null) ? null : adsDTO.getImpBeanRequest();
            if (impBeanRequest != null) {
                bundleM.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
                bundleM.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
                bundleM.putString("ext_info", impBeanRequest.getExtInfoJson());
            }
            ca.b.v0(bundleM);
            PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
            int i11 = 1;
            bundleM.putInt("is_install_ps", packageInfoC == null ? 0 : 1);
            bundleM.putString("ps_version", packageInfoC == null ? "" : String.valueOf(packageInfoC.versionCode));
            if (adsDTO == null) {
                bundleM.putInt("is_ps_type", 0);
            } else {
                bundleM.putInt("is_ps_type", x.a(adsDTO) ? 1 : 0);
                bundleM.putString("click_link", adsDTO.getClick_link());
                bundleM.putInt("is_jump_to_halfscreen", adsDTO.isJumpToHalfscreen() ? 1 : 0);
                bundleM.putInt("material_type", adsDTO.getMaterialType().intValue());
                bundleM.putInt(TrackingKey.SLOT_HEIGHT, adsDTO.getViewHeight());
                bundleM.putInt(TrackingKey.SLOT_WIDTH, adsDTO.getViewWidth());
                if (!AdManager.i() && !adsDTO.getTestResponse().booleanValue()) {
                    i11 = 0;
                }
                bundleM.putInt("is_test_request", i11);
                bundleM.putString("half_screen_type", adsDTO.getHalfScreenType());
                bundleM.putInt("is_halfscreen_ad", adsDTO.getPslinkInfoStatus() ? 1 : 0);
                bundleM.putInt("track_type", adsDTO.getTrackType().intValue());
                bundleM.putString("material_style", h(adsDTO));
                bundleM.putInt("close_delay_time", adsDTO.getCloseDelayTime());
            }
            if (bool != null) {
                bundleM.putInt("is_ps_reporting", bool.booleanValue() ? 1 : 0);
            }
            AthenaTracker.l(adsDTO, bundleM);
            AthenaTracker.k(bundleM);
            new dr.a("ad_ssp_click", 2411).c(bundleM, null).b();
        }

        public static void v(AttrData attrData) {
            if (attrData == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putLong(TrackingKey.EVENT_TS, attrData.getEventTs());
            bundleM.putInt("type", attrData.getType());
            bundleM.putInt(TrackingKey.ERROR_CODE, attrData.getErrorCode());
            bundleM.putInt("ct", attrData.getCount());
            bundleM.putInt("fail_c", attrData.getFailCount());
            bundleM.putString("error_list", attrData.getErrorList());
            bundleM.putString("link_id", attrData.getLinkId());
            bundleM.putString(TrackingKey.AD_CREATE_IDS, attrData.getCreatives());
            new dr.a("click_sync", 8765).c(bundleM, null).b();
        }

        public static void w(int i11, String str) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt(TrackingKey.TRIGGER_TYPE, i11);
            bundleM.putString(TrackingKey.CLD_REQUEST_ID, str);
            new dr.a("ad_cld_request", 8765).c(bundleM, null).b();
        }

        public static void x(int i11, String str, int i12, int i13, String str2, String str3) {
            Bundle bundleM = AthenaTracker.m(null);
            bundleM.putInt(TrackingKey.TRIGGER_TYPE, i11);
            bundleM.putString(TrackingKey.CLD_REQUEST_ID, str);
            bundleM.putString("app_id", AdManager.f29117b);
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt("cld_return_time_interval", i12);
            bundleM.putInt(TrackingKey.CODE, i13);
            bundleM.putString("message", str2);
            bundleM.putString("cld_version", str3);
            new dr.a("ad_cld_return", 8765).c(bundleM, null).b();
        }

        public static void y(AdsDTO adsDTO, String str, ClickJumpType clickJumpType) {
            if (adsDTO == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("called_url_type", adsDTO.getCalledUrlType());
            bundle.putString("app_name", adsDTO.getPslinkAppName());
            bundle.putInt("material_type", adsDTO.getMaterialType().intValue());
            bundle.putInt("show_times", adsDTO.getShowTime().intValue());
            bundle.putString("deep_link_url", str);
            bundle.putInt("is_halfscreen_ad", adsDTO.getPslinkInfoStatus() ? 1 : 0);
            bundle.putInt("is_jump_to_halfscreen", clickJumpType.rawValue());
            AthenaTracker.k(bundle);
            AthenaTracker.l(adsDTO, bundle);
            new dr.a(WebConstants.FIELD_DEEPLINK, 8765).c(g(adsDTO, bundle), null).b();
        }

        public static void z(AdsDTO adsDTO) {
            if (adsDTO == null) {
                return;
            }
            Bundle bundleM = AthenaTracker.m(null);
            AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest() != null ? adsDTO.getImpBeanRequest() : null;
            if (impBeanRequest == null) {
                return;
            }
            bundleM.putString(TrackingKey.TRIGGER_ID, impBeanRequest.triggerId);
            bundleM.putString(TrackingKey.CODE_SEAT_ID, impBeanRequest.pmid);
            bundleM.putString("ad_creative_id", adsDTO.getAdCreativeId());
            bundleM.putString(TrackingKey.REQUEST_ID, impBeanRequest.requestId);
            bundleM.putInt("code_seat_type", adsDTO.getCodeSeatType().intValue());
            bundleM.putLong("show_report_time_type", adsDTO.getShowReportTimeType().intValue());
            bundleM.putString("expired_date", adsDTO.getExpiredDate());
            bundleM.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
            bundleM.putString(TrackingKey.ECPM, String.valueOf(adsDTO.getFirstPrice()));
            bundleM.putString("campaignname", adsDTO.getCampaignname());
            bundleM.putString(TrackingKey.GAME_NAME, impBeanRequest.gameName);
            bundleM.putString(TrackingKey.GAME_SCENE, impBeanRequest.gameScene);
            bundleM.putInt(TrackingKey.AD_TRIGGER_STATUS, impBeanRequest.mTriggerNetState);
            bundleM.putString("tracking_secret_key", adsDTO.getShowTrackingSecretKey());
            bundleM.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundleM.putInt("is_inapp_ad", 1);
            bundleM.putString("material_style", h(adsDTO));
            bundleM.putInt("close_delay_time", adsDTO.getCloseDelayTime());
            new dr.a("ssp_click_inapp", 2411).c(bundleM, null).b();
        }
    }

    public static void A(final int i11, final Integer num, final Integer num2, final AdsDTO adsDTO) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.a
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.d(i11, num, num2, adsDTO);
            }
        });
    }

    public static void B(final AdsDTO adsDTO) {
        if (adsDTO == null || adsDTO.getSource() != 4) {
            ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.26
                @Override // java.lang.Runnable
                public void run() {
                    a.o(adsDTO);
                }
            });
        }
    }

    public static void C(final AdsDTO adsDTO, final int i11, final int i12) {
        if (adsDTO == null || adsDTO.getExt() == null || !ca.c.b(adsDTO.getExt().getLogEnable(), "halfScreenLogEnable")) {
            return;
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.e
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.b(adsDTO, i11, i12);
            }
        });
    }

    public static void D(final String str, final String str2, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.42
            @Override // java.lang.Runnable
            public void run() {
                a.q(str, str2, i11);
            }
        });
    }

    public static void E(final AdsDTO adsDTO, final boolean z11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.36
            @Override // java.lang.Runnable
            public void run() {
                a.r(adsDTO, z11);
            }
        });
    }

    public static void F(final AdsDTO adsDTO, final String str, final String str2, final boolean z11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.34
            @Override // java.lang.Runnable
            public void run() {
                a.s(adsDTO, str, str2, z11);
            }
        });
    }

    public static void G(final String str, final String str2, final boolean z11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.33
            @Override // java.lang.Runnable
            public void run() {
                a.t(str, str2, z11);
            }
        });
    }

    public static void H(final String str, final AdsDTO adsDTO, final Boolean bool) {
        if (adsDTO == null || adsDTO.getSource() != 4) {
            if (adsDTO == null || !adsDTO.isFromJs()) {
                ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.17
                    @Override // java.lang.Runnable
                    public void run() {
                        a.u(str, adsDTO, bool);
                    }
                });
            }
        }
    }

    public static void I(final AttrData attrData) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.b
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.e(attrData);
            }
        });
    }

    public static void J(final int i11, final String str) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.10
            @Override // java.lang.Runnable
            public void run() {
                a.w(i11, str);
            }
        });
    }

    public static void K(final int i11, final String str, final int i12, final int i13, final String str2, final String str3) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.11
            @Override // java.lang.Runnable
            public void run() {
                a.x(i11, str, i12, i13, str2, str3);
            }
        });
    }

    public static void L(final AdsDTO adsDTO, final String str, final ClickJumpType clickJumpType) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.8
            @Override // java.lang.Runnable
            public void run() {
                a.y(adsDTO, str, clickJumpType);
            }
        });
    }

    public static void M(List<AdsDTO> list, final String str, final String str2, final long j11) {
        final ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.22
            @Override // java.lang.Runnable
            public void run() {
                a.A(arrayList, str, str2, j11);
            }
        });
    }

    public static void N(final String str) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.4
            @Override // java.lang.Runnable
            public void run() {
                a.B(str);
            }
        });
    }

    public static void O(final String str, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.5
            @Override // java.lang.Runnable
            public void run() {
                a.C(str, i11);
            }
        });
    }

    public static void P(final AdsDTO adsDTO) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.3
            @Override // java.lang.Runnable
            public void run() {
                a.D(adsDTO);
            }
        });
    }

    public static void Q(final AdsDTO adsDTO, final FormBean formBean) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.16
            @Override // java.lang.Runnable
            public void run() {
                a.G(adsDTO, formBean);
            }
        });
    }

    public static void R(final AdsDTO adsDTO, final String str, final String str2) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.25
            @Override // java.lang.Runnable
            public void run() {
                a.H(adsDTO, str, str2);
            }
        });
    }

    public static void S(final AttrData attrData) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.d
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.f(attrData);
            }
        });
    }

    public static void T() {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.1
            @Override // java.lang.Runnable
            public void run() {
                a.J();
            }
        });
    }

    public static void U(final AdsDTO adsDTO, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.29
            @Override // java.lang.Runnable
            public void run() {
                a.K(adsDTO, i11);
            }
        });
    }

    public static void V(final boolean z11, final int i11, final String str, final String str2, final int i12, final int i13, final String str3, final String str4, final Map<String, Object> map, final int i14) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.20
            @Override // java.lang.Runnable
            public void run() {
                a.L(z11, i11, str, str2, i12, i13, str3, str4, map, i14);
            }
        });
    }

    public static void W(final AdsDTO adsDTO, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.c
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.M(adsDTO, i11);
            }
        });
    }

    public static void X(final AdsDTO adsDTO, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.g
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.N(adsDTO, i11);
            }
        });
    }

    public static void Y(final AdsDTO adsDTO) {
        VastData videoInfo;
        ProgressData progressData;
        if (adsDTO == null || adsDTO.isFromJs()) {
            return;
        }
        if (adsDTO.isVastTypeAd() && (videoInfo = adsDTO.getVideoInfo()) != null && (progressData = videoInfo.getProgressData()) != null) {
            progressData.setVideoPlayTimeType(3);
            n0(adsDTO, progressData);
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.18
            @Override // java.lang.Runnable
            public void run() {
                if (adsDTO.getSource() == 4) {
                    a.z(adsDTO);
                } else {
                    a.O(adsDTO);
                }
            }
        });
    }

    public static void Z(final String str, final int i11, final int i12) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.41
            @Override // java.lang.Runnable
            public void run() {
                a.P(str, i11, i12);
            }
        });
    }

    public static void a0(final AdsDTO adsDTO) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.h
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.c(adsDTO);
            }
        });
    }

    public static void b0(final AdsDTO adsDTO) {
        if (adsDTO == null || !adsDTO.isFromJs()) {
            ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.2
                @Override // java.lang.Runnable
                public void run() {
                    a.R(adsDTO);
                }
            });
        }
    }

    public static void c0(final AdsDTO adsDTO, final String str, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.43
            @Override // java.lang.Runnable
            public void run() {
                a.S(adsDTO, str, i11);
            }
        });
    }

    public static void d0(final String str, final int i11, final int i12, final long j11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.9
            @Override // java.lang.Runnable
            public void run() {
                a.T(str, i11, i12, j11);
            }
        });
    }

    public static void e0(final AdsDTO adsDTO, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.28
            @Override // java.lang.Runnable
            public void run() {
                a.U(adsDTO, i11);
            }
        });
    }

    public static void f0(AdsDTO adsDTO) {
        g0(adsDTO, null);
    }

    public static void g0(final AdsDTO adsDTO, final Integer num) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.23
            @Override // java.lang.Runnable
            public void run() {
                a.V(adsDTO, num);
            }
        });
    }

    public static void h0(final AdxImpBean adxImpBean) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.12
            @Override // java.lang.Runnable
            public void run() {
                a.W(adxImpBean);
            }
        });
    }

    public static void i0(List<AdsDTO> list, final TaErrorCode taErrorCode, final AdxImpBean adxImpBean, final int i11) {
        final ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<AdsDTO> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.13
            @Override // java.lang.Runnable
            public void run() {
                a.Y(arrayList, taErrorCode, adxImpBean, i11);
            }
        });
    }

    public static void j0(final AdsDTO adsDTO, final DiskTrackingBean diskTrackingBean, final String str, final int i11, final String str2, final Throwable th2) {
        if ((adsDTO == null || adsDTO.getExt() == null || !ca.c.b(adsDTO.getExt().getLogEnable(), "showTrackingUrlsLogEnable")) && (diskTrackingBean == null || !diskTrackingBean.getShowTrackingUrlsLogEnable())) {
            return;
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.f
            @Override // java.lang.Runnable
            public final void run() {
                AthenaTracker.a.a(adsDTO, diskTrackingBean, str, i11, str2, th2);
            }
        });
    }

    public static void k(Bundle bundle) {
        bundle.putInt("screen_angular", j.e() - 1);
    }

    public static void k0(final String str, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.40
            @Override // java.lang.Runnable
            public void run() {
                a.a0(str, i11);
            }
        });
    }

    public static void l(AdsDTO adsDTO, Bundle bundle) {
        if (adsDTO == null || bundle == null || adsDTO.getDisplayRule() != Constants.AdDisplayRule.RU) {
            return;
        }
        bundle.putString("compliance", "1");
    }

    public static void l0(final AdsDTO adsDTO, final TaErrorCode taErrorCode, final int i11, final String str) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.32
            @Override // java.lang.Runnable
            public void run() {
                a.b0(adsDTO, taErrorCode, i11, str);
            }
        });
    }

    public static Bundle m(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        PackageInfo packageInfoC = x.c(com.cloud.sdk.commonutil.util.f.a());
        if (packageInfoC != null) {
            bundle.putString("ps_version", String.valueOf(packageInfoC.versionCode));
        }
        bundle.putInt("net", MitNetUtil.c(com.cloud.sdk.commonutil.util.f.a()) ? 1 : 0);
        bundle.putString("app_id", AdManager.f29117b);
        return ca.c.a(bundle);
    }

    public static void m0(final AdsDTO adsDTO, final TaErrorCode taErrorCode) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.31
            @Override // java.lang.Runnable
            public void run() {
                a.c0(adsDTO, taErrorCode);
            }
        });
    }

    public static void n(boolean z11, Context context) {
        if (f29385a) {
            return;
        }
        AthenaAnalytics.F(context, "SSP", 2411, z11, false);
        AthenaAnalytics.F(context, "SSP", 8765, z11, false);
        f29385a = true;
    }

    public static void n0(final AdsDTO adsDTO, final ProgressData progressData) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.39
            @Override // java.lang.Runnable
            public void run() {
                a.d0(adsDTO, progressData);
            }
        });
    }

    public static void o0(final String str, final String str2, final String str3, final int i11, final String str4, final String str5, final int i12, final long j11) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.38
            @Override // java.lang.Runnable
            public void run() {
                a.e0(str, str2, str3, i11, str4, str5, i12, j11);
            }
        });
    }

    public static void p0(final String str, final String str2, final String str3, final int i11, final int i12, final long j11) {
        if (i12 == -1 || !TextUtils.isEmpty(str2)) {
            ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.37
                @Override // java.lang.Runnable
                public void run() {
                    a.f0(str, str2, str3, i11, i12, j11);
                }
            });
        }
    }

    public static void q0(final String str, final String str2, final String str3, final String str4) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.35
            @Override // java.lang.Runnable
            public void run() {
                a.g0(str, str2, str3, str4);
            }
        });
    }

    public static void r0(final AdsDTO adsDTO) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.15
            @Override // java.lang.Runnable
            public void run() {
                a.h0(adsDTO);
            }
        });
    }

    public static void w(final AdsDTO adsDTO, final long j11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.24
            @Override // java.lang.Runnable
            public void run() {
                a.j(adsDTO, j11);
            }
        });
    }

    public static void x(List<AdsDTO> list, final String str, final int i11, final String str2, final int i12, final long j11, final String str3, final boolean z11, final String str4, final int i13) {
        final ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.21
            @Override // java.lang.Runnable
            public void run() {
                a.k(arrayList, str, i11, str2, i12, j11, str3, z11, str4, i13);
            }
        });
    }

    public static void y(final String str, final String str2, final String str3, final List<String> list, final List<Integer> list2, final boolean z11, final int i11) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.30
            @Override // java.lang.Runnable
            public void run() {
                a.l(str, str2, str3, list, list2, z11, i11);
            }
        });
    }

    public static void z(final AdsDTO adsDTO, final String str) {
        ca.c.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.AthenaTracker.27
            @Override // java.lang.Runnable
            public void run() {
                a.m(adsDTO, str);
            }
        });
    }
}
