package androidx.media3.ui;

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
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayerControlView f12024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final View f12025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ViewGroup f12026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final ViewGroup f12027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final ViewGroup f12028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final ViewGroup f12029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final ViewGroup f12030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final ViewGroup f12031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final ViewGroup f12032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final View f12033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final View f12034k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimatorSet f12035l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AnimatorSet f12036m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AnimatorSet f12037n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnimatorSet f12038o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AnimatorSet f12039p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ValueAnimator f12040q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ValueAnimator f12041r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f12042s = new Runnable() { // from class: androidx.media3.ui.s
        @Override // java.lang.Runnable
        public final void run() {
            this.f12124a.d0();
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f12043t = new Runnable() { // from class: androidx.media3.ui.y
        @Override // java.lang.Runnable
        public final void run() {
            this.f12130a.D();
        }
    };

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f12044u = new Runnable() { // from class: androidx.media3.ui.z
        @Override // java.lang.Runnable
        public final void run() {
            this.f12131a.H();
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f12045v = new Runnable() { // from class: androidx.media3.ui.a0
        @Override // java.lang.Runnable
        public final void run() {
            this.f12010a.G();
        }
    };

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f12046w = new Runnable() { // from class: androidx.media3.ui.b0
        @Override // java.lang.Runnable
        public final void run() {
            this.f12018a.E();
        }
    };

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View.OnLayoutChangeListener f12047x = new View.OnLayoutChangeListener() { // from class: androidx.media3.ui.c0
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f12019a.S(view, i11, i12, i13, i14, i15, i16, i17, i18);
        }
    };
    public boolean C = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12049z = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<View> f12048y = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f0.this.f12025b != null) {
                f0.this.f12025b.setVisibility(4);
            }
            if (f0.this.f12026c != null) {
                f0.this.f12026c.setVisibility(4);
            }
            if (f0.this.f12028e != null) {
                f0.this.f12028e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(f0.this.f12033j instanceof DefaultTimeBar) || f0.this.A) {
                return;
            }
            ((DefaultTimeBar) f0.this.f12033j).hideScrubber(250L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (f0.this.f12025b != null) {
                f0.this.f12025b.setVisibility(0);
            }
            if (f0.this.f12026c != null) {
                f0.this.f12026c.setVisibility(0);
            }
            if (f0.this.f12028e != null) {
                f0.this.f12028e.setVisibility(f0.this.A ? 0 : 4);
            }
            if (!(f0.this.f12033j instanceof DefaultTimeBar) || f0.this.A) {
                return;
            }
            ((DefaultTimeBar) f0.this.f12033j).showScrubber(250L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlView f12052a;

        public c(PlayerControlView playerControlView) {
            this.f12052a = playerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.a0(1);
            if (f0.this.B) {
                this.f12052a.post(f0.this.f12042s);
                f0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlView f12054a;

        public d(PlayerControlView playerControlView) {
            this.f12054a = playerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.a0(2);
            if (f0.this.B) {
                this.f12054a.post(f0.this.f12042s);
                f0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerControlView f12056a;

        public e(PlayerControlView playerControlView) {
            this.f12056a = playerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.a0(2);
            if (f0.this.B) {
                this.f12056a.post(f0.this.f12042s);
                f0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.a0(3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.a0(4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f0.this.a0(4);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f0.this.f12029f != null) {
                f0.this.f12029f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (f0.this.f12031h != null) {
                f0.this.f12031h.setVisibility(0);
                f0.this.f12031h.setTranslationX(f0.this.f12031h.getWidth());
                f0.this.f12031h.scrollTo(f0.this.f12031h.getWidth(), 0);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f0.this.f12031h != null) {
                f0.this.f12031h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (f0.this.f12029f != null) {
                f0.this.f12029f.setVisibility(0);
            }
        }
    }

    public f0(PlayerControlView playerControlView) {
        this.f12024a = playerControlView;
        this.f12025b = playerControlView.findViewById(R$id.exo_controls_background);
        this.f12026c = (ViewGroup) playerControlView.findViewById(R$id.exo_center_controls);
        this.f12028e = (ViewGroup) playerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) playerControlView.findViewById(R$id.exo_bottom_bar);
        this.f12027d = viewGroup;
        this.f12032i = (ViewGroup) playerControlView.findViewById(R$id.exo_time);
        View viewFindViewById = playerControlView.findViewById(R$id.exo_progress);
        this.f12033j = viewFindViewById;
        this.f12029f = (ViewGroup) playerControlView.findViewById(R$id.exo_basic_controls);
        this.f12030g = (ViewGroup) playerControlView.findViewById(R$id.exo_extra_controls);
        this.f12031h = (ViewGroup) playerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View viewFindViewById2 = playerControlView.findViewById(R$id.exo_overflow_show);
        this.f12034k = viewFindViewById2;
        View viewFindViewById3 = playerControlView.findViewById(R$id.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12020a.U(view);
                }
            });
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f12020a.U(view);
                }
            });
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.e0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f12022a.K(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.t
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f12125a.L(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addListener(new b());
        Resources resources = playerControlView.getResources();
        float dimension = resources.getDimension(R$dimen.exo_styled_bottom_bar_height) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R$dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f12035l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(playerControlView));
        animatorSet.play(valueAnimatorOfFloat).with(O(0.0f, dimension, viewFindViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f12036m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(playerControlView));
        animatorSet2.play(O(dimension, dimension2, viewFindViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f12037n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(playerControlView));
        animatorSet3.play(valueAnimatorOfFloat).with(O(0.0f, dimension2, viewFindViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f12038o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(valueAnimatorOfFloat2).with(O(dimension, 0.0f, viewFindViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f12039p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(valueAnimatorOfFloat2).with(O(dimension2, 0.0f, viewFindViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f12040q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.w
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f12128a.M(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.addListener(new h());
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f12041r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f12129a.N(valueAnimator);
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
        return view != null && this.f12048y.contains(view);
    }

    public void C() {
        int i11 = this.f12049z;
        if (i11 == 3 || i11 == 2) {
            return;
        }
        W();
        if (!this.C) {
            E();
        } else if (this.f12049z == 1) {
            H();
        } else {
            D();
        }
    }

    public final void D() {
        this.f12037n.start();
    }

    public final void E() {
        a0(2);
    }

    public void F() {
        int i11 = this.f12049z;
        if (i11 == 3 || i11 == 2) {
            return;
        }
        W();
        E();
    }

    public final void G() {
        this.f12035l.start();
        V(this.f12044u, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    public final void H() {
        this.f12036m.start();
    }

    public boolean I() {
        return this.C;
    }

    public boolean J() {
        return this.f12049z == 0 && this.f12024a.isVisible();
    }

    public final /* synthetic */ void K(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f12025b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f12026c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f12028e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(fFloatValue);
        }
    }

    public final /* synthetic */ void L(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f12025b;
        if (view != null) {
            view.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup = this.f12026c;
        if (viewGroup != null) {
            viewGroup.setAlpha(fFloatValue);
        }
        ViewGroup viewGroup2 = this.f12028e;
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
        this.f12024a.addOnLayoutChangeListener(this.f12047x);
    }

    public void Q() {
        this.f12024a.removeOnLayoutChangeListener(this.f12047x);
    }

    public void R(boolean z11, int i11, int i12, int i13, int i14) {
        View view = this.f12025b;
        if (view != null) {
            view.layout(0, 0, i13 - i11, i14 - i12);
        }
    }

    public final void S(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean zF0 = f0();
        if (this.A != zF0) {
            this.A = zF0;
            view.post(new Runnable() { // from class: androidx.media3.ui.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f12126a.e0();
                }
            });
        }
        boolean z11 = i13 - i11 != i17 - i15;
        if (this.A || !z11) {
            return;
        }
        view.post(new Runnable() { // from class: androidx.media3.ui.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f12127a.T();
            }
        });
    }

    public final void T() {
        int i11;
        if (this.f12029f == null || this.f12030g == null) {
            return;
        }
        int width = (this.f12024a.getWidth() - this.f12024a.getPaddingLeft()) - this.f12024a.getPaddingRight();
        while (true) {
            if (this.f12030g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f12030g.getChildCount() - 2;
            View childAt = this.f12030g.getChildAt(childCount);
            this.f12030g.removeViewAt(childCount);
            this.f12029f.addView(childAt, 0);
        }
        View view = this.f12034k;
        if (view != null) {
            view.setVisibility(8);
        }
        int iB = B(this.f12032i);
        int childCount2 = this.f12029f.getChildCount() - 1;
        for (int i12 = 0; i12 < childCount2; i12++) {
            iB += B(this.f12029f.getChildAt(i12));
        }
        if (iB <= width) {
            ViewGroup viewGroup = this.f12031h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f12041r.isStarted()) {
                return;
            }
            this.f12040q.cancel();
            this.f12041r.start();
            return;
        }
        View view2 = this.f12034k;
        if (view2 != null) {
            view2.setVisibility(0);
            iB += B(this.f12034k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = this.f12029f.getChildAt(i13);
            iB -= B(childAt2);
            arrayList.add(childAt2);
            if (iB <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f12029f.removeViews(0, arrayList.size());
        for (i11 = 0; i11 < arrayList.size(); i11++) {
            this.f12030g.addView((View) arrayList.get(i11), this.f12030g.getChildCount() - 1);
        }
    }

    public final void U(View view) {
        X();
        if (view.getId() == R$id.exo_overflow_show) {
            this.f12040q.start();
        } else if (view.getId() == R$id.exo_overflow_hide) {
            this.f12041r.start();
        }
    }

    public final void V(Runnable runnable, long j11) {
        if (j11 >= 0) {
            this.f12024a.postDelayed(runnable, j11);
        }
    }

    public void W() {
        this.f12024a.removeCallbacks(this.f12046w);
        this.f12024a.removeCallbacks(this.f12043t);
        this.f12024a.removeCallbacks(this.f12045v);
        this.f12024a.removeCallbacks(this.f12044u);
    }

    public void X() {
        if (this.f12049z == 3) {
            return;
        }
        W();
        int showTimeoutMs = this.f12024a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                V(this.f12046w, showTimeoutMs);
            } else if (this.f12049z == 1) {
                V(this.f12044u, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            } else {
                V(this.f12045v, showTimeoutMs);
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
            this.f12048y.remove(view);
            return;
        }
        if (this.A && b0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f12048y.add(view);
    }

    public final void a0(int i11) {
        int i12 = this.f12049z;
        this.f12049z = i11;
        if (i11 == 2) {
            this.f12024a.setVisibility(8);
        } else if (i12 == 2) {
            this.f12024a.setVisibility(0);
        }
        if (i12 != i11) {
            this.f12024a.Z();
        }
    }

    public final boolean b0(View view) {
        int id2 = view.getId();
        return id2 == R$id.exo_bottom_bar || id2 == R$id.exo_prev || id2 == R$id.exo_next || id2 == R$id.exo_rew || id2 == R$id.exo_rew_with_amount || id2 == R$id.exo_ffwd || id2 == R$id.exo_ffwd_with_amount;
    }

    public void c0() {
        if (!this.f12024a.isVisible()) {
            this.f12024a.setVisibility(0);
            this.f12024a.g0();
            this.f12024a.d0();
        }
        d0();
    }

    public final void d0() {
        if (!this.C) {
            a0(0);
            X();
            return;
        }
        int i11 = this.f12049z;
        if (i11 == 1) {
            this.f12038o.start();
        } else if (i11 == 2) {
            this.f12039p.start();
        } else if (i11 == 3) {
            this.B = true;
        } else if (i11 == 4) {
            return;
        }
        X();
    }

    public final void e0() {
        ViewGroup viewGroup = this.f12028e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        if (this.f12033j != null) {
            int dimensionPixelSize = this.f12024a.getResources().getDimensionPixelSize(R$dimen.exo_styled_progress_margin_bottom);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12033j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f12033j.setLayoutParams(marginLayoutParams);
            }
            View view = this.f12033j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i11 = this.f12049z;
                    if (i11 == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i11 != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View view2 : this.f12048y) {
            view2.setVisibility((this.A && b0(view2)) ? 4 : 0);
        }
    }

    public final boolean f0() {
        int width = (this.f12024a.getWidth() - this.f12024a.getPaddingLeft()) - this.f12024a.getPaddingRight();
        int height = (this.f12024a.getHeight() - this.f12024a.getPaddingBottom()) - this.f12024a.getPaddingTop();
        int iB = B(this.f12026c);
        ViewGroup viewGroup = this.f12026c;
        int paddingLeft = iB - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f12026c.getPaddingRight() : 0);
        int iZ = z(this.f12026c);
        ViewGroup viewGroup2 = this.f12026c;
        return width <= Math.max(paddingLeft, B(this.f12032i) + B(this.f12034k)) || height <= (iZ - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f12026c.getPaddingBottom() : 0)) + (z(this.f12027d) * 2);
    }

    public final void y(float f11) {
        ViewGroup viewGroup = this.f12031h;
        if (viewGroup != null) {
            this.f12031h.setTranslationX((int) (viewGroup.getWidth() * (1.0f - f11)));
        }
        ViewGroup viewGroup2 = this.f12032i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f11);
        }
        ViewGroup viewGroup3 = this.f12029f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f11);
        }
    }
}
