package com.cloud.tmc.miniapp.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.StringRes;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.render.IWebViewFactory;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.base.BaseActivity;
import com.cloud.tmc.miniapp.widget.LoadingTextView;
import com.cloud.tmc.miniapp.widget.NativeTitleBar;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.d;
import com.cloud.tmc.miniutils.util.f;
import com.cloud.tmc.render.system.SystemWebView;
import id.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zc.k;
import zc.n;
import zc.o;
import zc.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WebViewActivity extends BaseActivity implements p, o, i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f31752h = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f31753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f31754b = LazyKt__LazyJVMKt.b(new OooOO0());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f31755c = LazyKt__LazyJVMKt.b(new OooO0OO());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f31756d = LazyKt__LazyJVMKt.b(new OooO0o());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f31757f = LazyKt__LazyJVMKt.b(new OooO());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f31758g = Boolean.FALSE;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<ProgressBar> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ProgressBar invoke() {
            return (ProgressBar) WebViewActivity.this.findViewById(R$id.f31324pb);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<Unit> {
        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            WebViewActivity.this.finish();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0OO extends Lambda implements Function0<FrameLayout> {
        public OooO0OO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) WebViewActivity.this.findViewById(R$id.fl_wb);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<NativeTitleBar> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public NativeTitleBar invoke() {
            return (NativeTitleBar) WebViewActivity.this.findViewById(R$id.title_native_Bar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<StatusLayout> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public StatusLayout invoke() {
            return (StatusLayout) WebViewActivity.this.findViewById(R$id.sl_status);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static void a(a aVar, Context context, String url, String str, String str2, int i11) {
            Intrinsics.g(context, "context");
            Intrinsics.g(url, "url");
            Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
            intent.putExtra("pageUri", url);
            h.f31061a.a(intent, context);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements StatusLayout.b {
        public b() {
        }

        @Override // com.cloud.tmc.miniapp.widget.StatusLayout.b
        public void a(StatusLayout statusLayout) {
            StatusLayout statusLayout2 = WebViewActivity.this.getStatusLayout();
            if (statusLayout2 != null) {
                statusLayout2.OooO0Oo();
            }
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.f31758g = Boolean.FALSE;
            k kVar = webViewActivity.f31753a;
            if (kVar != null) {
                kVar.reload();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements StatusLayout.b {
        public c() {
        }

        @Override // com.cloud.tmc.miniapp.widget.StatusLayout.b
        public void a(StatusLayout statusLayout) {
            StatusLayout statusLayout2 = WebViewActivity.this.getStatusLayout();
            if (statusLayout2 != null) {
                statusLayout2.OooO0Oo();
            }
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.f31758g = Boolean.FALSE;
            k kVar = webViewActivity.f31753a;
            if (kVar != null) {
                kVar.reload();
            }
        }
    }

    public final FrameLayout O() {
        return (FrameLayout) this.f31755c.getValue();
    }

    public final NativeTitleBar Q() {
        return (NativeTitleBar) this.f31756d.getValue();
    }

    public final ProgressBar R() {
        return (ProgressBar) this.f31757f.getValue();
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public int getLayoutId() {
        return R$layout.activity_mini_web_view;
    }

    @Override // id.i
    public StatusLayout getStatusLayout() {
        return (StatusLayout) this.f31754b.getValue();
    }

    public Integer getViewThemeMode() {
        return 1;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void hideStatusLoading() {
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initData() {
        String string;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString("pageUri")) == null) {
            return;
        }
        Intrinsics.f(string, "getString(TmcConstants.EXTRA_PAGE_URI) ?: return");
        this.f31758g = Boolean.FALSE;
        k kVar = this.f31753a;
        if (kVar != null) {
            kVar.load(string, s.j(TuplesKt.a("x-tr-devtype", "h5")));
        }
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initView() {
        try {
            k kVarCreateWebView = ((IWebViewFactory) tc.a.a(IWebViewFactory.class)).createWebView(this);
            SystemWebView systemWebView = null;
            if (kVarCreateWebView != null) {
                kVarCreateWebView.registerPageEventCallback(this);
                kVarCreateWebView.registerPageCallback(this);
            } else {
                kVarCreateWebView = null;
            }
            this.f31753a = kVarCreateWebView;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            FrameLayout frameLayoutO = O();
            if (frameLayoutO != null) {
                k kVar = this.f31753a;
                SystemWebView systemWebView2 = kVar instanceof SystemWebView ? (SystemWebView) kVar : null;
                if (systemWebView2 != null) {
                    systemWebView2.setBackgroundColor(d.a(R$color.mini_color_bg_01));
                    systemWebView2.getSettings().setDomStorageEnabled(true);
                    systemWebView2.setLayoutParams(layoutParams);
                    xb.i.b(systemWebView2);
                    systemWebView = systemWebView2;
                }
                frameLayoutO.addView(systemWebView);
            }
            k kVar2 = this.f31753a;
            if (kVar2 != null) {
                kVar2.setAppId("open webview");
            }
            k kVar3 = this.f31753a;
            if (kVar3 != null) {
                kVar3.setNode(new PageNode(null, "", "", null, null));
            }
            k kVar4 = this.f31753a;
            if (kVar4 != null) {
                kVar4.create();
            }
            NativeTitleBar nativeTitleBarQ = Q();
            if (nativeTitleBarQ != null) {
                nativeTitleBarQ.setTitle("");
            }
            NativeTitleBar nativeTitleBarQ2 = Q();
            if (nativeTitleBarQ2 != null) {
                nativeTitleBarQ2.setonBackClickListener(new OooO0O0());
            }
        } catch (Throwable th2) {
            TmcLogger.h("WebViewActivity", th2);
        }
    }

    @Override // zc.p
    public void onConsoleMessage(String consoleMessage) {
        Intrinsics.g(consoleMessage, "consoleMessage");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k kVar = this.f31753a;
        if (kVar != null) {
            kVar.destroy();
            this.f31753a = null;
        }
        FrameLayout frameLayoutO = O();
        if (frameLayoutO != null) {
            frameLayoutO.removeAllViews();
        }
    }

    public void onPageFinished(WebView webView, String str) {
        StatusLayout statusLayout = getStatusLayout();
        if (statusLayout != null) {
            statusLayout.OooO0O0();
        }
    }

    @Override // zc.o
    public void onPageStarted(WebView webView, String str) {
    }

    @Override // zc.p
    public void onProgressChanged(WebView webView, int i11) {
        if (i11 == 0) {
            ProgressBar progressBarR = R();
            if (progressBarR == null) {
                return;
            }
            progressBarR.setVisibility(0);
            return;
        }
        if (i11 != 100) {
            ProgressBar progressBarR2 = R();
            if (progressBarR2 == null) {
                return;
            }
            progressBarR2.setProgress(i11);
            return;
        }
        ProgressBar progressBarR3 = R();
        if (progressBarR3 == null) {
            return;
        }
        progressBarR3.setVisibility(8);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        LoadingTextView loadingTextView;
        this.f31758g = Boolean.TRUE;
        if (webResourceRequest == null || !webResourceRequest.isForMainFrame()) {
            return;
        }
        StatusLayout statusLayout = getStatusLayout();
        if (statusLayout != null && (loadingTextView = statusLayout.f31867OooO0oo) != null) {
            loadingTextView.setVisibility(4);
        }
        if (NetworkUtils.r()) {
            i.a.f(this, new c(), R$string.loading_error_tv, "", "open webview", null, 16, null);
        } else {
            i.a.s(this, new b(), 0, null, "open webview", null, 22, null);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // zc.p
    public void onReceivedIcon(Bitmap bitmap) {
    }

    public void onReceivedTitle(String str) {
        if (!Intrinsics.b(this.f31758g, Boolean.FALSE) || f.a(str)) {
            NativeTitleBar nativeTitleBarQ = Q();
            if (nativeTitleBarQ != null) {
                nativeTitleBarQ.setTitle("");
                return;
            }
            return;
        }
        NativeTitleBar nativeTitleBarQ2 = Q();
        if (nativeTitleBarQ2 != null) {
            nativeTitleBarQ2.setTitle(str);
        }
    }

    @Override // zc.p
    public void onRequestFocus() {
    }

    public /* synthetic */ Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return n.b(this, webView, webResourceRequest);
    }

    @Override // id.i
    public void showError(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.e(this, bVar, i11, str, str2, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, @StringRes int i13, StatusLayout.b bVar, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.g(this, i11, i12, i13, bVar, z11, z12, aVar);
    }

    @Override // id.i
    public void showErrorLayout(int i11, @StringRes int i12, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.h(this, i11, i12, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, StatusLayout.b bVar, String str, StatusLayout.a aVar) {
        i.a.i(this, drawable, charSequence, bVar, str, aVar);
    }

    @Override // id.i
    public void showErrorLayout(Drawable drawable, CharSequence charSequence, CharSequence charSequence2, StatusLayout.b bVar, String str, boolean z11, boolean z12, StatusLayout.a aVar) {
        i.a.j(this, drawable, charSequence, charSequence2, bVar, str, z11, z12, aVar);
    }

    @Override // id.i
    public void showNoNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.r(this, bVar, i11, str, str2, aVar);
    }

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void showStatusLoading() {
    }

    @Override // id.i
    public void showUnstableNetwork(StatusLayout.b bVar, @StringRes int i11, String str, String str2, StatusLayout.a aVar) {
        i.a.u(this, bVar, i11, str, str2, aVar);
    }
}
