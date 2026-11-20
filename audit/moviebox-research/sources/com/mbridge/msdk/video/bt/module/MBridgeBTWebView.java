package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.card.MaterialCardView;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.f.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.mbsignalcommon.b.a;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.d.c;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeBTWebView extends MBridgeBTWebViewDiff {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f47494p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f47495q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f47496r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f47497s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f47498t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f47499u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private c f47500v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List<CampaignEx> f47501w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private WebView f47502x;

    public MBridgeBTWebView(Context context) {
        super(context);
        this.f47497s = false;
        this.f47499u = false;
    }

    public MBridgeBTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47497s = false;
        this.f47499u = false;
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.webView != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TrackingKey.CODE, BTBaseView.f47371n);
                jSONObject2.put("id", this.f47376d);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                g.a().a((WebView) this.webView, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a((WebView) this.webView, "broadcast", this.f47376d);
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        WebView webView = this.f47502x;
        if (webView != null) {
            BTBaseView.a(webView, "onPlayerCloseBtnClicked", this.f47376d);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z11) {
    }

    public List<CampaignEx> getCampaigns() {
        return this.f47501w;
    }

    public String getFilePath() {
        return this.f47495q;
    }

    public String getFileURL() {
        return this.f47494p;
    }

    public String getHtml() {
        return this.f47496r;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.f47374b;
    }

    public c getRewardUnitSetting() {
        return this.f47500v;
    }

    public WindVaneWebView getWebView() {
        return this.webView;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
        WindVaneWebView windVaneWebView = new WindVaneWebView(context);
        this.webView = windVaneWebView;
        windVaneWebView.setBackgroundColor(0);
        this.webView.setVisibility(0);
        k kVar = new k(null, this.f47374b, this.f47501w);
        this.jsCommon = kVar;
        kVar.a(this.f47375c);
        if (b.a()) {
            setChinaAlertInstallState(this.jsCommon);
        }
        this.webView.setObject(this.jsCommon);
        this.webView.setMraidObject(this);
        this.webView.setWebViewListener(new a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTWebView.1
            @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i11) {
                super.a(webView, i11);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i11, String str, String str2) {
                super.a(webView, i11, str, str2);
                if (MBridgeBTWebView.this.f47502x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f47376d);
                        jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f47376d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put("error", str);
                        jSONObject.put("data", jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f47502x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        d.c().a(MBridgeBTWebView.this.f47502x, e11.getMessage());
                        ad.a("RVWindVaneWebView", e11.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                if (MBridgeBTWebView.this.f47502x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f47376d);
                        jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f47376d);
                        jSONObject2.put("result", 2);
                        jSONObject2.put("error", sslError.toString());
                        jSONObject.put("data", jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f47502x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        d.c().a(MBridgeBTWebView.this.f47502x, e11.getMessage());
                        ad.a("RVWindVaneWebView", e11.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                if (MBridgeBTWebView.this.f47502x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", MBridgeBTWebView.this.f47376d);
                        jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", MBridgeBTWebView.this.f47376d);
                        jSONObject2.put("result", 1);
                        jSONObject.put("data", jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f47502x, "onWebviewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        d.c().a(MBridgeBTWebView.this.f47502x, e11.getMessage());
                        ad.a("RVWindVaneWebView", e11.getMessage());
                    }
                }
                g.a().a(MBridgeBTWebView.this.webView);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.a
            public final void a(Object obj) {
                super.a(obj);
                try {
                    k kVar2 = MBridgeBTWebView.this.jsCommon;
                    String strEncodeToString = "";
                    String strC = kVar2 != null ? kVar2.c() : "";
                    if (TextUtils.isEmpty(strC)) {
                        ad.a("RVWindVaneWebView", "getEndScreenInfo failed");
                    } else {
                        strEncodeToString = Base64.encodeToString(strC.getBytes(), 2);
                        ad.a("RVWindVaneWebView", "getEndScreenInfo success");
                    }
                    g.a().a(obj, strEncodeToString);
                } catch (Throwable th2) {
                    ad.a("RVWindVaneWebView", th2.getMessage());
                }
            }
        });
        addView(this.webView, new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTWebView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBridgeBTWebView.this.f47502x != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(TrackingKey.CODE, BTBaseView.f47371n);
                        jSONObject.put("id", MBridgeBTWebView.this.f47376d);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("x", String.valueOf(view.getX()));
                        jSONObject2.put("y", String.valueOf(view.getY()));
                        jSONObject.put("data", jSONObject2);
                        g.a().a(MBridgeBTWebView.this.f47502x, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception unused) {
                        d.c().a(MBridgeBTWebView.this.f47502x, "onClicked", MBridgeBTWebView.this.f47376d);
                    }
                }
            }
        });
        try {
            ImageView imageView = new ImageView(getContext());
            this.f47498t = imageView;
            imageView.setImageResource(findDrawable("mbridge_reward_close"));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
            layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
            layoutParams.setMargins(30, 30, 30, 30);
            this.f47498t.setLayoutParams(layoutParams);
            this.f47498t.setVisibility(this.f47497s ? 4 : 8);
            CampaignEx campaignEx = this.f47374b;
            if (campaignEx != null && campaignEx.isMraid()) {
                this.f47498t.setVisibility(4);
            }
            this.f47498t.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTWebView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeBTWebView.this.close();
                }
            });
            addView(this.f47498t);
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void onBackPressed() {
        if (this.webView != null) {
            d.c().a((WebView) this.webView, "onSystemBackPressed", this.f47376d);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (configuration.orientation == 2) {
                    jSONObject.put("orientation", "landscape");
                } else {
                    jSONObject.put("orientation", "portrait");
                }
                jSONObject.put("instanceId", this.f47376d);
                g.a().a((WebView) this.webView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
        if (this.f47499u) {
            return;
        }
        this.f47499u = true;
        try {
            if (this.webView != null) {
                d.c().a((WebView) this.webView, "onSystemDestory", this.f47376d);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTWebView.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        WindVaneWebView windVaneWebView = MBridgeBTWebView.this.webView;
                        if (windVaneWebView != null) {
                            windVaneWebView.clearWebView();
                            MBridgeBTWebView.this.webView.release();
                        }
                        MBridgeBTWebView.this.f47494p = null;
                        MBridgeBTWebView.this.f47495q = null;
                        MBridgeBTWebView.this.f47496r = null;
                        if (MBridgeBTWebView.this.f47502x != null) {
                            MBridgeBTWebView.this.f47502x = null;
                        }
                    } catch (Throwable th2) {
                        ad.a(BTBaseView.TAG, th2.getMessage());
                    }
                }
            }, 500L);
            setOnClickListener(null);
            removeAllViews();
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onFinishRedirection(Campaign campaign, String str) {
        ah.a(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onRedirectionFailed(Campaign campaign, String str) {
        ah.a(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onStartRedirection(Campaign campaign, String str) {
        ah.b(campaign, this);
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTWebViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        try {
            String clickURL = this.f47374b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f47374b.setClickURL(str);
                reportOpen(str);
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getContext(), this.f47375c);
            aVar.a(this);
            aVar.a(this.f47374b);
            this.f47374b.setClickURL(clickURL);
        } catch (Throwable th2) {
            ad.b(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void preload() {
        if (!TextUtils.isEmpty(this.f47494p)) {
            this.webView.loadUrl(this.f47494p);
        } else if (!TextUtils.isEmpty(this.f47495q)) {
            this.webView.loadUrl(this.f47495q);
        } else {
            if (TextUtils.isEmpty(this.f47496r)) {
                return;
            }
            this.webView.loadDataWithBaseURL("", this.f47496r, "text/html", "UTF-8", null);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTWebViewDiff
    public void reportOpen(String str) {
        try {
            CampaignEx mraidCampaign = getMraidCampaign();
            if (mraidCampaign != null) {
                new o(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.f47375c, str, this.f47374b.isBidCampaign());
            }
        } catch (Throwable th2) {
            ad.a(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void setCampaigns(List<CampaignEx> list) {
        this.f47501w = list;
    }

    public void setCreateWebView(WebView webView) {
        this.f47502x = webView;
    }

    public void setFilePath(String str) {
        this.f47495q = str;
    }

    public void setFileURL(String str) {
        this.f47494p = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean zContains = str.contains("play.google.com");
        setWebviewClickable(!zContains);
        if (zContains) {
            com.mbridge.msdk.mbsignalcommon.base.c cVar = new com.mbridge.msdk.mbsignalcommon.base.c();
            WindVaneWebView windVaneWebView = this.webView;
            if (windVaneWebView != null) {
                windVaneWebView.setFilter(cVar);
            }
        }
    }

    public void setHtml(String str) {
        this.f47496r = str;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void setRewardUnitSetting(c cVar) {
        this.f47500v = cVar;
    }

    public void setTempTypeForMetrics(int i11) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setTempTypeForMetrics(i11);
        }
    }

    public void setWebViewLocalRequestId(String str) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setLocalRequestId(str);
        }
    }

    public void setWebViewRid(String str) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setRid(str);
        }
    }

    public void setWebviewClickable(boolean z11) {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setClickable(z11);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z11) {
        try {
            this.f47498t.setVisibility(z11 ? 4 : 0);
        } catch (Throwable th2) {
            ad.b(BTBaseView.TAG, th2.getMessage());
        }
    }

    public boolean webviewGoBack() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null || !windVaneWebView.canGoBack()) {
            return false;
        }
        this.webView.goBack();
        return true;
    }

    public boolean webviewGoForward() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null || !windVaneWebView.canGoForward()) {
            return false;
        }
        this.webView.goForward();
        return true;
    }

    public void webviewLoad(int i11) {
        if (this.jsCommon == null) {
            this.jsCommon = new k(null, this.f47374b, this.f47501w);
        }
        CampaignEx campaignEx = this.f47374b;
        if (campaignEx != null) {
            this.jsCommon.a(campaignEx);
        } else {
            List<CampaignEx> list = this.f47501w;
            if (list != null && list.size() > 0) {
                this.jsCommon.a(this.f47501w);
                if (this.f47501w.size() == 1) {
                    this.jsCommon.a(this.f47501w.get(0));
                }
            }
        }
        c cVar = this.f47500v;
        if (cVar != null) {
            this.jsCommon.a(cVar);
        }
        this.jsCommon.a(this.f47375c);
        this.jsCommon.c(this.f47376d);
        if (b.a()) {
            setChinaAlertInstallState(this.jsCommon);
        }
        if (i11 == 1) {
            this.jsCommon.n();
        }
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView != null) {
            windVaneWebView.setObject(this.jsCommon);
        }
        CampaignEx campaignEx2 = this.f47374b;
        if (campaignEx2 != null && campaignEx2.isMraid()) {
            this.f47498t.setVisibility(4);
        }
        preload();
    }

    public boolean webviewReload() {
        WindVaneWebView windVaneWebView = this.webView;
        if (windVaneWebView == null) {
            return false;
        }
        windVaneWebView.reload();
        return true;
    }
}
