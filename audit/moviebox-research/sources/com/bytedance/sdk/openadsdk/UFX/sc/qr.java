package com.bytedance.sdk.openadsdk.UFX.sc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject> {
    private final HJN pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f27296sc;

    public qr(String str, HJN hjn) {
        this.pFF = hjn;
        this.f27296sc = str;
    }

    public static void sc(Xc xc2, HJN hjn) {
        xc2.sc("appInfo", new qr("appInfo", hjn));
        xc2.sc("adInfo", new qr("adInfo", hjn));
        xc2.sc("sendLog", new qr("sendLog", hjn));
        xc2.sc("playable_style", new qr("playable_style", hjn));
        xc2.sc("getTemplateInfo", new qr("getTemplateInfo", hjn));
        xc2.sc("getTeMaiAds", new qr("getTeMaiAds", hjn));
        xc2.sc("isViewable", new qr("isViewable", hjn));
        xc2.sc("getScreenSize", new qr("getScreenSize", hjn));
        xc2.sc("getCloseButtonInfo", new qr("getCloseButtonInfo", hjn));
        xc2.sc("getVolume", new qr("getVolume", hjn));
        xc2.sc("removeLoading", new qr("removeLoading", hjn));
        xc2.sc("sendReward", new qr("sendReward", hjn));
        xc2.sc("subscribe_app_ad", new qr("subscribe_app_ad", hjn));
        xc2.sc("download_app_ad", new qr("download_app_ad", hjn));
        xc2.sc("cancel_download_app_ad", new qr("cancel_download_app_ad", hjn));
        xc2.sc("unsubscribe_app_ad", new qr("unsubscribe_app_ad", hjn));
        xc2.sc("landscape_click", new qr("landscape_click", hjn));
        xc2.sc("clickEvent", new qr("clickEvent", hjn));
        xc2.sc("renderDidFinish", new qr("renderDidFinish", hjn));
        xc2.sc("dynamicTrack", new qr("dynamicTrack", hjn));
        xc2.sc("skipVideo", new qr("skipVideo", hjn));
        xc2.sc("muteVideo", new qr("muteVideo", hjn));
        xc2.sc("changeVideoState", new qr("changeVideoState", hjn));
        xc2.sc("getCurrentVideoState", new qr("getCurrentVideoState", hjn));
        xc2.sc("send_temai_product_ids", new qr("send_temai_product_ids", hjn));
        xc2.sc("getMaterialMeta", new qr("getMaterialMeta", hjn));
        xc2.sc("endcard_load", new qr("endcard_load", hjn));
        xc2.sc("pauseWebView", new qr("pauseWebView", hjn));
        xc2.sc("pauseWebViewTimers", new qr("pauseWebViewTimers", hjn));
        xc2.sc("webview_time_track", new qr("webview_time_track", hjn));
        xc2.sc("openPrivacy", new qr("openPrivacy", hjn));
        xc2.sc("openAdLandPageLinks", new qr("openAdLandPageLinks", hjn));
        xc2.sc("getNativeSiteCustomData", new qr("getNativeSiteCustomData", hjn));
        xc2.sc(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, new qr(CampaignEx.JSON_NATIVE_VIDEO_CLOSE, hjn));
    }

    @Override // com.bytedance.sdk.component.sc.ExN
    @Nullable
    public JSONObject sc(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        HJN.pFF pff = new HJN.pFF();
        pff.f28022sc = NotificationCompat.CATEGORY_CALL;
        pff.zY = this.f27296sc;
        pff.We = jSONObject;
        return this.pFF.sc(pff, 3);
    }
}
