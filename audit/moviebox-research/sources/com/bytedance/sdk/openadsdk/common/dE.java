package com.bytedance.sdk.openadsdk.common;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE {
    private final Context ExN;
    private com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc Qj;
    private ImageView TRI;
    private final String We;
    private final com.bytedance.sdk.component.Ol.We pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private ImageView f27710qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final LinearLayout f27711sc;
    private final Sfl zY;

    public dE(Context context, LinearLayout linearLayout, com.bytedance.sdk.component.Ol.We we2, Sfl sfl, String str) {
        this.ExN = context;
        this.f27711sc = linearLayout;
        this.pFF = we2;
        this.zY = sfl;
        this.We = str;
        zY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.pFF.getWebView() != null && (webBackForwardListCopyBackForwardList = this.pFF.getWebView().copyBackForwardList()) != null) {
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.pFF.getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("first_page", Integer.valueOf(webBackForwardListCopyBackForwardList.getCurrentIndex() == 0 ? 1 : 0));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), this.zY, this.We, str, jSONObject, (com.bytedance.sdk.openadsdk.We.qr) null, (com.bytedance.sdk.openadsdk.We.pFF.sc) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str) {
        WebBackForwardList webBackForwardListCopyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.pFF.getWebView() != null && (webBackForwardListCopyBackForwardList = this.pFF.getWebView().copyBackForwardList()) != null) {
                int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.pFF.getUrl();
                }
                String url2 = str.equals(ToolBar.BACKWARD) ? webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex - 1).getUrl() : "";
                int i11 = 1;
                if (str.equals(ToolBar.FORWARD)) {
                    url2 = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex + 1).getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("next_url", url2);
                if (webBackForwardListCopyBackForwardList.getCurrentIndex() != 0) {
                    i11 = 0;
                }
                jSONObject2.putOpt("first_page", Integer.valueOf(i11));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), this.zY, this.We, str, jSONObject, (com.bytedance.sdk.openadsdk.We.qr) null, (com.bytedance.sdk.openadsdk.We.pFF.sc) null);
    }

    private void zY() {
        this.TRI = (ImageView) this.f27711sc.findViewById(com.bytedance.sdk.openadsdk.utils.SR.dix);
        this.f27710qr = (ImageView) this.f27711sc.findViewById(com.bytedance.sdk.openadsdk.utils.SR.IEI);
        ImageView imageView = (ImageView) this.f27711sc.findViewById(com.bytedance.sdk.openadsdk.utils.SR.PPh);
        ImageView imageView2 = (ImageView) this.f27711sc.findViewById(com.bytedance.sdk.openadsdk.utils.SR.gsl);
        this.TRI.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.dE.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dE.this.pFF == null || !dE.this.pFF.ExN()) {
                    return;
                }
                if (dE.this.Qj != null) {
                    dE.this.Qj.sc();
                }
                dE.this.sc(ToolBar.BACKWARD);
                dE.this.pFF.TRI();
            }
        });
        this.f27710qr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.dE.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dE.this.pFF == null || !dE.this.pFF.qr()) {
                    return;
                }
                dE.this.sc(ToolBar.FORWARD);
                dE.this.pFF.Qj();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.dE.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dE.this.pFF != null) {
                    dE.this.pFF(ToolBar.REFRESH);
                    dE.this.pFF.We();
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.dE.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dE.this.pFF != null) {
                    dE.this.pFF("external_btn_click");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String url = dE.this.pFF.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return;
                    }
                    intent.setData(Uri.parse(url));
                    com.bytedance.sdk.component.utils.pFF.sc(dE.this.ExN, intent, null);
                }
            }
        });
        this.f27711sc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.dE.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.TRI.setClickable(false);
        this.f27710qr.setClickable(false);
        ImageView imageView3 = this.TRI;
        int color = Color.parseColor("#A8FFFFFF");
        PorterDuff.Mode mode = PorterDuff.Mode.ADD;
        imageView3.setColorFilter(color, mode);
        this.f27710qr.setColorFilter(Color.parseColor("#A8FFFFFF"), mode);
    }

    public void pFF() {
        if (this.f27711sc.getAlpha() == 1.0f) {
            ObjectAnimator.ofFloat(this.f27711sc, "alpha", 1.0f, 0.0f).setDuration(300L).start();
        }
    }

    public void sc() {
        if (this.f27711sc.getAlpha() == 0.0f) {
            ObjectAnimator.ofFloat(this.f27711sc, "alpha", 0.0f, 1.0f).setDuration(300L).start();
        }
    }

    public void sc(WebView webView, com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc scVar) {
        this.Qj = scVar;
        try {
            if (this.TRI != null) {
                if (webView.canGoBack()) {
                    this.TRI.setClickable(true);
                    this.TRI.clearColorFilter();
                } else {
                    this.TRI.setClickable(false);
                    this.TRI.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
            if (this.f27710qr != null) {
                if (webView.canGoForward()) {
                    this.f27710qr.setClickable(true);
                    this.f27710qr.clearColorFilter();
                } else {
                    this.f27710qr.setClickable(false);
                    this.f27710qr.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
