package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.Xc;
import com.bytedance.sdk.openadsdk.core.Cb;
import com.bytedance.sdk.openadsdk.core.ExN.Qj;
import com.bytedance.sdk.openadsdk.core.ExN.qr;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTWebsiteActivity extends TTBaseActivity {
    private Xc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f27614sc = null;
    private WebView zY;

    public static void sc(Context context, Sfl sfl, String str) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), sfl, str, "open_policy");
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.Xc.We().cJ())) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTWebsiteActivity.class);
        if (sfl != null) {
            intent.putExtra("_extra_meta", sfl.WMT().toString());
            intent.putExtra("_extra_glo_d", sfl.uPZ());
        }
        com.bytedance.sdk.component.utils.pFF.sc(context, intent, null);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.Xc.pFF(getApplicationContext());
        if (!SR.ExN()) {
            finish();
            return;
        }
        final String stringExtra = getIntent().getStringExtra("_extra_meta");
        String stringExtra2 = getIntent().getStringExtra("_extra_glo_d");
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(this);
        if (Build.VERSION.SDK_INT >= 35) {
            exN.setFitsSystemWindows(true);
        }
        exN.setBackgroundColor(-1);
        exN.setId(520093726);
        exN.setOrientation(1);
        exN.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        try {
            setContentView(exN);
            int iZY = kX.zY(this, 5.0f);
            int iZY2 = kX.zY(this, 8.0f);
            int iZY3 = kX.zY(this, 10.0f);
            int iZY4 = kX.zY(this, 12.0f);
            int iZY5 = kX.zY(this, 14.0f);
            int iZY6 = kX.zY(this, 20.0f);
            int iZY7 = kX.zY(this, 24.0f);
            int iZY8 = kX.zY(this, 40.0f);
            int iZY9 = kX.zY(this, 44.0f);
            int iZY10 = kX.zY(this, 191.0f);
            qr qrVar = new qr(this);
            qrVar.setGravity(15);
            qrVar.setLayoutParams(new LinearLayout.LayoutParams(-1, iZY9));
            com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(this);
            we2.setId(520093720);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZY8, iZY9);
            layoutParams.setMarginStart(iZY2);
            we2.setLayoutParams(layoutParams);
            we2.setClickable(true);
            we2.setFocusable(true);
            we2.setPadding(iZY5, iZY4, iZY5, iZY4);
            we2.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this, "tt_ad_arrow_backward"));
            final com.bytedance.sdk.openadsdk.core.ExN.We we3 = new com.bytedance.sdk.openadsdk.core.ExN.We(this);
            we3.setId(520093716);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iZY8, iZY9);
            layoutParams2.addRule(17, 520093720);
            we3.setLayoutParams(layoutParams2);
            we3.setClickable(true);
            we3.setFocusable(true);
            we3.setPadding(iZY4, iZY5, iZY4, iZY5);
            we3.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this, "tt_ad_xmark"));
            Qj qj2 = new Qj(this);
            qj2.setId(com.bytedance.sdk.openadsdk.utils.SR.Mrq);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iZY10, iZY7);
            layoutParams3.setMarginStart(iZY);
            layoutParams3.addRule(15);
            layoutParams3.addRule(16, 520093741);
            layoutParams3.addRule(17, 520093716);
            qj2.setLayoutParams(layoutParams3);
            qj2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            qj2.setGravity(17);
            qj2.setSingleLine(true);
            qj2.setTextColor(Color.parseColor("#222222"));
            qj2.setTextSize(17.0f);
            com.bytedance.sdk.openadsdk.core.ExN.We we4 = new com.bytedance.sdk.openadsdk.core.ExN.We(this);
            we4.setId(520093741);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iZY8, iZY9);
            layoutParams4.addRule(16, 520093742);
            we4.setLayoutParams(layoutParams4);
            we4.setPadding(iZY3, iZY4, iZY3, iZY4);
            we4.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this, "tt_ad_link"));
            com.bytedance.sdk.openadsdk.core.ExN.We we5 = new com.bytedance.sdk.openadsdk.core.ExN.We(this);
            we5.setId(520093742);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iZY8, iZY9);
            layoutParams5.addRule(21);
            layoutParams5.setMarginEnd(iZY2);
            we5.setLayoutParams(layoutParams5);
            we5.setPadding(iZY4, iZY6, iZY4, iZY6);
            we5.setImageDrawable(com.bytedance.sdk.component.utils.Sfl.zY(this, "tt_ad_threedots"));
            final com.bytedance.sdk.openadsdk.core.ExN.TRI tri = new com.bytedance.sdk.openadsdk.core.ExN.TRI(this, null, R.style.Widget.ProgressBar.Horizontal);
            tri.setId(520093743);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, kX.zY(this, 2.0f));
            layoutParams6.addRule(12);
            tri.setLayoutParams(layoutParams6);
            tri.setProgress(1);
            tri.setProgressDrawable(Ol.sc(this, "tt_privacy_progress_style"));
            View view = new View(this);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, kX.zY(this, 1.0f));
            layoutParams7.addRule(12);
            view.setLayoutParams(layoutParams7);
            qrVar.addView(we2);
            qrVar.addView(we3);
            qrVar.addView(qj2);
            qrVar.addView(we4);
            qrVar.addView(we5);
            qrVar.addView(tri);
            qrVar.addView(view);
            exN.addView(qrVar);
            try {
                WebView webView = new WebView(getApplicationContext());
                this.zY = webView;
                webView.setBackgroundColor(-1);
                exN.addView(this.zY, new ViewGroup.LayoutParams(-1, -1));
                we2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TTWebsiteActivity.this.zY.canGoBack()) {
                            TTWebsiteActivity.this.zY.goBack();
                        } else {
                            TTWebsiteActivity.this.finish();
                        }
                    }
                });
                we3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TTWebsiteActivity.this.finish();
                    }
                });
                we3.setVisibility(4);
                we3.setClickable(false);
                qj2.setText(com.bytedance.sdk.component.utils.Sfl.sc(this, "tt_privacy_title"));
                we4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        String url = TTWebsiteActivity.this.zY.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            return;
                        }
                        intent.setData(Uri.parse(url));
                        com.bytedance.sdk.component.utils.pFF.sc(TTWebsiteActivity.this, intent, null);
                    }
                });
                we5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TTWebsiteActivity.this.pFF == null) {
                            TTWebsiteActivity.this.pFF = new Xc(TTWebsiteActivity.this);
                            TTWebsiteActivity.this.pFF.sc(stringExtra);
                            TTWebsiteActivity.this.pFF.setCanceledOnTouchOutside(false);
                        }
                        TTWebsiteActivity.this.pFF.show();
                    }
                });
                if (com.bytedance.sdk.openadsdk.core.Xc.We() != null) {
                    this.f27614sc = com.bytedance.sdk.openadsdk.core.Xc.We().cJ();
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        String strEncode = URLEncoder.encode(stringExtra2);
                        if (this.f27614sc.contains("?")) {
                            this.f27614sc += "&gdid_encrypted=" + strEncode;
                        } else {
                            this.f27614sc += "?gdid_encrypted=" + strEncode;
                        }
                    }
                }
                if (this.f27614sc == null) {
                    finish();
                    return;
                }
                WebSettings settings = this.zY.getSettings();
                settings.setMixedContentMode(0);
                try {
                    settings.setJavaScriptEnabled(true);
                    settings.setDomStorageEnabled(true);
                    settings.setSavePassword(false);
                    settings.setAllowFileAccess(false);
                } catch (Throwable unused) {
                }
                HashMap map = new HashMap();
                map.put("Referer", TTAdConstant.REQUEST_HEAD_REFERER);
                try {
                    this.zY.loadUrl(this.f27614sc, map);
                } catch (Throwable unused2) {
                    this.zY.loadUrl(this.f27614sc);
                }
                this.zY.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.5
                    @Override // android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView2, int i11) {
                        super.onProgressChanged(webView2, i11);
                        if (tri == null || TTWebsiteActivity.this.isFinishing()) {
                            return;
                        }
                        if (i11 != 100) {
                            tri.setVisibility(0);
                            tri.setProgress(i11);
                            return;
                        }
                        tri.setVisibility(8);
                        if (webView2.canGoBack()) {
                            we3.setVisibility(0);
                            we3.setClickable(true);
                        } else {
                            we3.setVisibility(4);
                            we3.setClickable(false);
                        }
                    }
                });
                this.zY.setWebViewClient(new com.bytedance.sdk.component.Ol.We.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.6
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str) {
                        super.onPageFinished(webView2, str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView2, int i11, String str, String str2) {
                        super.onReceivedError(webView2, i11, str, str2);
                    }

                    @Override // android.webkit.WebViewClient
                    @RequiresApi(api = 23)
                    public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        super.onReceivedError(webView2, webResourceRequest, webResourceError);
                        Tf.sc("TTAD.TTWebsiteActivity", "onReceivedError invoke....onReceivedError=" + webResourceError.getErrorCode());
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                        Tf.sc("TTAD.TTWebsiteActivity", "onReceivedHttpError invoke....errorResponse=".concat(String.valueOf(webResourceResponse)));
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                        if (webView2 == null || webResourceRequest == null) {
                            return false;
                        }
                        webView2.loadUrl(webResourceRequest.getUrl().toString());
                        return true;
                    }
                });
                com.bytedance.sdk.openadsdk.core.widget.sc.zY.pFF(this.zY);
            } catch (Exception e11) {
                Tf.sc("TTAD.TTWebsiteActivity", "onCreate: ", e11);
                finish();
            }
        } catch (Throwable unused3) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Cb.sc(this.zY);
        super.onDestroy();
    }
}
