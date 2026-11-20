package com.cloud.tmc.miniapp.ad.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cloud.tmc.ad.R$layout;
import com.cloud.tmc.ad.bean.AdClickBean;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.kernel.proxy.render.IWebViewFactory;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.ad.interstitial.AdInterstitialHtmlView$Builder;
import com.cloud.tmc.miniutils.util.w;
import com.cloud.tmc.render.system.SystemWebView;
import ia.a;
import jd.b;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import xb.i;
import zc.k;
import zc.o;
import zc.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class AdInterstitialHtmlView$Builder extends b implements p, o {
    public a A;
    public k B;
    public FrameLayout C;
    public ImageView D;
    public ImageView E;
    public ImageView F;
    public boolean G;
    public boolean H;
    public boolean I;
    public float J;
    public float K;
    public float L;
    public float M;
    public final ViewGroup.LayoutParams N;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f31378z;

    /* JADX INFO: compiled from: source.java */
    public final class CheckMaterial {
        public CheckMaterial() {
        }

        @JavascriptInterface
        public void loadMaterialError(String str) {
            AdInterstitialHtmlView$Builder adInterstitialHtmlView$Builder = AdInterstitialHtmlView$Builder.this;
            adInterstitialHtmlView$Builder.I = true;
            a aVar = adInterstitialHtmlView$Builder.A;
            if (aVar != null) {
                aVar.b(adInterstitialHtmlView$Builder.f31378z, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInterstitialHtmlView$Builder(Context context, String triggerId, String htmlData, String scale, a aVar) {
        ViewTreeObserver viewTreeObserver;
        super(context);
        Intrinsics.g(context, "context");
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(htmlData, "htmlData");
        Intrinsics.g(scale, "scale");
        this.f31378z = triggerId;
        this.A = aVar;
        this.N = new ViewGroup.LayoutParams(-1, -2);
        try {
            j(R$layout.view_interstitial_html_style);
            n(false);
            b(-1);
            this.D = (ImageView) findViewById(R$id.iv_close);
            this.C = (FrameLayout) findViewById(R$id.fl_wb);
            this.E = (ImageView) findViewById(com.cloud.tmc.ad.R$id.iv_ad);
            this.F = (ImageView) findViewById(com.cloud.tmc.ad.R$id.iv_homepage);
            FrameLayout frameLayout = this.C;
            if (frameLayout != null && (viewTreeObserver = frameLayout.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: jd.c
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        AdInterstitialHtmlView$Builder.D(this.f67989a);
                    }
                });
            }
            k kVarCreateWebView = ((IWebViewFactory) tc.a.a(IWebViewFactory.class)).createWebView(context);
            if (kVarCreateWebView != null) {
                kVarCreateWebView.registerPageEventCallback(this);
                kVarCreateWebView.registerPageCallback(this);
            } else {
                kVarCreateWebView = null;
            }
            this.B = kVarCreateWebView;
            if (kVarCreateWebView != null) {
                kVarCreateWebView.setAppId("open AdInterstitialHtmlView");
            }
            k kVar = this.B;
            if (kVar != null) {
                kVar.setNode(new PageNode(null, "", "", null, null));
            }
            k kVar2 = this.B;
            if (kVar2 != null) {
                kVar2.create();
            }
            k kVar3 = this.B;
            SystemWebView systemWebView = kVar3 instanceof SystemWebView ? (SystemWebView) kVar3 : null;
            if (systemWebView != null) {
                systemWebView.getSettings().setDomStorageEnabled(true);
                i.b(systemWebView);
                systemWebView.addJavascriptInterface(new CheckMaterial(), "loadError");
                systemWebView.setOnTouchListener(new View.OnTouchListener() { // from class: jd.d
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return AdInterstitialHtmlView$Builder.E(this.f67990a, view, motionEvent);
                    }
                });
                systemWebView.loadDataWithBaseURL(null, htmlData + "<script>\n\twindow.addEventListener('error', function(e) {\n\t\tvar target = e.srcElement;\n\t\tvar tagName = target.tagName;\n\t\tif (tagName && tagName.toUpperCase() === 'IMG' && target) {\n\t\t\tconst {\n\t\t\t\twidth,\n\t\t\t\theight\n\t\t\t} = target.getBoundingClientRect();\n\t\t\tvar isShow = window.getComputedStyle(target).getPropertyValue('display').toUpperCase() !== \"NONE\" ||\n\t\t\t\tfalse;\n\t\t\tvar isShow1 = window.getComputedStyle(target).getPropertyValue('visibility').toUpperCase() !==\n\t\t\t\t\"HIDDEN\" || false;\n\t\t\tif (typeof width == \"number\" && width > 1 && isShow && isShow1) {\n\t\t\t\twindow.loadError && window.loadError.loadMaterialError && window.loadError.loadMaterialError(target\n\t\t\t\t\t.src)\n\t\t\t}\n\t\t}\n\t}, true)\n</script>", "text/html", "utf-8", null);
                FrameLayout frameLayout2 = this.C;
                if (frameLayout2 != null) {
                    frameLayout2.addView(systemWebView);
                }
            }
            u(this.D, this.E, this.F);
        } catch (Throwable unused) {
        }
    }

    public static final void D(AdInterstitialHtmlView$Builder this$0) {
        Intrinsics.g(this$0, "this$0");
        FrameLayout frameLayout = this$0.C;
        int height = frameLayout != null ? frameLayout.getHeight() : 0;
        if (height <= 0 || this$0.G) {
            return;
        }
        this$0.G = true;
        int iB = (int) (((double) w.b()) * 0.54d);
        if (height > iB) {
            ViewGroup.LayoutParams layoutParams = this$0.N;
            layoutParams.height = iB;
            FrameLayout frameLayout2 = this$0.C;
            if (frameLayout2 == null) {
                return;
            }
            frameLayout2.setLayoutParams(layoutParams);
        }
    }

    public static final boolean E(AdInterstitialHtmlView$Builder this$0, View view, MotionEvent motionEvent) {
        Intrinsics.g(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.J = motionEvent.getX();
            this$0.K = motionEvent.getY();
            return false;
        }
        if (action != 1) {
            return false;
        }
        this$0.L = motionEvent.getX();
        this$0.M = motionEvent.getY();
        return false;
    }

    @Override // jd.b
    public int A() {
        FrameLayout frameLayout = this.C;
        if (frameLayout != null) {
            return frameLayout.getWidth();
        }
        return 0;
    }

    public final void C() {
        k kVar = this.B;
        if (kVar != null) {
            kVar.destroy();
            this.B = null;
        }
        FrameLayout frameLayout = this.C;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.A = null;
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Intrinsics.g(view, "view");
        if (u.a()) {
            return;
        }
        if (!Intrinsics.b(view, this.D)) {
            if (Intrinsics.b(view, this.E)) {
                a aVar2 = this.A;
                if (aVar2 != null) {
                    aVar2.e(this.f31378z);
                    return;
                }
                return;
            }
            if (!Intrinsics.b(view, this.F) || (aVar = this.A) == null) {
                return;
            }
            aVar.d(this.f31378z);
            return;
        }
        a aVar3 = this.A;
        if (aVar3 != null) {
            String str = this.f31378z;
            AdClickBean adClickBean = new AdClickBean(0, 0L, null, 7, null);
            adClickBean.setShowTimes(this.f67981u);
            adClickBean.setShowDuration(System.currentTimeMillis() - adClickBean.getShowDuration());
            StringBuilder sb2 = new StringBuilder();
            FrameLayout frameLayout = this.C;
            sb2.append(frameLayout != null ? Integer.valueOf(frameLayout.getWidth()) : null);
            sb2.append('*');
            FrameLayout frameLayout2 = this.C;
            sb2.append(frameLayout2 != null ? Integer.valueOf(frameLayout2.getHeight()) : null);
            adClickBean.setShowArea(sb2.toString());
            Unit unit = Unit.f68710a;
            aVar3.a(str, adClickBean);
        }
    }

    @Override // zc.p
    public void onConsoleMessage(String str) {
    }

    @Override // zc.o
    public void onPageFinished(WebView webView, String str) {
    }

    @Override // zc.o
    public void onPageStarted(WebView webView, String str) {
    }

    @Override // zc.p
    public void onProgressChanged(WebView webView, int i11) {
        a aVar;
        if (i11 != 100) {
            this.H = false;
            return;
        }
        if (i11 != 100 || this.H) {
            return;
        }
        this.H = true;
        if (this.I || (aVar = this.A) == null) {
            return;
        }
        aVar.b(this.f31378z, true);
    }

    @Override // zc.o
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
    }

    @Override // zc.o
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // zc.p
    public void onReceivedIcon(Bitmap bitmap) {
    }

    @Override // zc.p
    public void onReceivedTitle(String str) {
    }

    @Override // zc.p
    public void onRequestFocus() {
    }

    @Override // zc.o
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        float f11 = this.J;
        float f12 = this.K;
        float f13 = this.L;
        float f14 = this.M;
        FrameLayout frameLayout = this.C;
        int width = frameLayout != null ? frameLayout.getWidth() : 0;
        FrameLayout frameLayout2 = this.C;
        DownUpPointBean downUpPointBean = new DownUpPointBean(f11, f12, f13, f14, frameLayout2 != null ? frameLayout2.getHeight() : 0, width);
        a aVar = this.A;
        if (aVar != null) {
            aVar.f(this.f31378z, downUpPointBean, webView != null ? webView.getUrl() : null);
        }
        return Boolean.TRUE;
    }

    @Override // jd.b
    public void w(AdShowBean adShowBean) {
        Intrinsics.g(adShowBean, "adShowBean");
        a aVar = this.A;
        if (aVar != null) {
            aVar.c(this.f31378z, true, adShowBean);
        }
    }

    @Override // jd.b
    public int z() {
        FrameLayout frameLayout = this.C;
        if (frameLayout != null) {
            return frameLayout.getHeight();
        }
        return 0;
    }
}
