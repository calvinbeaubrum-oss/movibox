package com.vungle.warren.ui.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.AdConfig;
import com.vungle.warren.AdRequest;
import com.vungle.warren.SessionTracker;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.p;
import com.vungle.warren.r;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.utility.ActivityManager;
import com.vungle.warren.utility.j;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class VungleBannerView extends WebView implements b10.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f62495k = "com.vungle.warren.ui.view.VungleBannerView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b10.g f62496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f62497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b10.b.a f62498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AdRequest f62499d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AdConfig f62500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f62501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicReference<Boolean> f62502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f62503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.vungle.warren.ui.view.e f62504j;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.vungle.warren.ui.view.e {
        public a() {
        }

        @Override // com.vungle.warren.ui.view.e
        public boolean a(MotionEvent motionEvent) {
            if (VungleBannerView.this.f62496a == null) {
                return false;
            }
            VungleBannerView.this.f62496a.e(motionEvent);
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return VungleBannerView.this.f62504j != null ? VungleBannerView.this.f62504j.a(motionEvent) : VungleBannerView.super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements a10.a {
        public c() {
        }

        @Override // a10.a
        public void close() {
            VungleBannerView.this.finishDisplayingAdInternal(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements r.c {
        public d() {
        }

        @Override // com.vungle.warren.r.c
        public void a(@NonNull Pair<b10.g, VungleWebClient> pair, @Nullable VungleException vungleException) {
            VungleBannerView vungleBannerView = VungleBannerView.this;
            vungleBannerView.f62501g = null;
            if (vungleException != null) {
                if (vungleBannerView.f62498c != null) {
                    VungleBannerView.this.f62498c.b(vungleException, VungleBannerView.this.f62499d.getPlacementId());
                    return;
                }
                return;
            }
            vungleBannerView.f62496a = (b10.g) pair.first;
            VungleBannerView.this.setWebViewClient((VungleWebClient) pair.second);
            VungleBannerView.this.f62496a.o(VungleBannerView.this.f62498c);
            VungleBannerView.this.f62496a.j(VungleBannerView.this, null);
            VungleBannerView.this.p();
            if (VungleBannerView.this.f62502h.get() != null) {
                VungleBannerView vungleBannerView2 = VungleBannerView.this;
                vungleBannerView2.setAdVisibility(((Boolean) vungleBannerView2.f62502h.get()).booleanValue());
            }
            ViewGroup.LayoutParams layoutParams = VungleBannerView.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
                layoutParams.width = -1;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("command");
            if ("stopAll".equalsIgnoreCase(stringExtra)) {
                VungleBannerView.this.finishDisplayingAdInternal(false);
                return;
            }
            VungleLogger.j(VungleBannerView.class.getSimpleName() + "#onAttachedToWindow", String.format("Receiving Invalid Broadcast: %1$s", stringExtra));
        }
    }

    public VungleBannerView(@NonNull Context context, @NonNull AdRequest adRequest, @Nullable AdConfig adConfig, @NonNull r rVar, @NonNull b10.b.a aVar) {
        super(context);
        this.f62502h = new AtomicReference<>();
        this.f62504j = new a();
        this.f62498c = aVar;
        this.f62499d = adRequest;
        this.f62500f = adConfig;
        this.f62501g = rVar;
        setLayerType(2, null);
        setBackgroundColor(0);
        o();
    }

    private void o() {
        setOnTouchListener(new b());
    }

    @Override // b10.a
    public void close() {
        if (this.f62496a != null) {
            finishDisplayingAdInternal(false);
            return;
        }
        r rVar = this.f62501g;
        if (rVar != null) {
            rVar.destroy();
            this.f62501g = null;
            this.f62498c.b(new VungleException(25), this.f62499d.getPlacementId());
        }
    }

    @Override // b10.a
    public void destroyAdView(long j11) {
        if (this.f62503i) {
            return;
        }
        this.f62503i = true;
        this.f62496a = null;
        this.f62501g = null;
        removeJavascriptInterface("Android");
        setWebChromeClient(null);
        Runnable runnable = new Runnable() { // from class: com.vungle.warren.ui.view.VungleBannerView.3
            @Override // java.lang.Runnable
            public void run() {
                VungleBannerView.this.stopLoading();
                VungleBannerView.this.setWebViewClient(null);
                if (Build.VERSION.SDK_INT >= 29) {
                    VungleBannerView.this.setWebViewRenderProcessClient(null);
                }
                VungleBannerView.this.loadUrl("about:blank");
            }
        };
        if (j11 <= 0) {
            runnable.run();
        } else {
            new j().a(runnable, j11);
        }
    }

    public void finishDisplayingAd() {
        finishDisplayingAdInternal(true);
    }

    public void finishDisplayingAdInternal(boolean z11) {
        b10.g gVar = this.f62496a;
        if (gVar != null) {
            gVar.s((z11 ? 4 : 0) | 2);
        } else {
            r rVar = this.f62501g;
            if (rVar != null) {
                rVar.destroy();
                this.f62501g = null;
                this.f62498c.b(new VungleException(25), this.f62499d.getPlacementId());
            }
        }
        if (z11) {
            p.b bVarD = new p.b().d(SessionEvent.DISMISS_AD);
            AdRequest adRequest = this.f62499d;
            if (adRequest != null && adRequest.getEventId() != null) {
                bVarD.a(SessionAttribute.EVENT_ID, this.f62499d.getEventId());
            }
            SessionTracker.l().w(bVarD.c());
        }
        destroyAdView(0L);
    }

    @Override // b10.a
    public String getWebsiteUrl() {
        return getUrl();
    }

    @Override // b10.a
    public boolean hasWebView() {
        return true;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        r rVar = this.f62501g;
        if (rVar != null && this.f62496a == null) {
            rVar.b(getContext(), this.f62499d, this.f62500f, new c(), new d());
        }
        this.f62497b = new e();
        u3.a.b(getContext()).c(this.f62497b, new IntentFilter("AdvertisementBus"));
        resumeWeb();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        u3.a.b(getContext()).e(this.f62497b);
        super.onDetachedFromWindow();
        r rVar = this.f62501g;
        if (rVar != null) {
            rVar.destroy();
        }
        pauseWeb();
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
        setAdVisibility(false);
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
        setAdVisibility(true);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        setAdVisibility(z11);
    }

    @Override // b10.a
    public void open(String str, @NonNull String str2, ActivityManager.d dVar, PresenterAdOpenCallback presenterAdOpenCallback) {
        String str3 = f62495k;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Opening ");
        sb2.append(str2);
        if (com.vungle.warren.utility.g.b(str, str2, getContext(), dVar, true, presenterAdOpenCallback)) {
            return;
        }
        Log.e(str3, "Cannot open url " + str2);
    }

    @SuppressLint({"AddJavascriptInterface", "NewApi"})
    public final void p() {
        g.a(this);
        addJavascriptInterface(new a10.d(this.f62496a), "Android");
        getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    @Override // b10.a
    public void pauseWeb() {
        onPause();
    }

    @Override // b10.a
    public void refreshDialogIfVisible() {
    }

    @Override // b10.a
    public void removeWebView() {
        ViewParent parent = getParent();
        if (parent instanceof ViewManager) {
            ((ViewManager) parent).removeView(this);
        }
    }

    public View renderBannerView() {
        return this;
    }

    @Override // b10.a
    public void resumeWeb() {
        onResume();
    }

    public void setAdVisibility(boolean z11) {
        b10.g gVar = this.f62496a;
        if (gVar != null) {
            gVar.a(z11);
        } else {
            this.f62502h.set(Boolean.valueOf(z11));
        }
    }

    @Override // b10.a
    public void setImmersiveMode() {
    }

    @Override // b10.a
    public void setOrientation(int i11) {
    }

    @Override // b10.a
    public void setPresenter(@NonNull b10.g gVar) {
    }

    @Override // b10.h
    public void setVisibility(boolean z11) {
        setVisibility(z11 ? 0 : 4);
    }

    @Override // b10.a
    public void showCloseButton() {
        throw new UnsupportedOperationException("VungleBannerView does not implement a close button");
    }

    @Override // b10.a
    public void showDialog(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable DialogInterface.OnClickListener onClickListener) {
        throw new UnsupportedOperationException("VungleBannerView does not implement a dialog.");
    }

    @Override // b10.a
    public void showWebsite(@NonNull String str) {
        loadUrl(str);
    }

    @Override // b10.h
    public void updateWindow() {
    }
}
