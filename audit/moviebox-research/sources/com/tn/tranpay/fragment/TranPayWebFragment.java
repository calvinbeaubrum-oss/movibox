package com.tn.tranpay.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.z;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.tn.tranpay.TranPayConfiguration;
import com.tn.tranpay.event.AppScopeVMlProvider;
import com.tn.tranpay.event.FlowEventBus;
import com.tn.tranpay.helper.PayUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class TranPayWebFragment extends BaseFragment<np.c> implements NetworkUtils.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f50145q = new a(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f50146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f50147s;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f50149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebView f50150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f50151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f50152i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f50154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50155l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f50157n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f50148d = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f50153j = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<String, Long> f50156m = new HashMap<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WebChromeClient f50158o = new b();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WebViewClient f50159p = new c();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TranPayWebFragment a() {
            return new TranPayWebFragment();
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
            np.c mViewBinding;
            AppCompatTextView appCompatTextView;
            Intrinsics.g(view, "view");
            Intrinsics.g(title, "title");
            super.onReceivedTitle(view, title);
            TranPayWebFragment.this.f50148d = title;
            String str = TranPayWebFragment.this.f50148d;
            if (str == null || (mViewBinding = TranPayWebFragment.this.getMViewBinding()) == null || (appCompatTextView = mViewBinding.f72133j) == null) {
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
            HashMap<String, String> mapG;
            Intrinsics.g(view, "view");
            Intrinsics.g(url, "url");
            super.onPageFinished(view, url);
            fq.a aVar = fq.a.f65215a;
            fq.a.c(aVar, TranPayWebFragment.this.x0() + " --> mWebViewClient --> onPageFinished() --> url = " + url, null, 2, null);
            if (!TranPayWebFragment.this.f50154k) {
                TranPayWebFragment.this.I0(url);
                return;
            }
            hq.c logViewConfig = TranPayWebFragment.this.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.j(false);
            }
            if (TranPayWebFragment.this.f50156m.get(url) == null) {
                fq.a.e(aVar, TranPayWebFragment.this.x0() + " --> mWebViewClient --> onPageFinished() --> 未记录请求加载的耗时 --> url = " + url, null, 2, null);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = TranPayWebFragment.this.f50156m.get(url);
            Intrinsics.d(obj);
            long jLongValue = jCurrentTimeMillis - ((Number) obj).longValue();
            hq.c logViewConfig2 = TranPayWebFragment.this.getLogViewConfig();
            if (logViewConfig2 == null || (mapG = logViewConfig2.g()) == null) {
                return;
            }
            mapG.put("duration", String.valueOf(jLongValue));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap bitmap) {
            HashMap<String, String> mapG;
            Intrinsics.g(view, "view");
            Intrinsics.g(url, "url");
            super.onPageStarted(view, url, bitmap);
            if (TranPayWebFragment.this.v0(url, "onPageStarted()")) {
                return;
            }
            ViewGroup viewGroup = TranPayWebFragment.this.f50149f;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            np.c mViewBinding = TranPayWebFragment.this.getMViewBinding();
            ProgressBar progressBar = mViewBinding != null ? mViewBinding.f72130g : null;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (TranPayWebFragment.this.f50156m.get(url) == null) {
                TranPayWebFragment.this.f50156m.put(url, Long.valueOf(System.currentTimeMillis()));
            }
            hq.c logViewConfig = TranPayWebFragment.this.getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("url", url);
            }
            TranPayWebFragment.this.f50154k = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            Intrinsics.g(error, "error");
            super.onReceivedError(view, request, error);
            fq.a.e(fq.a.f65215a, TranPayWebFragment.this.x0() + " --> mWebViewClient --> onReceivedError() --> url = " + request.getUrl() + " --> error = " + error, null, 2, null);
            TranPayWebFragment.this.f50154k = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            Intrinsics.g(errorResponse, "errorResponse");
            super.onReceivedHttpError(view, request, errorResponse);
            fq.a.e(fq.a.f65215a, TranPayWebFragment.this.x0() + " --> mWebViewClient --> onReceivedHttpError() --> url = " + request.getUrl() + " --> errorResponse = " + errorResponse, null, 2, null);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            TranPayWebFragment tranPayWebFragment = TranPayWebFragment.this;
            String string = request.getUrl().toString();
            Intrinsics.f(string, "request.url.toString()");
            tranPayWebFragment.v0(string, "shouldInterceptRequest()");
            return super.shouldInterceptRequest(view, request);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            String string;
            Context context;
            fq.a aVar = fq.a.f65215a;
            fq.a.c(aVar, TranPayWebFragment.this.x0() + " --> mWebViewClient --> shouldOverrideUrlLoading() --> url = " + webResourceRequest, null, 2, null);
            if (TranPayWebFragment.this.F0(String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null))) {
                return true;
            }
            if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null && (string = url.toString()) != null) {
                TranPayWebFragment tranPayWebFragment = TranPayWebFragment.this;
                if (l.L(string, "tel:", false, 2, null)) {
                    fq.a.e(aVar, tranPayWebFragment.x0() + " --> mWebViewClient --> shouldOverrideUrlLoading() --> 使用Intent来处理拨号请求 --> url = " + string, null, 2, null);
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(string));
                    if (webView != null && (context = webView.getContext()) != null) {
                        context.startActivity(intent);
                    }
                    return true;
                }
                if (tranPayWebFragment.v0(string, "shouldOverrideUrlLoading()")) {
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    static {
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.f50046a;
        f50146r = tranPayConfiguration.q() ? "https://cashier-serverweb.paynicorn.com/result" : "https://cashier-serverweb-test.paynicorn.com/result";
        f50147s = tranPayConfiguration.q() ? "https://cashier-serverweb.paynicorn.com/api/cancelPay" : "https://cashier-serverweb-test.paynicorn.com/api/cancelPay";
    }

    public static final void B0(TranPayWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        WebView webView = this$0.f50150g;
        if (webView != null) {
            webView.reload();
        }
    }

    public static final void C0(TranPayWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.A0(true);
    }

    public static final void D0(TranPayWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.A0(false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void E0(View view) {
        HashMap<String, String> mapG;
        FrameLayout frameLayout;
        WebView webView = new WebView(view.getContext());
        np.c mViewBinding = getMViewBinding();
        if (mViewBinding != null && (frameLayout = mViewBinding.f72126b) != null) {
            frameLayout.addView(webView, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        webView.setLayerType(2, null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setSavePassword(false);
        kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new TranPayWebFragment$initWeb$1$1$1(settings, null), 3, null);
        settings.setMixedContentMode(0);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(false);
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
        webView.setWebChromeClient(this.f50158o);
        webView.setWebViewClient(this.f50159p);
        webView.setOverScrollMode(2);
        this.f50150g = webView;
        String str = this.f50151h;
        if (str != null) {
            this.f50156m.put(str, Long.valueOf(System.currentTimeMillis()));
            hq.c logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
                mapG.put("url", this.f50151h);
            }
            np.c mViewBinding2 = getMViewBinding();
            ProgressBar progressBar = mViewBinding2 != null ? mViewBinding2.f72130g : null;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            fq.a.g(fq.a.f65215a, x0() + " --> initWeb() --> WebView初始化完成 --> mCustomWebView?.loadUrl(it) 开始加载收银台 -- url = " + this.f50151h, null, 2, null);
            WebView webView2 = this.f50150g;
            if (webView2 != null) {
                webView2.loadUrl(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(String str) {
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        if (this.f50156m.get(str) != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l11 = this.f50156m.get(str);
            long jLongValue = jCurrentTimeMillis - (l11 != null ? l11.longValue() : jCurrentTimeMillis);
            fq.a.g(fq.a.f65215a, x0() + " --> pageFinish() --> mUrl = " + this.f50151h + " -- used time = " + jLongValue, null, 2, null);
            hq.c logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (mapG2 = logViewConfig.g()) != null) {
                mapG2.put("duration", String.valueOf(jLongValue));
            }
            if (this.f50156m.get("on_create") != null) {
                Long l12 = this.f50156m.get("on_create");
                Intrinsics.d(l12);
                long jLongValue2 = jCurrentTimeMillis - l12.longValue();
                hq.c logViewConfig2 = getLogViewConfig();
                if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
                    mapG.put("duration", String.valueOf(jLongValue2));
                }
                this.f50156m.put("on_create", null);
            }
        }
        hq.c logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 == null) {
            return;
        }
        logViewConfig3.j(true);
    }

    private final void initViewModel() {
        String string;
        np.c mViewBinding;
        AppCompatTextView appCompatTextView;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("url")) == null) {
            string = "";
        }
        this.f50151h = string;
        Bundle arguments2 = getArguments();
        this.f50152i = arguments2 != null ? arguments2.getString("cpFrontPage") : null;
        Bundle arguments3 = getArguments();
        this.f50153j = arguments3 != null ? arguments3.getBoolean("shouldOpenCpFrontPage") : true;
        String[] strArrA = z.a(this.f50151h, "\\/");
        if (strArrA != null) {
            if (!(strArrA.length == 0)) {
                String str = strArrA[strArrA.length - 1];
                this.f50148d = str;
                if (str == null || (mViewBinding = getMViewBinding()) == null || (appCompatTextView = mViewBinding.f72133j) == null) {
                    return;
                }
                appCompatTextView.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v0(String str, String str2) {
        fq.a aVar = fq.a.f65215a;
        fq.a.g(aVar, x0() + " --> mWebViewClient --> checkUrl() --> from = " + str2 + " --> url = " + str + " --> resultPageUrl = " + y0(), null, 2, null);
        if (this.f50157n) {
            fq.a.c(aVar, x0() + " --> mWebViewClient --> isTriggerFinishPage = " + str2 + " --> url = " + str + " --> resultPageUrl = " + y0(), null, 2, null);
            return true;
        }
        if (!StringsKt__StringsKt.Q(str, y0(), false, 2, null)) {
            if (!StringsKt__StringsKt.Q(str, f50147s, false, 2, null)) {
                return false;
            }
            this.f50157n = true;
            fq.a.g(aVar, x0() + " --> mWebViewClient --> checkUrl() --> cancel --> from = " + str2 + " --> url = " + str, null, 2, null);
            this.f50155l = true;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return true;
            }
            activity.finish();
            return true;
        }
        if (this.f50153j) {
            this.f50157n = true;
            fq.a.g(aVar, x0() + " --> mWebViewClient --> checkUrl() -- shouldOpenCpFrontPage --> result --> from = " + str2 + " --> url = " + str, null, 2, null);
            com.tn.tranpay.event.b bVar = new com.tn.tranpay.event.b(0);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = com.tn.tranpay.event.b.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, bVar, 0L);
            return false;
        }
        this.f50157n = true;
        fq.a.g(aVar, x0() + " --> mWebViewClient --> checkUrl() -- shouldNotOpenCpFrontPage --> result --> from = " + str2 + " --> url = " + str, null, 2, null);
        com.tn.tranpay.event.b bVar2 = new com.tn.tranpay.event.b(0);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = com.tn.tranpay.event.b.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, bVar2, 0L);
        ThreadUtils.f().postDelayed(new Runnable() { // from class: com.tn.tranpay.fragment.k
            @Override // java.lang.Runnable
            public final void run() {
                TranPayWebFragment.w0(this.f50172a);
            }
        }, 400L);
        return true;
    }

    public static final void w0(TranPayWebFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String x0() {
        String simpleName = TranPayWebFragment.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void A0(boolean z11) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            fq.a.c(fq.a.f65215a, "用户关闭了 TranPayWebFragment", null, 2, null);
            if (z11) {
                activity.onBackPressed();
            } else {
                activity.finish();
            }
        }
    }

    public final boolean F0(String str) {
        Object objM163constructorimpl;
        fq.a aVar = fq.a.f65215a;
        fq.a.c(aVar, x0() + " --> isDeeplink() --> url = " + str, null, 2, null);
        boolean z11 = true;
        if (TextUtils.isEmpty(str)) {
            return (l.L(str, "tel:", false, 2, null) || l.L(str, "intent:", false, 2, null) || l.L(str, "mailto:", false, 2, null) || l.L(str, "sms:", false, 2, null) || l.L(str, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null) || l.L(str, "ftp", false, 2, null)) ? false : true;
        }
        try {
            Result.Companion companion = Result.Companion;
            Uri uri = Uri.parse(str);
            fq.a.g(aVar, "isAdDeeplink --> url = " + str + ", scheme = " + uri.getScheme() + " -- host = " + uri.getHost(), null, 2, null);
            if (Intrinsics.b(uri.getScheme(), "intent")) {
                G0(str);
            } else {
                z11 = false;
            }
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf(z11));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final boolean G0(String str) {
        return PayUtils.f50173a.g(str);
    }

    public final boolean H0() {
        WebView webView = this.f50150g;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        WebView webView2 = this.f50150g;
        if (webView2 == null) {
            return true;
        }
        webView2.goBack();
        return true;
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public hq.c g0() {
        return new hq.c("web_page", false, 2, null);
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        ProgressBar progressBar;
        np.d dVar;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        Intrinsics.g(view, "view");
        np.c mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            mViewBinding.f72132i.setVisibility(0);
        }
        this.f50156m.put("on_create", Long.valueOf(System.currentTimeMillis()));
        np.c mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView3 = mViewBinding2.f72129f) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TranPayWebFragment.B0(this.f50169a, view2);
                }
            });
        }
        np.c mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatImageView2 = mViewBinding3.f72127c) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TranPayWebFragment.C0(this.f50170a, view2);
                }
            });
        }
        np.c mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.f72128d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tn.tranpay.fragment.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TranPayWebFragment.D0(this.f50171a, view2);
                }
            });
        }
        np.c mViewBinding5 = getMViewBinding();
        this.f50149f = (mViewBinding5 == null || (dVar = mViewBinding5.f72134k) == null) ? null : dVar.f72136b;
        np.c mViewBinding6 = getMViewBinding();
        if (mViewBinding6 != null && (progressBar = mViewBinding6.f72130g) != null) {
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(com.tn.tranpay.e.f50084c.b().d()));
        }
        initViewModel();
        E0(view);
        NetworkUtils.x(this);
    }

    @Override // com.blankj.utilcode.util.NetworkUtils.a
    public void k(NetworkUtils.NetworkType networkType) {
        WebView webView;
        hq.c logViewConfig = getLogViewConfig();
        if ((logViewConfig == null || !logViewConfig.i()) && this.f50154k && (webView = this.f50150g) != null) {
            webView.reload();
        }
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.tn.tranpay.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fq.a.g(fq.a.f65215a, x0() + " --> onCreate()", null, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        NetworkUtils.B(this);
        if (this.f50155l) {
            com.tn.tranpay.event.b bVar = new com.tn.tranpay.event.b(-1);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = com.tn.tranpay.event.b.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, bVar, 0L);
            return;
        }
        com.tn.tranpay.event.b bVar2 = new com.tn.tranpay.event.b(0);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = com.tn.tranpay.event.b.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, bVar2, 0L);
    }

    @Override // com.tn.tranpay.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        WebView webView = this.f50150g;
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroyView();
    }

    @Override // com.blankj.utilcode.util.NetworkUtils.a
    public void onDisconnected() {
    }

    public final String y0() {
        String str = this.f50152i;
        if (!(true ^ (str == null || l.y(str)))) {
            str = null;
        }
        return str == null ? f50146r : str;
    }

    @Override // com.tn.tranpay.fragment.BaseFragment
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public np.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        np.c cVarC = np.c.c(inflater);
        Intrinsics.f(cVarC, "inflate(inflater)");
        return cVarC;
    }
}
