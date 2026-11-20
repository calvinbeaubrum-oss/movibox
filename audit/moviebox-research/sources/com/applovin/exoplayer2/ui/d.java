package com.applovin.exoplayer2.ui;

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
import com.applovin.impl.b1;
import com.applovin.impl.bf;
import com.applovin.impl.c20;
import com.applovin.impl.d20;
import com.applovin.impl.f8;
import com.applovin.impl.fo;
import com.applovin.impl.nh;
import com.applovin.impl.ph;
import com.applovin.impl.po;
import com.applovin.impl.qh;
import com.applovin.impl.r6;
import com.applovin.impl.t2;
import com.applovin.impl.t4;
import com.applovin.impl.td;
import com.applovin.impl.to;
import com.applovin.impl.u5;
import com.applovin.impl.ui;
import com.applovin.impl.vd;
import com.applovin.impl.xp;
import com.applovin.impl.xq;
import com.applovin.sdk.R;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends FrameLayout {
    private final String A;
    private final Drawable B;
    private final Drawable C;
    private final float D;
    private final float E;
    private final String F;
    private final String G;
    private qh H;
    private t4 I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;
    private long[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f17292a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean[] f17293a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f17294b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private long[] f17295b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f17296c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean[] f17297c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f17298d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private long f17299d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private long f17300e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f17301f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private long f17302f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View f17303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final View f17304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f17305i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImageView f17306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ImageView f17307k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View f17308l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final TextView f17309m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextView f17310n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final i f17311o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final StringBuilder f17312p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Formatter f17313q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final fo.b f17314r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final fo.d f17315s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f17316t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f17317u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Drawable f17318v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Drawable f17319w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Drawable f17320x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f17321y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f17322z;

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements qh.e, i.a, View.OnClickListener {
        private c() {
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a() {
            d20.a(this);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(float f11) {
            d20.b(this, f11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(int i11) {
            d20.c(this, i11);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(int i11, int i12) {
            d20.d(this, i11, i12);
        }

        @Override // com.applovin.exoplayer2.ui.i.a
        public void a(i iVar, long j11) {
            d.this.M = true;
            if (d.this.f17310n != null) {
                d.this.f17310n.setText(xp.a(d.this.f17312p, d.this.f17313q, j11));
            }
        }

        @Override // com.applovin.exoplayer2.ui.i.a
        public void a(i iVar, long j11, boolean z11) {
            d.this.M = false;
            if (z11 || d.this.H == null) {
                return;
            }
            d dVar = d.this;
            dVar.a(dVar.H, j11);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(bf bfVar) {
            d20.e(this, bfVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(fo foVar, int i11) {
            d20.f(this, foVar, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(nh nhVar) {
            d20.g(this, nhVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(ph phVar) {
            d20.h(this, phVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(po poVar, to toVar) {
            d20.i(this, poVar, toVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(qh.b bVar) {
            d20.j(this, bVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(qh.f fVar, qh.f fVar2, int i11) {
            d20.k(this, fVar, fVar2, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(qh qhVar, qh.d dVar) {
            if (dVar.a(4, 5)) {
                d.this.j();
            }
            if (dVar.a(4, 5, 7)) {
                d.this.k();
            }
            if (dVar.a(8)) {
                d.this.l();
            }
            if (dVar.a(9)) {
                d.this.m();
            }
            if (dVar.a(8, 9, 11, 0, 13)) {
                d.this.i();
            }
            if (dVar.a(11, 0)) {
                d.this.n();
            }
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(r6 r6Var) {
            d20.m(this, r6Var);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(td tdVar, int i11) {
            d20.n(this, tdVar, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(vd vdVar) {
            d20.o(this, vdVar);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(xq xqVar) {
            d20.p(this, xqVar);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(List list) {
            d20.q(this, list);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void a(boolean z11) {
            d20.r(this, z11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void a(boolean z11, int i11) {
            d20.s(this, z11, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b() {
            c20.l(this);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void b(int i11) {
            d20.t(this, i11);
        }

        @Override // com.applovin.impl.qh.e
        public /* synthetic */ void b(int i11, boolean z11) {
            d20.u(this, i11, z11);
        }

        @Override // com.applovin.exoplayer2.ui.i.a
        public void b(i iVar, long j11) {
            if (d.this.f17310n != null) {
                d.this.f17310n.setText(xp.a(d.this.f17312p, d.this.f17313q, j11));
            }
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void b(nh nhVar) {
            d20.v(this, nhVar);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11) {
            d20.w(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void b(boolean z11, int i11) {
            c20.o(this, z11, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void c(int i11) {
            d20.x(this, i11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void c(boolean z11) {
            d20.y(this, z11);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public /* synthetic */ void d(boolean z11) {
            d20.z(this, z11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(int i11) {
            c20.s(this, i11);
        }

        @Override // com.applovin.impl.qh.c
        public /* synthetic */ void e(boolean z11) {
            c20.t(this, z11);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            qh qhVar = d.this.H;
            if (qhVar == null) {
                return;
            }
            if (d.this.f17298d == view) {
                d.this.I.a(qhVar);
                return;
            }
            if (d.this.f17296c == view) {
                d.this.I.e(qhVar);
                return;
            }
            if (d.this.f17304h == view) {
                if (qhVar.o() != 4) {
                    d.this.I.d(qhVar);
                    return;
                }
                return;
            }
            if (d.this.f17305i == view) {
                d.this.I.c(qhVar);
                return;
            }
            if (d.this.f17301f == view) {
                d.this.b(qhVar);
                return;
            }
            if (d.this.f17303g == view) {
                d.this.a(qhVar);
            } else if (d.this.f17306j == view) {
                d.this.I.a(qhVar, ui.a(qhVar.m(), d.this.P));
            } else if (d.this.f17307k == view) {
                d.this.I.a(qhVar, !qhVar.r());
            }
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.ui.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0173d {
    }

    /* JADX INFO: compiled from: source.java */
    public interface e {
        void d(int i11);
    }

    static {
        f8.a("goog.exo.ui");
    }

    public d(Context context, AttributeSet attributeSet, int i11, AttributeSet attributeSet2) {
        super(context, attributeSet, i11);
        int resourceId = R.layout.applovin_exo_player_control_view;
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
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinPlayerControlView, i11, 0);
            try {
                this.N = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_show_timeout, this.N);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerControlView_al_controller_layout_id, resourceId);
                this.P = a(typedArrayObtainStyledAttributes, this.P);
                this.Q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_rewind_button, this.Q);
                this.R = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_fastforward_button, this.R);
                this.S = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_previous_button, this.S);
                this.T = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_next_button, this.T);
                this.U = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_shuffle_button, this.U);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_time_bar_min_update_interval, this.O));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        }
        this.f17294b = new CopyOnWriteArrayList();
        this.f17314r = new fo.b();
        this.f17315s = new fo.d();
        StringBuilder sb2 = new StringBuilder();
        this.f17312p = sb2;
        this.f17313q = new Formatter(sb2, Locale.getDefault());
        this.W = new long[0];
        this.f17293a0 = new boolean[0];
        this.f17295b0 = new long[0];
        this.f17297c0 = new boolean[0];
        c cVar = new c();
        this.f17292a = cVar;
        this.I = new u5();
        this.f17316t = new Runnable() { // from class: com.applovin.exoplayer2.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f17400a.k();
            }
        };
        this.f17317u = new Runnable() { // from class: com.applovin.exoplayer2.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f17401a.a();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        i iVar = (i) findViewById(R.id.al_exo_progress);
        View viewFindViewById = findViewById(R.id.al_exo_progress_placeholder);
        if (iVar != null) {
            this.f17311o = iVar;
        } else if (viewFindViewById != null) {
            com.applovin.exoplayer2.ui.b bVar = new com.applovin.exoplayer2.ui.b(context, null, 0, attributeSet2);
            bVar.setId(R.id.al_exo_progress);
            bVar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(bVar, iIndexOfChild);
            this.f17311o = bVar;
        } else {
            this.f17311o = null;
        }
        this.f17309m = (TextView) findViewById(R.id.al_exo_duration);
        this.f17310n = (TextView) findViewById(R.id.al_exo_position);
        i iVar2 = this.f17311o;
        if (iVar2 != null) {
            iVar2.a(cVar);
        }
        View viewFindViewById2 = findViewById(R.id.al_exo_play);
        this.f17301f = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R.id.al_exo_pause);
        this.f17303g = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R.id.al_exo_prev);
        this.f17296c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R.id.al_exo_next);
        this.f17298d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R.id.al_exo_rew);
        this.f17305i = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R.id.al_exo_ffwd);
        this.f17304h = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R.id.al_exo_repeat_toggle);
        this.f17306j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_shuffle);
        this.f17307k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R.id.al_exo_vr);
        this.f17308l = viewFindViewById8;
        setShowVrButton(false);
        a(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.D = resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.E = resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f17318v = resources.getDrawable(R.drawable.al_exo_controls_repeat_off);
        this.f17319w = resources.getDrawable(R.drawable.al_exo_controls_repeat_one);
        this.f17320x = resources.getDrawable(R.drawable.al_exo_controls_repeat_all);
        this.B = resources.getDrawable(R.drawable.al_exo_controls_shuffle_on);
        this.C = resources.getDrawable(R.drawable.al_exo_controls_shuffle_off);
        this.f17321y = resources.getString(R.string.al_exo_controls_repeat_off_description);
        this.f17322z = resources.getString(R.string.al_exo_controls_repeat_one_description);
        this.A = resources.getString(R.string.al_exo_controls_repeat_all_description);
        this.F = resources.getString(R.string.al_exo_controls_shuffle_on_description);
        this.G = resources.getString(R.string.al_exo_controls_shuffle_off_description);
    }

    private static int a(TypedArray typedArray, int i11) {
        return typedArray.getInt(R.styleable.AppLovinPlayerControlView_al_repeat_toggle_modes, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(qh qhVar) {
        this.I.b(qhVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(qh qhVar, long j11) {
        int iT;
        fo foVarN = qhVar.n();
        if (this.L && !foVarN.c()) {
            int iB = foVarN.b();
            iT = 0;
            while (true) {
                long jD = foVarN.a(iT, this.f17315s).d();
                if (j11 < jD) {
                    break;
                }
                if (iT == iB - 1) {
                    j11 = jD;
                    break;
                } else {
                    j11 -= jD;
                    iT++;
                }
            }
        } else {
            iT = qhVar.t();
        }
        a(qhVar, iT, j11);
        k();
    }

    private void a(boolean z11, boolean z12, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z12);
        view.setAlpha(z12 ? this.D : this.E);
        view.setVisibility(z11 ? 0 : 8);
    }

    private static boolean a(int i11) {
        return i11 == 90 || i11 == 89 || i11 == 85 || i11 == 79 || i11 == 126 || i11 == 127 || i11 == 87 || i11 == 88;
    }

    private static boolean a(fo foVar, fo.d dVar) {
        if (foVar.b() > 100) {
            return false;
        }
        int iB = foVar.b();
        for (int i11 = 0; i11 < iB; i11++) {
            if (foVar.a(i11, dVar).f19059o == C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    private boolean a(qh qhVar, int i11, long j11) {
        return this.I.a(qhVar, i11, j11);
    }

    private void b() {
        removeCallbacks(this.f17317u);
        if (this.N <= 0) {
            this.V = C.TIME_UNSET;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j11 = this.N;
        this.V = jUptimeMillis + j11;
        if (this.J) {
            postDelayed(this.f17317u, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(qh qhVar) {
        int iO = qhVar.o();
        if (iO == 1) {
            this.I.b(qhVar);
        } else if (iO == 4) {
            a(qhVar, qhVar.t(), C.TIME_UNSET);
        }
        this.I.b(qhVar, true);
    }

    private void c(qh qhVar) {
        int iO = qhVar.o();
        if (iO == 1 || iO == 4 || !qhVar.l()) {
            b(qhVar);
        } else {
            a(qhVar);
        }
    }

    private void d() {
        View view;
        View view2;
        boolean zF = f();
        if (!zF && (view2 = this.f17301f) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zF || (view = this.f17303g) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    private void e() {
        View view;
        View view2;
        boolean zF = f();
        if (!zF && (view2 = this.f17301f) != null) {
            view2.requestFocus();
        } else {
            if (!zF || (view = this.f17303g) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private boolean f() {
        qh qhVar = this.H;
        return (qhVar == null || qhVar.o() == 4 || this.H.o() == 1 || !this.H.l()) ? false : true;
    }

    private void h() {
        j();
        i();
        l();
        m();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        boolean z11;
        boolean zB;
        boolean z12;
        boolean z13;
        if (c() && this.J) {
            qh qhVar = this.H;
            boolean z14 = false;
            if (qhVar != null) {
                boolean zB2 = qhVar.b(4);
                boolean zB3 = qhVar.b(6);
                z13 = qhVar.b(10) && this.I.b();
                if (qhVar.b(11) && this.I.a()) {
                    z14 = true;
                }
                zB = qhVar.b(8);
                z11 = z14;
                z14 = zB3;
                z12 = zB2;
            } else {
                z11 = false;
                zB = false;
                z12 = false;
                z13 = false;
            }
            a(this.S, z14, this.f17296c);
            a(this.Q, z13, this.f17305i);
            a(this.R, z11, this.f17304h);
            a(this.T, zB, this.f17298d);
            i iVar = this.f17311o;
            if (iVar != null) {
                iVar.setEnabled(z12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        boolean z11;
        boolean z12;
        if (c() && this.J) {
            boolean zF = f();
            View view = this.f17301f;
            boolean z13 = true;
            if (view != null) {
                z11 = zF && view.isFocused();
                if (xp.f24372a < 21) {
                    z12 = z11;
                } else {
                    z12 = zF && b.a(this.f17301f);
                }
                this.f17301f.setVisibility(zF ? 8 : 0);
            } else {
                z11 = false;
                z12 = false;
            }
            View view2 = this.f17303g;
            if (view2 != null) {
                z11 |= !zF && view2.isFocused();
                if (xp.f24372a < 21) {
                    z13 = z11;
                } else if (zF || !b.a(this.f17303g)) {
                    z13 = false;
                }
                z12 |= z13;
                this.f17303g.setVisibility(zF ? 0 : 8);
            }
            if (z11) {
                e();
            }
            if (z12) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        long jG;
        long jS;
        if (c() && this.J) {
            qh qhVar = this.H;
            if (qhVar != null) {
                jG = this.f17299d0 + qhVar.g();
                jS = this.f17299d0 + qhVar.s();
            } else {
                jG = 0;
                jS = 0;
            }
            boolean z11 = jG != this.f17300e0;
            this.f17300e0 = jG;
            this.f17302f0 = jS;
            TextView textView = this.f17310n;
            if (textView != null && !this.M && z11) {
                textView.setText(xp.a(this.f17312p, this.f17313q, jG));
            }
            i iVar = this.f17311o;
            if (iVar != null) {
                iVar.setPosition(jG);
                this.f17311o.setBufferedPosition(jS);
            }
            removeCallbacks(this.f17316t);
            int iO = qhVar == null ? 1 : qhVar.o();
            if (qhVar == null || !qhVar.isPlaying()) {
                if (iO == 4 || iO == 1) {
                    return;
                }
                postDelayed(this.f17316t, 1000L);
                return;
            }
            i iVar2 = this.f17311o;
            long jMin = Math.min(iVar2 != null ? iVar2.getPreferredUpdateDelay() : 1000L, 1000 - (jG % 1000));
            float f11 = qhVar.a().f21777a;
            postDelayed(this.f17316t, xp.b(f11 > 0.0f ? (long) (jMin / f11) : 1000L, this.O, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ImageView imageView;
        if (c() && this.J && (imageView = this.f17306j) != null) {
            if (this.P == 0) {
                a(false, false, (View) imageView);
                return;
            }
            qh qhVar = this.H;
            if (qhVar == null) {
                a(true, false, (View) imageView);
                this.f17306j.setImageDrawable(this.f17318v);
                this.f17306j.setContentDescription(this.f17321y);
                return;
            }
            a(true, true, (View) imageView);
            int iM = qhVar.m();
            if (iM == 0) {
                this.f17306j.setImageDrawable(this.f17318v);
                this.f17306j.setContentDescription(this.f17321y);
            } else if (iM == 1) {
                this.f17306j.setImageDrawable(this.f17319w);
                this.f17306j.setContentDescription(this.f17322z);
            } else if (iM == 2) {
                this.f17306j.setImageDrawable(this.f17320x);
                this.f17306j.setContentDescription(this.A);
            }
            this.f17306j.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ImageView imageView;
        if (c() && this.J && (imageView = this.f17307k) != null) {
            qh qhVar = this.H;
            if (!this.U) {
                a(false, false, (View) imageView);
                return;
            }
            if (qhVar == null) {
                a(true, false, (View) imageView);
                this.f17307k.setImageDrawable(this.C);
                this.f17307k.setContentDescription(this.G);
            } else {
                a(true, true, (View) imageView);
                this.f17307k.setImageDrawable(qhVar.r() ? this.B : this.C);
                this.f17307k.setContentDescription(qhVar.r() ? this.F : this.G);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5 A[SYNTHETIC] */
    public void n() {
        int i11;
        fo.d dVar;
        long jE;
        long[] jArr;
        int length;
        qh qhVar = this.H;
        if (qhVar == null) {
            return;
        }
        boolean z11 = true;
        this.L = this.K && a(qhVar.n(), this.f17315s);
        long j11 = 0;
        this.f17299d0 = 0L;
        fo foVarN = qhVar.n();
        if (foVarN.c()) {
            i11 = 0;
        } else {
            int iT = qhVar.t();
            boolean z12 = this.L;
            int i12 = z12 ? 0 : iT;
            int iB = z12 ? foVarN.b() - 1 : iT;
            long j12 = 0;
            i11 = 0;
            while (i12 <= iB) {
                if (i12 == iT) {
                    this.f17299d0 = t2.b(j12);
                }
                foVarN.a(i12, this.f17315s);
                fo.d dVar2 = this.f17315s;
                if (dVar2.f19059o == C.TIME_UNSET) {
                    b1.b(this.L ^ z11);
                    break;
                }
                int i13 = dVar2.f19060p;
                while (true) {
                    dVar = this.f17315s;
                    if (i13 <= dVar.f19061q) {
                        foVarN.a(i13, this.f17314r);
                        int iA = this.f17314r.a();
                        for (int iF = this.f17314r.f(); iF < iA; iF++) {
                            long jB = this.f17314r.b(iF);
                            if (jB == Long.MIN_VALUE) {
                                long j13 = this.f17314r.f19034d;
                                if (j13 != C.TIME_UNSET) {
                                    jB = j13;
                                    jE = jB + this.f17314r.e();
                                    if (jE >= 0) {
                                        jArr = this.W;
                                        if (i11 == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.W = Arrays.copyOf(jArr, length);
                                            this.f17293a0 = Arrays.copyOf(this.f17293a0, length);
                                        }
                                        this.W[i11] = t2.b(j12 + jE);
                                        this.f17293a0[i11] = this.f17314r.e(iF);
                                        i11++;
                                    }
                                }
                            } else {
                                jE = jB + this.f17314r.e();
                                if (jE >= 0) {
                                    jArr = this.W;
                                    if (i11 == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.W = Arrays.copyOf(jArr, length);
                                        this.f17293a0 = Arrays.copyOf(this.f17293a0, length);
                                    }
                                    this.W[i11] = t2.b(j12 + jE);
                                    this.f17293a0[i11] = this.f17314r.e(iF);
                                    i11++;
                                }
                            }
                        }
                        i13++;
                    }
                }
                j12 += dVar.f19059o;
                i12++;
                z11 = true;
            }
            j11 = j12;
        }
        long jB2 = t2.b(j11);
        TextView textView = this.f17309m;
        if (textView != null) {
            textView.setText(xp.a(this.f17312p, this.f17313q, jB2));
        }
        i iVar = this.f17311o;
        if (iVar != null) {
            iVar.setDuration(jB2);
            int length2 = this.f17295b0.length;
            int i14 = i11 + length2;
            long[] jArr2 = this.W;
            if (i14 > jArr2.length) {
                this.W = Arrays.copyOf(jArr2, i14);
                this.f17293a0 = Arrays.copyOf(this.f17293a0, i14);
            }
            System.arraycopy(this.f17295b0, 0, this.W, i11, length2);
            System.arraycopy(this.f17297c0, 0, this.f17293a0, i11, length2);
            this.f17311o.a(this.W, this.f17293a0, i14);
        }
        k();
    }

    public void a() {
        if (c()) {
            setVisibility(8);
            Iterator it = this.f17294b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).d(getVisibility());
            }
            removeCallbacks(this.f17316t);
            removeCallbacks(this.f17317u);
            this.V = C.TIME_UNSET;
        }
    }

    public void a(e eVar) {
        b1.a(eVar);
        this.f17294b.add(eVar);
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        qh qhVar = this.H;
        if (qhVar == null || !a(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (qhVar.o() == 4) {
                return true;
            }
            this.I.d(qhVar);
            return true;
        }
        if (keyCode == 89) {
            this.I.c(qhVar);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            c(qhVar);
            return true;
        }
        if (keyCode == 87) {
            this.I.a(qhVar);
            return true;
        }
        if (keyCode == 88) {
            this.I.e(qhVar);
            return true;
        }
        if (keyCode == 126) {
            b(qhVar);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        a(qhVar);
        return true;
    }

    public void b(e eVar) {
        this.f17294b.remove(eVar);
    }

    public boolean c() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f17317u);
        } else if (motionEvent.getAction() == 1) {
            b();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void g() {
        if (!c()) {
            setVisibility(0);
            Iterator it = this.f17294b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).d(getVisibility());
            }
            h();
            e();
            d();
        }
        b();
    }

    @Nullable
    public qh getPlayer() {
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
        View view = this.f17308l;
        return view != null && view.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J = true;
        long j11 = this.V;
        if (j11 != C.TIME_UNSET) {
            long jUptimeMillis = j11 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                a();
            } else {
                postDelayed(this.f17317u, jUptimeMillis);
            }
        } else if (c()) {
            b();
        }
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J = false;
        removeCallbacks(this.f17316t);
        removeCallbacks(this.f17317u);
    }

    @Deprecated
    public void setControlDispatcher(t4 t4Var) {
        if (this.I != t4Var) {
            this.I = t4Var;
            i();
        }
    }

    public void setPlayer(@Nullable qh qhVar) {
        b1.b(Looper.myLooper() == Looper.getMainLooper());
        b1.a(qhVar == null || qhVar.p() == Looper.getMainLooper());
        qh qhVar2 = this.H;
        if (qhVar2 == qhVar) {
            return;
        }
        if (qhVar2 != null) {
            qhVar2.a(this.f17292a);
        }
        this.H = qhVar;
        if (qhVar != null) {
            qhVar.b(this.f17292a);
        }
        h();
    }

    public void setProgressUpdateListener(@Nullable InterfaceC0173d interfaceC0173d) {
    }

    public void setRepeatToggleModes(int i11) {
        this.P = i11;
        qh qhVar = this.H;
        if (qhVar != null) {
            int iM = qhVar.m();
            if (i11 == 0 && iM != 0) {
                this.I.a(this.H, 0);
            } else if (i11 == 1 && iM == 2) {
                this.I.a(this.H, 1);
            } else if (i11 == 2 && iM == 1) {
                this.I.a(this.H, 2);
            }
        }
        l();
    }

    public void setShowFastForwardButton(boolean z11) {
        this.R = z11;
        i();
    }

    public void setShowMultiWindowTimeBar(boolean z11) {
        this.K = z11;
        n();
    }

    public void setShowNextButton(boolean z11) {
        this.T = z11;
        i();
    }

    public void setShowPreviousButton(boolean z11) {
        this.S = z11;
        i();
    }

    public void setShowRewindButton(boolean z11) {
        this.Q = z11;
        i();
    }

    public void setShowShuffleButton(boolean z11) {
        this.U = z11;
        m();
    }

    public void setShowTimeoutMs(int i11) {
        this.N = i11;
        if (c()) {
            b();
        }
    }

    public void setShowVrButton(boolean z11) {
        View view = this.f17308l;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i11) {
        this.O = xp.a(i11, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f17308l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            a(getShowVrButton(), onClickListener != null, this.f17308l);
        }
    }
}
