package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.Cb;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class wjp implements com.bytedance.sdk.openadsdk.Tf.qr {
    private int BT;
    private com.bytedance.sdk.openadsdk.common.We Bs;
    private boolean CYO;
    private boolean Dl;
    com.bytedance.sdk.openadsdk.We.UFX ExN;
    private View FI;
    private boolean GI;
    private float II;
    private boolean JPJ;
    private com.bytedance.sdk.openadsdk.core.widget.sc.ExN JoC;
    private long McK;
    private boolean NQ;
    private ILoader OKY;
    private com.bytedance.sdk.openadsdk.common.Ql OXF;
    private long QLv;
    protected com.bytedance.sdk.openadsdk.We.We.ExN Qj;
    private int Ql;
    private final boolean SR;
    private final String Tf;

    @NonNull
    private final com.bytedance.sdk.openadsdk.core.model.Sfl UFX;
    private View WP;
    protected String We;
    private com.bytedance.sdk.component.Ol.We Xc;
    private boolean YdT;
    private String bSP;
    private boolean cJ;
    private float cvk;
    private int dE;
    private com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc fT;
    private boolean idT;
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc kX;
    HJN pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private boolean f27918pc;
    private boolean qKn;
    private String qfG;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    HJN f27920sc;
    private boolean uEA;
    private com.bytedance.sdk.component.Ol.We wjp;
    private int yL;
    protected boolean zY = true;
    private boolean Sfl = false;
    private final AtomicBoolean YIK = new AtomicBoolean(true);
    int TRI = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    String f27919qr = "";
    boolean Ol = false;
    private SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> HJN = new SparseArray<>();
    private boolean Gb = true;
    private float cD = -1.0f;
    private float Cb = -1.0f;
    private boolean BR = false;
    private long MxZ = -1;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private volatile int f27915eo = 0;
    private int Yhz = -1;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private volatile int f27917ko = 0;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private volatile int f27916ht = 0;
    private long ZM = 0;
    public boolean WH = false;
    private int kDg = -1;

    /* JADX INFO: compiled from: source.java */
    public interface We {
        void sc(WebView webView, int i11);

        void sc(WebView webView, String str);

        void sc(WebView webView, String str, Bitmap bitmap);
    }

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements com.bytedance.sdk.openadsdk.Tf.sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final View f27940sc;

        public pFF(View view) {
            this.f27940sc = view;
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.sc
        public int pFF() {
            View view = this.f27940sc;
            int measuredWidth = view != null ? view.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc()) : measuredWidth;
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.sc
        public int sc() {
            View view = this.f27940sc;
            int measuredHeight = view != null ? view.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? kX.We(com.bytedance.sdk.openadsdk.core.Xc.sc()) : measuredHeight;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc extends com.bytedance.sdk.openadsdk.core.pFF.sc implements com.bytedance.sdk.openadsdk.core.pFF.pFF.sc {
        private final View pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final com.bytedance.sdk.openadsdk.component.reward.sc.sc f27941sc;
        private final View.OnClickListener zY;

        public sc(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar, View view, View.OnClickListener onClickListener) {
            super(scVar.CYO, scVar.pFF, scVar.ExN, scVar.We ? 7 : 5);
            this.f27941sc = scVar;
            this.pFF = view;
            this.zY = onClickListener;
            HashMap map = new HashMap();
            map.put("close_auto_click", Boolean.TRUE);
            map.put("click_scence", 2);
            sc(map);
            sc(scVar.FI.zY());
            sc(this);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pFF.sc, com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
        public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
            if (!((com.bytedance.sdk.openadsdk.core.pFF.pFF) this).TRI.RiV()) {
                super.sc(view, f11, f12, f13, f14, sparseArray, z11);
                this.f27941sc.qKn.c_();
            } else {
                this.zY.onClick(view);
                this.pFF.setOnTouchListener(null);
                this.pFF.setOnClickListener(this.zY);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
        public void sc(View view, int i11) {
            this.pFF.setOnTouchListener(null);
            this.pFF.setOnClickListener(this.zY);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY implements com.bytedance.sdk.openadsdk.Tf.Ol {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final com.bytedance.sdk.component.Ol.We f27942sc;

        private zY(com.bytedance.sdk.component.Ol.We we2) {
            this.f27942sc = we2;
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.Ol
        public void pFF() {
            com.bytedance.sdk.component.Ol.We we2 = this.f27942sc;
            if (we2 == null) {
                return;
            }
            we2.SR();
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.Ol
        public void sc() {
            com.bytedance.sdk.component.Ol.We we2 = this.f27942sc;
            if (we2 == null) {
                return;
            }
            we2.UFX();
        }
    }

    public wjp(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.kX = scVar;
        this.UFX = scVar.pFF;
        this.Tf = scVar.ExN;
        this.SR = scVar.We;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MxZ() {
        this.CYO = true;
        this.NQ = false;
        this.kX.GI.removeMessages(LogSeverity.CRITICAL_VALUE);
        this.kX.GI.removeMessages(LogSeverity.ALERT_VALUE);
        this.kX.GI.removeMessages(900);
        this.kX.cJ.We(false);
        this.kX.Sfl.set(true);
        this.kX.kDg.BT();
        this.UFX.RiV();
        if (this.UFX.RiV() || !cJ.Qj(JPJ.sc(this.UFX))) {
            return;
        }
        View viewWH = this.kX.BR.WH();
        View.OnClickListener onClickListener = (View.OnClickListener) viewWH.getTag(viewWH.getId());
        if (onClickListener != null) {
            sc scVar = new sc(this.kX, viewWH, onClickListener);
            viewWH.setOnClickListener(scVar);
            viewWH.setOnTouchListener(scVar);
        }
    }

    private void QLv() {
        this.pFF.sc("showPlayableEndCardOverlay", (JSONObject) null);
        this.kX.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 1000L);
        this.kX.GI.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.5
            @Override // java.lang.Runnable
            public void run() {
                wjp.this.MxZ();
            }
        }, 1000L);
        com.bytedance.sdk.openadsdk.utils.Tf tf2 = this.kX.NP;
        if (tf2 != null) {
            tf2.sc(0L);
        }
    }

    public static /* synthetic */ int SR(wjp wjpVar) {
        int i11 = wjpVar.f27917ko;
        wjpVar.f27917ko = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int Xc(wjp wjpVar) {
        int i11 = wjpVar.f27915eo;
        wjpVar.f27915eo = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int dE(wjp wjpVar) {
        int i11 = wjpVar.f27916ht;
        wjpVar.f27916ht = i11 + 1;
        return i11;
    }

    private com.bytedance.sdk.openadsdk.We.We.ExN eo() {
        return new com.bytedance.sdk.openadsdk.We.Xc(JPJ.qr(this.UFX) ? 3 : 2, this.SR ? "rewarded_video" : "fullscreen_interstitial_ad", this.UFX);
    }

    private static String sc(String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, int i12, int i13) {
        String str2;
        String str3;
        float fAZJ = sfl.AZJ();
        if (!TextUtils.isEmpty(str)) {
            if (i11 == 1) {
                if (str.contains("?")) {
                    str3 = str + "&";
                } else {
                    str3 = str + "?";
                }
                str = str3 + "orientation=portrait";
            }
            if (str.contains("?")) {
                str2 = str + "&";
            } else {
                str2 = str + "?";
            }
            str = str2 + "height=" + i12 + "&width=" + i13 + "&aspect_ratio=" + fAZJ;
        }
        return !JPJ.qr(sfl) ? com.bytedance.sdk.openadsdk.utils.We.sc(str) : str;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void sc(String str, final We we2) {
        com.bytedance.sdk.component.Ol.We we3;
        com.bytedance.sdk.component.Ol.We we4 = this.Xc;
        if (we4 != null && we4.getWebView() != null) {
            com.bytedance.sdk.openadsdk.We.UFX ufxSc = new com.bytedance.sdk.openadsdk.We.UFX(this.UFX, this.Xc.getWebView(), new com.bytedance.sdk.openadsdk.We.WH() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.7
                @Override // com.bytedance.sdk.openadsdk.We.WH
                public void sc(int i11) {
                    if (TextUtils.isEmpty(wjp.this.qfG)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.We.zY.sc.sc(wjp.this.yL, wjp.this.f27915eo, wjp.this.f27916ht, wjp.this.f27917ko - wjp.this.f27916ht, wjp.this.UFX, "landingpage_endcard", i11);
                }
            }, this.Yhz).sc(true);
            this.ExN = ufxSc;
            this.fT = ufxSc.f27333sc;
            ufxSc.sc(Xc() ? "landingpage_endcard" : str);
            this.ExN.pFF(this.Tf);
            this.ExN.pFF(true);
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 23) {
                this.Xc.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.8
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(View view, int i12, int i13, int i14, int i15) {
                        com.bytedance.sdk.openadsdk.We.UFX ufx = wjp.this.ExN;
                        if (ufx != null) {
                            ufx.pFF(i13);
                        }
                    }
                });
            }
            Qj qj2 = this.kX.WP;
            if (qj2 != null) {
                this.ExN.sc(qj2.We());
            }
            com.bytedance.sdk.openadsdk.common.We weSc = cJ.sc(this.UFX, this.Xc, this.kX.CYO, this.Tf);
            this.Bs = weSc;
            if (weSc != null) {
                if (Xc()) {
                    str = "landingpage_endcard";
                }
                weSc.sc(str);
            }
            if (Xc()) {
                cJ.sc(this.UFX, this.Xc);
            }
            com.bytedance.sdk.openadsdk.core.widget.sc.ExN exN = new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(com.bytedance.sdk.openadsdk.core.Xc.sc(), this.f27920sc, this.UFX.kDg(), this.Bs, this.ExN, this.UFX.kX() || JPJ.qr(this.UFX)) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.9
                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str2) {
                    super.onPageFinished(webView, str2);
                    wjp.this.YdT = false;
                    wjp.this.Dl = true;
                    if (wjp.this.kX.Cb.cvk()) {
                        View viewWH = wjp.this.kX.BR.WH();
                        if (viewWH instanceof com.bytedance.sdk.openadsdk.core.ExN.We) {
                            ((com.bytedance.sdk.openadsdk.core.ExN.We) viewWH).setImageResource(com.bytedance.sdk.component.utils.Sfl.We(wjp.this.kX.f27911pc, "tt_skip_btn"));
                        }
                    }
                    DeviceUtils.AudioInfoReceiver.sc(wjp.this);
                    wjp.this.kDg = DeviceUtils.qr();
                    com.bytedance.sdk.openadsdk.We.We.ExN exN2 = wjp.this.Qj;
                    if (exN2 != null) {
                        exN2.TRI();
                    }
                    wjp.this.kX.WP.pFF(str2);
                    We we5 = we2;
                    if (we5 != null) {
                        we5.sc(webView, str2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                    super.onPageStarted(webView, str2, bitmap);
                    com.bytedance.sdk.openadsdk.We.We.ExN exN2 = wjp.this.Qj;
                    if (exN2 != null) {
                        exN2.ExN();
                    }
                    We we5 = we2;
                    if (we5 != null) {
                        we5.sc(webView, str2, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i12, String str2, String str3) {
                    super.onReceivedError(webView, i12, str2, str3);
                    int i13 = Build.VERSION.SDK_INT;
                    if (i13 < 23 && !wjp.this.sc(str3)) {
                        wjp.this.YIK.set(false);
                        wjp wjpVar = wjp.this;
                        wjpVar.TRI = i12;
                        wjpVar.f27919qr = str2;
                        wjpVar.YdT = false;
                        wjp.this.kX.WP.sc(i12, str2, str3);
                        if (wjp.this.Qj != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (i13 >= 23) {
                                    jSONObject.put(TrackingKey.CODE, i12);
                                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str2);
                                }
                                wjp.this.Qj.sc(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                @TargetApi(23)
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    int i12 = Build.VERSION.SDK_INT;
                    if (i12 < 23) {
                        return;
                    }
                    if (webResourceError != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                        StringBuilder sb2 = new StringBuilder("onReceivedError WebResourceError : description=");
                        sb2.append((Object) webResourceError.getDescription());
                        sb2.append("  url =");
                        sb2.append(webResourceRequest.getUrl().toString());
                    }
                    if (webResourceRequest == null || webResourceRequest.getUrl() == null || !wjp.this.sc(webResourceRequest.getUrl().toString())) {
                        if (webResourceError != null && webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                            wjp.this.kX.WP.sc(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
                        }
                        if (webResourceRequest == null || webResourceRequest.isForMainFrame()) {
                            wjp.this.YIK.set(false);
                            wjp.this.YdT = false;
                        }
                        if (wjp.this.Qj != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (i12 >= 23 && webResourceError != null) {
                                    jSONObject.put(TrackingKey.CODE, webResourceError.getErrorCode());
                                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                                }
                                wjp.this.Qj.sc(jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        if (webResourceError != null) {
                            wjp.this.TRI = webResourceError.getErrorCode();
                            wjp.this.f27919qr = String.valueOf(webResourceError.getDescription());
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                @TargetApi(21)
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    wjp.this.kX.WP.sc(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    if (webResourceRequest.getUrl() != null) {
                        new StringBuilder("onReceivedHttpError:url =").append(webResourceRequest.getUrl().toString());
                    }
                    if (webResourceRequest.isForMainFrame()) {
                        wjp.this.YIK.set(false);
                        wjp.this.YdT = false;
                        wjp.this.TRI = webResourceResponse.getStatusCode();
                        wjp.this.f27919qr = "onReceivedHttpError";
                    }
                    if (wjp.this.Qj != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(TrackingKey.CODE, webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                            wjp.this.Qj.sc(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                @TargetApi(21)
                public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                    try {
                        return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                    } catch (Throwable th2) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFWVM", "shouldInterceptRequest error1", th2);
                        return super.shouldInterceptRequest(webView, webResourceRequest);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                    if (JPJ.qr(wjp.this.UFX)) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        WebResourceResponse webResourceResponseSc = com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(wjp.this.UFX.GI().j(), JPJ.Ql(wjp.this.UFX), str2);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (wjp.this.Qj != null) {
                            com.bytedance.sdk.component.adexpress.We.WH.sc scVarSc = com.bytedance.sdk.component.adexpress.We.WH.sc(str2);
                            int i12 = webResourceResponseSc != null ? 1 : 2;
                            if (scVarSc == com.bytedance.sdk.component.adexpress.We.WH.sc.HTML) {
                                wjp.this.Qj.sc(str2, jCurrentTimeMillis, jCurrentTimeMillis2, i12);
                            } else if (scVarSc == com.bytedance.sdk.component.adexpress.We.WH.sc.JS) {
                                wjp.this.Qj.pFF(str2, jCurrentTimeMillis, jCurrentTimeMillis2, i12);
                            }
                        }
                        return webResourceResponseSc != null ? webResourceResponseSc : super.shouldInterceptRequest(webView, str2);
                    }
                    try {
                        if (TextUtils.isEmpty(wjp.this.qfG)) {
                            return super.shouldInterceptRequest(webView, str2);
                        }
                        wjp.SR(wjp.this);
                        WebResourceResponseModel webResourceResponseModelSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(wjp.this.OKY, wjp.this.qfG, str2);
                        if (webResourceResponseModelSc != null && webResourceResponseModelSc.getWebResourceResponse() != null) {
                            wjp.dE(wjp.this);
                            return webResourceResponseModelSc.getWebResourceResponse();
                        }
                        if (webResourceResponseModelSc != null && webResourceResponseModelSc.getMsg() == 2) {
                            wjp.Xc(wjp.this);
                        }
                        return super.shouldInterceptRequest(webView, str2);
                    } catch (Throwable th2) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFWVM", "shouldInterceptRequest url error", th2);
                        return super.shouldInterceptRequest(webView, str2);
                    }
                }
            };
            this.JoC = exN;
            this.Xc.setWebViewClient(exN);
            this.JoC.sc(this.UFX);
            this.JoC.sc(this.SR ? "rewarded_video" : "fullscreen_interstitial_ad");
            if (this.UFX.kX() && (we3 = this.Xc) != null && we3.getWebView() != null) {
                this.Xc.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.10
                    private final int pFF = com.bytedance.sdk.openadsdk.core.Xc.pFF();

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int i12;
                        com.bytedance.sdk.openadsdk.We.UFX ufx = wjp.this.ExN;
                        if (ufx != null) {
                            ufx.sc(motionEvent);
                        }
                        if (wjp.this.Bs != null) {
                            wjp.this.Bs.sc(motionEvent);
                        }
                        try {
                            int actionMasked = motionEvent.getActionMasked();
                            if (actionMasked == 0) {
                                wjp.this.Gb = true;
                                wjp.this.HJN = new SparseArray();
                                wjp.this.cvk = motionEvent.getRawX();
                                wjp.this.II = motionEvent.getRawY();
                                wjp.this.McK = System.currentTimeMillis();
                                try {
                                    long landingPageClickBegin = wjp.this.Xc.getLandingPageClickBegin();
                                    if (landingPageClickBegin > 0 && landingPageClickBegin < wjp.this.McK) {
                                        wjp.this.McK = landingPageClickBegin;
                                        wjp.this.Xc.setLandingPageClickBegin(-1L);
                                    }
                                } catch (Exception unused) {
                                }
                                wjp.this.cD = -1.0f;
                                wjp.this.Cb = -1.0f;
                                i12 = 0;
                            } else if (actionMasked == 1) {
                                i12 = 3;
                            } else if (actionMasked != 2) {
                                i12 = actionMasked != 3 ? -1 : 4;
                            } else {
                                float rawX = motionEvent.getRawX();
                                float rawY = motionEvent.getRawY();
                                if (Math.abs(rawX - wjp.this.cvk) >= this.pFF || Math.abs(rawY - wjp.this.II) >= this.pFF) {
                                    wjp.this.Gb = false;
                                }
                                wjp.this.cD += Math.abs(motionEvent.getX() - wjp.this.cvk);
                                wjp.this.Cb += Math.abs(motionEvent.getY() - wjp.this.II);
                                int i13 = (System.currentTimeMillis() - wjp.this.McK <= 200 || (wjp.this.cD <= 8.0f && wjp.this.Cb <= 8.0f)) ? 2 : 1;
                                if (wjp.this.cJ) {
                                    if (rawY - wjp.this.II > 8.0f) {
                                        wjp.this.OXF.sc();
                                    }
                                    if (rawY - wjp.this.II < -8.0f) {
                                        wjp.this.OXF.pFF();
                                    }
                                }
                                i12 = i13;
                            }
                            wjp.this.HJN.put(motionEvent.getActionMasked(), new com.bytedance.sdk.openadsdk.core.pFF.zY.sc(i12, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
                            if (motionEvent.getAction() != 1 || view.getVisibility() != 0 || Float.valueOf(view.getAlpha()).intValue() != 1) {
                                return false;
                            }
                            if ((wjp.this.Sfl && !com.bytedance.sdk.openadsdk.core.model.Xc.Qj(wjp.this.UFX)) || !wjp.this.Gb) {
                                return false;
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("down_x", wjp.this.cvk);
                            jSONObject.put("down_y", wjp.this.II);
                            jSONObject.put("down_time", wjp.this.McK);
                            jSONObject.put("up_x", motionEvent.getRawX());
                            jSONObject.put("up_y", motionEvent.getRawY());
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            try {
                                long landingPageClickEnd = wjp.this.Xc.getLandingPageClickEnd();
                                if (landingPageClickEnd > 0 && landingPageClickEnd < jCurrentTimeMillis) {
                                    try {
                                        wjp.this.Xc.setLandingPageClickEnd(-1L);
                                    } catch (Exception unused2) {
                                    }
                                    jCurrentTimeMillis = landingPageClickEnd;
                                }
                            } catch (Exception unused3) {
                            }
                            jSONObject.put("up_time", jCurrentTimeMillis);
                            int[] iArr = new int[2];
                            if (wjp.this.cJ) {
                                wjp wjpVar = wjp.this;
                                wjpVar.WP = wjpVar.kX.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.NP);
                            } else {
                                wjp wjpVar2 = wjp.this;
                                wjpVar2.WP = wjpVar2.kX.JoC.findViewById(520093713);
                            }
                            if (wjp.this.WP != null) {
                                wjp.this.WP.getLocationOnScreen(iArr);
                                jSONObject.put("button_x", iArr[0]);
                                jSONObject.put("button_y", iArr[1]);
                                jSONObject.put("button_width", wjp.this.WP.getWidth());
                                jSONObject.put("button_height", wjp.this.WP.getHeight());
                            }
                            if (wjp.this.FI != null) {
                                int[] iArr2 = new int[2];
                                wjp.this.FI.getLocationOnScreen(iArr2);
                                jSONObject.put("ad_x", iArr2[0]);
                                jSONObject.put("ad_y", iArr2[1]);
                                jSONObject.put("width", wjp.this.FI.getWidth());
                                jSONObject.put("height", wjp.this.FI.getHeight());
                            }
                            jSONObject.put("toolType", motionEvent.getToolType(0));
                            jSONObject.put("deviceId", motionEvent.getDeviceId());
                            jSONObject.put("source", motionEvent.getSource());
                            jSONObject.put("ft", com.bytedance.sdk.openadsdk.core.model.WH.sc(wjp.this.HJN, com.bytedance.sdk.openadsdk.core.Ol.pFF().sc() ? 1 : 2));
                            jSONObject.put("user_behavior_type", wjp.this.Gb ? 1 : 2);
                            jSONObject.put("click_scence", 2);
                            if (wjp.this.JoC != null) {
                                wjp.this.JoC.sc(jSONObject);
                            }
                            if (wjp.this.Sfl || com.bytedance.sdk.openadsdk.core.model.Xc.qr(wjp.this.UFX)) {
                                return false;
                            }
                            if (wjp.this.SR) {
                                com.bytedance.sdk.openadsdk.We.zY.sc(wjp.this.UFX, "rewarded_video", "click", jSONObject);
                            } else {
                                com.bytedance.sdk.openadsdk.We.zY.sc(wjp.this.UFX, "fullscreen_interstitial_ad", "click", jSONObject);
                            }
                            wjp.this.Sfl = true;
                            return false;
                        } catch (Throwable th2) {
                            Log.e("TTAD.RFWVM", "TouchRecordTool onTouch error", th2);
                            return false;
                        }
                    }
                });
            }
            com.bytedance.sdk.component.Ol.We we5 = this.Xc;
            if (we5 != null) {
                we5.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.f27920sc, this.ExN, this.Bs) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.11
                    @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i12) {
                        super.onProgressChanged(webView, i12);
                        We we6 = we2;
                        if (we6 != null) {
                            we6.sc(webView, i12);
                        }
                    }
                });
            }
            sc(this.Xc);
            if (i11 >= 24) {
                this.Xc.setLayerType(1, null);
            }
            this.Xc.setBackgroundColor(-1);
            this.Xc.setDisplayZoomControls(false);
        }
        ExN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return this.UFX.kX() && str.endsWith(".mp4");
    }

    public boolean BR() {
        return this.Dl && this.YIK.get();
    }

    public void BT() {
        a aVarGI;
        if (JPJ.ExN(this.UFX)) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
            if (sfl != null && (aVarGI = sfl.GI()) != null) {
                this.We = aVarGI.p();
            }
        } else {
            this.We = JPJ.Ql(this.UFX);
        }
        String strSc = sc(this.We, this.UFX, this.Ql, this.dE, this.BT);
        this.We = strSc;
        if (TextUtils.isEmpty(strSc)) {
            return;
        }
        this.qKn = this.We.contains("use_second_endcard=1");
    }

    public boolean CYO() {
        com.bytedance.sdk.component.Ol.We we2 = this.Xc;
        return we2 == null || we2.getWebView() == null;
    }

    public void Cb() {
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.Qj;
        if (exN != null) {
            exN.WH();
        }
    }

    public void Dl() {
        com.bytedance.sdk.component.Ol.We we2 = this.Xc;
        if (we2 != null) {
            we2.UFX();
        }
        com.bytedance.sdk.component.Ol.We we3 = this.wjp;
        if (we3 != null) {
            we3.UFX();
        }
        if (this.MxZ > 0) {
            this.QLv += SystemClock.elapsedRealtime() - this.MxZ;
            this.MxZ = 0L;
        }
        HJN hjn = this.f27920sc;
        if (hjn != null) {
            hjn.pFF(false);
            pFF(this.f27920sc, false);
            sc(this.f27920sc, true, false);
        }
        if (this.pFF == null || !JPJ.Qj(this.UFX)) {
            return;
        }
        this.pFF.pFF(false);
        pFF(this.pFF, false);
        sc(this.pFF, true, false);
    }

    public void ExN() {
        if (JPJ.ExN(this.UFX)) {
            return;
        }
        TRI();
    }

    public void ExN(boolean z11) {
        this.f27918pc = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("endcard_overlay_render_type", com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.UFX) ? 7 : 0);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.UFX, this.Tf, "use_second_endcard", jSONObject);
        this.MxZ = SystemClock.elapsedRealtime();
        try {
            if (!com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.UFX)) {
                this.f27920sc.sc("click_endcard_close", (JSONObject) null);
            } else if (z11) {
                this.kX.OXF.Qj();
                com.bytedance.sdk.openadsdk.We.zY.pFF(this.UFX, this.Tf, "endcard_close_skip", jSONObject);
            }
        } catch (Exception unused2) {
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.kX;
        scVar.NP.sc(scVar.Qj);
    }

    public String FI() {
        return this.f27919qr;
    }

    public boolean GI() {
        return this.WH;
    }

    public boolean Gb() {
        return this.Ol;
    }

    public void HJN() {
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.ExN;
        if (ufx != null) {
            ufx.sc(System.currentTimeMillis());
        }
    }

    public void II() {
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.Qj;
        if (exN != null) {
            exN.Qj();
        }
    }

    public int JPJ() {
        return this.TRI;
    }

    public boolean JoC() {
        return this.NQ;
    }

    public void McK() {
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.Qj;
        if (exN != null) {
            exN.qr();
        }
    }

    public boolean OXF() {
        HJN hjn = this.f27920sc;
        if (hjn == null) {
            return false;
        }
        return hjn.Qj();
    }

    public void Ol() {
        this.f27920sc.sc("showPlayableEndCardOverlay", (JSONObject) null);
        this.kX.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, 1000L);
        this.kX.GI.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.6
            @Override // java.lang.Runnable
            public void run() {
                wjp.this.MxZ();
            }
        }, 1000L);
        com.bytedance.sdk.openadsdk.utils.Tf tf2 = this.kX.NP;
        if (tf2 != null) {
            tf2.sc(0L);
        }
    }

    public void Qj() {
        if (this.Xc == null) {
            return;
        }
        this.YIK.set(this.uEA);
        if (this.wjp.getVisibility() == 0 && this.uEA) {
            QLv();
            return;
        }
        this.kX.cJ.zY(false);
        this.kX.WP.qr(Qj.zY);
        sc(this.f27920sc, true, false);
        pFF(this.f27920sc, false);
        sc(this.f27920sc, false);
        this.Xc.Tf();
        if (this.uEA) {
            this.wjp.setVisibility(0);
            sc(this.pFF, this.kX.f27908eo, true);
            pFF(this.pFF, true);
            sc(this.pFF, true);
            this.kX.GI.removeMessages(LogSeverity.CRITICAL_VALUE);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.kX;
            if (!scVar.kX.zY(scVar.kDg)) {
                this.kX.kDg.FI();
            }
        } else {
            if (this.kX.WP.sc()) {
                this.kX.WP.sc(5);
            }
            this.kX.kX.We();
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.kX;
            scVar2.NP.sc(scVar2.Qj);
        }
        this.NQ = true;
    }

    public HJN Ql() {
        return this.pFF;
    }

    public com.bytedance.sdk.openadsdk.We.UFX SR() {
        return this.ExN;
    }

    public boolean Sfl() {
        return this.Dl;
    }

    public void TRI() {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.Sfl.sc(this.kX.f27911pc, this.UFX))) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.UFX;
            if (sfl != null && !sfl.JK() && this.OKY == null && Xc()) {
                this.qfG = this.UFX.PPh();
                this.OKY = com.bytedance.sdk.openadsdk.qr.pFF.sc().pFF();
                int iSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.OKY, this.qfG);
                this.yL = iSc;
                this.Yhz = iSc > 0 ? 2 : 0;
                if (!TextUtils.isEmpty(this.qfG)) {
                    com.bytedance.sdk.openadsdk.We.UFX ufx = this.ExN;
                    if (ufx != null) {
                        ufx.sc(this.Yhz);
                    }
                    com.bytedance.sdk.openadsdk.We.zY.sc.sc(this.ZM, this.UFX, "landingpage_endcard", this.OKY, this.qfG);
                }
            }
            if ((!TextUtils.isEmpty(this.We) && this.We.contains("play.google.com/store")) || com.bytedance.sdk.openadsdk.core.model.Xc.TRI(this.UFX) || com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.UFX)) {
                this.Ol = true;
                return;
            }
            if (this.zY) {
                if (this.Xc == null || TextUtils.isEmpty(this.We) || !com.bytedance.sdk.openadsdk.core.model.Sfl.pFF(this.UFX)) {
                    if (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.UFX)) {
                        this.kX.OXF.zY();
                    }
                } else {
                    if (this.YdT) {
                        return;
                    }
                    String str = this.We + "&is_pre_render=1";
                    com.bytedance.sdk.openadsdk.We.UFX ufx2 = this.ExN;
                    if (ufx2 != null) {
                        ufx2.We();
                    }
                    if (JPJ.qr(this.UFX)) {
                        com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().pFF(this.UFX);
                    }
                    com.bytedance.sdk.openadsdk.utils.Sfl.sc(this.Xc, str);
                    this.kX.WP.sc(str);
                    this.YdT = true;
                }
            }
        }
    }

    public void TRI(boolean z11) {
        this.NQ = z11;
    }

    public HJN Tf() {
        return this.f27920sc;
    }

    public com.bytedance.sdk.component.Ol.We UFX() {
        return this.wjp;
    }

    public com.bytedance.sdk.component.Ol.We WH() {
        return this.Xc;
    }

    public String WP() {
        return this.We;
    }

    public void We(boolean z11) {
        if (this.f27920sc == null || this.kX.CYO.isFinishing()) {
            return;
        }
        this.kX.WP.ExN(z11);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z11);
            this.f27920sc.sc("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public boolean We() {
        return this.f27918pc;
    }

    public boolean Xc() {
        String str = this.We;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void YIK() {
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.Qj;
        if (exN != null) {
            exN.Ol();
        }
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.ExN;
        if (ufx != null) {
            ufx.Qj();
        }
    }

    public void cD() {
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.Qj;
        if (exN != null) {
            exN.zY();
            this.Qj.We();
        }
    }

    public void cJ() {
        kX.sc((View) this.Xc, 0);
        kX.sc((View) this.wjp, 8);
    }

    public boolean cvk() {
        if (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.UFX)) {
            return this.qKn && !this.f27918pc && this.kX.OXF.Tf();
        }
        return this.qKn && !this.f27918pc && this.YIK.get() && this.Dl;
    }

    public void dE() {
        com.bytedance.sdk.component.Ol.We we2 = this.Xc;
        if (we2 != null) {
            Cb.sc(we2.getWebView());
        }
        com.bytedance.sdk.component.Ol.We we3 = this.wjp;
        if (we3 != null) {
            Cb.sc(we3.getWebView());
        }
        long j11 = this.QLv;
        if (j11 > 0) {
            if (this.MxZ > 0) {
                this.QLv = j11 + (SystemClock.elapsedRealtime() - this.MxZ);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("endcard_overlay_render_type", com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.UFX) ? 7 : 0);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(this.kX.pFF, this.Tf, "second_endcard_duration", jSONObject, this.QLv);
        }
        this.Xc = null;
        if (this.Qj != null && !com.bytedance.sdk.openadsdk.core.model.Xc.We(this.UFX) && !com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.UFX) && !com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.UFX)) {
            this.Qj.sc(true);
            this.Qj.Tf();
        }
        HJN hjn = this.f27920sc;
        if (hjn != null) {
            hjn.UFX();
        }
        HJN hjn2 = this.pFF;
        if (hjn2 != null) {
            hjn2.UFX();
        }
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.ExN;
        if (ufx != null) {
            ufx.zY(this.UFX.kX() || JPJ.qr(this.UFX));
        }
        DeviceUtils.AudioInfoReceiver.pFF(this);
    }

    public void kX() {
        kX.sc((View) this.wjp, 8);
    }

    public void pFF() {
        com.bytedance.sdk.openadsdk.common.Ql ql2;
        this.FI = this.kX.CYO.findViewById(R.id.content);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.kX;
        boolean z11 = scVar.f27912qr;
        this.cJ = z11;
        if (!z11 || (ql2 = this.OXF) == null) {
            com.bytedance.sdk.component.Ol.We we2 = (com.bytedance.sdk.component.Ol.We) scVar.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.SR);
            this.Xc = we2;
            if (we2 == null || !com.bytedance.sdk.openadsdk.core.model.Sfl.pFF(this.UFX)) {
                kX.sc((View) this.Xc, 8);
            } else {
                this.Xc.f_();
            }
        } else {
            this.Xc = ql2.We();
        }
        com.bytedance.sdk.component.Ol.We we3 = (com.bytedance.sdk.component.Ol.We) this.kX.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.dE);
        this.wjp = we3;
        if (we3 != null && JPJ.qr(this.UFX) && JPJ.Qj(this.UFX)) {
            this.wjp.f_();
            this.wjp.setDisplayZoomControls(false);
        } else {
            kX.sc((View) this.wjp, 8);
        }
        com.bytedance.sdk.component.Ol.We we4 = this.Xc;
        if (we4 != null) {
            we4.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (wjp.this.Xc == null || wjp.this.Xc.getViewTreeObserver() == null) {
                        return;
                    }
                    wjp.this.Xc.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = wjp.this.Xc.getMeasuredWidth();
                    int measuredHeight = wjp.this.Xc.getMeasuredHeight();
                    if (wjp.this.Xc.getVisibility() == 0) {
                        wjp.this.sc(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        com.bytedance.sdk.component.Ol.We we5 = this.wjp;
        if (we5 != null) {
            we5.setLandingPage(true);
            this.wjp.setTag(JPJ.qr(this.UFX) ? this.Tf : "landingpage_endcard");
            this.wjp.setWebViewClient(new com.bytedance.sdk.component.Ol.We.sc());
            this.wjp.setMaterialMeta(this.UFX.bZj());
        }
    }

    public void pFF(int i11) {
        kX.sc((View) this.Xc, i11);
        com.bytedance.sdk.component.Ol.We we2 = this.Xc;
        if (we2 != null) {
            kX.sc((View) we2.getWebView(), i11);
        }
        if (this.Xc != null && (this.UFX.kX() || JPJ.qr(this.UFX))) {
            this.Xc.setLandingPage(true);
            this.Xc.setTag(JPJ.qr(this.UFX) ? this.Tf : "landingpage_endcard");
            this.Xc.setMaterialMeta(this.UFX.bZj());
        }
        if (i11 == 0 && JPJ.Qj(this.UFX)) {
            qr();
        }
    }

    public void pFF(HJN hjn, boolean z11) {
        try {
            this.kX.WP.We(z11);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z11 ? 1 : 0);
            hjn.sc("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void pFF(boolean z11) {
        sc(this.f27920sc, z11);
    }

    public boolean pc() {
        return this.CYO;
    }

    public void qKn() {
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.ExN;
        if (ufx != null) {
            ufx.ExN();
        }
    }

    public void qr() {
        a aVarGI = this.UFX.GI();
        if (aVarGI == null) {
            return;
        }
        String strP = aVarGI.p();
        this.bSP = strP;
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        this.bSP = sc(this.bSP, this.UFX, this.Ql, this.dE, this.BT);
        this.wjp.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(com.bytedance.sdk.openadsdk.core.Xc.sc(), this.pFF, this.UFX.kDg(), this.ExN, this.UFX.kX() || JPJ.qr(this.UFX)) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                com.bytedance.sdk.openadsdk.We.We.ExN exN = wjp.this.Qj;
                if (exN != null) {
                    exN.TRI();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                com.bytedance.sdk.openadsdk.We.We.ExN exN = wjp.this.Qj;
                if (exN != null) {
                    exN.ExN();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i11, String str, String str2) {
                if (wjp.this.sc(str2)) {
                    return;
                }
                wjp.this.uEA = false;
                wjp wjpVar = wjp.this;
                wjpVar.TRI = i11;
                wjpVar.f27919qr = str;
                if (wjpVar.Qj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put(TrackingKey.CODE, i11);
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        }
                        wjp.this.Qj.sc(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i11, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || !wjp.this.sc(webResourceRequest.getUrl().toString())) {
                    wjp.this.uEA = false;
                    if (wjp.this.Qj != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (Build.VERSION.SDK_INT >= 23 && webResourceError != null) {
                                jSONObject.put(TrackingKey.CODE, webResourceError.getErrorCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                            }
                            wjp.this.Qj.sc(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceError != null) {
                        wjp.this.TRI = webResourceError.getErrorCode();
                        wjp.this.f27919qr = String.valueOf(webResourceError.getDescription());
                    }
                    if (webResourceRequest == null) {
                        return;
                    }
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    wjp.this.uEA = false;
                    if (webResourceResponse != null) {
                        wjp.this.TRI = webResourceResponse.getStatusCode();
                        wjp.this.f27919qr = "onReceivedHttpError";
                    }
                }
                if (wjp.this.Qj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (webResourceResponse != null) {
                            jSONObject.put(TrackingKey.CODE, webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        }
                        wjp.this.Qj.sc(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceRequest != null) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }
        });
        this.wjp.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.pFF, this.ExN) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                super.onProgressChanged(webView, i11);
                if (!wjp.this.kX.f27912qr || wjp.this.kX.bSP == null) {
                    return;
                }
                wjp.this.kX.bSP.sc(webView, i11, wjp.this.fT);
            }
        });
        com.bytedance.sdk.openadsdk.utils.Sfl.sc(this.wjp, this.bSP);
        this.uEA = true;
    }

    public void sc() {
        if (this.JPJ) {
            return;
        }
        this.JPJ = true;
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.kX;
        this.Ql = scVar.OKY;
        this.BT = scVar.f27909ht;
        this.dE = scVar.ZM;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        pFF();
        this.ZM = SystemClock.elapsedRealtime() - jElapsedRealtime;
    }

    public void sc(float f11) {
        kX.sc(this.Xc, f11);
    }

    @Override // com.bytedance.sdk.openadsdk.Tf.qr
    public void sc(int i11) {
        int i12 = this.kDg;
        if (i12 <= 0 && i11 > 0) {
            We(false);
        } else if (i12 > 0 && i11 == 0) {
            We(true);
        }
        this.kDg = i11;
    }

    public void sc(int i11, int i12) {
        if (this.f27920sc == null || this.kX.CYO.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i11);
            jSONObject.put("height", i12);
            this.f27920sc.sc("resize", jSONObject);
        } catch (Exception e11) {
            Log.e("TTAD.RFWVM", "", e11);
        }
    }

    public void sc(DownloadListener downloadListener) {
        com.bytedance.sdk.component.Ol.We we2 = this.Xc;
        if (we2 == null || downloadListener == null) {
            return;
        }
        we2.setDownloadListener(downloadListener);
    }

    public void sc(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(this.kX.CYO).sc(false).pFF(false).sc(we2.getWebView());
        we2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we2.getWebView(), BuildConfig.VERSION_CODE));
        we2.setMixedContentMode(0);
    }

    public void sc(com.bytedance.sdk.openadsdk.Tf.ExN exN, String str, final com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff) {
        if (this.Xc == null) {
            return;
        }
        HashMap map = new HashMap();
        if (JPJ.qr(this.UFX)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 2);
        }
        this.Qj = eo();
        HJN hjn = new HJN(this.kX.CYO);
        this.f27920sc = hjn;
        hjn.sc(this.kX.qKn);
        String strBU = this.UFX.BU();
        this.f27920sc.pFF(this.Xc).sc(this.UFX).zY(this.UFX.kDg()).We(this.UFX.mD()).pFF(this.UFX.xP() ? 7 : 5).sc(new pFF(this.Xc)).ExN(strBU).sc(this.Xc).pFF(Xc() ? "landingpage_endcard" : str).sc(map).sc(this.Qj).sc(new com.bytedance.sdk.openadsdk.core.widget.TRI() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.TRI
            public void sc() {
                if (wjp.this.JoC != null) {
                    wjp.this.JoC.pFF();
                }
                com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff2 = pff;
                if (pff2 != null) {
                    pff2.We();
                }
            }
        }).sc(new HJN.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.15
            @Override // com.bytedance.sdk.openadsdk.core.HJN.sc
            public void sc() {
                wjp.this.MxZ();
            }
        });
        HashMap map2 = new HashMap();
        if (JPJ.Qj(this.UFX)) {
            map2.put("click_scence", 2);
        }
        HJN hjn2 = new HJN(this.kX.CYO);
        this.pFF = hjn2;
        hjn2.sc(this.kX.qKn);
        HJN hjnExN = this.pFF.pFF(this.wjp).sc(this.UFX).zY(this.UFX.kDg()).We(this.UFX.mD()).pFF(this.UFX.xP() ? 7 : 5).sc(new pFF(this.wjp)).sc(this.wjp).ExN(strBU);
        if (Xc()) {
            str = "landingpage_endcard";
        }
        hjnExN.pFF(str).sc(map2).sc(this.Qj).sc(new com.bytedance.sdk.openadsdk.core.widget.TRI() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.18
            @Override // com.bytedance.sdk.openadsdk.core.widget.TRI
            public void sc() {
                if (wjp.this.JoC != null) {
                    wjp.this.JoC.pFF();
                }
            }
        }).sc(new HJN.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.17
            @Override // com.bytedance.sdk.openadsdk.core.HJN.sc
            public void sc() {
                wjp.this.MxZ();
            }
        });
        this.f27920sc.sc(new zY(this.Xc));
        this.pFF.sc(new zY(this.wjp));
        this.f27920sc.sc(this.kX.BR.WH()).sc(this.kX.Bs).sc(exN).sc(this.kX.WP.UFX()).sc(new com.bytedance.sdk.openadsdk.Tf.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.19
            @Override // com.bytedance.sdk.openadsdk.Tf.pFF
            public void sc() {
                wjp.this.GI = true;
                wjp.this.kX.BR.WH().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.Tf.pFF
            public void sc(boolean z11, int i11, String str2) {
                if (z11) {
                    wjp wjpVar = wjp.this;
                    wjpVar.WH = true;
                    if (wjpVar.idT) {
                        wjp.this.idT = false;
                        wjp wjpVar2 = wjp.this;
                        wjpVar2.sc(wjpVar2.kX.f27908eo, true);
                    }
                }
                if (!com.bytedance.sdk.openadsdk.core.model.Sfl.We(wjp.this.kX.pFF) || JPJ.qr(wjp.this.kX.pFF)) {
                    return;
                }
                wjp.this.sc(z11, i11, str2);
            }
        });
        this.f27920sc.ExN(this.qKn);
        this.pFF.sc(this.kX.BR.WH()).sc(new com.bytedance.sdk.openadsdk.Tf.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.2
            @Override // com.bytedance.sdk.openadsdk.Tf.pFF
            public void sc() {
                wjp.this.GI = true;
                wjp.this.kX.BR.WH().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.Tf.pFF
            public void sc(boolean z11, int i11, String str2) {
            }
        });
    }

    public void sc(com.bytedance.sdk.openadsdk.common.Ql ql2) {
        this.OXF = ql2;
    }

    public void sc(HJN hjn, boolean z11) {
        if (this.f27920sc == null || this.kX.CYO.isFinishing()) {
            return;
        }
        hjn.pFF(z11);
    }

    public void sc(HJN hjn, boolean z11, boolean z12) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z11);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z12);
            com.bytedance.sdk.openadsdk.activity.TRI tri = this.kX.dix;
            if (tri != null) {
                jSONObject.put("multi_ads_show", tri.FI().qr());
            }
            hjn.sc("endcard_control_event", jSONObject);
            if (!z12) {
                this.idT = false;
            } else {
                if (this.Dl) {
                    return;
                }
                this.idT = true;
            }
        } catch (Exception unused) {
        }
    }

    public void sc(String str, final com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff) {
        sc(str, new We() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.12
            @Override // com.bytedance.sdk.openadsdk.component.reward.sc.wjp.We
            public void sc(WebView webView, int i11) {
                try {
                    if (JPJ.wjp(wjp.this.kX.pFF) && wjp.this.kX.pFF.TEo() && !wjp.this.kX.CYO.isFinishing()) {
                        wjp.this.kX.WP.zY(i11);
                    } else {
                        if (!wjp.this.kX.f27912qr || wjp.this.kX.bSP == null) {
                            return;
                        }
                        wjp.this.kX.bSP.sc(webView, i11, wjp.this.fT);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.sc.wjp.We
            public void sc(WebView webView, String str2) {
                if (wjp.this.kX.CYO.isFinishing()) {
                    return;
                }
                wjp.this.kX.WP.pFF(wjp.this.wjp());
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.sc.wjp.We
            public void sc(WebView webView, String str2, Bitmap bitmap) {
                if (wjp.this.BR || !JPJ.wjp(wjp.this.kX.pFF)) {
                    return;
                }
                wjp.this.BR = true;
                wjp.this.kX.WP.sc(wjp.this.kX.TRI, wjp.this.kX.pFF, wjp.this.kX.pFF.xP());
                if (!JPJ.Qj(wjp.this.UFX)) {
                    wjp.this.kX.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, wjp.this.kX.WP.Ol() * 1000);
                }
                wjp.this.kX.WP.WH();
                wjp.this.kX.qKn.UFX();
            }
        });
        if (JPJ.wjp(this.kX.pFF)) {
            sc(this.wjp);
            this.kX.WP.sc(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.13
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j11) {
                    wjp.this.kX.FI.pFF();
                    com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff2 = pff;
                    if (pff2 != null) {
                        pff2.We();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.kX;
        scVar.WP.zY(scVar.Bs);
        sc(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.wjp.14
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j11) {
                wjp.this.kX.FI.pFF();
                com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff2 = pff;
                if (pff2 != null) {
                    pff2.We();
                }
            }
        });
    }

    public void sc(boolean z11) {
        this.zY = z11;
    }

    public void sc(boolean z11, int i11, String str) {
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.Qj;
        if (exN == null) {
            return;
        }
        if (z11) {
            exN.pFF();
        } else {
            exN.sc(i11, str);
        }
    }

    public void sc(boolean z11, boolean z12) {
        sc(this.f27920sc, z11, z12);
    }

    public void uEA() {
        com.bytedance.sdk.component.Ol.We we2 = this.Xc;
        if (we2 != null) {
            we2.Ol();
        }
        com.bytedance.sdk.component.Ol.We we3 = this.wjp;
        if (we3 != null) {
            we3.Ol();
        }
        if (this.MxZ == 0) {
            this.MxZ = SystemClock.elapsedRealtime();
        }
        HJN hjn = this.f27920sc;
        if (hjn != null) {
            hjn.WH();
            com.bytedance.sdk.component.Ol.We we4 = this.Xc;
            if (we4 != null) {
                if (we4.getVisibility() == 0) {
                    this.f27920sc.pFF(true);
                    pFF(this.f27920sc, true);
                    sc(this.f27920sc, false, true);
                    if (JPJ.WH(this.UFX) && !this.CYO && this.kX.pFF.RiV()) {
                        Ol();
                    }
                } else {
                    this.f27920sc.pFF(false);
                    pFF(this.f27920sc, false);
                    sc(this.f27920sc, true, false);
                }
            }
        }
        if (this.pFF != null && JPJ.Qj(this.UFX)) {
            this.pFF.WH();
            com.bytedance.sdk.component.Ol.We we5 = this.wjp;
            if (we5 != null) {
                if (we5.getVisibility() == 0) {
                    this.pFF.pFF(true);
                    pFF(this.pFF, true);
                    sc(this.pFF, false, true);
                    if (!this.CYO && this.kX.pFF.RiV()) {
                        QLv();
                    }
                } else {
                    this.pFF.pFF(false);
                    pFF(this.pFF, false);
                    sc(this.pFF, true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.ExN;
        if (ufx != null) {
            ufx.qr();
        }
    }

    public boolean wjp() {
        return this.YIK.get();
    }

    public void zY(boolean z11) {
        pFF(this.f27920sc, z11);
    }

    public boolean zY() {
        return this.GI;
    }
}
