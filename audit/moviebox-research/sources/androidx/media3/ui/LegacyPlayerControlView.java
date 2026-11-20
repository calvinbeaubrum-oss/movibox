package androidx.media3.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class LegacyPlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    public final String A;
    public final Drawable B;
    public final Drawable C;
    public final float D;
    public final float E;
    public final String F;
    public final String G;

    @Nullable
    public androidx.media3.common.h0 H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public long V;
    public long[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11845a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean[] f11846a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<e> f11847b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long[] f11848b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final View f11849c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean[] f11850c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f11851d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f11852d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f11853e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final View f11854f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f11855f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final View f11856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final View f11857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final View f11858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final ImageView f11859j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final ImageView f11860k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final View f11861l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final TextView f11862m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final TextView f11863n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final o0 f11864o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final StringBuilder f11865p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Formatter f11866q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.media3.common.m0.b f11867r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final androidx.media3.common.m0.c f11868s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f11869t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f11870u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Drawable f11871v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Drawable f11872w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Drawable f11873x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f11874y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f11875z;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements androidx.media3.common.h0.d, o0.a, View.OnClickListener {
        public c() {
        }

        @Override // androidx.media3.ui.o0.a
        public void f(o0 o0Var, long j11) {
            LegacyPlayerControlView.this.M = true;
            if (LegacyPlayerControlView.this.f11863n != null) {
                LegacyPlayerControlView.this.f11863n.setText(u0.q0(LegacyPlayerControlView.this.f11865p, LegacyPlayerControlView.this.f11866q, j11));
            }
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onAvailableCommandsChanged(androidx.media3.common.h0.b bVar) {
            androidx.media3.common.i0.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.media3.common.h0 h0Var = LegacyPlayerControlView.this.H;
            if (h0Var == null) {
                return;
            }
            if (LegacyPlayerControlView.this.f11851d == view) {
                h0Var.n();
                return;
            }
            if (LegacyPlayerControlView.this.f11849c == view) {
                h0Var.f();
                return;
            }
            if (LegacyPlayerControlView.this.f11857h == view) {
                if (h0Var.getPlaybackState() != 4) {
                    h0Var.w();
                    return;
                }
                return;
            }
            if (LegacyPlayerControlView.this.f11858i == view) {
                h0Var.x();
                return;
            }
            if (LegacyPlayerControlView.this.f11854f == view) {
                u0.y0(h0Var);
                return;
            }
            if (LegacyPlayerControlView.this.f11856g == view) {
                u0.x0(h0Var);
            } else if (LegacyPlayerControlView.this.f11859j == view) {
                h0Var.setRepeatMode(z3.d0.a(h0Var.getRepeatMode(), LegacyPlayerControlView.this.P));
            } else if (LegacyPlayerControlView.this.f11860k == view) {
                h0Var.setShuffleModeEnabled(!h0Var.getShuffleModeEnabled());
            }
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onCues(List list) {
            androidx.media3.common.i0.d(this, list);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onCues(y3.b bVar) {
            androidx.media3.common.i0.e(this, bVar);
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
        public void onEvents(androidx.media3.common.h0 h0Var, androidx.media3.common.h0.c cVar) {
            if (cVar.b(4, 5)) {
                LegacyPlayerControlView.this.H();
            }
            if (cVar.b(4, 5, 7)) {
                LegacyPlayerControlView.this.I();
            }
            if (cVar.a(8)) {
                LegacyPlayerControlView.this.J();
            }
            if (cVar.a(9)) {
                LegacyPlayerControlView.this.K();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                LegacyPlayerControlView.this.G();
            }
            if (cVar.b(11, 0)) {
                LegacyPlayerControlView.this.L();
            }
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onIsLoadingChanged(boolean z11) {
            androidx.media3.common.i0.i(this, z11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onIsPlayingChanged(boolean z11) {
            androidx.media3.common.i0.j(this, z11);
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
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z11, int i11) {
            androidx.media3.common.i0.p(this, z11, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPlaybackParametersChanged(androidx.media3.common.g0 g0Var) {
            androidx.media3.common.i0.q(this, g0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onPlaybackStateChanged(int i11) {
            androidx.media3.common.i0.r(this, i11);
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
        public /* synthetic */ void onPositionDiscontinuity(androidx.media3.common.h0.e eVar, androidx.media3.common.h0.e eVar2, int i11) {
            androidx.media3.common.i0.y(this, eVar, eVar2, i11);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onRenderedFirstFrame() {
            androidx.media3.common.i0.z(this);
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
        public /* synthetic */ void onTracksChanged(androidx.media3.common.q0 q0Var) {
            androidx.media3.common.i0.I(this, q0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onVideoSizeChanged(t0 t0Var) {
            androidx.media3.common.i0.J(this, t0Var);
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            androidx.media3.common.i0.K(this, f11);
        }

        @Override // androidx.media3.ui.o0.a
        public void p(o0 o0Var, long j11) {
            if (LegacyPlayerControlView.this.f11863n != null) {
                LegacyPlayerControlView.this.f11863n.setText(u0.q0(LegacyPlayerControlView.this.f11865p, LegacyPlayerControlView.this.f11866q, j11));
            }
        }

        @Override // androidx.media3.ui.o0.a
        public void r(o0 o0Var, long j11, boolean z11) {
            LegacyPlayerControlView.this.M = false;
            if (z11 || LegacyPlayerControlView.this.H == null) {
                return;
            }
            LegacyPlayerControlView legacyPlayerControlView = LegacyPlayerControlView.this;
            legacyPlayerControlView.D(legacyPlayerControlView.H, j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void f(int i11);
    }

    static {
        androidx.media3.common.c0.a("media3.ui");
    }

    public LegacyPlayerControlView(Context context) {
        this(context, null);
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public LegacyPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i11);
        int resourceId = R$layout.exo_legacy_player_control_view;
        this.K = true;
        this.N = 5000;
        this.P = 0;
        this.O = 200;
        this.V = C.TIME_UNSET;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.LegacyPlayerControlView, i11, 0);
            try {
                this.N = typedArrayObtainStyledAttributes.getInt(R$styleable.LegacyPlayerControlView_show_timeout, this.N);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.LegacyPlayerControlView_controller_layout_id, resourceId);
                this.P = x(typedArrayObtainStyledAttributes, this.P);
                this.Q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_rewind_button, this.Q);
                this.R = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_fastforward_button, this.R);
                this.S = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_previous_button, this.S);
                this.T = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_next_button, this.T);
                this.U = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LegacyPlayerControlView_show_shuffle_button, this.U);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.LegacyPlayerControlView_time_bar_min_update_interval, this.O));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        }
        this.f11847b = new CopyOnWriteArrayList<>();
        this.f11867r = new androidx.media3.common.m0.b();
        this.f11868s = new androidx.media3.common.m0.c();
        StringBuilder sb2 = new StringBuilder();
        this.f11865p = sb2;
        this.f11866q = new Formatter(sb2, Locale.getDefault());
        this.W = new long[0];
        this.f11846a0 = new boolean[0];
        this.f11848b0 = new long[0];
        this.f11850c0 = new boolean[0];
        c cVar = new c();
        this.f11845a = cVar;
        this.f11869t = new Runnable() { // from class: androidx.media3.ui.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f12074a.I();
            }
        };
        this.f11870u = new Runnable() { // from class: androidx.media3.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f12075a.hide();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        o0 o0Var = (o0) findViewById(R$id.exo_progress);
        View viewFindViewById = findViewById(R$id.exo_progress_placeholder);
        if (o0Var != null) {
            this.f11864o = o0Var;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f11864o = defaultTimeBar;
        } else {
            this.f11864o = null;
        }
        this.f11862m = (TextView) findViewById(R$id.exo_duration);
        this.f11863n = (TextView) findViewById(R$id.exo_position);
        o0 o0Var2 = this.f11864o;
        if (o0Var2 != null) {
            o0Var2.addListener(cVar);
        }
        View viewFindViewById2 = findViewById(R$id.exo_play);
        this.f11854f = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R$id.exo_pause);
        this.f11856g = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R$id.exo_prev);
        this.f11849c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R$id.exo_next);
        this.f11851d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R$id.exo_rew);
        this.f11858i = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R$id.exo_ffwd);
        this.f11857h = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f11859j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f11860k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R$id.exo_vr);
        this.f11861l = viewFindViewById8;
        setShowVrButton(false);
        F(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.E = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f11871v = u0.a0(context, resources, R$drawable.exo_legacy_controls_repeat_off);
        this.f11872w = u0.a0(context, resources, R$drawable.exo_legacy_controls_repeat_one);
        this.f11873x = u0.a0(context, resources, R$drawable.exo_legacy_controls_repeat_all);
        this.B = u0.a0(context, resources, R$drawable.exo_legacy_controls_shuffle_on);
        this.C = u0.a0(context, resources, R$drawable.exo_legacy_controls_shuffle_off);
        this.f11874y = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f11875z = resources.getString(R$string.exo_controls_repeat_one_description);
        this.A = resources.getString(R$string.exo_controls_repeat_all_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.G = resources.getString(R$string.exo_controls_shuffle_off_description);
        this.f11853e0 = C.TIME_UNSET;
        this.f11855f0 = C.TIME_UNSET;
    }

    public static boolean w(androidx.media3.common.m0 m0Var, androidx.media3.common.m0.c cVar) {
        if (m0Var.p() > 100) {
            return false;
        }
        int iP = m0Var.p();
        for (int i11 = 0; i11 < iP; i11++) {
            if (m0Var.n(i11, cVar).f9322n == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    public static int x(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.LegacyPlayerControlView_repeat_toggle_modes, i11);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean z(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    public final void A() {
        View view;
        View view2;
        boolean zL1 = u0.l1(this.H, this.K);
        if (zL1 && (view2 = this.f11854f) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (zL1 || (view = this.f11856g) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    public final void B() {
        View view;
        View view2;
        boolean zL1 = u0.l1(this.H, this.K);
        if (zL1 && (view2 = this.f11854f) != null) {
            view2.requestFocus();
        } else {
            if (zL1 || (view = this.f11856g) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    public final void C(androidx.media3.common.h0 h0Var, int i11, long j11) {
        h0Var.seekTo(i11, j11);
    }

    public final void D(androidx.media3.common.h0 h0Var, long j11) {
        int iU;
        androidx.media3.common.m0 currentTimeline = h0Var.getCurrentTimeline();
        if (this.L && !currentTimeline.q()) {
            int iP = currentTimeline.p();
            iU = 0;
            while (true) {
                long jD = currentTimeline.n(iU, this.f11868s).d();
                if (j11 < jD) {
                    break;
                }
                if (iU == iP - 1) {
                    j11 = jD;
                    break;
                } else {
                    j11 -= jD;
                    iU++;
                }
            }
        } else {
            iU = h0Var.u();
        }
        C(h0Var, iU, j11);
        I();
    }

    public final void E() {
        H();
        G();
        J();
        K();
        L();
    }

    public final void F(boolean z11, boolean z12, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z12);
        view.setAlpha(z12 ? this.D : this.E);
        view.setVisibility(z11 ? 0 : 8);
    }

    public final void G() {
        boolean zI;
        boolean zI2;
        boolean zI3;
        boolean zI4;
        boolean zI5;
        if (isVisible() && this.I) {
            androidx.media3.common.h0 h0Var = this.H;
            if (h0Var != null) {
                zI = h0Var.i(5);
                zI3 = h0Var.i(7);
                zI4 = h0Var.i(11);
                zI5 = h0Var.i(12);
                zI2 = h0Var.i(9);
            } else {
                zI = false;
                zI2 = false;
                zI3 = false;
                zI4 = false;
                zI5 = false;
            }
            F(this.S, zI3, this.f11849c);
            F(this.Q, zI4, this.f11858i);
            F(this.R, zI5, this.f11857h);
            F(this.T, zI2, this.f11851d);
            o0 o0Var = this.f11864o;
            if (o0Var != null) {
                o0Var.setEnabled(zI);
            }
        }
    }

    public final void H() {
        boolean z11;
        boolean z12;
        if (isVisible() && this.I) {
            boolean zL1 = u0.l1(this.H, this.K);
            View view = this.f11854f;
            boolean z13 = true;
            if (view != null) {
                z11 = !zL1 && view.isFocused();
                if (u0.f81838a < 21) {
                    z12 = z11;
                } else {
                    z12 = !zL1 && b.a(this.f11854f);
                }
                this.f11854f.setVisibility(zL1 ? 0 : 8);
            } else {
                z11 = false;
                z12 = false;
            }
            View view2 = this.f11856g;
            if (view2 != null) {
                z11 |= zL1 && view2.isFocused();
                if (u0.f81838a < 21) {
                    z13 = z11;
                } else if (!zL1 || !b.a(this.f11856g)) {
                    z13 = false;
                }
                z12 |= z13;
                this.f11856g.setVisibility(zL1 ? 8 : 0);
            }
            if (z11) {
                B();
            }
            if (z12) {
                A();
            }
        }
    }

    public final void I() {
        long contentPosition;
        long jV;
        if (isVisible() && this.I) {
            androidx.media3.common.h0 h0Var = this.H;
            if (h0Var != null) {
                contentPosition = this.f11852d0 + h0Var.getContentPosition();
                jV = this.f11852d0 + h0Var.v();
            } else {
                contentPosition = 0;
                jV = 0;
            }
            boolean z11 = contentPosition != this.f11853e0;
            this.f11853e0 = contentPosition;
            this.f11855f0 = jV;
            TextView textView = this.f11863n;
            if (textView != null && !this.M && z11) {
                textView.setText(u0.q0(this.f11865p, this.f11866q, contentPosition));
            }
            o0 o0Var = this.f11864o;
            if (o0Var != null) {
                o0Var.setPosition(contentPosition);
                this.f11864o.setBufferedPosition(jV);
            }
            removeCallbacks(this.f11869t);
            int playbackState = h0Var == null ? 1 : h0Var.getPlaybackState();
            if (h0Var == null || !h0Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f11869t, 1000L);
                return;
            }
            o0 o0Var2 = this.f11864o;
            long jMin = Math.min(o0Var2 != null ? o0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f11 = h0Var.getPlaybackParameters().f9222a;
            postDelayed(this.f11869t, u0.q(f11 > 0.0f ? (long) (jMin / f11) : 1000L, this.O, 1000L));
        }
    }

    public final void J() {
        ImageView imageView;
        if (isVisible() && this.I && (imageView = this.f11859j) != null) {
            if (this.P == 0) {
                F(false, false, imageView);
                return;
            }
            androidx.media3.common.h0 h0Var = this.H;
            if (h0Var == null) {
                F(true, false, imageView);
                this.f11859j.setImageDrawable(this.f11871v);
                this.f11859j.setContentDescription(this.f11874y);
                return;
            }
            F(true, true, imageView);
            int repeatMode = h0Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f11859j.setImageDrawable(this.f11871v);
                this.f11859j.setContentDescription(this.f11874y);
            } else if (repeatMode == 1) {
                this.f11859j.setImageDrawable(this.f11872w);
                this.f11859j.setContentDescription(this.f11875z);
            } else if (repeatMode == 2) {
                this.f11859j.setImageDrawable(this.f11873x);
                this.f11859j.setContentDescription(this.A);
            }
            this.f11859j.setVisibility(0);
        }
    }

    public final void K() {
        ImageView imageView;
        if (isVisible() && this.I && (imageView = this.f11860k) != null) {
            androidx.media3.common.h0 h0Var = this.H;
            if (!this.U) {
                F(false, false, imageView);
                return;
            }
            if (h0Var == null) {
                F(true, false, imageView);
                this.f11860k.setImageDrawable(this.C);
                this.f11860k.setContentDescription(this.G);
            } else {
                F(true, true, imageView);
                this.f11860k.setImageDrawable(h0Var.getShuffleModeEnabled() ? this.B : this.C);
                this.f11860k.setContentDescription(h0Var.getShuffleModeEnabled() ? this.F : this.G);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4 A[SYNTHETIC] */
    public final void L() {
        int i11;
        androidx.media3.common.m0.c cVar;
        long jO;
        long[] jArr;
        int length;
        androidx.media3.common.h0 h0Var = this.H;
        if (h0Var == null) {
            return;
        }
        boolean z11 = true;
        this.L = this.J && w(h0Var.getCurrentTimeline(), this.f11868s);
        long j11 = 0;
        this.f11852d0 = 0L;
        androidx.media3.common.m0 currentTimeline = h0Var.getCurrentTimeline();
        if (currentTimeline.q()) {
            i11 = 0;
        } else {
            int iU = h0Var.u();
            boolean z12 = this.L;
            int i12 = z12 ? 0 : iU;
            int iP = z12 ? currentTimeline.p() - 1 : iU;
            long j12 = 0;
            i11 = 0;
            while (i12 <= iP) {
                if (i12 == iU) {
                    this.f11852d0 = u0.B1(j12);
                }
                currentTimeline.n(i12, this.f11868s);
                androidx.media3.common.m0.c cVar2 = this.f11868s;
                if (cVar2.f9322n == C.TIME_UNSET) {
                    z3.a.g(this.L ^ z11);
                    break;
                }
                int i13 = cVar2.f9323o;
                while (true) {
                    cVar = this.f11868s;
                    if (i13 <= cVar.f9324p) {
                        currentTimeline.f(i13, this.f11867r);
                        int iC = this.f11867r.c();
                        for (int iP2 = this.f11867r.p(); iP2 < iC; iP2++) {
                            long jF = this.f11867r.f(iP2);
                            if (jF == Long.MIN_VALUE) {
                                long j13 = this.f11867r.f9296d;
                                if (j13 != C.TIME_UNSET) {
                                    jF = j13;
                                    jO = jF + this.f11867r.o();
                                    if (jO >= 0) {
                                        jArr = this.W;
                                        if (i11 == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.W = Arrays.copyOf(jArr, length);
                                            this.f11846a0 = Arrays.copyOf(this.f11846a0, length);
                                        }
                                        this.W[i11] = u0.B1(j12 + jO);
                                        this.f11846a0[i11] = this.f11867r.q(iP2);
                                        i11++;
                                    }
                                }
                            } else {
                                jO = jF + this.f11867r.o();
                                if (jO >= 0) {
                                    jArr = this.W;
                                    if (i11 == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.W = Arrays.copyOf(jArr, length);
                                        this.f11846a0 = Arrays.copyOf(this.f11846a0, length);
                                    }
                                    this.W[i11] = u0.B1(j12 + jO);
                                    this.f11846a0[i11] = this.f11867r.q(iP2);
                                    i11++;
                                }
                            }
                        }
                        i13++;
                    }
                }
                j12 += cVar.f9322n;
                i12++;
                z11 = true;
            }
            j11 = j12;
        }
        long jB1 = u0.B1(j11);
        TextView textView = this.f11862m;
        if (textView != null) {
            textView.setText(u0.q0(this.f11865p, this.f11866q, jB1));
        }
        o0 o0Var = this.f11864o;
        if (o0Var != null) {
            o0Var.setDuration(jB1);
            int length2 = this.f11848b0.length;
            int i14 = i11 + length2;
            long[] jArr2 = this.W;
            if (i14 > jArr2.length) {
                this.W = Arrays.copyOf(jArr2, i14);
                this.f11846a0 = Arrays.copyOf(this.f11846a0, i14);
            }
            System.arraycopy(this.f11848b0, 0, this.W, i11, length2);
            System.arraycopy(this.f11850c0, 0, this.f11846a0, i11, length2);
            this.f11864o.setAdGroupTimesMs(this.W, this.f11846a0, i14);
        }
        I();
    }

    public void addVisibilityListener(e eVar) {
        z3.a.e(eVar);
        this.f11847b.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.media3.common.h0 h0Var = this.H;
        if (h0Var == null || !z(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (h0Var.getPlaybackState() == 4) {
                return true;
            }
            h0Var.w();
            return true;
        }
        if (keyCode == 89) {
            h0Var.x();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            u0.z0(h0Var, this.K);
            return true;
        }
        if (keyCode == 87) {
            h0Var.n();
            return true;
        }
        if (keyCode == 88) {
            h0Var.f();
            return true;
        }
        if (keyCode == 126) {
            u0.y0(h0Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        u0.x0(h0Var);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f11870u);
        } else if (motionEvent.getAction() == 1) {
            y();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public androidx.media3.common.h0 getPlayer() {
        return this.H;
    }

    public int getRepeatToggleModes() {
        return this.P;
    }

    public boolean getShowShuffleButton() {
        return this.U;
    }

    public int getShowTimeoutMs() {
        return this.N;
    }

    public boolean getShowVrButton() {
        View view = this.f11861l;
        return view != null && view.getVisibility() == 0;
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator<e> it = this.f11847b.iterator();
            while (it.hasNext()) {
                it.next().f(getVisibility());
            }
            removeCallbacks(this.f11869t);
            removeCallbacks(this.f11870u);
            this.V = C.TIME_UNSET;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        long j11 = this.V;
        if (j11 != C.TIME_UNSET) {
            long jUptimeMillis = j11 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.f11870u, jUptimeMillis);
            }
        } else if (isVisible()) {
            y();
        }
        E();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        removeCallbacks(this.f11869t);
        removeCallbacks(this.f11870u);
    }

    public void removeVisibilityListener(e eVar) {
        this.f11847b.remove(eVar);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f11848b0 = new long[0];
            this.f11850c0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) z3.a.e(zArr);
            z3.a.a(jArr.length == zArr2.length);
            this.f11848b0 = jArr;
            this.f11850c0 = zArr2;
        }
        L();
    }

    public void setPlayer(@Nullable androidx.media3.common.h0 h0Var) {
        z3.a.g(Looper.myLooper() == Looper.getMainLooper());
        z3.a.a(h0Var == null || h0Var.l() == Looper.getMainLooper());
        androidx.media3.common.h0 h0Var2 = this.H;
        if (h0Var2 == h0Var) {
            return;
        }
        if (h0Var2 != null) {
            h0Var2.J(this.f11845a);
        }
        this.H = h0Var;
        if (h0Var != null) {
            h0Var.K(this.f11845a);
        }
        E();
    }

    public void setProgressUpdateListener(@Nullable d dVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.P = i11;
        androidx.media3.common.h0 h0Var = this.H;
        if (h0Var != null) {
            int repeatMode = h0Var.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.H.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.H.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.H.setRepeatMode(2);
            }
        }
        J();
    }

    public void setShowFastForwardButton(boolean z11) {
        this.R = z11;
        G();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z11) {
        this.J = z11;
        L();
    }

    public void setShowNextButton(boolean z11) {
        this.T = z11;
        G();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z11) {
        this.K = z11;
        H();
    }

    public void setShowPreviousButton(boolean z11) {
        this.S = z11;
        G();
    }

    public void setShowRewindButton(boolean z11) {
        this.Q = z11;
        G();
    }

    public void setShowShuffleButton(boolean z11) {
        this.U = z11;
        K();
    }

    public void setShowTimeoutMs(int i11) {
        this.N = i11;
        if (isVisible()) {
            y();
        }
    }

    public void setShowVrButton(boolean z11) {
        View view = this.f11861l;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.O = u0.p(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f11861l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            F(getShowVrButton(), onClickListener != null, this.f11861l);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator<e> it = this.f11847b.iterator();
            while (it.hasNext()) {
                it.next().f(getVisibility());
            }
            E();
            B();
            A();
        }
        y();
    }

    public final void y() {
        removeCallbacks(this.f11870u);
        if (this.N <= 0) {
            this.V = C.TIME_UNSET;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i11 = this.N;
        this.V = jUptimeMillis + ((long) i11);
        if (this.I) {
            postDelayed(this.f11870u, i11);
        }
    }
}
