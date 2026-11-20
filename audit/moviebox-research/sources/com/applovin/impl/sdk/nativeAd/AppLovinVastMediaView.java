package com.applovin.impl.sdk.nativeAd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.aq;
import com.applovin.impl.be;
import com.applovin.impl.bi;
import com.applovin.impl.c20;
import com.applovin.impl.ck;
import com.applovin.impl.fo;
import com.applovin.impl.fq;
import com.applovin.impl.gq;
import com.applovin.impl.kq;
import com.applovin.impl.lq;
import com.applovin.impl.mq;
import com.applovin.impl.nh;
import com.applovin.impl.oq;
import com.applovin.impl.p;
import com.applovin.impl.ph;
import com.applovin.impl.po;
import com.applovin.impl.qh;
import com.applovin.impl.r;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.td;
import com.applovin.impl.to;
import com.applovin.impl.tp;
import com.applovin.impl.v4;
import com.applovin.impl.vd;
import com.applovin.impl.w5;
import com.applovin.impl.xp;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.impl.zq;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public class AppLovinVastMediaView extends AppLovinMediaView implements AppLovinCommunicatorSubscriber, yp.b {
    private static final String COUNTDOWN_IDENTIFIER_PROGRESS_TRACKING = "PROGRESS_TRACKING";
    private static final long FADE_ANIMATION_DURATION_MILLIS = 250;
    private static final String TAG = "AppLovinVastMediaView";
    private final AtomicBoolean automaticPauseHandled;
    private final AtomicBoolean automaticResumeHandled;
    private final Handler countdownHandler;
    private final v4 countdownManager;

    @Nullable
    private ImageView industryIconImageView;
    private final AtomicBoolean initialOnAttachedToWindowHandled;
    private boolean isVideoMuted;
    private boolean isVideoPausedByUser;
    private final boolean isVideoStream;
    private long lastVideoPositionFromPauseMillis;
    private final p lifecycleCallbacksAdapter;
    private final AtomicBoolean mediaErrorHandled;
    private final ck mediaPlayer;

    @Nullable
    private ImageView muteButtonImageView;

    @Nullable
    private ImageView playPauseButtonImageView;

    @Nullable
    private FrameLayout replayIconContainer;
    private int savedVideoPercentViewed;
    private long startTimeMillis;
    private final aq vastAd;
    private long videoDurationMillis;
    private final AtomicBoolean videoEndListenerNotified;
    private final Set<kq> videoProgressTrackers;
    private final com.applovin.exoplayer2.ui.e videoView;
    private boolean videoWasCompleted;

    @Nullable
    private LinearLayout videoWidgetLinearLayout;
    private Activity viewActivity;

    /* JADX INFO: compiled from: source.java */
    public class a extends p {
        public a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity.equals(AppLovinVastMediaView.this.viewActivity)) {
                AppLovinVastMediaView.this.maybeHandlePause();
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (!activity.equals(AppLovinVastMediaView.this.viewActivity) || AppLovinVastMediaView.this.isVideoPausedByUser) {
                return;
            }
            AppLovinVastMediaView.this.maybeHandleResume();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements v4.b {
        public b() {
        }

        @Override // com.applovin.impl.v4.b
        public void a() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(AppLovinVastMediaView.this.videoDurationMillis - (AppLovinVastMediaView.this.mediaPlayer.getDuration() - AppLovinVastMediaView.this.mediaPlayer.getCurrentPosition()));
            int videoPercentViewed = AppLovinVastMediaView.this.getVideoPercentViewed();
            HashSet hashSet = new HashSet();
            for (kq kqVar : new HashSet(AppLovinVastMediaView.this.videoProgressTrackers)) {
                if (kqVar.a(seconds, videoPercentViewed)) {
                    hashSet.add(kqVar);
                    AppLovinVastMediaView.this.videoProgressTrackers.remove(kqVar);
                }
            }
            AppLovinVastMediaView.this.maybeFireTrackers(hashSet);
            if (videoPercentViewed >= 25 && videoPercentViewed < 50) {
                AppLovinVastMediaView.this.vastAd.getAdEventTracker().x();
                return;
            }
            if (videoPercentViewed >= 50 && videoPercentViewed < 75) {
                AppLovinVastMediaView.this.vastAd.getAdEventTracker().y();
            } else if (videoPercentViewed >= 75) {
                AppLovinVastMediaView.this.vastAd.getAdEventTracker().C();
            }
        }

        @Override // com.applovin.impl.v4.b
        public boolean b() {
            return !AppLovinVastMediaView.this.videoWasCompleted;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnClickListener {
        private c() {
        }

        public /* synthetic */ c(AppLovinVastMediaView appLovinVastMediaView, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Uri uriB;
            gq gqVarN1 = AppLovinVastMediaView.this.vastAd.n1();
            if (gqVarN1 == null || (uriB = gqVarN1.b()) == null) {
                return;
            }
            n nVar = AppLovinVastMediaView.this.logger;
            if (n.a()) {
                AppLovinVastMediaView.this.logger.a(AppLovinVastMediaView.TAG, "Industry icon clicked, opening URL: " + uriB);
            }
            AppLovinVastMediaView.this.maybeFireTrackers(aq.d.INDUSTRY_ICON_CLICK);
            tp.a(uriB, view.getContext(), AppLovinVastMediaView.this.sdk);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements AppLovinTouchToClickListener.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinNativeAdImpl f22686a;

        public d(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.f22686a = appLovinNativeAdImpl;
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            Uri uriJ0;
            AppLovinVastMediaView.this.maybeFireTrackers(aq.d.VIDEO_CLICK);
            AppLovinVastMediaView.this.vastAd.getAdEventTracker().v();
            if (AppLovinVastMediaView.this.vastAd.G0() && (uriJ0 = AppLovinVastMediaView.this.vastAd.j0()) != null) {
                n nVar = AppLovinVastMediaView.this.logger;
                if (n.a()) {
                    AppLovinVastMediaView.this.logger.a(AppLovinVastMediaView.TAG, "Clicking through video");
                }
                AppLovinVastMediaView.this.sdk.i().maybeSubmitPersistentPostbacks(AppLovinVastMediaView.this.vastAd.a(motionEvent, false));
                this.f22686a.handleNativeAdClick(uriJ0, null, motionEvent, (!((Boolean) AppLovinVastMediaView.this.sdk.a(sj.H)).booleanValue() || AppLovinVastMediaView.this.viewActivity == null) ? AppLovinVastMediaView.this.getContext() : AppLovinVastMediaView.this.viewActivity);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements qh.c, com.applovin.exoplayer2.ui.d.e {
        private e() {
        }

        public /* synthetic */ e(AppLovinVastMediaView appLovinVastMediaView, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            AppLovinVastMediaView.this.mediaPlayer.a(0L);
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
            AppLovinVastMediaView.this.handleMediaError("Video view error (" + yp.a(nhVar) + ")");
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
            n nVar = AppLovinVastMediaView.this.logger;
            if (n.a()) {
                AppLovinVastMediaView.this.logger.a(AppLovinVastMediaView.TAG, "Player state changed to state " + i11 + " and will play when ready: " + AppLovinVastMediaView.this.mediaPlayer.l());
            }
            if (i11 != 3) {
                if (i11 == 4) {
                    n nVar2 = AppLovinVastMediaView.this.logger;
                    if (n.a()) {
                        AppLovinVastMediaView.this.logger.a(AppLovinVastMediaView.TAG, "Video completed");
                    }
                    AppLovinVastMediaView.this.videoWasCompleted = true;
                    AppLovinVastMediaView.this.finishVideo();
                    if (AppLovinVastMediaView.this.replayIconContainer != null) {
                        zq.a(AppLovinVastMediaView.this.replayIconContainer, AppLovinVastMediaView.FADE_ANIMATION_DURATION_MILLIS, new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f22715a.c();
                            }
                        });
                        return;
                    } else {
                        AppLovinVastMediaView.this.showMediaImageView();
                        return;
                    }
                }
                return;
            }
            AppLovinVastMediaView.this.mediaPlayer.a(!AppLovinVastMediaView.this.isVideoMuted ? 1 : 0);
            AppLovinVastMediaView appLovinVastMediaView = AppLovinVastMediaView.this;
            appLovinVastMediaView.videoDurationMillis = appLovinVastMediaView.mediaPlayer.getDuration();
            AppLovinVastMediaView.this.vastAd.getAdEventTracker().b(TimeUnit.MILLISECONDS.toSeconds(AppLovinVastMediaView.this.videoDurationMillis), yp.e(AppLovinVastMediaView.this.sdk));
            n nVar3 = AppLovinVastMediaView.this.logger;
            if (n.a()) {
                AppLovinVastMediaView.this.logger.a(AppLovinVastMediaView.TAG, "MediaPlayer prepared: " + AppLovinVastMediaView.this.mediaPlayer);
            }
            AppLovinVastMediaView.this.countdownManager.b();
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
                AppLovinVastMediaView.this.videoView.c();
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
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements View.OnClickListener {
        private f() {
        }

        public /* synthetic */ f(AppLovinVastMediaView appLovinVastMediaView, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            AppLovinVastMediaView.this.videoWasCompleted = false;
            AppLovinVastMediaView.this.automaticResumeHandled.set(false);
            AppLovinVastMediaView.this.sdk.e().a(AppLovinVastMediaView.this.lifecycleCallbacksAdapter);
            AppLovinVastMediaView.this.maybeHandleResume();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == AppLovinVastMediaView.this.playPauseButtonImageView) {
                if (AppLovinVastMediaView.this.mediaPlayer.isPlaying()) {
                    AppLovinVastMediaView.this.isVideoPausedByUser = true;
                    AppLovinVastMediaView.this.maybeHandlePause();
                    return;
                } else {
                    AppLovinVastMediaView.this.isVideoPausedByUser = false;
                    AppLovinVastMediaView.this.maybeHandleResume();
                    return;
                }
            }
            if (view != AppLovinVastMediaView.this.muteButtonImageView) {
                if (view == AppLovinVastMediaView.this.replayIconContainer) {
                    zq.b(AppLovinVastMediaView.this.replayIconContainer, AppLovinVastMediaView.FADE_ANIMATION_DURATION_MILLIS, new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f22716a.a();
                        }
                    });
                }
            } else {
                boolean z11 = AppLovinVastMediaView.this.isVideoMuted;
                boolean z12 = !z11;
                AppLovinVastMediaView.this.isVideoMuted = z12;
                AppLovinVastMediaView.this.mediaPlayer.a(z11 ? 1.0f : 0.0f);
                AppLovinVastMediaView.this.populateMuteImage(z12);
            }
        }
    }

    public AppLovinVastMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, j jVar, Context context) {
        int iDpToPx;
        super(appLovinNativeAdImpl, jVar, context);
        Handler handler = new Handler(Looper.getMainLooper());
        this.countdownHandler = handler;
        this.countdownManager = new v4(handler, this.sdk);
        this.videoEndListenerNotified = new AtomicBoolean();
        this.mediaErrorHandled = new AtomicBoolean();
        this.initialOnAttachedToWindowHandled = new AtomicBoolean();
        this.automaticPauseHandled = new AtomicBoolean();
        this.automaticResumeHandled = new AtomicBoolean();
        this.isVideoMuted = true;
        this.lastVideoPositionFromPauseMillis = -1L;
        HashSet hashSet = new HashSet();
        this.videoProgressTrackers = hashSet;
        this.lifecycleCallbacksAdapter = new a();
        aq vastAd = appLovinNativeAdImpl.getVastAd();
        this.vastAd = vastAd;
        boolean zH0 = vastAd.H0();
        this.isVideoStream = zH0;
        if (yp.a(sj.f23014n1, jVar)) {
            checkCachedAdResourcesAsync(!zH0);
        }
        if (zH0) {
            AppLovinCommunicator.getInstance(context).subscribe(this, "video_caching_failed");
        }
        a aVar = null;
        if (vastAd.t1()) {
            this.industryIconImageView = gq.a(vastAd.n1().d(), context, jVar);
            int iDpToPx2 = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(sj.T4)).intValue());
            this.industryIconImageView.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx2, iDpToPx2, ((Integer) jVar.a(sj.V4)).intValue()));
            this.industryIconImageView.setOnClickListener(new c(this, aVar));
            addView(this.industryIconImageView);
        }
        if (((Boolean) jVar.a(sj.f22916a5)).booleanValue()) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.videoWidgetLinearLayout = linearLayout;
            linearLayout.setOrientation(0);
            this.videoWidgetLinearLayout.setBackgroundResource(R.drawable.applovin_rounded_black_background);
            this.videoWidgetLinearLayout.setAlpha(((Float) jVar.a(sj.Z4)).floatValue());
            ImageView imageView = new ImageView(context);
            this.playPauseButtonImageView = imageView;
            imageView.setClickable(true);
            f fVar = new f(this, aVar);
            this.playPauseButtonImageView.setOnClickListener(fVar);
            int iDpToPx3 = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(sj.X4)).intValue());
            this.playPauseButtonImageView.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx3, iDpToPx3));
            populatePlayPauseImage(false);
            this.videoWidgetLinearLayout.addView(this.playPauseButtonImageView);
            this.muteButtonImageView = new ImageView(context);
            if (populateMuteImage(this.isVideoMuted)) {
                iDpToPx = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(sj.W4)).intValue());
                this.muteButtonImageView.setClickable(true);
                this.muteButtonImageView.setOnClickListener(fVar);
                this.muteButtonImageView.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx, iDpToPx));
                this.videoWidgetLinearLayout.addView(this.muteButtonImageView);
            } else {
                iDpToPx = 0;
            }
            int iDpToPx4 = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(sj.Y4)).intValue());
            this.videoWidgetLinearLayout.setPadding(iDpToPx4, iDpToPx4, iDpToPx4, iDpToPx4);
            int i11 = iDpToPx4 * 2;
            this.videoWidgetLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx3 + iDpToPx + i11, Math.max(iDpToPx3, iDpToPx) + i11, MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START));
            addView(this.videoWidgetLinearLayout);
        }
        if (((Boolean) jVar.a(sj.f22923b5)).booleanValue()) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.replayIconContainer = frameLayout;
            frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            this.replayIconContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.replayIconContainer.setVisibility(4);
            this.replayIconContainer.setOnClickListener(new f(this, aVar));
            ImageView imageView2 = new ImageView(getContext());
            int iDpToPx5 = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(sj.f22931c5)).intValue());
            imageView2.setLayoutParams(new FrameLayout.LayoutParams(iDpToPx5, iDpToPx5, 17));
            imageView2.setImageResource(R.drawable.applovin_ic_replay_icon);
            imageView2.setAdjustViewBounds(true);
            imageView2.setMaxHeight(this.replayIconContainer.getHeight());
            imageView2.setMaxWidth(this.replayIconContainer.getWidth());
            this.replayIconContainer.addView(imageView2);
            addView(this.replayIconContainer);
        }
        ck ckVarA = new ck.b(getContext()).a();
        this.mediaPlayer = ckVarA;
        e eVar = new e(this, aVar);
        ckVarA.a((qh.c) eVar);
        ckVarA.a(0);
        com.applovin.exoplayer2.ui.e eVar2 = new com.applovin.exoplayer2.ui.e(getContext());
        this.videoView = eVar2;
        eVar2.c();
        eVar2.setControllerVisibilityListener(eVar);
        eVar2.setPlayer(ckVarA);
        eVar2.setOnTouchListener(new AppLovinTouchToClickListener(jVar, sj.G0, getContext(), new d(appLovinNativeAdImpl)));
        addView(eVar2);
        bringChildToFront(this.industryIconImageView);
        bringChildToFront(this.videoWidgetLinearLayout);
        prepareMediaPlayer();
        appLovinNativeAdImpl.setVideoView(eVar2);
        hashSet.addAll(vastAd.a(aq.d.VIDEO, lq.f20505a));
    }

    private void checkCachedAdResourcesAsync(boolean z11) {
        yp.a(z11, this.vastAd, this.sdk, j.l(), this);
    }

    private void checkCachedAdResourcesImmediately(boolean z11) {
        if (yp.a(z11, this.vastAd, this.sdk, getContext()).isEmpty()) {
            return;
        }
        handleUnavailableCachedResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishVideo() {
        maybeFireTrackers(aq.d.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        maybeHandlePause();
        this.sdk.e().b(this.lifecycleCallbacksAdapter);
        if (this.videoWasCompleted) {
            maybeFireRemainingCompletionTrackers();
            this.vastAd.getAdEventTracker().w();
        }
        if (this.videoEndListenerNotified.compareAndSet(false, true)) {
            this.sdk.i().trackVideoEnd(this.vastAd, TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.startTimeMillis), getVideoPercentViewed(), this.isVideoStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getVideoPercentViewed() {
        long currentPosition = this.mediaPlayer.getCurrentPosition();
        if (this.videoWasCompleted) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.videoDurationMillis) * 100.0f) : this.savedVideoPercentViewed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMediaError(String str) {
        if (n.a()) {
            this.logger.b(TAG, str);
        }
        if (!StringUtils.containsAtLeastOneSubstring(str, this.sdk.c(sj.f22946e5))) {
            maybeFireTrackers(aq.d.ERROR, fq.MEDIA_FILE_ERROR);
            this.vastAd.getAdEventTracker().b(str);
        } else if (n.a()) {
            this.logger.a(TAG, "Not firing trackers for media error: " + str);
        }
        if (!StringUtils.containsAtLeastOneSubstring(str, this.sdk.c(sj.T2))) {
            if (this.mediaErrorHandled.compareAndSet(false, true)) {
                this.sdk.E().a("handleVastVideoError", str, this.vastAd);
                finishVideo();
                showMediaImageView();
                return;
            }
            return;
        }
        if (n.a()) {
            this.logger.a(TAG, "Ignoring media error: " + str);
        }
    }

    private void handleUnavailableCachedResources() {
        if (n.a()) {
            this.logger.b(TAG, "Video failed due to unavailable resources");
        }
        finishVideo();
        showMediaImageView();
    }

    private void maybeFireRemainingCompletionTrackers() {
        if (getVideoPercentViewed() < this.vastAd.m0() || this.videoProgressTrackers.isEmpty()) {
            return;
        }
        if (n.a()) {
            this.logger.k(TAG, "Firing " + this.videoProgressTrackers.size() + " un-fired video progress trackers when video was completed.");
        }
        maybeFireTrackers(this.videoProgressTrackers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFireTrackers(aq.d dVar) {
        maybeFireTrackers(dVar, fq.UNSPECIFIED);
    }

    private void maybeFireTrackers(aq.d dVar, fq fqVar) {
        maybeFireTrackers(dVar, "", fqVar);
    }

    private void maybeFireTrackers(aq.d dVar, String str) {
        maybeFireTrackers(dVar, str, fq.UNSPECIFIED);
    }

    private void maybeFireTrackers(aq.d dVar, String str, fq fqVar) {
        maybeFireTrackers((Set<kq>) this.vastAd.a(dVar, str), fqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFireTrackers(Set<kq> set) {
        maybeFireTrackers(set, fq.UNSPECIFIED);
    }

    private void maybeFireTrackers(Set<kq> set, fq fqVar) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.mediaPlayer.getCurrentPosition());
        oq oqVarS1 = this.vastAd.s1();
        Uri uriC = oqVarS1 != null ? oqVarS1.c() : null;
        if (n.a()) {
            this.logger.a(TAG, "Firing " + set.size() + " tracker(s): " + set);
        }
        mq.a(set, seconds, uriC, fqVar, this.sdk);
    }

    private void maybeHandleOnAttachedToWindow() {
        if (this.initialOnAttachedToWindowHandled.compareAndSet(false, true)) {
            if (this.industryIconImageView != null && this.vastAd.t1()) {
                maybeFireTrackers(aq.d.INDUSTRY_ICON_IMPRESSION);
                this.industryIconImageView.setVisibility(0);
            }
            this.startTimeMillis = SystemClock.elapsedRealtime();
            maybeFireTrackers(aq.d.IMPRESSION);
            maybeFireTrackers(aq.d.VIDEO, "creativeView");
            this.vastAd.getAdEventTracker().g();
            this.vastAd.setHasShown(true);
            this.sdk.i().trackImpression(this.vastAd);
            this.viewActivity = r.a(zq.b(this));
            this.sdk.e().a(this.lifecycleCallbacksAdapter);
            this.mediaPlayer.a(true);
            this.countdownManager.a(COUNTDOWN_IDENTIFIER_PROGRESS_TRACKING, TimeUnit.SECONDS.toMillis(1L), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeHandlePause() {
        if (this.automaticPauseHandled.compareAndSet(false, true)) {
            maybeFireTrackers(aq.d.VIDEO, "pause");
            this.vastAd.getAdEventTracker().z();
            pauseVideo();
            populatePlayPauseImage(true);
            this.automaticResumeHandled.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeHandleResume() {
        if (this.automaticResumeHandled.compareAndSet(false, true)) {
            maybeFireTrackers(aq.d.VIDEO, CampaignEx.JSON_NATIVE_VIDEO_RESUME);
            this.vastAd.getAdEventTracker().A();
            if (this.lastVideoPositionFromPauseMillis >= 0) {
                if (n.a()) {
                    this.logger.a(TAG, "Resuming video at position " + this.lastVideoPositionFromPauseMillis);
                }
                this.mediaPlayer.a(true);
                this.countdownManager.b();
                this.lastVideoPositionFromPauseMillis = -1L;
            } else if (n.a()) {
                this.logger.a(TAG, "Invalid last video position, isVideoPlaying=" + this.mediaPlayer.isPlaying());
            }
            populatePlayPauseImage(false);
            this.automaticPauseHandled.set(false);
        }
    }

    private void pauseVideo() {
        if (n.a()) {
            this.logger.a(TAG, "Pausing video");
        }
        this.savedVideoPercentViewed = getVideoPercentViewed();
        this.lastVideoPositionFromPauseMillis = this.mediaPlayer.getCurrentPosition();
        this.mediaPlayer.a(false);
        this.countdownManager.c();
        if (n.a()) {
            this.logger.a(TAG, "Paused video at position " + this.lastVideoPositionFromPauseMillis + " ms");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean populateMuteImage(boolean z11) {
        if (this.muteButtonImageView == null) {
            return false;
        }
        if (z3.f()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) getContext().getDrawable(z11 ? R.drawable.applovin_ic_unmute_to_mute : R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.muteButtonImageView.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return true;
            }
        }
        Uri uriL = z11 ? this.vastAd.L() : this.vastAd.e0();
        if (uriL == null) {
            return false;
        }
        ImageViewUtils.setImageUri(this.muteButtonImageView, uriL, this.sdk);
        return true;
    }

    private void populatePlayPauseImage(boolean z11) {
        ImageView imageView = this.playPauseButtonImageView;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(z11 ? R.drawable.applovin_ic_play_icon : R.drawable.applovin_ic_pause_icon);
    }

    private void prepareMediaPlayer() {
        if (!yp.a(sj.f23014n1, this.sdk)) {
            checkCachedAdResourcesImmediately(!this.isVideoStream);
        }
        bi biVarA = new bi.b(new w5(getContext(), xp.a(getContext(), "com.applovin.sdk"))).a(td.a(this.vastAd.s0()));
        this.mediaPlayer.a(!this.isVideoMuted ? 1 : 0);
        this.mediaPlayer.a((be) biVarA);
        this.mediaPlayer.b();
        this.mediaPlayer.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMediaImageView() {
        if (this.imageView.getDrawable() == null) {
            return;
        }
        this.imageView.setVisibility(0);
        this.videoView.setVisibility(8);
        LinearLayout linearLayout = this.videoWidgetLinearLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView = this.industryIconImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinMediaView
    public void destroy() {
        finishVideo();
        ImageView imageView = this.industryIconImageView;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.playPauseButtonImageView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
        ImageView imageView3 = this.muteButtonImageView;
        if (imageView3 != null) {
            imageView3.setOnClickListener(null);
        }
        FrameLayout frameLayout = this.replayIconContainer;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(null);
        }
        this.videoView.setOnTouchListener(null);
        this.viewActivity = null;
        this.mediaPlayer.V();
        this.vastAd.getAdEventTracker().f();
        this.countdownManager.a();
        this.countdownHandler.removeCallbacksAndMessages(null);
        if (this.isVideoStream) {
            AppLovinCommunicator.getInstance(getContext()).unsubscribe(this, "video_caching_failed");
        }
        super.destroy();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return TAG;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeHandleOnAttachedToWindow();
        if (this.isVideoPausedByUser) {
            return;
        }
        maybeHandleResume();
    }

    @Override // com.applovin.impl.yp.b
    public void onCachedResourcesChecked(boolean z11) {
        if (z11) {
            return;
        }
        handleUnavailableCachedResources();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        maybeHandlePause();
        super.onDetachedFromWindow();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.vastAd.getAdIdNumber() && this.isVideoStream) {
                int i11 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i11 >= 200 && i11 < 300) || this.videoWasCompleted || this.mediaPlayer.isPlaying()) {
                    return;
                }
                handleMediaError("Video cache error during stream. ResponseCode=" + i11 + ", exception=" + string);
            }
        }
    }
}
