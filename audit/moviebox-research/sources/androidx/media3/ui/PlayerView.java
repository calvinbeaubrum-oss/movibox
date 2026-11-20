package androidx.media3.ui;

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
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.t0;
import androidx.media3.exoplayer.video.VideoDecoderGLSurfaceView;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class PlayerView extends FrameLayout {
    public static final int ARTWORK_DISPLAY_MODE_FILL = 2;
    public static final int ARTWORK_DISPLAY_MODE_FIT = 1;
    public static final int ARTWORK_DISPLAY_MODE_OFF = 0;
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    public int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final AspectRatioFrameLayout f11951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final View f11952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f11953d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f11954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final ImageView f11955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final SubtitleView f11956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final View f11957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final TextView f11958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final PlayerControlView f11959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final FrameLayout f11960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final FrameLayout f11961m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.h0 f11962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f11963o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public c f11964p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public PlayerControlView.m f11965q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f11966r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public Drawable f11967s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f11968t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11969u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public CharSequence f11970v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11971w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11972x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11973y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11974z;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(34)
    public static class a {
        public static void a(SurfaceView surfaceView) {
            surfaceView.setSurfaceLifecycle(2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b implements androidx.media3.common.h0.d, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.m, PlayerControlView.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.m0.b f11975a = new androidx.media3.common.m0.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f11976b;

        public b() {
        }

        @Override // androidx.media3.ui.PlayerControlView.m
        public void f(int i11) {
            PlayerView.this.H();
            if (PlayerView.this.f11964p != null) {
                PlayerView.this.f11964p.a(i11);
            }
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onAvailableCommandsChanged(androidx.media3.common.h0.b bVar) {
            androidx.media3.common.i0.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView.this.E();
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onCues(List list) {
            androidx.media3.common.i0.d(this, list);
        }

        @Override // androidx.media3.common.h0.d
        public void onCues(y3.b bVar) {
            if (PlayerView.this.f11956h != null) {
                PlayerView.this.f11956h.setCues(bVar.f81147a);
            }
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onDeviceInfoChanged(androidx.media3.common.o oVar) {
            androidx.media3.common.i0.f(this, oVar);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
            androidx.media3.common.i0.g(this, i11, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onEvents(androidx.media3.common.h0 h0Var, androidx.media3.common.h0.c cVar) {
            androidx.media3.common.i0.h(this, h0Var, cVar);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onIsLoadingChanged(boolean z11) {
            androidx.media3.common.i0.i(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onIsPlayingChanged(boolean z11) {
            androidx.media3.common.i0.j(this, z11);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            PlayerView.q((TextureView) view, PlayerView.this.A);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onLoadingChanged(boolean z11) {
            androidx.media3.common.i0.k(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onMediaItemTransition(androidx.media3.common.b0 b0Var, int i11) {
            androidx.media3.common.i0.m(this, b0Var, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onMediaMetadataChanged(androidx.media3.common.d0 d0Var) {
            androidx.media3.common.i0.n(this, d0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onMetadata(Metadata metadata) {
            androidx.media3.common.i0.o(this, metadata);
        }

        @Override // androidx.media3.common.h0.d
        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            PlayerView.this.G();
            PlayerView.this.I();
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPlaybackParametersChanged(androidx.media3.common.g0 g0Var) {
            androidx.media3.common.i0.q(this, g0Var);
        }

        @Override // androidx.media3.common.h0.d
        public void onPlaybackStateChanged(int i11) {
            PlayerView.this.G();
            PlayerView.this.J();
            PlayerView.this.I();
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
            androidx.media3.common.i0.s(this, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            androidx.media3.common.i0.t(this, playbackException);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            androidx.media3.common.i0.u(this, playbackException);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPlayerStateChanged(boolean z11, int i11) {
            androidx.media3.common.i0.v(this, z11, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPositionDiscontinuity(int i11) {
            androidx.media3.common.i0.x(this, i11);
        }

        @Override // androidx.media3.common.h0.d
        public void onPositionDiscontinuity(androidx.media3.common.h0.e eVar, androidx.media3.common.h0.e eVar2, int i11) {
            if (PlayerView.this.w() && PlayerView.this.f11973y) {
                PlayerView.this.hideController();
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onRenderedFirstFrame() {
            if (PlayerView.this.f11952c != null) {
                PlayerView.this.f11952c.setVisibility(4);
            }
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onRepeatModeChanged(int i11) {
            androidx.media3.common.i0.A(this, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z11) {
            androidx.media3.common.i0.D(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
            androidx.media3.common.i0.E(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
            androidx.media3.common.i0.F(this, i11, i12);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onTimelineChanged(androidx.media3.common.m0 m0Var, int i11) {
            androidx.media3.common.i0.G(this, m0Var, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onTrackSelectionParametersChanged(androidx.media3.common.p0 p0Var) {
            androidx.media3.common.i0.H(this, p0Var);
        }

        @Override // androidx.media3.common.h0.d
        public void onTracksChanged(androidx.media3.common.q0 q0Var) {
            androidx.media3.common.h0 h0Var = (androidx.media3.common.h0) z3.a.e(PlayerView.this.f11962n);
            androidx.media3.common.m0 currentTimeline = h0Var.i(17) ? h0Var.getCurrentTimeline() : androidx.media3.common.m0.f9282a;
            if (currentTimeline.q()) {
                this.f11976b = null;
            } else if (!h0Var.i(30) || h0Var.getCurrentTracks().b()) {
                Object obj = this.f11976b;
                if (obj != null) {
                    int iB = currentTimeline.b(obj);
                    if (iB != -1) {
                        if (h0Var.u() == currentTimeline.f(iB, this.f11975a).f9295c) {
                            return;
                        }
                    }
                    this.f11976b = null;
                }
            } else {
                this.f11976b = currentTimeline.g(h0Var.getCurrentPeriodIndex(), this.f11975a, true).f9294b;
            }
            PlayerView.this.K(false);
        }

        @Override // androidx.media3.common.h0.d
        public void onVideoSizeChanged(t0 t0Var) {
            if (t0Var.equals(t0.f9443e) || PlayerView.this.f11962n == null || PlayerView.this.f11962n.getPlaybackState() == 1) {
                return;
            }
            PlayerView.this.F();
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            androidx.media3.common.i0.K(this, f11);
        }

        @Override // androidx.media3.ui.PlayerControlView.d
        public void p(boolean z11) {
            PlayerView.h(PlayerView.this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
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
        boolean z12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z13;
        int i17;
        boolean z14;
        int i18;
        boolean z15;
        boolean z16;
        boolean z17;
        super(context, attributeSet, i11);
        b bVar = new b();
        this.f11950a = bVar;
        if (isInEditMode()) {
            this.f11951b = null;
            this.f11952c = null;
            this.f11953d = null;
            this.f11954f = false;
            this.f11955g = null;
            this.f11956h = null;
            this.f11957i = null;
            this.f11958j = null;
            this.f11959k = null;
            this.f11960l = null;
            this.f11961m = null;
            ImageView imageView = new ImageView(context);
            if (u0.f81838a >= 23) {
                t(context, getResources(), imageView);
            } else {
                s(context, getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i19 = R$layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PlayerView, i11, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.PlayerView_shutter_background_color);
                int color = typedArrayObtainStyledAttributes.getColor(R$styleable.PlayerView_shutter_background_color, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i19);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                int i21 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_artwork_display_mode, 1);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                int i22 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                int i23 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                int i24 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.PlayerView_show_buffering, 0);
                this.f11969u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.f11969u);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                z11 = z21;
                i14 = integer;
                z16 = z22;
                i19 = resourceId;
                i12 = i24;
                i13 = i22;
                z15 = z19;
                i18 = i21;
                i17 = color;
                i16 = resourceId2;
                z14 = z18;
                z13 = zHasValue;
                i15 = i23;
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            i12 = 5000;
            z11 = true;
            z12 = true;
            i13 = 1;
            i14 = 0;
            i15 = 0;
            i16 = 0;
            z13 = false;
            i17 = 0;
            z14 = true;
            i18 = 1;
            z15 = true;
            z16 = true;
        }
        LayoutInflater.from(context).inflate(i19, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f11951b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            B(aspectRatioFrameLayout, i15);
        }
        View viewFindViewById = findViewById(R$id.exo_shutter);
        this.f11952c = viewFindViewById;
        if (viewFindViewById != null && z13) {
            viewFindViewById.setBackgroundColor(i17);
        }
        if (aspectRatioFrameLayout == null || i13 == 0) {
            this.f11953d = null;
            z17 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i13 != 2) {
                if (i13 == 3) {
                    try {
                        int i25 = SphericalGLSurfaceView.f11695n;
                        this.f11953d = (View) SphericalGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                        z17 = true;
                    } catch (Exception e11) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e11);
                    }
                } else if (i13 != 4) {
                    SurfaceView surfaceView = new SurfaceView(context);
                    if (u0.f81838a >= 34) {
                        a.a(surfaceView);
                    }
                    this.f11953d = surfaceView;
                } else {
                    try {
                        int i26 = VideoDecoderGLSurfaceView.f11532b;
                        this.f11953d = (View) VideoDecoderGLSurfaceView.class.getConstructor(Context.class).newInstance(context);
                    } catch (Exception e12) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e12);
                    }
                }
                this.f11953d.setLayoutParams(layoutParams);
                this.f11953d.setOnClickListener(bVar);
                this.f11953d.setClickable(false);
                aspectRatioFrameLayout.addView(this.f11953d, 0);
            } else {
                this.f11953d = new TextureView(context);
            }
            z17 = false;
            this.f11953d.setLayoutParams(layoutParams);
            this.f11953d.setOnClickListener(bVar);
            this.f11953d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f11953d, 0);
        }
        this.f11954f = z17;
        this.f11960l = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f11961m = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f11955g = imageView2;
        this.f11966r = (!z14 || i18 == 0 || imageView2 == null) ? 0 : i18;
        if (i16 != 0) {
            this.f11967s = z2.a.getDrawable(getContext(), i16);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f11956h = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(R$id.exo_buffering);
        this.f11957i = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f11968t = i14;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f11958j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(R$id.exo_controller);
        View viewFindViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f11959k = playerControlView;
        } else if (viewFindViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f11959k = playerControlView2;
            playerControlView2.setId(R$id.exo_controller);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            this.f11959k = null;
        }
        PlayerControlView playerControlView3 = this.f11959k;
        this.f11971w = playerControlView3 != null ? i12 : 0;
        this.f11974z = z12;
        this.f11972x = z11;
        this.f11973y = z16;
        this.f11963o = z15 && playerControlView3 != null;
        if (playerControlView3 != null) {
            playerControlView3.hideImmediately();
            this.f11959k.addVisibilityListener(bVar);
        }
        if (z15) {
            setClickable(true);
        }
        H();
    }

    public static void B(AspectRatioFrameLayout aspectRatioFrameLayout, int i11) {
        aspectRatioFrameLayout.setResizeMode(i11);
    }

    public static /* synthetic */ d h(PlayerView playerView) {
        playerView.getClass();
        return null;
    }

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

    public static void s(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(u0.a0(context, resources, R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    public static void switchTargetView(androidx.media3.common.h0 h0Var, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView == playerView2) {
            return;
        }
        if (playerView2 != null) {
            playerView2.setPlayer(h0Var);
        }
        if (playerView != null) {
            playerView.setPlayer(null);
        }
    }

    @RequiresApi(23)
    public static void t(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(u0.a0(context, resources, R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
    }

    public final boolean A(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float width = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.f11966r == 2) {
                    width = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                y(this.f11951b, width);
                this.f11955g.setScaleType(scaleType);
                this.f11955g.setImageDrawable(drawable);
                this.f11955g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean C() {
        androidx.media3.common.h0 h0Var = this.f11962n;
        if (h0Var == null) {
            return true;
        }
        int playbackState = h0Var.getPlaybackState();
        return this.f11972x && !(this.f11962n.i(17) && this.f11962n.getCurrentTimeline().q()) && (playbackState == 1 || playbackState == 4 || !((androidx.media3.common.h0) z3.a.e(this.f11962n)).getPlayWhenReady());
    }

    public final void D(boolean z11) {
        if (M()) {
            this.f11959k.setShowTimeoutMs(z11 ? 0 : this.f11971w);
            this.f11959k.show();
        }
    }

    public final void E() {
        if (!M() || this.f11962n == null) {
            return;
        }
        if (!this.f11959k.isFullyVisible()) {
            x(true);
        } else if (this.f11974z) {
            this.f11959k.hide();
        }
    }

    public final void F() {
        androidx.media3.common.h0 h0Var = this.f11962n;
        t0 t0VarQ = h0Var != null ? h0Var.q() : t0.f9443e;
        int i11 = t0VarQ.f9449a;
        int i12 = t0VarQ.f9450b;
        int i13 = t0VarQ.f9451c;
        float f11 = (i12 == 0 || i11 == 0) ? 0.0f : (i11 * t0VarQ.f9452d) / i12;
        View view = this.f11953d;
        if (view instanceof TextureView) {
            if (f11 > 0.0f && (i13 == 90 || i13 == 270)) {
                f11 = 1.0f / f11;
            }
            if (this.A != 0) {
                view.removeOnLayoutChangeListener(this.f11950a);
            }
            this.A = i13;
            if (i13 != 0) {
                this.f11953d.addOnLayoutChangeListener(this.f11950a);
            }
            q((TextureView) this.f11953d, this.A);
        }
        y(this.f11951b, this.f11954f ? 0.0f : f11);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    public final void G() {
        boolean z11;
        if (this.f11957i != null) {
            androidx.media3.common.h0 h0Var = this.f11962n;
            if (h0Var == null || h0Var.getPlaybackState() != 2) {
                z11 = false;
            } else {
                int i11 = this.f11968t;
                z11 = true;
                if (i11 != 2 && (i11 != 1 || !this.f11962n.getPlayWhenReady())) {
                    z11 = false;
                }
            }
            this.f11957i.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void H() {
        PlayerControlView playerControlView = this.f11959k;
        if (playerControlView == null || !this.f11963o) {
            setContentDescription(null);
        } else if (playerControlView.isFullyVisible()) {
            setContentDescription(this.f11974z ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    public final void I() {
        if (w() && this.f11973y) {
            hideController();
        } else {
            x(false);
        }
    }

    public final void J() {
        TextView textView = this.f11958j;
        if (textView != null) {
            CharSequence charSequence = this.f11970v;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f11958j.setVisibility(0);
            } else {
                androidx.media3.common.h0 h0Var = this.f11962n;
                if (h0Var != null) {
                    h0Var.c();
                }
                this.f11958j.setVisibility(8);
            }
        }
    }

    public final void K(boolean z11) {
        androidx.media3.common.h0 h0Var = this.f11962n;
        if (h0Var == null || !h0Var.i(30) || h0Var.getCurrentTracks().b()) {
            if (this.f11969u) {
                return;
            }
            u();
            r();
            return;
        }
        if (z11 && !this.f11969u) {
            r();
        }
        if (h0Var.getCurrentTracks().c(2)) {
            u();
            return;
        }
        r();
        if (L() && (z(h0Var) || A(this.f11967s))) {
            return;
        }
        u();
    }

    public final boolean L() {
        if (this.f11966r == 0) {
            return false;
        }
        z3.a.i(this.f11955g);
        return true;
    }

    public final boolean M() {
        if (!this.f11963o) {
            return false;
        }
        z3.a.i(this.f11959k);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        androidx.media3.common.h0 h0Var = this.f11962n;
        if (h0Var != null && h0Var.i(16) && this.f11962n.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zV = v(keyEvent.getKeyCode());
        if (zV && M() && !this.f11959k.isFullyVisible()) {
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
        return M() && this.f11959k.dispatchMediaKeyEvent(keyEvent);
    }

    public List<androidx.media3.common.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f11961m;
        if (frameLayout != null) {
            arrayList.add(new androidx.media3.common.a.C0087a(frameLayout, 4).b("Transparent overlay does not impact viewability").a());
        }
        PlayerControlView playerControlView = this.f11959k;
        if (playerControlView != null) {
            arrayList.add(new androidx.media3.common.a.C0087a(playerControlView, 1).a());
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) z3.a.j(this.f11960l, "exo_ad_overlay must be present for ad playback");
    }

    public int getArtworkDisplayMode() {
        return this.f11966r;
    }

    public boolean getControllerAutoShow() {
        return this.f11972x;
    }

    public boolean getControllerHideOnTouch() {
        return this.f11974z;
    }

    public int getControllerShowTimeoutMs() {
        return this.f11971w;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f11967s;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f11961m;
    }

    @Nullable
    public androidx.media3.common.h0 getPlayer() {
        return this.f11962n;
    }

    public int getResizeMode() {
        z3.a.i(this.f11951b);
        return this.f11951b.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f11956h;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.f11966r != 0;
    }

    public boolean getUseController() {
        return this.f11963o;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f11953d;
    }

    public void hideController() {
        PlayerControlView playerControlView = this.f11959k;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    public boolean isControllerFullyVisible() {
        PlayerControlView playerControlView = this.f11959k;
        return playerControlView != null && playerControlView.isFullyVisible();
    }

    public void onPause() {
        View view = this.f11953d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.f11953d;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!M() || this.f11962n == null) {
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

    public final void r() {
        View view = this.f11952c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setArtworkDisplayMode(int i11) {
        z3.a.g(i11 == 0 || this.f11955g != null);
        if (this.f11966r != i11) {
            this.f11966r = i11;
            K(false);
        }
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        z3.a.i(this.f11951b);
        this.f11951b.setAspectRatioListener(bVar);
    }

    public void setControllerAnimationEnabled(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setAnimationEnabled(z11);
    }

    public void setControllerAutoShow(boolean z11) {
        this.f11972x = z11;
    }

    public void setControllerHideDuringAds(boolean z11) {
        this.f11973y = z11;
    }

    public void setControllerHideOnTouch(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11974z = z11;
        H();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(@Nullable PlayerControlView.d dVar) {
        z3.a.i(this.f11959k);
        this.f11959k.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i11) {
        z3.a.i(this.f11959k);
        this.f11971w = i11;
        if (this.f11959k.isFullyVisible()) {
            showController();
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(@Nullable PlayerControlView.m mVar) {
        z3.a.i(this.f11959k);
        PlayerControlView.m mVar2 = this.f11965q;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            this.f11959k.removeVisibilityListener(mVar2);
        }
        this.f11965q = mVar;
        if (mVar != null) {
            this.f11959k.addVisibilityListener(mVar);
            setControllerVisibilityListener((c) null);
        }
    }

    public void setControllerVisibilityListener(@Nullable c cVar) {
        if (cVar != null) {
            setControllerVisibilityListener((PlayerControlView.m) null);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        z3.a.g(this.f11958j != null);
        this.f11970v = charSequence;
        J();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f11967s != drawable) {
            this.f11967s = drawable;
            K(false);
        }
    }

    public void setErrorMessageProvider(@Nullable androidx.media3.common.q<? super PlaybackException> qVar) {
        if (qVar != null) {
            J();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        z3.a.i(this.f11959k);
        this.f11959k.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setFullscreenButtonClickListener(@Nullable d dVar) {
        z3.a.i(this.f11959k);
        this.f11959k.setOnFullScreenModeChangedListener(this.f11950a);
    }

    public void setKeepContentOnPlayerReset(boolean z11) {
        if (this.f11969u != z11) {
            this.f11969u = z11;
            K(false);
        }
    }

    public void setPlayer(@Nullable androidx.media3.common.h0 h0Var) {
        z3.a.g(Looper.myLooper() == Looper.getMainLooper());
        z3.a.a(h0Var == null || h0Var.l() == Looper.getMainLooper());
        androidx.media3.common.h0 h0Var2 = this.f11962n;
        if (h0Var2 == h0Var) {
            return;
        }
        if (h0Var2 != null) {
            h0Var2.J(this.f11950a);
            if (h0Var2.i(27)) {
                View view = this.f11953d;
                if (view instanceof TextureView) {
                    h0Var2.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    h0Var2.clearVideoSurfaceView((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f11956h;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f11962n = h0Var;
        if (M()) {
            this.f11959k.setPlayer(h0Var);
        }
        G();
        J();
        K(true);
        if (h0Var == null) {
            hideController();
            return;
        }
        if (h0Var.i(27)) {
            View view2 = this.f11953d;
            if (view2 instanceof TextureView) {
                h0Var.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                h0Var.setVideoSurfaceView((SurfaceView) view2);
            }
            if (!h0Var.i(30) || h0Var.getCurrentTracks().d(2)) {
                F();
            }
        }
        if (this.f11956h != null && h0Var.i(28)) {
            this.f11956h.setCues(h0Var.h().f81147a);
        }
        h0Var.K(this.f11950a);
        x(false);
    }

    public void setRepeatToggleModes(int i11) {
        z3.a.i(this.f11959k);
        this.f11959k.setRepeatToggleModes(i11);
    }

    public void setResizeMode(int i11) {
        z3.a.i(this.f11951b);
        this.f11951b.setResizeMode(i11);
    }

    public void setShowBuffering(int i11) {
        if (this.f11968t != i11) {
            this.f11968t = i11;
            G();
        }
    }

    public void setShowFastForwardButton(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowFastForwardButton(z11);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowMultiWindowTimeBar(z11);
    }

    public void setShowNextButton(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowNextButton(z11);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowPlayButtonIfPlaybackIsSuppressed(z11);
    }

    public void setShowPreviousButton(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowPreviousButton(z11);
    }

    public void setShowRewindButton(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowRewindButton(z11);
    }

    public void setShowShuffleButton(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowShuffleButton(z11);
    }

    public void setShowSubtitleButton(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowSubtitleButton(z11);
    }

    public void setShowVrButton(boolean z11) {
        z3.a.i(this.f11959k);
        this.f11959k.setShowVrButton(z11);
    }

    public void setShutterBackgroundColor(int i11) {
        View view = this.f11952c;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    @Deprecated
    public void setUseArtwork(boolean z11) {
        setArtworkDisplayMode(!z11 ? 1 : 0);
    }

    public void setUseController(boolean z11) {
        boolean z12 = true;
        z3.a.g((z11 && this.f11959k == null) ? false : true);
        if (!z11 && !hasOnClickListeners()) {
            z12 = false;
        }
        setClickable(z12);
        if (this.f11963o == z11) {
            return;
        }
        this.f11963o = z11;
        if (M()) {
            this.f11959k.setPlayer(this.f11962n);
        } else {
            PlayerControlView playerControlView = this.f11959k;
            if (playerControlView != null) {
                playerControlView.hide();
                this.f11959k.setPlayer(null);
            }
        }
        H();
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
        View view = this.f11953d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i11);
        }
    }

    public void showController() {
        D(C());
    }

    public final void u() {
        ImageView imageView = this.f11955g;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f11955g.setVisibility(4);
        }
    }

    @SuppressLint({"InlinedApi"})
    public final boolean v(int i11) {
        return i11 == 19 || i11 == 270 || i11 == 22 || i11 == 271 || i11 == 20 || i11 == 269 || i11 == 21 || i11 == 268 || i11 == 23;
    }

    public final boolean w() {
        androidx.media3.common.h0 h0Var = this.f11962n;
        return h0Var != null && h0Var.i(16) && this.f11962n.isPlayingAd() && this.f11962n.getPlayWhenReady();
    }

    public final void x(boolean z11) {
        if (!(w() && this.f11973y) && M()) {
            boolean z12 = this.f11959k.isFullyVisible() && this.f11959k.getShowTimeoutMs() <= 0;
            boolean zC = C();
            if (z11 || z12 || zC) {
                D(zC);
            }
        }
    }

    public void y(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f11) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f11);
        }
    }

    public final boolean z(androidx.media3.common.h0 h0Var) {
        byte[] bArr;
        if (h0Var.i(18) && (bArr = h0Var.y().f9164h) != null) {
            return A(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
        }
        return false;
    }
}
