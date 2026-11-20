package com.bytedance.sdk.openadsdk.core.Qj;

import android.R;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cD;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class JPJ extends com.bytedance.sdk.component.adexpress.ExN.sc {
    private HJN BT;
    private final Runnable Dl;
    private com.bytedance.sdk.openadsdk.core.model.Sfl Ol;
    private String Qj;
    private com.bytedance.sdk.openadsdk.We.UFX Ql;
    private final Map<String, com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI> SR;
    private WH Sfl;
    com.bytedance.sdk.openadsdk.utils.sc TRI;
    private String Tf;
    private com.bytedance.sdk.openadsdk.We.We.ExN UFX;
    private JSONObject WH;
    private com.bytedance.sdk.openadsdk.core.model.Sfl.sc Xc;
    private final com.bytedance.sdk.component.Qj.Qj YIK;
    private com.bytedance.sdk.component.adexpress.pFF.qr dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Context f28053qr;
    private volatile int wjp;

    public JPJ(Context context, com.bytedance.sdk.component.adexpress.pFF.Ql ql2, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.We.We.ExN exN, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        super(context, ql2, themeStatusBroadcastReceiver);
        this.SR = Collections.synchronizedMap(new HashMap());
        this.wjp = 0;
        this.YIK = new com.bytedance.sdk.component.Qj.Qj("webviewrender_template") { // from class: com.bytedance.sdk.openadsdk.core.Qj.JPJ.1
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.component.adexpress.ExN.sc) JPJ.this).ExN.get()) {
                    return;
                }
                if ((JPJ.this.Ol instanceof com.bytedance.sdk.openadsdk.core.model.YIK) && ((com.bytedance.sdk.openadsdk.core.model.YIK) JPJ.this.Ol).Kv()) {
                    JPJ.this.pFF(true);
                }
                JPJ jpj = JPJ.this;
                jpj.WH = jpj.UFX().zY();
                JPJ jpj2 = JPJ.this;
                jpj2.sc(jpj2.WH);
                if (JPJ.this.wjp == 0) {
                    JPJ.this.Xc();
                }
                com.bytedance.sdk.openadsdk.core.SR.zY().post(JPJ.this.Dl);
            }
        };
        this.Dl = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.JPJ.2
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.component.adexpress.ExN.sc) JPJ.this).ExN.get() || JPJ.this.dE == null) {
                    return;
                }
                JPJ.this.Tf();
                JPJ jpj = JPJ.this;
                JPJ.super.sc(jpj.dE);
            }
        };
        if (this.zY == null) {
            return;
        }
        this.f28053qr = context;
        this.Qj = ql2.We();
        this.Ol = sfl;
        this.UFX = exN;
        themeStatusBroadcastReceiver.sc(this);
        Xc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (this.zY.getWebView() != null && Cb.ExN()) {
            wjp();
        } else {
            this.wjp = 1;
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.JPJ.3
                @Override // java.lang.Runnable
                public void run() {
                    JPJ.this.wjp();
                }
            });
        }
    }

    public static boolean pFF(String str) {
        return "banner_call".equals(str) || "banner_ad".equals(str) || "slide_banner_ad".equals(str) || "banner_ad_landingpage".equals(str);
    }

    public static String sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return com.bytedance.sdk.component.adexpress.sc.pFF.pFF.We((sfl == null || !sfl.CYO()) ? null : "v3");
    }

    private void sc(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(this.f28053qr).sc(false).sc(we2.getWebView());
            we2.setVerticalScrollBarEnabled(false);
            we2.setHorizontalScrollBarEnabled(false);
            com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(we2);
            we2.WH();
            we2.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we2.getWebView(), BuildConfig.VERSION_CODE));
            we2.setMixedContentMode(0);
            we2.setJavaScriptEnabled(true);
            we2.setJavaScriptCanOpenWindowsAutomatically(true);
            we2.setDomStorageEnabled(true);
            we2.setDatabaseEnabled(true);
            we2.setAllowFileAccess(false);
            we2.setSupportZoom(true);
            we2.setBuiltInZoomControls(true);
            we2.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            we2.setUseWideViewPort(true);
            we2.setCacheMode(-1);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.WebViewRender", e11.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wjp() {
        com.bytedance.sdk.component.Ol.We we2 = this.zY;
        if (we2 == null || we2.getWebView() == null || this.wjp == 2) {
            return;
        }
        this.Tf = sc(this.Ol);
        this.zY.setDisplayZoomControls(false);
        sc(cD.sc(this.Tf));
        Ql();
        HJN hjn = new HJN(this.f28053qr);
        this.BT = hjn;
        hjn.We(true);
        SR();
        this.wjp = 2;
    }

    private void zY(boolean z11) {
        if (this.BT == null || this.zY == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z11);
            this.BT.sc("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public WH BT() {
        return this.Sfl;
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public void Ol() {
        super.Ol();
        com.bytedance.sdk.openadsdk.utils.sc scVarExN = com.bytedance.sdk.openadsdk.core.BT.sc().ExN();
        this.TRI = scVarExN;
        scVarExN.sc(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public void Qj() {
        super.Qj();
        if (this.BT == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.BT.sc("expressShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void Ql() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.Ol;
        if (sfl == null || sfl.JoC() == null) {
            return;
        }
        this.Xc = this.Ol.JoC();
    }

    public void SR() {
        com.bytedance.sdk.component.Ol.We we2 = this.zY;
        if (we2 == null || we2.getWebView() == null) {
            return;
        }
        this.zY.setBackgroundColor(0);
        this.zY.setBackgroundResource(R.color.transparent);
        sc(this.zY);
        if (sc() != null) {
            this.Ql = new com.bytedance.sdk.openadsdk.We.UFX(this.Ol, sc().getWebView()).sc(false);
        }
        this.Ql.sc(this.UFX);
        WH wh2 = new WH(this.f28053qr, this.BT, this.Ol, this.Ql, UFX());
        this.Sfl = wh2;
        this.zY.setWebViewClient(wh2);
        this.zY.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.BT, this.Ql));
        com.bytedance.sdk.component.adexpress.ExN.ExN.sc().sc(this.zY, this.BT);
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public void TRI() {
        if (sc() == null) {
            return;
        }
        try {
            sc().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void Tf() {
        HJN hjn;
        com.bytedance.sdk.component.Ol.We we2 = this.zY;
        if (we2 == null || we2.getWebView() == null || (hjn = this.BT) == null) {
            return;
        }
        hjn.pFF(this.zY).sc(this.Ol).zY(this.Ol.kDg()).We(this.Ol.mD()).pFF(cJ.sc(this.Qj)).ExN(this.Ol.BU()).sc(this).sc(this.WH).sc(this.zY).sc(this.UFX);
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public void WH() {
        super.WH();
        com.bytedance.sdk.openadsdk.utils.sc scVar = this.TRI;
        if (scVar != null) {
            scVar.pFF(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public void We() {
        if (this.ExN.get()) {
            return;
        }
        super.We();
        HJN hjn = this.BT;
        if (hjn != null) {
            hjn.pFF();
            this.BT.UFX();
            this.BT = null;
        }
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.Ql;
        if (ufx != null) {
            ufx.zY(false);
        }
        com.bytedance.sdk.openadsdk.core.SR.zY().removeCallbacks(this.Dl);
        this.SR.clear();
    }

    public HJN dE() {
        return this.BT;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.sc
    public void onThemeChanged(int i11) {
        if (this.BT == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i11);
        } catch (JSONException unused) {
        }
        this.BT.sc("themeChange", jSONObject);
    }

    public void pFF(int i11) {
        if (this.BT == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("zoom_type", i11);
            this.BT.sc("expressAdViewWillZoom", jSONObject);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.WebViewRender", e11.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public void qr() {
        HJN hjn = this.BT;
        if (hjn == null) {
            return;
        }
        hjn.sc("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public com.bytedance.sdk.component.Ol.We sc() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc
    public void sc(int i11) {
        if (i11 == this.We) {
            return;
        }
        this.We = i11;
        zY(i11 == 0);
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc, com.bytedance.sdk.component.adexpress.pFF.UFX
    public void sc(com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        super.sc(sr2);
        if (this.pFF) {
            com.bytedance.sdk.component.utils.qr.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.JPJ.4
                @Override // java.lang.Runnable
                public void run() {
                    WebView webView = ((com.bytedance.sdk.component.adexpress.ExN.sc) JPJ.this).zY.getWebView();
                    if (webView != null) {
                        webView.resumeTimers();
                    }
                }
            }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc, com.bytedance.sdk.component.adexpress.pFF.We
    public void sc(com.bytedance.sdk.component.adexpress.pFF.qr qrVar) {
        this.dE = qrVar;
        Cb.pFF(this.YIK);
    }

    @Override // com.bytedance.sdk.component.adexpress.ExN.sc, com.bytedance.sdk.component.adexpress.pFF.We
    public int zY() {
        return this.Ol.cvk();
    }
}
