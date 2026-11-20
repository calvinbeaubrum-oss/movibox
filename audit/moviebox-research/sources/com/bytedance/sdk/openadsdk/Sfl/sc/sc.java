package com.bytedance.sdk.openadsdk.Sfl.sc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.sc.TRI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Sfl.Qj;
import com.bytedance.sdk.openadsdk.Sfl.qr;
import com.bytedance.sdk.openadsdk.Tf.ExN;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.UFX;
import com.bytedance.sdk.openadsdk.core.widget.WH;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private AtomicBoolean BT;
    private final FrameLayout ExN;
    private final String Ol;
    private String Qj;
    private volatile boolean Ql;
    private volatile boolean SR;

    @Nullable
    private UFX TRI;
    private boolean Tf;

    @Nullable
    private ExN UFX;
    private Qj WH;
    private final int We;
    private com.bytedance.sdk.openadsdk.core.pFF.sc Xc;
    private WH dE;
    private final Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private HJN f27256qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected com.bytedance.sdk.component.Ol.We f27257sc;
    private InterfaceC0271sc wjp;
    private final Sfl zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.Sfl.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0271sc {
        void sc();
    }

    public sc(Context context, Sfl sfl, int i11, boolean z11, FrameLayout frameLayout) {
        this(context, sfl, i11, z11, frameLayout, false);
    }

    public sc(Context context, Sfl sfl, int i11, boolean z11, FrameLayout frameLayout, boolean z12) {
        this.Tf = true;
        this.BT = new AtomicBoolean(false);
        this.pFF = context;
        this.zY = sfl;
        this.We = i11;
        String strZY = cJ.zY(sfl.Cb().getDurationSlotType());
        this.Qj = strZY;
        int iSc = cJ.sc(strZY);
        if (z12) {
            this.Qj = cJ.pFF(iSc);
        }
        this.Ol = JPJ.Ql(sfl);
        this.ExN = frameLayout;
        sc(frameLayout);
        sc(iSc);
        zY(z11);
        qr();
    }

    private void qr() {
        this.f27257sc.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(Xc.sc(), this.f27256qr, this.zY.kDg(), null, true) { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.sc.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (sc.this.WH != null) {
                    sc.this.WH.Ol(str);
                }
                if (sc.this.Tf) {
                    sc.this.sc(0, 0);
                    com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), sc.this.zY, sc.this.Qj, "py_loading_success");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i11, String str, String str2) {
                super.onReceivedError(webView, i11, str, str2);
                sc.this.Tf = false;
                if (sc.this.WH != null) {
                    sc.this.WH.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(sc.this.zY));
                    sc.this.WH.sc(i11, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            @RequiresApi(api = 23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT >= 23 && webResourceRequest.isForMainFrame()) {
                    sc.this.Tf = false;
                    if (sc.this.WH == null || webResourceError == null) {
                        return;
                    }
                    sc.this.WH.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(sc.this.zY));
                    sc.this.WH.sc(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    sc.this.Tf = false;
                    if (sc.this.WH != null) {
                        sc.this.WH.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(sc.this.zY));
                        sc.this.WH.sc(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (sc.this.zY.GI() != null && !TextUtils.isEmpty(sc.this.zY.GI().j())) {
                        if (sc.this.WH != null) {
                            sc.this.WH.WH(str);
                        }
                        String strQl = JPJ.Ql(sc.this.zY);
                        WebResourceResponse webResourceResponseSc = com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(sc.this.zY.GI().j(), strQl, str);
                        if (webResourceResponseSc == null) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        if (sc.this.WH != null) {
                            sc.this.WH.UFX(str);
                        }
                        return webResourceResponseSc;
                    }
                    return super.shouldInterceptRequest(webView, str);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        this.f27257sc.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.f27256qr) { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.sc.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                super.onProgressChanged(webView, i11);
                if (sc.this.TRI == null || sc.this.TRI.getVisibility() != 0) {
                    return;
                }
                sc.this.TRI.setProgress(i11);
            }
        });
        com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(this.pFF).sc(false).pFF(false).sc(this.f27257sc.getWebView());
        com.bytedance.sdk.component.Ol.We we2 = this.f27257sc;
        we2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we2.getWebView(), BuildConfig.VERSION_CODE));
        this.f27257sc.setMixedContentMode(0);
    }

    private void sc(int i11) {
        HashMap map = new HashMap();
        map.put("click_scence", 3);
        this.f27256qr = new HJN(this.pFF);
        this.f27256qr.pFF(this.f27257sc).sc(this.zY).zY(this.zY.kDg()).We(this.zY.mD()).pFF(i11).ExN(this.zY.BU()).sc(this.f27257sc).pFF(this.Qj).sc(map).sc(new com.bytedance.sdk.openadsdk.We.Xc(3, this.Qj, this.zY));
    }

    private void sc(FrameLayout frameLayout) {
        com.bytedance.sdk.component.Ol.We we2 = new com.bytedance.sdk.component.Ol.We(this.pFF);
        this.f27257sc = we2;
        we2.f_();
        this.f27257sc.setLayerType(2, null);
        this.f27257sc.setVisibility(4);
        this.f27257sc.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f27257sc.setEnabled(true);
        this.f27257sc.setTag(this.Qj);
        this.f27257sc.setMaterialMeta(this.zY.bZj());
        this.f27257sc.setLandingPage(true);
        frameLayout.addView(this.f27257sc, new FrameLayout.LayoutParams(-1, -1));
        WH wh2 = new WH(this.pFF);
        this.dE = wh2;
        wh2.sc(this.zY, this.Qj, this.Xc);
        frameLayout.addView(this.dE, new FrameLayout.LayoutParams(-1, -1));
        if (this.zY.TEo()) {
            UFX ufx = new UFX(this.pFF);
            this.TRI = ufx;
            ufx.pFF();
            frameLayout.addView(this.TRI, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public static void sc(Sfl sfl, JSONObject jSONObject) {
        if (jSONObject == null || sfl == null || !JPJ.pFF(sfl) || !sfl.nW()) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_new_playable", 1);
            jSONObject.put("pag_json_data", jSONObject2.toString());
        } catch (JSONException unused) {
        }
    }

    private void zY(boolean z11) {
        com.bytedance.sdk.component.sc.Xc xcSc;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BidResponsedEx.KEY_CID, this.zY.kDg());
            jSONObject.put("log_extra", this.zY.mD());
        } catch (Throwable unused) {
        }
        if (Ol.pFF().Xc()) {
            qr.sc(new qr.sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.sc.1
                @Override // com.bytedance.sdk.openadsdk.Sfl.qr.sc
                public void sc(String str, String str2, Throwable th2) {
                    Tf.sc(str, str2, th2);
                }
            });
        }
        Qj qjSc = Qj.sc(Xc.sc(), this.f27257sc.getWebView(), new com.bytedance.sdk.openadsdk.Sfl.zY() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.sc.2
            @Override // com.bytedance.sdk.openadsdk.Sfl.zY
            public void sc(String str, JSONObject jSONObject2) {
                if (sc.this.f27256qr != null) {
                    sc.this.f27256qr.sc(str, jSONObject2);
                }
            }
        }, new com.bytedance.sdk.openadsdk.Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.sc.3
            @Override // com.bytedance.sdk.openadsdk.Sfl.sc
            public void pFF() {
                sc.this.f27256qr.zY(true);
                if (sc.this.UFX != null) {
                    sc.this.UFX.sc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Sfl.sc
            public com.bytedance.sdk.openadsdk.Sfl.We sc() {
                String strTRI = com.bytedance.sdk.openadsdk.common.pFF.TRI();
                strTRI.hashCode();
                switch (strTRI) {
                    case "2g":
                        return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_2G;
                    case "3g":
                        return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_3G;
                    case "4g":
                        return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_4G;
                    case "5g":
                        return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_5G;
                    case "wifi":
                        return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_WIFI;
                    default:
                        return com.bytedance.sdk.openadsdk.Sfl.We.TYPE_UNKNOWN;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Sfl.sc
            public void sc(int i11, String str) {
                sc.this.Tf = false;
                if (i11 == 2 || i11 == 3 || i11 == 4) {
                    sc.this.sc(2, i11);
                } else if (i11 == 5) {
                    sc.this.sc(3, i11);
                } else {
                    sc.this.sc(1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Sfl.sc
            public void sc(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("is_new_playable", 1);
                    if (sc.this.zY.nj()) {
                        jSONObject3.put("is_pre_render", 1);
                    }
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                } catch (JSONException e11) {
                    Tf.sc("PlayableManager", e11.getMessage());
                }
                com.bytedance.sdk.openadsdk.We.zY.pFF(sc.this.zY, sc.this.Qj, "playable_track", jSONObject2);
            }
        });
        this.WH = qjSc;
        qjSc.qr(this.Ol).ExN(com.bytedance.sdk.openadsdk.common.pFF.sc(Xc.sc())).pFF(com.bytedance.sdk.openadsdk.common.pFF.ExN()).sc(com.bytedance.sdk.openadsdk.common.pFF.sc()).We(com.bytedance.sdk.openadsdk.common.pFF.We()).zY(jSONObject).zY(JPJ.UFX(this.zY)).We(true).sc(z11).zY(false).sc(JPJ.YIK(this.zY)).pFF(JPJ.YIK(this.zY)).sc("sdkEdition", com.bytedance.sdk.openadsdk.common.pFF.zY()).ExN(JPJ.TRI(this.zY)).TRI(this.Qj);
        this.WH.sc(com.bytedance.sdk.openadsdk.Sfl.ExN.pFF(this.pFF));
        Set<String> setUFX = this.WH.UFX();
        final WeakReference weakReference = new WeakReference(this.WH);
        for (String str : setUFX) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (xcSc = this.f27256qr.sc()) != null) {
                xcSc.sc(str, new com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.sc.4
                    @Override // com.bytedance.sdk.component.sc.ExN
                    public JSONObject sc(@NonNull JSONObject jSONObject2, @NonNull TRI tri) {
                        try {
                            Qj qj2 = (Qj) weakReference.get();
                            if (qj2 == null) {
                                return null;
                            }
                            return qj2.We(sc(), jSONObject2);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
            }
        }
    }

    public boolean ExN() {
        return this.Ql;
    }

    public boolean TRI() {
        HJN hjn = this.f27256qr;
        if (hjn != null) {
            return hjn.ExN();
        }
        return false;
    }

    public void We() {
        Qj qj2 = this.WH;
        if (qj2 != null) {
            qj2.cJ();
        }
        com.bytedance.sdk.component.Ol.We we2 = this.f27257sc;
        if (we2 != null) {
            we2.Tf();
        }
        HJN hjn = this.f27256qr;
        if (hjn != null) {
            hjn.UFX();
        }
        this.f27257sc = null;
    }

    public void pFF() {
        Qj qj2;
        if (!this.BT.get() || (qj2 = this.WH) == null) {
            return;
        }
        qj2.zY(true);
    }

    public void pFF(boolean z11) {
        Qj qj2 = this.WH;
        if (qj2 != null) {
            qj2.ExN(z11);
        }
    }

    public void sc() {
        boolean z11;
        UFX ufx;
        if (this.BT.getAndSet(true)) {
            return;
        }
        FrameLayout frameLayout = this.ExN;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        if (this.SR || (ufx = this.TRI) == null) {
            this.WH.zY(true);
            z11 = false;
        } else {
            ufx.pFF(this.zY, this.We);
            Qj qj2 = this.WH;
            if (qj2 != null) {
                qj2.HJN();
            }
            z11 = true;
        }
        if (this.WH != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("webview_state", this.WH.JoC());
                jSONObject2.put("has_loading", z11);
                jSONObject2.put("is_new_playable", 1);
                jSONObject.put("pag_json_data", jSONObject2.toString());
                jSONObject.put("playable_event", "start_show_plb");
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.We.zY.pFF(this.zY, this.Qj, "playable_track", jSONObject);
            this.WH.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(this.zY));
        }
        this.f27257sc.setVisibility(0);
    }

    public void sc(final int i11, final int i12) {
        Qj qj2;
        InterfaceC0271sc interfaceC0271sc;
        if (this.SR) {
            return;
        }
        this.SR = true;
        if (i11 == 2) {
            this.Ql = true;
            this.WH.sc(3);
        } else if (i11 == 1) {
            this.Ql = true;
            this.WH.sc(2);
        } else if (i11 == 3) {
            this.Ql = true;
            this.WH.sc(4);
        } else if (i11 == 0) {
            this.WH.sc(1);
        }
        if (this.Ql && (interfaceC0271sc = this.wjp) != null) {
            interfaceC0271sc.sc();
        }
        if (this.BT.get() && (qj2 = this.WH) != null) {
            qj2.zY(true);
        }
        UFX ufx = this.TRI;
        if (ufx != null) {
            ufx.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.sc.7
                @Override // java.lang.Runnable
                public void run() {
                    if (sc.this.Ql) {
                        sc.this.dE.setVisibility(0);
                        sc.this.sc(true);
                    }
                    sc.this.TRI.zY();
                    if (sc.this.BT.get()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("remove_loading_page_type", i11);
                            jSONObject2.put("remove_loading_page_reason", i12);
                            jSONObject2.put("playable_url", sc.this.Ol);
                            jSONObject2.put("duration", sc.this.TRI.getDisplayDuration());
                            jSONObject2.put("is_new_playable", 1);
                            jSONObject.put("pag_json_data", jSONObject2.toString());
                            jSONObject.put("playable_event", "remove_loading_page");
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.We.zY.pFF(sc.this.zY, sc.this.Qj, "playable_track", jSONObject);
                    }
                }
            });
        }
    }

    public void sc(InterfaceC0271sc interfaceC0271sc) {
        this.wjp = interfaceC0271sc;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff) {
        HJN hjn = this.f27256qr;
        if (hjn != null) {
            hjn.sc(pff);
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.sc scVar) {
        this.Xc = scVar;
        UFX ufx = this.TRI;
        if (ufx != null && ufx.getDownloadButton() != null) {
            com.bytedance.sdk.openadsdk.core.ExN.Qj downloadButton = this.TRI.getDownloadButton();
            downloadButton.setOnClickListener(scVar);
            downloadButton.setOnTouchListener(scVar);
        }
        WH wh2 = this.dE;
        if (wh2 != null) {
            wh2.setClickListener(scVar);
        }
    }

    public void sc(boolean z11) {
        Qj qj2 = this.WH;
        if (qj2 != null) {
            qj2.sc(z11);
        }
    }

    public void sc(boolean z11, ExN exN) {
        this.UFX = exN;
        this.WH.pFF(z11);
        com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().pFF(this.zY);
        this.f27257sc.a_(this.Ol);
        Qj qj2 = this.WH;
        if (qj2 != null) {
            qj2.TRI(com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(this.zY));
            this.WH.Qj(this.Ol);
        }
    }

    public void zY() {
        Qj qj2;
        if (!this.BT.get() || (qj2 = this.WH) == null) {
            return;
        }
        qj2.zY(false);
    }
}
