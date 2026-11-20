package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class u9 extends p9 implements AppLovinCommunicatorSubscriber {
    private final w9 L;
    protected final com.applovin.exoplayer2.ui.e M;
    protected final ck N;
    protected final o O;
    protected final com.applovin.impl.adview.g P;
    protected h3 Q;
    protected final ImageView R;
    protected com.applovin.impl.adview.l S;
    protected final ProgressBar T;
    protected ProgressBar U;
    private final d V;
    private final Handler W;
    private final Handler X;
    protected final v4 Y;
    protected final v4 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final boolean f23535a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected boolean f23536b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected long f23537c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected int f23538d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected boolean f23539e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    protected boolean f23540f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private long f23541g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final AtomicBoolean f23542h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final AtomicBoolean f23543i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private long f23544j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private long f23545k0;

    /* JADX INFO: compiled from: source.java */
    public class a implements v4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f23546a;

        public a(int i11) {
            this.f23546a = i11;
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            u9 u9Var = u9.this;
            if (u9Var.Q != null) {
                long seconds = ((long) this.f23546a) - TimeUnit.MILLISECONDS.toSeconds(u9Var.M.getPlayer().getCurrentPosition());
                if (seconds <= 0) {
                    u9.this.f21695v = true;
                } else if (u9.this.T()) {
                    u9.this.Q.setProgress((int) seconds);
                }
            }
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return u9.this.T();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements v4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f23548a;

        public b(Integer num) {
            this.f23548a = num;
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            u9 u9Var = u9.this;
            if (u9Var.f23539e0) {
                u9Var.T.setVisibility(8);
            } else {
                u9.this.T.setProgress((int) ((u9Var.N.getCurrentPosition() / u9.this.f23537c0) * this.f23548a.intValue()));
            }
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return !u9.this.f23539e0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements v4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f23550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f23551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f23552c;

        public c(long j11, Integer num, Long l11) {
            this.f23550a = j11;
            this.f23551b = num;
            this.f23552c = l11;
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            u9.this.U.setProgress((int) ((u9.this.f21691r / this.f23550a) * this.f23551b.intValue()));
            u9.this.f21691r += this.f23552c.longValue();
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return u9.this.f21691r < this.f23550a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements rr.a {
        private d() {
        }

        public /* synthetic */ d(u9 u9Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.rr.a
        public void a(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            tp.a(uri, u9.this.f21682i.getController(), u9.this.f21676b);
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            u9.this.f();
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar, Bundle bundle) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            u9.this.a(lVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.rr.a
        public void b(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            tp.b(uri, u9.this.f21682i.getController().i(), u9.this.f21676b);
        }

        @Override // com.applovin.impl.rr.a
        public void b(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            u9.this.a(lVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.rr.a
        public void c(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Fully Watched from video button...");
            }
            u9.this.I = true;
        }

        @Override // com.applovin.impl.rr.a
        public void d(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            u9.this.Y();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements qh.c, com.applovin.exoplayer2.ui.d.e, AppLovinTouchToClickListener.OnClickListener {
        private e() {
        }

        public /* synthetic */ e(u9 u9Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(int i11) {
            c20.a(this, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(fo foVar, int i11) {
            c20.b(this, foVar, i11);
        }

        @Override // com.applovin.impl.qh.c
        public void a(nh nhVar) {
            u9.this.d("Video view error (" + yp.a(nhVar) + ")");
            u9.this.f();
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(ph phVar) {
            c20.d(this, phVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(po poVar, to toVar) {
            c20.e(this, poVar, toVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(qh.b bVar) {
            c20.f(this, bVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(qh.f fVar, qh.f fVar2, int i11) {
            c20.g(this, fVar, fVar2, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(qh qhVar, qh.d dVar) {
            c20.h(this, qhVar, dVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(td tdVar, int i11) {
            c20.i(this, tdVar, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(vd vdVar) {
            c20.j(this, vdVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void a(boolean z11, int i11) {
            c20.k(this, z11, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b() {
            c20.l(this);
        }

        @Override // com.applovin.impl.qh.c
        public void b(int i11) {
            com.applovin.impl.sdk.n nVar = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "Player state changed to state " + i11 + " and will play when ready: " + u9.this.N.l());
            }
            if (i11 == 2) {
                u9.this.W();
                return;
            }
            if (i11 != 3) {
                if (i11 == 4) {
                    com.applovin.impl.sdk.n nVar2 = u9.this.f21677c;
                    if (com.applovin.impl.sdk.n.a()) {
                        u9.this.f21677c.a("AppLovinFullscreenActivity", "Video completed");
                    }
                    u9 u9Var = u9.this;
                    u9Var.f23540f0 = true;
                    if (!u9Var.f21693t) {
                        u9Var.X();
                        return;
                    } else {
                        if (u9Var.l()) {
                            u9.this.V();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            u9 u9Var2 = u9.this;
            u9Var2.N.a(!u9Var2.f23536b0 ? 1 : 0);
            u9 u9Var3 = u9.this;
            u9Var3.f21694u = (int) TimeUnit.MILLISECONDS.toSeconds(u9Var3.N.getDuration());
            u9 u9Var4 = u9.this;
            u9Var4.c(u9Var4.N.getDuration());
            u9.this.Q();
            com.applovin.impl.sdk.n nVar3 = u9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.a("AppLovinFullscreenActivity", "MediaPlayer prepared: " + u9.this.N);
            }
            u9.this.Y.b();
            u9 u9Var5 = u9.this;
            if (u9Var5.P != null) {
                u9Var5.R();
            }
            u9.this.G();
            if (u9.this.F.b()) {
                u9.this.z();
            }
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(nh nhVar) {
            c20.m(this, nhVar);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11) {
            c20.n(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11, int i11) {
            c20.o(this, z11, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void c(int i11) {
            c20.p(this, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void c(boolean z11) {
            c20.q(this, z11);
        }

        @Override // com.applovin.exoplayer2.ui.d.e
        public void d(int i11) {
            if (i11 == 0) {
                u9.this.M.c();
            }
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void d(boolean z11) {
            c20.r(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(int i11) {
            c20.s(this, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(boolean z11) {
            c20.t(this, z11);
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            u9.this.a(motionEvent, (Bundle) null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnClickListener {
        private f() {
        }

        public /* synthetic */ f(u9 u9Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u9 u9Var = u9.this;
            if (view == u9Var.P) {
                u9Var.Y();
                return;
            }
            if (view == u9Var.R) {
                u9Var.a0();
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f21677c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public u9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.L = new w9(this.f21675a, this.f21678d, this.f21676b);
        a aVar = null;
        d dVar = new d(this, aVar);
        this.V = dVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.W = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.X = handler2;
        v4 v4Var = new v4(handler, this.f21676b);
        this.Y = v4Var;
        this.Z = new v4(handler2, this.f21676b);
        boolean zH0 = this.f21675a.H0();
        this.f23535a0 = zH0;
        this.f23536b0 = yp.e(this.f21676b);
        this.f23541g0 = -1L;
        this.f23542h0 = new AtomicBoolean();
        this.f23543i0 = new AtomicBoolean();
        this.f23544j0 = -2L;
        this.f23545k0 = 0L;
        if (!bVar.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        if (yp.a(sj.f23014n1, jVar)) {
            a(!zH0);
        }
        f fVar = new f(this, aVar);
        if (bVar.k0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.b0(), activity);
            this.P = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(fVar);
        } else {
            this.P = null;
        }
        if (a(this.f23536b0, jVar)) {
            ImageView imageView = new ImageView(activity);
            this.R = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(fVar);
            e(this.f23536b0);
        } else {
            this.R = null;
        }
        String strG0 = bVar.g0();
        if (StringUtils.isValidString(strG0)) {
            rr rrVar = new rr(jVar);
            rrVar.a(new WeakReference(dVar));
            com.applovin.impl.adview.l lVar = new com.applovin.impl.adview.l(bVar.f0(), bVar, rrVar, activity);
            this.S = lVar;
            lVar.a(strG0);
        } else {
            this.S = null;
        }
        if (zH0) {
            o oVar = new o(activity, ((Integer) jVar.a(sj.G2)).intValue(), R.attr.progressBarStyleLarge);
            this.O = oVar;
            oVar.setColor(Color.parseColor("#75FFFFFF"));
            oVar.setBackgroundColor(Color.parseColor("#00000000"));
            oVar.setVisibility(8);
            AppLovinCommunicator.getInstance(activity).subscribe(this, "video_caching_failed");
        } else {
            this.O = null;
        }
        int iG = g();
        boolean z11 = ((Boolean) jVar.a(sj.f23015n2)).booleanValue() && iG > 0;
        if (this.Q == null && z11) {
            this.Q = new h3(activity);
            int iQ = bVar.q();
            this.Q.setTextColor(iQ);
            this.Q.setTextSize(((Integer) jVar.a(sj.f23007m2)).intValue());
            this.Q.setFinishedStrokeColor(iQ);
            this.Q.setFinishedStrokeWidth(((Integer) jVar.a(sj.f22999l2)).intValue());
            this.Q.setMax(iG);
            this.Q.setProgress(iG);
            v4Var.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1L), new a(iG));
        }
        if (bVar.r0()) {
            Long l11 = (Long) jVar.a(sj.D2);
            Integer num = (Integer) jVar.a(sj.E2);
            ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
            this.T = progressBar;
            a(progressBar, bVar.q0(), num.intValue());
            v4Var.a("PROGRESS_BAR", l11.longValue(), new b(num));
        } else {
            this.T = null;
        }
        ck ckVarA = new ck.b(activity).a();
        this.N = ckVarA;
        e eVar = new e(this, aVar);
        ckVarA.a((qh.c) eVar);
        ckVarA.a(0);
        com.applovin.exoplayer2.ui.e eVar2 = new com.applovin.exoplayer2.ui.e(activity);
        this.M = eVar2;
        eVar2.c();
        eVar2.setControllerVisibilityListener(eVar);
        eVar2.setPlayer(ckVarA);
        eVar2.setOnTouchListener(new AppLovinTouchToClickListener(jVar, sj.F0, activity, eVar));
        bVar.e().putString("video_view_address", zq.a(eVar2));
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        o oVar = this.O;
        if (oVar != null) {
            oVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.f23544j0 = -1L;
        this.f23545k0 = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        a(250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        o oVar = this.O;
        if (oVar != null) {
            oVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.f21690q = SystemClock.elapsedRealtime();
    }

    private void O() {
        com.applovin.impl.adview.l lVar;
        qq qqVarI0 = this.f21675a.i0();
        if (qqVarI0 == null || !qqVarI0.j() || this.f23539e0 || (lVar = this.S) == null) {
            return;
        }
        final boolean z11 = lVar.getVisibility() == 4;
        final long jH = qqVarI0.h();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.q60
            @Override // java.lang.Runnable
            public final void run() {
                this.f21907a.b(z11, jH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.L.a(this.f21685l);
        this.f21690q = SystemClock.elapsedRealtime();
    }

    private void a(ProgressBar progressBar, int i11, int i12) {
        progressBar.setMax(i12);
        progressBar.setPadding(0, 0, 0, 0);
        if (z3.f()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(i11));
        }
    }

    private static boolean a(boolean z11, com.applovin.impl.sdk.j jVar) {
        if (!((Boolean) jVar.a(sj.f23079v2)).booleanValue()) {
            return false;
        }
        if (!((Boolean) jVar.a(sj.f23087w2)).booleanValue() || z11) {
            return true;
        }
        return ((Boolean) jVar.a(sj.f23103y2)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z11, long j11) {
        if (z11) {
            zq.a(this.S, j11, (Runnable) null);
        } else {
            zq.b(this.S, j11, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        tr.a(this.S, str, "AppLovinFullscreenActivity", this.f21676b);
    }

    @Override // com.applovin.impl.p9
    public void A() {
        a((ViewGroup) null);
    }

    public int E() {
        ck ckVar = this.N;
        if (ckVar == null) {
            return 0;
        }
        long currentPosition = ckVar.getCurrentPosition();
        if (this.f23540f0) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.f23537c0) * 100.0f) : this.f23538d0;
    }

    public void F() {
        this.f21698y++;
        if (this.f21675a.B()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            f();
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Skipping video...");
            }
            X();
        }
    }

    public void G() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.t60
            @Override // java.lang.Runnable
            public final void run() {
                this.f23205a.J();
            }
        });
    }

    public boolean H() {
        com.applovin.impl.sdk.ad.b bVar = this.f21675a;
        if (bVar == null) {
            return false;
        }
        if (this.I && bVar.Y0()) {
            return true;
        }
        return I();
    }

    public boolean I() {
        return E() >= this.f21675a.m0();
    }

    public void P() {
        if (this.f23539e0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.k("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
                return;
            }
            return;
        }
        if (this.f21676b.f0().isApplicationPaused()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.k("AppLovinFullscreenActivity", "Skip video resume - app paused");
                return;
            }
            return;
        }
        long j11 = this.f23541g0;
        if (j11 < 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Invalid last video position, isVideoPlaying=" + this.N.isPlaying());
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Resuming video at position " + j11 + "ms for MediaPlayer: " + this.N);
        }
        this.N.a(true);
        this.Y.b();
        this.f23541g0 = -1L;
        if (this.N.isPlaying()) {
            return;
        }
        W();
    }

    public void Q() {
        long jV;
        long millis;
        if (this.f21675a.U() >= 0 || this.f21675a.V() >= 0) {
            if (this.f21675a.U() >= 0) {
                jV = this.f21675a.U();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f21675a;
                long j11 = this.f23537c0;
                long j12 = j11 > 0 ? j11 : 0L;
                if (aVar.V0()) {
                    int iJ1 = (int) ((com.applovin.impl.sdk.ad.a) this.f21675a).j1();
                    if (iJ1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iJ1);
                    } else {
                        int iP = (int) aVar.p();
                        if (iP > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iP);
                        }
                    }
                    j12 += millis;
                }
                jV = (long) (j12 * (((double) this.f21675a.V()) / 100.0d));
            }
            b(jV);
        }
    }

    public void R() {
        if (this.f23543i0.compareAndSet(false, true)) {
            a(this.P, this.f21675a.k0(), new Runnable() { // from class: com.applovin.impl.w60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f24065a.K();
                }
            });
        }
    }

    public void S() {
        if (!yp.a(sj.f23014n1, this.f21676b)) {
            b(!this.f23535a0);
        }
        Activity activity = this.f21678d;
        bi biVarA = new bi.b(new w5(activity, xp.a((Context) activity, "com.applovin.sdk"))).a(td.a(this.f21675a.s0()));
        this.N.a(!this.f23536b0 ? 1 : 0);
        this.N.a((be) biVarA);
        this.N.b();
        this.N.a(false);
    }

    public boolean T() {
        return (this.f21695v || this.f23539e0 || !this.M.getPlayer().isPlaying()) ? false : true;
    }

    public boolean U() {
        return l() && !H();
    }

    public void W() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.s60
            @Override // java.lang.Runnable
            public final void run() {
                this.f22303a.M();
            }
        });
    }

    public void X() {
        Z();
        long jT = this.f21675a.T();
        if (jT > 0) {
            this.f21691r = 0L;
            Long l11 = (Long) this.f21676b.a(sj.M2);
            Integer num = (Integer) this.f21676b.a(sj.P2);
            ProgressBar progressBar = new ProgressBar(this.f21678d, null, R.attr.progressBarStyleHorizontal);
            this.U = progressBar;
            a(progressBar, this.f21675a.S(), num.intValue());
            this.Z.a("POSTITIAL_PROGRESS_BAR", l11.longValue(), new c(jT, num, l11));
            this.Z.b();
        }
        this.L.a(this.f21684k, this.f21683j, this.f21682i, this.U);
        a("javascript:al_onPoststitialShow(" + this.f21698y + "," + this.f21699z + ");", this.f21675a.D());
        if (this.f21684k != null) {
            if (this.f21675a.p() >= 0) {
                a(this.f21684k, this.f21675a.p(), new Runnable() { // from class: com.applovin.impl.p60
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21667a.N();
                    }
                });
            } else {
                this.f21684k.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.f21684k;
        if (gVar != null) {
            arrayList.add(new og(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.f21683j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f21683j;
            arrayList.add(new og(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        ProgressBar progressBar2 = this.U;
        if (progressBar2 != null) {
            arrayList.add(new og(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        this.f21675a.getAdEventTracker().b(this.f21682i, arrayList);
        t();
        this.f23539e0 = true;
    }

    public void Y() {
        this.f23544j0 = SystemClock.elapsedRealtime() - this.f23545k0;
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.f23544j0 + "ms");
        }
        if (!U()) {
            F();
            return;
        }
        z();
        r();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
        }
        this.F.e();
    }

    public void Z() {
        this.f23538d0 = E();
        this.N.a(false);
    }

    @Override // com.applovin.impl.p9
    public void a(long j11) {
        a(new Runnable() { // from class: com.applovin.impl.x60
            @Override // java.lang.Runnable
            public final void run() {
                this.f24265a.P();
            }
        }, j11);
    }

    public void a(MotionEvent motionEvent, Bundle bundle) {
        Context context;
        if (!this.f21675a.G0()) {
            O();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Clicking through video");
        }
        Uri uriJ0 = this.f21675a.j0();
        if (uriJ0 != null) {
            if (!((Boolean) this.f21676b.a(sj.H)).booleanValue() || (context = this.f21678d) == null) {
                AppLovinAdView appLovinAdView = this.f21682i;
                context = appLovinAdView != null ? appLovinAdView.getContext() : com.applovin.impl.sdk.j.l();
            }
            this.f21676b.i().trackAndLaunchVideoClick(this.f21675a, uriJ0, motionEvent, bundle, this, context);
            gc.a(this.C, this.f21675a);
            this.f21699z++;
        }
    }

    @Override // com.applovin.impl.p9
    public void a(ViewGroup viewGroup) {
        this.L.a(this.R, this.P, this.S, this.O, this.T, this.Q, this.M, this.f21682i, this.f21683j, null, viewGroup);
        com.applovin.impl.adview.k kVar = this.f21683j;
        if (kVar != null) {
            kVar.b();
        }
        this.N.a(true);
        if (this.f21675a.b1()) {
            this.F.b(this.f21675a, new Runnable() { // from class: com.applovin.impl.u60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23527a.L();
                }
            });
        }
        if (this.f23535a0) {
            W();
        }
        this.f21682i.renderAd(this.f21675a);
        if (this.P != null) {
            this.f21676b.j0().a(new jn(this.f21676b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.v60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f23765a.R();
                }
            }), tm.b.TIMEOUT, this.f21675a.l0(), true);
        }
        super.d(this.f23536b0);
    }

    @Override // com.applovin.impl.p9
    public void a(final String str, long j11) {
        super.a(str, j11);
        if (this.S == null || j11 < 0 || !StringUtils.isValidString(str) || !((Boolean) this.f21676b.a(sj.S2)).booleanValue()) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.r60
            @Override // java.lang.Runnable
            public final void run() {
                this.f22053a.e(str);
            }
        }, j11);
    }

    public void a0() {
        boolean z11 = this.f23536b0;
        this.f23536b0 = !z11;
        this.N.a(z11 ? 1.0f : 0.0f);
        e(this.f23536b0);
        a(this.f23536b0, 0L);
    }

    @Override // com.applovin.impl.kb.a
    public void b() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        F();
    }

    @Override // com.applovin.impl.kb.a
    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void c(long j11) {
        this.f23537c0 = j11;
    }

    @Override // com.applovin.impl.p9
    public void c(boolean z11) {
        super.c(z11);
        if (z11) {
            a(0L);
            if (this.f23539e0) {
                this.Z.b();
                return;
            }
            return;
        }
        if (this.f23539e0) {
            this.Z.c();
        } else {
            z();
        }
    }

    public void d(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.b("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f21675a);
        }
        if (StringUtils.containsAtLeastOneSubstring(str, this.f21676b.c(sj.T2))) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Ignoring media error: " + str);
                return;
            }
            return;
        }
        if (this.f23542h0.compareAndSet(false, true)) {
            if (yp.a(sj.f22982j1, this.f21676b)) {
                this.f21676b.B().d(this.f21675a, com.applovin.impl.sdk.j.l());
            }
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.D;
            if (appLovinAdDisplayListener instanceof qb) {
                ((qb) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            this.f21676b.E().a(this.f21675a instanceof aq ? "handleVastExoPlayerError" : "handleExoPlayerError", str, this.f21675a);
            f();
        }
    }

    public void e(boolean z11) {
        if (z3.f()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f21678d.getDrawable(z11 ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.R.setScaleType(ImageView.ScaleType.FIT_XY);
                this.R.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        ImageViewUtils.setImageUri(this.R, z11 ? this.f21675a.L() : this.f21675a.e0(), this.f21676b);
    }

    @Override // com.applovin.impl.p9
    public void f() {
        this.Y.a();
        this.Z.a();
        this.W.removeCallbacksAndMessages(null);
        this.X.removeCallbacksAndMessages(null);
        q();
        super.f();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    @Override // com.applovin.impl.p9
    public void i() {
        super.i();
        V();
    }

    @Override // com.applovin.impl.p9
    public void j() {
        super.j();
        this.L.a(this.S);
        this.L.a((View) this.P);
        if (!l() || this.f23539e0) {
            V();
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.f21675a.getAdIdNumber() && this.f23535a0) {
                int i11 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i11 >= 200 && i11 < 300) || this.f23540f0 || this.N.isPlaying()) {
                    return;
                }
                d("Video cache error during stream. ResponseCode=" + i11 + ", exception=" + string);
            }
        }
    }

    @Override // com.applovin.impl.p9
    public void q() {
        super.a(E(), this.f23535a0, H(), this.f23544j0);
    }

    @Override // com.applovin.impl.p9
    public void v() {
        if (((Boolean) this.f21676b.a(sj.f22963g6)).booleanValue()) {
            tr.b(this.S);
            this.S = null;
        }
        this.N.V();
        if (this.f23535a0) {
            AppLovinCommunicator.getInstance(this.f21678d).unsubscribe(this, "video_caching_failed");
        }
        super.v();
    }

    @Override // com.applovin.impl.p9
    public void z() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Pausing video");
        }
        if (!this.N.isPlaying()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Nothing to pause");
                return;
            }
            return;
        }
        this.f23541g0 = this.N.getCurrentPosition();
        this.N.a(false);
        this.Y.c();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Paused video at position " + this.f23541g0 + "ms");
        }
    }
}
