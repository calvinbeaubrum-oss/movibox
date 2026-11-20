package com.transsion.usercenter.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xy.j0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WebViewActivity extends BaseActivity<j0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f59664c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f59665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f59666b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            AppCompatTextView appCompatTextView;
            Intrinsics.g(view, "view");
            Intrinsics.g(title, "title");
            super.onReceivedTitle(view, title);
            j0 j0Var = (j0) WebViewActivity.this.getMViewBinding();
            if (j0Var == null || (appCompatTextView = j0Var.f80836d) == null) {
                return;
            }
            appCompatTextView.setText(title);
        }
    }

    public static final void R(WebViewActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        this.f59666b = String.valueOf(getIntent().getStringExtra("url"));
        this.f59665a = new WebView(this);
        LinearLayout linearLayout = ((j0) getMViewBinding()).f80835c;
        WebView webView = this.f59665a;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.y("mWebView");
            webView = null;
        }
        linearLayout.addView(webView);
        WebView webView3 = this.f59665a;
        if (webView3 == null) {
            Intrinsics.y("mWebView");
        } else {
            webView2 = webView3;
        }
        WebSettings settings = webView2.getSettings();
        Intrinsics.f(settings, "mWebView.settings");
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        WebSettings.LayoutAlgorithm layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN;
        settings.setLayoutAlgorithm(layoutAlgorithm);
        settings.supportMultipleWindows();
        settings.setAllowFileAccess(true);
        settings.setNeedInitialFocus(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setLayoutAlgorithm(layoutAlgorithm);
        settings.setDomStorageEnabled(true);
        S();
        T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        AppCompatImageButton appCompatImageButton;
        j0 j0Var = (j0) getMViewBinding();
        if (j0Var == null || (appCompatImageButton = j0Var.f80834b) == null) {
            return;
        }
        appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewActivity.R(this.f59690a, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O() {
        if (this.f59665a == null) {
            Intrinsics.y("mWebView");
        }
        LinearLayout linearLayout = ((j0) getMViewBinding()).f80835c;
        WebView webView = this.f59665a;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.y("mWebView");
            webView = null;
        }
        linearLayout.removeView(webView);
        WebView webView3 = this.f59665a;
        if (webView3 == null) {
            Intrinsics.y("mWebView");
            webView3 = null;
        }
        ViewParent parent = webView3.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            WebView webView4 = this.f59665a;
            if (webView4 == null) {
                Intrinsics.y("mWebView");
                webView4 = null;
            }
            viewGroup.removeView(webView4);
        }
        WebView webView5 = this.f59665a;
        if (webView5 == null) {
            Intrinsics.y("mWebView");
            webView5 = null;
        }
        webView5.stopLoading();
        WebView webView6 = this.f59665a;
        if (webView6 == null) {
            Intrinsics.y("mWebView");
            webView6 = null;
        }
        webView6.getSettings().setJavaScriptEnabled(false);
        WebView webView7 = this.f59665a;
        if (webView7 == null) {
            Intrinsics.y("mWebView");
            webView7 = null;
        }
        webView7.clearHistory();
        WebView webView8 = this.f59665a;
        if (webView8 == null) {
            Intrinsics.y("mWebView");
            webView8 = null;
        }
        webView8.clearView();
        WebView webView9 = this.f59665a;
        if (webView9 == null) {
            Intrinsics.y("mWebView");
            webView9 = null;
        }
        webView9.removeAllViews();
        WebView webView10 = this.f59665a;
        if (webView10 == null) {
            Intrinsics.y("mWebView");
        } else {
            webView2 = webView10;
        }
        webView2.destroy();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public j0 getViewBinding() {
        j0 j0VarC = j0.c(getLayoutInflater());
        Intrinsics.f(j0VarC, "inflate(layoutInflater)");
        return j0VarC;
    }

    public final void S() {
        WebView webView = this.f59665a;
        if (webView == null) {
            Intrinsics.y("mWebView");
            webView = null;
        }
        webView.setWebChromeClient(new b());
    }

    public final void T() {
        String str = this.f59666b;
        String str2 = null;
        if (str == null) {
            Intrinsics.y("mUrl");
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WebView webView = this.f59665a;
        if (webView == null) {
            Intrinsics.y("mWebView");
            webView = null;
        }
        String str3 = this.f59666b;
        if (str3 == null) {
            Intrinsics.y("mUrl");
        } else {
            str2 = str3;
        }
        webView.loadUrl(str2);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initData();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        O();
    }
}
