package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.applovin.impl.aq;
import com.applovin.impl.dq;
import com.applovin.impl.iq;
import com.applovin.impl.j3;
import com.applovin.impl.pi;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tr;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends j3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f17569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f17570d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.ad.b f17571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f17573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f17574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f17575j;

    public b(com.applovin.impl.sdk.j jVar, Context context) {
        super(context);
        this.f17574i = new ArrayList();
        this.f17575j = new Object();
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f17570d = jVar;
        this.f17569c = jVar.J();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(ASTNode.PCTX_STORED);
        if (z3.k() && ((Boolean) jVar.a(sj.P5)).booleanValue()) {
            setWebViewRenderProcessClient(new d(jVar).a());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.g0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return b.a(view, motionEvent);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.applovin.impl.adview.h0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f17606a.a(view);
            }
        });
    }

    private String a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }

    private void a(String str, String str2, String str3, com.applovin.impl.sdk.j jVar, aq aqVar) {
        String strA = a(str3, str);
        if (StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17569c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + strA);
            }
            loadDataWithBaseURL(str2, strA, "text/html", null, "");
            return;
        }
        String strA2 = a((String) jVar.a(sj.L4), str);
        if (!StringUtils.isValidString(strA2)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17569c.a("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
            }
            loadUrl(str);
            return;
        }
        if (aqVar.z1() && aqVar.isOpenMeasurementEnabled()) {
            strA2 = jVar.W().a(strA2);
        }
        String str4 = strA2;
        if (com.applovin.impl.sdk.n.a()) {
            this.f17569c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + str4);
        }
        loadDataWithBaseURL(str2, str4, "text/html", null, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f17569c.a("AdWebView", "Received a LongClick event.");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    private void b() {
        synchronized (this.f17575j) {
            try {
                Iterator it = this.f17574i.iterator();
                while (it.hasNext()) {
                    tr.a(this, (String) it.next(), "AdWebView", this.f17570d);
                }
                this.f17574i.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(c cVar) {
        if (((Boolean) this.f17570d.a(sj.F1)).booleanValue()) {
            loadUrl("about:blank");
            clearView();
        }
        setWebViewClient(cVar != null ? cVar : new pi());
        setWebChromeClient(new com.applovin.impl.f0(cVar != null ? cVar.c() : null, this.f17570d));
        synchronized (this.f17574i) {
            this.f17574i.clear();
        }
        onResume();
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        if (this.f17572g) {
            com.applovin.impl.sdk.n.h("AdWebView", "Ad can not be loaded in a destroyed webview");
            return;
        }
        this.f17571f = bVar;
        try {
            applySettings(bVar);
            if (yp.a(bVar.getSize())) {
                setVisibility(0);
            }
            if (bVar instanceof com.applovin.impl.sdk.ad.a) {
                loadDataWithBaseURL(bVar.h(), ((com.applovin.impl.sdk.ad.a) bVar).h1(), "text/html", null, "");
                if (com.applovin.impl.sdk.n.a()) {
                    this.f17569c.a("AdWebView", "AppLovinAd rendered");
                    return;
                }
                return;
            }
            if (bVar instanceof aq) {
                aq aqVar = (aq) bVar;
                dq dqVarH1 = aqVar.h1();
                if (dqVarH1 == null) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f17569c.a("AdWebView", "No companion ad provided.");
                        return;
                    }
                    return;
                }
                iq iqVarD = dqVarH1.d();
                Uri uriB = iqVarD.b();
                String string = uriB != null ? uriB.toString() : "";
                String strA = iqVarD.a();
                String strJ1 = aqVar.j1();
                if (!StringUtils.isValidString(string) && !StringUtils.isValidString(strA)) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f17569c.b("AdWebView", "Unable to load companion ad. No resources provided.");
                        return;
                    }
                    return;
                }
                if (iqVarD.c() == iq.a.STATIC) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f17569c.a("AdWebView", "Rendering WebView for static VAST ad");
                    }
                    String strA2 = a((String) this.f17570d.a(sj.K4), string);
                    if (aqVar.z1() && aqVar.isOpenMeasurementEnabled() && aqVar.A1()) {
                        strA2 = this.f17570d.W().a(strA2);
                    }
                    loadDataWithBaseURL(bVar.h(), strA2, "text/html", null, "");
                    return;
                }
                if (iqVarD.c() == iq.a.HTML) {
                    if (!StringUtils.isValidString(strA)) {
                        if (StringUtils.isValidString(string)) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f17569c.a("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                            }
                            a(string, bVar.h(), strJ1, this.f17570d, aqVar);
                            return;
                        }
                        return;
                    }
                    String strA3 = a(strJ1, strA);
                    String str = StringUtils.isValidString(strA3) ? strA3 : strA;
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f17569c.a("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str);
                    }
                    loadDataWithBaseURL(bVar.h(), str, "text/html", null, "");
                    return;
                }
                if (iqVarD.c() != iq.a.IFRAME) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f17569c.b("AdWebView", "Failed to render VAST companion ad of invalid type");
                        return;
                    }
                    return;
                }
                if (StringUtils.isValidString(string)) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f17569c.a("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                    }
                    a(string, bVar.h(), strJ1, this.f17570d, aqVar);
                } else if (StringUtils.isValidString(strA)) {
                    String strA4 = a(strJ1, strA);
                    String str2 = StringUtils.isValidString(strA4) ? strA4 : strA;
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f17569c.a("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str2);
                    }
                    loadDataWithBaseURL(bVar.h(), str2, "text/html", null, "");
                }
            }
        } catch (Throwable th2) {
            throw new RuntimeException("Unable to render AppLovin ad (" + (bVar != null ? String.valueOf(bVar.getAdIdNumber()) : "null") + ") - " + th2);
        }
    }

    public void a(String str) {
        if (!((Boolean) this.f17570d.a(sj.f22987j6)).booleanValue()) {
            tr.a(this, str, "AdWebView", this.f17570d);
        } else {
            if (this.f17573h) {
                tr.a(this, str, "AdWebView", this.f17570d);
                return;
            }
            synchronized (this.f17574i) {
                this.f17574i.add(str);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f17572g = true;
        this.f17573h = false;
        super.destroy();
    }

    public com.applovin.impl.sdk.ad.b getCurrentAd() {
        return this.f17571f;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i11, int i12, int i13, int i14) {
    }

    @Override // android.view.View
    public void scrollTo(int i11, int i12) {
    }

    public void setAdHtmlLoaded(boolean z11) {
        this.f17573h = z11;
        if (z11 && ((Boolean) this.f17570d.a(sj.f22987j6)).booleanValue()) {
            b();
        }
    }
}
