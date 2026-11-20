package com.google.android.exoplayer2.ui;

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
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.z1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PlayerControlView extends FrameLayout {
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
    public n2 H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public long U;
    public long[] V;
    public boolean[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f34898a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public long[] f34899a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<e> f34900b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean[] f34901b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final View f34902c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public long f34903c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f34904d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f34905d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f34906e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final View f34907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final View f34908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final View f34909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final View f34910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final ImageView f34911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final ImageView f34912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final View f34913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final TextView f34914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final TextView f34915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final n0 f34916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final StringBuilder f34917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Formatter f34918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j3.b f34919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j3.d f34920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f34921t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f34922u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Drawable f34923v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Drawable f34924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Drawable f34925x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f34926y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f34927z;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements n2.d, n0.a, View.OnClickListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void f(n0 n0Var, long j11) {
            if (PlayerControlView.this.f34915n != null) {
                PlayerControlView.this.f34915n.setText(com.google.android.exoplayer2.util.o0.h0(PlayerControlView.this.f34917p, PlayerControlView.this.f34918q, j11));
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onAvailableCommandsChanged(n2.b bVar) {
            p2.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n2 n2Var = PlayerControlView.this.H;
            if (n2Var == null) {
                return;
            }
            if (PlayerControlView.this.f34904d == view) {
                n2Var.n();
                return;
            }
            if (PlayerControlView.this.f34902c == view) {
                n2Var.f();
                return;
            }
            if (PlayerControlView.this.f34909h == view) {
                if (n2Var.getPlaybackState() != 4) {
                    n2Var.w();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f34910i == view) {
                n2Var.x();
                return;
            }
            if (PlayerControlView.this.f34907f == view) {
                PlayerControlView.this.A(n2Var);
                return;
            }
            if (PlayerControlView.this.f34908g == view) {
                PlayerControlView.this.z(n2Var);
            } else if (PlayerControlView.this.f34911j == view) {
                n2Var.setRepeatMode(com.google.android.exoplayer2.util.e0.a(n2Var.getRepeatMode(), PlayerControlView.this.O));
            } else if (PlayerControlView.this.f34912k == view) {
                n2Var.setShuffleModeEnabled(!n2Var.getShuffleModeEnabled());
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onCues(List list) {
            p2.d(this, list);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onCues(vh.f fVar) {
            p2.e(this, fVar);
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
        public void onEvents(n2 n2Var, n2.c cVar) {
            if (cVar.b(4, 5)) {
                PlayerControlView.this.N();
            }
            if (cVar.b(4, 5, 7)) {
                PlayerControlView.this.O();
            }
            if (cVar.a(8)) {
                PlayerControlView.this.P();
            }
            if (cVar.a(9)) {
                PlayerControlView.this.Q();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                PlayerControlView.this.M();
            }
            if (cVar.b(11, 0)) {
                PlayerControlView.this.R();
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onIsLoadingChanged(boolean z11) {
            p2.i(this, z11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onIsPlayingChanged(boolean z11) {
            p2.j(this, z11);
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
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z11, int i11) {
            p2.p(this, z11, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlaybackParametersChanged(m2 m2Var) {
            p2.q(this, m2Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onPlaybackStateChanged(int i11) {
            p2.r(this, i11);
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
        public /* synthetic */ void onPositionDiscontinuity(n2.e eVar, n2.e eVar2, int i11) {
            p2.y(this, eVar, eVar2, i11);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onRenderedFirstFrame() {
            p2.z(this);
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
        public /* synthetic */ void onTracksChanged(o3 o3Var) {
            p2.J(this, o3Var);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onVideoSizeChanged(com.google.android.exoplayer2.video.y yVar) {
            p2.K(this, yVar);
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onVolumeChanged(float f11) {
            p2.L(this, f11);
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void p(n0 n0Var, long j11, boolean z11) {
            PlayerControlView.this.L = false;
            if (z11 || PlayerControlView.this.H == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.I(playerControlView.H, j11);
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void q(n0 n0Var, long j11) {
            PlayerControlView.this.L = true;
            if (PlayerControlView.this.f34915n != null) {
                PlayerControlView.this.f34915n.setText(com.google.android.exoplayer2.util.o0.h0(PlayerControlView.this.f34917p, PlayerControlView.this.f34918q, j11));
            }
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
        k1.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i11);
        int resourceId = R$layout.exo_player_control_view;
        this.M = 5000;
        this.O = 0;
        this.N = 200;
        this.U = C.TIME_UNSET;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i11, 0);
            try {
                this.M = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.M);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, resourceId);
                this.O = C(typedArrayObtainStyledAttributes, this.O);
                this.P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, this.P);
                this.Q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, this.Q);
                this.R = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, this.R);
                this.S = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, this.S);
                this.T = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.T);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.N));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        }
        this.f34900b = new CopyOnWriteArrayList<>();
        this.f34919r = new j3.b();
        this.f34920s = new j3.d();
        StringBuilder sb2 = new StringBuilder();
        this.f34917p = sb2;
        this.f34918q = new Formatter(sb2, Locale.getDefault());
        this.V = new long[0];
        this.W = new boolean[0];
        this.f34899a0 = new long[0];
        this.f34901b0 = new boolean[0];
        c cVar = new c();
        this.f34898a = cVar;
        this.f34921t = new Runnable() { // from class: com.google.android.exoplayer2.ui.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f35110a.O();
            }
        };
        this.f34922u = new Runnable() { // from class: com.google.android.exoplayer2.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f35149a.hide();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        n0 n0Var = (n0) findViewById(R$id.exo_progress);
        View viewFindViewById = findViewById(R$id.exo_progress_placeholder);
        if (n0Var != null) {
            this.f34916o = n0Var;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f34916o = defaultTimeBar;
        } else {
            this.f34916o = null;
        }
        this.f34914m = (TextView) findViewById(R$id.exo_duration);
        this.f34915n = (TextView) findViewById(R$id.exo_position);
        n0 n0Var2 = this.f34916o;
        if (n0Var2 != null) {
            n0Var2.addListener(cVar);
        }
        View viewFindViewById2 = findViewById(R$id.exo_play);
        this.f34907f = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R$id.exo_pause);
        this.f34908g = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R$id.exo_prev);
        this.f34902c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R$id.exo_next);
        this.f34904d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R$id.exo_rew);
        this.f34910i = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R$id.exo_ffwd);
        this.f34909h = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f34911j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f34912k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R$id.exo_vr);
        this.f34913l = viewFindViewById8;
        setShowVrButton(false);
        L(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.E = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f34923v = resources.getDrawable(R$drawable.exo_controls_repeat_off);
        this.f34924w = resources.getDrawable(R$drawable.exo_controls_repeat_one);
        this.f34925x = resources.getDrawable(R$drawable.exo_controls_repeat_all);
        this.B = resources.getDrawable(R$drawable.exo_controls_shuffle_on);
        this.C = resources.getDrawable(R$drawable.exo_controls_shuffle_off);
        this.f34926y = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f34927z = resources.getString(R$string.exo_controls_repeat_one_description);
        this.A = resources.getString(R$string.exo_controls_repeat_all_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.G = resources.getString(R$string.exo_controls_shuffle_off_description);
        this.f34905d0 = C.TIME_UNSET;
        this.f34906e0 = C.TIME_UNSET;
    }

    public static int C(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i11);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean E(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    public static boolean y(j3 j3Var, j3.d dVar) {
        if (j3Var.t() > 100) {
            return false;
        }
        int iT = j3Var.t();
        for (int i11 = 0; i11 < iT; i11++) {
            if (j3Var.r(i11, dVar).f33390o == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    public final void A(n2 n2Var) {
        int playbackState = n2Var.getPlaybackState();
        if (playbackState == 1) {
            n2Var.prepare();
        } else if (playbackState == 4) {
            H(n2Var, n2Var.u(), C.TIME_UNSET);
        }
        n2Var.play();
    }

    public final void B(n2 n2Var) {
        int playbackState = n2Var.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !n2Var.getPlayWhenReady()) {
            A(n2Var);
        } else {
            z(n2Var);
        }
    }

    public final void D() {
        removeCallbacks(this.f34922u);
        if (this.M <= 0) {
            this.U = C.TIME_UNSET;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i11 = this.M;
        this.U = jUptimeMillis + ((long) i11);
        if (this.I) {
            postDelayed(this.f34922u, i11);
        }
    }

    public final void F() {
        View view;
        View view2;
        boolean zJ = J();
        if (!zJ && (view2 = this.f34907f) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zJ || (view = this.f34908g) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    public final void G() {
        View view;
        View view2;
        boolean zJ = J();
        if (!zJ && (view2 = this.f34907f) != null) {
            view2.requestFocus();
        } else {
            if (!zJ || (view = this.f34908g) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    public final void H(n2 n2Var, int i11, long j11) {
        n2Var.seekTo(i11, j11);
    }

    public final void I(n2 n2Var, long j11) {
        int iU;
        j3 currentTimeline = n2Var.getCurrentTimeline();
        if (this.K && !currentTimeline.u()) {
            int iT = currentTimeline.t();
            iU = 0;
            while (true) {
                long jG = currentTimeline.r(iU, this.f34920s).g();
                if (j11 < jG) {
                    break;
                }
                if (iU == iT - 1) {
                    j11 = jG;
                    break;
                } else {
                    j11 -= jG;
                    iU++;
                }
            }
        } else {
            iU = n2Var.u();
        }
        H(n2Var, iU, j11);
        O();
    }

    public final boolean J() {
        n2 n2Var = this.H;
        return (n2Var == null || n2Var.getPlaybackState() == 4 || this.H.getPlaybackState() == 1 || !this.H.getPlayWhenReady()) ? false : true;
    }

    public final void K() {
        N();
        M();
        P();
        Q();
        R();
    }

    public final void L(boolean z11, boolean z12, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z12);
        view.setAlpha(z12 ? this.D : this.E);
        view.setVisibility(z11 ? 0 : 8);
    }

    public final void M() {
        boolean zI;
        boolean zI2;
        boolean zI3;
        boolean zI4;
        boolean zI5;
        if (isVisible() && this.I) {
            n2 n2Var = this.H;
            if (n2Var != null) {
                zI = n2Var.i(5);
                zI3 = n2Var.i(7);
                zI4 = n2Var.i(11);
                zI5 = n2Var.i(12);
                zI2 = n2Var.i(9);
            } else {
                zI = false;
                zI2 = false;
                zI3 = false;
                zI4 = false;
                zI5 = false;
            }
            L(this.R, zI3, this.f34902c);
            L(this.P, zI4, this.f34910i);
            L(this.Q, zI5, this.f34909h);
            L(this.S, zI2, this.f34904d);
            n0 n0Var = this.f34916o;
            if (n0Var != null) {
                n0Var.setEnabled(zI);
            }
        }
    }

    public final void N() {
        boolean z11;
        boolean z12;
        if (isVisible() && this.I) {
            boolean zJ = J();
            View view = this.f34907f;
            boolean z13 = true;
            if (view != null) {
                z11 = zJ && view.isFocused();
                if (com.google.android.exoplayer2.util.o0.f35608a < 21) {
                    z12 = z11;
                } else {
                    z12 = zJ && b.a(this.f34907f);
                }
                this.f34907f.setVisibility(zJ ? 8 : 0);
            } else {
                z11 = false;
                z12 = false;
            }
            View view2 = this.f34908g;
            if (view2 != null) {
                z11 |= !zJ && view2.isFocused();
                if (com.google.android.exoplayer2.util.o0.f35608a < 21) {
                    z13 = z11;
                } else if (zJ || !b.a(this.f34908g)) {
                    z13 = false;
                }
                z12 |= z13;
                this.f34908g.setVisibility(zJ ? 0 : 8);
            }
            if (z11) {
                G();
            }
            if (z12) {
                F();
            }
        }
    }

    public final void O() {
        long contentPosition;
        long jV;
        if (isVisible() && this.I) {
            n2 n2Var = this.H;
            if (n2Var != null) {
                contentPosition = this.f34903c0 + n2Var.getContentPosition();
                jV = this.f34903c0 + n2Var.v();
            } else {
                contentPosition = 0;
                jV = 0;
            }
            boolean z11 = contentPosition != this.f34905d0;
            this.f34905d0 = contentPosition;
            this.f34906e0 = jV;
            TextView textView = this.f34915n;
            if (textView != null && !this.L && z11) {
                textView.setText(com.google.android.exoplayer2.util.o0.h0(this.f34917p, this.f34918q, contentPosition));
            }
            n0 n0Var = this.f34916o;
            if (n0Var != null) {
                n0Var.setPosition(contentPosition);
                this.f34916o.setBufferedPosition(jV);
            }
            removeCallbacks(this.f34921t);
            int playbackState = n2Var == null ? 1 : n2Var.getPlaybackState();
            if (n2Var == null || !n2Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f34921t, 1000L);
                return;
            }
            n0 n0Var2 = this.f34916o;
            long jMin = Math.min(n0Var2 != null ? n0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f11 = n2Var.getPlaybackParameters().f33487a;
            postDelayed(this.f34921t, com.google.android.exoplayer2.util.o0.r(f11 > 0.0f ? (long) (jMin / f11) : 1000L, this.N, 1000L));
        }
    }

    public final void P() {
        ImageView imageView;
        if (isVisible() && this.I && (imageView = this.f34911j) != null) {
            if (this.O == 0) {
                L(false, false, imageView);
                return;
            }
            n2 n2Var = this.H;
            if (n2Var == null) {
                L(true, false, imageView);
                this.f34911j.setImageDrawable(this.f34923v);
                this.f34911j.setContentDescription(this.f34926y);
                return;
            }
            L(true, true, imageView);
            int repeatMode = n2Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f34911j.setImageDrawable(this.f34923v);
                this.f34911j.setContentDescription(this.f34926y);
            } else if (repeatMode == 1) {
                this.f34911j.setImageDrawable(this.f34924w);
                this.f34911j.setContentDescription(this.f34927z);
            } else if (repeatMode == 2) {
                this.f34911j.setImageDrawable(this.f34925x);
                this.f34911j.setContentDescription(this.A);
            }
            this.f34911j.setVisibility(0);
        }
    }

    public final void Q() {
        ImageView imageView;
        if (isVisible() && this.I && (imageView = this.f34912k) != null) {
            n2 n2Var = this.H;
            if (!this.T) {
                L(false, false, imageView);
                return;
            }
            if (n2Var == null) {
                L(true, false, imageView);
                this.f34912k.setImageDrawable(this.C);
                this.f34912k.setContentDescription(this.G);
            } else {
                L(true, true, imageView);
                this.f34912k.setImageDrawable(n2Var.getShuffleModeEnabled() ? this.B : this.C);
                this.f34912k.setContentDescription(n2Var.getShuffleModeEnabled() ? this.F : this.G);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4 A[SYNTHETIC] */
    public final void R() {
        int i11;
        j3.d dVar;
        long jQ;
        long[] jArr;
        int length;
        n2 n2Var = this.H;
        if (n2Var == null) {
            return;
        }
        boolean z11 = true;
        this.K = this.J && y(n2Var.getCurrentTimeline(), this.f34920s);
        long j11 = 0;
        this.f34903c0 = 0L;
        j3 currentTimeline = n2Var.getCurrentTimeline();
        if (currentTimeline.u()) {
            i11 = 0;
        } else {
            int iU = n2Var.u();
            boolean z12 = this.K;
            int i12 = z12 ? 0 : iU;
            int iT = z12 ? currentTimeline.t() - 1 : iU;
            long j12 = 0;
            i11 = 0;
            while (i12 <= iT) {
                if (i12 == iU) {
                    this.f34903c0 = com.google.android.exoplayer2.util.o0.f1(j12);
                }
                currentTimeline.r(i12, this.f34920s);
                j3.d dVar2 = this.f34920s;
                if (dVar2.f33390o == C.TIME_UNSET) {
                    com.google.android.exoplayer2.util.a.g(this.K ^ z11);
                    break;
                }
                int i13 = dVar2.f33391p;
                while (true) {
                    dVar = this.f34920s;
                    if (i13 <= dVar.f33392q) {
                        currentTimeline.j(i13, this.f34919r);
                        int iF = this.f34919r.f();
                        for (int iR = this.f34919r.r(); iR < iF; iR++) {
                            long jI = this.f34919r.i(iR);
                            if (jI == Long.MIN_VALUE) {
                                long j13 = this.f34919r.f33365d;
                                if (j13 != C.TIME_UNSET) {
                                    jI = j13;
                                    jQ = jI + this.f34919r.q();
                                    if (jQ >= 0) {
                                        jArr = this.V;
                                        if (i11 == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.V = Arrays.copyOf(jArr, length);
                                            this.W = Arrays.copyOf(this.W, length);
                                        }
                                        this.V[i11] = com.google.android.exoplayer2.util.o0.f1(j12 + jQ);
                                        this.W[i11] = this.f34919r.s(iR);
                                        i11++;
                                    }
                                }
                            } else {
                                jQ = jI + this.f34919r.q();
                                if (jQ >= 0) {
                                    jArr = this.V;
                                    if (i11 == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.V = Arrays.copyOf(jArr, length);
                                        this.W = Arrays.copyOf(this.W, length);
                                    }
                                    this.V[i11] = com.google.android.exoplayer2.util.o0.f1(j12 + jQ);
                                    this.W[i11] = this.f34919r.s(iR);
                                    i11++;
                                }
                            }
                        }
                        i13++;
                    }
                }
                j12 += dVar.f33390o;
                i12++;
                z11 = true;
            }
            j11 = j12;
        }
        long jF1 = com.google.android.exoplayer2.util.o0.f1(j11);
        TextView textView = this.f34914m;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.o0.h0(this.f34917p, this.f34918q, jF1));
        }
        n0 n0Var = this.f34916o;
        if (n0Var != null) {
            n0Var.setDuration(jF1);
            int length2 = this.f34899a0.length;
            int i14 = i11 + length2;
            long[] jArr2 = this.V;
            if (i14 > jArr2.length) {
                this.V = Arrays.copyOf(jArr2, i14);
                this.W = Arrays.copyOf(this.W, i14);
            }
            System.arraycopy(this.f34899a0, 0, this.V, i11, length2);
            System.arraycopy(this.f34901b0, 0, this.W, i11, length2);
            this.f34916o.setAdGroupTimesMs(this.V, this.W, i14);
        }
        O();
    }

    public void addVisibilityListener(e eVar) {
        com.google.android.exoplayer2.util.a.e(eVar);
        this.f34900b.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        n2 n2Var = this.H;
        if (n2Var == null || !E(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (n2Var.getPlaybackState() == 4) {
                return true;
            }
            n2Var.w();
            return true;
        }
        if (keyCode == 89) {
            n2Var.x();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            B(n2Var);
            return true;
        }
        if (keyCode == 87) {
            n2Var.n();
            return true;
        }
        if (keyCode == 88) {
            n2Var.f();
            return true;
        }
        if (keyCode == 126) {
            A(n2Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        z(n2Var);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f34922u);
        } else if (motionEvent.getAction() == 1) {
            D();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public n2 getPlayer() {
        return this.H;
    }

    public int getRepeatToggleModes() {
        return this.O;
    }

    public boolean getShowShuffleButton() {
        return this.T;
    }

    public int getShowTimeoutMs() {
        return this.M;
    }

    public boolean getShowVrButton() {
        View view = this.f34913l;
        return view != null && view.getVisibility() == 0;
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator<e> it = this.f34900b.iterator();
            while (it.hasNext()) {
                it.next().f(getVisibility());
            }
            removeCallbacks(this.f34921t);
            removeCallbacks(this.f34922u);
            this.U = C.TIME_UNSET;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = true;
        long j11 = this.U;
        if (j11 != C.TIME_UNSET) {
            long jUptimeMillis = j11 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.f34922u, jUptimeMillis);
            }
        } else if (isVisible()) {
            D();
        }
        K();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = false;
        removeCallbacks(this.f34921t);
        removeCallbacks(this.f34922u);
    }

    public void removeVisibilityListener(e eVar) {
        this.f34900b.remove(eVar);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f34899a0 = new long[0];
            this.f34901b0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.a.e(zArr);
            com.google.android.exoplayer2.util.a.a(jArr.length == zArr2.length);
            this.f34899a0 = jArr;
            this.f34901b0 = zArr2;
        }
        R();
    }

    public void setPlayer(@Nullable n2 n2Var) {
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(n2Var == null || n2Var.l() == Looper.getMainLooper());
        n2 n2Var2 = this.H;
        if (n2Var2 == n2Var) {
            return;
        }
        if (n2Var2 != null) {
            n2Var2.C(this.f34898a);
        }
        this.H = n2Var;
        if (n2Var != null) {
            n2Var.E(this.f34898a);
        }
        K();
    }

    public void setProgressUpdateListener(@Nullable d dVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.O = i11;
        n2 n2Var = this.H;
        if (n2Var != null) {
            int repeatMode = n2Var.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.H.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.H.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.H.setRepeatMode(2);
            }
        }
        P();
    }

    public void setShowFastForwardButton(boolean z11) {
        this.Q = z11;
        M();
    }

    public void setShowMultiWindowTimeBar(boolean z11) {
        this.J = z11;
        R();
    }

    public void setShowNextButton(boolean z11) {
        this.S = z11;
        M();
    }

    public void setShowPreviousButton(boolean z11) {
        this.R = z11;
        M();
    }

    public void setShowRewindButton(boolean z11) {
        this.P = z11;
        M();
    }

    public void setShowShuffleButton(boolean z11) {
        this.T = z11;
        Q();
    }

    public void setShowTimeoutMs(int i11) {
        this.M = i11;
        if (isVisible()) {
            D();
        }
    }

    public void setShowVrButton(boolean z11) {
        View view = this.f34913l;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.N = com.google.android.exoplayer2.util.o0.q(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f34913l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            L(getShowVrButton(), onClickListener != null, this.f34913l);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator<e> it = this.f34900b.iterator();
            while (it.hasNext()) {
                it.next().f(getVisibility());
            }
            K();
            G();
            F();
        }
        D();
    }

    public final void z(n2 n2Var) {
        n2Var.pause();
    }
}
