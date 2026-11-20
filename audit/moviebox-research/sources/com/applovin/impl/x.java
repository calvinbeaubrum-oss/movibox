package com.applovin.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends se implements AdControlButton.a, MaxRewardedAdListener, MaxAdViewAdListener, MaxAdRevenueListener, o0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f24172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private z f24173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ir f24174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private y f24175d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxAdView f24176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxInterstitialAd f24177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MaxAppOpenAd f24178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MaxRewardedInterstitialAd f24179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaxRewardedAd f24180j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxNativeAdView f24181k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaxNativeAdLoader f24182l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MaxAd f24183m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d0 f24184n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f24185o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ListView f24186p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f24187q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AdControlButton f24188r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f24189s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private o0 f24190t;

    /* JADX INFO: compiled from: source.java */
    public class a extends MaxNativeAdListener {
        public a() {
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdClicked(MaxAd maxAd) {
            x.this.onAdClicked(maxAd);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoadFailed(String str, MaxError maxError) {
            x.this.onAdLoadFailed(str, maxError);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
            if (x.this.f24183m != null) {
                x.this.f24182l.destroy(x.this.f24183m);
            }
            x.this.f24183m = maxAd;
            if (maxNativeAdView != null) {
                x.this.f24181k = maxNativeAdView;
            } else {
                x xVar = x.this;
                com.applovin.impl.sdk.j unused = x.this.f24172a;
                xVar.f24181k = new MaxNativeAdView(MaxNativeAdView.MEDIUM_TEMPLATE_1, com.applovin.impl.sdk.j.l());
                x.this.f24182l.render(x.this.f24181k, maxAd);
            }
            x.this.onAdLoaded(maxAd);
        }
    }

    private String a() {
        if (this.f24172a.l0().c()) {
            return "Not supported while Test Mode is enabled";
        }
        return this.f24175d.j() != this.f24173b.f() ? "This waterfall is not targeted for the current device" : "Tap to load an ad";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.f24184n = null;
    }

    private void a(ViewGroup viewGroup, AppLovinSdkUtils.Size size) {
        if (this.f24184n != null) {
            return;
        }
        d0 d0Var = new d0(viewGroup, size, this);
        this.f24184n = d0Var;
        d0Var.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.r80
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f22071a.a(dialogInterface);
            }
        });
        this.f24184n.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(dc dcVar, z zVar, a0 a0Var, com.applovin.impl.sdk.j jVar, MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
        maxDebuggerAdUnitDetailActivity.initialize(zVar, a0Var, ((y.b) dcVar).v(), jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.applovin.impl.sdk.j jVar, final z zVar, final a0 a0Var, lb lbVar, final dc dcVar) {
        if (dcVar instanceof y.b) {
            r.a(this, MaxDebuggerAdUnitDetailActivity.class, jVar.e(), new r.b() { // from class: com.applovin.impl.s80
                @Override // com.applovin.impl.r.b
                public final void a(Activity activity) {
                    x.a(dcVar, zVar, a0Var, jVar, (MaxDebuggerAdUnitDetailActivity) activity);
                }
            });
        }
    }

    private void a(MaxAdFormat maxAdFormat) {
        if (this.f24174c != null) {
            this.f24172a.l0().a(this.f24174c.b().b());
        }
        if (maxAdFormat.isAdViewAd()) {
            this.f24176f.setPlacement("[Mediation Debugger Live Ad]");
            this.f24176f.loadAd();
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f24173b.a()) {
            this.f24177g.loadAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f24173b.a()) {
            this.f24178h.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f24173b.a()) {
            this.f24179i.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED == this.f24173b.a()) {
            this.f24180j.loadAd();
        } else if (MaxAdFormat.NATIVE != this.f24173b.a()) {
            yp.a("Live ads currently unavailable for ad format", this);
        } else {
            this.f24182l.setPlacement("[Mediation Debugger Live Ad]");
            this.f24182l.loadAd();
        }
    }

    private void b() {
        String strC = this.f24173b.c();
        if (this.f24173b.a().isAdViewAd()) {
            MaxAdView maxAdView = new MaxAdView(strC, this.f24173b.a(), this.f24172a.s0(), this);
            this.f24176f = maxAdView;
            maxAdView.setExtraParameter("adaptive_banner", "false");
            this.f24176f.setExtraParameter("disable_auto_retries", "true");
            this.f24176f.setExtraParameter("disable_precache", "true");
            this.f24176f.setExtraParameter("allow_pause_auto_refresh_immediately", "true");
            this.f24176f.stopAutoRefresh();
            this.f24176f.setListener(this);
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f24173b.a()) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(strC, this.f24172a.s0(), this);
            this.f24177g = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter("disable_auto_retries", "true");
            this.f24177g.setListener(this);
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f24173b.a()) {
            MaxAppOpenAd maxAppOpenAd = new MaxAppOpenAd(strC, this.f24172a.s0());
            this.f24178h = maxAppOpenAd;
            maxAppOpenAd.setExtraParameter("disable_auto_retries", "true");
            this.f24178h.setListener(this);
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f24173b.a()) {
            MaxRewardedInterstitialAd maxRewardedInterstitialAd = new MaxRewardedInterstitialAd(strC, this.f24172a.s0(), this);
            this.f24179i = maxRewardedInterstitialAd;
            maxRewardedInterstitialAd.setExtraParameter("disable_auto_retries", "true");
            this.f24179i.setListener(this);
            return;
        }
        if (MaxAdFormat.REWARDED == this.f24173b.a()) {
            MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(strC, this.f24172a.s0(), this);
            this.f24180j = maxRewardedAd;
            maxRewardedAd.setExtraParameter("disable_auto_retries", "true");
            this.f24180j.setListener(this);
            return;
        }
        if (MaxAdFormat.NATIVE == this.f24173b.a()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(strC, this.f24172a.s0(), this);
            this.f24182l = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter("disable_auto_retries", "true");
            this.f24182l.setNativeAdListener(new a());
            this.f24182l.setRevenueListener(this);
        }
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            a(this.f24176f, maxAdFormat.getSize());
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == this.f24173b.a()) {
            this.f24177g.showAd("[Mediation Debugger Live Ad]");
            return;
        }
        if (MaxAdFormat.APP_OPEN == this.f24173b.a()) {
            this.f24178h.showAd("[Mediation Debugger Live Ad]");
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == this.f24173b.a()) {
            this.f24179i.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.REWARDED == this.f24173b.a()) {
            this.f24180j.showAd("[Mediation Debugger Live Ad]");
        } else if (MaxAdFormat.NATIVE == this.f24173b.a()) {
            a(this.f24181k, MaxAdFormat.MREC.getSize());
        }
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f24172a;
    }

    public void initialize(final z zVar, @Nullable final a0 a0Var, @Nullable ir irVar, final com.applovin.impl.sdk.j jVar) {
        List listA;
        this.f24172a = jVar;
        this.f24173b = zVar;
        this.f24174c = irVar;
        this.f24185o = jVar.l0().b();
        y yVar = new y(zVar, a0Var, irVar, this);
        this.f24175d = yVar;
        yVar.a(new ec.a() { // from class: com.applovin.impl.t80
            @Override // com.applovin.impl.ec.a
            public final void a(lb lbVar, dc dcVar) {
                this.f23210a.a(jVar, zVar, a0Var, lbVar, dcVar);
            }
        });
        b();
        if (zVar.f().f()) {
            if ((irVar != null && !irVar.b().d().A()) || (listA = jVar.N().a(zVar.c())) == null || listA.isEmpty()) {
                return;
            }
            this.f24190t = new o0(listA, zVar.a(), this);
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(@NonNull MaxAd maxAd) {
        yp.a("onAdClicked", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdCollapsed(@NonNull MaxAd maxAd) {
        yp.a("onAdCollapsed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        this.f24188r.setControlState(AdControlButton.b.LOAD);
        this.f24189s.setText("");
        yp.a("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(@NonNull MaxAd maxAd) {
        yp.a("onAdDisplayed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdExpanded(@NonNull MaxAd maxAd) {
        yp.a("onAdExpanded", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(@NonNull MaxAd maxAd) {
        yp.a("onAdHidden", maxAd, this);
    }

    @Override // com.applovin.impl.o0.a
    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.f24176f.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f24177g.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f24178h.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f24179i.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f24180j.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f24182l.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(@NonNull String str, @NonNull MaxError maxError) {
        this.f24188r.setControlState(AdControlButton.b.LOAD);
        this.f24189s.setText("");
        if (204 == maxError.getCode()) {
            yp.a("No Fill", "No fills often happen in live environments. Please make sure to use the Mediation Debugger test mode before you go live.", this);
            return;
        }
        yp.a("", "Failed to load with error code: " + maxError.getCode(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(@NonNull MaxAd maxAd) {
        this.f24189s.setText(maxAd.getNetworkName() + " ad loaded");
        this.f24188r.setControlState(AdControlButton.b.SHOW);
        if (maxAd.getFormat().isAdViewAd()) {
            a(this.f24176f, maxAd.getFormat().getSize());
        } else if (MaxAdFormat.NATIVE == this.f24173b.a()) {
            a(this.f24181k, MaxAdFormat.MREC.getSize());
        }
    }

    @Override // com.applovin.impl.o0.a
    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd()) {
            this.f24176f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f24177g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f24178h.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f24179i.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f24180j.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f24182l.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(@NonNull MaxAd maxAd) {
        yp.a("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton.a
    public void onClick(AdControlButton adControlButton) {
        if (this.f24172a.l0().c()) {
            yp.a("Not Supported", "Ad loads are not supported while Test Mode is enabled. Please restart the app.", this);
            return;
        }
        if (this.f24175d.j() != this.f24173b.f()) {
            yp.a("Not Supported", "You cannot load an ad from this waterfall because it does not target the current device. To load an ad, please select the targeted waterfall.", this);
            return;
        }
        MaxAdFormat maxAdFormatA = this.f24173b.a();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            o0 o0Var = this.f24190t;
            if (o0Var != null) {
                o0Var.a();
                return;
            } else {
                a(maxAdFormatA);
                return;
            }
        }
        if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            if (!maxAdFormatA.isAdViewAd() && maxAdFormatA != MaxAdFormat.NATIVE) {
                adControlButton.setControlState(bVar);
            }
            b(maxAdFormatA);
        }
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_ad_unit_detail_activity);
        setTitle(this.f24175d.k());
        this.f24186p = (ListView) findViewById(R.id.listView);
        this.f24187q = findViewById(R.id.ad_presenter_view);
        this.f24188r = (AdControlButton) findViewById(R.id.ad_control_button);
        this.f24189s = (TextView) findViewById(R.id.status_textview);
        this.f24186p.setAdapter((ListAdapter) this.f24175d);
        this.f24189s.setText(a());
        this.f24189s.setTypeface(Typeface.DEFAULT_BOLD);
        this.f24188r.setOnClickListener(this);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setPadding(0, 10, 0, 0);
        shapeDrawable.getPaint().setColor(-1);
        shapeDrawable.getPaint().setShadowLayer(10, 0.0f, -10, 855638016);
        shapeDrawable.setShape(new RectShape());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable});
        layerDrawable.setLayerInset(0, 0, 10, 0, 0);
        this.f24187q.setBackground(layerDrawable);
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        if (this.f24174c != null) {
            this.f24172a.l0().a(this.f24185o);
        }
        MaxAdView maxAdView = this.f24176f;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f24177g;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxAppOpenAd maxAppOpenAd = this.f24178h;
        if (maxAppOpenAd != null) {
            maxAppOpenAd.destroy();
        }
        MaxRewardedInterstitialAd maxRewardedInterstitialAd = this.f24179i;
        if (maxRewardedInterstitialAd != null) {
            maxRewardedInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f24180j;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f24182l;
        if (maxNativeAdLoader == null || (maxAd = this.f24183m) == null) {
            return;
        }
        maxNativeAdLoader.destroy(maxAd);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoCompleted(@NonNull MaxAd maxAd) {
        yp.a("onRewardedVideoCompleted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoStarted(@NonNull MaxAd maxAd) {
        yp.a("onRewardedVideoStarted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(@NonNull MaxAd maxAd, @NonNull MaxReward maxReward) {
        yp.a("onUserRewarded", maxAd, this);
    }
}
