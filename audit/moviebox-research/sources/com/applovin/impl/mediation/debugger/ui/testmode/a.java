package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.ke;
import com.applovin.impl.o0;
import com.applovin.impl.p0;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.se;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends se implements MaxRewardedAdListener, MaxAdViewAdListener, AdControlButton.a, MaxAdRevenueListener, o0.a {
    private Map A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ke f20929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f20930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MaxAdView f20931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MaxAdView f20932d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxInterstitialAd f20933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxAppOpenAd f20934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MaxRewardedInterstitialAd f20935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MaxRewardedAd f20936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaxAd f20937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxNativeAdLoader f20938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f20939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f20940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AdControlButton f20941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AdControlButton f20942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AdControlButton f20943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AdControlButton f20944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AdControlButton f20945r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private AdControlButton f20946s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private AdControlButton f20947t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Button f20948u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Button f20949v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private FrameLayout f20950w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FrameLayout f20951x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Switch f20952y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Switch f20953z;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.debugger.ui.testmode.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0190a extends MaxNativeAdListener {
        public C0190a() {
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdClicked(MaxAd maxAd) {
            a.this.onAdClicked(maxAd);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoadFailed(String str, MaxError maxError) {
            a.this.onAdLoadFailed(str, maxError);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
        public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
            if (a.this.f20937j != null) {
                a.this.f20938k.destroy(a.this.f20937j);
            }
            a.this.f20937j = maxAd;
            a.this.f20951x.removeAllViews();
            a.this.f20951x.addView(maxNativeAdView);
            a.this.onAdLoaded(maxAd);
        }
    }

    private AdControlButton a(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.f20941n;
        }
        if (str.equals("test_mode_mrec")) {
            return this.f20942o;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.f20943p;
        }
        if (str.equals("test_mode_app_open")) {
            return this.f20944q;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.f20945r;
        }
        if (str.equals(this.f20940m)) {
            return this.f20946s;
        }
        if (str.equals("test_mode_native")) {
            return this.f20947t;
        }
        throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
    }

    private void a() {
        MaxAdFormat maxAdFormat;
        String str;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_ad_view_container);
        if (zIsTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(R.id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (!this.f20929a.r().contains(maxAdFormat)) {
            findViewById(R.id.banner_control_view).setVisibility(8);
            frameLayout.setVisibility(8);
            return;
        }
        MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.f20930b.s0(), this);
        this.f20931c = maxAdView;
        maxAdView.setExtraParameter("adaptive_banner", "false");
        this.f20931c.setExtraParameter("disable_auto_retries", "true");
        this.f20931c.setExtraParameter("disable_precache", "true");
        this.f20931c.setExtraParameter("allow_pause_auto_refresh_immediately", "true");
        this.f20931c.stopAutoRefresh();
        this.f20931c.setListener(this);
        frameLayout.addView(this.f20931c, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
        AdControlButton adControlButton = (AdControlButton) findViewById(R.id.banner_control_button);
        this.f20941n = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f20941n.setFormat(maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f20950w.setVisibility(0);
        this.f20951x.setVisibility(8);
        this.f20948u.setBackgroundColor(-1);
        this.f20949v.setBackgroundColor(-3355444);
    }

    private void a(MaxAdFormat maxAdFormat) {
        MaxAdFormat maxAdFormat2 = MaxAdFormat.BANNER;
        boolean z11 = false;
        boolean z12 = (maxAdFormat2 == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) && this.f20952y.isChecked();
        MaxAdFormat maxAdFormat3 = MaxAdFormat.MREC;
        if (maxAdFormat3 == maxAdFormat && this.f20953z.isChecked()) {
            z11 = true;
        }
        if (z12 || z11) {
            this.f20930b.l0().a(this.f20929a.v());
        } else {
            this.f20930b.l0().a(getTestModeNetwork(maxAdFormat));
        }
        if (maxAdFormat2 == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.f20931c.loadAd();
            return;
        }
        if (maxAdFormat3 == maxAdFormat) {
            this.f20932d.loadAd();
            this.f20948u.callOnClick();
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f20933f.loadAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f20934g.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f20935h.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f20936i.loadAd();
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f20938k.loadAd();
            this.f20949v.callOnClick();
        }
    }

    private void b() {
        List listR = this.f20929a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.INTERSTITIAL;
        if (!listR.contains(maxAdFormat)) {
            findViewById(R.id.interstitial_control_view).setVisibility(8);
            return;
        }
        MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.f20930b.s0(), this);
        this.f20933f = maxInterstitialAd;
        maxInterstitialAd.setExtraParameter("disable_auto_retries", "true");
        this.f20933f.setListener(this);
        AdControlButton adControlButton = (AdControlButton) findViewById(R.id.interstitial_control_button);
        this.f20943p = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f20943p.setFormat(maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f20951x.setVisibility(0);
        this.f20950w.setVisibility(8);
        this.f20949v.setBackgroundColor(-1);
        this.f20948u.setBackgroundColor(-3355444);
    }

    private void b(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f20933f.showAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f20934g.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f20935h.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f20936i.showAd();
        }
    }

    private void c() {
        this.f20950w = (FrameLayout) findViewById(R.id.mrec_ad_view_container);
        List listR = this.f20929a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.MREC;
        if (!listR.contains(maxAdFormat)) {
            findViewById(R.id.mrec_control_view).setVisibility(8);
            this.f20950w.setVisibility(8);
            return;
        }
        MaxAdView maxAdView = new MaxAdView("test_mode_mrec", maxAdFormat, this.f20930b.s0(), this);
        this.f20932d = maxAdView;
        maxAdView.setExtraParameter("disable_auto_retries", "true");
        this.f20932d.setExtraParameter("disable_precache", "true");
        this.f20932d.setExtraParameter("allow_pause_auto_refresh_immediately", "true");
        this.f20932d.stopAutoRefresh();
        this.f20932d.setListener(this);
        this.f20950w.addView(this.f20932d, new FrameLayout.LayoutParams(-1, -1));
        AdControlButton adControlButton = (AdControlButton) findViewById(R.id.mrec_control_button);
        this.f20942o = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f20942o.setFormat(maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.f20931c.removeAllViews();
        this.f20941n.setControlState(AdControlButton.b.LOAD);
    }

    private void d() {
        this.f20951x = (FrameLayout) findViewById(R.id.native_ad_view_container);
        if (!this.f20929a.G()) {
            findViewById(R.id.native_control_view).setVisibility(8);
            this.f20951x.setVisibility(8);
            return;
        }
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.f20930b.s0(), this);
        this.f20938k = maxNativeAdLoader;
        maxNativeAdLoader.setExtraParameter("disable_auto_retries", "true");
        this.f20938k.setNativeAdListener(new C0190a());
        this.f20938k.setRevenueListener(this);
        AdControlButton adControlButton = (AdControlButton) findViewById(R.id.native_control_button);
        this.f20947t = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f20947t.setFormat(MaxAdFormat.NATIVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        this.f20932d.removeAllViews();
        this.f20942o.setControlState(AdControlButton.b.LOAD);
    }

    private void e() {
        List listR = this.f20929a.r();
        MaxAdFormat maxAdFormat = MaxAdFormat.REWARDED;
        if (!listR.contains(maxAdFormat)) {
            findViewById(R.id.rewarded_control_view).setVisibility(8);
            return;
        }
        String str = "test_mode_rewarded_" + this.f20929a.m();
        this.f20940m = str;
        MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(str, this.f20930b.s0(), this);
        this.f20936i = maxRewardedAd;
        maxRewardedAd.setExtraParameter("disable_auto_retries", "true");
        this.f20936i.setListener(this);
        AdControlButton adControlButton = (AdControlButton) findViewById(R.id.rewarded_control_button);
        this.f20946s = adControlButton;
        adControlButton.setOnClickListener(this);
        this.f20946s.setFormat(maxAdFormat);
    }

    @Override // com.applovin.impl.se
    public j getSdk() {
        return this.f20930b;
    }

    public String getTestModeNetwork(MaxAdFormat maxAdFormat) {
        return (this.f20929a.w() == null || !this.f20929a.w().containsKey(maxAdFormat)) ? this.f20929a.m() : (String) this.f20929a.w().get(maxAdFormat);
    }

    public void initialize(ke keVar) {
        this.f20929a = keVar;
        this.f20930b = keVar.o();
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
    public void onAdDisplayFailed(@NonNull MaxAd maxAd, @NonNull MaxError maxError) {
        a(maxAd.getAdUnitId()).setControlState(AdControlButton.b.LOAD);
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
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.f20931c.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.f20932d.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f20933f.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f20934g.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f20935h.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f20936i.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f20938k.setLocalExtraParameter("amazon_ad_error", adError);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(@NonNull String str, @NonNull MaxError maxError) {
        AdControlButton adControlButtonA = a(str);
        adControlButtonA.setControlState(AdControlButton.b.LOAD);
        yp.a(maxError, adControlButtonA.getFormat().getLabel(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(@NonNull MaxAd maxAd) {
        AdControlButton adControlButtonA = a(maxAd.getAdUnitId());
        if (maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) {
            adControlButtonA.setControlState(AdControlButton.b.LOAD);
        } else {
            adControlButtonA.setControlState(AdControlButton.b.SHOW);
        }
    }

    @Override // com.applovin.impl.o0.a
    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.f20931c.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.f20932d.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.f20933f.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.f20934g.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.f20935h.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.f20936i.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.f20938k.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        a(maxAdFormat);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(@NonNull MaxAd maxAd) {
        yp.a("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton.a
    public void onClick(AdControlButton adControlButton) {
        MaxAdFormat format = adControlButton.getFormat();
        AdControlButton.b bVar = AdControlButton.b.LOAD;
        if (bVar != adControlButton.getControlState()) {
            if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
                adControlButton.setControlState(bVar);
                b(format);
                return;
            }
            return;
        }
        adControlButton.setControlState(AdControlButton.b.LOADING);
        Map map = this.A;
        if (map == null || map.get(format) == null) {
            a(format);
        } else {
            ((o0) this.A.get(format)).a();
        }
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f20929a == null) {
            n.h("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.f20929a.g() + " Test Ads");
        this.f20939l = this.f20930b.l0().b();
        a();
        c();
        b();
        e();
        d();
        findViewById(R.id.rewarded_interstitial_control_view).setVisibility(8);
        findViewById(R.id.app_open_ad_control_view).setVisibility(8);
        this.f20948u = (Button) findViewById(R.id.show_mrec_button);
        this.f20949v = (Button) findViewById(R.id.show_native_button);
        if (this.f20929a.G() && this.f20929a.r().contains(MaxAdFormat.MREC)) {
            this.f20951x.setVisibility(8);
            this.f20948u.setBackgroundColor(-1);
            this.f20949v.setBackgroundColor(-3355444);
            this.f20948u.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20955a.a(view);
                }
            });
            this.f20949v.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20956a.b(view);
                }
            });
        } else {
            this.f20948u.setVisibility(8);
            this.f20949v.setVisibility(8);
        }
        this.f20952y = (Switch) findViewById(R.id.native_banner_switch);
        this.f20953z = (Switch) findViewById(R.id.native_mrec_switch);
        if (this.f20929a.H()) {
            this.f20952y.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20957a.c(view);
                }
            });
            this.f20953z.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20958a.d(view);
                }
            });
        } else {
            this.f20952y.setVisibility(8);
            this.f20953z.setVisibility(8);
        }
        if (StringUtils.isValidString(this.f20929a.e()) && this.f20929a.d() != null && this.f20929a.d().size() > 0) {
            AdRegistration.getInstance(this.f20929a.e(), this);
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
            HashMap map = new HashMap(this.f20929a.d().size());
            for (MaxAdFormat maxAdFormat : this.f20929a.d().keySet()) {
                map.put(maxAdFormat, new o0((p0) this.f20929a.d().get(maxAdFormat), maxAdFormat, this));
            }
            this.A = map;
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th2) {
            n.c("AppLovinSdk", "Failed to set portrait orientation", th2);
        }
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        this.f20930b.l0().a(this.f20939l);
        MaxAdView maxAdView = this.f20931c;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.f20932d;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.f20933f;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.f20936i;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.f20938k;
        if (maxNativeAdLoader == null || (maxAd = this.f20937j) == null) {
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
