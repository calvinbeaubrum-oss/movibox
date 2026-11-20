package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StyledPlayerControlView f35111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final View f35112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ViewGroup f35113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final ViewGroup f35114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final ViewGroup f35115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final ViewGroup f35116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final ViewGroup f35117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final ViewGroup f35118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final ViewGroup f35119i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final View f35120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final View f35121k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimatorSet f35122l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AnimatorSet f35123m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AnimatorSet f35124n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnimatorSet f35125o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AnimatorSet f35126p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ValueAnimator f35127q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ValueAnimator f35128r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f35129s = new Runnable() { // from class: com.google.android.exoplayer2.ui.v
        @Override // java.lang.Runnable
        public final void run() {
            this.f35208a.d0();
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f35130t = new Runnable() { // from class: com.google.android.exoplayer2.ui.b0
        @Override // java.lang.Runnable
        public final void run() {
            this.f35093a.D();
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f35131u = new Runnable() { // from class: com.google.android.exoplayer2.ui.c0
        @Override // java.lang.Runnable
        public final void run() {
            this.f35101a.H();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f35132v = new Runnable() { // from class: com.google.android.exoplayer2.ui.d0
        @Override // java.lang.Runnable
        public final void run() {
            this.f35102a.G();
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f35133w = new Runnable() { // from class: com.google.android.exoplayer2.ui.e0
        @Override // java.lang.Runnable
        public final void run() {
            this.f35104a.E();
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View.OnLayoutChangeListener f35134x = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.f0
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f35106a.S(view, i11, i12, i13, i14, i15, i16, i17, i18);
        }
    };
    public boolean C = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f35136z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<View> f35135y = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i0.this.f35112b != null) {
                i0.this.f35112b.setVisibility(4);
            }
            if (i0.this.f35113c != null) {
                i0.this.f35113c.setVisibility(4);
            }
            if (i0.this.f35115e != null) {
                i0.this.f35115e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(i0.this.f35120j instanceof DefaultTimeBar) || i0.this.A) {
                return;
            }
            ((DefaultTimeBar) i0.this.f35120j).hideScrubber(250L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (i0.this.f35112b != null) {
                i0.this.f35112b.setVisibility(0);
            }
            if (i0.this.f35113c != null) {
                i0.this.f35113c.setVisibility(0);
            }
            if (i0.this.f35115e != null) {
                i0.this.f35115e.setVisibility(i0.this.A ? 0 : 4);
            }
            if (!(i0.this.f35120j instanceof DefaultTimeBar) || i0.this.A) {
                return;
            }
            ((DefaultTimeBar) i0.this.f35120j).showScrubber(250L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f35139a;

        public c(StyledPlayerControlView styledPlayerControlView) {
            this.f35139a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(1);
            if (i0.this.B) {
                this.f35139a.post(i0.this.f35129s);
                i0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f35141a;

        public d(StyledPlayerControlView styledPlayerControlView) {
            this.f35141a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(2);
            if (i0.this.B) {
                this.f35141a.post(i0.this.f35129s);
                i0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StyledPlayerControlView f35143a;

        public e(StyledPlayerControlView styledPlayerControlView) {
            this.f35143a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(2);
            if (i0.this.B) {
                this.f35143a.post(i0.this.f35129s);
                i0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i0.this.f35116f != null) {
                i0.this.f35116f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (i0.this.f35118h != null) {
                i0.this.f35118h.setVisibility(0);
                i0.this.f35118h.setTranslationX(i0.this.f35118h.getWidth());
                i0.this.f35118h.scrollTo(i0.this.f35118h.getWidth(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i0.this.f35118h != null) {
                i0.this.f35118h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (i0.this.f35116f != null) {
                i0.this.f35116f.setVisibility(0);
            }
        }
    }

    public i0(StyledPlayerControlView styledPlayerControlView) {
        this.f35111a = styledPlayerControlView;
        this.f35112b = styledPlayerControlView.findViewById(R$id.exo_controls_background);
        this.f35113c = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_center_controls);
        this.f35115e = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_bottom_bar);
        this.f35114d = viewGroup;
        this.f35119i = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_time);
        View viewFindViewById = styledPlayerControlView.findViewById(R$id.exo_progress);
        this.f35120j = viewFindViewById;
        this.f35116f = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_basic_controls);
        this.f35117g = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls);
        this.f35118h = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View viewFindViewById2 = styledPlayerControlView.findViewById(R$id.exo_overflow_show);
        this.f35121k = viewFindViewById2;
        View viewFindViewById3 = styledPlayerControlView.findViewById(R$id.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f35108a.U(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f35108a.U(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.h0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f35109a.K(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.w
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f35209a.L(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        float dimension = resources.getDimension(R$dimen.exo_styled_bottom_bar_height) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R$dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f35122l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(valueAnimatorOfFloat).with(O(0.0f, dimension, viewFindViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f35123m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(O(dimension, dimension2, viewFindViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f35124n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(styledPlayerControlView));
        animatorSet3.play(valueAnimatorOfFloat).with(O(0.0f, dimension2, viewFindViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f35125o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(O(dimension, 0.0f, viewFindViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f35126p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(O(dimension2, 0.0f, viewFindViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f35127q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f35212a.M(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f35128r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.a0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f35086a.N(valueAnimator);
            }
        });
        valueAnimatorOfFloat4.addListener(new i());
    }

    public static int B(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    public static ObjectAnimator O(float f11, float f12, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f11, f12);
    }

    public static int z(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@Nullable View view) {
        return view != null && this.f35135y.contains(view);
    }

    public void C() {
        int i11 = this.f35136z;
        if (i11 == 3 || i11 == 2) {
            return;
        }
        W();
        if (!this.C) {
            E();
        } else if (this.f35136z == 1) {
            H();
        } else {
            D();
        }
    }

    public final void D() {
        this.f35124n.start();
    }

    public final void E() {
        a0(2);
    }

    public void F() {
        int i11 = this.f35136z;
        if (i11 == 3 || i11 == 2) {
            return;
        }
        W();
        E();
    }

    public final void G() {
        this.f35122l.start();
        V(this.f35131u, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    public final void H() {
        this.f35123m.start();
    }

    public boolean I() {
        return this.C;
    }

    public boolean J() {
        return this.f35136z == 0 && this.f35111a.isVisible();
    }

    public final /* synthetic */ void K(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f35112b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f35113c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f35115e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    public final /* synthetic */ void L(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f35112b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f35113c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f35115e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    public final /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final /* synthetic */ void N(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void P() {
        this.f35111a.addOnLayoutChangeListener(this.f35134x);
    }

    public void Q() {
        this.f35111a.removeOnLayoutChangeListener(this.f35134x);
    }

    public void R(boolean z11, int i11, int i12, int i13, int i14) {
        View view = this.f35112b;
        if (view != null) {
            view.layout(0, 0, i13 - i11, i14 - i12);
        }
    }

    public final void S(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean zF0 = f0();
        if (this.A != zF0) {
            this.A = zF0;
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.f35210a.e0();
                }
            });
        }
        boolean z11 = i13 - i11 != i17 - i15;
        if (this.A || !z11) {
            return;
        }
        view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f35211a.T();
            }
        });
    }

    public final void T() {
        int i11;
        if (this.f35116f == null || this.f35117g == null) {
            return;
        }
        int width = (this.f35111a.getWidth() - this.f35111a.getPaddingLeft()) - this.f35111a.getPaddingRight();
        while (true) {
            if (this.f35117g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f35117g.getChildCount() - 2;
            View childAt = this.f35117g.getChildAt(childCount);
            this.f35117g.removeViewAt(childCount);
            this.f35116f.addView(childAt, 0);
        }
        View view = this.f35121k;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.f35119i);
        int childCount2 = this.f35116f.getChildCount() - 1;
        for (int i12 = 0; i12 < childCount2; i12++) {
            iB += B(this.f35116f.getChildAt(i12));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.f35118h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f35128r.isStarted()) {
                return;
            }
            this.f35127q.cancel();
            this.f35128r.start();
            return;
        }
        View view2 = this.f35121k;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.f35121k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = this.f35116f.getChildAt(i13);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f35116f.removeViews(0, arrayList.size());
        for (i11 = 0; i11 < arrayList.size(); i11++) {
            this.f35117g.addView((View) arrayList.get(i11), this.f35117g.getChildCount() - 1);
        }
    }

    public final void U(View view) {
        X();
        if (view.getId() == R$id.exo_overflow_show) {
            this.f35127q.start();
        } else if (view.getId() == R$id.exo_overflow_hide) {
            this.f35128r.start();
        }
    }

    public final void V(Runnable runnable, long j11) {
        if (j11 >= 0) {
            this.f35111a.postDelayed(runnable, j11);
        }
    }

    public void W() {
        this.f35111a.removeCallbacks(this.f35133w);
        this.f35111a.removeCallbacks(this.f35130t);
        this.f35111a.removeCallbacks(this.f35132v);
        this.f35111a.removeCallbacks(this.f35131u);
    }

    public void X() {
        if (this.f35136z == 3) {
            return;
        }
        W();
        int showTimeoutMs = this.f35111a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                V(this.f35133w, showTimeoutMs);
            } else if (this.f35136z == 1) {
                V(this.f35131u, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            } else {
                V(this.f35132v, showTimeoutMs);
            }
        }
    }

    public void Y(boolean z11) {
        this.C = z11;
    }

    public void Z(@Nullable View view, boolean z11) {
        if (view == null) {
            return;
        }
        if (!z11) {
            view.setVisibility(8);
            this.f35135y.remove(view);
            return;
        }
        if (this.A && b0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f35135y.add(view);
    }

    public final void a0(int i11) {
        int i12 = this.f35136z;
        this.f35136z = i11;
        if (i11 == 2) {
            this.f35111a.setVisibility(8);
        } else if (i12 == 2) {
            this.f35111a.setVisibility(0);
        }
        if (i12 != i11) {
            this.f35111a.c0();
        }
    }

    public final boolean b0(View view) {
        int id2 = view.getId();
        return id2 == R$id.exo_bottom_bar || id2 == R$id.exo_prev || id2 == R$id.exo_next || id2 == R$id.exo_rew || id2 == R$id.exo_rew_with_amount || id2 == R$id.exo_ffwd || id2 == R$id.exo_ffwd_with_amount;
    }

    public void c0() {
        if (!this.f35111a.isVisible()) {
            this.f35111a.setVisibility(0);
            this.f35111a.k0();
            this.f35111a.g0();
        }
        d0();
    }

    public final void d0() {
        if (!this.C) {
            a0(0);
            X();
            return;
        }
        int i11 = this.f35136z;
        if (i11 == 1) {
            this.f35125o.start();
        } else if (i11 == 2) {
            this.f35126p.start();
        } else if (i11 == 3) {
            this.B = true;
        } else if (i11 == 4) {
            return;
        }
        X();
    }

    public final void e0() {
        ViewGroup viewGroup = this.f35115e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        if (this.f35120j != null) {
            int dimensionPixelSize = this.f35111a.getResources().getDimensionPixelSize(R$dimen.exo_styled_progress_margin_bottom);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35120j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f35120j.setLayoutParams(marginLayoutParams);
            }
            View view = this.f35120j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i11 = this.f35136z;
                    if (i11 == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i11 != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View view2 : this.f35135y) {
            view2.setVisibility((this.A && b0(view2)) ? 4 : 0);
        }
    }

    public final boolean f0() {
        int width = (this.f35111a.getWidth() - this.f35111a.getPaddingLeft()) - this.f35111a.getPaddingRight();
        int height = (this.f35111a.getHeight() - this.f35111a.getPaddingBottom()) - this.f35111a.getPaddingTop();
        int iB = B(this.f35113c);
        ViewGroup viewGroup = this.f35113c;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f35113c.getPaddingRight() : 0);
        int iZ = z(this.f35113c);
        ViewGroup viewGroup2 = this.f35113c;
        return width <= Math.max(paddingLeft, B(this.f35119i) + B(this.f35121k)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f35113c.getPaddingBottom() : 0)) + (z(this.f35114d) * 2);
    }

    public final void y(float f11) {
        ViewGroup viewGroup = this.f35118h;
        if (viewGroup != null) {
            this.f35118h.setTranslationX((int) (viewGroup.getWidth() * (1.0f - f11)));
        }
        ViewGroup viewGroup2 = this.f35119i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f11);
        }
        ViewGroup viewGroup3 = this.f35116f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f11);
        }
    }
}
