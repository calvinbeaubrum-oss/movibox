package com.bytedance.sdk.openadsdk.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.We.UFX;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.dE;
import com.bytedance.sdk.openadsdk.core.widget.qr;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTCeilingLandingPageActivity extends TTBaseActivity {
    private String ExN;
    private UFX Ol;
    private String Qj;
    private int TRI;
    private com.bytedance.sdk.component.Ol.We UFX;
    private com.bytedance.sdk.openadsdk.common.We WH;
    private String We;
    private Sfl pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    sc f27520sc;
    private HJN zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc();
    }

    private void sc() {
        HJN hjn = new HJN(this);
        this.zY = hjn;
        hjn.pFF(this.UFX).zY(this.We).We(this.ExN).sc(this.pFF).pFF(this.TRI).sc(this.pFF.BR()).ExN(this.pFF.BU()).sc(this.UFX).pFF("landingpage_split_ceiling");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void sc(Context context, FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.core.ExN.We we2;
        this.UFX = new com.bytedance.sdk.component.Ol.We(context);
        frameLayout.addView(this.UFX, new FrameLayout.LayoutParams(-1, -1));
        View viewPFF = qr.pFF(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams.topMargin = kX.zY(context, 18.0f);
        layoutParams.rightMargin = kX.zY(context, 18.0f);
        frameLayout.addView(viewPFF, layoutParams);
        final int iWe = this.pFF.WH().We();
        if (iWe != 3) {
            we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(kX.zY(context, 28.0f), kX.zY(context, 28.0f));
            layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
            layoutParams2.topMargin = kX.zY(context, 18.0f);
            layoutParams2.leftMargin = kX.zY(context, 18.0f);
            int iZY = kX.zY(context, 5.0f);
            we2.setPadding(iZY, iZY, iZY, iZY);
            we2.setScaleType(ImageView.ScaleType.FIT_XY);
            we2.setBackground(com.bytedance.sdk.openadsdk.core.widget.We.sc());
            we2.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_white_lefterbackicon_titlebar"));
            frameLayout.addView(we2, layoutParams2);
        } else {
            we2 = null;
        }
        com.bytedance.sdk.openadsdk.utils.Sfl.sc(this.UFX, this.Qj);
        final WebView webView = this.UFX.getWebView();
        viewPFF.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTCeilingLandingPageActivity.this.finish();
            }
        });
        UFX ufx = new UFX(this.pFF, webView, true);
        this.Ol = ufx;
        ufx.sc("landingpage_split_ceiling");
        final com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc scVar = this.Ol.f27333sc;
        if (we2 != null) {
            we2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i11 = iWe;
                    if (i11 == 1) {
                        TTCeilingLandingPageActivity.this.finish();
                    } else if (i11 != 2) {
                        return;
                    }
                    WebView webView2 = webView;
                    if (webView2 == null || !webView2.canGoBack()) {
                        TTCeilingLandingPageActivity.this.finish();
                        return;
                    }
                    webView.goBack();
                    com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc scVar2 = scVar;
                    if (scVar2 != null) {
                        scVar2.sc();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.common.We weSc = cJ.sc(this.pFF, this.UFX, this, "landingpage_split_ceiling");
        this.WH = weSc;
        if (weSc != null) {
            weSc.sc("landingpage_split_ceiling");
            this.WH.sc();
        }
        cJ.sc(this.pFF, this.UFX, true);
        this.f27520sc = new sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.3
            @Override // com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.sc
            public void sc() {
                if (TTCeilingLandingPageActivity.this.pFF.WH().ExN() == dE.pFF) {
                    TTCeilingLandingPageActivity.this.finish();
                }
            }
        };
        com.bytedance.sdk.openadsdk.core.widget.sc.ExN exN = new com.bytedance.sdk.openadsdk.core.widget.sc.ExN(this, this.zY, this.We, this.WH, this.Ol, true, true, this.f27520sc) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.ExN, android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
            }
        };
        exN.sc(this.pFF);
        com.bytedance.sdk.openadsdk.core.widget.sc.We we3 = new com.bytedance.sdk.openadsdk.core.widget.sc.We(this.zY, this.Ol, this.WH) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.sc.We, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i11) {
                super.onProgressChanged(webView2, i11);
            }
        };
        com.bytedance.sdk.component.Ol.We we4 = this.UFX;
        if (we4 != null) {
            we4.setWebViewClient(exN);
            this.UFX.setWebChromeClient(we3);
        }
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTCeilingLandingPageActivity.this.Ol == null) {
                        return false;
                    }
                    TTCeilingLandingPageActivity.this.Ol.sc(motionEvent);
                    return false;
                }
            });
            if (Build.VERSION.SDK_INT >= 23) {
                webView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.7
                    @Override // android.view.View.OnScrollChangeListener
                    public void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                        if (TTCeilingLandingPageActivity.this.Ol != null) {
                            TTCeilingLandingPageActivity.this.Ol.pFF(i12);
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!SR.ExN()) {
            finish();
            return;
        }
        Intent intent = getIntent();
        this.Qj = intent.getStringExtra("second_url");
        this.TRI = intent.getIntExtra("source", -1);
        this.pFF = FI.sc().pFF();
        FI.sc().TRI();
        Sfl sfl = this.pFF;
        if (sfl == null) {
            finish();
            return;
        }
        this.We = sfl.kDg();
        this.ExN = this.pFF.mD();
        this.TRI = this.pFF.Cb().getDurationSlotType() != 7 ? 5 : 7;
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(this);
        sc(this, zYVar);
        setContentView(zYVar);
        sc();
    }
}
