package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.Sfl.Qj;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.Tf.qr;
import com.bytedance.sdk.openadsdk.We.UFX;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.Cb;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.WP;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.BT;
import com.bytedance.sdk.openadsdk.core.widget.SR;
import com.bytedance.sdk.openadsdk.core.widget.WH;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTPlayableLandingPageActivity extends TTBaseActivity implements FI.sc, qr, com.bytedance.sdk.openadsdk.core.pFF.We {
    private static final com.bytedance.sdk.openadsdk.Sfl.qr.sc QLv = new com.bytedance.sdk.openadsdk.Sfl.qr.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.1
        @Override // com.bytedance.sdk.openadsdk.Sfl.qr.sc
        public void sc(String str, String str2, Throwable th2) {
            Tf.sc(str, str2, th2);
        }
    };
    private int BR;
    private com.bytedance.sdk.openadsdk.core.ExN.TRI BT;
    private Qj CYO;
    private String Cb;
    private HJN Dl;
    private com.bytedance.sdk.component.Ol.We ExN;
    private String FI;
    private com.bytedance.sdk.openadsdk.We.We.ExN GI;
    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI Gb;
    private boolean HJN;
    private String JPJ;
    private int JoC;
    private boolean McK;
    private UFX MxZ;
    private Context Ql;
    private int SR;
    private String Sfl;
    private SR Tf;
    private BT UFX;
    private RelativeLayout WH;
    private WH Xc;
    private HJN YIK;
    private com.bytedance.sdk.openadsdk.Sfl.sc.sc Yhz;
    private Sfl cvk;
    private com.bytedance.sdk.openadsdk.core.widget.UFX dE;
    TTAdDislikeToast pFF;
    private ILoader qKn;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    WP f27554sc;
    private int uEA;
    private String wjp;
    private boolean yL;
    private boolean TRI = true;
    private boolean Qj = false;
    private boolean Ol = true;
    final AtomicBoolean zY = new AtomicBoolean(false);
    private final String WP = "embeded_ad";
    private final FI II = new FI(Looper.getMainLooper(), this);
    private final AtomicBoolean cD = new AtomicBoolean(false);
    private final AtomicInteger OXF = new AtomicInteger(0);
    private final AtomicInteger cJ = new AtomicInteger(0);
    private final AtomicInteger kX = new AtomicInteger(0);

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private boolean f27553pc = false;
    protected com.bytedance.sdk.openadsdk.Tf.We We = new com.bytedance.sdk.openadsdk.Tf.We() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.8
        @Override // com.bytedance.sdk.openadsdk.Tf.We
        public void pFF() {
            if (JPJ.SR(TTPlayableLandingPageActivity.this.cvk) && JPJ.BT(TTPlayableLandingPageActivity.this.cvk)) {
                TTPlayableLandingPageActivity.this.II.sendMessageDelayed(TTPlayableLandingPageActivity.this.sc(0, 0), 1000L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.We
        public void sc() {
            if (!TTPlayableLandingPageActivity.this.isFinishing() && JPJ.SR(TTPlayableLandingPageActivity.this.cvk) && JPJ.dE(TTPlayableLandingPageActivity.this.cvk)) {
                TTPlayableLandingPageActivity.this.II.removeMessages(2);
                TTPlayableLandingPageActivity.this.II.sendMessage(TTPlayableLandingPageActivity.this.sc(1, 0));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.Tf.We
        public void sc(int i11) {
            if (!JPJ.SR(TTPlayableLandingPageActivity.this.cvk) || TTPlayableLandingPageActivity.this.dE == null) {
                return;
            }
            TTPlayableLandingPageActivity.this.dE.setProgress(i11);
        }
    };

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private int f27552eo = 1;

    private void ExN() {
        if (this.CYO != null) {
            return;
        }
        if (Ol.pFF().Xc()) {
            com.bytedance.sdk.openadsdk.Sfl.qr.sc(QLv);
        }
        com.bytedance.sdk.openadsdk.Sfl.sc scVar = new com.bytedance.sdk.openadsdk.Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.9
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
                super.sc(i11, str);
                if (JPJ.JPJ(TTPlayableLandingPageActivity.this.cvk)) {
                    TTPlayableLandingPageActivity.this.II.sendMessage(TTPlayableLandingPageActivity.this.sc(3, JPJ.sc(i11)));
                    TTPlayableLandingPageActivity.this.WH();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Sfl.sc
            public void sc(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.We.zY.pFF(TTPlayableLandingPageActivity.this.cvk, "embeded_ad", "playable_track", jSONObject);
            }
        };
        com.bytedance.sdk.openadsdk.Sfl.zY zYVar = new com.bytedance.sdk.openadsdk.Sfl.zY() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.Sfl.zY
            public void sc(String str, JSONObject jSONObject) {
                TTPlayableLandingPageActivity.this.YIK.sc(str, jSONObject);
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BidResponsedEx.KEY_CID, this.wjp);
            jSONObject.put("log_extra", this.Sfl);
            this.CYO = Qj.sc(getApplicationContext(), this.ExN.getWebView(), zYVar, scVar).qr(this.JPJ).ExN(com.bytedance.sdk.openadsdk.common.pFF.sc(Xc.sc())).sc(com.bytedance.sdk.openadsdk.common.pFF.sc()).zY(jSONObject).pFF(com.bytedance.sdk.openadsdk.common.pFF.ExN()).sc("sdkEdition", com.bytedance.sdk.openadsdk.common.pFF.zY()).We(com.bytedance.sdk.openadsdk.common.pFF.We()).We(false).sc(this.f27553pc).sc(JPJ.YIK(this.cvk)).pFF(JPJ.YIK(this.cvk)).ExN(true);
        } catch (Throwable unused) {
        }
        if (this.CYO == null) {
            Tf.sc("Pangle", "new PlayablePlugin Object failed, mPlayablePlugin is null");
            return;
        }
        if (!TextUtils.isEmpty(JPJ.UFX(this.cvk))) {
            this.CYO.zY(JPJ.UFX(this.cvk));
        }
        Set<String> setUFX = this.CYO.UFX();
        final WeakReference weakReference = new WeakReference(this.CYO);
        for (String str : setUFX) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str)) {
                this.YIK.sc().sc(str, new com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.11
                    @Override // com.bytedance.sdk.component.sc.ExN
                    public JSONObject sc(@NonNull JSONObject jSONObject2, @NonNull com.bytedance.sdk.component.sc.TRI tri) {
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

    private void Ol() {
        RelativeLayout relativeLayout = this.WH;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTPlayableLandingPageActivity.this.GI != null) {
                        TTPlayableLandingPageActivity.this.GI.Qj();
                    }
                    TTPlayableLandingPageActivity.this.II.sendMessage(TTPlayableLandingPageActivity.this.sc(4, 0));
                    TTPlayableLandingPageActivity.this.sc("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        BT bt2 = this.UFX;
        if (bt2 != null) {
            bt2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.pFF();
                }
            });
        }
        SR sr2 = this.Tf;
        if (sr2 != null) {
            sr2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                    tTPlayableLandingPageActivity.f27553pc = !tTPlayableLandingPageActivity.f27553pc;
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity2 = TTPlayableLandingPageActivity.this;
                    tTPlayableLandingPageActivity2.zY(tTPlayableLandingPageActivity2.f27553pc);
                    if (TTPlayableLandingPageActivity.this.CYO != null) {
                        TTPlayableLandingPageActivity.this.CYO.sc(TTPlayableLandingPageActivity.this.f27553pc);
                    }
                }
            });
        }
        if (this.yL) {
            return;
        }
        this.ExN.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        kX.sc((View) this.ExN, 4);
        this.dE.pFF(this.cvk, this.f27552eo);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Qj() {
        com.bytedance.sdk.component.Ol.We we2 = this.ExN;
        if (we2 == null) {
            return;
        }
        we2.setLandingPage(true);
        this.ExN.setTag("landingpage");
        this.ExN.setMaterialMeta(this.cvk.bZj());
        UFX ufxSc = new UFX(this.cvk, this.ExN.getWebView(), new com.bytedance.sdk.openadsdk.We.WH() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.12
            @Override // com.bytedance.sdk.openadsdk.We.WH
            public void sc(int i11) {
                com.bytedance.sdk.openadsdk.We.zY.sc.sc(TTPlayableLandingPageActivity.this.BR, TTPlayableLandingPageActivity.this.kX.get(), TTPlayableLandingPageActivity.this.cJ.get(), TTPlayableLandingPageActivity.this.OXF.get() - TTPlayableLandingPageActivity.this.cJ.get(), TTPlayableLandingPageActivity.this.cvk, "embeded_ad", i11);
            }
        }, this.JoC).sc(true);
        this.MxZ = ufxSc;
        ufxSc.sc("embeded_ad");
        this.MxZ.sc(this.GI);
        this.MxZ.sc(this.CYO);
        this.ExN.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(this.Ql, this.YIK, this.wjp, this.MxZ, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                TTPlayableLandingPageActivity.this.Qj = true;
                if (TTPlayableLandingPageActivity.this.isFinishing()) {
                    return;
                }
                if (TTPlayableLandingPageActivity.this.CYO != null) {
                    TTPlayableLandingPageActivity.this.CYO.Ol(str);
                }
                try {
                    TTPlayableLandingPageActivity.this.We.pFF();
                } catch (Throwable unused) {
                }
                try {
                    if (TTPlayableLandingPageActivity.this.BT != null) {
                        TTPlayableLandingPageActivity.this.BT.setVisibility(8);
                    }
                    if (TTPlayableLandingPageActivity.this.TRI) {
                        TTPlayableLandingPageActivity.this.WH();
                        TTPlayableLandingPageActivity.this.sc("py_loading_success");
                        HJN hjn = this.zY;
                        if (hjn != null) {
                            hjn.pFF(true);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i11, String str, String str2) {
                super.onReceivedError(webView, i11, str, str2);
                if (Build.VERSION.SDK_INT >= 23) {
                    return;
                }
                TTPlayableLandingPageActivity.this.TRI = false;
                if (TTPlayableLandingPageActivity.this.CYO != null) {
                    TTPlayableLandingPageActivity.this.CYO.sc(i11, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (Build.VERSION.SDK_INT < 23) {
                    return;
                }
                TTPlayableLandingPageActivity.this.TRI = false;
                if (TTPlayableLandingPageActivity.this.CYO == null || webResourceError == null || webResourceRequest == null) {
                    return;
                }
                TTPlayableLandingPageActivity.this.CYO.sc(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            @RequiresApi(api = 21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (TTPlayableLandingPageActivity.this.JPJ != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableLandingPageActivity.this.JPJ.equals(webResourceRequest.getUrl().toString())) {
                    TTPlayableLandingPageActivity.this.TRI = false;
                }
                if (TTPlayableLandingPageActivity.this.CYO != null && webResourceRequest != null) {
                    try {
                        TTPlayableLandingPageActivity.this.CYO.sc(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    } catch (Throwable unused) {
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (TTPlayableLandingPageActivity.this.CYO != null) {
                        TTPlayableLandingPageActivity.this.CYO.WH(str);
                    }
                    if (!TextUtils.isEmpty(TTPlayableLandingPageActivity.this.Cb)) {
                        TTPlayableLandingPageActivity.this.OXF.incrementAndGet();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    WebResourceResponseModel webResourceResponseModelSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(TTPlayableLandingPageActivity.this.qKn, TTPlayableLandingPageActivity.this.Cb, str);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (TTPlayableLandingPageActivity.this.GI != null) {
                        com.bytedance.sdk.component.adexpress.We.WH.sc scVarSc = com.bytedance.sdk.component.adexpress.We.WH.sc(str);
                        int i11 = (webResourceResponseModelSc == null || webResourceResponseModelSc.getWebResourceResponse() == null) ? 2 : 1;
                        if (scVarSc == com.bytedance.sdk.component.adexpress.We.WH.sc.HTML) {
                            TTPlayableLandingPageActivity.this.GI.sc(str, jCurrentTimeMillis, jCurrentTimeMillis2, i11);
                        } else if (scVarSc == com.bytedance.sdk.component.adexpress.We.WH.sc.JS) {
                            TTPlayableLandingPageActivity.this.GI.pFF(str, jCurrentTimeMillis, jCurrentTimeMillis2, i11);
                        }
                    }
                    if (webResourceResponseModelSc == null || webResourceResponseModelSc.getWebResourceResponse() == null) {
                        if (webResourceResponseModelSc != null && webResourceResponseModelSc.getMsg() == 2) {
                            TTPlayableLandingPageActivity.this.kX.incrementAndGet();
                        }
                        return super.shouldInterceptRequest(webView, str);
                    }
                    TTPlayableLandingPageActivity.this.cJ.incrementAndGet();
                    if (TTPlayableLandingPageActivity.this.CYO != null) {
                        TTPlayableLandingPageActivity.this.CYO.UFX(str);
                    }
                    return webResourceResponseModelSc.getWebResourceResponse();
                } catch (Exception unused) {
                    return super.shouldInterceptRequest(webView, str);
                }
            }
        });
        sc(this.ExN);
        com.bytedance.sdk.openadsdk.utils.Sfl.sc(this.ExN, this.JPJ);
        Qj qj2 = this.CYO;
        if (qj2 != null) {
            qj2.Qj(this.JPJ);
        }
        this.ExN.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.YIK, this.MxZ) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                super.onProgressChanged(webView, i11);
                if (TTPlayableLandingPageActivity.this.isFinishing()) {
                    return;
                }
                try {
                    TTPlayableLandingPageActivity.this.We.sc(i11);
                } catch (Throwable unused) {
                }
                if (TTPlayableLandingPageActivity.this.BT != null) {
                    if (i11 != 100) {
                        TTPlayableLandingPageActivity.this.BT.setProgress(i11);
                        return;
                    }
                    TTPlayableLandingPageActivity.this.Qj = true;
                    TTPlayableLandingPageActivity.this.BT.setVisibility(8);
                    TTPlayableLandingPageActivity.this.WH();
                }
            }
        });
        this.ExN.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (TTPlayableLandingPageActivity.this.MxZ == null) {
                    return false;
                }
                TTPlayableLandingPageActivity.this.MxZ.sc(motionEvent);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql() {
        TTAdDislikeToast tTAdDislikeToast = this.pFF;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    private void SR() {
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(this, this.cvk, "embeded_ad", this.uEA) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.pFF.sc, com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
            public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
                Sfl sfl = ((com.bytedance.sdk.openadsdk.core.pFF.pFF) this).TRI;
                if (sfl == null || sfl.YIK() != 1 || z11) {
                    super.sc(view, f11, f12, f13, f14, sparseArray, z11);
                    TTPlayableLandingPageActivity.this.McK = true;
                    TTPlayableLandingPageActivity.this.HJN = true;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.JPJ);
                    } catch (JSONException e11) {
                        Tf.sc("TTPWPActivity", "onClick JSON ERROR", e11);
                    }
                    com.bytedance.sdk.openadsdk.We.zY.pFF(TTPlayableLandingPageActivity.this.cvk, ((com.bytedance.sdk.openadsdk.core.pFF.pFF) this).f28460qr, "click_playable_download_button_loading", jSONObject);
                }
            }
        };
        scVar.sc(this.Gb);
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar2 = this.Yhz;
        if (scVar2 != null) {
            scVar2.sc(scVar);
        }
    }

    private void TRI() {
        if (this.cvk.QLv() == 4) {
            this.Gb = com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(this.Ql, this.cvk, "interaction");
        }
    }

    private void Tf() {
        TTAdDislikeToast tTAdDislikeToast = this.pFF;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
        }
    }

    private void UFX() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.cvk);
        this.GI = new com.bytedance.sdk.openadsdk.We.Xc(3, "embeded_ad", this.cvk);
        this.YIK = new HJN(this);
        this.YIK.pFF(this.ExN).sc(this.cvk).sc(arrayList).zY(this.wjp).We(this.Sfl).pFF("embeded_ad").pFF(this.uEA).sc(this).sc(this.GI).sc(this.We).sc(this.ExN).ExN(this.cvk.BU());
        ExN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WH() {
        if (this.cD.getAndSet(true)) {
            return;
        }
        if (!JPJ.JPJ(this.cvk) || (this.Qj && this.TRI)) {
            com.bytedance.sdk.component.Ol.We we2 = this.ExN;
            if (we2 == null || this.dE == null) {
                return;
            }
            kX.sc((View) we2, 0);
            kX.sc((View) this.dE, 8);
            return;
        }
        if (this.Xc == null || this.dE == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(this, this.cvk, "embeded_ad", this.uEA);
        scVar.sc(this.Gb);
        this.Xc.sc(this.cvk, "embeded_ad", scVar);
        kX.sc((View) this.Xc, 0);
        kX.sc((View) this.dE, 8);
        kX.sc((View) this.Tf, 8);
    }

    private View We() {
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(this);
        zYVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.yL) {
            this.Yhz = new com.bytedance.sdk.openadsdk.Sfl.sc.sc(this.Ql, this.cvk, this.f27552eo, this.f27553pc, zYVar, true);
        } else {
            this.ExN = new com.bytedance.sdk.component.Ol.We(this);
            this.ExN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.ExN.setVisibility(4);
            this.BT = new com.bytedance.sdk.openadsdk.core.ExN.TRI(this, null, R.style.Widget.ProgressBar.Horizontal);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, kX.zY(this, 3.0f));
            layoutParams.gravity = 49;
            this.BT.setLayoutParams(layoutParams);
            this.BT.setProgress(1);
            this.BT.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(this, "tt_browser_progress_style"));
            this.dE = new com.bytedance.sdk.openadsdk.core.widget.UFX(this);
            this.dE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.dE.setClickable(true);
            this.dE.setFocusable(true);
            this.Xc = new WH(this);
            this.Xc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        this.Tf = new SR(this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(kX.zY(this, 28.0f), kX.zY(this, 28.0f));
        layoutParams2.leftMargin = kX.zY(this, 12.0f);
        layoutParams2.topMargin = kX.zY(this, 20.0f);
        this.Tf.setLayoutParams(layoutParams2);
        this.Tf.setScaleType(ImageView.ScaleType.CENTER);
        this.Tf.setImageDrawable(com.bytedance.sdk.openadsdk.utils.Ol.sc(this, "tt_unmute_wrapper"));
        this.UFX = new BT(this);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, kX.zY(this, 28.0f));
        layoutParams3.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams3.leftMargin = kX.zY(this, 16.0f);
        layoutParams3.rightMargin = kX.zY(this, 80.0f);
        layoutParams3.topMargin = kX.zY(this, 20.0f);
        this.UFX.setLayoutParams(layoutParams3);
        this.UFX.setGravity(17);
        this.UFX.setText(com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_reward_feedback"));
        this.UFX.setTextColor(-1);
        this.UFX.setTextSize(14.0f);
        this.WH = new com.bytedance.sdk.openadsdk.core.ExN.qr(this);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(kX.zY(this, 28.0f), kX.zY(this, 28.0f));
        layoutParams4.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams4.topMargin = kX.zY(this, 20.0f);
        layoutParams4.rightMargin = kX.zY(this, 24.0f);
        this.WH.setLayoutParams(layoutParams4);
        this.WH.setBackground(com.bytedance.sdk.openadsdk.utils.Ol.sc(this, "tt_mute_btn_bg"));
        this.WH.setGravity(17);
        this.WH.setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(this);
        we2.setLayoutParams(new RelativeLayout.LayoutParams(kX.zY(this, 12.0f), kX.zY(this, 12.0f)));
        we2.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this, "tt_video_close_drawable"));
        we2.setVisibility(0);
        this.WH.addView(we2);
        if (!this.yL) {
            zYVar.addView(this.ExN);
            zYVar.addView(this.BT);
            zYVar.addView(this.Xc);
            zYVar.addView(this.dE);
        }
        zYVar.addView(this.Tf);
        zYVar.addView(this.UFX);
        zYVar.addView(this.WH);
        return zYVar;
    }

    private void qr() {
        int i11 = Xc.We().II(String.valueOf(this.cvk.QT())).Xc;
        if (i11 >= 0) {
            this.II.sendEmptyMessageDelayed(1, ((long) i11) * 1000);
        } else {
            kX.sc((View) this.WH, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message sc(int i11, int i12) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i11;
        if (i11 == 3) {
            messageObtain.arg2 = i12;
        }
        return messageObtain;
    }

    private void sc(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.SR = intent.getIntExtra("sdk_version", 1);
            this.wjp = intent.getStringExtra("adid");
            this.Sfl = intent.getStringExtra("log_extra");
            this.uEA = intent.getIntExtra("source", -1);
            this.McK = intent.getBooleanExtra("ad_pending_download", false);
            this.JPJ = intent.getStringExtra("url");
            this.Cb = intent.getStringExtra("gecko_id");
            this.FI = intent.getStringExtra("web_title");
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.cvk = com.bytedance.sdk.openadsdk.core.pFF.sc(new JSONObject(stringExtra));
                    } catch (Exception e11) {
                        Tf.sc("TTPWPActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e11);
                    }
                }
            } else {
                this.cvk = com.bytedance.sdk.openadsdk.core.FI.sc().pFF();
                com.bytedance.sdk.openadsdk.core.FI.sc().TRI();
            }
        }
        if (bundle != null) {
            try {
                this.SR = bundle.getInt("sdk_version", 1);
                this.wjp = bundle.getString("adid");
                this.Sfl = bundle.getString("log_extra");
                this.uEA = bundle.getInt("source", -1);
                this.McK = bundle.getBoolean("ad_pending_download", false);
                this.JPJ = bundle.getString("url");
                this.FI = bundle.getString("web_title");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.cvk = com.bytedance.sdk.openadsdk.core.pFF.sc(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.cvk == null) {
            Tf.sc("TTPWPActivity", "material is null, no data to display");
            finish();
        } else {
            try {
                this.f27553pc = Xc.We().Xc(this.cvk.Cb().getCodeId());
            } catch (Throwable th2) {
                Tf.sc("TTPWPActivity", th2.getMessage());
            }
        }
    }

    private void sc(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(this.Ql).sc(false).pFF(false).sc(we2.getWebView());
        we2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we2.getWebView(), this.SR));
        we2.setMixedContentMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str) {
        com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), this.cvk, "embeded_ad", str);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.GI;
        if (exN != null) {
            exN.Qj();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onCreate(@Nullable Bundle bundle) {
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar;
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.SR.ExN()) {
            finish();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            Xc.pFF(this);
        } catch (Throwable unused) {
        }
        sc(bundle);
        Sfl sfl = this.cvk;
        if (sfl == null) {
            return;
        }
        this.yL = sfl.nW();
        int iXc = JPJ.Xc(this.cvk);
        if (iXc == 0) {
            setRequestedOrientation(14);
        } else if (iXc == 1) {
            setRequestedOrientation(1);
        } else if (iXc == 2) {
            setRequestedOrientation(0);
            this.f27552eo = 2;
        }
        this.Ql = this;
        try {
            setContentView(We());
            Ol();
            TRI();
            if (this.yL) {
                SR();
                this.Yhz.sc(false, (com.bytedance.sdk.openadsdk.Tf.ExN) null);
            } else {
                sc();
                UFX();
                if (!TextUtils.isEmpty(this.Cb)) {
                    this.qKn = com.bytedance.sdk.openadsdk.qr.pFF.sc().pFF();
                    int iSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.qKn, this.Cb);
                    this.BR = iSc;
                    this.JoC = iSc > 0 ? 2 : 0;
                }
                Qj();
                com.bytedance.sdk.openadsdk.We.We.ExN exN = this.GI;
                if (exN != null) {
                    exN.qr();
                }
            }
            qr();
            com.bytedance.sdk.openadsdk.We.zY.sc.sc(SystemClock.elapsedRealtime() - jElapsedRealtime, this.cvk, "embeded_ad", this.qKn, this.Cb);
            if (!this.yL || (scVar = this.Yhz) == null) {
                return;
            }
            scVar.sc();
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Yhz;
        if (scVar != null) {
            scVar.We();
        }
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.GI;
        if (exN != null) {
            exN.sc(true);
            this.GI.Tf();
        }
        this.II.removeCallbacksAndMessages(null);
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.Cb)) {
            com.bytedance.sdk.openadsdk.We.zY.sc.sc(this.cJ.get(), this.OXF.get(), this.cvk);
        }
        com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.qKn);
        com.bytedance.sdk.component.Ol.We we2 = this.ExN;
        if (we2 != null) {
            Cb.sc(we2.getWebView());
            this.ExN.Tf();
        }
        this.ExN = null;
        HJN hjn = this.YIK;
        if (hjn != null) {
            hjn.UFX();
        }
        HJN hjn2 = this.Dl;
        if (hjn2 != null) {
            hjn2.UFX();
        }
        Qj qj2 = this.CYO;
        if (qj2 != null) {
            qj2.cJ();
        }
        UFX ufx = this.MxZ;
        if (ufx != null) {
            ufx.zY(true);
        }
        WP wp2 = this.f27554sc;
        if (wp2 != null) {
            wp2.pFF();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        HJN hjn = this.YIK;
        if (hjn != null) {
            hjn.pFF(false);
        }
        Qj qj2 = this.CYO;
        if (qj2 != null) {
            qj2.sc(true);
            this.CYO.zY(false);
        }
        DeviceUtils.AudioInfoReceiver.pFF((qr) this);
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Yhz;
        if (scVar != null) {
            scVar.zY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        HJN hjn = this.YIK;
        if (hjn != null) {
            hjn.WH();
            com.bytedance.sdk.component.Ol.We we2 = this.ExN;
            if (we2 != null) {
                this.YIK.pFF(we2.getVisibility() == 0);
            }
        }
        HJN hjn2 = this.Dl;
        if (hjn2 != null) {
            hjn2.WH();
        }
        Qj qj2 = this.CYO;
        if (qj2 != null) {
            qj2.zY(true);
        }
        UFX ufx = this.MxZ;
        if (ufx != null) {
            ufx.qr();
        }
        DeviceUtils.AudioInfoReceiver.sc((qr) this);
        if (DeviceUtils.qr() == 0) {
            this.f27553pc = true;
        }
        zY(this.f27553pc);
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Yhz;
        if (scVar != null) {
            scVar.pFF();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            Sfl sfl = this.cvk;
            bundle.putString("material_meta", sfl != null ? sfl.JP().toString() : null);
            bundle.putInt("sdk_version", this.SR);
            bundle.putString("adid", this.wjp);
            bundle.putString("log_extra", this.Sfl);
            bundle.putInt("source", this.uEA);
            bundle.putBoolean("ad_pending_download", this.McK);
            bundle.putString("url", this.JPJ);
            bundle.putString("web_title", this.FI);
            bundle.putString("event_tag", "embeded_ad");
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.GI;
        if (exN != null) {
            exN.WH();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.GI;
        if (exN != null) {
            exN.Ol();
        }
        UFX ufx = this.MxZ;
        if (ufx != null) {
            ufx.Qj();
        }
    }

    public void pFF() {
        if (this.cvk == null || isFinishing()) {
            return;
        }
        if (this.zY.get()) {
            Tf();
            return;
        }
        if (this.f27554sc == null) {
            zY();
        }
        this.f27554sc.sc(new WP.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.WP.sc
            public void sc() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.WP.sc
            public void sc(int i11, String str) {
                if (TTPlayableLandingPageActivity.this.zY.get() || TextUtils.isEmpty(str)) {
                    return;
                }
                TTPlayableLandingPageActivity.this.zY.set(true);
                TTPlayableLandingPageActivity.this.Ql();
            }
        });
        WP wp2 = this.f27554sc;
        if (wp2 != null) {
            wp2.sc();
        }
    }

    public void sc() {
        if (this.dE == null) {
            return;
        }
        Sfl sfl = this.cvk;
        if (sfl != null && !JPJ.SR(sfl)) {
            this.dE.zY();
            return;
        }
        this.dE.pFF(this.cvk, this.f27552eo);
        if (this.dE.getDownloadButton() != null) {
            com.bytedance.sdk.openadsdk.core.pFF.sc scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(this, this.cvk, "embeded_ad", this.uEA) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.pFF.sc, com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
                public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
                    Sfl sfl2 = ((com.bytedance.sdk.openadsdk.core.pFF.pFF) this).TRI;
                    if (sfl2 == null || sfl2.YIK() != 1 || z11) {
                        super.sc(view, f11, f12, f13, f14, sparseArray, z11);
                        TTPlayableLandingPageActivity.this.McK = true;
                        TTPlayableLandingPageActivity.this.HJN = true;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.JPJ);
                        } catch (JSONException e11) {
                            Tf.sc("TTPWPActivity", "onClick JSON ERROR", e11);
                        }
                        com.bytedance.sdk.openadsdk.We.zY.pFF(TTPlayableLandingPageActivity.this.cvk, ((com.bytedance.sdk.openadsdk.core.pFF.pFF) this).f28460qr, "click_playable_download_button_loading", jSONObject);
                    }
                }
            };
            scVar.sc(this.Gb);
            this.dE.getDownloadButton().setOnClickListener(scVar);
        }
        if (JPJ.dE(this.cvk)) {
            this.II.sendMessageDelayed(sc(2, JPJ.sc(2)), JPJ.Dl(this.cvk));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Tf.qr
    public void sc(int i11) {
        zY(i11 <= 0);
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            kX.sc((View) this.WH, 0);
            return;
        }
        if (i11 != 2) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.UFX ufx = this.dE;
        if (ufx == null || !ufx.We()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                int i12 = message.arg2;
                if (i12 != 0) {
                    jSONObject.put("remove_loading_page_reason", i12);
                }
                jSONObject.put("playable_url", this.JPJ);
                com.bytedance.sdk.openadsdk.core.widget.UFX ufx2 = this.dE;
                jSONObject.put("duration", ufx2 != null ? ufx2.getDisplayDuration() : 0L);
            } catch (JSONException e11) {
                Tf.sc("TTPWPActivity", "handleMsg json error", e11);
            }
            com.bytedance.sdk.openadsdk.We.zY.pFF(this.cvk, "embeded_ad", "remove_loading_page", jSONObject);
            this.II.removeMessages(2);
            com.bytedance.sdk.openadsdk.core.widget.UFX ufx3 = this.dE;
            if (ufx3 != null) {
                ufx3.zY();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.We
    public void sc(boolean z11) {
        com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri;
        this.McK = true;
        this.HJN = z11;
        if (!z11) {
            try {
                Toast.makeText(this.Ql, "Download later", 0).show();
            } catch (Throwable unused) {
            }
        }
        if (!this.HJN || (tri = this.Gb) == null) {
            return;
        }
        tri.We();
    }

    public void zY() {
        Sfl sfl = this.cvk;
        if (sfl != null) {
            this.f27554sc = new com.bytedance.sdk.openadsdk.zY.zY(this, sfl.mD(), this.cvk.IEI(), this.cvk.JP().toString(), "playable");
        }
        if (this.pFF == null) {
            this.pFF = new TTAdDislikeToast(this);
            ((FrameLayout) findViewById(R.id.content)).addView(this.pFF);
        }
    }

    public void zY(boolean z11) {
        try {
            this.f27553pc = z11;
            this.Tf.setImageDrawable(z11 ? com.bytedance.sdk.openadsdk.utils.Ol.sc(this.Ql, "tt_mute_wrapper") : com.bytedance.sdk.openadsdk.utils.Ol.sc(this.Ql, "tt_unmute_wrapper"));
            Qj qj2 = this.CYO;
            if (qj2 != null) {
                qj2.sc(z11);
            }
            com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Yhz;
            if (scVar != null) {
                scVar.sc(z11);
            }
        } catch (Exception e11) {
            Tf.sc("TTPWPActivity", e11.getMessage());
        }
    }
}
