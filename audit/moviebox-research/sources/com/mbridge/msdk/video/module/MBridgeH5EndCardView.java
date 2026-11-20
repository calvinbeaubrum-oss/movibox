package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeH5EndCardView extends MBridgeH5EndCardViewDiff {
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private long E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private String N;
    private boolean O;
    private boolean P;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected View f47839n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected RelativeLayout f47840o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected ImageView f47841p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected WindVaneWebView f47842q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected Handler f47843r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected String f47844s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f47845t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f47846u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Handler f47847v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f47848w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f47849x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f47850y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f47851z;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f47859b;

        public a(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f47859b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler handler;
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e11) {
                ad.b("CloseRunnable", e11.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f47859b;
            if (mBridgeH5EndCardView == null || (handler = mBridgeH5EndCardView.f47847v) == null) {
                return;
            }
            handler.sendEmptyMessage(100);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f47861b;

        public b(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f47861b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f47861b;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.C) {
                return;
            }
            this.f47861b.C = true;
            this.f47861b.f47845t = false;
            MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
            this.f47861b.f47794e.a(127, "");
            ad.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f47862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f47863b;

        public c(MBridgeH5EndCardView mBridgeH5EndCardView, int i11) {
            this.f47862a = mBridgeH5EndCardView;
            this.f47863b = i11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f47862a;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.f47791b == null) {
                return;
            }
            try {
                if (mBridgeH5EndCardView.B) {
                    ad.c(MBridgeBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                    return;
                }
                this.f47862a.B = true;
                n nVar = new n("m_download_end", 12, (this.f47863b * 1000) + "", this.f47862a.f47791b.getendcard_url(), this.f47862a.f47791b.getId(), this.f47862a.unitId, "ready timeout", (an.b(this.f47862a.f47791b.getendcard_url()) && this.f47862a.f47791b.getendcard_url().contains(".zip")) ? "1" : "2");
                try {
                    if (this.f47862a.f47791b.getAdType() == 287) {
                        nVar.d("3");
                    } else if (this.f47862a.f47791b.getAdType() == 94) {
                        nVar.d("1");
                    } else if (this.f47862a.f47791b.getAdType() == 42) {
                        nVar.d("2");
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                nVar.f(this.f47862a.f47791b.getRequestId());
                nVar.s(this.f47862a.f47791b.getCurrentLocalRid());
                nVar.g(this.f47862a.f47791b.getRequestIdNotice());
                nVar.c(this.f47862a.f47791b.getAdSpaceT());
                this.f47862a.isLoadSuccess();
            } catch (Throwable th2) {
                ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f47865b;

        public d(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f47865b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f47865b;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.J = true;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f47867b;

        public e(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f47867b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f47867b;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.K = true;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MBridgeH5EndCardView f47869b;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f47869b = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f47869b;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.L) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                this.f47869b.G = true;
            }
        }
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
        this.f47849x = false;
        this.f47843r = new Handler();
        this.f47845t = false;
        this.f47846u = false;
        this.f47850y = false;
        this.f47851z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = 1;
        this.E = 0L;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = "";
        this.f47847v = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (MBridgeH5EndCardView.this.F) {
                    MBridgeH5EndCardView.this.f47794e.a(122, "");
                }
                MBridgeH5EndCardView.this.f47794e.a(Worker.WHAT_SYNC_DATA, "");
            }
        };
        this.O = false;
        this.P = false;
        this.f47848w = false;
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47849x = false;
        this.f47843r = new Handler();
        this.f47845t = false;
        this.f47846u = false;
        this.f47850y = false;
        this.f47851z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = 1;
        this.E = 0L;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = "";
        this.f47847v = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                if (MBridgeH5EndCardView.this.F) {
                    MBridgeH5EndCardView.this.f47794e.a(122, "");
                }
                MBridgeH5EndCardView.this.f47794e.a(Worker.WHAT_SYNC_DATA, "");
            }
        };
        this.O = false;
        this.P = false;
        this.f47848w = false;
    }

    public static /* synthetic */ void a(MBridgeH5EndCardView mBridgeH5EndCardView, long j11, boolean z11) {
        String str;
        int i11;
        int i12;
        try {
            if (mBridgeH5EndCardView.B) {
                return;
            }
            mBridgeH5EndCardView.B = true;
            String str2 = (an.b(mBridgeH5EndCardView.f47791b.getendcard_url()) && mBridgeH5EndCardView.f47791b.getendcard_url().contains(".zip")) ? "1" : "2";
            if (z11) {
                str = "ready timeout";
                i11 = 12;
                i12 = 2;
            } else if (mBridgeH5EndCardView.D == 2) {
                str = "ready no";
                i11 = 11;
                i12 = 3;
            } else {
                str = "ready yes";
                i11 = 10;
                i12 = 1;
            }
            int i13 = i12;
            String str3 = str;
            n nVar = new n("m_download_end", i11, j11 + "", mBridgeH5EndCardView.f47791b.getendcard_url(), mBridgeH5EndCardView.f47791b.getId(), mBridgeH5EndCardView.unitId, str, str2);
            try {
                if (mBridgeH5EndCardView.f47791b.getAdType() == 287) {
                    nVar.d("3");
                } else if (mBridgeH5EndCardView.f47791b.getAdType() == 94) {
                    nVar.d("1");
                } else if (mBridgeH5EndCardView.f47791b.getAdType() == 42) {
                    nVar.d("2");
                }
            } catch (NullPointerException e11) {
                e11.printStackTrace();
            }
            nVar.f(mBridgeH5EndCardView.f47791b.getRequestId());
            nVar.s(mBridgeH5EndCardView.f47791b.getCurrentLocalRid());
            nVar.g(mBridgeH5EndCardView.f47791b.getRequestIdNotice());
            nVar.c(mBridgeH5EndCardView.f47791b.getAdSpaceT());
            try {
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), mBridgeH5EndCardView.f47791b.getCampaignUnitId());
                if (cVarA != null) {
                    nVar.v(cVarA.l());
                }
                com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
                if (aVarB != null) {
                    nVar.u(aVarB.c());
                }
            } catch (Exception e12) {
                ad.b(MBridgeBaseView.TAG, e12.getMessage());
            }
            if (mBridgeH5EndCardView.isLoadSuccess() || i13 != 1) {
                return;
            }
            nVar.b(i13);
            nVar.l(String.valueOf(j11));
            nVar.e(mBridgeH5EndCardView.f47791b.getId());
            nVar.h(str3);
            if (mBridgeH5EndCardView.f47791b.isMraid()) {
                nVar.d(n.f44338a);
            } else {
                nVar.n(mBridgeH5EndCardView.f47791b.getendcard_url());
                nVar.o(str2);
                nVar.d(n.f44339b);
            }
            m.b(nVar, mBridgeH5EndCardView.unitId, mBridgeH5EndCardView.f47791b);
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
        }
    }

    public static /* synthetic */ void d(MBridgeH5EndCardView mBridgeH5EndCardView) {
        CampaignEx campaignEx = mBridgeH5EndCardView.f47791b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        int i11 = mBridgeH5EndCardView.getResources().getConfiguration().orientation;
        String str = AdError.UNDEFINED_DOMAIN;
        if (i11 != 0) {
            if (i11 == 1) {
                str = "portrait";
            } else if (i11 == 2) {
                str = "landscape";
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        HashMap map = new HashMap();
        map.put("placementType", "Interstitial");
        map.put("state", TmcEngineFactory.ENGINE_TYPE_DEFAULT);
        map.put("viewable", "true");
        map.put("currentAppOrientation", jSONObject);
        if (mBridgeH5EndCardView.getContext() instanceof Activity) {
            float fI = z.i(mBridgeH5EndCardView.getContext());
            float fG = z.g(mBridgeH5EndCardView.getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) mBridgeH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f11 = displayMetrics.widthPixels;
            float f12 = displayMetrics.heightPixels;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(mBridgeH5EndCardView.f47842q, fI, fG);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(mBridgeH5EndCardView.f47842q, f11, f12);
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a aVarA = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
        WindVaneWebView windVaneWebView = mBridgeH5EndCardView.f47842q;
        aVarA.a(windVaneWebView, windVaneWebView.getLeft(), mBridgeH5EndCardView.f47842q.getTop(), mBridgeH5EndCardView.f47842q.getWidth(), mBridgeH5EndCardView.f47842q.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a aVarA2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
        WindVaneWebView windVaneWebView2 = mBridgeH5EndCardView.f47842q;
        aVarA2.b(windVaneWebView2, windVaneWebView2.getLeft(), mBridgeH5EndCardView.f47842q.getTop(), mBridgeH5EndCardView.f47842q.getWidth(), mBridgeH5EndCardView.f47842q.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.f47842q, map);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.f47842q, com.mbridge.msdk.mbsignalcommon.mraid.d.f45741a);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBridgeH5EndCardView.f47842q);
    }

    public static /* synthetic */ void f(MBridgeH5EndCardView mBridgeH5EndCardView) {
        try {
            CampaignEx campaignEx = mBridgeH5EndCardView.f47791b;
            if (campaignEx != null) {
                campaignEx.setCampaignUnitId(mBridgeH5EndCardView.unitId);
                com.mbridge.msdk.foundation.d.b.a().c(mBridgeH5EndCardView.unitId + "_1");
                com.mbridge.msdk.foundation.d.b.a().a(mBridgeH5EndCardView.unitId + "_2", mBridgeH5EndCardView.f47791b);
            }
            CampaignEx campaignEx2 = mBridgeH5EndCardView.f47791b;
            if (campaignEx2 == null || !campaignEx2.isMraid()) {
                return;
            }
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            imageView.setBackgroundResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_notice", "drawable"));
            ImageView imageView2 = mBridgeH5EndCardView.f47841p;
            RelativeLayout.LayoutParams layoutParams = imageView2 != null ? (RelativeLayout.LayoutParams) imageView2.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f), ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            if (layoutParams != null) {
                layoutParams2.leftMargin = layoutParams.rightMargin;
                layoutParams2.topMargin = layoutParams.topMargin;
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
            } else {
                layoutParams2.leftMargin = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f);
                layoutParams2.topMargin = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 12.0f);
            }
            mBridgeH5EndCardView.addView(imageView, layoutParams2);
            ai.a(4, imageView, mBridgeH5EndCardView.f47791b, com.mbridge.msdk.foundation.controller.c.m().c(), false, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.5
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
                        ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) MBridgeH5EndCardView.this.f47842q, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) MBridgeH5EndCardView.this.f47842q, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
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
                        ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) MBridgeH5EndCardView.this.f47842q, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String a() {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null) {
            this.F = false;
            return null;
        }
        this.F = true;
        if (campaignEx.isMraid()) {
            this.f47850y = false;
            String mraid = this.f47791b.getMraid();
            if (TextUtils.isEmpty(mraid)) {
                return this.f47791b.getEndScreenUrl();
            }
            File file = new File(mraid);
            try {
                if (file.exists() && file.isFile() && file.canRead()) {
                    mraid = "file:////" + mraid;
                } else {
                    mraid = this.f47791b.getEndScreenUrl();
                }
                return mraid;
            } catch (Throwable th2) {
                if (!MBridgeConstans.DEBUG) {
                    return mraid;
                }
                th2.printStackTrace();
                return mraid;
            }
        }
        String str = this.f47791b.getendcard_url();
        if (an.a(str)) {
            this.f47850y = false;
            return this.f47791b.getEndScreenUrl();
        }
        this.f47850y = true;
        String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
        if (!TextUtils.isEmpty(h5ResAddress)) {
            return h5ResAddress + "&native_adtype=" + this.f47791b.getAdType();
        }
        try {
            String path = Uri.parse(str).getPath();
            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                String endScreenUrl = this.f47791b.getEndScreenUrl();
                if (TextUtils.isEmpty(endScreenUrl)) {
                    return null;
                }
                this.f47850y = false;
                excuteTask();
                return endScreenUrl;
            }
        } catch (Throwable th3) {
            ad.b(MBridgeBaseView.TAG, th3.getMessage());
        }
        return str + "&native_adtype=" + this.f47791b.getAdType();
    }

    public RelativeLayout.LayoutParams b() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.f47795f) {
            this.f47841p.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeH5EndCardView.this.onCloseViewClick();
                }
            });
        }
    }

    public boolean canBackPress() {
        ImageView imageView = this.f47841p;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    public void e() {
        if (this.f47795f) {
            setMatchParent();
        }
    }

    public void excuteEndCardShowTask(int i11) {
        this.f47843r.postDelayed(new c(this, i11), i11 * 1000);
    }

    public void excuteTask() {
        if (this.f47850y || this.f47851z <= -1) {
            return;
        }
        this.f47843r.postDelayed(new f(this), this.f47851z * 1000);
    }

    public void executeEndCardShow(int i11) {
        this.f47843r.postDelayed(new b(this), i11 * 1000);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z11) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.f47791b;
    }

    public void handlerPlayableException(String str) {
        if (this.f47846u) {
            return;
        }
        this.f47846u = true;
        this.f47845t = false;
        if (this.f47791b != null) {
            n nVar = new n();
            nVar.f(this.f47791b.getRequestId());
            nVar.g(this.f47791b.getRequestIdNotice());
            nVar.e(this.f47791b.getId());
            nVar.h(str);
            m.a(nVar, this.f47790a.getApplicationContext(), this.unitId);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_endcard_h5");
        if (iFindLayout >= 0) {
            View viewInflate = this.f47792c.inflate(iFindLayout, (ViewGroup) null);
            this.f47839n = viewInflate;
            try {
                this.f47841p = (ImageView) viewInflate.findViewById(findID("mbridge_windwv_close"));
                this.f47840o = (RelativeLayout) viewInflate.findViewById(findID("mbridge_windwv_content_rl"));
                WindVaneWebView windVaneWebView = new WindVaneWebView(getContext());
                this.f47842q = windVaneWebView;
                CampaignEx campaignEx = this.f47791b;
                if (campaignEx != null) {
                    windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
                }
                this.f47842q.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                this.f47840o.addView(this.f47842q);
                this.f47795f = isNotNULL(this.f47841p, this.f47842q);
            } catch (Exception unused) {
                this.f47795f = false;
            }
            addView(this.f47839n, b());
            c();
            e();
        }
    }

    public void install(CampaignEx campaignEx) {
    }

    public boolean isLoadSuccess() {
        return this.f47845t;
    }

    public boolean isPlayable() {
        return this.f47850y;
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i11) {
        if (i11 == 0) {
            this.H = true;
        } else {
            if (i11 != 1) {
                return;
            }
            this.I = true;
        }
    }

    public void onBackPress() {
        boolean z11;
        if (this.G || (((z11 = this.H) && this.I) || (!(z11 || !this.J || this.f47848w) || (!z11 && this.K && this.f47848w)))) {
            onCloseViewClick();
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.f47842q != null) {
                g.a().a((WebView) this.f47842q, "onSystemDestory", "");
                new Thread(new a(this)).start();
            } else {
                this.f47794e.a(Worker.WHAT_SYNC_DATA, "");
                this.f47794e.a(119, "webview is null when closing webview");
            }
        } catch (Exception e11) {
            this.f47794e.a(Worker.WHAT_SYNC_DATA, "");
            this.f47794e.a(119, "close webview exception" + e11.getMessage());
            ad.a(MBridgeBaseView.TAG, e11.getMessage());
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("type", 2);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000134", this.f47791b);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onFinishRedirection(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        ah.a(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onRedirectionFailed(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        ah.a(campaign, this);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onStartRedirection(Campaign campaign, String str) {
        ah.b(campaign, this);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0 || this.M) {
            return;
        }
        this.M = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        if (z11) {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f47842q, "true");
        } else {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f47842q, "false");
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        super.open(str);
    }

    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            g.a().a((WebView) this.f47842q, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x011b A[EDGE_INSN: B:61:0x011b->B:62:0x011d BREAK  A[LOOP:0: B:46:0x00e1->B:56:0x010b]] */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        int iO;
        String strA = a();
        if (!this.f47795f || this.f47791b == null || TextUtils.isEmpty(strA)) {
            reportRenderResult("PL URL IS NULL", 3);
            this.f47794e.a(127, "");
            this.f47794e.a(TsExtractor.TS_STREAM_TYPE_AC3, "");
        } else {
            this.E = System.currentTimeMillis();
            try {
                reportRenderResult("start", 0);
            } catch (Exception unused) {
            }
            com.mbridge.msdk.foundation.same.g.a aVar = new com.mbridge.msdk.foundation.same.g.a(this.f47791b);
            aVar.a(this.f47791b.getAppName());
            this.f47842q.setDownloadListener(aVar);
            this.f47842q.setCampaignId(this.f47791b.getId());
            this.f47842q.setTempTypeForMetrics(3);
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null) {
                this.f47842q.setCampaignEx(campaignEx);
            }
            setCloseVisible(8);
            this.f47842q.setApiManagerJSFactory(bVar);
            if (this.f47791b.isMraid()) {
                this.f47842q.setMraidObject(this);
            }
            final boolean z11 = strA.contains("wfr=1") || strA.contains("wfl=1");
            this.f47842q.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.3
                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView) {
                    super.a(webView);
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, int i11) {
                    super.a(webView, i11);
                    ad.c("WindVaneWebView", "h5EncardView readyStatus:" + i11 + "- isError" + MBridgeH5EndCardView.this.f47846u);
                    MBridgeH5EndCardView.this.D = i11;
                    if (!MBridgeH5EndCardView.this.f47846u) {
                        MBridgeH5EndCardView.a(MBridgeH5EndCardView.this, System.currentTimeMillis() - MBridgeH5EndCardView.this.E, false);
                    }
                    if (z11) {
                        try {
                            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                            dVar.a("type", 3);
                            dVar.a("result", Integer.valueOf(i11));
                            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000155", MBridgeH5EndCardView.this.f47791b, dVar);
                        } catch (Throwable th2) {
                            ad.b("WindVaneWebView", th2.getMessage());
                        }
                    }
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, int i11, String str, String str2) {
                    super.a(webView, i11, str, str2);
                    MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
                    if (mBridgeH5EndCardView.f47846u) {
                        return;
                    }
                    mBridgeH5EndCardView.f47794e.a(118, "onReceivedError " + i11 + str);
                    MBridgeH5EndCardView.this.reportRenderResult(str, 3);
                    MBridgeH5EndCardView.this.f47794e.a(127, "");
                    MBridgeH5EndCardView.this.f47794e.a(TsExtractor.TS_STREAM_TYPE_AC3, "");
                    MBridgeH5EndCardView.this.f47846u = true;
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, String str) {
                    super.a(webView, str);
                    MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
                    if (mBridgeH5EndCardView.f47846u) {
                        return;
                    }
                    mBridgeH5EndCardView.f47845t = true;
                    mBridgeH5EndCardView.f47794e.a(100, "");
                    if (MBridgeH5EndCardView.this.f47791b != null) {
                        n nVar = new n();
                        nVar.f(MBridgeH5EndCardView.this.f47791b.getRequestId());
                        nVar.g(MBridgeH5EndCardView.this.f47791b.getRequestIdNotice());
                        nVar.e(MBridgeH5EndCardView.this.f47791b.getId());
                        nVar.b(1);
                        nVar.l(String.valueOf(System.currentTimeMillis() - MBridgeH5EndCardView.this.E));
                        nVar.h("onPageFinished");
                        String str2 = "2";
                        if (MBridgeH5EndCardView.this.f47791b.getAdType() == 287) {
                            nVar.d("3");
                        } else if (MBridgeH5EndCardView.this.f47791b.getAdType() == 94) {
                            nVar.d("1");
                        } else if (MBridgeH5EndCardView.this.f47791b.getAdType() == 42) {
                            nVar.d("2");
                        }
                        if (MBridgeH5EndCardView.this.f47791b.isMraid()) {
                            nVar.d(n.f44338a);
                        } else {
                            nVar.n(MBridgeH5EndCardView.this.f47791b.getendcard_url());
                            if (an.b(MBridgeH5EndCardView.this.f47791b.getendcard_url()) && MBridgeH5EndCardView.this.f47791b.getendcard_url().contains(".zip")) {
                                str2 = "1";
                            }
                            nVar.o(str2);
                            nVar.d(n.f44339b);
                        }
                        MBridgeH5EndCardView mBridgeH5EndCardView2 = MBridgeH5EndCardView.this;
                        m.b(nVar, mBridgeH5EndCardView2.unitId, mBridgeH5EndCardView2.f47791b);
                    }
                    MBridgeH5EndCardView.this.f47794e.a(120, "");
                    if (z11) {
                        return;
                    }
                    try {
                        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                        dVar.a("type", 3);
                        dVar.a("result", 1);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000155", MBridgeH5EndCardView.this.f47791b, dVar);
                    } catch (Throwable th2) {
                        ad.b("WindVaneWebView", th2.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void c(WebView webView, int i11) {
                    super.c(webView, i11);
                    MBridgeH5EndCardView.this.D = i11;
                    if (MBridgeH5EndCardView.this.C) {
                        return;
                    }
                    MBridgeH5EndCardView.this.C = true;
                    if (i11 == 1) {
                        MBridgeH5EndCardView.this.reportRenderResult("success", 4);
                    } else {
                        MBridgeH5EndCardView.this.f47794e.a(127, "");
                        MBridgeH5EndCardView.this.reportRenderResult("failed", 6);
                    }
                }
            });
            if (TextUtils.isEmpty(this.f47791b.getMraid())) {
                try {
                    this.E = System.currentTimeMillis();
                    String str = this.f47791b.getendcard_url();
                    com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.unitId);
                    if (this.f47850y && an.b(str) && (str.contains("wfr=1") || (cVarA != null && cVarA.o() > 0))) {
                        if (str.contains("wfr=1")) {
                            String[] strArrSplit = str.split("&");
                            if (strArrSplit != null && strArrSplit.length > 0) {
                                int length = strArrSplit.length;
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= length) {
                                        iO = 20;
                                        break;
                                    }
                                    String str2 = strArrSplit[i11];
                                    if (an.b(str2) && str2.contains("to") && str2.split("=") != null && str2.split("=").length > 0) {
                                        iO = ai.a((Object) str2.split("=")[1]);
                                        break;
                                    }
                                    i11++;
                                }
                            } else {
                                iO = 20;
                                break;
                            }
                        } else {
                            if (cVarA == null || cVarA.o() <= 0) {
                                iO = 20;
                                break;
                            }
                            iO = cVarA.o();
                        }
                        if (iO >= 0) {
                            excuteEndCardShowTask(iO);
                        } else {
                            excuteEndCardShowTask(20);
                        }
                    }
                } catch (Throwable th2) {
                    ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
                }
            }
            setHtmlSource(HTMLResourceManager.getInstance().getHtmlContentFromUrl(strA));
            if (TextUtils.isEmpty(this.f47844s)) {
                this.f47842q.loadUrl(strA);
            } else {
                this.f47842q.loadDataWithBaseURL(strA, this.f47844s, "text/html", "UTF-8", null);
            }
        }
        this.f47848w = false;
    }

    public void readyStatus(int i11) {
    }

    public void release() {
        Handler handler = this.f47843r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f47843r = null;
        }
        Handler handler2 = this.f47847v;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.f47847v = null;
        }
        this.f47840o.removeAllViews();
        this.f47842q.release();
        this.f47842q = null;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new o(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.f47791b.isBidCampaign());
        }
    }

    public void reportRenderResult(String str, int i11) {
        if (this.f47791b == null || this.f47846u) {
            return;
        }
        n nVar = new n();
        nVar.f(this.f47791b.getRequestId());
        nVar.g(this.f47791b.getRequestIdNotice());
        nVar.e(this.f47791b.getId());
        nVar.b(i11);
        nVar.l(String.valueOf(System.currentTimeMillis() - this.E));
        nVar.h(str);
        String str2 = "2";
        if (this.f47791b.getAdType() == 287) {
            nVar.d("3");
        } else if (this.f47791b.getAdType() == 94) {
            nVar.d("1");
        } else if (this.f47791b.getAdType() == 42) {
            nVar.d("2");
        }
        if (this.f47791b.isMraid()) {
            nVar.d(n.f44338a);
        } else {
            nVar.n(this.f47791b.getendcard_url());
            if (an.b(this.f47791b.getendcard_url()) && this.f47791b.getendcard_url().contains(".zip")) {
                str2 = "1";
            }
            nVar.o(str2);
            nVar.d(n.f44339b);
        }
        m.b(nVar, this.unitId, this.f47791b);
    }

    public void setCloseDelayShowTime(int i11) {
        this.f47851z = i11;
    }

    public void setCloseVisible(int i11) {
        if (this.f47795f) {
            this.f47841p.setVisibility(i11);
        }
    }

    public void setCloseVisibleForMraid(int i11) {
        if (this.f47795f) {
            this.L = true;
            if (i11 == 4) {
                this.f47841p.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.f47841p.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.f47841p.setVisibility(0);
        }
    }

    public void setError(boolean z11) {
        this.f47846u = z11;
    }

    public void setHtmlSource(String str) {
        this.f47844s = str;
    }

    public void setLoadPlayable(boolean z11) {
        this.f47848w = z11;
    }

    public void setNotchValue(String str, int i11, int i12, int i13, int i14) {
        this.N = str;
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
            return;
        }
        ad.b(MBridgeBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f47841p.getLayoutParams();
        int iA = ai.a(getContext(), 20.0f);
        layoutParams.setMargins(i11 + iA, i13 + iA, i12 + iA, i14 + iA);
        this.f47841p.setLayoutParams(layoutParams);
    }

    public void setPlayCloseBtnTm(int i11) {
        this.A = i11;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.f47791b.getendcard_url();
            if (an.b(str) && str.contains("wfl=1")) {
                String[] strArrSplit = str.split("&");
                int iA = 15;
                if (strArrSplit != null && strArrSplit.length > 0) {
                    for (String str2 : strArrSplit) {
                        if (an.b(str2) && str2.contains("timeout") && str2.split("=") != null && str2.split("=").length > 0) {
                            iA = ai.a((Object) str2.split("=")[1]);
                        }
                    }
                }
                executeEndCardShow(iA);
            }
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i11) {
        int visibility = this.f47841p.getVisibility();
        if (i11 == 1) {
            this.G = true;
            visibility = 0;
        } else if (i11 == 2) {
            this.G = false;
            if (this.f47848w) {
                if (!this.P && !this.H) {
                    this.P = true;
                    int i12 = this.A;
                    if (i12 == 0) {
                        this.K = true;
                    } else {
                        this.K = false;
                        if (i12 > -1) {
                            this.f47843r.postDelayed(new e(this), this.A * 1000);
                        }
                    }
                }
            } else if (!this.O && !this.H) {
                this.O = true;
                int i13 = this.f47851z;
                if (i13 == 0) {
                    this.J = true;
                } else {
                    this.J = false;
                    if (i13 > -1) {
                        this.f47843r.postDelayed(new d(this), this.f47851z * 1000);
                    }
                }
            }
            visibility = 8;
        }
        setCloseVisible(visibility);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z11) {
        try {
            setCloseVisibleForMraid(z11 ? 4 : 0);
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void volumeChange(double d11) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f47842q, d11);
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f47842q;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeH5EndCardView.4
                @Override // java.lang.Runnable
                public final void run() {
                    String string;
                    try {
                        ad.a(MBridgeBaseView.TAG, "webviewshow");
                        try {
                            int[] iArr = new int[2];
                            MBridgeH5EndCardView.this.f47842q.getLocationOnScreen(iArr);
                            ad.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                            if (contextC != null) {
                                jSONObject.put("startX", ai.b(contextC, iArr[0]));
                                jSONObject.put("startY", ai.b(contextC, iArr[1]));
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f44376l, ai.d(contextC));
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th2) {
                            ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
                            string = "";
                        }
                        g.a().a((WebView) MBridgeH5EndCardView.this.f47842q, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                        MBridgeH5EndCardView.this.f47794e.a(109, "");
                        MBridgeH5EndCardView.d(MBridgeH5EndCardView.this);
                        MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                        g gVarA = g.a();
                        MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
                        gVarA.a((WebView) mBridgeH5EndCardView.f47842q, "oncutoutfetched", Base64.encodeToString(mBridgeH5EndCardView.N.getBytes(), 0));
                        MBridgeH5EndCardView.f(MBridgeH5EndCardView.this);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            });
        }
    }
}
