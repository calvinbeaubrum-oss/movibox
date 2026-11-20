package androidx.media3.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.t0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final float[] f11877z0;

    @Nullable
    public final View A;

    @Nullable
    public final View B;

    @Nullable
    public final View C;

    @Nullable
    public final TextView D;

    @Nullable
    public final TextView E;

    @Nullable
    public final o0 F;
    public final StringBuilder G;
    public final Formatter H;
    public final androidx.media3.common.m0.b I;
    public final androidx.media3.common.m0.c J;
    public final Runnable K;
    public final Drawable L;
    public final Drawable M;
    public final Drawable N;
    public final String O;
    public final String P;
    public final String Q;
    public final Drawable R;
    public final Drawable S;
    public final float T;
    public final float U;
    public final String V;
    public final String W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f11878a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Drawable f11879a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f11880b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final Drawable f11881b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f11882c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final String f11883c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<m> f11884d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final String f11885d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Drawable f11886e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f11887f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Drawable f11888f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f11889g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final String f11890g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f11891h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final String f11892h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f11893i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.h0 f11894i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f11895j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    @Nullable
    public d f11896j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p0 f11897k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f11898k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PopupWindow f11899l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f11900l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f11901m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f11902m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final View f11903n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f11904n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final View f11905o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f11906o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final View f11907p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f11908p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final View f11909q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f11910q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final View f11911r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f11912r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final TextView f11913s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f11914s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public final TextView f11915t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public long[] f11916t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    public final ImageView f11917u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean[] f11918u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    public final ImageView f11919v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public long[] f11920v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final View f11921w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean[] f11922w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final ImageView f11923x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public long f11924x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public final ImageView f11925y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f11926y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    public final ImageView f11927z;

    /* JADX INFO: compiled from: source.java */
    public final class b extends l {
        public b() {
            super();
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void h(i iVar) {
            iVar.f11942b.setText(R$string.exo_track_selection_auto);
            iVar.f11943c.setVisibility(l(((androidx.media3.common.h0) z3.a.e(PlayerControlView.this.f11894i0)).m()) ? 4 : 0);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12105a.n(view);
                }
            });
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void j(String str) {
            PlayerControlView.this.f11889g.g(1, str);
        }

        public final boolean l(androidx.media3.common.p0 p0Var) {
            for (int i11 = 0; i11 < this.f11948i.size(); i11++) {
                if (p0Var.A.containsKey(this.f11948i.get(i11).f11945a.a())) {
                    return true;
                }
            }
            return false;
        }

        public void m(List<k> list) {
            this.f11948i = list;
            androidx.media3.common.p0 p0VarM = ((androidx.media3.common.h0) z3.a.e(PlayerControlView.this.f11894i0)).m();
            if (list.isEmpty()) {
                PlayerControlView.this.f11889g.g(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
                return;
            }
            if (!l(p0VarM)) {
                PlayerControlView.this.f11889g.g(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
                return;
            }
            for (int i11 = 0; i11 < list.size(); i11++) {
                k kVar = list.get(i11);
                if (kVar.a()) {
                    PlayerControlView.this.f11889g.g(1, kVar.f11947c);
                    return;
                }
            }
        }

        public final /* synthetic */ void n(View view) {
            if (PlayerControlView.this.f11894i0 == null || !PlayerControlView.this.f11894i0.i(29)) {
                return;
            }
            ((androidx.media3.common.h0) u0.i(PlayerControlView.this.f11894i0)).T(PlayerControlView.this.f11894i0.m().a().D(1).K(1, false).C());
            PlayerControlView.this.f11889g.g(1, PlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
            PlayerControlView.this.f11899l.dismiss();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements androidx.media3.common.h0.d, o0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // androidx.media3.ui.o0.a
        public void f(o0 o0Var, long j11) {
            PlayerControlView.this.f11908p0 = true;
            if (PlayerControlView.this.E != null) {
                PlayerControlView.this.E.setText(u0.q0(PlayerControlView.this.G, PlayerControlView.this.H, j11));
            }
            PlayerControlView.this.f11878a.W();
        }

        @Override // androidx.media3.common.h0.d
        public /* synthetic */ void onAvailableCommandsChanged(androidx.media3.common.h0.b bVar) {
            androidx.media3.common.i0.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.media3.common.h0 h0Var = PlayerControlView.this.f11894i0;
            if (h0Var == null) {
                return;
            }
            PlayerControlView.this.f11878a.X();
            if (PlayerControlView.this.f11905o == view) {
                if (h0Var.i(9)) {
                    h0Var.n();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f11903n == view) {
                if (h0Var.i(7)) {
                    h0Var.f();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f11909q == view) {
                if (h0Var.getPlaybackState() == 4 || !h0Var.i(12)) {
                    return;
                }
                h0Var.w();
                return;
            }
            if (PlayerControlView.this.f11911r == view) {
                if (h0Var.i(11)) {
                    h0Var.x();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f11907p == view) {
                u0.z0(h0Var, PlayerControlView.this.f11904n0);
                return;
            }
            if (PlayerControlView.this.f11917u == view) {
                if (h0Var.i(15)) {
                    h0Var.setRepeatMode(z3.d0.a(h0Var.getRepeatMode(), PlayerControlView.this.f11914s0));
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f11919v == view) {
                if (h0Var.i(14)) {
                    h0Var.setShuffleModeEnabled(!h0Var.getShuffleModeEnabled());
                    return;
                }
                return;
            }
            if (PlayerControlView.this.A == view) {
                PlayerControlView.this.f11878a.W();
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.T(playerControlView.f11889g, PlayerControlView.this.A);
                return;
            }
            if (PlayerControlView.this.B == view) {
                PlayerControlView.this.f11878a.W();
                PlayerControlView playerControlView2 = PlayerControlView.this;
                playerControlView2.T(playerControlView2.f11891h, PlayerControlView.this.B);
            } else if (PlayerControlView.this.C == view) {
                PlayerControlView.this.f11878a.W();
                PlayerControlView playerControlView3 = PlayerControlView.this;
                playerControlView3.T(playerControlView3.f11895j, PlayerControlView.this.C);
            } else if (PlayerControlView.this.f11923x == view) {
                PlayerControlView.this.f11878a.W();
                PlayerControlView playerControlView4 = PlayerControlView.this;
                playerControlView4.T(playerControlView4.f11893i, PlayerControlView.this.f11923x);
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (PlayerControlView.this.f11926y0) {
                PlayerControlView.this.f11878a.X();
            }
        }

        @Override // androidx.media3.common.h0.d
        public void onEvents(androidx.media3.common.h0 h0Var, androidx.media3.common.h0.c cVar) {
            if (cVar.b(4, 5, 13)) {
                PlayerControlView.this.m0();
            }
            if (cVar.b(4, 5, 7, 13)) {
                PlayerControlView.this.o0();
            }
            if (cVar.b(8, 13)) {
                PlayerControlView.this.p0();
            }
            if (cVar.b(9, 13)) {
                PlayerControlView.this.t0();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                PlayerControlView.this.l0();
            }
            if (cVar.b(11, 0, 13)) {
                PlayerControlView.this.u0();
            }
            if (cVar.b(12, 13)) {
                PlayerControlView.this.n0();
            }
            if (cVar.b(2, 13)) {
                PlayerControlView.this.v0();
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
            if (PlayerControlView.this.E != null) {
                PlayerControlView.this.E.setText(u0.q0(PlayerControlView.this.G, PlayerControlView.this.H, j11));
            }
        }

        @Override // androidx.media3.ui.o0.a
        public void r(o0 o0Var, long j11, boolean z11) {
            PlayerControlView.this.f11908p0 = false;
            if (!z11 && PlayerControlView.this.f11894i0 != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.e0(playerControlView.f11894i0, j11);
            }
            PlayerControlView.this.f11878a.X();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface d {
        void p(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public final class e extends RecyclerView.Adapter<i> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String[] f11930i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f11931j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11932k;

        public e(String[] strArr, float[] fArr) {
            this.f11930i = strArr;
            this.f11931j = fArr;
        }

        public String e() {
            return this.f11930i[this.f11932k];
        }

        public final /* synthetic */ void f(int i11, View view) {
            if (i11 != this.f11932k) {
                PlayerControlView.this.setPlaybackSpeed(this.f11931j[i11]);
            }
            PlayerControlView.this.f11899l.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i11) {
            String[] strArr = this.f11930i;
            if (i11 < strArr.length) {
                iVar.f11942b.setText(strArr[i11]);
            }
            if (i11 == this.f11932k) {
                iVar.itemView.setSelected(true);
                iVar.f11943c.setVisibility(0);
            } else {
                iVar.itemView.setSelected(false);
                iVar.f11943c.setVisibility(4);
            }
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12106a.f(i11, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11930i.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void i(float f11) {
            int i11 = 0;
            int i12 = 0;
            float f12 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.f11931j;
                if (i11 >= fArr.length) {
                    this.f11932k = i12;
                    return;
                }
                float fAbs = Math.abs(f11 - fArr[i11]);
                if (fAbs < f12) {
                    i12 = i11;
                    f12 = fAbs;
                }
                i11++;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
    }

    /* JADX INFO: compiled from: source.java */
    public final class g extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f11934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f11935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f11936d;

        public g(View view) {
            super(view);
            if (u0.f81838a < 26) {
                view.setFocusable(true);
            }
            this.f11934b = (TextView) view.findViewById(R$id.exo_main_text);
            this.f11935c = (TextView) view.findViewById(R$id.exo_sub_text);
            this.f11936d = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f12108a.i(view2);
                }
            });
        }

        public final /* synthetic */ void i(View view) {
            PlayerControlView.this.c0(getBindingAdapterPosition());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends RecyclerView.Adapter<g> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String[] f11938i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String[] f11939j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Drawable[] f11940k;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f11938i = strArr;
            this.f11939j = new String[strArr.length];
            this.f11940k = drawableArr;
        }

        public boolean d() {
            return h(1) || h(0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i11) {
            if (h(i11)) {
                gVar.itemView.setLayoutParams(new RecyclerView.n(-1, -2));
            } else {
                gVar.itemView.setLayoutParams(new RecyclerView.n(0, 0));
            }
            gVar.f11934b.setText(this.f11938i[i11]);
            if (this.f11939j[i11] == null) {
                gVar.f11935c.setVisibility(8);
            } else {
                gVar.f11935c.setText(this.f11939j[i11]);
            }
            if (this.f11940k[i11] == null) {
                gVar.f11936d.setVisibility(8);
            } else {
                gVar.f11936d.setImageDrawable(this.f11940k[i11]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return PlayerControlView.this.new g(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void g(int i11, String str) {
            this.f11939j[i11] = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f11938i.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        public final boolean h(int i11) {
            if (PlayerControlView.this.f11894i0 == null) {
                return false;
            }
            if (i11 == 0) {
                return PlayerControlView.this.f11894i0.i(13);
            }
            if (i11 != 1) {
                return true;
            }
            return PlayerControlView.this.f11894i0.i(30) && PlayerControlView.this.f11894i0.i(29);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f11942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f11943c;

        public i(View view) {
            super(view);
            if (u0.f81838a < 26) {
                view.setFocusable(true);
            }
            this.f11942b = (TextView) view.findViewById(R$id.exo_text);
            this.f11943c = view.findViewById(R$id.exo_check);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class j extends l {
        public j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            if (PlayerControlView.this.f11894i0 == null || !PlayerControlView.this.f11894i0.i(29)) {
                return;
            }
            PlayerControlView.this.f11894i0.T(PlayerControlView.this.f11894i0.m().a().D(3).G(-3).C());
            PlayerControlView.this.f11899l.dismiss();
        }

        @Override // androidx.media3.ui.PlayerControlView.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i11) {
            super.onBindViewHolder(iVar, i11);
            if (i11 > 0) {
                iVar.f11943c.setVisibility(this.f11948i.get(i11 + (-1)).a() ? 0 : 4);
            }
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void h(i iVar) {
            boolean z11;
            iVar.f11942b.setText(R$string.exo_track_selection_none);
            int i11 = 0;
            while (true) {
                if (i11 >= this.f11948i.size()) {
                    z11 = true;
                    break;
                } else {
                    if (this.f11948i.get(i11).a()) {
                        z11 = false;
                        break;
                    }
                    i11++;
                }
            }
            iVar.f11943c.setVisibility(z11 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12109a.m(view);
                }
            });
        }

        @Override // androidx.media3.ui.PlayerControlView.l
        public void j(String str) {
        }

        public void l(List<k> list) {
            boolean z11 = false;
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (list.get(i11).a()) {
                    z11 = true;
                    break;
                }
            }
            if (PlayerControlView.this.f11923x != null) {
                ImageView imageView = PlayerControlView.this.f11923x;
                PlayerControlView playerControlView = PlayerControlView.this;
                imageView.setImageDrawable(z11 ? playerControlView.f11879a0 : playerControlView.f11881b0);
                PlayerControlView.this.f11923x.setContentDescription(z11 ? PlayerControlView.this.f11883c0 : PlayerControlView.this.f11885d0);
            }
            this.f11948i = list;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.media3.common.q0.a f11945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11947c;

        public k(androidx.media3.common.q0 q0Var, int i11, int i12, String str) {
            this.f11945a = q0Var.a().get(i11);
            this.f11946b = i12;
            this.f11947c = str;
        }

        public boolean a() {
            return this.f11945a.h(this.f11946b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class l extends RecyclerView.Adapter<i> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<k> f11948i = new ArrayList();

        public l() {
        }

        public void e() {
            this.f11948i = Collections.emptyList();
        }

        public final /* synthetic */ void f(androidx.media3.common.h0 h0Var, androidx.media3.common.n0 n0Var, k kVar, View view) {
            if (h0Var.i(29)) {
                h0Var.T(h0Var.m().a().H(new androidx.media3.common.o0(n0Var, ImmutableList.of(Integer.valueOf(kVar.f11946b)))).K(kVar.f11945a.d(), false).C());
                j(kVar.f11947c);
                PlayerControlView.this.f11899l.dismiss();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g */
        public void onBindViewHolder(i iVar, int i11) {
            final androidx.media3.common.h0 h0Var = PlayerControlView.this.f11894i0;
            if (h0Var == null) {
                return;
            }
            if (i11 == 0) {
                h(iVar);
                return;
            }
            final k kVar = this.f11948i.get(i11 - 1);
            final androidx.media3.common.n0 n0VarA = kVar.f11945a.a();
            boolean z11 = h0Var.m().A.get(n0VarA) != null && kVar.a();
            iVar.f11942b.setText(kVar.f11947c);
            iVar.f11943c.setVisibility(z11 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12111a.f(h0Var, n0VarA, kVar, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f11948i.isEmpty()) {
                return 0;
            }
            return this.f11948i.size() + 1;
        }

        public abstract void h(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public abstract void j(String str);
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface m {
        void f(int i11);
    }

    static {
        androidx.media3.common.c0.a("media3.ui");
        f11877z0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
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
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        TextView textView;
        super(context, attributeSet, i11);
        int resourceId = R$layout.exo_player_control_view;
        this.f11904n0 = true;
        this.f11910q0 = 5000;
        this.f11914s0 = 0;
        this.f11912r0 = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i11, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, resourceId);
                this.f11910q0 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.f11910q0);
                this.f11914s0 = V(typedArrayObtainStyledAttributes, this.f11914s0);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, true);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, true);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, false);
                boolean z25 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_subtitle_button, false);
                boolean z26 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.f11912r0));
                boolean z27 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z18 = z25;
                z15 = z22;
                z12 = z26;
                z16 = z23;
                z13 = z19;
                z14 = z21;
                z11 = z27;
                z17 = z24;
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            z11 = true;
            z12 = false;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = true;
            z17 = false;
            z18 = false;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        c cVar = new c();
        this.f11882c = cVar;
        this.f11884d = new CopyOnWriteArrayList<>();
        this.I = new androidx.media3.common.m0.b();
        this.J = new androidx.media3.common.m0.c();
        StringBuilder sb2 = new StringBuilder();
        this.G = sb2;
        this.H = new Formatter(sb2, Locale.getDefault());
        this.f11916t0 = new long[0];
        this.f11918u0 = new boolean[0];
        this.f11920v0 = new long[0];
        this.f11922w0 = new boolean[0];
        this.K = new Runnable() { // from class: androidx.media3.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f12076a.o0();
            }
        };
        this.D = (TextView) findViewById(R$id.exo_duration);
        this.E = (TextView) findViewById(R$id.exo_position);
        ImageView imageView = (ImageView) findViewById(R$id.exo_subtitle);
        this.f11923x = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_fullscreen);
        this.f11925y = imageView2;
        X(imageView2, new View.OnClickListener() { // from class: androidx.media3.ui.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12103a.a0(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R$id.exo_minimal_fullscreen);
        this.f11927z = imageView3;
        X(imageView3, new View.OnClickListener() { // from class: androidx.media3.ui.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12103a.a0(view);
            }
        });
        View viewFindViewById = findViewById(R$id.exo_settings);
        this.A = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar);
        }
        View viewFindViewById2 = findViewById(R$id.exo_playback_speed);
        this.B = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R$id.exo_audio_track);
        this.C = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        o0 o0Var = (o0) findViewById(R$id.exo_progress);
        View viewFindViewById4 = findViewById(R$id.exo_progress_placeholder);
        if (o0Var != null) {
            this.F = o0Var;
            textView = null;
        } else if (viewFindViewById4 != null) {
            textView = null;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(R$id.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.F = defaultTimeBar;
        } else {
            textView = null;
            this.F = null;
        }
        o0 o0Var2 = this.F;
        if (o0Var2 != null) {
            o0Var2.addListener(cVar);
        }
        View viewFindViewById5 = findViewById(R$id.exo_play_pause);
        this.f11907p = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R$id.exo_prev);
        this.f11903n = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R$id.exo_next);
        this.f11905o = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        Typeface typefaceG = b3.h.g(context, R$font.roboto_medium_numbers);
        View viewFindViewById8 = findViewById(R$id.exo_rew);
        TextView textView2 = viewFindViewById8 == null ? (TextView) findViewById(R$id.exo_rew_with_amount) : textView;
        this.f11915t = textView2;
        if (textView2 != null) {
            textView2.setTypeface(typefaceG);
        }
        viewFindViewById8 = viewFindViewById8 == null ? textView2 : viewFindViewById8;
        this.f11911r = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(cVar);
        }
        View viewFindViewById9 = findViewById(R$id.exo_ffwd);
        TextView textView3 = viewFindViewById9 == null ? (TextView) findViewById(R$id.exo_ffwd_with_amount) : null;
        this.f11913s = textView3;
        if (textView3 != null) {
            textView3.setTypeface(typefaceG);
        }
        viewFindViewById9 = viewFindViewById9 == null ? textView3 : viewFindViewById9;
        this.f11909q = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(cVar);
        }
        ImageView imageView4 = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f11917u = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f11919v = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar);
        }
        Resources resources = context.getResources();
        this.f11880b = resources;
        this.T = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.U = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById10 = findViewById(R$id.exo_vr);
        this.f11921w = viewFindViewById10;
        boolean z28 = z18;
        if (viewFindViewById10 != null) {
            h0(false, viewFindViewById10);
        }
        f0 f0Var = new f0(this);
        this.f11878a = f0Var;
        f0Var.Y(z11);
        boolean z29 = z17;
        h hVar = new h(new String[]{resources.getString(R$string.exo_controls_playback_speed), resources.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{u0.a0(context, resources, R$drawable.exo_styled_controls_speed), u0.a0(context, resources, R$drawable.exo_styled_controls_audiotrack)});
        this.f11889g = hVar;
        this.f11901m = resources.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, (ViewGroup) null);
        this.f11887f = recyclerView;
        recyclerView.setAdapter(hVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.f11899l = popupWindow;
        if (u0.f81838a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(cVar);
        this.f11926y0 = true;
        this.f11897k = new androidx.media3.ui.g(getResources());
        this.f11879a0 = u0.a0(context, resources, R$drawable.exo_styled_controls_subtitle_on);
        this.f11881b0 = u0.a0(context, resources, R$drawable.exo_styled_controls_subtitle_off);
        this.f11883c0 = resources.getString(R$string.exo_controls_cc_enabled_description);
        this.f11885d0 = resources.getString(R$string.exo_controls_cc_disabled_description);
        this.f11893i = new j();
        this.f11895j = new b();
        this.f11891h = new e(resources.getStringArray(R$array.exo_controls_playback_speeds), f11877z0);
        this.f11886e0 = u0.a0(context, resources, R$drawable.exo_styled_controls_fullscreen_exit);
        this.f11888f0 = u0.a0(context, resources, R$drawable.exo_styled_controls_fullscreen_enter);
        this.L = u0.a0(context, resources, R$drawable.exo_styled_controls_repeat_off);
        this.M = u0.a0(context, resources, R$drawable.exo_styled_controls_repeat_one);
        this.N = u0.a0(context, resources, R$drawable.exo_styled_controls_repeat_all);
        this.R = u0.a0(context, resources, R$drawable.exo_styled_controls_shuffle_on);
        this.S = u0.a0(context, resources, R$drawable.exo_styled_controls_shuffle_off);
        this.f11890g0 = resources.getString(R$string.exo_controls_fullscreen_exit_description);
        this.f11892h0 = resources.getString(R$string.exo_controls_fullscreen_enter_description);
        this.O = resources.getString(R$string.exo_controls_repeat_off_description);
        this.P = resources.getString(R$string.exo_controls_repeat_one_description);
        this.Q = resources.getString(R$string.exo_controls_repeat_all_description);
        this.V = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.W = resources.getString(R$string.exo_controls_shuffle_off_description);
        f0Var.Z((ViewGroup) findViewById(R$id.exo_bottom_bar), true);
        f0Var.Z(viewFindViewById9, z14);
        f0Var.Z(viewFindViewById8, z13);
        f0Var.Z(viewFindViewById6, z15);
        f0Var.Z(viewFindViewById7, z16);
        f0Var.Z(imageView5, z29);
        f0Var.Z(imageView, z28);
        f0Var.Z(viewFindViewById10, z12);
        f0Var.Z(imageView4, this.f11914s0 != 0);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.media3.ui.m
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                this.f12104a.b0(view, i12, i13, i14, i15, i16, i17, i18, i19);
            }
        });
    }

    public static boolean S(androidx.media3.common.h0 h0Var, androidx.media3.common.m0.c cVar) {
        androidx.media3.common.m0 currentTimeline;
        int iP;
        if (!h0Var.i(17) || (iP = (currentTimeline = h0Var.getCurrentTimeline()).p()) <= 1 || iP > 100) {
            return false;
        }
        for (int i11 = 0; i11 < iP; i11++) {
            if (currentTimeline.n(i11, cVar).f9322n == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    public static int V(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i11);
    }

    public static void X(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean Y(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    public static void k0(@Nullable View view, boolean z11) {
        if (view == null) {
            return;
        }
        if (z11) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f11) {
        androidx.media3.common.h0 h0Var = this.f11894i0;
        if (h0Var == null || !h0Var.i(13)) {
            return;
        }
        androidx.media3.common.h0 h0Var2 = this.f11894i0;
        h0Var2.b(h0Var2.getPlaybackParameters().b(f11));
    }

    public final void T(RecyclerView.Adapter<?> adapter, View view) {
        this.f11887f.setAdapter(adapter);
        s0();
        this.f11926y0 = false;
        this.f11899l.dismiss();
        this.f11926y0 = true;
        this.f11899l.showAsDropDown(view, (getWidth() - this.f11899l.getWidth()) - this.f11901m, (-this.f11899l.getHeight()) - this.f11901m);
    }

    public final ImmutableList<k> U(androidx.media3.common.q0 q0Var, int i11) {
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList<androidx.media3.common.q0.a> immutableListA = q0Var.a();
        for (int i12 = 0; i12 < immutableListA.size(); i12++) {
            androidx.media3.common.q0.a aVar2 = immutableListA.get(i12);
            if (aVar2.d() == i11) {
                for (int i13 = 0; i13 < aVar2.f9435a; i13++) {
                    if (aVar2.i(i13)) {
                        androidx.media3.common.y yVarB = aVar2.b(i13);
                        if ((yVarB.f9493e & 2) == 0) {
                            aVar.a(new k(q0Var, i12, i13, this.f11897k.a(yVarB)));
                        }
                    }
                }
            }
        }
        return aVar.m();
    }

    public final void W() {
        this.f11893i.e();
        this.f11895j.e();
        androidx.media3.common.h0 h0Var = this.f11894i0;
        if (h0Var != null && h0Var.i(30) && this.f11894i0.i(29)) {
            androidx.media3.common.q0 currentTracks = this.f11894i0.getCurrentTracks();
            this.f11895j.m(U(currentTracks, 1));
            if (this.f11878a.A(this.f11923x)) {
                this.f11893i.l(U(currentTracks, 3));
            } else {
                this.f11893i.l(ImmutableList.of());
            }
        }
    }

    public void Z() {
        Iterator<m> it = this.f11884d.iterator();
        while (it.hasNext()) {
            it.next().f(getVisibility());
        }
    }

    public final void a0(View view) {
        if (this.f11896j0 == null) {
            return;
        }
        boolean z11 = !this.f11898k0;
        this.f11898k0 = z11;
        j0(this.f11925y, z11);
        j0(this.f11927z, this.f11898k0);
        d dVar = this.f11896j0;
        if (dVar != null) {
            dVar.p(this.f11898k0);
        }
    }

    @Deprecated
    public void addVisibilityListener(m mVar) {
        z3.a.e(mVar);
        this.f11884d.add(mVar);
    }

    public final void b0(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = i14 - i12;
        int i21 = i18 - i16;
        if (!(i13 - i11 == i17 - i15 && i19 == i21) && this.f11899l.isShowing()) {
            s0();
            this.f11899l.update(view, (getWidth() - this.f11899l.getWidth()) - this.f11901m, (-this.f11899l.getHeight()) - this.f11901m, -1, -1);
        }
    }

    public final void c0(int i11) {
        if (i11 == 0) {
            T(this.f11891h, (View) z3.a.e(this.A));
        } else if (i11 == 1) {
            T(this.f11895j, (View) z3.a.e(this.A));
        } else {
            this.f11899l.dismiss();
        }
    }

    public void d0() {
        View view = this.f11907p;
        if (view != null) {
            view.requestFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.media3.common.h0 h0Var = this.f11894i0;
        if (h0Var == null || !Y(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (h0Var.getPlaybackState() == 4 || !h0Var.i(12)) {
                return true;
            }
            h0Var.w();
            return true;
        }
        if (keyCode == 89 && h0Var.i(11)) {
            h0Var.x();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            u0.z0(h0Var, this.f11904n0);
            return true;
        }
        if (keyCode == 87) {
            if (!h0Var.i(9)) {
                return true;
            }
            h0Var.n();
            return true;
        }
        if (keyCode == 88) {
            if (!h0Var.i(7)) {
                return true;
            }
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

    public final void e0(androidx.media3.common.h0 h0Var, long j11) {
        if (this.f11906o0) {
            if (h0Var.i(17) && h0Var.i(10)) {
                androidx.media3.common.m0 currentTimeline = h0Var.getCurrentTimeline();
                int iP = currentTimeline.p();
                int i11 = 0;
                while (true) {
                    long jD = currentTimeline.n(i11, this.J).d();
                    if (j11 < jD) {
                        break;
                    }
                    if (i11 == iP - 1) {
                        j11 = jD;
                        break;
                    } else {
                        j11 -= jD;
                        i11++;
                    }
                }
                h0Var.seekTo(i11, j11);
            }
        } else if (h0Var.i(5)) {
            h0Var.seekTo(j11);
        }
        o0();
    }

    public final boolean f0() {
        androidx.media3.common.h0 h0Var = this.f11894i0;
        return (h0Var == null || !h0Var.i(1) || (this.f11894i0.i(17) && this.f11894i0.getCurrentTimeline().q())) ? false : true;
    }

    public void g0() {
        m0();
        l0();
        p0();
        t0();
        v0();
        n0();
        u0();
    }

    @Nullable
    public androidx.media3.common.h0 getPlayer() {
        return this.f11894i0;
    }

    public int getRepeatToggleModes() {
        return this.f11914s0;
    }

    public boolean getShowShuffleButton() {
        return this.f11878a.A(this.f11919v);
    }

    public boolean getShowSubtitleButton() {
        return this.f11878a.A(this.f11923x);
    }

    public int getShowTimeoutMs() {
        return this.f11910q0;
    }

    public boolean getShowVrButton() {
        return this.f11878a.A(this.f11921w);
    }

    public final void h0(boolean z11, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z11);
        view.setAlpha(z11 ? this.T : this.U);
    }

    public void hide() {
        this.f11878a.C();
    }

    public void hideImmediately() {
        this.f11878a.F();
    }

    public final void i0() {
        androidx.media3.common.h0 h0Var = this.f11894i0;
        int iS = (int) ((h0Var != null ? h0Var.s() : 15000L) / 1000);
        TextView textView = this.f11913s;
        if (textView != null) {
            textView.setText(String.valueOf(iS));
        }
        View view = this.f11909q;
        if (view != null) {
            view.setContentDescription(this.f11880b.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, iS, Integer.valueOf(iS)));
        }
    }

    public boolean isAnimationEnabled() {
        return this.f11878a.I();
    }

    public boolean isFullyVisible() {
        return this.f11878a.J();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public final void j0(@Nullable ImageView imageView, boolean z11) {
        if (imageView == null) {
            return;
        }
        if (z11) {
            imageView.setImageDrawable(this.f11886e0);
            imageView.setContentDescription(this.f11890g0);
        } else {
            imageView.setImageDrawable(this.f11888f0);
            imageView.setContentDescription(this.f11892h0);
        }
    }

    public final void l0() {
        boolean zI;
        boolean zI2;
        boolean zI3;
        boolean zI4;
        boolean zI5;
        if (isVisible() && this.f11900l0) {
            androidx.media3.common.h0 h0Var = this.f11894i0;
            if (h0Var != null) {
                zI = (this.f11902m0 && S(h0Var, this.J)) ? h0Var.i(10) : h0Var.i(5);
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
            if (zI4) {
                q0();
            }
            if (zI5) {
                i0();
            }
            h0(zI3, this.f11903n);
            h0(zI4, this.f11911r);
            h0(zI5, this.f11909q);
            h0(zI2, this.f11905o);
            o0 o0Var = this.F;
            if (o0Var != null) {
                o0Var.setEnabled(zI);
            }
        }
    }

    public final void m0() {
        if (isVisible() && this.f11900l0 && this.f11907p != null) {
            boolean zL1 = u0.l1(this.f11894i0, this.f11904n0);
            int i11 = zL1 ? R$drawable.exo_styled_controls_play : R$drawable.exo_styled_controls_pause;
            int i12 = zL1 ? R$string.exo_controls_play_description : R$string.exo_controls_pause_description;
            ((ImageView) this.f11907p).setImageDrawable(u0.a0(getContext(), this.f11880b, i11));
            this.f11907p.setContentDescription(this.f11880b.getString(i12));
            h0(f0(), this.f11907p);
        }
    }

    public final void n0() {
        androidx.media3.common.h0 h0Var = this.f11894i0;
        if (h0Var == null) {
            return;
        }
        this.f11891h.i(h0Var.getPlaybackParameters().f9222a);
        this.f11889g.g(0, this.f11891h.e());
        r0();
    }

    public final void o0() {
        long contentPosition;
        long jV;
        if (isVisible() && this.f11900l0) {
            androidx.media3.common.h0 h0Var = this.f11894i0;
            if (h0Var == null || !h0Var.i(16)) {
                contentPosition = 0;
                jV = 0;
            } else {
                contentPosition = this.f11924x0 + h0Var.getContentPosition();
                jV = this.f11924x0 + h0Var.v();
            }
            TextView textView = this.E;
            if (textView != null && !this.f11908p0) {
                textView.setText(u0.q0(this.G, this.H, contentPosition));
            }
            o0 o0Var = this.F;
            if (o0Var != null) {
                o0Var.setPosition(contentPosition);
                this.F.setBufferedPosition(jV);
            }
            removeCallbacks(this.K);
            int playbackState = h0Var == null ? 1 : h0Var.getPlaybackState();
            if (h0Var == null || !h0Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.K, 1000L);
                return;
            }
            o0 o0Var2 = this.F;
            long jMin = Math.min(o0Var2 != null ? o0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f11 = h0Var.getPlaybackParameters().f9222a;
            postDelayed(this.K, u0.q(f11 > 0.0f ? (long) (jMin / f11) : 1000L, this.f11912r0, 1000L));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11878a.P();
        this.f11900l0 = true;
        if (isFullyVisible()) {
            this.f11878a.X();
        }
        g0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11878a.Q();
        this.f11900l0 = false;
        removeCallbacks(this.K);
        this.f11878a.W();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f11878a.R(z11, i11, i12, i13, i14);
    }

    public final void p0() {
        ImageView imageView;
        if (isVisible() && this.f11900l0 && (imageView = this.f11917u) != null) {
            if (this.f11914s0 == 0) {
                h0(false, imageView);
                return;
            }
            androidx.media3.common.h0 h0Var = this.f11894i0;
            if (h0Var == null || !h0Var.i(15)) {
                h0(false, this.f11917u);
                this.f11917u.setImageDrawable(this.L);
                this.f11917u.setContentDescription(this.O);
                return;
            }
            h0(true, this.f11917u);
            int repeatMode = h0Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f11917u.setImageDrawable(this.L);
                this.f11917u.setContentDescription(this.O);
            } else if (repeatMode == 1) {
                this.f11917u.setImageDrawable(this.M);
                this.f11917u.setContentDescription(this.P);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.f11917u.setImageDrawable(this.N);
                this.f11917u.setContentDescription(this.Q);
            }
        }
    }

    public final void q0() {
        androidx.media3.common.h0 h0Var = this.f11894i0;
        int iZ = (int) ((h0Var != null ? h0Var.z() : 5000L) / 1000);
        TextView textView = this.f11915t;
        if (textView != null) {
            textView.setText(String.valueOf(iZ));
        }
        View view = this.f11911r;
        if (view != null) {
            view.setContentDescription(this.f11880b.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, iZ, Integer.valueOf(iZ)));
        }
    }

    public final void r0() {
        h0(this.f11889g.d(), this.A);
    }

    @Deprecated
    public void removeVisibilityListener(m mVar) {
        this.f11884d.remove(mVar);
    }

    public final void s0() {
        this.f11887f.measure(0, 0);
        this.f11899l.setWidth(Math.min(this.f11887f.getMeasuredWidth(), getWidth() - (this.f11901m * 2)));
        this.f11899l.setHeight(Math.min(getHeight() - (this.f11901m * 2), this.f11887f.getMeasuredHeight()));
    }

    public void setAnimationEnabled(boolean z11) {
        this.f11878a.Y(z11);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f11920v0 = new long[0];
            this.f11922w0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) z3.a.e(zArr);
            z3.a.a(jArr.length == zArr2.length);
            this.f11920v0 = jArr;
            this.f11922w0 = zArr2;
        }
        u0();
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        this.f11896j0 = dVar;
        k0(this.f11925y, dVar != null);
        k0(this.f11927z, dVar != null);
    }

    public void setPlayer(@Nullable androidx.media3.common.h0 h0Var) {
        z3.a.g(Looper.myLooper() == Looper.getMainLooper());
        z3.a.a(h0Var == null || h0Var.l() == Looper.getMainLooper());
        androidx.media3.common.h0 h0Var2 = this.f11894i0;
        if (h0Var2 == h0Var) {
            return;
        }
        if (h0Var2 != null) {
            h0Var2.J(this.f11882c);
        }
        this.f11894i0 = h0Var;
        if (h0Var != null) {
            h0Var.K(this.f11882c);
        }
        g0();
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.f11914s0 = i11;
        androidx.media3.common.h0 h0Var = this.f11894i0;
        if (h0Var != null && h0Var.i(15)) {
            int repeatMode = this.f11894i0.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.f11894i0.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.f11894i0.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.f11894i0.setRepeatMode(2);
            }
        }
        this.f11878a.Z(this.f11917u, i11 != 0);
        p0();
    }

    public void setShowFastForwardButton(boolean z11) {
        this.f11878a.Z(this.f11909q, z11);
        l0();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z11) {
        this.f11902m0 = z11;
        u0();
    }

    public void setShowNextButton(boolean z11) {
        this.f11878a.Z(this.f11905o, z11);
        l0();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z11) {
        this.f11904n0 = z11;
        m0();
    }

    public void setShowPreviousButton(boolean z11) {
        this.f11878a.Z(this.f11903n, z11);
        l0();
    }

    public void setShowRewindButton(boolean z11) {
        this.f11878a.Z(this.f11911r, z11);
        l0();
    }

    public void setShowShuffleButton(boolean z11) {
        this.f11878a.Z(this.f11919v, z11);
        t0();
    }

    public void setShowSubtitleButton(boolean z11) {
        this.f11878a.Z(this.f11923x, z11);
    }

    public void setShowTimeoutMs(int i11) {
        this.f11910q0 = i11;
        if (isFullyVisible()) {
            this.f11878a.X();
        }
    }

    public void setShowVrButton(boolean z11) {
        this.f11878a.Z(this.f11921w, z11);
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.f11912r0 = u0.p(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f11921w;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            h0(onClickListener != null, this.f11921w);
        }
    }

    public void show() {
        this.f11878a.c0();
    }

    public final void t0() {
        ImageView imageView;
        if (isVisible() && this.f11900l0 && (imageView = this.f11919v) != null) {
            androidx.media3.common.h0 h0Var = this.f11894i0;
            if (!this.f11878a.A(imageView)) {
                h0(false, this.f11919v);
                return;
            }
            if (h0Var == null || !h0Var.i(14)) {
                h0(false, this.f11919v);
                this.f11919v.setImageDrawable(this.S);
                this.f11919v.setContentDescription(this.W);
            } else {
                h0(true, this.f11919v);
                this.f11919v.setImageDrawable(h0Var.getShuffleModeEnabled() ? this.R : this.S);
                this.f11919v.setContentDescription(h0Var.getShuffleModeEnabled() ? this.V : this.W);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:62:0x0107  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dd A[SYNTHETIC] */
    public final void u0() {
        long jS0;
        int i11;
        androidx.media3.common.m0.c cVar;
        long jO;
        long[] jArr;
        int length;
        androidx.media3.common.h0 h0Var = this.f11894i0;
        if (h0Var == null) {
            return;
        }
        boolean z11 = true;
        this.f11906o0 = this.f11902m0 && S(h0Var, this.J);
        this.f11924x0 = 0L;
        androidx.media3.common.m0 currentTimeline = h0Var.i(17) ? h0Var.getCurrentTimeline() : androidx.media3.common.m0.f9282a;
        if (currentTimeline.q()) {
            if (h0Var.i(16)) {
                long jP = h0Var.P();
                if (jP != C.TIME_UNSET) {
                    jS0 = u0.S0(jP);
                } else {
                    jS0 = 0;
                }
            } else {
                jS0 = 0;
            }
            i11 = 0;
        } else {
            int iU = h0Var.u();
            boolean z12 = this.f11906o0;
            int i12 = z12 ? 0 : iU;
            int iP = z12 ? currentTimeline.p() - 1 : iU;
            long j11 = 0;
            i11 = 0;
            while (i12 <= iP) {
                if (i12 == iU) {
                    this.f11924x0 = u0.B1(j11);
                }
                currentTimeline.n(i12, this.J);
                androidx.media3.common.m0.c cVar2 = this.J;
                if (cVar2.f9322n == C.TIME_UNSET) {
                    z3.a.g(this.f11906o0 ^ z11);
                    break;
                }
                int i13 = cVar2.f9323o;
                while (true) {
                    cVar = this.J;
                    if (i13 <= cVar.f9324p) {
                        currentTimeline.f(i13, this.I);
                        int iC = this.I.c();
                        for (int iP2 = this.I.p(); iP2 < iC; iP2++) {
                            long jF = this.I.f(iP2);
                            if (jF == Long.MIN_VALUE) {
                                long j12 = this.I.f9296d;
                                if (j12 != C.TIME_UNSET) {
                                    jF = j12;
                                    jO = jF + this.I.o();
                                    if (jO >= 0) {
                                        jArr = this.f11916t0;
                                        if (i11 == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.f11916t0 = Arrays.copyOf(jArr, length);
                                            this.f11918u0 = Arrays.copyOf(this.f11918u0, length);
                                        }
                                        this.f11916t0[i11] = u0.B1(j11 + jO);
                                        this.f11918u0[i11] = this.I.q(iP2);
                                        i11++;
                                    }
                                }
                            } else {
                                jO = jF + this.I.o();
                                if (jO >= 0) {
                                    jArr = this.f11916t0;
                                    if (i11 == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.f11916t0 = Arrays.copyOf(jArr, length);
                                        this.f11918u0 = Arrays.copyOf(this.f11918u0, length);
                                    }
                                    this.f11916t0[i11] = u0.B1(j11 + jO);
                                    this.f11918u0[i11] = this.I.q(iP2);
                                    i11++;
                                }
                            }
                        }
                        i13++;
                    }
                }
                j11 += cVar.f9322n;
                i12++;
                z11 = true;
            }
            jS0 = j11;
        }
        long jB1 = u0.B1(jS0);
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(u0.q0(this.G, this.H, jB1));
        }
        o0 o0Var = this.F;
        if (o0Var != null) {
            o0Var.setDuration(jB1);
            int length2 = this.f11920v0.length;
            int i14 = i11 + length2;
            long[] jArr2 = this.f11916t0;
            if (i14 > jArr2.length) {
                this.f11916t0 = Arrays.copyOf(jArr2, i14);
                this.f11918u0 = Arrays.copyOf(this.f11918u0, i14);
            }
            System.arraycopy(this.f11920v0, 0, this.f11916t0, i11, length2);
            System.arraycopy(this.f11922w0, 0, this.f11918u0, i11, length2);
            this.F.setAdGroupTimesMs(this.f11916t0, this.f11918u0, i14);
        }
        o0();
    }

    public final void v0() {
        W();
        h0(this.f11893i.getItemCount() > 0, this.f11923x);
        r0();
    }
}
