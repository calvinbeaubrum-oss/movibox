package com.bytedance.sdk.openadsdk.core.model;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.Cb;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Xc implements Handler.Callback {
    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI BR;
    private Handler BT;
    private AtomicBoolean Bs;
    private boolean CYO;
    private String Cb;
    private TextView Dl;
    View ExN;
    private FrameLayout FI;
    private com.bytedance.sdk.openadsdk.core.widget.sc.ExN GI;
    private long HJN;
    private ImageView II;
    private com.bytedance.sdk.component.Ol.We JPJ;
    private com.bytedance.sdk.openadsdk.We.UFX JoC;
    private View McK;
    private String MxZ;
    private LinearLayout.LayoutParams NQ;
    private int OKY;
    private final com.bytedance.sdk.openadsdk.core.Ql.We.pFF OXF;
    ObjectAnimator Ol;
    private ILoader QLv;
    FrameLayout Qj;
    com.bytedance.sdk.openadsdk.core.pFF.sc Ql;
    com.bytedance.sdk.openadsdk.core.pFF.pFF SR;
    private TextView Sfl;
    RelativeLayout TRI;
    c.InterfaceC0849c Tf;
    ObjectAnimator UFX;
    ValueAnimator WH;
    private com.bytedance.sdk.openadsdk.common.Tf WP;
    FrameLayout We;
    private View Xc;
    private com.bytedance.sdk.openadsdk.core.widget.Xc YIK;
    private com.bytedance.sdk.openadsdk.core.widget.Xc YdT;
    private com.bytedance.sdk.openadsdk.core.Qj.Sfl ZM;
    private com.bytedance.sdk.openadsdk.core.ExN.Qj bSP;
    private final Activity cD;
    private final View cJ;
    private View cvk;
    private View dE;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ExN.We f28417ht;
    private FrameLayout idT;
    private int kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.common.We f28418ko;
    FrameLayout pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private boolean f28419pc;
    private int qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    final Sfl f28420qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    ImageView f28421sc;
    private HJN uEA;
    private TextView wjp;
    TextView zY;
    private final AtomicBoolean Gb = new AtomicBoolean(false);
    private final AtomicBoolean qKn = new AtomicBoolean(false);

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private volatile int f28416eo = 0;
    private volatile int yL = 0;
    private volatile int Yhz = 0;
    private float fT = -1.0f;
    private final AtomicBoolean kDg = new AtomicBoolean(false);
    private long DNB = -1;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements com.bytedance.sdk.openadsdk.We.WH {
        private final WeakReference<Xc> We;
        private final Sfl pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final int f28440sc;
        private final String zY;

        public pFF(int i11, Sfl sfl, String str, Xc xc2) {
            this.f28440sc = i11;
            this.pFF = sfl;
            this.zY = str;
            this.We = new WeakReference<>(xc2);
        }

        @Override // com.bytedance.sdk.openadsdk.We.WH
        public void sc(int i11) {
            Xc xc2 = this.We.get();
            if (xc2 != null) {
                com.bytedance.sdk.openadsdk.We.zY.sc.sc(this.f28440sc, xc2.Yhz, xc2.yL, xc2.f28416eo - xc2.yL, this.pFF, this.zY, i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.ExN.Qj {
        @Override // com.bytedance.sdk.component.ExN.Qj
        public Bitmap sc(Bitmap bitmap) {
            return com.bytedance.sdk.component.adexpress.We.sc.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), bitmap, 25);
        }
    }

    public Xc(Activity activity, final Sfl sfl, String str, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff, View view) {
        this.cD = activity;
        this.f28420qr = sfl;
        this.Cb = str;
        this.OXF = pff;
        this.cJ = view;
        this.kX = cJ.sc(str);
        if (sfl != null) {
            this.MxZ = sfl.PPh();
        }
        if (!TextUtils.isEmpty(this.MxZ)) {
            this.QLv = com.bytedance.sdk.openadsdk.qr.pFF.sc().pFF();
            int iSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.QLv, this.MxZ);
            this.qfG = iSc;
            this.OKY = iSc > 0 ? 2 : 0;
        }
        boolean zWe = We(sfl);
        boolean zExN = ExN(sfl);
        if (pFF(sfl)) {
            this.Cb = "landingpage_split_screen";
        } else if (zWe) {
            this.Cb = "landingpage_direct";
        } else if (zExN) {
            this.Cb = "aggregate_page";
        } else if (zY(sfl)) {
            this.Cb = "landingpage_split_ceiling";
        }
        this.Ql = new com.bytedance.sdk.openadsdk.core.pFF.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), sfl, this.Cb, cJ.sc(str));
        HashMap map = new HashMap();
        map.put("click_scence", 1);
        this.Ql.sc(map);
        View viewFindViewById = activity.findViewById(R.id.content);
        this.Ql.sc(viewFindViewById);
        com.bytedance.sdk.openadsdk.core.pFF.pFF pff2 = new com.bytedance.sdk.openadsdk.core.pFF.pFF(activity, sfl, this.Cb, cJ.sc(str), true) { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.1
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF
            public boolean sc(WH wh2, Map<String, Object> map2) {
                if (Xc.Qj(sfl) && Xc.this.GI != null) {
                    Xc.this.GI.sc(wh2);
                    Xc.this.GI.sc(map2);
                    if (Xc.qr(Xc.this.f28420qr) || Xc.this.f28419pc) {
                        return true;
                    }
                }
                return super.sc(wh2, map2);
            }
        };
        this.SR = pff2;
        pff2.sc(map);
        this.SR.sc(viewFindViewById);
        this.Qj = frameLayout;
        if (zWe || zExN) {
            try {
                Handler handler = new Handler(Looper.getMainLooper(), this);
                this.BT = handler;
                handler.sendMessage(handler.obtainMessage(100, 0, 0));
            } catch (Exception e11) {
                Log.e("LandingPageModel", "LandingPageModel: ", e11);
            }
        }
    }

    private void BT() {
        if ((We(this.f28420qr) || ExN(this.f28420qr)) && (this.cD instanceof com.bytedance.sdk.openadsdk.core.Ql.We.pFF)) {
            this.OXF.UFX();
            this.OXF.Tf();
        }
    }

    public static boolean ExN(Sfl sfl) {
        return sfl != null && sfl.Xc() == 33;
    }

    public static boolean Ol(Sfl sfl) {
        return sfl != null && sfl.Xc() == 19;
    }

    public static boolean Qj(Sfl sfl) {
        if (sfl != null) {
            return sfl.Xc() == 19 || sfl.Xc() == 20;
        }
        return false;
    }

    public static /* synthetic */ int Ql(Xc xc2) {
        int i11 = xc2.yL;
        xc2.yL = i11 + 1;
        return i11;
    }

    private void Ql() {
        this.TRI.setVisibility(8);
        if (We(this.f28420qr) || ExN(this.f28420qr) || !We() || zY(this.f28420qr)) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "timeVisible", 0.0f, 1.0f);
        this.UFX = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(100L);
        this.UFX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.16
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) Xc.this.FI.getLayoutParams();
                layoutParams.weight = (float) (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.25d);
                Xc.this.sc((float) (1.0d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.2d)));
                Xc.this.FI.setLayoutParams(layoutParams);
            }
        });
        this.UFX.start();
    }

    public static /* synthetic */ int SR(Xc xc2) {
        int i11 = xc2.Yhz;
        xc2.Yhz = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void SR() {
        LinearLayout.LayoutParams layoutParams;
        if (this.Gb.get()) {
            return;
        }
        BT();
        this.qKn.set(true);
        this.OXF.Qj();
        com.bytedance.sdk.openadsdk.common.Tf tf2 = this.WP;
        if (tf2 != null) {
            tf2.pFF();
        }
        if (ExN(this.f28420qr)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), this.f28420qr, this.Cb, "show_agg_backup");
            View view = this.Xc;
            if (view != null) {
                view.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Xc.getLayoutParams();
                layoutParams2.addRule(13);
                layoutParams2.addRule(10, 0);
                this.Xc.setLayoutParams(layoutParams2);
                RelativeLayout relativeLayout = this.TRI;
                if (relativeLayout != null) {
                    relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        this.dE.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dE.getLayoutParams();
        layoutParams3.addRule(13);
        layoutParams3.addRule(10, 0);
        this.dE.setLayoutParams(layoutParams3);
        if (this.f28420qr.qfG() != null && !TextUtils.isEmpty(this.f28420qr.qfG().sc())) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.f28420qr.qfG().sc(), this.f28420qr.qfG().pFF(), this.f28420qr.qfG().zY(), this.YIK, this.f28420qr);
        }
        this.wjp.setText(this.f28420qr.MxZ());
        this.Sfl.setText(this.f28420qr.bSP());
        if (this.Dl != null) {
            pFF();
            this.Dl.setClickable(true);
            this.Dl.setOnClickListener(this.Ql);
            this.Dl.setOnTouchListener(this.Ql);
        }
        if (!zY(this.f28420qr) || (layoutParams = this.NQ) == null) {
            return;
        }
        if (layoutParams.weight < 30.0f) {
            zY(8);
        } else {
            zY(0);
        }
    }

    public static boolean TRI(Sfl sfl) {
        return We(sfl) && !Ol(sfl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        if (this.Gb.get() || this.qKn.get()) {
            return;
        }
        this.Gb.set(true);
        long jElapsedRealtime = this.DNB == -1 ? 0L : SystemClock.elapsedRealtime() - this.DNB;
        if (zY(this.f28420qr)) {
            com.bytedance.sdk.openadsdk.We.zY.zY(this.f28420qr, this.Cb, jElapsedRealtime);
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(this.f28420qr, this.Cb, System.currentTimeMillis() - this.HJN, true);
        Ql();
    }

    public static /* synthetic */ int UFX(Xc xc2) {
        int i11 = xc2.f28416eo;
        xc2.f28416eo = i11 + 1;
        return i11;
    }

    private void UFX() {
        HJN hjn = new HJN(this.cD);
        this.uEA = hjn;
        hjn.pFF(this.JPJ).zY(this.f28420qr.kDg()).We(this.f28420qr.mD()).sc(this.f28420qr).pFF(ExN(this.f28420qr) ? this.kX : -1).sc(this.f28420qr.BR()).pFF(this.Cb).ExN(this.f28420qr.BU()).sc(this.JPJ).sc(new com.bytedance.sdk.openadsdk.core.widget.TRI() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.15
            @Override // com.bytedance.sdk.openadsdk.core.widget.TRI
            public void sc() {
                if (Xc.ExN(Xc.this.f28420qr) && (Xc.this.cD instanceof com.bytedance.sdk.openadsdk.core.Ql.We.pFF)) {
                    ((com.bytedance.sdk.openadsdk.core.Ql.We.pFF) Xc.this.cD).c_();
                } else if (Xc.this.GI != null) {
                    Xc.this.GI.pFF();
                }
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void WH() {
        com.bytedance.sdk.openadsdk.common.Tf tf2;
        com.bytedance.sdk.component.Ol.We we2 = this.JPJ;
        if (we2 != null && we2.getWebView() != null) {
            com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()).sc(false).pFF(false).sc(this.JPJ.getWebView());
            com.bytedance.sdk.component.Ol.We we3 = this.JPJ;
            if (we3 != null && we3.getWebView() != null) {
                com.bytedance.sdk.openadsdk.We.UFX ufxSc = new com.bytedance.sdk.openadsdk.We.UFX(this.f28420qr, this.JPJ.getWebView(), new pFF(this.qfG, this.f28420qr, this.Cb, this), this.OKY).sc(true);
                this.JoC = ufxSc;
                ufxSc.sc(this.Cb);
                com.bytedance.sdk.openadsdk.common.We weSc = cJ.sc(this.f28420qr, this.JPJ, this.cD, this.Cb);
                this.f28418ko = weSc;
                if (weSc != null) {
                    weSc.sc(this.Cb);
                }
                cJ.sc(this.f28420qr, this.JPJ);
            }
            UFX();
            this.JPJ.setLandingPage(true);
            this.JPJ.setTag(this.Cb);
            this.JPJ.setMaterialMeta(this.f28420qr.bZj());
            com.bytedance.sdk.openadsdk.core.widget.sc.ExN exN = new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(com.bytedance.sdk.openadsdk.core.Xc.sc(), this.uEA, this.f28420qr.kDg(), this.f28418ko, this.JoC, true) { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.10
                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    Xc.this.Tf();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    Xc.this.OXF.UFX();
                    Xc.this.HJN = System.currentTimeMillis();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i11, String str, String str2) {
                    super.onReceivedError(webView, i11, str, str2);
                    String strWe = com.bytedance.sdk.openadsdk.core.widget.sc.ExN.We(str2);
                    boolean z11 = false;
                    if (this.TRI != null) {
                        this.TRI.sc(webView, i11, str, str2, com.bytedance.sdk.openadsdk.core.widget.sc.ExN.We(str2), (webView == null || str2 == null || !str2.equals(webView.getUrl())) ? false : true);
                    }
                    boolean z12 = strWe != null && strWe.startsWith("image");
                    if (strWe != null && strWe.startsWith("mp4")) {
                        z11 = true;
                    }
                    if (z12 || z11 || Xc.this.Gb.get()) {
                        return;
                    }
                    Xc.this.SR();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    if (sslErrorHandler != null) {
                        Xc.this.SR();
                    }
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                    try {
                        if (TextUtils.isEmpty(Xc.this.MxZ)) {
                            return super.shouldInterceptRequest(webView, str);
                        }
                        Xc.UFX(Xc.this);
                        WebResourceResponseModel webResourceResponseModelSc = com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(Xc.this.QLv, Xc.this.MxZ, str);
                        if (webResourceResponseModelSc != null && webResourceResponseModelSc.getWebResourceResponse() != null) {
                            Xc.Ql(Xc.this);
                            return webResourceResponseModelSc.getWebResourceResponse();
                        }
                        if (webResourceResponseModelSc != null && webResourceResponseModelSc.getMsg() == 2) {
                            Xc.SR(Xc.this);
                        }
                        return super.shouldInterceptRequest(webView, str);
                    } catch (Throwable th2) {
                        com.bytedance.sdk.component.utils.Tf.sc("LandingPageModel", "shouldInterceptRequest url error", th2);
                        return super.shouldInterceptRequest(webView, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (!Xc.zY(Xc.this.f28420qr) || cJ.sc(webView) != 1) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    Intent intent = new Intent(Xc.this.cD, (Class<?>) TTCeilingLandingPageActivity.class);
                    intent.putExtra("second_url", str);
                    com.bytedance.sdk.openadsdk.core.FI.sc().TRI();
                    com.bytedance.sdk.openadsdk.core.FI.sc().sc(Xc.this.f28420qr);
                    com.bytedance.sdk.component.utils.pFF.sc(this.We, intent, null);
                    return true;
                }
            };
            this.GI = exN;
            this.JPJ.setWebViewClient(exN);
            this.GI.sc(this.f28420qr);
            this.GI.sc(this.Cb);
            this.JPJ.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.uEA, this.JoC, this.f28418ko) { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.11
                @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i11) {
                    super.onProgressChanged(webView, i11);
                    if (Xc.this.cD != null && !Xc.this.cD.isFinishing() && i11 == 100) {
                        Xc.this.Tf();
                    }
                    if (Xc.this.WP != null) {
                        Xc.this.WP.sc(i11);
                    }
                }
            });
            if (this.BR == null) {
                this.BR = com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), this.f28420qr, this.Cb);
            }
            this.JPJ.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.12
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
                    if (Xc.this.BR != null) {
                        Xc.this.BR.We();
                    }
                }
            });
            com.bytedance.sdk.component.Ol.We we4 = this.JPJ;
            we4.setUserAgentString(com.bytedance.sdk.openadsdk.utils.Xc.sc(we4.getWebView(), BuildConfig.VERSION_CODE));
            int i11 = Build.VERSION.SDK_INT;
            this.JPJ.setMixedContentMode(0);
            if (i11 >= 23) {
                this.JPJ.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.13
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(View view, int i12, int i13, int i14, int i15) {
                        if (Xc.this.JoC != null) {
                            Xc.this.JoC.pFF(i13);
                        }
                    }
                });
            }
            this.JPJ.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.14
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (Xc.this.Ol()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            Xc.this.fT = motionEvent.getY();
                        } else if (action == 1) {
                            if (kX.sc(Xc.this.fT, motionEvent.getY(), Xc.this.cD)) {
                                Xc.this.sc(5);
                            }
                        } else if (action == 2) {
                            motionEvent.setAction(3);
                        }
                    }
                    if ((!Xc.this.f28419pc || Xc.Qj(Xc.this.f28420qr)) && !Xc.ExN(Xc.this.f28420qr)) {
                        Xc.this.SR.onTouch(view, motionEvent);
                    }
                    if ((!Xc.this.f28419pc || Xc.Qj(Xc.this.f28420qr)) && !Xc.ExN(Xc.this.f28420qr) && motionEvent.getAction() == 1 && Xc.this.SR.qr()) {
                        Xc.this.JPJ.getWebView().performClick();
                        Xc.this.f28419pc = true;
                    }
                    if (Xc.this.JoC != null) {
                        Xc.this.JoC.sc(motionEvent);
                    }
                    if (Xc.this.f28418ko == null) {
                        return false;
                    }
                    Xc.this.f28418ko.sc(motionEvent);
                    return false;
                }
            });
            this.JPJ.getWebView().setOnClickListener(this.SR);
            com.bytedance.sdk.openadsdk.We.zY.sc(this.f28420qr, this.Cb, this.OKY);
            com.bytedance.sdk.openadsdk.utils.Sfl.sc(this.JPJ, this.f28420qr.ko());
            this.CYO = true;
        }
        if (this.JPJ == null || (tf2 = this.WP) == null) {
            return;
        }
        tf2.sc();
    }

    public static boolean WH(Sfl sfl) {
        return (sfl == null || !com.bytedance.sdk.openadsdk.core.Xc.We().uEA() || !sfl.kX() || pFF(sfl) || We(sfl) || ExN(sfl)) ? false : true;
    }

    public static boolean We(Sfl sfl) {
        if (sfl == null) {
            return false;
        }
        if (Ol(sfl)) {
            return true;
        }
        return sfl.QLv() == 3 && sfl.Xc() == 5 && !JPJ.pFF(sfl) && (sfl.AZJ() == 0.0f || sfl.AZJ() == 100.0f);
    }

    private void Xc() {
        if (We()) {
            this.cvk.setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.II, "translationY", 16.0f, 0.0f).setDuration(500L);
            this.Ol = duration;
            duration.setRepeatMode(2);
            this.Ol.setRepeatCount(-1);
            this.Ol.start();
            this.cvk.setClickable(true);
            this.cvk.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!Xc.this.f28419pc) {
                        Xc.this.SR.onTouch(view, motionEvent);
                    }
                    if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                        return false;
                    }
                    Xc.this.WH = ObjectAnimator.ofFloat(this, "timeSlide", 0.0f, 1.0f);
                    Xc.this.WH.setDuration(200L);
                    Xc.this.WH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) Xc.this.FI.getLayoutParams();
                            layoutParams.weight = (float) (((double) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 2.07f)) + 0.25d);
                            Xc.this.sc((float) (0.800000011920929d - (((double) ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.5d)));
                            Xc.this.FI.setLayoutParams(layoutParams);
                        }
                    });
                    if (Xc.this.SR.qr()) {
                        Xc.this.cvk.performClick();
                        Xc.this.f28419pc = true;
                    }
                    Xc.this.WH.start();
                    Xc.this.cvk.setVisibility(8);
                    return true;
                }
            });
            this.cvk.setOnClickListener(this.SR);
        }
        if (!wjp()) {
            this.Qj.setVisibility(8);
            this.pFF.setVisibility(0);
            this.f28421sc.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f28421sc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Xc xc2 = Xc.this;
                    com.bytedance.sdk.openadsdk.We.zY.pFF(xc2.f28420qr, xc2.Cb);
                }
            });
            Sfl sfl = this.f28420qr;
            if (sfl != null && sfl.ht() != null && this.f28420qr.ht().size() > 0 && this.f28420qr.ht().get(0) != null && !TextUtils.isEmpty(this.f28420qr.ht().get(0).sc())) {
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.f28420qr.ht().get(0), this.f28421sc, this.f28420qr);
            }
        }
        try {
            String strSc = this.f28420qr.ht().get(0).sc();
            com.bytedance.sdk.openadsdk.Ol.We.sc().sc(strSc).sc(this.f28420qr.ht().get(0).pFF()).pFF(this.f28420qr.ht().get(0).zY()).ExN(kX.We(com.bytedance.sdk.openadsdk.core.Xc.sc())).We(kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc())).zY(2).sc(new sc()).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(this.f28420qr, strSc, new com.bytedance.sdk.component.ExN.dE<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.7
                @Override // com.bytedance.sdk.component.ExN.dE
                public void sc(int i11, String str, @Nullable Throwable th2) {
                }

                @Override // com.bytedance.sdk.component.ExN.dE
                public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
                    try {
                        Bitmap bitmapPFF = ufx.pFF();
                        if (bitmapPFF != null && ufx.zY() != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.Xc.sc().getResources(), bitmapPFF);
                            if (!Xc.this.wjp()) {
                                Xc.this.pFF.setBackground(bitmapDrawable);
                                return;
                            }
                            Xc.this.We.setBackground(bitmapDrawable);
                            View viewWH = Xc.this.OXF.WH();
                            if (viewWH == null || !(viewWH.getParent() instanceof View)) {
                                return;
                            }
                            ((View) viewWH.getParent()).setBackground(bitmapDrawable);
                        }
                    } catch (Exception unused) {
                    }
                }
            }));
        } catch (Exception unused) {
        }
    }

    private void dE() {
        com.bytedance.sdk.openadsdk.common.UFX loadingStyle;
        com.bytedance.sdk.openadsdk.common.Tf tf2 = this.WP;
        if (tf2 != null && (loadingStyle = tf2.getLoadingStyle()) != null) {
            this.YdT = loadingStyle.pFF();
            this.bSP = loadingStyle.zY();
        }
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = this.f28417ht;
        if (we2 != null) {
            we2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (Xc.this.f28417ht.getTag() != null) {
                        if (Xc.this.f28417ht.getTag().equals(1)) {
                            Xc.this.sc(3);
                        } else if (Xc.this.f28417ht.getTag().equals(2)) {
                            Xc.this.sc(4);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pFF(int i11) {
        return i11 == 1 || i11 == 2 || i11 == 4 || i11 == 5;
    }

    public static boolean pFF(Sfl sfl) {
        return sfl != null && sfl.QLv() == 3 && sfl.Xc() == 6 && !JPJ.pFF(sfl) && sfl.gx() == 1 && (sfl.AZJ() == 0.0f || sfl.AZJ() == 100.0f);
    }

    public static boolean qr(Sfl sfl) {
        return (sfl == null || sfl.TI() == 1 || !Qj(sfl)) ? false : true;
    }

    public static boolean sc(Sfl sfl) {
        if (sfl == null || Ol(sfl)) {
            return false;
        }
        return We(sfl) || pFF(sfl) || ExN(sfl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wjp() {
        return Sfl.ExN(this.f28420qr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(int i11) {
        kX.sc((View) this.YdT, i11);
        kX.sc((View) this.bSP, i11);
        if (this.qKn.get()) {
            kX.sc((View) this.wjp, i11);
            kX.sc((View) this.Sfl, i11);
            kX.sc((View) this.YIK, i11);
            kX.sc((View) this.Dl, 0);
        }
    }

    public static boolean zY(Sfl sfl) {
        return sfl != null && sfl.QLv() == 3 && sfl.wjp() == 38 && sfl.gx() == 1;
    }

    public void ExN() {
        FrameLayout frameLayout = this.FI;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            View view = this.McK;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public boolean Ol() {
        AtomicBoolean atomicBoolean;
        return (!zY(this.f28420qr) || (atomicBoolean = this.Bs) == null || atomicBoolean.get()) ? false : true;
    }

    public void Qj() {
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.JoC;
        if (ufx != null) {
            ufx.Qj();
        }
    }

    public void TRI() {
        com.bytedance.sdk.component.Ol.We we2;
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.JoC;
        if (ufx != null && (we2 = this.JPJ) != null) {
            ufx.sc(we2);
        }
        Handler handler = this.BT;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.WH;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.WH.cancel();
        }
        ObjectAnimator objectAnimator = this.UFX;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.UFX.cancel();
        }
        com.bytedance.sdk.openadsdk.common.Tf tf2 = this.WP;
        if (tf2 != null) {
            tf2.pFF();
        }
        ObjectAnimator objectAnimator2 = this.Ol;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        com.bytedance.sdk.component.Ol.We we3 = this.JPJ;
        if (we3 != null) {
            Cb.sc(we3.getWebView());
        }
        this.JPJ = null;
        HJN hjn = this.uEA;
        if (hjn != null) {
            hjn.UFX();
        }
        com.bytedance.sdk.openadsdk.We.UFX ufx2 = this.JoC;
        if (ufx2 != null) {
            ufx2.zY(true);
        }
        if (!TextUtils.isEmpty(this.MxZ) && this.CYO) {
            com.bytedance.sdk.openadsdk.We.zY.sc.sc(this.yL, this.f28416eo, this.f28420qr);
        }
        com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(this.QLv);
    }

    public boolean We() {
        return this.f28420qr.dix() == 15 || this.f28420qr.dix() == 16;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        long jWe;
        Sfl sfl;
        Sfl sfl2;
        if (message.what == 100) {
            int i11 = message.arg1;
            if (!We(this.f28420qr) || (sfl2 = this.f28420qr) == null || sfl2.Ol() == null) {
                jWe = (!ExN(this.f28420qr) || (sfl = this.f28420qr) == null || sfl.Ol() == null) ? 20L : this.f28420qr.Ol().We();
            } else {
                jWe = this.f28420qr.Ol().pFF();
            }
            c.InterfaceC0849c interfaceC0849c = this.Tf;
            if (interfaceC0849c != null) {
                interfaceC0849c.sc(((long) i11) * 1000, jWe * 1000);
            }
            long j11 = i11;
            if (j11 >= jWe) {
                c.InterfaceC0849c interfaceC0849c2 = this.Tf;
                if (interfaceC0849c2 != null) {
                    interfaceC0849c2.sc(jWe * 1000, 100);
                }
            } else if (j11 < jWe && this.BT != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                messageObtain.arg1 = i11 + 1;
                this.BT.sendMessageDelayed(messageObtain, 1000L);
            }
        }
        return true;
    }

    public void pFF() {
        Sfl sfl = this.f28420qr;
        if (sfl == null || TextUtils.isEmpty(sfl.NQ())) {
            return;
        }
        this.Dl.setText(this.f28420qr.NQ());
    }

    public void qr() {
        HJN hjn = this.uEA;
        if (hjn != null) {
            hjn.WH();
        }
        com.bytedance.sdk.openadsdk.We.UFX ufx = this.JoC;
        if (ufx != null) {
            ufx.qr();
        }
    }

    public void sc() {
        View view;
        Long lValueOf = Long.valueOf(SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.Ol.We we2 = (com.bytedance.sdk.component.Ol.We) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Dl);
        this.JPJ = we2;
        if (we2 == null || Sfl.sc(this.f28420qr)) {
            kX.sc((View) this.JPJ, 8);
        } else {
            this.JPJ.f_();
        }
        this.FI = (FrameLayout) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.YIK);
        this.WP = (com.bytedance.sdk.openadsdk.common.Tf) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.WP);
        this.cvk = this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.uEA);
        this.II = (ImageView) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.JPJ);
        this.McK = this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.OXF);
        this.pFF = (FrameLayout) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.wjp);
        this.f28421sc = (ImageView) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Sfl);
        this.TRI = (RelativeLayout) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.FI);
        this.zY = (TextView) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.AIZ);
        this.We = (FrameLayout) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.WH);
        View viewFindViewById = this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.cvk);
        this.dE = viewFindViewById;
        if (viewFindViewById == null) {
            this.dE = this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.kX);
        }
        this.Xc = this.cD.findViewById(com.bytedance.sdk.openadsdk.utils.SR.II);
        this.wjp = (TextView) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.HJN);
        this.Sfl = (TextView) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Gb);
        this.YIK = (com.bytedance.sdk.openadsdk.core.widget.Xc) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.McK);
        this.Dl = (TextView) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.cD);
        if (this.zY != null && this.f28420qr.Ol() != null) {
            this.zY.setText(this.f28420qr.Ol().ExN());
        }
        this.ExN = this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Cb);
        this.f28417ht = (com.bytedance.sdk.openadsdk.core.ExN.We) this.cJ.findViewById(com.bytedance.sdk.openadsdk.utils.SR.yQN);
        if ((We(this.f28420qr) || pFF(this.f28420qr) || ExN(this.f28420qr) || zY(this.f28420qr)) && this.f28420qr.Ol() != null) {
            View view2 = this.ExN;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.SR.zY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.9
                @Override // java.lang.Runnable
                public void run() {
                    if (Xc.this.Gb.get()) {
                        return;
                    }
                    Xc xc2 = Xc.this;
                    com.bytedance.sdk.openadsdk.We.zY.sc(xc2.f28420qr, xc2.Cb, System.currentTimeMillis() - Xc.this.HJN, false);
                    Xc.this.SR();
                }
            }, (ExN(this.f28420qr) ? this.f28420qr.Ol().zY() : this.f28420qr.Ol().sc()) * 1000);
        }
        WH();
        if (pFF(this.f28420qr)) {
            Xc();
            if (!We()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.FI.getLayoutParams();
                layoutParams.weight = 2.33f;
                this.FI.setLayoutParams(layoutParams);
            }
        }
        if ((We(this.f28420qr) || ExN(this.f28420qr)) && (view = this.McK) != null) {
            view.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.common.Tf tf2 = this.WP;
        if (tf2 != null) {
            tf2.sc(this.f28420qr);
        }
        if (zY(this.f28420qr)) {
            dE();
        }
        com.bytedance.sdk.openadsdk.We.zY.sc.sc(SystemClock.elapsedRealtime() - lValueOf.longValue(), this.f28420qr, this.Cb, this.QLv, this.MxZ);
    }

    public void sc(float f11) {
        try {
            this.OXF.Ol();
        } catch (Throwable unused) {
        }
    }

    public void sc(int i11) {
        com.bytedance.sdk.openadsdk.core.Qj.Sfl sfl = this.ZM;
        if (sfl != null) {
            sfl.ExN(i11);
        }
    }

    public void sc(final int i11, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
        final float f11;
        int iZY;
        if (i11 == 3 || pFF(i11)) {
            if (this.idT == null || sr2 == null) {
                return;
            }
            AtomicBoolean atomicBoolean = this.Bs;
            if (atomicBoolean != null) {
                if (i11 == 1) {
                    return;
                }
                if (i11 == 5 && atomicBoolean.get()) {
                    return;
                }
            }
            final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.McK.getLayoutParams();
            this.NQ = (LinearLayout.LayoutParams) this.FI.getLayoutParams();
            final float f12 = layoutParams.weight;
            dE dEVarWH = this.f28420qr.WH();
            if (pFF(i11)) {
                if (dEVarWH != null) {
                    iZY = dEVarWH.pFF();
                    f11 = iZY;
                } else {
                    f11 = 30.0f;
                }
            } else if (dEVarWH != null) {
                iZY = dEVarWH.zY();
                f11 = iZY;
            } else {
                f11 = 70.0f;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.idT.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            final FrameLayout.LayoutParams layoutParams3 = layoutParams2;
            final int i12 = layoutParams3.height;
            final int i13 = layoutParams3.width;
            final int i14 = layoutParams3.leftMargin;
            final int i15 = layoutParams3.topMargin;
            final int iZY2 = kX.zY(this.cD, (float) sr2.Qj());
            final int iZY3 = kX.zY(this.cD, (float) sr2.Ol());
            final int iZY4 = kX.zY(this.cD, (float) sr2.TRI());
            final int iZY5 = kX.zY(this.cD, (float) sr2.qr());
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.WH = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(500L);
            this.WH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout.LayoutParams layoutParams4 = layoutParams;
                    float f13 = f12;
                    layoutParams4.weight = f13 + ((f11 - f13) * fFloatValue);
                    Xc.this.NQ.weight = 100.0f - layoutParams.weight;
                    if (Xc.this.McK != null) {
                        Xc.this.McK.setLayoutParams(layoutParams);
                    }
                    if (Xc.this.FI != null) {
                        Xc.this.FI.setLayoutParams(Xc.this.NQ);
                    }
                    if (Xc.this.NQ.weight < 30.0f) {
                        Xc.this.zY(8);
                    } else {
                        Xc.this.zY(0);
                    }
                    FrameLayout.LayoutParams layoutParams5 = layoutParams3;
                    int i16 = i13;
                    layoutParams5.width = i16 + ((int) ((iZY2 - i16) * fFloatValue));
                    int i17 = i12;
                    layoutParams5.height = i17 + ((int) ((iZY3 - i17) * fFloatValue));
                    int i18 = i14;
                    layoutParams5.leftMargin = i18 + ((int) ((iZY4 - i18) * fFloatValue));
                    int i19 = i15;
                    layoutParams5.topMargin = i19 + ((int) ((iZY5 - i19) * fFloatValue));
                    if (Xc.this.idT != null) {
                        Xc.this.idT.setLayoutParams(layoutParams3);
                    }
                    Xc.this.sc(0.0f);
                    if (fFloatValue == 1.0f) {
                        if (Xc.this.f28417ht != null) {
                            kX.sc((View) Xc.this.f28417ht, 0);
                            if (Xc.this.pFF(i11)) {
                                Xc.this.f28417ht.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(Xc.this.cD, "tt_ad_zoom_down"));
                                Xc.this.f28417ht.setTag(1);
                            } else {
                                Xc.this.f28417ht.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(Xc.this.cD, "tt_ad_zoom_up"));
                                Xc.this.f28417ht.setTag(2);
                            }
                        }
                        if (Xc.this.Bs == null) {
                            Xc.this.Bs = new AtomicBoolean();
                        }
                        Xc.this.Bs.set(Xc.this.pFF(i11));
                    }
                }
            });
            com.bytedance.sdk.openadsdk.We.zY.We(this.f28420qr, this.Cb, i11);
            this.WH.start();
            if (this.kDg.compareAndSet(false, true)) {
                this.DNB = SystemClock.elapsedRealtime();
            }
            kX.sc((View) this.f28417ht, 8);
        }
    }

    public void sc(@NonNull com.bytedance.sdk.openadsdk.core.Qj.Sfl sfl, FrameLayout frameLayout) {
        this.ZM = sfl;
        this.idT = frameLayout;
    }

    public void sc(c.InterfaceC0849c interfaceC0849c) {
        this.Tf = interfaceC0849c;
    }

    public void zY() {
        if (wjp()) {
            try {
                String strR = this.f28420qr.GI().r();
                com.bytedance.sdk.openadsdk.Ol.We.sc().sc(strR).sc(this.f28420qr.GI().L()).pFF(this.f28420qr.GI().z()).ExN(kX.We(com.bytedance.sdk.openadsdk.core.Xc.sc())).We(kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc())).zY(2).sc(new sc()).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(this.f28420qr, strR, new com.bytedance.sdk.component.ExN.dE<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.model.Xc.4
                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(int i11, String str, @Nullable Throwable th2) {
                    }

                    @Override // com.bytedance.sdk.component.ExN.dE
                    public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
                        try {
                            Bitmap bitmapPFF = ufx.pFF();
                            if (bitmapPFF != null && ufx.zY() != null) {
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(com.bytedance.sdk.openadsdk.core.Xc.sc().getResources(), bitmapPFF);
                                View viewWH = Xc.this.OXF.WH();
                                if (viewWH == null || !(viewWH.getParent() instanceof View)) {
                                    return;
                                }
                                ((View) viewWH.getParent()).setBackground(bitmapDrawable);
                            }
                        } catch (Throwable th2) {
                            com.bytedance.sdk.component.utils.Tf.sc("LandingPageModel", th2.getMessage());
                        }
                    }
                }));
            } catch (Exception unused) {
            }
        }
    }
}
