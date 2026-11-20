package com.google.android.exoplayer2.ui;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.z1;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class PlayerView extends FrameLayout {
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f34929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final AspectRatioFrameLayout f34930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final View f34931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f34932d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f34933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final ImageView f34934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final SubtitleView f34935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final View f34936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final TextView f34937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final PlayerControlView f34938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final FrameLayout f34939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final FrameLayout f34940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public n2 f34941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f34942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public PlayerControlView.e f34943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f34944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public Drawable f34945r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f34946s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f34947t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public CharSequence f34948u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f34949v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f34950w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f34951x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f34952y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f34953z;

    /* JADX INFO: compiled from: source.java */
    public final class a implements n2.d, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j3.b f34954a = new j3.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f34955b;

        public a() {
        }

        @Override // com.google.android.exoplayer2.ui.PlayerControlView.e
        public void f(int i11) {
            PlayerView.this.F();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onAvailableCommandsChanged(n2.b bVar) {
            p2.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView.this.C();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onCues(List list) {
            p2.d(this, list);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onCues(vh.f fVar) {
            if (PlayerView.this.f34935h != null) {
                PlayerView.this.f34935h.setCues(fVar.f78854a);
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onDeviceInfoChanged(com.google.android.exoplayer2.n nVar) {
            p2.f(this, nVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
            p2.g(this, i11, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onEvents(n2 n2Var, n2.c cVar) {
            p2.h(this, n2Var, cVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z11) {
            p2.i(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onIsPlayingChanged(boolean z11) {
            p2.j(this, z11);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            PlayerView.o((TextureView) view, PlayerView.this.f34953z);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onLoadingChanged(boolean z11) {
            p2.k(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onMediaItemTransition(u1 u1Var, int i11) {
            p2.m(this, u1Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onMediaMetadataChanged(z1 z1Var) {
            p2.n(this, z1Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onMetadata(Metadata metadata) {
            p2.o(this, metadata);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            PlayerView.this.E();
            PlayerView.this.G();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlaybackParametersChanged(m2 m2Var) {
            p2.q(this, m2Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlaybackStateChanged(int i11) {
            PlayerView.this.E();
            PlayerView.this.H();
            PlayerView.this.G();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            p2.s(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            p2.t(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            p2.u(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlayerStateChanged(boolean z11, int i11) {
            p2.v(this, z11, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPositionDiscontinuity(int i11) {
            p2.x(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPositionDiscontinuity(n2.e eVar, n2.e eVar2, int i11) {
            if (PlayerView.this.u() && PlayerView.this.f34951x) {
                PlayerView.this.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onRenderedFirstFrame() {
            if (PlayerView.this.f34931c != null) {
                PlayerView.this.f34931c.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onRepeatModeChanged(int i11) {
            p2.A(this, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onSeekProcessed() {
            p2.D(this);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z11) {
            p2.E(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
            p2.F(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            p2.G(this, i11, i12);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onTimelineChanged(j3 j3Var, int i11) {
            p2.H(this, j3Var, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onTrackSelectionParametersChanged(fi.z zVar) {
            p2.I(this, zVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onTracksChanged(o3 o3Var) {
            n2 n2Var = (n2) com.google.android.exoplayer2.util.a.e(PlayerView.this.f34941n);
            j3 currentTimeline = n2Var.getCurrentTimeline();
            if (currentTimeline.u()) {
                this.f34955b = null;
            } else if (n2Var.getCurrentTracks().c()) {
                Object obj = this.f34955b;
                if (obj != null) {
                    int iF = currentTimeline.f(obj);
                    if (iF != -1) {
                        if (n2Var.u() == currentTimeline.j(iF, this.f34954a).f33364c) {
                            return;
                        }
                    }
                    this.f34955b = null;
                }
            } else {
                this.f34955b = currentTimeline.k(n2Var.getCurrentPeriodIndex(), this.f34954a, true).f33363b;
            }
            PlayerView.this.I(false);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar) {
            PlayerView.this.D();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            p2.L(this, f11);
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        int i12;
        boolean z11;
        int i13;
        int integer;
        boolean z12;
        boolean z13;
        int i14;
        boolean z14;
        int i15;
        boolean z15;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        super(context, attributeSet, i11);
        a aVar = new a();
        this.f34929a = aVar;
        if (isInEditMode()) {
            this.f34930b = null;
            this.f34931c = null;
            this.f34932d = null;
            this.f34933f = false;
            this.f34934g = null;
            this.f34935h = null;
            this.f34936i = null;
            this.f34937j = null;
            this.f34938k = null;
            this.f34939l = null;
            this.f34940m = null;
            ImageView imageView = new ImageView(context);
            if (com.google.android.exoplayer2.util.o0.f35608a >= 23) {
                r(getResources(), imageView);
            } else {
                q(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i17 = R$layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PlayerView, i11, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.PlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(R$styleable.PlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i17);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                int i18 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                int i19 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                int i21 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.PlayerView_show_buffering, 0);
                this.f34947t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.f34947t);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                z13 = z22;
                z11 = z23;
                i13 = i19;
                z16 = z21;
                i16 = resourceId2;
                z15 = z19;
                i15 = color;
                z14 = zHasValue;
                i14 = i18;
                i17 = resourceId;
                i12 = i21;
                z12 = z24;
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            i12 = 5000;
            z11 = true;
            i13 = 0;
            integer = 0;
            z12 = true;
            z13 = true;
            i14 = 1;
            z14 = false;
            i15 = 0;
            z15 = true;
            i16 = 0;
            z16 = true;
        }
        LayoutInflater.from(context).inflate(i17, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f34930b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            z(aspectRatioFrameLayout, i13);
        }
        View viewFindViewById = findViewById(R$id.exo_shutter);
        this.f34931c = viewFindViewById;
        if (viewFindViewById != null && z14) {
            viewFindViewById.setBackgroundColor(i15);
        }
        if (aspectRatioFrameLayout == null || i14 == 0) {
            this.f34932d = null;
            z17 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i14 != 2) {
                if (i14 == 3) {
                    try {
                        int i22 = SphericalGLSurfaceView.f35812n;
                        this.f34932d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                        z18 = true;
                    } catch (Exception e11) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e11);
                    }
                } else if (i14 != 4) {
                    this.f34932d = new SurfaceView(context);
                } else {
                    try {
                        int i23 = VideoDecoderGLSurfaceView.f35693b;
                        this.f34932d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    } catch (Exception e12) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e12);
                    }
                }
                this.f34932d.setLayoutParams(layoutParams);
                this.f34932d.setOnClickListener(aVar);
                this.f34932d.setClickable(false);
                aspectRatioFrameLayout.addView(this.f34932d, 0);
                z17 = z18;
            } else {
                this.f34932d = new TextureView(context);
            }
            z18 = false;
            this.f34932d.setLayoutParams(layoutParams);
            this.f34932d.setOnClickListener(aVar);
            this.f34932d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f34932d, 0);
            z17 = z18;
        }
        this.f34933f = z17;
        this.f34939l = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f34940m = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f34934g = imageView2;
        this.f34944q = z15 && imageView2 != null;
        if (i16 != 0) {
            this.f34945r = z2.a.getDrawable(getContext(), i16);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f34935h = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(R$id.exo_buffering);
        this.f34936i = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f34946s = integer;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f34937j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R$id.exo_controller);
        View viewFindViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f34938k = playerControlView;
        } else if (viewFindViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f34938k = playerControlView2;
            playerControlView2.setId(R$id.exo_controller);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            this.f34938k = null;
        }
        PlayerControlView playerControlView3 = this.f34938k;
        this.f34949v = playerControlView3 != null ? i12 : 0;
        this.f34952y = z13;
        this.f34950w = z11;
        this.f34951x = z12;
        this.f34942o = z16 && playerControlView3 != null;
        if (playerControlView3 != null) {
            playerControlView3.hide();
            this.f34938k.addVisibilityListener(aVar);
        }
        if (z16) {
            setClickable(true);
        }
        F();
    }

    public static void o(TextureView textureView, int i11) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i11 != 0) {
            float f11 = width / 2.0f;
            float f12 = height / 2.0f;
            matrix.postRotate(i11, f11, f12);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f11, f12);
        }
        textureView.setTransform(matrix);
    }

    public static void q(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    @RequiresApi(23)
    public static void r(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
    }

    public static void switchTargetView(n2 n2Var, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView == playerView2) {
            return;
        }
        if (playerView2 != null) {
            playerView2.setPlayer(n2Var);
        }
        if (playerView != null) {
            playerView.setPlayer(null);
        }
    }

    public static void z(AspectRatioFrameLayout aspectRatioFrameLayout, int i11) {
        aspectRatioFrameLayout.setResizeMode(i11);
    }

    public final boolean A() {
        n2 n2Var = this.f34941n;
        if (n2Var == null) {
            return true;
        }
        int playbackState = n2Var.getPlaybackState();
        return this.f34950w && (playbackState == 1 || playbackState == 4 || !this.f34941n.getPlayWhenReady());
    }

    public final void B(boolean z11) {
        if (K()) {
            this.f34938k.setShowTimeoutMs(z11 ? 0 : this.f34949v);
            this.f34938k.show();
        }
    }

    public final void C() {
        if (!K() || this.f34941n == null) {
            return;
        }
        if (!this.f34938k.isVisible()) {
            v(true);
        } else if (this.f34952y) {
            this.f34938k.hide();
        }
    }

    public final void D() {
        n2 n2Var = this.f34941n;
        com.google.android.exoplayer2.video.y yVarQ = n2Var != null ? n2Var.q() : com.google.android.exoplayer2.video.y.f35861f;
        int i11 = yVarQ.f35863a;
        int i12 = yVarQ.f35864b;
        int i13 = yVarQ.f35865c;
        float f11 = (i12 == 0 || i11 == 0) ? 0.0f : (i11 * yVarQ.f35866d) / i12;
        View view = this.f34932d;
        if (view instanceof TextureView) {
            if (f11 > 0.0f && (i13 == 90 || i13 == 270)) {
                f11 = 1.0f / f11;
            }
            if (this.f34953z != 0) {
                view.removeOnLayoutChangeListener(this.f34929a);
            }
            this.f34953z = i13;
            if (i13 != 0) {
                this.f34932d.addOnLayoutChangeListener(this.f34929a);
            }
            o((TextureView) this.f34932d, this.f34953z);
        }
        w(this.f34930b, this.f34933f ? 0.0f : f11);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    public final void E() {
        boolean z11;
        if (this.f34936i != null) {
            n2 n2Var = this.f34941n;
            if (n2Var == null || n2Var.getPlaybackState() != 2) {
                z11 = false;
            } else {
                int i11 = this.f34946s;
                z11 = true;
                if (i11 != 2 && (i11 != 1 || !this.f34941n.getPlayWhenReady())) {
                    z11 = false;
                }
            }
            this.f34936i.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void F() {
        PlayerControlView playerControlView = this.f34938k;
        if (playerControlView == null || !this.f34942o) {
            setContentDescription(null);
        } else if (playerControlView.getVisibility() == 0) {
            setContentDescription(this.f34952y ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    public final void G() {
        if (u() && this.f34951x) {
            hideController();
        } else {
            v(false);
        }
    }

    public final void H() {
        TextView textView = this.f34937j;
        if (textView != null) {
            CharSequence charSequence = this.f34948u;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f34937j.setVisibility(0);
            } else {
                n2 n2Var = this.f34941n;
                if (n2Var != null) {
                    n2Var.c();
                }
                this.f34937j.setVisibility(8);
            }
        }
    }

    public final void I(boolean z11) {
        n2 n2Var = this.f34941n;
        if (n2Var == null || !n2Var.i(30) || n2Var.getCurrentTracks().c()) {
            if (this.f34947t) {
                return;
            }
            s();
            p();
            return;
        }
        if (z11 && !this.f34947t) {
            p();
        }
        if (n2Var.getCurrentTracks().d(2)) {
            s();
            return;
        }
        p();
        if (J() && (x(n2Var.y()) || y(this.f34945r))) {
            return;
        }
        s();
    }

    public final boolean J() {
        if (!this.f34944q) {
            return false;
        }
        com.google.android.exoplayer2.util.a.i(this.f34934g);
        return true;
    }

    public final boolean K() {
        if (!this.f34942o) {
            return false;
        }
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        n2 n2Var = this.f34941n;
        if (n2Var != null && n2Var.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zT = t(keyEvent.getKeyCode());
        if (zT && K() && !this.f34938k.isVisible()) {
            v(true);
            return true;
        }
        if (dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            v(true);
            return true;
        }
        if (zT && K()) {
            v(true);
        }
        return false;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return K() && this.f34938k.dispatchMediaKeyEvent(keyEvent);
    }

    public List<com.google.android.exoplayer2.ui.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f34940m;
        if (frameLayout != null) {
            arrayList.add(new com.google.android.exoplayer2.ui.a(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.f34938k;
        if (playerControlView != null) {
            arrayList.add(new com.google.android.exoplayer2.ui.a(playerControlView, 1));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) com.google.android.exoplayer2.util.a.j(this.f34939l, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f34950w;
    }

    public boolean getControllerHideOnTouch() {
        return this.f34952y;
    }

    public int getControllerShowTimeoutMs() {
        return this.f34949v;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f34945r;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f34940m;
    }

    @Nullable
    public n2 getPlayer() {
        return this.f34941n;
    }

    public int getResizeMode() {
        com.google.android.exoplayer2.util.a.i(this.f34930b);
        return this.f34930b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f34935h;
    }

    public boolean getUseArtwork() {
        return this.f34944q;
    }

    public boolean getUseController() {
        return this.f34942o;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f34932d;
    }

    public void hideController() {
        PlayerControlView playerControlView = this.f34938k;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    public boolean isControllerVisible() {
        PlayerControlView playerControlView = this.f34938k;
        return playerControlView != null && playerControlView.isVisible();
    }

    public void onPause() {
        View view = this.f34932d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.f34932d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!K() || this.f34941n == null) {
            return false;
        }
        v(true);
        return true;
    }

    public final void p() {
        View view = this.f34931c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        C();
        return super.performClick();
    }

    public final void s() {
        ImageView imageView = this.f34934g;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f34934g.setVisibility(4);
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        com.google.android.exoplayer2.util.a.i(this.f34930b);
        this.f34930b.setAspectRatioListener(bVar);
    }

    public void setControllerAutoShow(boolean z11) {
        this.f34950w = z11;
    }

    public void setControllerHideDuringAds(boolean z11) {
        this.f34951x = z11;
    }

    public void setControllerHideOnTouch(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34952y = z11;
        F();
    }

    public void setControllerShowTimeoutMs(int i11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34949v = i11;
        if (this.f34938k.isVisible()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView.e eVar) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        PlayerControlView.e eVar2 = this.f34943p;
        if (eVar2 == eVar) {
            return;
        }
        if (eVar2 != null) {
            this.f34938k.removeVisibilityListener(eVar2);
        }
        this.f34943p = eVar;
        if (eVar != null) {
            this.f34938k.addVisibilityListener(eVar);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        com.google.android.exoplayer2.util.a.g(this.f34937j != null);
        this.f34948u = charSequence;
        H();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f34945r != drawable) {
            this.f34945r = drawable;
            I(false);
        }
    }

    public void setErrorMessageProvider(@Nullable com.google.android.exoplayer2.util.k<? super PlaybackException> kVar) {
        if (kVar != null) {
            H();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setKeepContentOnPlayerReset(boolean z11) {
        if (this.f34947t != z11) {
            this.f34947t = z11;
            I(false);
        }
    }

    public void setPlayer(@Nullable n2 n2Var) {
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(n2Var == null || n2Var.l() == Looper.getMainLooper());
        n2 n2Var2 = this.f34941n;
        if (n2Var2 == n2Var) {
            return;
        }
        if (n2Var2 != null) {
            n2Var2.C(this.f34929a);
            if (n2Var2.i(27)) {
                View view = this.f34932d;
                if (view instanceof TextureView) {
                    n2Var2.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    n2Var2.clearVideoSurfaceView((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f34935h;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f34941n = n2Var;
        if (K()) {
            this.f34938k.setPlayer(n2Var);
        }
        E();
        H();
        I(true);
        if (n2Var == null) {
            hideController();
            return;
        }
        if (n2Var.i(27)) {
            View view2 = this.f34932d;
            if (view2 instanceof TextureView) {
                n2Var.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                n2Var.setVideoSurfaceView((SurfaceView) view2);
            }
            D();
        }
        if (this.f34935h != null && n2Var.i(28)) {
            this.f34935h.setCues(n2Var.h().f78854a);
        }
        n2Var.E(this.f34929a);
        v(false);
    }

    public void setRepeatToggleModes(int i11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setRepeatToggleModes(i11);
    }

    public void setResizeMode(int i11) {
        com.google.android.exoplayer2.util.a.i(this.f34930b);
        this.f34930b.setResizeMode(i11);
    }

    public void setShowBuffering(int i11) {
        if (this.f34946s != i11) {
            this.f34946s = i11;
            E();
        }
    }

    public void setShowFastForwardButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setShowFastForwardButton(z11);
    }

    public void setShowMultiWindowTimeBar(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setShowMultiWindowTimeBar(z11);
    }

    public void setShowNextButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setShowNextButton(z11);
    }

    public void setShowPreviousButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setShowPreviousButton(z11);
    }

    public void setShowRewindButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setShowRewindButton(z11);
    }

    public void setShowShuffleButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f34938k);
        this.f34938k.setShowShuffleButton(z11);
    }

    public void setShutterBackgroundColor(int i11) {
        View view = this.f34931c;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    public void setUseArtwork(boolean z11) {
        com.google.android.exoplayer2.util.a.g((z11 && this.f34934g == null) ? false : true);
        if (this.f34944q != z11) {
            this.f34944q = z11;
            I(false);
        }
    }

    public void setUseController(boolean z11) {
        boolean z12 = true;
        com.google.android.exoplayer2.util.a.g((z11 && this.f34938k == null) ? false : true);
        if (!z11 && !hasOnClickListeners()) {
            z12 = false;
        }
        setClickable(z12);
        if (this.f34942o == z11) {
            return;
        }
        this.f34942o = z11;
        if (K()) {
            this.f34938k.setPlayer(this.f34941n);
        } else {
            PlayerControlView playerControlView = this.f34938k;
            if (playerControlView != null) {
                playerControlView.hide();
                this.f34938k.setPlayer(null);
            }
        }
        F();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        View view = this.f34932d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i11);
        }
    }

    public void showController() {
        B(A());
    }

    @SuppressLint({"InlinedApi"})
    public final boolean t(int i11) {
        return i11 == 19 || i11 == 270 || i11 == 22 || i11 == 271 || i11 == 20 || i11 == 269 || i11 == 21 || i11 == 268 || i11 == 23;
    }

    public final boolean u() {
        n2 n2Var = this.f34941n;
        return n2Var != null && n2Var.isPlayingAd() && this.f34941n.getPlayWhenReady();
    }

    public final void v(boolean z11) {
        if (!(u() && this.f34951x) && K()) {
            boolean z12 = this.f34938k.isVisible() && this.f34938k.getShowTimeoutMs() <= 0;
            boolean zA = A();
            if (z11 || z12 || zA) {
                B(zA);
            }
        }
    }

    public void w(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f11) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f11);
        }
    }

    public final boolean x(z1 z1Var) {
        byte[] bArr = z1Var.f35939k;
        if (bArr == null) {
            return false;
        }
        return y(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public final boolean y(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                w(this.f34930b, intrinsicWidth / intrinsicHeight);
                this.f34934g.setImageDrawable(drawable);
                this.f34934g.setVisibility(0);
                return true;
            }
        }
        return false;
    }
}
