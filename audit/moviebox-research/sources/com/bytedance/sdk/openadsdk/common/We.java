package com.bytedance.sdk.openadsdk.common;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We implements FI.sc {
    private long BT;
    private zY ExN;
    private int Ol;
    private float Qj;
    private int Ql;
    private boolean SR;
    private int Sfl;
    private long WH;
    private final com.bytedance.sdk.component.Ol.We We;
    private String YIK;
    private boolean dE;
    private final boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Sfl f27701sc;
    private WebView zY;
    private String TRI = "landingpage";

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Handler f27700qr = new FI(com.bytedance.sdk.openadsdk.core.SR.pFF().getLooper(), this);
    private final AtomicBoolean UFX = new AtomicBoolean(false);
    private Pattern Tf = null;
    private long wjp = -1;
    private final List<Integer> Xc = new ArrayList();

    public We(Sfl sfl, com.bytedance.sdk.component.Ol.We we2, String str, boolean z11) {
        this.f27701sc = sfl;
        this.We = we2;
        this.pFF = z11;
        pFF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void ExN() {
        this.SR = false;
        if (this.UFX.getAndSet(true)) {
            return;
        }
        this.WH = SystemClock.elapsedRealtime();
        this.BT = System.currentTimeMillis();
        Qj();
        if (this.ExN == null) {
            return;
        }
        WebView webView = this.zY;
        if (webView != null) {
            this.YIK = webView.getUrl();
        }
        this.ExN.setVisibility(0);
        this.ExN.sc(this.f27701sc);
        this.ExN.sc();
        this.ExN.setAlpha(this.Qj);
        this.ExN.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.common.We.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        We();
        zY();
    }

    private void Qj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loading_show_interval", SystemClock.elapsedRealtime() - this.wjp);
            jSONObject.put("loading_show_timestamp", this.BT);
            WebView webView = this.zY;
            jSONObject.put("arbi_current_url", webView != null ? webView.getUrl() : "");
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.f27701sc, this.TRI, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TRI() {
        return qr() > 0 && !this.UFX.get();
    }

    private void We() {
        Handler handler = this.f27700qr;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private void pFF() {
        com.bytedance.sdk.component.Ol.We we2 = this.We;
        if (we2 != null) {
            this.zY = we2.getWebView();
            View arbitrageLoadingView = this.We.getArbitrageLoadingView();
            if (arbitrageLoadingView instanceof zY) {
                this.ExN = (zY) arbitrageLoadingView;
            }
        }
        this.Ol = com.bytedance.sdk.openadsdk.core.settings.dE.ef().JP();
        this.Qj = com.bytedance.sdk.openadsdk.core.settings.dE.ef().WMT();
    }

    private int qr() {
        try {
            return this.zY.copyBackForwardList().getCurrentIndex() + 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private void sc(final int i11) {
        WebView webView = this.zY;
        if (webView != null && i11 == 1) {
            String url = webView.getUrl();
            if (TextUtils.isEmpty(url) || url.equals(this.YIK)) {
                return;
            }
        }
        com.bytedance.sdk.component.utils.qr.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.We.4
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.ExN != null) {
                    We.this.UFX.set(false);
                    We.this.ExN.sc(We.this.f27701sc, We.this.TRI, i11, We.this.YIK, We.this.WH, We.this.SR, We.this.Ql, We.this.BT);
                    We.this.Ql = 0;
                }
            }
        });
        We();
    }

    private void sc(int i11, WebView webView) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_progress", i11);
            jSONObject.put("progress_timestamp", System.currentTimeMillis());
            jSONObject.put("arbi_current_url", webView.getUrl());
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.zY(this.f27701sc, this.TRI, jSONObject);
    }

    private boolean sc(int i11, int i12) {
        if (i11 < i12 || this.Xc.contains(Integer.valueOf(i12)) || this.Sfl < 2) {
            return false;
        }
        this.Xc.add(Integer.valueOf(i12));
        return true;
    }

    private void zY() {
        Handler handler = this.f27700qr;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, this.Ol);
        }
    }

    public void pFF(WebView webView, String str, boolean z11) {
        if (!z11 || this.ExN == null) {
            return;
        }
        sc(1);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void sc() {
        if (Cb.ExN()) {
            ExN();
        } else {
            com.bytedance.sdk.component.utils.qr.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.We.2
                @Override // java.lang.Runnable
                public void run() {
                    We.this.ExN();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        if (message.what == 1) {
            sc(0);
        }
    }

    public void sc(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.wjp = SystemClock.elapsedRealtime();
        }
    }

    public void sc(WebView webView, int i11) {
        zY zYVar = this.ExN;
        if (zYVar != null) {
            zYVar.sc(i11);
        }
        if (this.dE) {
            if (sc(i11, 30)) {
                sc(30, webView);
            }
            if (sc(i11, 50)) {
                sc(50, webView);
            }
            if (sc(i11, 70)) {
                sc(70, webView);
            }
        }
        if (this.ExN == null || i11 != 100) {
            return;
        }
        sc(1);
    }

    public void sc(WebView webView, String str) {
        Sfl sfl = this.f27701sc;
        if (sfl == null || !com.bytedance.sdk.component.Ol.pFF.sc(sfl.UFX().zY(), str)) {
            return;
        }
        this.Ql++;
        com.bytedance.sdk.component.utils.qr.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.We.1
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.TRI()) {
                    We.this.sc();
                }
            }
        });
    }

    public void sc(WebView webView, String str, boolean z11) {
        if (z11 && TRI()) {
            sc();
        }
    }

    public void sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.TRI = str;
    }

    public void zY(WebView webView, String str, boolean z11) {
        this.Xc.clear();
        this.dE = z11;
        if (z11) {
            this.SR = true;
        }
        this.Sfl = qr();
    }
}
