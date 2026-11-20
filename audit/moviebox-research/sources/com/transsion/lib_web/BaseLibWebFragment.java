package com.transsion.lib_web;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.p;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.n;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.util.networkinfo.g;
import com.transsion.lib_web.BaseLibWebFragment;
import com.transsion.web.api.WebConstants;
import hu.e;
import hu.f;
import hu.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
public abstract class BaseLibWebFragment extends Fragment implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f53054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public iu.a f53055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.lib_web.zip.loader.d f53056c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f53058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f53060h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f53057d = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f53061i = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends p {
        public a() {
            super(true);
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            if (BaseLibWebFragment.this.n0().f67702b.canGoBack()) {
                BaseLibWebFragment.this.n0().f67702b.goBack();
            } else {
                BaseLibWebFragment.this.requireActivity().finish();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            super.onHideCustomView();
            BaseLibWebFragment.this.F0();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int i11) {
            Intrinsics.g(view, "view");
            super.onProgressChanged(view, i11);
            BaseLibWebFragment.this.G0(view, i11);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            Intrinsics.g(view, "view");
            Intrinsics.g(title, "title");
            super.onReceivedTitle(view, title);
            BaseLibWebFragment.this.R0(title);
            BaseLibWebFragment.this.H0(view, title);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            BaseLibWebFragment.this.I0(view, customViewCallback);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends f {
        public c(BridgeWebView bridgeWebView) {
            super(bridgeWebView);
        }

        @Override // hu.f
        @JavascriptInterface
        public void close() {
            super.close();
            FragmentActivity activity = BaseLibWebFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.g(view, "view");
            Intrinsics.g(url, "url");
            super.onPageFinished(view, url);
            BaseLibWebFragment.this.J0(view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap bitmap) {
            Intrinsics.g(view, "view");
            Intrinsics.g(url, "url");
            super.onPageStarted(view, url, bitmap);
            BaseLibWebFragment.this.K0(view, url, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            BaseLibWebFragment.this.L0(webView, i11, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            Intrinsics.g(error, "error");
            super.onReceivedError(view, request, error);
            BaseLibWebFragment.this.M0(view, request, error);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            Intrinsics.g(errorResponse, "errorResponse");
            super.onReceivedHttpError(view, request, errorResponse);
            BaseLibWebFragment.this.N0(view, request, errorResponse);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            WebResourceResponse webResourceResponseC;
            Intrinsics.g(view, "view");
            Intrinsics.g(request, "request");
            com.transsion.lib_web.zip.loader.d dVarP0 = BaseLibWebFragment.this.p0();
            return (dVarP0 == null || (webResourceResponseC = dVarP0.c(request)) == null) ? super.shouldInterceptRequest(view, request) : webResourceResponseC;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse webResourceResponseE;
            com.transsion.lib_web.zip.loader.d dVarP0 = BaseLibWebFragment.this.p0();
            return (dVarP0 == null || (webResourceResponseE = com.transsion.lib_web.zip.loader.d.e(dVarP0, str, null, 2, null)) == null) ? super.shouldInterceptRequest(webView, str) : webResourceResponseE;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String string;
            Uri url;
            if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (string = url.toString()) == null) {
                string = "";
            }
            if (hu.g.f66794a.a(string, BaseLibWebFragment.this.getContext())) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.g(view, "view");
            Intrinsics.g(url, "url");
            if (hu.g.f66794a.a(url, BaseLibWebFragment.this.getContext())) {
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    public static final void Q0(BaseLibWebFragment this$0, String url, String str, String str2, String str3, long j11) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.E0()) {
            return;
        }
        Intrinsics.f(url, "url");
        if (!l.u(url, ".apk", false, 2, null) && !l.u(url, ".APK", false, 2, null) && !TextUtils.equals(str3, "application/vnd.android.package-archive")) {
            FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            String str4 = this$0.f53057d;
            String strR0 = this$0.r0();
            if (strR0 == null) {
                strR0 = "";
            }
            this$0.l0(fragmentActivityRequireActivity, "web_load", url, str4, j11, strR0);
            return;
        }
        h.f66795a.c("拦截APK下载 --> mimetype = " + str3 + " --> url = " + url + " --> contentLength = " + j11 + " --> contentDisposition = " + str2 + " --> userAgent = " + str);
    }

    private final void initListener() {
        n0().f67703c.setOnClickListener(new View.OnClickListener() { // from class: hu.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseLibWebFragment.v0(this.f66788a, view);
            }
        });
        n0().f67704d.setOnClickListener(new View.OnClickListener() { // from class: hu.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseLibWebFragment.w0(this.f66789a, view);
            }
        });
        n0().f67705f.setOnClickListener(new View.OnClickListener() { // from class: hu.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseLibWebFragment.x0(this.f66790a, view);
            }
        });
    }

    private final void u0() {
        Bundle arguments = getArguments();
        boolean z11 = arguments != null ? arguments.getBoolean(WebConstants.FIELD_STATUS_BAR_HIDDEN, false) : false;
        Bundle arguments2 = getArguments();
        boolean z12 = arguments2 != null ? arguments2.getBoolean(WebConstants.FIELD_TOOL_BAR_HIDDEN, false) : false;
        Bundle arguments3 = getArguments();
        int i11 = arguments3 != null ? arguments3.getInt(WebConstants.BOTTOM_MARGIN, 0) : 0;
        iu.a aVarN0 = n0();
        aVarN0.getRoot().setFitsSystemWindows(!z11);
        if (i11 > 0) {
            ViewGroup.LayoutParams layoutParams = aVarN0.f67702b.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = i11;
            aVarN0.f67702b.setLayoutParams(bVar);
        }
        boolean zA = e.f66792a.a(r0());
        t0(z12 || zA);
        h.f66795a.a(o0() + " --> initLayout() --> statusBarHide = " + z11 + " --> isFieldToolBarHidden = " + z12 + " -- bottomMargin = " + i11 + " --> hideNavigationBar = " + zA);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || !arguments4.getBoolean(WebConstants.NEED_HEADER, false)) {
            return;
        }
        View view = n0().f67708i;
        view.getLayoutParams().height = f0.a(34.0f) + com.blankj.utilcode.util.d.c();
        Bundle arguments5 = getArguments();
        int i12 = arguments5 != null ? arguments5.getInt(WebConstants.HEADER_BG) : 0;
        if (i12 != 0) {
            view.setBackgroundResource(i12);
        }
        view.setVisibility(0);
    }

    public static final void v0(BaseLibWebFragment this$0, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.l();
    }

    public static final void w0(BaseLibWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void x0(BaseLibWebFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.n0().f67702b.reload();
    }

    private final void z0() {
        n0().f67702b.setWebChromeClient(new b());
    }

    public final void A0() {
        BridgeWebView bridgeWebView = n0().f67702b;
        bridgeWebView.setGson(n.f());
        bridgeWebView.setLayerType(2, null);
        bridgeWebView.setOverScrollMode(2);
    }

    public final void B0() {
        A0();
        y0();
        z0();
        C0();
        P0();
        BridgeWebView bridgeWebView = n0().f67702b;
        Intrinsics.f(bridgeWebView, "binding.bridgeWebView");
        m0(bridgeWebView);
        k0();
        D0();
        s0().addJavascriptInterface(new c(s0()), "MbOkSpinJsBridge");
        String strR0 = r0();
        h.f66795a.a(o0() + " --> initWebView() --> 开始加载网页 --> url = " + strR0);
        n0().f67702b.loadUrl(strR0);
    }

    public final void C0() {
        n0().f67702b.setWebViewClient(new d());
    }

    public final void D0() {
        Context context = getContext();
        if (context != null) {
            this.f53056c = new com.transsion.lib_web.zip.loader.d(context, kotlin.collections.f.e(new com.transsion.lib_web.zip.loader.a(context, r0())));
        }
    }

    public final boolean E0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(WebConstants.FIELD_LOAD_URL_ONLY, false);
        }
        return false;
    }

