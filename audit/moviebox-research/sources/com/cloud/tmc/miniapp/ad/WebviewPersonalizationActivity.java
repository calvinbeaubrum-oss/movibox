package com.cloud.tmc.miniapp.ad;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.render.system.SystemWebView;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import uc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class WebviewPersonalizationActivity extends WebViewActivity {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f31363q = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f31364i = "WebviewPersonalizationActivity";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f31365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f31366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f31367l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f31368m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f31369n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f31370o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AdsDTO f31371p;

    /* JADX INFO: compiled from: source.java */
    public static final class SspInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f31372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AdsDTO f31373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f31374c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WeakReference<Activity> f31375d;

        public SspInterface(Activity activity, String str, AdsDTO adsDTO, String str2) {
            this.f31372a = str;
            this.f31373b = adsDTO;
            this.f31374c = str2;
            this.f31375d = new WeakReference<>(activity);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JavascriptInterface
        public final void athenaTrack(String eventName, String params) {
            Intrinsics.g(eventName, "eventName");
            Intrinsics.g(params, "params");
            WeakReference<Activity> weakReference = this.f31375d;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if ((activity instanceof WebviewPersonalizationActivity ? (WebviewPersonalizationActivity) activity : null) != null) {
                String str = this.f31374c;
                AdsDTO adsDTO = this.f31373b;
                int i11 = WebviewPersonalizationActivity.f31363q;
                try {
                    JSONObject jSONObject = new JSONObject(params);
                    Bundle bundle = new Bundle();
                    Iterator<String> itKeys = jSONObject.keys();
                    if (itKeys != null) {
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            Object obj = jSONObject.get(next);
                            if (obj != null) {
                                TmcLogger.c("ssp", obj.toString());
                                String simpleName = obj.getClass().getSimpleName();
                                switch (simpleName.hashCode()) {
                                    case -1808118735:
                                        if (!simpleName.equals("String")) {
                                            TmcLogger.c("ssp", "type not supported");
                                        } else {
                                            Object obj2 = jSONObject.get(next);
                                            Intrinsics.e(obj2, "null cannot be cast to non-null type kotlin.String");
                                            bundle.putString(next, (String) obj2);
                                        }
                                        break;
                                    case -672261858:
                                        if (!simpleName.equals("Integer")) {
                                            TmcLogger.c("ssp", "type not supported");
                                        } else {
                                            Object obj3 = jSONObject.get(next);
                                            Intrinsics.e(obj3, "null cannot be cast to non-null type kotlin.Int");
                                            bundle.putInt(next, ((Integer) obj3).intValue());
                                        }
                                        break;
                                    case 2374300:
                                        if (!simpleName.equals("Long")) {
                                            TmcLogger.c("ssp", "type not supported");
                                        } else {
                                            Object obj4 = jSONObject.get(next);
                                            Intrinsics.e(obj4, "null cannot be cast to non-null type kotlin.Long");
                                            bundle.putLong(next, ((Long) obj4).longValue());
                                        }
                                        break;
                                    case 1729365000:
                                        if (!simpleName.equals("Boolean")) {
                                            TmcLogger.c("ssp", "type not supported");
                                        } else {
                                            Object obj5 = jSONObject.get(next);
                                            Intrinsics.e(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                                            bundle.putBoolean(next, ((Boolean) obj5).booleanValue());
                                        }
                                        break;
                                    case 2052876273:
                                        if (!simpleName.equals("Double")) {
                                            TmcLogger.c("ssp", "type not supported");
                                        } else {
                                            Object obj6 = jSONObject.get(next);
                                            Intrinsics.e(obj6, "null cannot be cast to non-null type kotlin.Double");
                                            bundle.putDouble(next, ((Double) obj6).doubleValue());
                                        }
                                        break;
                                    default:
                                        TmcLogger.c("ssp", "type not supported");
                                        break;
                                }
                            }
                        }
                    }
                    if (adsDTO != null) {
                        Integer codeSeatType = adsDTO.getCodeSeatType();
                        Intrinsics.f(codeSeatType, "info.getCodeSeatType()");
                        bundle.putInt("code_seat_type", codeSeatType.intValue());
                        bundle.putString("advertiser_id", String.valueOf(adsDTO.getAdvertiserId()));
                        bundle.putString("plan_id", String.valueOf(adsDTO.getPlanId()));
                        bundle.putString("ad_group_id", String.valueOf(adsDTO.getAdGroupId()));
                        bundle.putString("ad_creative_id", String.valueOf(adsDTO.getAdCreativeId()));
                        bundle.putInt(TrackingKey.IS_OFFLINE_AD, adsDTO.isOfflineAd() ? 1 : 0);
                        bundle.putString(TrackingKey.REQUEST_ID, adsDTO.getRequestId());
                        bundle.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
                    }
                    bundle.putString("ip_address", q.f31091a.h());
                    bundle.putString("app_id_external", adsDTO != null ? adsDTO.getAppIdExternal() : null);
                    bundle.putString("code_seat_id_external", adsDTO != null ? adsDTO.getCodeSeatIdExternal() : null);
                    bundle.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).recordForAd(str, eventName, "", bundle);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }

        public final AdsDTO getAdsDTO() {
            return this.f31373b;
        }

        public final String getAppId() {
            return this.f31374c;
        }

        public final String getTriggerId() {
            return this.f31372a;
        }

        @JavascriptInterface
        public final void personaliseCallback() {
            Activity activity;
            b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(((AppManager) tc.a.a(AppManager.class)).findApp(this.f31374c));
            if (eventCenterInstance != null) {
                eventCenterInstance.d("adPersonalizationPage", new fc.a(this.f31372a));
            }
            WeakReference<Activity> weakReference = this.f31375d;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            activity.finish();
        }
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, id.i
    public Integer getViewThemeMode() {
        return 1;
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        String stringExtra = getIntent().getStringExtra("ad_personalization_url");
        this.f31365j = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        try {
            this.f31366k = getIntent().getStringExtra("adsDTO");
            this.f31368m = getIntent().getStringExtra(TrackingKey.TRIGGER_ID);
            this.f31369n = getIntent().getStringExtra("appIdExternal");
            this.f31370o = getIntent().getStringExtra("codeSeatIdExternal");
            this.f31367l = getIntent().getStringExtra(PushConstants.PROVIDER_FIELD_APP_ID);
            AdsDTO adsDTO = (AdsDTO) k.d(this.f31366k, AdsDTO.class);
            this.f31371p = adsDTO;
            if (adsDTO != null) {
                adsDTO.setAppIdExternal(this.f31369n);
            }
            AdsDTO adsDTO2 = this.f31371p;
            if (adsDTO2 != null) {
                adsDTO2.setCodeSeatIdExternal(this.f31370o);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("gaid=");
            sb2.append(q.d());
            sb2.append("&oneid=&ad_creative_id=");
            AdsDTO adsDTO3 = this.f31371p;
            sb2.append(adsDTO3 != null ? adsDTO3.getAdCreativeId() : null);
            sb2.append("&industry_id=");
            AdsDTO adsDTO4 = this.f31371p;
            sb2.append(adsDTO4 != null ? adsDTO4.getIndustryId() : null);
            sb2.append("&advertiser_id=");
            AdsDTO adsDTO5 = this.f31371p;
            sb2.append(adsDTO5 != null ? adsDTO5.getAdvertiserId() : null);
            sb2.append("&app_id=");
            AdsDTO adsDTO6 = this.f31371p;
            sb2.append(adsDTO6 != null ? adsDTO6.getApp_id() : null);
            sb2.append("&code_seat_id=");
            AdsDTO adsDTO7 = this.f31371p;
            sb2.append(adsDTO7 != null ? adsDTO7.getCodeSeatId() : null);
            sb2.append("&trigger_id=");
            sb2.append(this.f31368m);
            sb2.append("&request_id=");
            AdsDTO adsDTO8 = this.f31371p;
            sb2.append(adsDTO8 != null ? adsDTO8.getRequestId() : null);
            this.f31365j += '?' + sb2.toString();
        } catch (Throwable th2) {
            p.e(this.f31364i, "parse LandingPage info fail: " + th2);
        }
        zc.k kVar = this.f31753a;
        SystemWebView systemWebView = kVar instanceof SystemWebView ? (SystemWebView) kVar : null;
        if (systemWebView != null) {
            systemWebView.setBackgroundColor(0);
            systemWebView.getSettings().setMixedContentMode(0);
            systemWebView.getSettings().setSupportMultipleWindows(false);
            systemWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            systemWebView.getSettings().setNeedInitialFocus(true);
            systemWebView.getSettings().setDisplayZoomControls(false);
            systemWebView.getSettings().setUseWideViewPort(true);
            systemWebView.getSettings().setLoadWithOverviewMode(true);
            systemWebView.addJavascriptInterface(new SspInterface(this, this.f31368m, this.f31371p, this.f31367l), "sspWebView");
        }
        getIntent().putExtra("pageUri", this.f31365j);
        super.initData();
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(((AppManager) tc.a.a(AppManager.class)).findApp(this.f31367l));
        if (eventCenterInstance != null) {
            fc.a aVar = new fc.a("landingPage");
            aVar.c(r.f(TuplesKt.a("finish", "true")));
            Unit unit = Unit.f68710a;
            eventCenterInstance.d("adLandingPage", aVar);
        }
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, zc.o
    public void onPageFinished(WebView webView, String str) {
        StatusLayout statusLayout = getStatusLayout();
        if (statusLayout != null) {
            statusLayout.OooO0O0();
        }
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, zc.o
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, zc.o
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, zc.p
    public void onReceivedTitle(String str) {
        super.onReceivedTitle(str);
    }
}
