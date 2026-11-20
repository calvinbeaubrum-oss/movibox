package com.transsion.payment.lib.strategy.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.z;
import com.tn.lib.util.networkinfo.g;
import com.transsion.baselib.report.h;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.payment.lib.d;
import com.transsion.payment.lib.strategy.ui.PayWebFragment;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import j00.e;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import yp.f;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class PayWebFragment extends BaseFragment<cv.b> implements g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f54088l = new a(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f54089m = "https://api.paynicorn.com/sp-gateway/redirect/mock";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f54091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebView f54092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f54093d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f54094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54095g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54097i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f54090a = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, Long> f54096h = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WebChromeClient f54098j = new b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WebViewClient f54099k = new c();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PayWebFragment a() {
            return new PayWebFragment();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int i11) {
            Intrinsics.g(view, "view");
            super.onProgressChanged(view, i11);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            cv.b mViewBinding;
            AppCompatTextView appCompatTextView;
            Intrinsics.g(view, "view");
            Intrinsics.g(title, "title");
            super.onReceivedTitle(view, title);
            PayWebFragment.this.f54090a = title;
            String str = PayWebFragment.this.f54090a;
            if (str == null || (mViewBinding = PayWebFragment.this.getMViewBinding()) == null || (appCompatTextView = mViewBinding.f62820j) == null) {
                return;
            }
            appCompatTextView.setText(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.g(view, "view");
            Intrinsics.g(url, "url");
            super.onPageFinished(view, url);
            if (PayWebFragment.this.f54094f) {
                return;
            }
            PayWebFragment.this.A0(url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap bitmap) {
            HashMap<String, String> mapG;
            Intrinsics.g(view, "view");
            Intrinsics.g(url, "url");
            super.onPageStarted(view, url, bitmap);
            if (PayWebFragment.this.s0(url, "onPageStarted()")) {
                return;
            }
            ViewGroup viewGroup = PayWebFragment.this.f54091b;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            cv.b mViewBinding = PayWebFragment.this.getMViewBinding();
            ProgressBar progressBar = mViewBinding != null ? mViewBinding.f62817g : null;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (PayWebFragment.this.f54096h.get(url) == null) {
                PayWebFragment.this.f54096h.put(url, Long.valueOf(System.currentTimeMillis()));
            }
            h logViewConfig = PayWebFragment.this.getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("url", url);
            }
            PayWebFragment.this.f54094f = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            Intrinsics.g(error, "error");
            super.onReceivedError(view, request, error);
            d.f54044a.b(PayWebFragment.this.t0() + " --> mWebViewClient --> onReceivedError() --> url = " + request.getUrl() + " --> error = " + error);
            PayWebFragment.this.f54094f = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            Intrinsics.g(errorResponse, "errorResponse");
            super.onReceivedHttpError(view, request, errorResponse);
            d.f54044a.b(PayWebFragment.this.t0() + " --> mWebViewClient --> onReceivedHttpError() --> url = " + request.getUrl() + " --> errorResponse = " + errorResponse);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            PayWebFragment payWebFragment = PayWebFragment.this;
            String string = request.getUrl().toString();
            Intrinsics.f(string, "request.url.toString()");
            payWebFragment.s0(string, "shouldInterceptRequest()");
            return super.shouldInterceptRequest(view, request);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String string;
            Context context;
            if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null && (string = url.toString()) != null) {
                PayWebFragment payWebFragment = PayWebFragment.this;
                if (l.L(string, "tel:", false, 2, null)) {
                    d.f54044a.b(payWebFragment.t0() + " --> mWebViewClient --> shouldOverrideUrlLoading() --> 使用Intent来处理拨号请求 --> url = " + string);
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(string));
                    if (webView != null && (context = webView.getContext()) != null) {
                        context.startActivity(intent);
                    }
                    return true;
                }
                if (payWebFragment.s0(string, "shouldOverrideUrlLoading()")) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(String str) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        HashMap<String, String> mapG4;
        if (this.f54096h.get(str) != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l11 = this.f54096h.get(str);
            long jLongValue = jCurrentTimeMillis - (l11 != null ? l11.longValue() : jCurrentTimeMillis);
            d.f54044a.a(t0() + " --> pageFinish() --> mUrl = " + this.f54093d + " -- used time = " + jLongValue);
            h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG4 = logViewConfig.g()) != null) {
                mapG4.put("load_h5_time", String.valueOf(jLongValue));
            }
            if (this.f54096h.get("on_create") != null) {
                Long l12 = this.f54096h.get("on_create");
                Intrinsics.d(l12);
                long jLongValue2 = jCurrentTimeMillis - l12.longValue();
                h logViewConfig2 = getLogViewConfig();
                if (logViewConfig2 != null && (mapG3 = logViewConfig2.g()) != null) {
                    mapG3.put("load_time", String.valueOf(jLongValue2));
                }
                this.f54096h.put("on_create", null);
            }
            h logViewConfig3 = getLogViewConfig();
            if (logViewConfig3 != null && (mapG2 = logViewConfig3.g()) != null) {
                mapG2.put("load_h5_time", String.valueOf(jLongValue));
            }
        }
        h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG = logViewConfig4.g()) != null) {
            PayWebActivity.a aVar = PayWebActivity.f54082d;
            String strB = aVar.b();
            Bundle arguments = getArguments();
            mapG.put(strB, arguments != null ? arguments.getString(aVar.b()) : null);
        }
        h logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 == null) {
            return;
        }
        logViewConfig5.j(true);
    }

    private final void initViewModel() {
        String string;
        cv.b mViewBinding;
        AppCompatTextView appCompatTextView;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(PayWebActivity.f54082d.a())) == null) {
            string = "";
        }
        this.f54093d = string;
        String[] strArrA = z.a(string, "\\/");
        if (strArrA != null) {
            if (!(strArrA.length == 0)) {
                String str = strArrA[strArrA.length - 1];
                this.f54090a = str;
                if (str == null || (mViewBinding = getMViewBinding()) == null || (appCompatTextView = mViewBinding.f62820j) == null) {
                    return;
                }
                appCompatTextView.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t0() {
        String simpleName = PayWebFragment.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public static final void v0(PayWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        WebView webView = this$0.f54092c;
        if (webView != null) {
            webView.reload();
        }
    }

    public static final void w0(PayWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public static final void x0(PayWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        f fVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        Intrinsics.g(view, "view");
        cv.b mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            ConstraintLayout toolBar = mViewBinding.f62819i;
            Intrinsics.f(toolBar, "toolBar");
            so.c.k(toolBar);
        }
        this.f54096h.put("on_create", Long.valueOf(System.currentTimeMillis()));
        cv.b mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView3 = mViewBinding2.f62816f) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: dv.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.v0(this.f63539a, view2);
                }
            });
        }
        cv.b mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatImageView2 = mViewBinding3.f62814c) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: dv.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.w0(this.f63540a, view2);
                }
            });
        }
        cv.b mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.f62815d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: dv.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PayWebFragment.x0(this.f63541a, view2);
                }
            });
        }
        cv.b mViewBinding5 = getMViewBinding();
        this.f54091b = (mViewBinding5 == null || (fVar = mViewBinding5.f62821k) == null) ? null : fVar.f81600b;
        initViewModel();
        y0(view);
        com.tn.lib.util.networkinfo.f.f49475a.l(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public h newLogViewConfig() {
        return new h("snifferh5page", false, 2, null);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        WebView webView;
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        h logViewConfig = getLogViewConfig();
        if ((logViewConfig == null || !logViewConfig.i()) && this.f54094f && (webView = this.f54092c) != null) {
            webView.reload();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.f54044a.a(t0() + " --> onCreate() --> 聚合支付收银台容器初始化");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tn.lib.util.networkinfo.f.f49475a.m(this);
        if (this.f54095g) {
            e eVar = new e(-1);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = e.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, eVar, 0L);
            return;
        }
        e eVar2 = new e(0);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = e.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, eVar2, 0L);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        WebView webView = this.f54092c;
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroyView();
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }

    public final boolean s0(String str, String str2) {
        if (this.f54097i) {
            return true;
        }
        if (!StringsKt__StringsKt.Q(str, f54089m, false, 2, null)) {
            if (!StringsKt__StringsKt.Q(str, "https://cashier-serverweb.paynicorn.com/api/cancelPay", false, 2, null)) {
                return false;
            }
            this.f54097i = true;
            d.f54044a.b(t0() + " --> mWebViewClient --> checkUrl() --> from = " + str2 + " --> url = " + str);
            this.f54095g = true;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return true;
            }
            activity.finish();
            return true;
        }
        this.f54097i = true;
        d.f54044a.b(t0() + " --> mWebViewClient --> checkUrl() --> from = " + str2 + " --> url = " + str);
        e eVar = new e(0);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = e.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, eVar, 0L);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            return true;
        }
        activity2.finish();
        return true;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public cv.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        cv.b bVarC = cv.b.c(inflater);
        Intrinsics.f(bVarC, "inflate(inflater)");
        return bVarC;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void y0(View view) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        FrameLayout frameLayout;
        Context context = view.getContext();
        WebView webView = new WebView(context);
        cv.b mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f62813b) != null) {
            frameLayout.addView(webView, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        webView.setLayerType(2, null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setSavePassword(false);
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        Intrinsics.f(context, "context");
        settings.setCacheMode(fVar.j(context) ? -1 : 1);
        settings.setMixedContentMode(0);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(false);
        settings.setUseWideViewPort(false);
        settings.setDomStorageEnabled(true);
        settings.setNeedInitialFocus(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDefaultFontSize(16);
        settings.setMinimumFontSize(12);
        settings.setGeolocationEnabled(true);
        webView.setWebChromeClient(this.f54098j);
        webView.setWebViewClient(this.f54099k);
        webView.setOverScrollMode(2);
        this.f54092c = webView;
        String str = this.f54093d;
        if (str != null) {
            this.f54096h.put(str, Long.valueOf(System.currentTimeMillis()));
            h logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG2 = logViewConfig.g()) != null) {
                mapG2.put("url", this.f54093d);
            }
            h logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
                mapG.put("loading", "1");
            }
            cv.b mViewBinding2 = getMViewBinding();
            ProgressBar progressBar = mViewBinding2 != null ? mViewBinding2.f62817g : null;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            d.f54044a.a(t0() + " --> initWeb() --> WebView初始化完成 --> mCustomWebView?.loadUrl(it) 开始加载收银台 -- url = " + this.f54093d);
            WebView webView2 = this.f54092c;
            if (webView2 != null) {
                webView2.loadUrl(str);
            }
        }
    }

    public final boolean z0() {
        WebView webView = this.f54092c;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        WebView webView2 = this.f54092c;
        if (webView2 == null) {
            return true;
        }
        webView2.goBack();
        return true;
    }
}
