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
public class StyledPlayerView extends FrameLayout {
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f35029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final AspectRatioFrameLayout f35030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final View f35031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f35032d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f35033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final ImageView f35034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final SubtitleView f35035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final View f35036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final TextView f35037j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final StyledPlayerControlView f35038k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final FrameLayout f35039l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final FrameLayout f35040m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public n2 f35041n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f35042o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public b f35043p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public StyledPlayerControlView.m f35044q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f35045r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public Drawable f35046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f35047t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f35048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public CharSequence f35049v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f35050w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f35051x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f35052y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f35053z;

    /* JADX INFO: compiled from: source.java */
    public final class a implements n2.d, View.OnLayoutChangeListener, View.OnClickListener, StyledPlayerControlView.m, StyledPlayerControlView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j3.b f35054a = new j3.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f35055b;

        public a() {
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.m
        public void f(int i11) {
            StyledPlayerView.this.H();
            if (StyledPlayerView.this.f35043p != null) {
                StyledPlayerView.this.f35043p.a(i11);
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onAvailableCommandsChanged(n2.b bVar) {
            p2.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StyledPlayerView.this.E();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onCues(List list) {
            p2.d(this, list);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onCues(vh.f fVar) {
            if (StyledPlayerView.this.f35035h != null) {
                StyledPlayerView.this.f35035h.setCues(fVar.f78854a);
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
            StyledPlayerView.q((TextureView) view, StyledPlayerView.this.A);
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
            StyledPlayerView.this.G();
            StyledPlayerView.this.I();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlaybackParametersChanged(m2 m2Var) {
            p2.q(this, m2Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onPlaybackStateChanged(int i11) {
            StyledPlayerView.this.G();
            StyledPlayerView.this.J();
            StyledPlayerView.this.I();
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
            if (StyledPlayerView.this.w() && StyledPlayerView.this.f35052y) {
                StyledPlayerView.this.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onRenderedFirstFrame() {
            if (StyledPlayerView.this.f35031c != null) {
                StyledPlayerView.this.f35031c.setVisibility(4);
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
            n2 n2Var = (n2) com.google.android.exoplayer2.util.a.e(StyledPlayerView.this.f35041n);
            j3 currentTimeline = n2Var.getCurrentTimeline();
            if (currentTimeline.u()) {
                this.f35055b = null;
            } else if (n2Var.getCurrentTracks().c()) {
                Object obj = this.f35055b;
                if (obj != null) {
                    int iF = currentTimeline.f(obj);
                    if (iF != -1) {
                        if (n2Var.u() == currentTimeline.j(iF, this.f35054a).f33364c) {
                            return;
                        }
                    }
                    this.f35055b = null;
                }
            } else {
                this.f35055b = currentTimeline.k(n2Var.getCurrentPeriodIndex(), this.f35054a, true).f33363b;
            }
            StyledPlayerView.this.K(false);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar) {
            StyledPlayerView.this.F();
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            p2.L(this, f11);
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.d
        public void p(boolean z11) {
            StyledPlayerView.h(StyledPlayerView.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
    }

    public StyledPlayerView(Context context) {
        this(context, null);
    }

    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerView(Context context, @Nullable AttributeSet attributeSet, int i11) {
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
        this.f35029a = aVar;
        if (isInEditMode()) {
            this.f35030b = null;
            this.f35031c = null;
            this.f35032d = null;
            this.f35033f = false;
            this.f35034g = null;
            this.f35035h = null;
            this.f35036i = null;
            this.f35037j = null;
            this.f35038k = null;
            this.f35039l = null;
            this.f35040m = null;
            ImageView imageView = new ImageView(context);
            if (com.google.android.exoplayer2.util.o0.f35608a >= 23) {
                t(getResources(), imageView);
            } else {
                s(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i17 = R$layout.exo_styled_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.StyledPlayerView, i11, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.StyledPlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(R$styleable.StyledPlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.StyledPlayerView_player_layout_id, i17);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.StyledPlayerView_default_artwork, 0);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_use_controller, true);
                int i18 = typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerView_surface_type, 1);
                int i19 = typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerView_resize_mode, 0);
                int i21 = typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerView_show_timeout, 5000);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_hide_on_touch, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.StyledPlayerView_show_buffering, 0);
                this.f35048u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_keep_content_on_player_reset, this.f35048u);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerView_hide_during_ads, true);
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
        this.f35030b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            B(aspectRatioFrameLayout, i13);
        }
        View viewFindViewById = findViewById(R$id.exo_shutter);
        this.f35031c = viewFindViewById;
        if (viewFindViewById != null && z14) {
            viewFindViewById.setBackgroundColor(i15);
        }
        if (aspectRatioFrameLayout == null || i14 == 0) {
            this.f35032d = null;
            z17 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i14 != 2) {
                if (i14 == 3) {
                    try {
                        int i22 = SphericalGLSurfaceView.f35812n;
                        this.f35032d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                        z18 = true;
                    } catch (Exception e11) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e11);
                    }
                } else if (i14 != 4) {
                    this.f35032d = new SurfaceView(context);
                } else {
                    try {
                        int i23 = VideoDecoderGLSurfaceView.f35693b;
                        this.f35032d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    } catch (Exception e12) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e12);
                    }
                }
                this.f35032d.setLayoutParams(layoutParams);
                this.f35032d.setOnClickListener(aVar);
                this.f35032d.setClickable(false);
                aspectRatioFrameLayout.addView(this.f35032d, 0);
                z17 = z18;
            } else {
                this.f35032d = new TextureView(context);
            }
            z18 = false;
            this.f35032d.setLayoutParams(layoutParams);
            this.f35032d.setOnClickListener(aVar);
            this.f35032d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f35032d, 0);
            z17 = z18;
        }
        this.f35033f = z17;
        this.f35039l = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f35040m = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f35034g = imageView2;
        this.f35045r = z15 && imageView2 != null;
        if (i16 != 0) {
            this.f35046s = z2.a.getDrawable(getContext(), i16);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f35035h = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(R$id.exo_buffering);
        this.f35036i = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f35047t = integer;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f35037j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) findViewById(R$id.exo_controller);
        View viewFindViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (styledPlayerControlView != null) {
            this.f35038k = styledPlayerControlView;
        } else if (viewFindViewById3 != null) {
            StyledPlayerControlView styledPlayerControlView2 = new StyledPlayerControlView(context, null, 0, attributeSet);
            this.f35038k = styledPlayerControlView2;
            styledPlayerControlView2.setId(R$id.exo_controller);
            styledPlayerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(styledPlayerControlView2, iIndexOfChild);
        } else {
            this.f35038k = null;
        }
        StyledPlayerControlView styledPlayerControlView3 = this.f35038k;
        this.f35050w = styledPlayerControlView3 != null ? i12 : 0;
        this.f35053z = z13;
        this.f35051x = z11;
        this.f35052y = z12;
        this.f35042o = z16 && styledPlayerControlView3 != null;
        if (styledPlayerControlView3 != null) {
            styledPlayerControlView3.hideImmediately();
            this.f35038k.addVisibilityListener(aVar);
        }
        if (z16) {
            setClickable(true);
        }
        H();
    }

    private boolean A(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                y(this.f35030b, intrinsicWidth / intrinsicHeight);
                this.f35034g.setImageDrawable(drawable);
                this.f35034g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void B(AspectRatioFrameLayout aspectRatioFrameLayout, int i11) {
        aspectRatioFrameLayout.setResizeMode(i11);
    }

    private boolean C() {
        n2 n2Var = this.f35041n;
        if (n2Var == null) {
            return true;
        }
        int playbackState = n2Var.getPlaybackState();
        return this.f35051x && !this.f35041n.getCurrentTimeline().u() && (playbackState == 1 || playbackState == 4 || !((n2) com.google.android.exoplayer2.util.a.e(this.f35041n)).getPlayWhenReady());
    }

    private void D(boolean z11) {
        if (M()) {
            this.f35038k.setShowTimeoutMs(z11 ? 0 : this.f35050w);
            this.f35038k.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (!M() || this.f35041n == null) {
            return;
        }
        if (!this.f35038k.isFullyVisible()) {
            x(true);
        } else if (this.f35053z) {
            this.f35038k.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        n2 n2Var = this.f35041n;
        com.google.android.exoplayer2.video.y yVarQ = n2Var != null ? n2Var.q() : com.google.android.exoplayer2.video.y.f35861f;
        int i11 = yVarQ.f35863a;
        int i12 = yVarQ.f35864b;
        int i13 = yVarQ.f35865c;
        float f11 = (i12 == 0 || i11 == 0) ? 0.0f : (i11 * yVarQ.f35866d) / i12;
        View view = this.f35032d;
        if (view instanceof TextureView) {
            if (f11 > 0.0f && (i13 == 90 || i13 == 270)) {
                f11 = 1.0f / f11;
            }
            if (this.A != 0) {
                view.removeOnLayoutChangeListener(this.f35029a);
            }
            this.A = i13;
            if (i13 != 0) {
                this.f35032d.addOnLayoutChangeListener(this.f35029a);
            }
            q((TextureView) this.f35032d, this.A);
        }
        y(this.f35030b, this.f35033f ? 0.0f : f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    public void G() {
        boolean z11;
        if (this.f35036i != null) {
            n2 n2Var = this.f35041n;
            if (n2Var == null || n2Var.getPlaybackState() != 2) {
                z11 = false;
            } else {
                int i11 = this.f35047t;
                z11 = true;
                if (i11 != 2 && (i11 != 1 || !this.f35041n.getPlayWhenReady())) {
                    z11 = false;
                }
            }
            this.f35036i.setVisibility(z11 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        StyledPlayerControlView styledPlayerControlView = this.f35038k;
        if (styledPlayerControlView == null || !this.f35042o) {
            setContentDescription(null);
        } else if (styledPlayerControlView.isFullyVisible()) {
            setContentDescription(this.f35053z ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (w() && this.f35052y) {
            hideController();
        } else {
            x(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        TextView textView = this.f35037j;
        if (textView != null) {
            CharSequence charSequence = this.f35049v;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f35037j.setVisibility(0);
            } else {
                n2 n2Var = this.f35041n;
                if (n2Var != null) {
                    n2Var.c();
                }
                this.f35037j.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z11) {
        n2 n2Var = this.f35041n;
        if (n2Var == null || n2Var.getCurrentTracks().c()) {
            if (this.f35048u) {
                return;
            }
            u();
            r();
            return;
        }
        if (z11 && !this.f35048u) {
            r();
        }
        if (n2Var.getCurrentTracks().d(2)) {
            u();
            return;
        }
        r();
        if (L() && (z(n2Var.y()) || A(this.f35046s))) {
            return;
        }
        u();
    }

    private boolean L() {
        if (!this.f35045r) {
            return false;
        }
        com.google.android.exoplayer2.util.a.i(this.f35034g);
        return true;
    }

    private boolean M() {
        if (!this.f35042o) {
            return false;
        }
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        return true;
    }

    public static /* synthetic */ c h(StyledPlayerView styledPlayerView) {
        styledPlayerView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TextureView textureView, int i11) {
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

    private void r() {
        View view = this.f35031c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void s(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    public static void switchTargetView(n2 n2Var, @Nullable StyledPlayerView styledPlayerView, @Nullable StyledPlayerView styledPlayerView2) {
        if (styledPlayerView == styledPlayerView2) {
            return;
        }
        if (styledPlayerView2 != null) {
            styledPlayerView2.setPlayer(n2Var);
        }
        if (styledPlayerView != null) {
            styledPlayerView.setPlayer(null);
        }
    }

    @RequiresApi(23)
    private static void t(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
    }

    private void u() {
        ImageView imageView = this.f35034g;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f35034g.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    private boolean v(int i11) {
        return i11 == 19 || i11 == 270 || i11 == 22 || i11 == 271 || i11 == 20 || i11 == 269 || i11 == 21 || i11 == 268 || i11 == 23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        n2 n2Var = this.f35041n;
        return n2Var != null && n2Var.isPlayingAd() && this.f35041n.getPlayWhenReady();
    }

    private void x(boolean z11) {
        if (!(w() && this.f35052y) && M()) {
            boolean z12 = this.f35038k.isFullyVisible() && this.f35038k.getShowTimeoutMs() <= 0;
            boolean zC = C();
            if (z11 || z12 || zC) {
                D(zC);
            }
        }
    }

    private boolean z(z1 z1Var) {
        byte[] bArr = z1Var.f35939k;
        if (bArr == null) {
            return false;
        }
        return A(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        n2 n2Var = this.f35041n;
        if (n2Var != null && n2Var.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zV = v(keyEvent.getKeyCode());
        if (zV && M() && !this.f35038k.isFullyVisible()) {
            x(true);
            return true;
        }
        if (dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            x(true);
            return true;
        }
        if (zV && M()) {
            x(true);
        }
        return false;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return M() && this.f35038k.dispatchMediaKeyEvent(keyEvent);
    }

    public List<com.google.android.exoplayer2.ui.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f35040m;
        if (frameLayout != null) {
            arrayList.add(new com.google.android.exoplayer2.ui.a(frameLayout, 4, "Transparent overlay does not impact viewability"));
        }
        StyledPlayerControlView styledPlayerControlView = this.f35038k;
        if (styledPlayerControlView != null) {
            arrayList.add(new com.google.android.exoplayer2.ui.a(styledPlayerControlView, 1));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) com.google.android.exoplayer2.util.a.j(this.f35039l, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f35051x;
    }

    public boolean getControllerHideOnTouch() {
        return this.f35053z;
    }

    public int getControllerShowTimeoutMs() {
        return this.f35050w;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f35046s;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f35040m;
    }

    @Nullable
    public n2 getPlayer() {
        return this.f35041n;
    }

    public int getResizeMode() {
        com.google.android.exoplayer2.util.a.i(this.f35030b);
        return this.f35030b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f35035h;
    }

    public boolean getUseArtwork() {
        return this.f35045r;
    }

    public boolean getUseController() {
        return this.f35042o;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f35032d;
    }

    public void hideController() {
        StyledPlayerControlView styledPlayerControlView = this.f35038k;
        if (styledPlayerControlView != null) {
            styledPlayerControlView.hide();
        }
    }

    public boolean isControllerFullyVisible() {
        StyledPlayerControlView styledPlayerControlView = this.f35038k;
        return styledPlayerControlView != null && styledPlayerControlView.isFullyVisible();
    }

    public void onPause() {
        View view = this.f35032d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.f35032d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!M() || this.f35041n == null) {
            return false;
        }
        x(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        E();
        return super.performClick();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        com.google.android.exoplayer2.util.a.i(this.f35030b);
        this.f35030b.setAspectRatioListener(bVar);
    }

    public void setControllerAutoShow(boolean z11) {
        this.f35051x = z11;
    }

    public void setControllerHideDuringAds(boolean z11) {
        this.f35052y = z11;
    }

    public void setControllerHideOnTouch(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35053z = z11;
        H();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable StyledPlayerControlView.d dVar) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35050w = i11;
        if (this.f35038k.isFullyVisible()) {
            showController();
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(@Nullable StyledPlayerControlView.m mVar) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        StyledPlayerControlView.m mVar2 = this.f35044q;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            this.f35038k.removeVisibilityListener(mVar2);
        }
        this.f35044q = mVar;
        if (mVar != null) {
            this.f35038k.addVisibilityListener(mVar);
        }
        setControllerVisibilityListener((b) null);
    }

    public void setControllerVisibilityListener(@Nullable b bVar) {
        setControllerVisibilityListener((StyledPlayerControlView.m) null);
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        com.google.android.exoplayer2.util.a.g(this.f35037j != null);
        this.f35049v = charSequence;
        J();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f35046s != drawable) {
            this.f35046s = drawable;
            K(false);
        }
    }

    public void setErrorMessageProvider(@Nullable com.google.android.exoplayer2.util.k<? super PlaybackException> kVar) {
        if (kVar != null) {
            J();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setFullscreenButtonClickListener(@Nullable c cVar) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setOnFullScreenModeChangedListener(this.f35029a);
    }

    public void setKeepContentOnPlayerReset(boolean z11) {
        if (this.f35048u != z11) {
            this.f35048u = z11;
            K(false);
        }
    }

    public void setPlayer(@Nullable n2 n2Var) {
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(n2Var == null || n2Var.l() == Looper.getMainLooper());
        n2 n2Var2 = this.f35041n;
        if (n2Var2 == n2Var) {
            return;
        }
        if (n2Var2 != null) {
            n2Var2.C(this.f35029a);
            View view = this.f35032d;
            if (view instanceof TextureView) {
                n2Var2.clearVideoTextureView((TextureView) view);
            } else if (view instanceof SurfaceView) {
                n2Var2.clearVideoSurfaceView((SurfaceView) view);
            }
        }
        SubtitleView subtitleView = this.f35035h;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f35041n = n2Var;
        if (M()) {
            this.f35038k.setPlayer(n2Var);
        }
        G();
        J();
        K(true);
        if (n2Var == null) {
            hideController();
            return;
        }
        if (n2Var.i(27)) {
            View view2 = this.f35032d;
            if (view2 instanceof TextureView) {
                n2Var.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                n2Var.setVideoSurfaceView((SurfaceView) view2);
            }
            F();
        }
        if (this.f35035h != null && n2Var.i(28)) {
            this.f35035h.setCues(n2Var.h().f78854a);
        }
        n2Var.E(this.f35029a);
        x(false);
    }

    public void setRepeatToggleModes(int i11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setRepeatToggleModes(i11);
    }

    public void setResizeMode(int i11) {
        com.google.android.exoplayer2.util.a.i(this.f35030b);
        this.f35030b.setResizeMode(i11);
    }

    public void setShowBuffering(int i11) {
        if (this.f35047t != i11) {
            this.f35047t = i11;
            G();
        }
    }

    public void setShowFastForwardButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowFastForwardButton(z11);
    }

    public void setShowMultiWindowTimeBar(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowMultiWindowTimeBar(z11);
    }

    public void setShowNextButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowNextButton(z11);
    }

    public void setShowPreviousButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowPreviousButton(z11);
    }

    public void setShowRewindButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowRewindButton(z11);
    }

    public void setShowShuffleButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowShuffleButton(z11);
    }

    public void setShowSubtitleButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowSubtitleButton(z11);
    }

    public void setShowVrButton(boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f35038k);
        this.f35038k.setShowVrButton(z11);
    }

    public void setShutterBackgroundColor(int i11) {
        View view = this.f35031c;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    public void setUseArtwork(boolean z11) {
        com.google.android.exoplayer2.util.a.g((z11 && this.f35034g == null) ? false : true);
        if (this.f35045r != z11) {
            this.f35045r = z11;
            K(false);
        }
    }

    public void setUseController(boolean z11) {
        boolean z12 = true;
        com.google.android.exoplayer2.util.a.g((z11 && this.f35038k == null) ? false : true);
        if (!z11 && !hasOnClickListeners()) {
            z12 = false;
        }
        setClickable(z12);
        if (this.f35042o == z11) {
            return;
        }
        this.f35042o = z11;
        if (M()) {
            this.f35038k.setPlayer(this.f35041n);
        } else {
            StyledPlayerControlView styledPlayerControlView = this.f35038k;
            if (styledPlayerControlView != null) {
                styledPlayerControlView.hide();
                this.f35038k.setPlayer(null);
            }
        }
        H();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        View view = this.f35032d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i11);
        }
    }

    public void showController() {
        D(C());
    }

    public void y(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f11) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f11);
        }
    }
}
