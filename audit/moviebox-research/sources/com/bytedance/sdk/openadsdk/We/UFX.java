package com.bytedance.sdk.openadsdk.We;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX {
    private static final int[] pFF = {10, 30, 50, 75, 100};
    private volatile long BR;
    private com.bytedance.sdk.openadsdk.core.widget.sc.TRI BT;
    private final AtomicInteger CYO;
    private boolean Cb;
    private final Sfl Dl;
    private int ExN;
    private long FI;
    private int GI;
    private final AtomicInteger Gb;
    private final boolean HJN;
    private long II;
    private long JPJ;
    private final AtomicInteger JoC;
    private boolean McK;
    private volatile long MxZ;
    private final AtomicBoolean OKY;
    private com.bytedance.sdk.openadsdk.We.We.ExN OXF;
    private final AtomicBoolean Ol;
    private volatile long QLv;
    private final AtomicBoolean Qj;
    private String Ql;
    private final Context SR;
    private boolean Sfl;
    private final AtomicBoolean TRI;
    private String Tf;
    private boolean UFX;
    private int WH;
    private long WP;
    private long We;
    private com.bytedance.sdk.openadsdk.Sfl.Qj Xc;
    private int YIK;
    private String Yhz;
    private WeakReference<WebView> cD;
    private boolean cJ;
    private long cvk;
    private boolean dE;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private volatile long f27329eo;
    private WH kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private String f27330ko;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private volatile int f27331pc;
    private final AtomicBoolean qKn;
    private long qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final AtomicBoolean f27332qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc f27333sc;
    private String uEA;
    private Qj wjp;
    private final AtomicBoolean yL;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public class sc {
        private sc() {
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i11 = 0;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i11 = 100;
                } else if (iIntValue >= 0) {
                    i11 = iIntValue;
                }
            } catch (Throwable unused) {
            }
            UFX.this.Gb.set(i11);
        }
    }

    public UFX(Sfl sfl, WebView webView) {
        this(sfl, webView, false);
    }

    public UFX(Sfl sfl, WebView webView, WH wh2, int i11) {
        this(sfl, webView);
        this.kX = wh2;
        this.GI = i11;
    }

    public UFX(Sfl sfl, WebView webView, boolean z11) {
        this.zY = 0;
        this.We = -1L;
        this.ExN = 1;
        this.TRI = new AtomicBoolean(false);
        this.f27332qr = new AtomicBoolean(false);
        this.Qj = new AtomicBoolean(false);
        this.Ol = new AtomicBoolean(false);
        this.WH = -1;
        this.Sfl = false;
        this.uEA = "landingpage";
        this.JPJ = 0L;
        this.FI = 0L;
        this.WP = 0L;
        this.cvk = 0L;
        this.II = 0L;
        this.McK = false;
        this.HJN = false;
        this.Gb = new AtomicInteger(0);
        this.Cb = false;
        this.cJ = false;
        this.BR = 0L;
        this.JoC = new AtomicInteger(0);
        this.CYO = new AtomicInteger(0);
        this.qKn = new AtomicBoolean(false);
        this.f27331pc = 0;
        this.GI = -1;
        this.yL = new AtomicBoolean(false);
        this.OKY = new AtomicBoolean(false);
        Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
        this.SR = contextSc;
        this.Dl = sfl;
        if (webView == null) {
            return;
        }
        this.Sfl = z11;
        WeakReference<WebView> weakReference = new WeakReference<>(webView);
        this.cD = weakReference;
        WebView webView2 = weakReference.get();
        if (webView2 == null) {
            return;
        }
        if (sfl != null && sfl.eo()) {
            com.bytedance.sdk.openadsdk.core.widget.sc.TRI tri = new com.bytedance.sdk.openadsdk.core.widget.sc.TRI(webView2, sfl, contextSc, this.Sfl);
            this.BT = tri;
            this.f27333sc = tri.zY();
        }
        if (sfl != null && sfl.yL() && com.bytedance.sdk.openadsdk.core.settings.dE.ef().vYl()) {
            this.wjp = new Qj(sfl, webView, this.Sfl);
        }
        if (webView instanceof com.bytedance.sdk.component.Ol.zY) {
            this.qfG = ((com.bytedance.sdk.component.Ol.zY) webView2).f26552sc;
        } else {
            this.qfG = System.currentTimeMillis();
        }
        try {
            webView2.addJavascriptInterface(new sc(), "JS_LANDING_PAGE_LOG_OBJ");
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("LandingPageLog", "addJavascriptInterface exception", e11);
        }
        if (sfl != null && sfl.jxU() != null) {
            this.We = sfl.jxU().optLong("page_id", -1L);
        }
        this.f27330ko = String.valueOf(SystemClock.elapsedRealtime());
    }

    private boolean Ol() {
        Sfl sfl;
        return this.cJ && (sfl = this.Dl) != null && sfl.JK();
    }

    private int WH() {
        WeakReference<WebView> weakReference = this.cD;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
                if (webBackForwardListCopyBackForwardList != null && webBackForwardListCopyBackForwardList.getCurrentIndex() == 0) {
                    return 1;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i11, String str) {
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.qr.pFF)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb2 = new StringBuilder(com.bytedance.sdk.openadsdk.core.settings.qr.pFF);
            jSONObject.putOpt(BidResponsedEx.KEY_CID, sc().kDg());
            jSONObject.putOpt("ad_id", sc().kDg());
            jSONObject.put("log_extra", sc().mD());
            cJ.sc(sb2, "\"/** adInfo **/\"", jSONObject.toString());
            cJ.sc(sb2, "\"/** first_page **/\"", String.valueOf(i11));
            cJ.sc(sb2, "\"/** ix_to_externalurl **/\"", this.We != -1 ? "1" : "0");
            cJ.sc(sb2, "\"/** preload_status **/\"", this.GI == 2 ? "2" : "0");
            cJ.sc(sb2, "\"/** scene_state **/\"", str);
            cJ.sc(sb2, "\"/** web_init_time **/\"", String.valueOf(this.qfG));
            cJ.sc(sb2, "\"/** channel_name **/\"", "\"" + sc().PPh() + "\"");
            cJ.sc(sb2, "\"/** session_id **/\"", "\"" + UUID.randomUUID().toString() + "\"");
            cJ.sc(sb2, "\"/** web_url **/\"", "\"" + sc().ko() + "\"");
            String string = sb2.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            final String strZY = zY(string);
            WeakReference<WebView> weakReference = this.cD;
            final WebView webView = weakReference != null ? weakReference.get() : null;
            if (TextUtils.isEmpty(strZY) || webView == null) {
                return;
            }
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.We.UFX.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.UFX.sc(webView, strZY);
                }
            });
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
        }
    }

    private void sc(String str, String str2, long j11) {
        if (this.Qj.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (str.length() > 200) {
                    int iIndexOf = str.indexOf(38, 200);
                    int i11 = LogSeverity.NOTICE_VALUE;
                    if (iIndexOf == -1 || iIndexOf > 300) {
                        iIndexOf = str.indexOf(63);
                    }
                    if (iIndexOf != -1 && iIndexOf <= 300) {
                        i11 = iIndexOf;
                    }
                    str = str.substring(0, i11);
                }
                jSONObject.put("url", str);
                jSONObject.put("type", str2);
            } catch (Throwable unused) {
            }
            sc("load_finish_progress", jSONObject, j11);
        }
    }

    private void sc(String str, JSONObject jSONObject) {
        sc(str, jSONObject, -1L);
    }

    private void sc(final String str, final JSONObject jSONObject, final long j11) {
        if (!this.Cb || this.Dl == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.Sfl.Qj qj2 = this.Xc;
        final int iKX = qj2 != null ? qj2.kX() : -1;
        zY.sc(System.currentTimeMillis(), this.Dl, this.uEA, str, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.UFX.1
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    boolean zPFF = JPJ.pFF(UFX.this.Dl);
                    int i11 = 0;
                    jSONObject.put("is_playable", zPFF ? 1 : 0);
                    jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.Ql.zY.sc.sc().sc(UFX.this.Dl) ? 1 : 0);
                    if (zPFF && ("load_finish".equals(str) || "load_fail".equals(str))) {
                        jSONObject.put("playable_has_show", iKX);
                    }
                    if ("stay_page".equals(str)) {
                        JSONObject jSONObject2 = jSONObject;
                        if (UFX.this.YIK <= 1) {
                            i11 = 1;
                        }
                        jSONObject2.put("first_page", i11);
                    }
                } catch (JSONException unused) {
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("ad_extra_data", jSONObject.toString());
                        long j12 = j11;
                        if (j12 > 0) {
                            jSONObject3.put("duration", j12);
                        }
                    } catch (JSONException unused2) {
                    }
                    return jSONObject3;
                } catch (JSONException unused3) {
                    return null;
                }
            }
        });
    }

    private void sc(boolean z11, final String str) {
        if (z11) {
            final int iWH = WH();
            zY.sc(new com.bytedance.sdk.component.Qj.Qj("sendPrefLog") { // from class: com.bytedance.sdk.openadsdk.We.UFX.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.openadsdk.core.settings.qr qrVarWP = com.bytedance.sdk.openadsdk.core.Xc.We().WP();
                        boolean zSc = UFX.this.sc(qrVarWP, str);
                        if (zSc) {
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.qr.pFF)) {
                                UFX.this.sc(iWH, str);
                                return;
                            }
                            if (TextUtils.isEmpty(qrVarWP.zY) || !zSc) {
                                return;
                            }
                            String str2 = qrVarWP.zY;
                            com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
                            pffZY.pFF(str2);
                            HashMap map = new HashMap();
                            map.put("content-type", "application/json; charset=utf-8");
                            pffZY.We(map);
                            pffZY.sc(9);
                            pffZY.sc("sendPrefLog");
                            pffZY.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.We.UFX.2.1
                                @Override // com.bytedance.sdk.component.qr.sc.sc
                                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                                    try {
                                        com.bytedance.sdk.openadsdk.core.settings.qr.pFF = pff.We();
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        UFX.this.sc(iWH, str);
                                    } catch (Exception e11) {
                                        com.bytedance.sdk.component.utils.Tf.sc("LandingPageLog", "TTWebViewClient : onPageFinished", e11);
                                    }
                                }

                                @Override // com.bytedance.sdk.component.qr.sc.sc
                                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                                }
                            });
                        }
                    } catch (Throwable th2) {
                        com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(com.bytedance.sdk.openadsdk.core.settings.qr qrVar, String str) {
        str.hashCode();
        switch (str) {
            case "0":
                return qrVar.We;
            case "1":
                return qrVar.ExN;
            case "2":
                return qrVar.TRI;
            default:
                return false;
        }
    }

    private String zY(String str) {
        return "javascript:".concat(String.valueOf(str));
    }

    public void ExN() {
        if (Ol()) {
            this.QLv = SystemClock.elapsedRealtime();
            TRI();
        }
    }

    public void Qj() {
        if (("landingpage".equals(this.uEA) || "landingpage_endcard".equals(this.uEA) || "landingpage_split_screen".equals(this.uEA) || "landingpage_direct".equals(this.uEA) || "aggregate_page".equals(this.uEA)) && this.ExN == 2) {
            if (this.FI > 0 || !zY()) {
                long jCurrentTimeMillis = System.currentTimeMillis() - Math.max(this.JPJ, this.FI);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_status", this.ExN);
                    jSONObject.put("max_scroll_percent", this.Gb.get());
                    jSONObject.put("jump_times", this.JoC.getAndSet(0));
                    jSONObject.put("click_times", this.CYO.getAndSet(0));
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                this.Ol.set(true);
                sc("stay_page", jSONObject, Math.min(jCurrentTimeMillis, TTAdConstant.AD_MAX_EVENT_TIME));
                com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("landingPause", this.Dl, this.f27330ko);
            }
        }
    }

    public void TRI() {
        if (Ol() && this.QLv > 0 && this.f27329eo > 0 && !this.yL.getAndSet(true)) {
            zY.pFF(this.f27329eo - this.QLv, this.Dl, this.Yhz, (String) null);
        }
    }

    public void We() {
        if (Ol()) {
            this.MxZ = SystemClock.elapsedRealtime();
            zY.sc(this.Dl, this.Yhz);
        }
    }

    public com.bytedance.sdk.openadsdk.We.We.ExN pFF() {
        return this.OXF;
    }

    public void pFF(int i11) {
        com.bytedance.sdk.openadsdk.core.widget.sc.TRI tri = this.BT;
        if (tri == null || !this.dE) {
            return;
        }
        tri.sc(i11);
    }

    public void pFF(WebView webView, String str, boolean z11) {
        Qj qj2 = this.wjp;
        if (qj2 == null || !z11) {
            return;
        }
        qj2.sc(webView, str);
    }

    public void pFF(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Yhz = str;
    }

    public void pFF(boolean z11) {
        this.cJ = z11;
    }

    public void qr() {
        if (this.II == 0) {
            this.II = System.currentTimeMillis();
        }
        this.JPJ = System.currentTimeMillis();
        if ("landingpage".equals(this.uEA) || "landingpage_endcard".equals(this.uEA) || "landingpage_split_screen".equals(this.uEA) || "landingpage_direct".equals(this.uEA) || "aggregate_page".equals(this.uEA)) {
            if (this.OKY.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("landingStart", this.Dl, this.f27330ko);
            } else {
                com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("landingContinue", this.Dl, this.f27330ko);
            }
        }
    }

    public UFX sc(boolean z11) {
        this.Cb = z11;
        return this;
    }

    public Sfl sc() {
        return this.Dl;
    }

    public void sc(int i11) {
        this.GI = i11;
    }

    public void sc(long j11) {
        this.FI = j11;
    }

    public void sc(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.widget.sc.TRI tri = this.BT;
        if (tri != null && this.dE) {
            tri.sc(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.BR != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.CYO.incrementAndGet();
                if (this.qKn.getAndSet(true)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.Dl.ko());
                } catch (JSONException unused) {
                }
                sc(TrackingKey.CLICK_TIME, jSONObject, Math.max(SystemClock.elapsedRealtime() - this.BR, 0L));
            }
        }
    }

    public void sc(WebView webView, int i11) {
        if (webView == null) {
            return;
        }
        if (this.BR == 0) {
            this.BR = SystemClock.elapsedRealtime();
        }
        if (this.WP == 0 && i11 > 0) {
            this.WP = System.currentTimeMillis();
        } else if (this.cvk == 0 && i11 == 100) {
            this.cvk = System.currentTimeMillis();
        }
        if (this.zY != pFF.length && ("landingpage".equals(this.uEA) || "landingpage_endcard".equals(this.uEA) || "landingpage_split_screen".equals(this.uEA) || "landingpage_direct".equals(this.uEA) || "aggregate_page".equals(this.uEA))) {
            int i12 = this.zY;
            while (true) {
                int[] iArr = pFF;
                if (i12 >= iArr.length || i11 < iArr[this.zY]) {
                    break;
                }
                int i13 = i12 + 1;
                this.zY = i13;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", webView.getUrl());
                    long j11 = this.We;
                    if (j11 != -1) {
                        jSONObject.put("page_id", j11);
                    }
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("pct", iArr[i12]);
                } catch (Exception unused) {
                }
                sc("progress_load_finish", jSONObject);
                i12 = i13;
            }
        }
        if (i11 == 100) {
            sc(webView.getUrl(), NotificationCompat.CATEGORY_PROGRESS, Math.min(this.cvk - this.WP, TTAdConstant.AD_MAX_EVENT_TIME));
        }
    }

    public void sc(WebView webView, int i11, String str, String str2, String str3, boolean z11) {
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.OXF;
        if (exN != null) {
            exN.sc((JSONObject) null);
        }
        if ((str3 == null || !str3.startsWith("image")) && this.ExN != 2) {
            this.ExN = 3;
        }
        this.WH = i11;
        this.Tf = str;
        this.Ql = str2;
        this.UFX = z11;
    }

    public void sc(WebView webView, String str, Bitmap bitmap, boolean z11, int i11) {
        this.dE = z11;
        this.YIK++;
        com.bytedance.sdk.openadsdk.core.widget.sc.TRI tri = this.BT;
        if (tri != null && z11) {
            tri.pFF(str);
            this.BT.pFF();
        }
        Qj qj2 = this.wjp;
        if (qj2 != null && z11) {
            qj2.sc(str, i11);
        }
        WeakReference<WebView> weakReference = this.cD;
        WebView webView2 = weakReference != null ? weakReference.get() : null;
        if (webView2 != null) {
            try {
                WebBackForwardList webBackForwardListCopyBackForwardList = webView2.copyBackForwardList();
                if (webBackForwardListCopyBackForwardList != null && webBackForwardListCopyBackForwardList.getCurrentIndex() > this.f27331pc) {
                    this.JoC.incrementAndGet();
                }
                this.f27331pc = webBackForwardListCopyBackForwardList.getCurrentIndex();
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("LandingPageLog", "copyBackForwardList exception", e11);
            }
        }
        if (this.BR == 0) {
            this.BR = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.OXF;
        if (exN != null) {
            exN.ExN();
        }
        if (this.TRI.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                int i12 = this.GI;
                if (i12 >= 0) {
                    jSONObject.putOpt("preload_status", Integer.valueOf(i12));
                }
            } catch (Exception unused) {
            }
            sc("load_start", jSONObject);
        }
    }

    public void sc(WebView webView, String str, boolean z11) {
        com.bytedance.sdk.openadsdk.core.widget.sc.TRI tri = this.BT;
        if (tri != null && z11) {
            tri.sc();
        }
        com.bytedance.sdk.openadsdk.We.We.ExN exN = this.OXF;
        if (exN != null) {
            exN.TRI();
        }
        Qj qj2 = this.wjp;
        if (qj2 != null && z11) {
            qj2.sc(str);
        }
        if (webView != null && !this.McK && this.Cb) {
            this.McK = true;
            com.bytedance.sdk.component.utils.UFX.sc(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.f27332qr.compareAndSet(false, true)) {
            if (this.ExN != 3) {
                this.ExN = 2;
            }
            this.JPJ = System.currentTimeMillis();
            boolean z12 = this.ExN == 2;
            int iWH = WH();
            if (!z12) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TrackingKey.ERROR_CODE, this.WH);
                    jSONObject.put("error_msg", this.Tf);
                    jSONObject.put("error_url", this.Ql);
                    jSONObject.put("first_page", iWH);
                    int i11 = this.GI;
                    if (i11 >= 0) {
                        jSONObject.put("preload_status", i11);
                    }
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("url", this.Dl.ko());
                    jSONObject.put("preload_h5_type", this.Dl.Ay());
                } catch (Exception unused) {
                }
                sc(z11, "2");
                sc("load_fail", jSONObject);
                if (Ol()) {
                    zY.sc(this.Dl, this.Yhz, SystemClock.elapsedRealtime() - this.MxZ, this.WH, this.Tf, this.Ql);
                }
                if (this.UFX) {
                    jSONObject.remove("render_type");
                    jSONObject.remove("render_type_2");
                    sc("load_fail_main", jSONObject);
                    return;
                }
                return;
            }
            long j11 = this.cvk - this.WP;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(TrackingKey.ERROR_CODE, this.WH);
                jSONObject2.put("error_msg", this.Tf);
                jSONObject2.put("error_url", this.Ql);
                int i12 = this.GI;
                if (i12 >= 0) {
                    jSONObject2.put("preload_status", i12);
                }
                jSONObject2.put("first_page", iWH);
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject2.put("url", this.Dl.ko());
                jSONObject2.put("preload_h5_type", this.Dl.Ay());
            } catch (Exception unused2) {
            }
            sc(z11, "0");
            long jMin = Math.min(j11, TTAdConstant.AD_MAX_EVENT_TIME);
            sc("load_finish", jSONObject2, jMin);
            if (Ol()) {
                this.f27329eo = SystemClock.elapsedRealtime();
                TRI();
                zY.sc(this.Dl, this.Yhz, this.f27329eo - this.MxZ);
            }
            sc(str, "load_finish", jMin);
            WH wh2 = this.kX;
            if (wh2 != null) {
                wh2.sc(iWH);
            }
        }
    }

    public void sc(com.bytedance.sdk.component.Ol.We we2) {
        int iIdT;
        Bitmap bitmapSc;
        Sfl sfl;
        if ((!"landingpage".equals(this.uEA) && !"landingpage_endcard".equals(this.uEA) && !"landingpage_split_screen".equals(this.uEA) && !"landingpage_direct".equals(this.uEA) && !"aggregate_page".equals(this.uEA)) || (iIdT = com.bytedance.sdk.openadsdk.core.Xc.We().idT()) == 0 || new Random().nextInt(100) + 1 > iIdT || we2 == null || we2.getWebView() == null || we2.getVisibility() != 0 || (bitmapSc = kX.sc(we2)) == null || (sfl = this.Dl) == null) {
            return;
        }
        kX.sc(sfl, this.uEA, "landing_page_blank", bitmapSc, we2.getUrl(), this.We);
    }

    public void sc(com.bytedance.sdk.openadsdk.Sfl.Qj qj2) {
        this.Xc = qj2;
    }

    public void sc(com.bytedance.sdk.openadsdk.We.We.ExN exN) {
        this.OXF = exN;
    }

    public void sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.sc.TRI tri = this.BT;
        if (tri != null) {
            tri.sc(str);
        }
        Qj qj2 = this.wjp;
        if (qj2 != null) {
            qj2.zY(str);
        }
        this.uEA = str;
    }

    public void sc(String str, boolean z11) {
        com.bytedance.sdk.openadsdk.core.widget.sc.TRI tri = this.BT;
        if (tri != null && z11) {
            tri.zY(str);
        }
        Qj qj2 = this.wjp;
        if (qj2 == null || !z11) {
            return;
        }
        qj2.pFF(str);
    }

    public void zY(boolean z11) {
        WeakReference<WebView> weakReference = this.cD;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                webView.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("LandingPageLog", "removeJavascriptInterface exception", e11);
            }
        }
        if (this.f27332qr.compareAndSet(false, true)) {
            sc(z11, "1");
            if (this.Cb) {
                zY.sc(this.Dl, this.uEA, System.currentTimeMillis() - this.II, this.GI, WH());
            }
        } else if (this.ExN == 2 && !this.Ol.get()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_status", this.ExN);
                jSONObject.put("max_scroll_percent", this.Gb.get());
                jSONObject.put("jump_times", this.JoC.getAndSet(0));
                jSONObject.put("click_times", this.CYO.getAndSet(0));
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (JSONException unused) {
            }
            sc("stay_page", jSONObject, 0L);
        }
        if ("landingpage".equals(this.uEA) || "landingpage_endcard".equals(this.uEA) || "landingpage_split_screen".equals(this.uEA) || "landingpage_direct".equals(this.uEA) || "aggregate_page".equals(this.uEA)) {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("landingFinish", this.Dl, this.f27330ko);
        }
    }

    public boolean zY() {
        return this.cJ;
    }
}
