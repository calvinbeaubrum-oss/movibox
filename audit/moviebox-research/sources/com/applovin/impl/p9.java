package com.applovin.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p9 implements kb.a, AppLovinBroadcastManager.Receiver, yp.b, com.applovin.impl.adview.a.b {
    protected boolean B;
    protected AppLovinAdClickListener C;
    protected AppLovinAdDisplayListener D;
    protected AppLovinAdVideoPlaybackListener E;
    protected final kb F;
    protected go G;
    protected go H;
    protected boolean I;
    private final j2 J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.ad.b f21675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f21676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f21677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Activity f21678d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p f21680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.f.a f21681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected AppLovinAdView f21682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected com.applovin.impl.adview.k f21683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final com.applovin.impl.adview.g f21684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final com.applovin.impl.adview.g f21685l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected long f21691r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f21692s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f21693t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f21694u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f21695v;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f21679f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final long f21686m = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f21687n = new AtomicBoolean();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f21688o = new AtomicBoolean();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f21689p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected long f21690q = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f21696w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ArrayList f21697x = new ArrayList();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected int f21698y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected int f21699z = 0;
    protected int A = com.applovin.impl.sdk.f.f22518i;
    private boolean K = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements AppLovinAdDisplayListener {
        public a() {
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = p9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                p9.this.f21677c.a("AppLovinFullscreenActivity", "Web content rendered");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = p9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                p9.this.f21677c.a("AppLovinFullscreenActivity", "Closing from WebView");
            }
            p9.this.f();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements com.applovin.impl.sdk.f.a {
        public b() {
        }

        @Override // com.applovin.impl.sdk.f.a
        public void a(int i11) {
            p9 p9Var = p9.this;
            if (p9Var.A != com.applovin.impl.sdk.f.f22518i) {
                p9Var.B = true;
            }
            com.applovin.impl.adview.b bVarG = p9Var.f21682i.getController().g();
            if (bVarG == null) {
                com.applovin.impl.sdk.n nVar = p9.this.f21677c;
                if (com.applovin.impl.sdk.n.a()) {
                    p9.this.f21677c.k("AppLovinFullscreenActivity", "Unable to handle ringer mode change: no valid web view.");
                }
            } else if (com.applovin.impl.sdk.f.a(i11) && !com.applovin.impl.sdk.f.a(p9.this.A)) {
                bVarG.a("javascript:al_muteSwitchOn();");
            } else if (i11 == 2) {
                bVarG.a("javascript:al_muteSwitchOff();");
            }
            p9.this.A = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends p {
        public c() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.getClass().getName().equals(yp.l(activity.getApplicationContext()))) {
                p9.this.h();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(p9 p9Var);

        void a(String str, Throwable th2);
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements AppLovinAdClickListener, View.OnClickListener {
        private e() {
        }

        public /* synthetic */ e(p9 p9Var, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            p9.this.f21690q = SystemClock.elapsedRealtime();
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = p9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                p9.this.f21677c.a("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            gc.a(p9.this.C, appLovinAd);
            p9.this.f21699z++;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p9 p9Var = p9.this;
            if (view != p9Var.f21684k || !((Boolean) p9Var.f21676b.a(sj.f23039q2)).booleanValue()) {
                com.applovin.impl.sdk.n nVar = p9.this.f21677c;
                if (com.applovin.impl.sdk.n.a()) {
                    p9.this.f21677c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                    return;
                }
                return;
            }
            p9.c(p9.this);
            if (p9.this.f21675a.S0()) {
                p9.this.c("javascript:al_onCloseButtonTapped(" + p9.this.f21696w + "," + p9.this.f21698y + "," + p9.this.f21699z + ");");
            }
            List listK = p9.this.f21675a.K();
            com.applovin.impl.sdk.n nVar2 = p9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                p9.this.f21677c.a("AppLovinFullscreenActivity", "Handling close button tap " + p9.this.f21696w + " with multi close delay: " + listK);
            }
            if (listK == null || listK.size() <= p9.this.f21696w) {
                p9.this.f();
                return;
            }
            p9.this.f21697x.add(Long.valueOf(SystemClock.elapsedRealtime() - p9.this.f21690q));
            List listI = p9.this.f21675a.I();
            if (listI != null && listI.size() > p9.this.f21696w) {
                p9 p9Var2 = p9.this;
                p9Var2.f21684k.a((com.applovin.impl.adview.e.a) listI.get(p9Var2.f21696w));
            }
            com.applovin.impl.sdk.n nVar3 = p9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                p9.this.f21677c.a("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + listK.get(p9.this.f21696w));
            }
            p9.this.f21684k.setVisibility(8);
            p9 p9Var3 = p9.this;
            p9Var3.a(p9Var3.f21684k, ((Integer) listK.get(p9Var3.f21696w)).intValue(), new Runnable() { // from class: com.applovin.impl.c10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18079a.a();
                }
            });
        }
    }

    public p9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f21675a = bVar;
        this.f21676b = jVar;
        this.f21677c = jVar.J();
        this.f21678d = activity;
        this.C = appLovinAdClickListener;
        this.D = appLovinAdDisplayListener;
        this.E = appLovinAdVideoPlaybackListener;
        kb kbVar = new kb(activity, jVar);
        this.F = kbVar;
        kbVar.a(this);
        this.J = new j2(jVar);
        e eVar = new e(this, null);
        if (((Boolean) jVar.a(sj.K2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
        }
        if (((Boolean) jVar.a(sj.Q2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.al_onPoststitialShow_evaluation_error"));
        }
        n9 n9Var = new n9(jVar.s0(), AppLovinAdSize.INTERSTITIAL, activity);
        this.f21682i = n9Var;
        n9Var.setAdClickListener(eVar);
        this.f21682i.setAdDisplayListener(new a());
        bVar.e().putString("ad_view_address", zq.a(this.f21682i));
        this.f21682i.getController().a(this);
        ea eaVar = new ea(map, jVar);
        if (eaVar.c()) {
            this.f21683j = new com.applovin.impl.adview.k(eaVar, activity);
        }
        jVar.i().trackImpression(bVar);
        List listK = bVar.K();
        if (bVar.p() >= 0 || listK != null) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.n(), activity);
            this.f21684k = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(eVar);
        } else {
            this.f21684k = null;
        }
        com.applovin.impl.adview.g gVar2 = new com.applovin.impl.adview.g(com.applovin.impl.adview.e.a.WHITE_ON_TRANSPARENT, activity);
        this.f21685l = gVar2;
        gVar2.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.a10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17416a.b(view);
            }
        });
        if (bVar.U0()) {
            this.f21681h = new b();
        } else {
            this.f21681h = null;
        }
        this.f21680g = new c();
    }

    private void C() {
        if (this.f21681h != null) {
            this.f21676b.n().a(this.f21681h);
        }
        if (this.f21680g != null) {
            this.f21676b.e().a(this.f21680g);
        }
    }

    private void D() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.z00
            @Override // java.lang.Runnable
            public final void run() {
                this.f24737a.o();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        com.applovin.impl.adview.g gVar;
        if (yp.a(sj.f22990k1, this.f21676b)) {
            this.f21676b.B().c(this.f21675a, com.applovin.impl.sdk.j.l());
        }
        this.f21676b.E().a(la.F, ma.a(this.f21675a));
        if (((Boolean) this.f21676b.a(sj.f22932c6)).booleanValue()) {
            f();
            return;
        }
        this.K = ((Boolean) this.f21676b.a(sj.f22940d6)).booleanValue();
        if (!((Boolean) this.f21676b.a(sj.f22947e6)).booleanValue() || (gVar = this.f21684k) == null) {
            return;
        }
        gVar.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.adview.g gVar, Runnable runnable) {
        gVar.bringToFront();
        runnable.run();
    }

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, Map map, com.applovin.impl.sdk.j jVar, Activity activity, d dVar) {
        p9 q9Var;
        boolean zE1 = bVar.e1();
        if (bVar instanceof aq) {
            if (zE1) {
                try {
                    q9Var = new s9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th2) {
                    jVar.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.J().d("AppLovinFullscreenActivity", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th2);
                    }
                    jVar.E().a("AppLovinFullscreenActivity", "createVastVideoAdExoPlayerPresenter", th2, ma.a(bVar));
                    try {
                        q9Var = new t9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                    } catch (Throwable th3) {
                        dVar.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + jVar + " and throwable: " + th3.getMessage(), th3);
                        return;
                    }
                }
            } else {
                try {
                    q9Var = new t9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th4) {
                    dVar.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + jVar + " and throwable: " + th4.getMessage(), th4);
                    return;
                }
            }
        } else if (!bVar.hasVideoUrl()) {
            try {
                q9Var = new q9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th5) {
                dVar.a("Failed to create FullscreenGraphicAdPresenter with sdk: " + jVar + " and throwable: " + th5.getMessage(), th5);
                return;
            }
        } else if (bVar.J0()) {
            try {
                q9Var = new x9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th6) {
                dVar.a("Failed to create FullscreenWebVideoAdPresenter with sdk: " + jVar + " and throwable: " + th6.getMessage(), th6);
                return;
            }
        } else if (zE1) {
            try {
                q9Var = new u9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th7) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().d("AppLovinFullscreenActivity", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th7);
                }
                jVar.E().a("AppLovinFullscreenActivity", "createVideoAdExoPlayerPresenter", th7, ma.a(bVar));
                try {
                    q9Var = new v9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th8) {
                    dVar.a("Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: " + jVar + " and throwable: " + th8.getMessage(), th8);
                    return;
                }
            }
        } else {
            try {
                q9Var = new v9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th9) {
                dVar.a("Failed to create FullscreenVideoAdPresenter with sdk: " + jVar + " and throwable: " + th9.getMessage(), th9);
                return;
            }
        }
        q9Var.C();
        dVar.a(q9Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        com.applovin.impl.adview.b bVarG;
        AppLovinAdView appLovinAdView = this.f21682i;
        if (appLovinAdView == null || (bVarG = appLovinAdView.getController().g()) == null) {
            return;
        }
        bVarG.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        zq.a(gVar, 400L, new Runnable() { // from class: com.applovin.impl.w00
            @Override // java.lang.Runnable
            public final void run() {
                p9.a(gVar, runnable);
            }
        });
    }

    public static /* synthetic */ int c(p9 p9Var) {
        int i11 = p9Var.f21696w;
        p9Var.f21696w = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.v00
            @Override // java.lang.Runnable
            public final void run() {
                p9.b(gVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f21675a.d() >= 0) {
            this.f21689p.set(true);
        } else {
            if (this.f21688o.get()) {
                return;
            }
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        if (this.f21675a.E0().getAndSet(true)) {
            return;
        }
        this.f21676b.j0().a((yl) new en(this.f21675a, this.f21676b), tm.b.OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        com.applovin.impl.sdk.n.h("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
        try {
            f();
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("AppLovinFullscreenActivity", "Failed to dismiss ad.", th2);
            try {
                p();
            } catch (Throwable unused) {
            }
        }
    }

    public abstract void A();

    public boolean B() {
        return this.f21689p.get();
    }

    public void a(int i11, KeyEvent keyEvent) {
        if (this.f21677c == null || !com.applovin.impl.sdk.n.a()) {
            return;
        }
        this.f21677c.d("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i11 + ", " + keyEvent);
    }

    public void a(int i11, boolean z11, boolean z12, long j11) {
        if (this.f21687n.compareAndSet(false, true)) {
            if (this.f21675a.hasVideoUrl() || l()) {
                gc.a(this.E, this.f21675a, i11, z12);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f21686m;
            this.f21676b.i().trackVideoEnd(this.f21675a, TimeUnit.MILLISECONDS.toSeconds(jElapsedRealtime), i11, z11);
            long jElapsedRealtime2 = this.f21690q != -1 ? SystemClock.elapsedRealtime() - this.f21690q : -1L;
            this.f21676b.i().trackFullScreenAdClosed(this.f21675a, jElapsedRealtime2, this.f21697x, j11, this.B, this.A);
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Video ad ended at percent: " + i11 + "%, elapsedTime: " + jElapsedRealtime + "ms, skipTimeMillis: " + j11 + "ms, closeTimeMillis: " + jElapsedRealtime2 + "ms");
            }
        }
    }

    public abstract void a(long j11);

    public void a(Configuration configuration) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    public abstract void a(ViewGroup viewGroup);

    @Override // com.applovin.impl.adview.a.b
    public void a(com.applovin.impl.adview.a aVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Fully watched from ad web view...");
        }
        this.I = true;
    }

    public void a(final com.applovin.impl.adview.g gVar, long j11, final Runnable runnable) {
        if (j11 >= ((Long) this.f21676b.a(sj.f23031p2)).longValue()) {
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.applovin.impl.u00
            @Override // java.lang.Runnable
            public final void run() {
                p9.c(gVar, runnable);
            }
        };
        if (((Boolean) this.f21676b.a(sj.R2)).booleanValue()) {
            this.H = go.a(TimeUnit.SECONDS.toMillis(j11), this.f21676b, runnable2);
        } else {
            this.f21676b.j0().a(new jn(this.f21676b, "fadeInCloseButton", runnable2), tm.b.OTHER, TimeUnit.SECONDS.toMillis(j11), true);
        }
    }

    public void a(Runnable runnable, long j11) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j11, this.f21679f);
    }

    public void a(final String str, long j11) {
        if (j11 < 0 || !StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.b10
            @Override // java.lang.Runnable
            public final void run() {
                this.f17813a.a(str);
            }
        }, j11);
    }

    public void a(boolean z11) {
        yp.a(z11, this.f21675a, this.f21676b, com.applovin.impl.sdk.j.l(), this);
    }

    public void a(boolean z11, long j11) {
        if (this.f21675a.L0()) {
            a(z11 ? "javascript:al_mute();" : "javascript:al_unmute();", j11);
        }
    }

    public void b(long j11) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j11) + " seconds...");
        }
        this.G = go.a(j11, this.f21676b, new Runnable() { // from class: com.applovin.impl.x00
            @Override // java.lang.Runnable
            public final void run() {
                this.f24199a.n();
            }
        });
    }

    public void b(String str) {
        if (this.f21675a.B0()) {
            a(str, 0L);
        }
    }

    public void b(boolean z11) {
        List listA = yp.a(z11, this.f21675a, this.f21676b, this.f21678d);
        if (listA.isEmpty()) {
            return;
        }
        if (!((Boolean) this.f21676b.a(sj.N5)).booleanValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.b("AppLovinFullscreenActivity", "Streaming ad due to missing ad resources: " + listA);
            }
            this.f21675a.K0();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.b("AppLovinFullscreenActivity", "Dismissing ad due to missing resources: " + listA);
        }
        tb.a(this.f21675a, this.D, "Missing ad resources", null, null);
        f();
    }

    public void c(String str) {
        a(str, 0L);
    }

    public void c(boolean z11) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z11);
        }
        b("javascript:al_onWindowFocusChanged( " + z11 + " );");
        go goVar = this.H;
        if (goVar != null) {
            if (z11) {
                goVar.e();
            } else {
                goVar.d();
            }
        }
    }

    public void d(boolean z11) {
        a(z11, ((Long) this.f21676b.a(sj.I2)).longValue());
        gc.a(this.D, this.f21675a);
        this.f21676b.C().a(this.f21675a);
        if (this.f21675a.hasVideoUrl() || l()) {
            gc.a(this.E, this.f21675a);
        }
        new yg(this.f21678d).a(this.f21675a);
        this.f21675a.setHasShown(true);
    }

    public void f() {
        this.f21692s = true;
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "dismiss()");
        }
        com.applovin.impl.sdk.ad.b bVar = this.f21675a;
        if (bVar != null) {
            bVar.getAdEventTracker().f();
        }
        this.f21679f.removeCallbacksAndMessages(null);
        com.applovin.impl.sdk.ad.b bVar2 = this.f21675a;
        a("javascript:al_onPoststitialDismiss();", bVar2 != null ? bVar2.C() : 0L);
        p();
        this.J.b();
        if (this.f21681h != null) {
            this.f21676b.n().b(this.f21681h);
        }
        if (this.f21680g != null) {
            this.f21676b.e().b(this.f21680g);
        }
        if (m()) {
            this.f21678d.finish();
            return;
        }
        this.f21676b.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21676b.J().a("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        v();
    }

    public int g() {
        int iR = this.f21675a.r();
        return (iR <= 0 && ((Boolean) this.f21676b.a(sj.H2)).booleanValue()) ? this.f21694u + 1 : iR;
    }

    public void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "Handling al_onPoststitialShow evaluation error");
        }
    }

    public void j() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "Handling render process crash");
        }
        this.f21693t = true;
    }

    public boolean k() {
        return this.f21692s;
    }

    public boolean l() {
        return AppLovinAdType.INCENTIVIZED == this.f21675a.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.f21675a.getType();
    }

    public boolean m() {
        return this.f21678d instanceof AppLovinFullscreenActivity;
    }

    @Override // com.applovin.impl.yp.b
    public void onCachedResourcesChecked(boolean z11) {
        if (z11) {
            return;
        }
        if (!((Boolean) this.f21676b.a(sj.N5)).booleanValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.b("AppLovinFullscreenActivity", "Streaming ad due to unavailable ad resources");
            }
            this.f21675a.K0();
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.b("AppLovinFullscreenActivity", "Dismissing ad due to unavailable resources");
            }
            tb.a(this.f21675a, this.D, "Unavailable ad resources", null, null);
            f();
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction()) && !this.f21693t) {
            j();
        } else if ("com.applovin.al_onPoststitialShow_evaluation_error".equals(intent.getAction())) {
            i();
        }
    }

    public void p() {
        if (!B() && this.f21688o.compareAndSet(false, true)) {
            gc.b(this.D, this.f21675a);
            this.f21676b.C().b(this.f21675a);
            this.f21676b.E().a(la.f20383l, this.f21675a);
        }
    }

    public abstract void q();

    public void r() {
        go goVar = this.G;
        if (goVar != null) {
            goVar.d();
        }
    }

    public void s() {
        go goVar = this.G;
        if (goVar != null) {
            goVar.e();
        }
    }

    public void t() {
        com.applovin.impl.adview.b bVarG;
        if (this.f21682i == null || !this.f21675a.x0() || (bVarG = this.f21682i.getController().g()) == null) {
            return;
        }
        this.J.a(bVarG, new j2.c() { // from class: com.applovin.impl.y00
            @Override // com.applovin.impl.j2.c
            public final void a(View view) {
                this.f24451a.a(view);
            }
        });
    }

    public void u() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.K) {
            f();
        }
        if (this.f21675a.S0()) {
            c("javascript:onBackPressed();");
        }
    }

    public void v() {
        AppLovinAdView appLovinAdView = this.f21682i;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.f21682i.destroy();
            this.f21682i = null;
            if ((parent instanceof ViewGroup) && m()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        q();
        p();
        this.C = null;
        this.D = null;
        this.E = null;
        this.f21678d = null;
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    public void w() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "onPause()");
        }
        b("javascript:al_onAppPaused();");
        if (this.F.b()) {
            this.F.a();
        }
        r();
    }

    public void x() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "onResume()");
        }
        b("javascript:al_onAppResumed();");
        s();
        if (this.F.b()) {
            this.F.a();
        }
    }

    public void y() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public abstract void z();
}
