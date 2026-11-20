package com.google.android.exoplayer2.ui;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.j3;
import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m2;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.p2;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.z1;
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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class StyledPlayerControlView extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final float[] f34957y0;
    public final String A;
    public final Drawable B;
    public final Drawable C;
    public final float D;
    public final float E;
    public final String F;
    public final String G;
    public final Drawable H;
    public final Drawable I;
    public final String J;
    public final String K;
    public final Drawable L;
    public final Drawable M;
    public final String N;
    public final String O;

    @Nullable
    public n2 P;

    @Nullable
    public d Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f34958a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f34959a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<m> f34960b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f34961b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final View f34962c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public long[] f34963c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f34964d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean[] f34965d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long[] f34966e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final View f34967f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean[] f34968f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final View f34969g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f34970g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final View f34971h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public i0 f34972h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final TextView f34973i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Resources f34974i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final TextView f34975j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public RecyclerView f34976j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final ImageView f34977k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public h f34978k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final ImageView f34979l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public e f34980l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public final View f34981m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public PopupWindow f34982m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public final TextView f34983n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f34984n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public final TextView f34985o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f34986o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final n0 f34987p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public j f34988p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final StringBuilder f34989q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public b f34990q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Formatter f34991r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public o0 f34992r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j3.b f34993s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    @Nullable
    public ImageView f34994s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final j3.d f34995t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    @Nullable
    public ImageView f34996t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f34997u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    @Nullable
    public ImageView f34998u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Drawable f34999v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    @Nullable
    public View f35000v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Drawable f35001w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    @Nullable
    public View f35002w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Drawable f35003x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    @Nullable
    public View f35004x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f35005y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f35006z;

    /* JADX INFO: compiled from: source.java */
    public final class b extends l {
        public b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(View view) {
            if (StyledPlayerControlView.this.P == null) {
                return;
            }
            ((n2) com.google.android.exoplayer2.util.o0.j(StyledPlayerControlView.this.P)).B(StyledPlayerControlView.this.P.m().a().B(1).J(1, false).A());
            StyledPlayerControlView.this.f34978k0.f(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
            StyledPlayerControlView.this.f34982m0.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void h(i iVar) {
            iVar.f35021b.setText(R$string.exo_track_selection_auto);
            iVar.f35022c.setVisibility(l(((n2) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.P)).m()) ? 4 : 0);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f35191a.n(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void j(String str) {
            StyledPlayerControlView.this.f34978k0.f(1, str);
        }

        public final boolean l(fi.z zVar) {
            for (int i11 = 0; i11 < this.f35027i.size(); i11++) {
                if (zVar.f65081z.containsKey(this.f35027i.get(i11).f35024a.b())) {
                    return true;
                }
            }
            return false;
        }

        public void m(List<k> list) {
            this.f35027i = list;
            fi.z zVarM = ((n2) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.P)).m();
            if (list.isEmpty()) {
                StyledPlayerControlView.this.f34978k0.f(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
                return;
            }
            if (!l(zVarM)) {
                StyledPlayerControlView.this.f34978k0.f(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
                return;
            }
            for (int i11 = 0; i11 < list.size(); i11++) {
                k kVar = list.get(i11);
                if (kVar.a()) {
                    StyledPlayerControlView.this.f34978k0.f(1, kVar.f35026c);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements n2.d, n0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void f(n0 n0Var, long j11) {
            if (StyledPlayerControlView.this.f34985o != null) {
                StyledPlayerControlView.this.f34985o.setText(com.google.android.exoplayer2.util.o0.h0(StyledPlayerControlView.this.f34989q, StyledPlayerControlView.this.f34991r, j11));
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public /* synthetic */ void onAvailableCommandsChanged(n2.b bVar) {
            p2.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n2 n2Var = StyledPlayerControlView.this.P;
            if (n2Var == null) {
                return;
            }
            StyledPlayerControlView.this.f34972h0.X();
            if (StyledPlayerControlView.this.f34964d == view) {
                n2Var.n();
                return;
            }
            if (StyledPlayerControlView.this.f34962c == view) {
                n2Var.f();
                return;
            }
            if (StyledPlayerControlView.this.f34969g == view) {
                if (n2Var.getPlaybackState() != 4) {
                    n2Var.w();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.f34971h == view) {
                n2Var.x();
                return;
            }
            if (StyledPlayerControlView.this.f34967f == view) {
                StyledPlayerControlView.this.V(n2Var);
                return;
            }
            if (StyledPlayerControlView.this.f34977k == view) {
                n2Var.setRepeatMode(com.google.android.exoplayer2.util.e0.a(n2Var.getRepeatMode(), StyledPlayerControlView.this.f34961b0));
                return;
            }
            if (StyledPlayerControlView.this.f34979l == view) {
                n2Var.setShuffleModeEnabled(!n2Var.getShuffleModeEnabled());
                return;
            }
            if (StyledPlayerControlView.this.f35000v0 == view) {
                StyledPlayerControlView.this.f34972h0.W();
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.W(styledPlayerControlView.f34978k0);
                return;
            }
            if (StyledPlayerControlView.this.f35002w0 == view) {
                StyledPlayerControlView.this.f34972h0.W();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                styledPlayerControlView2.W(styledPlayerControlView2.f34980l0);
            } else if (StyledPlayerControlView.this.f35004x0 == view) {
                StyledPlayerControlView.this.f34972h0.W();
                StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                styledPlayerControlView3.W(styledPlayerControlView3.f34990q0);
            } else if (StyledPlayerControlView.this.f34994s0 == view) {
                StyledPlayerControlView.this.f34972h0.W();
                StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                styledPlayerControlView4.W(styledPlayerControlView4.f34988p0);
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.f34984n0) {
                StyledPlayerControlView.this.f34972h0.X();
            }
        }

        @Override // com.google.android.exoplayer2.n2.d
        public void onEvents(n2 n2Var, n2.c cVar) {
            if (cVar.b(4, 5)) {
                StyledPlayerControlView.this.q0();
            }
            if (cVar.b(4, 5, 7)) {
                StyledPlayerControlView.this.s0();
            }
            if (cVar.a(8)) {
                StyledPlayerControlView.this.t0();
            }
            if (cVar.a(9)) {
                StyledPlayerControlView.this.w0();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                StyledPlayerControlView.this.p0();
            }
            if (cVar.b(11, 0)) {
                StyledPlayerControlView.this.x0();
            }
            if (cVar.a(12)) {
                StyledPlayerControlView.this.r0();
            }
            if (cVar.a(2)) {
                StyledPlayerControlView.this.y0();
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
            StyledPlayerControlView.this.V = false;
            if (!z11 && StyledPlayerControlView.this.P != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.i0(styledPlayerControlView.P, j11);
            }
            StyledPlayerControlView.this.f34972h0.X();
        }

        @Override // com.google.android.exoplayer2.ui.n0.a
        public void q(n0 n0Var, long j11) {
            StyledPlayerControlView.this.V = true;
            if (StyledPlayerControlView.this.f34985o != null) {
                StyledPlayerControlView.this.f34985o.setText(com.google.android.exoplayer2.util.o0.h0(StyledPlayerControlView.this.f34989q, StyledPlayerControlView.this.f34991r, j11));
            }
            StyledPlayerControlView.this.f34972h0.W();
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
        public final String[] f35009i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float[] f35010j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f35011k;

        public e(String[] strArr, float[] fArr) {
            this.f35009i = strArr;
            this.f35010j = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(int i11, View view) {
            if (i11 != this.f35011k) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.f35010j[i11]);
            }
            StyledPlayerControlView.this.f34982m0.dismiss();
        }

        public String e() {
            return this.f35009i[this.f35011k];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i11) {
            String[] strArr = this.f35009i;
            if (i11 < strArr.length) {
                iVar.f35021b.setText(strArr[i11]);
            }
            if (i11 == this.f35011k) {
                iVar.itemView.setSelected(true);
                iVar.f35022c.setVisibility(0);
            } else {
                iVar.itemView.setSelected(false);
                iVar.f35022c.setVisibility(4);
            }
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f35200a.f(i11, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f35009i.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void i(float f11) {
            int i11 = 0;
            int i12 = 0;
            float f12 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.f35010j;
                if (i11 >= fArr.length) {
                    this.f35011k = i12;
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
        public final TextView f35013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f35014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f35015d;

        public g(View view) {
            super(view);
            if (com.google.android.exoplayer2.util.o0.f35608a < 26) {
                view.setFocusable(true);
            }
            this.f35013b = (TextView) view.findViewById(R$id.exo_main_text);
            this.f35014c = (TextView) view.findViewById(R$id.exo_sub_text);
            this.f35015d = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f35202a.i(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(View view) {
            StyledPlayerControlView.this.f0(getAdapterPosition());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends RecyclerView.Adapter<g> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String[] f35017i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String[] f35018j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Drawable[] f35019k;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f35017i = strArr;
            this.f35018j = new String[strArr.length];
            this.f35019k = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i11) {
            gVar.f35013b.setText(this.f35017i[i11]);
            if (this.f35018j[i11] == null) {
                gVar.f35014c.setVisibility(8);
            } else {
                gVar.f35014c.setText(this.f35018j[i11]);
            }
            if (this.f35019k[i11] == null) {
                gVar.f35015d.setVisibility(8);
            } else {
                gVar.f35015d.setImageDrawable(this.f35019k[i11]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return StyledPlayerControlView.this.new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void f(int i11, String str) {
            this.f35018j[i11] = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f35017i.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f35021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f35022c;

        public i(View view) {
            super(view);
            if (com.google.android.exoplayer2.util.o0.f35608a < 26) {
                view.setFocusable(true);
            }
            this.f35021b = (TextView) view.findViewById(R$id.exo_text);
            this.f35022c = view.findViewById(R$id.exo_check);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class j extends l {
        public j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            if (StyledPlayerControlView.this.P != null) {
                StyledPlayerControlView.this.P.B(StyledPlayerControlView.this.P.m().a().B(3).F(-3).A());
                StyledPlayerControlView.this.f34982m0.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i11) {
            super.onBindViewHolder(iVar, i11);
            if (i11 > 0) {
                iVar.f35022c.setVisibility(this.f35027i.get(i11 + (-1)).a() ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void h(i iVar) {
            boolean z11;
            iVar.f35021b.setText(R$string.exo_track_selection_none);
            int i11 = 0;
            while (true) {
                if (i11 >= this.f35027i.size()) {
                    z11 = true;
                    break;
                } else {
                    if (this.f35027i.get(i11).a()) {
                        z11 = false;
                        break;
                    }
                    i11++;
                }
            }
            iVar.f35022c.setVisibility(z11 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f35203a.m(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
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
            if (StyledPlayerControlView.this.f34994s0 != null) {
                ImageView imageView = StyledPlayerControlView.this.f34994s0;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z11 ? styledPlayerControlView.H : styledPlayerControlView.I);
                StyledPlayerControlView.this.f34994s0.setContentDescription(z11 ? StyledPlayerControlView.this.J : StyledPlayerControlView.this.K);
            }
            this.f35027i = list;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o3.a f35024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f35026c;

        public k(o3 o3Var, int i11, int i12, String str) {
            this.f35024a = o3Var.b().get(i11);
            this.f35025b = i12;
            this.f35026c = str;
        }

        public boolean a() {
            return this.f35024a.g(this.f35025b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class l extends RecyclerView.Adapter<i> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<k> f35027i = new ArrayList();

        public l() {
        }

        public void e() {
            this.f35027i = Collections.emptyList();
        }

        public final /* synthetic */ void f(n2 n2Var, nh.i0 i0Var, k kVar, View view) {
            n2Var.B(n2Var.m().a().G(new fi.x(i0Var, ImmutableList.of(Integer.valueOf(kVar.f35025b)))).J(kVar.f35024a.d(), false).A());
            j(kVar.f35026c);
            StyledPlayerControlView.this.f34982m0.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: g */
        public void onBindViewHolder(i iVar, int i11) {
            final n2 n2Var = StyledPlayerControlView.this.P;
            if (n2Var == null) {
                return;
            }
            if (i11 == 0) {
                h(iVar);
                return;
            }
            final k kVar = this.f35027i.get(i11 - 1);
            final nh.i0 i0VarB = kVar.f35024a.b();
            boolean z11 = n2Var.m().f65081z.get(i0VarB) != null && kVar.a();
            iVar.f35021b.setText(kVar.f35026c);
            iVar.f35022c.setVisibility(z11 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f35204a.f(n2Var, i0VarB, kVar, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f35027i.isEmpty()) {
                return 0;
            }
            return this.f35027i.size() + 1;
        }

        public abstract void h(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public abstract void j(String str);
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public interface m {
        void f(int i11);
    }

    static {
        k1.a("goog.exo.ui");
        f34957y0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
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
        int resourceId = R$layout.exo_styled_player_control_view;
        this.W = 5000;
        this.f34961b0 = 0;
        this.f34959a0 = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.StyledPlayerControlView, i11, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.StyledPlayerControlView_controller_layout_id, resourceId);
                this.W = typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_show_timeout, this.W);
                this.f34961b0 = Y(typedArrayObtainStyledAttributes, this.f34961b0);
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z21 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z22 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z23 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_next_button, true);
                boolean z24 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z25 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z26 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_time_bar_min_update_interval, this.f34959a0));
                boolean z27 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z17 = z24;
                z18 = z25;
                z13 = z19;
                z14 = z21;
                z15 = z22;
                z11 = z27;
                z16 = z23;
                z12 = z26;
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
        this.f34958a = cVar;
        this.f34960b = new CopyOnWriteArrayList<>();
        this.f34993s = new j3.b();
        this.f34995t = new j3.d();
        StringBuilder sb2 = new StringBuilder();
        this.f34989q = sb2;
        this.f34991r = new Formatter(sb2, Locale.getDefault());
        this.f34963c0 = new long[0];
        this.f34965d0 = new boolean[0];
        this.f34966e0 = new long[0];
        this.f34968f0 = new boolean[0];
        this.f34997u = new Runnable() { // from class: com.google.android.exoplayer2.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f35187a.s0();
            }
        };
        this.f34983n = (TextView) findViewById(R$id.exo_duration);
        this.f34985o = (TextView) findViewById(R$id.exo_position);
        ImageView imageView = (ImageView) findViewById(R$id.exo_subtitle);
        this.f34994s0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_fullscreen);
        this.f34996t0 = imageView2;
        a0(imageView2, new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f35188a.d0(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R$id.exo_minimal_fullscreen);
        this.f34998u0 = imageView3;
        a0(imageView3, new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f35188a.d0(view);
            }
        });
        View viewFindViewById = findViewById(R$id.exo_settings);
        this.f35000v0 = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar);
        }
        View viewFindViewById2 = findViewById(R$id.exo_playback_speed);
        this.f35002w0 = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R$id.exo_audio_track);
        this.f35004x0 = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        n0 n0Var = (n0) findViewById(R$id.exo_progress);
        View viewFindViewById4 = findViewById(R$id.exo_progress_placeholder);
        if (n0Var != null) {
            this.f34987p = n0Var;
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
            this.f34987p = defaultTimeBar;
        } else {
            textView = null;
            this.f34987p = null;
        }
        n0 n0Var2 = this.f34987p;
        if (n0Var2 != null) {
            n0Var2.addListener(cVar);
        }
        View viewFindViewById5 = findViewById(R$id.exo_play_pause);
        this.f34967f = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R$id.exo_prev);
        this.f34962c = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R$id.exo_next);
        this.f34964d = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        Typeface typefaceG = b3.h.g(context, R$font.roboto_medium_numbers);
        View viewFindViewById8 = findViewById(R$id.exo_rew);
        TextView textView2 = viewFindViewById8 == null ? (TextView) findViewById(R$id.exo_rew_with_amount) : textView;
        this.f34975j = textView2;
        if (textView2 != null) {
            textView2.setTypeface(typefaceG);
        }
        viewFindViewById8 = viewFindViewById8 == null ? textView2 : viewFindViewById8;
        this.f34971h = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(cVar);
        }
        View viewFindViewById9 = findViewById(R$id.exo_ffwd);
        TextView textView3 = viewFindViewById9 == null ? (TextView) findViewById(R$id.exo_ffwd_with_amount) : null;
        this.f34973i = textView3;
        if (textView3 != null) {
            textView3.setTypeface(typefaceG);
        }
        viewFindViewById9 = viewFindViewById9 == null ? textView3 : viewFindViewById9;
        this.f34969g = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(cVar);
        }
        ImageView imageView4 = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f34977k = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f34979l = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar);
        }
        Resources resources = context.getResources();
        this.f34974i0 = resources;
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.E = this.f34974i0.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById10 = findViewById(R$id.exo_vr);
        this.f34981m = viewFindViewById10;
        if (viewFindViewById10 != null) {
            l0(false, viewFindViewById10);
        }
        i0 i0Var = new i0(this);
        this.f34972h0 = i0Var;
        boolean z28 = z12;
        i0Var.Y(z11);
        boolean z29 = z18;
        this.f34978k0 = new h(new String[]{this.f34974i0.getString(R$string.exo_controls_playback_speed), this.f34974i0.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{this.f34974i0.getDrawable(R$drawable.exo_styled_controls_speed), this.f34974i0.getDrawable(R$drawable.exo_styled_controls_audiotrack)});
        this.f34986o0 = this.f34974i0.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, (ViewGroup) null);
        this.f34976j0 = recyclerView;
        recyclerView.setAdapter(this.f34978k0);
        this.f34976j0.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) this.f34976j0, -2, -2, true);
        this.f34982m0 = popupWindow;
        if (com.google.android.exoplayer2.util.o0.f35608a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f34982m0.setOnDismissListener(cVar);
        this.f34984n0 = true;
        this.f34992r0 = new com.google.android.exoplayer2.ui.g(getResources());
        this.H = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_subtitle_on);
        this.I = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_subtitle_off);
        this.J = this.f34974i0.getString(R$string.exo_controls_cc_enabled_description);
        this.K = this.f34974i0.getString(R$string.exo_controls_cc_disabled_description);
        this.f34988p0 = new j();
        this.f34990q0 = new b();
        this.f34980l0 = new e(this.f34974i0.getStringArray(R$array.exo_controls_playback_speeds), f34957y0);
        this.L = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_fullscreen_exit);
        this.M = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_fullscreen_enter);
        this.f34999v = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_repeat_off);
        this.f35001w = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_repeat_one);
        this.f35003x = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_repeat_all);
        this.B = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_shuffle_on);
        this.C = this.f34974i0.getDrawable(R$drawable.exo_styled_controls_shuffle_off);
        this.N = this.f34974i0.getString(R$string.exo_controls_fullscreen_exit_description);
        this.O = this.f34974i0.getString(R$string.exo_controls_fullscreen_enter_description);
        this.f35005y = this.f34974i0.getString(R$string.exo_controls_repeat_off_description);
        this.f35006z = this.f34974i0.getString(R$string.exo_controls_repeat_one_description);
        this.A = this.f34974i0.getString(R$string.exo_controls_repeat_all_description);
        this.F = this.f34974i0.getString(R$string.exo_controls_shuffle_on_description);
        this.G = this.f34974i0.getString(R$string.exo_controls_shuffle_off_description);
        this.f34972h0.Z((ViewGroup) findViewById(R$id.exo_bottom_bar), true);
        this.f34972h0.Z(viewFindViewById9, z14);
        this.f34972h0.Z(viewFindViewById8, z13);
        this.f34972h0.Z(viewFindViewById6, z15);
        this.f34972h0.Z(viewFindViewById7, z16);
        this.f34972h0.Z(imageView5, z17);
        this.f34972h0.Z(this.f34994s0, z29);
        this.f34972h0.Z(viewFindViewById10, z28);
        this.f34972h0.Z(imageView4, this.f34961b0 != 0);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.p
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                this.f35189a.e0(view, i12, i13, i14, i15, i16, i17, i18, i19);
            }
        });
    }

    public static boolean S(j3 j3Var, j3.d dVar) {
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

    public static int Y(TypedArray typedArray, int i11) {
        return typedArray.getInt(R$styleable.StyledPlayerControlView_repeat_toggle_modes, i11);
    }

    public static void a0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean b0(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    public static void o0(@Nullable View view, boolean z11) {
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
        n2 n2Var = this.P;
        if (n2Var == null) {
            return;
        }
        n2Var.b(n2Var.getPlaybackParameters().e(f11));
    }

    public final void T(n2 n2Var) {
        n2Var.pause();
    }

    public final void U(n2 n2Var) {
        int playbackState = n2Var.getPlaybackState();
        if (playbackState == 1) {
            n2Var.prepare();
        } else if (playbackState == 4) {
            h0(n2Var, n2Var.u(), C.TIME_UNSET);
        }
        n2Var.play();
    }

    public final void V(n2 n2Var) {
        int playbackState = n2Var.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !n2Var.getPlayWhenReady()) {
            U(n2Var);
        } else {
            T(n2Var);
        }
    }

    public final void W(RecyclerView.Adapter<?> adapter) {
        this.f34976j0.setAdapter(adapter);
        v0();
        this.f34984n0 = false;
        this.f34982m0.dismiss();
        this.f34984n0 = true;
        this.f34982m0.showAsDropDown(this, (getWidth() - this.f34982m0.getWidth()) - this.f34986o0, (-this.f34982m0.getHeight()) - this.f34986o0);
    }

    public final ImmutableList<k> X(o3 o3Var, int i11) {
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList<o3.a> immutableListB = o3Var.b();
        for (int i12 = 0; i12 < immutableListB.size(); i12++) {
            o3.a aVar2 = immutableListB.get(i12);
            if (aVar2.d() == i11) {
                for (int i13 = 0; i13 < aVar2.f33629a; i13++) {
                    if (aVar2.h(i13)) {
                        m1 m1VarC = aVar2.c(i13);
                        if ((m1VarC.f33437d & 2) == 0) {
                            aVar.a(new k(o3Var, i12, i13, this.f34992r0.a(m1VarC)));
                        }
                    }
                }
            }
        }
        return aVar.m();
    }

    public final void Z() {
        this.f34988p0.e();
        this.f34990q0.e();
        n2 n2Var = this.P;
        if (n2Var != null && n2Var.i(30) && this.P.i(29)) {
            o3 currentTracks = this.P.getCurrentTracks();
            this.f34990q0.m(X(currentTracks, 1));
            if (this.f34972h0.A(this.f34994s0)) {
                this.f34988p0.l(X(currentTracks, 3));
            } else {
                this.f34988p0.l(ImmutableList.of());
            }
        }
    }

    @Deprecated
    public void addVisibilityListener(m mVar) {
        com.google.android.exoplayer2.util.a.e(mVar);
        this.f34960b.add(mVar);
    }

    public void c0() {
        Iterator<m> it = this.f34960b.iterator();
        while (it.hasNext()) {
            it.next().f(getVisibility());
        }
    }

    public final void d0(View view) {
        if (this.Q == null) {
            return;
        }
        boolean z11 = !this.R;
        this.R = z11;
        n0(this.f34996t0, z11);
        n0(this.f34998u0, this.R);
        d dVar = this.Q;
        if (dVar != null) {
            dVar.p(this.R);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        n2 n2Var = this.P;
        if (n2Var == null || !b0(keyCode)) {
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
            V(n2Var);
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
            U(n2Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        T(n2Var);
        return true;
    }

    public final void e0(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = i14 - i12;
        int i21 = i18 - i16;
        if (!(i13 - i11 == i17 - i15 && i19 == i21) && this.f34982m0.isShowing()) {
            v0();
            this.f34982m0.update(view, (getWidth() - this.f34982m0.getWidth()) - this.f34986o0, (-this.f34982m0.getHeight()) - this.f34986o0, -1, -1);
        }
    }

    public final void f0(int i11) {
        if (i11 == 0) {
            W(this.f34980l0);
        } else if (i11 == 1) {
            W(this.f34990q0);
        } else {
            this.f34982m0.dismiss();
        }
    }

    public void g0() {
        View view = this.f34967f;
        if (view != null) {
            view.requestFocus();
        }
    }

    @Nullable
    public n2 getPlayer() {
        return this.P;
    }

    public int getRepeatToggleModes() {
        return this.f34961b0;
    }

    public boolean getShowShuffleButton() {
        return this.f34972h0.A(this.f34979l);
    }

    public boolean getShowSubtitleButton() {
        return this.f34972h0.A(this.f34994s0);
    }

    public int getShowTimeoutMs() {
        return this.W;
    }

    public boolean getShowVrButton() {
        return this.f34972h0.A(this.f34981m);
    }

    public final void h0(n2 n2Var, int i11, long j11) {
        n2Var.seekTo(i11, j11);
    }

    public void hide() {
        this.f34972h0.C();
    }

    public void hideImmediately() {
        this.f34972h0.F();
    }

    public final void i0(n2 n2Var, long j11) {
        int iU;
        j3 currentTimeline = n2Var.getCurrentTimeline();
        if (this.U && !currentTimeline.u()) {
            int iT = currentTimeline.t();
            iU = 0;
            while (true) {
                long jG = currentTimeline.r(iU, this.f34995t).g();
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
        h0(n2Var, iU, j11);
        s0();
    }

    public boolean isAnimationEnabled() {
        return this.f34972h0.I();
    }

    public boolean isFullyVisible() {
        return this.f34972h0.J();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public final boolean j0() {
        n2 n2Var = this.P;
        return (n2Var == null || n2Var.getPlaybackState() == 4 || this.P.getPlaybackState() == 1 || !this.P.getPlayWhenReady()) ? false : true;
    }

    public void k0() {
        q0();
        p0();
        t0();
        w0();
        y0();
        r0();
        x0();
    }

    public final void l0(boolean z11, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z11);
        view.setAlpha(z11 ? this.D : this.E);
    }

    public final void m0() {
        n2 n2Var = this.P;
        int iS = (int) ((n2Var != null ? n2Var.s() : 15000L) / 1000);
        TextView textView = this.f34973i;
        if (textView != null) {
            textView.setText(String.valueOf(iS));
        }
        View view = this.f34969g;
        if (view != null) {
            view.setContentDescription(this.f34974i0.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, iS, Integer.valueOf(iS)));
        }
    }

    public final void n0(@Nullable ImageView imageView, boolean z11) {
        if (imageView == null) {
            return;
        }
        if (z11) {
            imageView.setImageDrawable(this.L);
            imageView.setContentDescription(this.N);
        } else {
            imageView.setImageDrawable(this.M);
            imageView.setContentDescription(this.O);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f34972h0.P();
        this.S = true;
        if (isFullyVisible()) {
            this.f34972h0.X();
        }
        k0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f34972h0.Q();
        this.S = false;
        removeCallbacks(this.f34997u);
        this.f34972h0.W();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f34972h0.R(z11, i11, i12, i13, i14);
    }

    public final void p0() {
        boolean zI;
        boolean zI2;
        boolean zI3;
        boolean zI4;
        boolean zI5;
        if (isVisible() && this.S) {
            n2 n2Var = this.P;
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
            if (zI4) {
                u0();
            }
            if (zI5) {
                m0();
            }
            l0(zI3, this.f34962c);
            l0(zI4, this.f34971h);
            l0(zI5, this.f34969g);
            l0(zI2, this.f34964d);
            n0 n0Var = this.f34987p;
            if (n0Var != null) {
                n0Var.setEnabled(zI);
            }
        }
    }

    public final void q0() {
        if (isVisible() && this.S && this.f34967f != null) {
            if (j0()) {
                ((ImageView) this.f34967f).setImageDrawable(this.f34974i0.getDrawable(R$drawable.exo_styled_controls_pause));
                this.f34967f.setContentDescription(this.f34974i0.getString(R$string.exo_controls_pause_description));
            } else {
                ((ImageView) this.f34967f).setImageDrawable(this.f34974i0.getDrawable(R$drawable.exo_styled_controls_play));
                this.f34967f.setContentDescription(this.f34974i0.getString(R$string.exo_controls_play_description));
            }
        }
    }

    public final void r0() {
        n2 n2Var = this.P;
        if (n2Var == null) {
            return;
        }
        this.f34980l0.i(n2Var.getPlaybackParameters().f33487a);
        this.f34978k0.f(0, this.f34980l0.e());
    }

    @Deprecated
    public void removeVisibilityListener(m mVar) {
        this.f34960b.remove(mVar);
    }

    public final void s0() {
        long contentPosition;
        long jV;
        if (isVisible() && this.S) {
            n2 n2Var = this.P;
            if (n2Var != null) {
                contentPosition = this.f34970g0 + n2Var.getContentPosition();
                jV = this.f34970g0 + n2Var.v();
            } else {
                contentPosition = 0;
                jV = 0;
            }
            TextView textView = this.f34985o;
            if (textView != null && !this.V) {
                textView.setText(com.google.android.exoplayer2.util.o0.h0(this.f34989q, this.f34991r, contentPosition));
            }
            n0 n0Var = this.f34987p;
            if (n0Var != null) {
                n0Var.setPosition(contentPosition);
                this.f34987p.setBufferedPosition(jV);
            }
            removeCallbacks(this.f34997u);
            int playbackState = n2Var == null ? 1 : n2Var.getPlaybackState();
            if (n2Var == null || !n2Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f34997u, 1000L);
                return;
            }
            n0 n0Var2 = this.f34987p;
            long jMin = Math.min(n0Var2 != null ? n0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f11 = n2Var.getPlaybackParameters().f33487a;
            postDelayed(this.f34997u, com.google.android.exoplayer2.util.o0.r(f11 > 0.0f ? (long) (jMin / f11) : 1000L, this.f34959a0, 1000L));
        }
    }

    public void setAnimationEnabled(boolean z11) {
        this.f34972h0.Y(z11);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f34966e0 = new long[0];
            this.f34968f0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.a.e(zArr);
            com.google.android.exoplayer2.util.a.a(jArr.length == zArr2.length);
            this.f34966e0 = jArr;
            this.f34968f0 = zArr2;
        }
        x0();
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        this.Q = dVar;
        o0(this.f34996t0, dVar != null);
        o0(this.f34998u0, dVar != null);
    }

    public void setPlayer(@Nullable n2 n2Var) {
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(n2Var == null || n2Var.l() == Looper.getMainLooper());
        n2 n2Var2 = this.P;
        if (n2Var2 == n2Var) {
            return;
        }
        if (n2Var2 != null) {
            n2Var2.C(this.f34958a);
        }
        this.P = n2Var;
        if (n2Var != null) {
            n2Var.E(this.f34958a);
        }
        if (n2Var instanceof o1) {
            ((o1) n2Var).F();
        }
        k0();
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
    }

    public void setRepeatToggleModes(int i11) {
        this.f34961b0 = i11;
        n2 n2Var = this.P;
        if (n2Var != null) {
            int repeatMode = n2Var.getRepeatMode();
            if (i11 == 0 && repeatMode != 0) {
                this.P.setRepeatMode(0);
            } else if (i11 == 1 && repeatMode == 2) {
                this.P.setRepeatMode(1);
            } else if (i11 == 2 && repeatMode == 1) {
                this.P.setRepeatMode(2);
            }
        }
        this.f34972h0.Z(this.f34977k, i11 != 0);
        t0();
    }

    public void setShowFastForwardButton(boolean z11) {
        this.f34972h0.Z(this.f34969g, z11);
        p0();
    }

    public void setShowMultiWindowTimeBar(boolean z11) {
        this.T = z11;
        x0();
    }

    public void setShowNextButton(boolean z11) {
        this.f34972h0.Z(this.f34964d, z11);
        p0();
    }

    public void setShowPreviousButton(boolean z11) {
        this.f34972h0.Z(this.f34962c, z11);
        p0();
    }

    public void setShowRewindButton(boolean z11) {
        this.f34972h0.Z(this.f34971h, z11);
        p0();
    }

    public void setShowShuffleButton(boolean z11) {
        this.f34972h0.Z(this.f34979l, z11);
        w0();
    }

    public void setShowSubtitleButton(boolean z11) {
        this.f34972h0.Z(this.f34994s0, z11);
    }

    public void setShowTimeoutMs(int i11) {
        this.W = i11;
        if (isFullyVisible()) {
            this.f34972h0.X();
        }
    }

    public void setShowVrButton(boolean z11) {
        this.f34972h0.Z(this.f34981m, z11);
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.f34959a0 = com.google.android.exoplayer2.util.o0.q(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f34981m;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            l0(onClickListener != null, this.f34981m);
        }
    }

    public void show() {
        this.f34972h0.c0();
    }

    public final void t0() {
        ImageView imageView;
        if (isVisible() && this.S && (imageView = this.f34977k) != null) {
            if (this.f34961b0 == 0) {
                l0(false, imageView);
                return;
            }
            n2 n2Var = this.P;
            if (n2Var == null) {
                l0(false, imageView);
                this.f34977k.setImageDrawable(this.f34999v);
                this.f34977k.setContentDescription(this.f35005y);
                return;
            }
            l0(true, imageView);
            int repeatMode = n2Var.getRepeatMode();
            if (repeatMode == 0) {
                this.f34977k.setImageDrawable(this.f34999v);
                this.f34977k.setContentDescription(this.f35005y);
            } else if (repeatMode == 1) {
                this.f34977k.setImageDrawable(this.f35001w);
                this.f34977k.setContentDescription(this.f35006z);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.f34977k.setImageDrawable(this.f35003x);
                this.f34977k.setContentDescription(this.A);
            }
        }
    }

    public final void u0() {
        n2 n2Var = this.P;
        int iZ = (int) ((n2Var != null ? n2Var.z() : 5000L) / 1000);
        TextView textView = this.f34975j;
        if (textView != null) {
            textView.setText(String.valueOf(iZ));
        }
        View view = this.f34971h;
        if (view != null) {
            view.setContentDescription(this.f34974i0.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, iZ, Integer.valueOf(iZ)));
        }
    }

    public final void v0() {
        this.f34976j0.measure(0, 0);
        this.f34982m0.setWidth(Math.min(this.f34976j0.getMeasuredWidth(), getWidth() - (this.f34986o0 * 2)));
        this.f34982m0.setHeight(Math.min(getHeight() - (this.f34986o0 * 2), this.f34976j0.getMeasuredHeight()));
    }

    public final void w0() {
        ImageView imageView;
        if (isVisible() && this.S && (imageView = this.f34979l) != null) {
            n2 n2Var = this.P;
            if (!this.f34972h0.A(imageView)) {
                l0(false, this.f34979l);
                return;
            }
            if (n2Var == null) {
                l0(false, this.f34979l);
                this.f34979l.setImageDrawable(this.C);
                this.f34979l.setContentDescription(this.G);
            } else {
                l0(true, this.f34979l);
                this.f34979l.setImageDrawable(n2Var.getShuffleModeEnabled() ? this.B : this.C);
                this.f34979l.setContentDescription(n2Var.getShuffleModeEnabled() ? this.F : this.G);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4 A[SYNTHETIC] */
    public final void x0() {
        int i11;
        j3.d dVar;
        long jQ;
        long[] jArr;
        int length;
        n2 n2Var = this.P;
        if (n2Var == null) {
            return;
        }
        boolean z11 = true;
        this.U = this.T && S(n2Var.getCurrentTimeline(), this.f34995t);
        long j11 = 0;
        this.f34970g0 = 0L;
        j3 currentTimeline = n2Var.getCurrentTimeline();
        if (currentTimeline.u()) {
            i11 = 0;
        } else {
            int iU = n2Var.u();
            boolean z12 = this.U;
            int i12 = z12 ? 0 : iU;
            int iT = z12 ? currentTimeline.t() - 1 : iU;
            long j12 = 0;
            i11 = 0;
            while (i12 <= iT) {
                if (i12 == iU) {
                    this.f34970g0 = com.google.android.exoplayer2.util.o0.f1(j12);
                }
                currentTimeline.r(i12, this.f34995t);
                j3.d dVar2 = this.f34995t;
                if (dVar2.f33390o == C.TIME_UNSET) {
                    com.google.android.exoplayer2.util.a.g(this.U ^ z11);
                    break;
                }
                int i13 = dVar2.f33391p;
                while (true) {
                    dVar = this.f34995t;
                    if (i13 <= dVar.f33392q) {
                        currentTimeline.j(i13, this.f34993s);
                        int iF = this.f34993s.f();
                        for (int iR = this.f34993s.r(); iR < iF; iR++) {
                            long jI = this.f34993s.i(iR);
                            if (jI == Long.MIN_VALUE) {
                                long j13 = this.f34993s.f33365d;
                                if (j13 != C.TIME_UNSET) {
                                    jI = j13;
                                    jQ = jI + this.f34993s.q();
                                    if (jQ >= 0) {
                                        jArr = this.f34963c0;
                                        if (i11 == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.f34963c0 = Arrays.copyOf(jArr, length);
                                            this.f34965d0 = Arrays.copyOf(this.f34965d0, length);
                                        }
                                        this.f34963c0[i11] = com.google.android.exoplayer2.util.o0.f1(j12 + jQ);
                                        this.f34965d0[i11] = this.f34993s.s(iR);
                                        i11++;
                                    }
                                }
                            } else {
                                jQ = jI + this.f34993s.q();
                                if (jQ >= 0) {
                                    jArr = this.f34963c0;
                                    if (i11 == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.f34963c0 = Arrays.copyOf(jArr, length);
                                        this.f34965d0 = Arrays.copyOf(this.f34965d0, length);
                                    }
                                    this.f34963c0[i11] = com.google.android.exoplayer2.util.o0.f1(j12 + jQ);
                                    this.f34965d0[i11] = this.f34993s.s(iR);
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
        TextView textView = this.f34983n;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.o0.h0(this.f34989q, this.f34991r, jF1));
        }
        n0 n0Var = this.f34987p;
        if (n0Var != null) {
            n0Var.setDuration(jF1);
            int length2 = this.f34966e0.length;
            int i14 = i11 + length2;
            long[] jArr2 = this.f34963c0;
            if (i14 > jArr2.length) {
                this.f34963c0 = Arrays.copyOf(jArr2, i14);
                this.f34965d0 = Arrays.copyOf(this.f34965d0, i14);
            }
            System.arraycopy(this.f34966e0, 0, this.f34963c0, i11, length2);
            System.arraycopy(this.f34968f0, 0, this.f34965d0, i11, length2);
            this.f34987p.setAdGroupTimesMs(this.f34963c0, this.f34965d0, i14);
        }
        s0();
    }

    public final void y0() {
        Z();
        l0(this.f34988p0.getItemCount() > 0, this.f34994s0);
    }
}
