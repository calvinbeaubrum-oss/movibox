package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CollapsibleWebView extends CommonWebView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.a> f45679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.a> f45680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f45681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f45682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f45683i;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(View view, String str);

        void a(View view, Map<String, String> map);

        void b(View view, String str);

        void b(View view, Map<String, String> map);
    }

    public CollapsibleWebView(Context context) {
        super(context);
    }

    public CollapsibleWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CollapsibleWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public static /* synthetic */ void a(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.f45679e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.f45681g.iterator();
        while (it.hasNext()) {
            it.next().b(view, str);
        }
    }

    public static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.f45681g.iterator();
        while (it.hasNext()) {
            it.next().a(view, (Map<String, String>) map);
        }
    }

    public static /* synthetic */ void b(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.f45680f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.f45681g.iterator();
        while (it.hasNext()) {
            it.next().a(view, str);
        }
    }

    public static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.f45681g.iterator();
        while (it.hasNext()) {
            it.next().b(view, (Map<String, String>) map);
        }
    }

    public String getCollapseIconName() {
        return this.f45682h;
    }

    public String getExpandIconName() {
        return this.f45683i;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView
    public void init() {
        super.init();
        this.f45679e = new CopyOnWriteArrayList<>();
        this.f45680f = new CopyOnWriteArrayList<>();
        this.f45681g = new CopyOnWriteArrayList<>();
        this.f45682h = "mbridge_arrow_down_white_blackbg";
        this.f45683i = "mbridge_arrow_up_white";
        useDeeplink();
        initWebViewListener();
        useProgressBar();
        ArrayList<ToolBar.b> arrayList = new ArrayList<>();
        ToolBar.b bVar = new ToolBar.b("doCollapse");
        bVar.f45724c = false;
        bVar.f45723b = "mbridge_arrow_down_white_blackbg";
        bVar.f45725d = new View.OnClickListener() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doCollapse");
                CollapsibleWebView.this.showToolBarButton("doSpand");
                CollapsibleWebView.a(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar);
        ToolBar.b bVar2 = new ToolBar.b("doSpand");
        bVar2.f45723b = "mbridge_arrow_up_black";
        bVar2.f45725d = new View.OnClickListener() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doSpand");
                CollapsibleWebView.this.showToolBarButton("doCollapse");
                CollapsibleWebView.b(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar2);
        useDefaultToolBar();
        useCustomizedToolBar(arrayList, true);
    }

    public void initWebViewListener() {
        setPageLoadTimtoutListener(new CommonWebView.b() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.3
            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.b
            public final void a(String str) {
                CollapsibleWebView collapsibleWebView = CollapsibleWebView.this;
                CollapsibleWebView.a(collapsibleWebView, (View) collapsibleWebView.f45693d, str);
            }
        });
        setPageLoadTimtout(CommonWebView.DEFAULT_JUMP_TIMEOUT);
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Boolean f45687a = Boolean.FALSE;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            String f45688b = "";

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                if (this.f45687a.booleanValue()) {
                    return;
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, str);
                this.f45687a = Boolean.FALSE;
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f45688b = str;
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i11, String str, String str2) {
                HashMap map = new HashMap();
                map.put("type", "error");
                map.put("url", str2);
                map.put(TrackingKey.DESCRIPTION, str);
                if (!this.f45687a.booleanValue() && this.f45688b.equals(str2)) {
                    this.f45687a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, webView, map);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, map);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                HashMap map = new HashMap();
                map.put("type", HttpHost.DEFAULT_SCHEME_NAME);
                String str = webResourceRequest.getUrl() + "";
                map.put("url", str);
                map.put("statusCode", webResourceResponse.getStatusCode() + "");
                map.put(TrackingKey.DESCRIPTION, "http error");
                if (!this.f45687a.booleanValue() && (this.f45688b.equals(str) || TextUtils.isEmpty(this.f45688b))) {
                    this.f45687a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, webView, map);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, map);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                HashMap map = new HashMap();
                map.put("type", "ssl");
                map.put("url", sslError.getUrl());
                map.put(TrackingKey.DESCRIPTION, "ssl error");
                if (!this.f45687a.booleanValue()) {
                    if (this.f45688b.equals(sslError.getUrl() + "")) {
                        this.f45687a = Boolean.TRUE;
                        CollapsibleWebView.a(CollapsibleWebView.this, webView, map);
                    }
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, map);
            }

            @Override // android.webkit.WebViewClient
            public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                ad.b("CollapsibleWebView", "WebView called onRenderProcessGone");
                return true;
            }
        });
    }

    public void setCollapseIconName(String str) {
        this.f45682h = str;
    }

    public void setCollapseListener(CommonWebView.a aVar) {
        this.f45679e.add(aVar);
    }

    public void setCustomizedToolBarMarginWidthPixel(int i11, int i12, int i13, int i14) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f45690a.getLayoutParams();
        layoutParams.setMargins(i11, i12, i13, i14);
        this.f45690a.setLayoutParams(layoutParams);
    }

    public void setExpandIconName(String str) {
        this.f45683i = str;
    }

    public void setExpandListener(CommonWebView.a aVar) {
        this.f45680f.add(aVar);
    }

    public void setPageLoadListener(a aVar) {
        this.f45681g.add(aVar);
    }
}
