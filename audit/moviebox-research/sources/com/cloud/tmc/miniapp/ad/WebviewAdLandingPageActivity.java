package com.cloud.tmc.miniapp.ad;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.cloud.tmc.ad.bean.AdExtraBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.g0;
import com.cloud.tmc.integration.utils.l;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.AdAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.render.method.ShellGameJsInterface;
import com.cloud.tmc.render.system.SystemWebView;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.collections.r;
import kotlin.jvm.internal.Intrinsics;
import uc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class WebviewAdLandingPageActivity extends WebViewActivity {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f31354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f31355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f31356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f31357m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f31358n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DownUpPointBean f31360p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AdsDTO f31361q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f31353i = "WebviewAdLandingPageActivity";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bundle f31359o = new Bundle();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f31362r = System.currentTimeMillis();

    public final void S(String str) {
        AdsDTO adsDTO;
        Integer codeSeatType;
        List listL;
        ArrayList<String> clickTrackingUrls;
        App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(this.f31358n);
        fc.a aVar = new fc.a("landingPage");
        ArrayList arrayList = new ArrayList();
        AdsDTO adsDTO2 = this.f31361q;
        if (TextUtils.isEmpty(adsDTO2 != null ? adsDTO2.getAdm() : null) || (adsDTO = this.f31361q) == null || (codeSeatType = adsDTO.getCodeSeatType()) == null || codeSeatType.intValue() != 1) {
            arrayList.add(str);
        } else {
            AdsDTO adsDTO3 = this.f31361q;
            if (adsDTO3 == null || (clickTrackingUrls = adsDTO3.getClickTrackingUrls()) == null || (listL = CollectionsKt___CollectionsKt.J0(clickTrackingUrls)) == null) {
                listL = g.l();
            }
            arrayList.addAll(listL);
        }
        aVar.c(r.f(TuplesKt.a("ad_click", arrayList)));
        b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(appFindApp);
        if (eventCenterInstance != null) {
            eventCenterInstance.d("adLandingPage", aVar);
        }
    }

    public final void T() {
        this.f31359o.putLong("web_duration", System.currentTimeMillis() - this.f31362r);
        this.f31359o.putLong(TrackingKey.EVENT_TS, this.f31362r);
        this.f31359o.putString("web_url", this.f31354j);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31358n, AdAnalyseType.ad_web_callback, "", this.f31359o);
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, id.i
    public Integer getViewThemeMode() {
        return 1;
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        String stringExtra = getIntent().getStringExtra("ad_landingPage_url");
        this.f31354j = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        try {
            this.f31355k = getIntent().getStringExtra("adInfo");
            this.f31356l = getIntent().getStringExtra("adsDTO");
            this.f31357m = getIntent().getStringExtra("pointData");
            this.f31358n = getIntent().getStringExtra(PushConstants.PROVIDER_FIELD_APP_ID);
            Map<String, ? extends Object> _dataMap = (Map) new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdLandingPageActivity$initData$gson$1
            }.getType(), new g0()).serializeNulls().create().fromJson(this.f31355k, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdLandingPageActivity$initData$_dataMap$1
            }.getType());
            this.f31360p = (DownUpPointBean) k.d(this.f31357m, DownUpPointBean.class);
            this.f31361q = (AdsDTO) k.d(this.f31356l, AdsDTO.class);
            l lVar = l.f31069a;
            Intrinsics.f(_dataMap, "_dataMap");
            lVar.a(_dataMap, this.f31359o);
        } catch (Throwable th2) {
            p.e(this.f31353i, "parse LandingPage info fail: " + th2);
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
            systemWebView.addJavascriptInterface(new ShellGameJsInterface(), "dltms");
        }
        if (this.f31360p == null || this.f31361q == null) {
            finish();
        } else {
            String str = this.f31354j;
            if (str == null) {
                str = "";
            }
            if (ga.b.d(str)) {
                ga.b bVar = ga.b.f65469a;
                DownUpPointBean downUpPointBean = this.f31360p;
                Intrinsics.d(downUpPointBean);
                AdsDTO adsDTO = this.f31361q;
                Intrinsics.d(adsDTO);
                String str2 = this.f31358n;
                String str3 = str2 != null ? str2 : "";
                String sDKVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion();
                Intrinsics.f(sDKVersion, "get(\n                   …             ).sdkVersion");
                this.f31354j = bVar.f(downUpPointBean, adsDTO, new AdExtraBean(str3, false, sDKVersion), true);
            }
            getIntent().putExtra("pageUri", this.f31354j);
        }
        super.initData();
        T();
        String str4 = this.f31354j;
        if (str4 != null) {
            S(str4);
        }
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(((AppManager) tc.a.a(AppManager.class)).findApp(this.f31358n));
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

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, zc.o
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        T();
        AdsDTO adsDTO = this.f31361q;
        if (!TextUtils.isEmpty(adsDTO != null ? adsDTO.getAdm() : null) && webResourceRequest != null && (url = webResourceRequest.getUrl()) != null) {
            String string = url.toString();
            Intrinsics.f(string, "it.toString()");
            S(string);
        }
        Boolean boolShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
        Intrinsics.f(boolShouldOverrideUrlLoading, "super.shouldOverrideUrlLoading(view, request)");
        return boolShouldOverrideUrlLoading;
    }
}
