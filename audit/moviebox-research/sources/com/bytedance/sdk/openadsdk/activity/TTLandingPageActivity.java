package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.We.UFX;
import com.bytedance.sdk.openadsdk.We.WH;
import com.bytedance.sdk.openadsdk.common.BT;
import com.bytedance.sdk.openadsdk.common.SR;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.qr;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.Tf;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTLandingPageActivity extends TTBaseActivity {
    private String BT;
    private Tf Cb;
    private String Dl;
    private ILoader FI;
    private com.bytedance.sdk.openadsdk.common.Tf Gb;
    private int II;
    private String JPJ;
    private int McK;
    private com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc OXF;
    private TextView Ol;
    private ImageView Qj;
    private com.bytedance.sdk.openadsdk.core.ExN.TRI Ql;
    private String SR;
    private Sfl Sfl;
    private com.bytedance.sdk.component.Ol.We TRI;
    private Button Tf;
    private SR UFX;
    private Context WH;
    private int Xc;
    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI YIK;
    private boolean cD;
    private com.bytedance.sdk.openadsdk.common.We cJ;
    private HJN dE;
    private com.bytedance.sdk.openadsdk.core.widget.sc.ExN kX;
    BT pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    UFX f27536sc;
    private String wjp;
    TTAdDislikeToast zY;
    private final AtomicBoolean uEA = new AtomicBoolean(true);
    private final AtomicInteger WP = new AtomicInteger(0);
    private final AtomicInteger cvk = new AtomicInteger(0);
    private final AtomicInteger HJN = new AtomicInteger(0);
    final AtomicBoolean We = new AtomicBoolean(false);
    final AtomicBoolean ExN = new AtomicBoolean(false);
    private String BR = "ダウンロード";

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements View.OnScrollChangeListener {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<UFX> f27549sc;

        public pFF(UFX ufx) {
            this.f27549sc = new WeakReference<>(ufx);
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i11, int i12, int i13, int i14) {
            UFX ufx = this.f27549sc.get();
            if (ufx != null) {
                ufx.pFF(i12);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements WH {
        private final WeakReference<TTLandingPageActivity> We;
        private final Sfl pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final int f27550sc;
        private final String zY;

        public sc(int i11, Sfl sfl, String str, TTLandingPageActivity tTLandingPageActivity) {
            this.f27550sc = i11;
            this.pFF = sfl;
            this.zY = str;
            this.We = new WeakReference<>(tTLandingPageActivity);
        }

        @Override // com.bytedance.sdk.openadsdk.We.WH
        public void sc(int i11) {
            TTLandingPageActivity tTLandingPageActivity = this.We.get();
            if (tTLandingPageActivity != null) {
                com.bytedance.sdk.openadsdk.We.zY.sc.sc(this.f27550sc, tTLandingPageActivity.cvk.get(), tTLandingPageActivity.HJN.get(), tTLandingPageActivity.WP.get() - tTLandingPageActivity.HJN.get(), this.pFF, this.zY, i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY implements View.OnTouchListener {
        private final WeakReference<com.bytedance.sdk.openadsdk.common.We> pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<UFX> f27551sc;

        public zY(UFX ufx, com.bytedance.sdk.openadsdk.common.We we2) {
            this.f27551sc = new WeakReference<>(ufx);
            this.pFF = new WeakReference<>(we2);
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            UFX ufx = this.f27551sc.get();
            if (ufx != null) {
                ufx.sc(motionEvent);
            }
            com.bytedance.sdk.openadsdk.common.We we2 = this.pFF.get();
            if (we2 == null) {
                return false;
            }
            we2.sc(motionEvent);
            return false;
        }
    }

    private void ExN() {
        com.bytedance.sdk.component.Ol.We we2 = (com.bytedance.sdk.component.Ol.We) findViewById(com.bytedance.sdk.openadsdk.utils.SR.QLv);
        this.TRI = we2;
        cJ.sc(this.Sfl, we2);
        this.UFX = (SR) findViewById(com.bytedance.sdk.openadsdk.utils.SR.ZM);
        SR sr2 = (SR) findViewById(com.bytedance.sdk.openadsdk.utils.SR.fT);
        com.bytedance.sdk.openadsdk.common.Tf tf2 = (com.bytedance.sdk.openadsdk.common.Tf) findViewById(520093721);
        this.Gb = tf2;
        if (tf2 != null) {
            tf2.sc(this.Sfl);
            this.Gb.sc();
        }
        if (sr2 != null) {
            sr2.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(520093720);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTLandingPageActivity.this.TRI != null) {
                        if (TTLandingPageActivity.this.OXF != null) {
                            TTLandingPageActivity.this.OXF.sc();
                        }
                        if (TTLandingPageActivity.this.TRI.ExN()) {
                            TTLandingPageActivity.this.TRI.TRI();
                        } else if (TTLandingPageActivity.this.qr()) {
                            TTLandingPageActivity.this.onBackPressed();
                        } else {
                            TTLandingPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(520093716);
        this.Qj = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.Ol = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.Mrq);
        com.bytedance.sdk.openadsdk.core.ExN.TRI tri = (com.bytedance.sdk.openadsdk.core.ExN.TRI) findViewById(com.bytedance.sdk.openadsdk.utils.SR.bSP);
        this.Ql = tri;
        if (tri != null) {
            tri.setVisibility(0);
        }
        View viewFindViewById = findViewById(com.bytedance.sdk.openadsdk.utils.SR.eoh);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTLandingPageActivity.this.sc();
                }
            });
        }
    }

    private void Ol() {
        try {
            if (this.pFF == null) {
                BT bt2 = new BT(this.WH, this.Sfl);
                this.pFF = bt2;
                bt2.setDislikeSource("landing_page");
                this.pFF.setCallback(new BT.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void pFF(View view) {
                        TTLandingPageActivity.this.We.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void sc(View view) {
                        TTLandingPageActivity.this.We.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void sc(FilterWord filterWord) {
                        if (TTLandingPageActivity.this.ExN.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTLandingPageActivity.this.ExN.set(true);
                        TTLandingPageActivity.this.UFX();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.pFF);
            if (this.zY == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.WH);
                this.zY = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th2) {
            ApmHelper.reportCustomError("initDislike error", "LandingPageActivity", th2);
        }
    }

    private void Qj() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.dE.sc("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    private void TRI() {
        HJN hjn = new HJN(this);
        this.dE = hjn;
        hjn.pFF(this.TRI).zY(this.SR).We(this.BT).sc(this.Sfl).pFF(this.Xc).sc(this.Sfl.BR()).ExN(this.Sfl.BU()).sc(this.TRI).pFF("landingpage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UFX() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.zY) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }

    private void WH() {
        TTAdDislikeToast tTAdDislikeToast = this.zY;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    private String We() {
        Sfl sfl = this.Sfl;
        if (sfl != null && !TextUtils.isEmpty(sfl.NQ())) {
            this.BR = this.Sfl.NQ();
        }
        return this.BR;
    }

    private View pFF() {
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(this);
        if (Build.VERSION.SDK_INT >= 35) {
            zYVar.setFitsSystemWindows(true);
        }
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(this);
        exN.setOrientation(1);
        zYVar.addView(exN, new FrameLayout.LayoutParams(-1, -1));
        View sr2 = new SR(this, new SR.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.common.SR.sc
            public View sc(Context context) {
                return new com.bytedance.sdk.openadsdk.common.WH(context);
            }
        });
        sr2.setId(com.bytedance.sdk.openadsdk.utils.SR.fT);
        exN.addView(sr2, new LinearLayout.LayoutParams(-1, kX.zY(this, 44.0f)));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        exN.addView(zYVar2, layoutParams);
        com.bytedance.sdk.component.Ol.We we2 = new com.bytedance.sdk.component.Ol.We(this);
        we2.setId(com.bytedance.sdk.openadsdk.utils.SR.QLv);
        zYVar2.addView(we2, new FrameLayout.LayoutParams(-1, -1));
        SR sr3 = new SR(this, new SR.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.common.SR.sc
            public View sc(Context context) {
                return new qr(context);
            }
        });
        sr3.setId(com.bytedance.sdk.openadsdk.utils.SR.ZM);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 81;
        zYVar2.addView(sr3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.TRI tri = new com.bytedance.sdk.openadsdk.core.ExN.TRI(this, null, R.style.Widget.ProgressBar.Horizontal);
        tri.setId(com.bytedance.sdk.openadsdk.utils.SR.bSP);
        tri.setProgress(1);
        tri.setVisibility(8);
        tri.setProgressDrawable(Ol.sc(this, "tt_browser_progress_style"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, kX.zY(this, 3.0f));
        layoutParams3.gravity = 49;
        zYVar2.addView(tri, layoutParams3);
        View tf2 = new com.bytedance.sdk.openadsdk.common.Tf(this);
        tf2.setId(520093721);
        zYVar.addView(tf2, new FrameLayout.LayoutParams(-1, -1));
        return zYVar;
    }

    private void pFF(final int i11) {
        if (this.Qj == null || !qr()) {
            return;
        }
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                kX.sc((View) TTLandingPageActivity.this.Qj, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qr() {
        return !TextUtils.isEmpty(this.Dl) && this.Dl.contains("__luban_sdk");
    }

    private void sc(int i11) {
        int i12;
        if (i11 == 1 || (i12 = Build.VERSION.SDK_INT) == 26) {
            return;
        }
        if (i12 != 27) {
            setRequestedOrientation(i11);
        } else {
            try {
                setRequestedOrientation(i11);
            } catch (Throwable unused) {
            }
        }
    }

    private void sc(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.Tf) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.10
            @Override // java.lang.Runnable
            public void run() {
                if (TTLandingPageActivity.this.Tf == null || TTLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTLandingPageActivity.this.Tf.setText(str);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void zY() {
        Sfl sfl = this.Sfl;
        if (sfl == null || sfl.QLv() != 4) {
            return;
        }
        SR sr2 = this.UFX;
        if (sr2 != null) {
            sr2.setVisibility(0);
        }
        Button button = (Button) findViewById(com.bytedance.sdk.openadsdk.utils.SR.QST);
        this.Tf = button;
        if (button != null) {
            sc(We());
            if (this.YIK == null) {
                this.YIK = com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(this, this.Sfl, TextUtils.isEmpty(this.wjp) ? cJ.pFF(this.Xc) : this.wjp);
            }
            com.bytedance.sdk.openadsdk.core.pFF.sc scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(this, this.Sfl, this.wjp, this.Xc);
            scVar.sc(false);
            this.Tf.setOnClickListener(scVar);
            this.Tf.setOnTouchListener(scVar);
            scVar.zY(true);
            scVar.sc(this.YIK);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (qr() && !this.uEA.getAndSet(true)) {
            Qj();
            pFF(0);
        } else {
            try {
                super.onBackPressed();
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.LandingPageAct", "onBackPressed: ", th2.getMessage());
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable unused) {
        }
        zY();
    }

    @Override // android.app.Activity
    @SuppressLint({"ClickableViewAccessibility"})
    public void onCreate(@Nullable Bundle bundle) {
        sc(3);
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.SR.ExN()) {
            finish();
            return;
        }
        try {
            Xc.pFF(this);
        } catch (Throwable unused) {
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            setContentView(pFF());
            Intent intent = getIntent();
            int intExtra = intent.getIntExtra("sdk_version", 1);
            this.SR = intent.getStringExtra("adid");
            this.BT = intent.getStringExtra("log_extra");
            this.Xc = intent.getIntExtra("source", -1);
            String stringExtra = intent.getStringExtra("url");
            this.Dl = stringExtra;
            pFF(4);
            String stringExtra2 = intent.getStringExtra("web_title");
            this.wjp = intent.getStringExtra("event_tag");
            this.JPJ = intent.getStringExtra("gecko_id");
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra3 != null) {
                    try {
                        this.Sfl = com.bytedance.sdk.openadsdk.core.pFF.sc(new JSONObject(stringExtra3));
                    } catch (Exception e11) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.LandingPageAct", "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e11);
                    }
                }
            } else {
                this.Sfl = FI.sc().pFF();
                FI.sc().TRI();
            }
            if (this.Sfl == null) {
                finish();
                return;
            }
            ExN();
            if (!TextUtils.isEmpty(this.JPJ)) {
                this.FI = com.bytedance.sdk.openadsdk.qr.pFF.sc().pFF();
                int iSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.FI, this.JPJ);
                this.II = iSc;
                this.McK = iSc > 0 ? 2 : 0;
            }
            this.WH = this;
            if (this.TRI != null) {
                com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(this).sc(false).pFF(false).sc(this.TRI.getWebView());
            }
            com.bytedance.sdk.component.Ol.We we2 = this.TRI;
            if (we2 != null && we2.getWebView() != null) {
                UFX ufxSc = new UFX(this.Sfl, this.TRI.getWebView(), new sc(this.II, this.Sfl, "landingpage", this), this.McK).sc(true);
                this.f27536sc = ufxSc;
                this.OXF = ufxSc.f27333sc;
                this.cJ = cJ.sc(this.Sfl, this.TRI, this.WH, this.wjp);
            }
            TRI();
            this.TRI.setLandingPage(true);
            this.TRI.setTag("landingpage");
            this.TRI.setMaterialMeta(this.Sfl.bZj());
            com.bytedance.sdk.openadsdk.core.widget.sc.ExN exN = new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(this.WH, this.dE, this.SR, this.cJ, this.f27536sc, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    try {
                        if (TTLandingPageActivity.this.Ql != null && !TTLandingPageActivity.this.isFinishing()) {
                            TTLandingPageActivity.this.Ql.setVisibility(8);
                        }
                    } catch (Throwable unused2) {
                    }
                    if (TTLandingPageActivity.this.Gb != null) {
                        TTLandingPageActivity.this.Gb.pFF();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(TTLandingPageActivity.this.JPJ)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        TTLandingPageActivity.this.WP.incrementAndGet();
                        WebResourceResponseModel webResourceResponseModelSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(TTLandingPageActivity.this.FI, TTLandingPageActivity.this.JPJ, str);
                        if (webResourceResponseModelSc != null && webResourceResponseModelSc.getWebResourceResponse() != null) {
                            TTLandingPageActivity.this.HJN.incrementAndGet();
                            return webResourceResponseModelSc.getWebResourceResponse();
                        }
                        if (webResourceResponseModelSc != null && webResourceResponseModelSc.getMsg() == 2) {
                            TTLandingPageActivity.this.cvk.incrementAndGet();
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable th2) {
                        com.bytedance.sdk.component.utils.Tf.sc("TTAD.LandingPageAct", "shouldInterceptRequest url error", th2);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }
            };
            this.kX = exN;
            exN.sc(this.Sfl);
            this.TRI.setWebViewClient(this.kX);
            com.bytedance.sdk.component.Ol.We we3 = this.TRI;
            if (we3 != null) {
                we3.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we3.getWebView(), intExtra));
            }
            int i11 = Build.VERSION.SDK_INT;
            com.bytedance.sdk.component.Ol.We we4 = this.TRI;
            if (we4 != null) {
                we4.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(this.Sfl, "landingpage", this.McK);
            com.bytedance.sdk.openadsdk.utils.Sfl.sc(this.TRI, stringExtra);
            this.TRI.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.dE, this.f27536sc, this.cJ) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i12) {
                    super.onProgressChanged(webView, i12);
                    if (TTLandingPageActivity.this.Gb != null) {
                        TTLandingPageActivity.this.Gb.sc(i12);
                    }
                    if (TTLandingPageActivity.this.Ql == null || TTLandingPageActivity.this.isFinishing()) {
                        return;
                    }
                    if (i12 == 100 && TTLandingPageActivity.this.Ql.isShown()) {
                        TTLandingPageActivity.this.Ql.setVisibility(8);
                    } else {
                        TTLandingPageActivity.this.Ql.setProgress(i12);
                    }
                }
            });
            if (this.TRI.getWebView() != null) {
                if (i11 >= 23) {
                    this.TRI.getWebView().setOnScrollChangeListener(new pFF(this.f27536sc));
                }
                this.TRI.getWebView().setOnTouchListener(new zY(this.f27536sc, this.cJ));
            }
            this.TRI.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.6
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
                    if (TTLandingPageActivity.this.YIK != null) {
                        TTLandingPageActivity.this.YIK.We();
                    }
                }
            });
            TextView textView = this.Ol;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_web_title_default");
                }
                textView.setText(stringExtra2);
            }
            zY();
            Tf tfSc = com.bytedance.sdk.openadsdk.utils.qr.sc(this, new com.bytedance.sdk.openadsdk.utils.qr.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.7
                @Override // com.bytedance.sdk.openadsdk.utils.qr.sc
                public void pFF() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.qr.sc
                public View sc() {
                    return TTLandingPageActivity.this.Qj;
                }
            });
            this.Cb = tfSc;
            tfSc.sc(0L);
            com.bytedance.sdk.openadsdk.We.zY.sc.sc(SystemClock.elapsedRealtime() - jElapsedRealtime, this.Sfl, "landingpage", this.FI, this.JPJ);
        } catch (Throwable unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.bytedance.sdk.component.Ol.We we2;
        super.onDestroy();
        UFX ufx = this.f27536sc;
        if (ufx != null && (we2 = this.TRI) != null) {
            ufx.sc(we2);
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.Ol.We we3 = this.TRI;
        if (we3 != null) {
            com.bytedance.sdk.openadsdk.core.Cb.sc(we3.getWebView());
        }
        this.TRI = null;
        HJN hjn = this.dE;
        if (hjn != null) {
            hjn.UFX();
        }
        UFX ufx2 = this.f27536sc;
        if (ufx2 != null) {
            ufx2.zY(true);
        }
        if (!TextUtils.isEmpty(this.JPJ)) {
            com.bytedance.sdk.openadsdk.We.zY.sc.sc(this.HJN.get(), this.WP.get(), this.Sfl);
        }
        com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.FI);
        Tf tf2 = this.Cb;
        if (tf2 != null) {
            tf2.zY();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Tf tf2 = this.Cb;
        if (tf2 != null) {
            tf2.pFF();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        HJN hjn = this.dE;
        if (hjn != null) {
            hjn.WH();
        }
        UFX ufx = this.f27536sc;
        if (ufx != null) {
            ufx.qr();
        }
        if (!this.cD) {
            this.cD = true;
            sc(4);
        }
        Tf tf2 = this.Cb;
        if (tf2 != null) {
            tf2.sc();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.bytedance.sdk.openadsdk.utils.zY.sc(this, this.Sfl);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        UFX ufx = this.f27536sc;
        if (ufx != null) {
            ufx.Qj();
        }
    }

    public void sc() {
        if (isFinishing()) {
            return;
        }
        if (this.ExN.get()) {
            WH();
            return;
        }
        if (this.pFF == null) {
            Ol();
        }
        BT bt2 = this.pFF;
        if (bt2 != null) {
            bt2.sc();
        }
    }
}
