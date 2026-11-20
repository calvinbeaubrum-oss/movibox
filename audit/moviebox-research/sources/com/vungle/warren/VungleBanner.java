package com.vungle.warren;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.ui.view.VungleBannerView;
import com.vungle.warren.utility.ViewUtility;
import com.vungle.warren.utility.WeakRunnable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class VungleBanner extends RelativeLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f61851o = "VungleBanner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f61852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f61853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f61855d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f61856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f61857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public VungleBannerView f61858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f61859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f61860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.vungle.warren.utility.o f61861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f61862l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f61863m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m f61864n;

    /* JADX INFO: compiled from: source.java */
    public class a implements m {
        public a() {
        }

        @Override // com.vungle.warren.m
        public void onAdLoad(String str) {
            String unused = VungleBanner.f61851o;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ad Loaded : ");
            sb2.append(str);
            if (VungleBanner.this.f61856f && VungleBanner.this.k()) {
                VungleBanner.this.f61856f = false;
                VungleBanner.this.l(false);
                VungleBannerView bannerViewInternal = Vungle.getBannerViewInternal(VungleBanner.this.f61852a, null, new AdConfig(VungleBanner.this.f61859i), VungleBanner.this.f61860j);
                if (bannerViewInternal != null) {
                    VungleBanner.this.f61858h = bannerViewInternal;
                    VungleBanner.this.renderAd();
                    return;
                }
                onError(VungleBanner.this.f61852a, new VungleException(10));
                VungleLogger.c(VungleBanner.class.getSimpleName() + "#loadAdCallback; onAdLoad", "VungleBannerView is null");
            }
        }

        @Override // com.vungle.warren.m
        public void onError(String str, VungleException vungleException) {
            String unused = VungleBanner.f61851o;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ad Load Error : ");
            sb2.append(str);
            sb2.append(" Message : ");
            sb2.append(vungleException.getLocalizedMessage());
            if (VungleBanner.this.getVisibility() == 0 && VungleBanner.this.k()) {
                VungleBanner.this.f61861k.c();
            }
        }
    }

    public VungleBanner(@NonNull Context context, String str, @Nullable String str2, int i11, c cVar, q qVar) {
        super(context);
        this.f61863m = new Runnable() { // from class: com.vungle.warren.VungleBanner.1
            @Override // java.lang.Runnable
            public void run() {
                String unused = VungleBanner.f61851o;
                VungleBanner.this.f61856f = true;
                VungleBanner.this.m();
            }
        };
        this.f61864n = new a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = f61851o;
        VungleLogger.i(true, str3, "ttDownloadContext", String.format("Creating banner ad, id = %1$s, at: %2$d", str, Long.valueOf(jCurrentTimeMillis)));
        this.f61852a = str;
        this.f61859i = cVar;
        AdConfig.AdSize adSizeA = cVar.a();
        this.f61860j = qVar;
        this.f61854c = ViewUtility.a(context, adSizeA.getHeight());
        this.f61853b = ViewUtility.a(context, adSizeA.getWidth());
        SessionTracker.l().v(cVar);
        this.f61858h = Vungle.getBannerViewInternal(str, com.vungle.warren.utility.a.a(str2), new AdConfig(cVar), this.f61860j);
        this.f61861k = new com.vungle.warren.utility.o(new WeakRunnable(this.f61863m), ((long) i11) * 1000);
        VungleLogger.i(true, str3, "ttDownloadContext", String.format("Banner ad created, id = %1$s, elapsed time: %2$dms", str, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
    }

    public void destroyAd() {
        l(true);
        this.f61855d = true;
        this.f61860j = null;
    }

    public void disableLifeCycleManagement(boolean z11) {
        this.f61857g = z11;
    }

    public void finishAd() {
        l(true);
    }

    public final boolean k() {
        return !this.f61855d && (!this.f61857g || this.f61862l);
    }

    public final void l(boolean z11) {
        synchronized (this) {
            this.f61861k.a();
            VungleBannerView vungleBannerView = this.f61858h;
            if (vungleBannerView != null) {
                vungleBannerView.finishDisplayingAdInternal(z11);
                this.f61858h = null;
                try {
                    removeAllViews();
                } catch (Exception e11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Removing webview error: ");
                    sb2.append(e11.getLocalizedMessage());
                }
            }
        }
    }

    public void m() {
        d.g(this.f61852a, this.f61859i, new com.vungle.warren.utility.y(this.f61864n));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f61857g) {
            return;
        }
        renderAd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f61857g) {
            return;
        }
        l(true);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        setAdVisibility(i11 == 0);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        setAdVisibility(z11);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Banner onWindowVisibilityChanged: ");
        sb2.append(i11);
        setAdVisibility(i11 == 0);
    }

    public void renderAd() {
        this.f61862l = true;
        if (getVisibility() != 0) {
            return;
        }
        VungleBannerView vungleBannerView = this.f61858h;
        if (vungleBannerView == null) {
            if (k()) {
                this.f61856f = true;
                m();
                return;
            }
            return;
        }
        View viewRenderBannerView = vungleBannerView.renderBannerView();
        if (viewRenderBannerView.getParent() != this) {
            addView(viewRenderBannerView, this.f61853b, this.f61854c);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Rendering new ad for: ");
        sb2.append(this.f61852a);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f61854c;
            layoutParams.width = this.f61853b;
            requestLayout();
        }
        this.f61861k.c();
    }

    public void setAdVisibility(boolean z11) {
        if (z11 && k()) {
            this.f61861k.c();
        } else {
            this.f61861k.b();
        }
        VungleBannerView vungleBannerView = this.f61858h;
        if (vungleBannerView != null) {
            vungleBannerView.setAdVisibility(z11);
        }
    }
}
