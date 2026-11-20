package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
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
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class v9 extends p9 implements AppLovinCommunicatorSubscriber {
    private final w9 L;
    private MediaPlayer M;
    protected final AppLovinVideoView N;
    protected final o O;
    protected final com.applovin.impl.adview.g P;
    protected h3 Q;
    protected final ImageView R;
    protected com.applovin.impl.adview.l S;
    protected final ProgressBar T;
    protected ProgressBar U;
    protected ImageView V;
    private final e W;
    private final d X;
    private final Handler Y;
    private final Handler Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected final v4 f23786a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected final v4 f23787b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final boolean f23788c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected boolean f23789d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected long f23790e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f23791f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private int f23792g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected boolean f23793h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private boolean f23794i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final AtomicBoolean f23795j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final AtomicBoolean f23796k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private long f23797l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private long f23798m0;

    /* JADX INFO: compiled from: source.java */
    public class a implements v4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f23799a;

        public a(int i11) {
            this.f23799a = i11;
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            v9 v9Var = v9.this;
            if (v9Var.Q != null) {
                long seconds = ((long) this.f23799a) - TimeUnit.MILLISECONDS.toSeconds(v9Var.N.getCurrentPosition());
                if (seconds <= 0) {
                    v9.this.f21695v = true;
                } else if (v9.this.T()) {
                    v9.this.Q.setProgress((int) seconds);
                }
            }
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return v9.this.T();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements v4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f23801a;

        public b(Integer num) {
            this.f23801a = num;
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            v9 v9Var = v9.this;
            if (v9Var.f23793h0) {
                v9Var.T.setVisibility(8);
            } else {
                v9.this.T.setProgress((int) ((v9Var.N.getCurrentPosition() / v9.this.f23790e0) * this.f23801a.intValue()));
            }
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return !v9.this.f23793h0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements v4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f23803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f23804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f23805c;

        public c(long j11, Integer num, Long l11) {
            this.f23803a = j11;
            this.f23804b = num;
            this.f23805c = l11;
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            v9.this.U.setProgress((int) ((v9.this.f21691r / this.f23803a) * this.f23804b.intValue()));
            v9.this.f21691r += this.f23805c.longValue();
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return v9.this.f21691r < this.f23803a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements rr.a {
        private d() {
        }

        public /* synthetic */ d(v9 v9Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.rr.a
        public void a(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            tp.a(uri, v9.this.f21682i.getController(), v9.this.f21676b);
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            v9.this.f();
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar, Bundle bundle) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            v9.this.a(lVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.rr.a
        public void b(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            tp.b(uri, v9.this.f21682i.getController().i(), v9.this.f21676b);
        }

        @Override // com.applovin.impl.rr.a
        public void b(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            v9.this.a(lVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.rr.a
        public void c(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Fully Watched from video button...");
            }
            v9.this.I = true;
        }

        @Override // com.applovin.impl.rr.a
        public void d(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            v9.this.Y();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnCompletionListener, AppLovinTouchToClickListener.OnClickListener {
        private e() {
        }

        public /* synthetic */ e(v9 v9Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            v9.this.a(motionEvent, (Bundle) null);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "Video completed");
            }
            v9.this.f23794i0 = true;
            v9 v9Var = v9.this;
            if (!v9Var.f21693t) {
                v9Var.X();
            } else if (v9Var.l()) {
                v9.this.V();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
            v9.this.d("Video view error (" + i11 + "," + i12 + ")");
            v9.this.N.start();
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i11 + ", " + i12 + ")");
            }
            if (i11 == 701) {
                v9.this.W();
                return false;
            }
            if (i11 != 3) {
                if (i11 != 702) {
                    return false;
                }
                v9.this.G();
                return false;
            }
            v9.this.f23786a0.b();
            v9 v9Var = v9.this;
            if (v9Var.P != null) {
                v9Var.S();
            }
            v9.this.G();
            if (!v9.this.F.b()) {
                return false;
            }
            v9.this.z();
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            v9.this.M = mediaPlayer;
            mediaPlayer.setOnInfoListener(v9.this.W);
            mediaPlayer.setOnErrorListener(v9.this.W);
            float f11 = !v9.this.f23789d0 ? 1 : 0;
            mediaPlayer.setVolume(f11, f11);
            v9.this.f21694u = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());
            v9.this.c(mediaPlayer.getDuration());
            v9.this.R();
            com.applovin.impl.sdk.n nVar = v9.this.f21677c;
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.a("AppLovinFullscreenActivity", "MediaPlayer prepared: " + v9.this.M);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnClickListener {
        private f() {
        }

        public /* synthetic */ f(v9 v9Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v9 v9Var = v9.this;
            if (view == v9Var.P) {
                v9Var.Y();
                return;
            }
            if (view == v9Var.R) {
                v9Var.Z();
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                v9.this.f21677c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public v9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.L = new w9(this.f21675a, this.f21678d, this.f21676b);
        a aVar = null;
        this.V = null;
        e eVar = new e(this, aVar);
        this.W = eVar;
        d dVar = new d(this, aVar);
        this.X = dVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.Y = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.Z = handler2;
        v4 v4Var = new v4(handler, this.f21676b);
        this.f23786a0 = v4Var;
        this.f23787b0 = new v4(handler2, this.f21676b);
        boolean zH0 = this.f21675a.H0();
        this.f23788c0 = zH0;
        this.f23789d0 = yp.e(this.f21676b);
        this.f23792g0 = -1;
        this.f23795j0 = new AtomicBoolean();
        this.f23796k0 = new AtomicBoolean();
        this.f23797l0 = -2L;
        this.f23798m0 = 0L;
        if (!bVar.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        if (yp.a(sj.f23014n1, jVar)) {
            a(!zH0);
        }
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
        this.N = appLovinVideoView;
        appLovinVideoView.setOnPreparedListener(eVar);
        appLovinVideoView.setOnCompletionListener(eVar);
        appLovinVideoView.setOnErrorListener(eVar);
        appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(jVar, sj.F0, activity, eVar));
        bVar.e().putString("video_view_address", zq.a(appLovinVideoView));
        f fVar = new f(this, aVar);
        if (bVar.k0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.b0(), activity);
            this.P = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(fVar);
        } else {
            this.P = null;
        }
        if (a(this.f23789d0, jVar)) {
            ImageView imageView = new ImageView(activity);
            this.R = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(fVar);
            e(this.f23789d0);
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
        if (!bVar.r0()) {
            this.T = null;
            return;
        }
        Long l11 = (Long) jVar.a(sj.D2);
        Integer num = (Integer) jVar.a(sj.E2);
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
        this.T = progressBar;
        a(progressBar, bVar.q0(), num.intValue());
        v4Var.a("PROGRESS_BAR", l11.longValue(), new b(num));
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
        o oVar = this.O;
        if (oVar != null) {
            oVar.a();
            final o oVar2 = this.O;
            Objects.requireNonNull(oVar2);
            a(new Runnable() { // from class: com.applovin.impl.p70
                @Override // java.lang.Runnable
                public final void run() {
                    oVar2.b();
                }
            }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.f23797l0 = -1L;
        this.f23798m0 = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        a(250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        o oVar = this.O;
        if (oVar != null) {
            oVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        this.f21690q = SystemClock.elapsedRealtime();
    }

    private void P() {
        com.applovin.impl.adview.l lVar;
        qq qqVarI0 = this.f21675a.i0();
        if (qqVarI0 == null || !qqVarI0.j() || this.f23793h0 || (lVar = this.S) == null) {
            return;
        }
        final boolean z11 = lVar.getVisibility() == 4;
        final long jH = qqVarI0.h();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i70
            @Override // java.lang.Runnable
            public final void run() {
                this.f19639a.b(z11, jH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.f23793h0) {
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
        if (this.f23792g0 < 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21677c.a("AppLovinFullscreenActivity", "Invalid last video position");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Resuming video at position " + this.f23792g0 + "ms for MediaPlayer: " + this.M);
        }
        this.N.seekTo(this.f23792g0);
        this.N.start();
        this.f23786a0.b();
        this.f23792g0 = -1;
        a(new Runnable() { // from class: com.applovin.impl.o70
            @Override // java.lang.Runnable
            public final void run() {
                this.f21465a.K();
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (this.f23796k0.compareAndSet(false, true)) {
            a(this.P, this.f21675a.k0(), new Runnable() { // from class: com.applovin.impl.k70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20187a.L();
                }
            });
        }
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

    private void e(boolean z11) {
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

    private void f(boolean z11) {
        this.f23791f0 = E();
        if (z11) {
            this.N.pause();
        } else {
            this.N.stopPlayback();
        }
    }

    @Override // com.applovin.impl.p9
    public void A() {
        a((ViewGroup) null);
    }

    public int E() {
        long currentPosition = this.N.getCurrentPosition();
        if (this.f23794i0) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.f23790e0) * 100.0f) : this.f23791f0;
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
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m70
            @Override // java.lang.Runnable
            public final void run() {
                this.f20629a.J();
            }
        });
    }

    public boolean H() {
        if (this.I && this.f21675a.Y0()) {
            return true;
        }
        return I();
    }

    public boolean I() {
        return E() >= this.f21675a.m0();
    }

    public void R() {
        long jV;
        long millis;
        if (this.f21675a.U() >= 0 || this.f21675a.V() >= 0) {
            if (this.f21675a.U() >= 0) {
                jV = this.f21675a.U();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f21675a;
                long j11 = this.f23790e0;
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

    public boolean T() {
        return (this.f21695v || this.f23793h0 || !this.N.isPlaying()) ? false : true;
    }

    public boolean U() {
        return l() && !H();
    }

    public void W() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.n70
            @Override // java.lang.Runnable
            public final void run() {
                this.f21298a.N();
            }
        });
    }

    public void X() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Showing postitial...");
        }
        f(this.f21675a.f1());
        long jT = this.f21675a.T();
        if (jT > 0) {
            this.f21691r = 0L;
            Long l11 = (Long) this.f21676b.a(sj.M2);
            Integer num = (Integer) this.f21676b.a(sj.P2);
            ProgressBar progressBar = new ProgressBar(this.f21678d, null, R.attr.progressBarStyleHorizontal);
            this.U = progressBar;
            a(progressBar, this.f21675a.S(), num.intValue());
            this.f23787b0.a("POSTITIAL_PROGRESS_BAR", l11.longValue(), new c(jT, num, l11));
            this.f23787b0.b();
        }
        this.L.a(this.f21684k, this.f21683j, this.f21682i, this.U);
        a("javascript:al_onPoststitialShow(" + this.f21698y + "," + this.f21699z + ");", this.f21675a.D());
        if (this.f21684k != null) {
            if (this.f21675a.p() >= 0) {
                a(this.f21684k, this.f21675a.p(), new Runnable() { // from class: com.applovin.impl.l70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f20363a.O();
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
        this.f23793h0 = true;
    }

    public void Y() {
        this.f23797l0 = SystemClock.elapsedRealtime() - this.f23798m0;
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.f23797l0 + "ms");
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
        MediaPlayer mediaPlayer = this.M;
        if (mediaPlayer == null) {
            return;
        }
        try {
            float f11 = this.f23789d0 ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f11, f11);
            boolean z11 = !this.f23789d0;
            this.f23789d0 = z11;
            e(z11);
            a(this.f23789d0, 0L);
        } catch (Throwable unused) {
        }
    }

    @Override // com.applovin.impl.p9
    public void a(long j11) {
        a(new Runnable() { // from class: com.applovin.impl.j70
            @Override // java.lang.Runnable
            public final void run() {
                this.f19873a.Q();
            }
        }, j11);
    }

    public void a(MotionEvent motionEvent, Bundle bundle) {
        Context context;
        if (!this.f21675a.G0()) {
            P();
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
        String str;
        this.L.a(this.R, this.P, this.S, this.O, this.T, this.Q, this.N, this.f21682i, this.f21683j, this.V, viewGroup);
        if (z3.i() && (str = this.f21676b.g0().getExtraParameters().get("audio_focus_request")) != null) {
            this.N.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (!yp.a(sj.f23014n1, this.f21676b)) {
            b(!this.f23788c0);
        }
        this.N.setVideoURI(this.f21675a.s0());
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        if (this.f21675a.b1()) {
            this.F.b(this.f21675a, new Runnable() { // from class: com.applovin.impl.r70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22056a.M();
                }
            });
        }
        com.applovin.impl.adview.k kVar = this.f21683j;
        if (kVar != null) {
            kVar.b();
        }
        this.N.start();
        if (this.f23788c0) {
            W();
        }
        this.f21682i.renderAd(this.f21675a);
        if (this.P != null) {
            this.f21676b.j0().a(new jn(this.f21676b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.s70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22304a.S();
                }
            }), tm.b.TIMEOUT, this.f21675a.l0(), true);
        }
        super.d(this.f23789d0);
    }

    @Override // com.applovin.impl.p9
    public void a(final String str, long j11) {
        super.a(str, j11);
        if (this.S == null || j11 < 0 || !StringUtils.isValidString(str) || !((Boolean) this.f21676b.a(sj.S2)).booleanValue()) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.q70
            @Override // java.lang.Runnable
            public final void run() {
                this.f21910a.e(str);
            }
        }, j11);
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
        this.f23790e0 = j11;
    }

    @Override // com.applovin.impl.p9
    public void c(boolean z11) {
        super.c(z11);
        if (z11) {
            a(0L);
            if (this.f23793h0) {
                this.f23787b0.b();
                return;
            }
            return;
        }
        if (this.f23793h0) {
            this.f23787b0.c();
        } else {
            z();
        }
    }

    public void d(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.b("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f21675a);
        }
        if (this.f23795j0.compareAndSet(false, true)) {
            if (yp.a(sj.f22982j1, this.f21676b)) {
                this.f21676b.B().d(this.f21675a, com.applovin.impl.sdk.j.l());
            }
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.D;
            if (appLovinAdDisplayListener instanceof qb) {
                ((qb) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            this.f21676b.E().a(this.f21675a instanceof aq ? "handleVastVideoError" : "handleVideoError", str, this.f21675a);
            f();
        }
    }

    @Override // com.applovin.impl.p9
    public void f() {
        this.f23786a0.a();
        this.f23787b0.a();
        this.Y.removeCallbacksAndMessages(null);
        this.Z.removeCallbacksAndMessages(null);
        q();
        super.f();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
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
        if (!l() || this.f23793h0) {
            V();
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.f21675a.getAdIdNumber() && this.f23788c0) {
                int i11 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i11 >= 200 && i11 < 300) || this.f23794i0 || this.N.isPlaying()) {
                    return;
                }
                d("Video cache error during stream. ResponseCode=" + i11 + ", exception=" + string);
            }
        }
    }

    @Override // com.applovin.impl.p9
    public void q() {
        super.a(E(), this.f23788c0, H(), this.f23797l0);
    }

    @Override // com.applovin.impl.p9
    public void v() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.d("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (((Boolean) this.f21676b.a(sj.f22963g6)).booleanValue()) {
                tr.b(this.S);
                this.S = null;
            }
            if (this.f23788c0) {
                AppLovinCommunicator.getInstance(this.f21678d).unsubscribe(this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.N;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.N.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.M;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("AppLovinFullscreenActivity", "Unable to destroy presenter", th2);
        }
        super.v();
    }

    @Override // com.applovin.impl.p9
    public void z() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Pausing video");
        }
        this.f23792g0 = this.N.getCurrentPosition();
        this.N.pause();
        this.f23786a0.c();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21677c.a("AppLovinFullscreenActivity", "Paused video at position " + this.f23792g0 + "ms");
        }
    }
}
