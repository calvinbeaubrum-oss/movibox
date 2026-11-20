package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.Cb;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.hisavana.common.tracking.TrackingKey;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Sfl implements com.bytedance.sdk.openadsdk.Tf.qr {
    private boolean ExN;
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc Ol;
    private volatile boolean Qj;
    private com.bytedance.sdk.openadsdk.core.pFF.qr TRI;
    private int WH;
    private ImageView We;
    private final com.bytedance.sdk.openadsdk.core.model.Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final AtomicBoolean f27868qr = new AtomicBoolean(false);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Activity f27869sc;
    private com.bytedance.sdk.component.Ol.We zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.ExN.dE<Bitmap> {
        private final AtomicBoolean We;
        private final String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<ImageView> f27874sc;
        private final WeakReference<Sfl> zY;

        public sc(ImageView imageView, String str, Sfl sfl, AtomicBoolean atomicBoolean) {
            this.f27874sc = new WeakReference<>(imageView);
            this.pFF = str;
            this.zY = new WeakReference<>(sfl);
            this.We = atomicBoolean;
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, @Nullable Throwable th2) {
            Sfl sfl;
            ImageView imageView = this.f27874sc.get();
            if (imageView == null || (sfl = this.zY.get()) == null) {
                return;
            }
            imageView.setVisibility(8);
            sfl.sc(-2, this.pFF);
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
            Sfl sfl;
            ImageView imageView = this.f27874sc.get();
            if (imageView == null || (sfl = this.zY.get()) == null || ufx == null) {
                return;
            }
            Bitmap bitmapPFF = ufx.pFF();
            if (bitmapPFF == null) {
                sfl.sc(-1, this.pFF);
                return;
            }
            imageView.setImageBitmap(bitmapPFF);
            this.We.set(true);
            sfl.We();
        }
    }

    public Sfl(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.Ol = scVar;
        this.pFF = scVar.pFF;
        this.f27869sc = scVar.CYO;
    }

    private void ExN() {
        this.zY.f_();
        sc(this.zY);
        this.zY.setDisplayZoomControls(false);
        this.zY.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Sfl.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                super.onProgressChanged(webView, i11);
                if (i11 == 100) {
                    Sfl.this.We();
                }
            }
        });
        this.zY.setWebViewClient(new com.bytedance.sdk.component.Ol.We.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Sfl.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                Sfl.this.We();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    Sfl.this.sc(webResourceResponse.getStatusCode(), webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : null);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (Sfl.this.sc(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        sc(Api.BaseClientBuilder.API_PRIORITY_OTHER, (String) null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void sc(int i11, int i12) {
        if (i11 == 0 || i12 == 0 || this.We == null) {
            return;
        }
        int iZY = kX.zY((Context) this.f27869sc);
        int iWe = kX.We((Context) this.f27869sc);
        float f11 = i11 / i12;
        float f12 = iZY;
        if (f11 <= f12 / iWe) {
            iZY = (int) Math.ceil(f12 * f11);
        } else {
            iWe = (int) Math.ceil(f12 / f11);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.We.getLayoutParams();
        layoutParams.width = iZY;
        layoutParams.height = iWe;
        layoutParams.gravity = 17;
        this.We.setLayoutParams(layoutParams);
        this.We.setOnClickListener(this.TRI);
        this.We.setOnTouchListener(this.TRI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final int i11, final String str) {
        if (this.Qj) {
            return;
        }
        this.Qj = true;
        final String strUFX = this.pFF.GOt() != null ? this.pFF.GOt().UFX() : "";
        if (i11 == Integer.MAX_VALUE) {
            com.bytedance.sdk.openadsdk.We.zY.pFF(this.pFF, strUFX, "load_vast_endcard_success", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.We.zY.sc(new com.bytedance.sdk.component.Qj.Qj("load_vast_endcard_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Sfl.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("reason_code", i11);
                        jSONObject.put(TrackingKey.ERROR_CODE, i11);
                        String str2 = str;
                        if (str2 != null) {
                            jSONObject.put("url", str2);
                        }
                        com.bytedance.sdk.openadsdk.We.zY.pFF(Sfl.this.pFF, strUFX, "load_vast_endcard_fail", jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void sc(com.bytedance.sdk.component.Ol.We we2) {
        we2.setVerticalScrollBarEnabled(false);
        we2.setHorizontalScrollBarEnabled(false);
        we2.setMixedContentMode(0);
        we2.setJavaScriptEnabled(true);
        we2.setJavaScriptCanOpenWindowsAutomatically(true);
        we2.setDomStorageEnabled(true);
        we2.setDatabaseEnabled(true);
        we2.setCacheMode(-1);
        we2.setAllowFileAccess(false);
        we2.setSupportZoom(true);
        we2.setBuiltInZoomControls(true);
        we2.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        we2.setUseWideViewPort(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(String str) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
        if (str == null || (sfl = this.pFF) == null || sfl.GOt() == null || this.TRI == null) {
            return false;
        }
        this.pFF.GOt().qr(str);
        this.TRI.onClick(this.zY);
        return true;
    }

    public void pFF() {
        DeviceUtils.AudioInfoReceiver.pFF(this);
        com.bytedance.sdk.component.Ol.We we2 = this.zY;
        if (we2 != null) {
            Cb.sc(we2.getWebView());
        }
    }

    public void sc() {
        DeviceUtils.AudioInfoReceiver.sc(this);
        this.WH = DeviceUtils.qr();
        if (this.pFF.GOt() != null) {
            this.TRI = new com.bytedance.sdk.openadsdk.core.pFF.qr("VAST_END_CARD", this.pFF.GOt()) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.Sfl.1
            };
            com.bytedance.sdk.openadsdk.core.Tf.zY zYVarZY = this.pFF.GOt().zY();
            if (zYVarZY != null) {
                String strExN = zYVarZY.ExN();
                if (!TextUtils.isEmpty(strExN)) {
                    this.ExN = true;
                    this.We = (ImageView) this.Ol.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Qj);
                    sc(zYVarZY.pFF(), zYVarZY.zY());
                    com.bytedance.sdk.openadsdk.Ol.We.sc(strExN).sc(zYVarZY.pFF()).pFF(zYVarZY.zY()).ExN(kX.We(com.bytedance.sdk.openadsdk.core.Xc.sc())).We(kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc())).zY(2).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(this.pFF, strExN, new sc(this.We, strExN, this, this.f27868qr)));
                    return;
                }
                com.bytedance.sdk.component.Ol.We we2 = (com.bytedance.sdk.component.Ol.We) this.Ol.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Ol);
                this.zY = we2;
                if (we2 == null) {
                    return;
                }
                ExN();
                String strWe = zYVarZY.We();
                if (strWe != null) {
                    this.ExN = true;
                    if (strWe.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        this.zY.a_(strWe);
                        return;
                    }
                    String strSc = com.bytedance.sdk.openadsdk.core.Tf.ExN.sc(strWe);
                    String str = TextUtils.isEmpty(strSc) ? strWe : strSc;
                    this.zY.setDefaultTextEncodingName("UTF -8");
                    this.zY.sc(null, str, "text/html", "UTF-8", null);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Tf.qr
    public void sc(int i11) {
        int i12 = this.WH;
        if (i12 == 0 && i11 > 0) {
            this.pFF.GOt().sc().Ol(this.Ol.JPJ.qr());
        } else if (i12 > 0 && i11 == 0) {
            this.pFF.GOt().sc().Qj(this.Ol.JPJ.qr());
        }
        this.WH = i11;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.ExN exN) {
        com.bytedance.sdk.openadsdk.core.pFF.qr qrVar = this.TRI;
        if (qrVar != null) {
            qrVar.sc(exN);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean sc(Xc xc2) {
        com.bytedance.sdk.openadsdk.core.Tf.zY zYVarZY;
        if (!this.ExN) {
            return false;
        }
        if (this.We == null || !this.f27868qr.get()) {
            com.bytedance.sdk.component.Ol.We we2 = this.zY;
            if (we2 != null) {
                we2.setVisibility(0);
                if (this.zY.getWebView() != null) {
                    this.zY.getWebView().setOnTouchListener(this.TRI);
                }
            }
        } else {
            this.We.setVisibility(0);
        }
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.pFF;
        if (sfl == null || sfl.GOt() == null || (zYVarZY = this.pFF.GOt().zY()) == null) {
            return true;
        }
        zYVarZY.pFF(xc2 != null ? xc2.qr() : -1L);
        return true;
    }

    public boolean zY() {
        if (!this.ExN) {
            return false;
        }
        ImageView imageView = this.We;
        if (imageView != null) {
            imageView.performClick();
            return true;
        }
        com.bytedance.sdk.component.Ol.We we2 = this.zY;
        if (we2 == null) {
            return false;
        }
        this.TRI.onClick(we2);
        return true;
    }
}
