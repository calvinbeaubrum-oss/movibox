package com.cloud.hisavana.sdk.bridge;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import ca.d;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.request.DeviceDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.g2;
import com.cloud.hisavana.sdk.l2;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import w9.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class HisavanaAdJsBridge {
    public static final String INTERFACE_NAME = "HisavanaAdJsBridge";
    public static final String PS_CLICKTRACKING_URL = "PsClickTrackingUrl";
    public static final String PS_CLICK_CURRENT_TIMEMILLIS = "ClickCurrentTimeMillis";
    public static final String PS_TRACKTYPE = "PsTrackType";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29200a = INTERFACE_NAME;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<WebView> f29201b;

    /* JADX INFO: compiled from: source.java */
    public static class a extends s9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l2 f29202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<HisavanaAdJsBridge> f29203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AdsDTO f29204c;

        public a(@NonNull l2 l2Var, @NonNull HisavanaAdJsBridge hisavanaAdJsBridge, @NonNull AdsDTO adsDTO) {
            this.f29202a = l2Var;
            this.f29203b = new WeakReference<>(hisavanaAdJsBridge);
            this.f29204c = adsDTO;
        }

        @Override // s9.a
        public void a() {
            super.a();
            z.a().d("JsAdmAdListener", "adm from js : onAdClicked");
            AthenaTracker.C(this.f29204c, 3, 0);
            HisavanaAdJsBridge hisavanaAdJsBridge = this.f29203b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.f(hisavanaAdJsBridge.c(this.f29204c.getUuid(), 3, 0), null);
            }
        }

        @Override // s9.a
        public void b() {
            super.b();
            z.a().d("JsAdmAdListener", "adm from js : onAdClosed");
            AthenaTracker.C(this.f29204c, 4, 0);
            this.f29202a.W();
            HisavanaAdJsBridge hisavanaAdJsBridge = this.f29203b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.f(hisavanaAdJsBridge.c(this.f29204c.getUuid(), 4, 0), null);
            }
        }

        @Override // s9.a
        public void g() {
            super.g();
            z.a().d("JsAdmAdListener", "adm from js : onAdShow");
            AthenaTracker.C(this.f29204c, 2, 0);
            HisavanaAdJsBridge hisavanaAdJsBridge = this.f29203b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.f(hisavanaAdJsBridge.c(this.f29204c.getUuid(), 2, 0), null);
            }
        }

        @Override // s9.a
        public void h(TaErrorCode taErrorCode) {
            super.h(taErrorCode);
            int errorCode = taErrorCode == null ? -1 : taErrorCode.getErrorCode();
            z.a().d("JsAdmAdListener", "adm from js : onAdShowError");
            AthenaTracker.C(this.f29204c, 2, errorCode);
            this.f29202a.W();
            HisavanaAdJsBridge hisavanaAdJsBridge = this.f29203b.get();
            if (hisavanaAdJsBridge != null) {
                hisavanaAdJsBridge.f(hisavanaAdJsBridge.c(this.f29204c.getUuid(), 2, errorCode), null);
            }
        }
    }

    public HisavanaAdJsBridge() {
    }

    public HisavanaAdJsBridge(WebView webView) {
        this.f29201b = new WeakReference<>(webView);
    }

    public final String c(String str, int i11, int i12) {
        return "javascript:hisavanaToJsForAdmCallBack('" + str + "'," + i11 + "," + i12 + ")";
    }

    public final void e(AdsDTO adsDTO, String str, boolean z11) {
        if (adsDTO == null) {
            return;
        }
        AthenaTracker.F(adsDTO, adsDTO.getUuid(), str, z11);
    }

    public final void f(final String str, final ValueCallback<String> valueCallback) {
        z.a().d(INTERFACE_NAME, "[jsbridge]callBackToJS: " + str);
        Preconditions.d(new Preconditions.a() { // from class: v9.b
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                this.f78765a.k(str, valueCallback);
            }
        });
    }

    public final boolean g(Context context, AdsDTO adsDTO) {
        if (context != null && adsDTO != null) {
            z.a().d(INTERFACE_NAME, "start openWithClickUrls, clickUrls: " + adsDTO.getStoreDeeplink());
            ArrayList<String> storeDeeplink = adsDTO.getStoreDeeplink();
            if (storeDeeplink != null && !storeDeeplink.isEmpty()) {
                for (String str : storeDeeplink) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str)) {
                        if (!str.startsWith("palmplay://")) {
                            if (str.startsWith("aha://") && e1.m(context, adsDTO, str)) {
                                z.a().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is ahaLink: " + str);
                                e(adsDTO, str, true);
                                return true;
                            }
                            if (i(str) && e1.A(context, str, "com.android.vending")) {
                                z.a().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is GP link: " + str);
                                e(adsDTO, str, true);
                                return true;
                            }
                            if (e1.A(context, str, null)) {
                                z.a().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is other link: " + str);
                                e(adsDTO, str, true);
                                return true;
                            }
                        } else if (adsDTO.getDspType().intValue() != 2 || !adsDTO.getPslinkInfoStatus() || !e1.p(context, adsDTO.getPackageName(), adsDTO.getPackageName())) {
                            if (e1.n(context, adsDTO, str, false)) {
                                z.a().d(INTERFACE_NAME, "startOpenAcquisitionLink,url is psLink: " + str);
                                e(adsDTO, str, true);
                                j(adsDTO);
                                return true;
                            }
                        }
                    }
                }
                e(adsDTO, null, false);
                return false;
            }
            z.a().w(INTERFACE_NAME, "openWithClickUrls failed, clickUrls is empty.");
            e(adsDTO, null, false);
        }
        return false;
    }

    @JavascriptInterface
    public String getAppVersionCode() {
        String strQ = d.q();
        z.a().d(INTERFACE_NAME, "[jsbridge]getAppVersionCode: " + strQ);
        return strQ;
    }

    @JavascriptInterface
    public String getAppVersionName() {
        String strR = d.r();
        z.a().d(INTERFACE_NAME, "[jsbridge]getAppVersionName: " + strR);
        return strR;
    }

    @JavascriptInterface
    public String getDeviceInfo() {
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setBrand(d.a());
        deviceDTO.setModel(d.f());
        deviceDTO.setOsType(1);
        deviceDTO.setOsApiLevel(String.valueOf(d.g()));
        deviceDTO.setLanguage(Locale.getDefault().getLanguage());
        deviceDTO.setPsCountryCode(DeviceUtil.d());
        deviceDTO.setCpu(DeviceUtil.c());
        String strD = GsonUtil.d(deviceDTO);
        z.a().d(INTERFACE_NAME, "[jsbridge]getDeviceInfo");
        return strD;
    }

    @JavascriptInterface
    public long getPsVersion() {
        PackageInfo packageInfoC = x.c(f.a());
        if (packageInfoC == null) {
            return 0L;
        }
        long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfoC.getLongVersionCode() : packageInfoC.versionCode;
        z.a().d(INTERFACE_NAME, "[jsbridge]getPsVersion: " + longVersionCode);
        return longVersionCode;
    }

    @JavascriptInterface
    public String getSdkVersionCode() {
        String strValueOf = String.valueOf(d.m());
        z.a().d(INTERFACE_NAME, "[jsbridge]getSdkVersionCode: " + strValueOf);
        return strValueOf;
    }

    public final boolean h(AdsDTO adsDTO) {
        Context contextA = f.a();
        if (contextA == null || adsDTO == null) {
            return false;
        }
        adsDTO.setClickid(g2.a());
        Integer trackType = adsDTO.getTrackType();
        if (e1.y(contextA, adsDTO, adsDTO.getDeepLinkUrl())) {
            if (trackType.intValue() == 0) {
                e1.J(adsDTO);
            }
            e(adsDTO, null, true);
            return true;
        }
        if (e1.L(contextA, adsDTO.getPackageName())) {
            if (trackType.intValue() == 0) {
                e1.J(adsDTO);
            }
            e(adsDTO, null, true);
            return true;
        }
        if (!e1.L(contextA, adsDTO.getPsPackageName())) {
            return g(contextA, adsDTO);
        }
        if (trackType.intValue() == 0) {
            e1.J(adsDTO);
        }
        e(adsDTO, null, true);
        return true;
    }

    public final boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("market://") || str.contains("play.google.com");
    }

    public final void j(AdsDTO adsDTO) {
        boolean z11;
        if (adsDTO == null) {
            return;
        }
        boolean zG = x.g(f.a());
        if (adsDTO.getTrackType().intValue() == 0) {
            if (zG) {
                z11 = true;
            } else {
                e1.J(adsDTO);
                z11 = false;
            }
            AthenaTracker.E(adsDTO, z11);
        }
    }

    public final /* synthetic */ void k(String str, ValueCallback valueCallback) {
        WebView webView;
        WeakReference<WebView> weakReference = this.f29201b;
        if (weakReference == null || (webView = weakReference.get()) == null) {
            return;
        }
        try {
            webView.evaluateJavascript(str, valueCallback);
        } catch (Exception unused) {
            z.a().w(INTERFACE_NAME, "evaluate javascript failed:" + str);
        }
    }

    @JavascriptInterface
    public boolean openPsDetail(String str, String str2) {
        if (AdManager.h()) {
            z.a().d(INTERFACE_NAME, "[jsbridge]start openPsDetail: showId = " + str + ", adInfo = " + str2);
        }
        try {
            AdsDTO adsDTO = (AdsDTO) GsonUtil.a(str2, AdsDTO.class);
            if (adsDTO == null) {
                AthenaTracker.G(null, str, false);
                AthenaTracker.F(null, str, null, false);
                z.a().w(INTERFACE_NAME, "[jsbridge]openPsDetail failed, adsDTO is null.");
                return false;
            }
            adsDTO.setUuid(str);
            AdxImpBean adxImpBean = new AdxImpBean();
            adxImpBean.pmid = adsDTO.getJsCodeSeatId();
            adxImpBean.triggerId = adsDTO.getJsTriggerId();
            adxImpBean.requestId = adsDTO.getJsRequestId();
            adsDTO.setImpBeanRequest(adxImpBean);
            adsDTO.setPslinkInfo(e1.v(adsDTO));
            AthenaTracker.G(adsDTO.getJsTriggerId(), str, false);
            return h(adsDTO);
        } catch (Exception e11) {
            z.a().w(INTERFACE_NAME, "[jsbridge]openPsDetail failed, error: " + Log.getStackTraceString(e11));
            AthenaTracker.G(null, str, false);
            AthenaTracker.F(null, str, null, false);
            return false;
        }
    }

    @JavascriptInterface
    public void showAdmAdFromJs(String str, String str2, String str3, String str4, String str5) {
        AdsDTO adsDTO;
        try {
            adsDTO = (AdsDTO) GsonUtil.a(str5, AdsDTO.class);
        } catch (Exception unused) {
            z.a().w(INTERFACE_NAME, "showAdmAdFromJs: adInfo is not available");
            adsDTO = null;
        }
        if (adsDTO == null) {
            return;
        }
        adsDTO.setUuid(str4);
        AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.pmid = str;
        adxImpBean.triggerId = str2;
        adxImpBean.requestId = str3;
        adsDTO.setImpBeanRequest(adxImpBean);
        adsDTO.setFromJs(true);
        adsDTO.setPslinkInfo(e1.v(adsDTO));
        AthenaTracker.C(adsDTO, 1, 0);
        l2 l2Var = new l2(adsDTO.getCodeSeatId());
        l2Var.C(new a(l2Var, this, adsDTO));
        f(c(str4, 1, 0), null);
        l2Var.R0(adsDTO);
    }
}
