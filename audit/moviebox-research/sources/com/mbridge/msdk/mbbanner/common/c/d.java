package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.ads.AdError;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbanner.common.b.f;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbanner.view.MBBannerWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.widget.MBAdChoice;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {
    private float A;
    private float B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.mbbanner.common.b.c f45322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected CampaignEx f45323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final MBBannerView f45324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f45325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f45326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    com.mbridge.msdk.click.a f45327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f45328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f45329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MBBannerWebView f45330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f45331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ImageView f45332k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f45333l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f45334m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f45335n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f45336o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f45337p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f45338q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f45339r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<CampaignEx> f45340s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f45342u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.communication.a f45344w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private kn.b f45345x;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f45341t = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final long f45343v = 15000;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Handler f45346y = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.mbbanner.common.c.d.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                if (d.this.f45345x != null) {
                    kn.a.a(d.this.f45345x).b();
                    d.this.f45345x.c();
                    d.this.f45345x = null;
                }
            } catch (Throwable th2) {
                ad.a("BannerShowManager", th2.getMessage());
            }
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.e.a f45347z = new com.mbridge.msdk.foundation.same.e.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.6
        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z11) {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            d.this.a("banner render failed because render is timeout");
        }
    };
    private final View.OnClickListener C = new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.c.d.7
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d dVar = d.this;
            if (dVar.f45325d) {
                d.b(dVar);
            }
        }
    };
    private com.mbridge.msdk.mbbanner.common.b.a D = new com.mbridge.msdk.mbbanner.common.b.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.8
        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a() {
            d.b(d.this);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(int i11) {
            if (i11 == 2) {
                d.c(d.this);
            } else {
                d.this.f();
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(CampaignEx campaignEx) {
            d.this.a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(String str) {
            d.b(d.this);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(boolean z11) {
            d dVar = d.this;
            if (dVar.f45322a != null) {
                dVar.f45338q = z11;
                if (z11) {
                    d.this.f45322a.c();
                } else {
                    d.this.f45322a.d();
                }
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(boolean z11, String str) {
            try {
                if (d.this.f45322a != null) {
                    if (TextUtils.isEmpty(str)) {
                        d.this.f45322a.a();
                        d.this.f45322a.b();
                    } else {
                        CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(d.this.f45323b));
                        campaignWithBackData.setClickURL(str);
                        d.this.a(campaignWithBackData, z11, str);
                    }
                }
            } catch (Exception e11) {
                ad.b("BannerShowManager", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void b(int i11) {
            if (i11 != 1) {
                d.this.c();
            } else {
                d.this.d();
                d.this.a("", 1);
            }
        }
    };
    private com.mbridge.msdk.mbsignalcommon.b.b E = new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.mbbanner.common.c.d.4
        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView) {
            d.this.c();
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i11, String str, String str2) {
            d.this.a(str);
            d.this.a(str, 2);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            d.this.f45335n = true;
            ad.b("BannerCallJS", "fireOnJSBridgeConnected");
            g.a().a(webView);
            d.this.f45337p = true;
            CampaignEx campaignEx = d.this.f45323b;
            if (campaignEx == null || campaignEx.isHasMBTplMark()) {
                return;
            }
            d.this.d();
            d.this.a("", 1);
        }
    };

    public d(MBBannerView mBBannerView, com.mbridge.msdk.mbbanner.common.b.c cVar, String str, String str2, boolean z11, k kVar) {
        this.f45328g = z11;
        this.f45324c = mBBannerView;
        this.f45326e = str2;
        this.f45339r = str;
        this.f45322a = new f(cVar, kVar);
    }

    private String a(CampaignEx campaignEx) {
        String strA;
        if (campaignEx == null) {
            return "";
        }
        String htmlContentFromUrl = HTMLResourceManager.getInstance().getHtmlContentFromUrl(campaignEx.getBannerUrl());
        if (!TextUtils.isEmpty(htmlContentFromUrl)) {
            return jn.b.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, htmlContentFromUrl);
        }
        String bannerHtml = campaignEx.getBannerHtml();
        if (!campaignEx.isActiveOm()) {
            File file = new File(bannerHtml);
            if (file.exists() && file.isFile() && file.canRead()) {
                strA = "file:////" + bannerHtml;
            }
            return bannerHtml;
        }
        try {
            File file2 = new File(bannerHtml);
            strA = jn.b.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, file2.exists() ? ab.b(file2) : "");
        } catch (Exception unused) {
            File file3 = new File(bannerHtml);
            if (file3.exists() && file3.isFile() && file3.canRead()) {
                strA = "file:////" + bannerHtml;
            }
            return bannerHtml;
        }
        return strA;
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, str, it.next(), false, true);
                }
            } catch (Throwable th2) {
                ad.b("BannerShowManager", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f45323b == null || e()) {
            return;
        }
        this.f45346y.removeCallbacks(this.f45347z);
        com.mbridge.msdk.mbbanner.common.b.c cVar = this.f45322a;
        if (cVar != null) {
            cVar.a(str);
        }
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f45323b, this.f45326e, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i11) {
        if (this.f45323b != null) {
            com.mbridge.msdk.mbbanner.common.d.a.a(com.mbridge.msdk.mbbanner.common.a.a.a().c(this.f45323b.getId()).b(this.f45326e).d(this.f45323b.getRequestId()).e(this.f45323b.getRequestIdNotice()).g(str).a(i11).a(this.f45323b.isBidCampaign()), this.f45326e);
        }
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43073h);
            } catch (Throwable th2) {
                ad.b("BannerShowManager", th2.getMessage());
            }
        }
    }

    public static /* synthetic */ void b(d dVar) {
        MBBannerWebView mBBannerWebView = dVar.f45330i;
        if (mBBannerWebView != null && mBBannerWebView.getParent() != null) {
            dVar.f45324c.removeView(dVar.f45330i);
        }
        ImageView imageView = dVar.f45329h;
        if (imageView != null && imageView.getParent() != null) {
            dVar.f45329h.setVisibility(8);
            dVar.f45324c.removeView(dVar.f45329h);
        }
        ImageView imageView2 = dVar.f45331j;
        if (imageView2 != null && imageView2.getParent() != null) {
            dVar.f45324c.removeView(dVar.f45331j);
            dVar.f45331j.setVisibility(8);
        }
        com.mbridge.msdk.foundation.d.b.a().c(dVar.f45326e);
        ImageView imageView3 = dVar.f45332k;
        if (imageView3 != null && imageView3.getParent() != null) {
            dVar.f45324c.removeView(dVar.f45332k);
            dVar.f45332k.setVisibility(8);
        }
        com.mbridge.msdk.mbbanner.common.a.a aVarA = com.mbridge.msdk.mbbanner.common.a.a.a().b(dVar.f45326e).d(dVar.f45323b.getRequestId()).e(dVar.f45323b.getRequestIdNotice()).c(dVar.f45323b.getId()).f(dVar.f45323b.getCreativeId() + "").a(dVar.f45323b.isBidCampaign());
        String str = dVar.f45326e;
        if (aVarA != null) {
            aVarA.a("2000069");
            if (j.a().b()) {
                j.a().a(aVarA.b());
            } else {
                m.a(aVarA.b(), com.mbridge.msdk.foundation.controller.c.m().c(), str);
            }
        }
        BannerUtils.inserCloseId(dVar.f45326e, dVar.f45340s);
        com.mbridge.msdk.mbbanner.common.b.c cVar = dVar.f45322a;
        if (cVar != null) {
            cVar.e();
        }
    }

    private boolean b() {
        String strA = a(this.f45323b);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        if (this.f45324c != null) {
            if (this.f45330i == null) {
                try {
                    MBBannerWebView mBBannerWebView = new MBBannerWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                    this.f45330i = mBBannerWebView;
                    mBBannerWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.f45330i.setWebViewClient(new com.mbridge.msdk.mbbanner.view.a(this.f45326e, this.f45340s, this.D));
                } catch (Throwable unused) {
                    a("banner show failed because WebView is not available and try to show default", 1);
                    return false;
                }
            }
            ImageView imageView = this.f45329h;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (this.f45330i.getVisibility() != 0) {
                this.f45330i.setVisibility(0);
            }
            if (this.f45330i.getParent() == null) {
                this.f45324c.addView(this.f45330i);
                d(this.f45323b.isMraid());
            }
            if (this.f45323b.isMraid()) {
                g();
            }
            f();
            com.mbridge.msdk.mbbanner.common.communication.a aVar = new com.mbridge.msdk.mbbanner.common.communication.a(this.f45324c.getContext(), this.f45339r, this.f45326e);
            this.f45344w = aVar;
            aVar.a(this.f45340s);
            this.f45344w.a(this.D);
            this.f45344w.a(this.f45342u);
            this.f45330i.setWebViewListener(this.E);
            this.f45330i.setObject(this.f45344w);
            if (strA.startsWith("file")) {
                this.f45330i.loadUrl(strA);
            } else {
                if (this.f45323b.isActiveOm()) {
                    strA = com.mbridge.msdk.a.b.c(strA);
                }
                this.f45330i.loadDataWithBaseURL(this.f45323b.getBannerUrl(), strA, "text/html", "utf-8", null);
            }
            MBBannerWebView mBBannerWebView2 = this.f45330i;
            if (mBBannerWebView2 != null) {
                mBBannerWebView2.postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.d.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (d.this.f45330i != null) {
                                String str = d.this.f45341t == 2 ? "false" : "true";
                                d.this.f45330i.evaluateJavascript("(function() {\n    var videos = document.getElementsByTagName('video');\n    for (var i = 0; i < videos.length; i++) {\n    videos[i].muted = " + str + ";\n    }\n    var audios = document.getElementsByTagName('audio');\n    for (var i = 0; i < audios.length; i++) {\n    audios[i].muted = " + str + ";\n    }\n    })()", null);
                            }
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    }
                }, 1000L);
            }
        } else {
            a("banner render failed because banner view is null", 2);
            a("banner show failed because banner view is exception");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f45324c == null) {
            a("banner show failed because banner view is exception");
            return;
        }
        MBBannerWebView mBBannerWebView = this.f45330i;
        if (mBBannerWebView != null && mBBannerWebView.getParent() != null) {
            this.f45324c.removeView(this.f45330i);
        }
        if (this.f45329h == null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            this.f45329h = imageView;
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.mbbanner.common.c.d.10
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    d.this.A = motionEvent.getRawX();
                    d.this.B = motionEvent.getRawY();
                    ad.b("BannerShowManager", d.this.A + "  " + d.this.B);
                    return false;
                }
            });
            this.f45329h.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.c.d.11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.this.a(BannerUtils.managerCampaignEX(com.mbridge.msdk.mbsignalcommon.communication.d.a(d.this.A, d.this.B), d.this.f45323b), false, "");
                }
            });
        }
        String imageUrl = this.f45323b.getImageUrl();
        if (TextUtils.isEmpty(imageUrl)) {
            a("banner show failed because campain is exception");
        } else {
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(imageUrl, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.mbbanner.common.c.d.12
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                    d.this.a("banner show failed because banner default view is exception");
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (d.this.f45329h != null) {
                        d.this.f45329h.setImageBitmap(bitmap);
                    }
                    d.this.f45335n = true;
                    d.l(d.this);
                    d.this.f();
                    d.this.g();
                    d dVar = d.this;
                    if (dVar.f45325d) {
                        return;
                    }
                    dVar.d();
                }
            });
        }
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.k.a(h.a(context)).a(campaignEx.getId());
                    } catch (Exception e11) {
                        ad.b("BannerShowManager", e11.getMessage());
                    }
                }
            }).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43072g);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().p() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().p(), false, false);
    }

    public static /* synthetic */ void c(d dVar) {
        ImageView imageView;
        if (dVar.f45328g && (imageView = dVar.f45331j) != null && imageView.getVisibility() == 0) {
            dVar.f45331j.setVisibility(8);
            dVar.f45331j.setOnClickListener(null);
            if (dVar.f45324c == null || dVar.f45331j.getParent() == null) {
                return;
            }
            dVar.f45324c.removeView(dVar.f45331j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:107:0x0318  */
    /* JADX WARN: Code duplicated, block: B:116:0x0349 A[Catch: Exception -> 0x0351, TryCatch #5 {Exception -> 0x0351, blocks: (B:114:0x033f, B:116:0x0349, B:119:0x0353, B:121:0x0357, B:122:0x035e), top: B:155:0x033f, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0357 A[Catch: Exception -> 0x0351, TryCatch #5 {Exception -> 0x0351, blocks: (B:114:0x033f, B:116:0x0349, B:119:0x0353, B:121:0x0357, B:122:0x035e), top: B:155:0x033f, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0370 A[Catch: Exception -> 0x036e, TryCatch #0 {Exception -> 0x036e, blocks: (B:108:0x031d, B:110:0x0321, B:112:0x0327, B:126:0x0370, B:128:0x0374, B:124:0x0364, B:114:0x033f, B:116:0x0349, B:119:0x0353, B:121:0x0357, B:122:0x035e), top: B:146:0x031d, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0374 A[Catch: Exception -> 0x036e, TRY_LEAVE, TryCatch #0 {Exception -> 0x036e, blocks: (B:108:0x031d, B:110:0x0321, B:112:0x0327, B:126:0x0370, B:128:0x0374, B:124:0x0364, B:114:0x033f, B:116:0x0349, B:119:0x0353, B:121:0x0357, B:122:0x035e), top: B:146:0x031d, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:137:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:140:0x0407  */
    /* JADX WARN: Code duplicated, block: B:143:0x0424  */
    /* JADX WARN: Code duplicated, block: B:144:0x0432  */
    /* JADX WARN: Code duplicated, block: B:155:0x033f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x02e1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:75:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:79:0x0235  */
    /* JADX WARN: Code duplicated, block: B:89:0x027e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0282  */
    /* JADX WARN: Code duplicated, block: B:96:0x0293  */
    /* JADX WARN: Code duplicated, block: B:98:0x02a1 A[ADDED_TO_REGION] */
    public void d() {
        boolean z11;
        boolean z12;
        String str;
        ImageView imageView;
        List<CampaignEx> list;
        boolean z13;
        int i11;
        int i12;
        com.mbridge.msdk.mbbanner.common.b.c cVar;
        BitmapDrawable bitmapDrawableA;
        CampaignEx campaignEx;
        kn.b bVarA;
        ImageView imageView2;
        ImageView imageView3;
        CampaignEx campaignEx2;
        MBBannerView mBBannerView;
        d dVar = this;
        if (dVar.f45335n && !dVar.f45336o && dVar.f45322a != null) {
            dVar.f45336o = true;
            dVar.f45346y.removeCallbacks(dVar.f45347z);
            CampaignEx campaignEx3 = dVar.f45323b;
            if (campaignEx3 != null && !campaignEx3.isCallbacked()) {
                dVar.f45323b.setCallbacked(true);
                dVar.f45322a.a(dVar.f45340s);
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45323b.getMaitve(), dVar.f45323b.getMaitve_src());
            }
        }
        if (dVar.f45335n && dVar.f45333l && dVar.f45334m && dVar.f45336o && dVar.f45323b != null && !e()) {
            if (dVar.f45324c != null) {
                CampaignEx campaignEx4 = dVar.f45323b;
                if (aq.a(dVar.f45324c, campaignEx4 != null ? campaignEx4.getImpReportType() : 0) || dVar.f45338q) {
                    z11 = false;
                } else {
                    z11 = true;
                }
            } else {
                z11 = false;
            }
            if (!z11 && (mBBannerView = dVar.f45324c) != null) {
                mBBannerView.postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.d.13
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.d();
                    }
                }, 1000L);
            }
            if (dVar.f45337p && z11) {
                ad.b("BannerShowManager", "onBannerWebViewShow && transInfoToMraid");
                int[] iArr = new int[2];
                dVar.f45324c.getLocationInWindow(iArr);
                MBBannerWebView mBBannerWebView = dVar.f45330i;
                float f11 = iArr[0];
                float f12 = iArr[1];
                ad.b("BannerCallJS", "fireOnBannerWebViewShow");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("startX", f11);
                    jSONObject.put("startY", f12);
                    jSONObject.put("scale", ai.d(com.mbridge.msdk.foundation.controller.c.m().c()));
                    g.a().a((WebView) mBBannerWebView, "webviewshow", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Throwable th2) {
                    ad.a("BannerCallJS", "fireOnBannerWebViewShow", th2);
                }
                MBBannerWebView mBBannerWebView2 = dVar.f45330i;
                int i13 = iArr[0];
                int i14 = iArr[1];
                int width = dVar.f45324c.getWidth();
                int height = dVar.f45324c.getHeight();
                ad.b("BannerCallJS", "transInfoForMraid");
                try {
                    int i15 = com.mbridge.msdk.foundation.controller.c.m().c().getResources().getConfiguration().orientation;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("orientation", i15 == 2 ? "landscape" : i15 == 1 ? "portrait" : AdError.UNDEFINED_DOMAIN);
                    jSONObject2.put("locked", "true");
                    float fI = z.i(com.mbridge.msdk.foundation.controller.c.m().c());
                    float fG = z.g(com.mbridge.msdk.foundation.controller.c.m().c());
                    HashMap mapH = z.h(com.mbridge.msdk.foundation.controller.c.m().c());
                    int iIntValue = ((Integer) mapH.get("width")).intValue();
                    z12 = z11;
                    try {
                        int iIntValue2 = ((Integer) mapH.get("height")).intValue();
                        HashMap map = new HashMap();
                        str = "BannerShowManager";
                        try {
                            map.put("placementType", "inline");
                            map.put("state", TmcEngineFactory.ENGINE_TYPE_DEFAULT);
                            map.put("viewable", "true");
                            map.put("currentAppOrientation", jSONObject2);
                            float f13 = i13;
                            float f14 = i14;
                            float f15 = width;
                            float f16 = height;
                            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView2, f13, f14, f15, f16);
                            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBBannerWebView2, f13, f14, f15, f16);
                            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBBannerWebView2, fI, fG);
                            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBBannerWebView2, iIntValue, iIntValue2);
                            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView2, map);
                            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView2);
                        } catch (Throwable th3) {
                            th = th3;
                            ad.a("BannerCallJS", "transInfoForMraid", th);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str = "BannerShowManager";
                        ad.a("BannerCallJS", "transInfoForMraid", th);
                        dVar = this;
                        dVar.f45337p = false;
                        if (!TextUtils.isEmpty(dVar.f45323b.getImageUrl())) {
                            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(dVar.f45323b.getImageUrl());
                        }
                        ad.b(str, "showSuccessed:" + dVar.f45323b.getId());
                        if (z12) {
                            dVar.f45323b.setReport(false);
                            return;
                        }
                        imageView = dVar.f45329h;
                        if (imageView == null) {
                            list = dVar.f45340s;
                            if (list != null) {
                                z13 = false;
                                i12 = 0;
                                while (i11 < dVar.f45340s.size()) {
                                    if (dVar.f45340s.get(i11).isHasMBTplMark()) {
                                    }
                                }
                                if (z13) {
                                    dVar.b(dVar.f45340s.get(i12), com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                                    dVar.a(dVar.f45340s.get(i12), com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                                }
                            }
                        } else {
                            list = dVar.f45340s;
                            if (list != null) {
                                z13 = false;
                                i12 = 0;
                                while (i11 < dVar.f45340s.size()) {
                                    if (dVar.f45340s.get(i11).isHasMBTplMark()) {
                                    }
                                }
                                if (z13) {
                                    dVar.b(dVar.f45340s.get(i12), com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                                    dVar.a(dVar.f45340s.get(i12), com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                                }
                            }
                        }
                        dVar.f45325d = true;
                        cVar = dVar.f45322a;
                        if (cVar != null) {
                            cVar.a(dVar.f45323b);
                        }
                        try {
                            campaignEx = dVar.f45323b;
                            if (campaignEx != null) {
                                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                                MBBannerWebView mBBannerWebView3 = dVar.f45330i;
                                bVarA = com.mbridge.msdk.a.b.a(contextC, mBBannerWebView3, mBBannerWebView3.getUrl(), dVar.f45323b);
                                dVar.f45345x = bVarA;
                                if (bVarA != null) {
                                    try {
                                        bVarA.d(dVar.f45330i);
                                        imageView2 = dVar.f45331j;
                                        if (imageView2 != null) {
                                            dVar.f45345x.a(imageView2, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                                        }
                                        imageView3 = dVar.f45329h;
                                        if (imageView3 != null) {
                                            dVar.f45345x.a(imageView3, FriendlyObstructionPurpose.OTHER, null);
                                        }
                                        dVar.f45345x.g();
                                    } catch (Exception e11) {
                                        ad.a("OMSDK", e11.getMessage());
                                    }
                                } else {
                                    campaignEx2 = dVar.f45323b;
                                    if (campaignEx2 != null) {
                                        new o(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx2.getRequestId(), dVar.f45323b.getRequestIdNotice(), dVar.f45323b.getId(), dVar.f45326e, "fetch OM failed, context null");
                                    }
                                }
                            }
                        } catch (Exception unused) {
                            CampaignEx campaignEx5 = dVar.f45323b;
                            if (campaignEx5 != null) {
                                new o(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx5.getRequestId(), dVar.f45323b.getRequestIdNotice(), dVar.f45323b.getId(), dVar.f45326e, "fetch OM failed, context null");
                            }
                        }
                        dVar.f45346y.sendEmptyMessageDelayed(1, 1000L);
                        q.b(com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45323b, dVar.f45326e, "");
                        bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(dVar.f45326e, dVar.f45323b.getAdType());
                        if (bitmapDrawableA != null) {
                            if (dVar.f45332k == null) {
                                dVar.f45332k = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                            }
                            if (dVar.f45332k.getVisibility() != 0) {
                                dVar.f45332k.setVisibility(0);
                            }
                            ai.a(dVar.f45332k, bitmapDrawableA, dVar.f45324c.getResources().getDisplayMetrics());
                            if (dVar.f45332k.getParent() == null) {
                                dVar.f45324c.addView(dVar.f45332k, new ViewGroup.LayoutParams(-1, -1));
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    z12 = z11;
                }
                dVar = this;
                dVar.f45337p = false;
                if (!TextUtils.isEmpty(dVar.f45323b.getImageUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(dVar.f45323b.getImageUrl());
                }
            } else {
                z12 = z11;
                str = "BannerShowManager";
            }
            ad.b(str, "showSuccessed:" + dVar.f45323b.getId());
            if (z12) {
                dVar.f45323b.setReport(false);
                return;
            }
            imageView = dVar.f45329h;
            if (imageView == null && imageView.getVisibility() == 0) {
                CampaignEx campaignEx6 = dVar.f45323b;
                if (campaignEx6 != null) {
                    if (campaignEx6 != null) {
                        dVar.c(campaignEx6, com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                        dVar.b(campaignEx6, com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                        dVar.a(campaignEx6, com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                    }
                    dVar.f45323b.setReport(true);
                    com.mbridge.msdk.foundation.same.a.d.a(dVar.f45326e, dVar.f45323b, "banner");
                }
            } else {
                list = dVar.f45340s;
                if (list != null && list.size() > 0) {
                    z13 = false;
                    i12 = 0;
                    for (i11 = 0; i11 < dVar.f45340s.size(); i11++) {
                        if (dVar.f45340s.get(i11).isHasMBTplMark() && (i11 == 0 || !dVar.f45340s.get(i11).isReport())) {
                            dVar.c(dVar.f45340s.get(i11), com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                            dVar.f45340s.get(i11).setReport(true);
                            com.mbridge.msdk.foundation.same.a.d.a(dVar.f45326e, dVar.f45340s.get(i11), "banner");
                            i12 = i11;
                            z13 = true;
                        }
                    }
                    if (z13) {
                        dVar.b(dVar.f45340s.get(i12), com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                        dVar.a(dVar.f45340s.get(i12), com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45326e);
                    }
                }
            }
            dVar.f45325d = true;
            cVar = dVar.f45322a;
            if (cVar != null) {
                cVar.a(dVar.f45323b);
            }
            campaignEx = dVar.f45323b;
            if (campaignEx != null && campaignEx.isActiveOm()) {
                Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                MBBannerWebView mBBannerWebView4 = dVar.f45330i;
                bVarA = com.mbridge.msdk.a.b.a(contextC2, mBBannerWebView4, mBBannerWebView4.getUrl(), dVar.f45323b);
                dVar.f45345x = bVarA;
                if (bVarA != null) {
                    bVarA.d(dVar.f45330i);
                    imageView2 = dVar.f45331j;
                    if (imageView2 != null) {
                        dVar.f45345x.a(imageView2, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                    }
                    imageView3 = dVar.f45329h;
                    if (imageView3 != null) {
                        dVar.f45345x.a(imageView3, FriendlyObstructionPurpose.OTHER, null);
                    }
                    dVar.f45345x.g();
                } else {
                    campaignEx2 = dVar.f45323b;
                    if (campaignEx2 != null) {
                        new o(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx2.getRequestId(), dVar.f45323b.getRequestIdNotice(), dVar.f45323b.getId(), dVar.f45326e, "fetch OM failed, context null");
                    }
                }
            }
            dVar.f45346y.sendEmptyMessageDelayed(1, 1000L);
            q.b(com.mbridge.msdk.foundation.controller.c.m().c(), dVar.f45323b, dVar.f45326e, "");
            bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(dVar.f45326e, dVar.f45323b.getAdType());
            if (bitmapDrawableA != null) {
                if (dVar.f45332k == null) {
                    dVar.f45332k = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                }
                if (dVar.f45332k.getVisibility() != 0) {
                    dVar.f45332k.setVisibility(0);
                }
                ai.a(dVar.f45332k, bitmapDrawableA, dVar.f45324c.getResources().getDisplayMetrics());
                if (dVar.f45332k.getParent() == null) {
                    dVar.f45324c.addView(dVar.f45332k, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
    }

    private void d(boolean z11) {
        if (this.f45324c != null) {
            View viewB = com.mbridge.msdk.foundation.d.b.a().b(this.f45326e);
            if (com.mbridge.msdk.foundation.d.b.a().b() && z11 && viewB != null) {
                ViewGroup viewGroup = (ViewGroup) viewB.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(viewB);
                }
                viewB.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewB.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.d.b.f44149b, com.mbridge.msdk.foundation.d.b.f44148a);
                }
                layoutParams.addRule(12);
                viewB.setLayoutParams(layoutParams);
                this.f45324c.addView(viewB);
            }
            com.mbridge.msdk.foundation.d.b.a().a(this.f45326e, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.5
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                    String string;
                    d.this.f45324c.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a("BannerShowManager", th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f45330i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    String string;
                    d.this.f45324c.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a("BannerShowManager", th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f45330i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    String string;
                    d.this.f45324c.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a("BannerShowManager", th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f45330i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            this.f45323b.setCampaignUnitId(this.f45326e);
            com.mbridge.msdk.foundation.d.b.a().a(this.f45326e, this.f45323b);
        }
    }

    private synchronized boolean e() {
        boolean zIsReport;
        zIsReport = this.f45323b.isReport();
        if (!zIsReport) {
            this.f45323b.setReport(true);
        }
        return zIsReport;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ImageView imageView;
        if (!this.f45328g || (imageView = this.f45331j) == null) {
            return;
        }
        if (imageView.getVisibility() != 0) {
            this.f45331j.setVisibility(0);
            this.f45331j.setOnClickListener(this.C);
        }
        if (this.f45331j.getParent() != null || this.f45324c == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f), ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.f45324c.addView(this.f45331j, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f45324c == null) {
            return;
        }
        CampaignEx campaignEx = this.f45323b;
        if (campaignEx == null || campaignEx.getPrivacyButtonTemplateVisibility() == 1) {
            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().c());
            mBAdChoice.setCampaign(this.f45323b);
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.2
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a("BannerShowManager", th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f45330i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a("BannerShowManager", th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f45330i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a("BannerShowManager", th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f45330i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 6.0f), ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 6.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            this.f45324c.addView(mBAdChoice, layoutParams);
        }
    }

    public static /* synthetic */ void l(d dVar) {
        if (dVar.f45329h != null) {
            MBBannerWebView mBBannerWebView = dVar.f45330i;
            if (mBBannerWebView != null) {
                mBBannerWebView.setVisibility(8);
            }
            if (dVar.f45329h.getVisibility() != 0) {
                dVar.f45329h.setVisibility(0);
            }
            if (dVar.f45324c != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                dVar.f45329h.setScaleType(ImageView.ScaleType.FIT_XY);
                if (dVar.f45329h.getParent() == null) {
                    dVar.f45324c.addView(dVar.f45329h, layoutParams);
                }
                dVar.d(true);
            }
        }
    }

    public final void a() {
        kn.b bVar = this.f45345x;
        if (bVar != null) {
            bVar.c();
            this.f45345x = null;
            ad.a("omsdk", " adSession.finish() ");
        }
        if (this.f45322a != null) {
            this.f45322a = null;
        }
        MBBannerWebView mBBannerWebView = this.f45330i;
        if (mBBannerWebView != null) {
            mBBannerWebView.setWebViewListener(null);
        }
        if (this.E != null) {
            this.E = null;
        }
        ImageView imageView = this.f45331j;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.f45329h;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
        MBBannerView mBBannerView = this.f45324c;
        if (mBBannerView != null) {
            mBBannerView.removeAllViews();
        }
        MBBannerWebView mBBannerWebView2 = this.f45330i;
        if (mBBannerWebView2 != null) {
            mBBannerWebView2.release();
        }
        com.mbridge.msdk.mbbanner.common.communication.a aVar = this.f45344w;
        if (aVar != null) {
            aVar.a();
        }
        if (this.D != null) {
            this.D = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f45326e);
    }

    public final void a(int i11, int i12, int i13, int i14) {
        if (i11 == i13 && i12 == i14) {
            return;
        }
        MBBannerWebView mBBannerWebView = this.f45330i;
        ad.b("BannerCallJS", "fireOnBannerViewSizeChange");
        try {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView, i11, i12);
        } catch (Throwable th2) {
            ad.a("BannerCallJS", "fireOnBannerViewSizeChange", th2);
        }
    }

    public void a(CampaignEx campaignEx, boolean z11, String str) {
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    public final void a(CampaignUnit campaignUnit) {
        CampaignEx campaignEx;
        if (campaignUnit != null) {
            ArrayList<CampaignEx> ads = campaignUnit.getAds();
            this.f45340s = ads;
            if (ads == null || ads.size() <= 0) {
                campaignEx = null;
            } else {
                campaignEx = this.f45340s.get(0);
            }
        } else {
            campaignEx = null;
        }
        this.f45323b = campaignEx;
        if (campaignEx == null) {
            a("banner show failed because campain is exception");
            return;
        }
        this.f45346y.removeCallbacks(this.f45347z);
        if (this.f45328g && this.f45331j == null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            this.f45331j = imageView;
            imageView.setBackgroundResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_banner_close", "drawable"));
            this.f45331j.setVisibility(8);
            this.f45331j.setContentDescription("closeButton");
        }
        this.f45335n = false;
        this.f45336o = false;
        this.f45325d = false;
        if (!TextUtils.isEmpty(this.f45323b.getBannerHtml()) || !TextUtils.isEmpty(this.f45323b.getBannerUrl())) {
            com.mbridge.msdk.mbbanner.common.a.a aVarA = com.mbridge.msdk.mbbanner.common.a.a.a().c(this.f45323b.getId()).d(this.f45323b.getRequestId()).e(this.f45323b.getRequestIdNotice()).b(this.f45326e).a(this.f45323b.isBidCampaign());
            String str = this.f45326e;
            if (aVarA != null) {
                aVarA.a("2000067");
                if (j.a().b()) {
                    j.a().a(aVarA.b());
                } else {
                    m.a(aVarA.b(), com.mbridge.msdk.foundation.controller.c.m().c(), str);
                }
            }
        }
        this.f45346y.postDelayed(this.f45347z, 15000L);
        if (b()) {
            return;
        }
        if (!TextUtils.isEmpty(this.f45323b.getBannerHtml()) || !TextUtils.isEmpty(this.f45323b.getBannerUrl())) {
            a("banner render failed because res load failed", 2);
        }
        c();
    }

    public final void a(boolean z11) {
        this.f45328g = z11;
    }

    public final void a(boolean z11, int i11) {
        this.f45342u = i11;
        if (i11 == 0) {
            k kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f45326e);
            if (kVarD == null) {
                return;
            } else {
                z11 = kVarD.f() == 1;
            }
        }
        this.f45328g = z11;
    }

    public final void b(boolean z11) {
        this.f45333l = z11;
        d();
        if (z11) {
            return;
        }
        CampaignEx campaignEx = this.f45323b;
        String str = this.f45326e;
        if (campaignEx != null) {
            String strA = com.mbridge.msdk.mbsignalcommon.mraid.c.a(campaignEx.getId());
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            new o(com.mbridge.msdk.foundation.controller.c.m().c()).b(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, strA, campaignEx.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(campaignEx.getId());
        }
    }

    public final void c(boolean z11) {
        this.f45334m = z11;
        d();
    }
}