    public void F0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.e(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) decorView).removeView(this.f53054a);
        this.f53054a = null;
        this.f53058f = null;
        ImmersionBar.with(activity).hideBar(BarHide.FLAG_SHOW_BAR).init();
        activity.setRequestedOrientation(this.f53061i);
        WebChromeClient.CustomViewCallback customViewCallback = this.f53060h;
        Intrinsics.d(customViewCallback);
        customViewCallback.onCustomViewHidden();
        this.f53060h = null;
    }

    public void G0(WebView view, int i11) {
        int i12;
        Intrinsics.g(view, "view");
        ProgressBar progressBar = n0().f67707h;
        if (i11 == 100) {
            i12 = 8;
        } else {
            n0().f67707h.setProgress(i11);
            i12 = 0;
        }
        progressBar.setVisibility(i12);
    }

    public void H0(WebView view, String title) {
        Intrinsics.g(view, "view");
        Intrinsics.g(title, "title");
        n0().f67709j.setText(title);
    }

    public void I0(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.f53058f != null) {
            if (customViewCallback != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        this.f53058f = view;
        this.f53059g = activity.getWindow().getDecorView().getSystemUiVisibility();
        this.f53061i = activity.getRequestedOrientation();
        this.f53060h = customViewCallback;
        View decorView = activity.getWindow().getDecorView();
        FrameLayout frameLayout = decorView instanceof FrameLayout ? (FrameLayout) decorView : null;
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout2.addView(this.f53058f, new FrameLayout.LayoutParams(-1, -1));
        this.f53054a = frameLayout2;
        if (frameLayout != null) {
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        }
        ImmersionBar.with(activity).hideBar(BarHide.FLAG_HIDE_BAR).init();
        activity.setRequestedOrientation(6);
    }

    public void J0(WebView view, String url) {
        Intrinsics.g(view, "view");
        Intrinsics.g(url, "url");
    }

    public void K0(WebView view, String url, Bitmap bitmap) {
        Intrinsics.g(view, "view");
        Intrinsics.g(url, "url");
    }

    public void L0(WebView webView, int i11, String str, String str2) {
    }

    public void M0(WebView webView, WebResourceRequest request, WebResourceError error) {
        Intrinsics.g(request, "request");
        Intrinsics.g(error, "error");
    }

    public void N0(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        Intrinsics.g(view, "view");
        Intrinsics.g(request, "request");
        Intrinsics.g(errorResponse, "errorResponse");
    }

    public final void O0(iu.a aVar) {
        Intrinsics.g(aVar, "<set-?>");
        this.f53055b = aVar;
    }

    public final void P0() {
        n0().f67702b.setDownloadListener(new DownloadListener() { // from class: hu.d
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
                BaseLibWebFragment.Q0(this.f66791a, str, str2, str3, str4, j11);
            }
        });
    }

    public final void R0(String str) {
        this.f53057d = str;
    }

    public final void k0() {
        requireActivity().getOnBackPressedDispatcher().i(this, new a());
    }

    public void l0(FragmentActivity requireActivity, String tag, String str, String str2, long j11, String originalUrl) {
        Intrinsics.g(requireActivity, "requireActivity");
        Intrinsics.g(tag, "tag");
        Intrinsics.g(originalUrl, "originalUrl");
    }

    public abstract void m0(BridgeWebView bridgeWebView);

    public final iu.a n0() {
        iu.a aVar = this.f53055b;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.y("binding");
        return null;
    }

    public final String o0() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        iu.a aVarC = iu.a.c(inflater);
        Intrinsics.f(aVarC, "inflate(inflater)");
        O0(aVarC);
        return n0().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tn.lib.util.networkinfo.f.f49475a.m(this);
        h.f66795a.b(o0() + " --> onDestroy()");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        n0().f67702b.destroy();
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        u0();
        initListener();
        B0();
        com.tn.lib.util.networkinfo.f.f49475a.l(this);
    }

    public final com.transsion.lib_web.zip.loader.d p0() {
        return this.f53056c;
    }

    public final String q0() {
        return this.f53057d;
    }

    public String r0() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("url") : null;
        return string == null ? "" : string;
    }

    public final BridgeWebView s0() {
        BridgeWebView bridgeWebView = n0().f67702b;
        Intrinsics.f(bridgeWebView, "binding.bridgeWebView");
        return bridgeWebView;
    }

    public final void t0(boolean z11) {
        n0();
        if (z11) {
            n0().f67706g.setVisibility(8);
        } else {
            n0().f67706g.setVisibility(0);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void y0() {
        WebSettings settings = n0().f67702b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        Context context = n0().f67702b.getContext();
        Intrinsics.f(context, "binding.bridgeWebView.context");
        settings.setCacheMode(fVar.j(context) ? -1 : 1);
        settings.setMixedContentMode(0);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setSupportMultipleWindows(false);
        settings.setBlockNetworkImage(false);
        settings.setAllowFileAccess(true);
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
    }
}
