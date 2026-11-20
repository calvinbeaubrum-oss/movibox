package com.cloud.hisavana.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.common.activity.HisavanaSplashActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.widget.CountTimeView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.google.android.exoplayer2.PlaybackException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class u1 extends t {
    public CountTimeView R;
    public s9.c S;
    public ViewGroup T;
    public View U;
    public final Context V;
    public x1 W;
    public volatile AdsDTO X;
    public boolean Y;
    public Handler Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public long f30129a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f30130b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CopyOnWriteArrayList<p1> f30131c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public AdChoicesView f30132d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public LinearLayout f30133e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public AdDisclaimerView f30134f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public y9.d f30135g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public PopupWindow f30136h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Runnable f30137i0;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.a().d("TranSplash", "closeAdRunnable all time is end");
            u1.this.L0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f30139a;

        public b(int i11) {
            this.f30139a = i11;
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void a(TaErrorCode taErrorCode) {
            u1.this.p(taErrorCode, this.f30139a);
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void b(AdsDTO adsDTO) {
            if (this.f30139a == 4) {
                u1.this.f30046d = 4;
                u1.this.E.e();
            } else {
                if (u1.this.s0()) {
                    return;
                }
                if (adsDTO == null || !u1.this.r1()) {
                    u1.this.p(TaErrorCode.ERROR_AD_SHOW_NOT_IN_INTERVAL, this.f30139a);
                    return;
                }
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(adsDTO);
                u1.this.z(arrayList, this.f30139a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Preconditions.a {
        public c() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "loadPlatformAd bidInfo");
            if (u1.this.f30046d != 2 || u1.this.f30046d == 8 || u1.this.f30046d == 1) {
                z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "bid  is not success");
            } else {
                u1 u1Var = u1.this;
                u1Var.k1(u1Var.X, 4);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Preconditions.a {
        public d() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            u1.this.K0();
            u1.super.W();
            com.cloud.sdk.commonutil.util.l.a(u1.this.f30132d0);
            if (u1.this.W != null) {
                u1.this.W.b();
            }
            if (u1.this.R != null) {
                u1.this.R.cancel();
                u1.this.R.setCountDownTimerListener(null);
                u1.this.R = null;
            }
            if (u1.this.T != null) {
                u1.this.T.removeAllViews();
            }
            u1.this.T = null;
            if (u1.this.U != null && (u1.this.U.getParent() instanceof ViewGroup)) {
                ((ViewGroup) u1.this.U.getParent()).removeView(u1.this.U);
            }
            u1.this.U = null;
            u1.this.z1();
            z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "TranSplash，destroy");
            r0.e().a();
            if (u1.this.f30135g0 != null) {
                u1.this.f30135g0.f();
                u1.this.f30135g0 = null;
            }
            if (u1.this.f30136h0 != null) {
                u1.this.f30136h0.dismiss();
                u1.this.f30136h0 = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u1.this.R != null) {
                u1.this.R.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e1.g(com.cloud.sdk.commonutil.util.f.a(), u1.this.X);
            if (u1.this.X == null || u1.this.X.isOfflineAd() || u1.this.l() == null) {
                return;
            }
            u1.this.l().a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements CountTimeView.b {
        public g() {
        }

        @Override // com.cloud.hisavana.sdk.common.widget.CountTimeView.b
        public void onClick() {
            if (u1.this.R != null) {
                u1.this.R.cancel();
            }
            if (u1.this.S != null) {
                u1.this.S.onClick();
            }
            r0.e().a();
            AthenaTracker.f0(u1.this.X);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.CountTimeView.b
        public void onFinish() {
            z.a().d("TranSplash", "splash ad onTimeEnd");
            if (u1.this.S != null) {
                u1.this.S.a();
                r0.e().a();
            }
        }

        @Override // com.cloud.hisavana.sdk.common.widget.CountTimeView.b
        public void onStart() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u1.this.T != null) {
                u1.this.T.removeAllViews();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends f0 {
        public i(AdsDTO adsDTO) {
            super(adsDTO);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void d() {
            super.d();
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void e(boolean z11) {
            super.e(z11);
            z.a().d("TranSplash", "onCompanion");
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onIsPlayingChanged(boolean z11) {
            z.a().d("TranSplash", "onIsPlayingChanged isPLaying " + z11);
            super.onIsPlayingChanged(z11);
        }

        @Override // com.cloud.hisavana.sdk.f0, com.cloud.hisavana.sdk.q0
        public void onPlayerError(PlaybackException playbackException) {
            z.a().d("TranSplash", "onPlayerError");
            super.onPlayerError(playbackException);
            if (u1.this.l() != null) {
                u1.this.l().h(playbackException == null ? TaErrorCode.ERROR_NETWORK_NOT_CONNECTED : new TaErrorCode(playbackException.errorCode, playbackException.getMessage()));
                r0.e().a();
            }
        }
    }

    public u1(Context context, ViewGroup viewGroup, String str) {
        super(4, str);
        this.W = null;
        this.f30129a0 = 10000L;
        this.f30131c0 = new CopyOnWriteArrayList<>();
        this.f30137i0 = new a();
        this.T = viewGroup;
        this.V = context;
        this.f30043a = str;
    }

    public u1(Context context, String str) {
        this(context, null, str);
    }

    private void F0() {
        Resources resources;
        int i11;
        if (this.X == null || this.T == null || this.V == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.T.getLayoutDirection() == 0) {
            layoutParams.setMarginEnd(this.V.getResources().getDimensionPixelOffset(R$dimen.dimens_16));
        } else {
            layoutParams.setMarginStart(this.V.getResources().getDimensionPixelOffset(R$dimen.dimens_16));
        }
        if (this.U == null) {
            resources = this.V.getResources();
            i11 = R$dimen.dimens_82;
        } else {
            resources = this.V.getResources();
            i11 = R$dimen.dimens_48;
        }
        layoutParams.bottomMargin = resources.getDimensionPixelOffset(i11);
        layoutParams.addRule(12);
        layoutParams.addRule(21);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.V).inflate(R$layout.include_ad_flag, this.T, false);
        this.f30133e0 = linearLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setId(View.generateViewId());
        this.f30132d0 = (AdChoicesView) this.f30133e0.findViewById(R$id.ad_choices_view);
        AdBadgeView adBadgeView = (AdBadgeView) this.f30133e0.findViewById(R$id.ad_badge_view);
        AdCloseView adCloseView = (AdCloseView) this.f30133e0.findViewById(R$id.ad_close_view);
        j1(this.f30132d0);
        if (adBadgeView != null) {
            adBadgeView.setDisplayStyle(this.X.getDisplayRule(), w9.v.c(this.X));
        }
        if (adCloseView != null) {
            adCloseView.setDisplayStyle(this.X.getDisplayRule(), AdCloseView.CloseImageType.EXPAND);
            com.cloud.hisavana.sdk.h.p().f(this.V, adCloseView, this, this.X);
        }
        this.T.addView(this.f30133e0, layoutParams);
    }

    private void G0() {
        ViewParent parent;
        if (this.T == null || this.U == null || this.X.isInteractiveAd() || (parent = this.T.getParent()) == null) {
            return;
        }
        int iJ = ca.d.j();
        int i11 = iJ > 0 ? (int) (((double) iJ) * 0.14d) : 0;
        if (i11 == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, i11);
        this.T.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, i11);
        layoutParams2.addRule(12);
        if (this.U.getParent() != null) {
            ((ViewGroup) this.U.getParent()).removeView(this.U);
        }
        ((ViewGroup) parent).addView(this.U, layoutParams2);
    }

    private void H0() {
        if (this.T == null || !w9.x.a(this.X) || this.X == null) {
            return;
        }
        StoreMarkView storeMarkView = new StoreMarkView(this.V);
        storeMarkView.setTextSize(8.0f);
        storeMarkView.setTextColor(-1);
        storeMarkView.setVisibility(0);
        storeMarkView.attachInfo(this.X);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.V.getResources().getDimensionPixelOffset(R$dimen.dimens_16);
        layoutParams.addRule(20);
        LinearLayout linearLayout = this.f30133e0;
        if (linearLayout == null || linearLayout.getParent() == null) {
            layoutParams.addRule(12);
        } else {
            layoutParams.addRule(8, this.f30133e0.getId());
        }
        this.T.addView(storeMarkView, layoutParams);
    }

    private void I0() {
        if (this.X == null || this.X.getDisplayRule() != Constants.AdDisplayRule.RU || this.T == null || this.V == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.V.getResources().getDimensionPixelOffset(R$dimen.ad_disclaimer_height));
        layoutParams.addRule(12);
        AdDisclaimerView adDisclaimerView = new AdDisclaimerView(this.V);
        this.T.addView(adDisclaimerView, layoutParams);
        adDisclaimerView.setDisplayStyle(this.X.getDisplayRule(), w9.v.f(this.X));
        adDisclaimerView.updateHeightWith(w9.v.e(this.X), this.T.getHeight());
        adDisclaimerView.setListener(new AdDisclaimerView.b() { // from class: com.cloud.hisavana.sdk.k3
            @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
            public final void a(String str, String str2, String str3) {
                this.f29847a.p1(str, str2, str3);
            }
        });
        this.f30134f0 = adDisclaimerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(AdsDTO adsDTO, int i11) {
        p1 p1Var = new p1(adsDTO, i11, new b(i11));
        this.f30131c0.add(p1Var);
        p1Var.i();
    }

    @Override // com.cloud.hisavana.sdk.t
    public void B0() {
        this.Y = true;
        z1();
    }

    public void B1() {
        if (this.V == null || this.X == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "contex is null or mAdBean is null");
            r0.e().a();
            return;
        }
        this.f30066x = w9.a.f79345a.b(this.X);
        if (this.W == null) {
            this.W = new x1(this);
        }
        this.W.h(new i(this.X));
        this.W.c(this.f30066x);
        if (X0()) {
            this.W.A(this.X);
            f1(10000L);
        } else {
            z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "Ad is not ready");
            r0.e().a();
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void C0() {
        s1(100L);
    }

    @Override // com.cloud.hisavana.sdk.t
    public void D0() {
    }

    public void D1() {
        if (X0()) {
            r0.e().c(this);
            HisavanaSplashActivity.M(this.V);
            return;
        }
        r0.e().a();
        z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "current status is " + this.f30046d);
    }

    public AdsDTO F1() {
        return this.X;
    }

    public final void J0() {
        VastData videoInfo;
        Integer duration;
        if (this.T == null || this.V == null) {
            return;
        }
        this.R = new CountTimeView(this.V);
        Integer showTime = this.X.getShowTime();
        if (this.X.isVastTypeAd() && (videoInfo = this.X.getVideoInfo()) != null && (duration = videoInfo.getDuration()) != null && duration.intValue() > 1 && duration.intValue() <= 5) {
            showTime = Integer.valueOf(duration.intValue() - 1);
        }
        this.R.setStartTime(showTime.intValue());
        this.R.setCountDownTimerListener(new g());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.R.getLayoutDirection() == 0) {
            layoutParams.setMarginEnd(this.V.getResources().getDimensionPixelOffset(R$dimen.ad_mark_margin_start));
        } else {
            layoutParams.setMarginStart(this.V.getResources().getDimensionPixelOffset(R$dimen.ad_mark_margin_start));
        }
        layoutParams.topMargin = this.V.getResources().getDimensionPixelOffset(R$dimen.ad_mark_margin_top);
        int dimensionPixelSize = this.V.getResources().getDimensionPixelSize(R$dimen.ad_skip_view_width);
        int dimensionPixelOffset = this.V.getResources().getDimensionPixelOffset(R$dimen.ad_skip_view_height);
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelOffset;
        layoutParams.addRule(21);
        ViewGroup viewGroup = this.T;
        if (viewGroup != null) {
            viewGroup.addView(this.R, layoutParams);
        }
        this.R.setVisibility(8);
    }

    public final void K0() {
        CopyOnWriteArrayList<p1> copyOnWriteArrayList = this.f30131c0;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (p1 p1Var : this.f30131c0) {
            if (p1Var != null) {
                p1Var.k();
            }
        }
        this.f30131c0.clear();
    }

    public void L0() {
        z.a().d("TranSplash", "splash ad close");
        z1();
        if (l() != null) {
            l().b();
        }
        r0.e().a();
    }

    public void M0() {
        f1(this.f30129a0);
    }

    @Override // com.cloud.hisavana.sdk.t
    public void N(List<AdsDTO> list, int i11) {
        AdsDTO adsDTO = (list == null || list.isEmpty()) ? null : list.get(0);
        if (this.f30061s) {
            z(list, i11);
        } else {
            k1(adsDTO, i11);
        }
    }

    public Context N0() {
        return this.V;
    }

    public void O0() {
        x1 x1Var = this.W;
        if (x1Var != null) {
            x1Var.z(this.X);
        }
    }

    public void P0() {
        z.a().d("TranSplash", "fillSplash");
        if (this.T == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "bg view is null");
            return;
        }
        G0();
        x1 x1Var = this.W;
        View viewB = x1Var != null ? x1Var.B(this.X) : null;
        if (viewB == null) {
            z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "Splash view is null");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (viewB.getParent() != null) {
            ((ViewGroup) viewB.getParent()).removeView(viewB);
        }
        this.T.addView(viewB, layoutParams);
        z.a().d("TranSplash", "fillSplash renderView " + viewB);
        I0();
        F0();
        H0();
        J0();
        this.T.postDelayed(new e(), 1000L);
    }

    public int Q0() {
        if (this.X != null) {
            return this.X.getDspType().intValue();
        }
        return 1;
    }

    public double R0() {
        if (this.X != null) {
            return this.X.getFirstPrice().doubleValue();
        }
        return 0.0d;
    }

    public CountTimeView S0() {
        return this.R;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void T(List<AdsDTO> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.X = list.get(0);
    }

    public boolean T0() {
        return !w9.c.b(this.X);
    }

    public boolean U0() {
        return this.X != null && this.X.getSource() == 4;
    }

    public boolean V0() {
        if (this.X != null) {
            return this.X.isJumpToHalfscreen();
        }
        return false;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void W() {
        Preconditions.d(new d());
    }

    public boolean W0() {
        if (this.X == null) {
            return false;
        }
        return this.X.isOfflineAd();
    }

    public boolean X0() {
        return this.f30046d == 4 && T0();
    }

    @Override // com.cloud.hisavana.sdk.t
    public List<AdsDTO> a0() {
        ArrayList arrayList = new ArrayList();
        if (this.X == null) {
            return arrayList;
        }
        arrayList.add(this.X);
        return arrayList;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void e() {
        super.e();
        r0.e().a();
    }

    @Override // com.cloud.hisavana.sdk.t
    public void f() {
        K0();
    }

    public final void f1(long j11) {
        this.f30130b0 = System.currentTimeMillis();
        if (this.Z == null) {
            this.Z = new Handler(Looper.getMainLooper());
        }
        this.Z.postDelayed(this.f30137i0, j11);
        z.a().d("TranSplash", "closeAdDelay " + j11);
    }

    public void g1(View view) {
        this.U = view;
    }

    public void h1(ViewGroup viewGroup) {
        this.T = viewGroup;
    }

    public void i1(PopupWindow popupWindow) {
        this.f30136h0 = popupWindow;
    }

    public final void j1(AdChoicesView adChoicesView) {
        if (adChoicesView == null) {
            return;
        }
        if (this.X != null) {
            this.X.setACReady(Boolean.TRUE);
        }
        if (this.X.getSource() == 4) {
            DownLoadRequest.o(this.X.getAdChoiceImageUrl(), this.X, null, adChoicesView);
        } else {
            DownLoadRequest.p(this.X.getAdChoiceImageUrl(), this.X, 3, null, adChoicesView);
        }
        adChoicesView.setOnClickListener(new f());
    }

    public void l1(BidInfo bidInfo) {
        Preconditions.d(new c());
    }

    @Override // com.cloud.hisavana.sdk.t
    public void m(double d11) {
        if (this.X != null) {
            this.X.setSecondPrice(d11);
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void o(TaErrorCode taErrorCode) {
        r0.e().a();
        s1(0L);
    }

    public final /* synthetic */ void p1(String str, String str2, String str3) {
        y9.d dVarI = new y9.d(this.T).j(str).h(str2).i(str3, null);
        this.f30135g0 = dVarI;
        dVarI.k();
    }

    public void q1(s9.c cVar) {
        this.S = cVar;
    }

    public final boolean r1() {
        ConfigCodeSeatDTO configCodeSeatDTO = this.f30054l;
        if (configCodeSeatDTO != null) {
            int iIntValue = configCodeSeatDTO.getShowInterval().intValue();
            long lastShowAdTime = this.f30054l.getLastShowAdTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            z.a().d("TranSplash", "calculateDownloadCount, current " + jCurrentTimeMillis + ",lastShowAdTime " + lastShowAdTime + ",showInterval " + iIntValue);
            if (iIntValue != 0 && Math.abs(lastShowAdTime - jCurrentTimeMillis) < ((long) iIntValue) * 1000) {
                z.a().d("TranSplash", "ad display did not reach the interval, current " + jCurrentTimeMillis + ",lastShowAdTime " + lastShowAdTime + ",showInterval " + iIntValue);
                return false;
            }
        }
        return true;
    }

    public final void s1(long j11) {
        ViewGroup viewGroup = this.T;
        if (viewGroup == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j11);
        alphaAnimation.start();
        viewGroup.postDelayed(new h(), j11);
    }

    public boolean v1() {
        return this.Y;
    }

    public void x1() {
        x1 x1Var = this.W;
        if (x1Var != null) {
            x1Var.D(this.X);
        }
    }

    public void z1() {
        this.f30129a0 -= System.currentTimeMillis() - this.f30130b0;
        z.a().d("TranSplash", "removeCloseMsg remainForceCloseAdTime " + this.f30129a0);
        if (this.f30129a0 <= 0) {
            this.f30129a0 = 10000L;
        }
        Handler handler = this.Z;
        if (handler != null) {
            handler.removeCallbacks(this.f30137i0);
        }
    }
}
