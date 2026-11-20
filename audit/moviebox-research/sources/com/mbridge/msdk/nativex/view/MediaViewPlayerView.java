package com.mbridge.msdk.nativex.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.VideoNativePlayer;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.videocommon.view.MyImageView;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MediaViewPlayerView extends LinearLayout implements VideoPlayerStatusListener {
    private static Handler F = new Handler();
    private String A;
    private String B;
    private CampaignEx C;
    private com.mbridge.msdk.nativex.listener.a D;
    private Timer E;
    private com.mbridge.msdk.videocommon.download.a G;
    private VideoNativePlayer H;
    private a I;
    private kn.b J;
    private com.iab.omid.library.mmadbridge.adsession.media.a K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f45894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f45895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f45898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f45899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f45900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f45901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f45902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f45903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f45904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile int f45905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f45906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f45907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextureView f45908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LinearLayout f45909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Surface f45910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ProgressBar f45911r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MyImageView f45912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f45913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f45914u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f45915v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView f45916w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private View f45917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private AnimationDrawable f45918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AlphaAnimation f45919z;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediaViewPlayerView f45927a;

        public a(MediaViewPlayerView mediaViewPlayerView) {
            this.f45927a = mediaViewPlayerView;
        }

        public void a() {
            try {
                MediaViewPlayerView mediaViewPlayerView = this.f45927a;
                if (mediaViewPlayerView == null || mediaViewPlayerView.f45903j) {
                    return;
                }
                ad.c("MediaViewPlayerView", "play end and display endcardView");
                this.f45927a.e();
            } catch (Exception e11) {
                ad.b("MediaViewPlayerView", e11.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements TextureView.SurfaceTextureListener {
        private b() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            try {
                MediaViewPlayerView.this.f45910q = new Surface(surfaceTexture);
                MediaViewPlayerView.this.f45900g = true;
                MediaViewPlayerView.this.f45902i = true;
                if (MediaViewPlayerView.this.f45897d) {
                    if (MediaViewPlayerView.this.f45901h) {
                        MediaViewPlayerView.this.f45896c = false;
                        MediaViewPlayerView.this.f45901h = false;
                    }
                    if (!MediaViewPlayerView.this.isComplete() && !MediaViewPlayerView.this.f45898e) {
                        MediaViewPlayerView.this.startOrPlayVideo();
                        return;
                    }
                    MediaViewPlayerView.this.e();
                    return;
                }
                if (MediaViewPlayerView.this.f45895b) {
                    if (MediaViewPlayerView.this.hasPrepare() && MediaViewPlayerView.this.isComplete()) {
                        MediaViewPlayerView.this.e();
                        return;
                    }
                    MediaViewPlayerView.this.startOrPlayVideo();
                    return;
                }
                if (MediaViewPlayerView.this.hasPrepare() && !MediaViewPlayerView.this.isComplete()) {
                    MediaViewPlayerView.this.startOrPlayVideo();
                    return;
                }
                MediaViewPlayerView.this.e();
            } catch (Exception e11) {
                ad.b("MediaViewPlayerView", e11.getMessage());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            try {
                if (MediaViewPlayerView.this.H != null && MediaViewPlayerView.this.H.isPlayIng()) {
                    MediaViewPlayerView.this.pause();
                }
                MediaViewPlayerView.this.f45896c = true;
                MediaViewPlayerView.this.f45900g = false;
            } catch (Throwable th2) {
                ad.b("MediaViewPlayerView", th2.getMessage());
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            ad.c("MediaViewPlayerView", "onSurfaceTextureSizeChanged ");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public MediaViewPlayerView(Context context) {
        super(context);
        this.f45894a = false;
        this.f45895b = false;
        this.f45896c = false;
        this.f45897d = false;
        this.f45898e = false;
        this.f45899f = false;
        this.f45900g = false;
        this.f45901h = true;
        this.f45902i = false;
        this.f45903j = true;
        this.f45904k = false;
        this.f45905l = -1;
        this.f45906m = true;
        this.f45907n = true;
        this.J = null;
        this.K = null;
        this.L = false;
        a();
    }

    public MediaViewPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45894a = false;
        this.f45895b = false;
        this.f45896c = false;
        this.f45897d = false;
        this.f45898e = false;
        this.f45899f = false;
        this.f45900g = false;
        this.f45901h = true;
        this.f45902i = false;
        this.f45903j = true;
        this.f45904k = false;
        this.f45905l = -1;
        this.f45906m = true;
        this.f45907n = true;
        this.J = null;
        this.K = null;
        this.L = false;
        a();
    }

    private void a() {
        try {
            c();
            b();
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    private void b() {
        VideoNativePlayer videoNativePlayer = new VideoNativePlayer();
        this.H = videoNativePlayer;
        videoNativePlayer.setSelfVideoFeedsPlayerListener(this);
    }

    private void c() {
        try {
            View viewInflate = LayoutInflater.from(getContext()).inflate(v.a(getContext(), "mbridge_nativex_playerview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
            if (viewInflate != null) {
                this.f45909p = (LinearLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_ll_loading", "id"));
                TextureView textureView = (TextureView) viewInflate.findViewById(v.a(getContext(), "mbridge_textureview", "id"));
                this.f45908o = textureView;
                textureView.setKeepScreenOn(true);
                this.f45908o.setSurfaceTextureListener(new b());
                this.f45911r = (ProgressBar) viewInflate.findViewById(v.a(getContext(), "mbridge_progress", "id"));
                this.f45912s = (MyImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_iv_playend_pic", "id"));
                this.f45913t = (ImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_iv_play", "id"));
                this.f45914u = (ImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_iv_pause", "id"));
                this.f45915v = (ImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_iv_sound", "id"));
                this.f45917x = viewInflate.findViewById(v.a(getContext(), "mbridge_view_cover", "id"));
                ImageView imageView = (ImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_iv_sound_animation", "id"));
                this.f45916w = imageView;
                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
                this.f45918y = animationDrawable;
                animationDrawable.start();
                d();
                addView(viewInflate, -1, -1);
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    private void d() {
        this.f45915v.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.MediaViewPlayerView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    if (MediaViewPlayerView.this.f45904k) {
                        MediaViewPlayerView.this.closeSound();
                        if (MediaViewPlayerView.this.D != null) {
                            MediaViewPlayerView.this.D.a();
                        }
                    } else {
                        MediaViewPlayerView.this.openSound();
                        if (MediaViewPlayerView.this.D != null) {
                            MediaViewPlayerView.this.D.b();
                        }
                    }
                } catch (Throwable th2) {
                    ad.b("MediaViewPlayerView", th2.getMessage());
                }
            }
        });
        this.f45914u.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.MediaViewPlayerView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    MediaViewPlayerView.this.pause();
                    MediaViewPlayerView.this.f45913t.setVisibility(0);
                    MediaViewPlayerView.this.i();
                    MediaViewPlayerView.this.k();
                    if (MediaViewPlayerView.this.D != null) {
                        MediaViewPlayerView.this.D.c();
                    }
                    MediaViewPlayerView.this.f45898e = true;
                } catch (Throwable th2) {
                    ad.a("MediaViewPlayerView", th2.getMessage(), th2);
                }
            }
        });
        this.f45913t.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.nativex.view.MediaViewPlayerView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaViewPlayerView.this.onClickPlayButton();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f45912s.setVisibility(0);
            this.f45913t.setVisibility(0);
            i();
            k();
            this.f45911r.setVisibility(8);
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    private void f() {
        try {
            this.f45912s.setVisibility(8);
            this.f45913t.setVisibility(8);
            j();
            showProgressView(this.f45907n);
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    private void g() {
        ImageView imageView;
        if (this.f45897d || (imageView = this.f45916w) == null || imageView.getVisibility() == 0 || !this.f45906m) {
            return;
        }
        this.f45916w.setVisibility(0);
    }

    public static /* synthetic */ void g(MediaViewPlayerView mediaViewPlayerView) {
        mediaViewPlayerView.l();
        mediaViewPlayerView.E = new Timer();
        mediaViewPlayerView.E.schedule(new TimerTask() { // from class: com.mbridge.msdk.nativex.view.MediaViewPlayerView.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                try {
                    MediaViewPlayerView.this.gonePauseView();
                } catch (Throwable th2) {
                    ad.a("MediaViewPlayerView", th2.getMessage(), th2);
                }
            }
        }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    private void h() {
        if (this.f45916w.getVisibility() == 0) {
            this.f45916w.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f45917x.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f45913t.getVisibility() != 0) {
            this.f45917x.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f45914u.setVisibility(8);
    }

    private void l() {
        try {
            Handler handler = F;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Timer timer = this.E;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    private String m() {
        String str;
        try {
            CampaignEx campaignEx = this.C;
            if (campaignEx == null) {
                return null;
            }
            try {
                if (this.G == null) {
                    if (campaignEx.getAdType() == 287 || this.C.getAdType() == 94) {
                        str = this.C.getRequestId() + this.C.getId() + this.C.getVideoUrlEncode();
                    } else {
                        str = this.C.getId() + this.C.getVideoUrlEncode() + this.C.getBidToken();
                    }
                    this.G = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.A, str);
                }
            } catch (Exception e11) {
                ad.b("MediaViewPlayerView", e11.getMessage());
            }
            com.mbridge.msdk.videocommon.download.a aVar = this.G;
            if (aVar != null && aVar.k() == 5) {
                String strH = this.G.h();
                if (new File(strH).exists()) {
                    return strH;
                }
            }
            String videoUrlEncode = this.C.getVideoUrlEncode();
            if (an.b(videoUrlEncode)) {
                return videoUrlEncode;
            }
        } catch (Exception e12) {
            ad.b("MediaViewPlayerView", e12.getMessage());
        }
        return null;
    }

    public void closeSound() {
        this.f45904k = false;
        try {
            if (this.H != null) {
                this.f45915v.setImageResource(v.a(getContext(), "mbridge_nativex_sound_close", "drawable"));
                this.H.closeSound();
            }
            try {
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.K;
                if (aVar != null) {
                    aVar.p(0.0f);
                }
            } catch (IllegalArgumentException e11) {
                ad.a("OMSDK", e11.getMessage());
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public boolean curIsFullScreen() {
        return this.f45897d;
    }

    public Campaign getCampaign() {
        return this.C;
    }

    public boolean getIsActiviePause() {
        return this.f45898e;
    }

    public void gonePauseView() {
        Handler handler = F;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.mbridge.msdk.nativex.view.MediaViewPlayerView.5
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        MediaViewPlayerView.this.k();
                        MediaViewPlayerView.this.j();
                    } catch (Exception e11) {
                        ad.b("MediaViewPlayerView", e11.getMessage());
                    }
                }
            });
        }
    }

    public boolean halfLoadingViewisVisible() {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            return videoNativePlayer != null && videoNativePlayer.loadingViewIsVisible();
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    public boolean hasPrepare() {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                return videoNativePlayer.hasPrepare();
            }
            return false;
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    public boolean initPlayerViewData(String str, CampaignEx campaignEx, boolean z11, VideoPlayerStatusListener videoPlayerStatusListener, com.mbridge.msdk.videocommon.download.a aVar, String str2) {
        try {
            if (TextUtils.isEmpty(str) || campaignEx == null) {
                return false;
            }
            this.B = str;
            this.f45895b = z11;
            this.C = campaignEx;
            this.G = aVar;
            this.A = str2;
            this.H.initParameter(campaignEx.getVideoUrlEncode(), true, this.f45903j, this.f45912s, videoPlayerStatusListener);
            try {
                CampaignEx campaignEx2 = this.C;
                if (campaignEx2 != null) {
                    String imageUrl = campaignEx2.getImageUrl();
                    if (!an.a(imageUrl) && getContext() != null) {
                        if (com.mbridge.msdk.foundation.same.c.b.a(getContext()).c(imageUrl)) {
                            Bitmap bitmapB = com.mbridge.msdk.foundation.same.c.b.a(c.m().c()).b(imageUrl);
                            MyImageView myImageView = this.f45912s;
                            if (myImageView != null && bitmapB != null) {
                                myImageView.setImageUrl(imageUrl);
                                this.f45912s.setImageBitmap(bitmapB);
                                this.f45912s.setVisibility(0);
                            }
                        } else {
                            com.mbridge.msdk.foundation.same.c.b.a(getContext()).a(imageUrl, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.nativex.view.MediaViewPlayerView.6
                                @Override // com.mbridge.msdk.foundation.same.c.c
                                public final void onFailedLoad(String str3, String str4) {
                                }

                                @Override // com.mbridge.msdk.foundation.same.c.c
                                public final void onSuccessLoad(Bitmap bitmap, String str3) {
                                    if (MediaViewPlayerView.this.f45912s == null || bitmap == null) {
                                        return;
                                    }
                                    MediaViewPlayerView.this.f45912s.setImageUrl(str3);
                                    MediaViewPlayerView.this.f45912s.setImageBitmap(bitmap);
                                }
                            });
                        }
                    }
                }
            } catch (Throwable th2) {
                ad.b("MediaViewPlayerView", th2.getMessage());
            }
            this.f45894a = true;
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
            this.f45894a = false;
        }
        return true;
    }

    public boolean isComplete() {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                return videoNativePlayer.isComplete();
            }
            return false;
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    public boolean isPlaying() {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                return videoNativePlayer.isPlaying();
            }
            return false;
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
            return false;
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
    }

    public void onClickPlayButton() {
        com.mbridge.msdk.nativex.listener.a aVar;
        try {
            f();
            j();
            setIsComplete(false);
            if (this.f45899f) {
                this.H.play();
            } else if (!hasPrepare() || this.f45896c) {
                ad.c("MediaViewPlayerView", "点击播放 playVideo()");
                this.H.replaySameSource(getContext(), this.B, this.f45910q);
            } else {
                ad.c("MediaViewPlayerView", "startOrPlayVideo() hasPrepare():" + hasPrepare() + " mIsNeedToRepeatPrepare:" + this.f45896c);
                startOrPlayVideo();
            }
            if (this.f45898e && (aVar = this.D) != null) {
                aVar.d();
            }
            this.f45898e = false;
        } catch (Throwable th2) {
            ad.a("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    public void onClickPlayerView() {
        ImageView imageView;
        try {
            MyImageView myImageView = this.f45912s;
            if ((myImageView == null || myImageView.getVisibility() != 0) && isPlaying() && (imageView = this.f45914u) != null) {
                if (imageView.getVisibility() == 0) {
                    gonePauseView();
                    l();
                    return;
                }
                AlphaAnimation alphaAnimation = this.f45919z;
                if (alphaAnimation != null) {
                    alphaAnimation.cancel();
                }
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                this.f45919z = alphaAnimation2;
                alphaAnimation2.setDuration(300L);
                this.f45919z.setInterpolator(new DecelerateInterpolator());
                this.f45919z.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.nativex.view.MediaViewPlayerView.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public final void onAnimationEnd(Animation animation) {
                        MediaViewPlayerView.this.f45914u.setVisibility(0);
                        MediaViewPlayerView.g(MediaViewPlayerView.this);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public final void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public final void onAnimationStart(Animation animation) {
                    }
                });
                i();
                this.f45917x.startAnimation(this.f45919z);
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        if (this.D != null && !TextUtils.isEmpty(this.B)) {
            this.D.b(this.B);
        }
        a aVar = this.I;
        if (aVar != null) {
            aVar.a();
            return;
        }
        try {
            if (this.f45903j) {
                return;
            }
            this.f45896c = true;
            e();
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(String str) {
        try {
            this.f45896c = true;
            e();
            if (this.L) {
                return;
            }
            this.H.play(getContext(), this.B, this.f45910q);
            this.L = true;
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i11, int i12) {
        try {
            f();
            g();
            this.f45898e = false;
            this.f45896c = false;
            this.f45905l = i11;
        } catch (Throwable th2) {
            ad.a("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i11, int i12) {
        try {
            ProgressBar progressBar = this.f45911r;
            if (progressBar == null || progressBar.getVisibility() != 0) {
                return;
            }
            if (i12 > 0) {
                this.f45911r.setMax(i12);
            }
            if (i11 >= 0) {
                this.f45911r.setProgress(i11 + 1);
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
        try {
            this.f45896c = true;
            try {
                if (!URLUtil.isNetworkUrl(this.B)) {
                    String videoUrlEncode = this.C.getVideoUrlEncode();
                    if (an.b(videoUrlEncode)) {
                        this.B = videoUrlEncode;
                    }
                }
            } catch (Throwable th2) {
                ad.b("MediaViewPlayerView", th2.getMessage());
            }
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i11) {
        if (this.D == null || TextUtils.isEmpty(this.B)) {
            return;
        }
        this.D.a(this.B);
    }

    public void openSound() {
        this.f45904k = true;
        try {
            if (this.H != null) {
                this.f45915v.setImageResource(v.a(getContext(), "mbridge_nativex_sound_open", "drawable"));
                this.H.openSound();
            }
            try {
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.K;
                if (aVar != null) {
                    aVar.p(1.0f);
                    return;
                }
                return;
            } catch (IllegalArgumentException e11) {
                ad.a("OMSDK", e11.getMessage());
                return;
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
        ad.b("MediaViewPlayerView", th2.getMessage());
    }

    public void pause() {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                videoNativePlayer.pause();
                this.f45899f = true;
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.K;
            if (aVar != null) {
                aVar.j();
            }
            h();
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void playVideo() {
        com.iab.omid.library.mmadbridge.adsession.media.a aVar;
        try {
            if (this.f45894a && this.H != null) {
                if (!this.f45900g) {
                    e();
                    return;
                }
                if ((!TextUtils.isEmpty(this.B) && this.B.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) || this.B.startsWith("https")) {
                    this.B = m();
                }
                f();
                this.H.play(getContext(), this.B, this.f45910q);
                if ((this.f45899f || this.f45898e) && (aVar = this.K) != null) {
                    this.f45899f = false;
                    aVar.l();
                }
                if (this.f45904k) {
                    this.H.openSound();
                } else {
                    this.H.closeSound();
                }
                this.f45896c = false;
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void registerView(kn.b bVar) {
        this.J = bVar;
        if (bVar != null) {
            bVar.d(this);
            LinearLayout linearLayout = this.f45909p;
            FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
            bVar.a(linearLayout, friendlyObstructionPurpose, null);
            bVar.a(this.f45911r, friendlyObstructionPurpose, null);
            MyImageView myImageView = this.f45912s;
            FriendlyObstructionPurpose friendlyObstructionPurpose2 = FriendlyObstructionPurpose.VIDEO_CONTROLS;
            bVar.a(myImageView, friendlyObstructionPurpose2, null);
            bVar.a(this.f45913t, friendlyObstructionPurpose2, null);
            bVar.a(this.f45914u, friendlyObstructionPurpose2, null);
            bVar.a(this.f45915v, friendlyObstructionPurpose, null);
        }
    }

    public void release() {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                videoNativePlayer.releasePlayer();
                this.H = null;
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void setAllowLoopPlay(boolean z11) {
        this.f45903j = z11;
    }

    public void setEnterFullScreen() {
        try {
            ad.c("MediaViewPlayerView", "setEnterFullScreen");
            this.f45897d = true;
            this.f45901h = true;
            this.f45915v.setVisibility(0);
            h();
        } catch (Throwable th2) {
            ad.a("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    public void setExitFullScreen() {
        try {
            this.f45897d = false;
            this.f45896c = false;
            this.f45915v.setVisibility(8);
            g();
            f();
        } catch (Throwable th2) {
            ad.a("MediaViewPlayerView", th2.getMessage(), th2);
        }
    }

    public void setIsActivePause(boolean z11) {
        this.f45898e = z11;
    }

    public void setIsComplete(boolean z11) {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                videoNativePlayer.setIsComplete(z11);
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void setIsFrontDesk(boolean z11) {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                videoNativePlayer.setIsFrontDesk(z11);
            }
        } catch (Throwable th2) {
            ad.b("MediaViewPlayerView", th2.getMessage());
        }
    }

    public void setMediaViewPlayListener(a aVar) {
        this.I = aVar;
    }

    public void setOnMediaViewPlayerViewListener(com.mbridge.msdk.nativex.listener.a aVar) {
        this.D = aVar;
    }

    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.K = aVar;
    }

    public void showPlayView() {
        this.f45913t.setVisibility(0);
    }

    public void showProgressView(boolean z11) {
        this.f45907n = z11;
        ProgressBar progressBar = this.f45911r;
        if (progressBar != null) {
            progressBar.setVisibility(z11 ? 0 : 4);
        }
    }

    public void showSoundIndicator(boolean z11) {
        this.f45906m = z11;
        if (z11) {
            g();
        } else {
            h();
        }
    }

    public void startOrPlayVideo() {
        com.iab.omid.library.mmadbridge.adsession.media.a aVar;
        try {
            if (!this.f45900g) {
                e();
                return;
            }
            if (!hasPrepare()) {
                playVideo();
                return;
            }
            try {
                if (this.H == null) {
                    return;
                }
                f();
                if (this.f45902i) {
                    this.H.start(this.f45910q);
                    this.f45902i = false;
                } else {
                    this.H.start();
                }
                if ((this.f45899f || this.f45898e) && (aVar = this.K) != null) {
                    this.f45899f = false;
                    aVar.l();
                }
            } catch (Throwable th2) {
                ad.a("MediaViewPlayerView", th2.getMessage(), th2);
            }
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    public void stop() {
        try {
            VideoNativePlayer videoNativePlayer = this.H;
            if (videoNativePlayer != null) {
                videoNativePlayer.stop();
            }
            h();
        } catch (Exception e11) {
            ad.b("MediaViewPlayerView", e11.getMessage());
        }
    }

    public void unregisterView() {
        kn.b bVar = this.J;
        if (bVar != null) {
            bVar.e();
        }
    }
}
