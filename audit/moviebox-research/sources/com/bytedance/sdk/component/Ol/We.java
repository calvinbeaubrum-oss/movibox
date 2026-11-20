package com.bytedance.sdk.component.Ol;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.YIK;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends FrameLayout {
    private static zY McK;
    private List<String> BT;
    private YIK Dl;
    private float ExN;
    private AtomicBoolean FI;
    private long Gb;
    private long HJN;
    private InterfaceC0244We II;
    private Context JPJ;
    private long Ol;
    private long Qj;
    private com.bytedance.sdk.component.Ol.sc.InterfaceC0245sc Ql;
    private com.bytedance.sdk.component.Ol.sc SR;
    private int Sfl;
    private float TRI;
    private View Tf;
    private volatile WebView UFX;
    private boolean WH;
    private AtomicBoolean WP;
    private boolean We;
    private float Xc;
    private pFF YIK;
    private AtomicBoolean cvk;
    private float dE;
    private String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f26543qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.Ol.pFF.sc f26544sc;
    private AttributeSet uEA;
    private float wjp;
    private JSONObject zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Ol.We$We, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0244We {
    }

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            webView.post(new Runnable() { // from class: com.bytedance.sdk.component.Ol.We.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface zY {
        WebView createWebView(Context context, AttributeSet attributeSet, int i11);
    }

    public We(Context context) {
        this(sc(context), false);
    }

    public We(Context context, boolean z11) {
        super(sc(context));
        this.ExN = 0.0f;
        this.TRI = 0.0f;
        this.f26543qr = 0L;
        this.Qj = 0L;
        this.Ol = 0L;
        this.WH = false;
        this.dE = 20.0f;
        this.wjp = 50.0f;
        this.FI = new AtomicBoolean();
        this.WP = new AtomicBoolean();
        this.cvk = new AtomicBoolean();
        this.JPJ = context;
        if (z11) {
            return;
        }
        try {
            this.UFX = sc((AttributeSet) null, 0);
            pFF();
        } catch (Throwable unused) {
        }
        pFF(sc(context));
    }

    private void BT() {
        if (this.UFX == null) {
            return;
        }
        try {
            this.UFX.removeJavascriptInterface("searchBoxJavaBridge_");
            this.UFX.removeJavascriptInterface("accessibility");
            this.UFX.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    private void Xc() {
        if (this.Dl == null) {
            this.cvk.set(false);
            this.Dl = new YIK(getContext());
        }
        new Object() { // from class: com.bytedance.sdk.component.Ol.We.1
        };
        this.cvk.set(true);
    }

    private void dE() {
        try {
            WebSettings settings = this.UFX.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    private void pFF(Context context) {
        zY(context);
        dE();
        BT();
    }

    private static boolean pFF(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ViewPager");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static Context sc(Context context) {
        return Build.VERSION.SDK_INT < 23 ? context.createConfigurationContext(new Configuration()) : context;
    }

    private WebView sc(AttributeSet attributeSet, int i11) {
        zY zYVar = McK;
        if (zYVar != null) {
            return zYVar.createWebView(getContext(), attributeSet, i11);
        }
        return attributeSet == null ? new WebView(sc(this.JPJ)) : new WebView(sc(this.JPJ), attributeSet);
    }

    private void sc(MotionEvent motionEvent) {
        if (!this.We || this.f26544sc == null) {
            return;
        }
        if ((this.pFF == null && this.zY == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.ExN = motionEvent.getRawX();
                this.TRI = motionEvent.getRawY();
                this.f26543qr = System.currentTimeMillis();
                this.zY = new JSONObject();
                if (this.UFX != null) {
                    this.HJN = this.f26543qr;
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.zY.put("start_x", String.valueOf(this.ExN));
                this.zY.put("start_y", String.valueOf(this.TRI));
                this.zY.put("offset_x", String.valueOf(motionEvent.getRawX() - this.ExN));
                this.zY.put("offset_y", String.valueOf(motionEvent.getRawY() - this.TRI));
                this.zY.put("url", String.valueOf(getUrl()));
                this.zY.put("tag", "");
                this.Qj = System.currentTimeMillis();
                if (this.UFX != null) {
                    this.Gb = this.Qj;
                }
                this.zY.put("down_time", this.f26543qr);
                this.zY.put("up_time", this.Qj);
                if (com.bytedance.sdk.component.Ol.sc.sc.sc().pFF() != null) {
                    long j11 = this.Ol;
                    long j12 = this.f26543qr;
                    if (j11 != j12) {
                        this.Ol = j12;
                        com.bytedance.sdk.component.Ol.sc.sc.sc().pFF().sc(this.f26544sc, this.pFF, "in_web_click", this.zY, this.Qj - this.f26543qr);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = this.UFX.getSettings()) == null) {
                return;
            }
            if (Uri.parse(str).getScheme().equalsIgnoreCase("file")) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    public static void setWebViewProvider(zY zYVar) {
        McK = zYVar;
    }

    private static void zY(Context context) {
    }

    private static boolean zY(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ScrollingView");
            if (clsLoadClass != null && clsLoadClass.isInstance(view)) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            return clsLoadClass2 != null && clsLoadClass2.isInstance(view);
        } catch (Throwable unused2) {
            return false;
        }
    }

    public boolean ExN() {
        if (this.UFX == null) {
            return false;
        }
        try {
            return this.UFX.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void Ol() {
        if (this.UFX != null) {
            this.UFX.onResume();
        }
    }

    public void Qj() {
        try {
            this.UFX.goForward();
        } catch (Throwable unused) {
        }
    }

    public void Ql() {
        try {
            this.UFX.clearView();
        } catch (Throwable unused) {
        }
    }

    public void SR() {
        try {
            this.UFX.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    public void TRI() {
        try {
            this.UFX.goBack();
        } catch (Throwable unused) {
        }
    }

    public void Tf() {
        if (this.UFX == null) {
            return;
        }
        try {
            this.UFX.destroy();
        } catch (Throwable unused) {
        }
    }

    public void UFX() {
        if (this.UFX == null) {
            return;
        }
        try {
            this.UFX.onPause();
        } catch (Throwable unused) {
        }
    }

    public void WH() {
        try {
            this.UFX.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public void We() {
        try {
            this.UFX.reload();
        } catch (Throwable unused) {
        }
    }

    public void a_(String str) {
        try {
            setJavaScriptEnabled(str);
            this.UFX.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    public void b_(String str) {
        try {
            this.UFX.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.UFX == null) {
            return;
        }
        try {
            this.UFX.computeScroll();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void f_() {
        try {
            this.UFX = sc(this.uEA, 0);
            pFF();
            pFF(sc(this.JPJ));
        } catch (Throwable th2) {
            Tf.sc("SSWebView.TAG", "initWebview: " + th2.getMessage());
        }
    }

    public View getArbitrageLoadingView() {
        return this.Tf;
    }

    public int getContentHeight() {
        if (this.UFX == null) {
            return 0;
        }
        try {
            return this.UFX.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public long getLandingPageClickBegin() {
        return this.HJN;
    }

    public long getLandingPageClickEnd() {
        return this.Gb;
    }

    public com.bytedance.sdk.component.Ol.pFF.sc getMaterialMeta() {
        return this.f26544sc;
    }

    public String getOriginalUrl() {
        String url;
        if (this.UFX == null) {
            return null;
        }
        try {
            String originalUrl = this.UFX.getOriginalUrl();
            return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = this.UFX.getUrl()) == null || !url.startsWith("file://")) ? originalUrl : url;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getProgress() {
        if (this.UFX == null) {
            return 0;
        }
        try {
            return this.UFX.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    @Override // android.view.View
    public String getTag() {
        return this.pFF;
    }

    public String getUrl() {
        if (this.UFX == null) {
            return null;
        }
        try {
            return this.UFX.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUserAgentString() {
        if (this.UFX == null) {
            return "";
        }
        try {
            return this.UFX.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.UFX;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.FI.set(true);
        if (!this.WP.get() || this.cvk.get()) {
            return;
        }
        Xc();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.FI.set(false);
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentSc;
        try {
            sc(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.WH && (viewParentSc = sc(this)) != null) {
                viewParentSc.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
    }

    public void pFF() {
        if (this.UFX != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.UFX.setId(520093704);
            } catch (Throwable unused) {
            }
            addView(this.UFX, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public boolean qr() {
        if (this.UFX == null) {
            return false;
        }
        try {
            return this.UFX.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            this.UFX.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewParent sc(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (pFF(view2) || zY(view2)) ? parent : sc(view2);
    }

    @SuppressLint({"JavascriptInterface"})
    public void sc(Object obj, String str) {
        try {
            this.UFX.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    public void sc(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            this.UFX.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Throwable unused) {
        }
    }

    @TargetApi(19)
    public void sc(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            this.UFX.loadUrl(str, map);
        } catch (Throwable unused) {
        }
    }

    public void sc(boolean z11) {
        try {
            this.UFX.clearCache(z11);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void sc(boolean z11, int i11, int i12, List<Integer> list, int i13, List<String> list2) {
        if (z11 && this.UFX != null && (this.UFX instanceof com.bytedance.sdk.component.Ol.zY)) {
            this.SR = new com.bytedance.sdk.component.Ol.sc(this.JPJ, i11, i12, list, i13);
            this.BT = list2;
            if (!TextUtils.isEmpty(this.pFF)) {
                this.SR.sc(this.pFF);
            }
            ((com.bytedance.sdk.component.Ol.zY) this.UFX).setArbitrageTouchListener(this.SR);
            this.Ql = this.SR.sc();
        }
    }

    public void sc(boolean z11, View view) {
        if (z11) {
            this.Tf = view;
            if (view == null || view.getParent() != null) {
                return;
            }
            addView(this.Tf, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setAllowFileAccess(boolean z11) {
        try {
            this.UFX.getSettings().setAllowFileAccess(z11);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setAlpha(float f11) {
        try {
            super.setAlpha(f11);
            this.UFX.setAlpha(f11);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        try {
            this.UFX.setBackgroundColor(i11);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z11) {
        try {
            this.UFX.getSettings().setBuiltInZoomControls(z11);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i11) {
        try {
            this.UFX.getSettings().setCacheMode(i11);
        } catch (Throwable unused) {
        }
    }

    public void setCalculationMethod(int i11) {
        this.Sfl = i11;
    }

    public void setDatabaseEnabled(boolean z11) {
        try {
            this.UFX.getSettings().setDatabaseEnabled(z11);
        } catch (Throwable unused) {
        }
    }

    public void setDeepShakeValue(float f11) {
        this.Xc = f11;
    }

    public void setDefaultFontSize(int i11) {
        try {
            this.UFX.getSettings().setDefaultFontSize(i11);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.UFX.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z11) {
        try {
            this.UFX.getSettings().setDisplayZoomControls(z11);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z11) {
        try {
            this.UFX.getSettings().setDomStorageEnabled(z11);
        } catch (Throwable unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.UFX.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setIsPreventTouchEvent(boolean z11) {
        this.WH = z11;
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z11) {
        try {
            this.UFX.getSettings().setJavaScriptCanOpenWindowsAutomatically(z11);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z11) {
        try {
            this.UFX.getSettings().setJavaScriptEnabled(z11);
        } catch (Throwable unused) {
        }
    }

    public void setLandingPage(boolean z11) {
        this.We = z11;
    }

    public void setLandingPageClickBegin(long j11) {
        this.HJN = j11;
    }

    public void setLandingPageClickEnd(long j11) {
        this.Gb = j11;
    }

    @Override // android.view.View
    public void setLayerType(int i11, Paint paint) {
        try {
            this.UFX.setLayerType(i11, paint);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.UFX.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z11) {
        try {
            this.UFX.getSettings().setLoadWithOverviewMode(z11);
        } catch (Throwable unused) {
        }
    }

    public void setMaterialMeta(com.bytedance.sdk.component.Ol.pFF.sc scVar) {
        this.f26544sc = scVar;
    }

    public void setMixedContentMode(int i11) {
        try {
            this.UFX.getSettings().setMixedContentMode(i11);
        } catch (Throwable unused) {
        }
    }

    public void setNetworkAvailable(boolean z11) {
        try {
            this.UFX.setNetworkAvailable(z11);
        } catch (Throwable unused) {
        }
    }

    public void setOnShakeListener(pFF pff) {
        this.YIK = pff;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i11) {
        try {
            this.UFX.setOverScrollMode(i11);
            super.setOverScrollMode(i11);
        } catch (Throwable unused) {
        }
    }

    public void setRecycler(boolean z11) {
        if (this.UFX == null || !(this.UFX instanceof com.bytedance.sdk.component.Ol.zY)) {
            return;
        }
        ((com.bytedance.sdk.component.Ol.zY) this.UFX).setRecycler(z11);
    }

    public void setShakeValue(float f11) {
        this.dE = f11;
    }

    public void setSupportZoom(boolean z11) {
        try {
            this.UFX.getSettings().setSupportZoom(z11);
        } catch (Throwable unused) {
        }
    }

    public void setTag(String str) {
        this.pFF = str;
        com.bytedance.sdk.component.Ol.sc scVar = this.SR;
        if (scVar != null) {
            scVar.sc(str);
        }
    }

    public void setTouchStateListener(InterfaceC0244We interfaceC0244We) {
        this.II = interfaceC0244We;
    }

    public void setUseWideViewPort(boolean z11) {
        try {
            this.UFX.getSettings().setUseWideViewPort(z11);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.UFX.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        try {
            super.setVisibility(i11);
            this.UFX.setVisibility(i11);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.UFX.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof InterfaceC0244We) {
                setTouchStateListener((InterfaceC0244We) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == 0) {
                webViewClient = new sc();
            }
            this.UFX.setWebViewClient(new ExN(this.Ql, webViewClient, this.BT));
        } catch (Throwable unused) {
        }
    }

    public void setWriggleValue(float f11) {
        this.wjp = f11;
    }

    public void zY() {
        try {
            this.UFX.stopLoading();
        } catch (Throwable unused) {
        }
    }
}
