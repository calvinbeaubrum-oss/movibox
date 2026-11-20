package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.g;
import com.mbridge.msdk.video.module.a.a.i;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.a.a.l;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.video.signal.h;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeContainerView extends MBridgeBaseView implements f, h {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private String Q;
    private b R;
    private boolean S;
    private boolean T;
    private List<CampaignEx> U;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MBridgePlayableView f47820n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MBridgeClickCTAView f47821o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private MBridgeClickMiniCardView f47822p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MBridgeNativeEndCardView f47823q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MBridgeH5EndCardView f47824r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MBridgeVastEndCardView f47825s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private MBridgeLandingPageView f47826t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MBridgeVideoEndCoverView f47827u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MBridgeAlertWebview f47828v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private MBridgeOrderCampView f47829w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f47830x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f47831y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f47832z;

    public MBridgeContainerView(Context context) {
        super(context);
        this.f47832z = 1;
        this.A = 1;
        this.B = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47832z = 1;
        this.A = 1;
        this.B = 1;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.S = false;
        this.T = false;
        this.U = new ArrayList();
    }

    private void a() {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null) {
            boolean zIsDynamicView = campaignEx.isDynamicView();
            boolean zL = ai.l(this.f47791b.getendcard_url());
            if (zIsDynamicView && !zL && !this.f47791b.isMraid()) {
                e();
                return;
            }
        }
        if (this.f47832z != 2 || this.J) {
            e();
        } else {
            b();
        }
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th2) {
                ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        a aVar;
        CampaignEx campaignEx;
        this.R = bVar;
        CampaignEx campaignEx2 = this.f47791b;
        if (campaignEx2 != null) {
            if (num == null) {
                num = Integer.valueOf(campaignEx2.getVideo_end_type());
            }
            if (!isLast()) {
                h();
            }
            int iIntValue = num.intValue();
            if (iIntValue != 1) {
                if (iIntValue == 3) {
                    if (this.f47825s == null) {
                        this.f47825s = new MBridgeVastEndCardView(this.f47790a);
                    }
                    this.f47825s.setCampaign(this.f47791b);
                    this.f47825s.setNotifyListener(new l(this.f47794e));
                    this.f47825s.preLoadData(bVar);
                    return;
                }
                if (iIntValue == 4) {
                    if (this.f47826t == null) {
                        this.f47826t = new MBridgeLandingPageView(this.f47790a);
                    }
                    this.f47826t.setCampaign(this.f47791b);
                    this.f47826t.setNotifyListener(new i(this.f47794e));
                    return;
                }
                if (iIntValue != 5) {
                    if (this.f47832z == 2) {
                        boolean zIsDynamicView = this.f47791b.isDynamicView();
                        boolean zL = ai.l(this.f47791b.getendcard_url());
                        if ((!zIsDynamicView || zL || (campaignEx = this.f47791b) == null || campaignEx.isMraid()) && this.f47791b.getAdSpaceT() != 2) {
                            if (this.f47824r == null) {
                                this.f47824r = new MBridgeH5EndCardView(this.f47790a);
                                try {
                                    d dVar = new d();
                                    dVar.a("type", 3);
                                    c.a().a("2000154", this.f47791b, dVar);
                                } catch (Throwable th2) {
                                    ad.b(MBridgeBaseView.TAG, th2.getMessage());
                                }
                            }
                            if (this.f47791b.getDynamicTempCode() == 5 && (aVar = this.f47794e) != null && (aVar instanceof k)) {
                                ((k) aVar).a(this.f47791b);
                            }
                            this.f47824r.setCampaign(this.f47791b);
                            this.f47824r.setCloseDelayShowTime(this.A);
                            this.f47824r.setNotifyListener(new i(this.f47794e));
                            this.f47824r.setUnitId(this.f47830x);
                            this.f47824r.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
                            this.f47824r.preLoadData(bVar);
                            if (this.E) {
                                return;
                            }
                            addView(this.f47824r);
                            return;
                        }
                        return;
                    }
                    CampaignEx campaignEx3 = this.f47791b;
                    int iB = (campaignEx3 == null || campaignEx3.getRewardTemplateMode() == null) ? 0 : this.f47791b.getRewardTemplateMode().b();
                    if (this.f47823q == null) {
                        if (this.f47791b.isDynamicView()) {
                            i();
                        } else {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = new MBridgeNativeEndCardView(this.f47790a, null, false, -1, this.f47791b.getAdSpaceT() == 2, iB, this.f47791b.getMof_tplid());
                            this.f47823q = mBridgeNativeEndCardView;
                            mBridgeNativeEndCardView.setCampaign(this.f47791b);
                        }
                    }
                    this.f47823q.setLayout();
                    if (this.f47791b.isDynamicView()) {
                        if (com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f47791b.getRequestId() + "_" + this.f47791b.getId())) {
                            try {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f47823q, this.f47791b.getRequestId() + "_" + this.f47791b.getId(), new i(this.f47794e));
                            } catch (Exception e11) {
                                ad.b(MBridgeBaseView.TAG, e11.getMessage());
                            }
                        } else {
                            try {
                                String strA = ao.a(this.f47791b.getendcard_url(), "mof");
                                if (!TextUtils.isEmpty(strA) && Integer.parseInt(strA) == 1) {
                                    com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f47791b, this.f47823q, new i(this.f47794e), 2);
                                }
                            } catch (Exception e12) {
                                ad.b(MBridgeBaseView.TAG, e12.getMessage());
                            }
                        }
                    }
                    this.f47823q.setUnitId(this.f47830x);
                    this.f47823q.setCloseBtnDelay(this.A);
                    this.f47823q.setNotifyListener(new i(this.f47794e));
                    this.f47823q.preLoadData(bVar);
                    this.f47823q.setNotchPadding(this.L, this.M, this.N, this.O);
                }
            }
        }
    }

    private void b() {
        if (this.f47824r == null) {
            a(this.R, 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isLoadSuccess()) {
            e();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f47824r;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.f47824r.setError(true);
            }
        } else {
            this.J = true;
            addView(this.f47824r);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.f47824r.excuteTask();
            this.f47824r.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
            n nVar = new n();
            nVar.f(this.f47791b.getRequestId());
            nVar.g(this.f47791b.getRequestIdNotice());
            nVar.e(this.f47791b.getId());
            nVar.d(this.f47791b.isMraid() ? n.f44338a : n.f44339b);
            m.d(nVar, this.f47790a, this.f47830x);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.f47824r;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.f47830x);
        }
    }

    private void b(int i11) {
        if (i11 != -3) {
            if (i11 != -2) {
                if (this.f47821o == null) {
                    this.f47821o = new MBridgeClickCTAView(this.f47790a);
                }
                this.f47821o.setCampaign(this.f47791b);
                this.f47821o.setUnitId(this.f47830x);
                this.f47821o.setNotifyListener(new i(this.f47794e));
                this.f47821o.preLoadData(this.R);
                return;
            }
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx == null || campaignEx.getVideo_end_type() != 2) {
                return;
            }
            if (this.f47822p == null) {
                this.f47822p = new MBridgeClickMiniCardView(this.f47790a);
            }
            this.f47822p.setCampaign(this.f47791b);
            MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
            mBridgeClickMiniCardView.setNotifyListener(new g(mBridgeClickMiniCardView, this.f47794e));
            this.f47822p.preLoadData(this.R);
            setMatchParent();
            f();
            h();
        }
    }

    private void e() {
        this.f47832z = 1;
        if (this.f47823q == null) {
            a(this.R, 2);
        }
        addView(this.f47823q);
        onConfigurationChanged(getResources().getConfiguration());
        this.f47823q.notifyShowListener();
        this.T = true;
        bringToFront();
    }

    private void f() {
        if (this.f47822p == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.E && this.F) {
            this.F = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.f47822p, layoutParams);
    }

    private void g() {
        if (this.f47828v == null) {
            MBridgeAlertWebview mBridgeAlertWebview = new MBridgeAlertWebview(this.f47790a);
            this.f47828v = mBridgeAlertWebview;
            mBridgeAlertWebview.setUnitId(this.f47830x);
            this.f47828v.setCampaign(this.f47791b);
        }
        this.f47828v.preLoadData(this.R);
    }

    private void h() {
        this.D = false;
        this.T = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i11 = 0;
            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt instanceof MBridgeContainerView) {
                    i11++;
                } else {
                    viewGroup.bringChildToFront(childAt);
                }
            }
        }
    }

    private void i() {
        int i11;
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null) {
            return;
        }
        String str = campaignEx.getendcard_url();
        if (TextUtils.isEmpty(str)) {
            i11 = 404;
        } else {
            try {
                i11 = Integer.parseInt(ao.a(str, "ecid"));
            } catch (Throwable th2) {
                ad.b(MBridgeBaseView.TAG, th2.getMessage());
                i11 = 404;
            }
        }
        this.f47823q = new MBridgeNativeEndCardView(this.f47790a, null, true, i11, this.f47791b.getAdSpaceT() == 2, this.f47801l, this.f47791b.getMof_tplid());
        if (this.f47791b.getDynamicTempCode() != 5) {
            this.f47823q.setCampaign(this.f47791b);
            return;
        }
        a aVar = this.f47794e;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.f47791b);
        }
        this.f47823q.setCampaign(this.f47791b);
    }

    public void addOrderViewData(List<CampaignEx> list) {
        if (list == null) {
            return;
        }
        this.U = list;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view == null) {
            ad.b(MBridgeBaseView.TAG, "view is null");
        } else {
            a(view);
            super.addView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            ad.b(MBridgeBaseView.TAG, "view is null");
        } else {
            a(view);
            super.addView(view, layoutParams);
        }
    }

    public boolean canBackPress() {
        if (this.f47823q != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f47826t;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.f47820n;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void configurationChanged(int i11, int i12, int i13) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getVisibility() != 0) {
            return;
        }
        this.f47822p.resizeMiniCard(i11, i12);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean endCardShowing() {
        return this.C;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        return mBridgeH5EndCardView != null && mBridgeH5EndCardView.isPlayable();
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        return mBridgeH5EndCardView == null ? this.f47820n : mBridgeH5EndCardView;
    }

    public CampaignEx getReSetCampaign() {
        if (!this.f47791b.isDynamicView() || !TextUtils.isEmpty(this.f47791b.getendcard_url())) {
            return null;
        }
        int size = this.U.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            if (this.U.get(i12) != null && this.U.get(i12).getId() == this.f47791b.getId()) {
                i11 = i12 - 1;
                break;
            }
        }
        if (i11 < 0 || i11 >= size || this.U.get(i11) == null) {
            return null;
        }
        return this.U.get(i11);
    }

    public boolean getShowingTransparent() {
        return this.E;
    }

    public String getUnitID() {
        return this.f47830x;
    }

    public int getVideoInteractiveType() {
        return this.f47831y;
    }

    public int getVideoSkipTime() {
        return this.I;
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.handlerPlayableException(str);
            if (!this.J) {
                return;
            }
        }
        a();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void hideAlertWebview() {
        if (isLast()) {
            return;
        }
        if (this.S && !this.T) {
            h();
            this.S = false;
        }
        MBridgeAlertWebview mBridgeAlertWebview = this.f47828v;
        if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
            return;
        }
        removeView(this.f47828v);
        MBridgeClickCTAView mBridgeClickCTAView = this.f47821o;
        if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
            return;
        }
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        setVisibility(0);
    }

    public void install(CampaignEx campaignEx) {
        this.f47794e.a(105, campaignEx);
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup != null && viewGroup.indexOfChild(this) == 0;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void ivRewardAdsWithoutVideo(String str) {
        this.f47794e.a(Worker.WHAT_SYNC_DATA, str);
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
        return mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.isLoadSuccess();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean miniCardShowing() {
        return this.D;
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i11) {
        MBridgePlayableView mBridgePlayableView = this.f47820n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i11);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i11);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f47820n, this.f47821o, this.f47822p, this.f47823q, this.f47824r, this.f47825s, this.f47826t, this.f47827u};
        for (int i11 = 0; i11 < 8; i11++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i11];
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void onEndcardBackPress() {
        if (this.f47823q != null || this.f47825s != null) {
            this.f47794e.a(104, "");
            try {
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
                return;
            } catch (Exception e11) {
                ad.b(MBridgeBaseView.TAG, e11.getMessage());
                return;
            }
        }
        if (this.f47826t != null) {
            this.f47794e.a(Worker.WHAT_SYNC_DATA, "");
            return;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.D) {
            this.f47794e.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.f47820n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void orientation(Configuration configuration) {
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f47820n, this.f47822p, this.f47824r, this.f47828v};
        for (int i11 = 0; i11 < 4; i11++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i11];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    public void preLoadData(final b bVar) {
        this.R = bVar;
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null) {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                if (this.f47820n == null) {
                    this.f47820n = new MBridgePlayableView(this.f47790a);
                }
                this.f47820n.setCloseDelayShowTime(this.A);
                this.f47820n.setPlayCloseBtnTm(this.B);
                this.f47820n.setCampaign(this.f47791b);
                this.f47820n.setNotifyListener(new i(this.f47794e) { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.4
                    @Override // com.mbridge.msdk.video.module.a.a.i, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
                    public final void a(int i11, Object obj) {
                        super.a(i11, obj);
                        if (i11 == 100) {
                            MBridgeContainerView.this.webviewshow();
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                            n nVar = new n();
                            nVar.f(MBridgeContainerView.this.f47791b.getRequestId());
                            nVar.g(MBridgeContainerView.this.f47791b.getRequestIdNotice());
                            nVar.e(MBridgeContainerView.this.f47791b.getId());
                            nVar.d(MBridgeContainerView.this.f47791b.isMraid() ? n.f44338a : n.f44339b);
                            MBridgeContainerView mBridgeContainerView2 = MBridgeContainerView.this;
                            m.d(nVar, mBridgeContainerView2.f47790a, mBridgeContainerView2.f47830x);
                        }
                    }
                });
                this.f47820n.preLoadData(bVar);
            } else {
                b(this.f47831y);
                if (this.f47791b.isDynamicView()) {
                    try {
                        a(bVar, Integer.valueOf(this.f47791b.getVideo_end_type()));
                    } catch (Throwable th2) {
                        ad.b(MBridgeBaseView.TAG, th2.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                                mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f47791b.getVideo_end_type()));
                            }
                        });
                    }
                    if (!ai.l(this.f47791b.getendcard_url())) {
                        try {
                            String strA = ao.a(this.f47791b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(strA) && Integer.parseInt(strA) == 1) {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f47791b, 2);
                            }
                        } catch (Exception e11) {
                            ad.b(MBridgeBaseView.TAG, e11.getMessage());
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f47791b.getVideo_end_type()));
                        }
                    }, getVideoSkipTime());
                }
            }
            g();
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void readyStatus(int i11) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i11);
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.f47824r = null;
        }
        MBridgePlayableView mBridgePlayableView = this.f47820n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f47826t;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f47823q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
            this.f47823q.release();
        }
        if (this.f47794e != null) {
            this.f47794e = null;
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void resizeMiniCard(int i11, int i12, int i13) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i11, i12);
            this.f47822p.setRadius(i13);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            f();
        }
    }

    public void setCloseDelayTime(int i11) {
        this.A = i11;
    }

    public void setEndscreenType(int i11) {
        this.f47832z = i11;
    }

    public void setJSFactory(b bVar) {
        this.R = bVar;
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.f47822p.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14, int i15) {
        ad.b(MBridgeBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i11)));
        this.P = i11;
        this.L = i12;
        this.M = i13;
        this.N = i14;
        this.O = i15;
        this.Q = r.a(i11, i12, i13, i14, i15);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f47823q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i12, i13, i14, i15);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.f47842q != null) {
            mBridgeH5EndCardView.setNotchValue(this.Q, i12, i13, i14, i15);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f47824r.f47842q, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
        }
        MBridgePlayableView mBridgePlayableView = this.f47820n;
        if (mBridgePlayableView != null && mBridgePlayableView.f47842q != null) {
            mBridgePlayableView.setNotchValue(this.Q, i12, i13, i14, i15);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f47820n.f47842q, "oncutoutfetched", Base64.encodeToString(this.Q.getBytes(), 0));
        }
        MBridgeOrderCampView mBridgeOrderCampView = this.f47829w;
        if (mBridgeOrderCampView != null) {
            mBridgeOrderCampView.setNotchPadding(i12, i13, i14, i15);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setNotifyListener(a aVar) {
        super.setNotifyListener(aVar);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f47820n, this.f47821o, this.f47822p, this.f47823q, this.f47824r, this.f47825s, this.f47826t, this.f47827u};
        for (int i11 = 0; i11 < 8; i11++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i11];
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new g(this.f47822p, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void setOnPause() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f47823q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f47823q;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i11) {
        this.B = i11;
    }

    public void setRewardStatus(boolean z11) {
        this.K = z11;
    }

    public void setShowingTransparent(boolean z11) {
        this.E = z11;
    }

    public void setUnitID(String str) {
        this.f47830x = str;
    }

    public void setVideoInteractiveType(int i11) {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            this.f47831y = i11;
            return;
        }
        int iA = com.mbridge.msdk.video.dynview.i.a.a(this.f47791b);
        if (iA == 100) {
            this.f47831y = i11;
        } else {
            this.f47831y = iA;
        }
    }

    public void setVideoSkipTime(int i11) {
        this.I = i11;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.f47828v;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1 && !this.T) {
            removeAllViews();
            bringToFront();
            this.S = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.f47828v == null) {
            g();
        }
        MBridgeAlertWebview mBridgeAlertWebview2 = this.f47828v;
        if (mBridgeAlertWebview2 != null && mBridgeAlertWebview2.getParent() != null) {
            removeView(this.f47828v);
        }
        addView(this.f47828v);
        setBackgroundColor(0);
        this.f47828v.webviewshow();
        return true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showEndcard(int i11) {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null) {
            if (i11 == 1) {
                this.f47794e.a(104, "");
            } else if (i11 == 100) {
                if (campaignEx.getPlayable_ads_without_video() == 2) {
                    this.H = true;
                }
                a(this.f47820n);
                setMatchParent();
                e();
            } else if (i11 == 3) {
                removeAllViews();
                setMatchParent();
                if (this.f47825s == null) {
                    a(this.R, 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.f47825s, layoutParams);
                this.f47825s.notifyShowListener();
                this.T = true;
                bringToFront();
            } else if (i11 == 4) {
                this.f47794e.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.f47826t == null) {
                    a(this.R, 4);
                }
                this.f47826t.setUnitId(this.f47830x);
                this.f47826t.preLoadData(this.R);
                addView(this.f47826t);
                this.T = true;
                bringToFront();
            } else if (i11 != 5) {
                removeAllViews();
                setMatchParent();
                this.T = true;
                bringToFront();
                a();
                this.f47794e.a(117, "");
            } else {
                this.f47794e.a(106, "");
            }
        }
        this.C = true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showMiniCard(int i11, int i12, int i13, int i14, int i15) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i11, i12, i13, i14);
            this.f47822p.setRadius(i15);
            this.f47822p.setCloseVisible(8);
            this.f47822p.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            f();
            if (this.G) {
                return;
            }
            this.G = true;
            this.f47794e.a(109, "");
            this.f47794e.a(117, "");
        }
    }

    public void showOrderCampView() {
        MBridgeOrderCampView mBridgeOrderCampView = new MBridgeOrderCampView(this.f47790a);
        this.f47829w = mBridgeOrderCampView;
        mBridgeOrderCampView.setCampaignExes(this.U);
        a aVar = this.f47794e;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.U);
        }
        this.f47829w.setNotifyListener(new i(this.f47794e));
        this.f47829w.setRewarded(this.K);
        this.f47829w.setNotchPadding(this.L, this.M, this.N, this.O);
        this.f47829w.setCampOrderViewBuildCallback(new com.mbridge.msdk.video.dynview.e.b() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.3
            @Override // com.mbridge.msdk.video.dynview.e.b
            public final void a() {
                a aVar2 = MBridgeContainerView.this.f47794e;
                if (aVar2 != null) {
                    aVar2.a(117, "");
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.b
            public final void b() {
                if (MBridgeContainerView.this.f47791b.getAdSpaceT() == 2) {
                    MBridgeContainerView.this.showVideoEndCover();
                } else {
                    MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                    mBridgeContainerView.showEndcard(mBridgeContainerView.f47791b.getVideo_end_type());
                }
            }
        });
        this.f47829w.createView(this);
    }

    public void showPlayableView() {
        if (this.f47791b == null || this.H) {
            return;
        }
        removeAllViews();
        setMatchParent();
        if (this.f47820n == null) {
            preLoadData(this.R);
        }
        addView(this.f47820n);
        MBridgePlayableView mBridgePlayableView = this.f47820n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.setUnitId(this.f47830x);
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null && campaignEx.isMraid() && this.f47791b.getPlayable_ads_without_video() == 2) {
                this.f47820n.setCloseVisible(0);
            }
            this.f47820n.setNotchValue(this.Q, this.L, this.M, this.N, this.O);
        }
        this.T = true;
        bringToFront();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoClickView(int i11) {
        CampaignEx campaignEx;
        if (this.f47791b != null) {
            if (i11 == -1) {
                if (isLast() || endCardShowing()) {
                    return;
                }
                h();
                return;
            }
            if (i11 == 1) {
                if (this.C) {
                    return;
                }
                MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
                if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getParent() != null) {
                    removeView(this.f47824r);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f47822p;
                if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
                    removeView(this.f47822p);
                }
                MBridgeClickCTAView mBridgeClickCTAView = this.f47821o;
                if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
                    try {
                        CampaignEx campaignEx2 = this.f47791b;
                        if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 1) {
                            this.T = true;
                            if (this.f47821o == null) {
                                b(-1);
                            }
                            if (this.f47821o != null && ((campaignEx = this.f47791b) == null || !campaignEx.isDynamicView())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12, -1);
                                addView(this.f47821o, 0, layoutParams);
                            }
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                    return;
                }
                return;
            }
            if (i11 != 2) {
                return;
            }
            MBridgeClickCTAView mBridgeClickCTAView2 = this.f47821o;
            if (mBridgeClickCTAView2 != null && mBridgeClickCTAView2.getParent() != null) {
                removeView(this.f47821o);
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.f47828v;
            if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.f47822p;
                if (mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null) {
                    try {
                        CampaignEx campaignEx3 = this.f47791b;
                        if (campaignEx3 != null && campaignEx3.getPlayable_ads_without_video() == 1) {
                            setMatchParent();
                            f();
                        }
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
                if (!miniCardLoaded()) {
                    h();
                    return;
                }
                MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f47824r;
                if (mBridgeH5EndCardView2 != null && mBridgeH5EndCardView2.getParent() != null) {
                    removeView(this.f47824r);
                }
                this.f47794e.a(112, "");
                CampaignEx campaignEx4 = this.f47791b;
                if (campaignEx4 != null && !campaignEx4.isHasReportAdTrackPause()) {
                    this.f47791b.setHasReportAdTrackPause(true);
                    com.mbridge.msdk.video.module.b.b.f(this.f47790a, this.f47791b);
                }
                if (this.E) {
                    this.f47794e.a(115, "");
                } else {
                    this.T = true;
                    bringToFront();
                    webviewshow();
                    onConfigurationChanged(getResources().getConfiguration());
                }
                this.D = true;
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        MBridgeVideoEndCoverView mBridgeVideoEndCoverView = this.f47827u;
        if (mBridgeVideoEndCoverView == null) {
            b bVar = this.R;
            this.R = bVar;
            if (mBridgeVideoEndCoverView == null) {
                MBridgeVideoEndCoverView mBridgeVideoEndCoverView2 = new MBridgeVideoEndCoverView(this.f47790a);
                this.f47827u = mBridgeVideoEndCoverView2;
                mBridgeVideoEndCoverView2.setCampaign(this.f47791b);
                this.f47827u.setNotifyListener(new i(this.f47794e));
                this.f47827u.preLoadData(bVar);
            }
        }
        addView(this.f47827u);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i11) {
        MBridgePlayableView mBridgePlayableView = this.f47820n;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i11);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f47824r;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i11);
        }
    }

    public void triggerCloseBtn(String str) {
        try {
            d dVar = new d();
            dVar.a("type", 2);
            c.a().a("2000152", dVar);
            c.a().a("2000134", this.f47791b);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
        if (this.f47791b != null) {
            this.f47794e.a(122, "");
            this.f47794e.a(104, "");
        }
    }

    public void webviewshow() {
        try {
            d dVar = new d();
            dVar.a("type", 3);
            c.a().a("2000133", this.f47791b, dVar);
        } catch (Exception unused) {
        }
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f47820n, this.f47822p, this.f47824r, this.f47828v};
        for (int i11 = 0; i11 < 4; i11++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i11];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }
}
