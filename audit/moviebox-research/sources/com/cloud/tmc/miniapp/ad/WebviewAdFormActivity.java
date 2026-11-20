package com.cloud.tmc.miniapp.ad;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.cloud.tmc.ad.bean.AdExtraBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.bean.FormBean;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.g0;
import com.cloud.tmc.integration.utils.l;
import com.cloud.tmc.integration.utils.n0;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.AdAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.render.system.SystemWebView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import mb.c;
import mb.d;
import uc.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class WebviewAdFormActivity extends WebViewActivity {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f31333y = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f31341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f31342q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f31343r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f31344s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f31345t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DownUpPointBean f31347v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AdsDTO f31348w;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f31334i = "WebviewAdFormActivity";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f31335j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f31336k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f31337l = "sspWebView";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f31338m = "height";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f31339n = "formId";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f31340o = LogSeverity.EMERGENCY_VALUE;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Bundle f31346u = new Bundle();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f31349x = System.currentTimeMillis();

    /* JADX INFO: compiled from: source.java */
    public static final class SspWebWindow {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f31350a;

        public SspWebWindow(Activity activity, int i11) {
            this.f31350a = new WeakReference<>(activity);
        }

        @JavascriptInterface
        public final void close() {
            Activity activity = this.f31350a.get();
            if (activity != null) {
                activity.finish();
            }
        }

        @JavascriptInterface
        public final void submitForm(String str) {
            Activity activity = this.f31350a.get();
            FormBean formBean = null;
            WebviewAdFormActivity webviewAdFormActivity = activity instanceof WebviewAdFormActivity ? (WebviewAdFormActivity) activity : null;
            if (webviewAdFormActivity != null) {
                try {
                    FormBean formBean2 = (FormBean) new Gson().fromJson(str, FormBean.class);
                    if (formBean2 != null) {
                        formBean2.setGaid(q.d());
                        formBean2.setFormId(webviewAdFormActivity.f31342q);
                        formBean2.setIpAddress(q.f31091a.i(webviewAdFormActivity));
                        formBean = formBean2;
                    }
                    webviewAdFormActivity.S(formBean);
                    webviewAdFormActivity.f31346u.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
                    webviewAdFormActivity.f31346u.putString("form_info", String.valueOf(str));
                    ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(webviewAdFormActivity.f31345t, AdAnalyseType.form_infor_set, "", webviewAdFormActivity.f31346u);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    public final void S(final FormBean formBean) {
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).postJson(d.d(), s.j(TuplesKt.a("Accept-Timezone", "UTC")), new HashMap(), formBean, Boolean.FALSE, new c<String>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdFormActivity$realSubmitForm$1
            @Override // mb.c
            public Type d() {
                return new TypeToken<BaseResponse<? extends String>>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdFormActivity$realSubmitForm$1$getType$1
                }.getType();
            }

            @Override // mb.c
            public void e(BaseResponse<? extends Object> fail, Map<String, String> map) {
                Intrinsics.g(fail, "fail");
                WebviewAdFormActivity webviewAdFormActivity = this.f31351a;
                int i11 = webviewAdFormActivity.f31336k;
                if (i11 <= webviewAdFormActivity.f31335j) {
                    webviewAdFormActivity.f31336k = i11 + 1;
                    webviewAdFormActivity.S(formBean);
                }
            }

            @Override // mb.c
            public void g(BaseResponse<? extends String> bean, Map<String, String> map) {
                Intrinsics.g(bean, "bean");
                this.f31351a.f31336k = 1;
            }
        });
    }

    public final void T(String str) {
        App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(this.f31345t);
        fc.a aVar = new fc.a("formPage");
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        aVar.c(r.f(TuplesKt.a("ad_click", arrayList)));
        b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(appFindApp);
        if (eventCenterInstance != null) {
            eventCenterInstance.d("adFromPage", aVar);
        }
    }

    public final void U() {
        this.f31346u.putLong("web_duration", System.currentTimeMillis() - this.f31349x);
        this.f31346u.putLong(TrackingKey.EVENT_TS, this.f31349x);
        this.f31346u.putString("web_url", this.f31341p);
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f31345t, AdAnalyseType.ad_web_callback, "", this.f31346u);
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, id.i
    public Integer getViewThemeMode() {
        return 1;
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        AdsDTO adsDTO;
        String stringExtra = getIntent().getStringExtra("ad_web_form_url");
        this.f31341p = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        }
        try {
            String stringExtra2 = getIntent().getStringExtra("ad_web_ad_info");
            this.f31343r = getIntent().getStringExtra("adsDTO");
            this.f31344s = getIntent().getStringExtra("pointData");
            this.f31345t = getIntent().getStringExtra(PushConstants.PROVIDER_FIELD_APP_ID);
            Map<String, ? extends Object> _dataMap = (Map) new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdFormActivity$initData$gson$1
            }.getType(), new g0()).serializeNulls().create().fromJson(stringExtra2, new TypeToken<Map<String, ? extends Object>>() { // from class: com.cloud.tmc.miniapp.ad.WebviewAdFormActivity$initData$_dataMap$1
            }.getType());
            l lVar = l.f31069a;
            Intrinsics.f(_dataMap, "_dataMap");
            lVar.a(_dataMap, this.f31346u);
            this.f31347v = (DownUpPointBean) k.d(this.f31344s, DownUpPointBean.class);
            this.f31348w = (AdsDTO) k.d(this.f31343r, AdsDTO.class);
        } catch (Exception e11) {
            p.e(this.f31334i, "parse AdForm info fail: " + e11);
        }
        int iMin = this.f31340o;
        try {
            String str = this.f31341p;
            if (str != null) {
                n0 n0Var = n0.f31078a;
                String strF = n0Var.f(this.f31338m, str);
                if (strF == null) {
                    strF = "0";
                }
                String strF2 = n0Var.f(this.f31339n, str);
                this.f31342q = strF2 != null ? Integer.parseInt(strF2) : 0;
                int i11 = Integer.parseInt(strF);
                iMin = Math.min(i11 == 0 ? this.f31340o : com.cloud.tmc.integration.utils.r.a(this, i11), (getResources().getDisplayMetrics().heightPixels * 4) / 5);
            }
        } catch (Exception unused) {
            iMin = this.f31340o;
        }
        FrameLayout frameLayoutO = O();
        ViewGroup.LayoutParams layoutParams = frameLayoutO != null ? frameLayoutO.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = (getResources().getDisplayMetrics().widthPixels * 4) / 5;
            layoutParams2.height = iMin;
            layoutParams2.gravity = 17;
            layoutParams2.topMargin = 0;
            FrameLayout frameLayoutO2 = O();
            if (frameLayoutO2 != null) {
                frameLayoutO2.setLayoutParams(layoutParams2);
            }
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
            systemWebView.addJavascriptInterface(new SspWebWindow(this, this.f31342q), this.f31337l);
        }
        if (this.f31347v != null && (adsDTO = this.f31348w) != null) {
            String clickUrl = adsDTO.getClickUrl();
            if (clickUrl == null) {
                clickUrl = "";
            }
            if (ga.b.d(clickUrl)) {
                ga.b bVar = ga.b.f65469a;
                DownUpPointBean downUpPointBean = this.f31347v;
                Intrinsics.d(downUpPointBean);
                AdsDTO adsDTO2 = this.f31348w;
                Intrinsics.d(adsDTO2);
                String str2 = this.f31345t;
                String str3 = str2 != null ? str2 : "";
                String sDKVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion();
                Intrinsics.f(sDKVersion, "get(\n                   …             ).sdkVersion");
                T(bVar.f(downUpPointBean, adsDTO2, new AdExtraBean(str3, false, sDKVersion), true));
            } else {
                AdsDTO adsDTO3 = this.f31348w;
                String clickUrl2 = adsDTO3 != null ? adsDTO3.getClickUrl() : null;
                T(clickUrl2 != null ? clickUrl2 : "");
            }
        }
        getIntent().putExtra("pageUri", this.f31341p);
        super.initData();
        U();
    }

    @Override // com.cloud.tmc.miniapp.ui.WebViewActivity, com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(((AppManager) tc.a.a(AppManager.class)).findApp(this.f31345t));
        if (eventCenterInstance != null) {
            fc.a aVar = new fc.a("formPage");
            aVar.c(r.f(TuplesKt.a("finish", "true")));
            Unit unit = Unit.f68710a;
            eventCenterInstance.d("adFromPage", aVar);
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
        U();
        AdsDTO adsDTO = this.f31348w;
        if (!TextUtils.isEmpty(adsDTO != null ? adsDTO.getAdm() : null) && webResourceRequest != null && (url = webResourceRequest.getUrl()) != null) {
            String string = url.toString();
            Intrinsics.f(string, "it.toString()");
            T(string);
        }
        Boolean boolShouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
        Intrinsics.f(boolShouldOverrideUrlLoading, "super.shouldOverrideUrlLoading(view, request)");
        return boolShouldOverrideUrlLoading;
    }
}
