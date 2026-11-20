package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.We.UFX;
import com.bytedance.sdk.openadsdk.common.BT;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.Tf;
import com.bytedance.sdk.openadsdk.common.dE;
import com.bytedance.sdk.openadsdk.core.ExN.Qj;
import com.bytedance.sdk.openadsdk.core.ExN.qr;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity {
    private long Bs;
    private com.bytedance.sdk.openadsdk.common.We DNB;
    private PAGLogoView NP;
    private dE NQ;
    private Tf OKY;
    private boolean ZM;
    private boolean bSP;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    BT f27597eo;
    private TextView fT;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private View f27598ht;
    private TextView idT;
    private LinearLayout kDg;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private View f27599ko;
    private com.bytedance.sdk.openadsdk.core.widget.sc.ExN otH;
    TTAdDislikeToast yL;
    private boolean YdT = false;
    final AtomicBoolean Yhz = new AtomicBoolean(false);
    final AtomicBoolean qfG = new AtomicBoolean(false);

    private void BT() {
        TTAdDislikeToast tTAdDislikeToast = this.yL;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql() {
        com.bytedance.sdk.openadsdk.We.zY.sc(this.dE, "landingpage_split_screen", "click_video", (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SR() {
        Tf tf2 = this.OKY;
        if (tf2 != null) {
            tf2.pFF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.yL) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }

    private void dE() {
        try {
            if (this.f27597eo == null) {
                BT bt2 = new BT(this.ExN, this.dE);
                this.f27597eo = bt2;
                bt2.setDislikeSource("landing_page");
                this.f27597eo.setCallback(new BT.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.6
                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void pFF(View view) {
                        TTVideoLandingPageLink2Activity.this.Yhz.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void sc(View view) {
                        TTVideoLandingPageLink2Activity.this.Yhz.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                    public void sc(FilterWord filterWord) {
                        if (TTVideoLandingPageLink2Activity.this.qfG.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTVideoLandingPageLink2Activity.this.qfG.set(true);
                        TTVideoLandingPageLink2Activity.this.Xc();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.f27597eo);
            if (this.yL == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.ExN);
                this.yL = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th2) {
            ApmHelper.reportCustomError("initDislike error", "TTVideoLandingPageLink2Activity", th2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public boolean ExN() {
        int i11 = this.Ql;
        return i11 == 5 || i11 == 15 || i11 == 50;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    @SuppressLint({"ClickableViewAccessibility"})
    public void Ol() {
        super.Ol();
        Sfl sfl = this.dE;
        if (sfl != null) {
            sfl.TRI(true);
        }
        TextView textView = this.fT;
        if (textView != null) {
            textView.setText(pFF());
            this.fT.setClickable(true);
            this.fT.setOnClickListener(this.QLv);
            this.fT.setOnTouchListener(this.QLv);
        }
    }

    public void Tf() {
        if (isFinishing()) {
            return;
        }
        if (this.qfG.get()) {
            BT();
            return;
        }
        if (this.f27597eo == null) {
            dE();
        }
        BT bt2 = this.f27597eo;
        if (bt2 != null) {
            bt2.sc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    @SuppressLint({"ClickableViewAccessibility"})
    public void We() {
        if (!ExN()) {
            try {
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.dE.ht().get(0), imageView, this.dE);
                this.Tf.setVisibility(0);
                this.Tf.removeAllViews();
                this.Tf.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.bytedance.sdk.openadsdk.We.zY.pFF(TTVideoLandingPageLink2Activity.this.dE, "landingpage_split_screen");
                    }
                });
                return;
            } catch (Exception unused) {
                return;
            }
        }
        super.We();
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri = this.SR;
        if (tri != null) {
            if (tri.getNativeVideoController() != null) {
                this.SR.getNativeVideoController().sc(false);
                ((com.bytedance.sdk.openadsdk.core.Ql.pFF.zY) this.SR.getNativeVideoController()).qr(false);
                this.Tf.setClickable(true);
                this.Tf.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() != 0) {
                            return false;
                        }
                        TTVideoLandingPageLink2Activity.this.Ql();
                        return false;
                    }
                });
            }
            this.SR.getNativeVideoController().sc(new c.InterfaceC0849c() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.4
                @Override // t8.c.InterfaceC0849c
                public void pFF(long j11, int i11) {
                }

                @Override // t8.c.InterfaceC0849c
                public void sc() {
                }

                @Override // t8.c.InterfaceC0849c
                public void sc(long j11, int i11) {
                }

                @Override // t8.c.InterfaceC0849c
                public void sc(long j11, long j12) {
                    if (TTVideoLandingPageLink2Activity.this.idT != null) {
                        int iMax = (int) Math.max(0L, (j12 - j11) / 1000);
                        TTVideoLandingPageLink2Activity.this.idT.setText(String.valueOf(iMax));
                        if (iMax <= 0) {
                            TTVideoLandingPageLink2Activity.this.idT.setVisibility(8);
                        }
                    }
                }
            });
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Tf tf2 = this.OKY;
        if (tf2 != null) {
            tf2.sc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Sfl sfl;
        com.bytedance.sdk.component.Ol.We we2;
        super.onCreate(bundle);
        if (!SR.ExN() || (sfl = this.dE) == null || (we2 = this.f27583sc) == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.common.We weSc = cJ.sc(sfl, we2, this.ExN, this.cD);
        this.DNB = weSc;
        if (weSc != null) {
            weSc.sc("landingpage_split_screen");
        }
        this.bSP = Xc.We().uEA();
        if (this.f27583sc.getWebView() != null && Build.VERSION.SDK_INT >= 23) {
            this.f27583sc.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                    UFX ufx = TTVideoLandingPageLink2Activity.this.CYO;
                    if (ufx != null) {
                        ufx.pFF(i12);
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.widget.sc.ExN exN = new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(this.ExN, this.WH, this.Qj, this.DNB, this.CYO, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoLandingPageLink2Activity.this.f27599ko != null && !TTVideoLandingPageLink2Activity.this.ZM) {
                        TTVideoLandingPageLink2Activity.this.f27599ko.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.kDg != null) {
                        TTVideoLandingPageLink2Activity.this.kDg.setVisibility(0);
                    }
                    TTVideoLandingPageLink2Activity.this.YdT = true;
                    TTVideoLandingPageLink2Activity.this.SR();
                    TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
                    com.bytedance.sdk.openadsdk.We.zY.sc(tTVideoLandingPageLink2Activity.dE, tTVideoLandingPageLink2Activity.cD, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.Bs, true);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                TTVideoLandingPageLink2Activity.this.Bs = System.currentTimeMillis();
            }
        };
        this.otH = exN;
        exN.sc(this.dE);
        this.f27583sc.setWebViewClient(this.otH);
        this.f27583sc.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.WH, this.CYO, this.DNB) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.8
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                super.onProgressChanged(webView, i11);
                if (TTVideoLandingPageLink2Activity.this.bSP && TTVideoLandingPageLink2Activity.this.NQ != null && i11 == 100) {
                    TTVideoLandingPageLink2Activity.this.NQ.sc(webView, TTVideoLandingPageLink2Activity.this.MxZ);
                }
                if (TTVideoLandingPageLink2Activity.this.OKY != null) {
                    TTVideoLandingPageLink2Activity.this.OKY.sc(i11);
                }
            }
        });
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.AIZ);
        if (textView != null && this.dE.Ol() != null) {
            textView.setText(this.dE.Ol().ExN());
        }
        Sfl sfl2 = this.dE;
        SR.zY().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTVideoLandingPageLink2Activity.this.ZM = true;
                    if (TTVideoLandingPageLink2Activity.this.OKY != null) {
                        TTVideoLandingPageLink2Activity.this.OKY.pFF();
                    }
                    TTVideoLandingPageLink2Activity.this.f27598ht.setVisibility(0);
                    if (TTVideoLandingPageLink2Activity.this.NP != null) {
                        TTVideoLandingPageLink2Activity.this.NP.setVisibility(0);
                    }
                    if (TTVideoLandingPageLink2Activity.this.YdT) {
                        return;
                    }
                    TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
                    com.bytedance.sdk.openadsdk.We.zY.sc(tTVideoLandingPageLink2Activity.dE, tTVideoLandingPageLink2Activity.cD, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.Bs, false);
                } catch (Exception unused) {
                }
            }
        }, (sfl2 == null || sfl2.Ol() == null) ? 10000L : this.dE.Ol().sc() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, android.app.Activity
    public void onDestroy() {
        SR();
        if (!this.ZM && this.CYO != null && this.f27583sc != null && this.OKY.getVisibility() == 8) {
            this.CYO.sc(this.f27583sc);
        }
        super.onDestroy();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public View sc() {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(this);
        if (Build.VERSION.SDK_INT >= 35) {
            exN.setFitsSystemWindows(true);
        }
        exN.setOrientation(1);
        exN.setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(this);
        exN.addView(zYVar, new LinearLayout.LayoutParams(-1, kX.zY(this, 220.0f)));
        View zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(this);
        zYVar2.setId(com.bytedance.sdk.openadsdk.utils.SR.BR);
        zYVar.addView(zYVar2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN2 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(this);
        exN2.setOrientation(0);
        exN2.setPadding(0, kX.zY(this, 20.0f), 0, 0);
        zYVar.addView(exN2, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        exN2.addView(view, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.BT bt2 = new com.bytedance.sdk.openadsdk.core.widget.BT(this);
        bt2.setId(520093713);
        bt2.setGravity(17);
        bt2.setText(com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_reward_feedback"));
        bt2.setTextColor(-1);
        bt2.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, kX.zY(this, 28.0f));
        int iZY = kX.zY(this, 16.0f);
        layoutParams2.rightMargin = iZY;
        layoutParams2.leftMargin = iZY;
        exN2.addView(bt2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.widget.SR sr2 = new com.bytedance.sdk.openadsdk.core.widget.SR(this);
        sr2.setId(com.bytedance.sdk.openadsdk.utils.SR.JoC);
        sr2.setPadding(kX.zY(this, 7.0f), kX.zY(this, 7.0f), kX.zY(this, 7.0f), kX.zY(this, 7.0f));
        sr2.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(this, "tt_video_close_drawable"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(kX.zY(this, 28.0f), kX.zY(this, 28.0f));
        layoutParams3.rightMargin = kX.zY(this, 12.0f);
        exN2.addView(sr2, layoutParams3);
        qr qrVar = new qr(this);
        qrVar.setVisibility(8);
        qrVar.setId(com.bytedance.sdk.openadsdk.utils.SR.CYO);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = kX.zY(this, 10.0f);
        exN.addView(qrVar, layoutParams4);
        com.bytedance.sdk.openadsdk.core.widget.sc scVar = new com.bytedance.sdk.openadsdk.core.widget.sc(this);
        scVar.setId(com.bytedance.sdk.openadsdk.utils.SR.qKn);
        scVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        scVar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(kX.zY(this, 44.0f), kX.zY(this, 44.0f));
        layoutParams5.addRule(9);
        layoutParams5.leftMargin = kX.zY(this, 5.0f);
        qrVar.addView(scVar, layoutParams5);
        Qj qj2 = new Qj(this);
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.f28751pc;
        qj2.setId(i11);
        qj2.setBackground(Ol.sc(this, "tt_circle_solid_mian"));
        qj2.setGravity(17);
        qj2.setTextColor(-1);
        qj2.setTextSize(2, 19.0f);
        qj2.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(kX.zY(this, 44.0f), kX.zY(this, 44.0f));
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = kX.zY(this, 5.0f);
        qrVar.addView(qj2, layoutParams6);
        Qj qj3 = new Qj(this);
        qj3.setId(com.bytedance.sdk.openadsdk.utils.SR.GI);
        qj3.setMaxLines(1);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        qj3.setEllipsize(truncateAt);
        qj3.setTextColor(Color.parseColor("#e5000000"));
        qj3.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = kX.zY(this, 5.0f);
        layoutParams7.rightMargin = kX.zY(this, 80.0f);
        layoutParams7.addRule(1, i11);
        qrVar.addView(qj3, layoutParams7);
        Qj qj4 = new Qj(this);
        qj4.setId(com.bytedance.sdk.openadsdk.utils.SR.MxZ);
        qj4.setClickable(true);
        qj4.setMaxLines(1);
        qj4.setEllipsize(truncateAt);
        qj4.setFocusable(true);
        qj4.setGravity(17);
        qj4.setText(com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_video_mobile_go_detail"));
        qj4.setTextColor(-1);
        qj4.setTextSize(2, 14.0f);
        qj4.setPadding(kX.zY(this, 2.0f), kX.zY(this, 2.0f), kX.zY(this, 2.0f), kX.zY(this, 2.0f));
        qj4.setBackground(Ol.sc(this, "tt_ad_cover_btn_begin_bg"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(kX.zY(this, 90.0f), kX.zY(this, 36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = kX.zY(this, 5.0f);
        qrVar.addView(qj4, layoutParams8);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar3 = new com.bytedance.sdk.openadsdk.core.ExN.zY(this);
        exN.addView(zYVar3, new LinearLayout.LayoutParams(-1, -1));
        View we2 = new com.bytedance.sdk.component.Ol.We(this);
        we2.setId(com.bytedance.sdk.openadsdk.utils.SR.QLv);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.topMargin = kX.zY(this, 2.0f);
        zYVar3.addView(we2, layoutParams9);
        qr qrVar2 = new qr(this);
        qrVar2.setId(com.bytedance.sdk.openadsdk.utils.SR.f28746eo);
        qrVar2.setBackgroundColor(Color.parseColor("#F8F8F8"));
        zYVar3.addView(qrVar2, new FrameLayout.LayoutParams(-1, -1));
        View tf2 = new Tf(this);
        tf2.setId(com.bytedance.sdk.openadsdk.utils.SR.yL);
        qrVar2.addView(tf2, new RelativeLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN3 = new com.bytedance.sdk.openadsdk.core.ExN.ExN(this);
        exN3.setId(com.bytedance.sdk.openadsdk.utils.SR.kX);
        exN3.setOrientation(1);
        exN3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(13);
        qrVar2.addView(exN3, layoutParams10);
        com.bytedance.sdk.openadsdk.core.widget.Xc xc2 = new com.bytedance.sdk.openadsdk.core.widget.Xc(this);
        xc2.setId(com.bytedance.sdk.openadsdk.utils.SR.Yhz);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(kX.zY(this, 80.0f), kX.zY(this, 80.0f));
        layoutParams11.gravity = 17;
        exN3.addView(xc2, layoutParams11);
        Qj qj5 = new Qj(this);
        qj5.setId(com.bytedance.sdk.openadsdk.utils.SR.qfG);
        qj5.setTextColor(Color.parseColor("#161823"));
        qj5.setTextSize(0, kX.zY(this, 24.0f));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.gravity = 17;
        layoutParams12.topMargin = kX.zY(this, 12.0f);
        exN3.addView(qj5, layoutParams12);
        Qj qj6 = new Qj(this);
        qj6.setId(com.bytedance.sdk.openadsdk.utils.SR.OKY);
        qj6.setTextColor(Color.parseColor("#80161823"));
        qj6.setTextSize(0, kX.zY(this, 16.0f));
        qj6.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 17;
        int iZY2 = kX.zY(this, 60.0f);
        layoutParams13.rightMargin = iZY2;
        layoutParams13.leftMargin = iZY2;
        layoutParams13.topMargin = kX.zY(this, 8.0f);
        exN3.addView(qj6, layoutParams13);
        Qj qj7 = new Qj(this);
        qj7.setId(com.bytedance.sdk.openadsdk.utils.SR.f28750ko);
        qj7.setGravity(17);
        qj7.setTextColor(-1);
        qj7.setText(com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_video_mobile_go_detail"));
        qj7.setBackground(Ol.sc(this, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(kX.zY(this, 255.0f), kX.zY(this, 44.0f));
        layoutParams14.gravity = 17;
        layoutParams14.topMargin = kX.zY(this, 32.0f);
        exN3.addView(qj7, layoutParams14);
        PAGLogoView pAGLogoView = new PAGLogoView(this);
        this.NP = pAGLogoView;
        pAGLogoView.setId(com.bytedance.sdk.openadsdk.utils.SR.f28749ht);
        this.NP.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, kX.zY(this, 14.0f));
        layoutParams15.addRule(12);
        layoutParams15.leftMargin = kX.zY(this, 18.0f);
        layoutParams15.bottomMargin = kX.zY(this, 61.0f);
        qrVar2.addView(this.NP, layoutParams15);
        View sr3 = new com.bytedance.sdk.openadsdk.common.SR(this, new com.bytedance.sdk.openadsdk.common.SR.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.10
            @Override // com.bytedance.sdk.openadsdk.common.SR.sc
            public View sc(Context context) {
                return new com.bytedance.sdk.openadsdk.common.qr(context);
            }
        });
        sr3.setId(com.bytedance.sdk.openadsdk.utils.SR.ZM);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-1, kX.zY(this, 48.0f));
        layoutParams16.gravity = 81;
        zYVar3.addView(sr3, layoutParams16);
        View sr4 = new com.bytedance.sdk.openadsdk.common.SR(this, new com.bytedance.sdk.openadsdk.common.SR.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.11
            @Override // com.bytedance.sdk.openadsdk.common.SR.sc
            public View sc(Context context) {
                return new com.bytedance.sdk.openadsdk.common.Qj(context);
            }
        });
        sr4.setId(com.bytedance.sdk.openadsdk.utils.SR.idT);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, kX.zY(this, 44.0f));
        layoutParams17.gravity = 80;
        zYVar3.addView(sr4, layoutParams17);
        return exN;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    @SuppressLint({"ClickableViewAccessibility"})
    public void zY() {
        super.zY();
        TextView textView = (TextView) findViewById(520093713);
        if (textView != null) {
            textView.setText(com.bytedance.sdk.component.utils.Sfl.sc(Xc.sc(), "tt_reward_feedback"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoLandingPageLink2Activity.this.Tf();
                }
            });
        }
        this.idT = (TextView) findViewById(520093714);
        this.OKY = (Tf) findViewById(com.bytedance.sdk.openadsdk.utils.SR.yL);
        this.f27599ko = findViewById(com.bytedance.sdk.openadsdk.utils.SR.f28746eo);
        this.f27598ht = findViewById(com.bytedance.sdk.openadsdk.utils.SR.kX);
        TextView textView2 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.qfG);
        TextView textView3 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.OKY);
        com.bytedance.sdk.openadsdk.core.widget.Xc xc2 = (com.bytedance.sdk.openadsdk.core.widget.Xc) findViewById(com.bytedance.sdk.openadsdk.utils.SR.Yhz);
        this.fT = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.SR.f28750ko);
        if (this.dE.qfG() != null && !TextUtils.isEmpty(this.dE.qfG().sc())) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.dE.qfG(), xc2, this.dE);
        }
        textView2.setText(this.dE.MxZ());
        textView3.setText(this.dE.bSP());
        findViewById(com.bytedance.sdk.openadsdk.utils.SR.f28749ht).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTVideoLandingPageLink2Activity tTVideoLandingPageLink2Activity = TTVideoLandingPageLink2Activity.this;
                TTWebsiteActivity.sc(tTVideoLandingPageLink2Activity.ExN, tTVideoLandingPageLink2Activity.dE, tTVideoLandingPageLink2Activity.cD);
            }
        });
        com.bytedance.sdk.component.Ol.We we2 = this.f27583sc;
        if (we2 != null && we2.getWebView() != null) {
            cJ.sc(this.dE, this.f27583sc);
        }
        boolean zUEA = Xc.We().uEA();
        this.bSP = zUEA;
        if (zUEA) {
            ((com.bytedance.sdk.openadsdk.common.SR) findViewById(com.bytedance.sdk.openadsdk.utils.SR.idT)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.SR.mD);
            this.kDg = linearLayout;
            linearLayout.setVisibility(8);
            this.NQ = new dE(this, this.kDg, this.f27583sc, this.dE, "landingpage_split_screen");
            if (this.f27583sc.getWebView() != null) {
                this.f27583sc.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.14

                    /* JADX INFO: renamed from: sc, reason: collision with root package name */
                    float f27605sc = 0.0f;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            this.f27605sc = motionEvent.getY();
                        }
                        UFX ufx = TTVideoLandingPageLink2Activity.this.CYO;
                        if (ufx != null) {
                            ufx.sc(motionEvent);
                        }
                        if (TTVideoLandingPageLink2Activity.this.DNB != null) {
                            TTVideoLandingPageLink2Activity.this.DNB.sc(motionEvent);
                        }
                        if (motionEvent.getAction() == 2) {
                            float y11 = motionEvent.getY();
                            float f11 = this.f27605sc;
                            if (y11 - f11 > 8.0f) {
                                if (TTVideoLandingPageLink2Activity.this.NQ != null) {
                                    TTVideoLandingPageLink2Activity.this.NQ.sc();
                                }
                                return false;
                            }
                            if (y11 - f11 < -8.0f && TTVideoLandingPageLink2Activity.this.NQ != null) {
                                TTVideoLandingPageLink2Activity.this.NQ.pFF();
                            }
                        }
                        return false;
                    }
                });
            }
        } else if (this.f27583sc.getWebView() != null) {
            this.f27583sc.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    UFX ufx = TTVideoLandingPageLink2Activity.this.CYO;
                    if (ufx != null) {
                        ufx.sc(motionEvent);
                    }
                    if (TTVideoLandingPageLink2Activity.this.DNB == null) {
                        return false;
                    }
                    TTVideoLandingPageLink2Activity.this.DNB.sc(motionEvent);
                    return false;
                }
            });
        }
        Tf tf2 = this.OKY;
        if (tf2 != null) {
            tf2.sc(this.dE);
        }
    }
}
