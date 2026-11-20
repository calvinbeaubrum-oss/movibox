package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.Position;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.m;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBTempContainer extends MBTempContainerDiff {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f47386x = "MBTempContainer";
    private com.mbridge.msdk.videocommon.download.a A;
    private h B;
    private com.mbridge.msdk.video.bt.module.a.b C;
    private com.mbridge.msdk.video.dynview.e.a D;
    private int E;
    private String F;
    private com.mbridge.msdk.video.signal.factory.b G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private String P;
    private String Q;
    private List<CampaignEx> R;
    private int S;
    private com.mbridge.msdk.foundation.same.report.d.b T;
    private LayoutInflater U;
    private int V;
    private int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f47387a;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private View f47388aa;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private boolean f47389ab;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private boolean f47390ac;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private boolean f47391ad;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    private boolean f47392ae;

    /* JADX INFO: renamed from: af, reason: collision with root package name */
    private boolean f47393af;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private boolean f47394ag;

    /* JADX INFO: renamed from: ah, reason: collision with root package name */
    private boolean f47395ah;

    /* JADX INFO: renamed from: ai, reason: collision with root package name */
    private boolean f47396ai;

    /* JADX INFO: renamed from: aj, reason: collision with root package name */
    private boolean f47397aj;

    /* JADX INFO: renamed from: ak, reason: collision with root package name */
    private boolean f47398ak;

    /* JADX INFO: renamed from: al, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.mraid.d f47399al;

    /* JADX INFO: renamed from: am, reason: collision with root package name */
    private kn.b f47400am;

    /* JADX INFO: renamed from: an, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f47401an;

    /* JADX INFO: renamed from: ao, reason: collision with root package name */
    private Runnable f47402ao;

    /* JADX INFO: renamed from: ap, reason: collision with root package name */
    private boolean f47403ap;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f47404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a f47405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected WindVaneWebView f47406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected MBridgeContainerView f47407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Handler f47408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Runnable f47409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Runnable f47410h;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View f47411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CampaignEx f47412z;

    /* JADX INFO: compiled from: source.java */
    public interface a {

        /* JADX INFO: renamed from: com.mbridge.msdk.video.bt.module.MBTempContainer$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0523a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f47422a = false;

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a
            public void a(String str) {
                ad.b("ActivityErrorListener", str);
                this.f47422a = true;
            }

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a
            public final void a(boolean z11) {
                this.f47422a = z11;
            }
        }

        void a(String str);

        void a(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends AppletSchemeCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CampaignEx f47423a;

        public b(CampaignEx campaignEx) {
            this.f47423a = campaignEx;
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        public final void onRequestFailed(int i11, String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                ad.a(MBTempContainer.f47386x, "request wx scheme failed: errorCode: " + i11 + " errorMessage: " + str);
            }
            try {
                CampaignEx campaignEx = this.f47423a;
                if (campaignEx != null) {
                    campaignEx.setClickURL(str2);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b(MBTempContainer.f47386x, e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        public final void onRequestStart() {
            if (MBridgeConstans.DEBUG) {
                ad.a(MBTempContainer.f47386x, "start request wx scheme");
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        public final void onRequestSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                ad.a(MBTempContainer.f47386x, "request wx scheme success");
            }
            try {
                CampaignEx campaignEx = this.f47423a;
                if (campaignEx != null) {
                    campaignEx.setDeepLinkUrl(str);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b(MBTempContainer.f47386x, e11.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c extends com.mbridge.msdk.video.module.a.a.a {
        public c(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        /* JADX WARN: Code duplicated, block: B:40:0x00d9  */
        @Override // com.mbridge.msdk.video.module.a.a.a, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        public final void a(int i11, Object obj) {
            if (com.mbridge.msdk.f.b.a()) {
                MBTempContainer.this.setChinaJsCommonContext();
            }
            if (i11 == 108) {
                if (com.mbridge.msdk.f.b.a()) {
                    MBTempContainer mBTempContainer = MBTempContainer.this;
                    mBTempContainer.setChinaCallBackStatus(mBTempContainer.f47406d);
                }
                MBTempContainer.this.getJSCommon().a(new com.mbridge.msdk.video.signal.a.a.b(MBTempContainer.this.getJSCommon(), new e()));
                MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
            } else if (i11 == 113) {
                MBTempContainer.this.B.a(true, ((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
            } else if (i11 == 117) {
                MBridgeVideoView mBridgeVideoView = MBTempContainer.this.mbridgeVideoView;
                if (mBridgeVideoView != null) {
                    mBridgeVideoView.setVisible(4);
                }
                MBTempContainer.this.f47396ai = true;
                MBTempContainer.this.B.b(((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
            } else if (i11 == 126 || i11 == 128) {
                MBTempContainer.this.B.a(false, ((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
            } else if (i11 != 131) {
                switch (i11) {
                    case Worker.WHAT_SYNC_DATA /* 103 */:
                    case 104:
                        MBTempContainer.p(MBTempContainer.this);
                        break;
                    case 105:
                        if (com.mbridge.msdk.f.b.a()) {
                            MBTempContainer.this.setChinaCTACallBack();
                        }
                        MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        break;
                    case 106:
                        if (!com.mbridge.msdk.f.b.a()) {
                            MBTempContainer.this.B.a(true, ((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
                        } else {
                            MBTempContainer mBTempContainer2 = MBTempContainer.this;
                            mBTempContainer2.setChinaBrowserCallBack(mBTempContainer2.C, MBTempContainer.this.F, MBTempContainer.this.B, MBTempContainer.this.f47412z);
                            if (((AbstractJSContainer) MBTempContainer.this).f48400i != null && MBTempContainer.this.f47412z != null) {
                                MBTempContainer.p(MBTempContainer.this);
                            }
                        }
                        break;
                }
            } else {
                MBTempContainer.this.B.a(true, ((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
            }
            super.a(i11, obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d extends com.mbridge.msdk.video.module.a.a.f {
        private d() {
        }

        @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        public final void a(int i11, Object obj) {
            super.a(i11, obj);
            try {
                String string = obj instanceof JSONObject ? obj.toString() : (String) obj;
                if (((AbstractJSContainer) MBTempContainer.this).f48408q && !TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    int iOptInt = jSONObject.optInt("type");
                    int iOptInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    if (iOptInt == 2) {
                        MBTempContainer.this.H = com.mbridge.msdk.foundation.same.a.D;
                    } else if (iOptInt != 3) {
                        MBTempContainer.this.H = com.mbridge.msdk.foundation.same.a.F;
                    } else {
                        MBTempContainer.this.H = com.mbridge.msdk.foundation.same.a.E;
                    }
                    MBTempContainer.this.I = iOptInt2;
                }
            } catch (Exception unused) {
                ad.b("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i11 == 120) {
                MBTempContainer.this.B.b(((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
            }
            if (i11 == 131) {
                MBTempContainer.this.getJSCommon().click(4, obj != null ? obj.toString() : "");
                return;
            }
            if (i11 == 126) {
                MBTempContainer.this.B.a(false, ((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
                return;
            }
            if (i11 == 127) {
                MBTempContainer.this.f47390ac = true;
                MBTempContainer.this.B.a(MBTempContainer.this.T);
                MBTempContainer.this.B.b(((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
                MBTempContainer.this.getJSContainerModule().showEndcard(100);
                return;
            }
            switch (i11) {
                case 100:
                    MBTempContainer.this.f47397aj = true;
                    MBTempContainer mBTempContainer = MBTempContainer.this;
                    mBTempContainer.f47408f.postDelayed(mBTempContainer.f47402ao, 250L);
                    MBTempContainer.this.B.a(MBTempContainer.this.T);
                    break;
                case 101:
                case 102:
                    MBTempContainer.this.getJSCommon().d();
                    break;
                case Worker.WHAT_SYNC_DATA /* 103 */:
                    MBTempContainer.this.f47390ac = true;
                    if (!MBTempContainer.this.f47412z.isMraid()) {
                        MBTempContainer.this.getJSCommon().d();
                    } else {
                        MBTempContainer.p(MBTempContainer.this);
                    }
                    break;
                case 104:
                    MBTempContainer.p(MBTempContainer.this);
                    break;
                case 105:
                    if (com.mbridge.msdk.f.b.a()) {
                        MBTempContainer.this.setChinaCTACallBack();
                    }
                    MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends com.mbridge.msdk.video.signal.a.a.C0531a {
        private e() {
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a() {
            super.a();
            MBTempContainer.this.receiveSuccess();
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a(int i11, String str) {
            super.a(i11, str);
            MBTempContainer.this.defaultLoad(i11, str);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a(boolean z11) {
            super.a(z11);
            MBTempContainer.this.B.a(z11, ((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void b() {
            super.b();
            MBTempContainer mBTempContainer = MBTempContainer.this;
            Handler handler = mBTempContainer.f47408f;
            if (handler != null) {
                handler.removeCallbacks(mBTempContainer.f47409g);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            MBTempContainer.this.f47394ag = true;
            MBTempContainer.P(MBTempContainer.this);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String strOptString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && strOptString.equals("1.0") && ((AbstractJSContainer) MBTempContainer.this).f48400i != null) {
                        if (((AbstractJSContainer) MBTempContainer.this).f48413v) {
                            MBTempContainer.p(MBTempContainer.this);
                        } else {
                            ((AbstractJSContainer) MBTempContainer.this).f48400i.finish();
                        }
                    }
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            if (MBTempContainer.this.f47403ap) {
                MBTempContainer.this.onResume();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.P(MBTempContainer.this);
            MBTempContainer.this.f47394ag = true;
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.N(MBTempContainer.this);
            if (MBTempContainer.this.f47403ap) {
                MBTempContainer.this.onPause();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class f extends com.mbridge.msdk.video.module.a.a.f {
        private f() {
        }

        @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        public final void a(int i11, Object obj) {
            super.a(i11, obj);
            if (((AbstractJSContainer) MBTempContainer.this).f48408q) {
                try {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            MBTempContainer.this.H = jSONObject.getInt("Alert_window_status");
                            MBTempContainer.this.I = jSONObject.getInt("complete_info");
                        }
                    }
                } catch (Exception e11) {
                    ad.b("NotifyListener", e11.getMessage());
                }
            }
            if (i11 != 2) {
                if (i11 == 121) {
                    MBTempContainer.this.f47390ac = true;
                    MBTempContainer.this.B.a(((AbstractJSContainer) MBTempContainer.this).f48402k, ((AbstractJSContainer) MBTempContainer.this).f48401j);
                    MBTempContainer.this.f47395ah = false;
                    return;
                }
                if (i11 == 16) {
                    if (com.mbridge.msdk.f.b.a()) {
                        MBTempContainer.p(MBTempContainer.this);
                        return;
                    } else {
                        MBTempContainer.this.getJSCommon().d();
                        return;
                    }
                }
                if (i11 == 17) {
                    MBTempContainer.this.f47390ac = true;
                    MBridgeContainerView mBridgeContainerView = MBTempContainer.this.f47407e;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.setRewardStatus(true);
                        return;
                    }
                    return;
                }
                switch (i11) {
                    case 10:
                        MBTempContainer.this.f47395ah = true;
                        if (MBTempContainer.this.f47412z != null && !af.a().a("i_l_s_t_r_i", false)) {
                            if (!MBTempContainer.this.f47412z.isDynamicView() || !((AbstractJSContainer) MBTempContainer.this).f48413v || MBTempContainer.this.f47412z.isCampaignIsFiltered()) {
                                MBTempContainer.this.B.a(MBTempContainer.this.T);
                            }
                            com.mbridge.msdk.video.bt.module.b.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.f47412z, ((AbstractJSContainer) MBTempContainer.this).f48401j, MBTempContainer.this.E);
                            break;
                        }
                        break;
                }
            }
            if (i11 == 12) {
                String string = "Play error but has no message.";
                try {
                    if (obj instanceof String) {
                        string = obj.toString();
                    }
                } catch (Throwable th2) {
                    ad.b("NotifyListener", th2.getMessage());
                }
                com.mbridge.msdk.video.bt.module.b.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.f47412z, ((AbstractJSContainer) MBTempContainer.this).f48401j, string, MBTempContainer.this.E);
                if (!MBTempContainer.this.f47395ah) {
                    if (((AbstractJSContainer) MBTempContainer.this).f48403l.C() == 0) {
                        MBTempContainer.this.B.a(MBTempContainer.this.T, "play error");
                        MBTempContainer.this.f47395ah = false;
                        MBTempContainer.p(MBTempContainer.this);
                        return;
                    } else if (MBTempContainer.this.f47412z == null || !MBTempContainer.this.f47412z.isDynamicView() || !((AbstractJSContainer) MBTempContainer.this).f48413v || MBTempContainer.this.f47412z.isCampaignIsFiltered()) {
                        MBTempContainer.this.B.a(MBTempContainer.this.T);
                    }
                }
            }
            MBTempContainer.this.getJSVideoModule().videoOperate(i11 == 2 ? 6 : 3);
            MBTempContainer.this.f47395ah = false;
            if (MBTempContainer.this.f47401an == null || i11 != 2) {
                return;
            }
            MBTempContainer.this.f47401an.m();
        }
    }

    public MBTempContainer(Context context) {
        super(context);
        this.E = 1;
        this.F = "";
        this.H = com.mbridge.msdk.foundation.same.a.F;
        this.J = false;
        this.P = "";
        this.R = new ArrayList();
        this.S = 0;
        this.f47387a = false;
        this.f47404b = false;
        this.f47405c = new a.C0523a();
        this.f47408f = new Handler();
        this.V = 0;
        this.W = 0;
        this.f47409g = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() == 0) {
                    MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
                } else {
                    MBTempContainer.this.V = -3;
                }
            }
        };
        this.f47410h = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() == 0) {
                    MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
                } else {
                    MBTempContainer.this.V = -4;
                }
            }
        };
        this.f47389ab = false;
        this.f47390ac = false;
        this.f47391ad = false;
        this.f47393af = false;
        this.f47394ag = false;
        this.f47395ah = false;
        this.f47396ai = false;
        this.f47397aj = false;
        this.f47398ak = false;
        this.f47400am = null;
        this.f47401an = null;
        this.f47402ao = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.f47388aa != null) {
                    MBTempContainer.this.f47388aa.setVisibility(8);
                }
            }
        };
        this.f47403ap = false;
        init(context);
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = 1;
        this.F = "";
        this.H = com.mbridge.msdk.foundation.same.a.F;
        this.J = false;
        this.P = "";
        this.R = new ArrayList();
        this.S = 0;
        this.f47387a = false;
        this.f47404b = false;
        this.f47405c = new a.C0523a();
        this.f47408f = new Handler();
        this.V = 0;
        this.W = 0;
        this.f47409g = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() == 0) {
                    MBTempContainer.this.defaultLoad(-1, "WebView load timeout");
                } else {
                    MBTempContainer.this.V = -3;
                }
            }
        };
        this.f47410h = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.getActivityProxy().h() == 0) {
                    MBTempContainer.this.defaultLoad(-3, "Signal Communication connect timeout");
                } else {
                    MBTempContainer.this.V = -4;
                }
            }
        };
        this.f47389ab = false;
        this.f47390ac = false;
        this.f47391ad = false;
        this.f47393af = false;
        this.f47394ag = false;
        this.f47395ah = false;
        this.f47396ai = false;
        this.f47397aj = false;
        this.f47398ak = false;
        this.f47400am = null;
        this.f47401an = null;
        this.f47402ao = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.4
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.f47388aa != null) {
                    MBTempContainer.this.f47388aa.setVisibility(8);
                }
            }
        };
        this.f47403ap = false;
        init(context);
    }

    public static /* synthetic */ void N(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.f48400i.runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.8
                @Override // java.lang.Runnable
                public final void run() {
                    MBTempContainer.this.f47388aa.setBackgroundColor(0);
                    MBTempContainer.this.f47388aa.setVisibility(0);
                    MBTempContainer.this.f47388aa.bringToFront();
                }
            });
        }
    }

    public static /* synthetic */ void P(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.f48400i.runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.9
                @Override // java.lang.Runnable
                public final void run() {
                    MBTempContainer.this.f47388aa.setVisibility(8);
                }
            });
        }
    }

    private int a(int i11, int i12) {
        List<CampaignEx> list;
        if (i11 < 0 || (list = this.R) == null || list.size() == 0 || i12 <= 1) {
            return i11;
        }
        int videoLength = 0;
        for (int i13 = 0; i13 < i12 - 1; i13++) {
            if (this.R.get(i13) != null) {
                videoLength += this.R.get(i13).getVideoLength();
            }
        }
        if (i11 > videoLength) {
            return i11 - videoLength;
        }
        return 0;
    }

    private void a(int i11, String str) {
        try {
            n nVar = new n();
            nVar.a("2000037");
            nVar.r("code=" + i11 + ",desc=" + str);
            CampaignEx campaignEx = this.f47412z;
            nVar.q((campaignEx == null || campaignEx.getRewardTemplateMode() == null) ? "" : this.f47412z.getRewardTemplateMode().e());
            nVar.c(this.f48401j);
            CampaignEx campaignEx2 = this.f47412z;
            nVar.e(campaignEx2 != null ? campaignEx2.getId() : "");
            CampaignEx campaignEx3 = this.f47412z;
            if (campaignEx3 != null && !TextUtils.isEmpty(campaignEx3.getRequestId())) {
                nVar.f(this.f47412z.getRequestId());
            }
            CampaignEx campaignEx4 = this.f47412z;
            if (campaignEx4 != null && !TextUtils.isEmpty(campaignEx4.getRequestIdNotice())) {
                nVar.g(this.f47412z.getRequestIdNotice());
            }
            int iL = z.l(getContext());
            nVar.a(iL);
            nVar.k(z.a(getContext(), iL));
            com.mbridge.msdk.video.module.b.b.a(n.h(nVar), this.f48401j);
        } catch (Throwable th2) {
            ad.a(f47386x, th2.getMessage(), th2);
        }
    }

    private int c() {
        k kVarB = b(this.f47412z);
        if (kVarB != null) {
            return kVarB.j();
        }
        return 0;
    }

    private boolean d() {
        k kVarB = b(this.f47412z);
        if (kVarB != null) {
            return kVarB.m();
        }
        return false;
    }

    private boolean e() {
        if (this.mbridgeVideoView == null) {
            return false;
        }
        if (com.mbridge.msdk.f.b.a()) {
            return this.mbridgeVideoView.isShowingAlertView() || checkChinaShowingAlertViewState() || this.mbridgeVideoView.isRewardPopViewShowing();
        }
        return this.mbridgeVideoView.isShowingAlertView() || this.mbridgeVideoView.isRewardPopViewShowing();
    }

    private void f() {
        o oVar = new o(getContext());
        CampaignEx campaignEx = this.f47412z;
        if (campaignEx != null) {
            oVar.b(campaignEx.getRequestId(), this.f47412z.getRequestIdNotice(), this.f47412z.getId(), this.f48401j, com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.f47412z.getId()), this.f47412z.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.f47412z.getId());
            this.f47392ae = true;
        }
    }

    private void g() {
        kn.b bVar = this.f47400am;
        if (bVar != null) {
            try {
                MBridgeContainerView mBridgeContainerView = this.f47407e;
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                bVar.a(mBridgeContainerView, friendlyObstructionPurpose, null);
                View view = this.f47388aa;
                if (view != null) {
                    this.f47400am.a(view, friendlyObstructionPurpose, null);
                }
                WindVaneWebView windVaneWebView = this.f47406d;
                if (windVaneWebView != null) {
                    this.f47400am.a(windVaneWebView, friendlyObstructionPurpose, null);
                }
                kn.a aVarA = kn.a.a(this.f47400am);
                this.f47401an = com.iab.omid.library.mmadbridge.adsession.media.a.g(this.f47400am);
                this.f47400am.g();
                aVarA.c(com.iab.omid.library.mmadbridge.adsession.media.b.b(true, Position.STANDALONE));
                this.mbridgeVideoView.setVideoEvents(this.f47401an);
                aVarA.b();
            } catch (Exception e11) {
                ad.a("omsdk", e11.getMessage());
            }
        }
    }

    private int h() {
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (aVarB != null) {
                return (int) aVarB.h();
            }
            return 5;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 5;
        }
    }

    private int i() {
        CampaignEx campaignEx = this.f47412z;
        if (campaignEx == null) {
            return 1;
        }
        boolean zA = ai.a(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int iC = ai.c(this.f47412z.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        if (!zA || iC < 0) {
            return this.f47412z.getCbd() > -2 ? this.f47412z.getCbd() : this.f48403l.p();
        }
        return iC;
    }

    public static /* synthetic */ void p(MBTempContainer mBTempContainer) {
        int i11;
        try {
            com.mbridge.msdk.video.bt.module.a.b bVar = mBTempContainer.C;
            if (bVar == null) {
                Activity activity = mBTempContainer.f48400i;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (mBTempContainer.f48408q && ((i11 = mBTempContainer.f48410s) == com.mbridge.msdk.foundation.same.a.G || i11 == com.mbridge.msdk.foundation.same.a.H)) {
                boolean z11 = true;
                if (mBTempContainer.I != 1) {
                    z11 = false;
                }
                bVar.a(z11, mBTempContainer.H);
            }
            mBTempContainer.C.a(mBTempContainer.F, mBTempContainer.f47390ac, mBTempContainer.f48405n);
        } catch (Exception unused) {
            Activity activity2 = mBTempContainer.f48400i;
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public final void a(String str) {
        h hVar = this.B;
        if (hVar != null) {
            hVar.a(this.T, str);
        }
        super.a(str);
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.f47407e;
        return mBridgeContainerView == null || mBridgeContainerView.canBackPress();
    }

    public void defaultLoad(int i11, String str) {
        int i12;
        superDefaultLoad(i11, str);
        if (!isLoadSuccess()) {
            a(i11, str);
            Activity activity = this.f48400i;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (this.f47412z.getPlayable_ads_without_video() == 2) {
            this.f47407e.setCampaign(this.f47412z);
            this.f47407e.addOrderViewData(this.R);
            this.f47407e.setUnitID(this.f48401j);
            this.f47407e.setCloseDelayTime(i());
            this.f47407e.setPlayCloseBtnTm(this.f48403l.h());
            this.f47407e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.f47412z, this.A, this.f48405n, b(), this.f48401j, new d(), this.f48403l.y(), this.f48413v));
            this.f47407e.preLoadData(this.G);
            this.f47407e.showPlayableView();
        } else {
            a(i11, str);
            this.f47388aa.setVisibility(8);
            loadModuleDatas();
            int iF = this.f48403l.f();
            int iC = c();
            int i13 = iC != 0 ? iC : iF;
            CampaignEx campaignEx = this.f47412z;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                this.mbridgeVideoView.setContainerViewOnNotifyListener(new c(this.f48400i, this.f47412z));
            }
            CampaignEx campaignEx2 = this.f47412z;
            int iE = (campaignEx2 == null || campaignEx2.getVst() <= -2) ? this.f48403l.e() : this.f47412z.getVst();
            CampaignEx campaignEx3 = this.f47412z;
            if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (i12 = this.E) > 1) {
                iE = a(iE, i12);
                this.f47412z.setVst(iE);
            }
            int i14 = iE;
            this.mbridgeVideoView.setVideoSkipTime(i14);
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            mBridgeVideoView.setNotifyListener(new m(mBridgeVideoView, this.f47407e, this.f47412z, this.f48405n, this.A, b(), this.f48401j, i13, i14, new f(), this.f48403l.y(), this.f48413v, this.f48403l.C()));
            this.mbridgeVideoView.defaultShow();
            MBridgeContainerView mBridgeContainerView = this.f47407e;
            mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.b(this.mbridgeVideoView, mBridgeContainerView, this.f47412z, this.f48405n, this.A, b(), this.f48401j, new c(this.f48400i, this.f47412z), this.f48403l.y(), this.f48413v));
            this.f47407e.defaultShow();
        }
        g();
    }

    public int findID(String str) {
        return v.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return v.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public WindVaneWebView findWindVaneWebView() {
        try {
            if (!this.f48413v) {
                com.mbridge.msdk.videocommon.a.C0532a c0532aA = this.f48408q ? com.mbridge.msdk.videocommon.a.a(287, this.f47412z) : com.mbridge.msdk.videocommon.a.a(94, this.f47412z);
                if (c0532aA == null || !c0532aA.c()) {
                    return null;
                }
                if (this.f48408q) {
                    com.mbridge.msdk.videocommon.a.b(287, this.f47412z);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.f47412z);
                }
                WindVaneWebView windVaneWebViewA = c0532aA.a();
                if (this.f47393af) {
                    windVaneWebViewA.setWebViewTransparent();
                }
                return windVaneWebViewA;
            }
            CampaignEx campaignEx = this.f47412z;
            if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
                return null;
            }
            com.mbridge.msdk.videocommon.a.C0532a c0532aA2 = com.mbridge.msdk.videocommon.a.a(this.f48401j + "_" + this.f47412z.getId() + "_" + this.f47412z.getRequestId() + "_" + this.f47412z.getRewardTemplateMode().e());
            if (c0532aA2 != null) {
                return c0532aA2.a();
            }
            return null;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e11.printStackTrace();
            return null;
        }
    }

    public CampaignEx getCampaign() {
        return this.f47412z;
    }

    public String getInstanceId() {
        return this.F;
    }

    public int getLayoutID() {
        return findLayout(this.f47393af ? "mbridge_reward_activity_video_templete_transparent" : "mbridge_reward_activity_video_templete");
    }

    public void init(Context context) {
        this.U = LayoutInflater.from(context);
    }

    public boolean initViews() {
        View viewFindViewById = findViewById(findID("mbridge_video_templete_progressbar"));
        this.f47388aa = viewFindViewById;
        return viewFindViewById != null;
    }

    public boolean isLoadSuccess() {
        return this.f47404b;
    }

    public void loadModuleDatas() {
        int i11;
        int i12;
        k kVarB = b(this.f47412z);
        int iK = kVarB != null ? kVarB.k() : 0;
        if (iK != 0) {
            this.f48407p = iK;
        }
        int iF = this.f48403l.f();
        int iC = c();
        int i13 = iC != 0 ? iC : iF;
        this.mbridgeVideoView.setSoundState(this.f48407p);
        this.mbridgeVideoView.setCampaign(this.f47412z);
        this.mbridgeVideoView.setPlayURL(this.A.t());
        CampaignEx campaignEx = this.f47412z;
        int iE = (campaignEx == null || campaignEx.getVst() <= -2) ? this.f48403l.e() : this.f47412z.getVst();
        CampaignEx campaignEx2 = this.f47412z;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (i12 = this.E) > 1) {
            iE = a(iE, i12);
            this.f47412z.setVst(iE);
        }
        this.mbridgeVideoView.setVideoSkipTime(iE);
        this.mbridgeVideoView.setCloseAlert(this.f48403l.i());
        this.mbridgeVideoView.setBufferTimeout(h());
        int i14 = iE;
        this.mbridgeVideoView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.n(this.G, this.f47412z, this.f48405n, this.A, b(), this.f48401j, i13, iE, new f(), this.f48403l.y(), this.f48413v, this.f48403l.C()));
        this.mbridgeVideoView.setShowingTransparent(this.f47393af);
        this.mbridgeVideoView.setAdSession(this.f47400am);
        if (this.f48408q && ((i11 = this.f48410s) == com.mbridge.msdk.foundation.same.a.G || i11 == com.mbridge.msdk.foundation.same.a.H)) {
            this.mbridgeVideoView.setIVRewardEnable(i11, this.f48411t, this.f48412u);
            this.mbridgeVideoView.setDialogRole(getJSCommon() != null ? getJSCommon().h() : 1);
        }
        this.f47407e.setCampaign(this.f47412z);
        this.f47407e.addOrderViewData(this.R);
        this.f47407e.setUnitID(this.f48401j);
        this.f47407e.setCloseDelayTime(i());
        this.f47407e.setPlayCloseBtnTm(this.f48403l.h());
        this.f47407e.setVideoInteractiveType(this.f48403l.g());
        this.f47407e.setEndscreenType(this.f48403l.q());
        this.f47407e.setVideoSkipTime(i14);
        this.f47407e.setShowingTransparent(this.f47393af);
        this.f47407e.setJSFactory(this.G);
        if (this.f47412z.getPlayable_ads_without_video() == 2) {
            this.f47407e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.f47412z, this.A, this.f48405n, b(), this.f48401j, new d(), this.f48403l.y(), this.f48413v));
            this.f47407e.preLoadData(this.G);
            this.f47407e.showPlayableView();
        } else {
            this.f47407e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.c(this.G, this.f47412z, this.f48405n, this.A, b(), this.f48401j, new c(this.f48400i, this.f47412z), this.f48403l.y(), this.f48413v));
            this.f47407e.preLoadData(this.G);
            this.mbridgeVideoView.preLoadData(this.G);
        }
        if (this.f47393af) {
            this.f47407e.setMBridgeClickMiniCardViewTransparent();
        }
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (this.f47393af && (mBridgeVideoView2 = this.mbridgeVideoView) != null) {
            mBridgeVideoView2.notifyVideoClose();
            return;
        }
        CampaignEx campaignEx = this.f47412z;
        if (((campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f47412z.getRewardTemplateMode().f() == 5002010) || this.f47395ah) && (mBridgeVideoView = this.mbridgeVideoView) != null) {
            if (!mBridgeVideoView.isMiniCardShowing()) {
                this.mbridgeVideoView.onBackPress();
                return;
            }
            MBridgeContainerView mBridgeContainerView3 = this.f47407e;
            if (mBridgeContainerView3 != null) {
                mBridgeContainerView3.onMiniEndcardBackPress();
                return;
            }
            return;
        }
        if (this.f47397aj && (mBridgeContainerView2 = this.f47407e) != null) {
            mBridgeContainerView2.onPlayableBackPress();
            return;
        }
        if (this.f47396ai && (mBridgeContainerView = this.f47407e) != null) {
            mBridgeContainerView.onEndcardBackPress();
        }
        if (getJSCommon().b()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().g();
                return;
            }
            return;
        }
        if (!canBackPress()) {
            ad.a(f47386x, "onBackPressed can't excute");
            return;
        }
        Activity activity = this.f48400i;
        if (activity == null || this.f48413v || this.f47398ak) {
            return;
        }
        this.f47398ak = true;
        activity.onBackPressed();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        ViewGroup viewGroup;
        int iF;
        int iE;
        List<CampaignEx> list;
        AppletsModel appletsModel;
        if (this.f48403l == null) {
            this.f48403l = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48401j, this.f48408q);
        }
        try {
            if (this.f47412z != null) {
                try {
                    appletsModel = AppletModelManager.getInstance().get(this.f47412z);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                    appletsModel = null;
                }
                if (appletsModel != null) {
                    try {
                        if (appletsModel.can(0)) {
                            appletsModel.setUserClick(false);
                            appletsModel.requestWxAppletsScheme(0, new b(this.f47412z));
                        }
                    } catch (Exception e12) {
                        appletsModel.clearRequestState();
                        if (MBridgeConstans.DEBUG) {
                            e12.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e13) {
            if (MBridgeConstans.DEBUG) {
                e13.printStackTrace();
            }
        }
        this.f47398ak = false;
        try {
            if (this.f48413v) {
                CampaignEx campaignEx = this.f47412z;
                if (campaignEx == null || !campaignEx.isDynamicView()) {
                    this.B = new com.mbridge.msdk.video.bt.module.b.c(this.C, this.F);
                } else {
                    this.B = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.f48408q, this.f48403l, this.f47412z, this.B, b(), this.f48401j);
                }
            } else {
                this.B = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.f48408q, this.f48403l, this.f47412z, this.B, b(), this.f48401j);
            }
            CampaignEx campaignEx2 = this.f47412z;
            if (campaignEx2 != null && campaignEx2.isActiveOm()) {
                this.f47400am = com.mbridge.msdk.a.b.a(getContext(), false, this.f47412z.getOmid(), this.f47412z.getRequestId(), this.f47412z.getId(), this.f48401j, this.A.t(), this.f47412z.getRequestIdNotice());
            }
            registerErrorListener(new com.mbridge.msdk.video.bt.module.b.e(this.T, this.B));
            a(this.f48403l, this.f47412z);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            View viewInflate = this.U.inflate(layoutID, (ViewGroup) null);
            this.f47411y = viewInflate;
            addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
            if (this.f47387a) {
                setMatchParent();
            }
            this.f47406d = findWindVaneWebView();
            MBridgeVideoView mBridgeVideoViewFindMBridgeVideoView = findMBridgeVideoView();
            this.mbridgeVideoView = mBridgeVideoViewFindMBridgeVideoView;
            mBridgeVideoViewFindMBridgeVideoView.setVideoLayout(this.f47412z);
            this.mbridgeVideoView.setIsIV(this.f48408q);
            this.mbridgeVideoView.setUnitId(this.f48401j);
            this.mbridgeVideoView.setCamPlayOrderCallback(this.D, this.R, this.E, this.S);
            if (this.f48413v) {
                this.mbridgeVideoView.setNotchPadding(this.L, this.M, this.N, this.O);
            }
            MBridgeContainerView mBridgeContainerViewFindMBridgeContainerView = findMBridgeContainerView();
            this.f47407e = mBridgeContainerViewFindMBridgeContainerView;
            if (this.f48413v) {
                mBridgeContainerViewFindMBridgeContainerView.setNotchPadding(this.K, this.L, this.M, this.N, this.O);
            }
            if (af.a().a("i_l_s_t_r_i", false)) {
                this.mbridgeVideoView.setPlayerViewAttachListener(new MBridgeVideoView.a() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.3
                    @Override // com.mbridge.msdk.video.module.MBridgeVideoView.a
                    public final void a() {
                        if (MBTempContainer.this.f47412z != null) {
                            if (!MBTempContainer.this.f47412z.isDynamicView() || !((AbstractJSContainer) MBTempContainer.this).f48413v || MBTempContainer.this.f47412z.isCampaignIsFiltered()) {
                                MBTempContainer.this.B.a(MBTempContainer.this.T);
                            }
                            com.mbridge.msdk.video.bt.module.b.f.a(MBTempContainer.this.getContext(), MBTempContainer.this.f47412z, ((AbstractJSContainer) MBTempContainer.this).f48401j, MBTempContainer.this.E);
                        }
                    }
                });
            }
            if (this.mbridgeVideoView == null || this.f47407e == null || !initViews()) {
                this.f47405c.a("not found View IDS");
                Activity activity = this.f48400i;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            this.f47404b = true;
            WindVaneWebView windVaneWebView = this.f47406d;
            this.G = new com.mbridge.msdk.video.signal.factory.b(this.f48400i, windVaneWebView, this.mbridgeVideoView, this.f47407e, this.f47412z, new e());
            CampaignEx campaignEx3 = this.f47412z;
            if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (list = this.R) != null) {
                this.G.a(list);
            }
            registerJsFactory(this.G);
            com.mbridge.msdk.foundation.d.b.a().a(this.f48401j + "_1", new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.6
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                    String string;
                    MBTempContainer.this.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a(MBTempContainer.f47386x, th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f47406d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    String string;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a(MBTempContainer.f47386x, th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f47406d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    String string;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th2) {
                        ad.a(MBTempContainer.f47386x, th2.getMessage(), th2);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f47406d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            if (windVaneWebView == null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) this.f47411y.findViewById(v.a(getContext(), "mbridge_video_templete_webview_parent", "id"));
            windVaneWebView.setApiManagerJSFactory(this.G);
            if (windVaneWebView.getParent() != null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            if (windVaneWebView.getObject() instanceof k) {
                this.G.a((k) windVaneWebView.getObject());
                getJSCommon().a(this.f48407p);
                getJSCommon().a(this.f48401j);
                getJSCommon().a(this.f48403l);
                getJSCommon().a(new e());
                CampaignEx campaignEx4 = this.f47412z;
                if (campaignEx4 != null && (campaignEx4.isMraid() || this.f47412z.isActiveOm())) {
                    com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(getContext());
                    this.f47399al = dVar;
                    dVar.c();
                    this.f47399al.a();
                    this.f47399al.a(new com.mbridge.msdk.mbsignalcommon.mraid.d.b() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.7
                        @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
                        public final void a(double d11) {
                            MBridgeContainerView mBridgeContainerView;
                            ad.b(MBTempContainer.f47386x, "volume is : " + d11);
                            try {
                                if (!MBTempContainer.this.f47412z.isMraid() || (mBridgeContainerView = MBTempContainer.this.f47407e) == null || mBridgeContainerView.getH5EndCardView() == null) {
                                    return;
                                }
                                MBTempContainer.this.f47407e.getH5EndCardView().volumeChange(d11);
                            } catch (Exception e14) {
                                ad.b(MBTempContainer.f47386x, e14.getMessage());
                            }
                        }
                    });
                }
                getJSContainerModule().readyStatus(((k) windVaneWebView.getObject()).o());
                try {
                    if (this.f47406d != null) {
                        int i11 = getResources().getConfiguration().orientation;
                        if (d()) {
                            iF = ai.h(getContext());
                            iE = ai.g(getContext());
                            if (com.mbridge.msdk.foundation.tools.d.a(getContext())) {
                                int iC = ai.c(getContext());
                                if (i11 == 2) {
                                    iF += iC;
                                } else {
                                    iE += iC;
                                }
                            }
                        } else {
                            iF = ai.f(getContext());
                            iE = ai.e(getContext());
                        }
                        int iB = this.f47412z.getRewardTemplateMode().b();
                        if (c(this.f47412z) == 1) {
                            iB = i11;
                        }
                        getJSNotifyProxy().a(i11, iB, iF, iE);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.f44376l, ai.d(getContext()));
                        try {
                            if (this.f48405n != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", this.f48405n.a());
                                jSONObject2.put("amount", this.f48405n.b());
                                jSONObject2.put("id", this.f48406o);
                                jSONObject.put("userId", this.f48404m);
                                jSONObject.put("reward", jSONObject2);
                                jSONObject.put("playVideoMute", this.f48407p);
                                jSONObject.put("extra", this.Q);
                            }
                        } catch (JSONException e14) {
                            ad.a(f47386x, e14.getMessage());
                        } catch (Exception e15) {
                            ad.a(f47386x, e15.getMessage());
                        }
                        String string = jSONObject.toString();
                        com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
                        dVar2.a("type", 2);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000133", this.f47412z, dVar2);
                        getJSNotifyProxy().a(string);
                        g.a().a((WebView) this.f47406d, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
                        getJSCommon().b(true);
                        if (com.mbridge.msdk.f.b.a()) {
                            setChinaCallBackStatus(this.f47406d);
                        }
                        loadModuleDatas();
                        this.f47408f.postDelayed(this.f47409g, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } catch (Exception e16) {
                    if (MBridgeConstans.DEBUG) {
                        e16.printStackTrace();
                    }
                }
                ((k) windVaneWebView.getObject()).f48086m.a();
                if (this.f48413v) {
                    getJSCommon().e(this.W);
                }
            }
            if (getJSCommon().a() == 1 && (viewGroup = (ViewGroup) this.f47411y.findViewById(v.a(getContext(), "mbridge_video_templete_webview_parent", "id"))) != null) {
                ((ViewGroup) this.f47411y).removeView(viewGroup);
                ((ViewGroup) this.f47411y).addView(viewGroup, 1);
            }
            viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
            g();
        } catch (Throwable th2) {
            th2.printStackTrace();
            a("onCreate error" + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        CampaignEx campaignEx;
        int i11;
        if (this.J) {
            return;
        }
        boolean z11 = true;
        this.J = true;
        super.onDestroy();
        try {
            if (com.mbridge.msdk.f.b.a()) {
                setChinaDestroy();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.releasePlayer();
            }
            WindVaneWebView windVaneWebView = this.f47406d;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f47406d.clearWebView();
                this.f47406d.release();
            }
            if (this.C != null) {
                this.C = null;
            }
            this.f47408f.removeCallbacks(this.f47409g);
            this.f47408f.removeCallbacks(this.f47410h);
            getJSCommon().e();
            if (this.f48408q) {
                com.mbridge.msdk.c.h.a().e(this.f48401j);
            }
            if (!this.f47389ab) {
                try {
                    this.f47389ab = true;
                    CampaignEx campaignEx2 = this.f47412z;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 2) {
                        this.f47390ac = true;
                    }
                    h hVar = this.B;
                    if (hVar != null) {
                        if (this.f48408q && ((i11 = this.f48410s) == com.mbridge.msdk.foundation.same.a.G || i11 == com.mbridge.msdk.foundation.same.a.H)) {
                            if (this.I != 1) {
                                z11 = false;
                            }
                            hVar.a(z11, this.H);
                        }
                        if (!this.f47390ac) {
                            this.f48405n.a(0);
                        }
                        this.T.a(this.f47412z);
                        this.B.a(this.T, this.f47390ac, this.f48405n);
                    }
                    this.f47408f.removeCallbacks(this.f47402ao);
                    if (((!this.f48408q && !this.f48413v) || ((campaignEx = this.f47412z) != null && campaignEx.isDynamicView())) && this.f47390ac && (!com.mbridge.msdk.f.b.a() || !checkChinaSendToServerDiff(this.B))) {
                        ad.a(f47386x, "sendToServerRewardInfo");
                        com.mbridge.msdk.video.module.b.b.a(this.f47412z, this.f48405n, this.f48401j, this.f48404m, this.Q);
                    }
                    if (!this.f48413v) {
                        if (this.f48408q) {
                            com.mbridge.msdk.videocommon.a.b(287, this.f47412z);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(94, this.f47412z);
                        }
                    }
                    MBridgeContainerView mBridgeContainerView = this.f47407e;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.release();
                    }
                } catch (Throwable th2) {
                    ad.a(f47386x, th2.getMessage(), th2);
                }
            }
            if (!this.f47392ae) {
                f();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = this.f47399al;
            if (dVar != null) {
                dVar.d();
            }
            kn.b bVar = this.f47400am;
            if (bVar != null) {
                bVar.e();
                this.f47400am.c();
                this.f47400am = null;
            }
            if (!this.f48413v) {
                if (isLoadSuccess()) {
                    this.f47408f.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (((AbstractJSContainer) MBTempContainer.this).f48400i != null) {
                                ((AbstractJSContainer) MBTempContainer.this).f48400i.finish();
                            }
                        }
                    }, 100L);
                } else {
                    Activity activity = this.f48400i;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
            if (!this.f47392ae) {
                f();
            }
            com.mbridge.msdk.video.bt.a.d.c().f(this.F);
        } catch (Throwable th3) {
            ad.a(f47386x, th3.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.f47391ad = true;
        try {
            getJSVideoModule().videoOperate(2);
            MBridgeContainerView mBridgeContainerView = this.f47407e;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnPause();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityPause();
            }
        } catch (Throwable th2) {
            ad.a(f47386x, th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        Runnable runnable;
        Activity activity;
        super.onResume();
        int i11 = this.V;
        if (i11 == -3) {
            runnable = this.f47409g;
        } else {
            runnable = i11 == -4 ? this.f47410h : null;
        }
        if (runnable != null) {
            runnable.run();
            this.V = 0;
        }
        try {
            if (this.mbridgeVideoView != null && !e() && !this.mbridgeVideoView.isMiniCardShowing() && !com.mbridge.msdk.foundation.d.b.f44150c) {
                this.mbridgeVideoView.setCover(false);
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityResume();
            }
            MBridgeContainerView mBridgeContainerView = this.f47407e;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnResume();
            }
            if (this.f47391ad && !e() && !com.mbridge.msdk.foundation.d.b.f44150c) {
                getJSVideoModule().videoOperate(1);
            }
            Activity activity2 = this.f48400i;
            if (activity2 != null) {
                ai.a(activity2.getWindow().getDecorView());
            }
            if (this.f47393af && this.f47394ag && (activity = this.f48400i) != null) {
                activity.finish();
            }
        } catch (Throwable th2) {
            ad.a(f47386x, th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
            this.mbridgeVideoView.onActivityStop();
        }
    }

    public void preload() {
    }

    public void receiveSuccess() {
        ad.a(f47386x, "receiveSuccess ,start hybrid");
        this.f47408f.removeCallbacks(this.f47410h);
        this.f47408f.postDelayed(this.f47402ao, 250L);
    }

    public void registerErrorListener(a aVar) {
        this.f47405c = aVar;
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, int i11) {
        this.D = aVar;
        this.E = i11;
    }

    public void setCampOrderViewData(List<CampaignEx> list, int i11) {
        if (list != null) {
            this.R = list;
        }
        this.S = i11;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f47412z = campaignEx;
        if (campaignEx != null) {
            com.mbridge.msdk.foundation.same.report.d.b bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(campaignEx.getCurrentLocalRid());
            this.T = bVarB;
            if (bVarB == null) {
                this.T = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            this.T.c(campaignEx.getCurrentLocalRid());
            this.T.a(campaignEx);
            if (TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && !TextUtils.isEmpty(this.f48401j)) {
                campaignEx.setCampaignUnitId(this.f48401j);
            }
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (appletsModel != null) {
                this.f47403ap = appletsModel.isSupportWxScheme();
            }
            com.mbridge.msdk.foundation.d.b.a().a(campaignEx.getCampaignUnitId() + "_1", campaignEx);
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.A = aVar;
    }

    public void setCampaignExpired(boolean z11) {
        try {
            CampaignEx campaignEx = this.f47412z;
            if (campaignEx != null) {
                if (z11) {
                    campaignEx.setSpareOfferFlag(1);
                    if (!com.mbridge.msdk.f.b.a()) {
                        com.mbridge.msdk.videocommon.d.c cVar = this.f48403l;
                        if (cVar != null) {
                            if (cVar.y() == 1) {
                                this.f47412z.setCbt(1);
                            } else {
                                this.f47412z.setCbt(0);
                            }
                        }
                    } else if (this.f48409r) {
                        this.f47412z.setCbt(0);
                    } else {
                        com.mbridge.msdk.videocommon.d.c cVar2 = this.f48403l;
                        if (cVar2 != null) {
                            if (cVar2.y() == 1) {
                                this.f47412z.setCbt(1);
                            } else {
                                this.f47412z.setCbt(0);
                            }
                        }
                    }
                } else {
                    campaignEx.setSpareOfferFlag(0);
                    this.f47412z.setCbt(0);
                }
            }
        } catch (Exception e11) {
            ad.b(f47386x, e11.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.Q = str;
    }

    public void setInstanceId(String str) {
        this.F = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.G = bVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.a.b bVar) {
        this.C = bVar;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setMediaPlayerUrl(String str) {
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14, int i15) {
        this.K = i11;
        this.L = i12;
        this.M = i13;
        this.N = i14;
        this.O = i15;
        String strA = r.a(i11, i12, i13, i14, i15);
        this.P = strA;
        ad.b(f47386x, strA);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.P)) {
            getJSCommon().b(this.P);
            if (this.f47406d != null && !TextUtils.isEmpty(this.P)) {
                g.a().a((WebView) this.f47406d, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i12, i13, i14, i15);
        }
        MBridgeContainerView mBridgeContainerView = this.f47407e;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i11, i12, i13, i14, i15);
        }
    }

    public void setShowRewardListener(h hVar) {
        this.B = hVar;
    }

    public void setShowingTransparent() {
        int iA;
        Activity activity;
        boolean zD = d();
        this.f47393af = zD;
        if (zD || (iA = v.a(getContext(), "mbridge_reward_theme", TtmlNode.TAG_STYLE)) <= 1 || (activity = this.f48400i) == null) {
            return;
        }
        activity.setTheme(iA);
    }

    public void setWebViewFront(int i11) {
        this.W = i11;
    }

    public void superDefaultLoad(int i11, String str) {
        this.f47408f.removeCallbacks(this.f47409g);
        this.f47408f.removeCallbacks(this.f47410h);
        this.f47405c.a(true);
        WindVaneWebView windVaneWebView = this.f47406d;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }
}
